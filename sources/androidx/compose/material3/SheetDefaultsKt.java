package androidx.compose.material3;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000H\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a;\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2!\u0010\f\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00110\rH\u0000\u001aA\u0010\u0012\u001a\u00020\t2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\u0014\b\u0002\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00140\r2\b\b\u0002\u0010\u0017\u001a\u00020\u00162\b\b\u0002\u0010\u0018\u001a\u00020\u0014H\u0001¢\u0006\u0002\u0010\u0019\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0005¨\u0006\u001a"}, d2 = {"BottomSheetAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "DragHandleVerticalPadding", "Landroidx/compose/ui/unit/Dp;", "F", "ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "sheetState", "Landroidx/compose/material3/SheetState;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "onFling", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "velocity", "", "rememberSheetState", "skipPartiallyExpanded", "", "confirmValueChange", "Landroidx/compose/material3/SheetValue;", "initialValue", "skipHiddenState", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/material3/SheetValue;ZLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/SheetState;", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: SheetDefaults.kt */
public final class SheetDefaultsKt {
    /* access modifiers changed from: private */
    public static final AnimationSpec<Float> BottomSheetAnimationSpec = AnimationSpecKt.tween$default(300, 0, EasingKt.getFastOutSlowInEasing(), 2, (Object) null);
    /* access modifiers changed from: private */
    public static final float DragHandleVerticalPadding = Dp.m7111constructorimpl((float) 22);

