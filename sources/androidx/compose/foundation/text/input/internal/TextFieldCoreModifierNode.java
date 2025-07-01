package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.text.input.TextFieldCharSequence;
import androidx.compose.foundation.text.input.TextHighlightType;
import androidx.compose.foundation.text.input.internal.selection.AndroidTextFieldMagnifier_androidKt;
import androidx.compose.foundation.text.input.internal.selection.TextFieldMagnifierNode;
import androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState;
import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.GlobalPositionAwareModifierNode;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.node.LayoutModifierNodeKt;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextPainter;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedRange;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000Ô\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006BM\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\b\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\u0006\u0010\u0015\u001a\u00020\u0016¢\u0006\u0002\u0010\u0017J\"\u0010'\u001a\u00020!2\u0006\u0010(\u001a\u00020\u001f2\u0006\u0010)\u001a\u00020!H\u0002ø\u0001\u0000¢\u0006\u0004\b*\u0010+J\b\u0010,\u001a\u00020-H\u0016J\u0010\u0010.\u001a\u00020-2\u0006\u0010/\u001a\u000200H\u0016J\b\u00101\u001a\u00020-H\u0002JN\u00102\u001a\u00020-2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016J\f\u00103\u001a\u00020-*\u000204H\u0016J\f\u00105\u001a\u00020-*\u000206H\u0016J\f\u00107\u001a\u00020-*\u000208H\u0002J(\u00109\u001a\u00020-*\u0002082\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020\u001f0;2\u0006\u0010=\u001a\u00020>H\u0002J&\u0010?\u001a\u00020-*\u0002082\u0006\u0010@\u001a\u00020\u001f2\u0006\u0010=\u001a\u00020>H\u0002ø\u0001\u0000¢\u0006\u0004\bA\u0010BJ\u0014\u0010C\u001a\u00020-*\u0002082\u0006\u0010=\u001a\u00020>H\u0002J&\u0010D\u001a\u00020E*\u00020F2\u0006\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020JH\u0016ø\u0001\u0000¢\u0006\u0004\bK\u0010LJ&\u0010M\u001a\u00020E*\u00020F2\u0006\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020JH\u0002ø\u0001\u0000¢\u0006\u0004\bN\u0010LJ&\u0010O\u001a\u00020E*\u00020F2\u0006\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020JH\u0002ø\u0001\u0000¢\u0006\u0004\bP\u0010LJ6\u0010Q\u001a\u00020-*\u00020R2\u0006\u0010S\u001a\u00020!2\u0006\u0010T\u001a\u00020!2\u0006\u0010(\u001a\u00020\u001f2\u0006\u0010U\u001a\u00020VH\u0002ø\u0001\u0000¢\u0006\u0004\bW\u0010XR\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\"\u001a\u00020\b8BX\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R\u000e\u0010%\u001a\u00020&X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006Y"}, d2 = {"Landroidx/compose/foundation/text/input/internal/TextFieldCoreModifierNode;", "Landroidx/compose/ui/node/DelegatingNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/node/DrawModifierNode;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "Landroidx/compose/ui/node/GlobalPositionAwareModifierNode;", "Landroidx/compose/ui/node/SemanticsModifierNode;", "isFocused", "", "isDragHovered", "textLayoutState", "Landroidx/compose/foundation/text/input/internal/TextLayoutState;", "textFieldState", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "textFieldSelectionState", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;", "cursorBrush", "Landroidx/compose/ui/graphics/Brush;", "writeable", "scrollState", "Landroidx/compose/foundation/ScrollState;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "(ZZLandroidx/compose/foundation/text/input/internal/TextLayoutState;Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;Landroidx/compose/ui/graphics/Brush;ZLandroidx/compose/foundation/ScrollState;Landroidx/compose/foundation/gestures/Orientation;)V", "changeObserverJob", "Lkotlinx/coroutines/Job;", "cursorAnimation", "Landroidx/compose/foundation/text/input/internal/CursorAnimationState;", "previousCursorRect", "Landroidx/compose/ui/geometry/Rect;", "previousSelection", "Landroidx/compose/ui/text/TextRange;", "previousTextLayoutSize", "", "showCursor", "getShowCursor", "()Z", "textFieldMagnifierNode", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldMagnifierNode;", "calculateOffsetToFollow", "currSelection", "currTextLayoutSize", "calculateOffsetToFollow-72CqOWE", "(JI)I", "onAttach", "", "onGloballyPositioned", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "startCursorJob", "updateNode", "applySemantics", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "draw", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "drawCursor", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "drawHighlight", "highlight", "Lkotlin/Pair;", "Landroidx/compose/foundation/text/input/TextHighlightType;", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "drawSelection", "selection", "drawSelection-Sb-Bc2M", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JLandroidx/compose/ui/text/TextLayoutResult;)V", "drawText", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "measureHorizontalScroll", "measureHorizontalScroll-3p2s80s", "measureVerticalScroll", "measureVerticalScroll-3p2s80s", "updateScrollState", "Landroidx/compose/ui/unit/Density;", "containerSize", "textLayoutSize", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "updateScrollState-tIlFzwE", "(Landroidx/compose/ui/unit/Density;IIJLandroidx/compose/ui/unit/LayoutDirection;)V", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldCoreModifier.kt */
public final class TextFieldCoreModifierNode extends DelegatingNode implements LayoutModifierNode, DrawModifierNode, CompositionLocalConsumerModifierNode, GlobalPositionAwareModifierNode, SemanticsModifierNode {
    public static final int $stable = 8;
    private Job changeObserverJob;
    /* access modifiers changed from: private */
    public final CursorAnimationState cursorAnimation = new CursorAnimationState();
    private Brush cursorBrush;
    private boolean isDragHovered;
    private boolean isFocused;
    private Orientation orientation;
    private Rect previousCursorRect = new Rect(-1.0f, -1.0f, -1.0f, -1.0f);
    private TextRange previousSelection;
    private int previousTextLayoutSize;
    /* access modifiers changed from: private */
    public ScrollState scrollState;
    private final TextFieldMagnifierNode textFieldMagnifierNode;
    private TextFieldSelectionState textFieldSelectionState;
    /* access modifiers changed from: private */
    public TransformedTextFieldState textFieldState;
    /* access modifiers changed from: private */
    public TextLayoutState textLayoutState;
    private boolean writeable;

