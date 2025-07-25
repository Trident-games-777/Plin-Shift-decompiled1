package androidx.compose.foundation.text.input.internal;

import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0012\u001a\u00020\u0011H@¢\u0006\u0002\u0010\u0013R\"\u0010\u0003\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004j\n\u0012\u0006\u0012\u0004\u0018\u00010\u0005`\u0006X\u000e¢\u0006\u0002\n\u0000R+\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8F@BX\u0002¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0014"}, d2 = {"Landroidx/compose/foundation/text/input/internal/CursorAnimationState;", "", "()V", "animationJob", "Ljava/util/concurrent/atomic/AtomicReference;", "Lkotlinx/coroutines/Job;", "Landroidx/compose/foundation/AtomicReference;", "<set-?>", "", "cursorAlpha", "getCursorAlpha", "()F", "setCursorAlpha", "(F)V", "cursorAlpha$delegate", "Landroidx/compose/runtime/MutableFloatState;", "cancelAndHide", "", "snapToVisibleAndAnimate", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: CursorAnimationState.kt */
public final class CursorAnimationState {
    public static final int $stable = 8;
    /* access modifiers changed from: private */
    public AtomicReference<Job> animationJob = new AtomicReference<>((Object) null);
    private final MutableFloatState cursorAlpha$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);

    /* access modifiers changed from: private */
    public final void setCursorAlpha(float f) {
        this.cursorAlpha$delegate.setFloatValue(f);
    }

    public final float getCursorAlpha() {
        return this.cursorAlpha$delegate.getFloatValue();
    }

    public final Object snapToVisibleAndAnimate(Continuation<? super Unit> continuation) {
        Object coroutineScope = CoroutineScopeKt.coroutineScope(new CursorAnimationState$snapToVisibleAndAnimate$2(this, (Continuation<? super CursorAnimationState$snapToVisibleAndAnimate$2>) null), continuation);
        return coroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? coroutineScope : Unit.INSTANCE;
    }

    public final void cancelAndHide() {
        Job andSet = this.animationJob.getAndSet((Object) null);
        if (andSet != null) {
            Job.DefaultImpls.cancel$default(andSet, (CancellationException) null, 1, (Object) null);
        }
    }
}
