package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.Handle;
import androidx.compose.foundation.text.HandleState;
import androidx.compose.foundation.text.LegacyTextFieldState;
import androidx.compose.foundation.text.TextDelegate;
import androidx.compose.foundation.text.TextDragObserver;
import androidx.compose.foundation.text.TextFieldCursorKt;
import androidx.compose.foundation.text.TextLayoutResultProxy;
import androidx.compose.foundation.text.UndoManager;
import androidx.compose.foundation.text.ValidatingOffsetMappingKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.hapticfeedback.HapticFeedbackType;
import androidx.compose.ui.platform.ClipboardManager;
import androidx.compose.ui.platform.TextToolbar;
import androidx.compose.ui.platform.TextToolbarStatus;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.PasswordVisualTransformation;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.TextFieldValueKt;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000Â\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\r\u0010p\u001a\u00020FH\u0000¢\u0006\u0002\bqJ\u0018\u0010r\u001a\u00020F2\u0006\u0010s\u001a\u00020\fø\u0001\u0000¢\u0006\u0004\bt\u0010uJ\u0017\u0010v\u001a\u00020F2\b\b\u0002\u0010w\u001a\u00020!H\u0000¢\u0006\u0002\bxJ\"\u0010y\u001a\u00020C2\u0006\u0010z\u001a\u00020_2\u0006\u0010{\u001a\u00020|H\u0002ø\u0001\u0000¢\u0006\u0004\b}\u0010~J\u000e\u0010\u001a\u00020[H\u0000¢\u0006\u0003\b\u0001J\u000f\u0010\u0001\u001a\u00020FH\u0000¢\u0006\u0003\b\u0001J\u001e\u0010\u0001\u001a\u00020F2\n\b\u0002\u0010s\u001a\u0004\u0018\u00010\fH\u0000ø\u0001\u0000¢\u0006\u0003\b\u0001J\u001a\u0010\u0001\u001a\u00020F2\t\b\u0002\u0010\u0001\u001a\u00020!H\u0000¢\u0006\u0003\b\u0001J\u000f\u0010\u0001\u001a\u00020FH\u0000¢\u0006\u0003\b\u0001J\n\u0010\u0001\u001a\u00030\u0001H\u0002J\"\u0010\u0001\u001a\u00020\f2\b\u0010\u0001\u001a\u00030\u0001H\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J!\u0010\u0001\u001a\u00020\f2\u0007\u0010\u0001\u001a\u00020!H\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J\u0018\u0010\u0001\u001a\u00020[2\u0007\u0010\u0001\u001a\u00020!H\u0000¢\u0006\u0003\b\u0001J\u000f\u0010\u0001\u001a\u00020FH\u0000¢\u0006\u0003\b\u0001J\u000f\u0010\u0001\u001a\u00020!H\u0000¢\u0006\u0003\b\u0001J\u000f\u0010\u0001\u001a\u00020FH\u0000¢\u0006\u0003\b\u0001J\u000f\u0010\u0001\u001a\u00020FH\u0000¢\u0006\u0003\b\u0001J\u001d\u0010\u0001\u001a\u00020F2\u0007\u0010 \u0001\u001a\u00020|H\u0000ø\u0001\u0000¢\u0006\u0005\b¡\u0001\u0010uJ\u0013\u0010¢\u0001\u001a\u00020F2\b\u0010£\u0001\u001a\u00030¤\u0001H\u0002J\u001d\u0010¥\u0001\u001a\u00020F2\u0007\u0010 \u0001\u001a\u00020|H\u0000ø\u0001\u0000¢\u0006\u0005\b¦\u0001\u0010uJ\u000f\u0010§\u0001\u001a\u00020FH\u0000¢\u0006\u0003\b¨\u0001J\u0012\u0010©\u0001\u001a\u00020F2\u0007\u0010ª\u0001\u001a\u00020!H\u0002JK\u0010«\u0001\u001a\u00020|2\u0006\u0010d\u001a\u00020C2\u0007\u0010¬\u0001\u001a\u00020\f2\u0007\u0010­\u0001\u001a\u00020!2\u0007\u0010\u0001\u001a\u00020!2\b\u0010®\u0001\u001a\u00030¯\u00012\u0007\u0010°\u0001\u001a\u00020!H\u0002ø\u0001\u0000¢\u0006\u0006\b±\u0001\u0010²\u0001R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR5\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\f8F@BX\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0004\n\u0002\u0010\u0016R\u0016\u0010\u0017\u001a\u00020\fX\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0018R\u0016\u0010\u0019\u001a\u00020\fX\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0018R/\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\u0010\u000b\u001a\u0004\u0018\u00010\u001a8F@BX\u0002¢\u0006\u0012\n\u0004\b \u0010\u0013\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR+\u0010\"\u001a\u00020!2\u0006\u0010\u000b\u001a\u00020!8F@FX\u0002¢\u0006\u0012\n\u0004\b'\u0010\u0013\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R+\u0010(\u001a\u00020!2\u0006\u0010\u000b\u001a\u00020!8F@FX\u0002¢\u0006\u0012\n\u0004\b+\u0010\u0013\u001a\u0004\b)\u0010$\"\u0004\b*\u0010&R\u001c\u0010,\u001a\u0004\u0018\u00010-X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001c\u00102\u001a\u0004\u0018\u000103X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u0014\u00108\u001a\u000209X\u0004¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;R\u001a\u0010<\u001a\u00020=X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u000e\u0010B\u001a\u00020CX\u000e¢\u0006\u0002\n\u0000R&\u0010D\u001a\u000e\u0012\u0004\u0012\u00020C\u0012\u0004\u0012\u00020F0EX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\u000e\u0010K\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010L\u001a\u0004\u0018\u00010MX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010N\u001a\u0004\u0018\u00010OX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR\u001c\u0010T\u001a\u0004\u0018\u00010UX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR\u0014\u0010Z\u001a\u00020[X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\\\u0010]R\u0016\u0010^\u001a\u0004\u0018\u00010_8@X\u0004¢\u0006\u0006\u001a\u0004\b`\u0010aR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bb\u0010cR+\u0010d\u001a\u00020C2\u0006\u0010\u000b\u001a\u00020C8@@@X\u0002¢\u0006\u0012\n\u0004\bi\u0010\u0013\u001a\u0004\be\u0010f\"\u0004\bg\u0010hR\u001a\u0010j\u001a\u00020kX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bl\u0010m\"\u0004\bn\u0010o\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006³\u0001"}, d2 = {"Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;", "", "undoManager", "Landroidx/compose/foundation/text/UndoManager;", "(Landroidx/compose/foundation/text/UndoManager;)V", "clipboardManager", "Landroidx/compose/ui/platform/ClipboardManager;", "getClipboardManager$foundation_release", "()Landroidx/compose/ui/platform/ClipboardManager;", "setClipboardManager$foundation_release", "(Landroidx/compose/ui/platform/ClipboardManager;)V", "<set-?>", "Landroidx/compose/ui/geometry/Offset;", "currentDragPosition", "getCurrentDragPosition-_m7T9-E", "()Landroidx/compose/ui/geometry/Offset;", "setCurrentDragPosition-_kEHs6E", "(Landroidx/compose/ui/geometry/Offset;)V", "currentDragPosition$delegate", "Landroidx/compose/runtime/MutableState;", "dragBeginOffsetInText", "", "Ljava/lang/Integer;", "dragBeginPosition", "J", "dragTotalDistance", "Landroidx/compose/foundation/text/Handle;", "draggingHandle", "getDraggingHandle", "()Landroidx/compose/foundation/text/Handle;", "setDraggingHandle", "(Landroidx/compose/foundation/text/Handle;)V", "draggingHandle$delegate", "", "editable", "getEditable", "()Z", "setEditable", "(Z)V", "editable$delegate", "enabled", "getEnabled", "setEnabled", "enabled$delegate", "focusRequester", "Landroidx/compose/ui/focus/FocusRequester;", "getFocusRequester", "()Landroidx/compose/ui/focus/FocusRequester;", "setFocusRequester", "(Landroidx/compose/ui/focus/FocusRequester;)V", "hapticFeedBack", "Landroidx/compose/ui/hapticfeedback/HapticFeedback;", "getHapticFeedBack", "()Landroidx/compose/ui/hapticfeedback/HapticFeedback;", "setHapticFeedBack", "(Landroidx/compose/ui/hapticfeedback/HapticFeedback;)V", "mouseSelectionObserver", "Landroidx/compose/foundation/text/selection/MouseSelectionObserver;", "getMouseSelectionObserver$foundation_release", "()Landroidx/compose/foundation/text/selection/MouseSelectionObserver;", "offsetMapping", "Landroidx/compose/ui/text/input/OffsetMapping;", "getOffsetMapping$foundation_release", "()Landroidx/compose/ui/text/input/OffsetMapping;", "setOffsetMapping$foundation_release", "(Landroidx/compose/ui/text/input/OffsetMapping;)V", "oldValue", "Landroidx/compose/ui/text/input/TextFieldValue;", "onValueChange", "Lkotlin/Function1;", "", "getOnValueChange$foundation_release", "()Lkotlin/jvm/functions/Function1;", "setOnValueChange$foundation_release", "(Lkotlin/jvm/functions/Function1;)V", "previousRawDragOffset", "previousSelectionLayout", "Landroidx/compose/foundation/text/selection/SelectionLayout;", "state", "Landroidx/compose/foundation/text/LegacyTextFieldState;", "getState$foundation_release", "()Landroidx/compose/foundation/text/LegacyTextFieldState;", "setState$foundation_release", "(Landroidx/compose/foundation/text/LegacyTextFieldState;)V", "textToolbar", "Landroidx/compose/ui/platform/TextToolbar;", "getTextToolbar", "()Landroidx/compose/ui/platform/TextToolbar;", "setTextToolbar", "(Landroidx/compose/ui/platform/TextToolbar;)V", "touchSelectionObserver", "Landroidx/compose/foundation/text/TextDragObserver;", "getTouchSelectionObserver$foundation_release", "()Landroidx/compose/foundation/text/TextDragObserver;", "transformedText", "Landroidx/compose/ui/text/AnnotatedString;", "getTransformedText$foundation_release", "()Landroidx/compose/ui/text/AnnotatedString;", "getUndoManager", "()Landroidx/compose/foundation/text/UndoManager;", "value", "getValue$foundation_release", "()Landroidx/compose/ui/text/input/TextFieldValue;", "setValue$foundation_release", "(Landroidx/compose/ui/text/input/TextFieldValue;)V", "value$delegate", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "getVisualTransformation$foundation_release", "()Landroidx/compose/ui/text/input/VisualTransformation;", "setVisualTransformation$foundation_release", "(Landroidx/compose/ui/text/input/VisualTransformation;)V", "clearPreviewHighlight", "clearPreviewHighlight$foundation_release", "contextMenuOpenAdjustment", "position", "contextMenuOpenAdjustment-k-4lQ0M", "(J)V", "copy", "cancelSelection", "copy$foundation_release", "createTextFieldValue", "annotatedString", "selection", "Landroidx/compose/ui/text/TextRange;", "createTextFieldValue-FDrldGo", "(Landroidx/compose/ui/text/AnnotatedString;J)Landroidx/compose/ui/text/input/TextFieldValue;", "cursorDragObserver", "cursorDragObserver$foundation_release", "cut", "cut$foundation_release", "deselect", "deselect-_kEHs6E$foundation_release", "enterSelectionMode", "showFloatingToolbar", "enterSelectionMode$foundation_release", "exitSelectionMode", "exitSelectionMode$foundation_release", "getContentRect", "Landroidx/compose/ui/geometry/Rect;", "getCursorPosition", "density", "Landroidx/compose/ui/unit/Density;", "getCursorPosition-tuRUvjQ$foundation_release", "(Landroidx/compose/ui/unit/Density;)J", "getHandlePosition", "isStartHandle", "getHandlePosition-tuRUvjQ$foundation_release", "(Z)J", "handleDragObserver", "handleDragObserver$foundation_release", "hideSelectionToolbar", "hideSelectionToolbar$foundation_release", "isTextChanged", "isTextChanged$foundation_release", "paste", "paste$foundation_release", "selectAll", "selectAll$foundation_release", "setDeletionPreviewHighlight", "range", "setDeletionPreviewHighlight-5zc-tL8$foundation_release", "setHandleState", "handleState", "Landroidx/compose/foundation/text/HandleState;", "setSelectionPreviewHighlight", "setSelectionPreviewHighlight-5zc-tL8$foundation_release", "showSelectionToolbar", "showSelectionToolbar$foundation_release", "updateFloatingToolbar", "show", "updateSelection", "currentPosition", "isStartOfSelection", "adjustment", "Landroidx/compose/foundation/text/selection/SelectionAdjustment;", "isTouchBasedSelection", "updateSelection-8UEBfa8", "(Landroidx/compose/ui/text/input/TextFieldValue;JZZLandroidx/compose/foundation/text/selection/SelectionAdjustment;Z)J", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldSelectionManager.kt */
public final class TextFieldSelectionManager {
    public static final int $stable = 8;
    private ClipboardManager clipboardManager;
    private final MutableState currentDragPosition$delegate;
    /* access modifiers changed from: private */
    public Integer dragBeginOffsetInText;
    /* access modifiers changed from: private */
    public long dragBeginPosition;
    /* access modifiers changed from: private */
    public long dragTotalDistance;
    private final MutableState draggingHandle$delegate;
    private final MutableState editable$delegate;
    private final MutableState enabled$delegate;
    private FocusRequester focusRequester;
    private HapticFeedback hapticFeedBack;
    private final MouseSelectionObserver mouseSelectionObserver;
    private OffsetMapping offsetMapping;
    private TextFieldValue oldValue;
    private Function1<? super TextFieldValue, Unit> onValueChange;
    /* access modifiers changed from: private */
    public int previousRawDragOffset;
    private SelectionLayout previousSelectionLayout;
    private LegacyTextFieldState state;
    private TextToolbar textToolbar;
    private final TextDragObserver touchSelectionObserver;
    private final UndoManager undoManager;
    private final MutableState value$delegate;
    private VisualTransformation visualTransformation;

    public TextFieldSelectionManager() {
        this((UndoManager) null, 1, (DefaultConstructorMarker) null);
    }

    public TextFieldSelectionManager(UndoManager undoManager2) {
        this.undoManager = undoManager2;
        this.offsetMapping = ValidatingOffsetMappingKt.getValidatingEmptyOffsetMappingIdentity();
        this.onValueChange = TextFieldSelectionManager$onValueChange$1.INSTANCE;
        this.value$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new TextFieldValue((String) null, 0, (TextRange) null, 7, (DefaultConstructorMarker) null), (SnapshotMutationPolicy) null, 2, (Object) null);
        this.visualTransformation = VisualTransformation.Companion.getNone();
        this.editable$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(true, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.enabled$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(true, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.dragBeginPosition = Offset.Companion.m4003getZeroF1C5BW0();
        this.dragTotalDistance = Offset.Companion.m4003getZeroF1C5BW0();
        this.draggingHandle$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.currentDragPosition$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.previousRawDragOffset = -1;
        this.oldValue = new TextFieldValue((String) null, 0, (TextRange) null, 7, (DefaultConstructorMarker) null);
        this.touchSelectionObserver = new TextFieldSelectionManager$touchSelectionObserver$1(this);
        this.mouseSelectionObserver = new TextFieldSelectionManager$mouseSelectionObserver$1(this);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TextFieldSelectionManager(UndoManager undoManager2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : undoManager2);
    }

    public final UndoManager getUndoManager() {
        return this.undoManager;
    }

    public final OffsetMapping getOffsetMapping$foundation_release() {
        return this.offsetMapping;
    }

    public final void setOffsetMapping$foundation_release(OffsetMapping offsetMapping2) {
        this.offsetMapping = offsetMapping2;
    }

    public final Function1<TextFieldValue, Unit> getOnValueChange$foundation_release() {
        return this.onValueChange;
    }

    public final void setOnValueChange$foundation_release(Function1<? super TextFieldValue, Unit> function1) {
        this.onValueChange = function1;
    }

    public final LegacyTextFieldState getState$foundation_release() {
        return this.state;
    }

    public final void setState$foundation_release(LegacyTextFieldState legacyTextFieldState) {
        this.state = legacyTextFieldState;
    }

    public final TextFieldValue getValue$foundation_release() {
        return (TextFieldValue) this.value$delegate.getValue();
    }

    public final void setValue$foundation_release(TextFieldValue textFieldValue) {
        this.value$delegate.setValue(textFieldValue);
    }

    public final AnnotatedString getTransformedText$foundation_release() {
        TextDelegate textDelegate;
        LegacyTextFieldState legacyTextFieldState = this.state;
        if (legacyTextFieldState == null || (textDelegate = legacyTextFieldState.getTextDelegate()) == null) {
            return null;
        }
        return textDelegate.getText();
    }

    public final VisualTransformation getVisualTransformation$foundation_release() {
        return this.visualTransformation;
    }

    public final void setVisualTransformation$foundation_release(VisualTransformation visualTransformation2) {
        this.visualTransformation = visualTransformation2;
    }

    public final ClipboardManager getClipboardManager$foundation_release() {
        return this.clipboardManager;
    }

    public final void setClipboardManager$foundation_release(ClipboardManager clipboardManager2) {
        this.clipboardManager = clipboardManager2;
    }

    public final TextToolbar getTextToolbar() {
        return this.textToolbar;
    }

    public final void setTextToolbar(TextToolbar textToolbar2) {
        this.textToolbar = textToolbar2;
    }

    public final HapticFeedback getHapticFeedBack() {
        return this.hapticFeedBack;
    }

    public final void setHapticFeedBack(HapticFeedback hapticFeedback) {
        this.hapticFeedBack = hapticFeedback;
    }

    public final FocusRequester getFocusRequester() {
        return this.focusRequester;
    }

    public final void setFocusRequester(FocusRequester focusRequester2) {
        this.focusRequester = focusRequester2;
    }

    public final boolean getEditable() {
        return ((Boolean) this.editable$delegate.getValue()).booleanValue();
    }

    public final void setEditable(boolean z) {
        this.editable$delegate.setValue(Boolean.valueOf(z));
    }

    public final boolean getEnabled() {
        return ((Boolean) this.enabled$delegate.getValue()).booleanValue();
    }

    public final void setEnabled(boolean z) {
        this.enabled$delegate.setValue(Boolean.valueOf(z));
    }

    /* access modifiers changed from: private */
    public final void setDraggingHandle(Handle handle) {
        this.draggingHandle$delegate.setValue(handle);
    }

    public final Handle getDraggingHandle() {
        return (Handle) this.draggingHandle$delegate.getValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: setCurrentDragPosition-_kEHs6E  reason: not valid java name */
    public final void m1645setCurrentDragPosition_kEHs6E(Offset offset) {
        this.currentDragPosition$delegate.setValue(offset);
    }

    /* renamed from: getCurrentDragPosition-_m7T9-E  reason: not valid java name */
    public final Offset m1649getCurrentDragPosition_m7T9E() {
        return (Offset) this.currentDragPosition$delegate.getValue();
    }

    public final TextDragObserver getTouchSelectionObserver$foundation_release() {
        return this.touchSelectionObserver;
    }

    public final MouseSelectionObserver getMouseSelectionObserver$foundation_release() {
        return this.mouseSelectionObserver;
    }

    public final TextDragObserver handleDragObserver$foundation_release(boolean z) {
        return new TextFieldSelectionManager$handleDragObserver$1(this, z);
    }

    public final TextDragObserver cursorDragObserver$foundation_release() {
        return new TextFieldSelectionManager$cursorDragObserver$1(this);
    }

    public static /* synthetic */ void enterSelectionMode$foundation_release$default(TextFieldSelectionManager textFieldSelectionManager, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        textFieldSelectionManager.enterSelectionMode$foundation_release(z);
    }

    public final void enterSelectionMode$foundation_release(boolean z) {
        FocusRequester focusRequester2;
        LegacyTextFieldState legacyTextFieldState = this.state;
        if (!(legacyTextFieldState == null || legacyTextFieldState.getHasFocus() || (focusRequester2 = this.focusRequester) == null)) {
            focusRequester2.requestFocus();
        }
        this.oldValue = getValue$foundation_release();
        updateFloatingToolbar(z);
        setHandleState(HandleState.Selection);
    }

    public final void exitSelectionMode$foundation_release() {
        updateFloatingToolbar(false);
        setHandleState(HandleState.None);
    }

    /* renamed from: deselect-_kEHs6E$foundation_release$default  reason: not valid java name */
    public static /* synthetic */ void m1644deselect_kEHs6E$foundation_release$default(TextFieldSelectionManager textFieldSelectionManager, Offset offset, int i, Object obj) {
        if ((i & 1) != 0) {
            offset = null;
        }
        textFieldSelectionManager.m1648deselect_kEHs6E$foundation_release(offset);
    }

    /* renamed from: deselect-_kEHs6E$foundation_release  reason: not valid java name */
    public final void m1648deselect_kEHs6E$foundation_release(Offset offset) {
        int i;
        if (!TextRange.m6558getCollapsedimpl(getValue$foundation_release().m6823getSelectiond9O1mEE())) {
            LegacyTextFieldState legacyTextFieldState = this.state;
            TextLayoutResultProxy layoutResult = legacyTextFieldState != null ? legacyTextFieldState.getLayoutResult() : null;
            if (offset == null || layoutResult == null) {
                i = TextRange.m6561getMaximpl(getValue$foundation_release().m6823getSelectiond9O1mEE());
            } else {
                i = this.offsetMapping.transformedToOriginal(TextLayoutResultProxy.m1288getOffsetForPosition3MmeM6k$default(layoutResult, offset.m3997unboximpl(), false, 2, (Object) null));
            }
            this.onValueChange.invoke(TextFieldValue.m6818copy3r_uNRQ$default(getValue$foundation_release(), (AnnotatedString) null, TextRangeKt.TextRange(i), (TextRange) null, 5, (Object) null));
        }
        setHandleState((offset == null || getValue$foundation_release().getText().length() <= 0) ? HandleState.None : HandleState.Cursor);
        updateFloatingToolbar(false);
    }

    /* renamed from: setSelectionPreviewHighlight-5zc-tL8$foundation_release  reason: not valid java name */
    public final void m1653setSelectionPreviewHighlight5zctL8$foundation_release(long j) {
        LegacyTextFieldState legacyTextFieldState = this.state;
        if (legacyTextFieldState != null) {
            legacyTextFieldState.m1218setSelectionPreviewHighlightRange5zctL8(j);
        }
        LegacyTextFieldState legacyTextFieldState2 = this.state;
        if (legacyTextFieldState2 != null) {
            legacyTextFieldState2.m1215setDeletionPreviewHighlightRange5zctL8(TextRange.Companion.m6569getZerod9O1mEE());
        }
        if (!TextRange.m6558getCollapsedimpl(j)) {
            exitSelectionMode$foundation_release();
        }
    }

    /* renamed from: setDeletionPreviewHighlight-5zc-tL8$foundation_release  reason: not valid java name */
    public final void m1652setDeletionPreviewHighlight5zctL8$foundation_release(long j) {
        LegacyTextFieldState legacyTextFieldState = this.state;
        if (legacyTextFieldState != null) {
            legacyTextFieldState.m1215setDeletionPreviewHighlightRange5zctL8(j);
        }
        LegacyTextFieldState legacyTextFieldState2 = this.state;
        if (legacyTextFieldState2 != null) {
            legacyTextFieldState2.m1218setSelectionPreviewHighlightRange5zctL8(TextRange.Companion.m6569getZerod9O1mEE());
        }
        if (!TextRange.m6558getCollapsedimpl(j)) {
            exitSelectionMode$foundation_release();
        }
    }

    public final void clearPreviewHighlight$foundation_release() {
        LegacyTextFieldState legacyTextFieldState = this.state;
        if (legacyTextFieldState != null) {
            legacyTextFieldState.m1215setDeletionPreviewHighlightRange5zctL8(TextRange.Companion.m6569getZerod9O1mEE());
        }
        LegacyTextFieldState legacyTextFieldState2 = this.state;
        if (legacyTextFieldState2 != null) {
            legacyTextFieldState2.m1218setSelectionPreviewHighlightRange5zctL8(TextRange.Companion.m6569getZerod9O1mEE());
        }
    }

    public static /* synthetic */ void copy$foundation_release$default(TextFieldSelectionManager textFieldSelectionManager, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        textFieldSelectionManager.copy$foundation_release(z);
    }

    public final void copy$foundation_release(boolean z) {
        if (!TextRange.m6558getCollapsedimpl(getValue$foundation_release().m6823getSelectiond9O1mEE())) {
            ClipboardManager clipboardManager2 = this.clipboardManager;
            if (clipboardManager2 != null) {
                clipboardManager2.setText(TextFieldValueKt.getSelectedText(getValue$foundation_release()));
            }
            if (z) {
                int r4 = TextRange.m6561getMaximpl(getValue$foundation_release().m6823getSelectiond9O1mEE());
                this.onValueChange.invoke(m1643createTextFieldValueFDrldGo(getValue$foundation_release().getAnnotatedString(), TextRangeKt.TextRange(r4, r4)));
                setHandleState(HandleState.None);
            }
        }
    }

    public final void paste$foundation_release() {
        AnnotatedString text;
        ClipboardManager clipboardManager2 = this.clipboardManager;
        if (clipboardManager2 != null && (text = clipboardManager2.getText()) != null) {
            AnnotatedString plus = TextFieldValueKt.getTextBeforeSelection(getValue$foundation_release(), getValue$foundation_release().getText().length()).plus(text).plus(TextFieldValueKt.getTextAfterSelection(getValue$foundation_release(), getValue$foundation_release().getText().length()));
            int r2 = TextRange.m6562getMinimpl(getValue$foundation_release().m6823getSelectiond9O1mEE()) + text.length();
            this.onValueChange.invoke(m1643createTextFieldValueFDrldGo(plus, TextRangeKt.TextRange(r2, r2)));
            setHandleState(HandleState.None);
            UndoManager undoManager2 = this.undoManager;
            if (undoManager2 != null) {
                undoManager2.forceNextSnapshot();
            }
        }
    }

    public final void cut$foundation_release() {
        if (!TextRange.m6558getCollapsedimpl(getValue$foundation_release().m6823getSelectiond9O1mEE())) {
            ClipboardManager clipboardManager2 = this.clipboardManager;
            if (clipboardManager2 != null) {
                clipboardManager2.setText(TextFieldValueKt.getSelectedText(getValue$foundation_release()));
            }
            AnnotatedString plus = TextFieldValueKt.getTextBeforeSelection(getValue$foundation_release(), getValue$foundation_release().getText().length()).plus(TextFieldValueKt.getTextAfterSelection(getValue$foundation_release(), getValue$foundation_release().getText().length()));
            int r1 = TextRange.m6562getMinimpl(getValue$foundation_release().m6823getSelectiond9O1mEE());
            this.onValueChange.invoke(m1643createTextFieldValueFDrldGo(plus, TextRangeKt.TextRange(r1, r1)));
            setHandleState(HandleState.None);
            UndoManager undoManager2 = this.undoManager;
            if (undoManager2 != null) {
                undoManager2.forceNextSnapshot();
            }
        }
    }

    public final void selectAll$foundation_release() {
        TextFieldValue r0 = m1643createTextFieldValueFDrldGo(getValue$foundation_release().getAnnotatedString(), TextRangeKt.TextRange(0, getValue$foundation_release().getText().length()));
        this.onValueChange.invoke(r0);
        this.oldValue = TextFieldValue.m6818copy3r_uNRQ$default(this.oldValue, (AnnotatedString) null, r0.m6823getSelectiond9O1mEE(), (TextRange) null, 5, (Object) null);
        enterSelectionMode$foundation_release(true);
    }

    /* renamed from: getHandlePosition-tuRUvjQ$foundation_release  reason: not valid java name */
    public final long m1651getHandlePositiontuRUvjQ$foundation_release(boolean z) {
        TextLayoutResultProxy layoutResult;
        TextLayoutResult value;
        LegacyTextFieldState legacyTextFieldState = this.state;
        if (legacyTextFieldState == null || (layoutResult = legacyTextFieldState.getLayoutResult()) == null || (value = layoutResult.getValue()) == null) {
            return Offset.Companion.m4002getUnspecifiedF1C5BW0();
        }
        AnnotatedString transformedText$foundation_release = getTransformedText$foundation_release();
        if (transformedText$foundation_release == null) {
            return Offset.Companion.m4002getUnspecifiedF1C5BW0();
        }
        if (!Intrinsics.areEqual((Object) transformedText$foundation_release.getText(), (Object) value.getLayoutInput().getText().getText())) {
            return Offset.Companion.m4002getUnspecifiedF1C5BW0();
        }
        long r1 = getValue$foundation_release().m6823getSelectiond9O1mEE();
        return TextSelectionDelegateKt.getSelectionHandleCoordinates(value, this.offsetMapping.originalToTransformed(z ? TextRange.m6564getStartimpl(r1) : TextRange.m6559getEndimpl(r1)), z, TextRange.m6563getReversedimpl(getValue$foundation_release().m6823getSelectiond9O1mEE()));
    }

    /* renamed from: getCursorPosition-tuRUvjQ$foundation_release  reason: not valid java name */
    public final long m1650getCursorPositiontuRUvjQ$foundation_release(Density density) {
        int originalToTransformed = this.offsetMapping.originalToTransformed(TextRange.m6564getStartimpl(getValue$foundation_release().m6823getSelectiond9O1mEE()));
        LegacyTextFieldState legacyTextFieldState = this.state;
        TextLayoutResultProxy layoutResult = legacyTextFieldState != null ? legacyTextFieldState.getLayoutResult() : null;
        Intrinsics.checkNotNull(layoutResult);
        TextLayoutResult value = layoutResult.getValue();
        Rect cursorRect = value.getCursorRect(RangesKt.coerceIn(originalToTransformed, 0, value.getLayoutInput().getText().length()));
        return OffsetKt.Offset(cursorRect.getLeft() + (density.m7091toPx0680j_4(TextFieldCursorKt.getDefaultCursorThickness()) / ((float) 2)), cursorRect.getBottom());
    }

    /* access modifiers changed from: private */
    public final void updateFloatingToolbar(boolean z) {
        LegacyTextFieldState legacyTextFieldState = this.state;
        if (legacyTextFieldState != null) {
            legacyTextFieldState.setShowFloatingToolbar(z);
        }
        if (z) {
            showSelectionToolbar$foundation_release();
        } else {
            hideSelectionToolbar$foundation_release();
        }
    }

    public final void showSelectionToolbar$foundation_release() {
        ClipboardManager clipboardManager2;
        if (getEnabled()) {
            LegacyTextFieldState legacyTextFieldState = this.state;
            if (legacyTextFieldState == null || legacyTextFieldState.isInTouchMode()) {
                boolean z = this.visualTransformation instanceof PasswordVisualTransformation;
                Function0 function0 = null;
                Function0 textFieldSelectionManager$showSelectionToolbar$copy$1 = (TextRange.m6558getCollapsedimpl(getValue$foundation_release().m6823getSelectiond9O1mEE()) || z) ? null : new TextFieldSelectionManager$showSelectionToolbar$copy$1(this);
                Function0 textFieldSelectionManager$showSelectionToolbar$cut$1 = (TextRange.m6558getCollapsedimpl(getValue$foundation_release().m6823getSelectiond9O1mEE()) || !getEditable() || z) ? null : new TextFieldSelectionManager$showSelectionToolbar$cut$1(this);
                Function0 textFieldSelectionManager$showSelectionToolbar$paste$1 = (!getEditable() || (clipboardManager2 = this.clipboardManager) == null || !clipboardManager2.hasText()) ? null : new TextFieldSelectionManager$showSelectionToolbar$paste$1(this);
                if (TextRange.m6560getLengthimpl(getValue$foundation_release().m6823getSelectiond9O1mEE()) != getValue$foundation_release().getText().length()) {
                    function0 = new TextFieldSelectionManager$showSelectionToolbar$selectAll$1(this);
                }
                Function0 function02 = function0;
                TextToolbar textToolbar2 = this.textToolbar;
                if (textToolbar2 != null) {
                    textToolbar2.showMenu(getContentRect(), textFieldSelectionManager$showSelectionToolbar$copy$1, textFieldSelectionManager$showSelectionToolbar$paste$1, textFieldSelectionManager$showSelectionToolbar$cut$1, function02);
                }
            }
        }
    }

    public final void hideSelectionToolbar$foundation_release() {
        TextToolbar textToolbar2;
        TextToolbar textToolbar3 = this.textToolbar;
        if ((textToolbar3 != null ? textToolbar3.getStatus() : null) == TextToolbarStatus.Shown && (textToolbar2 = this.textToolbar) != null) {
            textToolbar2.hide();
        }
    }

    /* renamed from: contextMenuOpenAdjustment-k-4lQ0M  reason: not valid java name */
    public final void m1647contextMenuOpenAdjustmentk4lQ0M(long j) {
        TextLayoutResultProxy layoutResult;
        LegacyTextFieldState legacyTextFieldState = this.state;
        if (legacyTextFieldState != null && (layoutResult = legacyTextFieldState.getLayoutResult()) != null) {
            long j2 = j;
            if (!TextRange.m6555containsimpl(getValue$foundation_release().m6823getSelectiond9O1mEE(), TextLayoutResultProxy.m1288getOffsetForPosition3MmeM6k$default(layoutResult, j2, false, 2, (Object) null))) {
                this.previousRawDragOffset = -1;
                m1646updateSelection8UEBfa8(getValue$foundation_release(), j2, true, false, SelectionAdjustment.Companion.getWord(), false);
            }
        }
    }

    public final boolean isTextChanged$foundation_release() {
        return !Intrinsics.areEqual((Object) this.oldValue.getText(), (Object) getValue$foundation_release().getText());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x007d, code lost:
        r1 = (r9 = r9.getValue()).getCursorRect(r1);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final androidx.compose.ui.geometry.Rect getContentRect() {
        /*
            r11 = this;
            androidx.compose.foundation.text.LegacyTextFieldState r0 = r11.state
            if (r0 == 0) goto L_0x0108
            boolean r1 = r0.isLayoutResultStale()
            if (r1 != 0) goto L_0x000b
            goto L_0x000c
        L_0x000b:
            r0 = 0
        L_0x000c:
            if (r0 == 0) goto L_0x0108
            androidx.compose.ui.text.input.OffsetMapping r1 = r11.offsetMapping
            androidx.compose.ui.text.input.TextFieldValue r2 = r11.getValue$foundation_release()
            long r2 = r2.m6823getSelectiond9O1mEE()
            int r2 = androidx.compose.ui.text.TextRange.m6564getStartimpl(r2)
            int r1 = r1.originalToTransformed(r2)
            androidx.compose.ui.text.input.OffsetMapping r2 = r11.offsetMapping
            androidx.compose.ui.text.input.TextFieldValue r3 = r11.getValue$foundation_release()
            long r3 = r3.m6823getSelectiond9O1mEE()
            int r3 = androidx.compose.ui.text.TextRange.m6559getEndimpl(r3)
            int r2 = r2.originalToTransformed(r3)
            androidx.compose.foundation.text.LegacyTextFieldState r3 = r11.state
            if (r3 == 0) goto L_0x0046
            androidx.compose.ui.layout.LayoutCoordinates r3 = r3.getLayoutCoordinates()
            if (r3 == 0) goto L_0x0046
            r4 = 1
            long r4 = r11.m1651getHandlePositiontuRUvjQ$foundation_release(r4)
            long r3 = r3.m5803localToRootMKHz9U(r4)
            goto L_0x004c
        L_0x0046:
            androidx.compose.ui.geometry.Offset$Companion r3 = androidx.compose.ui.geometry.Offset.Companion
            long r3 = r3.m4003getZeroF1C5BW0()
        L_0x004c:
            androidx.compose.foundation.text.LegacyTextFieldState r5 = r11.state
            if (r5 == 0) goto L_0x0060
            androidx.compose.ui.layout.LayoutCoordinates r5 = r5.getLayoutCoordinates()
            if (r5 == 0) goto L_0x0060
            r6 = 0
            long r6 = r11.m1651getHandlePositiontuRUvjQ$foundation_release(r6)
            long r5 = r5.m5803localToRootMKHz9U(r6)
            goto L_0x0066
        L_0x0060:
            androidx.compose.ui.geometry.Offset$Companion r5 = androidx.compose.ui.geometry.Offset.Companion
            long r5 = r5.m4003getZeroF1C5BW0()
        L_0x0066:
            androidx.compose.foundation.text.LegacyTextFieldState r7 = r11.state
            r8 = 0
            if (r7 == 0) goto L_0x0096
            androidx.compose.ui.layout.LayoutCoordinates r7 = r7.getLayoutCoordinates()
            if (r7 == 0) goto L_0x0096
            androidx.compose.foundation.text.TextLayoutResultProxy r9 = r0.getLayoutResult()
            if (r9 == 0) goto L_0x0088
            androidx.compose.ui.text.TextLayoutResult r9 = r9.getValue()
            if (r9 == 0) goto L_0x0088
            androidx.compose.ui.geometry.Rect r1 = r9.getCursorRect(r1)
            if (r1 == 0) goto L_0x0088
            float r1 = r1.getTop()
            goto L_0x0089
        L_0x0088:
            r1 = r8
        L_0x0089:
            long r9 = androidx.compose.ui.geometry.OffsetKt.Offset(r8, r1)
            long r9 = r7.m5803localToRootMKHz9U(r9)
            float r1 = androidx.compose.ui.geometry.Offset.m3988getYimpl(r9)
            goto L_0x0097
        L_0x0096:
            r1 = r8
        L_0x0097:
            androidx.compose.foundation.text.LegacyTextFieldState r7 = r11.state
            if (r7 == 0) goto L_0x00c5
            androidx.compose.ui.layout.LayoutCoordinates r7 = r7.getLayoutCoordinates()
            if (r7 == 0) goto L_0x00c5
            androidx.compose.foundation.text.TextLayoutResultProxy r9 = r0.getLayoutResult()
            if (r9 == 0) goto L_0x00b8
            androidx.compose.ui.text.TextLayoutResult r9 = r9.getValue()
            if (r9 == 0) goto L_0x00b8
            androidx.compose.ui.geometry.Rect r2 = r9.getCursorRect(r2)
            if (r2 == 0) goto L_0x00b8
            float r2 = r2.getTop()
            goto L_0x00b9
        L_0x00b8:
            r2 = r8
        L_0x00b9:
            long r8 = androidx.compose.ui.geometry.OffsetKt.Offset(r8, r2)
            long r7 = r7.m5803localToRootMKHz9U(r8)
            float r8 = androidx.compose.ui.geometry.Offset.m3988getYimpl(r7)
        L_0x00c5:
            float r2 = androidx.compose.ui.geometry.Offset.m3987getXimpl(r3)
            float r7 = androidx.compose.ui.geometry.Offset.m3987getXimpl(r5)
            float r2 = java.lang.Math.min(r2, r7)
            float r7 = androidx.compose.ui.geometry.Offset.m3987getXimpl(r3)
            float r9 = androidx.compose.ui.geometry.Offset.m3987getXimpl(r5)
            float r7 = java.lang.Math.max(r7, r9)
            float r1 = java.lang.Math.min(r1, r8)
            float r3 = androidx.compose.ui.geometry.Offset.m3988getYimpl(r3)
            float r4 = androidx.compose.ui.geometry.Offset.m3988getYimpl(r5)
            float r3 = java.lang.Math.max(r3, r4)
            r4 = 25
            float r4 = (float) r4
            float r4 = androidx.compose.ui.unit.Dp.m7111constructorimpl(r4)
            androidx.compose.foundation.text.TextDelegate r0 = r0.getTextDelegate()
            androidx.compose.ui.unit.Density r0 = r0.getDensity()
            float r0 = r0.getDensity()
            float r4 = r4 * r0
            float r3 = r3 + r4
            androidx.compose.ui.geometry.Rect r0 = new androidx.compose.ui.geometry.Rect
            r0.<init>(r2, r1, r7, r3)
            return r0
        L_0x0108:
            androidx.compose.ui.geometry.Rect$Companion r0 = androidx.compose.ui.geometry.Rect.Companion
            androidx.compose.ui.geometry.Rect r0 = r0.getZero()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.TextFieldSelectionManager.getContentRect():androidx.compose.ui.geometry.Rect");
    }

    /* access modifiers changed from: private */
    /* renamed from: updateSelection-8UEBfa8  reason: not valid java name */
    public final long m1646updateSelection8UEBfa8(TextFieldValue textFieldValue, long j, boolean z, boolean z2, SelectionAdjustment selectionAdjustment, boolean z3) {
        TextLayoutResultProxy layoutResult;
        int i;
        HapticFeedback hapticFeedback;
        boolean z4 = z3;
        LegacyTextFieldState legacyTextFieldState = this.state;
        if (legacyTextFieldState == null || (layoutResult = legacyTextFieldState.getLayoutResult()) == null) {
            return TextRange.Companion.m6569getZerod9O1mEE();
        }
        long TextRange = TextRangeKt.TextRange(this.offsetMapping.originalToTransformed(TextRange.m6564getStartimpl(textFieldValue.m6823getSelectiond9O1mEE())), this.offsetMapping.originalToTransformed(TextRange.m6559getEndimpl(textFieldValue.m6823getSelectiond9O1mEE())));
        boolean z5 = false;
        int r3 = layoutResult.m1289getOffsetForPosition3MmeM6k(j, false);
        int r5 = (z2 || z) ? r3 : TextRange.m6564getStartimpl(TextRange);
        int r6 = (!z2 || z) ? r3 : TextRange.m6559getEndimpl(TextRange);
        SelectionLayout selectionLayout = this.previousSelectionLayout;
        if (z || selectionLayout == null || (i = this.previousRawDragOffset) == -1) {
            i = -1;
        }
        SelectionLayout r1 = SelectionLayoutKt.m1587getTextFieldSelectionLayoutRcvTLA(layoutResult.getValue(), r5, r6, i, TextRange, z, z2);
        if (!r1.shouldRecomputeSelection(selectionLayout)) {
            return textFieldValue.m6823getSelectiond9O1mEE();
        }
        this.previousSelectionLayout = r1;
        this.previousRawDragOffset = r3;
        Selection adjust = selectionAdjustment.adjust(r1);
        long TextRange2 = TextRangeKt.TextRange(this.offsetMapping.transformedToOriginal(adjust.getStart().getOffset()), this.offsetMapping.transformedToOriginal(adjust.getEnd().getOffset()));
        if (TextRange.m6557equalsimpl0(TextRange2, textFieldValue.m6823getSelectiond9O1mEE())) {
            return textFieldValue.m6823getSelectiond9O1mEE();
        }
        boolean z6 = TextRange.m6563getReversedimpl(TextRange2) != TextRange.m6563getReversedimpl(textFieldValue.m6823getSelectiond9O1mEE()) && TextRange.m6557equalsimpl0(TextRangeKt.TextRange(TextRange.m6559getEndimpl(TextRange2), TextRange.m6564getStartimpl(TextRange2)), textFieldValue.m6823getSelectiond9O1mEE());
        boolean z7 = TextRange.m6558getCollapsedimpl(TextRange2) && TextRange.m6558getCollapsedimpl(textFieldValue.m6823getSelectiond9O1mEE());
        if (z4 && textFieldValue.getText().length() > 0 && !z6 && !z7 && (hapticFeedback = this.hapticFeedBack) != null) {
            hapticFeedback.m5090performHapticFeedbackCdsT49E(HapticFeedbackType.Companion.m5099getTextHandleMove5zf0vsI());
        }
        this.onValueChange.invoke(m1643createTextFieldValueFDrldGo(textFieldValue.getAnnotatedString(), TextRange2));
        if (!z4) {
            updateFloatingToolbar(!TextRange.m6558getCollapsedimpl(TextRange2));
        }
        LegacyTextFieldState legacyTextFieldState2 = this.state;
        if (legacyTextFieldState2 != null) {
            legacyTextFieldState2.setInTouchMode(z4);
        }
        LegacyTextFieldState legacyTextFieldState3 = this.state;
        if (legacyTextFieldState3 != null) {
            legacyTextFieldState3.setShowSelectionHandleStart(!TextRange.m6558getCollapsedimpl(TextRange2) && TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(this, true));
        }
        LegacyTextFieldState legacyTextFieldState4 = this.state;
        if (legacyTextFieldState4 != null) {
            legacyTextFieldState4.setShowSelectionHandleEnd(!TextRange.m6558getCollapsedimpl(TextRange2) && TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(this, false));
        }
        LegacyTextFieldState legacyTextFieldState5 = this.state;
        if (legacyTextFieldState5 == null) {
            return TextRange2;
        }
        if (TextRange.m6558getCollapsedimpl(TextRange2) && TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(this, true)) {
            z5 = true;
        }
        legacyTextFieldState5.setShowCursorHandle(z5);
        return TextRange2;
    }

    /* access modifiers changed from: private */
    public final void setHandleState(HandleState handleState) {
        LegacyTextFieldState legacyTextFieldState = this.state;
        if (legacyTextFieldState != null) {
            if (legacyTextFieldState.getHandleState() == handleState) {
                legacyTextFieldState = null;
            }
            if (legacyTextFieldState != null) {
                legacyTextFieldState.setHandleState(handleState);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: createTextFieldValue-FDrldGo  reason: not valid java name */
    public final TextFieldValue m1643createTextFieldValueFDrldGo(AnnotatedString annotatedString, long j) {
        return new TextFieldValue(annotatedString, j, (TextRange) null, 4, (DefaultConstructorMarker) null);
    }
}
