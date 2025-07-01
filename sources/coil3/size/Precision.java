package coil3.size;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcoil3/size/Precision;", "", "<init>", "(Ljava/lang/String;I)V", "EXACT", "INEXACT", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: Precision.kt */
public enum Precision {
    EXACT,
    INEXACT;

    public static EnumEntries<Precision> getEntries() {
        return $ENTRIES;
    }

    static {
        Precision[] $values;
        $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
    }
}
