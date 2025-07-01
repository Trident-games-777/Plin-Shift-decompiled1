package coil3.size;

import android.view.ViewTreeObserver;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* compiled from: ViewSizeResolver.kt */
final class ViewSizeResolver$size$3$1 implements Function1<Throwable, Unit> {
    final /* synthetic */ ViewSizeResolver$size$3$preDrawListener$1 $preDrawListener;
    final /* synthetic */ ViewTreeObserver $viewTreeObserver;
    final /* synthetic */ ViewSizeResolver<T> this$0;

    ViewSizeResolver$size$3$1(ViewSizeResolver<T> viewSizeResolver, ViewTreeObserver viewTreeObserver, ViewSizeResolver$size$3$preDrawListener$1 viewSizeResolver$size$3$preDrawListener$1) {
        this.this$0 = viewSizeResolver;
        this.$viewTreeObserver = viewTreeObserver;
        this.$preDrawListener = viewSizeResolver$size$3$preDrawListener$1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Throwable th) {
        this.this$0.removePreDrawListenerSafe(this.$viewTreeObserver, this.$preDrawListener);
    }
}
