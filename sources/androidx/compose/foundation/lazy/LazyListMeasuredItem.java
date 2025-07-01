package androidx.compose.foundation.lazy;

import androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u0015\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0001\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\t\u0012\u0006\u0010\u0011\u001a\u00020\u0004\u0012\u0006\u0010\u0012\u001a\u00020\u0004\u0012\u0006\u0010\u0013\u001a\u00020\u0004\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00000\u001a\u0012\u0006\u0010\u001b\u001a\u00020\u001c¢\u0006\u0002\u0010\u001dJ\u0016\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020\u00042\u0006\u0010H\u001a\u00020\tJ\u001d\u00106\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u0004H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bI\u0010JJ\u0012\u0010K\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0003\u001a\u00020\u0004H\u0016J\u0016\u0010L\u001a\u00020F2\u0006\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020\tJ\u001e\u0010P\u001a\u00020F2\u0006\u0010Q\u001a\u00020\u00042\u0006\u0010R\u001a\u00020\u00042\u0006\u0010S\u001a\u00020\u0004J(\u0010P\u001a\u00020F2\u0006\u0010Q\u001a\u00020\u00042\u0006\u0010T\u001a\u00020\u00042\u0006\u0010R\u001a\u00020\u00042\u0006\u0010S\u001a\u00020\u0004H\u0016J\u000e\u0010U\u001a\u00020F2\u0006\u0010+\u001a\u00020\u0004J+\u0010V\u001a\u00020\u0015*\u00020\u00152\u0012\u0010W\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040XH\bø\u0001\u0000¢\u0006\u0004\bY\u0010ZR\u000e\u0010\u0012\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00000\u001aX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u001b\u001a\u00020\u001cX\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010 \u001a\u0004\b\u001e\u0010\u001fR\u0016\u0010\u0018\u001a\u0004\u0018\u00010\u0017X\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010#\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010%R\u0014\u0010\b\u001a\u00020\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010'R\u0014\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\"R\u0014\u0010)\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b*\u0010%R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010,\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010%R\u000e\u0010.\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u001a\u00100\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010'\"\u0004\b2\u00103R\u001e\u00105\u001a\u00020\u00042\u0006\u00104\u001a\u00020\u0004@RX\u000e¢\u0006\b\n\u0000\u001a\u0004\b6\u0010%R\u000e\u00107\u001a\u000208X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u00109\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b:\u0010%R\u000e\u0010\u0010\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010;\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b<\u0010%R\u000e\u0010\u0013\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010=\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b>\u0010%R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\u00020\u0015X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010 R\u0018\u0010?\u001a\u00020\u0004*\u00020\u00158BX\u0004¢\u0006\u0006\u001a\u0004\b@\u0010AR\u0018\u0010B\u001a\u00020\u0004*\u00020\u00078BX\u0004¢\u0006\u0006\u001a\u0004\bC\u0010D\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006["}, d2 = {"Landroidx/compose/foundation/lazy/LazyListMeasuredItem;", "Landroidx/compose/foundation/lazy/LazyListItemInfo;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasuredItem;", "index", "", "placeables", "", "Landroidx/compose/ui/layout/Placeable;", "isVertical", "", "horizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "verticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "reverseLayout", "beforeContentPadding", "afterContentPadding", "spacing", "visualOffset", "Landroidx/compose/ui/unit/IntOffset;", "key", "", "contentType", "animator", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "(ILjava/util/List;ZLandroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/ui/unit/LayoutDirection;ZIIIJLjava/lang/Object;Ljava/lang/Object;Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getConstraints-msEJaDk", "()J", "J", "getContentType", "()Ljava/lang/Object;", "crossAxisSize", "getCrossAxisSize", "()I", "getIndex", "()Z", "getKey", "lane", "getLane", "mainAxisLayoutSize", "mainAxisSizeWithSpacings", "getMainAxisSizeWithSpacings", "maxMainAxisOffset", "minMainAxisOffset", "nonScrollableItem", "getNonScrollableItem", "setNonScrollableItem", "(Z)V", "<set-?>", "offset", "getOffset", "placeableOffsets", "", "placeablesCount", "getPlaceablesCount", "size", "getSize", "span", "getSpan", "mainAxis", "getMainAxis--gyyYBs", "(J)I", "mainAxisSize", "getMainAxisSize", "(Landroidx/compose/ui/layout/Placeable;)I", "applyScrollDelta", "", "delta", "updateAnimations", "getOffset-Bjo55l4", "(I)J", "getParentData", "place", "scope", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "isLookingAhead", "position", "mainAxisOffset", "layoutWidth", "layoutHeight", "crossAxisOffset", "updateMainAxisLayoutSize", "copy", "mainAxisMap", "Lkotlin/Function1;", "copy-4Tuh3kE", "(JLkotlin/jvm/functions/Function1;)J", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyListMeasuredItem.kt */
public final class LazyListMeasuredItem implements LazyListItemInfo, LazyLayoutMeasuredItem {
    public static final int $stable = 8;
    private final int afterContentPadding;
    private final LazyLayoutItemAnimator<LazyListMeasuredItem> animator;
    private final int beforeContentPadding;
    private final long constraints;
    private final Object contentType;
    private final int crossAxisSize;
    private final Alignment.Horizontal horizontalAlignment;
    private final int index;
    private final boolean isVertical;
    private final Object key;
    private final int lane;
    private final LayoutDirection layoutDirection;
    private int mainAxisLayoutSize;
    private final int mainAxisSizeWithSpacings;
    private int maxMainAxisOffset;
    private int minMainAxisOffset;
    private boolean nonScrollableItem;
    private int offset;
    private final int[] placeableOffsets;
    private final List<Placeable> placeables;
    private final boolean reverseLayout;
    private final int size;
    private final int spacing;
    private final int span;
    private final Alignment.Vertical verticalAlignment;
    private final long visualOffset;

    public /* synthetic */ LazyListMeasuredItem(int i, List list, boolean z, Alignment.Horizontal horizontal, Alignment.Vertical vertical, LayoutDirection layoutDirection2, boolean z2, int i2, int i3, int i4, long j, Object obj, Object obj2, LazyLayoutItemAnimator lazyLayoutItemAnimator, long j2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, list, z, horizontal, vertical, layoutDirection2, z2, i2, i3, i4, j, obj, obj2, lazyLayoutItemAnimator, j2);
    }

    private LazyListMeasuredItem(int i, List<? extends Placeable> list, boolean z, Alignment.Horizontal horizontal, Alignment.Vertical vertical, LayoutDirection layoutDirection2, boolean z2, int i2, int i3, int i4, long j, Object obj, Object obj2, LazyLayoutItemAnimator<LazyListMeasuredItem> lazyLayoutItemAnimator, long j2) {
        this.index = i;
        this.placeables = list;
        this.isVertical = z;
        this.horizontalAlignment = horizontal;
        this.verticalAlignment = vertical;
        this.layoutDirection = layoutDirection2;
        this.reverseLayout = z2;
        this.beforeContentPadding = i2;
        this.afterContentPadding = i3;
        this.spacing = i4;
        this.visualOffset = j;
        this.key = obj;
        this.contentType = obj2;
        this.animator = lazyLayoutItemAnimator;
        this.constraints = j2;
        this.span = 1;
        this.mainAxisLayoutSize = Integer.MIN_VALUE;
        int size2 = list.size();
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < size2; i7++) {
            Placeable placeable = (Placeable) list.get(i7);
            i5 += isVertical() ? placeable.getHeight() : placeable.getWidth();
            i6 = Math.max(i6, !isVertical() ? placeable.getHeight() : placeable.getWidth());
        }
        this.size = i5;
        this.mainAxisSizeWithSpacings = RangesKt.coerceAtLeast(getSize() + this.spacing, 0);
        this.crossAxisSize = i6;
        this.placeableOffsets = new int[(this.placeables.size() * 2)];
    }

    public int getIndex() {
        return this.index;
    }

    public boolean isVertical() {
        return this.isVertical;
    }

    public Object getKey() {
        return this.key;
    }

    public Object getContentType() {
        return this.contentType;
    }

    /* renamed from: getConstraints-msEJaDk  reason: not valid java name */
    public long m918getConstraintsmsEJaDk() {
        return this.constraints;
    }

    public int getOffset() {
        return this.offset;
    }

    public int getSize() {
        return this.size;
    }

    public int getLane() {
        return this.lane;
    }

    public int getSpan() {
        return this.span;
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

    public int getPlaceablesCount() {
        return this.placeables.size();
    }

    public Object getParentData(int i) {
        return this.placeables.get(i).getParentData();
    }

    public void position(int i, int i2, int i3, int i4) {
        position(i, i3, i4);
    }

    public final void position(int i, int i2, int i3) {
        int i4;
        this.offset = i;
        this.mainAxisLayoutSize = isVertical() ? i3 : i2;
        List<Placeable> list = this.placeables;
        int size2 = list.size();
        for (int i5 = 0; i5 < size2; i5++) {
            Placeable placeable = list.get(i5);
            int i6 = i5 * 2;
            if (isVertical()) {
                int[] iArr = this.placeableOffsets;
                Alignment.Horizontal horizontal = this.horizontalAlignment;
                if (horizontal != null) {
                    iArr[i6] = horizontal.align(placeable.getWidth(), i2, this.layoutDirection);
                    this.placeableOffsets[i6 + 1] = i;
                    i4 = placeable.getHeight();
                } else {
                    throw new IllegalArgumentException("null horizontalAlignment when isVertical == true".toString());
                }
            } else {
                int[] iArr2 = this.placeableOffsets;
                iArr2[i6] = i;
                int i7 = i6 + 1;
                Alignment.Vertical vertical = this.verticalAlignment;
                if (vertical != null) {
                    iArr2[i7] = vertical.align(placeable.getHeight(), i3);
                    i4 = placeable.getWidth();
                } else {
                    throw new IllegalArgumentException("null verticalAlignment when isVertical == false".toString());
                }
            }
            i += i4;
        }
        this.minMainAxisOffset = -this.beforeContentPadding;
        this.maxMainAxisOffset = this.mainAxisLayoutSize + this.afterContentPadding;
    }

    public final void updateMainAxisLayoutSize(int i) {
        this.mainAxisLayoutSize = i;
        this.maxMainAxisOffset = i + this.afterContentPadding;
    }

    /* renamed from: getOffset-Bjo55l4  reason: not valid java name */
    public long m919getOffsetBjo55l4(int i) {
        int[] iArr = this.placeableOffsets;
        int i2 = i * 2;
        return IntOffsetKt.IntOffset(iArr[i2], iArr[i2 + 1]);
    }

    public final void applyScrollDelta(int i, boolean z) {
        if (!getNonScrollableItem()) {
            this.offset = getOffset() + i;
            int length = this.placeableOffsets.length;
            for (int i2 = 0; i2 < length; i2++) {
                if ((isVertical() && i2 % 2 == 1) || (!isVertical() && i2 % 2 == 0)) {
                    int[] iArr = this.placeableOffsets;
                    iArr[i2] = iArr[i2] + i;
                }
            }
            if (z) {
                int placeablesCount = getPlaceablesCount();
                for (int i3 = 0; i3 < placeablesCount; i3++) {
                    LazyLayoutItemAnimation animation = this.animator.getAnimation(getKey(), i3);
                    if (animation != null) {
                        long r2 = animation.m979getRawOffsetnOccac();
                        int r4 = isVertical() ? IntOffset.m7241getXimpl(r2) : Integer.valueOf(IntOffset.m7241getXimpl(r2) + i).intValue();
                        boolean isVertical2 = isVertical();
                        int r22 = IntOffset.m7242getYimpl(r2);
                        if (isVertical2) {
                            r22 += i;
                        }
                        animation.m982setRawOffsetgyyYBs(IntOffsetKt.IntOffset(r4, r22));
                    }
                }
            }
        }
    }

    public final void place(Placeable.PlacementScope placementScope, boolean z) {
        GraphicsLayer graphicsLayer;
        Placeable.PlacementScope placementScope2;
        int i;
        int i2;
        if (this.mainAxisLayoutSize != Integer.MIN_VALUE) {
            int placeablesCount = getPlaceablesCount();
            int i3 = 0;
            while (i3 < placeablesCount) {
                Placeable placeable = this.placeables.get(i3);
                int mainAxisSize = this.minMainAxisOffset - getMainAxisSize(placeable);
                int i4 = this.maxMainAxisOffset;
                long r5 = m919getOffsetBjo55l4(i3);
                LazyLayoutItemAnimation animation = this.animator.getAnimation(getKey(), i3);
                if (animation != null) {
                    if (z) {
                        animation.m981setLookaheadOffsetgyyYBs(r5);
                    } else {
                        if (!IntOffset.m7240equalsimpl0(animation.m977getLookaheadOffsetnOccac(), LazyLayoutItemAnimation.Companion.m983getNotInitializednOccac())) {
                            r5 = animation.m977getLookaheadOffsetnOccac();
                        }
                        long r8 = IntOffset.m7245plusqkQi6aY(r5, animation.m978getPlacementDeltanOccac());
                        if ((m917getMainAxisgyyYBs(r5) <= mainAxisSize && m917getMainAxisgyyYBs(r8) <= mainAxisSize) || (m917getMainAxisgyyYBs(r5) >= i4 && m917getMainAxisgyyYBs(r8) >= i4)) {
                            animation.cancelPlacementAnimation();
                        }
                        r5 = r8;
                    }
                    graphicsLayer = animation.getLayer();
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
                if (!z && animation != null) {
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
    private final int m917getMainAxisgyyYBs(long j) {
        return isVertical() ? IntOffset.m7242getYimpl(j) : IntOffset.m7241getXimpl(j);
    }

    private final int getMainAxisSize(Placeable placeable) {
        return isVertical() ? placeable.getHeight() : placeable.getWidth();
    }

    /* renamed from: copy-4Tuh3kE  reason: not valid java name */
    private final long m916copy4Tuh3kE(long j, Function1<? super Integer, Integer> function1) {
        int r0 = isVertical() ? IntOffset.m7241getXimpl(j) : function1.invoke(Integer.valueOf(IntOffset.m7241getXimpl(j))).intValue();
        boolean isVertical2 = isVertical();
        int r3 = IntOffset.m7242getYimpl(j);
        if (isVertical2) {
            r3 = function1.invoke(Integer.valueOf(r3)).intValue();
        }
        return IntOffsetKt.IntOffset(r0, r3);
    }
}
