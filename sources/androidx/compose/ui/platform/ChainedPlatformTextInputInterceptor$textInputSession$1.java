package androidx.compose.ui.platform;

import androidx.compose.ui.node.Owner;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.ui.platform.ChainedPlatformTextInputInterceptor", f = "PlatformTextInputModifierNode.kt", i = {}, l = {229}, m = "textInputSession", n = {}, s = {})
/* compiled from: PlatformTextInputModifierNode.kt */
final class ChainedPlatformTextInputInterceptor$textInputSession$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ChainedPlatformTextInputInterceptor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChainedPlatformTextInputInterceptor$textInputSession$1(ChainedPlatformTextInputInterceptor chainedPlatformTextInputInterceptor, Continuation<? super ChainedPlatformTextInputInterceptor$textInputSession$1> continuation) {
        super(continuation);
        this.this$0 = chainedPlatformTextInputInterceptor;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.textInputSession((Owner) null, (Function2<? super PlatformTextInputSessionScope, ? super Continuation<?>, ? extends Object>) null, this);
    }
}
