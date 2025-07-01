package com.plinkofortune.cash.winspin.profile;

import android.webkit.WebView;
import com.google.common.base.Ascii;
import com.plinkofortune.cash.winspin.StringFog;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.plinkofortune.cash.winspin.profile.PcAtMNHQpJHd$loadUrl$1", f = "PcAtMNHQpJHd.kt", i = {}, l = {217}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: PcAtMNHQpJHd.kt */
final class PcAtMNHQpJHd$loadUrl$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $url;
    int label;
    final /* synthetic */ PcAtMNHQpJHd this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PcAtMNHQpJHd$loadUrl$1(PcAtMNHQpJHd pcAtMNHQpJHd, String str, Continuation<? super PcAtMNHQpJHd$loadUrl$1> continuation) {
        super(2, continuation);
        this.this$0 = pcAtMNHQpJHd;
        this.$url = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PcAtMNHQpJHd$loadUrl$1(this.this$0, this.$url, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PcAtMNHQpJHd$loadUrl$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (this.this$0.webViewDeferred.await(this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException(StringFog.decrypt(new byte[]{75, 105, 53, -48, 79, -115, Ascii.DC4, -113, Ascii.SI, 122, 60, -49, Ascii.SUB, -108, Ascii.RS, -120, 8, 106, 60, -38, 0, -117, Ascii.RS, -113, Ascii.SI, 97, 55, -54, 0, -110, Ascii.RS, -120, 8, Byte.MAX_VALUE, 48, -56, 7, -39, Ascii.CAN, -64, 90, 103, 44, -56, 6, -105, Ascii.RS}, new byte[]{40, 8, 89, -68, 111, -7, 123, -81}));
        }
        WebView access$getWebView$p = this.this$0.webView;
        if (access$getWebView$p != null) {
            access$getWebView$p.loadUrl(this.$url);
        }
        return Unit.INSTANCE;
    }
}
