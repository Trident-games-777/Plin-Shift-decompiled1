package androidx.compose.foundation;

import androidx.compose.foundation.interaction.FocusInteraction;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u000b\u001a\u00020\fH\u0002J\u000e\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\bJ\u0010\u0010\u000f\u001a\u00020\f2\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003J\u0014\u0010\u0010\u001a\u00020\f*\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0012H\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Landroidx/compose/foundation/FocusableInteractionNode;", "Landroidx/compose/ui/Modifier$Node;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(Landroidx/compose/foundation/interaction/MutableInteractionSource;)V", "focusedInteraction", "Landroidx/compose/foundation/interaction/FocusInteraction$Focus;", "shouldAutoInvalidate", "", "getShouldAutoInvalidate", "()Z", "disposeInteractionSource", "", "setFocus", "isFocused", "update", "emitWithFallback", "interaction", "Landroidx/compose/foundation/interaction/Interaction;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Focusable.kt */
final class FocusableInteractionNode extends Modifier.Node {
    private FocusInteraction.Focus focusedInteraction;
    private MutableInteractionSource interactionSource;
    private final boolean shouldAutoInvalidate;

    public FocusableInteractionNode(MutableInteractionSource mutableInteractionSource) {
        this.interactionSource = mutableInteractionSource;
    }

    public boolean getShouldAutoInvalidate() {
        return this.shouldAutoInvalidate;
    }

    public final void setFocus(boolean z) {
        MutableInteractionSource mutableInteractionSource = this.interactionSource;
        if (mutableInteractionSource == null) {
            return;
        }
        if (z) {
            FocusInteraction.Focus focus = this.focusedInteraction;
            if (focus != null) {
                emitWithFallback(mutableInteractionSource, new FocusInteraction.Unfocus(focus));
                this.focusedInteraction = null;
            }
            FocusInteraction.Focus focus2 = new FocusInteraction.Focus();
            emitWithFallback(mutableInteractionSource, focus2);
            this.focusedInteraction = focus2;
            return;
        }
        FocusInteraction.Focus focus3 = this.focusedInteraction;
        if (focus3 != null) {
            emitWithFallback(mutableInteractionSource, new FocusInteraction.Unfocus(focus3));
            this.focusedInteraction = null;
        }
    }

    public final void update(MutableInteractionSource mutableInteractionSource) {
        if (!Intrinsics.areEqual((Object) this.interactionSource, (Object) mutableInteractionSource)) {
            disposeInteractionSource();
            this.interactionSource = mutableInteractionSource;
        }
    }

    private final void disposeInteractionSource() {
        FocusInteraction.Focus focus;
        MutableInteractionSource mutableInteractionSource = this.interactionSource;
        if (!(mutableInteractionSource == null || (focus = this.focusedInteraction) == null)) {
            mutableInteractionSource.tryEmit(new FocusInteraction.Unfocus(focus));
        }
        this.focusedInteraction = null;
    }

    private final void emitWithFallback(MutableInteractionSource mutableInteractionSource, Interaction interaction) {
        if (isAttached()) {
            Job job = (Job) getCoroutineScope().getCoroutineContext().get(Job.Key);
            Job unused = BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), (CoroutineContext) null, (CoroutineStart) null, new FocusableInteractionNode$emitWithFallback$1(mutableInteractionSource, interaction, job != null ? job.invokeOnCompletion(new FocusableInteractionNode$emitWithFallback$handler$1(mutableInteractionSource, interaction)) : null, (Continuation<? super FocusableInteractionNode$emitWithFallback$1>) null), 3, (Object) null);
            return;
        }
        mutableInteractionSource.tryEmit(interaction);
    }
}
