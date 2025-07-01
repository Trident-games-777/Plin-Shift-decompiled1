package coil3.decode;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "coil3.decode.StaticImageDecoder", f = "StaticImageDecoder.kt", i = {0, 0}, l = {157}, m = "decode", n = {"this", "$this$withPermit$iv"}, s = {"L$0", "L$1"})
/* compiled from: StaticImageDecoder.kt */
final class StaticImageDecoder$decode$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ StaticImageDecoder this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    StaticImageDecoder$decode$1(StaticImageDecoder staticImageDecoder, Continuation<? super StaticImageDecoder$decode$1> continuation) {
        super(continuation);
        this.this$0 = staticImageDecoder;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.decode(this);
    }
}
