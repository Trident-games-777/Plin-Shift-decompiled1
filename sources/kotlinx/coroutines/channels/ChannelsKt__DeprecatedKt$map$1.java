package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "R", "Lkotlinx/coroutines/channels/ProducerScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$map$1", f = "Deprecated.kt", i = {0, 0, 1, 1, 2, 2}, l = {514, 363, 363}, m = "invokeSuspend", n = {"$this$produce", "$this$consume$iv$iv", "$this$produce", "$this$consume$iv$iv", "$this$produce", "$this$consume$iv$iv"}, s = {"L$0", "L$2", "L$0", "L$2", "L$0", "L$2"})
/* compiled from: Deprecated.kt */
final class ChannelsKt__DeprecatedKt$map$1 extends SuspendLambda implements Function2<ProducerScope<? super R>, Continuation<? super Unit>, Object> {
    final /* synthetic */ ReceiveChannel<E> $this_map;
    final /* synthetic */ Function2<E, Continuation<? super R>, Object> $transform;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChannelsKt__DeprecatedKt$map$1(ReceiveChannel<? extends E> receiveChannel, Function2<? super E, ? super Continuation<? super R>, ? extends Object> function2, Continuation<? super ChannelsKt__DeprecatedKt$map$1> continuation) {
        super(2, continuation);
        this.$this_map = receiveChannel;
        this.$transform = function2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ChannelsKt__DeprecatedKt$map$1 channelsKt__DeprecatedKt$map$1 = new ChannelsKt__DeprecatedKt$map$1(this.$this_map, this.$transform, continuation);
        channelsKt__DeprecatedKt$map$1.L$0 = obj;
        return channelsKt__DeprecatedKt$map$1;
    }

