package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.IntrinsicMeasurable;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004J$\u0010\n\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004J$\u0010\f\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004J$\u0010\r\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004J$\u0010\u000e\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004J$\u0010\u000f\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004J$\u0010\u0010\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004J$\u0010\u0011\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004¨\u0006\u0012"}, d2 = {"Landroidx/compose/foundation/layout/IntrinsicMeasureBlocks;", "", "()V", "HorizontalMaxHeight", "", "measurables", "", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "availableWidth", "mainAxisSpacing", "HorizontalMaxWidth", "availableHeight", "HorizontalMinHeight", "HorizontalMinWidth", "VerticalMaxHeight", "VerticalMaxWidth", "VerticalMinHeight", "VerticalMinWidth", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: RowColumnImpl.kt */
public final class IntrinsicMeasureBlocks {
    public static final int $stable = 0;
    public static final IntrinsicMeasureBlocks INSTANCE = new IntrinsicMeasureBlocks();

    private IntrinsicMeasureBlocks() {
    }

    public final int HorizontalMinWidth(List<? extends IntrinsicMeasurable> list, int i, int i2) {
        if (list.isEmpty()) {
            return 0;
        }
        int size = list.size();
        int i3 = 0;
        int i4 = 0;
        float f = 0.0f;
        for (int i5 = 0; i5 < size; i5++) {
            IntrinsicMeasurable intrinsicMeasurable = (IntrinsicMeasurable) list.get(i5);
            float weight = RowColumnImplKt.getWeight(RowColumnImplKt.getRowColumnParentData(intrinsicMeasurable));
            int minIntrinsicWidth = intrinsicMeasurable.minIntrinsicWidth(i);
            if (weight == 0.0f) {
                i4 += minIntrinsicWidth;
            } else if (weight > 0.0f) {
                f += weight;
                i3 = Math.max(i3, Math.round(((float) minIntrinsicWidth) / weight));
            }
        }
        return Math.round(((float) i3) * f) + i4 + ((list.size() - 1) * i2);
    }

    public final int VerticalMinWidth(List<? extends IntrinsicMeasurable> list, int i, int i2) {
        int i3;
        if (list.isEmpty()) {
            return 0;
        }
        int min = Math.min((list.size() - 1) * i2, i);
        int size = list.size();
        int i4 = 0;
        float f = 0.0f;
        for (int i5 = 0; i5 < size; i5++) {
            IntrinsicMeasurable intrinsicMeasurable = (IntrinsicMeasurable) list.get(i5);
            float weight = RowColumnImplKt.getWeight(RowColumnImplKt.getRowColumnParentData(intrinsicMeasurable));
            if (weight == 0.0f) {
                int min2 = Math.min(intrinsicMeasurable.maxIntrinsicHeight(Integer.MAX_VALUE), i == Integer.MAX_VALUE ? Integer.MAX_VALUE : i - min);
                min += min2;
                i4 = Math.max(i4, intrinsicMeasurable.minIntrinsicWidth(min2));
            } else if (weight > 0.0f) {
                f += weight;
            }
        }
        int round = f == 0.0f ? 0 : i == Integer.MAX_VALUE ? Integer.MAX_VALUE : Math.round(((float) Math.max(i - min, 0)) / f);
        int size2 = list.size();
        for (int i6 = 0; i6 < size2; i6++) {
            IntrinsicMeasurable intrinsicMeasurable2 = (IntrinsicMeasurable) list.get(i6);
            float weight2 = RowColumnImplKt.getWeight(RowColumnImplKt.getRowColumnParentData(intrinsicMeasurable2));
            if (weight2 > 0.0f) {
                if (round != Integer.MAX_VALUE) {
                    i3 = Math.round(((float) round) * weight2);
                } else {
                    i3 = Integer.MAX_VALUE;
                }
                i4 = Math.max(i4, intrinsicMeasurable2.minIntrinsicWidth(i3));
            }
        }
        return i4;
    }

