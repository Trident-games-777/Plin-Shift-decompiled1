package androidx.compose.ui.text.android;

import android.graphics.RectF;
import android.text.Layout;
import androidx.compose.ui.text.android.LayoutHelper;
import androidx.compose.ui.text.android.selection.SegmentFinder;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000N\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0015\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u001a \u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0002\u001a \u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0002\u001af\u0010\b\u001a\u00020\u0003*\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00112\u0018\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00140\u0013H\u0002\u001aH\u0010\u0015\u001a\u0004\u0018\u00010\u0016*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u00032\u0018\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00140\u0013H\u0000\u001af\u0010\u001d\u001a\u00020\u0003*\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00112\u0018\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00140\u0013H\u0002\u001aV\u0010\u001e\u001a\u00020\u0003*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00112\u0018\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010 \u001a\u00020\u0014H\u0002\u001a\u001c\u0010!\u001a\u00020\u0014*\u00020\u000b2\u0006\u0010\"\u001a\u00020\u00012\u0006\u0010#\u001a\u00020\u0001H\u0002¨\u0006$"}, d2 = {"getCharacterLeftBounds", "", "offset", "", "lineStart", "horizontalBounds", "", "getCharacterRightBounds", "getEndOffsetForRectWithinRun", "Landroidx/compose/ui/text/android/LayoutHelper$BidiRun;", "rect", "Landroid/graphics/RectF;", "lineTop", "lineBottom", "runLeft", "runRight", "segmentFinder", "Landroidx/compose/ui/text/android/selection/SegmentFinder;", "inclusionStrategy", "Lkotlin/Function2;", "", "getRangeForRect", "", "Landroidx/compose/ui/text/android/TextLayout;", "layout", "Landroid/text/Layout;", "layoutHelper", "Landroidx/compose/ui/text/android/LayoutHelper;", "granularity", "getStartOffsetForRectWithinRun", "getStartOrEndOffsetForRectWithinLine", "lineIndex", "getStart", "horizontalOverlap", "left", "right", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextLayoutGetRangeForRectExtensions.android.kt */
public final class TextLayoutGetRangeForRectExtensions_androidKt {
    /* JADX WARNING: Removed duplicated region for block: B:20:0x006b A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x006c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final int[] getRangeForRect(androidx.compose.ui.text.android.TextLayout r10, android.text.Layout r11, androidx.compose.ui.text.android.LayoutHelper r12, android.graphics.RectF r13, int r14, kotlin.jvm.functions.Function2<? super android.graphics.RectF, ? super android.graphics.RectF, java.lang.Boolean> r15) {
        /*
            r0 = 1
            if (r14 != r0) goto L_0x0013
            androidx.compose.ui.text.android.selection.WordSegmentFinder r14 = new androidx.compose.ui.text.android.selection.WordSegmentFinder
            java.lang.CharSequence r1 = r10.getText()
            androidx.compose.ui.text.android.selection.WordIterator r2 = r10.getWordIterator()
            r14.<init>(r1, r2)
            androidx.compose.ui.text.android.selection.SegmentFinder r14 = (androidx.compose.ui.text.android.selection.SegmentFinder) r14
            goto L_0x001f
        L_0x0013:
            java.lang.CharSequence r14 = r10.getText()
            android.text.TextPaint r1 = r10.getTextPaint()
            androidx.compose.ui.text.android.selection.SegmentFinder r14 = androidx.compose.ui.text.android.selection.SegmentFinder_androidKt.createGraphemeClusterSegmentFinder(r14, r1)
        L_0x001f:
            r6 = r14
            float r14 = r13.top
            int r14 = (int) r14
            int r14 = r11.getLineForVertical(r14)
            float r1 = r13.top
            float r2 = r10.getLineBottom(r14)
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            r9 = 0
            if (r1 <= 0) goto L_0x003b
            int r14 = r14 + 1
            int r1 = r10.getLineCount()
            if (r14 < r1) goto L_0x003b
            return r9
        L_0x003b:
            r4 = r14
            float r14 = r13.bottom
            int r14 = (int) r14
            int r14 = r11.getLineForVertical(r14)
            if (r14 != 0) goto L_0x0051
            float r1 = r13.bottom
            r2 = 0
            float r2 = r10.getLineTop(r2)
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 >= 0) goto L_0x0051
            return r9
        L_0x0051:
            r8 = 1
            r1 = r10
            r2 = r11
            r3 = r12
            r5 = r13
            r7 = r15
            int r10 = getStartOrEndOffsetForRectWithinLine(r1, r2, r3, r4, r5, r6, r7, r8)
        L_0x005b:
            r11 = r4
            r12 = -1
            if (r10 != r12) goto L_0x0069
            if (r11 >= r14) goto L_0x0069
            int r4 = r11 + 1
            r8 = 1
            int r10 = getStartOrEndOffsetForRectWithinLine(r1, r2, r3, r4, r5, r6, r7, r8)
            goto L_0x005b
        L_0x0069:
            if (r10 != r12) goto L_0x006c
            return r9
        L_0x006c:
            r8 = 0
            r4 = r14
            int r13 = getStartOrEndOffsetForRectWithinLine(r1, r2, r3, r4, r5, r6, r7, r8)
        L_0x0072:
            if (r13 != r12) goto L_0x007f
            if (r11 >= r14) goto L_0x007f
            int r4 = r14 + -1
            r8 = 0
            int r13 = getStartOrEndOffsetForRectWithinLine(r1, r2, r3, r4, r5, r6, r7, r8)
            r14 = r4
            goto L_0x0072
        L_0x007f:
            if (r13 != r12) goto L_0x0082
            return r9
        L_0x0082:
            int r10 = r10 + r0
            int r10 = r6.previousStartBoundary(r10)
            int r13 = r13 - r0
            int r11 = r6.nextEndBoundary(r13)
            int[] r10 = new int[]{r10, r11}
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.android.TextLayoutGetRangeForRectExtensions_androidKt.getRangeForRect(androidx.compose.ui.text.android.TextLayout, android.text.Layout, androidx.compose.ui.text.android.LayoutHelper, android.graphics.RectF, int, kotlin.jvm.functions.Function2):int[]");
    }

    private static final int getStartOrEndOffsetForRectWithinLine(TextLayout textLayout, Layout layout, LayoutHelper layoutHelper, int i, RectF rectF, SegmentFinder segmentFinder, Function2<? super RectF, ? super RectF, Boolean> function2, boolean z) {
        IntProgression intProgression;
        float f;
        float f2;
        int i2;
        int i3 = i;
        int lineTop = layout.getLineTop(i3);
        int lineBottom = layout.getLineBottom(i3);
        int lineStart = layout.getLineStart(i3);
        int lineEnd = layout.getLineEnd(i3);
        if (lineStart == lineEnd) {
            return -1;
        }
        float[] fArr = new float[((lineEnd - lineStart) * 2)];
        textLayout.fillLineHorizontalBounds$ui_text_release(i3, fArr);
        LayoutHelper.BidiRun[] lineBidiRuns$ui_text_release = layoutHelper.getLineBidiRuns$ui_text_release(i);
        if (z) {
            intProgression = ArraysKt.getIndices((T[]) lineBidiRuns$ui_text_release);
        } else {
            intProgression = RangesKt.downTo(ArraysKt.getLastIndex((T[]) lineBidiRuns$ui_text_release), 0);
        }
        int first = intProgression.getFirst();
        int last = intProgression.getLast();
        int step = intProgression.getStep();
        if ((step > 0 && first <= last) || (step < 0 && last <= first)) {
            int i4 = first;
            while (true) {
                LayoutHelper.BidiRun bidiRun = lineBidiRuns$ui_text_release[i4];
                if (bidiRun.isRtl()) {
                    f = getCharacterLeftBounds(bidiRun.getEnd() - 1, lineStart, fArr);
                } else {
                    f = getCharacterLeftBounds(bidiRun.getStart(), lineStart, fArr);
                }
                float f3 = f;
                if (bidiRun.isRtl()) {
                    f2 = getCharacterRightBounds(bidiRun.getStart(), lineStart, fArr);
                } else {
                    f2 = getCharacterRightBounds(bidiRun.getEnd() - 1, lineStart, fArr);
                }
                float f4 = f2;
                if (z) {
                    i2 = getStartOffsetForRectWithinRun(bidiRun, rectF, lineStart, lineTop, lineBottom, f3, f4, fArr, segmentFinder, function2);
                } else {
                    i2 = getEndOffsetForRectWithinRun(bidiRun, rectF, lineStart, lineTop, lineBottom, f3, f4, fArr, segmentFinder, function2);
                }
                if (i2 < 0) {
                    if (i4 == last) {
                        break;
                    }
                    i4 += step;
                } else {
                    return i2;
                }
            }
        }
        return -1;
    }

    private static final int getStartOffsetForRectWithinRun(LayoutHelper.BidiRun bidiRun, RectF rectF, int i, int i2, int i3, float f, float f2, float[] fArr, SegmentFinder segmentFinder, Function2<? super RectF, ? super RectF, Boolean> function2) {
        int i4;
        int previousStartBoundary;
        float f3;
        float f4;
        if (!horizontalOverlap(rectF, f, f2)) {
            return -1;
        }
        if ((bidiRun.isRtl() || rectF.left > f) && (!bidiRun.isRtl() || rectF.right < f2)) {
            i4 = bidiRun.getStart();
            int end = bidiRun.getEnd();
            while (end - i4 > 1) {
                int i5 = (end + i4) / 2;
                float characterLeftBounds = getCharacterLeftBounds(i5, i, fArr);
                if ((bidiRun.isRtl() || characterLeftBounds <= rectF.left) && (!bidiRun.isRtl() || characterLeftBounds >= rectF.right)) {
                    i4 = i5;
                } else {
                    end = i5;
                }
            }
            if (bidiRun.isRtl()) {
                i4 = end;
            }
        } else {
            i4 = bidiRun.getStart();
        }
        int nextEndBoundary = segmentFinder.nextEndBoundary(i4);
        if (nextEndBoundary == -1 || (previousStartBoundary = segmentFinder.previousStartBoundary(nextEndBoundary)) >= bidiRun.getEnd()) {
            return -1;
        }
        int coerceAtLeast = RangesKt.coerceAtLeast(previousStartBoundary, bidiRun.getStart());
        int coerceAtMost = RangesKt.coerceAtMost(nextEndBoundary, bidiRun.getEnd());
        RectF rectF2 = new RectF(0.0f, (float) i2, 0.0f, (float) i3);
        while (true) {
            if (bidiRun.isRtl()) {
                f3 = getCharacterLeftBounds(coerceAtMost - 1, i, fArr);
            } else {
                f3 = getCharacterLeftBounds(coerceAtLeast, i, fArr);
            }
            rectF2.left = f3;
            if (bidiRun.isRtl()) {
                f4 = getCharacterRightBounds(coerceAtLeast, i, fArr);
            } else {
                f4 = getCharacterRightBounds(coerceAtMost - 1, i, fArr);
            }
            rectF2.right = f4;
            if (function2.invoke(rectF2, rectF).booleanValue()) {
                return coerceAtLeast;
            }
            coerceAtLeast = segmentFinder.nextStartBoundary(coerceAtLeast);
            if (coerceAtLeast == -1 || coerceAtLeast >= bidiRun.getEnd()) {
                return -1;
            }
            coerceAtMost = RangesKt.coerceAtMost(segmentFinder.nextEndBoundary(coerceAtLeast), bidiRun.getEnd());
        }
        return -1;
    }

    private static final int getEndOffsetForRectWithinRun(LayoutHelper.BidiRun bidiRun, RectF rectF, int i, int i2, int i3, float f, float f2, float[] fArr, SegmentFinder segmentFinder, Function2<? super RectF, ? super RectF, Boolean> function2) {
        int i4;
        int nextEndBoundary;
        float f3;
        float f4;
        if (!horizontalOverlap(rectF, f, f2)) {
            return -1;
        }
        if ((bidiRun.isRtl() || rectF.right < f2) && (!bidiRun.isRtl() || rectF.left > f)) {
            i4 = bidiRun.getStart();
            int end = bidiRun.getEnd();
            while (end - i4 > 1) {
                int i5 = (end + i4) / 2;
                float characterLeftBounds = getCharacterLeftBounds(i5, i, fArr);
                if ((bidiRun.isRtl() || characterLeftBounds <= rectF.right) && (!bidiRun.isRtl() || characterLeftBounds >= rectF.left)) {
                    i4 = i5;
                } else {
                    end = i5;
                }
            }
            if (bidiRun.isRtl()) {
                i4 = end;
            }
        } else {
            i4 = bidiRun.getEnd() - 1;
        }
        int previousStartBoundary = segmentFinder.previousStartBoundary(i4 + 1);
        if (previousStartBoundary == -1 || (nextEndBoundary = segmentFinder.nextEndBoundary(previousStartBoundary)) <= bidiRun.getStart()) {
            return -1;
        }
        int coerceAtLeast = RangesKt.coerceAtLeast(previousStartBoundary, bidiRun.getStart());
        int coerceAtMost = RangesKt.coerceAtMost(nextEndBoundary, bidiRun.getEnd());
        RectF rectF2 = new RectF(0.0f, (float) i2, 0.0f, (float) i3);
        while (true) {
            if (bidiRun.isRtl()) {
                f3 = getCharacterLeftBounds(coerceAtMost - 1, i, fArr);
            } else {
                f3 = getCharacterLeftBounds(coerceAtLeast, i, fArr);
            }
            rectF2.left = f3;
            if (bidiRun.isRtl()) {
                f4 = getCharacterRightBounds(coerceAtLeast, i, fArr);
            } else {
                f4 = getCharacterRightBounds(coerceAtMost - 1, i, fArr);
            }
            rectF2.right = f4;
            if (function2.invoke(rectF2, rectF).booleanValue()) {
                return coerceAtMost;
            }
            coerceAtMost = segmentFinder.previousEndBoundary(coerceAtMost);
            if (coerceAtMost == -1 || coerceAtMost <= bidiRun.getStart()) {
                return -1;
            }
            coerceAtLeast = RangesKt.coerceAtLeast(segmentFinder.previousStartBoundary(coerceAtMost), bidiRun.getStart());
        }
        return -1;
    }

    private static final float getCharacterLeftBounds(int i, int i2, float[] fArr) {
        return fArr[(i - i2) * 2];
    }

    private static final float getCharacterRightBounds(int i, int i2, float[] fArr) {
        return fArr[((i - i2) * 2) + 1];
    }

    private static final boolean horizontalOverlap(RectF rectF, float f, float f2) {
        return f2 >= rectF.left && f <= rectF.right;
    }
}
