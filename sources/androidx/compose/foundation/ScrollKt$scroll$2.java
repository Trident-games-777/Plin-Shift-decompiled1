package androidx.compose.foundation;

import androidx.compose.foundation.gestures.BringIntoViewSpec;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/ui/Modifier;", "invoke", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Scroll.kt */
final class ScrollKt$scroll$2 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {
    final /* synthetic */ FlingBehavior $flingBehavior;
    final /* synthetic */ boolean $isScrollable;
    final /* synthetic */ boolean $isVertical;
    final /* synthetic */ boolean $reverseScrolling;
    final /* synthetic */ ScrollState $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ScrollKt$scroll$2(ScrollState scrollState, boolean z, FlingBehavior flingBehavior, boolean z2, boolean z3) {
        super(3);
        this.$state = scrollState;
        this.$reverseScrolling = z;
        this.$flingBehavior = flingBehavior;
        this.$isScrollable = z2;
        this.$isVertical = z3;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
    }

    public final Modifier invoke(Modifier modifier, Composer composer, int i) {
        composer.startReplaceGroup(1478351300);
        ComposerKt.sourceInformation(composer, "C286@10609L368:Scroll.kt#71ulvw");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1478351300, i, -1, "androidx.compose.foundation.scroll.<anonymous> (Scroll.kt:276)");
        }
        Composer composer2 = composer;
        Modifier then = ScrollingContainerKt.scrollingContainer(Modifier.Companion.then(new ScrollSemanticsElement(this.$state, this.$reverseScrolling, this.$flingBehavior, this.$isScrollable, this.$isVertical)), this.$state, this.$isVertical ? Orientation.Vertical : Orientation.Horizontal, this.$isScrollable, this.$reverseScrolling, this.$flingBehavior, this.$state.getInternalInteractionSource$foundation_release(), (BringIntoViewSpec) null, composer2, 0, 64).then(new ScrollingLayoutElement(this.$state, this.$reverseScrolling, this.$isVertical));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer2.endReplaceGroup();
        return then;
    }
}
