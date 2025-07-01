package androidx.compose.material3;

import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.Easing;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.state.ToggleableState;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001Be\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003¢\u0006\u0002\u0010\u000fJ%\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00030\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0001¢\u0006\u0004\b$\u0010%J%\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00030\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0001¢\u0006\u0004\b'\u0010%J\u001d\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00030\u001f2\u0006\u0010\"\u001a\u00020#H\u0001¢\u0006\u0004\b)\u0010*J\u0001\u0010+\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b,\u0010-J\u0013\u0010.\u001a\u00020!2\b\u0010/\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u00100\u001a\u000201H\u0016R\u0019\u0010\n\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0005\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0013\u0010\u0011R\u0019\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0014\u0010\u0011R\u0019\u0010\f\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0015\u0010\u0011R\u0019\u0010\u0007\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0016\u0010\u0011R\u0019\u0010\u000e\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0017\u0010\u0011R\u0019\u0010\t\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0018\u0010\u0011R\u0019\u0010\r\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0019\u0010\u0011R\u0019\u0010\b\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u001a\u0010\u0011R\u0019\u0010\u000b\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u001b\u0010\u0011R\u0019\u0010\u0006\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u001c\u0010\u0011R\u0019\u0010\u0004\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u001d\u0010\u0011\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u00062"}, d2 = {"Landroidx/compose/material3/CheckboxColors;", "", "checkedCheckmarkColor", "Landroidx/compose/ui/graphics/Color;", "uncheckedCheckmarkColor", "checkedBoxColor", "uncheckedBoxColor", "disabledCheckedBoxColor", "disabledUncheckedBoxColor", "disabledIndeterminateBoxColor", "checkedBorderColor", "uncheckedBorderColor", "disabledBorderColor", "disabledUncheckedBorderColor", "disabledIndeterminateBorderColor", "(JJJJJJJJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getCheckedBorderColor-0d7_KjU", "()J", "J", "getCheckedBoxColor-0d7_KjU", "getCheckedCheckmarkColor-0d7_KjU", "getDisabledBorderColor-0d7_KjU", "getDisabledCheckedBoxColor-0d7_KjU", "getDisabledIndeterminateBorderColor-0d7_KjU", "getDisabledIndeterminateBoxColor-0d7_KjU", "getDisabledUncheckedBorderColor-0d7_KjU", "getDisabledUncheckedBoxColor-0d7_KjU", "getUncheckedBorderColor-0d7_KjU", "getUncheckedBoxColor-0d7_KjU", "getUncheckedCheckmarkColor-0d7_KjU", "borderColor", "Landroidx/compose/runtime/State;", "enabled", "", "state", "Landroidx/compose/ui/state/ToggleableState;", "borderColor$material3_release", "(ZLandroidx/compose/ui/state/ToggleableState;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "boxColor", "boxColor$material3_release", "checkmarkColor", "checkmarkColor$material3_release", "(Landroidx/compose/ui/state/ToggleableState;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "copy", "copy-2qZNXz8", "(JJJJJJJJJJJJ)Landroidx/compose/material3/CheckboxColors;", "equals", "other", "hashCode", "", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Checkbox.kt */
public final class CheckboxColors {
    public static final int $stable = 0;
    private final long checkedBorderColor;
    private final long checkedBoxColor;
    private final long checkedCheckmarkColor;
    private final long disabledBorderColor;
    private final long disabledCheckedBoxColor;
    private final long disabledIndeterminateBorderColor;
    private final long disabledIndeterminateBoxColor;
    private final long disabledUncheckedBorderColor;
    private final long disabledUncheckedBoxColor;
    private final long uncheckedBorderColor;
    private final long uncheckedBoxColor;
    private final long uncheckedCheckmarkColor;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: Checkbox.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        static {
            /*
                androidx.compose.ui.state.ToggleableState[] r0 = androidx.compose.ui.state.ToggleableState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                androidx.compose.ui.state.ToggleableState r1 = androidx.compose.ui.state.ToggleableState.On     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                androidx.compose.ui.state.ToggleableState r1 = androidx.compose.ui.state.ToggleableState.Indeterminate     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                androidx.compose.ui.state.ToggleableState r1 = androidx.compose.ui.state.ToggleableState.Off     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.CheckboxColors.WhenMappings.<clinit>():void");
        }
    }

    public /* synthetic */ CheckboxColors(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, j4, j5, j6, j7, j8, j9, j10, j11, j12);
    }

    private CheckboxColors(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12) {
        this.checkedCheckmarkColor = j;
        this.uncheckedCheckmarkColor = j2;
        this.checkedBoxColor = j3;
        this.uncheckedBoxColor = j4;
        this.disabledCheckedBoxColor = j5;
        this.disabledUncheckedBoxColor = j6;
        this.disabledIndeterminateBoxColor = j7;
        this.checkedBorderColor = j8;
        this.uncheckedBorderColor = j9;
        this.disabledBorderColor = j10;
        this.disabledUncheckedBorderColor = j11;
        this.disabledIndeterminateBorderColor = j12;
    }

