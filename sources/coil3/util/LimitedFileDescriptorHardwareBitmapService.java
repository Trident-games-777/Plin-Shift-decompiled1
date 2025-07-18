package coil3.util;

import coil3.size.Dimension;
import coil3.size.Size;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u0007H\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcoil3/util/LimitedFileDescriptorHardwareBitmapService;", "Lcoil3/util/HardwareBitmapService;", "logger", "Lcoil3/util/Logger;", "<init>", "(Lcoil3/util/Logger;)V", "allowHardwareMainThread", "", "size", "Lcoil3/size/Size;", "allowHardwareWorkerThread", "Companion", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: hardwareBitmaps.kt */
final class LimitedFileDescriptorHardwareBitmapService implements HardwareBitmapService {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int MIN_SIZE_DIMENSION = 100;
    private final Logger logger;

    public LimitedFileDescriptorHardwareBitmapService(Logger logger2) {
        this.logger = logger2;
    }

    public boolean allowHardwareMainThread(Size size) {
        Dimension width = size.getWidth();
        int i = Integer.MAX_VALUE;
        if ((width instanceof Dimension.Pixels ? ((Dimension.Pixels) width).m7548unboximpl() : Integer.MAX_VALUE) <= 100) {
            return false;
        }
        Dimension height = size.getHeight();
        if (height instanceof Dimension.Pixels) {
            i = ((Dimension.Pixels) height).m7548unboximpl();
        }
        return i > 100;
    }

    public boolean allowHardwareWorkerThread() {
        return FileDescriptorCounter.INSTANCE.hasAvailableFileDescriptors(this.logger);
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcoil3/util/LimitedFileDescriptorHardwareBitmapService$Companion;", "", "<init>", "()V", "MIN_SIZE_DIMENSION", "", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* compiled from: hardwareBitmaps.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
