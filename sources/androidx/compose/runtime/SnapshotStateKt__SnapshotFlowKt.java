package androidx.compose.runtime;

import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.StateFlow;

@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\"\n\u0002\b\u0002\u001a \u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004\u001a?\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0006\"\b\b\u0000\u0010\u0002*\u0002H\u0007\"\u0004\b\u0001\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\b\u001a\u0002H\u00072\b\b\u0002\u0010\t\u001a\u00020\nH\u0007¢\u0006\u0002\u0010\u000b\u001a-\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0006\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\f2\b\b\u0002\u0010\t\u001a\u00020\nH\u0007¢\u0006\u0002\u0010\r\u001a%\u0010\u000e\u001a\u00020\u000f*\b\u0012\u0004\u0012\u00020\u00110\u00102\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0013H\u0002¢\u0006\u0002\b\u0014¨\u0006\u0015"}, d2 = {"snapshotFlow", "Lkotlinx/coroutines/flow/Flow;", "T", "block", "Lkotlin/Function0;", "collectAsState", "Landroidx/compose/runtime/State;", "R", "initial", "context", "Lkotlin/coroutines/CoroutineContext;", "(Lkotlinx/coroutines/flow/Flow;Ljava/lang/Object;Lkotlin/coroutines/CoroutineContext;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "Lkotlinx/coroutines/flow/StateFlow;", "(Lkotlinx/coroutines/flow/StateFlow;Lkotlin/coroutines/CoroutineContext;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "intersects", "", "Landroidx/collection/MutableScatterSet;", "", "set", "", "intersects$SnapshotStateKt__SnapshotFlowKt", "runtime_release"}, k = 5, mv = {1, 8, 0}, xi = 48, xs = "androidx/compose/runtime/SnapshotStateKt")
/* compiled from: SnapshotFlow.kt */
final /* synthetic */ class SnapshotStateKt__SnapshotFlowKt {
    public static final <T> State<T> collectAsState(StateFlow<? extends T> stateFlow, CoroutineContext coroutineContext, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -1439883919, "C(collectAsState)49@1909L30:SnapshotFlow.kt#9igjgp");
        if ((i2 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        CoroutineContext coroutineContext2 = coroutineContext;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1439883919, i, -1, "androidx.compose.runtime.collectAsState (SnapshotFlow.kt:49)");
        }
        Composer composer2 = composer;
        State<T> collectAsState = SnapshotStateKt.collectAsState(stateFlow, stateFlow.getValue(), coroutineContext2, composer2, (i & 14) | ((i << 3) & 896), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer2);
        return collectAsState;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v0, resolved type: kotlin.jvm.functions.Function2} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T extends R, R> androidx.compose.runtime.State<R> collectAsState(kotlinx.coroutines.flow.Flow<? extends T> r8, R r9, kotlin.coroutines.CoroutineContext r10, androidx.compose.runtime.Composer r11, int r12, int r13) {
        /*
            java.lang.String r0 = "C(collectAsState)P(1)65@2578L149,65@2541L186:SnapshotFlow.kt#9igjgp"
            r1 = -606625098(0xffffffffdbd7a2b6, float:-1.21392045E17)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r11, r1, r0)
            r13 = r13 & 2
            if (r13 == 0) goto L_0x0010
            kotlin.coroutines.EmptyCoroutineContext r10 = kotlin.coroutines.EmptyCoroutineContext.INSTANCE
            kotlin.coroutines.CoroutineContext r10 = (kotlin.coroutines.CoroutineContext) r10
        L_0x0010:
            r4 = r10
            boolean r10 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r10 == 0) goto L_0x001d
            r10 = -1
            java.lang.String r13 = "androidx.compose.runtime.collectAsState (SnapshotFlow.kt:65)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r1, r12, r10, r13)
        L_0x001d:
            r10 = -498556383(0xffffffffe248a221, float:-9.2525786E20)
            java.lang.String r13 = "CC(remember):SnapshotFlow.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r11, r10, r13)
            boolean r10 = r11.changedInstance(r4)
            boolean r13 = r11.changedInstance(r8)
            r10 = r10 | r13
            java.lang.Object r13 = r11.rememberedValue()
            if (r10 != 0) goto L_0x003c
            androidx.compose.runtime.Composer$Companion r10 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r10 = r10.getEmpty()
            if (r13 != r10) goto L_0x0048
        L_0x003c:
            androidx.compose.runtime.SnapshotStateKt__SnapshotFlowKt$collectAsState$1$1 r10 = new androidx.compose.runtime.SnapshotStateKt__SnapshotFlowKt$collectAsState$1$1
            r13 = 0
            r10.<init>(r4, r8, r13)
            r13 = r10
            kotlin.jvm.functions.Function2 r13 = (kotlin.jvm.functions.Function2) r13
            r11.updateRememberedValue(r13)
        L_0x0048:
            r5 = r13
            kotlin.jvm.functions.Function2 r5 = (kotlin.jvm.functions.Function2) r5
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r11)
            int r10 = r12 >> 3
            r10 = r10 & 14
            int r13 = r12 << 3
            r13 = r13 & 112(0x70, float:1.57E-43)
            r10 = r10 | r13
            r12 = r12 & 896(0x380, float:1.256E-42)
            r7 = r10 | r12
            r3 = r8
            r2 = r9
            r6 = r11
            androidx.compose.runtime.State r8 = androidx.compose.runtime.SnapshotStateKt.produceState(r2, r3, r4, r5, r6, r7)
            boolean r9 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r9 == 0) goto L_0x006b
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x006b:
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r6)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.SnapshotStateKt__SnapshotFlowKt.collectAsState(kotlinx.coroutines.flow.Flow, java.lang.Object, kotlin.coroutines.CoroutineContext, androidx.compose.runtime.Composer, int, int):androidx.compose.runtime.State");
    }

    public static final <T> Flow<T> snapshotFlow(Function0<? extends T> function0) {
        return FlowKt.flow(new SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1(function0, (Continuation<? super SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1>) null));
    }

    /* access modifiers changed from: private */
    public static final boolean intersects$SnapshotStateKt__SnapshotFlowKt(MutableScatterSet<Object> mutableScatterSet, Set<? extends Object> set) {
        ScatterSet scatterSet = mutableScatterSet;
        Object[] objArr = scatterSet.elements;
        long[] jArr = scatterSet.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i = 0;
            while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & -9187201950435737472L) != -9187201950435737472L) {
                    int i2 = 8 - ((~(i - length)) >>> 31);
                    for (int i3 = 0; i3 < i2; i3++) {
                        if ((255 & j) < 128 && set.contains(objArr[(i << 3) + i3])) {
                            return true;
                        }
                        j >>= 8;
                    }
                    if (i2 != 8) {
                        break;
                    }
                }
                if (i == length) {
                    break;
                }
                i++;
            }
        }
        return false;
    }
}