    public final Object invoke(ProducerScope<? super R> producerScope, Continuation<? super Unit> continuation) {
        return ((ChannelsKt__DeprecatedKt$map$1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0086 A[Catch:{ all -> 0x00d0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0092 A[Catch:{ all -> 0x00d0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00c2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r13) {
        /*
            r12 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r12.label
            r2 = 3
            r3 = 2
            r4 = 1
            r5 = 0
            if (r1 == 0) goto L_0x0062
            if (r1 == r4) goto L_0x004d
            if (r1 == r3) goto L_0x002f
            if (r1 != r2) goto L_0x0027
            java.lang.Object r1 = r12.L$3
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r6 = r12.L$2
            kotlinx.coroutines.channels.ReceiveChannel r6 = (kotlinx.coroutines.channels.ReceiveChannel) r6
            java.lang.Object r7 = r12.L$1
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            java.lang.Object r8 = r12.L$0
            kotlinx.coroutines.channels.ProducerScope r8 = (kotlinx.coroutines.channels.ProducerScope) r8
            kotlin.ResultKt.throwOnFailure(r13)     // Catch:{ all -> 0x00d0 }
            r13 = r8
            goto L_0x0074
        L_0x0027:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r0)
            throw r13
        L_0x002f:
            java.lang.Object r1 = r12.L$4
            kotlinx.coroutines.channels.ProducerScope r1 = (kotlinx.coroutines.channels.ProducerScope) r1
            java.lang.Object r6 = r12.L$3
            kotlinx.coroutines.channels.ChannelIterator r6 = (kotlinx.coroutines.channels.ChannelIterator) r6
            java.lang.Object r7 = r12.L$2
            kotlinx.coroutines.channels.ReceiveChannel r7 = (kotlinx.coroutines.channels.ReceiveChannel) r7
            java.lang.Object r8 = r12.L$1
            kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8
            java.lang.Object r9 = r12.L$0
            kotlinx.coroutines.channels.ProducerScope r9 = (kotlinx.coroutines.channels.ProducerScope) r9
            kotlin.ResultKt.throwOnFailure(r13)     // Catch:{ all -> 0x0049 }
            r10 = r5
            goto L_0x00af
        L_0x0049:
            r13 = move-exception
            r6 = r7
            goto L_0x00d1
        L_0x004d:
            java.lang.Object r1 = r12.L$3
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r6 = r12.L$2
            kotlinx.coroutines.channels.ReceiveChannel r6 = (kotlinx.coroutines.channels.ReceiveChannel) r6
            java.lang.Object r7 = r12.L$1
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            java.lang.Object r8 = r12.L$0
            kotlinx.coroutines.channels.ProducerScope r8 = (kotlinx.coroutines.channels.ProducerScope) r8
            kotlin.ResultKt.throwOnFailure(r13)     // Catch:{ all -> 0x00d0 }
            r9 = r5
            goto L_0x008a
        L_0x0062:
            kotlin.ResultKt.throwOnFailure(r13)
            java.lang.Object r13 = r12.L$0
            kotlinx.coroutines.channels.ProducerScope r13 = (kotlinx.coroutines.channels.ProducerScope) r13
            kotlinx.coroutines.channels.ReceiveChannel<E> r6 = r12.$this_map
            kotlin.jvm.functions.Function2<E, kotlin.coroutines.Continuation<? super R>, java.lang.Object> r1 = r12.$transform
            kotlinx.coroutines.channels.ChannelIterator r7 = r6.iterator()     // Catch:{ all -> 0x00d0 }
            r8 = r7
            r7 = r1
            r1 = r8
        L_0x0074:
            r8 = r5
        L_0x0075:
            r12.L$0 = r13     // Catch:{ all -> 0x00d0 }
            r12.L$1 = r7     // Catch:{ all -> 0x00d0 }
            r12.L$2 = r6     // Catch:{ all -> 0x00d0 }
            r12.L$3 = r1     // Catch:{ all -> 0x00d0 }
            r12.label = r4     // Catch:{ all -> 0x00d0 }
            java.lang.Object r9 = r1.hasNext(r12)     // Catch:{ all -> 0x00d0 }
            if (r9 != r0) goto L_0x0086
            goto L_0x00c1
        L_0x0086:
            r11 = r8
            r8 = r13
            r13 = r9
            r9 = r11
        L_0x008a:
            java.lang.Boolean r13 = (java.lang.Boolean) r13     // Catch:{ all -> 0x00d0 }
            boolean r13 = r13.booleanValue()     // Catch:{ all -> 0x00d0 }
            if (r13 == 0) goto L_0x00c8
            java.lang.Object r13 = r1.next()     // Catch:{ all -> 0x00d0 }
            r12.L$0 = r8     // Catch:{ all -> 0x00d0 }
            r12.L$1 = r7     // Catch:{ all -> 0x00d0 }
            r12.L$2 = r6     // Catch:{ all -> 0x00d0 }
            r12.L$3 = r1     // Catch:{ all -> 0x00d0 }
            r12.L$4 = r8     // Catch:{ all -> 0x00d0 }
            r12.label = r3     // Catch:{ all -> 0x00d0 }
            java.lang.Object r13 = r7.invoke(r13, r12)     // Catch:{ all -> 0x00d0 }
            if (r13 != r0) goto L_0x00a9
            goto L_0x00c1
        L_0x00a9:
            r10 = r9
            r9 = r8
            r8 = r7
            r7 = r6
            r6 = r1
            r1 = r9
        L_0x00af:
            r12.L$0 = r9     // Catch:{ all -> 0x0049 }
            r12.L$1 = r8     // Catch:{ all -> 0x0049 }
            r12.L$2 = r7     // Catch:{ all -> 0x0049 }
            r12.L$3 = r6     // Catch:{ all -> 0x0049 }
            r12.L$4 = r5     // Catch:{ all -> 0x0049 }
            r12.label = r2     // Catch:{ all -> 0x0049 }
            java.lang.Object r13 = r1.send(r13, r12)     // Catch:{ all -> 0x0049 }
            if (r13 != r0) goto L_0x00c2
        L_0x00c1:
            return r0
        L_0x00c2:
            r1 = r6
            r6 = r7
            r7 = r8
            r13 = r9
            r8 = r10
            goto L_0x0075
        L_0x00c8:
            kotlin.Unit r13 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00d0 }
            kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r6, r9)
            kotlin.Unit r13 = kotlin.Unit.INSTANCE
            return r13
        L_0x00d0:
            r13 = move-exception
        L_0x00d1:
            throw r13     // Catch:{ all -> 0x00d2 }
        L_0x00d2:
            r0 = move-exception
            kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r6, r13)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$map$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
