package com.plinkofortune.cash.winspin.seq;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelProvider;
import com.plinkofortune.cash.winspin.GlobalRepo;
import com.plinkofortune.cash.winspin.R;
import com.plinkofortune.cash.winspin.StringFog;
import com.plinkofortune.cash.winspin.seq.models.BallInScreen;
import com.plinkofortune.cash.winspin.seq.models.Multi;
import com.plinkofortune.cash.winspin.seq.models.SeqBall;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 $2\u00020\u0001:\u0001$B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016J\u000e\u0010\u0017\u001a\u00020\u0014H@¢\u0006\u0002\u0010\u0018J\u0006\u0010\u0019\u001a\u00020\u0014J\u000e\u0010\u001a\u001a\u00020\u0014H@¢\u0006\u0002\u0010\u0018J\b\u0010\u001b\u001a\u00020\u0014H\u0002J\b\u0010\u001c\u001a\u00020\u0014H\u0002J\b\u0010\u001d\u001a\u00020\u0014H\u0002J\u000e\u0010\u001e\u001a\u00020\u0014H@¢\u0006\u0002\u0010\u0018J\u000e\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 H\u0002J\u000e\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0 H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bX\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/plinkofortune/cash/winspin/seq/SeqViewModel;", "Landroidx/lifecycle/ViewModel;", "round", "", "repo", "Lcom/plinkofortune/cash/winspin/GlobalRepo;", "<init>", "(ILcom/plinkofortune/cash/winspin/GlobalRepo;)V", "handler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "_state", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/plinkofortune/cash/winspin/seq/SeqState;", "state", "Lkotlinx/coroutines/flow/StateFlow;", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", "stateMutex", "Lkotlinx/coroutines/sync/Mutex;", "ballInScreenFinished", "", "ball", "Lcom/plinkofortune/cash/winspin/seq/models/BallInScreen;", "doOnFinish", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "click", "runLoop", "makeTimerDown", "moveBallsInScreen", "trySetBallInScreen", "createInitialState", "generateSeqBalls", "", "Lcom/plinkofortune/cash/winspin/seq/models/SeqBall;", "generateMultis", "Lcom/plinkofortune/cash/winspin/seq/models/Multi;", "Companion", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: SeqViewModel.kt */
public final class SeqViewModel extends ViewModel {
    public static final int $stable = 8;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public final MutableStateFlow<SeqState> _state;
    private final CoroutineExceptionHandler handler;
    private final GlobalRepo repo;
    private int round;
    private final StateFlow<SeqState> state;
    /* access modifiers changed from: private */
    public final Mutex stateMutex = MutexKt.Mutex$default(false, 1, (Object) null);

