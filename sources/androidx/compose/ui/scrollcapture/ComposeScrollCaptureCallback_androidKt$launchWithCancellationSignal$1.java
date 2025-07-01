package androidx.compose.ui.scrollcapture;

import android.os.CancellationSignal;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "cause", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: ComposeScrollCaptureCallback.android.kt */
final class ComposeScrollCaptureCallback_androidKt$launchWithCancellationSignal$1 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ CancellationSignal $signal;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ComposeScrollCaptureCallback_androidKt$launchWithCancellationSignal$1(CancellationSignal cancellationSignal) {
        super(1);
        this.$signal = cancellationSignal;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Throwable th) {
        if (th != null) {
            this.$signal.cancel();
        }
    }
}
