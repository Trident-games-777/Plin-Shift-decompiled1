package androidx.compose.foundation.text;

import androidx.compose.foundation.text.selection.SelectionManagerKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.PlatformSpanStyle;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextPainter;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.input.EditCommand;
import androidx.compose.ui.text.input.EditProcessor;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.ImeOptions;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.TextInputService;
import androidx.compose.ui.text.input.TextInputSession;
import androidx.compose.ui.text.input.TransformedText;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Landroidx/compose/foundation/text/TextFieldDelegate;", "", "()V", "Companion", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldDelegate.kt */
public final class TextFieldDelegate {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @JvmStatic
    /* renamed from: draw-Q1vqE60$foundation_release  reason: not valid java name */
    public static final void m1259drawQ1vqE60$foundation_release(Canvas canvas, TextFieldValue textFieldValue, long j, long j2, OffsetMapping offsetMapping, TextLayoutResult textLayoutResult, Paint paint, long j3) {
        Companion.m1265drawQ1vqE60$foundation_release(canvas, textFieldValue, j, j2, offsetMapping, textLayoutResult, paint, j3);
    }

    @JvmStatic
    /* renamed from: layout-_EkL_-Y$foundation_release  reason: not valid java name */
    public static final Triple<Integer, Integer, TextLayoutResult> m1260layout_EkL_Y$foundation_release(TextDelegate textDelegate, long j, LayoutDirection layoutDirection, TextLayoutResult textLayoutResult) {
        return Companion.m1266layout_EkL_Y$foundation_release(textDelegate, j, layoutDirection, textLayoutResult);
    }

    @JvmStatic
    public static final void notifyFocusedRect$foundation_release(TextFieldValue textFieldValue, TextDelegate textDelegate, TextLayoutResult textLayoutResult, LayoutCoordinates layoutCoordinates, TextInputSession textInputSession, boolean z, OffsetMapping offsetMapping) {
        Companion.notifyFocusedRect$foundation_release(textFieldValue, textDelegate, textLayoutResult, layoutCoordinates, textInputSession, z, offsetMapping);
    }

    @JvmStatic
    public static final void onBlur$foundation_release(TextInputSession textInputSession, EditProcessor editProcessor, Function1<? super TextFieldValue, Unit> function1) {
        Companion.onBlur$foundation_release(textInputSession, editProcessor, function1);
    }

    @JvmStatic
    public static final void onEditCommand$foundation_release(List<? extends EditCommand> list, EditProcessor editProcessor, Function1<? super TextFieldValue, Unit> function1, TextInputSession textInputSession) {
        Companion.onEditCommand$foundation_release(list, editProcessor, function1, textInputSession);
    }

    @JvmStatic
    public static final TextInputSession onFocus$foundation_release(TextInputService textInputService, TextFieldValue textFieldValue, EditProcessor editProcessor, ImeOptions imeOptions, Function1<? super TextFieldValue, Unit> function1, Function1<? super ImeAction, Unit> function12) {
        return Companion.onFocus$foundation_release(textInputService, textFieldValue, editProcessor, imeOptions, function1, function12);
    }

    @JvmStatic
    public static final TextInputSession restartInput$foundation_release(TextInputService textInputService, TextFieldValue textFieldValue, EditProcessor editProcessor, ImeOptions imeOptions, Function1<? super TextFieldValue, Unit> function1, Function1<? super ImeAction, Unit> function12) {
        return Companion.restartInput$foundation_release(textInputService, textFieldValue, editProcessor, imeOptions, function1, function12);
    }

    @JvmStatic
    /* renamed from: setCursorOffset-ULxng0E$foundation_release  reason: not valid java name */
    public static final void m1261setCursorOffsetULxng0E$foundation_release(long j, TextLayoutResultProxy textLayoutResultProxy, EditProcessor editProcessor, OffsetMapping offsetMapping, Function1<? super TextFieldValue, Unit> function1) {
        Companion.m1267setCursorOffsetULxng0E$foundation_release(j, textLayoutResultProxy, editProcessor, offsetMapping, function1);
    }

