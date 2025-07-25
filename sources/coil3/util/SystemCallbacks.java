package coil3.util;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0005À\u0006\u0001"}, d2 = {"Lcoil3/util/SystemCallbacks;", "", "registerMemoryPressureCallbacks", "", "shutdown", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: SystemCallbacks.kt */
public interface SystemCallbacks {
    void registerMemoryPressureCallbacks();

    void shutdown();
}
