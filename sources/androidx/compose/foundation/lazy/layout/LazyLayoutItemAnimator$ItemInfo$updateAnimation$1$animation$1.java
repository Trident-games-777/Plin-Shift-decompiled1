package androidx.compose.foundation.lazy.layout;

import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.DrawModifierNodeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "T", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasuredItem;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyLayoutItemAnimator.kt */
final class LazyLayoutItemAnimator$ItemInfo$updateAnimation$1$animation$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ LazyLayoutItemAnimator<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyLayoutItemAnimator$ItemInfo$updateAnimation$1$animation$1(LazyLayoutItemAnimator<T> lazyLayoutItemAnimator) {
        super(0);
        this.this$0 = lazyLayoutItemAnimator;
    }

    public final void invoke() {
        DrawModifierNode access$getDisplayingNode$p = this.this$0.displayingNode;
        if (access$getDisplayingNode$p != null) {
            DrawModifierNodeKt.invalidateDraw(access$getDisplayingNode$p);
        }
    }
}
