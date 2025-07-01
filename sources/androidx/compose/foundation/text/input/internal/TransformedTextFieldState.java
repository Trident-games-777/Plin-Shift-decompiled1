package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.text.input.InputTransformation;
import androidx.compose.foundation.text.input.OutputTransformation;
import androidx.compose.foundation.text.input.TextFieldBuffer;
import androidx.compose.foundation.text.input.TextFieldCharSequence;
import androidx.compose.foundation.text.input.TextFieldState;
import androidx.compose.foundation.text.input.internal.undo.TextFieldEditUndoBehavior;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0001\u0018\u0000 ]2\u00020\u0001:\u0002]^B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u0006\u0010 \u001a\u00020!J\u0006\u0010\"\u001a\u00020!J\u0016\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H@¢\u0006\u0002\u0010'J\u0006\u0010(\u001a\u00020!J,\u0010)\u001a\u00020!2\b\b\u0002\u0010*\u001a\u00020+2\u0017\u0010,\u001a\u0013\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020!0-¢\u0006\u0002\b/H\bJ\u0013\u00100\u001a\u00020+2\b\u00101\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u00102\u001a\u000203H\u0016J \u00104\u001a\u00020!2\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u000208ø\u0001\u0000¢\u0006\u0004\b9\u0010:J\u0018\u0010;\u001a\u0002082\u0006\u0010<\u001a\u000208ø\u0001\u0000¢\u0006\u0004\b=\u0010>J\u001b\u0010;\u001a\u0002082\u0006\u0010?\u001a\u000203ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b@\u0010AJ\u0018\u0010B\u001a\u0002082\u0006\u0010<\u001a\u000208ø\u0001\u0000¢\u0006\u0004\bC\u0010>J\u001b\u0010B\u001a\u0002082\u0006\u0010?\u001a\u000203ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bD\u0010AJ\u000e\u0010E\u001a\u00020!2\u0006\u0010F\u001a\u000203J\u0006\u0010G\u001a\u00020!J\u000e\u0010H\u001a\u00020!2\u0006\u0010I\u001a\u00020JJ\"\u0010K\u001a\u00020!2\u0006\u0010I\u001a\u00020J2\b\b\u0002\u0010L\u001a\u00020+2\b\b\u0002\u0010M\u001a\u00020NJ4\u0010O\u001a\u00020!2\u0006\u0010I\u001a\u00020J2\u0006\u0010<\u001a\u0002082\b\b\u0002\u0010M\u001a\u00020N2\b\b\u0002\u0010*\u001a\u00020+ø\u0001\u0000¢\u0006\u0004\bP\u0010QJ\u0006\u0010R\u001a\u00020!J\u0018\u0010S\u001a\u00020!2\u0006\u00107\u001a\u000208ø\u0001\u0000¢\u0006\u0004\bT\u0010UJ\u0018\u0010V\u001a\u00020!2\u0006\u0010W\u001a\u000208ø\u0001\u0000¢\u0006\u0004\bX\u0010UJ\b\u0010Y\u001a\u00020ZH\u0016J\u0006\u0010[\u001a\u00020!J\u0010\u0010\\\u001a\u00020!2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\fX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u000e\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0012\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\fX\u0004¢\u0006\u0002\n\u0000R+\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u00148F@FX\u0002¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u001c\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0011R\u0011\u0010\u001e\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0011\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006_"}, d2 = {"Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "", "textFieldState", "Landroidx/compose/foundation/text/input/TextFieldState;", "inputTransformation", "Landroidx/compose/foundation/text/input/InputTransformation;", "codepointTransformation", "Landroidx/compose/foundation/text/input/internal/CodepointTransformation;", "outputTransformation", "Landroidx/compose/foundation/text/input/OutputTransformation;", "(Landroidx/compose/foundation/text/input/TextFieldState;Landroidx/compose/foundation/text/input/InputTransformation;Landroidx/compose/foundation/text/input/internal/CodepointTransformation;Landroidx/compose/foundation/text/input/OutputTransformation;)V", "codepointTransformedText", "Landroidx/compose/runtime/State;", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState$TransformedText;", "outputText", "Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "getOutputText", "()Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "outputTransformedText", "<set-?>", "Landroidx/compose/foundation/text/input/internal/SelectionWedgeAffinity;", "selectionWedgeAffinity", "getSelectionWedgeAffinity", "()Landroidx/compose/foundation/text/input/internal/SelectionWedgeAffinity;", "setSelectionWedgeAffinity", "(Landroidx/compose/foundation/text/input/internal/SelectionWedgeAffinity;)V", "selectionWedgeAffinity$delegate", "Landroidx/compose/runtime/MutableState;", "untransformedText", "getUntransformedText", "visualText", "getVisualText", "collapseSelectionToEnd", "", "collapseSelectionToMax", "collectImeNotifications", "", "notifyImeListener", "Landroidx/compose/foundation/text/input/TextFieldState$NotifyImeListener;", "(Landroidx/compose/foundation/text/input/TextFieldState$NotifyImeListener;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteSelectedText", "editUntransformedTextAsUser", "restartImeIfContentChanges", "", "block", "Lkotlin/Function1;", "Landroidx/compose/foundation/text/input/internal/EditingBuffer;", "Lkotlin/ExtensionFunctionType;", "equals", "other", "hashCode", "", "highlightCharsIn", "type", "Landroidx/compose/foundation/text/input/TextHighlightType;", "transformedRange", "Landroidx/compose/ui/text/TextRange;", "highlightCharsIn-7RAjNK8", "(IJ)V", "mapFromTransformed", "range", "mapFromTransformed-GEjPoXI", "(J)J", "offset", "mapFromTransformed--jx7JFs", "(I)J", "mapToTransformed", "mapToTransformed-GEjPoXI", "mapToTransformed--jx7JFs", "placeCursorBeforeCharAt", "transformedOffset", "redo", "replaceAll", "newText", "", "replaceSelectedText", "clearComposition", "undoBehavior", "Landroidx/compose/foundation/text/input/internal/undo/TextFieldEditUndoBehavior;", "replaceText", "replaceText-M8tDOmk", "(Ljava/lang/CharSequence;JLandroidx/compose/foundation/text/input/internal/undo/TextFieldEditUndoBehavior;Z)V", "selectAll", "selectCharsIn", "selectCharsIn-5zc-tL8", "(J)V", "selectUntransformedCharsIn", "untransformedRange", "selectUntransformedCharsIn-5zc-tL8", "toString", "", "undo", "update", "Companion", "TransformedText", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: TransformedTextFieldState.kt */
public final class TransformedTextFieldState {
    public static final int $stable = 0;
    /* access modifiers changed from: private */
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final CodepointTransformation codepointTransformation;
    private final State<TransformedText> codepointTransformedText;
    /* access modifiers changed from: private */
    public InputTransformation inputTransformation;
    private final OutputTransformation outputTransformation;
    /* access modifiers changed from: private */
    public final State<TransformedText> outputTransformedText;
    private final MutableState selectionWedgeAffinity$delegate;
    /* access modifiers changed from: private */
    public final TextFieldState textFieldState;

    @JvmStatic
    private static final TransformedText calculateTransformedText(TextFieldCharSequence textFieldCharSequence, OutputTransformation outputTransformation2, SelectionWedgeAffinity selectionWedgeAffinity) {
        return Companion.calculateTransformedText(textFieldCharSequence, outputTransformation2, selectionWedgeAffinity);
    }

    @JvmStatic
    private static final TransformedText calculateTransformedText(TextFieldCharSequence textFieldCharSequence, CodepointTransformation codepointTransformation2, SelectionWedgeAffinity selectionWedgeAffinity) {
        return Companion.calculateTransformedText(textFieldCharSequence, codepointTransformation2, selectionWedgeAffinity);
    }

    @JvmStatic
    /* renamed from: mapFromTransformed-xdX6-G0  reason: not valid java name */
    private static final long m1440mapFromTransformedxdX6G0(long j, OffsetMappingCalculator offsetMappingCalculator) {
        return Companion.m1453mapFromTransformedxdX6G0(j, offsetMappingCalculator);
    }

    @JvmStatic
    /* renamed from: mapToTransformed-XGyztTk  reason: not valid java name */
    private static final long m1441mapToTransformedXGyztTk(long j, OffsetMappingCalculator offsetMappingCalculator, SelectionWedgeAffinity selectionWedgeAffinity) {
        return Companion.m1454mapToTransformedXGyztTk(j, offsetMappingCalculator, selectionWedgeAffinity);
    }

    public TransformedTextFieldState(TextFieldState textFieldState2, InputTransformation inputTransformation2, CodepointTransformation codepointTransformation2, OutputTransformation outputTransformation2) {
        this.textFieldState = textFieldState2;
        this.inputTransformation = inputTransformation2;
        this.codepointTransformation = codepointTransformation2;
        this.outputTransformation = outputTransformation2;
        this.outputTransformedText = outputTransformation2 != null ? SnapshotStateKt.derivedStateOf(new TransformedTextFieldState$outputTransformedText$1$1(this, outputTransformation2)) : null;
        this.codepointTransformedText = codepointTransformation2 != null ? SnapshotStateKt.derivedStateOf(new TransformedTextFieldState$codepointTransformedText$1$1(this, codepointTransformation2)) : null;
        this.selectionWedgeAffinity$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new SelectionWedgeAffinity(WedgeAffinity.Start), (SnapshotMutationPolicy) null, 2, (Object) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TransformedTextFieldState(TextFieldState textFieldState2, InputTransformation inputTransformation2, CodepointTransformation codepointTransformation2, OutputTransformation outputTransformation2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(textFieldState2, (i & 2) != 0 ? null : inputTransformation2, (i & 4) != 0 ? null : codepointTransformation2, (i & 8) != 0 ? null : outputTransformation2);
    }

    public final TextFieldCharSequence getUntransformedText() {
        return this.textFieldState.getValue$foundation_release();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000c, code lost:
        r0 = (r0 = r0.getValue()).getText();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.compose.foundation.text.input.TextFieldCharSequence getOutputText() {
        /*
            r1 = this;
            androidx.compose.runtime.State<androidx.compose.foundation.text.input.internal.TransformedTextFieldState$TransformedText> r0 = r1.outputTransformedText
            if (r0 == 0) goto L_0x0014
            java.lang.Object r0 = r0.getValue()
            androidx.compose.foundation.text.input.internal.TransformedTextFieldState$TransformedText r0 = (androidx.compose.foundation.text.input.internal.TransformedTextFieldState.TransformedText) r0
            if (r0 == 0) goto L_0x0014
            androidx.compose.foundation.text.input.TextFieldCharSequence r0 = r0.getText()
            if (r0 != 0) goto L_0x0013
            goto L_0x0014
        L_0x0013:
            return r0
        L_0x0014:
            androidx.compose.foundation.text.input.TextFieldCharSequence r0 = r1.getUntransformedText()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.input.internal.TransformedTextFieldState.getOutputText():androidx.compose.foundation.text.input.TextFieldCharSequence");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000c, code lost:
        r0 = (r0 = r0.getValue()).getText();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.compose.foundation.text.input.TextFieldCharSequence getVisualText() {
        /*
            r1 = this;
            androidx.compose.runtime.State<androidx.compose.foundation.text.input.internal.TransformedTextFieldState$TransformedText> r0 = r1.codepointTransformedText
            if (r0 == 0) goto L_0x0014
            java.lang.Object r0 = r0.getValue()
            androidx.compose.foundation.text.input.internal.TransformedTextFieldState$TransformedText r0 = (androidx.compose.foundation.text.input.internal.TransformedTextFieldState.TransformedText) r0
            if (r0 == 0) goto L_0x0014
            androidx.compose.foundation.text.input.TextFieldCharSequence r0 = r0.getText()
            if (r0 != 0) goto L_0x0013
            goto L_0x0014
        L_0x0013:
            return r0
        L_0x0014:
            androidx.compose.foundation.text.input.TextFieldCharSequence r0 = r1.getOutputText()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.input.internal.TransformedTextFieldState.getVisualText():androidx.compose.foundation.text.input.TextFieldCharSequence");
    }

    public final SelectionWedgeAffinity getSelectionWedgeAffinity() {
        return (SelectionWedgeAffinity) this.selectionWedgeAffinity$delegate.getValue();
    }

    public final void setSelectionWedgeAffinity(SelectionWedgeAffinity selectionWedgeAffinity) {
        this.selectionWedgeAffinity$delegate.setValue(selectionWedgeAffinity);
    }

    public final void update(InputTransformation inputTransformation2) {
        this.inputTransformation = inputTransformation2;
    }

    public final void placeCursorBeforeCharAt(int i) {
        m1449selectCharsIn5zctL8(TextRangeKt.TextRange(i));
    }

    /* renamed from: selectCharsIn-5zc-tL8  reason: not valid java name */
    public final void m1449selectCharsIn5zctL8(long j) {
        m1450selectUntransformedCharsIn5zctL8(m1445mapFromTransformedGEjPoXI(j));
    }

    /* renamed from: selectUntransformedCharsIn-5zc-tL8  reason: not valid java name */
    public final void m1450selectUntransformedCharsIn5zctL8(long j) {
        TextFieldState textFieldState2 = this.textFieldState;
        InputTransformation inputTransformation2 = this.inputTransformation;
        TextFieldEditUndoBehavior textFieldEditUndoBehavior = TextFieldEditUndoBehavior.MergeIfPossible;
        textFieldState2.getMainBuffer$foundation_release().getChangeTracker().clearChanges();
        textFieldState2.getMainBuffer$foundation_release().setSelection(TextRange.m6564getStartimpl(j), TextRange.m6559getEndimpl(j));
        textFieldState2.commitEditAsUser(inputTransformation2, true, textFieldEditUndoBehavior);
    }

    /* renamed from: highlightCharsIn-7RAjNK8  reason: not valid java name */
    public final void m1443highlightCharsIn7RAjNK8(int i, long j) {
        long r7 = m1445mapFromTransformedGEjPoXI(j);
        TextFieldState textFieldState2 = this.textFieldState;
        InputTransformation inputTransformation2 = this.inputTransformation;
        TextFieldEditUndoBehavior textFieldEditUndoBehavior = TextFieldEditUndoBehavior.MergeIfPossible;
        textFieldState2.getMainBuffer$foundation_release().getChangeTracker().clearChanges();
        textFieldState2.getMainBuffer$foundation_release().m1349setHighlightK7f2yys(i, TextRange.m6564getStartimpl(r7), TextRange.m6559getEndimpl(r7));
        textFieldState2.commitEditAsUser(inputTransformation2, true, textFieldEditUndoBehavior);
    }

    public final void replaceAll(CharSequence charSequence) {
        TextFieldState textFieldState2 = this.textFieldState;
        InputTransformation inputTransformation2 = this.inputTransformation;
        TextFieldEditUndoBehavior textFieldEditUndoBehavior = TextFieldEditUndoBehavior.MergeIfPossible;
        textFieldState2.getMainBuffer$foundation_release().getChangeTracker().clearChanges();
        EditingBuffer mainBuffer$foundation_release = textFieldState2.getMainBuffer$foundation_release();
        EditCommandKt.deleteAll(mainBuffer$foundation_release);
        EditCommandKt.commitText(mainBuffer$foundation_release, charSequence.toString(), 1);
        textFieldState2.commitEditAsUser(inputTransformation2, true, textFieldEditUndoBehavior);
    }

    public final void selectAll() {
        TextFieldState textFieldState2 = this.textFieldState;
        InputTransformation inputTransformation2 = this.inputTransformation;
        TextFieldEditUndoBehavior textFieldEditUndoBehavior = TextFieldEditUndoBehavior.MergeIfPossible;
        textFieldState2.getMainBuffer$foundation_release().getChangeTracker().clearChanges();
        EditingBuffer mainBuffer$foundation_release = textFieldState2.getMainBuffer$foundation_release();
        mainBuffer$foundation_release.setSelection(0, mainBuffer$foundation_release.getLength());
        textFieldState2.commitEditAsUser(inputTransformation2, true, textFieldEditUndoBehavior);
    }

    public final void deleteSelectedText() {
        TextFieldState textFieldState2 = this.textFieldState;
        InputTransformation inputTransformation2 = this.inputTransformation;
        TextFieldEditUndoBehavior textFieldEditUndoBehavior = TextFieldEditUndoBehavior.NeverMerge;
        textFieldState2.getMainBuffer$foundation_release().getChangeTracker().clearChanges();
        EditingBuffer mainBuffer$foundation_release = textFieldState2.getMainBuffer$foundation_release();
        mainBuffer$foundation_release.delete(TextRange.m6562getMinimpl(mainBuffer$foundation_release.m1348getSelectiond9O1mEE()), TextRange.m6561getMaximpl(mainBuffer$foundation_release.m1348getSelectiond9O1mEE()));
        mainBuffer$foundation_release.setSelection(TextRange.m6562getMinimpl(mainBuffer$foundation_release.m1348getSelectiond9O1mEE()), TextRange.m6562getMinimpl(mainBuffer$foundation_release.m1348getSelectiond9O1mEE()));
        textFieldState2.commitEditAsUser(inputTransformation2, true, textFieldEditUndoBehavior);
    }

    /* renamed from: replaceText-M8tDOmk$default  reason: not valid java name */
    public static /* synthetic */ void m1442replaceTextM8tDOmk$default(TransformedTextFieldState transformedTextFieldState, CharSequence charSequence, long j, TextFieldEditUndoBehavior textFieldEditUndoBehavior, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            textFieldEditUndoBehavior = TextFieldEditUndoBehavior.MergeIfPossible;
        }
        TextFieldEditUndoBehavior textFieldEditUndoBehavior2 = textFieldEditUndoBehavior;
        if ((i & 8) != 0) {
            z = true;
        }
        transformedTextFieldState.m1448replaceTextM8tDOmk(charSequence, j, textFieldEditUndoBehavior2, z);
    }

    /* renamed from: replaceText-M8tDOmk  reason: not valid java name */
    public final void m1448replaceTextM8tDOmk(CharSequence charSequence, long j, TextFieldEditUndoBehavior textFieldEditUndoBehavior, boolean z) {
        TextFieldState textFieldState2 = this.textFieldState;
        InputTransformation inputTransformation2 = this.inputTransformation;
        textFieldState2.getMainBuffer$foundation_release().getChangeTracker().clearChanges();
        EditingBuffer mainBuffer$foundation_release = textFieldState2.getMainBuffer$foundation_release();
        long r7 = m1445mapFromTransformedGEjPoXI(j);
        mainBuffer$foundation_release.replace(TextRange.m6562getMinimpl(r7), TextRange.m6561getMaximpl(r7), charSequence);
        int r72 = TextRange.m6562getMinimpl(r7) + charSequence.length();
        mainBuffer$foundation_release.setSelection(r72, r72);
        textFieldState2.commitEditAsUser(inputTransformation2, z, textFieldEditUndoBehavior);
    }

    public static /* synthetic */ void replaceSelectedText$default(TransformedTextFieldState transformedTextFieldState, CharSequence charSequence, boolean z, TextFieldEditUndoBehavior textFieldEditUndoBehavior, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            textFieldEditUndoBehavior = TextFieldEditUndoBehavior.MergeIfPossible;
        }
        transformedTextFieldState.replaceSelectedText(charSequence, z, textFieldEditUndoBehavior);
    }

    public final void replaceSelectedText(CharSequence charSequence, boolean z, TextFieldEditUndoBehavior textFieldEditUndoBehavior) {
        TextFieldState textFieldState2 = this.textFieldState;
        InputTransformation inputTransformation2 = this.inputTransformation;
        textFieldState2.getMainBuffer$foundation_release().getChangeTracker().clearChanges();
        EditingBuffer mainBuffer$foundation_release = textFieldState2.getMainBuffer$foundation_release();
        if (z) {
            mainBuffer$foundation_release.commitComposition();
        }
        long r3 = mainBuffer$foundation_release.m1348getSelectiond9O1mEE();
        mainBuffer$foundation_release.replace(TextRange.m6562getMinimpl(r3), TextRange.m6561getMaximpl(r3), charSequence);
        int r8 = TextRange.m6562getMinimpl(r3) + charSequence.length();
        mainBuffer$foundation_release.setSelection(r8, r8);
        textFieldState2.commitEditAsUser(inputTransformation2, true, textFieldEditUndoBehavior);
    }

    public final void collapseSelectionToMax() {
        TextFieldState textFieldState2 = this.textFieldState;
        InputTransformation inputTransformation2 = this.inputTransformation;
        TextFieldEditUndoBehavior textFieldEditUndoBehavior = TextFieldEditUndoBehavior.MergeIfPossible;
        textFieldState2.getMainBuffer$foundation_release().getChangeTracker().clearChanges();
        EditingBuffer mainBuffer$foundation_release = textFieldState2.getMainBuffer$foundation_release();
        mainBuffer$foundation_release.setSelection(TextRange.m6561getMaximpl(mainBuffer$foundation_release.m1348getSelectiond9O1mEE()), TextRange.m6561getMaximpl(mainBuffer$foundation_release.m1348getSelectiond9O1mEE()));
        textFieldState2.commitEditAsUser(inputTransformation2, true, textFieldEditUndoBehavior);
    }

    public final void collapseSelectionToEnd() {
        TextFieldState textFieldState2 = this.textFieldState;
        InputTransformation inputTransformation2 = this.inputTransformation;
        TextFieldEditUndoBehavior textFieldEditUndoBehavior = TextFieldEditUndoBehavior.MergeIfPossible;
        textFieldState2.getMainBuffer$foundation_release().getChangeTracker().clearChanges();
        EditingBuffer mainBuffer$foundation_release = textFieldState2.getMainBuffer$foundation_release();
        mainBuffer$foundation_release.setSelection(TextRange.m6559getEndimpl(mainBuffer$foundation_release.m1348getSelectiond9O1mEE()), TextRange.m6559getEndimpl(mainBuffer$foundation_release.m1348getSelectiond9O1mEE()));
        textFieldState2.commitEditAsUser(inputTransformation2, true, textFieldEditUndoBehavior);
    }

    public final void undo() {
        this.textFieldState.getUndoState().undo();
    }

    public final void redo() {
        this.textFieldState.getUndoState().redo();
    }

    public static /* synthetic */ void editUntransformedTextAsUser$default(TransformedTextFieldState transformedTextFieldState, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        TextFieldState access$getTextFieldState$p = transformedTextFieldState.textFieldState;
        InputTransformation access$getInputTransformation$p = transformedTextFieldState.inputTransformation;
        TextFieldEditUndoBehavior textFieldEditUndoBehavior = TextFieldEditUndoBehavior.MergeIfPossible;
        access$getTextFieldState$p.getMainBuffer$foundation_release().getChangeTracker().clearChanges();
        function1.invoke(access$getTextFieldState$p.getMainBuffer$foundation_release());
        access$getTextFieldState$p.commitEditAsUser(access$getInputTransformation$p, z, textFieldEditUndoBehavior);
    }

    public final void editUntransformedTextAsUser(boolean z, Function1<? super EditingBuffer, Unit> function1) {
        TextFieldState access$getTextFieldState$p = this.textFieldState;
        InputTransformation access$getInputTransformation$p = this.inputTransformation;
        TextFieldEditUndoBehavior textFieldEditUndoBehavior = TextFieldEditUndoBehavior.MergeIfPossible;
        access$getTextFieldState$p.getMainBuffer$foundation_release().getChangeTracker().clearChanges();
        function1.invoke(access$getTextFieldState$p.getMainBuffer$foundation_release());
        access$getTextFieldState$p.commitEditAsUser(access$getInputTransformation$p, z, textFieldEditUndoBehavior);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0005, code lost:
        r0 = r0.getValue();
     */
    /* renamed from: mapToTransformed--jx7JFs  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long m1446mapToTransformedjx7JFs(int r5) {
        /*
            r4 = this;
            androidx.compose.runtime.State<androidx.compose.foundation.text.input.internal.TransformedTextFieldState$TransformedText> r0 = r4.outputTransformedText
            r1 = 0
            if (r0 == 0) goto L_0x0012
            java.lang.Object r0 = r0.getValue()
            androidx.compose.foundation.text.input.internal.TransformedTextFieldState$TransformedText r0 = (androidx.compose.foundation.text.input.internal.TransformedTextFieldState.TransformedText) r0
            if (r0 == 0) goto L_0x0012
            androidx.compose.foundation.text.input.internal.OffsetMappingCalculator r0 = r0.getOffsetMapping()
            goto L_0x0013
        L_0x0012:
            r0 = r1
        L_0x0013:
            androidx.compose.runtime.State<androidx.compose.foundation.text.input.internal.TransformedTextFieldState$TransformedText> r2 = r4.codepointTransformedText
            if (r2 == 0) goto L_0x0023
            java.lang.Object r2 = r2.getValue()
            androidx.compose.foundation.text.input.internal.TransformedTextFieldState$TransformedText r2 = (androidx.compose.foundation.text.input.internal.TransformedTextFieldState.TransformedText) r2
            if (r2 == 0) goto L_0x0023
            androidx.compose.foundation.text.input.internal.OffsetMappingCalculator r1 = r2.getOffsetMapping()
        L_0x0023:
            if (r0 == 0) goto L_0x002a
            long r2 = r0.m1387mapFromSourcejx7JFs(r5)
            goto L_0x002e
        L_0x002a:
            long r2 = androidx.compose.ui.text.TextRangeKt.TextRange(r5)
        L_0x002e:
            if (r1 == 0) goto L_0x003b
            androidx.compose.foundation.text.input.internal.TransformedTextFieldState$Companion r5 = Companion
            androidx.compose.foundation.text.input.internal.SelectionWedgeAffinity r0 = r4.getSelectionWedgeAffinity()
            long r0 = r5.m1454mapToTransformedXGyztTk(r2, r1, r0)
            return r0
        L_0x003b:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.input.internal.TransformedTextFieldState.m1446mapToTransformedjx7JFs(int):long");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0005, code lost:
        r0 = r0.getValue();
     */
    /* renamed from: mapToTransformed-GEjPoXI  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long m1447mapToTransformedGEjPoXI(long r10) {
        /*
            r9 = this;
            androidx.compose.runtime.State<androidx.compose.foundation.text.input.internal.TransformedTextFieldState$TransformedText> r0 = r9.outputTransformedText
            r1 = 0
            if (r0 == 0) goto L_0x0013
            java.lang.Object r0 = r0.getValue()
            androidx.compose.foundation.text.input.internal.TransformedTextFieldState$TransformedText r0 = (androidx.compose.foundation.text.input.internal.TransformedTextFieldState.TransformedText) r0
            if (r0 == 0) goto L_0x0013
            androidx.compose.foundation.text.input.internal.OffsetMappingCalculator r0 = r0.getOffsetMapping()
            r5 = r0
            goto L_0x0014
        L_0x0013:
            r5 = r1
        L_0x0014:
            androidx.compose.runtime.State<androidx.compose.foundation.text.input.internal.TransformedTextFieldState$TransformedText> r0 = r9.codepointTransformedText
            if (r0 == 0) goto L_0x0024
            java.lang.Object r0 = r0.getValue()
            androidx.compose.foundation.text.input.internal.TransformedTextFieldState$TransformedText r0 = (androidx.compose.foundation.text.input.internal.TransformedTextFieldState.TransformedText) r0
            if (r0 == 0) goto L_0x0024
            androidx.compose.foundation.text.input.internal.OffsetMappingCalculator r1 = r0.getOffsetMapping()
        L_0x0024:
            if (r5 == 0) goto L_0x0031
            androidx.compose.foundation.text.input.internal.TransformedTextFieldState$Companion r2 = Companion
            r7 = 4
            r8 = 0
            r6 = 0
            r3 = r10
            long r10 = androidx.compose.foundation.text.input.internal.TransformedTextFieldState.Companion.m1455mapToTransformedXGyztTk$default(r2, r3, r5, r6, r7, r8)
            goto L_0x0032
        L_0x0031:
            r3 = r10
        L_0x0032:
            if (r1 == 0) goto L_0x003e
            androidx.compose.foundation.text.input.internal.TransformedTextFieldState$Companion r0 = Companion
            androidx.compose.foundation.text.input.internal.SelectionWedgeAffinity r2 = r9.getSelectionWedgeAffinity()
            long r10 = r0.m1454mapToTransformedXGyztTk(r10, r1, r2)
        L_0x003e:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.input.internal.TransformedTextFieldState.m1447mapToTransformedGEjPoXI(long):long");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0005, code lost:
        r0 = r0.getValue();
     */
    /* renamed from: mapFromTransformed--jx7JFs  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long m1444mapFromTransformedjx7JFs(int r4) {
        /*
            r3 = this;
            androidx.compose.runtime.State<androidx.compose.foundation.text.input.internal.TransformedTextFieldState$TransformedText> r0 = r3.outputTransformedText
            r1 = 0
            if (r0 == 0) goto L_0x0012
            java.lang.Object r0 = r0.getValue()
            androidx.compose.foundation.text.input.internal.TransformedTextFieldState$TransformedText r0 = (androidx.compose.foundation.text.input.internal.TransformedTextFieldState.TransformedText) r0
            if (r0 == 0) goto L_0x0012
            androidx.compose.foundation.text.input.internal.OffsetMappingCalculator r0 = r0.getOffsetMapping()
            goto L_0x0013
        L_0x0012:
            r0 = r1
        L_0x0013:
            androidx.compose.runtime.State<androidx.compose.foundation.text.input.internal.TransformedTextFieldState$TransformedText> r2 = r3.codepointTransformedText
            if (r2 == 0) goto L_0x0023
            java.lang.Object r2 = r2.getValue()
            androidx.compose.foundation.text.input.internal.TransformedTextFieldState$TransformedText r2 = (androidx.compose.foundation.text.input.internal.TransformedTextFieldState.TransformedText) r2
            if (r2 == 0) goto L_0x0023
            androidx.compose.foundation.text.input.internal.OffsetMappingCalculator r1 = r2.getOffsetMapping()
        L_0x0023:
            if (r1 == 0) goto L_0x002a
            long r1 = r1.m1386mapFromDestjx7JFs(r4)
            goto L_0x002e
        L_0x002a:
            long r1 = androidx.compose.ui.text.TextRangeKt.TextRange(r4)
        L_0x002e:
            if (r0 == 0) goto L_0x0037
            androidx.compose.foundation.text.input.internal.TransformedTextFieldState$Companion r4 = Companion
            long r0 = r4.m1453mapFromTransformedxdX6G0(r1, r0)
            return r0
        L_0x0037:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.input.internal.TransformedTextFieldState.m1444mapFromTransformedjx7JFs(int):long");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0005, code lost:
        r0 = r0.getValue();
     */
    /* renamed from: mapFromTransformed-GEjPoXI  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long m1445mapFromTransformedGEjPoXI(long r4) {
        /*
            r3 = this;
            androidx.compose.runtime.State<androidx.compose.foundation.text.input.internal.TransformedTextFieldState$TransformedText> r0 = r3.outputTransformedText
            r1 = 0
            if (r0 == 0) goto L_0x0012
            java.lang.Object r0 = r0.getValue()
            androidx.compose.foundation.text.input.internal.TransformedTextFieldState$TransformedText r0 = (androidx.compose.foundation.text.input.internal.TransformedTextFieldState.TransformedText) r0
            if (r0 == 0) goto L_0x0012
            androidx.compose.foundation.text.input.internal.OffsetMappingCalculator r0 = r0.getOffsetMapping()
            goto L_0x0013
        L_0x0012:
            r0 = r1
        L_0x0013:
            androidx.compose.runtime.State<androidx.compose.foundation.text.input.internal.TransformedTextFieldState$TransformedText> r2 = r3.codepointTransformedText
            if (r2 == 0) goto L_0x0023
            java.lang.Object r2 = r2.getValue()
            androidx.compose.foundation.text.input.internal.TransformedTextFieldState$TransformedText r2 = (androidx.compose.foundation.text.input.internal.TransformedTextFieldState.TransformedText) r2
            if (r2 == 0) goto L_0x0023
            androidx.compose.foundation.text.input.internal.OffsetMappingCalculator r1 = r2.getOffsetMapping()
        L_0x0023:
            if (r1 == 0) goto L_0x002b
            androidx.compose.foundation.text.input.internal.TransformedTextFieldState$Companion r2 = Companion
            long r4 = r2.m1453mapFromTransformedxdX6G0(r4, r1)
        L_0x002b:
            if (r0 == 0) goto L_0x0033
            androidx.compose.foundation.text.input.internal.TransformedTextFieldState$Companion r1 = Companion
            long r4 = r1.m1453mapFromTransformedxdX6G0(r4, r0)
        L_0x0033:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.input.internal.TransformedTextFieldState.m1445mapFromTransformedGEjPoXI(long):long");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object collectImeNotifications(androidx.compose.foundation.text.input.TextFieldState.NotifyImeListener r5, kotlin.coroutines.Continuation<?> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof androidx.compose.foundation.text.input.internal.TransformedTextFieldState$collectImeNotifications$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            androidx.compose.foundation.text.input.internal.TransformedTextFieldState$collectImeNotifications$1 r0 = (androidx.compose.foundation.text.input.internal.TransformedTextFieldState$collectImeNotifications$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            androidx.compose.foundation.text.input.internal.TransformedTextFieldState$collectImeNotifications$1 r0 = new androidx.compose.foundation.text.input.internal.TransformedTextFieldState$collectImeNotifications$1
            r0.<init>(r4, r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003a
            if (r2 == r3) goto L_0x002e
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x002e:
            java.lang.Object r5 = r0.L$1
            androidx.compose.foundation.text.input.TextFieldState$NotifyImeListener r5 = (androidx.compose.foundation.text.input.TextFieldState.NotifyImeListener) r5
            java.lang.Object r5 = r0.L$0
            androidx.compose.foundation.text.input.internal.TransformedTextFieldState r5 = (androidx.compose.foundation.text.input.internal.TransformedTextFieldState) r5
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0075
        L_0x003a:
            kotlin.ResultKt.throwOnFailure(r6)
            r0.L$0 = r4
            r0.L$1 = r5
            r0.label = r3
            kotlin.coroutines.Continuation r0 = (kotlin.coroutines.Continuation) r0
            kotlinx.coroutines.CancellableContinuationImpl r6 = new kotlinx.coroutines.CancellableContinuationImpl
            kotlin.coroutines.Continuation r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.intercepted(r0)
            r6.<init>(r2, r3)
            r6.initCancellability()
            r2 = r6
            kotlinx.coroutines.CancellableContinuation r2 = (kotlinx.coroutines.CancellableContinuation) r2
            androidx.compose.foundation.text.input.TextFieldState r3 = r4.textFieldState
            r3.addNotifyImeListener$foundation_release(r5)
            androidx.compose.foundation.text.input.internal.TransformedTextFieldState$collectImeNotifications$2$1 r3 = new androidx.compose.foundation.text.input.internal.TransformedTextFieldState$collectImeNotifications$2$1
            r3.<init>(r4, r5)
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            r2.invokeOnCancellation(r3)
            java.lang.Object r5 = r6.getResult()
            java.lang.Object r6 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            if (r5 != r6) goto L_0x0072
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r0)
        L_0x0072:
            if (r5 != r1) goto L_0x0075
            return r1
        L_0x0075:
            kotlin.KotlinNothingValueException r5 = new kotlin.KotlinNothingValueException
            r5.<init>()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.input.internal.TransformedTextFieldState.collectImeNotifications(androidx.compose.foundation.text.input.TextFieldState$NotifyImeListener, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TransformedTextFieldState)) {
            return false;
        }
        TransformedTextFieldState transformedTextFieldState = (TransformedTextFieldState) obj;
        if (Intrinsics.areEqual((Object) this.textFieldState, (Object) transformedTextFieldState.textFieldState) && Intrinsics.areEqual((Object) this.codepointTransformation, (Object) transformedTextFieldState.codepointTransformation)) {
            return Intrinsics.areEqual((Object) this.outputTransformation, (Object) transformedTextFieldState.outputTransformation);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.textFieldState.hashCode() * 31;
        CodepointTransformation codepointTransformation2 = this.codepointTransformation;
        int i = 0;
        int hashCode2 = (hashCode + (codepointTransformation2 != null ? codepointTransformation2.hashCode() : 0)) * 31;
        OutputTransformation outputTransformation2 = this.outputTransformation;
        if (outputTransformation2 != null) {
            i = outputTransformation2.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "TransformedTextFieldState(textFieldState=" + this.textFieldState + ", outputTransformation=" + this.outputTransformation + ", outputTransformedText=" + this.outputTransformedText + ", codepointTransformation=" + this.codepointTransformation + ", codepointTransformedText=" + this.codepointTransformedText + ", outputText=\"" + getOutputText() + "\", visualText=\"" + getVisualText() + "\")";
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState$TransformedText;", "", "text", "Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "offsetMapping", "Landroidx/compose/foundation/text/input/internal/OffsetMappingCalculator;", "(Landroidx/compose/foundation/text/input/TextFieldCharSequence;Landroidx/compose/foundation/text/input/internal/OffsetMappingCalculator;)V", "getOffsetMapping", "()Landroidx/compose/foundation/text/input/internal/OffsetMappingCalculator;", "getText", "()Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: TransformedTextFieldState.kt */
    private static final class TransformedText {
        private final OffsetMappingCalculator offsetMapping;
        private final TextFieldCharSequence text;

        public static /* synthetic */ TransformedText copy$default(TransformedText transformedText, TextFieldCharSequence textFieldCharSequence, OffsetMappingCalculator offsetMappingCalculator, int i, Object obj) {
            if ((i & 1) != 0) {
                textFieldCharSequence = transformedText.text;
            }
            if ((i & 2) != 0) {
                offsetMappingCalculator = transformedText.offsetMapping;
            }
            return transformedText.copy(textFieldCharSequence, offsetMappingCalculator);
        }

        public final TextFieldCharSequence component1() {
            return this.text;
        }

        public final OffsetMappingCalculator component2() {
            return this.offsetMapping;
        }

        public final TransformedText copy(TextFieldCharSequence textFieldCharSequence, OffsetMappingCalculator offsetMappingCalculator) {
            return new TransformedText(textFieldCharSequence, offsetMappingCalculator);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof TransformedText)) {
                return false;
            }
            TransformedText transformedText = (TransformedText) obj;
            return Intrinsics.areEqual((Object) this.text, (Object) transformedText.text) && Intrinsics.areEqual((Object) this.offsetMapping, (Object) transformedText.offsetMapping);
        }

        public int hashCode() {
            return (this.text.hashCode() * 31) + this.offsetMapping.hashCode();
        }

        public String toString() {
            return "TransformedText(text=" + this.text + ", offsetMapping=" + this.offsetMapping + ')';
        }

        public TransformedText(TextFieldCharSequence textFieldCharSequence, OffsetMappingCalculator offsetMappingCalculator) {
            this.text = textFieldCharSequence;
            this.offsetMapping = offsetMappingCalculator;
        }

        public final TextFieldCharSequence getText() {
            return this.text;
        }

        public final OffsetMappingCalculator getOffsetMapping() {
            return this.offsetMapping;
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0003J\"\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\nH\u0003J\"\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0003ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J.\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nH\u0003ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0017"}, d2 = {"Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState$Companion;", "", "()V", "calculateTransformedText", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState$TransformedText;", "untransformedValue", "Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "outputTransformation", "Landroidx/compose/foundation/text/input/OutputTransformation;", "wedgeAffinity", "Landroidx/compose/foundation/text/input/internal/SelectionWedgeAffinity;", "codepointTransformation", "Landroidx/compose/foundation/text/input/internal/CodepointTransformation;", "mapFromTransformed", "Landroidx/compose/ui/text/TextRange;", "range", "mapping", "Landroidx/compose/foundation/text/input/internal/OffsetMappingCalculator;", "mapFromTransformed-xdX6-G0", "(JLandroidx/compose/foundation/text/input/internal/OffsetMappingCalculator;)J", "mapToTransformed", "mapToTransformed-XGyztTk", "(JLandroidx/compose/foundation/text/input/internal/OffsetMappingCalculator;Landroidx/compose/foundation/text/input/internal/SelectionWedgeAffinity;)J", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: TransformedTextFieldState.kt */
    private static final class Companion {

        @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
        /* compiled from: TransformedTextFieldState.kt */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            /* JADX WARNING: Failed to process nested try/catch */
            /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
            static {
                /*
                    androidx.compose.foundation.text.input.internal.WedgeAffinity[] r0 = androidx.compose.foundation.text.input.internal.WedgeAffinity.values()
                    int r0 = r0.length
                    int[] r0 = new int[r0]
                    androidx.compose.foundation.text.input.internal.WedgeAffinity r1 = androidx.compose.foundation.text.input.internal.WedgeAffinity.Start     // Catch:{ NoSuchFieldError -> 0x0010 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                    r2 = 1
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
                L_0x0010:
                    androidx.compose.foundation.text.input.internal.WedgeAffinity r1 = androidx.compose.foundation.text.input.internal.WedgeAffinity.End     // Catch:{ NoSuchFieldError -> 0x0019 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                    r2 = 2
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
                L_0x0019:
                    $EnumSwitchMapping$0 = r0
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.input.internal.TransformedTextFieldState.Companion.WhenMappings.<clinit>():void");
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* access modifiers changed from: private */
        @JvmStatic
        public final TransformedText calculateTransformedText(TextFieldCharSequence textFieldCharSequence, OutputTransformation outputTransformation, SelectionWedgeAffinity selectionWedgeAffinity) {
            OffsetMappingCalculator offsetMappingCalculator = new OffsetMappingCalculator();
            TextFieldCharSequence textFieldCharSequence2 = textFieldCharSequence;
            TextFieldBuffer textFieldBuffer = new TextFieldBuffer(textFieldCharSequence2, (ChangeTracker) null, (TextFieldCharSequence) null, offsetMappingCalculator, 6, (DefaultConstructorMarker) null);
            outputTransformation.transformOutput(textFieldBuffer);
            TextRange textRange = null;
            if (textFieldBuffer.getChanges().getChangeCount() == 0) {
                return null;
            }
            long r2 = m1454mapToTransformedXGyztTk(textFieldCharSequence2.m1312getSelectiond9O1mEE(), offsetMappingCalculator, selectionWedgeAffinity);
            TextRange r8 = textFieldCharSequence2.m1311getCompositionMzsxiRA();
            if (r8 != null) {
                textRange = TextRange.m6552boximpl(TransformedTextFieldState.Companion.m1454mapToTransformedXGyztTk(r8.m6568unboximpl(), offsetMappingCalculator, selectionWedgeAffinity));
            }
            return new TransformedText(textFieldBuffer.m1308toTextFieldCharSequenceudt6zUU$foundation_release(r2, textRange), offsetMappingCalculator);
        }

        /* access modifiers changed from: private */
        @JvmStatic
        public final TransformedText calculateTransformedText(TextFieldCharSequence textFieldCharSequence, CodepointTransformation codepointTransformation, SelectionWedgeAffinity selectionWedgeAffinity) {
            OffsetMappingCalculator offsetMappingCalculator = new OffsetMappingCalculator();
            CharSequence visualText = CodepointTransformationKt.toVisualText(textFieldCharSequence, codepointTransformation, offsetMappingCalculator);
            TextRange textRange = null;
            if (visualText == textFieldCharSequence) {
                return null;
            }
            long r3 = m1454mapToTransformedXGyztTk(textFieldCharSequence.m1312getSelectiond9O1mEE(), offsetMappingCalculator, selectionWedgeAffinity);
            TextRange r10 = textFieldCharSequence.m1311getCompositionMzsxiRA();
            if (r10 != null) {
                textRange = TextRange.m6552boximpl(TransformedTextFieldState.Companion.m1454mapToTransformedXGyztTk(r10.m6568unboximpl(), offsetMappingCalculator, selectionWedgeAffinity));
            }
            return new TransformedText(new TextFieldCharSequence(visualText, r3, textRange, (Pair) null, 8, (DefaultConstructorMarker) null), offsetMappingCalculator);
        }

        /* renamed from: mapToTransformed-XGyztTk$default  reason: not valid java name */
        static /* synthetic */ long m1455mapToTransformedXGyztTk$default(Companion companion, long j, OffsetMappingCalculator offsetMappingCalculator, SelectionWedgeAffinity selectionWedgeAffinity, int i, Object obj) {
            if ((i & 4) != 0) {
                selectionWedgeAffinity = null;
            }
            return companion.m1454mapToTransformedXGyztTk(j, offsetMappingCalculator, selectionWedgeAffinity);
        }

        /* access modifiers changed from: private */
        @JvmStatic
        /* renamed from: mapToTransformed-XGyztTk  reason: not valid java name */
        public final long m1454mapToTransformedXGyztTk(long j, OffsetMappingCalculator offsetMappingCalculator, SelectionWedgeAffinity selectionWedgeAffinity) {
            long j2;
            long j3;
            long r0 = offsetMappingCalculator.m1387mapFromSourcejx7JFs(TextRange.m6564getStartimpl(j));
            if (TextRange.m6558getCollapsedimpl(j)) {
                j2 = r0;
            } else {
                j2 = offsetMappingCalculator.m1387mapFromSourcejx7JFs(TextRange.m6559getEndimpl(j));
            }
            int min = Math.min(TextRange.m6562getMinimpl(r0), TextRange.m6562getMinimpl(j2));
            int max = Math.max(TextRange.m6561getMaximpl(r0), TextRange.m6561getMaximpl(j2));
            if (TextRange.m6563getReversedimpl(j)) {
                j3 = TextRangeKt.TextRange(max, min);
            } else {
                j3 = TextRangeKt.TextRange(min, max);
            }
            if (TextRange.m6558getCollapsedimpl(j) && !TextRange.m6558getCollapsedimpl(j3)) {
                WedgeAffinity startAffinity = selectionWedgeAffinity != null ? selectionWedgeAffinity.getStartAffinity() : null;
                int i = startAffinity == null ? -1 : WhenMappings.$EnumSwitchMapping$0[startAffinity.ordinal()];
                if (i != -1) {
                    if (i == 1) {
                        return TextRangeKt.TextRange(TextRange.m6564getStartimpl(j3));
                    }
                    if (i == 2) {
                        return TextRangeKt.TextRange(TextRange.m6559getEndimpl(j3));
                    }
                    throw new NoWhenBranchMatchedException();
                }
            }
            return j3;
        }

        /* access modifiers changed from: private */
        @JvmStatic
        /* renamed from: mapFromTransformed-xdX6-G0  reason: not valid java name */
        public final long m1453mapFromTransformedxdX6G0(long j, OffsetMappingCalculator offsetMappingCalculator) {
            long j2;
            long r0 = offsetMappingCalculator.m1386mapFromDestjx7JFs(TextRange.m6564getStartimpl(j));
            if (TextRange.m6558getCollapsedimpl(j)) {
                j2 = r0;
            } else {
                j2 = offsetMappingCalculator.m1386mapFromDestjx7JFs(TextRange.m6559getEndimpl(j));
            }
            int min = Math.min(TextRange.m6562getMinimpl(r0), TextRange.m6562getMinimpl(j2));
            int max = Math.max(TextRange.m6561getMaximpl(r0), TextRange.m6561getMaximpl(j2));
            if (TextRange.m6563getReversedimpl(j)) {
                return TextRangeKt.TextRange(max, min);
            }
            return TextRangeKt.TextRange(min, max);
        }
    }
}
