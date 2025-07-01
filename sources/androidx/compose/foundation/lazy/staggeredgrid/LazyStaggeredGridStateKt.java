package androidx.compose.foundation.lazy.staggeredgrid;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u001a!\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"rememberLazyStaggeredGridState", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;", "initialFirstVisibleItemIndex", "", "initialFirstVisibleItemScrollOffset", "(IILandroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyStaggeredGridState.kt */
public final class LazyStaggeredGridStateKt {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: kotlin.jvm.functions.Function0} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState rememberLazyStaggeredGridState(int r10, int r11, androidx.compose.runtime.Composer r12, int r13, int r14) {
        /*
            java.lang.String r0 = "C(rememberLazyStaggeredGridState)73@3626L139,73@3571L194:LazyStaggeredGridState.kt#fzvcnm"
            r1 = 161145796(0x99ae3c4, float:3.728834E-33)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r12, r1, r0)
            r0 = r14 & 1
            r2 = 0
            if (r0 == 0) goto L_0x000e
            r10 = r2
        L_0x000e:
            r14 = r14 & 2
            if (r14 == 0) goto L_0x0013
            r11 = r2
        L_0x0013:
            boolean r14 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r14 == 0) goto L_0x001f
            r14 = -1
            java.lang.String r0 = "androidx.compose.foundation.lazy.staggeredgrid.rememberLazyStaggeredGridState (LazyStaggeredGridState.kt:73)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r1, r13, r14, r0)
        L_0x001f:
            java.lang.Object[] r3 = new java.lang.Object[r2]
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState$Companion r14 = androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState.Companion
            androidx.compose.runtime.saveable.Saver r4 = r14.getSaver()
            r14 = -1334922713(0xffffffffb06eb227, float:-8.6837065E-10)
            java.lang.String r0 = "CC(remember):LazyStaggeredGridState.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r12, r14, r0)
            r14 = r13 & 14
            r14 = r14 ^ 6
            r0 = 4
            r1 = 1
            if (r14 <= r0) goto L_0x003d
            boolean r14 = r12.changed((int) r10)
            if (r14 != 0) goto L_0x0041
        L_0x003d:
            r14 = r13 & 6
            if (r14 != r0) goto L_0x0043
        L_0x0041:
            r14 = r1
            goto L_0x0044
        L_0x0043:
            r14 = r2
        L_0x0044:
            r0 = r13 & 112(0x70, float:1.57E-43)
            r0 = r0 ^ 48
            r5 = 32
            if (r0 <= r5) goto L_0x0052
            boolean r0 = r12.changed((int) r11)
            if (r0 != 0) goto L_0x0056
        L_0x0052:
            r13 = r13 & 48
            if (r13 != r5) goto L_0x0057
        L_0x0056:
            r2 = r1
        L_0x0057:
            r13 = r14 | r2
            java.lang.Object r14 = r12.rememberedValue()
            if (r13 != 0) goto L_0x0067
            androidx.compose.runtime.Composer$Companion r13 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r13 = r13.getEmpty()
            if (r14 != r13) goto L_0x0072
        L_0x0067:
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridStateKt$rememberLazyStaggeredGridState$1$1 r13 = new androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridStateKt$rememberLazyStaggeredGridState$1$1
            r13.<init>(r10, r11)
            r14 = r13
            kotlin.jvm.functions.Function0 r14 = (kotlin.jvm.functions.Function0) r14
            r12.updateRememberedValue(r14)
        L_0x0072:
            r6 = r14
            kotlin.jvm.functions.Function0 r6 = (kotlin.jvm.functions.Function0) r6
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r12)
            r8 = 0
            r9 = 4
            r5 = 0
            r7 = r12
            java.lang.Object r10 = androidx.compose.runtime.saveable.RememberSaveableKt.rememberSaveable((java.lang.Object[]) r3, r4, (java.lang.String) r5, r6, (androidx.compose.runtime.Composer) r7, (int) r8, (int) r9)
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState r10 = (androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState) r10
            boolean r11 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r11 == 0) goto L_0x008b
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x008b:
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r7)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(int, int, androidx.compose.runtime.Composer, int, int):androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState");
    }
}