    public TextFieldCoreModifierNode(boolean z, boolean z2, TextLayoutState textLayoutState2, TransformedTextFieldState transformedTextFieldState, TextFieldSelectionState textFieldSelectionState2, Brush brush, boolean z3, ScrollState scrollState2, Orientation orientation2) {
        this.isFocused = z;
        this.isDragHovered = z2;
        this.textLayoutState = textLayoutState2;
        this.textFieldState = transformedTextFieldState;
        this.textFieldSelectionState = textFieldSelectionState2;
        this.cursorBrush = brush;
        this.writeable = z3;
        this.scrollState = scrollState2;
        this.orientation = orientation2;
        this.textFieldMagnifierNode = (TextFieldMagnifierNode) delegate(AndroidTextFieldMagnifier_androidKt.textFieldMagnifierNode(this.textFieldState, this.textFieldSelectionState, this.textLayoutState, this.isFocused || this.isDragHovered));
    }

    private final boolean getShowCursor() {
        if (this.writeable) {
            return (this.isFocused || this.isDragHovered) && TextFieldCoreModifierKt.isSpecified(this.cursorBrush);
        }
        return false;
    }

    public void onAttach() {
        if (this.isFocused && getShowCursor()) {
            startCursorJob();
        }
    }

    public final void updateNode(boolean z, boolean z2, TextLayoutState textLayoutState2, TransformedTextFieldState transformedTextFieldState, TextFieldSelectionState textFieldSelectionState2, Brush brush, boolean z3, ScrollState scrollState2, Orientation orientation2) {
        boolean showCursor = getShowCursor();
        boolean z4 = this.isFocused;
        TransformedTextFieldState transformedTextFieldState2 = this.textFieldState;
        TextLayoutState textLayoutState3 = this.textLayoutState;
        TextFieldSelectionState textFieldSelectionState3 = this.textFieldSelectionState;
        ScrollState scrollState3 = this.scrollState;
        this.isFocused = z;
        this.isDragHovered = z2;
        this.textLayoutState = textLayoutState2;
        this.textFieldState = transformedTextFieldState;
        this.textFieldSelectionState = textFieldSelectionState2;
        this.cursorBrush = brush;
        this.writeable = z3;
        this.scrollState = scrollState2;
        this.orientation = orientation2;
        this.textFieldMagnifierNode.update(transformedTextFieldState, textFieldSelectionState2, textLayoutState2, z || z2);
        if (!getShowCursor()) {
            Job job = this.changeObserverJob;
            if (job != null) {
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            this.changeObserverJob = null;
            this.cursorAnimation.cancelAndHide();
        } else if (!z4 || !Intrinsics.areEqual((Object) transformedTextFieldState2, (Object) transformedTextFieldState) || !showCursor) {
            startCursorJob();
        }
        if (!Intrinsics.areEqual((Object) transformedTextFieldState2, (Object) transformedTextFieldState) || !Intrinsics.areEqual((Object) textLayoutState3, (Object) textLayoutState2) || !Intrinsics.areEqual((Object) textFieldSelectionState3, (Object) textFieldSelectionState2) || !Intrinsics.areEqual((Object) scrollState3, (Object) scrollState2)) {
            LayoutModifierNodeKt.invalidateMeasurement(this);
        }
    }

    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public MeasureResult m1407measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        if (this.orientation == Orientation.Vertical) {
            return m1405measureVerticalScroll3p2s80s(measureScope, measurable, j);
        }
        return m1404measureHorizontalScroll3p2s80s(measureScope, measurable, j);
    }

