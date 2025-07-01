package androidx.compose.ui.focus;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.PinnableContainer;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0015\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0002\u0010\bJ\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0015H\u0016R \u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00070\nX\u0004¢\u0006\b\n\u0000\u0012\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00070\nX\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\bR\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Landroidx/compose/ui/focus/FocusRestorerNode;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "Landroidx/compose/ui/focus/FocusPropertiesModifierNode;", "Landroidx/compose/ui/focus/FocusRequesterModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "onRestoreFailed", "Lkotlin/Function0;", "Landroidx/compose/ui/focus/FocusRequester;", "(Lkotlin/jvm/functions/Function0;)V", "onEnter", "Lkotlin/Function1;", "Landroidx/compose/ui/focus/FocusDirection;", "getOnEnter$annotations", "()V", "onExit", "getOnRestoreFailed", "()Lkotlin/jvm/functions/Function0;", "setOnRestoreFailed", "pinnedHandle", "Landroidx/compose/ui/layout/PinnableContainer$PinnedHandle;", "applyFocusProperties", "", "focusProperties", "Landroidx/compose/ui/focus/FocusProperties;", "onDetach", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: FocusRestorer.kt */
public final class FocusRestorerNode extends Modifier.Node implements CompositionLocalConsumerModifierNode, FocusPropertiesModifierNode, FocusRequesterModifierNode {
    public static final int $stable = 8;
    private final Function1<FocusDirection, FocusRequester> onEnter = new FocusRestorerNode$onEnter$1(this);
    private final Function1<FocusDirection, FocusRequester> onExit = new FocusRestorerNode$onExit$1(this);
    private Function0<FocusRequester> onRestoreFailed;
    /* access modifiers changed from: private */
    public PinnableContainer.PinnedHandle pinnedHandle;

    private static /* synthetic */ void getOnEnter$annotations() {
    }

    public final Function0<FocusRequester> getOnRestoreFailed() {
        return this.onRestoreFailed;
    }

    public final void setOnRestoreFailed(Function0<FocusRequester> function0) {
        this.onRestoreFailed = function0;
    }

    public FocusRestorerNode(Function0<FocusRequester> function0) {
        this.onRestoreFailed = function0;
    }

    public void applyFocusProperties(FocusProperties focusProperties) {
        focusProperties.setEnter(this.onEnter);
        focusProperties.setExit(this.onExit);
    }

    public void onDetach() {
        PinnableContainer.PinnedHandle pinnedHandle2 = this.pinnedHandle;
        if (pinnedHandle2 != null) {
            pinnedHandle2.release();
        }
        this.pinnedHandle = null;
        super.onDetach();
    }
}