    @JvmStatic
    public static final void updateTextLayoutResult$foundation_release(TextInputSession textInputSession, TextFieldValue textFieldValue, OffsetMapping offsetMapping, TextLayoutResultProxy textLayoutResultProxy) {
        Companion.updateTextLayoutResult$foundation_release(textInputSession, textFieldValue, offsetMapping, textLayoutResultProxy);
    }

    @Metadata(d1 = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004ø\u0001\u0000¢\u0006\u0004\b\b\u0010\tJR\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0001ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ:\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u0017H\u0002ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 JH\u0010!\u001a\u0014\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u00150\"2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0015H\u0001ø\u0001\u0000¢\u0006\u0004\b+\u0010,JE\u0010-\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020%2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u0002032\u0006\u0010\u0012\u001a\u00020\u0013H\u0001¢\u0006\u0002\b4J1\u00105\u001a\u00020\u000b2\u0006\u00100\u001a\u0002012\u0006\u00106\u001a\u0002072\u0012\u00108\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000b09H\u0001¢\u0006\u0002\b:JA\u0010;\u001a\u00020\u000b2\f\u0010<\u001a\b\u0012\u0004\u0012\u00020>0=2\u0006\u00106\u001a\u0002072\u0012\u00108\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000b092\b\u0010?\u001a\u0004\u0018\u000101H\u0001¢\u0006\u0002\b@JU\u0010A\u001a\u0002012\u0006\u0010B\u001a\u00020C2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u00106\u001a\u0002072\u0006\u0010D\u001a\u00020E2\u0012\u00108\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000b092\u0012\u0010F\u001a\u000e\u0012\u0004\u0012\u00020G\u0012\u0004\u0012\u00020\u000b09H\u0001¢\u0006\u0002\bHJU\u0010I\u001a\u0002012\u0006\u0010B\u001a\u00020C2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u00106\u001a\u0002072\u0006\u0010D\u001a\u00020E2\u0012\u00108\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000b092\u0012\u0010F\u001a\u000e\u0012\u0004\u0012\u00020G\u0012\u0004\u0012\u00020\u000b09H\u0001¢\u0006\u0002\bJJF\u0010K\u001a\u00020\u000b2\u0006\u0010L\u001a\u00020M2\u0006\u0010\u0014\u001a\u00020N2\u0006\u00106\u001a\u0002072\u0006\u0010\u0012\u001a\u00020\u00132\u0012\u00108\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000b09H\u0001ø\u0001\u0000¢\u0006\u0004\bO\u0010PJ-\u0010Q\u001a\u00020\u000b2\u0006\u00100\u001a\u0002012\u0006\u0010R\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020NH\u0001¢\u0006\u0002\bS\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006T"}, d2 = {"Landroidx/compose/foundation/text/TextFieldDelegate$Companion;", "", "()V", "applyCompositionDecoration", "Landroidx/compose/ui/text/input/TransformedText;", "compositionRange", "Landroidx/compose/ui/text/TextRange;", "transformed", "applyCompositionDecoration-72CqOWE", "(JLandroidx/compose/ui/text/input/TransformedText;)Landroidx/compose/ui/text/input/TransformedText;", "draw", "", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "value", "Landroidx/compose/ui/text/input/TextFieldValue;", "selectionPreviewHighlightRange", "deletionPreviewHighlightRange", "offsetMapping", "Landroidx/compose/ui/text/input/OffsetMapping;", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "highlightPaint", "Landroidx/compose/ui/graphics/Paint;", "selectionBackgroundColor", "Landroidx/compose/ui/graphics/Color;", "draw-Q1vqE60$foundation_release", "(Landroidx/compose/ui/graphics/Canvas;Landroidx/compose/ui/text/input/TextFieldValue;JJLandroidx/compose/ui/text/input/OffsetMapping;Landroidx/compose/ui/text/TextLayoutResult;Landroidx/compose/ui/graphics/Paint;J)V", "drawHighlight", "range", "paint", "drawHighlight-Le-punE", "(Landroidx/compose/ui/graphics/Canvas;JLandroidx/compose/ui/text/input/OffsetMapping;Landroidx/compose/ui/text/TextLayoutResult;Landroidx/compose/ui/graphics/Paint;)V", "layout", "Lkotlin/Triple;", "", "textDelegate", "Landroidx/compose/foundation/text/TextDelegate;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "prevResultText", "layout-_EkL_-Y$foundation_release", "(Landroidx/compose/foundation/text/TextDelegate;JLandroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/text/TextLayoutResult;)Lkotlin/Triple;", "notifyFocusedRect", "layoutCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "textInputSession", "Landroidx/compose/ui/text/input/TextInputSession;", "hasFocus", "", "notifyFocusedRect$foundation_release", "onBlur", "editProcessor", "Landroidx/compose/ui/text/input/EditProcessor;", "onValueChange", "Lkotlin/Function1;", "onBlur$foundation_release", "onEditCommand", "ops", "", "Landroidx/compose/ui/text/input/EditCommand;", "session", "onEditCommand$foundation_release", "onFocus", "textInputService", "Landroidx/compose/ui/text/input/TextInputService;", "imeOptions", "Landroidx/compose/ui/text/input/ImeOptions;", "onImeActionPerformed", "Landroidx/compose/ui/text/input/ImeAction;", "onFocus$foundation_release", "restartInput", "restartInput$foundation_release", "setCursorOffset", "position", "Landroidx/compose/ui/geometry/Offset;", "Landroidx/compose/foundation/text/TextLayoutResultProxy;", "setCursorOffset-ULxng0E$foundation_release", "(JLandroidx/compose/foundation/text/TextLayoutResultProxy;Landroidx/compose/ui/text/input/EditProcessor;Landroidx/compose/ui/text/input/OffsetMapping;Lkotlin/jvm/functions/Function1;)V", "updateTextLayoutResult", "textFieldValue", "updateTextLayoutResult$foundation_release", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: TextFieldDelegate.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: layout-_EkL_-Y$foundation_release$default  reason: not valid java name */
        public static /* synthetic */ Triple m1263layout_EkL_Y$foundation_release$default(Companion companion, TextDelegate textDelegate, long j, LayoutDirection layoutDirection, TextLayoutResult textLayoutResult, int i, Object obj) {
            if ((i & 8) != 0) {
                textLayoutResult = null;
            }
            return companion.m1266layout_EkL_Y$foundation_release(textDelegate, j, layoutDirection, textLayoutResult);
        }

        @JvmStatic
        /* renamed from: layout-_EkL_-Y$foundation_release  reason: not valid java name */
        public final Triple<Integer, Integer, TextLayoutResult> m1266layout_EkL_Y$foundation_release(TextDelegate textDelegate, long j, LayoutDirection layoutDirection, TextLayoutResult textLayoutResult) {
            TextLayoutResult r1 = textDelegate.m1253layoutNN6EwU(j, layoutDirection, textLayoutResult);
            return new Triple<>(Integer.valueOf(IntSize.m7283getWidthimpl(r1.m6537getSizeYbymL2g())), Integer.valueOf(IntSize.m7282getHeightimpl(r1.m6537getSizeYbymL2g())), r1);
        }

        @JvmStatic
        /* renamed from: draw-Q1vqE60$foundation_release  reason: not valid java name */
        public final void m1265drawQ1vqE60$foundation_release(Canvas canvas, TextFieldValue textFieldValue, long j, long j2, OffsetMapping offsetMapping, TextLayoutResult textLayoutResult, Paint paint, long j3) {
            long j4;
            if (!TextRange.m6558getCollapsedimpl(j)) {
                paint.m4510setColor8_81llA(j3);
                m1262drawHighlightLepunE(canvas, j, offsetMapping, textLayoutResult, paint);
            } else if (!TextRange.m6558getCollapsedimpl(j2)) {
                Color r10 = Color.m4229boximpl(textLayoutResult.getLayoutInput().getStyle().m6594getColor0d7_KjU());
                if (r10.m4249unboximpl() == 16) {
                    r10 = null;
                }
                if (r10 != null) {
                    j4 = r10.m4249unboximpl();
                } else {
                    j4 = Color.Companion.m4265getBlack0d7_KjU();
                }
                long j5 = j4;
                Paint paint2 = paint;
                paint2.m4510setColor8_81llA(Color.m4238copywmQWz5c$default(j5, Color.m4241getAlphaimpl(j5) * 0.2f, 0.0f, 0.0f, 0.0f, 14, (Object) null));
                m1262drawHighlightLepunE(canvas, j2, offsetMapping, textLayoutResult, paint2);
            } else if (!TextRange.m6558getCollapsedimpl(textFieldValue.m6823getSelectiond9O1mEE())) {
                paint.m4510setColor8_81llA(j3);
                m1262drawHighlightLepunE(canvas, textFieldValue.m6823getSelectiond9O1mEE(), offsetMapping, textLayoutResult, paint);
            }
            TextPainter.INSTANCE.paint(canvas, textLayoutResult);
        }

        /* renamed from: drawHighlight-Le-punE  reason: not valid java name */
        private final void m1262drawHighlightLepunE(Canvas canvas, long j, OffsetMapping offsetMapping, TextLayoutResult textLayoutResult, Paint paint) {
            int originalToTransformed = offsetMapping.originalToTransformed(TextRange.m6562getMinimpl(j));
            int originalToTransformed2 = offsetMapping.originalToTransformed(TextRange.m6561getMaximpl(j));
            if (originalToTransformed != originalToTransformed2) {
                canvas.drawPath(textLayoutResult.getPathForRange(originalToTransformed, originalToTransformed2), paint);
            }
        }

        @JvmStatic
        public final void notifyFocusedRect$foundation_release(TextFieldValue textFieldValue, TextDelegate textDelegate, TextLayoutResult textLayoutResult, LayoutCoordinates layoutCoordinates, TextInputSession textInputSession, boolean z, OffsetMapping offsetMapping) {
            Rect rect;
            if (z) {
                int originalToTransformed = offsetMapping.originalToTransformed(TextRange.m6561getMaximpl(textFieldValue.m6823getSelectiond9O1mEE()));
                if (originalToTransformed < textLayoutResult.getLayoutInput().getText().length()) {
                    rect = textLayoutResult.getBoundingBox(originalToTransformed);
                } else if (originalToTransformed != 0) {
                    rect = textLayoutResult.getBoundingBox(originalToTransformed - 1);
                } else {
                    rect = new Rect(0.0f, 0.0f, 1.0f, (float) IntSize.m7282getHeightimpl(TextFieldDelegateKt.computeSizeForDefaultText$default(textDelegate.getStyle(), textDelegate.getDensity(), textDelegate.getFontFamilyResolver(), (String) null, 0, 24, (Object) null)));
                }
                long r9 = layoutCoordinates.m5803localToRootMKHz9U(OffsetKt.Offset(rect.getLeft(), rect.getTop()));
                textInputSession.notifyFocusedRect(RectKt.m4027Recttz77jQw(OffsetKt.Offset(Offset.m3987getXimpl(r9), Offset.m3988getYimpl(r9)), SizeKt.Size(rect.getWidth(), rect.getHeight())));
            }
        }

        @JvmStatic
        public final void updateTextLayoutResult$foundation_release(TextInputSession textInputSession, TextFieldValue textFieldValue, OffsetMapping offsetMapping, TextLayoutResultProxy textLayoutResultProxy) {
            LayoutCoordinates decorationBoxCoordinates;
            LayoutCoordinates innerTextFieldCoordinates = textLayoutResultProxy.getInnerTextFieldCoordinates();
            if (innerTextFieldCoordinates != null && innerTextFieldCoordinates.isAttached() && (decorationBoxCoordinates = textLayoutResultProxy.getDecorationBoxCoordinates()) != null) {
                textInputSession.updateTextLayoutResult(textFieldValue, offsetMapping, textLayoutResultProxy.getValue(), new TextFieldDelegate$Companion$updateTextLayoutResult$1$1$1(innerTextFieldCoordinates), SelectionManagerKt.visibleBounds(innerTextFieldCoordinates), innerTextFieldCoordinates.localBoundingBoxOf(decorationBoxCoordinates, false));
            }
        }

        @JvmStatic
        public final void onEditCommand$foundation_release(List<? extends EditCommand> list, EditProcessor editProcessor, Function1<? super TextFieldValue, Unit> function1, TextInputSession textInputSession) {
            TextFieldValue apply = editProcessor.apply(list);
            if (textInputSession != null) {
                textInputSession.updateState((TextFieldValue) null, apply);
            }
            function1.invoke(apply);
        }

        @JvmStatic
        /* renamed from: setCursorOffset-ULxng0E$foundation_release  reason: not valid java name */
        public final void m1267setCursorOffsetULxng0E$foundation_release(long j, TextLayoutResultProxy textLayoutResultProxy, EditProcessor editProcessor, OffsetMapping offsetMapping, Function1<? super TextFieldValue, Unit> function1) {
            function1.invoke(TextFieldValue.m6818copy3r_uNRQ$default(editProcessor.toTextFieldValue(), (AnnotatedString) null, TextRangeKt.TextRange(offsetMapping.transformedToOriginal(TextLayoutResultProxy.m1288getOffsetForPosition3MmeM6k$default(textLayoutResultProxy, j, false, 2, (Object) null))), (TextRange) null, 5, (Object) null));
        }

        @JvmStatic
        public final TextInputSession restartInput$foundation_release(TextInputService textInputService, TextFieldValue textFieldValue, EditProcessor editProcessor, ImeOptions imeOptions, Function1<? super TextFieldValue, Unit> function1, Function1<? super ImeAction, Unit> function12) {
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = textInputService.startInput(textFieldValue, imeOptions, new TextFieldDelegate$Companion$restartInput$1(editProcessor, function1, objectRef), function12);
            return (TextInputSession) objectRef.element;
        }

        @JvmStatic
        public final TextInputSession onFocus$foundation_release(TextInputService textInputService, TextFieldValue textFieldValue, EditProcessor editProcessor, ImeOptions imeOptions, Function1<? super TextFieldValue, Unit> function1, Function1<? super ImeAction, Unit> function12) {
            return restartInput$foundation_release(textInputService, textFieldValue, editProcessor, imeOptions, function1, function12);
        }

        @JvmStatic
        public final void onBlur$foundation_release(TextInputSession textInputSession, EditProcessor editProcessor, Function1<? super TextFieldValue, Unit> function1) {
            function1.invoke(TextFieldValue.m6818copy3r_uNRQ$default(editProcessor.toTextFieldValue(), (AnnotatedString) null, 0, (TextRange) null, 3, (Object) null));
            textInputSession.dispose();
        }

        /* renamed from: applyCompositionDecoration-72CqOWE  reason: not valid java name */
        public final TransformedText m1264applyCompositionDecoration72CqOWE(long j, TransformedText transformedText) {
            int originalToTransformed = transformedText.getOffsetMapping().originalToTransformed(TextRange.m6564getStartimpl(j));
            int originalToTransformed2 = transformedText.getOffsetMapping().originalToTransformed(TextRange.m6559getEndimpl(j));
            int min = Math.min(originalToTransformed, originalToTransformed2);
            int max = Math.max(originalToTransformed, originalToTransformed2);
            AnnotatedString.Builder builder = new AnnotatedString.Builder(transformedText.getText());
            builder.addStyle(new SpanStyle(0, 0, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, TextDecoration.Companion.getUnderline(), (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 61439, (DefaultConstructorMarker) null), min, max);
            return new TransformedText(builder.toAnnotatedString(), transformedText.getOffsetMapping());
        }
    }
}
