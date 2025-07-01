package coil3.compose;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "coil3.compose.ConstraintsSizeResolver", f = "ConstraintsSizeResolver.kt", i = {}, l = {38}, m = "size", n = {}, s = {})
/* compiled from: ConstraintsSizeResolver.kt */
final class ConstraintsSizeResolver$size$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ConstraintsSizeResolver this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ConstraintsSizeResolver$size$1(ConstraintsSizeResolver constraintsSizeResolver, Continuation<? super ConstraintsSizeResolver$size$1> continuation) {
        super(continuation);
        this.this$0 = constraintsSizeResolver;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.size(this);
    }
}
