package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.Handle;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidSelectionHandles.android.kt */
final class AndroidSelectionHandles_androidKt$SelectionHandle$semanticsModifier$1$1 extends Lambda implements Function1<SemanticsPropertyReceiver, Unit> {
    final /* synthetic */ boolean $isLeft;
    final /* synthetic */ boolean $isStartHandle;
    final /* synthetic */ OffsetProvider $offsetProvider;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AndroidSelectionHandles_androidKt$SelectionHandle$semanticsModifier$1$1(OffsetProvider offsetProvider, boolean z, boolean z2) {
        super(1);
        this.$offsetProvider = offsetProvider;
        this.$isStartHandle = z;
        this.$isLeft = z2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((SemanticsPropertyReceiver) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        long r3 = this.$offsetProvider.m1569provideF1C5BW0();
        semanticsPropertyReceiver.set(SelectionHandlesKt.getSelectionHandleInfoKey(), new SelectionHandleInfo(this.$isStartHandle ? Handle.SelectionStart : Handle.SelectionEnd, r3, this.$isLeft ? SelectionHandleAnchor.Left : SelectionHandleAnchor.Right, OffsetKt.m4006isSpecifiedk4lQ0M(r3), (DefaultConstructorMarker) null));
    }
}
