package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: ModalBottomSheet.kt */
final class ModalBottomSheetKt$ModalBottomSheet$settleToDismiss$1$1 extends Lambda implements Function1<Float, Unit> {
    final /* synthetic */ Function0<Unit> $onDismissRequest;
    final /* synthetic */ CoroutineScope $scope;
    final /* synthetic */ SheetState $sheetState;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ModalBottomSheetKt$ModalBottomSheet$settleToDismiss$1$1(CoroutineScope coroutineScope, SheetState sheetState, Function0<Unit> function0) {
        super(1);
        this.$scope = coroutineScope;
        this.$sheetState = sheetState;
        this.$onDismissRequest = function0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Number) obj).floatValue());
        return Unit.INSTANCE;
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.material3.ModalBottomSheetKt$ModalBottomSheet$settleToDismiss$1$1$1", f = "ModalBottomSheet.kt", i = {}, l = {148}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.material3.ModalBottomSheetKt$ModalBottomSheet$settleToDismiss$1$1$1  reason: invalid class name */
    /* compiled from: ModalBottomSheet.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(sheetState, f, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (sheetState.settle$material3_release(f, this) == coroutine_suspended) {
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

    public final void invoke(final float f) {
        CoroutineScope coroutineScope = this.$scope;
        final SheetState sheetState = this.$sheetState;
        Job launch$default = BuildersKt__Builders_commonKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1((Continuation<? super AnonymousClass1>) null), 3, (Object) null);
        final SheetState sheetState2 = this.$sheetState;
        final Function0<Unit> function0 = this.$onDismissRequest;
        launch$default.invokeOnCompletion(new Function1<Throwable, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Throwable) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Throwable th) {
                if (!sheetState2.isVisible()) {
                    function0.invoke();
                }
            }
        });
    }
}
