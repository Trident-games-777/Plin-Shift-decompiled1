package androidx.compose.ui.semantics;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\b@\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\f\u0010\u0005J\u000f\u0010\r\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0001\u0002\u0001\u00020\u0003¨\u0006\u0012"}, d2 = {"Landroidx/compose/ui/semantics/Role;", "", "value", "", "constructor-impl", "(I)I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
/* compiled from: SemanticsProperties.kt */
public final class Role {
    /* access modifiers changed from: private */
    public static final int Button = m6361constructorimpl(0);
    /* access modifiers changed from: private */
    public static final int Checkbox = m6361constructorimpl(1);
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final int DropdownList = m6361constructorimpl(6);
    /* access modifiers changed from: private */
    public static final int Image = m6361constructorimpl(5);
    /* access modifiers changed from: private */
    public static final int RadioButton = m6361constructorimpl(3);
    /* access modifiers changed from: private */
    public static final int Switch = m6361constructorimpl(2);
    /* access modifiers changed from: private */
    public static final int Tab = m6361constructorimpl(4);
    private final int value;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ Role m6360boximpl(int i) {
        return new Role(i);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    private static int m6361constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m6362equalsimpl(int i, Object obj) {
        return (obj instanceof Role) && i == ((Role) obj).m6366unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m6363equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m6364hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    public boolean equals(Object obj) {
        return m6362equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m6364hashCodeimpl(this.value);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ int m6366unboximpl() {
        return this.value;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u0019\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000b\u0010\u0006R\u0019\u0010\f\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\r\u0010\u0006R\u0019\u0010\u000e\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000f\u0010\u0006R\u0019\u0010\u0010\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0011\u0010\u0006R\u0019\u0010\u0012\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0013\u0010\u0006\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0014"}, d2 = {"Landroidx/compose/ui/semantics/Role$Companion;", "", "()V", "Button", "Landroidx/compose/ui/semantics/Role;", "getButton-o7Vup1c", "()I", "I", "Checkbox", "getCheckbox-o7Vup1c", "DropdownList", "getDropdownList-o7Vup1c", "Image", "getImage-o7Vup1c", "RadioButton", "getRadioButton-o7Vup1c", "Switch", "getSwitch-o7Vup1c", "Tab", "getTab-o7Vup1c", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: SemanticsProperties.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: getButton-o7Vup1c  reason: not valid java name */
        public final int m6367getButtono7Vup1c() {
            return Role.Button;
        }

        /* renamed from: getCheckbox-o7Vup1c  reason: not valid java name */
        public final int m6368getCheckboxo7Vup1c() {
            return Role.Checkbox;
        }

        /* renamed from: getSwitch-o7Vup1c  reason: not valid java name */
        public final int m6372getSwitcho7Vup1c() {
            return Role.Switch;
        }

        /* renamed from: getRadioButton-o7Vup1c  reason: not valid java name */
        public final int m6371getRadioButtono7Vup1c() {
            return Role.RadioButton;
        }

        /* renamed from: getTab-o7Vup1c  reason: not valid java name */
        public final int m6373getTabo7Vup1c() {
            return Role.Tab;
        }

        /* renamed from: getImage-o7Vup1c  reason: not valid java name */
        public final int m6370getImageo7Vup1c() {
            return Role.Image;
        }

        /* renamed from: getDropdownList-o7Vup1c  reason: not valid java name */
        public final int m6369getDropdownListo7Vup1c() {
            return Role.DropdownList;
        }
    }

    private /* synthetic */ Role(int i) {
        this.value = i;
    }

    public String toString() {
        return m6365toStringimpl(this.value);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m6365toStringimpl(int i) {
        if (m6363equalsimpl0(i, Button)) {
            return "Button";
        }
        if (m6363equalsimpl0(i, Checkbox)) {
            return "Checkbox";
        }
        if (m6363equalsimpl0(i, Switch)) {
            return "Switch";
        }
        if (m6363equalsimpl0(i, RadioButton)) {
            return "RadioButton";
        }
        if (m6363equalsimpl0(i, Tab)) {
            return "Tab";
        }
        if (m6363equalsimpl0(i, Image)) {
            return "Image";
        }
        if (m6363equalsimpl0(i, DropdownList)) {
            return "DropdownList";
        }
        return "Unknown";
    }
}
