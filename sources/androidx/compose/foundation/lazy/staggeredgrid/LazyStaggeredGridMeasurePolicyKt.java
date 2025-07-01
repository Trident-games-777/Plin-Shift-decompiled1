package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(d1 = {"\u0000^\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0010\u0000\u001a\u0019\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001¢\u0006\u0002\b\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0001ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u001a)\u0010\u001c\u001a\u00020\u0012*\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002¢\u0006\u0002\u0010\u001f\u001a)\u0010 \u001a\u00020\u0012*\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002¢\u0006\u0002\u0010\u001f\u001a!\u0010!\u001a\u00020\u0012*\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u001eH\u0002¢\u0006\u0002\u0010\"\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006#"}, d2 = {"rememberStaggeredGridMeasurePolicy", "Lkotlin/Function2;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureResult;", "Lkotlin/ExtensionFunctionType;", "state", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;", "itemProviderLambda", "Lkotlin/Function0;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemProvider;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "reverseLayout", "", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "mainAxisSpacing", "Landroidx/compose/ui/unit/Dp;", "crossAxisSpacing", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "slots", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyGridStaggeredGridSlotsProvider;", "graphicsContext", "Landroidx/compose/ui/graphics/GraphicsContext;", "rememberStaggeredGridMeasurePolicy-qKj4JfE", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;Lkotlin/jvm/functions/Function0;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/gestures/Orientation;FFLkotlinx/coroutines/CoroutineScope;Landroidx/compose/foundation/lazy/staggeredgrid/LazyGridStaggeredGridSlotsProvider;Landroidx/compose/ui/graphics/GraphicsContext;Landroidx/compose/runtime/Composer;I)Lkotlin/jvm/functions/Function2;", "afterPadding", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "(Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/gestures/Orientation;ZLandroidx/compose/ui/unit/LayoutDirection;)F", "beforePadding", "startPadding", "(Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/gestures/Orientation;Landroidx/compose/ui/unit/LayoutDirection;)F", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyStaggeredGridMeasurePolicy.kt */
public final class LazyStaggeredGridMeasurePolicyKt {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: LazyStaggeredGridMeasurePolicy.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        static {
            /*
                androidx.compose.foundation.gestures.Orientation[] r0 = androidx.compose.foundation.gestures.Orientation.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                androidx.compose.foundation.gestures.Orientation r1 = androidx.compose.foundation.gestures.Orientation.Vertical     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                androidx.compose.foundation.gestures.Orientation r1 = androidx.compose.foundation.gestures.Orientation.Horizontal     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasurePolicyKt.WhenMappings.<clinit>():void");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x007e, code lost:
        if (r0.changed((java.lang.Object) r3) == false) goto L_0x0083;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x009b, code lost:
        if (r0.changed(r20) == false) goto L_0x00a0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00d1, code lost:
        if (r0.changed((java.lang.Object) r11) == false) goto L_0x00d6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00d7, code lost:
        if ((r1 & 100663296) == 67108864) goto L_0x00d9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x00d9, code lost:
        r6 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x00da, code lost:
        r13 = r24;
        r1 = (r2 | r6) | r0.changed((java.lang.Object) r13);
        r2 = r0.rememberedValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x00e7, code lost:
        if (r1 != false) goto L_0x00f1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x00ef, code lost:
        if (r2 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L_0x0103;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x00f1, code lost:
        r2 = new androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasurePolicyKt$rememberStaggeredGridMeasurePolicy$1$1(r15, r3, r11, r8, r9, r10, r20, r22, r13);
        r0.updateRememberedValue(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0103, code lost:
        r2 = (kotlin.jvm.functions.Function2) r2;
        androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x010c, code lost:
        if (androidx.compose.runtime.ComposerKt.isTraceInProgress() == false) goto L_0x0111;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x010e, code lost:
        androidx.compose.runtime.ComposerKt.traceEventEnd();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0111, code lost:
        androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0114, code lost:
        return r2;
     */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00cb  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00d4  */
    /* renamed from: rememberStaggeredGridMeasurePolicy-qKj4JfE  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final kotlin.jvm.functions.Function2<androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope, androidx.compose.ui.unit.Constraints, androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureResult> m1056rememberStaggeredGridMeasurePolicyqKj4JfE(androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState r15, kotlin.jvm.functions.Function0<? extends androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemProvider> r16, androidx.compose.foundation.layout.PaddingValues r17, boolean r18, androidx.compose.foundation.gestures.Orientation r19, float r20, float r21, kotlinx.coroutines.CoroutineScope r22, androidx.compose.foundation.lazy.staggeredgrid.LazyGridStaggeredGridSlotsProvider r23, androidx.compose.ui.graphics.GraphicsContext r24, androidx.compose.runtime.Composer r25, int r26) {
        /*
            r0 = r25
            r1 = r26
            java.lang.String r2 = "C(rememberStaggeredGridMeasurePolicy)P(9,4!1,7,6,5:c#ui.unit.Dp,2:c#ui.unit.Dp!1,8)50@2173L2923:LazyStaggeredGridMeasurePolicy.kt#fzvcnm"
            r3 = 1630140849(0x6129f9b1, float:1.9596824E20)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r3, r2)
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x0018
            r2 = -1
            java.lang.String r4 = "androidx.compose.foundation.lazy.staggeredgrid.rememberStaggeredGridMeasurePolicy (LazyStaggeredGridMeasurePolicy.kt:50)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r3, r1, r2, r4)
        L_0x0018:
            r2 = -1650675918(0xffffffff9d9caf32, float:-4.1474004E-21)
            java.lang.String r3 = "CC(remember):LazyStaggeredGridMeasurePolicy.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r2, r3)
            boolean r2 = r0.changed((java.lang.Object) r15)
            r3 = r1 & 112(0x70, float:1.57E-43)
            r3 = r3 ^ 48
            r4 = 32
            r6 = 0
            r7 = 1
            r8 = r16
            if (r3 <= r4) goto L_0x0036
            boolean r3 = r0.changed((java.lang.Object) r8)
            if (r3 != 0) goto L_0x003a
        L_0x0036:
            r3 = r1 & 48
            if (r3 != r4) goto L_0x003c
        L_0x003a:
            r3 = r7
            goto L_0x003d
        L_0x003c:
            r3 = r6
        L_0x003d:
            r2 = r2 | r3
            r3 = r1 & 896(0x380, float:1.256E-42)
            r3 = r3 ^ 384(0x180, float:5.38E-43)
            r4 = 256(0x100, float:3.59E-43)
            r9 = r17
            if (r3 <= r4) goto L_0x004e
            boolean r3 = r0.changed((java.lang.Object) r9)
            if (r3 != 0) goto L_0x0052
        L_0x004e:
            r3 = r1 & 384(0x180, float:5.38E-43)
            if (r3 != r4) goto L_0x0054
        L_0x0052:
            r3 = r7
            goto L_0x0055
        L_0x0054:
            r3 = r6
        L_0x0055:
            r2 = r2 | r3
            r3 = r1 & 7168(0x1c00, float:1.0045E-41)
            r3 = r3 ^ 3072(0xc00, float:4.305E-42)
            r4 = 2048(0x800, float:2.87E-42)
            r10 = r18
            if (r3 <= r4) goto L_0x0066
            boolean r3 = r0.changed((boolean) r10)
            if (r3 != 0) goto L_0x006a
        L_0x0066:
            r3 = r1 & 3072(0xc00, float:4.305E-42)
            if (r3 != r4) goto L_0x006c
        L_0x006a:
            r3 = r7
            goto L_0x006d
        L_0x006c:
            r3 = r6
        L_0x006d:
            r2 = r2 | r3
            r3 = 57344(0xe000, float:8.0356E-41)
            r3 = r3 & r1
            r3 = r3 ^ 24576(0x6000, float:3.4438E-41)
            r4 = 16384(0x4000, float:2.2959E-41)
            if (r3 <= r4) goto L_0x0081
            r3 = r19
            boolean r11 = r0.changed((java.lang.Object) r3)
            if (r11 != 0) goto L_0x0087
            goto L_0x0083
        L_0x0081:
            r3 = r19
        L_0x0083:
            r11 = r1 & 24576(0x6000, float:3.4438E-41)
            if (r11 != r4) goto L_0x0089
        L_0x0087:
            r4 = r7
            goto L_0x008a
        L_0x0089:
            r4 = r6
        L_0x008a:
            r2 = r2 | r4
            r4 = 458752(0x70000, float:6.42848E-40)
            r4 = r4 & r1
            r11 = 196608(0x30000, float:2.75506E-40)
            r4 = r4 ^ r11
            r12 = 131072(0x20000, float:1.83671E-40)
            if (r4 <= r12) goto L_0x009e
            r4 = r20
            boolean r13 = r0.changed((float) r4)
            if (r13 != 0) goto L_0x00a3
            goto L_0x00a0
        L_0x009e:
            r4 = r20
        L_0x00a0:
            r11 = r11 & r1
            if (r11 != r12) goto L_0x00a5
        L_0x00a3:
            r11 = r7
            goto L_0x00a6
        L_0x00a5:
            r11 = r6
        L_0x00a6:
            r2 = r2 | r11
            r11 = 3670016(0x380000, float:5.142788E-39)
            r11 = r11 & r1
            r12 = 1572864(0x180000, float:2.204052E-39)
            r11 = r11 ^ r12
            r13 = 1048576(0x100000, float:1.469368E-39)
            if (r11 <= r13) goto L_0x00b9
            r11 = r21
            boolean r11 = r0.changed((float) r11)
            if (r11 != 0) goto L_0x00bd
        L_0x00b9:
            r11 = r1 & r12
            if (r11 != r13) goto L_0x00bf
        L_0x00bd:
            r11 = r7
            goto L_0x00c0
        L_0x00bf:
            r11 = r6
        L_0x00c0:
            r2 = r2 | r11
            r11 = 234881024(0xe000000, float:1.5777218E-30)
            r11 = r11 & r1
            r12 = 100663296(0x6000000, float:2.4074124E-35)
            r11 = r11 ^ r12
            r13 = 67108864(0x4000000, float:1.5046328E-36)
            if (r11 <= r13) goto L_0x00d4
            r11 = r23
            boolean r14 = r0.changed((java.lang.Object) r11)
            if (r14 != 0) goto L_0x00d9
            goto L_0x00d6
        L_0x00d4:
            r11 = r23
        L_0x00d6:
            r1 = r1 & r12
            if (r1 != r13) goto L_0x00da
        L_0x00d9:
            r6 = r7
        L_0x00da:
            r1 = r2 | r6
            r13 = r24
            boolean r2 = r0.changed((java.lang.Object) r13)
            r1 = r1 | r2
            java.lang.Object r2 = r0.rememberedValue()
            if (r1 != 0) goto L_0x00f1
            androidx.compose.runtime.Composer$Companion r1 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r1 = r1.getEmpty()
            if (r2 != r1) goto L_0x0103
        L_0x00f1:
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasurePolicyKt$rememberStaggeredGridMeasurePolicy$1$1 r4 = new androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasurePolicyKt$rememberStaggeredGridMeasurePolicy$1$1
            r5 = r15
            r12 = r22
            r6 = r3
            r7 = r11
            r11 = r20
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13)
            r2 = r4
            kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2
            r0.updateRememberedValue(r2)
        L_0x0103:
            kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x0111
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0111:
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasurePolicyKt.m1056rememberStaggeredGridMeasurePolicyqKj4JfE(androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState, kotlin.jvm.functions.Function0, androidx.compose.foundation.layout.PaddingValues, boolean, androidx.compose.foundation.gestures.Orientation, float, float, kotlinx.coroutines.CoroutineScope, androidx.compose.foundation.lazy.staggeredgrid.LazyGridStaggeredGridSlotsProvider, androidx.compose.ui.graphics.GraphicsContext, androidx.compose.runtime.Composer, int):kotlin.jvm.functions.Function2");
    }

    /* access modifiers changed from: private */
    public static final float startPadding(PaddingValues paddingValues, Orientation orientation, LayoutDirection layoutDirection) {
        int i = WhenMappings.$EnumSwitchMapping$0[orientation.ordinal()];
        if (i == 1) {
            return PaddingKt.calculateStartPadding(paddingValues, layoutDirection);
        }
        if (i == 2) {
            return paddingValues.m792calculateTopPaddingD9Ej5fM();
        }
        throw new NoWhenBranchMatchedException();
    }

    /* access modifiers changed from: private */
    public static final float beforePadding(PaddingValues paddingValues, Orientation orientation, boolean z, LayoutDirection layoutDirection) {
        int i = WhenMappings.$EnumSwitchMapping$0[orientation.ordinal()];
        if (i == 1) {
            return z ? paddingValues.m789calculateBottomPaddingD9Ej5fM() : paddingValues.m792calculateTopPaddingD9Ej5fM();
        }
        if (i != 2) {
            throw new NoWhenBranchMatchedException();
        } else if (z) {
            return PaddingKt.calculateEndPadding(paddingValues, layoutDirection);
        } else {
            return PaddingKt.calculateStartPadding(paddingValues, layoutDirection);
        }
    }

    /* access modifiers changed from: private */
    public static final float afterPadding(PaddingValues paddingValues, Orientation orientation, boolean z, LayoutDirection layoutDirection) {
        int i = WhenMappings.$EnumSwitchMapping$0[orientation.ordinal()];
        if (i == 1) {
            return z ? paddingValues.m792calculateTopPaddingD9Ej5fM() : paddingValues.m789calculateBottomPaddingD9Ej5fM();
        }
        if (i != 2) {
            throw new NoWhenBranchMatchedException();
        } else if (z) {
            return PaddingKt.calculateStartPadding(paddingValues, layoutDirection);
        } else {
            return PaddingKt.calculateEndPadding(paddingValues, layoutDirection);
        }
    }
}
