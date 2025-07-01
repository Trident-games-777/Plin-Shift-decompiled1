package kotlin.uuid;

import java.nio.BufferOverflowException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\b\u0010\u0000\u001a\u00020\u0001H\u0001\u001a\f\u0010\u0002\u001a\u00020\u0001*\u00020\u0003H\u0007\u001a\u0014\u0010\u0002\u001a\u00020\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0007\u001a\u001c\u0010\u0006\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0001H\u0007\u001a\u0014\u0010\u0006\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0001H\u0007\u001a\r\u0010\b\u001a\u00020\t*\u00020\tH\b\u001a\r\u0010\n\u001a\u00020\u000b*\u00020\u0001H\b\u001a\r\u0010\f\u001a\u00020\u0001*\u00020\u000bH\b¨\u0006\r"}, d2 = {"secureRandomUuid", "Lkotlin/uuid/Uuid;", "getUuid", "Ljava/nio/ByteBuffer;", "index", "", "putUuid", "uuid", "reverseBytes", "", "toJavaUuid", "Ljava/util/UUID;", "toKotlinUuid", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/uuid/UuidKt")
/* compiled from: UuidJVM.kt */
class UuidKt__UuidJVMKt {
    public static final Uuid secureRandomUuid() {
        byte[] bArr = new byte[16];
        SecureRandomHolder.INSTANCE.getInstance().nextBytes(bArr);
        return UuidKt.uuidFromRandomBytes(bArr);
    }

    public static final Uuid toKotlinUuid(UUID uuid) {
        Intrinsics.checkNotNullParameter(uuid, "<this>");
        return Uuid.Companion.fromLongs(uuid.getMostSignificantBits(), uuid.getLeastSignificantBits());
    }

    public static final UUID toJavaUuid(Uuid uuid) {
        Intrinsics.checkNotNullParameter(uuid, "<this>");
        return new UUID(uuid.getMostSignificantBits(), uuid.getLeastSignificantBits());
    }

    public static final Uuid getUuid(ByteBuffer byteBuffer) {
        Intrinsics.checkNotNullParameter(byteBuffer, "<this>");
        if (byteBuffer.position() + 15 < byteBuffer.limit()) {
            long j = byteBuffer.getLong();
            long j2 = byteBuffer.getLong();
            if (Intrinsics.areEqual((Object) byteBuffer.order(), (Object) ByteOrder.LITTLE_ENDIAN)) {
                j = Long.reverseBytes(j);
                j2 = Long.reverseBytes(j2);
            }
            return Uuid.Companion.fromLongs(j, j2);
        }
        throw new BufferUnderflowException();
    }

    public static final Uuid getUuid(ByteBuffer byteBuffer, int i) {
        Intrinsics.checkNotNullParameter(byteBuffer, "<this>");
        if (i < 0) {
            throw new IndexOutOfBoundsException("Negative index: " + i);
        } else if (i + 15 < byteBuffer.limit()) {
            long j = byteBuffer.getLong(i);
            long j2 = byteBuffer.getLong(i + 8);
            if (Intrinsics.areEqual((Object) byteBuffer.order(), (Object) ByteOrder.LITTLE_ENDIAN)) {
                j = Long.reverseBytes(j);
                j2 = Long.reverseBytes(j2);
            }
            return Uuid.Companion.fromLongs(j, j2);
        } else {
            throw new IndexOutOfBoundsException("Not enough bytes to read a uuid at index: " + i + ", with limit: " + byteBuffer.limit() + ' ');
        }
    }

    public static final ByteBuffer putUuid(ByteBuffer byteBuffer, Uuid uuid) {
        ByteBuffer byteBuffer2;
        Intrinsics.checkNotNullParameter(byteBuffer, "<this>");
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        long mostSignificantBits = uuid.getMostSignificantBits();
        long leastSignificantBits = uuid.getLeastSignificantBits();
        if (byteBuffer.position() + 15 < byteBuffer.limit()) {
            if (Intrinsics.areEqual((Object) byteBuffer.order(), (Object) ByteOrder.BIG_ENDIAN)) {
                byteBuffer.putLong(mostSignificantBits);
                byteBuffer2 = byteBuffer.putLong(leastSignificantBits);
            } else {
                byteBuffer.putLong(Long.reverseBytes(mostSignificantBits));
                byteBuffer2 = byteBuffer.putLong(Long.reverseBytes(leastSignificantBits));
            }
            Intrinsics.checkNotNullExpressionValue(byteBuffer2, "toLongs(...)");
            return byteBuffer2;
        }
        throw new BufferOverflowException();
    }

    public static final ByteBuffer putUuid(ByteBuffer byteBuffer, int i, Uuid uuid) {
        ByteBuffer byteBuffer2;
        Intrinsics.checkNotNullParameter(byteBuffer, "<this>");
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        long mostSignificantBits = uuid.getMostSignificantBits();
        long leastSignificantBits = uuid.getLeastSignificantBits();
        if (i < 0) {
            throw new IndexOutOfBoundsException("Negative index: " + i);
        } else if (i + 15 < byteBuffer.limit()) {
            if (Intrinsics.areEqual((Object) byteBuffer.order(), (Object) ByteOrder.BIG_ENDIAN)) {
                byteBuffer.putLong(i, mostSignificantBits);
                byteBuffer2 = byteBuffer.putLong(i + 8, leastSignificantBits);
            } else {
                byteBuffer.putLong(i, Long.reverseBytes(mostSignificantBits));
                byteBuffer2 = byteBuffer.putLong(i + 8, Long.reverseBytes(leastSignificantBits));
            }
            Intrinsics.checkNotNullExpressionValue(byteBuffer2, "toLongs(...)");
            return byteBuffer2;
        } else {
            throw new IndexOutOfBoundsException("Not enough capacity to write a uuid at index: " + i + ", with limit: " + byteBuffer.limit() + ' ');
        }
    }

    public static final long reverseBytes(long j) {
        return Long.reverseBytes(j);
    }
}
