package androidx.compose.foundation.text.input.internal;

import android.graphics.Matrix;
import android.os.Build;
import android.view.inputmethod.CursorAnchorInfo;
import androidx.compose.foundation.text.input.TextFieldCharSequence;
import androidx.compose.foundation.text.selection.SelectionManagerKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.AndroidMatrixConversions_androidKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.text.TextLayoutResult;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\n\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0002J8\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0010H\u0002J\u000e\u0010\u001d\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\"J\b\u0010#\u001a\u00020\u001eH\u0002R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\u00020\u0016X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006$"}, d2 = {"Landroidx/compose/foundation/text/input/internal/CursorAnchorInfoController;", "", "textFieldState", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "textLayoutState", "Landroidx/compose/foundation/text/input/internal/TextLayoutState;", "composeImm", "Landroidx/compose/foundation/text/input/internal/ComposeInputMethodManager;", "monitorScope", "Lkotlinx/coroutines/CoroutineScope;", "(Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;Landroidx/compose/foundation/text/input/internal/TextLayoutState;Landroidx/compose/foundation/text/input/internal/ComposeInputMethodManager;Lkotlinx/coroutines/CoroutineScope;)V", "androidMatrix", "Landroid/graphics/Matrix;", "builder", "Landroid/view/inputmethod/CursorAnchorInfo$Builder;", "hasPendingImmediateRequest", "", "includeCharacterBounds", "includeEditorBounds", "includeInsertionMarker", "includeLineBounds", "matrix", "Landroidx/compose/ui/graphics/Matrix;", "[F", "monitorEnabled", "monitorJob", "Lkotlinx/coroutines/Job;", "calculateCursorAnchorInfo", "Landroid/view/inputmethod/CursorAnchorInfo;", "requestUpdates", "", "immediate", "monitor", "cursorUpdateMode", "", "startOrStopMonitoring", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: CursorAnchorInfoController.android.kt */
public final class CursorAnchorInfoController {
    public static final int $stable = 8;
    private final Matrix androidMatrix = new Matrix();
    private final CursorAnchorInfo.Builder builder = new CursorAnchorInfo.Builder();
    /* access modifiers changed from: private */
    public final ComposeInputMethodManager composeImm;
    private boolean hasPendingImmediateRequest;
    private boolean includeCharacterBounds;
    private boolean includeEditorBounds;
    private boolean includeInsertionMarker;
    private boolean includeLineBounds;
    private final float[] matrix = androidx.compose.ui.graphics.Matrix.m4474constructorimpl$default((float[]) null, 1, (DefaultConstructorMarker) null);
    private boolean monitorEnabled;
    private Job monitorJob;
    private final CoroutineScope monitorScope;
    private final TransformedTextFieldState textFieldState;
    private final TextLayoutState textLayoutState;

    public CursorAnchorInfoController(TransformedTextFieldState transformedTextFieldState, TextLayoutState textLayoutState2, ComposeInputMethodManager composeInputMethodManager, CoroutineScope coroutineScope) {
        this.textFieldState = transformedTextFieldState;
        this.textLayoutState = textLayoutState2;
        this.composeImm = composeInputMethodManager;
        this.monitorScope = coroutineScope;
    }

    public final void requestUpdates(int i) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        CursorAnchorInfoController cursorAnchorInfoController;
        boolean z5 = false;
        boolean z6 = (i & 1) != 0;
        boolean z7 = (i & 2) != 0;
        if (Build.VERSION.SDK_INT >= 33) {
            boolean z8 = (i & 16) != 0;
            boolean z9 = (i & 8) != 0;
            boolean z10 = (i & 4) != 0;
            if (Build.VERSION.SDK_INT >= 34 && (i & 32) != 0) {
                z5 = true;
            }
            if (z8 || z9 || z10 || z5) {
                z = z5;
                z3 = z9;
                z2 = z10;
                cursorAnchorInfoController = this;
                z4 = z8;
            } else {
                cursorAnchorInfoController = this;
                if (Build.VERSION.SDK_INT >= 34) {
                    z4 = true;
                    z3 = true;
                    z2 = true;
                    z = true;
                } else {
                    z = z5;
                    z4 = true;
                    z3 = true;
                    z2 = true;
                }
            }
        } else {
            cursorAnchorInfoController = this;
            z2 = false;
            z = false;
            z4 = true;
            z3 = true;
        }
        cursorAnchorInfoController.requestUpdates(z6, z7, z4, z3, z2, z);
    }

    private final void requestUpdates(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        this.includeInsertionMarker = z3;
        this.includeCharacterBounds = z4;
        this.includeEditorBounds = z5;
        this.includeLineBounds = z6;
        if (z) {
            this.hasPendingImmediateRequest = true;
            CursorAnchorInfo calculateCursorAnchorInfo = calculateCursorAnchorInfo();
            if (calculateCursorAnchorInfo != null) {
                this.composeImm.updateCursorAnchorInfo(calculateCursorAnchorInfo);
            }
        }
        this.monitorEnabled = z2;
        startOrStopMonitoring();
    }

    private final void startOrStopMonitoring() {
        if (this.monitorEnabled) {
            Job job = this.monitorJob;
            if (job == null || !job.isActive()) {
                this.monitorJob = BuildersKt__Builders_commonKt.launch$default(this.monitorScope, (CoroutineContext) null, CoroutineStart.UNDISPATCHED, new CursorAnchorInfoController$startOrStopMonitoring$1(this, (Continuation<? super CursorAnchorInfoController$startOrStopMonitoring$1>) null), 1, (Object) null);
                return;
            }
            return;
        }
        Job job2 = this.monitorJob;
        if (job2 != null) {
            Job.DefaultImpls.cancel$default(job2, (CancellationException) null, 1, (Object) null);
        }
        this.monitorJob = null;
    }

    /* access modifiers changed from: private */
    public final CursorAnchorInfo calculateCursorAnchorInfo() {
        LayoutCoordinates coreNodeCoordinates;
        LayoutCoordinates decoratorNodeCoordinates;
        TextLayoutResult layoutResult;
        LayoutCoordinates textLayoutNodeCoordinates = this.textLayoutState.getTextLayoutNodeCoordinates();
        if (textLayoutNodeCoordinates != null) {
            if (!textLayoutNodeCoordinates.isAttached()) {
                textLayoutNodeCoordinates = null;
            }
            if (!(textLayoutNodeCoordinates == null || (coreNodeCoordinates = this.textLayoutState.getCoreNodeCoordinates()) == null)) {
                if (!coreNodeCoordinates.isAttached()) {
                    coreNodeCoordinates = null;
                }
                if (!(coreNodeCoordinates == null || (decoratorNodeCoordinates = this.textLayoutState.getDecoratorNodeCoordinates()) == null)) {
                    if (!decoratorNodeCoordinates.isAttached()) {
                        decoratorNodeCoordinates = null;
                    }
                    if (decoratorNodeCoordinates == null || (layoutResult = this.textLayoutState.getLayoutResult()) == null) {
                        return null;
                    }
                    TextFieldCharSequence visualText = this.textFieldState.getVisualText();
                    androidx.compose.ui.graphics.Matrix.m4483resetimpl(this.matrix);
                    textLayoutNodeCoordinates.m5808transformToScreen58bKbWc(this.matrix);
                    AndroidMatrixConversions_androidKt.m4098setFromEL8BTi8(this.androidMatrix, this.matrix);
                    return CursorAnchorInfoBuilder_androidKt.m1345buildvxqZcH0(this.builder, visualText, visualText.m1312getSelectiond9O1mEE(), visualText.m1311getCompositionMzsxiRA(), layoutResult, this.androidMatrix, SelectionManagerKt.visibleBounds(coreNodeCoordinates).m4024translatek4lQ0M(textLayoutNodeCoordinates.m5801localPositionOfR5De75A(coreNodeCoordinates, Offset.Companion.m4003getZeroF1C5BW0())), SelectionManagerKt.visibleBounds(decoratorNodeCoordinates).m4024translatek4lQ0M(textLayoutNodeCoordinates.m5801localPositionOfR5De75A(decoratorNodeCoordinates, Offset.Companion.m4003getZeroF1C5BW0())), this.includeInsertionMarker, this.includeCharacterBounds, this.includeEditorBounds, this.includeLineBounds);
                }
            }
        }
        return null;
    }
}