    /* renamed from: getCheckedCheckmarkColor-0d7_KjU  reason: not valid java name */
    public final long m1792getCheckedCheckmarkColor0d7_KjU() {
        return this.checkedCheckmarkColor;
    }

    /* renamed from: getUncheckedCheckmarkColor-0d7_KjU  reason: not valid java name */
    public final long m1801getUncheckedCheckmarkColor0d7_KjU() {
        return this.uncheckedCheckmarkColor;
    }

    /* renamed from: getCheckedBoxColor-0d7_KjU  reason: not valid java name */
    public final long m1791getCheckedBoxColor0d7_KjU() {
        return this.checkedBoxColor;
    }

    /* renamed from: getUncheckedBoxColor-0d7_KjU  reason: not valid java name */
    public final long m1800getUncheckedBoxColor0d7_KjU() {
        return this.uncheckedBoxColor;
    }

    /* renamed from: getDisabledCheckedBoxColor-0d7_KjU  reason: not valid java name */
    public final long m1794getDisabledCheckedBoxColor0d7_KjU() {
        return this.disabledCheckedBoxColor;
    }

    /* renamed from: getDisabledUncheckedBoxColor-0d7_KjU  reason: not valid java name */
    public final long m1798getDisabledUncheckedBoxColor0d7_KjU() {
        return this.disabledUncheckedBoxColor;
    }

    /* renamed from: getDisabledIndeterminateBoxColor-0d7_KjU  reason: not valid java name */
    public final long m1796getDisabledIndeterminateBoxColor0d7_KjU() {
        return this.disabledIndeterminateBoxColor;
    }

    /* renamed from: getCheckedBorderColor-0d7_KjU  reason: not valid java name */
    public final long m1790getCheckedBorderColor0d7_KjU() {
        return this.checkedBorderColor;
    }

    /* renamed from: getUncheckedBorderColor-0d7_KjU  reason: not valid java name */
    public final long m1799getUncheckedBorderColor0d7_KjU() {
        return this.uncheckedBorderColor;
    }

    /* renamed from: getDisabledBorderColor-0d7_KjU  reason: not valid java name */
    public final long m1793getDisabledBorderColor0d7_KjU() {
        return this.disabledBorderColor;
    }

    /* renamed from: getDisabledUncheckedBorderColor-0d7_KjU  reason: not valid java name */
    public final long m1797getDisabledUncheckedBorderColor0d7_KjU() {
        return this.disabledUncheckedBorderColor;
    }

    /* renamed from: getDisabledIndeterminateBorderColor-0d7_KjU  reason: not valid java name */
    public final long m1795getDisabledIndeterminateBorderColor0d7_KjU() {
        return this.disabledIndeterminateBorderColor;
    }

    /* renamed from: copy-2qZNXz8$default  reason: not valid java name */
    public static /* synthetic */ CheckboxColors m1788copy2qZNXz8$default(CheckboxColors checkboxColors, long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, int i, Object obj) {
        long j13;
        long j14;
        CheckboxColors checkboxColors2 = checkboxColors;
        int i2 = i;
        long j15 = (i2 & 1) != 0 ? checkboxColors2.checkedCheckmarkColor : j;
        long j16 = (i2 & 2) != 0 ? checkboxColors2.uncheckedCheckmarkColor : j2;
        long j17 = (i2 & 4) != 0 ? checkboxColors2.checkedBoxColor : j3;
        long j18 = (i2 & 8) != 0 ? checkboxColors2.uncheckedBoxColor : j4;
        long j19 = (i2 & 16) != 0 ? checkboxColors2.disabledCheckedBoxColor : j5;
        long j20 = (i2 & 32) != 0 ? checkboxColors2.disabledUncheckedBoxColor : j6;
        long j21 = (i2 & 64) != 0 ? checkboxColors2.disabledIndeterminateBoxColor : j7;
        long j22 = j15;
        long j23 = (i2 & 128) != 0 ? checkboxColors2.checkedBorderColor : j8;
        long j24 = (i2 & 256) != 0 ? checkboxColors2.uncheckedBorderColor : j9;
        long j25 = (i2 & 512) != 0 ? checkboxColors2.disabledBorderColor : j10;
        long j26 = (i2 & 1024) != 0 ? checkboxColors2.disabledUncheckedBorderColor : j11;
        if ((i2 & 2048) != 0) {
            j14 = j26;
            j13 = checkboxColors2.disabledIndeterminateBorderColor;
        } else {
            j13 = j12;
            j14 = j26;
        }
        return checkboxColors2.m1789copy2qZNXz8(j22, j16, j17, j18, j19, j20, j21, j23, j24, j25, j14, j13);
    }

