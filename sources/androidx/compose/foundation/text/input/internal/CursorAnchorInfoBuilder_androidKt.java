package androidx.compose.foundation.text.input.internal;

import android.graphics.Matrix;
import android.os.Build;
import android.view.inputmethod.CursorAnchorInfo;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\u001a,\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002\u001ax\u0010\t\u001a\u00020\n*\u00020\u00012\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\b2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0016\u001a\u00020\u00142\b\b\u0002\u0010\u0017\u001a\u00020\u0014H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u001a$\u0010\u001a\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001c"}, d2 = {"addCharacterBounds", "Landroid/view/inputmethod/CursorAnchorInfo$Builder;", "startOffset", "", "endOffset", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "innerTextFieldBounds", "Landroidx/compose/ui/geometry/Rect;", "build", "Landroid/view/inputmethod/CursorAnchorInfo;", "text", "", "selection", "Landroidx/compose/ui/text/TextRange;", "composition", "matrix", "Landroid/graphics/Matrix;", "decorationBoxBounds", "includeInsertionMarker", "", "includeCharacterBounds", "includeEditorBounds", "includeLineBounds", "build-vxqZcH0", "(Landroid/view/inputmethod/CursorAnchorInfo$Builder;Ljava/lang/CharSequence;JLandroidx/compose/ui/text/TextRange;Landroidx/compose/ui/text/TextLayoutResult;Landroid/graphics/Matrix;Landroidx/compose/ui/geometry/Rect;Landroidx/compose/ui/geometry/Rect;ZZZZ)Landroid/view/inputmethod/CursorAnchorInfo;", "setInsertionMarker", "selectionStart", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: CursorAnchorInfoBuilder.android.kt */
public final class CursorAnchorInfoBuilder_androidKt {
    /* renamed from: build-vxqZcH0$default  reason: not valid java name */
    public static /* synthetic */ CursorAnchorInfo m1346buildvxqZcH0$default(CursorAnchorInfo.Builder builder, CharSequence charSequence, long j, TextRange textRange, TextLayoutResult textLayoutResult, Matrix matrix, Rect rect, Rect rect2, boolean z, boolean z2, boolean z3, boolean z4, int i, Object obj) {
        if ((i & 128) != 0) {
            z = true;
        }
        if ((i & 256) != 0) {
            z2 = true;
        }
        if ((i & 512) != 0) {
            z3 = true;
        }
        if ((i & 1024) != 0) {
            z4 = true;
        }
        return m1345buildvxqZcH0(builder, charSequence, j, textRange, textLayoutResult, matrix, rect, rect2, z, z2, z3, z4);
    }

    /* renamed from: build-vxqZcH0  reason: not valid java name */
    public static final CursorAnchorInfo m1345buildvxqZcH0(CursorAnchorInfo.Builder builder, CharSequence charSequence, long j, TextRange textRange, TextLayoutResult textLayoutResult, Matrix matrix, Rect rect, Rect rect2, boolean z, boolean z2, boolean z3, boolean z4) {
        builder.reset();
        builder.setMatrix(matrix);
        int r6 = TextRange.m6562getMinimpl(j);
        builder.setSelectionRange(r6, TextRange.m6561getMaximpl(j));
        if (z) {
            setInsertionMarker(builder, r6, textLayoutResult, rect);
        }
        if (z2) {
            int i = -1;
            int r3 = textRange != null ? TextRange.m6562getMinimpl(textRange.m6568unboximpl()) : -1;
            if (textRange != null) {
                i = TextRange.m6561getMaximpl(textRange.m6568unboximpl());
            }
            if (r3 >= 0 && r3 < i) {
                builder.setComposingText(r3, charSequence.subSequence(r3, i));
                addCharacterBounds(builder, r3, i, textLayoutResult, rect);
            }
        }
        if (Build.VERSION.SDK_INT >= 33 && z3) {
            CursorAnchorInfoApi33Helper.setEditorBoundsInfo(builder, rect2);
        }
        if (Build.VERSION.SDK_INT >= 34 && z4) {
            CursorAnchorInfoApi34Helper.addVisibleLineBounds(builder, textLayoutResult, rect);
        }
        return builder.build();
    }

    private static final CursorAnchorInfo.Builder setInsertionMarker(CursorAnchorInfo.Builder builder, int i, TextLayoutResult textLayoutResult, Rect rect) {
        if (i < 0) {
            return builder;
        }
        Rect cursorRect = textLayoutResult.getCursorRect(i);
        float coerceIn = RangesKt.coerceIn(cursorRect.getLeft(), 0.0f, (float) IntSize.m7283getWidthimpl(textLayoutResult.m6537getSizeYbymL2g()));
        boolean containsInclusive = LegacyCursorAnchorInfoBuilder_androidKt.containsInclusive(rect, coerceIn, cursorRect.getTop());
        boolean containsInclusive2 = LegacyCursorAnchorInfoBuilder_androidKt.containsInclusive(rect, coerceIn, cursorRect.getBottom());
        int i2 = 1;
        boolean z = textLayoutResult.getBidiRunDirection(i) == ResolvedTextDirection.Rtl;
        if (!containsInclusive && !containsInclusive2) {
            i2 = 0;
        }
        if (!containsInclusive || !containsInclusive2) {
            i2 |= 2;
        }
        if (z) {
            i2 |= 4;
        }
        CursorAnchorInfo.Builder builder2 = builder;
        builder2.setInsertionMarkerLocation(coerceIn, cursorRect.getTop(), cursorRect.getBottom(), cursorRect.getBottom(), i2);
        return builder2;
    }

    private static final CursorAnchorInfo.Builder addCharacterBounds(CursorAnchorInfo.Builder builder, int i, int i2, TextLayoutResult textLayoutResult, Rect rect) {
        int i3 = i2;
        Rect rect2 = rect;
        float[] fArr = new float[((i3 - i) * 4)];
        textLayoutResult.getMultiParagraph().m6422fillBoundingBoxes8ffj60Q(TextRangeKt.TextRange(i, i2), fArr, 0);
        for (int i4 = i; i4 < i3; i4++) {
            int i5 = (i4 - i) * 4;
            Rect rect3 = new Rect(fArr[i5], fArr[i5 + 1], fArr[i5 + 2], fArr[i5 + 3]);
            boolean overlaps = rect2.overlaps(rect3);
            if (!LegacyCursorAnchorInfoBuilder_androidKt.containsInclusive(rect2, rect3.getLeft(), rect3.getTop()) || !LegacyCursorAnchorInfoBuilder_androidKt.containsInclusive(rect2, rect3.getRight(), rect3.getBottom())) {
                overlaps |= true;
            }
            if (textLayoutResult.getBidiRunDirection(i4) == ResolvedTextDirection.Rtl) {
                overlaps |= true;
            }
            builder.addCharacterBounds(i4, rect3.getLeft(), rect3.getTop(), rect3.getRight(), rect3.getBottom(), overlaps ? 1 : 0);
        }
        return builder;
    }
}
