package androidx.compose.foundation.text.input;

import androidx.compose.foundation.text.input.TextFieldBuffer;
import androidx.compose.foundation.text.input.TextUndoManager;
import androidx.compose.foundation.text.input.internal.ChangeTracker;
import androidx.compose.foundation.text.input.internal.EditingBuffer;
import androidx.compose.foundation.text.input.internal.OffsetMappingCalculator;
import androidx.compose.foundation.text.input.internal.undo.TextFieldEditUndoBehavior;
import androidx.compose.foundation.text.input.internal.undo.TextUndoOperation;
import androidx.compose.foundation.text.input.internal.undo.UndoManager;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001:\u0002]^B\u001b\b\u0016\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u001f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0015\u00106\u001a\u0002072\u0006\u00108\u001a\u00020\u001fH\u0000¢\u0006\u0002\b9J\u0010\u0010:\u001a\u0002072\u0006\u0010;\u001a\u00020<H\u0001J&\u0010=\u001a\u0002072\b\u0010>\u001a\u0004\u0018\u00010?2\b\b\u0002\u0010@\u001a\u00020\u000e2\b\b\u0002\u0010A\u001a\u00020BH\u0002J\"\u0010C\u001a\u0002072\u0017\u0010D\u001a\u0013\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u0002070E¢\u0006\u0002\bFH\bJE\u0010G\u001a\u0002072\b\u0010>\u001a\u0004\u0018\u00010?2\b\b\u0002\u0010@\u001a\u00020\u000e2\b\b\u0002\u0010A\u001a\u00020B2\u0017\u0010D\u001a\u0013\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u0002070E¢\u0006\u0002\bFH\b¢\u0006\u0002\bHJ'\u0010I\u001a\u0002072\u0017\u0010D\u001a\u0013\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u0002070E¢\u0006\u0002\bFH\b¢\u0006\u0002\bJJ\b\u0010K\u001a\u000207H\u0001J(\u0010L\u001a\u0002072\u0006\u0010M\u001a\u00020/2\u0006\u0010N\u001a\u00020/2\u0006\u0010O\u001a\u00020P2\u0006\u0010A\u001a\u00020BH\u0002J\u0015\u0010Q\u001a\u0002072\u0006\u00108\u001a\u00020\u001fH\u0000¢\u0006\u0002\bRJ\b\u0010S\u001a\u00020<H\u0001J2\u0010T\u001a\u0002072\u0006\u0010U\u001a\u00020<2\b\u0010V\u001a\u0004\u0018\u00010\u00052\u0006\u0010W\u001a\u00020\u000e2\u0006\u0010X\u001a\u00020\u000eH\u0001ø\u0001\u0000¢\u0006\u0002\bYJ\b\u0010Z\u001a\u00020\u0003H\u0016J \u0010[\u001a\u0002072\u0006\u0010\\\u001a\u00020/2\u0006\u0010;\u001a\u00020/2\u0006\u0010@\u001a\u00020\u000eH\u0002R\u0019\u0010\n\u001a\u0004\u0018\u00010\u00058Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR+\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000e8B@BX\u0002¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0015\u001a\u00020\u00168\u0000@\u0000X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eX\u0004¢\u0006\u0002\n\u0000R\u0017\u0010 \u001a\u00020\u00058Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u0011\u0010#\u001a\u00020$8F¢\u0006\u0006\u001a\u0004\b%\u0010&R\u0014\u0010'\u001a\u00020\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u001c\u0010*\u001a\u00020+8GX\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b,\u0010\u0018\u001a\u0004\b-\u0010.R+\u00100\u001a\u00020/2\u0006\u0010\r\u001a\u00020/8@@BX\u0002¢\u0006\u0012\n\u0004\b5\u0010\u0014\u001a\u0004\b1\u00102\"\u0004\b3\u00104\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006_"}, d2 = {"Landroidx/compose/foundation/text/input/TextFieldState;", "", "initialText", "", "initialSelection", "Landroidx/compose/ui/text/TextRange;", "(Ljava/lang/String;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "initialTextUndoManager", "Landroidx/compose/foundation/text/input/TextUndoManager;", "(Ljava/lang/String;JLandroidx/compose/foundation/text/input/TextUndoManager;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "composition", "getComposition-MzsxiRA", "()Landroidx/compose/ui/text/TextRange;", "<set-?>", "", "isEditing", "()Z", "setEditing", "(Z)V", "isEditing$delegate", "Landroidx/compose/runtime/MutableState;", "mainBuffer", "Landroidx/compose/foundation/text/input/internal/EditingBuffer;", "getMainBuffer$foundation_release$annotations", "()V", "getMainBuffer$foundation_release", "()Landroidx/compose/foundation/text/input/internal/EditingBuffer;", "setMainBuffer$foundation_release", "(Landroidx/compose/foundation/text/input/internal/EditingBuffer;)V", "notifyImeListeners", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/foundation/text/input/TextFieldState$NotifyImeListener;", "selection", "getSelection-d9O1mEE", "()J", "text", "", "getText", "()Ljava/lang/CharSequence;", "textUndoManager", "getTextUndoManager$foundation_release", "()Landroidx/compose/foundation/text/input/TextUndoManager;", "undoState", "Landroidx/compose/foundation/text/input/UndoState;", "getUndoState$annotations", "getUndoState", "()Landroidx/compose/foundation/text/input/UndoState;", "Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "value", "getValue$foundation_release", "()Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "setValue", "(Landroidx/compose/foundation/text/input/TextFieldCharSequence;)V", "value$delegate", "addNotifyImeListener", "", "notifyImeListener", "addNotifyImeListener$foundation_release", "commitEdit", "newValue", "Landroidx/compose/foundation/text/input/TextFieldBuffer;", "commitEditAsUser", "inputTransformation", "Landroidx/compose/foundation/text/input/InputTransformation;", "restartImeIfContentChanges", "undoBehavior", "Landroidx/compose/foundation/text/input/internal/undo/TextFieldEditUndoBehavior;", "edit", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "editAsUser", "editAsUser$foundation_release", "editWithNoSideEffects", "editWithNoSideEffects$foundation_release", "finishEditing", "recordEditForUndo", "previousValue", "postValue", "changes", "Landroidx/compose/foundation/text/input/TextFieldBuffer$ChangeList;", "removeNotifyImeListener", "removeNotifyImeListener$foundation_release", "startEdit", "syncMainBufferToTemporaryBuffer", "textFieldBuffer", "newComposition", "textChanged", "selectionChanged", "syncMainBufferToTemporaryBuffer-TS3Rm5k$foundation_release", "toString", "updateValueAndNotifyListeners", "oldValue", "NotifyImeListener", "Saver", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldState.kt */
public final class TextFieldState {
    public static final int $stable = 0;
    private final MutableState isEditing$delegate;
    private EditingBuffer mainBuffer;
    private final MutableVector<NotifyImeListener> notifyImeListeners;
    private final TextUndoManager textUndoManager;
    private final UndoState undoState;
    private final MutableState value$delegate;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bà\u0001\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH&ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\tÀ\u0006\u0001"}, d2 = {"Landroidx/compose/foundation/text/input/TextFieldState$NotifyImeListener;", "", "onChange", "", "oldValue", "Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "newValue", "restartImeIfContentChanges", "", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: TextFieldState.kt */
    public interface NotifyImeListener {
        void onChange(TextFieldCharSequence textFieldCharSequence, TextFieldCharSequence textFieldCharSequence2, boolean z);
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: TextFieldState.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        static {
            /*
                androidx.compose.foundation.text.input.internal.undo.TextFieldEditUndoBehavior[] r0 = androidx.compose.foundation.text.input.internal.undo.TextFieldEditUndoBehavior.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                androidx.compose.foundation.text.input.internal.undo.TextFieldEditUndoBehavior r1 = androidx.compose.foundation.text.input.internal.undo.TextFieldEditUndoBehavior.ClearHistory     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                androidx.compose.foundation.text.input.internal.undo.TextFieldEditUndoBehavior r1 = androidx.compose.foundation.text.input.internal.undo.TextFieldEditUndoBehavior.MergeIfPossible     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                androidx.compose.foundation.text.input.internal.undo.TextFieldEditUndoBehavior r1 = androidx.compose.foundation.text.input.internal.undo.TextFieldEditUndoBehavior.NeverMerge     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.input.TextFieldState.WhenMappings.<clinit>():void");
        }
    }

    public /* synthetic */ TextFieldState(String str, long j, TextUndoManager textUndoManager2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j, textUndoManager2);
    }

    public /* synthetic */ TextFieldState(String str, long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j);
    }

    public static /* synthetic */ void getMainBuffer$foundation_release$annotations() {
    }

    public static /* synthetic */ void getUndoState$annotations() {
    }

    private TextFieldState(String str, long j, TextUndoManager textUndoManager2) {
        this.textUndoManager = textUndoManager2;
        this.mainBuffer = new EditingBuffer(str, TextRangeKt.m6570coerceIn8ffj60Q(j, 0, str.length()), (DefaultConstructorMarker) null);
        this.isEditing$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.value$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new TextFieldCharSequence(str, j, (TextRange) null, (Pair) null, 12, (DefaultConstructorMarker) null), (SnapshotMutationPolicy) null, 2, (Object) null);
        this.undoState = new UndoState(this);
        this.notifyImeListeners = new MutableVector<>(new NotifyImeListener[16], 0);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ TextFieldState(java.lang.String r1, long r2, int r4, kotlin.jvm.internal.DefaultConstructorMarker r5) {
        /*
            r0 = this;
            r5 = r4 & 1
            if (r5 == 0) goto L_0x0006
            java.lang.String r1 = ""
        L_0x0006:
            r4 = r4 & 2
            if (r4 == 0) goto L_0x0012
            int r2 = r1.length()
            long r2 = androidx.compose.ui.text.TextRangeKt.TextRange(r2)
        L_0x0012:
            r4 = 0
            r0.<init>((java.lang.String) r1, (long) r2, (kotlin.jvm.internal.DefaultConstructorMarker) r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.input.TextFieldState.<init>(java.lang.String, long, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    private TextFieldState(String str, long j) {
        this(str, j, new TextUndoManager((TextUndoOperation) null, (UndoManager) null, 3, (DefaultConstructorMarker) null), (DefaultConstructorMarker) null);
    }

    public final TextUndoManager getTextUndoManager$foundation_release() {
        return this.textUndoManager;
    }

    public final EditingBuffer getMainBuffer$foundation_release() {
        return this.mainBuffer;
    }

    public final void setMainBuffer$foundation_release(EditingBuffer editingBuffer) {
        this.mainBuffer = editingBuffer;
    }

    private final boolean isEditing() {
        return ((Boolean) this.isEditing$delegate.getValue()).booleanValue();
    }

    private final void setEditing(boolean z) {
        this.isEditing$delegate.setValue(Boolean.valueOf(z));
    }

    private final void setValue(TextFieldCharSequence textFieldCharSequence) {
        this.value$delegate.setValue(textFieldCharSequence);
    }

    public final TextFieldCharSequence getValue$foundation_release() {
        return (TextFieldCharSequence) this.value$delegate.getValue();
    }

    public final CharSequence getText() {
        return getValue$foundation_release().getText();
    }

    /* renamed from: getSelection-d9O1mEE  reason: not valid java name */
    public final long m1314getSelectiond9O1mEE() {
        return getValue$foundation_release().m1312getSelectiond9O1mEE();
    }

    /* renamed from: getComposition-MzsxiRA  reason: not valid java name */
    public final TextRange m1313getCompositionMzsxiRA() {
        return getValue$foundation_release().m1311getCompositionMzsxiRA();
    }

    public final void edit(Function1<? super TextFieldBuffer, Unit> function1) {
        TextFieldBuffer startEdit = startEdit();
        try {
            function1.invoke(startEdit);
            commitEdit(startEdit);
        } finally {
            finishEditing();
        }
    }

    public String toString() {
        Snapshot.Companion companion = Snapshot.Companion;
        Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
        Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
        Snapshot makeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
        try {
            return "TextFieldState(selection=" + TextRange.m6567toStringimpl(m1314getSelectiond9O1mEE()) + ", text=\"" + getText() + "\")";
        } finally {
            companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
        }
    }

    public final UndoState getUndoState() {
        return this.undoState;
    }

    public final TextFieldBuffer startEdit() {
        Snapshot.Companion companion = Snapshot.Companion;
        Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
        Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
        Snapshot makeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
        try {
            if (!isEditing()) {
                setEditing(true);
                return new TextFieldBuffer(getValue$foundation_release(), (ChangeTracker) null, (TextFieldCharSequence) null, (OffsetMappingCalculator) null, 14, (DefaultConstructorMarker) null);
            }
            throw new IllegalStateException("TextFieldState does not support concurrent or nested editing.".toString());
        } finally {
            companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
        }
    }

    public final void commitEdit(TextFieldBuffer textFieldBuffer) {
        boolean z = textFieldBuffer.getChanges().getChangeCount() > 0;
        boolean r1 = true ^ TextRange.m6557equalsimpl0(textFieldBuffer.m1306getSelectiond9O1mEE(), this.mainBuffer.m1348getSelectiond9O1mEE());
        if (z) {
            this.textUndoManager.clearHistory();
        }
        m1315syncMainBufferToTemporaryBufferTS3Rm5k$foundation_release(textFieldBuffer, (TextRange) null, z, r1);
    }

    public final void finishEditing() {
        setEditing(false);
    }

    public static /* synthetic */ void editAsUser$foundation_release$default(TextFieldState textFieldState, InputTransformation inputTransformation, boolean z, TextFieldEditUndoBehavior textFieldEditUndoBehavior, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        if ((i & 4) != 0) {
            textFieldEditUndoBehavior = TextFieldEditUndoBehavior.MergeIfPossible;
        }
        textFieldState.getMainBuffer$foundation_release().getChangeTracker().clearChanges();
        function1.invoke(textFieldState.getMainBuffer$foundation_release());
        textFieldState.commitEditAsUser(inputTransformation, z, textFieldEditUndoBehavior);
    }

    public final void editAsUser$foundation_release(InputTransformation inputTransformation, boolean z, TextFieldEditUndoBehavior textFieldEditUndoBehavior, Function1<? super EditingBuffer, Unit> function1) {
        getMainBuffer$foundation_release().getChangeTracker().clearChanges();
        function1.invoke(getMainBuffer$foundation_release());
        commitEditAsUser(inputTransformation, z, textFieldEditUndoBehavior);
    }

    public final void editWithNoSideEffects$foundation_release(Function1<? super EditingBuffer, Unit> function1) {
        getMainBuffer$foundation_release().getChangeTracker().clearChanges();
        function1.invoke(getMainBuffer$foundation_release());
        updateValueAndNotifyListeners(getValue$foundation_release(), new TextFieldCharSequence(getMainBuffer$foundation_release().toString(), getMainBuffer$foundation_release().m1348getSelectiond9O1mEE(), getMainBuffer$foundation_release().m1347getCompositionMzsxiRA(), (Pair) null, 8, (DefaultConstructorMarker) null), true);
    }

    static /* synthetic */ void commitEditAsUser$default(TextFieldState textFieldState, InputTransformation inputTransformation, boolean z, TextFieldEditUndoBehavior textFieldEditUndoBehavior, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        if ((i & 4) != 0) {
            textFieldEditUndoBehavior = TextFieldEditUndoBehavior.MergeIfPossible;
        }
        textFieldState.commitEditAsUser(inputTransformation, z, textFieldEditUndoBehavior);
    }

    /* access modifiers changed from: private */
    public final void commitEditAsUser(InputTransformation inputTransformation, boolean z, TextFieldEditUndoBehavior textFieldEditUndoBehavior) {
        TextFieldCharSequence value$foundation_release = getValue$foundation_release();
        if (this.mainBuffer.getChangeTracker().getChangeCount() != 0 || !TextRange.m6557equalsimpl0(value$foundation_release.m1312getSelectiond9O1mEE(), this.mainBuffer.m1348getSelectiond9O1mEE())) {
            TextFieldCharSequence textFieldCharSequence = new TextFieldCharSequence(this.mainBuffer.toString(), this.mainBuffer.m1348getSelectiond9O1mEE(), this.mainBuffer.m1347getCompositionMzsxiRA(), this.mainBuffer.getHighlight(), (DefaultConstructorMarker) null);
            if (inputTransformation == null) {
                updateValueAndNotifyListeners(value$foundation_release, textFieldCharSequence, z);
                recordEditForUndo(value$foundation_release, textFieldCharSequence, this.mainBuffer.getChangeTracker(), textFieldEditUndoBehavior);
                return;
            }
            TextFieldBuffer textFieldBuffer = new TextFieldBuffer(textFieldCharSequence, this.mainBuffer.getChangeTracker(), value$foundation_release, (OffsetMappingCalculator) null, 8, (DefaultConstructorMarker) null);
            inputTransformation.transformInput(textFieldBuffer);
            boolean contentEquals = StringsKt.contentEquals(textFieldBuffer.asCharSequence(), (CharSequence) textFieldCharSequence);
            boolean z2 = !contentEquals;
            boolean r4 = TextRange.m6557equalsimpl0(textFieldBuffer.m1306getSelectiond9O1mEE(), textFieldCharSequence.m1312getSelectiond9O1mEE());
            boolean z3 = !r4;
            if (!contentEquals || !r4) {
                m1315syncMainBufferToTemporaryBufferTS3Rm5k$foundation_release(textFieldBuffer, (TextRange) null, z2, z3);
            } else {
                updateValueAndNotifyListeners(value$foundation_release, TextFieldBuffer.m1304toTextFieldCharSequenceudt6zUU$foundation_release$default(textFieldBuffer, 0, textFieldCharSequence.m1311getCompositionMzsxiRA(), 1, (Object) null), z);
            }
            recordEditForUndo(value$foundation_release, getValue$foundation_release(), textFieldBuffer.getChanges(), textFieldEditUndoBehavior);
        } else if (!Intrinsics.areEqual((Object) value$foundation_release.m1311getCompositionMzsxiRA(), (Object) this.mainBuffer.m1347getCompositionMzsxiRA()) || !Intrinsics.areEqual((Object) value$foundation_release.getHighlight(), (Object) this.mainBuffer.getHighlight())) {
            updateValueAndNotifyListeners(getValue$foundation_release(), new TextFieldCharSequence(this.mainBuffer.toString(), this.mainBuffer.m1348getSelectiond9O1mEE(), this.mainBuffer.m1347getCompositionMzsxiRA(), this.mainBuffer.getHighlight(), (DefaultConstructorMarker) null), z);
        }
    }

    /* access modifiers changed from: private */
    public final void updateValueAndNotifyListeners(TextFieldCharSequence textFieldCharSequence, TextFieldCharSequence textFieldCharSequence2, boolean z) {
        setValue(textFieldCharSequence2);
        finishEditing();
        MutableVector<NotifyImeListener> mutableVector = this.notifyImeListeners;
        int size = mutableVector.getSize();
        if (size > 0) {
            Object[] content = mutableVector.getContent();
            int i = 0;
            do {
                ((NotifyImeListener) content[i]).onChange(textFieldCharSequence, textFieldCharSequence2, z);
                i++;
            } while (i < size);
        }
    }

    private final void recordEditForUndo(TextFieldCharSequence textFieldCharSequence, TextFieldCharSequence textFieldCharSequence2, TextFieldBuffer.ChangeList changeList, TextFieldEditUndoBehavior textFieldEditUndoBehavior) {
        int i = WhenMappings.$EnumSwitchMapping$0[textFieldEditUndoBehavior.ordinal()];
        if (i == 1) {
            this.textUndoManager.clearHistory();
        } else if (i == 2) {
            TextUndoManagerKt.recordChanges(this.textUndoManager, textFieldCharSequence, textFieldCharSequence2, changeList, true);
        } else if (i == 3) {
            TextUndoManagerKt.recordChanges(this.textUndoManager, textFieldCharSequence, textFieldCharSequence2, changeList, false);
        }
    }

    public final void addNotifyImeListener$foundation_release(NotifyImeListener notifyImeListener) {
        this.notifyImeListeners.add(notifyImeListener);
    }

    public final void removeNotifyImeListener$foundation_release(NotifyImeListener notifyImeListener) {
        this.notifyImeListeners.remove(notifyImeListener);
    }

    /* renamed from: syncMainBufferToTemporaryBuffer-TS3Rm5k$foundation_release  reason: not valid java name */
    public final void m1315syncMainBufferToTemporaryBufferTS3Rm5k$foundation_release(TextFieldBuffer textFieldBuffer, TextRange textRange, boolean z, boolean z2) {
        String editingBuffer = this.mainBuffer.toString();
        TextFieldCharSequence textFieldCharSequence = new TextFieldCharSequence(editingBuffer, this.mainBuffer.m1348getSelectiond9O1mEE(), this.mainBuffer.m1347getCompositionMzsxiRA(), (Pair) null, 8, (DefaultConstructorMarker) null);
        boolean areEqual = Intrinsics.areEqual((Object) textRange, (Object) this.mainBuffer.m1347getCompositionMzsxiRA());
        if (z) {
            this.mainBuffer = new EditingBuffer(textFieldBuffer.toString(), textFieldBuffer.m1306getSelectiond9O1mEE(), (DefaultConstructorMarker) null);
        } else if (z2) {
            this.mainBuffer.setSelection(TextRange.m6564getStartimpl(textFieldBuffer.m1306getSelectiond9O1mEE()), TextRange.m6559getEndimpl(textFieldBuffer.m1306getSelectiond9O1mEE()));
        }
        if (textRange == null || TextRange.m6558getCollapsedimpl(textRange.m6568unboximpl())) {
            this.mainBuffer.commitComposition();
        } else {
            this.mainBuffer.setComposition(TextRange.m6562getMinimpl(textRange.m6568unboximpl()), TextRange.m6561getMaximpl(textRange.m6568unboximpl()));
        }
        if (z || (!z2 && !areEqual)) {
            this.mainBuffer.commitComposition();
        }
        if (z) {
            editingBuffer = textFieldBuffer.toString();
        }
        updateValueAndNotifyListeners(textFieldCharSequence, new TextFieldCharSequence(editingBuffer, this.mainBuffer.m1348getSelectiond9O1mEE(), this.mainBuffer.m1347getCompositionMzsxiRA(), (Pair) null, 8, (DefaultConstructorMarker) null), true);
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0003H\u0016J\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u0003*\u00020\b2\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¨\u0006\t"}, d2 = {"Landroidx/compose/foundation/text/input/TextFieldState$Saver;", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/foundation/text/input/TextFieldState;", "", "()V", "restore", "value", "save", "Landroidx/compose/runtime/saveable/SaverScope;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: TextFieldState.kt */
    public static final class Saver implements androidx.compose.runtime.saveable.Saver<TextFieldState, Object> {
        public static final int $stable = 0;
        public static final Saver INSTANCE = new Saver();

        private Saver() {
        }

        public Object save(SaverScope saverScope, TextFieldState textFieldState) {
            return CollectionsKt.listOf(textFieldState.getText().toString(), Integer.valueOf(TextRange.m6564getStartimpl(textFieldState.m1314getSelectiond9O1mEE())), Integer.valueOf(TextRange.m6559getEndimpl(textFieldState.m1314getSelectiond9O1mEE())), TextUndoManager.Companion.Saver.INSTANCE.save(saverScope, textFieldState.getTextUndoManager$foundation_release()));
        }

        public TextFieldState restore(Object obj) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<*>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            Object obj3 = list.get(1);
            Object obj4 = list.get(2);
            Object obj5 = list.get(3);
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.String");
            Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.Int");
            int intValue = ((Integer) obj3).intValue();
            Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type kotlin.Int");
            long TextRange = TextRangeKt.TextRange(intValue, ((Integer) obj4).intValue());
            TextUndoManager.Companion.Saver saver = TextUndoManager.Companion.Saver.INSTANCE;
            Intrinsics.checkNotNull(obj5);
            TextUndoManager restore = saver.restore(obj5);
            Intrinsics.checkNotNull(restore);
            return new TextFieldState((String) obj2, TextRange, restore, (DefaultConstructorMarker) null);
        }
    }
}
