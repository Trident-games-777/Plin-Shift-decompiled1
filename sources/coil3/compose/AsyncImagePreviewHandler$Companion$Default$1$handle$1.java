package coil3.compose;

import coil3.ImageLoader;
import coil3.request.ImageRequest;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "coil3.compose.AsyncImagePreviewHandler$Companion$Default$1", f = "LocalAsyncImagePreviewHandler.kt", i = {0}, l = {37}, m = "handle", n = {"request"}, s = {"L$0"})
/* compiled from: LocalAsyncImagePreviewHandler.kt */
final class AsyncImagePreviewHandler$Companion$Default$1$handle$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AsyncImagePreviewHandler$Companion$Default$1 this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AsyncImagePreviewHandler$Companion$Default$1$handle$1(AsyncImagePreviewHandler$Companion$Default$1 asyncImagePreviewHandler$Companion$Default$1, Continuation<? super AsyncImagePreviewHandler$Companion$Default$1$handle$1> continuation) {
        super(continuation);
        this.this$0 = asyncImagePreviewHandler$Companion$Default$1;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.handle((ImageLoader) null, (ImageRequest) null, this);
    }
}
