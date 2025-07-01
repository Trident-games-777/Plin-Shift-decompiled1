package androidx.compose.foundation.text.input;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\b@\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u0005J\u0010\u0010\u000f\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0001\u0002¨\u0006\u0014"}, d2 = {"Landroidx/compose/foundation/text/input/TextObfuscationMode;", "", "value", "", "constructor-impl", "(I)I", "getValue", "()I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
/* compiled from: TextObfuscationMode.kt */
public final class TextObfuscationMode {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final int Hidden = m1327constructorimpl(2);
    /* access modifiers changed from: private */
    public static final int RevealLastTyped = m1327constructorimpl(1);
    /* access modifiers changed from: private */
    public static final int Visible = m1327constructorimpl(0);
    private final int value;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ TextObfuscationMode m1326boximpl(int i) {
        return new TextObfuscationMode(i);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static int m1327constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m1328equalsimpl(int i, Object obj) {
        return (obj instanceof TextObfuscationMode) && i == ((TextObfuscationMode) obj).m1332unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m1329equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m1330hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m1331toStringimpl(int i) {
        return "TextObfuscationMode(value=" + i + ')';
    }

    public boolean equals(Object obj) {
        return m1328equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m1330hashCodeimpl(this.value);
    }

    public String toString() {
        return m1331toStringimpl(this.value);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ int m1332unboximpl() {
        return this.value;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u0019\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000b\u0010\u0006\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\f"}, d2 = {"Landroidx/compose/foundation/text/input/TextObfuscationMode$Companion;", "", "()V", "Hidden", "Landroidx/compose/foundation/text/input/TextObfuscationMode;", "getHidden-vTwcZD0", "()I", "I", "RevealLastTyped", "getRevealLastTyped-vTwcZD0", "Visible", "getVisible-vTwcZD0", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: TextObfuscationMode.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: getVisible-vTwcZD0  reason: not valid java name */
        public final int m1335getVisiblevTwcZD0() {
            return TextObfuscationMode.Visible;
        }

        /* renamed from: getRevealLastTyped-vTwcZD0  reason: not valid java name */
        public final int m1334getRevealLastTypedvTwcZD0() {
            return TextObfuscationMode.RevealLastTyped;
        }

        /* renamed from: getHidden-vTwcZD0  reason: not valid java name */
        public final int m1333getHiddenvTwcZD0() {
            return TextObfuscationMode.Hidden;
        }
    }

    private /* synthetic */ TextObfuscationMode(int i) {
        this.value = i;
    }

    public final int getValue() {
        return this.value;
    }
}
