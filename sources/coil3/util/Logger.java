package coil3.util;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u0010J,\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH&R\u0018\u0010\u0002\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0011À\u0006\u0001"}, d2 = {"Lcoil3/util/Logger;", "", "minLevel", "Lcoil3/util/Logger$Level;", "getMinLevel", "()Lcoil3/util/Logger$Level;", "setMinLevel", "(Lcoil3/util/Logger$Level;)V", "log", "", "tag", "", "level", "message", "throwable", "", "Level", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: logging.kt */
public interface Logger {
    Level getMinLevel();

    void log(String str, Level level, String str2, Throwable th);

    void setMinLevel(Level level);

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcoil3/util/Logger$Level;", "", "<init>", "(Ljava/lang/String;I)V", "Verbose", "Debug", "Info", "Warn", "Error", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* compiled from: logging.kt */
    public enum Level {
        Verbose,
        Debug,
        Info,
        Warn,
        Error;

        public static EnumEntries<Level> getEntries() {
            return $ENTRIES;
        }

        static {
            Level[] $values;
            $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
        }
    }
}
