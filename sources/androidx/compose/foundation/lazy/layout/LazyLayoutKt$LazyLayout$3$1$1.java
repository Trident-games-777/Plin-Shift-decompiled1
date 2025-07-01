package androidx.compose.foundation.lazy.layout;

import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.ui.layout.SubcomposeLayoutState;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/runtime/DisposableEffectResult;", "Landroidx/compose/runtime/DisposableEffectScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyLayout.kt */
final class LazyLayoutKt$LazyLayout$3$1$1 extends Lambda implements Function1<DisposableEffectScope, DisposableEffectResult> {
    final /* synthetic */ PrefetchScheduler $executor;
    final /* synthetic */ LazyLayoutItemContentFactory $itemContentFactory;
    final /* synthetic */ LazyLayoutPrefetchState $prefetchState;
    final /* synthetic */ SubcomposeLayoutState $subcomposeLayoutState;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyLayoutKt$LazyLayout$3$1$1(LazyLayoutPrefetchState lazyLayoutPrefetchState, LazyLayoutItemContentFactory lazyLayoutItemContentFactory, SubcomposeLayoutState subcomposeLayoutState, PrefetchScheduler prefetchScheduler) {
        super(1);
        this.$prefetchState = lazyLayoutPrefetchState;
        this.$itemContentFactory = lazyLayoutItemContentFactory;
        this.$subcomposeLayoutState = subcomposeLayoutState;
        this.$executor = prefetchScheduler;
    }

    public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
        this.$prefetchState.setPrefetchHandleProvider$foundation_release(new PrefetchHandleProvider(this.$itemContentFactory, this.$subcomposeLayoutState, this.$executor));
        return new LazyLayoutKt$LazyLayout$3$1$1$invoke$$inlined$onDispose$1(this.$prefetchState);
    }
}
