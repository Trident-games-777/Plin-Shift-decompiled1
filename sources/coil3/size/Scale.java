package coil3.size;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcoil3/size/Scale;", "", "<init>", "(Ljava/lang/String;I)V", "FILL", "FIT", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: Scale.kt */
public enum Scale {
    FILL,
    FIT;

    public static EnumEntries<Scale> getEntries() {
        return $ENTRIES;
    }

    static {
        Scale[] $values;
        $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
    }
}
