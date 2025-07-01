package androidx.compose.foundation.text.input.internal;

import android.view.KeyEvent;
import androidx.compose.foundation.content.internal.ReceiveContentConfiguration;
import androidx.compose.foundation.content.internal.ReceiveContentConfigurationKt;
import androidx.compose.foundation.interaction.HoverInteraction;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.foundation.text.handwriting.StylusHandwritingNode;
import androidx.compose.foundation.text.handwriting.StylusHandwriting_androidKt;
import androidx.compose.foundation.text.input.InputTransformation;
import androidx.compose.foundation.text.input.KeyboardActionHandler;
import androidx.compose.foundation.text.input.TextFieldCharSequence;
import androidx.compose.foundation.text.input.TextFieldState;
import androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState;
import androidx.compose.foundation.text.input.internal.undo.TextFieldEditUndoBehavior;
import androidx.compose.ui.draganddrop.DragAndDropModifierNode;
import androidx.compose.ui.focus.FocusEventModifierNode;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.focus.FocusRequesterModifierNode;
import androidx.compose.ui.focus.FocusState;
import androidx.compose.ui.input.key.KeyInputModifierNode;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNode;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.modifier.ModifierLocalModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.GlobalPositionAwareModifierNode;
import androidx.compose.ui.node.LayoutAwareModifierNode;
import androidx.compose.ui.node.ObserverModifierNode;
import androidx.compose.ui.node.ObserverModifierNodeKt;
import androidx.compose.ui.node.PointerInputModifierNode;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.node.SemanticsModifierNodeKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.PlatformTextInputModifierNode;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import androidx.compose.ui.platform.WindowInfo;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.ImeAction;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

