package androidx.compose.foundation.layout;

import androidx.compose.foundation.layout.FlowLayoutOverflow;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0001\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u00120\b\u0002\u0010\u0007\u001a*\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0002\b\u000f\u0018\u00010\b\u00120\b\u0002\u0010\u0010\u001a*\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0002\b\u000f\u0018\u00010\b¢\u0006\u0002\u0010\u0011¨\u0006\u0013"}, d2 = {"Landroidx/compose/foundation/layout/FlowRowOverflow;", "Landroidx/compose/foundation/layout/FlowLayoutOverflow;", "type", "Landroidx/compose/foundation/layout/FlowLayoutOverflow$OverflowType;", "minLinesToShowCollapse", "", "minCrossAxisSizeToShowCollapse", "seeMoreGetter", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/FlowLayoutOverflowState;", "Lkotlin/ParameterName;", "name", "state", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "collapseGetter", "(Landroidx/compose/foundation/layout/FlowLayoutOverflow$OverflowType;IILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "Companion", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: FlowLayoutOverflow.kt */
public final class FlowRowOverflow extends FlowLayoutOverflow {
    public static final int $stable = 0;
    /* access modifiers changed from: private */
    public static final FlowRowOverflow Clip = new FlowRowOverflow(FlowLayoutOverflow.OverflowType.Clip, 0, 0, (Function1) null, (Function1) null, 30, (DefaultConstructorMarker) null);
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final FlowRowOverflow Visible = new FlowRowOverflow(FlowLayoutOverflow.OverflowType.Visible, 0, 0, (Function1) null, (Function1) null, 30, (DefaultConstructorMarker) null);