    /* renamed from: copy-2qZNXz8  reason: not valid java name */
    public final CheckboxColors m1789copy2qZNXz8(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12) {
        long j13;
        long j14;
        long j15;
        long j16;
        long j17;
        long j18;
        long j19;
        long j20;
        long j21;
        long j22;
        long j23;
        long j24 = j != 16 ? j : this.checkedCheckmarkColor;
        if (j2 != 16) {
            j13 = j2;
        } else {
            j13 = this.uncheckedCheckmarkColor;
        }
        if (j3 != 16) {
            j14 = j3;
        } else {
            j14 = this.checkedBoxColor;
        }
        if (j4 != 16) {
            j15 = j4;
        } else {
            j15 = this.uncheckedBoxColor;
        }
        if (j5 != 16) {
            j16 = j5;
        } else {
            j16 = this.disabledCheckedBoxColor;
        }
        if (j6 != 16) {
            j17 = j6;
        } else {
            j17 = this.disabledUncheckedBoxColor;
        }
        if (j7 != 16) {
            j18 = j7;
        } else {
            j18 = this.disabledIndeterminateBoxColor;
        }
        if (j8 != 16) {
            j19 = j8;
        } else {
            j19 = this.checkedBorderColor;
        }
        if (j9 != 16) {
            j20 = j9;
        } else {
            j20 = this.uncheckedBorderColor;
        }
        if (j10 != 16) {
            j21 = j10;
        } else {
            j21 = this.disabledBorderColor;
        }
        if (j11 != 16) {
            j22 = j11;
        } else {
            j22 = this.disabledUncheckedBorderColor;
        }
        if (j12 != 16) {
            j23 = j12;
        } else {
            j23 = this.disabledIndeterminateBorderColor;
        }
        return new CheckboxColors(j24, j13, j14, j15, j16, j17, j18, j19, j20, j21, j22, j23, (DefaultConstructorMarker) null);
    }

