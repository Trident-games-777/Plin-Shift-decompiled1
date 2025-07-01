package androidx.compose.ui.platform;

import androidx.compose.ui.node.Owner;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.ui.platform.PlatformTextInputModifierNodeKt", f = "PlatformTextInputModifierNode.kt", i = {}, l = {194, 196}, m = "interceptedTextInputSession", n = {}, s = {})
/* compiled from: PlatformTextInputModifierNode.kt */
final class PlatformTextInputModifierNodeKt$interceptedTextInputSession$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;

    PlatformTextInputModifierNodeKt$interceptedTextInputSession$1(Continuation<? super PlatformTextInputModifierNodeKt$interceptedTextInputSession$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return PlatformTextInputModifierNodeKt.interceptedTextInputSession((Owner) null, (ChainedPlatformTextInputInterceptor) null, (Function2<? super PlatformTextInputSessionScope, ? super Continuation<?>, ? extends Object>) null, this);
    }
}
