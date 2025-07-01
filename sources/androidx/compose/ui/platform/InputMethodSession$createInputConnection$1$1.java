package androidx.compose.ui.platform;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.text.input.NullableInputConnectionWrapper;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "closedConnection", "Landroidx/compose/ui/text/input/NullableInputConnectionWrapper;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidPlatformTextInputSession.android.kt */
final class InputMethodSession$createInputConnection$1$1 extends Lambda implements Function1<NullableInputConnectionWrapper, Unit> {
    final /* synthetic */ InputMethodSession this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InputMethodSession$createInputConnection$1$1(InputMethodSession inputMethodSession) {
        super(1);
        this.this$0 = inputMethodSession;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((NullableInputConnectionWrapper) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(NullableInputConnectionWrapper nullableInputConnectionWrapper) {
        int i;
        nullableInputConnectionWrapper.disposeDelegate();
        MutableVector access$getConnections$p = this.this$0.connections;
        int size = access$getConnections$p.getSize();
        if (size > 0) {
            Object[] content = access$getConnections$p.getContent();
            i = 0;
            while (true) {
                if (Intrinsics.areEqual((Object) (WeakReference) content[i], (Object) nullableInputConnectionWrapper)) {
                    break;
                }
                i++;
                if (i >= size) {
                    break;
                }
            }
        } else {
            i = -1;
        }
        if (i >= 0) {
            this.this$0.connections.removeAt(i);
        }
        if (this.this$0.connections.isEmpty()) {
            this.this$0.onAllConnectionsClosed.invoke();
        }
    }
}
