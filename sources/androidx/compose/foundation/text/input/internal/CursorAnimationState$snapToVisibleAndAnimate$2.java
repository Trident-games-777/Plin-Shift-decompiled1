package androidx.compose.foundation.text.input.internal;

import androidx.compose.animation.core.MutatorMutex$$ExternalSyntheticBackportWithForwarding0;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.text.input.internal.CursorAnimationState$snapToVisibleAndAnimate$2", f = "CursorAnimationState.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: CursorAnimationState.kt */
final class CursorAnimationState$snapToVisibleAndAnimate$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ CursorAnimationState this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CursorAnimationState$snapToVisibleAndAnimate$2(CursorAnimationState cursorAnimationState, Continuation<? super CursorAnimationState$snapToVisibleAndAnimate$2> continuation) {
        super(2, continuation);
        this.this$0 = cursorAnimationState;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        CursorAnimationState$snapToVisibleAndAnimate$2 cursorAnimationState$snapToVisibleAndAnimate$2 = new CursorAnimationState$snapToVisibleAndAnimate$2(this.this$0, continuation);
        cursorAnimationState$snapToVisibleAndAnimate$2.L$0 = obj;
        return cursorAnimationState$snapToVisibleAndAnimate$2;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
        return ((CursorAnimationState$snapToVisibleAndAnimate$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            final Job job = (Job) this.this$0.animationJob.getAndSet((Object) null);
            AtomicReference access$getAnimationJob$p = this.this$0.animationJob;
            final CursorAnimationState cursorAnimationState = this.this$0;
            return Boxing.boxBoolean(MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m(access$getAnimationJob$p, (Object) null, BuildersKt__Builders_commonKt.launch$default((CoroutineScope) this.L$0, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1((Continuation<? super AnonymousClass1>) null), 3, (Object) null)));
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.text.input.internal.CursorAnimationState$snapToVisibleAndAnimate$2$1", f = "CursorAnimationState.kt", i = {}, l = {69, 77, 79}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.foundation.text.input.internal.CursorAnimationState$snapToVisibleAndAnimate$2$1  reason: invalid class name */
    /* compiled from: CursorAnimationState.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(job, cursorAnimationState, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:16:0x003a, code lost:
            if (kotlinx.coroutines.JobKt.cancelAndJoin(r9, r8) == r0) goto L_0x0060;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x005e, code lost:
            if (kotlinx.coroutines.DelayKt.delay(500, r8) != r0) goto L_0x003d;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r9) {
            /*
                r8 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r8.label
                r2 = 500(0x1f4, double:2.47E-321)
                r4 = 0
                r5 = 3
                r6 = 2
                r7 = 1
                if (r1 == 0) goto L_0x002a
                if (r1 == r7) goto L_0x0026
                if (r1 == r6) goto L_0x0020
                if (r1 != r5) goto L_0x0018
                kotlin.ResultKt.throwOnFailure(r9)     // Catch:{ all -> 0x0024 }
                goto L_0x003d
            L_0x0018:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r0)
                throw r9
            L_0x0020:
                kotlin.ResultKt.throwOnFailure(r9)     // Catch:{ all -> 0x0024 }
                goto L_0x0050
            L_0x0024:
                r9 = move-exception
                goto L_0x0061
            L_0x0026:
                kotlin.ResultKt.throwOnFailure(r9)
                goto L_0x003d
            L_0x002a:
                kotlin.ResultKt.throwOnFailure(r9)
                kotlinx.coroutines.Job r9 = r9
                if (r9 == 0) goto L_0x003d
                r1 = r8
                kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
                r8.label = r7
                java.lang.Object r9 = kotlinx.coroutines.JobKt.cancelAndJoin(r9, r1)
                if (r9 != r0) goto L_0x003d
                goto L_0x0060
            L_0x003d:
                androidx.compose.foundation.text.input.internal.CursorAnimationState r9 = r2     // Catch:{ all -> 0x0024 }
                r1 = 1065353216(0x3f800000, float:1.0)
                r9.setCursorAlpha(r1)     // Catch:{ all -> 0x0024 }
                r9 = r8
                kotlin.coroutines.Continuation r9 = (kotlin.coroutines.Continuation) r9     // Catch:{ all -> 0x0024 }
                r8.label = r6     // Catch:{ all -> 0x0024 }
                java.lang.Object r9 = kotlinx.coroutines.DelayKt.delay(r2, r9)     // Catch:{ all -> 0x0024 }
                if (r9 != r0) goto L_0x0050
                goto L_0x0060
            L_0x0050:
                androidx.compose.foundation.text.input.internal.CursorAnimationState r9 = r2     // Catch:{ all -> 0x0024 }
                r9.setCursorAlpha(r4)     // Catch:{ all -> 0x0024 }
                r9 = r8
                kotlin.coroutines.Continuation r9 = (kotlin.coroutines.Continuation) r9     // Catch:{ all -> 0x0024 }
                r8.label = r5     // Catch:{ all -> 0x0024 }
                java.lang.Object r9 = kotlinx.coroutines.DelayKt.delay(r2, r9)     // Catch:{ all -> 0x0024 }
                if (r9 != r0) goto L_0x003d
            L_0x0060:
                return r0
            L_0x0061:
                androidx.compose.foundation.text.input.internal.CursorAnimationState r0 = r2
                r0.setCursorAlpha(r4)
                throw r9
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.input.internal.CursorAnimationState$snapToVisibleAndAnimate$2.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }
}