    public static final NestedScrollConnection ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection(SheetState sheetState, Orientation orientation, Function1<? super Float, Unit> function1) {
        return new SheetDefaultsKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1(sheetState, function1, orientation);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v0, resolved type: kotlin.jvm.functions.Function1<? super androidx.compose.material3.SheetValue, java.lang.Boolean>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: androidx.compose.runtime.saveable.Saver<androidx.compose.material3.SheetState, androidx.compose.material3.SheetValue>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: kotlin.jvm.functions.Function0} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final androidx.compose.material3.SheetState rememberSheetState(boolean r12, kotlin.jvm.functions.Function1<? super androidx.compose.material3.SheetValue, java.lang.Boolean> r13, androidx.compose.material3.SheetValue r14, boolean r15, androidx.compose.runtime.Composer r16, int r17, int r18) {
        /*
            r4 = r16
            r0 = r17
            java.lang.String r1 = "C(rememberSheetState)P(3)408@15981L7,420@16374L180,409@16000L554:SheetDefaults.kt#uh7d8r"
            r2 = 1032784200(0x3d8f0948, float:0.06984192)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r4, r2, r1)
            r1 = r18 & 1
            r3 = 0
            if (r1 == 0) goto L_0x0013
            r6 = r3
            goto L_0x0014
        L_0x0013:
            r6 = r12
        L_0x0014:
            r12 = r18 & 2
            if (r12 == 0) goto L_0x001d
            androidx.compose.material3.SheetDefaultsKt$rememberSheetState$1 r12 = androidx.compose.material3.SheetDefaultsKt$rememberSheetState$1.INSTANCE
            r13 = r12
            kotlin.jvm.functions.Function1 r13 = (kotlin.jvm.functions.Function1) r13
        L_0x001d:
            r9 = r13
            r12 = r18 & 4
            if (r12 == 0) goto L_0x0026
            androidx.compose.material3.SheetValue r12 = androidx.compose.material3.SheetValue.Hidden
            r8 = r12
            goto L_0x0027
        L_0x0026:
            r8 = r14
        L_0x0027:
            r12 = r18 & 8
            if (r12 == 0) goto L_0x002d
            r10 = r3
            goto L_0x002e
        L_0x002d:
            r10 = r15
        L_0x002e:
            boolean r12 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r12 == 0) goto L_0x003a
            r12 = -1
            java.lang.String r13 = "androidx.compose.material3.rememberSheetState (SheetDefaults.kt:407)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r2, r0, r12, r13)
        L_0x003a:
            androidx.compose.runtime.ProvidableCompositionLocal r12 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r12 = (androidx.compose.runtime.CompositionLocal) r12
            r13 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r1 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r4, r13, r1)
            java.lang.Object r12 = r4.consume(r12)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r4)
            r7 = r12
            androidx.compose.ui.unit.Density r7 = (androidx.compose.ui.unit.Density) r7
            java.lang.Boolean r12 = java.lang.Boolean.valueOf(r6)
            java.lang.Boolean r13 = java.lang.Boolean.valueOf(r10)
            java.lang.Object[] r12 = new java.lang.Object[]{r12, r9, r13}
            androidx.compose.material3.SheetState$Companion r13 = androidx.compose.material3.SheetState.Companion
            androidx.compose.runtime.saveable.Saver r1 = r13.Saver(r6, r9, r7, r10)
            r13 = -349419818(0xffffffffeb2c46d6, float:-2.0826975E26)
            java.lang.String r2 = "CC(remember):SheetDefaults.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r4, r13, r2)
            r13 = r0 & 14
            r13 = r13 ^ 6
            r2 = 4
            r5 = 1
            if (r13 <= r2) goto L_0x007a
            boolean r13 = r4.changed((boolean) r6)
            if (r13 != 0) goto L_0x007e
        L_0x007a:
            r13 = r0 & 6
            if (r13 != r2) goto L_0x0080
        L_0x007e:
            r13 = r5
            goto L_0x0081
        L_0x0080:
            r13 = r3
        L_0x0081:
            boolean r2 = r4.changed((java.lang.Object) r7)
            r13 = r13 | r2
            r2 = r0 & 896(0x380, float:1.256E-42)
            r2 = r2 ^ 384(0x180, float:5.38E-43)
            r11 = 256(0x100, float:3.59E-43)
            if (r2 <= r11) goto L_0x0094
            boolean r2 = r4.changed((java.lang.Object) r8)
            if (r2 != 0) goto L_0x0098
        L_0x0094:
            r2 = r0 & 384(0x180, float:5.38E-43)
            if (r2 != r11) goto L_0x009a
        L_0x0098:
            r2 = r5
            goto L_0x009b
        L_0x009a:
            r2 = r3
        L_0x009b:
            r13 = r13 | r2
            r2 = r0 & 112(0x70, float:1.57E-43)
            r2 = r2 ^ 48
            r11 = 32
            if (r2 <= r11) goto L_0x00aa
            boolean r2 = r4.changed((java.lang.Object) r9)
            if (r2 != 0) goto L_0x00ae
        L_0x00aa:
            r2 = r0 & 48
            if (r2 != r11) goto L_0x00b0
        L_0x00ae:
            r2 = r5
            goto L_0x00b1
        L_0x00b0:
            r2 = r3
        L_0x00b1:
            r13 = r13 | r2
            r2 = r0 & 7168(0x1c00, float:1.0045E-41)
            r2 = r2 ^ 3072(0xc00, float:4.305E-42)
            r11 = 2048(0x800, float:2.87E-42)
            if (r2 <= r11) goto L_0x00c0
            boolean r2 = r4.changed((boolean) r10)
            if (r2 != 0) goto L_0x00c4
        L_0x00c0:
            r0 = r0 & 3072(0xc00, float:4.305E-42)
            if (r0 != r11) goto L_0x00c5
        L_0x00c4:
            r3 = r5
        L_0x00c5:
            r13 = r13 | r3
            java.lang.Object r0 = r4.rememberedValue()
            if (r13 != 0) goto L_0x00d4
            androidx.compose.runtime.Composer$Companion r13 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r13 = r13.getEmpty()
            if (r0 != r13) goto L_0x00df
        L_0x00d4:
            androidx.compose.material3.SheetDefaultsKt$rememberSheetState$2$1 r5 = new androidx.compose.material3.SheetDefaultsKt$rememberSheetState$2$1
            r5.<init>(r6, r7, r8, r9, r10)
            r0 = r5
            kotlin.jvm.functions.Function0 r0 = (kotlin.jvm.functions.Function0) r0
            r4.updateRememberedValue(r0)
        L_0x00df:
            r3 = r0
            kotlin.jvm.functions.Function0 r3 = (kotlin.jvm.functions.Function0) r3
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r4)
            r5 = 0
            r6 = 4
            r2 = 0
            r0 = r12
            java.lang.Object r12 = androidx.compose.runtime.saveable.RememberSaveableKt.rememberSaveable((java.lang.Object[]) r0, r1, (java.lang.String) r2, r3, (androidx.compose.runtime.Composer) r4, (int) r5, (int) r6)
            androidx.compose.material3.SheetState r12 = (androidx.compose.material3.SheetState) r12
            boolean r13 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r13 == 0) goto L_0x00f8
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x00f8:
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r16)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SheetDefaultsKt.rememberSheetState(boolean, kotlin.jvm.functions.Function1, androidx.compose.material3.SheetValue, boolean, androidx.compose.runtime.Composer, int, int):androidx.compose.material3.SheetState");
    }
}
