package androidx.compose.material3;

import androidx.activity.BackEventCompat;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0011\u0010\u0002\u001a\r\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\b\u0005H@"}, d2 = {"<anonymous>", "", "progress", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/activity/BackEventCompat;", "Lkotlin/jvm/JvmSuppressWildcards;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.material3.NavigationDrawer_androidKt$DrawerPredictiveBackHandler$2$1", f = "NavigationDrawer.android.kt", i = {}, l = {60, 86, 86, 86}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: NavigationDrawer.android.kt */
final class NavigationDrawer_androidKt$DrawerPredictiveBackHandler$2$1 extends SuspendLambda implements Function2<Flow<BackEventCompat>, Continuation<? super Unit>, Object> {
    final /* synthetic */ DrawerPredictiveBackState $drawerPredictiveBackState;
    final /* synthetic */ DrawerState $drawerState;
    final /* synthetic */ boolean $isRtl;
    final /* synthetic */ Ref.FloatRef $maxScaleXDistanceGrow;
    final /* synthetic */ Ref.FloatRef $maxScaleXDistanceShrink;
    final /* synthetic */ Ref.FloatRef $maxScaleYDistance;
    final /* synthetic */ CoroutineScope $scope;
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NavigationDrawer_androidKt$DrawerPredictiveBackHandler$2$1(DrawerPredictiveBackState drawerPredictiveBackState, CoroutineScope coroutineScope, DrawerState drawerState, boolean z, Ref.FloatRef floatRef, Ref.FloatRef floatRef2, Ref.FloatRef floatRef3, Continuation<? super NavigationDrawer_androidKt$DrawerPredictiveBackHandler$2$1> continuation) {
        super(2, continuation);
        this.$drawerPredictiveBackState = drawerPredictiveBackState;
        this.$scope = coroutineScope;
        this.$drawerState = drawerState;
        this.$isRtl = z;
        this.$maxScaleXDistanceGrow = floatRef;
        this.$maxScaleXDistanceShrink = floatRef2;
        this.$maxScaleYDistance = floatRef3;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        NavigationDrawer_androidKt$DrawerPredictiveBackHandler$2$1 navigationDrawer_androidKt$DrawerPredictiveBackHandler$2$1 = new NavigationDrawer_androidKt$DrawerPredictiveBackHandler$2$1(this.$drawerPredictiveBackState, this.$scope, this.$drawerState, this.$isRtl, this.$maxScaleXDistanceGrow, this.$maxScaleXDistanceShrink, this.$maxScaleYDistance, continuation);
        navigationDrawer_androidKt$DrawerPredictiveBackHandler$2$1.L$0 = obj;
        return navigationDrawer_androidKt$DrawerPredictiveBackHandler$2$1;
    }

