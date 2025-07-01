package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSizeKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002Bs\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u0012\u0006\u0010\u0010\u001a\u00020\u0004\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0006\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00000\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015¢\u0006\u0002\u0010\u0016J\u000e\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020\u0004J\u001d\u0010C\u001a\u0002032\u0006\u0010\u0003\u001a\u00020\u0004H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bD\u0010EJ\u0012\u0010F\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u0004H\u0016J\u0016\u0010G\u001a\u00020A2\u0006\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020KJ\u001e\u0010L\u001a\u00020A2\u0006\u0010<\u001a\u00020\u00042\u0006\u0010M\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u0004J(\u0010L\u001a\u00020A2\u0006\u0010'\u001a\u00020\u00042\u0006\u0010N\u001a\u00020\u00042\u0006\u0010O\u001a\u00020\u00042\u0006\u0010P\u001a\u00020\u0004H\u0016J\b\u0010Q\u001a\u00020RH\u0016J\u000e\u0010S\u001a\u00020A2\u0006\u0010&\u001a\u00020\u0004J+\u0010T\u001a\u000203*\u0002032\u0012\u0010U\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040VH\bø\u0001\u0000¢\u0006\u0004\bW\u0010XR\u000e\u0010\u0010\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00000\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0014\u001a\u00020\u0015X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u001c\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001eR\u0014\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010 R\u001a\u0010!\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010 \"\u0004\b\"\u0010#R\u0014\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001bR\u0014\u0010\r\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001eR\u000e\u0010&\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010'\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b(\u0010\u001eR\u0011\u0010)\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001eR\u0014\u0010+\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001eR\u000e\u0010-\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010/\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010 \"\u0004\b1\u0010#R&\u00104\u001a\u0002032\u0006\u00102\u001a\u000203@RX\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b5\u0010\u0018R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0004¢\u0006\u0002\n\u0000R\u0014\u00106\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b7\u0010\u001eR\u001c\u00108\u001a\u000209X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b:\u0010\u0018R\u0014\u0010\u000e\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b;\u0010\u001eR\u0018\u0010<\u001a\u00020\u0004*\u0002038BX\u0004¢\u0006\u0006\u001a\u0004\b=\u0010>R\u0019\u0010)\u001a\u00020\u0004*\u00020\t8Â\u0002X\u0004¢\u0006\u0006\u001a\u0004\b*\u0010?\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006Y"}, d2 = {"Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasuredItem;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemInfo;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasuredItem;", "index", "", "key", "", "placeables", "", "Landroidx/compose/ui/layout/Placeable;", "isVertical", "", "spacing", "lane", "span", "beforeContentPadding", "afterContentPadding", "contentType", "animator", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "(ILjava/lang/Object;Ljava/util/List;ZIIIIILjava/lang/Object;Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getConstraints-msEJaDk", "()J", "J", "getContentType", "()Ljava/lang/Object;", "crossAxisSize", "getCrossAxisSize", "()I", "getIndex", "()Z", "isVisible", "setVisible", "(Z)V", "getKey", "getLane", "mainAxisLayoutSize", "mainAxisOffset", "getMainAxisOffset", "mainAxisSize", "getMainAxisSize", "mainAxisSizeWithSpacings", "getMainAxisSizeWithSpacings", "maxMainAxisOffset", "minMainAxisOffset", "nonScrollableItem", "getNonScrollableItem", "setNonScrollableItem", "<set-?>", "Landroidx/compose/ui/unit/IntOffset;", "offset", "getOffset-nOcc-ac", "placeablesCount", "getPlaceablesCount", "size", "Landroidx/compose/ui/unit/IntSize;", "getSize-YbymL2g", "getSpan", "mainAxis", "getMainAxis--gyyYBs", "(J)I", "(Landroidx/compose/ui/layout/Placeable;)I", "applyScrollDelta", "", "delta", "getOffset", "getOffset-Bjo55l4", "(I)J", "getParentData", "place", "scope", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "context", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureContext;", "position", "crossAxis", "crossAxisOffset", "layoutWidth", "layoutHeight", "toString", "", "updateMainAxisLayoutSize", "copy", "mainAxisMap", "Lkotlin/Function1;", "copy-4Tuh3kE", "(JLkotlin/jvm/functions/Function1;)J", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyStaggeredGridMeasure.kt */
public final class LazyStaggeredGridMeasuredItem implements LazyStaggeredGridItemInfo, LazyLayoutMeasuredItem {
    public static final int $stable = 8;
    private final int afterContentPadding;
    private final LazyLayoutItemAnimator<LazyStaggeredGridMeasuredItem> animator;
    private final int beforeContentPadding;
    private final long constraints;
    private final Object contentType;
    private final int crossAxisSize;
    private final int index;
    private final boolean isVertical;
    private boolean isVisible;
    private final Object key;
    private final int lane;
    private int mainAxisLayoutSize;
    private final int mainAxisSize;
    private final int mainAxisSizeWithSpacings;
    private int maxMainAxisOffset;
    private int minMainAxisOffset;
    private boolean nonScrollableItem;
    private long offset;
    private final List<Placeable> placeables;
    private final long size;
    private final int span;

    public /* synthetic */ LazyStaggeredGridMeasuredItem(int i, Object obj, List list, boolean z, int i2, int i3, int i4, int i5, int i6, Object obj2, LazyLayoutItemAnimator lazyLayoutItemAnimator, long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, obj, list, z, i2, i3, i4, i5, i6, obj2, lazyLayoutItemAnimator, j);
    }

    private LazyStaggeredGridMeasuredItem(int i, Object obj, List<? extends Placeable> list, boolean z, int i2, int i3, int i4, int i5, int i6, Object obj2, LazyLayoutItemAnimator<LazyStaggeredGridMeasuredItem> lazyLayoutItemAnimator, long j) {
        Comparable comparable;
        long j2;
        this.index = i;
        this.key = obj;
        this.placeables = list;
        this.isVertical = z;
        this.lane = i3;
        this.span = i4;
        this.beforeContentPadding = i5;
        this.afterContentPadding = i6;
        this.contentType = obj2;
        this.animator = lazyLayoutItemAnimator;
        this.constraints = j;
        int i7 = 1;
        this.isVisible = true;
        Comparable comparable2 = null;
        int i8 = 0;
        if (list.isEmpty()) {
            comparable = null;
        } else {
            Placeable placeable = (Placeable) list.get(0);
            comparable = Integer.valueOf(isVertical() ? placeable.getHeight() : placeable.getWidth());
            int lastIndex = CollectionsKt.getLastIndex(list);
            if (1 <= lastIndex) {
                int i9 = 1;
                while (true) {
                    Placeable placeable2 = (Placeable) list.get(i9);
                    Comparable valueOf = Integer.valueOf(isVertical() ? placeable2.getHeight() : placeable2.getWidth());
                    comparable = valueOf.compareTo(comparable) > 0 ? valueOf : comparable;
                    if (i9 == lastIndex) {
                        break;
                    }
                    i9++;
                }
            }
        }
        Integer num = (Integer) comparable;
        int intValue = num != null ? num.intValue() : 0;
        this.mainAxisSize = intValue;
        this.mainAxisSizeWithSpacings = RangesKt.coerceAtLeast(intValue + i2, 0);
        List<Placeable> list2 = this.placeables;
        if (!list2.isEmpty()) {
            Placeable placeable3 = list2.get(0);
            Comparable valueOf2 = Integer.valueOf(isVertical() ? placeable3.getWidth() : placeable3.getHeight());
            int lastIndex2 = CollectionsKt.getLastIndex(list2);
            if (1 <= lastIndex2) {
                while (true) {
                    Placeable placeable4 = list2.get(i7);
                    Comparable valueOf3 = Integer.valueOf(isVertical() ? placeable4.getWidth() : placeable4.getHeight());
                    valueOf2 = valueOf3.compareTo(valueOf2) > 0 ? valueOf3 : valueOf2;
                    if (i7 == lastIndex2) {
                        break;
                    }
                    i7++;
                }
            }
            comparable2 = valueOf2;
        }
        Integer num2 = (Integer) comparable2;
        i8 = num2 != null ? num2.intValue() : i8;
        this.crossAxisSize = i8;
        this.mainAxisLayoutSize = -1;
        if (isVertical()) {
            j2 = IntSizeKt.IntSize(i8, this.mainAxisSize);
        } else {
            j2 = IntSizeKt.IntSize(this.mainAxisSize, i8);
        }
        this.size = j2;
        this.offset = IntOffset.Companion.m7251getZeronOccac();
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

    public int getLane() {
        return this.lane;
    }

    public int getSpan() {
        return this.span;
    }

    public Object getContentType() {
        return this.contentType;
    }

    /* renamed from: getConstraints-msEJaDk  reason: not valid java name */
    public long m1066getConstraintsmsEJaDk() {
        return this.constraints;
    }

    public final boolean isVisible() {
        return this.isVisible;
    }

    public final void setVisible(boolean z) {
        this.isVisible = z;
    }

    public int getPlaceablesCount() {
        return this.placeables.size();
    }

    public Object getParentData(int i) {
        return this.placeables.get(i).getParentData();
    }

    public final int getMainAxisSize() {
        return this.mainAxisSize;
    }

    public int getMainAxisSizeWithSpacings() {
        return this.mainAxisSizeWithSpacings;
    }

    public final int getCrossAxisSize() {
        return this.crossAxisSize;
    }

    public boolean getNonScrollableItem() {
        return this.nonScrollableItem;
    }

    public void setNonScrollableItem(boolean z) {
        this.nonScrollableItem = z;
    }

    /* renamed from: getSize-YbymL2g  reason: not valid java name */
    public long m1069getSizeYbymL2g() {
        return this.size;
    }

    /* renamed from: getOffset-nOcc-ac  reason: not valid java name */
    public long m1068getOffsetnOccac() {
        return this.offset;
    }

    /* renamed from: getOffset-Bjo55l4  reason: not valid java name */
    public long m1067getOffsetBjo55l4(int i) {
        return m1068getOffsetnOccac();
    }

    public final void position(int i, int i2, int i3) {
        long j;
        this.mainAxisLayoutSize = i3;
        this.minMainAxisOffset = -this.beforeContentPadding;
        this.maxMainAxisOffset = i3 + this.afterContentPadding;
        if (isVertical()) {
            j = IntOffsetKt.IntOffset(i2, i);
        } else {
            j = IntOffsetKt.IntOffset(i, i2);
        }
        this.offset = j;
    }

    public void position(int i, int i2, int i3, int i4) {
        if (isVertical()) {
            i3 = i4;
        }
        position(i, i2, i3);
    }

    public final int getMainAxisOffset() {
        return !isVertical() ? IntOffset.m7241getXimpl(m1068getOffsetnOccac()) : IntOffset.m7242getYimpl(m1068getOffsetnOccac());
    }

    public final void place(Placeable.PlacementScope placementScope, LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext) {
        GraphicsLayer graphicsLayer;
        Placeable.PlacementScope placementScope2;
        int i;
        int i2;
        if (this.mainAxisLayoutSize != -1) {
            List<Placeable> list = this.placeables;
            int size2 = list.size();
            int i3 = 0;
            while (i3 < size2) {
                Placeable placeable = list.get(i3);
                int height = this.minMainAxisOffset - (isVertical() ? placeable.getHeight() : placeable.getWidth());
                int i4 = this.maxMainAxisOffset;
                long r6 = m1068getOffsetnOccac();
                LazyLayoutItemAnimation animation = this.animator.getAnimation(getKey(), i3);
                if (animation != null) {
                    long r9 = IntOffset.m7245plusqkQi6aY(r6, animation.m978getPlacementDeltanOccac());
                    if ((m1065getMainAxisgyyYBs(r6) <= height && m1065getMainAxisgyyYBs(r9) <= height) || (m1065getMainAxisgyyYBs(r6) >= i4 && m1065getMainAxisgyyYBs(r9) >= i4)) {
                        animation.cancelPlacementAnimation();
                    }
                    graphicsLayer = animation.getLayer();
                    r6 = r9;
                } else {
                    graphicsLayer = null;
                }
                if (lazyStaggeredGridMeasureContext.getReverseLayout()) {
                    if (isVertical()) {
                        i = IntOffset.m7241getXimpl(r6);
                    } else {
                        i = (this.mainAxisLayoutSize - IntOffset.m7241getXimpl(r6)) - (isVertical() ? placeable.getHeight() : placeable.getWidth());
                    }
                    if (isVertical()) {
                        i2 = (this.mainAxisLayoutSize - IntOffset.m7242getYimpl(r6)) - (isVertical() ? placeable.getHeight() : placeable.getWidth());
                    } else {
                        i2 = IntOffset.m7242getYimpl(r6);
                    }
                    r6 = IntOffsetKt.IntOffset(i, i2);
                }
                long r62 = IntOffset.m7245plusqkQi6aY(r6, lazyStaggeredGridMeasureContext.m1048getContentOffsetnOccac());
                if (animation != null) {
                    animation.m980setFinalOffsetgyyYBs(r62);
                }
                if (graphicsLayer != null) {
                    placementScope2 = placementScope;
                    Placeable.PlacementScope.m5893placeRelativeWithLayeraW9wM$default(placementScope2, placeable, r62, graphicsLayer, 0.0f, 4, (Object) null);
                } else {
                    placementScope2 = placementScope;
                    Placeable.PlacementScope.m5892placeRelativeWithLayeraW9wM$default(placementScope2, placeable, r62, 0.0f, (Function1) null, 6, (Object) null);
                }
                i3++;
                placementScope = placementScope2;
            }
            return;
        }
        throw new IllegalArgumentException("position() should be called first".toString());
    }

    public final void updateMainAxisLayoutSize(int i) {
        this.mainAxisLayoutSize = i;
        this.maxMainAxisOffset = i + this.afterContentPadding;
    }

    public final void applyScrollDelta(int i) {
        if (!getNonScrollableItem()) {
            long r0 = m1068getOffsetnOccac();
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

    /* renamed from: getMainAxis--gyyYBs  reason: not valid java name */
    private final int m1065getMainAxisgyyYBs(long j) {
        return isVertical() ? IntOffset.m7242getYimpl(j) : IntOffset.m7241getXimpl(j);
    }

    private final int getMainAxisSize(Placeable placeable) {
        return isVertical() ? placeable.getHeight() : placeable.getWidth();
    }

    /* renamed from: copy-4Tuh3kE  reason: not valid java name */
    private final long m1064copy4Tuh3kE(long j, Function1<? super Integer, Integer> function1) {
        int r0 = isVertical() ? IntOffset.m7241getXimpl(j) : function1.invoke(Integer.valueOf(IntOffset.m7241getXimpl(j))).intValue();
        boolean isVertical2 = isVertical();
        int r3 = IntOffset.m7242getYimpl(j);
        if (isVertical2) {
            r3 = function1.invoke(Integer.valueOf(r3)).intValue();
        }
        return IntOffsetKt.IntOffset(r0, r3);
    }

    public String toString() {
        return super.toString();
    }
}
