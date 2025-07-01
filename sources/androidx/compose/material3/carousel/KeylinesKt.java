package androidx.compose.material3.carousel;

import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u001a \u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0001H\u0002\u001a0\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\fH\u0000\u001aD\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00012\b\b\u0002\u0010\u0014\u001a\u00020\u0001H\u0000\u001a(\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u0001H\u0000¨\u0006\u0017"}, d2 = {"calculateMediumChildSize", "", "minimumMediumSize", "largeItemSize", "remainingSpace", "createLeftAlignedKeylineList", "Landroidx/compose/material3/carousel/KeylineList;", "carouselMainAxisSize", "itemSpacing", "leftAnchorSize", "rightAnchorSize", "arrangement", "Landroidx/compose/material3/carousel/Arrangement;", "multiBrowseKeylineList", "density", "Landroidx/compose/ui/unit/Density;", "preferredItemSize", "itemCount", "", "minSmallItemSize", "maxSmallItemSize", "uncontainedKeylineList", "itemSize", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Keylines.kt */
public final class KeylinesKt {
    public static /* synthetic */ KeylineList multiBrowseKeylineList$default(Density density, float f, float f2, float f3, int i, float f4, float f5, int i2, Object obj) {
        if ((i2 & 32) != 0) {
            f4 = density.m7091toPx0680j_4(CarouselDefaults.INSTANCE.m2892getMinSmallItemSizeD9Ej5fM$material3_release());
        }
        float f6 = f4;
        if ((i2 & 64) != 0) {
            f5 = density.m7091toPx0680j_4(CarouselDefaults.INSTANCE.m2891getMaxSmallItemSizeD9Ej5fM$material3_release());
        }
        return multiBrowseKeylineList(density, f, f2, f3, i, f6, f5);
    }

    public static final KeylineList multiBrowseKeylineList(Density density, float f, float f2, float f3, int i, float f4, float f5) {
        float f6;
        float f7 = f;
        float f8 = f2;
        int i2 = i;
        float f9 = f4;
        float f10 = f5;
        if (f7 == 0.0f || f8 == 0.0f) {
            return KeylineListKt.emptyKeylineList();
        }
        int[] iArr = {1};
        int[] iArr2 = {1, 0};
        float min = Math.min(f8, f7);
        float coerceIn = RangesKt.coerceIn(min / 3.0f, f9, f10);
        float f11 = (min + coerceIn) / 2.0f;
        if (f7 < ((float) 2) * f9) {
            iArr = new int[]{0};
        }
        int[] iArr3 = iArr;
        int max = Math.max(1, (int) ((float) Math.floor((double) (((f7 - (((float) ArraysKt.maxOrThrow(iArr2)) * f11)) - (((float) ArraysKt.maxOrThrow(iArr3)) * f10)) / min))));
        int ceil = (int) ((float) Math.ceil((double) (f7 / min)));
        int i3 = (ceil - max) + 1;
        int i4 = ceil;
        int[] iArr4 = new int[i3];
        for (int i5 = 0; i5 < i3; i5++) {
            iArr4[i5] = i4 - i5;
        }
        float r15 = density.m7091toPx0680j_4(CarouselDefaults.INSTANCE.m2890getAnchorSizeD9Ej5fM$material3_release());
        float f12 = coerceIn;
        Arrangement findLowestCostArrangement = Arrangement.Companion.findLowestCostArrangement(f7, f3, f12, f9, f10, iArr3, f11, iArr2, min, iArr4);
        if (findLowestCostArrangement == null || findLowestCostArrangement.itemCount() <= i2) {
            f6 = f;
        } else {
            int smallCount = findLowestCostArrangement.getSmallCount();
            int mediumCount = findLowestCostArrangement.getMediumCount();
            for (int itemCount = findLowestCostArrangement.itemCount() - i2; itemCount > 0; itemCount--) {
                if (smallCount > 0) {
                    smallCount--;
                } else if (mediumCount > 1) {
                    mediumCount--;
                }
            }
            int[] iArr5 = {mediumCount};
            f6 = f;
            findLowestCostArrangement = Arrangement.Companion.findLowestCostArrangement(f6, f3, f12, f4, f5, new int[]{smallCount}, f11, iArr5, min, iArr4);
        }
        if (findLowestCostArrangement == null) {
            return KeylineListKt.emptyKeylineList();
        }
        return createLeftAlignedKeylineList(f6, f3, r15, r15, findLowestCostArrangement);
    }

    public static final KeylineList createLeftAlignedKeylineList(float f, float f2, float f3, float f4, Arrangement arrangement) {
        return KeylineListKt.m2900keylineListOfWNYm7Xg(f, f2, CarouselAlignment.Companion.m2889getStartNUL3oTo(), new KeylinesKt$createLeftAlignedKeylineList$1(f3, arrangement, f4));
    }

    public static final KeylineList uncontainedKeylineList(Density density, float f, float f2, float f3) {
        if (f == 0.0f || f2 == 0.0f) {
            return KeylineListKt.emptyKeylineList();
        }
        float min = Math.min(f2 + f3, f);
        int i = 1;
        int max = Math.max(1, (int) ((float) Math.floor((double) (f / min))));
        float f4 = f - (((float) max) * min);
        if (f4 <= 0.0f) {
            i = 0;
        }
        float r10 = density.m7091toPx0680j_4(CarouselDefaults.INSTANCE.m2890getAnchorSizeD9Ej5fM$material3_release());
        float calculateMediumChildSize = calculateMediumChildSize(r10, min, f4);
        return createLeftAlignedKeylineList(f, f3, Math.max(Math.min(r10, f2), calculateMediumChildSize * 0.5f), r10, new Arrangement(0, 0.0f, 0, calculateMediumChildSize, i, min, max));
    }

    private static final float calculateMediumChildSize(float f, float f2, float f3) {
        float max = Math.max(1.5f * f3, f);
        float f4 = f2 * 0.85f;
        return max > f4 ? Math.max(f4, f3 * 1.2f) : max;
    }
}
