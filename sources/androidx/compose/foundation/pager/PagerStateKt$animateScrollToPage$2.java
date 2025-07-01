package androidx.compose.foundation.pager;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.SuspendAnimationKt;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.lazy.layout.LazyLayoutAnimateScrollScope;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/ScrollScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.pager.PagerStateKt$animateScrollToPage$2", f = "PagerState.kt", i = {}, l = {953}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: PagerState.kt */
final class PagerStateKt$animateScrollToPage$2 extends SuspendLambda implements Function2<ScrollScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AnimationSpec<Float> $animationSpec;
    final /* synthetic */ int $targetPage;
    final /* synthetic */ float $targetPageOffsetToSnappedPosition;
    final /* synthetic */ LazyLayoutAnimateScrollScope $this_animateScrollToPage;
    final /* synthetic */ Function2<ScrollScope, Integer, Unit> $updateTargetPage;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PagerStateKt$animateScrollToPage$2(Function2<? super ScrollScope, ? super Integer, Unit> function2, int i, LazyLayoutAnimateScrollScope lazyLayoutAnimateScrollScope, float f, AnimationSpec<Float> animationSpec, Continuation<? super PagerStateKt$animateScrollToPage$2> continuation) {
        super(2, continuation);
        this.$updateTargetPage = function2;
        this.$targetPage = i;
        this.$this_animateScrollToPage = lazyLayoutAnimateScrollScope;
        this.$targetPageOffsetToSnappedPosition = f;
        this.$animationSpec = animationSpec;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        PagerStateKt$animateScrollToPage$2 pagerStateKt$animateScrollToPage$2 = new PagerStateKt$animateScrollToPage$2(this.$updateTargetPage, this.$targetPage, this.$this_animateScrollToPage, this.$targetPageOffsetToSnappedPosition, this.$animationSpec, continuation);
        pagerStateKt$animateScrollToPage$2.L$0 = obj;
        return pagerStateKt$animateScrollToPage$2;
    }

    public final Object invoke(ScrollScope scrollScope, Continuation<? super Unit> continuation) {
        return ((PagerStateKt$animateScrollToPage$2) create(scrollScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        int i;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            final ScrollScope scrollScope = (ScrollScope) this.L$0;
            this.$updateTargetPage.invoke(scrollScope, Boxing.boxInt(this.$targetPage));
            boolean z = this.$targetPage > this.$this_animateScrollToPage.getFirstVisibleItemIndex();
            int lastVisibleItemIndex = (this.$this_animateScrollToPage.getLastVisibleItemIndex() - this.$this_animateScrollToPage.getFirstVisibleItemIndex()) + 1;
            if (((z && this.$targetPage > this.$this_animateScrollToPage.getLastVisibleItemIndex()) || (!z && this.$targetPage < this.$this_animateScrollToPage.getFirstVisibleItemIndex())) && Math.abs(this.$targetPage - this.$this_animateScrollToPage.getFirstVisibleItemIndex()) >= 3) {
                if (z) {
                    i = RangesKt.coerceAtLeast(this.$targetPage - lastVisibleItemIndex, this.$this_animateScrollToPage.getFirstVisibleItemIndex());
                } else {
                    i = RangesKt.coerceAtMost(this.$targetPage + lastVisibleItemIndex, this.$this_animateScrollToPage.getFirstVisibleItemIndex());
                }
                this.$this_animateScrollToPage.snapToItem(scrollScope, i, 0);
            }
            float calculateDistanceTo = this.$this_animateScrollToPage.calculateDistanceTo(this.$targetPage) + this.$targetPageOffsetToSnappedPosition;
            final Ref.FloatRef floatRef = new Ref.FloatRef();
            this.label = 1;
            if (SuspendAnimationKt.animate$default(0.0f, calculateDistanceTo, 0.0f, this.$animationSpec, new Function2<Float, Float, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke(((Number) obj).floatValue(), ((Number) obj2).floatValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(float f, float f2) {
                    floatRef.element += scrollScope.scrollBy(f - floatRef.element);
                }
            }, this, 4, (Object) null) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i2 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
