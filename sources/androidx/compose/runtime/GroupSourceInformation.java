package androidx.compose.runtime;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0001H\u0002J\u001e\u0010#\u001a\u00020!2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\u0003J\u000e\u0010'\u001a\u00020!2\u0006\u0010(\u001a\u00020\u0003J\u000e\u0010)\u001a\u00020!2\u0006\u0010(\u001a\u00020\u0003J\u0010\u0010*\u001a\u00020\t2\u0006\u0010+\u001a\u00020,H\u0002J\b\u0010-\u001a\u00020\u0000H\u0002J\u000e\u0010.\u001a\u00020\t2\u0006\u0010+\u001a\u00020,J\u0016\u0010/\u001a\u00020!2\u0006\u00100\u001a\u0002012\u0006\u0010\"\u001a\u00020\u0003J\u0016\u0010/\u001a\u00020!2\u0006\u0010$\u001a\u00020%2\u0006\u0010\"\u001a\u00020\u0003J\u001e\u00102\u001a\u00020!2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010(\u001a\u00020\u0003R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R.\u0010\u0014\u001a\u0016\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0015j\n\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0010R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u00063"}, d2 = {"Landroidx/compose/runtime/GroupSourceInformation;", "", "key", "", "sourceInformation", "", "dataStartOffset", "(ILjava/lang/String;I)V", "closed", "", "getClosed", "()Z", "setClosed", "(Z)V", "dataEndOffset", "getDataEndOffset", "()I", "setDataEndOffset", "(I)V", "getDataStartOffset", "groups", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getGroups", "()Ljava/util/ArrayList;", "setGroups", "(Ljava/util/ArrayList;)V", "getKey", "getSourceInformation", "()Ljava/lang/String;", "setSourceInformation", "(Ljava/lang/String;)V", "add", "", "group", "addGroupAfter", "writer", "Landroidx/compose/runtime/SlotWriter;", "predecessor", "close", "dataOffset", "endGrouplessCall", "hasAnchor", "anchor", "Landroidx/compose/runtime/Anchor;", "openInformation", "removeAnchor", "reportGroup", "table", "Landroidx/compose/runtime/SlotTable;", "startGrouplessCall", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: SlotTable.kt */
public final class GroupSourceInformation {
    public static final int $stable = 8;
    private boolean closed;
    private int dataEndOffset;
    private final int dataStartOffset;
    private ArrayList<Object> groups;
    private final int key;
    private String sourceInformation;

    public GroupSourceInformation(int i, String str, int i2) {
        this.key = i;
        this.sourceInformation = str;
        this.dataStartOffset = i2;
    }

    public final int getKey() {
        return this.key;
    }

    public final String getSourceInformation() {
        return this.sourceInformation;
    }

    public final void setSourceInformation(String str) {
        this.sourceInformation = str;
    }

    public final int getDataStartOffset() {
        return this.dataStartOffset;
    }

    public final ArrayList<Object> getGroups() {
        return this.groups;
    }

    public final void setGroups(ArrayList<Object> arrayList) {
        this.groups = arrayList;
    }

    public final boolean getClosed() {
        return this.closed;
    }

    public final void setClosed(boolean z) {
        this.closed = z;
    }

    public final int getDataEndOffset() {
        return this.dataEndOffset;
    }

    public final void setDataEndOffset(int i) {
        this.dataEndOffset = i;
    }

    public final void startGrouplessCall(int i, String str, int i2) {
        openInformation().add(new GroupSourceInformation(i, str, i2));
    }

    public final void endGrouplessCall(int i) {
        openInformation().close(i);
    }

    public final void reportGroup(SlotWriter slotWriter, int i) {
        openInformation().add(slotWriter.anchor(i));
    }

    public final void reportGroup(SlotTable slotTable, int i) {
        openInformation().add(slotTable.anchor(i));
    }

    public final void addGroupAfter(SlotWriter slotWriter, int i, int i2) {
        Anchor tryAnchor$runtime_release;
        ArrayList<Object> arrayList = this.groups;
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            this.groups = arrayList;
        }
        int i3 = 0;
        if (i >= 0 && (tryAnchor$runtime_release = slotWriter.tryAnchor$runtime_release(i)) != null) {
            int size = arrayList.size();
            while (true) {
                if (i3 >= size) {
                    i3 = -1;
                    break;
                }
                Object obj = arrayList.get(i3);
                if (Intrinsics.areEqual(obj, (Object) tryAnchor$runtime_release) || ((obj instanceof GroupSourceInformation) && ((GroupSourceInformation) obj).hasAnchor(tryAnchor$runtime_release))) {
                    break;
                }
                i3++;
            }
        }
        arrayList.add(i3, slotWriter.anchor(i2));
    }

    public final void close(int i) {
        this.closed = true;
        this.dataEndOffset = i;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002a, code lost:
        r0 = r1.openInformation();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final androidx.compose.runtime.GroupSourceInformation openInformation() {
        /*
            r5 = this;
            java.util.ArrayList<java.lang.Object> r0 = r5.groups
            r1 = 0
            if (r0 == 0) goto L_0x0020
            int r2 = r0.size()
            int r2 = r2 + -1
        L_0x000b:
            if (r2 < 0) goto L_0x0020
            java.lang.Object r3 = r0.get(r2)
            boolean r4 = r3 instanceof androidx.compose.runtime.GroupSourceInformation
            if (r4 == 0) goto L_0x001d
            r4 = r3
            androidx.compose.runtime.GroupSourceInformation r4 = (androidx.compose.runtime.GroupSourceInformation) r4
            boolean r4 = r4.closed
            if (r4 != 0) goto L_0x001d
            goto L_0x0021
        L_0x001d:
            int r2 = r2 + -1
            goto L_0x000b
        L_0x0020:
            r3 = r1
        L_0x0021:
            boolean r0 = r3 instanceof androidx.compose.runtime.GroupSourceInformation
            if (r0 == 0) goto L_0x0028
            r1 = r3
            androidx.compose.runtime.GroupSourceInformation r1 = (androidx.compose.runtime.GroupSourceInformation) r1
        L_0x0028:
            if (r1 == 0) goto L_0x0031
            androidx.compose.runtime.GroupSourceInformation r0 = r1.openInformation()
            if (r0 == 0) goto L_0x0031
            return r0
        L_0x0031:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.GroupSourceInformation.openInformation():androidx.compose.runtime.GroupSourceInformation");
    }

    private final void add(Object obj) {
        ArrayList<Object> arrayList = this.groups;
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        this.groups = arrayList;
        arrayList.add(obj);
    }

    private final boolean hasAnchor(Anchor anchor) {
        ArrayList<Object> arrayList = this.groups;
        if (arrayList != null) {
            List list = arrayList;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                Object obj = list.get(i);
                if (Intrinsics.areEqual(obj, (Object) anchor)) {
                    return true;
                }
                if ((obj instanceof GroupSourceInformation) && ((GroupSourceInformation) obj).hasAnchor(anchor)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean removeAnchor(Anchor anchor) {
        ArrayList<Object> arrayList = this.groups;
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                Object obj = arrayList.get(size);
                if (obj instanceof Anchor) {
                    if (Intrinsics.areEqual(obj, (Object) anchor)) {
                        arrayList.remove(size);
                    }
                } else if ((obj instanceof GroupSourceInformation) && !((GroupSourceInformation) obj).removeAnchor(anchor)) {
                    arrayList.remove(size);
                }
            }
            if (arrayList.isEmpty()) {
                this.groups = null;
                return false;
            }
        }
        return true;
    }
}
