package androidx.compose.foundation.text;

import androidx.compose.foundation.text.input.internal.CursorAnimationState;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldCursor.kt */
final class TextFieldCursorKt$cursor$1$2$1 extends Lambda implements Function1<ContentDrawScope, Unit> {
    final /* synthetic */ CursorAnimationState $cursorAnimation;
    final /* synthetic */ Brush $cursorBrush;
    final /* synthetic */ OffsetMapping $offsetMapping;
    final /* synthetic */ LegacyTextFieldState $state;
    final /* synthetic */ TextFieldValue $value;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextFieldCursorKt$cursor$1$2$1(CursorAnimationState cursorAnimationState, OffsetMapping offsetMapping, TextFieldValue textFieldValue, LegacyTextFieldState legacyTextFieldState, Brush brush) {
        super(1);
        this.$cursorAnimation = cursorAnimationState;
        this.$offsetMapping = offsetMapping;
        this.$value = textFieldValue;
        this.$state = legacyTextFieldState;
        this.$cursorBrush = brush;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ContentDrawScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(ContentDrawScope contentDrawScope) {
        Rect rect;
        TextLayoutResult value;
        ContentDrawScope contentDrawScope2 = contentDrawScope;
        contentDrawScope2.drawContent();
        float cursorAlpha = this.$cursorAnimation.getCursorAlpha();
        if (cursorAlpha != 0.0f) {
            int originalToTransformed = this.$offsetMapping.originalToTransformed(TextRange.m6564getStartimpl(this.$value.m6823getSelectiond9O1mEE()));
            TextLayoutResultProxy layoutResult = this.$state.getLayoutResult();
            if (layoutResult == null || (value = layoutResult.getValue()) == null || (rect = value.getCursorRect(originalToTransformed)) == null) {
                rect = new Rect(0.0f, 0.0f, 0.0f, 0.0f);
            }
            float r9 = contentDrawScope2.m7091toPx0680j_4(TextFieldCursorKt.getDefaultCursorThickness());
            float f = r9 / ((float) 2);
            float coerceAtLeast = RangesKt.coerceAtLeast(RangesKt.coerceAtMost(rect.getLeft() + f, Size.m4056getWidthimpl(contentDrawScope2.m4865getSizeNHjbRc()) - f), f);
            DrawScope.m4831drawLine1RTmtNc$default(contentDrawScope2, this.$cursorBrush, OffsetKt.Offset(coerceAtLeast, rect.getTop()), OffsetKt.Offset(coerceAtLeast, rect.getBottom()), r9, 0, (PathEffect) null, cursorAlpha, (ColorFilter) null, 0, 432, (Object) null);
        }
    }
}
