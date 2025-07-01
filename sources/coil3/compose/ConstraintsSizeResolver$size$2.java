package coil3.compose;

import androidx.compose.ui.unit.Constraints;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Landroidx/compose/ui/unit/Constraints;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "coil3.compose.ConstraintsSizeResolver$size$2", f = "ConstraintsSizeResolver.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: ConstraintsSizeResolver.kt */
final class ConstraintsSizeResolver$size$2 extends SuspendLambda implements Function2<Constraints, Continuation<? super Boolean>, Object> {
    /* synthetic */ long J$0;
    int label;

    ConstraintsSizeResolver$size$2(Continuation<? super ConstraintsSizeResolver$size$2> continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ConstraintsSizeResolver$size$2 constraintsSizeResolver$size$2 = new ConstraintsSizeResolver$size$2(continuation);
        constraintsSizeResolver$size$2.J$0 = ((Constraints) obj).m7058unboximpl();
        return constraintsSizeResolver$size$2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return m7469invokeK40F9xA(((Constraints) obj).m7058unboximpl(), (Continuation) obj2);
    }

    /* renamed from: invoke-K40F9xA  reason: not valid java name */
    public final Object m7469invokeK40F9xA(long j, Continuation<? super Boolean> continuation) {
        return ((ConstraintsSizeResolver$size$2) create(Constraints.m7040boximpl(j), continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            return Boxing.boxBoolean(!Constraints.m7056isZeroimpl(this.J$0));
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
