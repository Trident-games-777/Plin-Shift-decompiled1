package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.unit.DensityKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.CoroutineScopeKt;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a!\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0007\u001a+\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0002\u0010\n\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"EmptyLazyGridLayoutInfo", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasureResult;", "rememberLazyGridState", "Landroidx/compose/foundation/lazy/grid/LazyGridState;", "initialFirstVisibleItemIndex", "", "initialFirstVisibleItemScrollOffset", "(IILandroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/lazy/grid/LazyGridState;", "prefetchStrategy", "Landroidx/compose/foundation/lazy/grid/LazyGridPrefetchStrategy;", "(IILandroidx/compose/foundation/lazy/grid/LazyGridPrefetchStrategy;Landroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/lazy/grid/LazyGridState;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyGridState.kt */
public final class LazyGridStateKt {
    /* access modifiers changed from: private */
    public static final LazyGridMeasureResult EmptyLazyGridLayoutInfo;

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: kotlin.jvm.functions.Function0} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final androidx.compose.foundation.lazy.grid.LazyGridState rememberLazyGridState(int r10, int r11, androidx.compose.runtime.Composer r12, int r13, int r14) {
        /*
            java.lang.String r0 = "C(rememberLazyGridState)72@3315L130,72@3269L176:LazyGridState.kt#7791vq"
            r1 = 29186956(0x1bd5b8c, float:6.9559E-38)
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
            java.lang.String r0 = "androidx.compose.foundation.lazy.grid.rememberLazyGridState (LazyGridState.kt:71)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r1, r13, r14, r0)
        L_0x001f:
            java.lang.Object[] r3 = new java.lang.Object[r2]
            androidx.compose.foundation.lazy.grid.LazyGridState$Companion r14 = androidx.compose.foundation.lazy.grid.LazyGridState.Companion
            androidx.compose.runtime.saveable.Saver r4 = r14.getSaver()
            r14 = -890212988(0xffffffffcaf06d84, float:-7878338.0)
            java.lang.String r0 = "CC(remember):LazyGridState.kt#9igjgp"
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
            androidx.compose.foundation.lazy.grid.LazyGridStateKt$rememberLazyGridState$1$1 r13 = new androidx.compose.foundation.lazy.grid.LazyGridStateKt$rememberLazyGridState$1$1
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
            androidx.compose.foundation.lazy.grid.LazyGridState r10 = (androidx.compose.foundation.lazy.grid.LazyGridState) r10
            boolean r11 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r11 == 0) goto L_0x008b
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x008b:
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r7)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.grid.LazyGridStateKt.rememberLazyGridState(int, int, androidx.compose.runtime.Composer, int, int):androidx.compose.foundation.lazy.grid.LazyGridState");
    }

    public static final LazyGridState rememberLazyGridState(int i, int i2, LazyGridPrefetchStrategy lazyGridPrefetchStrategy, Composer composer, int i3, int i4) {
        LazyGridPrefetchStrategy lazyGridPrefetchStrategy2;
        int i5 = i3;
        ComposerKt.sourceInformationMarkerStart(composer, -20335728, "C(rememberLazyGridState)97@4208L39,99@4361L161,99@4279L243:LazyGridState.kt#7791vq");
        boolean z = false;
        int i6 = (i4 & 1) != 0 ? 0 : i;
        int i7 = (i4 & 2) != 0 ? 0 : i2;
        if ((i4 & 4) != 0) {
            ComposerKt.sourceInformationMarkerStart(composer, -890184503, "CC(remember):LazyGridState.kt#9igjgp");
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = LazyGridPrefetchStrategyKt.LazyGridPrefetchStrategy$default(0, 1, (Object) null);
                composer.updateRememberedValue(rememberedValue);
            }
            lazyGridPrefetchStrategy2 = (LazyGridPrefetchStrategy) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
        } else {
            lazyGridPrefetchStrategy2 = lazyGridPrefetchStrategy;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-20335728, i5, -1, "androidx.compose.foundation.lazy.grid.rememberLazyGridState (LazyGridState.kt:98)");
        }
        Object[] objArr = {lazyGridPrefetchStrategy2};
        Saver<LazyGridState, ?> saver$foundation_release = LazyGridState.Companion.saver$foundation_release(lazyGridPrefetchStrategy2);
        ComposerKt.sourceInformationMarkerStart(composer, -890179485, "CC(remember):LazyGridState.kt#9igjgp");
        boolean z2 = ((((i5 & 14) ^ 6) > 4 && composer.changed(i6)) || (i5 & 6) == 4) | ((((i5 & 112) ^ 48) > 32 && composer.changed(i7)) || (i5 & 48) == 32);
        if ((((i5 & 896) ^ 384) > 256 && composer.changedInstance(lazyGridPrefetchStrategy2)) || (i5 & 384) == 256) {
            z = true;
        }
        boolean z3 = z2 | z;
        Object rememberedValue2 = composer.rememberedValue();
        if (z3 || rememberedValue2 == Composer.Companion.getEmpty()) {
            rememberedValue2 = new LazyGridStateKt$rememberLazyGridState$3$1(i6, i7, lazyGridPrefetchStrategy2);
            composer.updateRememberedValue(rememberedValue2);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        LazyGridState lazyGridState = (LazyGridState) RememberSaveableKt.rememberSaveable(objArr, saver$foundation_release, (String) null, (Function0) rememberedValue2, composer, 0, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return lazyGridState;
    }

    static {
        LazyGridStateKt$EmptyLazyGridLayoutInfo$1 lazyGridStateKt$EmptyLazyGridLayoutInfo$1 = new LazyGridStateKt$EmptyLazyGridLayoutInfo$1();
        List emptyList = CollectionsKt.emptyList();
        Orientation orientation = Orientation.Vertical;
        MeasureResult measureResult = lazyGridStateKt$EmptyLazyGridLayoutInfo$1;
        EmptyLazyGridLayoutInfo = new LazyGridMeasureResult((LazyGridMeasuredLine) null, 0, false, 0.0f, measureResult, false, CoroutineScopeKt.CoroutineScope(EmptyCoroutineContext.INSTANCE), DensityKt.Density$default(1.0f, 0.0f, 2, (Object) null), 0, LazyGridStateKt$EmptyLazyGridLayoutInfo$2.INSTANCE, emptyList, 0, 0, 0, false, orientation, 0, 0);
    }
}
