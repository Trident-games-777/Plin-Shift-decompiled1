package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0015\u0010\u0004\u001a\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\bH\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lkotlinx/coroutines/flow/SharingCommand;", "count", "", "Lkotlin/ParameterName;", "name", "value"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.StartedWhileSubscribed$command$1", f = "SharingStarted.kt", i = {1, 2, 3}, l = {174, 176, 178, 179, 181}, m = "invokeSuspend", n = {"$this$transformLatest", "$this$transformLatest", "$this$transformLatest"}, s = {"L$0", "L$0", "L$0"})
/* compiled from: SharingStarted.kt */
final class StartedWhileSubscribed$command$1 extends SuspendLambda implements Function3<FlowCollector<? super SharingCommand>, Integer, Continuation<? super Unit>, Object> {
    /* synthetic */ int I$0;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ StartedWhileSubscribed this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    StartedWhileSubscribed$command$1(StartedWhileSubscribed startedWhileSubscribed, Continuation<? super StartedWhileSubscribed$command$1> continuation) {
        super(3, continuation);
        this.this$0 = startedWhileSubscribed;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((FlowCollector<? super SharingCommand>) (FlowCollector) obj, ((Number) obj2).intValue(), (Continuation<? super Unit>) (Continuation) obj3);
    }

    public final Object invoke(FlowCollector<? super SharingCommand> flowCollector, int i, Continuation<? super Unit> continuation) {
        StartedWhileSubscribed$command$1 startedWhileSubscribed$command$1 = new StartedWhileSubscribed$command$1(this.this$0, continuation);
        startedWhileSubscribed$command$1.L$0 = flowCollector;
        startedWhileSubscribed$command$1.I$0 = i;
        return startedWhileSubscribed$command$1.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v12, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: kotlinx.coroutines.flow.FlowCollector} */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0055, code lost:
        if (r1.emit(kotlinx.coroutines.flow.SharingCommand.START, r9) == r0) goto L_0x00ac;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0069, code lost:
        if (kotlinx.coroutines.DelayKt.delay(r9.this$0.stopTimeout, r9) == r0) goto L_0x00ac;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0085, code lost:
        if (r1.emit(kotlinx.coroutines.flow.SharingCommand.STOP, r9) == r0) goto L_0x00ac;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0099, code lost:
        if (kotlinx.coroutines.DelayKt.delay(r9.this$0.replayExpiration, r9) == r0) goto L_0x00ac;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00aa, code lost:
        if (r1.emit(kotlinx.coroutines.flow.SharingCommand.STOP_AND_RESET_REPLAY_CACHE, r9) != r0) goto L_0x00ad;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) {
        /*
            r9 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r9.label
            r2 = 5
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 1
            if (r1 == 0) goto L_0x003e
            if (r1 == r6) goto L_0x0039
            if (r1 == r5) goto L_0x0031
            if (r1 == r4) goto L_0x0029
            if (r1 == r3) goto L_0x0020
            if (r1 != r2) goto L_0x0018
            goto L_0x0039
        L_0x0018:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L_0x0020:
            java.lang.Object r1 = r9.L$0
            kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x009c
        L_0x0029:
            java.lang.Object r1 = r9.L$0
            kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x0088
        L_0x0031:
            java.lang.Object r1 = r9.L$0
            kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x006c
        L_0x0039:
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x00ad
        L_0x003e:
            kotlin.ResultKt.throwOnFailure(r10)
            java.lang.Object r10 = r9.L$0
            r1 = r10
            kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
            int r10 = r9.I$0
            if (r10 <= 0) goto L_0x0058
            kotlinx.coroutines.flow.SharingCommand r10 = kotlinx.coroutines.flow.SharingCommand.START
            r2 = r9
            kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
            r9.label = r6
            java.lang.Object r10 = r1.emit(r10, r2)
            if (r10 != r0) goto L_0x00ad
            goto L_0x00ac
        L_0x0058:
            kotlinx.coroutines.flow.StartedWhileSubscribed r10 = r9.this$0
            long r6 = r10.stopTimeout
            r10 = r9
            kotlin.coroutines.Continuation r10 = (kotlin.coroutines.Continuation) r10
            r9.L$0 = r1
            r9.label = r5
            java.lang.Object r10 = kotlinx.coroutines.DelayKt.delay(r6, r10)
            if (r10 != r0) goto L_0x006c
            goto L_0x00ac
        L_0x006c:
            kotlinx.coroutines.flow.StartedWhileSubscribed r10 = r9.this$0
            long r5 = r10.replayExpiration
            r7 = 0
            int r10 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r10 <= 0) goto L_0x009c
            kotlinx.coroutines.flow.SharingCommand r10 = kotlinx.coroutines.flow.SharingCommand.STOP
            r5 = r9
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
            r9.L$0 = r1
            r9.label = r4
            java.lang.Object r10 = r1.emit(r10, r5)
            if (r10 != r0) goto L_0x0088
            goto L_0x00ac
        L_0x0088:
            kotlinx.coroutines.flow.StartedWhileSubscribed r10 = r9.this$0
            long r4 = r10.replayExpiration
            r10 = r9
            kotlin.coroutines.Continuation r10 = (kotlin.coroutines.Continuation) r10
            r9.L$0 = r1
            r9.label = r3
            java.lang.Object r10 = kotlinx.coroutines.DelayKt.delay(r4, r10)
            if (r10 != r0) goto L_0x009c
            goto L_0x00ac
        L_0x009c:
            kotlinx.coroutines.flow.SharingCommand r10 = kotlinx.coroutines.flow.SharingCommand.STOP_AND_RESET_REPLAY_CACHE
            r3 = r9
            kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
            r4 = 0
            r9.L$0 = r4
            r9.label = r2
            java.lang.Object r10 = r1.emit(r10, r3)
            if (r10 != r0) goto L_0x00ad
        L_0x00ac:
            return r0
        L_0x00ad:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.StartedWhileSubscribed$command$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
