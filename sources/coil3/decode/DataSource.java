package coil3.decode;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcoil3/decode/DataSource;", "", "<init>", "(Ljava/lang/String;I)V", "MEMORY_CACHE", "MEMORY", "DISK", "NETWORK", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: DataSource.kt */
public enum DataSource {
    MEMORY_CACHE,
    MEMORY,
    DISK,
    NETWORK;

    public static EnumEntries<DataSource> getEntries() {
        return $ENTRIES;
    }

    static {
        DataSource[] $values;
        $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
    }
}
