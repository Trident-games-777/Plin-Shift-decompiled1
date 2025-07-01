package androidx.compose.foundation.lazy;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.DensityKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScopeKt;

@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a!\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u0006H\u0007¢\u0006\u0002\u0010\u000b\u001a+\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\rH\u0007¢\u0006\u0002\u0010\u000e\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"DeltaThresholdForScrollAnimation", "Landroidx/compose/ui/unit/Dp;", "F", "EmptyLazyListMeasureResult", "Landroidx/compose/foundation/lazy/LazyListMeasureResult;", "NumberOfItemsToTeleport", "", "rememberLazyListState", "Landroidx/compose/foundation/lazy/LazyListState;", "initialFirstVisibleItemIndex", "initialFirstVisibleItemScrollOffset", "(IILandroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/lazy/LazyListState;", "prefetchStrategy", "Landroidx/compose/foundation/lazy/LazyListPrefetchStrategy;", "(IILandroidx/compose/foundation/lazy/LazyListPrefetchStrategy;Landroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/lazy/LazyListState;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyListState.kt */
public final class LazyListStateKt {
    /* access modifiers changed from: private */
    public static final float DeltaThresholdForScrollAnimation = Dp.m7111constructorimpl((float) 1);
    /* access modifiers changed from: private */
    public static final LazyListMeasureResult EmptyLazyListMeasureResult;
    private static final int NumberOfItemsToTeleport = 100;

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: kotlin.jvm.functions.Function0} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final androidx.compose.foundation.lazy.LazyListState rememberLazyListState(int r10, int r11, androidx.compose.runtime.Composer r12, int r13, int r14) {
        /*
            java.lang.String r0 = "C(rememberLazyListState)81@3758L130,81@3712L176:LazyListState.kt#428nma"
            r1 = 1470655220(0x57a86af4, float:3.70354627E14)
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
            java.lang.String r0 = "androidx.compose.foundation.lazy.rememberLazyListState (LazyListState.kt:80)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r1, r13, r14, r0)
        L_0x001f:
            java.lang.Object[] r3 = new java.lang.Object[r2]
            androidx.compose.foundation.lazy.LazyListState$Companion r14 = androidx.compose.foundation.lazy.LazyListState.Companion
            androidx.compose.runtime.saveable.Saver r4 = r14.getSaver()
            r14 = -61897676(0xfffffffffc4f8434, float:-4.3099474E36)
            java.lang.String r0 = "CC(remember):LazyListState.kt#9igjgp"
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
            androidx.compose.foundation.lazy.LazyListStateKt$rememberLazyListState$1$1 r13 = new androidx.compose.foundation.lazy.LazyListStateKt$rememberLazyListState$1$1
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
            androidx.compose.foundation.lazy.LazyListState r10 = (androidx.compose.foundation.lazy.LazyListState) r10
            boolean r11 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r11 == 0) goto L_0x008b
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x008b:
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r7)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.LazyListStateKt.rememberLazyListState(int, int, androidx.compose.runtime.Composer, int, int):androidx.compose.foundation.lazy.LazyListState");
    }

    public static final LazyListState rememberLazyListState(int i, int i2, LazyListPrefetchStrategy lazyListPrefetchStrategy, Composer composer, int i3, int i4) {
        LazyListPrefetchStrategy lazyListPrefetchStrategy2;
        int i5 = i3;
        ComposerKt.sourceInformationMarkerStart(composer, 1287535208, "C(rememberLazyListState)106@4651L39,108@4804L160,108@4722L242:LazyListState.kt#428nma");
        boolean z = false;
        int i6 = (i4 & 1) != 0 ? 0 : i;
        int i7 = (i4 & 2) != 0 ? 0 : i2;
        if ((i4 & 4) != 0) {
            ComposerKt.sourceInformationMarkerStart(composer, -61869191, "CC(remember):LazyListState.kt#9igjgp");
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = LazyListPrefetchStrategyKt.LazyListPrefetchStrategy$default(0, 1, (Object) null);
                composer.updateRememberedValue(rememberedValue);
            }
            lazyListPrefetchStrategy2 = (LazyListPrefetchStrategy) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
        } else {
            lazyListPrefetchStrategy2 = lazyListPrefetchStrategy;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1287535208, i5, -1, "androidx.compose.foundation.lazy.rememberLazyListState (LazyListState.kt:107)");
        }
        Object[] objArr = {lazyListPrefetchStrategy2};
        Saver<LazyListState, ?> saver$foundation_release = LazyListState.Companion.saver$foundation_release(lazyListPrefetchStrategy2);
        ComposerKt.sourceInformationMarkerStart(composer, -61864174, "CC(remember):LazyListState.kt#9igjgp");
        boolean z2 = ((((i5 & 14) ^ 6) > 4 && composer.changed(i6)) || (i5 & 6) == 4) | ((((i5 & 112) ^ 48) > 32 && composer.changed(i7)) || (i5 & 48) == 32);
        if ((((i5 & 896) ^ 384) > 256 && composer.changedInstance(lazyListPrefetchStrategy2)) || (i5 & 384) == 256) {
            z = true;
        }
        boolean z3 = z2 | z;
        Object rememberedValue2 = composer.rememberedValue();
        if (z3 || rememberedValue2 == Composer.Companion.getEmpty()) {
            rememberedValue2 = new LazyListStateKt$rememberLazyListState$3$1(i6, i7, lazyListPrefetchStrategy2);
            composer.updateRememberedValue(rememberedValue2);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        LazyListState lazyListState = (LazyListState) RememberSaveableKt.rememberSaveable(objArr, saver$foundation_release, (String) null, (Function0) rememberedValue2, composer, 0, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return lazyListState;
    }

    static {
        LazyListStateKt$EmptyLazyListMeasureResult$1 lazyListStateKt$EmptyLazyListMeasureResult$1 = new LazyListStateKt$EmptyLazyListMeasureResult$1();
        MeasureResult measureResult = lazyListStateKt$EmptyLazyListMeasureResult$1;
        EmptyLazyListMeasureResult = new LazyListMeasureResult((LazyListMeasuredItem) null, 0, false, 0.0f, measureResult, 0.0f, false, CoroutineScopeKt.CoroutineScope(EmptyCoroutineContext.INSTANCE), DensityKt.Density$default(1.0f, 0.0f, 2, (Object) null), ConstraintsKt.Constraints$default(0, 0, 0, 0, 15, (Object) null), CollectionsKt.emptyList(), 0, 0, 0, false, Orientation.Vertical, 0, 0, (DefaultConstructorMarker) null);
    }
}