    public void draw(ContentDrawScope contentDrawScope) {
        contentDrawScope.drawContent();
        TextFieldCharSequence visualText = this.textFieldState.getVisualText();
        TextLayoutResult layoutResult = this.textLayoutState.getLayoutResult();
        if (layoutResult != null) {
            Pair<TextHighlightType, TextRange> highlight = visualText.getHighlight();
            if (highlight != null) {
                drawHighlight(contentDrawScope, highlight, layoutResult);
            }
            if (TextRange.m6558getCollapsedimpl(visualText.m1312getSelectiond9O1mEE())) {
                DrawScope drawScope = contentDrawScope;
                drawText(drawScope, layoutResult);
                if (visualText.shouldShowSelection()) {
                    drawCursor(drawScope);
                }
            } else {
                if (visualText.shouldShowSelection()) {
                    m1403drawSelectionSbBc2M(contentDrawScope, visualText.m1312getSelectiond9O1mEE(), layoutResult);
                }
                drawText(contentDrawScope, layoutResult);
            }
            this.textFieldMagnifierNode.draw(contentDrawScope);
        }
    }

    /* renamed from: measureVerticalScroll-3p2s80s  reason: not valid java name */
    private final MeasureResult m1405measureVerticalScroll3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        long j2 = j;
        Placeable r10 = measurable.m5848measureBRTryo0(Constraints.m7043copyZbe2FdA$default(j2, 0, 0, 0, Integer.MAX_VALUE, 7, (Object) null));
        int min = Math.min(r10.getHeight(), Constraints.m7051getMaxHeightimpl(j2));
        return MeasureScope.layout$default(measureScope, r10.getWidth(), min, (Map) null, new TextFieldCoreModifierNode$measureVerticalScroll$1(this, measureScope, min, r10), 4, (Object) null);
    }

    /* renamed from: measureHorizontalScroll-3p2s80s  reason: not valid java name */
    private final MeasureResult m1404measureHorizontalScroll3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        long j2 = j;
        Placeable r10 = measurable.m5848measureBRTryo0(Constraints.m7043copyZbe2FdA$default(j2, 0, Integer.MAX_VALUE, 0, 0, 13, (Object) null));
        int min = Math.min(r10.getWidth(), Constraints.m7052getMaxWidthimpl(j2));
        return MeasureScope.layout$default(measureScope, min, r10.getHeight(), (Map) null, new TextFieldCoreModifierNode$measureHorizontalScroll$1(this, measureScope, min, r10), 4, (Object) null);
    }

    /* renamed from: calculateOffsetToFollow-72CqOWE  reason: not valid java name */
    private final int m1402calculateOffsetToFollow72CqOWE(long j, int i) {
        TextRange textRange = this.previousSelection;
        if (textRange == null || TextRange.m6559getEndimpl(j) != TextRange.m6559getEndimpl(textRange.m6568unboximpl())) {
            return TextRange.m6559getEndimpl(j);
        }
        TextRange textRange2 = this.previousSelection;
        if (textRange2 == null || TextRange.m6564getStartimpl(j) != TextRange.m6564getStartimpl(textRange2.m6568unboximpl())) {
            return TextRange.m6564getStartimpl(j);
        }
        if (i != this.previousTextLayoutSize) {
            return TextRange.m6564getStartimpl(j);
        }
        return -1;
    }

    /* access modifiers changed from: private */
    /* renamed from: updateScrollState-tIlFzwE  reason: not valid java name */
    public final void m1406updateScrollStatetIlFzwE(Density density, int i, int i2, long j, LayoutDirection layoutDirection) {
        TextLayoutResult layoutResult;
        float f;
        int i3;
        this.scrollState.setMaxValue$foundation_release(i2 - i);
        int r0 = m1402calculateOffsetToFollow72CqOWE(j, i2);
        if (r0 >= 0 && getShowCursor() && (layoutResult = this.textLayoutState.getLayoutResult()) != null) {
            boolean z = false;
            Rect cursorRect = layoutResult.getCursorRect(RangesKt.coerceIn(r0, (ClosedRange<Integer>) new IntRange(0, layoutResult.getLayoutInput().getText().length())));
            Rect access$getCursorRectInScroller = TextFieldCoreModifierKt.getCursorRectInScroller(density, cursorRect, layoutDirection == LayoutDirection.Rtl, i2);
            if (access$getCursorRectInScroller.getLeft() != this.previousCursorRect.getLeft() || access$getCursorRectInScroller.getTop() != this.previousCursorRect.getTop() || i2 != this.previousTextLayoutSize) {
                if (this.orientation == Orientation.Vertical) {
                    z = true;
                }
                float top = z ? access$getCursorRectInScroller.getTop() : access$getCursorRectInScroller.getLeft();
                float bottom = z ? access$getCursorRectInScroller.getBottom() : access$getCursorRectInScroller.getRight();
                int value = this.scrollState.getValue();
                float f2 = (float) (value + i);
                float f3 = (bottom <= f2 && (top >= f || bottom - top <= ((float) i))) ? (i3 >= 0 || bottom - top > ((float) i)) ? 0.0f : top - (f = (float) value) : bottom - f2;
                this.previousSelection = TextRange.m6552boximpl(j);
                this.previousCursorRect = access$getCursorRectInScroller;
                this.previousTextLayoutSize = i2;
                Job unused = BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), (CoroutineContext) null, CoroutineStart.UNDISPATCHED, new TextFieldCoreModifierNode$updateScrollState$1(this, f3, cursorRect, (Continuation<? super TextFieldCoreModifierNode$updateScrollState$1>) null), 1, (Object) null);
            }
        }
    }

    /* renamed from: drawSelection-Sb-Bc2M  reason: not valid java name */
    private final void m1403drawSelectionSbBc2M(DrawScope drawScope, long j, TextLayoutResult textLayoutResult) {
        int r0 = TextRange.m6562getMinimpl(j);
        int r13 = TextRange.m6561getMaximpl(j);
        if (r0 != r13) {
            DrawScope drawScope2 = drawScope;
            DrawScope.m4836drawPathLG529CI$default(drawScope2, textLayoutResult.getPathForRange(r0, r13), ((TextSelectionColors) CompositionLocalConsumerModifierNodeKt.currentValueOf(this, TextSelectionColorsKt.getLocalTextSelectionColors())).m1672getBackgroundColor0d7_KjU(), 0.0f, (DrawStyle) null, (ColorFilter) null, 0, 60, (Object) null);
        }
    }

    private final void drawHighlight(DrawScope drawScope, Pair<TextHighlightType, TextRange> pair, TextLayoutResult textLayoutResult) {
        int r0 = pair.component1().m1323unboximpl();
        long r1 = pair.component2().m6568unboximpl();
        if (!TextRange.m6558getCollapsedimpl(r1)) {
            Path pathForRange = textLayoutResult.getPathForRange(TextRange.m6562getMinimpl(r1), TextRange.m6561getMaximpl(r1));
            if (TextHighlightType.m1320equalsimpl0(r0, TextHighlightType.Companion.m1324getHandwritingDeletePreviewsxJuwY())) {
                Brush brush = textLayoutResult.getLayoutInput().getStyle().getBrush();
                if (brush != null) {
                    DrawScope.m4835drawPathGBMwjPU$default(drawScope, pathForRange, brush, 0.2f, (DrawStyle) null, (ColorFilter) null, 0, 56, (Object) null);
                    return;
                }
                DrawScope drawScope2 = drawScope;
                long r13 = textLayoutResult.getLayoutInput().getStyle().m6594getColor0d7_KjU();
                if (r13 == 16) {
                    r13 = Color.Companion.m4265getBlack0d7_KjU();
                }
                long j = r13;
                DrawScope.m4836drawPathLG529CI$default(drawScope2, pathForRange, Color.m4238copywmQWz5c$default(j, Color.m4241getAlphaimpl(j) * 0.2f, 0.0f, 0.0f, 0.0f, 14, (Object) null), 0.0f, (DrawStyle) null, (ColorFilter) null, 0, 60, (Object) null);
                return;
            }
            DrawScope.m4836drawPathLG529CI$default(drawScope, pathForRange, ((TextSelectionColors) CompositionLocalConsumerModifierNodeKt.currentValueOf(this, TextSelectionColorsKt.getLocalTextSelectionColors())).m1672getBackgroundColor0d7_KjU(), 0.0f, (DrawStyle) null, (ColorFilter) null, 0, 60, (Object) null);
        }
    }

    private final void drawCursor(DrawScope drawScope) {
        float cursorAlpha = this.cursorAnimation.getCursorAlpha();
        if (cursorAlpha != 0.0f && getShowCursor()) {
            Rect cursorRect = this.textFieldSelectionState.getCursorRect();
            DrawScope.m4831drawLine1RTmtNc$default(drawScope, this.cursorBrush, cursorRect.m4021getTopCenterF1C5BW0(), cursorRect.m4014getBottomCenterF1C5BW0(), cursorRect.getWidth(), 0, (PathEffect) null, cursorAlpha, (ColorFilter) null, 0, 432, (Object) null);
        }
    }

    private final void startCursorJob() {
        this.changeObserverJob = BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), (CoroutineContext) null, (CoroutineStart) null, new TextFieldCoreModifierNode$startCursorJob$1(this, (Continuation<? super TextFieldCoreModifierNode$startCursorJob$1>) null), 3, (Object) null);
    }

    public void onGloballyPositioned(LayoutCoordinates layoutCoordinates) {
        this.textLayoutState.setCoreNodeCoordinates(layoutCoordinates);
        this.textFieldMagnifierNode.onGloballyPositioned(layoutCoordinates);
    }

    public void applySemantics(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        this.textFieldMagnifierNode.applySemantics(semanticsPropertyReceiver);
    }

    private final void drawText(DrawScope drawScope, TextLayoutResult textLayoutResult) {
        TextPainter.INSTANCE.paint(drawScope.getDrawContext().getCanvas(), textLayoutResult);
    }
}
