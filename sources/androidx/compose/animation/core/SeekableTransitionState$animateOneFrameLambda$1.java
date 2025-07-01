package androidx.compose.animation.core;

import androidx.collection.MutableObjectList;
import androidx.collection.ObjectList;
import androidx.compose.animation.core.SeekableTransitionState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.math.MathKt;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "S", "frameTimeNanos", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Transition.kt */
final class SeekableTransitionState$animateOneFrameLambda$1 extends Lambda implements Function1<Long, Unit> {
    final /* synthetic */ SeekableTransitionState<S> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SeekableTransitionState$animateOneFrameLambda$1(SeekableTransitionState<S> seekableTransitionState) {
        super(1);
        this.this$0 = seekableTransitionState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Number) obj).longValue());
        return Unit.INSTANCE;
    }

    public final void invoke(long j) {
        this.this$0.lastFrameTimeNanos = j;
        long roundToLong = MathKt.roundToLong(((double) (j - this.this$0.lastFrameTimeNanos)) / ((double) this.this$0.durationScale));
        if (this.this$0.initialValueAnimations.isNotEmpty()) {
            ObjectList access$getInitialValueAnimations$p = this.this$0.initialValueAnimations;
            SeekableTransitionState<S> seekableTransitionState = this.this$0;
            Object[] objArr = access$getInitialValueAnimations$p.content;
            int i = access$getInitialValueAnimations$p._size;
            int i2 = 0;
            for (int i3 = 0; i3 < i; i3++) {
                SeekableTransitionState.SeekingAnimationState seekingAnimationState = (SeekableTransitionState.SeekingAnimationState) objArr[i3];
                seekableTransitionState.recalculateAnimationValue(seekingAnimationState, roundToLong);
                seekingAnimationState.setComplete(true);
            }
            Transition access$getTransition$p = this.this$0.transition;
            if (access$getTransition$p != null) {
                access$getTransition$p.updateInitialValues$animation_core_release();
            }
            MutableObjectList access$getInitialValueAnimations$p2 = this.this$0.initialValueAnimations;
            int i4 = access$getInitialValueAnimations$p2._size;
            Object[] objArr2 = access$getInitialValueAnimations$p2.content;
            IntRange until = RangesKt.until(0, access$getInitialValueAnimations$p2._size);
            int first = until.getFirst();
            int last = until.getLast();
            if (first <= last) {
                while (true) {
                    objArr2[first - i2] = objArr2[first];
                    if (((SeekableTransitionState.SeekingAnimationState) objArr2[first]).isComplete()) {
                        i2++;
                    }
                    if (first == last) {
                        break;
                    }
                    first++;
                }
            }
            ArraysKt.fill((T[]) objArr2, null, i4 - i2, i4);
            access$getInitialValueAnimations$p2._size -= i2;
        }
        SeekableTransitionState.SeekingAnimationState access$getCurrentAnimation$p = this.this$0.currentAnimation;
        if (access$getCurrentAnimation$p != null) {
            access$getCurrentAnimation$p.setDurationNanos(this.this$0.getTotalDurationNanos$animation_core_release());
            this.this$0.recalculateAnimationValue(access$getCurrentAnimation$p, roundToLong);
            this.this$0.setFraction(access$getCurrentAnimation$p.getValue());
            if (access$getCurrentAnimation$p.getValue() == 1.0f) {
                this.this$0.currentAnimation = null;
            }
            this.this$0.seekToFraction();
        }
    }
}
