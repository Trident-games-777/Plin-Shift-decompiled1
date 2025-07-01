package androidx.compose.foundation;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.MagnifierNode$onAttach$1", f = "Magnifier.android.kt", i = {}, l = {380, 384}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: Magnifier.android.kt */
final class MagnifierNode$onAttach$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ MagnifierNode this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MagnifierNode$onAttach$1(MagnifierNode magnifierNode, Continuation<? super MagnifierNode$onAttach$1> continuation) {
        super(2, continuation);
        this.this$0 = magnifierNode;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MagnifierNode$onAttach$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MagnifierNode$onAttach$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0029  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x003d  */
    public final java.lang.Object invokeSuspend(java.lang.Object r5) {
        /*
            r4 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r4.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x001e
            if (r1 == r3) goto L_0x001a
            if (r1 != r2) goto L_0x0012
            kotlin.ResultKt.throwOnFailure(r5)
            goto L_0x004d
        L_0x0012:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L_0x001a:
            kotlin.ResultKt.throwOnFailure(r5)
            goto L_0x0035
        L_0x001e:
            kotlin.ResultKt.throwOnFailure(r5)
        L_0x0021:
            androidx.compose.foundation.MagnifierNode r5 = r4.this$0
            kotlinx.coroutines.channels.Channel r5 = r5.drawSignalChannel
            if (r5 == 0) goto L_0x0035
            r1 = r4
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
            r4.label = r3
            java.lang.Object r5 = r5.receive(r1)
            if (r5 != r0) goto L_0x0035
            goto L_0x004c
        L_0x0035:
            androidx.compose.foundation.MagnifierNode r5 = r4.this$0
            androidx.compose.foundation.PlatformMagnifier r5 = r5.magnifier
            if (r5 == 0) goto L_0x0021
            androidx.compose.foundation.MagnifierNode$onAttach$1$1 r5 = androidx.compose.foundation.MagnifierNode$onAttach$1.AnonymousClass1.INSTANCE
            kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
            r1 = r4
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
            r4.label = r2
            java.lang.Object r5 = androidx.compose.runtime.MonotonicFrameClockKt.withFrameMillis(r5, r1)
            if (r5 != r0) goto L_0x004d
        L_0x004c:
            return r0
        L_0x004d:
            androidx.compose.foundation.MagnifierNode r5 = r4.this$0
            androidx.compose.foundation.PlatformMagnifier r5 = r5.magnifier
            if (r5 == 0) goto L_0x0021
            r5.updateContent()
            goto L_0x0021
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.MagnifierNode$onAttach$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
