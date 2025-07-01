package androidx.compose.foundation.text;

import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.ImeOptions;
import androidx.compose.ui.text.input.KeyboardCapitalization;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.compose.ui.text.input.PlatformImeOptions;
import androidx.compose.ui.text.intl.LocaleList;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b3\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u0000 J2\u00020\u0001:\u0001JBQ\b\u0017\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u000fB/\b\u0017\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\u0010B;\b\u0017\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\u0011BS\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u0013J:\u00105\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u0007ø\u0001\u0000¢\u0006\u0004\b6\u00107JF\u00105\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0007ø\u0001\u0000¢\u0006\u0004\b8\u00109J^\u00105\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\b:\u0010;J^\u00105\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eø\u0001\u0000¢\u0006\u0004\b:\u0010<J\u0013\u0010=\u001a\u00020\u00052\b\u0010>\u001a\u0004\u0018\u00010\u0001H\u0002J\u0017\u0010?\u001a\u00020\u00002\b\u0010>\u001a\u0004\u0018\u00010\u0000H\u0001¢\u0006\u0002\b@J\b\u0010A\u001a\u00020BH\u0016J\u0010\u0010C\u001a\u00020\u00002\b\u0010>\u001a\u0004\u0018\u00010\u0000J\u0017\u0010D\u001a\u00020E2\b\b\u0002\u0010F\u001a\u00020\u0005H\u0000¢\u0006\u0002\bGJ\b\u0010H\u001a\u00020IH\u0016R\u001a\u0010\u0004\u001a\u00020\u00058FX\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001b\u001a\u00020\u00058BX\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0017R\u0019\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b\u001d\u0010\u001eR\u001a\u0010 \u001a\u00020\u00038BX\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b!\u0010\u001eR\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0014\u0010$\u001a\u00020\u000e8BX\u0004¢\u0006\u0006\u001a\u0004\b%\u0010#R\u0019\u0010\b\u001a\u00020\tø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b&\u0010\u001eR\u001a\u0010'\u001a\u00020\t8@X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b(\u0010\u001eR\u0014\u0010)\u001a\u00020\u00058BX\u0004¢\u0006\u0006\u001a\u0004\b)\u0010\u0017R\u0019\u0010\u0006\u001a\u00020\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b*\u0010\u001eR\u001a\u0010+\u001a\u00020\u00078BX\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b,\u0010\u001eR\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u001a\u0010/\u001a\u00020\u00058FX\u0004¢\u0006\f\u0012\u0004\b0\u0010\u0015\u001a\u0004\b1\u0010\u0017R\u0015\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b2\u0010\u0019R\u0014\u00103\u001a\u00020\u00058@X\u0004¢\u0006\u0006\u001a\u0004\b4\u0010\u0017\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006K"}, d2 = {"Landroidx/compose/foundation/text/KeyboardOptions;", "", "capitalization", "Landroidx/compose/ui/text/input/KeyboardCapitalization;", "autoCorrect", "", "keyboardType", "Landroidx/compose/ui/text/input/KeyboardType;", "imeAction", "Landroidx/compose/ui/text/input/ImeAction;", "platformImeOptions", "Landroidx/compose/ui/text/input/PlatformImeOptions;", "showKeyboardOnFocus", "hintLocales", "Landroidx/compose/ui/text/intl/LocaleList;", "(IZIILandroidx/compose/ui/text/input/PlatformImeOptions;Ljava/lang/Boolean;Landroidx/compose/ui/text/intl/LocaleList;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "(IZIILkotlin/jvm/internal/DefaultConstructorMarker;)V", "(IZIILandroidx/compose/ui/text/input/PlatformImeOptions;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "autoCorrectEnabled", "(ILjava/lang/Boolean;IILandroidx/compose/ui/text/input/PlatformImeOptions;Ljava/lang/Boolean;Landroidx/compose/ui/text/intl/LocaleList;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAutoCorrect$annotations", "()V", "getAutoCorrect", "()Z", "getAutoCorrectEnabled", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "autoCorrectOrDefault", "getAutoCorrectOrDefault", "getCapitalization-IUNYP9k", "()I", "I", "capitalizationOrDefault", "getCapitalizationOrDefault-IUNYP9k", "getHintLocales", "()Landroidx/compose/ui/text/intl/LocaleList;", "hintLocalesOrDefault", "getHintLocalesOrDefault", "getImeAction-eUduSuo", "imeActionOrDefault", "getImeActionOrDefault-eUduSuo$foundation_release", "isCompletelyUnspecified", "getKeyboardType-PjHm6EE", "keyboardTypeOrDefault", "getKeyboardTypeOrDefault-PjHm6EE", "getPlatformImeOptions", "()Landroidx/compose/ui/text/input/PlatformImeOptions;", "shouldShowKeyboardOnFocus", "getShouldShowKeyboardOnFocus$annotations", "getShouldShowKeyboardOnFocus", "getShowKeyboardOnFocus", "showKeyboardOnFocusOrDefault", "getShowKeyboardOnFocusOrDefault$foundation_release", "copy", "copy-3m2b7yw", "(IZII)Landroidx/compose/foundation/text/KeyboardOptions;", "copy-ij11fho", "(IZIILandroidx/compose/ui/text/input/PlatformImeOptions;)Landroidx/compose/foundation/text/KeyboardOptions;", "copy-INvB4aQ", "(IZIILandroidx/compose/ui/text/input/PlatformImeOptions;Ljava/lang/Boolean;Landroidx/compose/ui/text/intl/LocaleList;)Landroidx/compose/foundation/text/KeyboardOptions;", "(ILjava/lang/Boolean;IILandroidx/compose/ui/text/input/PlatformImeOptions;Ljava/lang/Boolean;Landroidx/compose/ui/text/intl/LocaleList;)Landroidx/compose/foundation/text/KeyboardOptions;", "equals", "other", "fillUnspecifiedValuesWith", "fillUnspecifiedValuesWith$foundation_release", "hashCode", "", "merge", "toImeOptions", "Landroidx/compose/ui/text/input/ImeOptions;", "singleLine", "toImeOptions$foundation_release", "toString", "", "Companion", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: KeyboardOptions.kt */
public final class KeyboardOptions {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final KeyboardOptions Default = new KeyboardOptions(0, (Boolean) null, 0, 0, (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 127, (DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final KeyboardOptions SecureTextField = new KeyboardOptions(0, (Boolean) false, KeyboardType.Companion.m6813getPasswordPjHm6EE(), 0, (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 121, (DefaultConstructorMarker) null);
    private final Boolean autoCorrectEnabled;
    private final int capitalization;
    private final LocaleList hintLocales;
    private final int imeAction;
    private final int keyboardType;
    private final PlatformImeOptions platformImeOptions;
    private final Boolean showKeyboardOnFocus;

    public /* synthetic */ KeyboardOptions(int i, Boolean bool, int i2, int i3, PlatformImeOptions platformImeOptions2, Boolean bool2, LocaleList localeList, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, bool, i2, i3, platformImeOptions2, bool2, localeList);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Please use the new constructor that takes optional autoCorrectEnabled parameter.", replaceWith = @ReplaceWith(expression = "KeyboardOptions(capitalization = capitalization, autoCorrectEnabled = autoCorrect, keyboardType = keyboardType, imeAction = imeAction,platformImeOptions = platformImeOptions, showKeyboardOnFocus = showKeyboardOnFocus,hintLocales = hintLocales)", imports = {}))
    public /* synthetic */ KeyboardOptions(int i, boolean z, int i2, int i3, PlatformImeOptions platformImeOptions2, Boolean bool, LocaleList localeList, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, z, i2, i3, platformImeOptions2, bool, localeList);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compat")
    public /* synthetic */ KeyboardOptions(int i, boolean z, int i2, int i3, PlatformImeOptions platformImeOptions2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, z, i2, i3, platformImeOptions2);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Please use the new constructor that takes optional platformImeOptions parameter.")
    public /* synthetic */ KeyboardOptions(int i, boolean z, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, z, i2, i3);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Please use the autoCorrectEnabled property.")
    public static /* synthetic */ void getAutoCorrect$annotations() {
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Included for binary compatibility. Use showKeyboardOnFocus.")
    public static /* synthetic */ void getShouldShowKeyboardOnFocus$annotations() {
    }

    private KeyboardOptions(int i, Boolean bool, int i2, int i3, PlatformImeOptions platformImeOptions2, Boolean bool2, LocaleList localeList) {
        this.capitalization = i;
        this.autoCorrectEnabled = bool;
        this.keyboardType = i2;
        this.imeAction = i3;
        this.platformImeOptions = platformImeOptions2;
        this.showKeyboardOnFocus = bool2;
        this.hintLocales = localeList;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ KeyboardOptions(int r9, java.lang.Boolean r10, int r11, int r12, androidx.compose.ui.text.input.PlatformImeOptions r13, java.lang.Boolean r14, androidx.compose.ui.text.intl.LocaleList r15, int r16, kotlin.jvm.internal.DefaultConstructorMarker r17) {
        /*
            r8 = this;
            r0 = r16 & 1
            if (r0 == 0) goto L_0x000b
            androidx.compose.ui.text.input.KeyboardCapitalization$Companion r0 = androidx.compose.ui.text.input.KeyboardCapitalization.Companion
            int r0 = r0.m6789getUnspecifiedIUNYP9k()
            goto L_0x000c
        L_0x000b:
            r0 = r9
        L_0x000c:
            r1 = r16 & 2
            r2 = 0
            if (r1 == 0) goto L_0x0013
            r1 = r2
            goto L_0x0014
        L_0x0013:
            r1 = r10
        L_0x0014:
            r3 = r16 & 4
            if (r3 == 0) goto L_0x001f
            androidx.compose.ui.text.input.KeyboardType$Companion r3 = androidx.compose.ui.text.input.KeyboardType.Companion
            int r3 = r3.m6816getUnspecifiedPjHm6EE()
            goto L_0x0020
        L_0x001f:
            r3 = r11
        L_0x0020:
            r4 = r16 & 8
            if (r4 == 0) goto L_0x002b
            androidx.compose.ui.text.input.ImeAction$Companion r4 = androidx.compose.ui.text.input.ImeAction.Companion
            int r4 = r4.m6762getUnspecifiedeUduSuo()
            goto L_0x002c
        L_0x002b:
            r4 = r12
        L_0x002c:
            r5 = r16 & 16
            if (r5 == 0) goto L_0x0032
            r5 = r2
            goto L_0x0033
        L_0x0032:
            r5 = r13
        L_0x0033:
            r6 = r16 & 32
            if (r6 == 0) goto L_0x0039
            r6 = r2
            goto L_0x003a
        L_0x0039:
            r6 = r14
        L_0x003a:
            r7 = r16 & 64
            if (r7 == 0) goto L_0x003f
            goto L_0x0040
        L_0x003f:
            r2 = r15
        L_0x0040:
            r7 = 0
            r9 = r8
            r10 = r0
            r11 = r1
            r16 = r2
            r12 = r3
            r13 = r4
            r14 = r5
            r15 = r6
            r17 = r7
            r9.<init>((int) r10, (java.lang.Boolean) r11, (int) r12, (int) r13, (androidx.compose.ui.text.input.PlatformImeOptions) r14, (java.lang.Boolean) r15, (androidx.compose.ui.text.intl.LocaleList) r16, (kotlin.jvm.internal.DefaultConstructorMarker) r17)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.KeyboardOptions.<init>(int, java.lang.Boolean, int, int, androidx.compose.ui.text.input.PlatformImeOptions, java.lang.Boolean, androidx.compose.ui.text.intl.LocaleList, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* renamed from: getCapitalization-IUNYP9k  reason: not valid java name */
    public final int m1207getCapitalizationIUNYP9k() {
        return this.capitalization;
    }

    public final Boolean getAutoCorrectEnabled() {
        return this.autoCorrectEnabled;
    }

    /* renamed from: getKeyboardType-PjHm6EE  reason: not valid java name */
    public final int m1210getKeyboardTypePjHm6EE() {
        return this.keyboardType;
    }

    /* renamed from: getImeAction-eUduSuo  reason: not valid java name */
    public final int m1208getImeActioneUduSuo() {
        return this.imeAction;
    }

    public final PlatformImeOptions getPlatformImeOptions() {
        return this.platformImeOptions;
    }

    public final Boolean getShowKeyboardOnFocus() {
        return this.showKeyboardOnFocus;
    }

    public final LocaleList getHintLocales() {
        return this.hintLocales;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u00020\u00048\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\t\u0010\u0002\u001a\u0004\b\n\u0010\u0007¨\u0006\u000b"}, d2 = {"Landroidx/compose/foundation/text/KeyboardOptions$Companion;", "", "()V", "Default", "Landroidx/compose/foundation/text/KeyboardOptions;", "getDefault$annotations", "getDefault", "()Landroidx/compose/foundation/text/KeyboardOptions;", "SecureTextField", "getSecureTextField$foundation_release$annotations", "getSecureTextField$foundation_release", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: KeyboardOptions.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void getDefault$annotations() {
        }

        public static /* synthetic */ void getSecureTextField$foundation_release$annotations() {
        }

        private Companion() {
        }

        public final KeyboardOptions getDefault() {
            return KeyboardOptions.Default;
        }

        public final KeyboardOptions getSecureTextField$foundation_release() {
            return KeyboardOptions.SecureTextField;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ KeyboardOptions(int i, boolean z, int i2, int i3, PlatformImeOptions platformImeOptions2, Boolean bool, LocaleList localeList, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? KeyboardCapitalization.Companion.m6789getUnspecifiedIUNYP9k() : i, z, (i4 & 4) != 0 ? KeyboardType.Companion.m6816getUnspecifiedPjHm6EE() : i2, (i4 & 8) != 0 ? ImeAction.Companion.m6762getUnspecifiedeUduSuo() : i3, (i4 & 16) != 0 ? null : platformImeOptions2, (i4 & 32) != 0 ? null : bool, (i4 & 64) != 0 ? null : localeList, (DefaultConstructorMarker) null);
    }

    private KeyboardOptions(int i, boolean z, int i2, int i3, PlatformImeOptions platformImeOptions2, Boolean bool, LocaleList localeList) {
        this(i, Boolean.valueOf(z), i2, i3, platformImeOptions2, bool, localeList, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ KeyboardOptions(int i, boolean z, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? KeyboardCapitalization.Companion.m6789getUnspecifiedIUNYP9k() : i, (i4 & 2) != 0 ? Default.getAutoCorrectOrDefault() : z, (i4 & 4) != 0 ? KeyboardType.Companion.m6816getUnspecifiedPjHm6EE() : i2, (i4 & 8) != 0 ? ImeAction.Companion.m6754getDefaulteUduSuo() : i3, (DefaultConstructorMarker) null);
    }

    private KeyboardOptions(int i, boolean z, int i2, int i3) {
        this(i, Boolean.valueOf(z), i2, i3, (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 96, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ KeyboardOptions(int i, boolean z, int i2, int i3, PlatformImeOptions platformImeOptions2, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? KeyboardCapitalization.Companion.m6787getNoneIUNYP9k() : i, (i4 & 2) != 0 ? Default.getAutoCorrectOrDefault() : z, (i4 & 4) != 0 ? KeyboardType.Companion.m6815getTextPjHm6EE() : i2, (i4 & 8) != 0 ? ImeAction.Companion.m6754getDefaulteUduSuo() : i3, (i4 & 16) != 0 ? null : platformImeOptions2, (DefaultConstructorMarker) null);
    }

    private KeyboardOptions(int i, boolean z, int i2, int i3, PlatformImeOptions platformImeOptions2) {
        this(i, Boolean.valueOf(z), i2, i3, platformImeOptions2, Boolean.valueOf(Default.getShowKeyboardOnFocusOrDefault$foundation_release()), (LocaleList) null, 64, (DefaultConstructorMarker) null);
    }

    public final boolean getAutoCorrect() {
        return getAutoCorrectOrDefault();
    }

    public final /* synthetic */ boolean getShouldShowKeyboardOnFocus() {
        Boolean bool = this.showKeyboardOnFocus;
        if (bool != null) {
            return bool.booleanValue();
        }
        return true;
    }

    private final boolean getAutoCorrectOrDefault() {
        Boolean bool = this.autoCorrectEnabled;
        if (bool != null) {
            return bool.booleanValue();
        }
        return true;
    }

    /* renamed from: getCapitalizationOrDefault-IUNYP9k  reason: not valid java name */
    private final int m1201getCapitalizationOrDefaultIUNYP9k() {
        KeyboardCapitalization r0 = KeyboardCapitalization.m6774boximpl(this.capitalization);
        if (KeyboardCapitalization.m6777equalsimpl0(r0.m6780unboximpl(), KeyboardCapitalization.Companion.m6789getUnspecifiedIUNYP9k())) {
            r0 = null;
        }
        if (r0 != null) {
            return r0.m6780unboximpl();
        }
        return KeyboardCapitalization.Companion.m6787getNoneIUNYP9k();
    }

    /* renamed from: getKeyboardTypeOrDefault-PjHm6EE  reason: not valid java name */
    private final int m1202getKeyboardTypeOrDefaultPjHm6EE() {
        KeyboardType r0 = KeyboardType.m6791boximpl(this.keyboardType);
        if (KeyboardType.m6794equalsimpl0(r0.m6797unboximpl(), KeyboardType.Companion.m6816getUnspecifiedPjHm6EE())) {
            r0 = null;
        }
        if (r0 != null) {
            return r0.m6797unboximpl();
        }
        return KeyboardType.Companion.m6815getTextPjHm6EE();
    }

    /* renamed from: getImeActionOrDefault-eUduSuo$foundation_release  reason: not valid java name */
    public final int m1209getImeActionOrDefaulteUduSuo$foundation_release() {
        ImeAction r0 = ImeAction.m6738boximpl(this.imeAction);
        if (ImeAction.m6741equalsimpl0(r0.m6744unboximpl(), ImeAction.Companion.m6762getUnspecifiedeUduSuo())) {
            r0 = null;
        }
        if (r0 != null) {
            return r0.m6744unboximpl();
        }
        return ImeAction.Companion.m6754getDefaulteUduSuo();
    }

    public final boolean getShowKeyboardOnFocusOrDefault$foundation_release() {
        Boolean bool = this.showKeyboardOnFocus;
        if (bool != null) {
            return bool.booleanValue();
        }
        return true;
    }

    private final LocaleList getHintLocalesOrDefault() {
        LocaleList localeList = this.hintLocales;
        return localeList == null ? LocaleList.Companion.getEmpty() : localeList;
    }

    private final boolean isCompletelyUnspecified() {
        return KeyboardCapitalization.m6777equalsimpl0(this.capitalization, KeyboardCapitalization.Companion.m6789getUnspecifiedIUNYP9k()) && this.autoCorrectEnabled == null && KeyboardType.m6794equalsimpl0(this.keyboardType, KeyboardType.Companion.m6816getUnspecifiedPjHm6EE()) && ImeAction.m6741equalsimpl0(this.imeAction, ImeAction.Companion.m6762getUnspecifiedeUduSuo()) && this.platformImeOptions == null && this.showKeyboardOnFocus == null && this.hintLocales == null;
    }

    public static /* synthetic */ ImeOptions toImeOptions$foundation_release$default(KeyboardOptions keyboardOptions, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = ImeOptions.Companion.getDefault().getSingleLine();
        }
        return keyboardOptions.toImeOptions$foundation_release(z);
    }

    public final ImeOptions toImeOptions$foundation_release(boolean z) {
        return new ImeOptions(z, m1201getCapitalizationOrDefaultIUNYP9k(), getAutoCorrectOrDefault(), m1202getKeyboardTypeOrDefaultPjHm6EE(), m1209getImeActionOrDefaulteUduSuo$foundation_release(), this.platformImeOptions, getHintLocalesOrDefault(), (DefaultConstructorMarker) null);
    }

    /* renamed from: copy-INvB4aQ$default  reason: not valid java name */
    public static /* synthetic */ KeyboardOptions m1198copyINvB4aQ$default(KeyboardOptions keyboardOptions, int i, Boolean bool, int i2, int i3, PlatformImeOptions platformImeOptions2, Boolean bool2, LocaleList localeList, int i4, Object obj) {
        LocaleList localeList2;
        Boolean bool3;
        PlatformImeOptions platformImeOptions3;
        int i5;
        int i6;
        Boolean bool4;
        int i7;
        KeyboardOptions keyboardOptions2;
        if ((i4 & 1) != 0) {
            i = keyboardOptions.capitalization;
        }
        if ((i4 & 2) != 0) {
            bool = keyboardOptions.autoCorrectEnabled;
        }
        if ((i4 & 4) != 0) {
            i2 = keyboardOptions.keyboardType;
        }
        if ((i4 & 8) != 0) {
            i3 = keyboardOptions.imeAction;
        }
        if ((i4 & 16) != 0) {
            platformImeOptions2 = keyboardOptions.platformImeOptions;
        }
        if ((i4 & 32) != 0) {
            bool2 = null;
        }
        if ((i4 & 64) != 0) {
            localeList2 = null;
            platformImeOptions3 = platformImeOptions2;
            bool3 = bool2;
            i6 = i2;
            i5 = i3;
            i7 = i;
            bool4 = bool;
            keyboardOptions2 = keyboardOptions;
        } else {
            localeList2 = localeList;
            bool3 = bool2;
            i5 = i3;
            platformImeOptions3 = platformImeOptions2;
            bool4 = bool;
            i6 = i2;
            keyboardOptions2 = keyboardOptions;
            i7 = i;
        }
        return keyboardOptions2.m1204copyINvB4aQ(i7, bool4, i6, i5, platformImeOptions3, bool3, localeList2);
    }

    /* renamed from: copy-INvB4aQ  reason: not valid java name */
    public final KeyboardOptions m1204copyINvB4aQ(int i, Boolean bool, int i2, int i3, PlatformImeOptions platformImeOptions2, Boolean bool2, LocaleList localeList) {
        return new KeyboardOptions(i, bool, i2, i3, platformImeOptions2, bool2, localeList, (DefaultConstructorMarker) null);
    }

    /* renamed from: copy-INvB4aQ$default  reason: not valid java name */
    public static /* synthetic */ KeyboardOptions m1199copyINvB4aQ$default(KeyboardOptions keyboardOptions, int i, boolean z, int i2, int i3, PlatformImeOptions platformImeOptions2, Boolean bool, LocaleList localeList, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = keyboardOptions.capitalization;
        }
        if ((i4 & 2) != 0) {
            z = keyboardOptions.getAutoCorrectOrDefault();
        }
        if ((i4 & 4) != 0) {
            i2 = keyboardOptions.keyboardType;
        }
        if ((i4 & 8) != 0) {
            i3 = keyboardOptions.imeAction;
        }
        if ((i4 & 16) != 0) {
            platformImeOptions2 = keyboardOptions.platformImeOptions;
        }
        if ((i4 & 32) != 0) {
            bool = Boolean.valueOf(keyboardOptions.getShowKeyboardOnFocusOrDefault$foundation_release());
        }
        if ((i4 & 64) != 0) {
            localeList = keyboardOptions.hintLocales;
        }
        Boolean bool2 = bool;
        LocaleList localeList2 = localeList;
        int i5 = i3;
        PlatformImeOptions platformImeOptions3 = platformImeOptions2;
        return keyboardOptions.m1205copyINvB4aQ(i, z, i2, i5, platformImeOptions3, bool2, localeList2);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Please use the copy function that takes an autoCorrectEnabled parameter.", replaceWith = @ReplaceWith(expression = "copy(capitalization = capitalization, autoCorrectEnabled = autoCorrect, keyboardType = keyboardType, imeAction = imeAction,platformImeOptions = platformImeOptions, showKeyboardOnFocus = showKeyboardOnFocus ?: true,hintLocales = hintLocales)", imports = {}))
    /* renamed from: copy-INvB4aQ  reason: not valid java name */
    public final /* synthetic */ KeyboardOptions m1205copyINvB4aQ(int i, boolean z, int i2, int i3, PlatformImeOptions platformImeOptions2, Boolean bool, LocaleList localeList) {
        return new KeyboardOptions(i, Boolean.valueOf(z), i2, i3, platformImeOptions2, bool, localeList, (DefaultConstructorMarker) null);
    }

    /* renamed from: copy-ij11fho$default  reason: not valid java name */
    public static /* synthetic */ KeyboardOptions m1200copyij11fho$default(KeyboardOptions keyboardOptions, int i, boolean z, int i2, int i3, PlatformImeOptions platformImeOptions2, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = keyboardOptions.capitalization;
        }
        if ((i4 & 2) != 0) {
            z = keyboardOptions.getAutoCorrectOrDefault();
        }
        if ((i4 & 4) != 0) {
            i2 = keyboardOptions.keyboardType;
        }
        if ((i4 & 8) != 0) {
            i3 = keyboardOptions.imeAction;
        }
        if ((i4 & 16) != 0) {
            platformImeOptions2 = keyboardOptions.platformImeOptions;
        }
        int i5 = i3;
        PlatformImeOptions platformImeOptions3 = platformImeOptions2;
        return keyboardOptions.m1206copyij11fho(i, z, i2, i5, platformImeOptions3);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* renamed from: copy-ij11fho  reason: not valid java name */
    public final /* synthetic */ KeyboardOptions m1206copyij11fho(int i, boolean z, int i2, int i3, PlatformImeOptions platformImeOptions2) {
        return new KeyboardOptions(i, Boolean.valueOf(z), i2, i3, platformImeOptions2, this.showKeyboardOnFocus, this.hintLocales, (DefaultConstructorMarker) null);
    }

    /* renamed from: copy-3m2b7yw$default  reason: not valid java name */
    public static /* synthetic */ KeyboardOptions m1197copy3m2b7yw$default(KeyboardOptions keyboardOptions, int i, boolean z, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = keyboardOptions.capitalization;
        }
        if ((i4 & 2) != 0) {
            z = keyboardOptions.getAutoCorrectOrDefault();
        }
        if ((i4 & 4) != 0) {
            i2 = keyboardOptions.keyboardType;
        }
        if ((i4 & 8) != 0) {
            i3 = keyboardOptions.imeAction;
        }
        return keyboardOptions.m1203copy3m2b7yw(i, z, i2, i3);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Please use the new copy function that takes optional platformImeOptions parameter.")
    /* renamed from: copy-3m2b7yw  reason: not valid java name */
    public final /* synthetic */ KeyboardOptions m1203copy3m2b7yw(int i, boolean z, int i2, int i3) {
        return new KeyboardOptions(i, Boolean.valueOf(z), i2, i3, this.platformImeOptions, this.showKeyboardOnFocus, this.hintLocales, (DefaultConstructorMarker) null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof KeyboardOptions)) {
            return false;
        }
        KeyboardOptions keyboardOptions = (KeyboardOptions) obj;
        return KeyboardCapitalization.m6777equalsimpl0(this.capitalization, keyboardOptions.capitalization) && Intrinsics.areEqual((Object) this.autoCorrectEnabled, (Object) keyboardOptions.autoCorrectEnabled) && KeyboardType.m6794equalsimpl0(this.keyboardType, keyboardOptions.keyboardType) && ImeAction.m6741equalsimpl0(this.imeAction, keyboardOptions.imeAction) && Intrinsics.areEqual((Object) this.platformImeOptions, (Object) keyboardOptions.platformImeOptions) && Intrinsics.areEqual((Object) this.showKeyboardOnFocus, (Object) keyboardOptions.showKeyboardOnFocus) && Intrinsics.areEqual((Object) this.hintLocales, (Object) keyboardOptions.hintLocales);
    }

    public int hashCode() {
        int r0 = KeyboardCapitalization.m6778hashCodeimpl(this.capitalization) * 31;
        Boolean bool = this.autoCorrectEnabled;
        int i = 0;
        int hashCode = (((((r0 + (bool != null ? bool.hashCode() : 0)) * 31) + KeyboardType.m6795hashCodeimpl(this.keyboardType)) * 31) + ImeAction.m6742hashCodeimpl(this.imeAction)) * 31;
        PlatformImeOptions platformImeOptions2 = this.platformImeOptions;
        int hashCode2 = (hashCode + (platformImeOptions2 != null ? platformImeOptions2.hashCode() : 0)) * 31;
        Boolean bool2 = this.showKeyboardOnFocus;
        int hashCode3 = (hashCode2 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        LocaleList localeList = this.hintLocales;
        if (localeList != null) {
            i = localeList.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        return "KeyboardOptions(capitalization=" + KeyboardCapitalization.m6779toStringimpl(this.capitalization) + ", autoCorrectEnabled=" + this.autoCorrectEnabled + ", keyboardType=" + KeyboardType.m6796toStringimpl(this.keyboardType) + ", imeAction=" + ImeAction.m6743toStringimpl(this.imeAction) + ", platformImeOptions=" + this.platformImeOptions + "showKeyboardOnFocus=" + this.showKeyboardOnFocus + ", hintLocales=" + this.hintLocales + ')';
    }

    /* JADX WARNING: Code restructure failed: missing block: B:1:0x0002, code lost:
        r1 = r1.fillUnspecifiedValuesWith$foundation_release(r0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.compose.foundation.text.KeyboardOptions merge(androidx.compose.foundation.text.KeyboardOptions r1) {
        /*
            r0 = this;
            if (r1 == 0) goto L_0x000a
            androidx.compose.foundation.text.KeyboardOptions r1 = r1.fillUnspecifiedValuesWith$foundation_release(r0)
            if (r1 != 0) goto L_0x0009
            goto L_0x000a
        L_0x0009:
            return r1
        L_0x000a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.KeyboardOptions.merge(androidx.compose.foundation.text.KeyboardOptions):androidx.compose.foundation.text.KeyboardOptions");
    }

    public final KeyboardOptions fillUnspecifiedValuesWith$foundation_release(KeyboardOptions keyboardOptions) {
        int i;
        int i2;
        int i3;
        if (keyboardOptions == null || keyboardOptions.isCompletelyUnspecified() || Intrinsics.areEqual((Object) keyboardOptions, (Object) this)) {
            return this;
        }
        if (isCompletelyUnspecified()) {
            return keyboardOptions;
        }
        KeyboardCapitalization r0 = KeyboardCapitalization.m6774boximpl(this.capitalization);
        ImeAction imeAction2 = null;
        if (KeyboardCapitalization.m6777equalsimpl0(r0.m6780unboximpl(), KeyboardCapitalization.Companion.m6789getUnspecifiedIUNYP9k())) {
            r0 = null;
        }
        if (r0 != null) {
            i = r0.m6780unboximpl();
        } else {
            i = keyboardOptions.capitalization;
        }
        int i4 = i;
        Boolean bool = this.autoCorrectEnabled;
        if (bool == null) {
            bool = keyboardOptions.autoCorrectEnabled;
        }
        Boolean bool2 = bool;
        KeyboardType r02 = KeyboardType.m6791boximpl(this.keyboardType);
        if (KeyboardType.m6794equalsimpl0(r02.m6797unboximpl(), KeyboardType.Companion.m6816getUnspecifiedPjHm6EE())) {
            r02 = null;
        }
        if (r02 != null) {
            i2 = r02.m6797unboximpl();
        } else {
            i2 = keyboardOptions.keyboardType;
        }
        int i5 = i2;
        ImeAction r03 = ImeAction.m6738boximpl(this.imeAction);
        if (!ImeAction.m6741equalsimpl0(r03.m6744unboximpl(), ImeAction.Companion.m6762getUnspecifiedeUduSuo())) {
            imeAction2 = r03;
        }
        if (imeAction2 != null) {
            i3 = imeAction2.m6744unboximpl();
        } else {
            i3 = keyboardOptions.imeAction;
        }
        int i6 = i3;
        PlatformImeOptions platformImeOptions2 = this.platformImeOptions;
        if (platformImeOptions2 == null) {
            platformImeOptions2 = keyboardOptions.platformImeOptions;
        }
        PlatformImeOptions platformImeOptions3 = platformImeOptions2;
        Boolean bool3 = this.showKeyboardOnFocus;
        if (bool3 == null) {
            bool3 = keyboardOptions.showKeyboardOnFocus;
        }
        Boolean bool4 = bool3;
        LocaleList localeList = this.hintLocales;
        if (localeList == null) {
            localeList = keyboardOptions.hintLocales;
        }
        return new KeyboardOptions(i4, bool2, i5, i6, platformImeOptions3, bool4, localeList, (DefaultConstructorMarker) null);
    }
}
