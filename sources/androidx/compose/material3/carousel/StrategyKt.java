package androidx.compose.material3.carousel;

import androidx.collection.FloatList;
import androidx.collection.FloatListKt;
import androidx.collection.MutableFloatList;
import androidx.compose.ui.util.MathHelpersKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010!\n\u0000\u001a8\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002\u001a.\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00010\f2\u0006\u0010\r\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004H\u0002\u001a\u001e\u0010\u000f\u001a\u00020\u00042\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00010\f2\u0006\u0010\u000e\u001a\u00020\u0004H\u0002\u001a \u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0004H\u0002\u001a.\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00010\f2\u0006\u0010\r\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004H\u0002\u001a\u001e\u0010\u0019\u001a\u00020\u00042\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00010\f2\u0006\u0010\u0018\u001a\u00020\u0004H\u0002\u001a&\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u00042\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00010\f2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002\u001a0\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u0004H\u0002\u001a0\u0010&\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010'\u001a\u00020\n2\u0006\u0010(\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002\u001a(\u0010)\u001a\b\u0012\u0004\u0012\u00020\b0**\b\u0012\u0004\u0012\u00020\b0*2\u0006\u0010'\u001a\u00020\n2\u0006\u0010(\u001a\u00020\nH\u0002¨\u0006+"}, d2 = {"createShiftedKeylineListForContentPadding", "Landroidx/compose/material3/carousel/KeylineList;", "from", "carouselMainAxisSize", "", "itemSpacing", "contentPadding", "pivot", "Landroidx/compose/material3/carousel/Keyline;", "pivotIndex", "", "getEndKeylineSteps", "", "defaultKeylines", "afterContentPadding", "getEndShiftDistance", "endKeylineSteps", "getShiftPointRange", "Landroidx/compose/material3/carousel/ShiftPointRange;", "stepsCount", "shiftPoint", "Landroidx/collection/FloatList;", "interpolation", "getStartKeylineSteps", "beforeContentPadding", "getStartShiftDistance", "startKeylineSteps", "getStepInterpolationPoints", "totalShiftDistance", "steps", "isShiftingLeft", "", "lerp", "outputMin", "outputMax", "inputMin", "inputMax", "value", "moveKeylineAndCreateShiftedKeylineList", "srcIndex", "dstIndex", "move", "", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Strategy.kt */
public final class StrategyKt {
    /* access modifiers changed from: private */
    public static final float getStartShiftDistance(List<KeylineList> list, float f) {
        if (list.isEmpty()) {
            return 0.0f;
        }
        return Math.max(((Keyline) CollectionsKt.first((List) CollectionsKt.last(list))).getUnadjustedOffset() - ((Keyline) CollectionsKt.first((List) CollectionsKt.first(list))).getUnadjustedOffset(), f);
    }

    /* access modifiers changed from: private */
    public static final float getEndShiftDistance(List<KeylineList> list, float f) {
        if (list.isEmpty()) {
            return 0.0f;
        }
        return Math.max(((Keyline) CollectionsKt.last((List) CollectionsKt.first(list))).getUnadjustedOffset() - ((Keyline) CollectionsKt.last((List) CollectionsKt.last(list))).getUnadjustedOffset(), f);
    }

    /* access modifiers changed from: private */
    public static final List<KeylineList> getStartKeylineSteps(KeylineList keylineList, float f, float f2, float f3) {
        if (keylineList.isEmpty()) {
            return CollectionsKt.emptyList();
        }
        List<KeylineList> arrayList = new ArrayList<>();
        arrayList.add(keylineList);
        if (!keylineList.isFirstFocalItemAtStartOfContainer()) {
            float f4 = f;
            float f5 = f2;
            float f6 = f3;
            int firstNonAnchorIndex = keylineList.getFirstNonAnchorIndex();
            int firstFocalIndex = keylineList.getFirstFocalIndex() - firstNonAnchorIndex;
            if (firstFocalIndex > 0 || keylineList.getFirstFocal().getCutoff() <= 0.0f) {
                for (int i = 0; i < firstFocalIndex; i++) {
                    KeylineList keylineList2 = (KeylineList) CollectionsKt.last(arrayList);
                    int i2 = firstNonAnchorIndex + i;
                    int lastIndex = CollectionsKt.getLastIndex(keylineList);
                    if (i2 > 0) {
                        lastIndex = keylineList2.firstIndexAfterFocalRangeWithSize(keylineList.get(i2 - 1).getSize()) - 1;
                    }
                    arrayList.add(moveKeylineAndCreateShiftedKeylineList(keylineList2, keylineList.getFirstNonAnchorIndex(), lastIndex, f4, f5));
                }
                if (f6 == 0.0f) {
                    return arrayList;
                }
                float f7 = f6;
                float f8 = f5;
                arrayList.set(CollectionsKt.getLastIndex(arrayList), createShiftedKeylineListForContentPadding((KeylineList) CollectionsKt.last(arrayList), f4, f8, f7, ((KeylineList) CollectionsKt.last(arrayList)).getFirstFocal(), ((KeylineList) CollectionsKt.last(arrayList)).getFirstFocalIndex()));
                return arrayList;
            }
            arrayList.add(moveKeylineAndCreateShiftedKeylineList(keylineList, 0, 0, f4, f5));
            return arrayList;
        } else if (f3 == 0.0f) {
            return arrayList;
        } else {
            arrayList.add(createShiftedKeylineListForContentPadding(keylineList, f, f2, f3, keylineList.getFirstFocal(), keylineList.getFirstFocalIndex()));
            return arrayList;
        }
    }

    /* access modifiers changed from: private */
    public static final List<KeylineList> getEndKeylineSteps(KeylineList keylineList, float f, float f2, float f3) {
        if (keylineList.isEmpty()) {
            return CollectionsKt.emptyList();
        }
        List<KeylineList> arrayList = new ArrayList<>();
        arrayList.add(keylineList);
        if (!keylineList.isLastFocalItemAtEndOfContainer(f)) {
            float f4 = f;
            float f5 = f2;
            int lastFocalIndex = keylineList.getLastFocalIndex();
            int lastNonAnchorIndex = keylineList.getLastNonAnchorIndex();
            int i = lastNonAnchorIndex - lastFocalIndex;
            if (i > 0 || keylineList.getLastFocal().getCutoff() <= 0.0f) {
                for (int i2 = 0; i2 < i; i2++) {
                    KeylineList keylineList2 = (KeylineList) CollectionsKt.last(arrayList);
                    int i3 = lastNonAnchorIndex - i2;
                    arrayList.add(moveKeylineAndCreateShiftedKeylineList(keylineList2, keylineList.getLastNonAnchorIndex(), i3 < CollectionsKt.getLastIndex(keylineList) ? keylineList2.lastIndexBeforeFocalRangeWithSize(keylineList.get(i3 + 1).getSize()) + 1 : 0, f4, f5));
                }
                if (f3 == 0.0f) {
                    return arrayList;
                }
                arrayList.set(CollectionsKt.getLastIndex(arrayList), createShiftedKeylineListForContentPadding((KeylineList) CollectionsKt.last(arrayList), f4, f5, -f3, ((KeylineList) CollectionsKt.last(arrayList)).getLastFocal(), ((KeylineList) CollectionsKt.last(arrayList)).getLastFocalIndex()));
                return arrayList;
            }
            arrayList.add(moveKeylineAndCreateShiftedKeylineList(keylineList, 0, 0, f4, f5));
            return arrayList;
        } else if (f3 == 0.0f) {
            return arrayList;
        } else {
            arrayList.add(createShiftedKeylineListForContentPadding(keylineList, f, f2, -f3, keylineList.getLastFocal(), keylineList.getLastFocalIndex()));
            return arrayList;
        }
    }

    private static final KeylineList createShiftedKeylineListForContentPadding(KeylineList keylineList, float f, float f2, float f3, Keyline keyline, int i) {
        KeylineList keylineList2 = keylineList;
        List list = keylineList2;
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            Object obj = list.get(i2);
            if (!((Keyline) obj).isAnchor()) {
                arrayList.add(obj);
            }
        }
        float size2 = f3 / ((float) arrayList.size());
        List keylineListOf = KeylineListKt.keylineListOf(f, f2, i, (keyline.getOffset() - (size2 / 2.0f)) + f3, new StrategyKt$createShiftedKeylineListForContentPadding$newKeylines$1(keylineList2, size2));
        ArrayList arrayList2 = new ArrayList(keylineListOf.size());
        int size3 = keylineListOf.size();
        for (int i3 = 0; i3 < size3; i3++) {
            arrayList2.add(Keyline.copy$default((Keyline) keylineListOf.get(i3), 0.0f, 0.0f, keylineList2.get(i3).getUnadjustedOffset(), false, false, false, 0.0f, 123, (Object) null));
        }
        return new KeylineList(arrayList2);
    }

    private static final KeylineList moveKeylineAndCreateShiftedKeylineList(KeylineList keylineList, int i, int i2, float f, float f2) {
        int i3 = i > i2 ? 1 : -1;
        return KeylineListKt.keylineListOf(f, f2, keylineList.getPivotIndex() + i3, keylineList.getPivot().getOffset() + (((keylineList.get(i).getSize() - keylineList.get(i).getCutoff()) + f2) * ((float) i3)), new StrategyKt$moveKeylineAndCreateShiftedKeylineList$1(keylineList, i, i2));
    }

    /* access modifiers changed from: private */
    public static final FloatList getStepInterpolationPoints(float f, List<KeylineList> list, boolean z) {
        float f2;
        MutableFloatList mutableFloatListOf = FloatListKt.mutableFloatListOf(0.0f);
        if (f == 0.0f || list.isEmpty()) {
            return mutableFloatListOf;
        }
        Iterable until = RangesKt.until(1, list.size());
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(until, 10));
        Iterator it = until.iterator();
        while (it.hasNext()) {
            int nextInt = ((IntIterator) it).nextInt();
            int i = nextInt - 1;
            KeylineList keylineList = list.get(i);
            KeylineList keylineList2 = list.get(nextInt);
            if (z) {
                f2 = ((Keyline) CollectionsKt.first(keylineList2)).getUnadjustedOffset() - ((Keyline) CollectionsKt.first(keylineList)).getUnadjustedOffset();
            } else {
                f2 = ((Keyline) CollectionsKt.last(keylineList)).getUnadjustedOffset() - ((Keyline) CollectionsKt.last(keylineList2)).getUnadjustedOffset();
            }
            arrayList.add(Boolean.valueOf(mutableFloatListOf.add(nextInt == CollectionsKt.getLastIndex(list) ? 1.0f : mutableFloatListOf.get(i) + (f2 / f))));
        }
        List list2 = (List) arrayList;
        return mutableFloatListOf;
    }

    /* access modifiers changed from: private */
    public static final ShiftPointRange getShiftPointRange(int i, FloatList floatList, float f) {
        float f2 = floatList.get(0);
        Iterator it = RangesKt.until(1, i).iterator();
        while (it.hasNext()) {
            int nextInt = ((IntIterator) it).nextInt();
            float f3 = floatList.get(nextInt);
            if (f <= f3) {
                return new ShiftPointRange(nextInt - 1, nextInt, lerp(0.0f, 1.0f, f2, f3, f));
            }
            f2 = f3;
        }
        return new ShiftPointRange(0, 0, 0.0f);
    }

    /* access modifiers changed from: private */
    public static final List<Keyline> move(List<Keyline> list, int i, int i2) {
        list.remove(i);
        list.add(i2, list.get(i));
        return list;
    }

    /* access modifiers changed from: private */
    public static final float lerp(float f, float f2, float f3, float f4, float f5) {
        if (f5 <= f3) {
            return f;
        }
        return f5 >= f4 ? f2 : MathHelpersKt.lerp(f, f2, (f5 - f3) / (f4 - f3));
    }
}
