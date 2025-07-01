package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.selection.Selection;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.text.TextLayoutResult;
import java.util.Comparator;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000R\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\"\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a\"\u0010\b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0002ø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u001a\"\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0002ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\r\u001a\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\tH\u0002\u001a6\u0010\u0014\u001a\u00020\u0015*\u00020\u00162\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u001aH\u0000ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001c\u001a\u001c\u0010\u001d\u001a\u00020\t*\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020\u001aH\u0002\u001a4\u0010 \u001a\u00020\u0001*\u00020!2\u0016\u0010\"\u001a\u0012\u0012\u0004\u0012\u00020\u001a0#j\b\u0012\u0004\u0012\u00020\u001a`$2\u0006\u0010\u001f\u001a\u00020\u001a2\u0006\u0010%\u001a\u00020\u0001H\u0002\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006&"}, d2 = {"getOffsetForPosition", "", "position", "Landroidx/compose/ui/geometry/Offset;", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "getOffsetForPosition-3MmeM6k", "(JLandroidx/compose/ui/text/TextLayoutResult;)I", "getXDirection", "Landroidx/compose/foundation/text/selection/Direction;", "bounds", "Landroidx/compose/ui/geometry/Rect;", "getXDirection-3MmeM6k", "(JLandroidx/compose/ui/geometry/Rect;)Landroidx/compose/foundation/text/selection/Direction;", "getYDirection", "getYDirection-3MmeM6k", "isSelected", "", "currentDirection", "otherDirection", "appendSelectableInfo", "", "Landroidx/compose/foundation/text/selection/SelectionLayoutBuilder;", "localPosition", "previousHandlePosition", "selectableId", "", "appendSelectableInfo-Parwq6A", "(Landroidx/compose/foundation/text/selection/SelectionLayoutBuilder;Landroidx/compose/ui/text/TextLayoutResult;JJJ)V", "getDirectionById", "anchorSelectableId", "currentSelectableId", "getPreviousAdjustedOffset", "Landroidx/compose/foundation/text/selection/Selection$AnchorInfo;", "selectableIdOrderingComparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "currentTextLength", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: MultiWidgetSelectionDelegate.kt */
public final class MultiWidgetSelectionDelegateKt {
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0088, code lost:
        r1 = r1.getEnd();
     */
    /* renamed from: appendSelectableInfo-Parwq6A  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1565appendSelectableInfoParwq6A(androidx.compose.foundation.text.selection.SelectionLayoutBuilder r15, androidx.compose.ui.text.TextLayoutResult r16, long r17, long r19, long r21) {
        /*
            r10 = r16
            r0 = r17
            androidx.compose.ui.geometry.Rect r2 = new androidx.compose.ui.geometry.Rect
            long r3 = r10.m6537getSizeYbymL2g()
            int r3 = androidx.compose.ui.unit.IntSize.m7283getWidthimpl(r3)
            float r3 = (float) r3
            long r4 = r10.m6537getSizeYbymL2g()
            int r4 = androidx.compose.ui.unit.IntSize.m7282getHeightimpl(r4)
            float r4 = (float) r4
            r5 = 0
            r2.<init>(r5, r5, r3, r4)
            androidx.compose.foundation.text.selection.Direction r3 = m1567getXDirection3MmeM6k(r0, r2)
            androidx.compose.foundation.text.selection.Direction r2 = m1568getYDirection3MmeM6k(r0, r2)
            boolean r4 = r15.isStartHandle()
            r5 = 0
            if (r4 == 0) goto L_0x0048
            androidx.compose.foundation.text.selection.Selection r4 = r15.getPreviousSelection()
            if (r4 == 0) goto L_0x0035
            androidx.compose.foundation.text.selection.Selection$AnchorInfo r5 = r4.getEnd()
        L_0x0035:
            r4 = r3
            r3 = r2
            r2 = r4
            r4 = r15
            r7 = r5
            r5 = r21
            androidx.compose.foundation.text.selection.Direction r7 = appendSelectableInfo_Parwq6A$otherDirection(r2, r3, r4, r5, r7)
            r5 = r21
            r4 = r2
            r8 = r7
            r9 = r8
            r11 = r9
            r7 = r3
            goto L_0x0061
        L_0x0048:
            r13 = r3
            r3 = r2
            r2 = r13
            androidx.compose.foundation.text.selection.Selection r4 = r15.getPreviousSelection()
            if (r4 == 0) goto L_0x0055
            androidx.compose.foundation.text.selection.Selection$AnchorInfo r5 = r4.getStart()
        L_0x0055:
            r4 = r15
            r7 = r5
            r5 = r21
            androidx.compose.foundation.text.selection.Direction r7 = appendSelectableInfo_Parwq6A$otherDirection(r2, r3, r4, r5, r7)
            r9 = r2
            r8 = r3
            r4 = r7
            r11 = r4
        L_0x0061:
            androidx.compose.foundation.text.selection.Direction r2 = androidx.compose.foundation.text.selection.SelectionLayoutKt.resolve2dDirection(r2, r3)
            boolean r2 = isSelected(r2, r11)
            if (r2 != 0) goto L_0x006c
            return
        L_0x006c:
            androidx.compose.ui.text.TextLayoutInput r2 = r10.getLayoutInput()
            androidx.compose.ui.text.AnnotatedString r2 = r2.getText()
            int r2 = r2.length()
            boolean r3 = r15.isStartHandle()
            if (r3 == 0) goto L_0x0099
            int r0 = m1566getOffsetForPosition3MmeM6k(r0, r10)
            androidx.compose.foundation.text.selection.Selection r1 = r15.getPreviousSelection()
            if (r1 == 0) goto L_0x0097
            androidx.compose.foundation.text.selection.Selection$AnchorInfo r1 = r1.getEnd()
            if (r1 == 0) goto L_0x0097
            java.util.Comparator r3 = r15.getSelectableIdOrderingComparator()
            int r1 = getPreviousAdjustedOffset(r1, r3, r5, r2)
            goto L_0x00b3
        L_0x0097:
            r1 = r0
            goto L_0x00b3
        L_0x0099:
            int r1 = m1566getOffsetForPosition3MmeM6k(r0, r10)
            androidx.compose.foundation.text.selection.Selection r0 = r15.getPreviousSelection()
            if (r0 == 0) goto L_0x00b2
            androidx.compose.foundation.text.selection.Selection$AnchorInfo r0 = r0.getStart()
            if (r0 == 0) goto L_0x00b2
            java.util.Comparator r3 = r15.getSelectableIdOrderingComparator()
            int r0 = getPreviousAdjustedOffset(r0, r3, r5, r2)
            goto L_0x00b3
        L_0x00b2:
            r0 = r1
        L_0x00b3:
            r3 = r0
            boolean r0 = androidx.compose.ui.geometry.OffsetKt.m4008isUnspecifiedk4lQ0M(r19)
            if (r0 == 0) goto L_0x00bc
            r0 = -1
            goto L_0x00c2
        L_0x00bc:
            r11 = r19
            int r0 = m1566getOffsetForPosition3MmeM6k(r11, r10)
        L_0x00c2:
            r13 = r5
            r6 = r1
            r1 = r13
            r5 = r7
            r7 = r9
            r9 = r0
            r0 = r15
            r0.appendInfo(r1, r3, r4, r5, r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.MultiWidgetSelectionDelegateKt.m1565appendSelectableInfoParwq6A(androidx.compose.foundation.text.selection.SelectionLayoutBuilder, androidx.compose.ui.text.TextLayoutResult, long, long, long):void");
    }

    private static final Direction appendSelectableInfo_Parwq6A$otherDirection(Direction direction, Direction direction2, SelectionLayoutBuilder selectionLayoutBuilder, long j, Selection.AnchorInfo anchorInfo) {
        Direction directionById;
        if (anchorInfo == null || (directionById = getDirectionById(selectionLayoutBuilder, anchorInfo.getSelectableId(), j)) == null) {
            return SelectionLayoutKt.resolve2dDirection(direction, direction2);
        }
        return directionById;
    }

    private static final int getPreviousAdjustedOffset(Selection.AnchorInfo anchorInfo, Comparator<Long> comparator, long j, int i) {
        int compare = comparator.compare(Long.valueOf(anchorInfo.getSelectableId()), Long.valueOf(j));
        if (compare < 0) {
            return 0;
        }
        if (compare > 0) {
            return i;
        }
        return anchorInfo.getOffset();
    }

    /* renamed from: getXDirection-3MmeM6k  reason: not valid java name */
    private static final Direction m1567getXDirection3MmeM6k(long j, Rect rect) {
        if (Offset.m3987getXimpl(j) < rect.getLeft()) {
            return Direction.BEFORE;
        }
        if (Offset.m3987getXimpl(j) > rect.getRight()) {
            return Direction.AFTER;
        }
        return Direction.ON;
    }

    /* renamed from: getYDirection-3MmeM6k  reason: not valid java name */
    private static final Direction m1568getYDirection3MmeM6k(long j, Rect rect) {
        if (Offset.m3988getYimpl(j) < rect.getTop()) {
            return Direction.BEFORE;
        }
        if (Offset.m3988getYimpl(j) > rect.getBottom()) {
            return Direction.AFTER;
        }
        return Direction.ON;
    }

    private static final Direction getDirectionById(SelectionLayoutBuilder selectionLayoutBuilder, long j, long j2) {
        int compare = selectionLayoutBuilder.getSelectableIdOrderingComparator().compare(Long.valueOf(j), Long.valueOf(j2));
        if (compare < 0) {
            return Direction.BEFORE;
        }
        if (compare > 0) {
            return Direction.AFTER;
        }
        return Direction.ON;
    }

    private static final boolean isSelected(Direction direction, Direction direction2) {
        return direction == Direction.ON || direction != direction2;
    }

    /* renamed from: getOffsetForPosition-3MmeM6k  reason: not valid java name */
    private static final int m1566getOffsetForPosition3MmeM6k(long j, TextLayoutResult textLayoutResult) {
        if (Offset.m3988getYimpl(j) <= 0.0f) {
            return 0;
        }
        if (Offset.m3988getYimpl(j) >= textLayoutResult.getMultiParagraph().getHeight()) {
            return textLayoutResult.getLayoutInput().getText().length();
        }
        return textLayoutResult.m6536getOffsetForPositionk4lQ0M(j);
    }
}
