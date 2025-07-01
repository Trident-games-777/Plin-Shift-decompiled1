package androidx.compose.ui.viewinterop;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.ui.viewinterop.AndroidViewHolder$onNestedFling$1", f = "AndroidViewHolder.android.kt", i = {}, l = {565, 570}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: AndroidViewHolder.android.kt */
final class AndroidViewHolder$onNestedFling$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $consumed;
    final /* synthetic */ long $viewVelocity;
    int label;
    final /* synthetic */ AndroidViewHolder this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AndroidViewHolder$onNestedFling$1(boolean z, AndroidViewHolder androidViewHolder, long j, Continuation<? super AndroidViewHolder$onNestedFling$1> continuation) {
        super(2, continuation);
        this.$consumed = z;
        this.this$0 = androidViewHolder;
        this.$viewVelocity = j;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AndroidViewHolder$onNestedFling$1(this.$consumed, this.this$0, this.$viewVelocity, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AndroidViewHolder$onNestedFling$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0039, code lost:
        if (r10.this$0.dispatcher.m5458dispatchPostFlingRZ2iAVY(androidx.compose.ui.unit.Velocity.Companion.m7361getZero9UxMQ8M(), r10.$viewVelocity, r10) == r0) goto L_0x0055;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0053, code lost:
        if (r10.this$0.dispatcher.m5458dispatchPostFlingRZ2iAVY(r10.$viewVelocity, androidx.compose.ui.unit.Velocity.Companion.m7361getZero9UxMQ8M(), r10) == r0) goto L_0x0055;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) {
        /*
            r10 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r10.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x001b
            if (r1 == r3) goto L_0x0017
            if (r1 != r2) goto L_0x000f
            goto L_0x0017
        L_0x000f:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L_0x0017:
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x0056
        L_0x001b:
            kotlin.ResultKt.throwOnFailure(r11)
            boolean r11 = r10.$consumed
            if (r11 != 0) goto L_0x003c
            androidx.compose.ui.viewinterop.AndroidViewHolder r11 = r10.this$0
            androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher r4 = r11.dispatcher
            androidx.compose.ui.unit.Velocity$Companion r11 = androidx.compose.ui.unit.Velocity.Companion
            long r5 = r11.m7361getZero9UxMQ8M()
            long r7 = r10.$viewVelocity
            r9 = r10
            kotlin.coroutines.Continuation r9 = (kotlin.coroutines.Continuation) r9
            r10.label = r3
            java.lang.Object r11 = r4.m5458dispatchPostFlingRZ2iAVY(r5, r7, r9)
            if (r11 != r0) goto L_0x0056
            goto L_0x0055
        L_0x003c:
            androidx.compose.ui.viewinterop.AndroidViewHolder r11 = r10.this$0
            androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher r3 = r11.dispatcher
            long r4 = r10.$viewVelocity
            androidx.compose.ui.unit.Velocity$Companion r11 = androidx.compose.ui.unit.Velocity.Companion
            long r6 = r11.m7361getZero9UxMQ8M()
            r8 = r10
            kotlin.coroutines.Continuation r8 = (kotlin.coroutines.Continuation) r8
            r10.label = r2
            java.lang.Object r11 = r3.m5458dispatchPostFlingRZ2iAVY(r4, r6, r8)
            if (r11 != r0) goto L_0x0056
        L_0x0055:
            return r0
        L_0x0056:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.viewinterop.AndroidViewHolder$onNestedFling$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
