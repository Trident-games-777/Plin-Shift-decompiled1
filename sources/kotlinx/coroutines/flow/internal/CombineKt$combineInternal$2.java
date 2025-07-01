package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2", f = "Combine.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2}, l = {51, 73, 76}, m = "invokeSuspend", n = {"latestValues", "resultChannel", "lastReceivedEpoch", "remainingAbsentValues", "currentEpoch", "latestValues", "resultChannel", "lastReceivedEpoch", "remainingAbsentValues", "currentEpoch", "latestValues", "resultChannel", "lastReceivedEpoch", "remainingAbsentValues", "currentEpoch"}, s = {"L$0", "L$1", "L$2", "I$0", "I$1", "L$0", "L$1", "L$2", "I$0", "I$1", "L$0", "L$1", "L$2", "I$0", "I$1"})
/* compiled from: Combine.kt */
final class CombineKt$combineInternal$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<T[]> $arrayFactory;
    final /* synthetic */ Flow<T>[] $flows;
    final /* synthetic */ FlowCollector<R> $this_combineInternal;
    final /* synthetic */ Function3<FlowCollector<? super R>, T[], Continuation<? super Unit>, Object> $transform;
    int I$0;
    int I$1;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CombineKt$combineInternal$2(Flow<? extends T>[] flowArr, Function0<T[]> function0, Function3<? super FlowCollector<? super R>, ? super T[], ? super Continuation<? super Unit>, ? extends Object> function3, FlowCollector<? super R> flowCollector, Continuation<? super CombineKt$combineInternal$2> continuation) {
        super(2, continuation);
        this.$flows = flowArr;
        this.$arrayFactory = function0;
        this.$transform = function3;
        this.$this_combineInternal = flowCollector;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        CombineKt$combineInternal$2 combineKt$combineInternal$2 = new CombineKt$combineInternal$2(this.$flows, this.$arrayFactory, this.$transform, this.$this_combineInternal, continuation);
        combineKt$combineInternal$2.L$0 = obj;
        return combineKt$combineInternal$2;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CombineKt$combineInternal$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x010b, code lost:
        if (r10.invoke(r11, r9, r0) == r1) goto L_0x012d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x012b, code lost:
        if (r11.invoke(r12, r10, r0) == r1) goto L_0x012d;
     */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00c6 A[LOOP:1: B:24:0x00c6->B:30:0x00e9, LOOP_START, PHI: r6 r10 
      PHI: (r6v3 int) = (r6v2 int), (r6v4 int) binds: [B:21:0x00c1, B:30:0x00e9] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r10v3 kotlin.collections.IndexedValue) = (r10v2 kotlin.collections.IndexedValue), (r10v16 kotlin.collections.IndexedValue) binds: [B:21:0x00c1, B:30:0x00e9] A[DONT_GENERATE, DONT_INLINE]] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r22) {
        /*
            r21 = this;
            r0 = r21
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x004e
            if (r2 == r5) goto L_0x0031
            if (r2 == r4) goto L_0x001c
            if (r2 != r3) goto L_0x0014
            goto L_0x001c
        L_0x0014:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x001c:
            int r2 = r0.I$1
            int r6 = r0.I$0
            java.lang.Object r7 = r0.L$2
            byte[] r7 = (byte[]) r7
            java.lang.Object r8 = r0.L$1
            kotlinx.coroutines.channels.Channel r8 = (kotlinx.coroutines.channels.Channel) r8
            java.lang.Object r9 = r0.L$0
            java.lang.Object[] r9 = (java.lang.Object[]) r9
            kotlin.ResultKt.throwOnFailure(r22)
            goto L_0x012e
        L_0x0031:
            int r2 = r0.I$1
            int r6 = r0.I$0
            java.lang.Object r7 = r0.L$2
            byte[] r7 = (byte[]) r7
            java.lang.Object r8 = r0.L$1
            kotlinx.coroutines.channels.Channel r8 = (kotlinx.coroutines.channels.Channel) r8
            java.lang.Object r9 = r0.L$0
            java.lang.Object[] r9 = (java.lang.Object[]) r9
            kotlin.ResultKt.throwOnFailure(r22)
            r10 = r22
            kotlinx.coroutines.channels.ChannelResult r10 = (kotlinx.coroutines.channels.ChannelResult) r10
            java.lang.Object r10 = r10.m9369unboximpl()
            goto L_0x00bb
        L_0x004e:
            kotlin.ResultKt.throwOnFailure(r22)
            java.lang.Object r2 = r0.L$0
            r6 = r2
            kotlinx.coroutines.CoroutineScope r6 = (kotlinx.coroutines.CoroutineScope) r6
            kotlinx.coroutines.flow.Flow<T>[] r2 = r0.$flows
            int r2 = r2.length
            if (r2 != 0) goto L_0x005e
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        L_0x005e:
            java.lang.Object[] r7 = new java.lang.Object[r2]
            kotlinx.coroutines.internal.Symbol r8 = kotlinx.coroutines.flow.internal.NullSurrogateKt.UNINITIALIZED
            r11 = 6
            r12 = 0
            r9 = 0
            r10 = 0
            kotlin.collections.ArraysKt.fill$default((java.lang.Object[]) r7, (java.lang.Object) r8, (int) r9, (int) r10, (int) r11, (java.lang.Object) r12)
            r12 = r7
            r7 = 6
            r8 = 0
            kotlinx.coroutines.channels.Channel r17 = kotlinx.coroutines.channels.ChannelKt.Channel$default(r2, r8, r8, r7, r8)
            java.util.concurrent.atomic.AtomicInteger r7 = new java.util.concurrent.atomic.AtomicInteger
            r7.<init>(r2)
            r19 = 0
            r15 = r19
        L_0x0079:
            if (r15 >= r2) goto L_0x0095
            kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1 r13 = new kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1
            kotlinx.coroutines.flow.Flow<T>[] r14 = r0.$flows
            r18 = 0
            r16 = r7
            r13.<init>(r14, r15, r16, r17, r18)
            r9 = r13
            kotlin.jvm.functions.Function2 r9 = (kotlin.jvm.functions.Function2) r9
            r10 = 3
            r11 = 0
            r7 = 0
            r8 = 0
            kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r6, r7, r8, r9, r10, r11)
            int r15 = r15 + 1
            r7 = r16
            goto L_0x0079
        L_0x0095:
            byte[] r6 = new byte[r2]
            r7 = r12
            r8 = r17
        L_0x009a:
            int r9 = r19 + 1
            byte r9 = (byte) r9
            r10 = r0
            kotlin.coroutines.Continuation r10 = (kotlin.coroutines.Continuation) r10
            r0.L$0 = r7
            r0.L$1 = r8
            r0.L$2 = r6
            r0.I$0 = r2
            r0.I$1 = r9
            r0.label = r5
            java.lang.Object r10 = r8.m9380receiveCatchingJP2dKIU(r10)
            if (r10 != r1) goto L_0x00b4
            goto L_0x012d
        L_0x00b4:
            r20 = r6
            r6 = r2
            r2 = r9
            r9 = r7
            r7 = r20
        L_0x00bb:
            java.lang.Object r10 = kotlinx.coroutines.channels.ChannelResult.m9362getOrNullimpl(r10)
            kotlin.collections.IndexedValue r10 = (kotlin.collections.IndexedValue) r10
            if (r10 != 0) goto L_0x00c6
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        L_0x00c6:
            int r11 = r10.getIndex()
            r12 = r9[r11]
            java.lang.Object r10 = r10.getValue()
            r9[r11] = r10
            kotlinx.coroutines.internal.Symbol r10 = kotlinx.coroutines.flow.internal.NullSurrogateKt.UNINITIALIZED
            if (r12 != r10) goto L_0x00d8
            int r6 = r6 + -1
        L_0x00d8:
            byte r10 = r7[r11]
            if (r10 == r2) goto L_0x00eb
            byte r10 = (byte) r2
            r7[r11] = r10
            java.lang.Object r10 = r8.m9381tryReceivePtdJZtk()
            java.lang.Object r10 = kotlinx.coroutines.channels.ChannelResult.m9362getOrNullimpl(r10)
            kotlin.collections.IndexedValue r10 = (kotlin.collections.IndexedValue) r10
            if (r10 != 0) goto L_0x00c6
        L_0x00eb:
            if (r6 != 0) goto L_0x012e
            kotlin.jvm.functions.Function0<T[]> r10 = r0.$arrayFactory
            java.lang.Object r10 = r10.invoke()
            java.lang.Object[] r10 = (java.lang.Object[]) r10
            if (r10 != 0) goto L_0x010e
            kotlin.jvm.functions.Function3<kotlinx.coroutines.flow.FlowCollector<? super R>, T[], kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> r10 = r0.$transform
            kotlinx.coroutines.flow.FlowCollector<R> r11 = r0.$this_combineInternal
            r0.L$0 = r9
            r0.L$1 = r8
            r0.L$2 = r7
            r0.I$0 = r6
            r0.I$1 = r2
            r0.label = r4
            java.lang.Object r10 = r10.invoke(r11, r9, r0)
            if (r10 != r1) goto L_0x012e
            goto L_0x012d
        L_0x010e:
            r14 = 14
            r15 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            kotlin.collections.ArraysKt.copyInto$default((java.lang.Object[]) r9, (java.lang.Object[]) r10, (int) r11, (int) r12, (int) r13, (int) r14, (java.lang.Object) r15)
            kotlin.jvm.functions.Function3<kotlinx.coroutines.flow.FlowCollector<? super R>, T[], kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> r11 = r0.$transform
            kotlinx.coroutines.flow.FlowCollector<R> r12 = r0.$this_combineInternal
            r0.L$0 = r9
            r0.L$1 = r8
            r0.L$2 = r7
            r0.I$0 = r6
            r0.I$1 = r2
            r0.label = r3
            java.lang.Object r10 = r11.invoke(r12, r10, r0)
            if (r10 != r1) goto L_0x012e
        L_0x012d:
            return r1
        L_0x012e:
            r19 = r2
            r2 = r6
            r6 = r7
            r7 = r9
            goto L_0x009a
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
