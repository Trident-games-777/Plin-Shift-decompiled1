package coil3.decode;

import coil3.util.UtilsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.BufferedSource;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bæ\u0001\u0018\u0000 \b2\u00020\u0001:\u0001\bJ\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\tÀ\u0006\u0001"}, d2 = {"Lcoil3/decode/ExifOrientationStrategy;", "", "supports", "", "mimeType", "", "source", "Lokio/BufferedSource;", "Companion", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: ExifOrientationStrategy.kt */
public interface ExifOrientationStrategy {
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final ExifOrientationStrategy IGNORE = new ExifOrientationStrategy$$ExternalSyntheticLambda0();
    public static final ExifOrientationStrategy RESPECT_ALL = new ExifOrientationStrategy$$ExternalSyntheticLambda2();
    public static final ExifOrientationStrategy RESPECT_PERFORMANCE = new ExifOrientationStrategy$$ExternalSyntheticLambda1();

    /* access modifiers changed from: private */
    static boolean IGNORE$lambda$0(String str, BufferedSource bufferedSource) {
        return false;
    }

    /* access modifiers changed from: private */
    static boolean RESPECT_ALL$lambda$2(String str, BufferedSource bufferedSource) {
        return true;
    }

    boolean supports(String str, BufferedSource bufferedSource);

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0001R\u0013\u0010\u0006\u001a\u00020\u00058\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0001R\u0013\u0010\u0007\u001a\u00020\u00058\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0001¨\u0006\b"}, d2 = {"Lcoil3/decode/ExifOrientationStrategy$Companion;", "", "<init>", "()V", "IGNORE", "Lcoil3/decode/ExifOrientationStrategy;", "RESPECT_PERFORMANCE", "RESPECT_ALL", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* compiled from: ExifOrientationStrategy.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }
    }

    /* access modifiers changed from: private */
    static boolean RESPECT_PERFORMANCE$lambda$1(String str, BufferedSource bufferedSource) {
        if (str != null) {
            return Intrinsics.areEqual((Object) str, (Object) UtilsKt.MIME_TYPE_JPEG) || Intrinsics.areEqual((Object) str, (Object) UtilsKt.MIME_TYPE_WEBP) || Intrinsics.areEqual((Object) str, (Object) UtilsKt.MIME_TYPE_HEIC) || Intrinsics.areEqual((Object) str, (Object) UtilsKt.MIME_TYPE_HEIF);
        }
        return false;
    }
}
