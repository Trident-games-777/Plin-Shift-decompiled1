package androidx.compose.animation;

import androidx.compose.animation.SharedTransitionScope;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"androidx/compose/animation/SharedTransitionScopeKt$ParentClip$1", "Landroidx/compose/animation/SharedTransitionScope$OverlayClip;", "getClipPath", "Landroidx/compose/ui/graphics/Path;", "state", "Landroidx/compose/animation/SharedTransitionScope$SharedContentState;", "bounds", "Landroidx/compose/ui/geometry/Rect;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "density", "Landroidx/compose/ui/unit/Density;", "animation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: SharedTransitionScope.kt */
public final class SharedTransitionScopeKt$ParentClip$1 implements SharedTransitionScope.OverlayClip {
    SharedTransitionScopeKt$ParentClip$1() {
    }

    public Path getClipPath(SharedTransitionScope.SharedContentState sharedContentState, Rect rect, LayoutDirection layoutDirection, Density density) {
        SharedTransitionScope.SharedContentState parentSharedContentState = sharedContentState.getParentSharedContentState();
        if (parentSharedContentState != null) {
            return parentSharedContentState.getClipPathInOverlay();
        }
        return null;
    }
}
