package androidx.compose.material3;

import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputScope;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.material3.ModalBottomSheetKt$Scrim$dismissSheet$1$1", f = "ModalBottomSheet.kt", i = {}, l = {415}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: ModalBottomSheet.kt */
final class ModalBottomSheetKt$Scrim$dismissSheet$1$1 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Unit> $onDismissRequest;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ModalBottomSheetKt$Scrim$dismissSheet$1$1(Function0<Unit> function0, Continuation<? super ModalBottomSheetKt$Scrim$dismissSheet$1$1> continuation) {
        super(2, continuation);
        this.$onDismissRequest = function0;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ModalBottomSheetKt$Scrim$dismissSheet$1$1 modalBottomSheetKt$Scrim$dismissSheet$1$1 = new ModalBottomSheetKt$Scrim$dismissSheet$1$1(this.$onDismissRequest, continuation);
        modalBottomSheetKt$Scrim$dismissSheet$1$1.L$0 = obj;
        return modalBottomSheetKt$Scrim$dismissSheet$1$1;
    }

    public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
        return ((ModalBottomSheetKt$Scrim$dismissSheet$1$1) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final Function0<Unit> function0 = this.$onDismissRequest;
            this.label = 1;
            if (TapGestureDetectorKt.detectTapGestures$default((PointerInputScope) this.L$0, (Function1) null, (Function1) null, (Function3) null, new Function1<Offset, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    m2223invokek4lQ0M(((Offset) obj).m3997unboximpl());
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke-k-4lQ0M  reason: not valid java name */
                public final void m2223invokek4lQ0M(long j) {
                    function0.invoke();
                }
            }, this, 7, (Object) null) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
