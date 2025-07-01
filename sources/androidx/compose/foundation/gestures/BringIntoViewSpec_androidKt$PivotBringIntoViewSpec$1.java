package androidx.compose.foundation.gestures;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.CubicBezierEasing;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0003H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003XD¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u0003XD¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0005R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0010"}, d2 = {"androidx/compose/foundation/gestures/BringIntoViewSpec_androidKt$PivotBringIntoViewSpec$1", "Landroidx/compose/foundation/gestures/BringIntoViewSpec;", "childFraction", "", "getChildFraction", "()F", "parentFraction", "getParentFraction", "scrollAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "getScrollAnimationSpec", "()Landroidx/compose/animation/core/AnimationSpec;", "calculateScrollDistance", "offset", "size", "containerSize", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: BringIntoViewSpec.android.kt */
public final class BringIntoViewSpec_androidKt$PivotBringIntoViewSpec$1 implements BringIntoViewSpec {
    private final float childFraction;
    private final float parentFraction = 0.3f;
    private final AnimationSpec<Float> scrollAnimationSpec = AnimationSpecKt.tween$default(125, 0, new CubicBezierEasing(0.25f, 0.1f, 0.25f, 1.0f), 2, (Object) null);

    BringIntoViewSpec_androidKt$PivotBringIntoViewSpec$1() {
    }

    public final float getParentFraction() {
        return this.parentFraction;
    }

    public final float getChildFraction() {
        return this.childFraction;
    }

    public AnimationSpec<Float> getScrollAnimationSpec() {
        return this.scrollAnimationSpec;
    }

    public float calculateScrollDistance(float f, float f2, float f3) {
        float abs = Math.abs((f2 + f) - f);
        boolean z = abs <= f3;
        float f4 = (this.parentFraction * f3) - (this.childFraction * abs);
        float f5 = f3 - f4;
        if (z && f5 < abs) {
            f4 = f3 - abs;
        }
        return f - f4;
    }
}
