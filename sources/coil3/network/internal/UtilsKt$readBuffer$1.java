package coil3.network.internal;

import coil3.network.NetworkResponseBody;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "coil3.network.internal.UtilsKt", f = "utils.kt", i = {0}, l = {31}, m = "readBuffer", n = {"buffer"}, s = {"L$1"})
/* compiled from: utils.kt */
final class UtilsKt$readBuffer$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    UtilsKt$readBuffer$1(Continuation<? super UtilsKt$readBuffer$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return UtilsKt.readBuffer((NetworkResponseBody) null, this);
    }
}
