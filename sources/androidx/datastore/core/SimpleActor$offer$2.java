package androidx.datastore.core;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H@"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.datastore.core.SimpleActor$offer$2", f = "SimpleActor.kt", i = {}, l = {121, 121}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: SimpleActor.kt */
final class SimpleActor$offer$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ SimpleActor<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SimpleActor$offer$2(SimpleActor<T> simpleActor, Continuation<? super SimpleActor$offer$2> continuation) {
        super(2, continuation);
        this.this$0 = simpleActor;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SimpleActor$offer$2(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SimpleActor$offer$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0051, code lost:
        if (r6 == r0) goto L_0x005f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x005d, code lost:
        if (r1.invoke(r6, r5) == r0) goto L_0x005f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x005f, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r6) {
        /*
            r5 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r5.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x0022
            if (r1 == r3) goto L_0x001a
            if (r1 != r2) goto L_0x0012
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0060
        L_0x0012:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x001a:
            java.lang.Object r1 = r5.L$0
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0054
        L_0x0022:
            kotlin.ResultKt.throwOnFailure(r6)
            androidx.datastore.core.SimpleActor<T> r6 = r5.this$0
            androidx.datastore.core.AtomicInt r6 = r6.remainingMessages
            int r6 = r6.get()
            if (r6 <= 0) goto L_0x006f
        L_0x0031:
            androidx.datastore.core.SimpleActor<T> r6 = r5.this$0
            kotlinx.coroutines.CoroutineScope r6 = r6.scope
            kotlinx.coroutines.CoroutineScopeKt.ensureActive(r6)
            androidx.datastore.core.SimpleActor<T> r6 = r5.this$0
            kotlin.jvm.functions.Function2 r1 = r6.consumeMessage
            androidx.datastore.core.SimpleActor<T> r6 = r5.this$0
            kotlinx.coroutines.channels.Channel r6 = r6.messageQueue
            r4 = r5
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
            r5.L$0 = r1
            r5.label = r3
            java.lang.Object r6 = r6.receive(r4)
            if (r6 != r0) goto L_0x0054
            goto L_0x005f
        L_0x0054:
            r4 = 0
            r5.L$0 = r4
            r5.label = r2
            java.lang.Object r6 = r1.invoke(r6, r5)
            if (r6 != r0) goto L_0x0060
        L_0x005f:
            return r0
        L_0x0060:
            androidx.datastore.core.SimpleActor<T> r6 = r5.this$0
            androidx.datastore.core.AtomicInt r6 = r6.remainingMessages
            int r6 = r6.decrementAndGet()
            if (r6 != 0) goto L_0x0031
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L_0x006f:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "Check failed."
            java.lang.String r0 = r0.toString()
            r6.<init>(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.SimpleActor$offer$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
