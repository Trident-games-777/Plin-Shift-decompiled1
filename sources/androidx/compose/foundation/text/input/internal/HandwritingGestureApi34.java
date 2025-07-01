package androidx.compose.foundation.text.input.internal;

import android.os.CancellationSignal;
import android.view.inputmethod.DeleteGesture;
import android.view.inputmethod.DeleteRangeGesture;
import android.view.inputmethod.HandwritingGesture;
import android.view.inputmethod.InsertGesture;
import android.view.inputmethod.JoinOrSplitGesture;
import android.view.inputmethod.PreviewableHandwritingGesture;
import android.view.inputmethod.RemoveSpaceGesture;
import android.view.inputmethod.SelectGesture;
import android.view.inputmethod.SelectRangeGesture;
import androidx.compose.foundation.text.LegacyTextFieldState;
import androidx.compose.foundation.text.TextLayoutResultProxy;
import androidx.compose.foundation.text.input.InputTransformation;
import androidx.compose.foundation.text.input.TextFieldState;
import androidx.compose.foundation.text.input.TextHighlightType;
import androidx.compose.foundation.text.input.internal.undo.TextFieldEditUndoBehavior;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.ui.graphics.RectHelper_androidKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextGranularity;
import androidx.compose.ui.text.TextInclusionStrategy;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.input.CommitTextCommand;
import androidx.compose.ui.text.input.DeleteSurroundingTextCommand;
import androidx.compose.ui.text.input.EditCommand;
import androidx.compose.ui.text.input.SetSelectionCommand;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.MatchResult;
import kotlin.text.Regex;

