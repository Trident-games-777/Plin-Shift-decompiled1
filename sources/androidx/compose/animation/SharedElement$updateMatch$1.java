package androidx.compose.animation;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroidx/compose/animation/SharedElement;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: SharedElement.kt */
final class SharedElement$updateMatch$1 extends Lambda implements Function1<SharedElement, Unit> {
    final /* synthetic */ SharedElement this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SharedElement$updateMatch$1(SharedElement sharedElement) {
        super(1);
        this.this$0 = sharedElement;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((SharedElement) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(SharedElement sharedElement) {
        this.this$0.updateMatch();
    }
}
