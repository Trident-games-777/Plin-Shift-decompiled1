package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\u0006\u0010\n\u001a\u00020\u0004\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0006\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00000\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0019\u0012\u0006\u0010\u001a\u001a\u00020\u0004\u0012\u0006\u0010\u001b\u001a\u00020\u0004¢\u0006\u0002\u0010\u001cJ\u000e\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020\u0004J\u001d\u0010G\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u0004H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bH\u0010IJ\u0012\u0010J\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u0004H\u0016J\u000e\u0010K\u001a\u00020E2\u0006\u0010L\u001a\u00020MJ(\u0010N\u001a\u00020E2\u0006\u0010O\u001a\u00020\u00042\u0006\u0010P\u001a\u00020\u00042\u0006\u0010Q\u001a\u00020\u00042\u0006\u0010R\u001a\u00020\u0004H\u0016J6\u0010N\u001a\u00020E2\u0006\u0010O\u001a\u00020\u00042\u0006\u0010P\u001a\u00020\u00042\u0006\u0010Q\u001a\u00020\u00042\u0006\u0010R\u001a\u00020\u00042\u0006\u0010:\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u0004J\u000e\u0010S\u001a\u00020E2\u0006\u0010+\u001a\u00020\u0004J+\u0010T\u001a\u00020\u0014*\u00020\u00142\u0012\u0010U\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040VH\bø\u0001\u0000¢\u0006\u0004\bW\u0010XR\u000e\u0010\u000f\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00000\u0017X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u0004@RX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u001c\u0010\u0018\u001a\u00020\u0019X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010#\u001a\u0004\b!\u0010\"R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010 R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010 R\u0014\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010(R\u0014\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010%R\u0014\u0010\u001a\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010 R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010,\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010 R\u0014\u0010.\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u0010 R\u000e\u00100\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u001a\u00102\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010(\"\u0004\b4\u00105R&\u00106\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u0014@RX\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010#\u001a\u0004\b7\u0010\"R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0004¢\u0006\u0002\n\u0000R\u0014\u00108\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b9\u0010 R\u000e\u0010\u000b\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u001e\u0010:\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u0004@RX\u000e¢\u0006\b\n\u0000\u001a\u0004\b;\u0010 R\u001c\u0010<\u001a\u00020=X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010#\u001a\u0004\b>\u0010\"R\u0014\u0010\u001b\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b?\u0010 R\u0016\u0010\u0013\u001a\u00020\u0014X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010#R\u0018\u0010@\u001a\u00020\u0004*\u00020\u00148BX\u0004¢\u0006\u0006\u001a\u0004\bA\u0010BR\u0018\u0010,\u001a\u00020\u0004*\u00020\u00128BX\u0004¢\u0006\u0006\u001a\u0004\b-\u0010C\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006Y"}, d2 = {"Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItem;", "Landroidx/compose/foundation/lazy/grid/LazyGridItemInfo;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasuredItem;", "index", "", "key", "", "isVertical", "", "crossAxisSize", "mainAxisSpacing", "reverseLayout", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "beforeContentPadding", "afterContentPadding", "placeables", "", "Landroidx/compose/ui/layout/Placeable;", "visualOffset", "Landroidx/compose/ui/unit/IntOffset;", "contentType", "animator", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "lane", "span", "(ILjava/lang/Object;ZIIZLandroidx/compose/ui/unit/LayoutDirection;IILjava/util/List;JLjava/lang/Object;Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;JIILkotlin/jvm/internal/DefaultConstructorMarker;)V", "<set-?>", "column", "getColumn", "()I", "getConstraints-msEJaDk", "()J", "J", "getContentType", "()Ljava/lang/Object;", "getCrossAxisSize", "getIndex", "()Z", "getKey", "getLane", "mainAxisLayoutSize", "mainAxisSize", "getMainAxisSize", "mainAxisSizeWithSpacings", "getMainAxisSizeWithSpacings", "maxMainAxisOffset", "minMainAxisOffset", "nonScrollableItem", "getNonScrollableItem", "setNonScrollableItem", "(Z)V", "offset", "getOffset-nOcc-ac", "placeablesCount", "getPlaceablesCount", "row", "getRow", "size", "Landroidx/compose/ui/unit/IntSize;", "getSize-YbymL2g", "getSpan", "mainAxis", "getMainAxis--gyyYBs", "(J)I", "(Landroidx/compose/ui/layout/Placeable;)I", "applyScrollDelta", "", "delta", "getOffset", "getOffset-Bjo55l4", "(I)J", "getParentData", "place", "scope", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "position", "mainAxisOffset", "crossAxisOffset", "layoutWidth", "layoutHeight", "updateMainAxisLayoutSize", "copy", "mainAxisMap", "Lkotlin/Function1;", "copy-4Tuh3kE", "(JLkotlin/jvm/functions/Function1;)J", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyGridMeasuredItem.kt */
public final class LazyGridMeasuredItem implements LazyGridItemInfo, LazyLayoutMeasuredItem {
    public static final int $stable = 8;
    private final int afterContentPadding;
    private final LazyLayoutItemAnimator<LazyGridMeasuredItem> animator;
    private final int beforeContentPadding;
    private int column;
    private final long constraints;
    private final Object contentType;
    private final int crossAxisSize;
    private final int index;
    private final boolean isVertical;
    private final Object key;
    private final int lane;
    private final LayoutDirection layoutDirection;
    private int mainAxisLayoutSize;
    private final int mainAxisSize;
    private final int mainAxisSizeWithSpacings;
    private int maxMainAxisOffset;
    private int minMainAxisOffset;
    private boolean nonScrollableItem;
    private long offset;
    private final List<Placeable> placeables;
    private final boolean reverseLayout;
    private int row;
    private final long size;
    private final int span;
    private final long visualOffset;

    public /* synthetic */ LazyGridMeasuredItem(int i, Object obj, boolean z, int i2, int i3, boolean z2, LayoutDirection layoutDirection2, int i4, int i5, List list, long j, Object obj2, LazyLayoutItemAnimator lazyLayoutItemAnimator, long j2, int i6, int i7, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, obj, z, i2, i3, z2, layoutDirection2, i4, i5, list, j, obj2, lazyLayoutItemAnimator, j2, i6, i7);
    }

    private LazyGridMeasuredItem(int i, Object obj, boolean z, int i2, int i3, boolean z2, LayoutDirection layoutDirection2, int i4, int i5, List<? extends Placeable> list, long j, Object obj2, LazyLayoutItemAnimator<LazyGridMeasuredItem> lazyLayoutItemAnimator, long j2, int i6, int i7) {
        long j3;
        this.index = i;
        this.key = obj;
        this.isVertical = z;
        this.crossAxisSize = i2;
        this.reverseLayout = z2;
        this.layoutDirection = layoutDirection2;
        this.beforeContentPadding = i4;
        this.afterContentPadding = i5;
        this.placeables = list;
        this.visualOffset = j;
        this.contentType = obj2;
        this.animator = lazyLayoutItemAnimator;
        this.constraints = j2;
        this.lane = i6;
        this.span = i7;
        this.mainAxisLayoutSize = Integer.MIN_VALUE;
        int size2 = list.size();
        int i8 = 0;
        for (int i9 = 0; i9 < size2; i9++) {
            Placeable placeable = (Placeable) list.get(i9);
            i8 = Math.max(i8, isVertical() ? placeable.getHeight() : placeable.getWidth());
        }
        this.mainAxisSize = i8;
        this.mainAxisSizeWithSpacings = RangesKt.coerceAtLeast(i3 + i8, 0);
        if (isVertical()) {
            j3 = IntSizeKt.IntSize(this.crossAxisSize, i8);
        } else {
            j3 = IntSizeKt.IntSize(i8, this.crossAxisSize);
        }
        this.size = j3;
        this.offset = IntOffset.Companion.m7251getZeronOccac();
        this.row = -1;
        this.column = -1;
    }

    public int getIndex() {
        return this.index;
    }

    public Object getKey() {
        return this.key;
    }

    public boolean isVertical() {
        return this.isVertical;
    }

    public final int getCrossAxisSize() {
        return this.crossAxisSize;
    }

    public Object getContentType() {
        return this.contentType;
    }

    /* renamed from: getConstraints-msEJaDk  reason: not valid java name */
    public long m955getConstraintsmsEJaDk() {
        return this.constraints;
    }

    public int getLane() {
        return this.lane;
    }

    public int getSpan() {
        return this.span;
    }

    public final int getMainAxisSize() {
        return this.mainAxisSize;
    }

    public int getMainAxisSizeWithSpacings() {
        return this.mainAxisSizeWithSpacings;
    }

    public int getPlaceablesCount() {
        return this.placeables.size();
    }

    public Object getParentData(int i) {
        return this.placeables.get(i).getParentData();
    }

    /* renamed from: getSize-YbymL2g  reason: not valid java name */
    public long m958getSizeYbymL2g() {
        return this.size;
    }

    /* renamed from: getOffset-nOcc-ac  reason: not valid java name */
    public long m957getOffsetnOccac() {
        return this.offset;
    }

    public int getRow() {
        return this.row;
    }

    public int getColumn() {
        return this.column;
    }

    /* renamed from: getOffset-Bjo55l4  reason: not valid java name */
    public long m956getOffsetBjo55l4(int i) {
        return m957getOffsetnOccac();
    }

    public boolean getNonScrollableItem() {
        return this.nonScrollableItem;
    }

    public void setNonScrollableItem(boolean z) {
        this.nonScrollableItem = z;
    }

    public void position(int i, int i2, int i3, int i4) {
        position(i, i2, i3, i4, -1, -1);
    }

    public final void position(int i, int i2, int i3, int i4, int i5, int i6) {
        long j;
        this.mainAxisLayoutSize = isVertical() ? i4 : i3;
        if (!isVertical()) {
            i3 = i4;
        }
        if (isVertical() && this.layoutDirection == LayoutDirection.Rtl) {
            i2 = (i3 - i2) - this.crossAxisSize;
        }
        if (isVertical()) {
            j = IntOffsetKt.IntOffset(i2, i);
        } else {
            j = IntOffsetKt.IntOffset(i, i2);
        }
        this.offset = j;
        this.row = i5;
        this.column = i6;
        this.minMainAxisOffset = -this.beforeContentPadding;
        this.maxMainAxisOffset = this.mainAxisLayoutSize + this.afterContentPadding;
    }

    public final void updateMainAxisLayoutSize(int i) {
        this.mainAxisLayoutSize = i;
        this.maxMainAxisOffset = i + this.afterContentPadding;
    }

    public final void applyScrollDelta(int i) {
        if (!getNonScrollableItem()) {
            long r0 = m957getOffsetnOccac();
            int r2 = isVertical() ? IntOffset.m7241getXimpl(r0) : IntOffset.m7241getXimpl(r0) + i;
            boolean isVertical2 = isVertical();
            int r02 = IntOffset.m7242getYimpl(r0);
            if (isVertical2) {
                r02 += i;
            }
            this.offset = IntOffsetKt.IntOffset(r2, r02);
            int placeablesCount = getPlaceablesCount();
            for (int i2 = 0; i2 < placeablesCount; i2++) {
                LazyLayoutItemAnimation animation = this.animator.getAnimation(getKey(), i2);
                if (animation != null) {
                    long r3 = animation.m979getRawOffsetnOccac();
                    int r5 = isVertical() ? IntOffset.m7241getXimpl(r3) : Integer.valueOf(IntOffset.m7241getXimpl(r3) + i).intValue();
                    boolean isVertical3 = isVertical();
                    int r32 = IntOffset.m7242getYimpl(r3);
                    if (isVertical3) {
                        r32 += i;
                    }
                    animation.m982setRawOffsetgyyYBs(IntOffsetKt.IntOffset(r5, r32));
                }
            }
        }
    }

    public final void place(Placeable.PlacementScope placementScope) {
        GraphicsLayer graphicsLayer;
        Placeable.PlacementScope placementScope2;
        int i;
        int i2;
        if (this.mainAxisLayoutSize != Integer.MIN_VALUE) {
            int placeablesCount = getPlaceablesCount();
            int i3 = 0;
            while (i3 < placeablesCount) {
                Placeable placeable = this.placeables.get(i3);
                int mainAxisSize2 = this.minMainAxisOffset - getMainAxisSize(placeable);
                int i4 = this.maxMainAxisOffset;
                long r5 = m957getOffsetnOccac();
                LazyLayoutItemAnimation animation = this.animator.getAnimation(getKey(), i3);
                if (animation != null) {
                    long r8 = IntOffset.m7245plusqkQi6aY(r5, animation.m978getPlacementDeltanOccac());
                    if ((m954getMainAxisgyyYBs(r5) <= mainAxisSize2 && m954getMainAxisgyyYBs(r8) <= mainAxisSize2) || (m954getMainAxisgyyYBs(r5) >= i4 && m954getMainAxisgyyYBs(r8) >= i4)) {
                        animation.cancelPlacementAnimation();
                    }
                    graphicsLayer = animation.getLayer();
                    r5 = r8;
                } else {
                    graphicsLayer = null;
                }
                if (this.reverseLayout) {
                    if (isVertical()) {
                        i = IntOffset.m7241getXimpl(r5);
                    } else {
                        i = (this.mainAxisLayoutSize - IntOffset.m7241getXimpl(r5)) - getMainAxisSize(placeable);
                    }
                    if (isVertical()) {
                        i2 = (this.mainAxisLayoutSize - IntOffset.m7242getYimpl(r5)) - getMainAxisSize(placeable);
                    } else {
                        i2 = IntOffset.m7242getYimpl(r5);
                    }
                    r5 = IntOffsetKt.IntOffset(i, i2);
                }
                long r52 = IntOffset.m7245plusqkQi6aY(r5, this.visualOffset);
                if (animation != null) {
                    animation.m980setFinalOffsetgyyYBs(r52);
                }
                if (!isVertical()) {
                    placementScope2 = placementScope;
                    GraphicsLayer graphicsLayer2 = graphicsLayer;
                    if (graphicsLayer2 != null) {
                        Placeable.PlacementScope.m5893placeRelativeWithLayeraW9wM$default(placementScope2, placeable, r52, graphicsLayer2, 0.0f, 4, (Object) null);
                    } else {
                        Placeable.PlacementScope.m5892placeRelativeWithLayeraW9wM$default(placementScope2, placeable, r52, 0.0f, (Function1) null, 6, (Object) null);
                    }
                } else if (graphicsLayer != null) {
                    placementScope2 = placementScope;
                    Placeable.PlacementScope.m5895placeWithLayeraW9wM$default(placementScope2, placeable, r52, graphicsLayer, 0.0f, 4, (Object) null);
                } else {
                    placementScope2 = placementScope;
                    Placeable.PlacementScope.m5894placeWithLayeraW9wM$default(placementScope2, placeable, r52, 0.0f, (Function1) null, 6, (Object) null);
                }
                i3++;
                placementScope = placementScope2;
            }
            return;
        }
        throw new IllegalArgumentException("position() should be called first".toString());
    }

    /* renamed from: getMainAxis--gyyYBs  reason: not valid java name */
    private final int m954getMainAxisgyyYBs(long j) {
        return isVertical() ? IntOffset.m7242getYimpl(j) : IntOffset.m7241getXimpl(j);
    }

    private final int getMainAxisSize(Placeable placeable) {
        return isVertical() ? placeable.getHeight() : placeable.getWidth();
    }

    /* renamed from: copy-4Tuh3kE  reason: not valid java name */
    private final long m953copy4Tuh3kE(long j, Function1<? super Integer, Integer> function1) {
        int r0 = isVertical() ? IntOffset.m7241getXimpl(j) : function1.invoke(Integer.valueOf(IntOffset.m7241getXimpl(j))).intValue();
        boolean isVertical2 = isVertical();
        int r3 = IntOffset.m7242getYimpl(j);
        if (isVertical2) {
            r3 = function1.invoke(Integer.valueOf(r3)).intValue();
        }
        return IntOffsetKt.IntOffset(r0, r3);
    }
}
