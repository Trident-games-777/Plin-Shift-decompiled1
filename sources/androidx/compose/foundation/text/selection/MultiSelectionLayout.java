package androidx.compose.foundation.text.selection;

import androidx.collection.LongIntMap;
import androidx.collection.LongObjectMap;
import androidx.collection.LongObjectMapKt;
import androidx.collection.MutableLongObjectMap;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eJ\u0016\u0010*\u001a\b\u0012\u0004\u0012\u00020\r0+2\u0006\u0010,\u001a\u00020\rH\u0016J\u001c\u0010-\u001a\u00020.2\u0012\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020.00H\u0016J\u0010\u00101\u001a\u00020\b2\u0006\u00102\u001a\u000203H\u0002J\u0010\u00104\u001a\u00020\u000b2\u0006\u00105\u001a\u00020\u0000H\u0002J\u0012\u00106\u001a\u00020\u000b2\b\u00105\u001a\u0004\u0018\u00010\u0001H\u0016J\u0018\u00107\u001a\u00020\b2\u0006\u00108\u001a\u00020\b2\u0006\u00109\u001a\u00020\u000bH\u0002J\u0018\u0010:\u001a\u00020\b2\u0006\u00108\u001a\u00020\b2\u0006\u0010;\u001a\u00020\u000bH\u0002J\b\u0010<\u001a\u00020=H\u0016J2\u0010>\u001a\u00020.*\b\u0012\u0004\u0012\u00020\r0?2\u0006\u0010,\u001a\u00020\r2\u0006\u0010@\u001a\u00020\u00062\u0006\u0010A\u001a\u00020\b2\u0006\u0010B\u001a\u00020\bH\u0002R\u0014\u0010\u000f\u001a\u00020\u00108VX\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0015R\u0014\u0010\t\u001a\u00020\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0015R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u001eR\u0014\u0010\u001f\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b \u0010\u0015R\u0016\u0010\f\u001a\u0004\u0018\u00010\rX\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0014\u0010%\u001a\u00020\b8VX\u0004¢\u0006\u0006\u001a\u0004\b&\u0010\u0019R\u0014\u0010'\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b(\u0010\u0015R\u0014\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0019¨\u0006C"}, d2 = {"Landroidx/compose/foundation/text/selection/MultiSelectionLayout;", "Landroidx/compose/foundation/text/selection/SelectionLayout;", "selectableIdToInfoListIndex", "Landroidx/collection/LongIntMap;", "infoList", "", "Landroidx/compose/foundation/text/selection/SelectableInfo;", "startSlot", "", "endSlot", "isStartHandle", "", "previousSelection", "Landroidx/compose/foundation/text/selection/Selection;", "(Landroidx/collection/LongIntMap;Ljava/util/List;IIZLandroidx/compose/foundation/text/selection/Selection;)V", "crossStatus", "Landroidx/compose/foundation/text/selection/CrossStatus;", "getCrossStatus", "()Landroidx/compose/foundation/text/selection/CrossStatus;", "currentInfo", "getCurrentInfo", "()Landroidx/compose/foundation/text/selection/SelectableInfo;", "endInfo", "getEndInfo", "getEndSlot", "()I", "firstInfo", "getFirstInfo", "getInfoList", "()Ljava/util/List;", "()Z", "lastInfo", "getLastInfo", "getPreviousSelection", "()Landroidx/compose/foundation/text/selection/Selection;", "getSelectableIdToInfoListIndex", "()Landroidx/collection/LongIntMap;", "size", "getSize", "startInfo", "getStartInfo", "getStartSlot", "createSubSelections", "Landroidx/collection/LongObjectMap;", "selection", "forEachMiddleInfo", "", "block", "Lkotlin/Function1;", "getInfoListIndexBySelectableId", "id", "", "shouldAnyInfoRecomputeSelection", "other", "shouldRecomputeSelection", "slotToIndex", "slot", "isMinimumSlot", "startOrEndSlotToIndex", "isStartSlot", "toString", "", "createAndPutSubSelection", "Landroidx/collection/MutableLongObjectMap;", "info", "minOffset", "maxOffset", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: SelectionLayout.kt */
final class MultiSelectionLayout implements SelectionLayout {
    private final int endSlot;
    private final List<SelectableInfo> infoList;
    private final boolean isStartHandle;
    private final Selection previousSelection;
    private final LongIntMap selectableIdToInfoListIndex;
    private final int startSlot;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: SelectionLayout.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        static {
            /*
                androidx.compose.foundation.text.selection.CrossStatus[] r0 = androidx.compose.foundation.text.selection.CrossStatus.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                androidx.compose.foundation.text.selection.CrossStatus r1 = androidx.compose.foundation.text.selection.CrossStatus.COLLAPSED     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                androidx.compose.foundation.text.selection.CrossStatus r1 = androidx.compose.foundation.text.selection.CrossStatus.NOT_CROSSED     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                androidx.compose.foundation.text.selection.CrossStatus r1 = androidx.compose.foundation.text.selection.CrossStatus.CROSSED     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.MultiSelectionLayout.WhenMappings.<clinit>():void");
        }
    }

    public MultiSelectionLayout(LongIntMap longIntMap, List<SelectableInfo> list, int i, int i2, boolean z, Selection selection) {
        this.selectableIdToInfoListIndex = longIntMap;
        this.infoList = list;
        this.startSlot = i;
        this.endSlot = i2;
        this.isStartHandle = z;
        this.previousSelection = selection;
        if (list.size() <= 1) {
            throw new IllegalStateException(("MultiSelectionLayout requires an infoList size greater than 1, was " + list.size() + '.').toString());
        }
    }

    public final LongIntMap getSelectableIdToInfoListIndex() {
        return this.selectableIdToInfoListIndex;
    }

    public final List<SelectableInfo> getInfoList() {
        return this.infoList;
    }

    public int getStartSlot() {
        return this.startSlot;
    }

    public int getEndSlot() {
        return this.endSlot;
    }

    public boolean isStartHandle() {
        return this.isStartHandle;
    }

    public Selection getPreviousSelection() {
        return this.previousSelection;
    }

    public int getSize() {
        return this.infoList.size();
    }

    public CrossStatus getCrossStatus() {
        if (getStartSlot() < getEndSlot()) {
            return CrossStatus.NOT_CROSSED;
        }
        if (getStartSlot() > getEndSlot()) {
            return CrossStatus.CROSSED;
        }
        return this.infoList.get(getStartSlot() / 2).getRawCrossStatus();
    }

    public SelectableInfo getStartInfo() {
        return this.infoList.get(startOrEndSlotToIndex(getStartSlot(), true));
    }

    public SelectableInfo getEndInfo() {
        return this.infoList.get(startOrEndSlotToIndex(getEndSlot(), false));
    }

    public SelectableInfo getCurrentInfo() {
        return isStartHandle() ? getStartInfo() : getEndInfo();
    }

    public SelectableInfo getFirstInfo() {
        return getCrossStatus() == CrossStatus.CROSSED ? getEndInfo() : getStartInfo();
    }

    public SelectableInfo getLastInfo() {
        return getCrossStatus() == CrossStatus.CROSSED ? getStartInfo() : getEndInfo();
    }

    public void forEachMiddleInfo(Function1<? super SelectableInfo, Unit> function1) {
        int infoListIndexBySelectableId = getInfoListIndexBySelectableId(getFirstInfo().getSelectableId());
        int infoListIndexBySelectableId2 = getInfoListIndexBySelectableId(getLastInfo().getSelectableId());
        int i = infoListIndexBySelectableId + 1;
        if (i < infoListIndexBySelectableId2) {
            while (i < infoListIndexBySelectableId2) {
                function1.invoke(this.infoList.get(i));
                i++;
            }
        }
    }

    public boolean shouldRecomputeSelection(SelectionLayout selectionLayout) {
        if (getPreviousSelection() == null || selectionLayout == null || !(selectionLayout instanceof MultiSelectionLayout)) {
            return true;
        }
        MultiSelectionLayout multiSelectionLayout = (MultiSelectionLayout) selectionLayout;
        return (isStartHandle() == multiSelectionLayout.isStartHandle() && getStartSlot() == multiSelectionLayout.getStartSlot() && getEndSlot() == multiSelectionLayout.getEndSlot() && !shouldAnyInfoRecomputeSelection(multiSelectionLayout)) ? false : true;
    }

    private final boolean shouldAnyInfoRecomputeSelection(MultiSelectionLayout multiSelectionLayout) {
        if (getSize() != multiSelectionLayout.getSize()) {
            return true;
        }
        int size = this.infoList.size();
        for (int i = 0; i < size; i++) {
            if (this.infoList.get(i).shouldRecomputeSelection(multiSelectionLayout.infoList.get(i))) {
                return true;
            }
        }
        return false;
    }

    public LongObjectMap<Selection> createSubSelections(Selection selection) {
        if (selection.getStart().getSelectableId() != selection.getEnd().getSelectableId()) {
            MutableLongObjectMap mutableLongObjectMapOf = LongObjectMapKt.mutableLongObjectMapOf();
            Selection selection2 = selection;
            createAndPutSubSelection(mutableLongObjectMapOf, selection2, getFirstInfo(), (selection.getHandlesCrossed() ? selection.getEnd() : selection.getStart()).getOffset(), getFirstInfo().getTextLength());
            forEachMiddleInfo(new MultiSelectionLayout$createSubSelections$2$1(this, mutableLongObjectMapOf, selection2));
            createAndPutSubSelection(mutableLongObjectMapOf, selection2, getLastInfo(), 0, (selection2.getHandlesCrossed() ? selection2.getStart() : selection2.getEnd()).getOffset());
            return mutableLongObjectMapOf;
        } else if ((selection.getHandlesCrossed() && selection.getStart().getOffset() >= selection.getEnd().getOffset()) || (!selection.getHandlesCrossed() && selection.getStart().getOffset() <= selection.getEnd().getOffset())) {
            return LongObjectMapKt.longObjectMapOf(selection.getStart().getSelectableId(), selection);
        } else {
            throw new IllegalStateException(("unexpectedly miss-crossed selection: " + selection).toString());
        }
    }

    /* access modifiers changed from: private */
    public final void createAndPutSubSelection(MutableLongObjectMap<Selection> mutableLongObjectMap, Selection selection, SelectableInfo selectableInfo, int i, int i2) {
        Selection selection2;
        if (selection.getHandlesCrossed()) {
            selection2 = selectableInfo.makeSingleLayoutSelection(i2, i);
        } else {
            selection2 = selectableInfo.makeSingleLayoutSelection(i, i2);
        }
        if (i <= i2) {
            mutableLongObjectMap.put(selectableInfo.getSelectableId(), selection2);
            return;
        }
        throw new IllegalStateException(("minOffset should be less than or equal to maxOffset: " + selection2).toString());
    }

    public String toString() {
        boolean z = true;
        float f = (float) 2;
        StringBuilder append = new StringBuilder("MultiSelectionLayout(isStartHandle=").append(isStartHandle()).append(", startPosition=").append(((float) (getStartSlot() + 1)) / f).append(", endPosition=").append(((float) (getEndSlot() + 1)) / f).append(", crossed=").append(getCrossStatus()).append(", infos=");
        StringBuilder sb = new StringBuilder("[\n\t");
        List<SelectableInfo> list = this.infoList;
        int size = list.size();
        int i = 0;
        while (i < size) {
            SelectableInfo selectableInfo = list.get(i);
            if (z) {
                z = false;
            } else {
                sb.append(",\n\t");
            }
            i++;
            sb.append(i + " -> " + selectableInfo);
        }
        sb.append("\n]");
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return append.append(sb2).append(')').toString();
    }

    private final int startOrEndSlotToIndex(int i, boolean z) {
        int i2 = WhenMappings.$EnumSwitchMapping$0[getCrossStatus().ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    throw new NoWhenBranchMatchedException();
                } else if (z) {
                    z = false;
                }
            }
            return slotToIndex(i, z);
        }
        z = true;
        return slotToIndex(i, z);
    }

    private final int slotToIndex(int i, boolean z) {
        return (i - (z ^ true ? 1 : 0)) / 2;
    }

    private final int getInfoListIndexBySelectableId(long j) {
        try {
            return this.selectableIdToInfoListIndex.get(j);
        } catch (NoSuchElementException e) {
            throw new IllegalStateException("Invalid selectableId: " + j, e);
        }
    }
}