    public final int HorizontalMinHeight(List<? extends IntrinsicMeasurable> list, int i, int i2) {
        int i3;
        if (list.isEmpty()) {
            return 0;
        }
        int min = Math.min((list.size() - 1) * i2, i);
        int size = list.size();
        int i4 = 0;
        float f = 0.0f;
        for (int i5 = 0; i5 < size; i5++) {
            IntrinsicMeasurable intrinsicMeasurable = (IntrinsicMeasurable) list.get(i5);
            float weight = RowColumnImplKt.getWeight(RowColumnImplKt.getRowColumnParentData(intrinsicMeasurable));
            if (weight == 0.0f) {
                int min2 = Math.min(intrinsicMeasurable.maxIntrinsicWidth(Integer.MAX_VALUE), i == Integer.MAX_VALUE ? Integer.MAX_VALUE : i - min);
                min += min2;
                i4 = Math.max(i4, intrinsicMeasurable.minIntrinsicHeight(min2));
            } else if (weight > 0.0f) {
                f += weight;
            }
        }
        int round = f == 0.0f ? 0 : i == Integer.MAX_VALUE ? Integer.MAX_VALUE : Math.round(((float) Math.max(i - min, 0)) / f);
        int size2 = list.size();
        for (int i6 = 0; i6 < size2; i6++) {
            IntrinsicMeasurable intrinsicMeasurable2 = (IntrinsicMeasurable) list.get(i6);
            float weight2 = RowColumnImplKt.getWeight(RowColumnImplKt.getRowColumnParentData(intrinsicMeasurable2));
            if (weight2 > 0.0f) {
                if (round != Integer.MAX_VALUE) {
                    i3 = Math.round(((float) round) * weight2);
                } else {
                    i3 = Integer.MAX_VALUE;
                }
                i4 = Math.max(i4, intrinsicMeasurable2.minIntrinsicHeight(i3));
            }
        }
        return i4;
    }

    public final int VerticalMinHeight(List<? extends IntrinsicMeasurable> list, int i, int i2) {
        if (list.isEmpty()) {
            return 0;
        }
        int size = list.size();
        int i3 = 0;
        int i4 = 0;
        float f = 0.0f;
        for (int i5 = 0; i5 < size; i5++) {
            IntrinsicMeasurable intrinsicMeasurable = (IntrinsicMeasurable) list.get(i5);
            float weight = RowColumnImplKt.getWeight(RowColumnImplKt.getRowColumnParentData(intrinsicMeasurable));
            int minIntrinsicHeight = intrinsicMeasurable.minIntrinsicHeight(i);
            if (weight == 0.0f) {
                i4 += minIntrinsicHeight;
            } else if (weight > 0.0f) {
                f += weight;
                i3 = Math.max(i3, Math.round(((float) minIntrinsicHeight) / weight));
            }
        }
        return Math.round(((float) i3) * f) + i4 + ((list.size() - 1) * i2);
    }

    public final int HorizontalMaxWidth(List<? extends IntrinsicMeasurable> list, int i, int i2) {
        if (list.isEmpty()) {
            return 0;
        }
        int size = list.size();
        int i3 = 0;
        int i4 = 0;
        float f = 0.0f;
        for (int i5 = 0; i5 < size; i5++) {
            IntrinsicMeasurable intrinsicMeasurable = (IntrinsicMeasurable) list.get(i5);
            float weight = RowColumnImplKt.getWeight(RowColumnImplKt.getRowColumnParentData(intrinsicMeasurable));
            int maxIntrinsicWidth = intrinsicMeasurable.maxIntrinsicWidth(i);
            if (weight == 0.0f) {
                i4 += maxIntrinsicWidth;
            } else if (weight > 0.0f) {
                f += weight;
                i3 = Math.max(i3, Math.round(((float) maxIntrinsicWidth) / weight));
            }
        }
        return Math.round(((float) i3) * f) + i4 + ((list.size() - 1) * i2);
    }

