package androidx.compose.foundation.lazy.layout;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.animation.core.VisibilityThresholdsKt;
import androidx.compose.ui.unit.IntOffset;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0003"}, d2 = {"InterruptionSpec", "Landroidx/compose/animation/core/SpringSpec;", "Landroidx/compose/ui/unit/IntOffset;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyLayoutItemAnimation.kt */
public final class LazyLayoutItemAnimationKt {
    /* access modifiers changed from: private */
    public static final SpringSpec<IntOffset> InterruptionSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntOffset.m7232boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.Companion)), 1, (Object) null);
}
