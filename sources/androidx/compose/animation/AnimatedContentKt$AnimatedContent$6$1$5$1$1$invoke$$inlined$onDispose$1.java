package androidx.compose.animation;

import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004¸\u0006\u0000"}, d2 = {"androidx/compose/runtime/DisposableEffectScope$onDispose$1", "Landroidx/compose/runtime/DisposableEffectResult;", "dispose", "", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Effects.kt */
public final class AnimatedContentKt$AnimatedContent$6$1$5$1$1$invoke$$inlined$onDispose$1 implements DisposableEffectResult {
    final /* synthetic */ SnapshotStateList $currentlyVisible$inlined;
    final /* synthetic */ AnimatedContentTransitionScopeImpl $rootScope$inlined;
    final /* synthetic */ Object $stateForContent$inlined;

    public AnimatedContentKt$AnimatedContent$6$1$5$1$1$invoke$$inlined$onDispose$1(SnapshotStateList snapshotStateList, Object obj, AnimatedContentTransitionScopeImpl animatedContentTransitionScopeImpl) {
        this.$currentlyVisible$inlined = snapshotStateList;
        this.$stateForContent$inlined = obj;
        this.$rootScope$inlined = animatedContentTransitionScopeImpl;
    }

    public void dispose() {
        this.$currentlyVisible$inlined.remove(this.$stateForContent$inlined);
        this.$rootScope$inlined.getTargetSizeMap$animation_release().remove(this.$stateForContent$inlined);
    }
}
