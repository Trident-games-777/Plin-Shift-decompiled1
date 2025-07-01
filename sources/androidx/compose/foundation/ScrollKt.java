package androidx.compose.foundation;

import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u0017\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0004\u001a2\u0010\u0005\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00012\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\t\u001a6\u0010\r\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\tH\u0002\u001a2\u0010\u0010\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00012\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\t¨\u0006\u0011"}, d2 = {"rememberScrollState", "Landroidx/compose/foundation/ScrollState;", "initial", "", "(ILandroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/ScrollState;", "horizontalScroll", "Landroidx/compose/ui/Modifier;", "state", "enabled", "", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "reverseScrolling", "scroll", "isScrollable", "isVertical", "verticalScroll", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Scroll.kt */
public final class ScrollKt {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v0, resolved type: kotlin.jvm.functions.Function0} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final androidx.compose.foundation.ScrollState rememberScrollState(int r11, androidx.compose.runtime.Composer r12, int r13, int r14) {
        /*
            java.lang.String r0 = "C(rememberScrollState)70@3262L46,70@3218L90:Scroll.kt#71ulvw"
            r1 = -1464256199(0xffffffffa8b93939, float:-2.0563942E-14)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r12, r1, r0)
            r0 = 1
            r14 = r14 & r0
            r2 = 0
            if (r14 == 0) goto L_0x000e
            r11 = r2
        L_0x000e:
            boolean r14 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r14 == 0) goto L_0x001a
            r14 = -1
            java.lang.String r3 = "androidx.compose.foundation.rememberScrollState (Scroll.kt:69)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r1, r13, r14, r3)
        L_0x001a:
            java.lang.Object[] r4 = new java.lang.Object[r2]
            androidx.compose.foundation.ScrollState$Companion r14 = androidx.compose.foundation.ScrollState.Companion
            androidx.compose.runtime.saveable.Saver r5 = r14.getSaver()
            r14 = -506669717(0xffffffffe1ccd56b, float:-4.7231427E20)
            java.lang.String r1 = "CC(remember):Scroll.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r12, r14, r1)
            r14 = r13 & 14
            r14 = r14 ^ 6
            r1 = 4
            if (r14 <= r1) goto L_0x0037
            boolean r14 = r12.changed((int) r11)
            if (r14 != 0) goto L_0x003d
        L_0x0037:
            r13 = r13 & 6
            if (r13 != r1) goto L_0x003c
            goto L_0x003d
        L_0x003c:
            r0 = r2
        L_0x003d:
            java.lang.Object r13 = r12.rememberedValue()
            if (r0 != 0) goto L_0x004b
            androidx.compose.runtime.Composer$Companion r14 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r14 = r14.getEmpty()
            if (r13 != r14) goto L_0x0055
        L_0x004b:
            androidx.compose.foundation.ScrollKt$rememberScrollState$1$1 r13 = new androidx.compose.foundation.ScrollKt$rememberScrollState$1$1
            r13.<init>(r11)
            kotlin.jvm.functions.Function0 r13 = (kotlin.jvm.functions.Function0) r13
            r12.updateRememberedValue(r13)
        L_0x0055:
            r7 = r13
            kotlin.jvm.functions.Function0 r7 = (kotlin.jvm.functions.Function0) r7
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r12)
            r9 = 0
            r10 = 4
            r6 = 0
            r8 = r12
            java.lang.Object r11 = androidx.compose.runtime.saveable.RememberSaveableKt.rememberSaveable((java.lang.Object[]) r4, r5, (java.lang.String) r6, r7, (androidx.compose.runtime.Composer) r8, (int) r9, (int) r10)
            androidx.compose.foundation.ScrollState r11 = (androidx.compose.foundation.ScrollState) r11
            boolean r12 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r12 == 0) goto L_0x006e
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x006e:
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r8)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.ScrollKt.rememberScrollState(int, androidx.compose.runtime.Composer, int, int):androidx.compose.foundation.ScrollState");
    }

    public static /* synthetic */ Modifier verticalScroll$default(Modifier modifier, ScrollState scrollState, boolean z, FlingBehavior flingBehavior, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        if ((i & 4) != 0) {
            flingBehavior = null;
        }
        if ((i & 8) != 0) {
            z2 = false;
        }
        return verticalScroll(modifier, scrollState, z, flingBehavior, z2);
    }

    public static final Modifier verticalScroll(Modifier modifier, ScrollState scrollState, boolean z, FlingBehavior flingBehavior, boolean z2) {
        return scroll(modifier, scrollState, z2, flingBehavior, z, true);
    }

    public static /* synthetic */ Modifier horizontalScroll$default(Modifier modifier, ScrollState scrollState, boolean z, FlingBehavior flingBehavior, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        if ((i & 4) != 0) {
            flingBehavior = null;
        }
        if ((i & 8) != 0) {
            z2 = false;
        }
        return horizontalScroll(modifier, scrollState, z, flingBehavior, z2);
    }

    public static final Modifier horizontalScroll(Modifier modifier, ScrollState scrollState, boolean z, FlingBehavior flingBehavior, boolean z2) {
        return scroll(modifier, scrollState, z2, flingBehavior, z, false);
    }

    private static final Modifier scroll(Modifier modifier, ScrollState scrollState, boolean z, FlingBehavior flingBehavior, boolean z2, boolean z3) {
        boolean z4;
        boolean z5;
        FlingBehavior flingBehavior2;
        boolean z6;
        ScrollState scrollState2;
        Function1<InspectorInfo, Unit> function1;
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            scrollState2 = scrollState;
            z6 = z;
            flingBehavior2 = flingBehavior;
            z5 = z2;
            z4 = z3;
            function1 = new ScrollKt$scroll$$inlined$debugInspectorInfo$1(scrollState2, z6, flingBehavior2, z5, z4);
        } else {
            scrollState2 = scrollState;
            z6 = z;
            flingBehavior2 = flingBehavior;
            z5 = z2;
            z4 = z3;
            function1 = InspectableValueKt.getNoInspectorInfo();
        }
        boolean z7 = z4;
        boolean z8 = z5;
        FlingBehavior flingBehavior3 = flingBehavior2;
        return ComposedModifierKt.composed(modifier, function1, new ScrollKt$scroll$2(scrollState2, z6, flingBehavior3, z8, z7));
    }
}