    public final Object invoke(Flow<BackEventCompat> flow, Continuation<? super Unit> continuation) {
        return ((NavigationDrawer_androidKt$DrawerPredictiveBackHandler$2$1) create(flow, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0054, code lost:
        if (r14.collect(new androidx.compose.material3.NavigationDrawer_androidKt$DrawerPredictiveBackHandler$2$1.AnonymousClass1(), r13) == r1) goto L_0x00dc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x007e, code lost:
        if (r13.$drawerState.close(r13) == r1) goto L_0x00dc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00ac, code lost:
        if (r13.$drawerState.close(r13) == r1) goto L_0x00dc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00da, code lost:
        if (r13.$drawerState.close(r13) != r1) goto L_0x00dd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00dc, code lost:
        return r1;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0081 */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x008e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r14) {
        /*
            r13 = this;
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r0 = r13.label
            r2 = 4
            r3 = 3
            r4 = 2
            r5 = 1
            r6 = 0
            if (r0 == 0) goto L_0x0033
            if (r0 == r5) goto L_0x002b
            if (r0 == r4) goto L_0x0026
            if (r0 == r3) goto L_0x0026
            if (r0 == r2) goto L_0x001d
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r0)
            throw r14
        L_0x001d:
            java.lang.Object r0 = r13.L$0
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            kotlin.ResultKt.throwOnFailure(r14)
            goto L_0x00dd
        L_0x0026:
            kotlin.ResultKt.throwOnFailure(r14)
            goto L_0x00af
        L_0x002b:
            kotlin.ResultKt.throwOnFailure(r14)     // Catch:{ CancellationException -> 0x0081 }
            goto L_0x0058
        L_0x002f:
            r0 = move-exception
            r14 = r0
            goto L_0x00b2
        L_0x0033:
            kotlin.ResultKt.throwOnFailure(r14)
            java.lang.Object r14 = r13.L$0
            kotlinx.coroutines.flow.Flow r14 = (kotlinx.coroutines.flow.Flow) r14
            androidx.compose.material3.NavigationDrawer_androidKt$DrawerPredictiveBackHandler$2$1$1 r7 = new androidx.compose.material3.NavigationDrawer_androidKt$DrawerPredictiveBackHandler$2$1$1     // Catch:{ CancellationException -> 0x0081 }
            androidx.compose.material3.DrawerPredictiveBackState r8 = r13.$drawerPredictiveBackState     // Catch:{ CancellationException -> 0x0081 }
            boolean r9 = r13.$isRtl     // Catch:{ CancellationException -> 0x0081 }
            kotlin.jvm.internal.Ref$FloatRef r10 = r13.$maxScaleXDistanceGrow     // Catch:{ CancellationException -> 0x0081 }
            kotlin.jvm.internal.Ref$FloatRef r11 = r13.$maxScaleXDistanceShrink     // Catch:{ CancellationException -> 0x0081 }
            kotlin.jvm.internal.Ref$FloatRef r12 = r13.$maxScaleYDistance     // Catch:{ CancellationException -> 0x0081 }
            r7.<init>(r8, r9, r10, r11, r12)     // Catch:{ CancellationException -> 0x0081 }
            kotlinx.coroutines.flow.FlowCollector r7 = (kotlinx.coroutines.flow.FlowCollector) r7     // Catch:{ CancellationException -> 0x0081 }
            r0 = r13
            kotlin.coroutines.Continuation r0 = (kotlin.coroutines.Continuation) r0     // Catch:{ CancellationException -> 0x0081 }
            r13.label = r5     // Catch:{ CancellationException -> 0x0081 }
            java.lang.Object r14 = r14.collect(r7, r0)     // Catch:{ CancellationException -> 0x0081 }
            if (r14 != r1) goto L_0x0058
            goto L_0x00dc
        L_0x0058:
            androidx.compose.material3.DrawerPredictiveBackState r14 = r13.$drawerPredictiveBackState
            boolean r14 = r14.getSwipeEdgeMatchesDrawer()
            if (r14 == 0) goto L_0x0073
            kotlinx.coroutines.CoroutineScope r7 = r13.$scope
            androidx.compose.material3.NavigationDrawer_androidKt$DrawerPredictiveBackHandler$2$1$2 r14 = new androidx.compose.material3.NavigationDrawer_androidKt$DrawerPredictiveBackHandler$2$1$2
            androidx.compose.material3.DrawerPredictiveBackState r0 = r13.$drawerPredictiveBackState
            r14.<init>(r0, r6)
            r10 = r14
            kotlin.jvm.functions.Function2 r10 = (kotlin.jvm.functions.Function2) r10
            r11 = 3
            r12 = 0
            r8 = 0
            r9 = 0
            kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r7, r8, r9, r10, r11, r12)
        L_0x0073:
            androidx.compose.material3.DrawerState r14 = r13.$drawerState
            r0 = r13
            kotlin.coroutines.Continuation r0 = (kotlin.coroutines.Continuation) r0
            r13.label = r4
            java.lang.Object r14 = r14.close(r0)
            if (r14 != r1) goto L_0x00af
            goto L_0x00dc
        L_0x0081:
            androidx.compose.material3.DrawerPredictiveBackState r14 = r13.$drawerPredictiveBackState     // Catch:{ all -> 0x002f }
            r14.clear()     // Catch:{ all -> 0x002f }
            androidx.compose.material3.DrawerPredictiveBackState r14 = r13.$drawerPredictiveBackState
            boolean r14 = r14.getSwipeEdgeMatchesDrawer()
            if (r14 == 0) goto L_0x00a1
            kotlinx.coroutines.CoroutineScope r7 = r13.$scope
            androidx.compose.material3.NavigationDrawer_androidKt$DrawerPredictiveBackHandler$2$1$2 r14 = new androidx.compose.material3.NavigationDrawer_androidKt$DrawerPredictiveBackHandler$2$1$2
            androidx.compose.material3.DrawerPredictiveBackState r0 = r13.$drawerPredictiveBackState
            r14.<init>(r0, r6)
            r10 = r14
            kotlin.jvm.functions.Function2 r10 = (kotlin.jvm.functions.Function2) r10
            r11 = 3
            r12 = 0
            r8 = 0
            r9 = 0
            kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r7, r8, r9, r10, r11, r12)
        L_0x00a1:
            androidx.compose.material3.DrawerState r14 = r13.$drawerState
            r0 = r13
            kotlin.coroutines.Continuation r0 = (kotlin.coroutines.Continuation) r0
            r13.label = r3
            java.lang.Object r14 = r14.close(r0)
            if (r14 != r1) goto L_0x00af
            goto L_0x00dc
        L_0x00af:
            kotlin.Unit r14 = kotlin.Unit.INSTANCE
            return r14
        L_0x00b2:
            androidx.compose.material3.DrawerPredictiveBackState r14 = r13.$drawerPredictiveBackState
            boolean r14 = r14.getSwipeEdgeMatchesDrawer()
            if (r14 == 0) goto L_0x00cd
            kotlinx.coroutines.CoroutineScope r7 = r13.$scope
            androidx.compose.material3.NavigationDrawer_androidKt$DrawerPredictiveBackHandler$2$1$2 r14 = new androidx.compose.material3.NavigationDrawer_androidKt$DrawerPredictiveBackHandler$2$1$2
            androidx.compose.material3.DrawerPredictiveBackState r3 = r13.$drawerPredictiveBackState
            r14.<init>(r3, r6)
            r10 = r14
            kotlin.jvm.functions.Function2 r10 = (kotlin.jvm.functions.Function2) r10
            r11 = 3
            r12 = 0
            r8 = 0
            r9 = 0
            kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r7, r8, r9, r10, r11, r12)
        L_0x00cd:
            androidx.compose.material3.DrawerState r14 = r13.$drawerState
            r3 = r13
            kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
            r13.L$0 = r0
            r13.label = r2
            java.lang.Object r14 = r14.close(r3)
            if (r14 != r1) goto L_0x00dd
        L_0x00dc:
            return r1
        L_0x00dd:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.NavigationDrawer_androidKt$DrawerPredictiveBackHandler$2$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
