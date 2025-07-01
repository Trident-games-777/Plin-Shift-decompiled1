package androidx.compose.foundation.text.input.internal.selection;

import androidx.compose.foundation.content.PlatformTransferableContent;
import androidx.compose.foundation.content.TransferableContent;
import androidx.compose.foundation.content.TransferableContent_androidKt;
import androidx.compose.foundation.content.internal.ReceiveContentConfiguration;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.foundation.text.Handle;
import androidx.compose.foundation.text.TextDragObserver;
import androidx.compose.foundation.text.TextFieldCursorKt;
import androidx.compose.foundation.text.input.TextFieldCharSequence;
import androidx.compose.foundation.text.input.TextFieldCharSequenceKt;
import androidx.compose.foundation.text.input.internal.IndexTransformationType;
import androidx.compose.foundation.text.input.internal.MathUtilsKt;
import androidx.compose.foundation.text.input.internal.SelectionWedgeAffinity;
import androidx.compose.foundation.text.input.internal.TextLayoutState;
import androidx.compose.foundation.text.input.internal.TextLayoutStateKt;
import androidx.compose.foundation.text.input.internal.TransformedTextFieldState;
import androidx.compose.foundation.text.input.internal.WedgeAffinity;
import androidx.compose.foundation.text.input.internal.undo.TextFieldEditUndoBehavior;
import androidx.compose.foundation.text.selection.MouseSelectionObserver;
import androidx.compose.foundation.text.selection.SelectionAdjustment;
import androidx.compose.foundation.text.selection.SelectionGesturesKt;
import androidx.compose.foundation.text.selection.SelectionLayout;
import androidx.compose.foundation.text.selection.SelectionLayoutKt;
import androidx.compose.foundation.text.selection.SelectionManagerKt;
import androidx.compose.foundation.text.selection.TextSelectionDelegateKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.hapticfeedback.HapticFeedbackType;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.platform.ClipEntry;
import androidx.compose.ui.platform.ClipboardManager;
import androidx.compose.ui.platform.TextToolbar;
import androidx.compose.ui.platform.TextToolbarStatus;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(d1 = {"\u0000¼\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0000\u0018\u00002\u00020\u0001:\u0006«\u0001¬\u0001­\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\t¢\u0006\u0002\u0010\rJ\u0006\u0010W\u001a\u00020\tJ\u0006\u0010X\u001a\u00020\tJ\u0006\u0010Y\u001a\u00020\tJ\u0006\u0010Z\u001a\u00020\tJ\u0006\u0010[\u001a\u00020\\J\u0010\u0010]\u001a\u00020\\2\b\b\u0002\u0010^\u001a\u00020\tJ\u0006\u0010_\u001a\u00020\\J\u0006\u0010`\u001a\u00020\\J\u0006\u0010a\u001a\u00020\\J\b\u0010b\u001a\u00020cH\u0002J\u0015\u0010d\u001a\u00020e2\u0006\u0010f\u001a\u00020\tH\u0000¢\u0006\u0002\bgJ\u0006\u0010h\u001a\u00020cJ\u001d\u0010i\u001a\u00020\u00112\u0006\u0010j\u001a\u00020\tH\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bk\u0010lJ\u001d\u0010m\u001a\u00020e2\u0006\u0010j\u001a\u00020\t2\u0006\u0010f\u001a\u00020\tH\u0000¢\u0006\u0002\bnJ<\u0010o\u001a\u00020p2\u0006\u0010q\u001a\u0002032\u0006\u0010r\u001a\u0002032\b\u0010s\u001a\u0004\u0018\u00010p2\u0006\u0010j\u001a\u00020\t2\u0006\u0010t\u001a\u00020uH\u0002ø\u0001\u0000¢\u0006\u0004\bv\u0010wJ\b\u0010x\u001a\u00020\\H\u0002J\b\u0010y\u001a\u00020\tH\u0002J\b\u0010z\u001a\u00020\\H\u0002J1\u0010{\u001a\n\u0012\u0004\u0012\u00020\\\u0018\u00010<2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010|\u001a\u00020P2\u000e\b\u0004\u0010}\u001a\b\u0012\u0004\u0012\u00020\\0<H\bJ\u000e\u0010~\u001a\u00020\\H@¢\u0006\u0002\u0010J\u000f\u0010\u0001\u001a\u00020\\H@¢\u0006\u0002\u0010J\u000f\u0010\u0001\u001a\u00020\\H@¢\u0006\u0002\u0010J\u0007\u0010\u0001\u001a\u00020\\J\t\u0010\u0001\u001a\u00020\\H\u0002J\u001e\u0010\u0001\u001a\u00020\t2\u0007\u0010\u0001\u001a\u00020\u0011H\u0002ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J\u0007\u0010\u0001\u001a\u00020\\J\u0012\u0010\u0001\u001a\u00020\\2\u0007\u0010\u0001\u001a\u00020cH\u0002J?\u0010\u0001\u001a\u00020\\2\u0006\u0010)\u001a\u00020*2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010N\u001a\u00020O2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\tJ%\u0010\u0001\u001a\u00020\\2\u0007\u0010\u0001\u001a\u00020\u001d2\u0007\u0010\u0001\u001a\u00020\u0011ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001JZ\u0010\u0001\u001a\u00020p2\b\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u0002032\u0007\u0010\u0001\u001a\u0002032\u0006\u0010j\u001a\u00020\t2\u0006\u0010t\u001a\u00020u2\t\b\u0002\u0010\u0001\u001a\u00020\t2\t\b\u0002\u0010\u0001\u001a\u00020\tH\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J\u000f\u0010\u0001\u001a\u00020\\2\u0006\u0010Q\u001a\u00020PJ\u0015\u0010\u0001\u001a\u00020\\*\u00030\u0001H@¢\u0006\u0003\u0010\u0001J\u0015\u0010\u0001\u001a\u00020\\*\u00030\u0001H@¢\u0006\u0003\u0010\u0001J\u001d\u0010\u0001\u001a\u00020\\*\u00030\u00012\u0006\u0010j\u001a\u00020\tH@¢\u0006\u0003\u0010 \u0001J?\u0010¡\u0001\u001a\u00020\\*\u00030\u00012\n\u0010¢\u0001\u001a\u0005\u0018\u00010£\u00012\r\u0010¤\u0001\u001a\b\u0012\u0004\u0012\u00020\\0<2\r\u0010¥\u0001\u001a\b\u0012\u0004\u0012\u00020\\0<H@¢\u0006\u0003\u0010¦\u0001J\u0015\u0010§\u0001\u001a\u00020\\*\u00030\u0001H@¢\u0006\u0003\u0010\u0001J\u001d\u0010¨\u0001\u001a\u00020\\*\u00030\u00012\u0006\u0010j\u001a\u00020\tH@¢\u0006\u0003\u0010 \u0001J$\u0010©\u0001\u001a\u00020\\*\u00030\u00012\r\u0010¤\u0001\u001a\b\u0012\u0004\u0012\u00020\\0<H@¢\u0006\u0003\u0010ª\u0001R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u00020\u00118BX\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R+\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u00158F@FX\u0002¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR/\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\u0010\u0014\u001a\u0004\u0018\u00010\u001d8F@FX\u0002¢\u0006\u0012\n\u0004\b#\u0010\u001c\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0014\u0010$\u001a\u00020\t8BX\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0017\u0010'\u001a\u00020\u00118Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b(\u0010\u0013R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010&\"\u0004\b+\u0010,R+\u0010-\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\t8F@FX\u0002¢\u0006\u0012\n\u0004\b/\u0010\u001c\u001a\u0004\b-\u0010&\"\u0004\b.\u0010,R\u000e\u0010\f\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u000101X\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u000203X\u000e¢\u0006\u0002\n\u0000R\u0010\u00104\u001a\u0004\u0018\u000105X\u000e¢\u0006\u0002\n\u0000R1\u00106\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00118B@BX\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b:\u0010\u001c\u001a\u0004\b7\u0010\u0013\"\u0004\b8\u00109R\u000e\u0010\n\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R$\u0010;\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010=\u0018\u00010<X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR+\u0010B\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\t8B@BX\u0002¢\u0006\u0012\n\u0004\bE\u0010\u001c\u001a\u0004\bC\u0010&\"\u0004\bD\u0010,R1\u0010F\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00118B@BX\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\bI\u0010\u001c\u001a\u0004\bG\u0010\u0013\"\u0004\bH\u00109R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010J\u001a\u0004\u0018\u00010K8BX\u0004¢\u0006\u0006\u001a\u0004\bL\u0010MR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010N\u001a\u0004\u0018\u00010OX\u000e¢\u0006\u0002\n\u0000R+\u0010Q\u001a\u00020P2\u0006\u0010\u0014\u001a\u00020P8B@BX\u0002¢\u0006\u0012\n\u0004\bV\u0010\u001c\u001a\u0004\bR\u0010S\"\u0004\bT\u0010U\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006®\u0001"}, d2 = {"Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;", "", "textFieldState", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "textLayoutState", "Landroidx/compose/foundation/text/input/internal/TextLayoutState;", "density", "Landroidx/compose/ui/unit/Density;", "enabled", "", "readOnly", "isFocused", "isPassword", "(Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;Landroidx/compose/foundation/text/input/internal/TextLayoutState;Landroidx/compose/ui/unit/Density;ZZZZ)V", "clipboardManager", "Landroidx/compose/ui/platform/ClipboardManager;", "currentTextLayoutPositionInWindow", "Landroidx/compose/ui/geometry/Offset;", "getCurrentTextLayoutPositionInWindow-F1C5BW0", "()J", "<set-?>", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState$InputType;", "directDragGestureInitiator", "getDirectDragGestureInitiator", "()Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState$InputType;", "setDirectDragGestureInitiator", "(Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState$InputType;)V", "directDragGestureInitiator$delegate", "Landroidx/compose/runtime/MutableState;", "Landroidx/compose/foundation/text/Handle;", "draggingHandle", "getDraggingHandle", "()Landroidx/compose/foundation/text/Handle;", "setDraggingHandle", "(Landroidx/compose/foundation/text/Handle;)V", "draggingHandle$delegate", "editable", "getEditable", "()Z", "handleDragPosition", "getHandleDragPosition-F1C5BW0", "hapticFeedBack", "Landroidx/compose/ui/hapticfeedback/HapticFeedback;", "setFocused", "(Z)V", "isInTouchMode", "setInTouchMode", "isInTouchMode$delegate", "pressInteraction", "Landroidx/compose/foundation/interaction/PressInteraction$Press;", "previousRawDragOffset", "", "previousSelectionLayout", "Landroidx/compose/foundation/text/selection/SelectionLayout;", "rawHandleDragPosition", "getRawHandleDragPosition-F1C5BW0", "setRawHandleDragPosition-k-4lQ0M", "(J)V", "rawHandleDragPosition$delegate", "receiveContentConfiguration", "Lkotlin/Function0;", "Landroidx/compose/foundation/content/internal/ReceiveContentConfiguration;", "getReceiveContentConfiguration", "()Lkotlin/jvm/functions/Function0;", "setReceiveContentConfiguration", "(Lkotlin/jvm/functions/Function0;)V", "showCursorHandle", "getShowCursorHandle", "setShowCursorHandle", "showCursorHandle$delegate", "startTextLayoutPositionInWindow", "getStartTextLayoutPositionInWindow-F1C5BW0", "setStartTextLayoutPositionInWindow-k-4lQ0M", "startTextLayoutPositionInWindow$delegate", "textLayoutCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "getTextLayoutCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "textToolbar", "Landroidx/compose/ui/platform/TextToolbar;", "Landroidx/compose/foundation/text/input/internal/selection/TextToolbarState;", "textToolbarState", "getTextToolbarState", "()Landroidx/compose/foundation/text/input/internal/selection/TextToolbarState;", "setTextToolbarState", "(Landroidx/compose/foundation/text/input/internal/selection/TextToolbarState;)V", "textToolbarState$delegate", "canCopy", "canCut", "canPaste", "canSelectAll", "clearHandleDragging", "", "copy", "cancelSelection", "cut", "deselect", "dispose", "getContentRect", "Landroidx/compose/ui/geometry/Rect;", "getCursorHandleState", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldHandleState;", "includePosition", "getCursorHandleState$foundation_release", "getCursorRect", "getHandlePosition", "isStartHandle", "getHandlePosition-tuRUvjQ", "(Z)J", "getSelectionHandleState", "getSelectionHandleState$foundation_release", "getTextFieldSelection", "Landroidx/compose/ui/text/TextRange;", "rawStartOffset", "rawEndOffset", "previousSelection", "adjustment", "Landroidx/compose/foundation/text/selection/SelectionAdjustment;", "getTextFieldSelection-qeG_v_k", "(IILandroidx/compose/ui/text/TextRange;ZLandroidx/compose/foundation/text/selection/SelectionAdjustment;)J", "hideTextToolbar", "isCursorHandleInVisibleBounds", "markStartContentVisibleOffset", "menuItem", "desiredState", "operation", "observeChanges", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "observeTextChanges", "observeTextToolbarVisibility", "paste", "pasteAsPlainText", "placeCursorAtNearestOffset", "offset", "placeCursorAtNearestOffset-k-4lQ0M", "(J)Z", "selectAll", "showTextToolbar", "contentRect", "update", "updateHandleDragging", "handle", "position", "updateHandleDragging-Uv8p0NA", "(Landroidx/compose/foundation/text/Handle;J)V", "updateSelection", "textFieldCharSequence", "Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "startOffset", "endOffset", "allowPreviousSelectionCollapsed", "isStartOfSelection", "updateSelection-SsL-Rf8", "(Landroidx/compose/foundation/text/input/TextFieldCharSequence;IIZLandroidx/compose/foundation/text/selection/SelectionAdjustment;ZZ)J", "updateTextToolbarState", "cursorHandleGestures", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "detectCursorHandleDragGestures", "detectSelectionHandleDragGestures", "(Landroidx/compose/ui/input/pointer/PointerInputScope;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "detectTextFieldTapGestures", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "requestFocus", "showKeyboard", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "detectTouchMode", "selectionHandleGestures", "textFieldSelectionGestures", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "InputType", "TextFieldMouseSelectionObserver", "TextFieldTextDragObserver", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldSelectionState.kt */
public final class TextFieldSelectionState {
    public static final int $stable = 8;
    private ClipboardManager clipboardManager;
    private Density density;
    private final MutableState directDragGestureInitiator$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(InputType.None, (SnapshotMutationPolicy) null, 2, (Object) null);
    private final MutableState draggingHandle$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
    /* access modifiers changed from: private */
    public boolean enabled;
    /* access modifiers changed from: private */
    public HapticFeedback hapticFeedBack;
    private boolean isFocused;
    private final MutableState isInTouchMode$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(true, (SnapshotMutationPolicy) null, 2, (Object) null);
    private boolean isPassword;
    /* access modifiers changed from: private */
    public PressInteraction.Press pressInteraction;
    /* access modifiers changed from: private */
    public int previousRawDragOffset = -1;
    private SelectionLayout previousSelectionLayout;
    private final MutableState rawHandleDragPosition$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Offset.m3976boximpl(Offset.Companion.m4002getUnspecifiedF1C5BW0()), (SnapshotMutationPolicy) null, 2, (Object) null);
    /* access modifiers changed from: private */
    public boolean readOnly;
    private Function0<? extends ReceiveContentConfiguration> receiveContentConfiguration;
    private final MutableState showCursorHandle$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
    private final MutableState startTextLayoutPositionInWindow$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Offset.m3976boximpl(Offset.Companion.m4002getUnspecifiedF1C5BW0()), (SnapshotMutationPolicy) null, 2, (Object) null);
    /* access modifiers changed from: private */
    public final TransformedTextFieldState textFieldState;
    /* access modifiers changed from: private */
    public final TextLayoutState textLayoutState;
    private TextToolbar textToolbar;
    private final MutableState textToolbarState$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(TextToolbarState.None, (SnapshotMutationPolicy) null, 2, (Object) null);

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState$InputType;", "", "(Ljava/lang/String;I)V", "None", "Touch", "Mouse", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: TextFieldSelectionState.kt */
    public enum InputType {
        None,
        Touch,
        Mouse
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: TextFieldSelectionState.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(11:0|1|2|3|4|5|6|7|8|9|11) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        static {
            /*
                androidx.compose.foundation.text.input.internal.IndexTransformationType[] r0 = androidx.compose.foundation.text.input.internal.IndexTransformationType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                androidx.compose.foundation.text.input.internal.IndexTransformationType r1 = androidx.compose.foundation.text.input.internal.IndexTransformationType.Untransformed     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                androidx.compose.foundation.text.input.internal.IndexTransformationType r1 = androidx.compose.foundation.text.input.internal.IndexTransformationType.Deletion     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                androidx.compose.foundation.text.input.internal.IndexTransformationType r1 = androidx.compose.foundation.text.input.internal.IndexTransformationType.Insertion     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                androidx.compose.foundation.text.input.internal.IndexTransformationType r1 = androidx.compose.foundation.text.input.internal.IndexTransformationType.Replacement     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.WhenMappings.<clinit>():void");
        }
    }

    public TextFieldSelectionState(TransformedTextFieldState transformedTextFieldState, TextLayoutState textLayoutState2, Density density2, boolean z, boolean z2, boolean z3, boolean z4) {
        this.textFieldState = transformedTextFieldState;
        this.textLayoutState = textLayoutState2;
        this.density = density2;
        this.enabled = z;
        this.readOnly = z2;
        this.isFocused = z3;
        this.isPassword = z4;
    }

    public final boolean isFocused() {
        return this.isFocused;
    }

    public final void setFocused(boolean z) {
        this.isFocused = z;
    }

    public final boolean isInTouchMode() {
        return ((Boolean) this.isInTouchMode$delegate.getValue()).booleanValue();
    }

    public final void setInTouchMode(boolean z) {
        this.isInTouchMode$delegate.setValue(Boolean.valueOf(z));
    }

    public final Function0<ReceiveContentConfiguration> getReceiveContentConfiguration() {
        return this.receiveContentConfiguration;
    }

    public final void setReceiveContentConfiguration(Function0<? extends ReceiveContentConfiguration> function0) {
        this.receiveContentConfiguration = function0;
    }

    /* renamed from: getStartTextLayoutPositionInWindow-F1C5BW0  reason: not valid java name */
    private final long m1478getStartTextLayoutPositionInWindowF1C5BW0() {
        return ((Offset) this.startTextLayoutPositionInWindow$delegate.getValue()).m3997unboximpl();
    }

    /* renamed from: setStartTextLayoutPositionInWindow-k-4lQ0M  reason: not valid java name */
    private final void m1482setStartTextLayoutPositionInWindowk4lQ0M(long j) {
        this.startTextLayoutPositionInWindow$delegate.setValue(Offset.m3976boximpl(j));
    }

    /* renamed from: getCurrentTextLayoutPositionInWindow-F1C5BW0  reason: not valid java name */
    private final long m1475getCurrentTextLayoutPositionInWindowF1C5BW0() {
        LayoutCoordinates textLayoutCoordinates = getTextLayoutCoordinates();
        return textLayoutCoordinates != null ? LayoutCoordinatesKt.positionInWindow(textLayoutCoordinates) : Offset.Companion.m4002getUnspecifiedF1C5BW0();
    }

    /* renamed from: getRawHandleDragPosition-F1C5BW0  reason: not valid java name */
    private final long m1477getRawHandleDragPositionF1C5BW0() {
        return ((Offset) this.rawHandleDragPosition$delegate.getValue()).m3997unboximpl();
    }

    /* renamed from: setRawHandleDragPosition-k-4lQ0M  reason: not valid java name */
    private final void m1481setRawHandleDragPositionk4lQ0M(long j) {
        this.rawHandleDragPosition$delegate.setValue(Offset.m3976boximpl(j));
    }

    /* renamed from: getHandleDragPosition-F1C5BW0  reason: not valid java name */
    public final long m1485getHandleDragPositionF1C5BW0() {
        if (OffsetKt.m4008isUnspecifiedk4lQ0M(m1477getRawHandleDragPositionF1C5BW0())) {
            return Offset.Companion.m4002getUnspecifiedF1C5BW0();
        }
        if (OffsetKt.m4008isUnspecifiedk4lQ0M(m1478getStartTextLayoutPositionInWindowF1C5BW0())) {
            return TextLayoutStateKt.m1437fromDecorationToTextLayoutUv8p0NA(this.textLayoutState, m1477getRawHandleDragPositionF1C5BW0());
        }
        return Offset.m3992plusMKHz9U(m1477getRawHandleDragPositionF1C5BW0(), Offset.m3991minusMKHz9U(m1478getStartTextLayoutPositionInWindowF1C5BW0(), m1475getCurrentTextLayoutPositionInWindowF1C5BW0()));
    }

    public final Handle getDraggingHandle() {
        return (Handle) this.draggingHandle$delegate.getValue();
    }

    public final void setDraggingHandle(Handle handle) {
        this.draggingHandle$delegate.setValue(handle);
    }

    public final InputType getDirectDragGestureInitiator() {
        return (InputType) this.directDragGestureInitiator$delegate.getValue();
    }

    public final void setDirectDragGestureInitiator(InputType inputType) {
        this.directDragGestureInitiator$delegate.setValue(inputType);
    }

    private final boolean getShowCursorHandle() {
        return ((Boolean) this.showCursorHandle$delegate.getValue()).booleanValue();
    }

    /* access modifiers changed from: private */
    public final void setShowCursorHandle(boolean z) {
        this.showCursorHandle$delegate.setValue(Boolean.valueOf(z));
    }

    /* access modifiers changed from: private */
    public final TextToolbarState getTextToolbarState() {
        return (TextToolbarState) this.textToolbarState$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final void setTextToolbarState(TextToolbarState textToolbarState) {
        this.textToolbarState$delegate.setValue(textToolbarState);
    }

    /* access modifiers changed from: private */
    public final LayoutCoordinates getTextLayoutCoordinates() {
        LayoutCoordinates textLayoutNodeCoordinates = this.textLayoutState.getTextLayoutNodeCoordinates();
        if (textLayoutNodeCoordinates == null || !textLayoutNodeCoordinates.isAttached()) {
            return null;
        }
        return textLayoutNodeCoordinates;
    }

    private final boolean getEditable() {
        return this.enabled && !this.readOnly;
    }

    public final TextFieldHandleState getCursorHandleState$foundation_release(boolean z) {
        TextFieldCharSequence visualText = this.textFieldState.getVisualText();
        boolean showCursorHandle = getShowCursorHandle();
        boolean z2 = getDirectDragGestureInitiator() == InputType.None;
        Handle draggingHandle = getDraggingHandle();
        if (!showCursorHandle || !z2 || !TextRange.m6558getCollapsedimpl(visualText.m1312getSelectiond9O1mEE()) || !visualText.shouldShowSelection() || visualText.length() <= 0 || (draggingHandle != Handle.Cursor && !isCursorHandleInVisibleBounds())) {
            return TextFieldHandleState.Companion.getHidden();
        }
        return new TextFieldHandleState(true, z ? getCursorRect().m4014getBottomCenterF1C5BW0() : Offset.Companion.m4002getUnspecifiedF1C5BW0(), ResolvedTextDirection.Ltr, false, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: finally extract failed */
    private final boolean isCursorHandleInVisibleBounds() {
        Rect visibleBounds;
        Snapshot.Companion companion = Snapshot.Companion;
        Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
        Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
        Snapshot makeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
        try {
            long r4 = getCursorRect().m4014getBottomCenterF1C5BW0();
            companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
            LayoutCoordinates textLayoutCoordinates = getTextLayoutCoordinates();
            if (textLayoutCoordinates == null || (visibleBounds = SelectionManagerKt.visibleBounds(textLayoutCoordinates)) == null) {
                return false;
            }
            return SelectionManagerKt.m1624containsInclusiveUv8p0NA(visibleBounds, r4);
        } catch (Throwable th) {
            companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
            throw th;
        }
    }

    public final Rect getCursorRect() {
        float f;
        TextLayoutResult layoutResult = this.textLayoutState.getLayoutResult();
        if (layoutResult == null) {
            return Rect.Companion.getZero();
        }
        TextFieldCharSequence visualText = this.textFieldState.getVisualText();
        if (!TextRange.m6558getCollapsedimpl(visualText.m1312getSelectiond9O1mEE())) {
            return Rect.Companion.getZero();
        }
        Rect cursorRect = layoutResult.getCursorRect(TextRange.m6564getStartimpl(visualText.m1312getSelectiond9O1mEE()));
        float r2 = this.density.m7091toPx0680j_4(TextFieldCursorKt.getDefaultCursorThickness());
        if (layoutResult.getLayoutInput().getLayoutDirection() == LayoutDirection.Ltr) {
            f = cursorRect.getLeft() + (r2 / ((float) 2));
        } else {
            f = cursorRect.getRight() - (r2 / ((float) 2));
        }
        float f2 = r2 / ((float) 2);
        float coerceAtLeast = RangesKt.coerceAtLeast(RangesKt.coerceAtMost(f, ((float) IntSize.m7283getWidthimpl(layoutResult.m6537getSizeYbymL2g())) - f2), f2);
        return new Rect(coerceAtLeast - f2, cursorRect.getTop(), coerceAtLeast + f2, cursorRect.getBottom());
    }

    public final void update(HapticFeedback hapticFeedback, ClipboardManager clipboardManager2, TextToolbar textToolbar2, Density density2, boolean z, boolean z2, boolean z3) {
        if (!z) {
            hideTextToolbar();
        }
        this.hapticFeedBack = hapticFeedback;
        this.clipboardManager = clipboardManager2;
        this.textToolbar = textToolbar2;
        this.density = density2;
        this.enabled = z;
        this.readOnly = z2;
        this.isPassword = z3;
    }

    public final Object cursorHandleGestures(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
        Object coroutineScope = CoroutineScopeKt.coroutineScope(new TextFieldSelectionState$cursorHandleGestures$2(this, pointerInputScope, (Continuation<? super TextFieldSelectionState$cursorHandleGestures$2>) null), continuation);
        return coroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? coroutineScope : Unit.INSTANCE;
    }

    public final Object selectionHandleGestures(PointerInputScope pointerInputScope, boolean z, Continuation<? super Unit> continuation) {
        Object coroutineScope = CoroutineScopeKt.coroutineScope(new TextFieldSelectionState$selectionHandleGestures$2(this, pointerInputScope, z, (Continuation<? super TextFieldSelectionState$selectionHandleGestures$2>) null), continuation);
        return coroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? coroutineScope : Unit.INSTANCE;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object observeChanges(kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$observeChanges$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$observeChanges$1 r0 = (androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$observeChanges$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$observeChanges$1 r0 = new androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$observeChanges$1
            r0.<init>(r5, r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L_0x0039
            if (r2 != r4) goto L_0x0031
            java.lang.Object r0 = r0.L$0
            androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState r0 = (androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState) r0
            kotlin.ResultKt.throwOnFailure(r6)     // Catch:{ all -> 0x002f }
            goto L_0x0050
        L_0x002f:
            r6 = move-exception
            goto L_0x0063
        L_0x0031:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x0039:
            kotlin.ResultKt.throwOnFailure(r6)
            androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$observeChanges$2 r6 = new androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$observeChanges$2     // Catch:{ all -> 0x0061 }
            r2 = 0
            r6.<init>(r5, r2)     // Catch:{ all -> 0x0061 }
            kotlin.jvm.functions.Function2 r6 = (kotlin.jvm.functions.Function2) r6     // Catch:{ all -> 0x0061 }
            r0.L$0 = r5     // Catch:{ all -> 0x0061 }
            r0.label = r4     // Catch:{ all -> 0x0061 }
            java.lang.Object r6 = kotlinx.coroutines.CoroutineScopeKt.coroutineScope(r6, r0)     // Catch:{ all -> 0x0061 }
            if (r6 != r1) goto L_0x004f
            return r1
        L_0x004f:
            r0 = r5
        L_0x0050:
            r0.setShowCursorHandle(r3)
            androidx.compose.foundation.text.input.internal.selection.TextToolbarState r6 = r0.getTextToolbarState()
            androidx.compose.foundation.text.input.internal.selection.TextToolbarState r1 = androidx.compose.foundation.text.input.internal.selection.TextToolbarState.None
            if (r6 == r1) goto L_0x005e
            r0.hideTextToolbar()
        L_0x005e:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L_0x0061:
            r6 = move-exception
            r0 = r5
        L_0x0063:
            r0.setShowCursorHandle(r3)
            androidx.compose.foundation.text.input.internal.selection.TextToolbarState r1 = r0.getTextToolbarState()
            androidx.compose.foundation.text.input.internal.selection.TextToolbarState r2 = androidx.compose.foundation.text.input.internal.selection.TextToolbarState.None
            if (r1 == r2) goto L_0x0071
            r0.hideTextToolbar()
        L_0x0071:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.observeChanges(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void updateTextToolbarState(TextToolbarState textToolbarState) {
        setTextToolbarState(textToolbarState);
    }

    public final void dispose() {
        hideTextToolbar();
        this.textToolbar = null;
        this.clipboardManager = null;
        this.hapticFeedBack = null;
    }

    public final Object detectTouchMode(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
        Object awaitPointerEventScope = pointerInputScope.awaitPointerEventScope(new TextFieldSelectionState$detectTouchMode$2(this, (Continuation<? super TextFieldSelectionState$detectTouchMode$2>) null), continuation);
        return awaitPointerEventScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? awaitPointerEventScope : Unit.INSTANCE;
    }

    public final Object detectTextFieldTapGestures(PointerInputScope pointerInputScope, MutableInteractionSource mutableInteractionSource, Function0<Unit> function0, Function0<Unit> function02, Continuation<? super Unit> continuation) {
        Object detectTapAndPress = TapGestureDetectorKt.detectTapAndPress(pointerInputScope, new TextFieldSelectionState$detectTextFieldTapGestures$2(mutableInteractionSource, this, (Continuation<? super TextFieldSelectionState$detectTextFieldTapGestures$2>) null), new TextFieldSelectionState$detectTextFieldTapGestures$3(function0, this, function02), continuation);
        return detectTapAndPress == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? detectTapAndPress : Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    /* renamed from: placeCursorAtNearestOffset-k-4lQ0M  reason: not valid java name */
    public final boolean m1480placeCursorAtNearestOffsetk4lQ0M(long j) {
        int r2;
        IndexTransformationType indexTransformationType;
        int i;
        SelectionWedgeAffinity selectionWedgeAffinity;
        TextLayoutResult layoutResult = this.textLayoutState.getLayoutResult();
        if (layoutResult == null || (r2 = layoutResult.m6536getOffsetForPositionk4lQ0M(j)) == -1) {
            return false;
        }
        TransformedTextFieldState transformedTextFieldState = this.textFieldState;
        long r4 = transformedTextFieldState.m1444mapFromTransformedjx7JFs(r2);
        long r22 = transformedTextFieldState.m1447mapToTransformedGEjPoXI(r4);
        if (TextRange.m6558getCollapsedimpl(r4) && TextRange.m6558getCollapsedimpl(r22)) {
            indexTransformationType = IndexTransformationType.Untransformed;
        } else if (!TextRange.m6558getCollapsedimpl(r4) && !TextRange.m6558getCollapsedimpl(r22)) {
            indexTransformationType = IndexTransformationType.Replacement;
        } else if (!TextRange.m6558getCollapsedimpl(r4) || TextRange.m6558getCollapsedimpl(r22)) {
            indexTransformationType = IndexTransformationType.Deletion;
        } else {
            indexTransformationType = IndexTransformationType.Insertion;
        }
        int i2 = WhenMappings.$EnumSwitchMapping$0[indexTransformationType.ordinal()];
        SelectionWedgeAffinity selectionWedgeAffinity2 = null;
        if (i2 == 1) {
            i = TextRange.m6564getStartimpl(r4);
        } else if (i2 == 2) {
            i = TextRange.m6564getStartimpl(r4);
        } else if (i2 == 3) {
            if (MathUtilsKt.m1383findClosestRect9KIMszo(j, layoutResult.getCursorRect(TextRange.m6564getStartimpl(r22)), layoutResult.getCursorRect(TextRange.m6559getEndimpl(r22))) < 0) {
                selectionWedgeAffinity = new SelectionWedgeAffinity(WedgeAffinity.Start);
            } else {
                selectionWedgeAffinity = new SelectionWedgeAffinity(WedgeAffinity.End);
            }
            selectionWedgeAffinity2 = selectionWedgeAffinity;
            i = TextRange.m6564getStartimpl(r4);
        } else if (i2 != 4) {
            throw new NoWhenBranchMatchedException();
        } else if (MathUtilsKt.m1383findClosestRect9KIMszo(j, layoutResult.getCursorRect(TextRange.m6564getStartimpl(r22)), layoutResult.getCursorRect(TextRange.m6559getEndimpl(r22))) < 0) {
            i = TextRange.m6564getStartimpl(r4);
        } else {
            i = TextRange.m6559getEndimpl(r4);
        }
        long TextRange = TextRangeKt.TextRange(i);
        if (TextRange.m6557equalsimpl0(TextRange, this.textFieldState.getUntransformedText().m1312getSelectiond9O1mEE()) && (selectionWedgeAffinity2 == null || Intrinsics.areEqual((Object) selectionWedgeAffinity2, (Object) this.textFieldState.getSelectionWedgeAffinity()))) {
            return false;
        }
        this.textFieldState.m1450selectUntransformedCharsIn5zctL8(TextRange);
        if (selectionWedgeAffinity2 != null) {
            this.textFieldState.setSelectionWedgeAffinity(selectionWedgeAffinity2);
        }
        return true;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v10, resolved type: kotlin.jvm.internal.Ref$LongRef} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object detectCursorHandleDragGestures(androidx.compose.ui.input.pointer.PointerInputScope r9, kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$detectCursorHandleDragGestures$1
            if (r0 == 0) goto L_0x0014
            r0 = r10
            androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$detectCursorHandleDragGestures$1 r0 = (androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$detectCursorHandleDragGestures$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L_0x0019
        L_0x0014:
            androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$detectCursorHandleDragGestures$1 r0 = new androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$detectCursorHandleDragGestures$1
            r0.<init>(r8, r10)
        L_0x0019:
            r6 = r0
            java.lang.Object r10 = r6.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            r2 = 1
            if (r1 == 0) goto L_0x0044
            if (r1 != r2) goto L_0x003c
            java.lang.Object r9 = r6.L$2
            kotlin.jvm.internal.Ref$LongRef r9 = (kotlin.jvm.internal.Ref.LongRef) r9
            java.lang.Object r0 = r6.L$1
            r1 = r0
            kotlin.jvm.internal.Ref$LongRef r1 = (kotlin.jvm.internal.Ref.LongRef) r1
            java.lang.Object r0 = r6.L$0
            r2 = r0
            androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState r2 = (androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState) r2
            kotlin.ResultKt.throwOnFailure(r10)     // Catch:{ all -> 0x0039 }
            goto L_0x0091
        L_0x0039:
            r0 = move-exception
            r10 = r0
            goto L_0x009d
        L_0x003c:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x0044:
            kotlin.ResultKt.throwOnFailure(r10)
            kotlin.jvm.internal.Ref$LongRef r10 = new kotlin.jvm.internal.Ref$LongRef
            r10.<init>()
            androidx.compose.ui.geometry.Offset$Companion r1 = androidx.compose.ui.geometry.Offset.Companion
            long r3 = r1.m4002getUnspecifiedF1C5BW0()
            r10.element = r3
            kotlin.jvm.internal.Ref$LongRef r7 = new kotlin.jvm.internal.Ref$LongRef
            r7.<init>()
            androidx.compose.ui.geometry.Offset$Companion r1 = androidx.compose.ui.geometry.Offset.Companion
            long r3 = r1.m4002getUnspecifiedF1C5BW0()
            r7.element = r3
            androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$detectCursorHandleDragGestures$2 r1 = new androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$detectCursorHandleDragGestures$2     // Catch:{ all -> 0x0097 }
            r1.<init>(r10, r8, r7)     // Catch:{ all -> 0x0097 }
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1     // Catch:{ all -> 0x0097 }
            androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$detectCursorHandleDragGestures$3 r3 = new androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$detectCursorHandleDragGestures$3     // Catch:{ all -> 0x0097 }
            r3.<init>(r10, r7, r8)     // Catch:{ all -> 0x0097 }
            kotlin.jvm.functions.Function0 r3 = (kotlin.jvm.functions.Function0) r3     // Catch:{ all -> 0x0097 }
            androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$detectCursorHandleDragGestures$4 r4 = new androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$detectCursorHandleDragGestures$4     // Catch:{ all -> 0x0097 }
            r4.<init>(r10, r7, r8)     // Catch:{ all -> 0x0097 }
            kotlin.jvm.functions.Function0 r4 = (kotlin.jvm.functions.Function0) r4     // Catch:{ all -> 0x0097 }
            androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$detectCursorHandleDragGestures$5 r5 = new androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$detectCursorHandleDragGestures$5     // Catch:{ all -> 0x0097 }
            r5.<init>(r7, r8, r10)     // Catch:{ all -> 0x0097 }
            kotlin.jvm.functions.Function2 r5 = (kotlin.jvm.functions.Function2) r5     // Catch:{ all -> 0x0097 }
            r6.L$0 = r8     // Catch:{ all -> 0x0097 }
            r6.L$1 = r10     // Catch:{ all -> 0x0097 }
            r6.L$2 = r7     // Catch:{ all -> 0x0097 }
            r6.label = r2     // Catch:{ all -> 0x0097 }
            r2 = r1
            r1 = r9
            java.lang.Object r9 = androidx.compose.foundation.gestures.DragGestureDetectorKt.detectDragGestures(r1, r2, r3, r4, r5, r6)     // Catch:{ all -> 0x0097 }
            if (r9 != r0) goto L_0x008e
            return r0
        L_0x008e:
            r2 = r8
            r1 = r10
            r9 = r7
        L_0x0091:
            detectCursorHandleDragGestures$onDragStop(r1, r9, r2)
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        L_0x0097:
            r0 = move-exception
            r9 = r0
            r2 = r8
            r1 = r10
            r10 = r9
            r9 = r7
        L_0x009d:
            detectCursorHandleDragGestures$onDragStop(r1, r9, r2)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.detectCursorHandleDragGestures(androidx.compose.ui.input.pointer.PointerInputScope, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public static final void detectCursorHandleDragGestures$onDragStop(Ref.LongRef longRef, Ref.LongRef longRef2, TextFieldSelectionState textFieldSelectionState) {
        if (OffsetKt.m4006isSpecifiedk4lQ0M(longRef.element)) {
            longRef.element = Offset.Companion.m4002getUnspecifiedF1C5BW0();
            longRef2.element = Offset.Companion.m4002getUnspecifiedF1C5BW0();
            textFieldSelectionState.clearHandleDragging();
        }
    }

    public final Object textFieldSelectionGestures(PointerInputScope pointerInputScope, Function0<Unit> function0, Continuation<? super Unit> continuation) {
        Object selectionGesturePointerInputBtf2 = SelectionGesturesKt.selectionGesturePointerInputBtf2(pointerInputScope, new TextFieldMouseSelectionObserver(function0), new TextFieldTextDragObserver(function0), continuation);
        return selectionGesturePointerInputBtf2 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? selectionGesturePointerInputBtf2 : Unit.INSTANCE;
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0004\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\"\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0012\u001a\u00020\u0004H\u0016J\u001a\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\tH\u0016ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0017\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\tH\u0016ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0016J\"\u0010\u0019\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u0011J*\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\fH\u0002ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001fR\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\u00020\tX\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\nR\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006 "}, d2 = {"Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState$TextFieldMouseSelectionObserver;", "Landroidx/compose/foundation/text/selection/MouseSelectionObserver;", "requestFocus", "Lkotlin/Function0;", "", "(Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;Lkotlin/jvm/functions/Function0;)V", "dragBeginOffsetInText", "", "dragBeginPosition", "Landroidx/compose/ui/geometry/Offset;", "J", "onDrag", "", "dragPosition", "adjustment", "Landroidx/compose/foundation/text/selection/SelectionAdjustment;", "onDrag-3MmeM6k", "(JLandroidx/compose/foundation/text/selection/SelectionAdjustment;)Z", "onDragDone", "onExtend", "downPosition", "onExtend-k-4lQ0M", "(J)Z", "onExtendDrag", "onExtendDrag-k-4lQ0M", "onStart", "onStart-3MmeM6k", "updateSelection", "Landroidx/compose/ui/text/TextRange;", "isStartOfSelection", "updateSelection-r1Wruf4", "(JLandroidx/compose/foundation/text/selection/SelectionAdjustment;Z)J", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: TextFieldSelectionState.kt */
    private final class TextFieldMouseSelectionObserver implements MouseSelectionObserver {
        private int dragBeginOffsetInText = -1;
        private long dragBeginPosition = Offset.Companion.m4002getUnspecifiedF1C5BW0();
        private final Function0<Unit> requestFocus;

        public TextFieldMouseSelectionObserver(Function0<Unit> function0) {
            this.requestFocus = function0;
        }

        /* renamed from: onStart-3MmeM6k  reason: not valid java name */
        public boolean m1491onStart3MmeM6k(long j, SelectionAdjustment selectionAdjustment) {
            if (!TextFieldSelectionState.this.enabled || TextFieldSelectionState.this.textFieldState.getVisualText().length() == 0) {
                return false;
            }
            TextFieldSelectionStateKt.logDebug(TextFieldSelectionState$TextFieldMouseSelectionObserver$onStart$1.INSTANCE);
            TextFieldSelectionState.this.setDirectDragGestureInitiator(InputType.Mouse);
            this.requestFocus.invoke();
            TextFieldSelectionState.this.previousRawDragOffset = -1;
            this.dragBeginOffsetInText = -1;
            this.dragBeginPosition = j;
            this.dragBeginOffsetInText = TextRange.m6564getStartimpl(m1487updateSelectionr1Wruf4(j, selectionAdjustment, true));
            return true;
        }

        /* renamed from: onDrag-3MmeM6k  reason: not valid java name */
        public boolean m1488onDrag3MmeM6k(long j, SelectionAdjustment selectionAdjustment) {
            if (!TextFieldSelectionState.this.enabled || TextFieldSelectionState.this.textFieldState.getVisualText().length() == 0) {
                return false;
            }
            TextFieldSelectionStateKt.logDebug(new TextFieldSelectionState$TextFieldMouseSelectionObserver$onDrag$1(j));
            m1487updateSelectionr1Wruf4(j, selectionAdjustment, false);
            return true;
        }

        /* renamed from: updateSelection-r1Wruf4  reason: not valid java name */
        private final long m1487updateSelectionr1Wruf4(long j, SelectionAdjustment selectionAdjustment, boolean z) {
            int i;
            Integer valueOf = Integer.valueOf(this.dragBeginOffsetInText);
            if (valueOf.intValue() < 0) {
                valueOf = null;
            }
            if (valueOf != null) {
                i = valueOf.intValue();
            } else {
                i = TextFieldSelectionState.this.textLayoutState.m1432getOffsetForPosition3MmeM6k(this.dragBeginPosition, false);
            }
            int r5 = TextFieldSelectionState.this.textLayoutState.m1432getOffsetForPosition3MmeM6k(j, false);
            TextFieldSelectionState textFieldSelectionState = TextFieldSelectionState.this;
            long r11 = textFieldSelectionState.m1483updateSelectionSsLRf8(textFieldSelectionState.textFieldState.getVisualText(), i, r5, false, selectionAdjustment, false, z);
            if (this.dragBeginOffsetInText == -1 && !TextRange.m6558getCollapsedimpl(r11)) {
                this.dragBeginOffsetInText = TextRange.m6564getStartimpl(r11);
            }
            if (TextRange.m6563getReversedimpl(r11)) {
                r11 = TextFieldSelectionStateKt.m1504reverse5zctL8(r11);
            }
            TextFieldSelectionState.this.textFieldState.m1449selectCharsIn5zctL8(r11);
            TextFieldSelectionState.this.updateTextToolbarState(TextToolbarState.Selection);
            return r11;
        }

        public void onDragDone() {
            TextFieldSelectionStateKt.logDebug(TextFieldSelectionState$TextFieldMouseSelectionObserver$onDragDone$1.INSTANCE);
            TextFieldSelectionState.this.setDirectDragGestureInitiator(InputType.None);
        }

        /* renamed from: onExtend-k-4lQ0M  reason: not valid java name */
        public boolean m1489onExtendk4lQ0M(long j) {
            TextFieldSelectionStateKt.logDebug(TextFieldSelectionState$TextFieldMouseSelectionObserver$onExtend$1.INSTANCE);
            return true;
        }

        /* renamed from: onExtendDrag-k-4lQ0M  reason: not valid java name */
        public boolean m1490onExtendDragk4lQ0M(long j) {
            TextFieldSelectionStateKt.logDebug(TextFieldSelectionState$TextFieldMouseSelectionObserver$onExtendDrag$1.INSTANCE);
            return true;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0004\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\b\u0010\u000e\u001a\u00020\u0004H\u0016J\u001a\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000bH\u0016ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u000bH\u0016ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0012J\b\u0010\u0016\u001a\u00020\u0004H\u0002J\u001a\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u000bH\u0016ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u0012J\b\u0010\u001a\u001a\u00020\u0004H\u0016J\b\u0010\u001b\u001a\u00020\u0004H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\u00020\u000bX\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\fR\u0016\u0010\r\u001a\u00020\u000bX\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\fR\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001c"}, d2 = {"Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState$TextFieldTextDragObserver;", "Landroidx/compose/foundation/text/TextDragObserver;", "requestFocus", "Lkotlin/Function0;", "", "(Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;Lkotlin/jvm/functions/Function0;)V", "actingHandle", "Landroidx/compose/foundation/text/Handle;", "dragBeginOffsetInText", "", "dragBeginPosition", "Landroidx/compose/ui/geometry/Offset;", "J", "dragTotalDistance", "onCancel", "onDown", "point", "onDown-k-4lQ0M", "(J)V", "onDrag", "delta", "onDrag-k-4lQ0M", "onDragStop", "onStart", "startPoint", "onStart-k-4lQ0M", "onStop", "onUp", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: TextFieldSelectionState.kt */
    private final class TextFieldTextDragObserver implements TextDragObserver {
        private Handle actingHandle = Handle.SelectionEnd;
        private int dragBeginOffsetInText = -1;
        private long dragBeginPosition = Offset.Companion.m4002getUnspecifiedF1C5BW0();
        private long dragTotalDistance = Offset.Companion.m4003getZeroF1C5BW0();
        private final Function0<Unit> requestFocus;

        /* renamed from: onDown-k-4lQ0M  reason: not valid java name */
        public void m1492onDownk4lQ0M(long j) {
        }

        public void onUp() {
        }

        public TextFieldTextDragObserver(Function0<Unit> function0) {
            this.requestFocus = function0;
        }

        private final void onDragStop() {
            if (OffsetKt.m4006isSpecifiedk4lQ0M(this.dragBeginPosition)) {
                TextFieldSelectionStateKt.logDebug(TextFieldSelectionState$TextFieldTextDragObserver$onDragStop$1.INSTANCE);
                TextFieldSelectionState.this.clearHandleDragging();
                this.dragBeginOffsetInText = -1;
                this.dragBeginPosition = Offset.Companion.m4002getUnspecifiedF1C5BW0();
                this.dragTotalDistance = Offset.Companion.m4003getZeroF1C5BW0();
                TextFieldSelectionState.this.previousRawDragOffset = -1;
                TextFieldSelectionState.this.setDirectDragGestureInitiator(InputType.None);
                this.requestFocus.invoke();
            }
        }

        public void onStop() {
            onDragStop();
        }

        public void onCancel() {
            onDragStop();
        }

        /* renamed from: onStart-k-4lQ0M  reason: not valid java name */
        public void m1494onStartk4lQ0M(long j) {
            long j2 = j;
            if (TextFieldSelectionState.this.enabled) {
                TextFieldSelectionStateKt.logDebug(new TextFieldSelectionState$TextFieldTextDragObserver$onStart$1(j2));
                TextFieldSelectionState.this.m1486updateHandleDraggingUv8p0NA(this.actingHandle, j2);
                TextFieldSelectionState.this.setShowCursorHandle(false);
                TextFieldSelectionState.this.setDirectDragGestureInitiator(InputType.Touch);
                this.dragBeginPosition = j2;
                this.dragTotalDistance = Offset.Companion.m4003getZeroF1C5BW0();
                TextFieldSelectionState.this.previousRawDragOffset = -1;
                if (!TextFieldSelectionState.this.textLayoutState.m1433isPositionOnTextk4lQ0M(j2)) {
                    int r1 = TextLayoutState.m1429getOffsetForPosition3MmeM6k$default(TextFieldSelectionState.this.textLayoutState, j2, false, 2, (Object) null);
                    HapticFeedback access$getHapticFeedBack$p = TextFieldSelectionState.this.hapticFeedBack;
                    if (access$getHapticFeedBack$p != null) {
                        access$getHapticFeedBack$p.m5090performHapticFeedbackCdsT49E(HapticFeedbackType.Companion.m5099getTextHandleMove5zf0vsI());
                    }
                    TextFieldSelectionState.this.textFieldState.placeCursorBeforeCharAt(r1);
                    TextFieldSelectionState.this.setShowCursorHandle(true);
                    TextFieldSelectionState.this.updateTextToolbarState(TextToolbarState.Cursor);
                } else if (TextFieldSelectionState.this.textFieldState.getVisualText().length() != 0) {
                    int r9 = TextLayoutState.m1429getOffsetForPosition3MmeM6k$default(TextFieldSelectionState.this.textLayoutState, j, false, 2, (Object) null);
                    long r12 = TextFieldSelectionState.m1484updateSelectionSsLRf8$default(TextFieldSelectionState.this, new TextFieldCharSequence(TextFieldSelectionState.this.textFieldState.getVisualText(), TextRange.Companion.m6569getZerod9O1mEE(), (TextRange) null, (Pair) null, 12, (DefaultConstructorMarker) null), r9, r9, false, SelectionAdjustment.Companion.getWord(), false, false, 96, (Object) null);
                    TextFieldSelectionState.this.textFieldState.m1449selectCharsIn5zctL8(r12);
                    TextFieldSelectionState.this.updateTextToolbarState(TextToolbarState.Selection);
                    this.dragBeginOffsetInText = TextRange.m6564getStartimpl(r12);
                }
            }
        }

        /* renamed from: onDrag-k-4lQ0M  reason: not valid java name */
        public void m1493onDragk4lQ0M(long j) {
            int i;
            int r2;
            SelectionAdjustment word;
            Handle handle;
            if (TextFieldSelectionState.this.enabled && TextFieldSelectionState.this.textFieldState.getVisualText().length() != 0) {
                long r1 = Offset.m3992plusMKHz9U(this.dragTotalDistance, j);
                this.dragTotalDistance = r1;
                long r6 = Offset.m3992plusMKHz9U(this.dragBeginPosition, r1);
                TextFieldSelectionStateKt.logDebug(new TextFieldSelectionState$TextFieldTextDragObserver$onDrag$1(r6));
                if (this.dragBeginOffsetInText >= 0 || TextFieldSelectionState.this.textLayoutState.m1433isPositionOnTextk4lQ0M(r6)) {
                    Integer valueOf = Integer.valueOf(this.dragBeginOffsetInText);
                    if (valueOf.intValue() < 0) {
                        valueOf = null;
                    }
                    if (valueOf != null) {
                        i = valueOf.intValue();
                    } else {
                        i = TextFieldSelectionState.this.textLayoutState.m1432getOffsetForPosition3MmeM6k(this.dragBeginPosition, false);
                    }
                    r2 = TextFieldSelectionState.this.textLayoutState.m1432getOffsetForPosition3MmeM6k(r6, false);
                    if (this.dragBeginOffsetInText >= 0 || i != r2) {
                        word = SelectionAdjustment.Companion.getWord();
                        TextFieldSelectionState.this.updateTextToolbarState(TextToolbarState.Selection);
                    } else {
                        return;
                    }
                } else {
                    i = TextLayoutState.m1429getOffsetForPosition3MmeM6k$default(TextFieldSelectionState.this.textLayoutState, this.dragBeginPosition, false, 2, (Object) null);
                    r2 = TextLayoutState.m1429getOffsetForPosition3MmeM6k$default(TextFieldSelectionState.this.textLayoutState, r6, false, 2, (Object) null);
                    if (i == r2) {
                        word = SelectionAdjustment.Companion.getNone();
                    } else {
                        word = SelectionAdjustment.Companion.getWord();
                    }
                }
                int i2 = i;
                int i3 = r2;
                SelectionAdjustment selectionAdjustment = word;
                long r12 = TextFieldSelectionState.this.textFieldState.getVisualText().m1312getSelectiond9O1mEE();
                TextFieldSelectionState textFieldSelectionState = TextFieldSelectionState.this;
                long r3 = TextFieldSelectionState.m1484updateSelectionSsLRf8$default(textFieldSelectionState, textFieldSelectionState.textFieldState.getVisualText(), i2, i3, false, selectionAdjustment, false, false, 64, (Object) null);
                if (this.dragBeginOffsetInText == -1 && !TextRange.m6558getCollapsedimpl(r3)) {
                    this.dragBeginOffsetInText = TextRange.m6564getStartimpl(r3);
                }
                if (TextRange.m6563getReversedimpl(r3)) {
                    r3 = TextFieldSelectionStateKt.m1504reverse5zctL8(r3);
                }
                if (!TextRange.m6557equalsimpl0(r3, r12)) {
                    if (TextRange.m6564getStartimpl(r3) != TextRange.m6564getStartimpl(r12) && TextRange.m6559getEndimpl(r3) == TextRange.m6559getEndimpl(r12)) {
                        handle = Handle.SelectionStart;
                    } else if (TextRange.m6564getStartimpl(r3) == TextRange.m6564getStartimpl(r12) && TextRange.m6559getEndimpl(r3) != TextRange.m6559getEndimpl(r12)) {
                        handle = Handle.SelectionEnd;
                    } else if (((float) (TextRange.m6564getStartimpl(r3) + TextRange.m6559getEndimpl(r3))) / 2.0f > ((float) (TextRange.m6564getStartimpl(r12) + TextRange.m6559getEndimpl(r12))) / 2.0f) {
                        handle = Handle.SelectionEnd;
                    } else {
                        handle = Handle.SelectionStart;
                    }
                    this.actingHandle = handle;
                }
                if (TextRange.m6558getCollapsedimpl(r12) || !TextRange.m6558getCollapsedimpl(r3)) {
                    TextFieldSelectionState.this.textFieldState.m1449selectCharsIn5zctL8(r3);
                }
                TextFieldSelectionState.this.m1486updateHandleDraggingUv8p0NA(this.actingHandle, r6);
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00e3  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object detectSelectionHandleDragGestures(androidx.compose.ui.input.pointer.PointerInputScope r15, boolean r16, kotlin.coroutines.Continuation<? super kotlin.Unit> r17) {
        /*
            r14 = this;
            r0 = r17
            boolean r1 = r0 instanceof androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$detectSelectionHandleDragGestures$1
            if (r1 == 0) goto L_0x0016
            r1 = r0
            androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$detectSelectionHandleDragGestures$1 r1 = (androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$detectSelectionHandleDragGestures$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            if (r2 == 0) goto L_0x0016
            int r0 = r1.label
            int r0 = r0 - r3
            r1.label = r0
            goto L_0x001b
        L_0x0016:
            androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$detectSelectionHandleDragGestures$1 r1 = new androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$detectSelectionHandleDragGestures$1
            r1.<init>(r14, r0)
        L_0x001b:
            r7 = r1
            java.lang.Object r0 = r7.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r7.label
            r3 = 1
            if (r2 == 0) goto L_0x0049
            if (r2 != r3) goto L_0x0041
            java.lang.Object r15 = r7.L$3
            androidx.compose.foundation.text.Handle r15 = (androidx.compose.foundation.text.Handle) r15
            java.lang.Object r1 = r7.L$2
            kotlin.jvm.internal.Ref$LongRef r1 = (kotlin.jvm.internal.Ref.LongRef) r1
            java.lang.Object r2 = r7.L$1
            kotlin.jvm.internal.Ref$LongRef r2 = (kotlin.jvm.internal.Ref.LongRef) r2
            java.lang.Object r3 = r7.L$0
            androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState r3 = (androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState) r3
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ all -> 0x003e }
            goto L_0x00b1
        L_0x003e:
            r0 = move-exception
            goto L_0x00d3
        L_0x0041:
            java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r15.<init>(r0)
            throw r15
        L_0x0049:
            kotlin.ResultKt.throwOnFailure(r0)
            kotlin.jvm.internal.Ref$LongRef r12 = new kotlin.jvm.internal.Ref$LongRef
            r12.<init>()
            androidx.compose.ui.geometry.Offset$Companion r0 = androidx.compose.ui.geometry.Offset.Companion
            long r4 = r0.m4002getUnspecifiedF1C5BW0()
            r12.element = r4
            kotlin.jvm.internal.Ref$LongRef r13 = new kotlin.jvm.internal.Ref$LongRef
            r13.<init>()
            androidx.compose.ui.geometry.Offset$Companion r0 = androidx.compose.ui.geometry.Offset.Companion
            long r4 = r0.m4003getZeroF1C5BW0()
            r13.element = r4
            if (r16 == 0) goto L_0x006b
            androidx.compose.foundation.text.Handle r0 = androidx.compose.foundation.text.Handle.SelectionStart
            goto L_0x006d
        L_0x006b:
            androidx.compose.foundation.text.Handle r0 = androidx.compose.foundation.text.Handle.SelectionEnd
        L_0x006d:
            r11 = r0
            androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$detectSelectionHandleDragGestures$2 r8 = new androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$detectSelectionHandleDragGestures$2     // Catch:{ all -> 0x00ce }
            r10 = r14
            r9 = r12
            r12 = r11
            r11 = r16
            r8.<init>(r9, r10, r11, r12, r13)     // Catch:{ all -> 0x00ca }
            r11 = r12
            r12 = r9
            r0 = r8
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0     // Catch:{ all -> 0x00ce }
            androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$detectSelectionHandleDragGestures$3 r2 = new androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$detectSelectionHandleDragGestures$3     // Catch:{ all -> 0x00ce }
            r2.<init>(r12, r14, r13)     // Catch:{ all -> 0x00ce }
            r4 = r2
            kotlin.jvm.functions.Function0 r4 = (kotlin.jvm.functions.Function0) r4     // Catch:{ all -> 0x00ce }
            androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$detectSelectionHandleDragGestures$4 r2 = new androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$detectSelectionHandleDragGestures$4     // Catch:{ all -> 0x00ce }
            r2.<init>(r12, r14, r13)     // Catch:{ all -> 0x00ce }
            r5 = r2
            kotlin.jvm.functions.Function0 r5 = (kotlin.jvm.functions.Function0) r5     // Catch:{ all -> 0x00ce }
            androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$detectSelectionHandleDragGestures$5 r8 = new androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$detectSelectionHandleDragGestures$5     // Catch:{ all -> 0x00ce }
            r10 = r14
            r9 = r13
            r13 = r16
            r8.<init>(r9, r10, r11, r12, r13)     // Catch:{ all -> 0x00c7 }
            r13 = r9
            r6 = r8
            kotlin.jvm.functions.Function2 r6 = (kotlin.jvm.functions.Function2) r6     // Catch:{ all -> 0x00ce }
            r7.L$0 = r14     // Catch:{ all -> 0x00ce }
            r7.L$1 = r12     // Catch:{ all -> 0x00ce }
            r7.L$2 = r13     // Catch:{ all -> 0x00ce }
            r7.L$3 = r11     // Catch:{ all -> 0x00ce }
            r7.label = r3     // Catch:{ all -> 0x00ce }
            r2 = r15
            r3 = r0
            java.lang.Object r15 = androidx.compose.foundation.gestures.DragGestureDetectorKt.detectDragGestures(r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x00ce }
            if (r15 != r1) goto L_0x00ad
            return r1
        L_0x00ad:
            r3 = r14
            r15 = r11
            r2 = r12
            r1 = r13
        L_0x00b1:
            androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$detectSelectionHandleDragGestures$6 r0 = new androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$detectSelectionHandleDragGestures$6
            r0.<init>(r3, r15)
            kotlin.jvm.functions.Function0 r0 = (kotlin.jvm.functions.Function0) r0
            androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionStateKt.logDebug(r0)
            androidx.compose.foundation.text.Handle r0 = r3.getDraggingHandle()
            if (r0 != r15) goto L_0x00c4
            detectSelectionHandleDragGestures$onDragStop$5(r2, r3, r1)
        L_0x00c4:
            kotlin.Unit r15 = kotlin.Unit.INSTANCE
            return r15
        L_0x00c7:
            r0 = move-exception
            r13 = r9
            goto L_0x00cf
        L_0x00ca:
            r0 = move-exception
            r11 = r12
            r12 = r9
            goto L_0x00cf
        L_0x00ce:
            r0 = move-exception
        L_0x00cf:
            r3 = r14
            r15 = r11
            r2 = r12
            r1 = r13
        L_0x00d3:
            androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$detectSelectionHandleDragGestures$6 r4 = new androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$detectSelectionHandleDragGestures$6
            r4.<init>(r3, r15)
            kotlin.jvm.functions.Function0 r4 = (kotlin.jvm.functions.Function0) r4
            androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionStateKt.logDebug(r4)
            androidx.compose.foundation.text.Handle r4 = r3.getDraggingHandle()
            if (r4 != r15) goto L_0x00e6
            detectSelectionHandleDragGestures$onDragStop$5(r2, r3, r1)
        L_0x00e6:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.detectSelectionHandleDragGestures(androidx.compose.ui.input.pointer.PointerInputScope, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public static final void detectSelectionHandleDragGestures$onDragStop$5(Ref.LongRef longRef, TextFieldSelectionState textFieldSelectionState, Ref.LongRef longRef2) {
        if (OffsetKt.m4006isSpecifiedk4lQ0M(longRef.element)) {
            textFieldSelectionState.clearHandleDragging();
            longRef.element = Offset.Companion.m4002getUnspecifiedF1C5BW0();
            longRef2.element = Offset.Companion.m4003getZeroF1C5BW0();
            textFieldSelectionState.previousRawDragOffset = -1;
        }
    }

    /* access modifiers changed from: private */
    public final Object observeTextChanges(Continuation<? super Unit> continuation) {
        Object collect = FlowKt.drop(FlowKt.distinctUntilChanged(SnapshotStateKt.snapshotFlow(new TextFieldSelectionState$observeTextChanges$2(this)), TextFieldSelectionState$observeTextChanges$3.INSTANCE), 1).collect(new TextFieldSelectionState$observeTextChanges$4(this), continuation);
        return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public final Object observeTextToolbarVisibility(Continuation<? super Unit> continuation) {
        Object collect = SnapshotStateKt.snapshotFlow(new TextFieldSelectionState$observeTextToolbarVisibility$2(this)).collect(new TextFieldSelectionState$observeTextToolbarVisibility$3(this), continuation);
        return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public final Rect getContentRect() {
        float f;
        Rect cursorRect;
        Rect cursorRect2;
        TextFieldCharSequence visualText = this.textFieldState.getVisualText();
        if (TextRange.m6558getCollapsedimpl(visualText.m1312getSelectiond9O1mEE())) {
            Rect cursorRect3 = getCursorRect();
            LayoutCoordinates textLayoutCoordinates = getTextLayoutCoordinates();
            return RectKt.m4027Recttz77jQw(textLayoutCoordinates != null ? textLayoutCoordinates.m5803localToRootMKHz9U(cursorRect3.m4022getTopLeftF1C5BW0()) : Offset.Companion.m4003getZeroF1C5BW0(), cursorRect3.m4020getSizeNHjbRc());
        }
        LayoutCoordinates textLayoutCoordinates2 = getTextLayoutCoordinates();
        long r1 = textLayoutCoordinates2 != null ? textLayoutCoordinates2.m5803localToRootMKHz9U(m1476getHandlePositiontuRUvjQ(true)) : Offset.Companion.m4003getZeroF1C5BW0();
        LayoutCoordinates textLayoutCoordinates3 = getTextLayoutCoordinates();
        long r3 = textLayoutCoordinates3 != null ? textLayoutCoordinates3.m5803localToRootMKHz9U(m1476getHandlePositiontuRUvjQ(false)) : Offset.Companion.m4003getZeroF1C5BW0();
        LayoutCoordinates textLayoutCoordinates4 = getTextLayoutCoordinates();
        float f2 = 0.0f;
        if (textLayoutCoordinates4 != null) {
            TextLayoutResult layoutResult = this.textLayoutState.getLayoutResult();
            f = Offset.m3988getYimpl(textLayoutCoordinates4.m5803localToRootMKHz9U(OffsetKt.Offset(0.0f, (layoutResult == null || (cursorRect2 = layoutResult.getCursorRect(TextRange.m6564getStartimpl(visualText.m1312getSelectiond9O1mEE()))) == null) ? 0.0f : cursorRect2.getTop())));
        } else {
            f = 0.0f;
        }
        LayoutCoordinates textLayoutCoordinates5 = getTextLayoutCoordinates();
        if (textLayoutCoordinates5 != null) {
            TextLayoutResult layoutResult2 = this.textLayoutState.getLayoutResult();
            f2 = Offset.m3988getYimpl(textLayoutCoordinates5.m5803localToRootMKHz9U(OffsetKt.Offset(0.0f, (layoutResult2 == null || (cursorRect = layoutResult2.getCursorRect(TextRange.m6559getEndimpl(visualText.m1312getSelectiond9O1mEE()))) == null) ? 0.0f : cursorRect.getTop())));
        }
        return new Rect(Math.min(Offset.m3987getXimpl(r1), Offset.m3987getXimpl(r3)), Math.min(f, f2), Math.max(Offset.m3987getXimpl(r1), Offset.m3987getXimpl(r3)), Math.max(Offset.m3988getYimpl(r1), Offset.m3988getYimpl(r3)));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0052, code lost:
        if (((r0 == null || (r0 = androidx.compose.foundation.text.selection.SelectionManagerKt.visibleBounds(r0)) == null) ? false : androidx.compose.foundation.text.selection.SelectionManagerKt.m1624containsInclusiveUv8p0NA(r0, r4)) != false) goto L_0x0054;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.compose.foundation.text.input.internal.selection.TextFieldHandleState getSelectionHandleState$foundation_release(boolean r14, boolean r15) {
        /*
            r13 = this;
            if (r14 == 0) goto L_0x0005
            androidx.compose.foundation.text.Handle r0 = androidx.compose.foundation.text.Handle.SelectionStart
            goto L_0x0007
        L_0x0005:
            androidx.compose.foundation.text.Handle r0 = androidx.compose.foundation.text.Handle.SelectionEnd
        L_0x0007:
            androidx.compose.foundation.text.input.internal.TextLayoutState r1 = r13.textLayoutState
            androidx.compose.ui.text.TextLayoutResult r1 = r1.getLayoutResult()
            if (r1 != 0) goto L_0x0016
            androidx.compose.foundation.text.input.internal.selection.TextFieldHandleState$Companion r14 = androidx.compose.foundation.text.input.internal.selection.TextFieldHandleState.Companion
            androidx.compose.foundation.text.input.internal.selection.TextFieldHandleState r14 = r14.getHidden()
            return r14
        L_0x0016:
            androidx.compose.foundation.text.input.internal.TransformedTextFieldState r2 = r13.textFieldState
            androidx.compose.foundation.text.input.TextFieldCharSequence r2 = r2.getVisualText()
            long r2 = r2.m1312getSelectiond9O1mEE()
            boolean r4 = androidx.compose.ui.text.TextRange.m6558getCollapsedimpl(r2)
            if (r4 == 0) goto L_0x002d
            androidx.compose.foundation.text.input.internal.selection.TextFieldHandleState$Companion r14 = androidx.compose.foundation.text.input.internal.selection.TextFieldHandleState.Companion
            androidx.compose.foundation.text.input.internal.selection.TextFieldHandleState r14 = r14.getHidden()
            return r14
        L_0x002d:
            long r4 = r13.m1476getHandlePositiontuRUvjQ(r14)
            androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$InputType r6 = r13.getDirectDragGestureInitiator()
            androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$InputType r7 = androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.InputType.None
            if (r6 != r7) goto L_0x00a2
            androidx.compose.foundation.text.Handle r6 = r13.getDraggingHandle()
            r7 = 0
            if (r6 == r0) goto L_0x0054
            androidx.compose.ui.layout.LayoutCoordinates r0 = r13.getTextLayoutCoordinates()
            if (r0 == 0) goto L_0x0051
            androidx.compose.ui.geometry.Rect r0 = androidx.compose.foundation.text.selection.SelectionManagerKt.visibleBounds(r0)
            if (r0 == 0) goto L_0x0051
            boolean r0 = androidx.compose.foundation.text.selection.SelectionManagerKt.m1624containsInclusiveUv8p0NA(r0, r4)
            goto L_0x0052
        L_0x0051:
            r0 = r7
        L_0x0052:
            if (r0 == 0) goto L_0x00a2
        L_0x0054:
            androidx.compose.foundation.text.input.internal.TransformedTextFieldState r0 = r13.textFieldState
            androidx.compose.foundation.text.input.TextFieldCharSequence r0 = r0.getVisualText()
            boolean r0 = r0.shouldShowSelection()
            if (r0 != 0) goto L_0x0067
            androidx.compose.foundation.text.input.internal.selection.TextFieldHandleState$Companion r14 = androidx.compose.foundation.text.input.internal.selection.TextFieldHandleState.Companion
            androidx.compose.foundation.text.input.internal.selection.TextFieldHandleState r14 = r14.getHidden()
            return r14
        L_0x0067:
            if (r14 == 0) goto L_0x006e
            int r14 = androidx.compose.ui.text.TextRange.m6564getStartimpl(r2)
            goto L_0x0078
        L_0x006e:
            int r14 = androidx.compose.ui.text.TextRange.m6559getEndimpl(r2)
            int r14 = r14 + -1
            int r14 = java.lang.Math.max(r14, r7)
        L_0x0078:
            androidx.compose.ui.text.style.ResolvedTextDirection r10 = r1.getBidiRunDirection(r14)
            boolean r11 = androidx.compose.ui.text.TextRange.m6563getReversedimpl(r2)
            if (r15 == 0) goto L_0x0093
            androidx.compose.ui.layout.LayoutCoordinates r14 = r13.getTextLayoutCoordinates()
            if (r14 == 0) goto L_0x0099
            androidx.compose.ui.geometry.Rect r14 = androidx.compose.foundation.text.selection.SelectionManagerKt.visibleBounds(r14)
            if (r14 == 0) goto L_0x0099
            long r4 = androidx.compose.foundation.text.input.internal.TextLayoutStateKt.m1436coerceIn3MmeM6k(r4, r14)
            goto L_0x0099
        L_0x0093:
            androidx.compose.ui.geometry.Offset$Companion r14 = androidx.compose.ui.geometry.Offset.Companion
            long r4 = r14.m4002getUnspecifiedF1C5BW0()
        L_0x0099:
            r8 = r4
            androidx.compose.foundation.text.input.internal.selection.TextFieldHandleState r6 = new androidx.compose.foundation.text.input.internal.selection.TextFieldHandleState
            r7 = 1
            r12 = 0
            r6.<init>(r7, r8, r10, r11, r12)
            return r6
        L_0x00a2:
            androidx.compose.foundation.text.input.internal.selection.TextFieldHandleState$Companion r14 = androidx.compose.foundation.text.input.internal.selection.TextFieldHandleState.Companion
            androidx.compose.foundation.text.input.internal.selection.TextFieldHandleState r14 = r14.getHidden()
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.getSelectionHandleState$foundation_release(boolean, boolean):androidx.compose.foundation.text.input.internal.selection.TextFieldHandleState");
    }

    /* access modifiers changed from: private */
    /* renamed from: getHandlePosition-tuRUvjQ  reason: not valid java name */
    public final long m1476getHandlePositiontuRUvjQ(boolean z) {
        int i;
        TextLayoutResult layoutResult = this.textLayoutState.getLayoutResult();
        if (layoutResult == null) {
            return Offset.Companion.m4003getZeroF1C5BW0();
        }
        long r1 = this.textFieldState.getVisualText().m1312getSelectiond9O1mEE();
        if (z) {
            i = TextRange.m6564getStartimpl(r1);
        } else {
            i = TextRange.m6559getEndimpl(r1);
        }
        return TextSelectionDelegateKt.getSelectionHandleCoordinates(layoutResult, i, z, TextRange.m6563getReversedimpl(r1));
    }

    /* renamed from: updateHandleDragging-Uv8p0NA  reason: not valid java name */
    public final void m1486updateHandleDraggingUv8p0NA(Handle handle, long j) {
        setDraggingHandle(handle);
        m1481setRawHandleDragPositionk4lQ0M(j);
    }

    /* access modifiers changed from: private */
    public final void markStartContentVisibleOffset() {
        m1482setStartTextLayoutPositionInWindowk4lQ0M(m1475getCurrentTextLayoutPositionInWindowF1C5BW0());
    }

    public final void clearHandleDragging() {
        setDraggingHandle((Handle) null);
        m1481setRawHandleDragPositionk4lQ0M(Offset.Companion.m4002getUnspecifiedF1C5BW0());
        m1482setStartTextLayoutPositionInWindowk4lQ0M(Offset.Companion.m4002getUnspecifiedF1C5BW0());
    }

    public final boolean canCut() {
        return !TextRange.m6558getCollapsedimpl(this.textFieldState.getVisualText().m1312getSelectiond9O1mEE()) && getEditable() && !this.isPassword;
    }

    public final void cut() {
        TextFieldCharSequence visualText = this.textFieldState.getVisualText();
        if (!TextRange.m6558getCollapsedimpl(visualText.m1312getSelectiond9O1mEE())) {
            ClipboardManager clipboardManager2 = this.clipboardManager;
            if (clipboardManager2 != null) {
                clipboardManager2.setText(new AnnotatedString(TextFieldCharSequenceKt.getSelectedText(visualText).toString(), (List) null, (List) null, 6, (DefaultConstructorMarker) null));
            }
            this.textFieldState.deleteSelectedText();
        }
    }

    public final boolean canCopy() {
        return !TextRange.m6558getCollapsedimpl(this.textFieldState.getVisualText().m1312getSelectiond9O1mEE()) && !this.isPassword;
    }

    public static /* synthetic */ void copy$default(TextFieldSelectionState textFieldSelectionState, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        textFieldSelectionState.copy(z);
    }

    public final void copy(boolean z) {
        TextFieldCharSequence visualText = this.textFieldState.getVisualText();
        if (!TextRange.m6558getCollapsedimpl(visualText.m1312getSelectiond9O1mEE())) {
            ClipboardManager clipboardManager2 = this.clipboardManager;
            if (clipboardManager2 != null) {
                clipboardManager2.setText(new AnnotatedString(TextFieldCharSequenceKt.getSelectedText(visualText).toString(), (List) null, (List) null, 6, (DefaultConstructorMarker) null));
            }
            if (z) {
                this.textFieldState.collapseSelectionToMax();
            }
        }
    }

    public final boolean canPaste() {
        if (!getEditable()) {
            return false;
        }
        ClipboardManager clipboardManager2 = this.clipboardManager;
        if (clipboardManager2 != null && clipboardManager2.hasText()) {
            return true;
        }
        Function0<? extends ReceiveContentConfiguration> function0 = this.receiveContentConfiguration;
        ClipEntry clipEntry = null;
        if ((function0 != null ? (ReceiveContentConfiguration) function0.invoke() : null) != null) {
            ClipboardManager clipboardManager3 = this.clipboardManager;
            if (clipboardManager3 != null) {
                clipEntry = clipboardManager3.getClip();
            }
            if (clipEntry != null) {
                return true;
            }
        }
        return false;
    }

    public final void paste() {
        ReceiveContentConfiguration receiveContentConfiguration2;
        ClipEntry clip;
        ClipEntry clipEntry;
        String readPlainText;
        Function0<? extends ReceiveContentConfiguration> function0 = this.receiveContentConfiguration;
        if (function0 == null || (receiveContentConfiguration2 = (ReceiveContentConfiguration) function0.invoke()) == null) {
            pasteAsPlainText();
            return;
        }
        ClipboardManager clipboardManager2 = this.clipboardManager;
        if (clipboardManager2 == null || (clip = clipboardManager2.getClip()) == null) {
            pasteAsPlainText();
            return;
        }
        TransferableContent onReceive = receiveContentConfiguration2.getReceiveContentListener().onReceive(new TransferableContent(clip, clip.getClipMetadata(), TransferableContent.Source.Companion.m365getClipboardkB6V9T0(), (PlatformTransferableContent) null, 8, (DefaultConstructorMarker) null));
        if (onReceive != null && (clipEntry = onReceive.getClipEntry()) != null && (readPlainText = TransferableContent_androidKt.readPlainText(clipEntry)) != null) {
            TransformedTextFieldState.replaceSelectedText$default(this.textFieldState, readPlainText, false, TextFieldEditUndoBehavior.NeverMerge, 2, (Object) null);
        }
    }

    private final void pasteAsPlainText() {
        AnnotatedString text;
        String text2;
        ClipboardManager clipboardManager2 = this.clipboardManager;
        if (clipboardManager2 != null && (text = clipboardManager2.getText()) != null && (text2 = text.getText()) != null) {
            TransformedTextFieldState.replaceSelectedText$default(this.textFieldState, text2, false, TextFieldEditUndoBehavior.NeverMerge, 2, (Object) null);
        }
    }

    public final boolean canSelectAll() {
        return TextRange.m6560getLengthimpl(this.textFieldState.getVisualText().m1312getSelectiond9O1mEE()) != this.textFieldState.getVisualText().length();
    }

    public final void selectAll() {
        this.textFieldState.selectAll();
    }

    /* access modifiers changed from: private */
    public final void showTextToolbar(Rect rect) {
        Function0 function0;
        Function0 function02;
        Function0 function03;
        TextToolbar textToolbar2 = this.textToolbar;
        if (textToolbar2 != null) {
            boolean canCopy = canCopy();
            TextToolbarState textToolbarState = TextToolbarState.None;
            Function0 function04 = null;
            if (!canCopy) {
                function0 = null;
            } else {
                function0 = new TextFieldSelectionState$showTextToolbar$$inlined$menuItem$1(this, textToolbarState, this);
            }
            boolean canPaste = canPaste();
            TextToolbarState textToolbarState2 = TextToolbarState.None;
            if (!canPaste) {
                function02 = null;
            } else {
                function02 = new TextFieldSelectionState$showTextToolbar$$inlined$menuItem$2(this, textToolbarState2, this);
            }
            boolean canCut = canCut();
            TextToolbarState textToolbarState3 = TextToolbarState.None;
            if (!canCut) {
                function03 = null;
            } else {
                function03 = new TextFieldSelectionState$showTextToolbar$$inlined$menuItem$3(this, textToolbarState3, this);
            }
            boolean canSelectAll = canSelectAll();
            TextToolbarState textToolbarState4 = TextToolbarState.Selection;
            if (canSelectAll) {
                function04 = new TextFieldSelectionState$showTextToolbar$$inlined$menuItem$4(this, textToolbarState4, this);
            }
            textToolbar2.showMenu(rect, function0, function02, function03, function04);
        }
    }

    private final Function0<Unit> menuItem(boolean z, TextToolbarState textToolbarState, Function0<Unit> function0) {
        if (!z) {
            return null;
        }
        return new TextFieldSelectionState$menuItem$1(function0, this, textToolbarState);
    }

    public final void deselect() {
        if (!TextRange.m6558getCollapsedimpl(this.textFieldState.getVisualText().m1312getSelectiond9O1mEE())) {
            this.textFieldState.collapseSelectionToEnd();
        }
        setShowCursorHandle(false);
        updateTextToolbarState(TextToolbarState.None);
    }

    /* access modifiers changed from: private */
    public final void hideTextToolbar() {
        TextToolbar textToolbar2;
        TextToolbar textToolbar3 = this.textToolbar;
        if ((textToolbar3 != null ? textToolbar3.getStatus() : null) == TextToolbarStatus.Shown && (textToolbar2 = this.textToolbar) != null) {
            textToolbar2.hide();
        }
    }

    /* renamed from: updateSelection-SsL-Rf8$default  reason: not valid java name */
    static /* synthetic */ long m1484updateSelectionSsLRf8$default(TextFieldSelectionState textFieldSelectionState, TextFieldCharSequence textFieldCharSequence, int i, int i2, boolean z, SelectionAdjustment selectionAdjustment, boolean z2, boolean z3, int i3, Object obj) {
        if ((i3 & 32) != 0) {
            z2 = false;
        }
        if ((i3 & 64) != 0) {
            z3 = false;
        }
        return textFieldSelectionState.m1483updateSelectionSsLRf8(textFieldCharSequence, i, i2, z, selectionAdjustment, z2, z3);
    }

    /* access modifiers changed from: private */
    /* renamed from: updateSelection-SsL-Rf8  reason: not valid java name */
    public final long m1483updateSelectionSsLRf8(TextFieldCharSequence textFieldCharSequence, int i, int i2, boolean z, SelectionAdjustment selectionAdjustment, boolean z2, boolean z3) {
        HapticFeedback hapticFeedback;
        TextRange r0 = TextRange.m6552boximpl(textFieldCharSequence.m1312getSelectiond9O1mEE());
        long r1 = r0.m6568unboximpl();
        if (z3 || (!z2 && TextRange.m6558getCollapsedimpl(r1))) {
            r0 = null;
        }
        int i3 = i2;
        int i4 = i;
        long r6 = m1479getTextFieldSelectionqeG_v_k(i4, i3, r0, z, selectionAdjustment);
        if (!TextRange.m6557equalsimpl0(r6, textFieldCharSequence.m1312getSelectiond9O1mEE())) {
            boolean z4 = TextRange.m6563getReversedimpl(r6) != TextRange.m6563getReversedimpl(textFieldCharSequence.m1312getSelectiond9O1mEE()) && TextRange.m6557equalsimpl0(TextRangeKt.TextRange(TextRange.m6559getEndimpl(r6), TextRange.m6564getStartimpl(r6)), textFieldCharSequence.m1312getSelectiond9O1mEE());
            if (isInTouchMode() && !z4 && (hapticFeedback = this.hapticFeedBack) != null) {
                hapticFeedback.m5090performHapticFeedbackCdsT49E(HapticFeedbackType.Companion.m5099getTextHandleMove5zf0vsI());
            }
        }
        return r6;
    }

    /* renamed from: getTextFieldSelection-qeG_v_k  reason: not valid java name */
    private final long m1479getTextFieldSelectionqeG_v_k(int i, int i2, TextRange textRange, boolean z, SelectionAdjustment selectionAdjustment) {
        long j;
        TextLayoutResult layoutResult = this.textLayoutState.getLayoutResult();
        if (layoutResult == null) {
            return TextRange.Companion.m6569getZerod9O1mEE();
        }
        if (textRange == null && Intrinsics.areEqual((Object) selectionAdjustment, (Object) SelectionAdjustment.Companion.getCharacter())) {
            return TextRangeKt.TextRange(i, i2);
        }
        int i3 = this.previousRawDragOffset;
        if (textRange != null) {
            j = textRange.m6568unboximpl();
        } else {
            j = TextRange.Companion.m6569getZerod9O1mEE();
        }
        long j2 = j;
        int i4 = i;
        int i5 = i2;
        boolean z2 = z;
        SelectionLayout r10 = SelectionLayoutKt.m1587getTextFieldSelectionLayoutRcvTLA(layoutResult, i4, i5, i3, j2, textRange == null, z2);
        if (textRange != null && !r10.shouldRecomputeSelection(this.previousSelectionLayout)) {
            return textRange.m6568unboximpl();
        }
        long r11 = selectionAdjustment.adjust(r10).m1572toTextRanged9O1mEE();
        this.previousSelectionLayout = r10;
        this.previousRawDragOffset = z2 ? i4 : i5;
        return r11;
    }
}
