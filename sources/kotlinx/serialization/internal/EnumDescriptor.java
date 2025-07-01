package kotlinx.serialization.internal;

import java.util.Iterator;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorKt;
import kotlinx.serialization.descriptors.SerialKind;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0002J\u0010\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0005H\u0016J\b\u0010\u0018\u001a\u00020\u0005H\u0016J\b\u0010\u0019\u001a\u00020\u0003H\u0016R!\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8BX\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001a"}, d2 = {"Lkotlinx/serialization/internal/EnumDescriptor;", "Lkotlinx/serialization/internal/PluginGeneratedSerialDescriptor;", "name", "", "elementsCount", "", "(Ljava/lang/String;I)V", "elementDescriptors", "", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getElementDescriptors", "()[Lkotlinx/serialization/descriptors/SerialDescriptor;", "elementDescriptors$delegate", "Lkotlin/Lazy;", "kind", "Lkotlinx/serialization/descriptors/SerialKind;", "getKind", "()Lkotlinx/serialization/descriptors/SerialKind;", "equals", "", "other", "", "getElementDescriptor", "index", "hashCode", "toString", "kotlinx-serialization-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: Enums.kt */
public final class EnumDescriptor extends PluginGeneratedSerialDescriptor {
    private final Lazy elementDescriptors$delegate;
    private final SerialKind kind = SerialKind.ENUM.INSTANCE;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public EnumDescriptor(java.lang.String r8, int r9) {
        /*
            r7 = this;
            java.lang.String r0 = "name"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            r5 = 2
            r6 = 0
            r3 = 0
            r1 = r7
            r2 = r8
            r4 = r9
            r1.<init>(r2, r3, r4, r5, r6)
            kotlinx.serialization.descriptors.SerialKind$ENUM r8 = kotlinx.serialization.descriptors.SerialKind.ENUM.INSTANCE
            kotlinx.serialization.descriptors.SerialKind r8 = (kotlinx.serialization.descriptors.SerialKind) r8
            r1.kind = r8
            kotlinx.serialization.internal.EnumDescriptor$elementDescriptors$2 r8 = new kotlinx.serialization.internal.EnumDescriptor$elementDescriptors$2
            r8.<init>(r4, r2, r7)
            kotlin.jvm.functions.Function0 r8 = (kotlin.jvm.functions.Function0) r8
            kotlin.Lazy r8 = kotlin.LazyKt.lazy(r8)
            r1.elementDescriptors$delegate = r8
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.serialization.internal.EnumDescriptor.<init>(java.lang.String, int):void");
    }

    public SerialKind getKind() {
        return this.kind;
    }

    private final SerialDescriptor[] getElementDescriptors() {
        return (SerialDescriptor[]) this.elementDescriptors$delegate.getValue();
    }

    public SerialDescriptor getElementDescriptor(int i) {
        return getElementDescriptors()[i];
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof SerialDescriptor)) {
            return false;
        }
        SerialDescriptor serialDescriptor = (SerialDescriptor) obj;
        return serialDescriptor.getKind() == SerialKind.ENUM.INSTANCE && Intrinsics.areEqual((Object) getSerialName(), (Object) serialDescriptor.getSerialName()) && Intrinsics.areEqual((Object) Platform_commonKt.cachedSerialNames(this), (Object) Platform_commonKt.cachedSerialNames(serialDescriptor));
    }

    public String toString() {
        return CollectionsKt.joinToString$default(SerialDescriptorKt.getElementNames(this), ", ", getSerialName() + '(', ")", 0, (CharSequence) null, (Function1) null, 56, (Object) null);
    }

    public int hashCode() {
        int hashCode = getSerialName().hashCode();
        Iterator<String> it = SerialDescriptorKt.getElementNames(this).iterator();
        int i = 1;
        while (it.hasNext()) {
            int i2 = i * 31;
            String next = it.next();
            i = i2 + (next != null ? next.hashCode() : 0);
        }
        return (hashCode * 31) + i;
    }
}
