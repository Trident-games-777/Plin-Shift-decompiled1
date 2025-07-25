package androidx.compose.ui.text.input;

import androidx.compose.ui.text.intl.LocaleList;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u0000 +2\u00020\u0001:\u0001+BE\b\u0017\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rB9\b\u0017\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000eBM\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0011JD\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nH\u0007ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 JP\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007ø\u0001\u0000¢\u0006\u0004\b!\u0010\"JX\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\u000f\u001a\u00020\u0010ø\u0001\u0000¢\u0006\u0004\b#\u0010$J\u0013\u0010%\u001a\u00020\u00032\b\u0010&\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010'\u001a\u00020(H\u0016J\b\u0010)\u001a\u00020*H\u0016R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0019\u0010\t\u001a\u00020\nø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0019\u0010\u0015R\u0019\u0010\u0007\u001a\u00020\bø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u001a\u0010\u0015R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0013\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006,"}, d2 = {"Landroidx/compose/ui/text/input/ImeOptions;", "", "singleLine", "", "capitalization", "Landroidx/compose/ui/text/input/KeyboardCapitalization;", "autoCorrect", "keyboardType", "Landroidx/compose/ui/text/input/KeyboardType;", "imeAction", "Landroidx/compose/ui/text/input/ImeAction;", "platformImeOptions", "Landroidx/compose/ui/text/input/PlatformImeOptions;", "(ZIZIILandroidx/compose/ui/text/input/PlatformImeOptions;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "(ZIZIILkotlin/jvm/internal/DefaultConstructorMarker;)V", "hintLocales", "Landroidx/compose/ui/text/intl/LocaleList;", "(ZIZIILandroidx/compose/ui/text/input/PlatformImeOptions;Landroidx/compose/ui/text/intl/LocaleList;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAutoCorrect", "()Z", "getCapitalization-IUNYP9k", "()I", "I", "getHintLocales", "()Landroidx/compose/ui/text/intl/LocaleList;", "getImeAction-eUduSuo", "getKeyboardType-PjHm6EE", "getPlatformImeOptions", "()Landroidx/compose/ui/text/input/PlatformImeOptions;", "getSingleLine", "copy", "copy-uxg59PA", "(ZIZII)Landroidx/compose/ui/text/input/ImeOptions;", "copy-YTHSh70", "(ZIZIILandroidx/compose/ui/text/input/PlatformImeOptions;)Landroidx/compose/ui/text/input/ImeOptions;", "copy-wBHncE4", "(ZIZIILandroidx/compose/ui/text/input/PlatformImeOptions;Landroidx/compose/ui/text/intl/LocaleList;)Landroidx/compose/ui/text/input/ImeOptions;", "equals", "other", "hashCode", "", "toString", "", "Companion", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ImeOptions.kt */
public final class ImeOptions {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final ImeOptions Default = new ImeOptions(false, 0, false, 0, 0, (PlatformImeOptions) null, (LocaleList) null, 127, (DefaultConstructorMarker) null);
    private final boolean autoCorrect;
    private final int capitalization;
    private final LocaleList hintLocales;
    private final int imeAction;
    private final int keyboardType;
    private final PlatformImeOptions platformImeOptions;
    private final boolean singleLine;

    public /* synthetic */ ImeOptions(boolean z, int i, boolean z2, int i2, int i3, PlatformImeOptions platformImeOptions2, LocaleList localeList, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, i, z2, i2, i3, platformImeOptions2, localeList);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Please use the new constructor that takes optional hintLocales parameter.")
    public /* synthetic */ ImeOptions(boolean z, int i, boolean z2, int i2, int i3, PlatformImeOptions platformImeOptions2, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, i, z2, i2, i3, platformImeOptions2);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Please use the new constructor that takes optional platformImeOptions parameter.")
    public /* synthetic */ ImeOptions(boolean z, int i, boolean z2, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, i, z2, i2, i3);
    }

    private ImeOptions(boolean z, int i, boolean z2, int i2, int i3, PlatformImeOptions platformImeOptions2, LocaleList localeList) {
        this.singleLine = z;
        this.capitalization = i;
        this.autoCorrect = z2;
        this.keyboardType = i2;
        this.imeAction = i3;
        this.platformImeOptions = platformImeOptions2;
        this.hintLocales = localeList;
    }

    public final boolean getSingleLine() {
        return this.singleLine;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ImeOptions(boolean r9, int r10, boolean r11, int r12, int r13, androidx.compose.ui.text.input.PlatformImeOptions r14, androidx.compose.ui.text.intl.LocaleList r15, int r16, kotlin.jvm.internal.DefaultConstructorMarker r17) {
        /*
            r8 = this;
            r0 = r16 & 1
            if (r0 == 0) goto L_0x0006
            r0 = 0
            goto L_0x0007
        L_0x0006:
            r0 = r9
        L_0x0007:
            r1 = r16 & 2
            if (r1 == 0) goto L_0x0012
            androidx.compose.ui.text.input.KeyboardCapitalization$Companion r1 = androidx.compose.ui.text.input.KeyboardCapitalization.Companion
            int r1 = r1.m6787getNoneIUNYP9k()
            goto L_0x0013
        L_0x0012:
            r1 = r10
        L_0x0013:
            r2 = r16 & 4
            if (r2 == 0) goto L_0x0019
            r2 = 1
            goto L_0x001a
        L_0x0019:
            r2 = r11
        L_0x001a:
            r3 = r16 & 8
            if (r3 == 0) goto L_0x0025
            androidx.compose.ui.text.input.KeyboardType$Companion r3 = androidx.compose.ui.text.input.KeyboardType.Companion
            int r3 = r3.m6815getTextPjHm6EE()
            goto L_0x0026
        L_0x0025:
            r3 = r12
        L_0x0026:
            r4 = r16 & 16
            if (r4 == 0) goto L_0x0031
            androidx.compose.ui.text.input.ImeAction$Companion r4 = androidx.compose.ui.text.input.ImeAction.Companion
            int r4 = r4.m6754getDefaulteUduSuo()
            goto L_0x0032
        L_0x0031:
            r4 = r13
        L_0x0032:
            r5 = r16 & 32
            if (r5 == 0) goto L_0x0038
            r5 = 0
            goto L_0x0039
        L_0x0038:
            r5 = r14
        L_0x0039:
            r6 = r16 & 64
            if (r6 == 0) goto L_0x0044
            androidx.compose.ui.text.intl.LocaleList$Companion r6 = androidx.compose.ui.text.intl.LocaleList.Companion
            androidx.compose.ui.text.intl.LocaleList r6 = r6.getEmpty()
            goto L_0x0045
        L_0x0044:
            r6 = r15
        L_0x0045:
            r7 = 0
            r9 = r8
            r10 = r0
            r11 = r1
            r12 = r2
            r13 = r3
            r14 = r4
            r15 = r5
            r16 = r6
            r17 = r7
            r9.<init>((boolean) r10, (int) r11, (boolean) r12, (int) r13, (int) r14, (androidx.compose.ui.text.input.PlatformImeOptions) r15, (androidx.compose.ui.text.intl.LocaleList) r16, (kotlin.jvm.internal.DefaultConstructorMarker) r17)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.input.ImeOptions.<init>(boolean, int, boolean, int, int, androidx.compose.ui.text.input.PlatformImeOptions, androidx.compose.ui.text.intl.LocaleList, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* renamed from: getCapitalization-IUNYP9k  reason: not valid java name */
    public final int m6769getCapitalizationIUNYP9k() {
        return this.capitalization;
    }

    public final boolean getAutoCorrect() {
        return this.autoCorrect;
    }

    /* renamed from: getKeyboardType-PjHm6EE  reason: not valid java name */
    public final int m6771getKeyboardTypePjHm6EE() {
        return this.keyboardType;
    }

    /* renamed from: getImeAction-eUduSuo  reason: not valid java name */
    public final int m6770getImeActioneUduSuo() {
        return this.imeAction;
    }

    public final PlatformImeOptions getPlatformImeOptions() {
        return this.platformImeOptions;
    }

    public final LocaleList getHintLocales() {
        return this.hintLocales;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroidx/compose/ui/text/input/ImeOptions$Companion;", "", "()V", "Default", "Landroidx/compose/ui/text/input/ImeOptions;", "getDefault", "()Landroidx/compose/ui/text/input/ImeOptions;", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: ImeOptions.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ImeOptions getDefault() {
            return ImeOptions.Default;
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ImeOptions(boolean r8, int r9, boolean r10, int r11, int r12, androidx.compose.ui.text.input.PlatformImeOptions r13, int r14, kotlin.jvm.internal.DefaultConstructorMarker r15) {
        /*
            r7 = this;
            r0 = r14 & 1
            if (r0 == 0) goto L_0x0006
            r0 = 0
            goto L_0x0007
        L_0x0006:
            r0 = r8
        L_0x0007:
            r1 = r14 & 2
            if (r1 == 0) goto L_0x0012
            androidx.compose.ui.text.input.KeyboardCapitalization$Companion r1 = androidx.compose.ui.text.input.KeyboardCapitalization.Companion
            int r1 = r1.m6787getNoneIUNYP9k()
            goto L_0x0013
        L_0x0012:
            r1 = r9
        L_0x0013:
            r2 = r14 & 4
            if (r2 == 0) goto L_0x0019
            r2 = 1
            goto L_0x001a
        L_0x0019:
            r2 = r10
        L_0x001a:
            r3 = r14 & 8
            if (r3 == 0) goto L_0x0025
            androidx.compose.ui.text.input.KeyboardType$Companion r3 = androidx.compose.ui.text.input.KeyboardType.Companion
            int r3 = r3.m6815getTextPjHm6EE()
            goto L_0x0026
        L_0x0025:
            r3 = r11
        L_0x0026:
            r4 = r14 & 16
            if (r4 == 0) goto L_0x0031
            androidx.compose.ui.text.input.ImeAction$Companion r4 = androidx.compose.ui.text.input.ImeAction.Companion
            int r4 = r4.m6754getDefaulteUduSuo()
            goto L_0x0032
        L_0x0031:
            r4 = r12
        L_0x0032:
            r5 = r14 & 32
            if (r5 == 0) goto L_0x0038
            r5 = 0
            goto L_0x0039
        L_0x0038:
            r5 = r13
        L_0x0039:
            r6 = 0
            r8 = r7
            r9 = r0
            r10 = r1
            r11 = r2
            r12 = r3
            r13 = r4
            r14 = r5
            r15 = r6
            r8.<init>((boolean) r9, (int) r10, (boolean) r11, (int) r12, (int) r13, (androidx.compose.ui.text.input.PlatformImeOptions) r14, (kotlin.jvm.internal.DefaultConstructorMarker) r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.input.ImeOptions.<init>(boolean, int, boolean, int, int, androidx.compose.ui.text.input.PlatformImeOptions, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    private ImeOptions(boolean z, int i, boolean z2, int i2, int i3, PlatformImeOptions platformImeOptions2) {
        this(z, i, z2, i2, i3, platformImeOptions2, LocaleList.Companion.getEmpty(), (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ImeOptions(boolean z, int i, boolean z2, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? false : z, (i4 & 2) != 0 ? KeyboardCapitalization.Companion.m6787getNoneIUNYP9k() : i, (i4 & 4) != 0 ? true : z2, (i4 & 8) != 0 ? KeyboardType.Companion.m6815getTextPjHm6EE() : i2, (i4 & 16) != 0 ? ImeAction.Companion.m6754getDefaulteUduSuo() : i3, (DefaultConstructorMarker) null);
    }

    private ImeOptions(boolean z, int i, boolean z2, int i2, int i3) {
        this(z, i, z2, i2, i3, (PlatformImeOptions) null, (LocaleList) null, 64, (DefaultConstructorMarker) null);
    }

    /* renamed from: copy-wBHncE4$default  reason: not valid java name */
    public static /* synthetic */ ImeOptions m6765copywBHncE4$default(ImeOptions imeOptions, boolean z, int i, boolean z2, int i2, int i3, PlatformImeOptions platformImeOptions2, LocaleList localeList, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            z = imeOptions.singleLine;
        }
        if ((i4 & 2) != 0) {
            i = imeOptions.capitalization;
        }
        if ((i4 & 4) != 0) {
            z2 = imeOptions.autoCorrect;
        }
        if ((i4 & 8) != 0) {
            i2 = imeOptions.keyboardType;
        }
        if ((i4 & 16) != 0) {
            i3 = imeOptions.imeAction;
        }
        if ((i4 & 32) != 0) {
            platformImeOptions2 = imeOptions.platformImeOptions;
        }
        if ((i4 & 64) != 0) {
            localeList = imeOptions.hintLocales;
        }
        PlatformImeOptions platformImeOptions3 = platformImeOptions2;
        LocaleList localeList2 = localeList;
        int i5 = i2;
        int i6 = i3;
        return imeOptions.m6768copywBHncE4(z, i, z2, i5, i6, platformImeOptions3, localeList2);
    }

    /* renamed from: copy-wBHncE4  reason: not valid java name */
    public final ImeOptions m6768copywBHncE4(boolean z, int i, boolean z2, int i2, int i3, PlatformImeOptions platformImeOptions2, LocaleList localeList) {
        return new ImeOptions(z, i, z2, i2, i3, platformImeOptions2, localeList, (DefaultConstructorMarker) null);
    }

    /* renamed from: copy-YTHSh70$default  reason: not valid java name */
    public static /* synthetic */ ImeOptions m6763copyYTHSh70$default(ImeOptions imeOptions, boolean z, int i, boolean z2, int i2, int i3, PlatformImeOptions platformImeOptions2, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            z = imeOptions.singleLine;
        }
        if ((i4 & 2) != 0) {
            i = imeOptions.capitalization;
        }
        if ((i4 & 4) != 0) {
            z2 = imeOptions.autoCorrect;
        }
        if ((i4 & 8) != 0) {
            i2 = imeOptions.keyboardType;
        }
        if ((i4 & 16) != 0) {
            i3 = imeOptions.imeAction;
        }
        if ((i4 & 32) != 0) {
            platformImeOptions2 = imeOptions.platformImeOptions;
        }
        int i5 = i3;
        PlatformImeOptions platformImeOptions3 = platformImeOptions2;
        int i6 = i2;
        int i7 = i;
        return imeOptions.m6766copyYTHSh70(z, i7, z2, i6, i5, platformImeOptions3);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Please use the new copy function that takes optional hintLocales parameter.")
    /* renamed from: copy-YTHSh70  reason: not valid java name */
    public final /* synthetic */ ImeOptions m6766copyYTHSh70(boolean z, int i, boolean z2, int i2, int i3, PlatformImeOptions platformImeOptions2) {
        return new ImeOptions(z, i, z2, i2, i3, platformImeOptions2, this.hintLocales, (DefaultConstructorMarker) null);
    }

    /* renamed from: copy-uxg59PA$default  reason: not valid java name */
    public static /* synthetic */ ImeOptions m6764copyuxg59PA$default(ImeOptions imeOptions, boolean z, int i, boolean z2, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            z = imeOptions.singleLine;
        }
        if ((i4 & 2) != 0) {
            i = imeOptions.capitalization;
        }
        if ((i4 & 4) != 0) {
            z2 = imeOptions.autoCorrect;
        }
        if ((i4 & 8) != 0) {
            i2 = imeOptions.keyboardType;
        }
        if ((i4 & 16) != 0) {
            i3 = imeOptions.imeAction;
        }
        int i5 = i2;
        int i6 = i3;
        return imeOptions.m6767copyuxg59PA(z, i, z2, i5, i6);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Please use the new copy function that takes optional platformImeOptions parameter.")
    /* renamed from: copy-uxg59PA  reason: not valid java name */
    public final /* synthetic */ ImeOptions m6767copyuxg59PA(boolean z, int i, boolean z2, int i2, int i3) {
        return new ImeOptions(z, i, z2, i2, i3, this.platformImeOptions, this.hintLocales, (DefaultConstructorMarker) null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ImeOptions)) {
            return false;
        }
        ImeOptions imeOptions = (ImeOptions) obj;
        return this.singleLine == imeOptions.singleLine && KeyboardCapitalization.m6777equalsimpl0(this.capitalization, imeOptions.capitalization) && this.autoCorrect == imeOptions.autoCorrect && KeyboardType.m6794equalsimpl0(this.keyboardType, imeOptions.keyboardType) && ImeAction.m6741equalsimpl0(this.imeAction, imeOptions.imeAction) && Intrinsics.areEqual((Object) this.platformImeOptions, (Object) imeOptions.platformImeOptions) && Intrinsics.areEqual((Object) this.hintLocales, (Object) imeOptions.hintLocales);
    }

    public int hashCode() {
        int hashCode = ((((((((Boolean.hashCode(this.singleLine) * 31) + KeyboardCapitalization.m6778hashCodeimpl(this.capitalization)) * 31) + Boolean.hashCode(this.autoCorrect)) * 31) + KeyboardType.m6795hashCodeimpl(this.keyboardType)) * 31) + ImeAction.m6742hashCodeimpl(this.imeAction)) * 31;
        PlatformImeOptions platformImeOptions2 = this.platformImeOptions;
        return ((hashCode + (platformImeOptions2 != null ? platformImeOptions2.hashCode() : 0)) * 31) + this.hintLocales.hashCode();
    }

    public String toString() {
        return "ImeOptions(singleLine=" + this.singleLine + ", capitalization=" + KeyboardCapitalization.m6779toStringimpl(this.capitalization) + ", autoCorrect=" + this.autoCorrect + ", keyboardType=" + KeyboardType.m6796toStringimpl(this.keyboardType) + ", imeAction=" + ImeAction.m6743toStringimpl(this.imeAction) + ", platformImeOptions=" + this.platformImeOptions + ", hintLocales=" + this.hintLocales + ')';
    }
}
