package coil3.network.okhttp.internal;

import coil3.network.NetworkRequestBody;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "coil3.network.okhttp.internal.UtilsKt", f = "utils.kt", i = {0}, l = {39}, m = "readByteString", n = {"buffer"}, s = {"L$0"})
/* compiled from: utils.kt */
final class UtilsKt$readByteString$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    UtilsKt$readByteString$1(Continuation<? super UtilsKt$readByteString$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return UtilsKt.readByteString((NetworkRequestBody) null, this);
    }
}
