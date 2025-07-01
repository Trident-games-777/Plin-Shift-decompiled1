package androidx.compose.ui.viewinterop;

import androidx.compose.ui.focus.FocusDirection;
import androidx.compose.ui.focus.FocusRequester;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: FocusGroupNode.android.kt */
/* synthetic */ class FocusGroupPropertiesNode$applyFocusProperties$1 extends FunctionReferenceImpl implements Function1<FocusDirection, FocusRequester> {
    FocusGroupPropertiesNode$applyFocusProperties$1(Object obj) {
        super(1, obj, FocusGroupPropertiesNode.class, "onEnter", "onEnter-3ESFkO8(I)Landroidx/compose/ui/focus/FocusRequester;", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return m7366invoke3ESFkO8(((FocusDirection) obj).m3895unboximpl());
    }

    /* renamed from: invoke-3ESFkO8  reason: not valid java name */
    public final FocusRequester m7366invoke3ESFkO8(int i) {
        return ((FocusGroupPropertiesNode) this.receiver).m7364onEnter3ESFkO8(i);
    }
}