    public /* synthetic */ FlowRowOverflow(FlowLayoutOverflow.OverflowType overflowType, int i, int i2, Function1 function1, Function1 function12, DefaultConstructorMarker defaultConstructorMarker) {
        this(overflowType, i, i2, function1, function12);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* synthetic */ FlowRowOverflow(androidx.compose.foundation.layout.FlowLayoutOverflow.OverflowType r2, int r3, int r4, kotlin.jvm.functions.Function1 r5, kotlin.jvm.functions.Function1 r6, int r7, kotlin.jvm.internal.DefaultConstructorMarker r8) {
        /*
            r1 = this;
            r8 = r7 & 2
            r0 = 0
            if (r8 == 0) goto L_0x0006
            r3 = r0
        L_0x0006:
            r8 = r7 & 4
            if (r8 == 0) goto L_0x000b
            r4 = r0
        L_0x000b:
            r8 = r7 & 8
            r0 = 0
            if (r8 == 0) goto L_0x0011
            r5 = r0
        L_0x0011:
            r7 = r7 & 16
            if (r7 == 0) goto L_0x0017
            r7 = r0
            goto L_0x0018
        L_0x0017:
            r7 = r6
        L_0x0018:
            r6 = r5
            r5 = r4
            r4 = r3
            r3 = r2
            r2 = r1
            r2.<init>(r3, r4, r5, r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.layout.FlowRowOverflow.<init>(androidx.compose.foundation.layout.FlowLayoutOverflow$OverflowType, int, int, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    private FlowRowOverflow(FlowLayoutOverflow.OverflowType overflowType, int i, int i2, Function1<? super FlowLayoutOverflowState, ? extends Function2<? super Composer, ? super Integer, Unit>> function1, Function1<? super FlowLayoutOverflowState, ? extends Function2<? super Composer, ? super Integer, Unit>> function12) {
        super(overflowType, i, i2, function1, function12, (DefaultConstructorMarker) null);
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J+\u0010\u000b\u001a\u00020\u00042\u001c\u0010\f\u001a\u0018\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r¢\u0006\u0002\b\u0010¢\u0006\u0002\b\u0011H\u0007¢\u0006\u0002\u0010\u0012Jb\u0010\u0013\u001a\u00020\u00042\u001c\u0010\u000b\u001a\u0018\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r¢\u0006\u0002\b\u0010¢\u0006\u0002\b\u00112\u001c\u0010\u0014\u001a\u0018\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r¢\u0006\u0002\b\u0010¢\u0006\u0002\b\u00112\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u0018H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001aR\u001c\u0010\u0003\u001a\u00020\u00048GX\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u00020\u00048GX\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\t\u0010\u0002\u001a\u0004\b\n\u0010\u0007\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001b"}, d2 = {"Landroidx/compose/foundation/layout/FlowRowOverflow$Companion;", "", "()V", "Clip", "Landroidx/compose/foundation/layout/FlowRowOverflow;", "getClip$annotations", "getClip", "()Landroidx/compose/foundation/layout/FlowRowOverflow;", "Visible", "getVisible$annotations", "getVisible", "expandIndicator", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/FlowRowOverflowScope;", "", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function3;)Landroidx/compose/foundation/layout/FlowRowOverflow;", "expandOrCollapseIndicator", "collapseIndicator", "minRowsToShowCollapse", "", "minHeightToShowCollapse", "Landroidx/compose/ui/unit/Dp;", "expandOrCollapseIndicator--jt2gSs", "(Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;IFLandroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/layout/FlowRowOverflow;", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: FlowLayoutOverflow.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void getClip$annotations() {
        }

        public static /* synthetic */ void getVisible$annotations() {
        }

        private Companion() {
        }

        public final FlowRowOverflow getVisible() {
            return FlowRowOverflow.Visible;
        }

        public final FlowRowOverflow getClip() {
            return FlowRowOverflow.Clip;
        }

        public final FlowRowOverflow expandIndicator(Function3<? super FlowRowOverflowScope, ? super Composer, ? super Integer, Unit> function3) {
            return new FlowRowOverflow(FlowLayoutOverflow.OverflowType.ExpandIndicator, 0, 0, new FlowRowOverflow$Companion$expandIndicator$seeMoreGetter$1(function3), (Function1) null, 22, (DefaultConstructorMarker) null);
        }

        /* renamed from: expandOrCollapseIndicator--jt2gSs  reason: not valid java name */
        public final FlowRowOverflow m718expandOrCollapseIndicatorjt2gSs(Function3<? super FlowRowOverflowScope, ? super Composer, ? super Integer, Unit> function3, Function3<? super FlowRowOverflowScope, ? super Composer, ? super Integer, Unit> function32, int i, float f, Composer composer, int i2, int i3) {
            float f2;
            Composer composer2 = composer;
            int i4 = i2;
            ComposerKt.sourceInformationMarkerStart(composer2, -58693346, "C(expandOrCollapseIndicator)P(1!1,3,2:c#ui.unit.Dp)*155@7080L7,158@7176L1079:FlowLayoutOverflow.kt#2w3rfo");
            boolean z = true;
            int i5 = (i3 & 4) != 0 ? 1 : i;
            if ((i3 & 8) != 0) {
                f2 = Dp.m7111constructorimpl((float) 0);
            } else {
                f2 = f;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-58693346, i4, -1, "androidx.compose.foundation.layout.FlowRowOverflow.Companion.expandOrCollapseIndicator (FlowLayoutOverflow.kt:154)");
            }
            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = composer2.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd(composer2);
            int r8 = ((Density) consume).m7086roundToPx0680j_4(f2);
            ComposerKt.sourceInformationMarkerStart(composer2, -132686000, "CC(remember):FlowLayoutOverflow.kt#9igjgp");
            boolean changed = ((((i4 & 896) ^ 384) > 256 && composer2.changed(i5)) || (i4 & 384) == 256) | composer2.changed(r8) | ((((i4 & 14) ^ 6) > 4 && composer2.changed((Object) function3)) || (i4 & 6) == 4);
            if ((((i4 & 112) ^ 48) <= 32 || !composer2.changed((Object) function32)) && (i4 & 48) != 32) {
                z = false;
            }
            boolean z2 = changed | z;
            Object rememberedValue = composer2.rememberedValue();
            if (z2 || rememberedValue == Composer.Companion.getEmpty()) {
                FlowRowOverflow flowRowOverflow = new FlowRowOverflow(FlowLayoutOverflow.OverflowType.ExpandOrCollapseIndicator, i5, r8, new FlowRowOverflow$Companion$expandOrCollapseIndicator$1$seeMoreGetter$1(function3), new FlowRowOverflow$Companion$expandOrCollapseIndicator$1$collapseGetter$1(function32), (DefaultConstructorMarker) null);
                composer2.updateRememberedValue(flowRowOverflow);
                rememberedValue = flowRowOverflow;
            }
            FlowRowOverflow flowRowOverflow2 = (FlowRowOverflow) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            return flowRowOverflow2;
        }
    }
}