    public final int VerticalMaxWidth(List<? extends IntrinsicMeasurable> list, int i, int i2) {
        int i3;
        if (list.isEmpty()) {
            return 0;
        }
        int min = Math.min((list.size() - 1) * i2, i);
        int size = list.size();
        int i4 = 0;
        float f = 0.0f;
        for (int i5 = 0; i5 < size; i5++) {
            IntrinsicMeasurable intrinsicMeasurable = (IntrinsicMeasurable) list.get(i5);
            float weight = RowColumnImplKt.getWeight(RowColumnImplKt.getRowColumnParentData(intrinsicMeasurable));
            if (weight == 0.0f) {
                int min2 = Math.min(intrinsicMeasurable.maxIntrinsicHeight(Integer.MAX_VALUE), i == Integer.MAX_VALUE ? Integer.MAX_VALUE : i - min);
                min += min2;
                i4 = Math.max(i4, intrinsicMeasurable.maxIntrinsicWidth(min2));
            } else if (weight > 0.0f) {
                f += weight;
            }
        }
        int round = f == 0.0f ? 0 : i == Integer.MAX_VALUE ? Integer.MAX_VALUE : Math.round(((float) Math.max(i - min, 0)) / f);
        int size2 = list.size();
        for (int i6 = 0; i6 < size2; i6++) {
            IntrinsicMeasurable intrinsicMeasurable2 = (IntrinsicMeasurable) list.get(i6);
            float weight2 = RowColumnImplKt.getWeight(RowColumnImplKt.getRowColumnParentData(intrinsicMeasurable2));
            if (weight2 > 0.0f) {
                if (round != Integer.MAX_VALUE) {
                    i3 = Math.round(((float) round) * weight2);
                } else {
                    i3 = Integer.MAX_VALUE;
                }
                i4 = Math.max(i4, intrinsicMeasurable2.maxIntrinsicWidth(i3));
            }
        }
        return i4;
    }

    public final int HorizontalMaxHeight(List<? extends IntrinsicMeasurable> list, int i, int i2) {
        int i3;
        if (list.isEmpty()) {
            return 0;
        }
        int min = Math.min((list.size() - 1) * i2, i);
        int size = list.size();
        int i4 = 0;
        float f = 0.0f;
        for (int i5 = 0; i5 < size; i5++) {
            IntrinsicMeasurable intrinsicMeasurable = (IntrinsicMeasurable) list.get(i5);
            float weight = RowColumnImplKt.getWeight(RowColumnImplKt.getRowColumnParentData(intrinsicMeasurable));
            if (weight == 0.0f) {
                int min2 = Math.min(intrinsicMeasurable.maxIntrinsicWidth(Integer.MAX_VALUE), i == Integer.MAX_VALUE ? Integer.MAX_VALUE : i - min);
                min += min2;
                i4 = Math.max(i4, intrinsicMeasurable.maxIntrinsicHeight(min2));
            } else if (weight > 0.0f) {
                f += weight;
            }
        }
        int round = f == 0.0f ? 0 : i == Integer.MAX_VALUE ? Integer.MAX_VALUE : Math.round(((float) Math.max(i - min, 0)) / f);
        int size2 = list.size();
        for (int i6 = 0; i6 < size2; i6++) {
            IntrinsicMeasurable intrinsicMeasurable2 = (IntrinsicMeasurable) list.get(i6);
            float weight2 = RowColumnImplKt.getWeight(RowColumnImplKt.getRowColumnParentData(intrinsicMeasurable2));
            if (weight2 > 0.0f) {
                if (round != Integer.MAX_VALUE) {
                    i3 = Math.round(((float) round) * weight2);
                } else {
                    i3 = Integer.MAX_VALUE;
                }
                i4 = Math.max(i4, intrinsicMeasurable2.maxIntrinsicHeight(i3));
            }
        }
        return i4;
    }

    public final int VerticalMaxHeight(List<? extends IntrinsicMeasurable> list, int i, int i2) {
        if (list.isEmpty()) {
            return 0;
        }
        int size = list.size();
        int i3 = 0;
        int i4 = 0;
        float f = 0.0f;
        for (int i5 = 0; i5 < size; i5++) {
            IntrinsicMeasurable intrinsicMeasurable = (IntrinsicMeasurable) list.get(i5);
            float weight = RowColumnImplKt.getWeight(RowColumnImplKt.getRowColumnParentData(intrinsicMeasurable));
            int maxIntrinsicHeight = intrinsicMeasurable.maxIntrinsicHeight(i);
            if (weight == 0.0f) {
                i4 += maxIntrinsicHeight;
            } else if (weight > 0.0f) {
                f += weight;
                i3 = Math.max(i3, Math.round(((float) maxIntrinsicHeight) / weight));
            }
        }
        return Math.round(((float) i3) * f) + i4 + ((list.size() - 1) * i2);
    }
}