    public SeqViewModel(int i, GlobalRepo globalRepo) {
        Intrinsics.checkNotNullParameter(globalRepo, StringFog.decrypt(new byte[]{94, 43, -10, 95}, new byte[]{44, 78, -122, 48, 125, -124, 45, 33}));
        this.round = i;
        this.repo = globalRepo;
        CoroutineExceptionHandler seqViewModel$special$$inlined$CoroutineExceptionHandler$1 = new SeqViewModel$special$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.Key);
        this.handler = seqViewModel$special$$inlined$CoroutineExceptionHandler$1;
        MutableStateFlow<SeqState> MutableStateFlow = StateFlowKt.MutableStateFlow(null);
        this._state = MutableStateFlow;
        this.state = FlowKt.asStateFlow(MutableStateFlow);
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getDefault().plus(seqViewModel$special$$inlined$CoroutineExceptionHandler$1), (CoroutineStart) null, new AnonymousClass1(this, (Continuation<? super AnonymousClass1>) null), 2, (Object) null);
    }

    public final StateFlow<SeqState> getState() {
        return this.state;
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.plinkofortune.cash.winspin.seq.SeqViewModel$1", f = "SeqViewModel.kt", i = {}, l = {40, 41}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.plinkofortune.cash.winspin.seq.SeqViewModel$1  reason: invalid class name */
    /* compiled from: SeqViewModel.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ SeqViewModel this$0;

        {
            this.this$0 = r1;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x004a, code lost:
            if (com.plinkofortune.cash.winspin.seq.SeqViewModel.access$runLoop(r4.this$0, r4) == r0) goto L_0x004c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x004c, code lost:
            return r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x003c, code lost:
            if (com.plinkofortune.cash.winspin.seq.SeqViewModel.access$createInitialState(r4.this$0, r4) == r0) goto L_0x004c;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r5) {
            /*
                r4 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r4.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L_0x002e
                if (r1 == r3) goto L_0x002a
                if (r1 != r2) goto L_0x0012
                kotlin.ResultKt.throwOnFailure(r5)
                goto L_0x004d
            L_0x0012:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                r0 = 47
                byte[] r0 = new byte[r0]
                r0 = {-78, 22, 88, -58, -114, 63, -62, -8, -10, 5, 81, -39, -37, 38, -56, -1, -15, 21, 81, -52, -63, 57, -56, -8, -10, 30, 90, -36, -63, 32, -56, -1, -15, 0, 93, -34, -58, 107, -50, -73, -93, 24, 65, -34, -57, 37, -56} // fill-array
                r1 = 8
                byte[] r1 = new byte[r1]
                r1 = {-47, 119, 52, -86, -82, 75, -83, -40} // fill-array
                java.lang.String r0 = com.plinkofortune.cash.winspin.StringFog.decrypt(r0, r1)
                r5.<init>(r0)
                throw r5
            L_0x002a:
                kotlin.ResultKt.throwOnFailure(r5)
                goto L_0x003f
            L_0x002e:
                kotlin.ResultKt.throwOnFailure(r5)
                com.plinkofortune.cash.winspin.seq.SeqViewModel r5 = r4.this$0
                r1 = r4
                kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
                r4.label = r3
                java.lang.Object r5 = r5.createInitialState(r1)
                if (r5 != r0) goto L_0x003f
                goto L_0x004c
            L_0x003f:
                com.plinkofortune.cash.winspin.seq.SeqViewModel r5 = r4.this$0
                r1 = r4
                kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
                r4.label = r2
                java.lang.Object r5 = r5.runLoop(r1)
                if (r5 != r0) goto L_0x004d
            L_0x004c:
                return r0
            L_0x004d:
                kotlin.Unit r5 = kotlin.Unit.INSTANCE
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.plinkofortune.cash.winspin.seq.SeqViewModel.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public final void ballInScreenFinished(BallInScreen ballInScreen) {
        if (ballInScreen != null) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getDefault().plus(this.handler), (CoroutineStart) null, new SeqViewModel$ballInScreenFinished$1(this, ballInScreen, (Continuation<? super SeqViewModel$ballInScreenFinished$1>) null), 2, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0171, code lost:
        if (r1 != r3) goto L_0x0074;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0206, code lost:
        if (r4.setLeaders(r1, r2) != r3) goto L_0x0209;
     */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00cb  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00e2  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0106  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x011b  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0160  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0193  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x01ac  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x01cf  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x00df A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0118 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object doOnFinish(kotlin.coroutines.Continuation<? super kotlin.Unit> r23) {
        /*
            r22 = this;
            r0 = r22
            r1 = r23
            boolean r2 = r1 instanceof com.plinkofortune.cash.winspin.seq.SeqViewModel$doOnFinish$1
            if (r2 == 0) goto L_0x0018
            r2 = r1
            com.plinkofortune.cash.winspin.seq.SeqViewModel$doOnFinish$1 r2 = (com.plinkofortune.cash.winspin.seq.SeqViewModel$doOnFinish$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0018
            int r1 = r2.label
            int r1 = r1 - r4
            r2.label = r1
            goto L_0x001d
        L_0x0018:
            com.plinkofortune.cash.winspin.seq.SeqViewModel$doOnFinish$1 r2 = new com.plinkofortune.cash.winspin.seq.SeqViewModel$doOnFinish$1
            r2.<init>(r0, r1)
        L_0x001d:
            java.lang.Object r1 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            r5 = 5
            r6 = 4
            r7 = 2
            r8 = 3
            r9 = 0
            r10 = 1
            if (r4 == 0) goto L_0x0091
            if (r4 == r10) goto L_0x0085
            if (r4 == r7) goto L_0x0078
            if (r4 == r8) goto L_0x0069
            if (r4 == r6) goto L_0x0054
            if (r4 != r5) goto L_0x003c
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x0209
        L_0x003c:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            r2 = 47
            byte[] r2 = new byte[r2]
            r2 = {-40, 91, 26, 108, 78, -125, 116, 106, -100, 72, 19, 115, 27, -102, 126, 109, -101, 88, 19, 102, 1, -123, 126, 106, -100, 83, 24, 118, 1, -100, 126, 109, -101, 77, 31, 116, 6, -41, 120, 37, -55, 85, 3, 116, 7, -103, 126} // fill-array
            r3 = 8
            byte[] r3 = new byte[r3]
            r3 = {-69, 58, 118, 0, 110, -9, 27, 74} // fill-array
            java.lang.String r2 = com.plinkofortune.cash.winspin.StringFog.decrypt(r2, r3)
            r1.<init>(r2)
            throw r1
        L_0x0054:
            java.lang.Object r4 = r2.L$3
            java.util.List r4 = (java.util.List) r4
            java.lang.Object r6 = r2.L$2
            java.util.List r6 = (java.util.List) r6
            java.lang.Object r7 = r2.L$1
            com.plinkofortune.cash.winspin.seq.SeqState r7 = (com.plinkofortune.cash.winspin.seq.SeqState) r7
            java.lang.Object r8 = r2.L$0
            com.plinkofortune.cash.winspin.seq.SeqViewModel r8 = (com.plinkofortune.cash.winspin.seq.SeqViewModel) r8
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x0194
        L_0x0069:
            java.lang.Object r4 = r2.L$1
            com.plinkofortune.cash.winspin.seq.SeqState r4 = (com.plinkofortune.cash.winspin.seq.SeqState) r4
            java.lang.Object r7 = r2.L$0
            com.plinkofortune.cash.winspin.seq.SeqViewModel r7 = (com.plinkofortune.cash.winspin.seq.SeqViewModel) r7
            kotlin.ResultKt.throwOnFailure(r1)
        L_0x0074:
            r8 = r7
            r7 = r4
            goto L_0x0175
        L_0x0078:
            java.lang.Object r4 = r2.L$1
            com.plinkofortune.cash.winspin.seq.SeqState r4 = (com.plinkofortune.cash.winspin.seq.SeqState) r4
            java.lang.Object r7 = r2.L$0
            com.plinkofortune.cash.winspin.seq.SeqViewModel r7 = (com.plinkofortune.cash.winspin.seq.SeqViewModel) r7
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x0161
        L_0x0085:
            java.lang.Object r4 = r2.L$1
            com.plinkofortune.cash.winspin.seq.SeqState r4 = (com.plinkofortune.cash.winspin.seq.SeqState) r4
            java.lang.Object r11 = r2.L$0
            com.plinkofortune.cash.winspin.seq.SeqViewModel r11 = (com.plinkofortune.cash.winspin.seq.SeqViewModel) r11
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x00b9
        L_0x0091:
            kotlin.ResultKt.throwOnFailure(r1)
            kotlinx.coroutines.flow.MutableStateFlow<com.plinkofortune.cash.winspin.seq.SeqState> r1 = r0._state
            java.lang.Object r1 = r1.getValue()
            com.plinkofortune.cash.winspin.seq.SeqState r1 = (com.plinkofortune.cash.winspin.seq.SeqState) r1
            if (r1 != 0) goto L_0x00a1
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        L_0x00a1:
            com.plinkofortune.cash.winspin.GlobalRepo r4 = r0.repo
            kotlinx.coroutines.flow.Flow r4 = r4.getRounds()
            r2.L$0 = r0
            r2.L$1 = r1
            r2.label = r10
            java.lang.Object r4 = kotlinx.coroutines.flow.FlowKt.first(r4, r2)
            if (r4 != r3) goto L_0x00b5
            goto L_0x0208
        L_0x00b5:
            r11 = r4
            r4 = r1
            r1 = r11
            r11 = r0
        L_0x00b9:
            java.util.Collection r1 = (java.util.Collection) r1
            java.util.List r1 = kotlin.collections.CollectionsKt.toMutableList(r1)
            java.util.Iterator r12 = r1.iterator()
            r13 = r9
        L_0x00c4:
            boolean r14 = r12.hasNext()
            r15 = -1
            if (r14 == 0) goto L_0x00df
            java.lang.Object r14 = r12.next()
            com.plinkofortune.cash.winspin.rounds.RoundModel r14 = (com.plinkofortune.cash.winspin.rounds.RoundModel) r14
            int r14 = r14.getNum()
            int r5 = r11.round
            int r5 = r5 + r10
            if (r14 != r5) goto L_0x00db
            goto L_0x00e0
        L_0x00db:
            int r13 = r13 + 1
            r5 = 5
            goto L_0x00c4
        L_0x00df:
            r13 = r15
        L_0x00e0:
            if (r13 == r15) goto L_0x00fb
            java.lang.Object r5 = r1.get(r13)
            r16 = r5
            com.plinkofortune.cash.winspin.rounds.RoundModel r16 = (com.plinkofortune.cash.winspin.rounds.RoundModel) r16
            r20 = 3
            r21 = 0
            r17 = 0
            r18 = 0
            r19 = 1
            com.plinkofortune.cash.winspin.rounds.RoundModel r5 = com.plinkofortune.cash.winspin.rounds.RoundModel.copy$default(r16, r17, r18, r19, r20, r21)
            r1.set(r13, r5)
        L_0x00fb:
            java.util.Iterator r5 = r1.iterator()
            r12 = r9
        L_0x0100:
            boolean r13 = r5.hasNext()
            if (r13 == 0) goto L_0x0118
            java.lang.Object r13 = r5.next()
            com.plinkofortune.cash.winspin.rounds.RoundModel r13 = (com.plinkofortune.cash.winspin.rounds.RoundModel) r13
            int r13 = r13.getNum()
            int r14 = r11.round
            if (r13 != r14) goto L_0x0115
            goto L_0x0119
        L_0x0115:
            int r12 = r12 + 1
            goto L_0x0100
        L_0x0118:
            r12 = r15
        L_0x0119:
            if (r12 == r15) goto L_0x0150
            java.lang.Object r5 = r1.get(r12)
            r13 = r5
            com.plinkofortune.cash.winspin.rounds.RoundModel r13 = (com.plinkofortune.cash.winspin.rounds.RoundModel) r13
            java.lang.Object r5 = r1.get(r12)
            com.plinkofortune.cash.winspin.rounds.RoundModel r5 = (com.plinkofortune.cash.winspin.rounds.RoundModel) r5
            int r5 = r5.getStars()
            int r14 = r4.getStars()
            if (r5 >= r14) goto L_0x0137
            int r5 = r4.getStars()
            goto L_0x0141
        L_0x0137:
            java.lang.Object r5 = r1.get(r12)
            com.plinkofortune.cash.winspin.rounds.RoundModel r5 = (com.plinkofortune.cash.winspin.rounds.RoundModel) r5
            int r5 = r5.getStars()
        L_0x0141:
            r15 = r5
            r17 = 5
            r18 = 0
            r14 = 0
            r16 = 0
            com.plinkofortune.cash.winspin.rounds.RoundModel r5 = com.plinkofortune.cash.winspin.rounds.RoundModel.copy$default(r13, r14, r15, r16, r17, r18)
            r1.set(r12, r5)
        L_0x0150:
            com.plinkofortune.cash.winspin.GlobalRepo r5 = r11.repo
            r2.L$0 = r11
            r2.L$1 = r4
            r2.label = r7
            java.lang.Object r1 = r5.setRounds(r1, r2)
            if (r1 != r3) goto L_0x0160
            goto L_0x0208
        L_0x0160:
            r7 = r11
        L_0x0161:
            com.plinkofortune.cash.winspin.GlobalRepo r1 = r7.repo
            kotlinx.coroutines.flow.Flow r1 = r1.getLeaders()
            r2.L$0 = r7
            r2.L$1 = r4
            r2.label = r8
            java.lang.Object r1 = kotlinx.coroutines.flow.FlowKt.first(r1, r2)
            if (r1 != r3) goto L_0x0074
            goto L_0x0208
        L_0x0175:
            java.util.Collection r1 = (java.util.Collection) r1
            java.util.List r4 = kotlin.collections.CollectionsKt.toMutableList(r1)
            com.plinkofortune.cash.winspin.GlobalRepo r1 = r8.repo
            kotlinx.coroutines.flow.Flow r1 = r1.getProfile()
            r2.L$0 = r8
            r2.L$1 = r7
            r2.L$2 = r4
            r2.L$3 = r4
            r2.label = r6
            java.lang.Object r1 = kotlinx.coroutines.flow.FlowKt.first(r1, r2)
            if (r1 != r3) goto L_0x0193
            goto L_0x0208
        L_0x0193:
            r6 = r4
        L_0x0194:
            com.plinkofortune.cash.winspin.profile.ProfileData r1 = (com.plinkofortune.cash.winspin.profile.ProfileData) r1
            java.lang.String r1 = r1.getName()
            com.plinkofortune.cash.winspin.leader.LeaderModel r5 = new com.plinkofortune.cash.winspin.leader.LeaderModel
            int r7 = r7.getScore()
            r5.<init>(r9, r1, r7)
            r4.add(r5)
            int r1 = r4.size()
            if (r1 <= r10) goto L_0x01b6
            com.plinkofortune.cash.winspin.seq.SeqViewModel$doOnFinish$lambda$5$$inlined$sortByDescending$1 r1 = new com.plinkofortune.cash.winspin.seq.SeqViewModel$doOnFinish$lambda$5$$inlined$sortByDescending$1
            r1.<init>()
            java.util.Comparator r1 = (java.util.Comparator) r1
            kotlin.collections.CollectionsKt.sortWith(r4, r1)
        L_0x01b6:
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.ArrayList r1 = new java.util.ArrayList
            r4 = 10
            int r4 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r6, r4)
            r1.<init>(r4)
            java.util.Collection r1 = (java.util.Collection) r1
            java.util.Iterator r4 = r6.iterator()
        L_0x01c9:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x01ea
            java.lang.Object r5 = r4.next()
            int r11 = r9 + 1
            if (r9 >= 0) goto L_0x01da
            kotlin.collections.CollectionsKt.throwIndexOverflow()
        L_0x01da:
            r10 = r5
            com.plinkofortune.cash.winspin.leader.LeaderModel r10 = (com.plinkofortune.cash.winspin.leader.LeaderModel) r10
            r14 = 6
            r15 = 0
            r12 = 0
            r13 = 0
            com.plinkofortune.cash.winspin.leader.LeaderModel r5 = com.plinkofortune.cash.winspin.leader.LeaderModel.copy$default(r10, r11, r12, r13, r14, r15)
            r1.add(r5)
            r9 = r11
            goto L_0x01c9
        L_0x01ea:
            java.util.List r1 = (java.util.List) r1
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            r4 = 20
            java.util.List r1 = kotlin.collections.CollectionsKt.take(r1, r4)
            com.plinkofortune.cash.winspin.GlobalRepo r4 = r8.repo
            r5 = 0
            r2.L$0 = r5
            r2.L$1 = r5
            r2.L$2 = r5
            r2.L$3 = r5
            r5 = 5
            r2.label = r5
            java.lang.Object r1 = r4.setLeaders(r1, r2)
            if (r1 != r3) goto L_0x0209
        L_0x0208:
            return r3
        L_0x0209:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.plinkofortune.cash.winspin.seq.SeqViewModel.doOnFinish(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void click() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getDefault().plus(this.handler), (CoroutineStart) null, new SeqViewModel$click$1(this, (Continuation<? super SeqViewModel$click$1>) null), 2, (Object) null);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00a1, code lost:
        if (kotlinx.coroutines.DelayKt.delay(1000, r0) == r1) goto L_0x00a3;
     */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0082 A[Catch:{ all -> 0x00a4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0087 A[Catch:{ all -> 0x00a4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0090 A[SYNTHETIC, Splitter:B:28:0x0090] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object runLoop(kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            r9 = this;
            boolean r0 = r10 instanceof com.plinkofortune.cash.winspin.seq.SeqViewModel$runLoop$1
            if (r0 == 0) goto L_0x0014
            r0 = r10
            com.plinkofortune.cash.winspin.seq.SeqViewModel$runLoop$1 r0 = (com.plinkofortune.cash.winspin.seq.SeqViewModel$runLoop$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L_0x0019
        L_0x0014:
            com.plinkofortune.cash.winspin.seq.SeqViewModel$runLoop$1 r0 = new com.plinkofortune.cash.winspin.seq.SeqViewModel$runLoop$1
            r0.<init>(r9, r10)
        L_0x0019:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L_0x0059
            if (r2 == r4) goto L_0x004b
            if (r2 != r3) goto L_0x0033
            java.lang.Object r2 = r0.L$0
            com.plinkofortune.cash.winspin.seq.SeqViewModel r2 = (com.plinkofortune.cash.winspin.seq.SeqViewModel) r2
            kotlin.ResultKt.throwOnFailure(r10)
        L_0x0031:
            r10 = r2
            goto L_0x005d
        L_0x0033:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            r0 = 47
            byte[] r0 = new byte[r0]
            r0 = {-41, 80, 95, -68, 56, 113, -10, 59, -109, 67, 86, -93, 109, 104, -4, 60, -108, 83, 86, -74, 119, 119, -4, 59, -109, 88, 93, -90, 119, 110, -4, 60, -108, 70, 90, -92, 112, 37, -6, 116, -58, 94, 70, -92, 113, 107, -4} // fill-array
            r1 = 8
            byte[] r1 = new byte[r1]
            r1 = {-76, 49, 51, -48, 24, 5, -103, 27} // fill-array
            java.lang.String r0 = com.plinkofortune.cash.winspin.StringFog.decrypt(r0, r1)
            r10.<init>(r0)
            throw r10
        L_0x004b:
            java.lang.Object r2 = r0.L$1
            kotlinx.coroutines.sync.Mutex r2 = (kotlinx.coroutines.sync.Mutex) r2
            java.lang.Object r6 = r0.L$0
            com.plinkofortune.cash.winspin.seq.SeqViewModel r6 = (com.plinkofortune.cash.winspin.seq.SeqViewModel) r6
            kotlin.ResultKt.throwOnFailure(r10)
            r10 = r2
            r2 = r6
            goto L_0x006f
        L_0x0059:
            kotlin.ResultKt.throwOnFailure(r10)
            r10 = r9
        L_0x005d:
            kotlinx.coroutines.sync.Mutex r2 = r10.stateMutex
            r0.L$0 = r10
            r0.L$1 = r2
            r0.label = r4
            java.lang.Object r6 = r2.lock(r5, r0)
            if (r6 != r1) goto L_0x006c
            goto L_0x00a3
        L_0x006c:
            r8 = r2
            r2 = r10
            r10 = r8
        L_0x006f:
            r2.trySetBallInScreen()     // Catch:{ all -> 0x00a4 }
            r2.moveBallsInScreen()     // Catch:{ all -> 0x00a4 }
            r2.makeTimerDown()     // Catch:{ all -> 0x00a4 }
            kotlinx.coroutines.flow.MutableStateFlow<com.plinkofortune.cash.winspin.seq.SeqState> r6 = r2._state     // Catch:{ all -> 0x00a4 }
            java.lang.Object r6 = r6.getValue()     // Catch:{ all -> 0x00a4 }
            com.plinkofortune.cash.winspin.seq.SeqState r6 = (com.plinkofortune.cash.winspin.seq.SeqState) r6     // Catch:{ all -> 0x00a4 }
            if (r6 == 0) goto L_0x0087
            java.lang.Boolean r6 = r6.getWin()     // Catch:{ all -> 0x00a4 }
            goto L_0x0088
        L_0x0087:
            r6 = r5
        L_0x0088:
            if (r6 == 0) goto L_0x0090
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00a4 }
            r10.unlock(r5)
            return r0
        L_0x0090:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00a4 }
            r10.unlock(r5)
            r0.L$0 = r2
            r0.L$1 = r5
            r0.label = r3
            r6 = 1000(0x3e8, double:4.94E-321)
            java.lang.Object r10 = kotlinx.coroutines.DelayKt.delay(r6, r0)
            if (r10 != r1) goto L_0x0031
        L_0x00a3:
            return r1
        L_0x00a4:
            r0 = move-exception
            r10.unlock(r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.plinkofortune.cash.winspin.seq.SeqViewModel.runLoop(kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void makeTimerDown() {
        SeqState seqState;
        SeqState value = this._state.getValue();
        if (value != null && value.getWin() == null) {
            int time = value.getTime() - 1;
            MutableStateFlow<SeqState> mutableStateFlow = this._state;
            if (time == 0) {
                seqState = SeqState.copy$default(value, 0, time, 0, 0, (List) null, (List) null, (List) null, false, 125, (Object) null);
            } else {
                seqState = SeqState.copy$default(value, 0, time, 0, 0, (List) null, (List) null, (List) null, (Boolean) null, 253, (Object) null);
            }
            mutableStateFlow.setValue(seqState);
        }
    }

    private final void moveBallsInScreen() {
        SeqState value = this._state.getValue();
        if (value != null && value.getWin() == null) {
            Iterable<BallInScreen> ballsInScreen = value.getBallsInScreen();
            Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(ballsInScreen, 10));
            for (BallInScreen ballInScreen : ballsInScreen) {
                if (!ballInScreen.getFinished() && !ballInScreen.getFallingDown()) {
                    if (ballInScreen.getRight()) {
                        int row = ballInScreen.getRow() + 1;
                        ballInScreen = row == 8 ? BallInScreen.copy$default(ballInScreen, false, false, 6, 0, false, 11, (Object) null) : BallInScreen.copy$default(ballInScreen, false, false, row, 0, false, 27, (Object) null);
                    } else {
                        int row2 = ballInScreen.getRow() - 1;
                        ballInScreen = row2 == 0 ? BallInScreen.copy$default(ballInScreen, false, false, 2, 0, true, 11, (Object) null) : BallInScreen.copy$default(ballInScreen, false, false, row2, 0, false, 27, (Object) null);
                    }
                }
                arrayList.add(ballInScreen);
            }
            this._state.setValue(SeqState.copy$default(value, 0, 0, 0, 0, (List) arrayList, (List) null, (List) null, (Boolean) null, 239, (Object) null));
        }
    }

    private final void trySetBallInScreen() {
        Object obj;
        Object obj2;
        SeqState value = this._state.getValue();
        if (value != null && value.getWin() == null) {
            Iterator it = value.getBallsInScreen().iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                BallInScreen ballInScreen = (BallInScreen) obj;
                if (ballInScreen.getFallingDown() && !ballInScreen.getFinished()) {
                    break;
                }
            }
            if (obj == null) {
                Iterator it2 = value.getBallsInScreen().iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        obj2 = null;
                        break;
                    }
                    obj2 = it2.next();
                    if (!((BallInScreen) obj2).getFallingDown()) {
                        break;
                    }
                }
                if (obj2 == null && !value.getSeqBalls().isEmpty()) {
                    Collection arrayList = new ArrayList();
                    for (Object next : value.getSeqBalls()) {
                        if (!((SeqBall) next).getCatch()) {
                            arrayList.add(next);
                        }
                    }
                    SeqBall seqBall = (SeqBall) CollectionsKt.randomOrNull((List) arrayList, Random.Default);
                    if (seqBall != null) {
                        BallInScreen ballInScreen2 = new BallInScreen(false, false, 1, value.getBallsInScreen().size() == 6 ? ((Boolean) CollectionsKt.random(CollectionsKt.listOf(true, false), Random.Default)).booleanValue() : false ? R.drawable.surprise : seqBall.getResource(), true);
                        List mutableList = CollectionsKt.toMutableList(value.getSeqBalls());
                        int i = -1;
                        if (ballInScreen2.getResource() == R.drawable.surprise) {
                            Iterator it3 = mutableList.iterator();
                            int i2 = 0;
                            while (true) {
                                if (!it3.hasNext()) {
                                    i2 = -1;
                                    break;
                                } else if (!((SeqBall) it3.next()).getCatch()) {
                                    break;
                                } else {
                                    i2++;
                                }
                            }
                            if (i2 != -1) {
                                mutableList.set(i2, SeqBall.copy$default(value.getSeqBalls().get(i2), 0, true, 1, (Object) null));
                            }
                        } else {
                            Iterator<SeqBall> it4 = value.getSeqBalls().iterator();
                            int i3 = 0;
                            while (true) {
                                if (!it4.hasNext()) {
                                    break;
                                }
                                SeqBall next2 = it4.next();
                                if (next2.getResource() == ballInScreen2.getResource() && !next2.getCatch()) {
                                    i = i3;
                                    break;
                                }
                                i3++;
                            }
                            mutableList.set(i, SeqBall.copy$default(value.getSeqBalls().get(i), 0, true, 1, (Object) null));
                        }
                        List mutableList2 = CollectionsKt.toMutableList(value.getBallsInScreen());
                        mutableList2.add(ballInScreen2);
                        this._state.setValue(SeqState.copy$default(value, 0, 0, 0, 0, mutableList2, (List) null, mutableList, (Boolean) null, 175, (Object) null));
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public final Object createInitialState(Continuation<? super Unit> continuation) {
        List<SeqBall> generateSeqBalls = generateSeqBalls();
        this._state.setValue(new SeqState(this.round, 50, 3, 0, CollectionsKt.emptyList(), generateMultis(), generateSeqBalls, (Boolean) null));
        return Unit.INSTANCE;
    }

    private final List<SeqBall> generateSeqBalls() {
        List listOf = CollectionsKt.listOf(Integer.valueOf(R.drawable.b1), Integer.valueOf(R.drawable.b2), Integer.valueOf(R.drawable.b3), Integer.valueOf(R.drawable.b4));
        ArrayList arrayList = new ArrayList(7);
        for (int i = 0; i < 7; i++) {
            arrayList.add(new SeqBall(((Number) CollectionsKt.random(listOf, Random.Default)).intValue(), false));
        }
        return arrayList;
    }

    private final List<Multi> generateMultis() {
        ArrayList arrayList = new ArrayList(7);
        int i = 0;
        while (i < 7) {
            int i2 = i + 1;
            int i3 = 20;
            switch (i) {
                case 0:
                case 6:
                    i3 = 100;
                    break;
                case 1:
                case 5:
                    i3 = 60;
                    break;
                case 2:
                case 4:
                    break;
                case 3:
                    i3 = 10;
                    break;
                default:
                    throw new IllegalStateException();
            }
            arrayList.add(new Multi(i2, i3, false));
            i = i2;
        }
        return arrayList;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/plinkofortune/cash/winspin/seq/SeqViewModel$Companion;", "", "<init>", "()V", "Factory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "round", "", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* compiled from: SeqViewModel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ViewModelProvider.Factory Factory(int i) {
            return new SeqViewModel$Companion$Factory$1(i);
        }
    }
}