@Metadata(d1 = {"\u0000\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000*\u0001>\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\b2\u00020\t2\u00020\n2\u00020\u000b2\u00020\fBY\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\u0006\u0010\u0015\u001a\u00020\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\u0006\u0010\u0018\u001a\u00020\u0019\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\u0006\u0010\u001c\u001a\u00020\u0016\u0012\u0006\u0010\u001d\u001a\u00020\u001e¢\u0006\u0002\u0010\u001fJ\b\u0010d\u001a\u00020\"H\u0002J\b\u0010e\u001a\u00020\"H\u0002J\b\u0010f\u001a\u00020\"H\u0016J\b\u0010g\u001a\u00020\"H\u0016J\b\u0010h\u001a\u00020\"H\u0016J\b\u0010i\u001a\u00020\"H\u0002J\u0010\u0010j\u001a\u00020\"2\u0006\u0010k\u001a\u00020lH\u0016J\u0010\u0010m\u001a\u00020\"2\u0006\u0010n\u001a\u00020oH\u0016J\u001a\u0010p\u001a\u00020\"2\u0006\u0010q\u001a\u00020rH\u0002ø\u0001\u0000¢\u0006\u0004\bs\u0010tJ\u001a\u0010u\u001a\u00020\u00162\u0006\u0010v\u001a\u00020wH\u0016ø\u0001\u0000¢\u0006\u0004\bx\u0010yJ\b\u0010z\u001a\u00020\"H\u0016J.\u0010{\u001a\u00020\"2\u0006\u0010|\u001a\u00020}2\u0006\u0010~\u001a\u000202\b\u0010\u0001\u001a\u00030\u0001H\u0016ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J\u001c\u0010\u0001\u001a\u00020\u00162\u0006\u0010v\u001a\u00020wH\u0016ø\u0001\u0000¢\u0006\u0005\b\u0001\u0010yJ\n\u0010\u0001\u001a\u00030\u0001H\u0002J\u0012\u0010\u0001\u001a\u00020\"2\u0007\u0010\u0001\u001a\u00020\u0016H\u0002J[\u0010\u0001\u001a\u00020\"2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u001eJ\u000e\u0010\u0001\u001a\u00020\"*\u00030\u0001H\u0016R\u0016\u0010 \u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010!X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010'\u001a\u00020\u00168BX\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)R\u001a\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010)\"\u0004\b+\u0010,R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u0010\u00101\u001a\u0004\u0018\u000102X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001d\u001a\u00020\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u000e\u00107\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u0014\u00108\u001a\u00020\u00168BX\u0004¢\u0006\u0006\u001a\u0004\b8\u0010)R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u0010\u0010=\u001a\u00020>X\u0004¢\u0006\u0004\n\u0002\u0010?R\u001e\u0010\u0018\u001a\u00020\u00192\u0006\u0010@\u001a\u00020\u0019@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\bA\u0010BR\u0010\u0010C\u001a\u0004\u0018\u000102X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020EX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010)\"\u0004\bG\u0010,R\u0016\u0010H\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010J0IX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010K\u001a\u00020\u00168VX\u0004¢\u0006\u0006\u001a\u0004\bL\u0010)R\u001a\u0010\u001c\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010)\"\u0004\bN\u0010,R\u000e\u0010O\u001a\u00020PX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010Q\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010!8BX\u0004¢\u0006\u0006\u001a\u0004\bR\u0010SR\u000e\u0010T\u001a\u00020UX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR\u001a\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR\u0010\u0010b\u001a\u0004\u0018\u00010cX\u000e¢\u0006\u0002\n\u0000\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0001"}, d2 = {"Landroidx/compose/foundation/text/input/internal/TextFieldDecoratorModifierNode;", "Landroidx/compose/ui/node/DelegatingNode;", "Landroidx/compose/ui/platform/PlatformTextInputModifierNode;", "Landroidx/compose/ui/node/SemanticsModifierNode;", "Landroidx/compose/ui/focus/FocusRequesterModifierNode;", "Landroidx/compose/ui/focus/FocusEventModifierNode;", "Landroidx/compose/ui/node/GlobalPositionAwareModifierNode;", "Landroidx/compose/ui/node/PointerInputModifierNode;", "Landroidx/compose/ui/input/key/KeyInputModifierNode;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "Landroidx/compose/ui/modifier/ModifierLocalModifierNode;", "Landroidx/compose/ui/node/ObserverModifierNode;", "Landroidx/compose/ui/node/LayoutAwareModifierNode;", "textFieldState", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "textLayoutState", "Landroidx/compose/foundation/text/input/internal/TextLayoutState;", "textFieldSelectionState", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;", "filter", "Landroidx/compose/foundation/text/input/InputTransformation;", "enabled", "", "readOnly", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardOptions;", "keyboardActionHandler", "Landroidx/compose/foundation/text/input/KeyboardActionHandler;", "singleLine", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;Landroidx/compose/foundation/text/input/internal/TextLayoutState;Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;Landroidx/compose/foundation/text/input/InputTransformation;ZZLandroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/input/KeyboardActionHandler;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;)V", "backingStylusHandwritingTrigger", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "", "dragAndDropNode", "Landroidx/compose/ui/draganddrop/DragAndDropModifierNode;", "dragEnterEvent", "Landroidx/compose/foundation/interaction/HoverInteraction$Enter;", "editable", "getEditable", "()Z", "getEnabled", "setEnabled", "(Z)V", "getFilter", "()Landroidx/compose/foundation/text/input/InputTransformation;", "setFilter", "(Landroidx/compose/foundation/text/input/InputTransformation;)V", "inputSessionJob", "Lkotlinx/coroutines/Job;", "getInteractionSource", "()Landroidx/compose/foundation/interaction/MutableInteractionSource;", "setInteractionSource", "(Landroidx/compose/foundation/interaction/MutableInteractionSource;)V", "isElementFocused", "isFocused", "getKeyboardActionHandler", "()Landroidx/compose/foundation/text/input/KeyboardActionHandler;", "setKeyboardActionHandler", "(Landroidx/compose/foundation/text/input/KeyboardActionHandler;)V", "keyboardActionScope", "androidx/compose/foundation/text/input/internal/TextFieldDecoratorModifierNode$keyboardActionScope$1", "Landroidx/compose/foundation/text/input/internal/TextFieldDecoratorModifierNode$keyboardActionScope$1;", "<set-?>", "getKeyboardOptions", "()Landroidx/compose/foundation/text/KeyboardOptions;", "observeChangesJob", "pointerInputNode", "Landroidx/compose/ui/input/pointer/SuspendingPointerInputModifierNode;", "getReadOnly", "setReadOnly", "receiveContentConfigurationProvider", "Lkotlin/Function0;", "Landroidx/compose/foundation/content/internal/ReceiveContentConfiguration;", "shouldMergeDescendantSemantics", "getShouldMergeDescendantSemantics", "getSingleLine", "setSingleLine", "stylusHandwritingNode", "Landroidx/compose/foundation/text/handwriting/StylusHandwritingNode;", "stylusHandwritingTrigger", "getStylusHandwritingTrigger", "()Lkotlinx/coroutines/flow/MutableSharedFlow;", "textFieldKeyEventHandler", "Landroidx/compose/foundation/text/input/internal/TextFieldKeyEventHandler;", "getTextFieldSelectionState", "()Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;", "setTextFieldSelectionState", "(Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;)V", "getTextFieldState", "()Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "setTextFieldState", "(Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;)V", "getTextLayoutState", "()Landroidx/compose/foundation/text/input/internal/TextLayoutState;", "setTextLayoutState", "(Landroidx/compose/foundation/text/input/internal/TextLayoutState;)V", "windowInfo", "Landroidx/compose/ui/platform/WindowInfo;", "disposeInputSession", "emitDragExitEvent", "onAttach", "onCancelPointerInput", "onDetach", "onFocusChange", "onFocusEvent", "focusState", "Landroidx/compose/ui/focus/FocusState;", "onGloballyPositioned", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "onImeActionPerformed", "imeAction", "Landroidx/compose/ui/text/input/ImeAction;", "onImeActionPerformed-KlQnJC8", "(I)V", "onKeyEvent", "event", "Landroidx/compose/ui/input/key/KeyEvent;", "onKeyEvent-ZmokQxo", "(Landroid/view/KeyEvent;)Z", "onObservedReadsChanged", "onPointerEvent", "pointerEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "pass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "bounds", "Landroidx/compose/ui/unit/IntSize;", "onPointerEvent-H0pRuoY", "(Landroidx/compose/ui/input/pointer/PointerEvent;Landroidx/compose/ui/input/pointer/PointerEventPass;J)V", "onPreKeyEvent", "onPreKeyEvent-ZmokQxo", "requireKeyboardController", "Landroidx/compose/ui/platform/SoftwareKeyboardController;", "startInputSession", "fromTap", "updateNode", "applySemantics", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldDecoratorModifier.kt */
public final class TextFieldDecoratorModifierNode extends DelegatingNode implements PlatformTextInputModifierNode, SemanticsModifierNode, FocusRequesterModifierNode, FocusEventModifierNode, GlobalPositionAwareModifierNode, PointerInputModifierNode, KeyInputModifierNode, CompositionLocalConsumerModifierNode, ModifierLocalModifierNode, ObserverModifierNode, LayoutAwareModifierNode {
    public static final int $stable = 8;
    private MutableSharedFlow<Unit> backingStylusHandwritingTrigger;
    private final DragAndDropModifierNode dragAndDropNode;
    /* access modifiers changed from: private */
    public HoverInteraction.Enter dragEnterEvent;
    private boolean enabled;
    private InputTransformation filter;
    /* access modifiers changed from: private */
    public Job inputSessionJob;
    private MutableInteractionSource interactionSource;
    private boolean isElementFocused;
    private KeyboardActionHandler keyboardActionHandler;
    /* access modifiers changed from: private */
    public final TextFieldDecoratorModifierNode$keyboardActionScope$1 keyboardActionScope;
    private KeyboardOptions keyboardOptions;
    private Job observeChangesJob;
    private final SuspendingPointerInputModifierNode pointerInputNode = ((SuspendingPointerInputModifierNode) delegate(SuspendingPointerInputFilterKt.SuspendingPointerInputModifierNode(new TextFieldDecoratorModifierNode$pointerInputNode$1(this, (Continuation<? super TextFieldDecoratorModifierNode$pointerInputNode$1>) null))));
    private boolean readOnly;
    private final Function0<ReceiveContentConfiguration> receiveContentConfigurationProvider;
    private boolean singleLine;
    private final StylusHandwritingNode stylusHandwritingNode;
    private final TextFieldKeyEventHandler textFieldKeyEventHandler;
    private TextFieldSelectionState textFieldSelectionState;
    private TransformedTextFieldState textFieldState;
    private TextLayoutState textLayoutState;
    /* access modifiers changed from: private */
    public WindowInfo windowInfo;

    public boolean getShouldMergeDescendantSemantics() {
        return true;
    }

    public final TransformedTextFieldState getTextFieldState() {
        return this.textFieldState;
    }

    public final void setTextFieldState(TransformedTextFieldState transformedTextFieldState) {
        this.textFieldState = transformedTextFieldState;
    }

    public final TextLayoutState getTextLayoutState() {
        return this.textLayoutState;
    }

    public final void setTextLayoutState(TextLayoutState textLayoutState2) {
        this.textLayoutState = textLayoutState2;
    }

    public final TextFieldSelectionState getTextFieldSelectionState() {
        return this.textFieldSelectionState;
    }

    public final void setTextFieldSelectionState(TextFieldSelectionState textFieldSelectionState2) {
        this.textFieldSelectionState = textFieldSelectionState2;
    }

    public final InputTransformation getFilter() {
        return this.filter;
    }

    public final void setFilter(InputTransformation inputTransformation) {
        this.filter = inputTransformation;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final void setEnabled(boolean z) {
        this.enabled = z;
    }

    public final boolean getReadOnly() {
        return this.readOnly;
    }

    public final void setReadOnly(boolean z) {
        this.readOnly = z;
    }

    public final KeyboardActionHandler getKeyboardActionHandler() {
        return this.keyboardActionHandler;
    }

    public final void setKeyboardActionHandler(KeyboardActionHandler keyboardActionHandler2) {
        this.keyboardActionHandler = keyboardActionHandler2;
    }

    public final boolean getSingleLine() {
        return this.singleLine;
    }

    public final void setSingleLine(boolean z) {
        this.singleLine = z;
    }

    public final MutableInteractionSource getInteractionSource() {
        return this.interactionSource;
    }

    public final void setInteractionSource(MutableInteractionSource mutableInteractionSource) {
        this.interactionSource = mutableInteractionSource;
    }

    public TextFieldDecoratorModifierNode(TransformedTextFieldState transformedTextFieldState, TextLayoutState textLayoutState2, TextFieldSelectionState textFieldSelectionState2, InputTransformation inputTransformation, boolean z, boolean z2, KeyboardOptions keyboardOptions2, KeyboardActionHandler keyboardActionHandler2, boolean z3, MutableInteractionSource mutableInteractionSource) {
        KeyboardOptions keyboardOptions3 = keyboardOptions2;
        this.textFieldState = transformedTextFieldState;
        this.textLayoutState = textLayoutState2;
        this.textFieldSelectionState = textFieldSelectionState2;
        this.filter = inputTransformation;
        this.enabled = z;
        this.readOnly = z2;
        this.keyboardActionHandler = keyboardActionHandler2;
        this.singleLine = z3;
        this.interactionSource = mutableInteractionSource;
        KeyboardOptions keyboardOptions4 = null;
        this.stylusHandwritingNode = (StylusHandwritingNode) delegate(new StylusHandwritingNode(new TextFieldDecoratorModifierNode$stylusHandwritingNode$1(this, keyboardOptions3)));
        this.dragAndDropNode = (DragAndDropModifierNode) delegate(TextFieldDragAndDropNode_androidKt.textFieldDragAndDropNode$default(new TextFieldDecoratorModifierNode$dragAndDropNode$1(this), new TextFieldDecoratorModifierNode$dragAndDropNode$2(this), new TextFieldDecoratorModifierNode$dragAndDropNode$3(this), (Function1) null, new TextFieldDecoratorModifierNode$dragAndDropNode$4(this), new TextFieldDecoratorModifierNode$dragAndDropNode$5(this), (Function1) null, new TextFieldDecoratorModifierNode$dragAndDropNode$6(this), new TextFieldDecoratorModifierNode$dragAndDropNode$7(this), 72, (Object) null));
        InputTransformation inputTransformation2 = this.filter;
        this.keyboardOptions = keyboardOptions3.fillUnspecifiedValuesWith$foundation_release(inputTransformation2 != null ? inputTransformation2.getKeyboardOptions() : keyboardOptions4);
        this.textFieldKeyEventHandler = TextFieldKeyEventHandler_androidKt.createTextFieldKeyEventHandler();
        this.keyboardActionScope = new TextFieldDecoratorModifierNode$keyboardActionScope$1(this);
        this.receiveContentConfigurationProvider = new TextFieldDecoratorModifierNode$receiveContentConfigurationProvider$1(this);
    }

    /* access modifiers changed from: private */
    public final boolean getEditable() {
        return this.enabled && !this.readOnly;
    }

    /* access modifiers changed from: private */
    public final MutableSharedFlow<Unit> getStylusHandwritingTrigger() {
        MutableSharedFlow<Unit> mutableSharedFlow = this.backingStylusHandwritingTrigger;
        if (mutableSharedFlow != null) {
            return mutableSharedFlow;
        }
        if (!StylusHandwriting_androidKt.isStylusHandwritingSupported()) {
            return null;
        }
        MutableSharedFlow<Unit> MutableSharedFlow$default = SharedFlowKt.MutableSharedFlow$default(1, 0, BufferOverflow.DROP_LATEST, 2, (Object) null);
        this.backingStylusHandwritingTrigger = MutableSharedFlow$default;
        return MutableSharedFlow$default;
    }

    public final KeyboardOptions getKeyboardOptions() {
        return this.keyboardOptions;
    }

    /* access modifiers changed from: private */
    public final boolean isFocused() {
        WindowInfo windowInfo2 = this.windowInfo;
        return this.isElementFocused && (windowInfo2 != null && windowInfo2.isWindowFocused());
    }

    public final void updateNode(TransformedTextFieldState transformedTextFieldState, TextLayoutState textLayoutState2, TextFieldSelectionState textFieldSelectionState2, InputTransformation inputTransformation, boolean z, boolean z2, KeyboardOptions keyboardOptions2, KeyboardActionHandler keyboardActionHandler2, boolean z3, MutableInteractionSource mutableInteractionSource) {
        TransformedTextFieldState transformedTextFieldState2 = transformedTextFieldState;
        TextFieldSelectionState textFieldSelectionState3 = textFieldSelectionState2;
        InputTransformation inputTransformation2 = inputTransformation;
        boolean z4 = z;
        boolean z5 = z2;
        MutableInteractionSource mutableInteractionSource2 = mutableInteractionSource;
        boolean z6 = this.enabled;
        boolean z7 = true;
        boolean z8 = z6 && !this.readOnly;
        if (!z4 || z5) {
            z7 = false;
        }
        TransformedTextFieldState transformedTextFieldState3 = this.textFieldState;
        KeyboardOptions keyboardOptions3 = this.keyboardOptions;
        TextFieldSelectionState textFieldSelectionState4 = this.textFieldSelectionState;
        MutableInteractionSource mutableInteractionSource3 = this.interactionSource;
        this.textFieldState = transformedTextFieldState2;
        this.textLayoutState = textLayoutState2;
        this.textFieldSelectionState = textFieldSelectionState3;
        this.filter = inputTransformation2;
        this.enabled = z4;
        this.readOnly = z5;
        this.keyboardOptions = keyboardOptions2.fillUnspecifiedValuesWith$foundation_release(inputTransformation2 != null ? inputTransformation2.getKeyboardOptions() : null);
        this.keyboardActionHandler = keyboardActionHandler2;
        this.singleLine = z3;
        this.interactionSource = mutableInteractionSource2;
        if (z7 != z8 || !Intrinsics.areEqual((Object) transformedTextFieldState2, (Object) transformedTextFieldState3) || !Intrinsics.areEqual((Object) this.keyboardOptions, (Object) keyboardOptions3)) {
            if (z7 && isFocused()) {
                startInputSession(false);
            } else if (!z7) {
                disposeInputSession();
            }
        }
        if (z6 != z4) {
            SemanticsModifierNodeKt.invalidateSemantics(this);
        }
        if (!Intrinsics.areEqual((Object) textFieldSelectionState3, (Object) textFieldSelectionState4)) {
            this.pointerInputNode.resetPointerInputHandler();
            this.stylusHandwritingNode.resetPointerInputHandler();
            if (isAttached()) {
                textFieldSelectionState3.setReceiveContentConfiguration(this.receiveContentConfigurationProvider);
            }
        }
        if (!Intrinsics.areEqual((Object) mutableInteractionSource2, (Object) mutableInteractionSource3)) {
            this.pointerInputNode.resetPointerInputHandler();
            this.stylusHandwritingNode.resetPointerInputHandler();
        }
    }

    public void applySemantics(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        TextFieldCharSequence outputText = this.textFieldState.getOutputText();
        long r1 = outputText.m1312getSelectiond9O1mEE();
        SemanticsPropertiesKt.setEditableText(semanticsPropertyReceiver, new AnnotatedString(outputText.toString(), (List) null, (List) null, 6, (DefaultConstructorMarker) null));
        SemanticsPropertiesKt.m6387setTextSelectionRangeFDrldGo(semanticsPropertyReceiver, r1);
        if (!this.enabled) {
            SemanticsPropertiesKt.disabled(semanticsPropertyReceiver);
        }
        SemanticsPropertiesKt.setEditable(semanticsPropertyReceiver, getEditable());
        SemanticsPropertiesKt.getTextLayoutResult$default(semanticsPropertyReceiver, (String) null, new TextFieldDecoratorModifierNode$applySemantics$1(this), 1, (Object) null);
        if (getEditable()) {
            SemanticsPropertiesKt.setText$default(semanticsPropertyReceiver, (String) null, new TextFieldDecoratorModifierNode$applySemantics$2(this), 1, (Object) null);
            SemanticsPropertiesKt.insertTextAtCursor$default(semanticsPropertyReceiver, (String) null, new TextFieldDecoratorModifierNode$applySemantics$3(this), 1, (Object) null);
        }
        SemanticsPropertiesKt.setSelection$default(semanticsPropertyReceiver, (String) null, new TextFieldDecoratorModifierNode$applySemantics$4(this), 1, (Object) null);
        int r6 = this.keyboardOptions.m1209getImeActionOrDefaulteUduSuo$foundation_release();
        SemanticsPropertyReceiver semanticsPropertyReceiver2 = semanticsPropertyReceiver;
        SemanticsPropertiesKt.m6382onImeAction9UiTYpY$default(semanticsPropertyReceiver2, r6, (String) null, new TextFieldDecoratorModifierNode$applySemantics$5(this, r6), 2, (Object) null);
        SemanticsPropertiesKt.onClick$default(semanticsPropertyReceiver2, (String) null, new TextFieldDecoratorModifierNode$applySemantics$6(this), 1, (Object) null);
        SemanticsPropertiesKt.onLongClick$default(semanticsPropertyReceiver2, (String) null, new TextFieldDecoratorModifierNode$applySemantics$7(this), 1, (Object) null);
        if (!TextRange.m6558getCollapsedimpl(r1)) {
            SemanticsPropertiesKt.copyText$default(semanticsPropertyReceiver2, (String) null, new TextFieldDecoratorModifierNode$applySemantics$8(this), 1, (Object) null);
            if (this.enabled && !this.readOnly) {
                SemanticsPropertiesKt.cutText$default(semanticsPropertyReceiver2, (String) null, new TextFieldDecoratorModifierNode$applySemantics$9(this), 1, (Object) null);
            }
        }
        if (getEditable()) {
            SemanticsPropertiesKt.pasteText$default(semanticsPropertyReceiver2, (String) null, new TextFieldDecoratorModifierNode$applySemantics$10(this), 1, (Object) null);
        }
        InputTransformation inputTransformation = this.filter;
        if (inputTransformation != null) {
            inputTransformation.applySemantics(semanticsPropertyReceiver2);
        }
    }

    public void onFocusEvent(FocusState focusState) {
        if (this.isElementFocused != focusState.isFocused()) {
            this.isElementFocused = focusState.isFocused();
            onFocusChange();
            if (!focusState.isFocused()) {
                disposeInputSession();
                TransformedTextFieldState transformedTextFieldState = this.textFieldState;
                TextFieldState access$getTextFieldState$p = transformedTextFieldState.textFieldState;
                InputTransformation access$getInputTransformation$p = transformedTextFieldState.inputTransformation;
                TextFieldEditUndoBehavior textFieldEditUndoBehavior = TextFieldEditUndoBehavior.MergeIfPossible;
                access$getTextFieldState$p.getMainBuffer$foundation_release().getChangeTracker().clearChanges();
                EditCommandKt.finishComposingText(access$getTextFieldState$p.getMainBuffer$foundation_release());
                access$getTextFieldState$p.commitEditAsUser(access$getInputTransformation$p, true, textFieldEditUndoBehavior);
                this.textFieldState.collapseSelectionToMax();
            } else if (getEditable()) {
                startInputSession(false);
            }
            this.stylusHandwritingNode.onFocusEvent(focusState);
        }
    }

    /* access modifiers changed from: private */
    public final void onFocusChange() {
        this.textFieldSelectionState.setFocused(isFocused());
        if (isFocused() && this.observeChangesJob == null) {
            this.observeChangesJob = BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), (CoroutineContext) null, (CoroutineStart) null, new TextFieldDecoratorModifierNode$onFocusChange$1(this, (Continuation<? super TextFieldDecoratorModifierNode$onFocusChange$1>) null), 3, (Object) null);
        } else if (!isFocused()) {
            Job job = this.observeChangesJob;
            if (job != null) {
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            this.observeChangesJob = null;
        }
    }

    public void onAttach() {
        onObservedReadsChanged();
        this.textFieldSelectionState.setReceiveContentConfiguration(this.receiveContentConfigurationProvider);
    }

    public void onDetach() {
        disposeInputSession();
        this.textFieldSelectionState.setReceiveContentConfiguration((Function0<? extends ReceiveContentConfiguration>) null);
    }

    public void onGloballyPositioned(LayoutCoordinates layoutCoordinates) {
        this.textLayoutState.setDecoratorNodeCoordinates(layoutCoordinates);
    }

    /* renamed from: onPointerEvent-H0pRuoY  reason: not valid java name */
    public void m1411onPointerEventH0pRuoY(PointerEvent pointerEvent, PointerEventPass pointerEventPass, long j) {
        this.stylusHandwritingNode.m1301onPointerEventH0pRuoY(pointerEvent, pointerEventPass, j);
        this.pointerInputNode.m6200onPointerEventH0pRuoY(pointerEvent, pointerEventPass, j);
    }

    public void onCancelPointerInput() {
        this.stylusHandwritingNode.onCancelPointerInput();
        this.pointerInputNode.onCancelPointerInput();
    }

    /* renamed from: onPreKeyEvent-ZmokQxo  reason: not valid java name */
    public boolean m1412onPreKeyEventZmokQxo(KeyEvent keyEvent) {
        return this.textFieldKeyEventHandler.m1417onPreKeyEventMyFupTE(keyEvent, this.textFieldState, this.textFieldSelectionState, (FocusManager) CompositionLocalConsumerModifierNodeKt.currentValueOf(this, CompositionLocalsKt.getLocalFocusManager()), requireKeyboardController());
    }

    /* renamed from: onKeyEvent-ZmokQxo  reason: not valid java name */
    public boolean m1410onKeyEventZmokQxo(KeyEvent keyEvent) {
        return this.textFieldKeyEventHandler.m1416onKeyEvent6ptp14s(keyEvent, this.textFieldState, this.textLayoutState, this.textFieldSelectionState, this.enabled && !this.readOnly, this.singleLine, new TextFieldDecoratorModifierNode$onKeyEvent$1(this));
    }

    public void onObservedReadsChanged() {
        ObserverModifierNodeKt.observeReads(this, new TextFieldDecoratorModifierNode$onObservedReadsChanged$1(this));
    }

    /* access modifiers changed from: private */
    public final void startInputSession(boolean z) {
        if (z || this.keyboardOptions.getShowKeyboardOnFocusOrDefault$foundation_release()) {
            this.inputSessionJob = BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), (CoroutineContext) null, (CoroutineStart) null, new TextFieldDecoratorModifierNode$startInputSession$1(this, ReceiveContentConfigurationKt.getReceiveContentConfiguration(this), (Continuation<? super TextFieldDecoratorModifierNode$startInputSession$1>) null), 3, (Object) null);
        }
    }

    private final void disposeInputSession() {
        Job job = this.inputSessionJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.inputSessionJob = null;
        MutableSharedFlow<Unit> stylusHandwritingTrigger = getStylusHandwritingTrigger();
        if (stylusHandwritingTrigger != null) {
            stylusHandwritingTrigger.resetReplayCache();
        }
    }

    /* access modifiers changed from: private */
    public final SoftwareKeyboardController requireKeyboardController() {
        SoftwareKeyboardController softwareKeyboardController = (SoftwareKeyboardController) CompositionLocalConsumerModifierNodeKt.currentValueOf(this, CompositionLocalsKt.getLocalSoftwareKeyboardController());
        if (softwareKeyboardController != null) {
            return softwareKeyboardController;
        }
        throw new IllegalStateException("No software keyboard controller".toString());
    }

    /* access modifiers changed from: private */
    public final void emitDragExitEvent() {
        HoverInteraction.Enter enter = this.dragEnterEvent;
        if (enter != null) {
            this.interactionSource.tryEmit(new HoverInteraction.Exit(enter));
            this.dragEnterEvent = null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onImeActionPerformed-KlQnJC8  reason: not valid java name */
    public final void m1409onImeActionPerformedKlQnJC8(int i) {
        KeyboardActionHandler keyboardActionHandler2;
        if (ImeAction.m6741equalsimpl0(i, ImeAction.Companion.m6758getNoneeUduSuo()) || ImeAction.m6741equalsimpl0(i, ImeAction.Companion.m6754getDefaulteUduSuo()) || (keyboardActionHandler2 = this.keyboardActionHandler) == null) {
            this.keyboardActionScope.m1414defaultKeyboardActionKlQnJC8(i);
        } else if (keyboardActionHandler2 != null) {
            keyboardActionHandler2.onKeyboardAction(new TextFieldDecoratorModifierNode$onImeActionPerformed$1(this, i));
        }
    }
}
