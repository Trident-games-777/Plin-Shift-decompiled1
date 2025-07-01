package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\b@\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\f\u0010\u0005J\u000f\u0010\r\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0001\u0002\u0001\u00020\u0003¨\u0006\u0012"}, d2 = {"Landroidx/compose/material3/NavigationItemIconPosition;", "", "value", "", "constructor-impl", "(I)I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
/* compiled from: NavigationItem.kt */
public final class NavigationItemIconPosition {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final int Start = m2282constructorimpl(1);
    /* access modifiers changed from: private */
    public static final int Top = m2282constructorimpl(0);
    private final int value;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ NavigationItemIconPosition m2281boximpl(int i) {
        return new NavigationItemIconPosition(i);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    private static int m2282constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m2283equalsimpl(int i, Object obj) {
        return (obj instanceof NavigationItemIconPosition) && i == ((NavigationItemIconPosition) obj).m2287unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m2284equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m2285hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    public boolean equals(Object obj) {
        return m2283equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m2285hashCodeimpl(this.value);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ int m2287unboximpl() {
        return this.value;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\n"}, d2 = {"Landroidx/compose/material3/NavigationItemIconPosition$Companion;", "", "()V", "Start", "Landroidx/compose/material3/NavigationItemIconPosition;", "getStart--xw1Ddg", "()I", "I", "Top", "getTop--xw1Ddg", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: NavigationItem.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: getTop--xw1Ddg  reason: not valid java name */
        public final int m2289getTopxw1Ddg() {
            return NavigationItemIconPosition.Top;
        }

        /* renamed from: getStart--xw1Ddg  reason: not valid java name */
        public final int m2288getStartxw1Ddg() {
            return NavigationItemIconPosition.Start;
        }
    }

    private /* synthetic */ NavigationItemIconPosition(int i) {
        this.value = i;
    }

    public String toString() {
        return m2286toStringimpl(this.value);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m2286toStringimpl(int i) {
        if (m2284equalsimpl0(i, Top)) {
            return "Top";
        }
        if (m2284equalsimpl0(i, Start)) {
            return "Start";
        }
        return "Unknown";
    }
}