@Metadata(d1 = {"\u0000²\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bH\u0003J>\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bH\u0003ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J,\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00162\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bH\u0003J8\u0010\u0017\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bH\u0003ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ\u0014\u0010\u001c\u001a\u00020\u0004*\u00020\u001d2\u0006\u0010\u0005\u001a\u00020\u0006H\u0003J&\u0010\u001e\u001a\u00020\n*\u00020\u001d2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020 H\u0002ø\u0001\u0000¢\u0006\u0004\b!\u0010\"J0\u0010#\u001a\u00020\u0004*\u00020$2\u0006\u0010\u0005\u001a\u00020%2\u0006\u0010\u000e\u001a\u00020\u000f2\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bH\u0003J\u001c\u0010#\u001a\u00020\u0004*\u00020\u001d2\u0006\u0010\u0005\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0003J0\u0010(\u001a\u00020\u0004*\u00020$2\u0006\u0010\u0005\u001a\u00020)2\u0006\u0010\u000e\u001a\u00020\u000f2\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bH\u0003J\u001c\u0010(\u001a\u00020\u0004*\u00020\u001d2\u0006\u0010\u0005\u001a\u00020)2\u0006\u0010&\u001a\u00020'H\u0003J&\u0010*\u001a\u00020\n*\u00020\u001d2\u0006\u0010+\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011H\u0003ø\u0001\u0000¢\u0006\u0004\b,\u0010-JA\u0010.\u001a\u00020\u0004*\u00020$2\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010/\u001a\u0004\u0018\u00010\u00192\b\u00100\u001a\u0004\u0018\u0001012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bH\u0001¢\u0006\u0002\b2J+\u0010.\u001a\u00020\u0004*\u00020\u001d2\u0006\u00103\u001a\u00020\u00062\u0006\u0010&\u001a\u00020'2\b\u00100\u001a\u0004\u0018\u000101H\u0001¢\u0006\u0002\b2J2\u00104\u001a\u00020\u0004*\u00020$2\u0006\u0010\u0005\u001a\u0002052\b\u00100\u001a\u0004\u0018\u0001012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bH\u0003J&\u00104\u001a\u00020\u0004*\u00020\u001d2\u0006\u0010\u0005\u001a\u0002052\u0006\u0010&\u001a\u00020'2\b\u00100\u001a\u0004\u0018\u000101H\u0003J:\u00106\u001a\u00020\u0004*\u00020$2\u0006\u0010\u0005\u001a\u0002072\u0006\u0010\u000e\u001a\u00020\u000f2\b\u00100\u001a\u0004\u0018\u0001012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bH\u0003J&\u00106\u001a\u00020\u0004*\u00020\u001d2\u0006\u0010\u0005\u001a\u0002072\u0006\u0010&\u001a\u00020'2\b\u00100\u001a\u0004\u0018\u000101H\u0003J:\u00108\u001a\u00020\u0004*\u00020$2\u0006\u0010\u0005\u001a\u0002092\u0006\u0010\u000e\u001a\u00020\u000f2\b\u00100\u001a\u0004\u0018\u0001012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bH\u0003J&\u00108\u001a\u00020\u0004*\u00020\u001d2\u0006\u0010\u0005\u001a\u0002092\u0006\u0010&\u001a\u00020'2\b\u00100\u001a\u0004\u0018\u000101H\u0003J2\u0010:\u001a\u00020\u0004*\u00020$2\u0006\u0010\u0005\u001a\u00020;2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bH\u0003J\u001c\u0010:\u001a\u00020\u0004*\u00020\u001d2\u0006\u0010\u0005\u001a\u00020;2\u0006\u0010&\u001a\u00020'H\u0003J2\u0010<\u001a\u00020\u0004*\u00020$2\u0006\u0010\u0005\u001a\u00020=2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bH\u0003J\u001c\u0010<\u001a\u00020\u0004*\u00020\u001d2\u0006\u0010\u0005\u001a\u00020=2\u0006\u0010&\u001a\u00020'H\u0003J\u001e\u0010>\u001a\u00020\n*\u00020$2\u0006\u0010\u0005\u001a\u00020%2\b\u0010/\u001a\u0004\u0018\u00010\u0019H\u0003J\u001c\u0010>\u001a\u00020\n*\u00020\u001d2\u0006\u0010\u0005\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0003J\u001e\u0010?\u001a\u00020\n*\u00020$2\u0006\u0010\u0005\u001a\u00020)2\b\u0010/\u001a\u0004\u0018\u00010\u0019H\u0003J\u001c\u0010?\u001a\u00020\n*\u00020\u001d2\u0006\u0010\u0005\u001a\u00020)2\u0006\u0010&\u001a\u00020'H\u0003J-\u0010@\u001a\u00020\u0011*\u00020$2\u0006\u0010\u0005\u001a\u00020A2\b\u0010/\u001a\u0004\u0018\u00010\u00192\b\u0010B\u001a\u0004\u0018\u00010CH\u0001¢\u0006\u0002\bDJ+\u0010@\u001a\u00020\u0011*\u00020\u001d2\u0006\u00103\u001a\u00020A2\u0006\u0010&\u001a\u00020'2\b\u0010B\u001a\u0004\u0018\u00010CH\u0001¢\u0006\u0002\bDJ\u001e\u0010E\u001a\u00020\n*\u00020$2\u0006\u0010\u0005\u001a\u00020;2\b\u0010/\u001a\u0004\u0018\u00010\u0019H\u0003J\u001c\u0010E\u001a\u00020\n*\u00020\u001d2\u0006\u0010\u0005\u001a\u00020;2\u0006\u0010&\u001a\u00020'H\u0003J\u001e\u0010F\u001a\u00020\n*\u00020$2\u0006\u0010\u0005\u001a\u00020=2\b\u0010/\u001a\u0004\u0018\u00010\u0019H\u0003J\u001c\u0010F\u001a\u00020\n*\u00020\u001d2\u0006\u0010\u0005\u001a\u00020=2\u0006\u0010&\u001a\u00020'H\u0003J\u0019\u0010G\u001a\u00020H*\u00020\u0004H\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bI\u0010J\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006K"}, d2 = {"Landroidx/compose/foundation/text/input/internal/HandwritingGestureApi34;", "", "()V", "fallbackOnLegacyTextField", "", "gesture", "Landroid/view/inputmethod/HandwritingGesture;", "editCommandConsumer", "Lkotlin/Function1;", "Landroidx/compose/ui/text/input/EditCommand;", "", "performDeletionOnLegacyTextField", "range", "Landroidx/compose/ui/text/TextRange;", "text", "Landroidx/compose/ui/text/AnnotatedString;", "adjustRange", "", "performDeletionOnLegacyTextField-vJH6DeI", "(JLandroidx/compose/ui/text/AnnotatedString;ZLkotlin/jvm/functions/Function1;)V", "performInsertionOnLegacyTextField", "offset", "", "performSelectionOnLegacyTextField", "textSelectionManager", "Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;", "performSelectionOnLegacyTextField-8ffj60Q", "(JLandroidx/compose/foundation/text/selection/TextFieldSelectionManager;Lkotlin/jvm/functions/Function1;)V", "fallback", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "highlightRange", "type", "Landroidx/compose/foundation/text/input/TextHighlightType;", "highlightRange-XJREzCE", "(Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;JI)V", "performDeleteGesture", "Landroidx/compose/foundation/text/LegacyTextFieldState;", "Landroid/view/inputmethod/DeleteGesture;", "layoutState", "Landroidx/compose/foundation/text/input/internal/TextLayoutState;", "performDeleteRangeGesture", "Landroid/view/inputmethod/DeleteRangeGesture;", "performDeletion", "rangeInTransformedText", "performDeletion-Sb-Bc2M", "(Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;JZ)V", "performHandwritingGesture", "textFieldSelectionManager", "viewConfiguration", "Landroidx/compose/ui/platform/ViewConfiguration;", "performHandwritingGesture$foundation_release", "handwritingGesture", "performInsertGesture", "Landroid/view/inputmethod/InsertGesture;", "performJoinOrSplitGesture", "Landroid/view/inputmethod/JoinOrSplitGesture;", "performRemoveSpaceGesture", "Landroid/view/inputmethod/RemoveSpaceGesture;", "performSelectGesture", "Landroid/view/inputmethod/SelectGesture;", "performSelectRangeGesture", "Landroid/view/inputmethod/SelectRangeGesture;", "previewDeleteGesture", "previewDeleteRangeGesture", "previewHandwritingGesture", "Landroid/view/inputmethod/PreviewableHandwritingGesture;", "cancellationSignal", "Landroid/os/CancellationSignal;", "previewHandwritingGesture$foundation_release", "previewSelectGesture", "previewSelectRangeGesture", "toTextGranularity", "Landroidx/compose/ui/text/TextGranularity;", "toTextGranularity-NUwxegE", "(I)I", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: HandwritingGesture.android.kt */
public final class HandwritingGestureApi34 {
    public static final int $stable = 0;
    public static final HandwritingGestureApi34 INSTANCE = new HandwritingGestureApi34();

    private HandwritingGestureApi34() {
    }

    public final int performHandwritingGesture$foundation_release(TransformedTextFieldState transformedTextFieldState, HandwritingGesture handwritingGesture, TextLayoutState textLayoutState, ViewConfiguration viewConfiguration) {
        if (handwritingGesture instanceof SelectGesture) {
            return performSelectGesture(transformedTextFieldState, (SelectGesture) handwritingGesture, textLayoutState);
        }
        if (handwritingGesture instanceof DeleteGesture) {
            return performDeleteGesture(transformedTextFieldState, (DeleteGesture) handwritingGesture, textLayoutState);
        }
        if (handwritingGesture instanceof SelectRangeGesture) {
            return performSelectRangeGesture(transformedTextFieldState, (SelectRangeGesture) handwritingGesture, textLayoutState);
        }
        if (handwritingGesture instanceof DeleteRangeGesture) {
            return performDeleteRangeGesture(transformedTextFieldState, (DeleteRangeGesture) handwritingGesture, textLayoutState);
        }
        if (handwritingGesture instanceof JoinOrSplitGesture) {
            return performJoinOrSplitGesture(transformedTextFieldState, (JoinOrSplitGesture) handwritingGesture, textLayoutState, viewConfiguration);
        }
        if (handwritingGesture instanceof InsertGesture) {
            return performInsertGesture(transformedTextFieldState, (InsertGesture) handwritingGesture, textLayoutState, viewConfiguration);
        }
        if (handwritingGesture instanceof RemoveSpaceGesture) {
            return performRemoveSpaceGesture(transformedTextFieldState, (RemoveSpaceGesture) handwritingGesture, textLayoutState, viewConfiguration);
        }
        return 2;
    }

    public final boolean previewHandwritingGesture$foundation_release(TransformedTextFieldState transformedTextFieldState, PreviewableHandwritingGesture previewableHandwritingGesture, TextLayoutState textLayoutState, CancellationSignal cancellationSignal) {
        if (previewableHandwritingGesture instanceof SelectGesture) {
            previewSelectGesture(transformedTextFieldState, (SelectGesture) previewableHandwritingGesture, textLayoutState);
        } else if (previewableHandwritingGesture instanceof DeleteGesture) {
            previewDeleteGesture(transformedTextFieldState, (DeleteGesture) previewableHandwritingGesture, textLayoutState);
        } else if (previewableHandwritingGesture instanceof SelectRangeGesture) {
            previewSelectRangeGesture(transformedTextFieldState, (SelectRangeGesture) previewableHandwritingGesture, textLayoutState);
        } else if (!(previewableHandwritingGesture instanceof DeleteRangeGesture)) {
            return false;
        } else {
            previewDeleteRangeGesture(transformedTextFieldState, (DeleteRangeGesture) previewableHandwritingGesture, textLayoutState);
        }
        if (cancellationSignal == null) {
            return true;
        }
        cancellationSignal.setOnCancelListener(new HandwritingGestureApi34$$ExternalSyntheticLambda1(transformedTextFieldState));
        return true;
    }

    private final int performSelectGesture(TransformedTextFieldState transformedTextFieldState, SelectGesture selectGesture, TextLayoutState textLayoutState) {
        long r0 = HandwritingGesture_androidKt.m1376getRangeForScreenRectOH9lIzo(textLayoutState, RectHelper_androidKt.toComposeRect(selectGesture.getSelectionArea()), m1358toTextGranularityNUwxegE(selectGesture.getGranularity()), TextInclusionStrategy.Companion.getContainsCenter());
        if (TextRange.m6558getCollapsedimpl(r0)) {
            return INSTANCE.fallback(transformedTextFieldState, (HandwritingGesture) selectGesture);
        }
        transformedTextFieldState.m1449selectCharsIn5zctL8(r0);
        return 1;
    }

    private final void previewSelectGesture(TransformedTextFieldState transformedTextFieldState, SelectGesture selectGesture, TextLayoutState textLayoutState) {
        m1354highlightRangeXJREzCE(transformedTextFieldState, HandwritingGesture_androidKt.m1376getRangeForScreenRectOH9lIzo(textLayoutState, RectHelper_androidKt.toComposeRect(selectGesture.getSelectionArea()), m1358toTextGranularityNUwxegE(selectGesture.getGranularity()), TextInclusionStrategy.Companion.getContainsCenter()), TextHighlightType.Companion.m1325getHandwritingSelectPreviewsxJuwY());
    }

    private final int performDeleteGesture(TransformedTextFieldState transformedTextFieldState, DeleteGesture deleteGesture, TextLayoutState textLayoutState) {
        int r0 = m1358toTextGranularityNUwxegE(deleteGesture.getGranularity());
        long r1 = HandwritingGesture_androidKt.m1376getRangeForScreenRectOH9lIzo(textLayoutState, RectHelper_androidKt.toComposeRect(deleteGesture.getDeletionArea()), r0, TextInclusionStrategy.Companion.getContainsCenter());
        if (TextRange.m6558getCollapsedimpl(r1)) {
            return INSTANCE.fallback(transformedTextFieldState, (HandwritingGesture) deleteGesture);
        }
        m1355performDeletionSbBc2M(transformedTextFieldState, r1, TextGranularity.m6524equalsimpl0(r0, TextGranularity.Companion.m6529getWordDRrd7Zo()));
        return 1;
    }

    private final void previewDeleteGesture(TransformedTextFieldState transformedTextFieldState, DeleteGesture deleteGesture, TextLayoutState textLayoutState) {
        m1354highlightRangeXJREzCE(transformedTextFieldState, HandwritingGesture_androidKt.m1376getRangeForScreenRectOH9lIzo(textLayoutState, RectHelper_androidKt.toComposeRect(deleteGesture.getDeletionArea()), m1358toTextGranularityNUwxegE(deleteGesture.getGranularity()), TextInclusionStrategy.Companion.getContainsCenter()), TextHighlightType.Companion.m1324getHandwritingDeletePreviewsxJuwY());
    }

    private final int performSelectRangeGesture(TransformedTextFieldState transformedTextFieldState, SelectRangeGesture selectRangeGesture, TextLayoutState textLayoutState) {
        long r0 = HandwritingGesture_androidKt.m1378getRangeForScreenRectsO048IG0(textLayoutState, RectHelper_androidKt.toComposeRect(selectRangeGesture.getSelectionStartArea()), RectHelper_androidKt.toComposeRect(selectRangeGesture.getSelectionEndArea()), m1358toTextGranularityNUwxegE(selectRangeGesture.getGranularity()), TextInclusionStrategy.Companion.getContainsCenter());
        if (TextRange.m6558getCollapsedimpl(r0)) {
            return INSTANCE.fallback(transformedTextFieldState, (HandwritingGesture) selectRangeGesture);
        }
        transformedTextFieldState.m1449selectCharsIn5zctL8(r0);
        return 1;
    }

    private final void previewSelectRangeGesture(TransformedTextFieldState transformedTextFieldState, SelectRangeGesture selectRangeGesture, TextLayoutState textLayoutState) {
        m1354highlightRangeXJREzCE(transformedTextFieldState, HandwritingGesture_androidKt.m1378getRangeForScreenRectsO048IG0(textLayoutState, RectHelper_androidKt.toComposeRect(selectRangeGesture.getSelectionStartArea()), RectHelper_androidKt.toComposeRect(selectRangeGesture.getSelectionEndArea()), m1358toTextGranularityNUwxegE(selectRangeGesture.getGranularity()), TextInclusionStrategy.Companion.getContainsCenter()), TextHighlightType.Companion.m1325getHandwritingSelectPreviewsxJuwY());
    }

    private final int performDeleteRangeGesture(TransformedTextFieldState transformedTextFieldState, DeleteRangeGesture deleteRangeGesture, TextLayoutState textLayoutState) {
        int r0 = m1358toTextGranularityNUwxegE(deleteRangeGesture.getGranularity());
        long r1 = HandwritingGesture_androidKt.m1378getRangeForScreenRectsO048IG0(textLayoutState, RectHelper_androidKt.toComposeRect(deleteRangeGesture.getDeletionStartArea()), RectHelper_androidKt.toComposeRect(deleteRangeGesture.getDeletionEndArea()), r0, TextInclusionStrategy.Companion.getContainsCenter());
        if (TextRange.m6558getCollapsedimpl(r1)) {
            return INSTANCE.fallback(transformedTextFieldState, (HandwritingGesture) deleteRangeGesture);
        }
        m1355performDeletionSbBc2M(transformedTextFieldState, r1, TextGranularity.m6524equalsimpl0(r0, TextGranularity.Companion.m6529getWordDRrd7Zo()));
        return 1;
    }

    private final void previewDeleteRangeGesture(TransformedTextFieldState transformedTextFieldState, DeleteRangeGesture deleteRangeGesture, TextLayoutState textLayoutState) {
        m1354highlightRangeXJREzCE(transformedTextFieldState, HandwritingGesture_androidKt.m1378getRangeForScreenRectsO048IG0(textLayoutState, RectHelper_androidKt.toComposeRect(deleteRangeGesture.getDeletionStartArea()), RectHelper_androidKt.toComposeRect(deleteRangeGesture.getDeletionEndArea()), m1358toTextGranularityNUwxegE(deleteRangeGesture.getGranularity()), TextInclusionStrategy.Companion.getContainsCenter()), TextHighlightType.Companion.m1324getHandwritingDeletePreviewsxJuwY());
    }

    private final int performJoinOrSplitGesture(TransformedTextFieldState transformedTextFieldState, JoinOrSplitGesture joinOrSplitGesture, TextLayoutState textLayoutState, ViewConfiguration viewConfiguration) {
        TextLayoutResult layoutResult;
        if (transformedTextFieldState.getOutputText() != transformedTextFieldState.getUntransformedText()) {
            return 3;
        }
        int r13 = HandwritingGesture_androidKt.m1371getOffsetForHandwritingGestured4ec7I(textLayoutState, HandwritingGesture_androidKt.toOffset(joinOrSplitGesture.getJoinOrSplitPoint()), viewConfiguration);
        if (r13 == -1 || ((layoutResult = textLayoutState.getLayoutResult()) != null && HandwritingGesture_androidKt.isBiDiBoundary(layoutResult, r13))) {
            return fallback(transformedTextFieldState, (HandwritingGesture) joinOrSplitGesture);
        }
        long access$rangeOfWhitespaces = HandwritingGesture_androidKt.rangeOfWhitespaces(transformedTextFieldState.getVisualText(), r13);
        if (TextRange.m6558getCollapsedimpl(access$rangeOfWhitespaces)) {
            TransformedTextFieldState.m1442replaceTextM8tDOmk$default(transformedTextFieldState, " ", access$rangeOfWhitespaces, (TextFieldEditUndoBehavior) null, false, 12, (Object) null);
        } else {
            m1355performDeletionSbBc2M(transformedTextFieldState, access$rangeOfWhitespaces, false);
        }
        return 1;
    }

    private final int performInsertGesture(TransformedTextFieldState transformedTextFieldState, InsertGesture insertGesture, TextLayoutState textLayoutState, ViewConfiguration viewConfiguration) {
        int r11 = HandwritingGesture_androidKt.m1371getOffsetForHandwritingGestured4ec7I(textLayoutState, HandwritingGesture_androidKt.toOffset(insertGesture.getInsertionPoint()), viewConfiguration);
        if (r11 == -1) {
            return fallback(transformedTextFieldState, (HandwritingGesture) insertGesture);
        }
        TransformedTextFieldState.m1442replaceTextM8tDOmk$default(transformedTextFieldState, insertGesture.getTextToInsert(), TextRangeKt.TextRange(r11), (TextFieldEditUndoBehavior) null, false, 12, (Object) null);
        return 1;
    }

    private final int performRemoveSpaceGesture(TransformedTextFieldState transformedTextFieldState, RemoveSpaceGesture removeSpaceGesture, TextLayoutState textLayoutState, ViewConfiguration viewConfiguration) {
        long r1 = HandwritingGesture_androidKt.m1373getRangeForRemoveSpaceGesture5iVPX68(textLayoutState.getLayoutResult(), HandwritingGesture_androidKt.toOffset(removeSpaceGesture.getStartPoint()), HandwritingGesture_androidKt.toOffset(removeSpaceGesture.getEndPoint()), textLayoutState.getTextLayoutNodeCoordinates(), viewConfiguration);
        if (TextRange.m6558getCollapsedimpl(r1)) {
            return INSTANCE.fallback(transformedTextFieldState, (HandwritingGesture) removeSpaceGesture);
        }
        Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = -1;
        Ref.IntRef intRef2 = new Ref.IntRef();
        intRef2.element = -1;
        String replace = new Regex("\\s+").replace((CharSequence) TextRangeKt.m6571substringFDrldGo(transformedTextFieldState.getVisualText(), r1), (Function1<? super MatchResult, ? extends CharSequence>) new HandwritingGestureApi34$performRemoveSpaceGesture$newText$1(intRef, intRef2));
        if (intRef.element == -1 || intRef2.element == -1) {
            return fallback(transformedTextFieldState, (HandwritingGesture) removeSpaceGesture);
        }
        long TextRange = TextRangeKt.TextRange(TextRange.m6564getStartimpl(r1) + intRef.element, TextRange.m6564getStartimpl(r1) + intRef2.element);
        String substring = replace.substring(intRef.element, replace.length() - (TextRange.m6560getLengthimpl(r1) - intRef2.element));
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        TransformedTextFieldState.m1442replaceTextM8tDOmk$default(transformedTextFieldState, substring, TextRange, (TextFieldEditUndoBehavior) null, false, 12, (Object) null);
        return 1;
    }

    /* renamed from: performDeletion-Sb-Bc2M  reason: not valid java name */
    private final void m1355performDeletionSbBc2M(TransformedTextFieldState transformedTextFieldState, long j, boolean z) {
        if (z) {
            j = HandwritingGesture_androidKt.m1367adjustHandwritingDeleteGestureRange72CqOWE(j, transformedTextFieldState.getVisualText());
        }
        TransformedTextFieldState transformedTextFieldState2 = transformedTextFieldState;
        TransformedTextFieldState.m1442replaceTextM8tDOmk$default(transformedTextFieldState2, "", j, (TextFieldEditUndoBehavior) null, false, 12, (Object) null);
    }

    /* renamed from: highlightRange-XJREzCE  reason: not valid java name */
    private final void m1354highlightRangeXJREzCE(TransformedTextFieldState transformedTextFieldState, long j, int i) {
        if (TextRange.m6558getCollapsedimpl(j)) {
            TextFieldState access$getTextFieldState$p = transformedTextFieldState.textFieldState;
            InputTransformation access$getInputTransformation$p = transformedTextFieldState.inputTransformation;
            TextFieldEditUndoBehavior textFieldEditUndoBehavior = TextFieldEditUndoBehavior.MergeIfPossible;
            access$getTextFieldState$p.getMainBuffer$foundation_release().getChangeTracker().clearChanges();
            access$getTextFieldState$p.getMainBuffer$foundation_release().clearHighlight();
            access$getTextFieldState$p.commitEditAsUser(access$getInputTransformation$p, true, textFieldEditUndoBehavior);
            return;
        }
        transformedTextFieldState.m1443highlightCharsIn7RAjNK8(i, j);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0014, code lost:
        r1 = (r1 = r1.getValue()).getLayoutInput();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int performHandwritingGesture$foundation_release(androidx.compose.foundation.text.LegacyTextFieldState r7, android.view.inputmethod.HandwritingGesture r8, androidx.compose.foundation.text.selection.TextFieldSelectionManager r9, androidx.compose.ui.platform.ViewConfiguration r10, kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.input.EditCommand, kotlin.Unit> r11) {
        /*
            r6 = this;
            androidx.compose.ui.text.AnnotatedString r3 = r7.getUntransformedText()
            r0 = 3
            if (r3 != 0) goto L_0x0008
            return r0
        L_0x0008:
            androidx.compose.foundation.text.TextLayoutResultProxy r1 = r7.getLayoutResult()
            if (r1 == 0) goto L_0x001f
            androidx.compose.ui.text.TextLayoutResult r1 = r1.getValue()
            if (r1 == 0) goto L_0x001f
            androidx.compose.ui.text.TextLayoutInput r1 = r1.getLayoutInput()
            if (r1 == 0) goto L_0x001f
            androidx.compose.ui.text.AnnotatedString r1 = r1.getText()
            goto L_0x0020
        L_0x001f:
            r1 = 0
        L_0x0020:
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r1)
            if (r1 != 0) goto L_0x0027
            return r0
        L_0x0027:
            boolean r0 = r8 instanceof android.view.inputmethod.SelectGesture
            if (r0 == 0) goto L_0x0032
            android.view.inputmethod.SelectGesture r8 = (android.view.inputmethod.SelectGesture) r8
            int r7 = r6.performSelectGesture(r7, r8, r9, r11)
            return r7
        L_0x0032:
            boolean r0 = r8 instanceof android.view.inputmethod.DeleteGesture
            if (r0 == 0) goto L_0x003d
            android.view.inputmethod.DeleteGesture r8 = (android.view.inputmethod.DeleteGesture) r8
            int r7 = r6.performDeleteGesture(r7, r8, r3, r11)
            return r7
        L_0x003d:
            boolean r0 = r8 instanceof android.view.inputmethod.SelectRangeGesture
            if (r0 == 0) goto L_0x0048
            android.view.inputmethod.SelectRangeGesture r8 = (android.view.inputmethod.SelectRangeGesture) r8
            int r7 = r6.performSelectRangeGesture(r7, r8, r9, r11)
            return r7
        L_0x0048:
            boolean r9 = r8 instanceof android.view.inputmethod.DeleteRangeGesture
            if (r9 == 0) goto L_0x0053
            android.view.inputmethod.DeleteRangeGesture r8 = (android.view.inputmethod.DeleteRangeGesture) r8
            int r7 = r6.performDeleteRangeGesture(r7, r8, r3, r11)
            return r7
        L_0x0053:
            boolean r9 = r8 instanceof android.view.inputmethod.JoinOrSplitGesture
            if (r9 == 0) goto L_0x0063
            r2 = r8
            android.view.inputmethod.JoinOrSplitGesture r2 = (android.view.inputmethod.JoinOrSplitGesture) r2
            r0 = r6
            r1 = r7
            r4 = r10
            r5 = r11
            int r7 = r0.performJoinOrSplitGesture(r1, r2, r3, r4, r5)
            return r7
        L_0x0063:
            r0 = r6
            r1 = r7
            r4 = r10
            r5 = r11
            boolean r7 = r8 instanceof android.view.inputmethod.InsertGesture
            if (r7 == 0) goto L_0x0072
            android.view.inputmethod.InsertGesture r8 = (android.view.inputmethod.InsertGesture) r8
            int r7 = r6.performInsertGesture((androidx.compose.foundation.text.LegacyTextFieldState) r1, (android.view.inputmethod.InsertGesture) r8, (androidx.compose.ui.platform.ViewConfiguration) r4, (kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.input.EditCommand, kotlin.Unit>) r5)
            return r7
        L_0x0072:
            boolean r7 = r8 instanceof android.view.inputmethod.RemoveSpaceGesture
            if (r7 == 0) goto L_0x007e
            r2 = r8
            android.view.inputmethod.RemoveSpaceGesture r2 = (android.view.inputmethod.RemoveSpaceGesture) r2
            int r7 = r0.performRemoveSpaceGesture(r1, r2, r3, r4, r5)
            return r7
        L_0x007e:
            r7 = 2
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.input.internal.HandwritingGestureApi34.performHandwritingGesture$foundation_release(androidx.compose.foundation.text.LegacyTextFieldState, android.view.inputmethod.HandwritingGesture, androidx.compose.foundation.text.selection.TextFieldSelectionManager, androidx.compose.ui.platform.ViewConfiguration, kotlin.jvm.functions.Function1):int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0014, code lost:
        r2 = (r2 = r2.getValue()).getLayoutInput();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean previewHandwritingGesture$foundation_release(androidx.compose.foundation.text.LegacyTextFieldState r4, android.view.inputmethod.PreviewableHandwritingGesture r5, androidx.compose.foundation.text.selection.TextFieldSelectionManager r6, android.os.CancellationSignal r7) {
        /*
            r3 = this;
            androidx.compose.ui.text.AnnotatedString r0 = r4.getUntransformedText()
            r1 = 0
            if (r0 != 0) goto L_0x0008
            return r1
        L_0x0008:
            androidx.compose.foundation.text.TextLayoutResultProxy r2 = r4.getLayoutResult()
            if (r2 == 0) goto L_0x001f
            androidx.compose.ui.text.TextLayoutResult r2 = r2.getValue()
            if (r2 == 0) goto L_0x001f
            androidx.compose.ui.text.TextLayoutInput r2 = r2.getLayoutInput()
            if (r2 == 0) goto L_0x001f
            androidx.compose.ui.text.AnnotatedString r2 = r2.getText()
            goto L_0x0020
        L_0x001f:
            r2 = 0
        L_0x0020:
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r2)
            if (r0 != 0) goto L_0x0027
            return r1
        L_0x0027:
            boolean r0 = r5 instanceof android.view.inputmethod.SelectGesture
            if (r0 == 0) goto L_0x0031
            android.view.inputmethod.SelectGesture r5 = (android.view.inputmethod.SelectGesture) r5
            r3.previewSelectGesture((androidx.compose.foundation.text.LegacyTextFieldState) r4, (android.view.inputmethod.SelectGesture) r5, (androidx.compose.foundation.text.selection.TextFieldSelectionManager) r6)
            goto L_0x004e
        L_0x0031:
            boolean r0 = r5 instanceof android.view.inputmethod.DeleteGesture
            if (r0 == 0) goto L_0x003b
            android.view.inputmethod.DeleteGesture r5 = (android.view.inputmethod.DeleteGesture) r5
            r3.previewDeleteGesture((androidx.compose.foundation.text.LegacyTextFieldState) r4, (android.view.inputmethod.DeleteGesture) r5, (androidx.compose.foundation.text.selection.TextFieldSelectionManager) r6)
            goto L_0x004e
        L_0x003b:
            boolean r0 = r5 instanceof android.view.inputmethod.SelectRangeGesture
            if (r0 == 0) goto L_0x0045
            android.view.inputmethod.SelectRangeGesture r5 = (android.view.inputmethod.SelectRangeGesture) r5
            r3.previewSelectRangeGesture((androidx.compose.foundation.text.LegacyTextFieldState) r4, (android.view.inputmethod.SelectRangeGesture) r5, (androidx.compose.foundation.text.selection.TextFieldSelectionManager) r6)
            goto L_0x004e
        L_0x0045:
            boolean r0 = r5 instanceof android.view.inputmethod.DeleteRangeGesture
            if (r0 == 0) goto L_0x005a
            android.view.inputmethod.DeleteRangeGesture r5 = (android.view.inputmethod.DeleteRangeGesture) r5
            r3.previewDeleteRangeGesture((androidx.compose.foundation.text.LegacyTextFieldState) r4, (android.view.inputmethod.DeleteRangeGesture) r5, (androidx.compose.foundation.text.selection.TextFieldSelectionManager) r6)
        L_0x004e:
            if (r7 == 0) goto L_0x0058
            androidx.compose.foundation.text.input.internal.HandwritingGestureApi34$$ExternalSyntheticLambda0 r4 = new androidx.compose.foundation.text.input.internal.HandwritingGestureApi34$$ExternalSyntheticLambda0
            r4.<init>(r6)
            r7.setOnCancelListener(r4)
        L_0x0058:
            r4 = 1
            return r4
        L_0x005a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.input.internal.HandwritingGestureApi34.previewHandwritingGesture$foundation_release(androidx.compose.foundation.text.LegacyTextFieldState, android.view.inputmethod.PreviewableHandwritingGesture, androidx.compose.foundation.text.selection.TextFieldSelectionManager, android.os.CancellationSignal):boolean");
    }

    /* access modifiers changed from: private */
    public static final void previewHandwritingGesture$lambda$9(TextFieldSelectionManager textFieldSelectionManager) {
        if (textFieldSelectionManager != null) {
            textFieldSelectionManager.clearPreviewHighlight$foundation_release();
        }
    }

    private final int performSelectGesture(LegacyTextFieldState legacyTextFieldState, SelectGesture selectGesture, TextFieldSelectionManager textFieldSelectionManager, Function1<? super EditCommand, Unit> function1) {
        long r0 = HandwritingGesture_androidKt.m1375getRangeForScreenRectOH9lIzo(legacyTextFieldState, RectHelper_androidKt.toComposeRect(selectGesture.getSelectionArea()), m1358toTextGranularityNUwxegE(selectGesture.getGranularity()), TextInclusionStrategy.Companion.getContainsCenter());
        if (TextRange.m6558getCollapsedimpl(r0)) {
            return INSTANCE.fallbackOnLegacyTextField((HandwritingGesture) selectGesture, function1);
        }
        m1357performSelectionOnLegacyTextField8ffj60Q(r0, textFieldSelectionManager, function1);
        return 1;
    }

    private final void previewSelectGesture(LegacyTextFieldState legacyTextFieldState, SelectGesture selectGesture, TextFieldSelectionManager textFieldSelectionManager) {
        if (textFieldSelectionManager != null) {
            textFieldSelectionManager.m1653setSelectionPreviewHighlight5zctL8$foundation_release(HandwritingGesture_androidKt.m1375getRangeForScreenRectOH9lIzo(legacyTextFieldState, RectHelper_androidKt.toComposeRect(selectGesture.getSelectionArea()), m1358toTextGranularityNUwxegE(selectGesture.getGranularity()), TextInclusionStrategy.Companion.getContainsCenter()));
        }
    }

    private final int performDeleteGesture(LegacyTextFieldState legacyTextFieldState, DeleteGesture deleteGesture, AnnotatedString annotatedString, Function1<? super EditCommand, Unit> function1) {
        int r0 = m1358toTextGranularityNUwxegE(deleteGesture.getGranularity());
        long r4 = HandwritingGesture_androidKt.m1375getRangeForScreenRectOH9lIzo(legacyTextFieldState, RectHelper_androidKt.toComposeRect(deleteGesture.getDeletionArea()), r0, TextInclusionStrategy.Companion.getContainsCenter());
        if (TextRange.m6558getCollapsedimpl(r4)) {
            return INSTANCE.fallbackOnLegacyTextField((HandwritingGesture) deleteGesture, function1);
        }
        m1356performDeletionOnLegacyTextFieldvJH6DeI(r4, annotatedString, TextGranularity.m6524equalsimpl0(r0, TextGranularity.Companion.m6529getWordDRrd7Zo()), function1);
        return 1;
    }

    private final void previewDeleteGesture(LegacyTextFieldState legacyTextFieldState, DeleteGesture deleteGesture, TextFieldSelectionManager textFieldSelectionManager) {
        if (textFieldSelectionManager != null) {
            textFieldSelectionManager.m1652setDeletionPreviewHighlight5zctL8$foundation_release(HandwritingGesture_androidKt.m1375getRangeForScreenRectOH9lIzo(legacyTextFieldState, RectHelper_androidKt.toComposeRect(deleteGesture.getDeletionArea()), m1358toTextGranularityNUwxegE(deleteGesture.getGranularity()), TextInclusionStrategy.Companion.getContainsCenter()));
        }
    }

    private final int performSelectRangeGesture(LegacyTextFieldState legacyTextFieldState, SelectRangeGesture selectRangeGesture, TextFieldSelectionManager textFieldSelectionManager, Function1<? super EditCommand, Unit> function1) {
        long r0 = HandwritingGesture_androidKt.m1377getRangeForScreenRectsO048IG0(legacyTextFieldState, RectHelper_androidKt.toComposeRect(selectRangeGesture.getSelectionStartArea()), RectHelper_androidKt.toComposeRect(selectRangeGesture.getSelectionEndArea()), m1358toTextGranularityNUwxegE(selectRangeGesture.getGranularity()), TextInclusionStrategy.Companion.getContainsCenter());
        if (TextRange.m6558getCollapsedimpl(r0)) {
            return INSTANCE.fallbackOnLegacyTextField((HandwritingGesture) selectRangeGesture, function1);
        }
        m1357performSelectionOnLegacyTextField8ffj60Q(r0, textFieldSelectionManager, function1);
        return 1;
    }

    private final void previewSelectRangeGesture(LegacyTextFieldState legacyTextFieldState, SelectRangeGesture selectRangeGesture, TextFieldSelectionManager textFieldSelectionManager) {
        if (textFieldSelectionManager != null) {
            textFieldSelectionManager.m1653setSelectionPreviewHighlight5zctL8$foundation_release(HandwritingGesture_androidKt.m1377getRangeForScreenRectsO048IG0(legacyTextFieldState, RectHelper_androidKt.toComposeRect(selectRangeGesture.getSelectionStartArea()), RectHelper_androidKt.toComposeRect(selectRangeGesture.getSelectionEndArea()), m1358toTextGranularityNUwxegE(selectRangeGesture.getGranularity()), TextInclusionStrategy.Companion.getContainsCenter()));
        }
    }

    private final int performDeleteRangeGesture(LegacyTextFieldState legacyTextFieldState, DeleteRangeGesture deleteRangeGesture, AnnotatedString annotatedString, Function1<? super EditCommand, Unit> function1) {
        int r0 = m1358toTextGranularityNUwxegE(deleteRangeGesture.getGranularity());
        long r5 = HandwritingGesture_androidKt.m1377getRangeForScreenRectsO048IG0(legacyTextFieldState, RectHelper_androidKt.toComposeRect(deleteRangeGesture.getDeletionStartArea()), RectHelper_androidKt.toComposeRect(deleteRangeGesture.getDeletionEndArea()), r0, TextInclusionStrategy.Companion.getContainsCenter());
        if (TextRange.m6558getCollapsedimpl(r5)) {
            return INSTANCE.fallbackOnLegacyTextField((HandwritingGesture) deleteRangeGesture, function1);
        }
        m1356performDeletionOnLegacyTextFieldvJH6DeI(r5, annotatedString, TextGranularity.m6524equalsimpl0(r0, TextGranularity.Companion.m6529getWordDRrd7Zo()), function1);
        return 1;
    }

    private final void previewDeleteRangeGesture(LegacyTextFieldState legacyTextFieldState, DeleteRangeGesture deleteRangeGesture, TextFieldSelectionManager textFieldSelectionManager) {
        if (textFieldSelectionManager != null) {
            textFieldSelectionManager.m1652setDeletionPreviewHighlight5zctL8$foundation_release(HandwritingGesture_androidKt.m1377getRangeForScreenRectsO048IG0(legacyTextFieldState, RectHelper_androidKt.toComposeRect(deleteRangeGesture.getDeletionStartArea()), RectHelper_androidKt.toComposeRect(deleteRangeGesture.getDeletionEndArea()), m1358toTextGranularityNUwxegE(deleteRangeGesture.getGranularity()), TextInclusionStrategy.Companion.getContainsCenter()));
        }
    }

    private final int performJoinOrSplitGesture(LegacyTextFieldState legacyTextFieldState, JoinOrSplitGesture joinOrSplitGesture, AnnotatedString annotatedString, ViewConfiguration viewConfiguration, Function1<? super EditCommand, Unit> function1) {
        TextLayoutResultProxy layoutResult;
        TextLayoutResult value;
        if (viewConfiguration == null) {
            return fallbackOnLegacyTextField((HandwritingGesture) joinOrSplitGesture, function1);
        }
        int r11 = HandwritingGesture_androidKt.m1370getOffsetForHandwritingGestured4ec7I(legacyTextFieldState, HandwritingGesture_androidKt.toOffset(joinOrSplitGesture.getJoinOrSplitPoint()), viewConfiguration);
        if (r11 == -1 || !((layoutResult = legacyTextFieldState.getLayoutResult()) == null || (value = layoutResult.getValue()) == null || !HandwritingGesture_androidKt.isBiDiBoundary(value, r11))) {
            return fallbackOnLegacyTextField((HandwritingGesture) joinOrSplitGesture, function1);
        }
        long access$rangeOfWhitespaces = HandwritingGesture_androidKt.rangeOfWhitespaces(annotatedString, r11);
        if (TextRange.m6558getCollapsedimpl(access$rangeOfWhitespaces)) {
            performInsertionOnLegacyTextField(TextRange.m6564getStartimpl(access$rangeOfWhitespaces), " ", function1);
        } else {
            m1356performDeletionOnLegacyTextFieldvJH6DeI(access$rangeOfWhitespaces, annotatedString, false, function1);
        }
        return 1;
    }

    private final int performInsertGesture(LegacyTextFieldState legacyTextFieldState, InsertGesture insertGesture, ViewConfiguration viewConfiguration, Function1<? super EditCommand, Unit> function1) {
        TextLayoutResultProxy layoutResult;
        TextLayoutResult value;
        if (viewConfiguration == null) {
            return fallbackOnLegacyTextField((HandwritingGesture) insertGesture, function1);
        }
        int r5 = HandwritingGesture_androidKt.m1370getOffsetForHandwritingGestured4ec7I(legacyTextFieldState, HandwritingGesture_androidKt.toOffset(insertGesture.getInsertionPoint()), viewConfiguration);
        if (r5 == -1 || ((layoutResult = legacyTextFieldState.getLayoutResult()) != null && (value = layoutResult.getValue()) != null && HandwritingGesture_androidKt.isBiDiBoundary(value, r5))) {
            return fallbackOnLegacyTextField((HandwritingGesture) insertGesture, function1);
        }
        performInsertionOnLegacyTextField(r5, insertGesture.getTextToInsert(), function1);
        return 1;
    }

    private final int performRemoveSpaceGesture(LegacyTextFieldState legacyTextFieldState, RemoveSpaceGesture removeSpaceGesture, AnnotatedString annotatedString, ViewConfiguration viewConfiguration, Function1<? super EditCommand, Unit> function1) {
        TextLayoutResultProxy layoutResult = legacyTextFieldState.getLayoutResult();
        long r0 = HandwritingGesture_androidKt.m1373getRangeForRemoveSpaceGesture5iVPX68(layoutResult != null ? layoutResult.getValue() : null, HandwritingGesture_androidKt.toOffset(removeSpaceGesture.getStartPoint()), HandwritingGesture_androidKt.toOffset(removeSpaceGesture.getEndPoint()), legacyTextFieldState.getLayoutCoordinates(), viewConfiguration);
        if (TextRange.m6558getCollapsedimpl(r0)) {
            return INSTANCE.fallbackOnLegacyTextField((HandwritingGesture) removeSpaceGesture, function1);
        }
        Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = -1;
        Ref.IntRef intRef2 = new Ref.IntRef();
        intRef2.element = -1;
        String replace = new Regex("\\s+").replace((CharSequence) TextRangeKt.m6571substringFDrldGo(annotatedString, r0), (Function1<? super MatchResult, ? extends CharSequence>) new HandwritingGestureApi34$performRemoveSpaceGesture$newText$2(intRef, intRef2));
        if (intRef.element == -1 || intRef2.element == -1) {
            return fallbackOnLegacyTextField((HandwritingGesture) removeSpaceGesture, function1);
        }
        int r10 = TextRange.m6564getStartimpl(r0) + intRef.element;
        int r12 = TextRange.m6564getStartimpl(r0) + intRef2.element;
        String substring = replace.substring(intRef.element, replace.length() - (TextRange.m6560getLengthimpl(r0) - intRef2.element));
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        function1.invoke(HandwritingGesture_androidKt.compoundEditCommand(new SetSelectionCommand(r10, r12), new CommitTextCommand(substring, 1)));
        return 1;
    }

    private final void performInsertionOnLegacyTextField(int i, String str, Function1<? super EditCommand, Unit> function1) {
        function1.invoke(HandwritingGesture_androidKt.compoundEditCommand(new SetSelectionCommand(i, i), new CommitTextCommand(str, 1)));
    }

    /* renamed from: performSelectionOnLegacyTextField-8ffj60Q  reason: not valid java name */
    private final void m1357performSelectionOnLegacyTextField8ffj60Q(long j, TextFieldSelectionManager textFieldSelectionManager, Function1<? super EditCommand, Unit> function1) {
        function1.invoke(new SetSelectionCommand(TextRange.m6564getStartimpl(j), TextRange.m6559getEndimpl(j)));
        if (textFieldSelectionManager != null) {
            textFieldSelectionManager.enterSelectionMode$foundation_release(true);
        }
    }

    /* renamed from: performDeletionOnLegacyTextField-vJH6DeI  reason: not valid java name */
    private final void m1356performDeletionOnLegacyTextFieldvJH6DeI(long j, AnnotatedString annotatedString, boolean z, Function1<? super EditCommand, Unit> function1) {
        if (z) {
            j = HandwritingGesture_androidKt.m1367adjustHandwritingDeleteGestureRange72CqOWE(j, annotatedString);
        }
        function1.invoke(HandwritingGesture_androidKt.compoundEditCommand(new SetSelectionCommand(TextRange.m6559getEndimpl(j), TextRange.m6559getEndimpl(j)), new DeleteSurroundingTextCommand(TextRange.m6560getLengthimpl(j), 0)));
    }

    private final int fallbackOnLegacyTextField(HandwritingGesture handwritingGesture, Function1<? super EditCommand, Unit> function1) {
        String fallbackText = handwritingGesture.getFallbackText();
        if (fallbackText == null) {
            return 3;
        }
        function1.invoke(new CommitTextCommand(fallbackText, 1));
        return 5;
    }

    /* renamed from: toTextGranularity-NUwxegE  reason: not valid java name */
    private final int m1358toTextGranularityNUwxegE(int i) {
        if (i == 1) {
            return TextGranularity.Companion.m6529getWordDRrd7Zo();
        }
        if (i != 2) {
            return TextGranularity.Companion.m6528getCharacterDRrd7Zo();
        }
        return TextGranularity.Companion.m6528getCharacterDRrd7Zo();
    }

    private final int fallback(TransformedTextFieldState transformedTextFieldState, HandwritingGesture handwritingGesture) {
        TextFieldState access$getTextFieldState$p = transformedTextFieldState.textFieldState;
        InputTransformation access$getInputTransformation$p = transformedTextFieldState.inputTransformation;
        TextFieldEditUndoBehavior textFieldEditUndoBehavior = TextFieldEditUndoBehavior.MergeIfPossible;
        access$getTextFieldState$p.getMainBuffer$foundation_release().getChangeTracker().clearChanges();
        access$getTextFieldState$p.getMainBuffer$foundation_release().clearHighlight();
        access$getTextFieldState$p.commitEditAsUser(access$getInputTransformation$p, true, textFieldEditUndoBehavior);
        String fallbackText = handwritingGesture.getFallbackText();
        if (fallbackText == null) {
            return 3;
        }
        TransformedTextFieldState.replaceSelectedText$default(transformedTextFieldState, fallbackText, true, (TextFieldEditUndoBehavior) null, 4, (Object) null);
        return 5;
    }

    /* access modifiers changed from: private */
    public static final void previewHandwritingGesture$lambda$1(TransformedTextFieldState transformedTextFieldState) {
        TextFieldState access$getTextFieldState$p = transformedTextFieldState.textFieldState;
        InputTransformation access$getInputTransformation$p = transformedTextFieldState.inputTransformation;
        TextFieldEditUndoBehavior textFieldEditUndoBehavior = TextFieldEditUndoBehavior.MergeIfPossible;
        access$getTextFieldState$p.getMainBuffer$foundation_release().getChangeTracker().clearChanges();
        access$getTextFieldState$p.getMainBuffer$foundation_release().clearHighlight();
        access$getTextFieldState$p.commitEditAsUser(access$getInputTransformation$p, true, textFieldEditUndoBehavior);
    }
}
