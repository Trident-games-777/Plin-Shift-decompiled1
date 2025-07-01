package coil3.util;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0000\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"HardwareBitmapService", "Lcoil3/util/HardwareBitmapService;", "logger", "Lcoil3/util/Logger;", "IS_DEVICE_BLOCKED", "", "coil-core_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* compiled from: hardwareBitmaps.kt */
public final class HardwareBitmapsKt {
    private static final boolean IS_DEVICE_BLOCKED = false;

    public static final HardwareBitmapService HardwareBitmapService(Logger logger) {
        if (IS_DEVICE_BLOCKED) {
            return new ImmutableHardwareBitmapService(false);
        }
        return new ImmutableHardwareBitmapService(true);
    }
}