    public final State<Color> checkmarkColor$material3_release(ToggleableState toggleableState, Composer composer, int i) {
        long j;
        ComposerKt.sourceInformationMarkerStart(composer, -507585681, "C(checkmarkColor)490@21677L61:Checkbox.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-507585681, i, -1, "androidx.compose.material3.CheckboxColors.checkmarkColor (Checkbox.kt:481)");
        }
        if (toggleableState == ToggleableState.Off) {
            j = this.uncheckedCheckmarkColor;
        } else {
            j = this.checkedCheckmarkColor;
        }
        Composer composer2 = composer;
        State<Color> r11 = SingleValueAnimationKt.m123animateColorAsStateeuL9pac(j, AnimationSpecKt.tween$default(toggleableState == ToggleableState.Off ? 100 : 50, 0, (Easing) null, 6, (Object) null), (String) null, (Function1<? super Color, Unit>) null, composer2, 0, 12);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer2);
        return r11;
    }

    public final State<Color> boxColor$material3_release(boolean z, ToggleableState toggleableState, Composer composer, int i) {
        long j;
        State<Color> state;
        Composer composer2;
        ComposerKt.sourceInformationMarkerStart(composer, 360729865, "C(boxColor):Checkbox.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(360729865, i, -1, "androidx.compose.material3.CheckboxColors.boxColor (Checkbox.kt:501)");
        }
        if (z) {
            int i2 = WhenMappings.$EnumSwitchMapping$0[toggleableState.ordinal()];
            if (i2 == 1 || i2 == 2) {
                j = this.checkedBoxColor;
            } else if (i2 == 3) {
                j = this.uncheckedBoxColor;
            } else {
                throw new NoWhenBranchMatchedException();
            }
        } else {
            int i3 = WhenMappings.$EnumSwitchMapping$0[toggleableState.ordinal()];
            if (i3 == 1) {
                j = this.disabledCheckedBoxColor;
            } else if (i3 == 2) {
                j = this.disabledIndeterminateBoxColor;
            } else if (i3 == 3) {
                j = this.disabledUncheckedBoxColor;
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
        long j2 = j;
        if (z) {
            composer.startReplaceGroup(-392211906);
            ComposerKt.sourceInformation(composer, "521@22941L61");
            composer2 = composer;
            state = SingleValueAnimationKt.m123animateColorAsStateeuL9pac(j2, AnimationSpecKt.tween$default(toggleableState == ToggleableState.Off ? 100 : 50, 0, (Easing) null, 6, (Object) null), (String) null, (Function1<? super Color, Unit>) null, composer2, 0, 12);
            composer2.endReplaceGroup();
        } else {
            composer2 = composer;
            composer2.startReplaceGroup(-392031362);
            ComposerKt.sourceInformation(composer2, "523@23032L28");
            state = SnapshotStateKt.rememberUpdatedState(Color.m4229boximpl(j2), composer2, 0);
            composer2.endReplaceGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer2);
        return state;
    }

    public final State<Color> borderColor$material3_release(boolean z, ToggleableState toggleableState, Composer composer, int i) {
        long j;
        State<Color> state;
        Composer composer2;
        ComposerKt.sourceInformationMarkerStart(composer, 1009643462, "C(borderColor):Checkbox.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1009643462, i, -1, "androidx.compose.material3.CheckboxColors.borderColor (Checkbox.kt:534)");
        }
        if (z) {
            int i2 = WhenMappings.$EnumSwitchMapping$0[toggleableState.ordinal()];
            if (i2 == 1 || i2 == 2) {
                j = this.checkedBorderColor;
            } else if (i2 == 3) {
                j = this.uncheckedBorderColor;
            } else {
                throw new NoWhenBranchMatchedException();
            }
        } else {
            int i3 = WhenMappings.$EnumSwitchMapping$0[toggleableState.ordinal()];
            if (i3 == 1) {
                j = this.disabledBorderColor;
            } else if (i3 == 2) {
                j = this.disabledIndeterminateBorderColor;
            } else if (i3 == 3) {
                j = this.disabledUncheckedBorderColor;
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
        long j2 = j;
        if (z) {
            composer.startReplaceGroup(-1725816497);
            ComposerKt.sourceInformation(composer, "554@24267L61");
            composer2 = composer;
            state = SingleValueAnimationKt.m123animateColorAsStateeuL9pac(j2, AnimationSpecKt.tween$default(toggleableState == ToggleableState.Off ? 100 : 50, 0, (Easing) null, 6, (Object) null), (String) null, (Function1<? super Color, Unit>) null, composer2, 0, 12);
            composer2.endReplaceGroup();
        } else {
            composer2 = composer;
            composer2.startReplaceGroup(-1725635953);
            ComposerKt.sourceInformation(composer2, "556@24358L28");
            state = SnapshotStateKt.rememberUpdatedState(Color.m4229boximpl(j2), composer2, 0);
            composer2.endReplaceGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer2);
        return state;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof CheckboxColors)) {
            return false;
        }
        CheckboxColors checkboxColors = (CheckboxColors) obj;
        return Color.m4240equalsimpl0(this.checkedCheckmarkColor, checkboxColors.checkedCheckmarkColor) && Color.m4240equalsimpl0(this.uncheckedCheckmarkColor, checkboxColors.uncheckedCheckmarkColor) && Color.m4240equalsimpl0(this.checkedBoxColor, checkboxColors.checkedBoxColor) && Color.m4240equalsimpl0(this.uncheckedBoxColor, checkboxColors.uncheckedBoxColor) && Color.m4240equalsimpl0(this.disabledCheckedBoxColor, checkboxColors.disabledCheckedBoxColor) && Color.m4240equalsimpl0(this.disabledUncheckedBoxColor, checkboxColors.disabledUncheckedBoxColor) && Color.m4240equalsimpl0(this.disabledIndeterminateBoxColor, checkboxColors.disabledIndeterminateBoxColor) && Color.m4240equalsimpl0(this.checkedBorderColor, checkboxColors.checkedBorderColor) && Color.m4240equalsimpl0(this.uncheckedBorderColor, checkboxColors.uncheckedBorderColor) && Color.m4240equalsimpl0(this.disabledBorderColor, checkboxColors.disabledBorderColor) && Color.m4240equalsimpl0(this.disabledUncheckedBorderColor, checkboxColors.disabledUncheckedBorderColor) && Color.m4240equalsimpl0(this.disabledIndeterminateBorderColor, checkboxColors.disabledIndeterminateBorderColor);
    }

    public int hashCode() {
        return (((((((((((((((((((((Color.m4246hashCodeimpl(this.checkedCheckmarkColor) * 31) + Color.m4246hashCodeimpl(this.uncheckedCheckmarkColor)) * 31) + Color.m4246hashCodeimpl(this.checkedBoxColor)) * 31) + Color.m4246hashCodeimpl(this.uncheckedBoxColor)) * 31) + Color.m4246hashCodeimpl(this.disabledCheckedBoxColor)) * 31) + Color.m4246hashCodeimpl(this.disabledUncheckedBoxColor)) * 31) + Color.m4246hashCodeimpl(this.disabledIndeterminateBoxColor)) * 31) + Color.m4246hashCodeimpl(this.checkedBorderColor)) * 31) + Color.m4246hashCodeimpl(this.uncheckedBorderColor)) * 31) + Color.m4246hashCodeimpl(this.disabledBorderColor)) * 31) + Color.m4246hashCodeimpl(this.disabledUncheckedBorderColor)) * 31) + Color.m4246hashCodeimpl(this.disabledIndeterminateBorderColor);
    }
}
