package com.plinkofortune.cash.winspin.profile;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.plinkofortune.cash.winspin.profile.PcAtMNHQpJHd$awaitUrl$2", f = "PcAtMNHQpJHd.kt", i = {1}, l = {223, 228}, m = "invokeSuspend", n = {"wv"}, s = {"L$0"})
/* compiled from: PcAtMNHQpJHd.kt */
final class PcAtMNHQpJHd$awaitUrl$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ String $headerKey;
    final /* synthetic */ String $url;
    Object L$0;
    int label;
    final /* synthetic */ PcAtMNHQpJHd this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PcAtMNHQpJHd$awaitUrl$2(PcAtMNHQpJHd pcAtMNHQpJHd, String str, String str2, Continuation<? super PcAtMNHQpJHd$awaitUrl$2> continuation) {
        super(2, continuation);
        this.this$0 = pcAtMNHQpJHd;
        this.$url = str;
        this.$headerKey = str2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PcAtMNHQpJHd$awaitUrl$2(this.this$0, this.$url, this.$headerKey, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
        return ((PcAtMNHQpJHd$awaitUrl$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0096, code lost:
        if (kotlinx.coroutines.DelayKt.delay(10, r5) == r0) goto L_0x0098;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0098, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0046, code lost:
        if (r5.this$0.webViewDeferred.await(r5) == r0) goto L_0x0098;
     */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x009e A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r6) {
        /*
            r5 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r5.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x0034
            if (r1 == r3) goto L_0x0030
            if (r1 != r2) goto L_0x0018
            java.lang.Object r1 = r5.L$0
            android.webkit.WebView r1 = (android.webkit.WebView) r1
            kotlin.ResultKt.throwOnFailure(r6)
            r6 = r1
            goto L_0x0099
        L_0x0018:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            r0 = 47
            byte[] r0 = new byte[r0]
            r0 = {-52, 85, -93, -62, -9, -28, -62, -31, -120, 70, -86, -35, -94, -3, -56, -26, -113, 86, -86, -56, -72, -30, -56, -31, -120, 93, -95, -40, -72, -5, -56, -26, -113, 67, -90, -38, -65, -80, -50, -82, -35, 91, -70, -38, -66, -2, -56} // fill-array
            r1 = 8
            byte[] r1 = new byte[r1]
            r1 = {-81, 52, -49, -82, -41, -112, -83, -63} // fill-array
            java.lang.String r0 = com.plinkofortune.cash.winspin.StringFog.decrypt(r0, r1)
            r6.<init>(r0)
            throw r6
        L_0x0030:
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0049
        L_0x0034:
            kotlin.ResultKt.throwOnFailure(r6)
            com.plinkofortune.cash.winspin.profile.PcAtMNHQpJHd r6 = r5.this$0
            kotlinx.coroutines.CompletableDeferred r6 = r6.webViewDeferred
            r1 = r5
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
            r5.label = r3
            java.lang.Object r6 = r6.await(r1)
            if (r6 != r0) goto L_0x0049
            goto L_0x0098
        L_0x0049:
            com.plinkofortune.cash.winspin.profile.PcAtMNHQpJHd r6 = r5.this$0
            android.webkit.WebView r6 = r6.webView
            if (r6 == 0) goto L_0x006a
            java.lang.String r1 = r5.$url
            java.lang.String r3 = r5.$headerKey
            com.plinkofortune.cash.winspin.profile.PcAtMNHQpJHd r4 = r5.this$0
            android.content.Context r4 = r4.requireContext()
            java.lang.String r4 = android.webkit.WebSettings.getDefaultUserAgent(r4)
            kotlin.Pair r3 = kotlin.TuplesKt.to(r3, r4)
            java.util.Map r3 = kotlin.collections.MapsKt.mapOf(r3)
            r6.loadUrl(r1, r3)
        L_0x006a:
            com.plinkofortune.cash.winspin.profile.PcAtMNHQpJHd r6 = r5.this$0
            android.webkit.WebView r6 = r6.webView
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6)
            java.lang.String r1 = r6.getUrl()
        L_0x0077:
            if (r1 == 0) goto L_0x0081
            java.lang.String r3 = r5.$url
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x009e
        L_0x0081:
            int r3 = r6.getProgress()
            r4 = 100
            if (r3 >= r4) goto L_0x009e
            r1 = r5
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
            r5.L$0 = r6
            r5.label = r2
            r3 = 10
            java.lang.Object r1 = kotlinx.coroutines.DelayKt.delay(r3, r1)
            if (r1 != r0) goto L_0x0099
        L_0x0098:
            return r0
        L_0x0099:
            java.lang.String r1 = r6.getUrl()
            goto L_0x0077
        L_0x009e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.plinkofortune.cash.winspin.profile.PcAtMNHQpJHd$awaitUrl$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
