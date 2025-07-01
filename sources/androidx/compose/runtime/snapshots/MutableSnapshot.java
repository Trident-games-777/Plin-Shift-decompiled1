package androidx.compose.runtime.snapshots;

import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterSet;
import androidx.collection.ScatterSetKt;
import androidx.compose.runtime.PreconditionsKt;
import androidx.compose.runtime.snapshots.SnapshotApplyResult;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0015\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u001e\b\u0017\u0018\u0000 g2\u00020\u0001:\u0001gBC\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007\u0012\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007¢\u0006\u0002\u0010\u000bJ\b\u00109\u001a\u00020\tH\u0002J\r\u0010:\u001a\u00020\tH\u0000¢\u0006\u0002\b;J$\u0010:\u001a\u0002H<\"\u0004\b\u0000\u0010<2\f\u0010=\u001a\b\u0012\u0004\u0012\u0002H<0>H\b¢\u0006\u0004\b;\u0010?J\b\u0010@\u001a\u00020AH\u0016J\r\u0010B\u001a\u00020\tH\u0010¢\u0006\u0002\bCJ\b\u0010D\u001a\u00020\tH\u0016J\b\u0010E\u001a\u00020\rH\u0016J3\u0010F\u001a\u00020A2\u0006\u0010G\u001a\u00020\u00032\u0014\u0010H\u001a\u0010\u0012\u0004\u0012\u00020J\u0012\u0004\u0012\u00020J\u0018\u00010I2\u0006\u0010K\u001a\u00020\u0005H\u0000¢\u0006\u0002\bLJ\u0015\u0010M\u001a\u00020\t2\u0006\u0010N\u001a\u00020\u0001H\u0010¢\u0006\u0002\bOJ\u0015\u0010P\u001a\u00020\t2\u0006\u0010N\u001a\u00020\u0001H\u0010¢\u0006\u0002\bQJ\r\u0010R\u001a\u00020\tH\u0010¢\u0006\u0002\bSJ\u0015\u0010T\u001a\u00020\t2\u0006\u0010U\u001a\u00020\u0014H\u0010¢\u0006\u0002\bVJ\u0015\u0010W\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¢\u0006\u0002\bXJ\u0015\u0010Y\u001a\u00020\t2\u0006\u00102\u001a\u00020\u0005H\u0000¢\u0006\u0002\bZJ\u0015\u0010[\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¢\u0006\u0002\b\\J\u0015\u0010]\u001a\u00020\t2\u0006\u0010^\u001a\u00020&H\u0000¢\u0006\u0002\b_J\r\u0010`\u001a\u00020\tH\u0010¢\u0006\u0002\baJ\b\u0010b\u001a\u00020\tH\u0002J8\u0010c\u001a\u00020\u00002\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u00072\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007H\u0016J\u001e\u0010d\u001a\u00020\u00012\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007H\u0016J\b\u0010e\u001a\u00020\tH\u0002J\b\u0010f\u001a\u00020\tH\u0002R\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R4\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u001a2\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u001a@VX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010%\u001a\u00020&X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\"\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0014\u0010-\u001a\u00020\r8VX\u0004¢\u0006\u0006\u001a\u0004\b.\u0010\u000fR\u0014\u0010/\u001a\u00020\u00018VX\u0004¢\u0006\u0006\u001a\u0004\b0\u00101R\u000e\u00102\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u001a\u00103\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\"\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u0010,¨\u0006h"}, d2 = {"Landroidx/compose/runtime/snapshots/MutableSnapshot;", "Landroidx/compose/runtime/snapshots/Snapshot;", "id", "", "invalid", "Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "readObserver", "Lkotlin/Function1;", "", "", "writeObserver", "(ILandroidx/compose/runtime/snapshots/SnapshotIdSet;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "applied", "", "getApplied$runtime_release", "()Z", "setApplied$runtime_release", "(Z)V", "merged", "", "Landroidx/compose/runtime/snapshots/StateObject;", "getMerged$runtime_release", "()Ljava/util/List;", "setMerged$runtime_release", "(Ljava/util/List;)V", "<set-?>", "Landroidx/collection/MutableScatterSet;", "modified", "getModified$runtime_release", "()Landroidx/collection/MutableScatterSet;", "setModified", "(Landroidx/collection/MutableScatterSet;)V", "previousIds", "getPreviousIds$runtime_release", "()Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "setPreviousIds$runtime_release", "(Landroidx/compose/runtime/snapshots/SnapshotIdSet;)V", "previousPinnedSnapshots", "", "getPreviousPinnedSnapshots$runtime_release", "()[I", "setPreviousPinnedSnapshots$runtime_release", "([I)V", "getReadObserver$runtime_release", "()Lkotlin/jvm/functions/Function1;", "readOnly", "getReadOnly", "root", "getRoot", "()Landroidx/compose/runtime/snapshots/Snapshot;", "snapshots", "writeCount", "getWriteCount$runtime_release", "()I", "setWriteCount$runtime_release", "(I)V", "getWriteObserver$runtime_release", "abandon", "advance", "advance$runtime_release", "T", "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "apply", "Landroidx/compose/runtime/snapshots/SnapshotApplyResult;", "closeLocked", "closeLocked$runtime_release", "dispose", "hasPendingChanges", "innerApplyLocked", "snapshotId", "optimisticMerges", "", "Landroidx/compose/runtime/snapshots/StateRecord;", "invalidSnapshots", "innerApplyLocked$runtime_release", "nestedActivated", "snapshot", "nestedActivated$runtime_release", "nestedDeactivated", "nestedDeactivated$runtime_release", "notifyObjectsInitialized", "notifyObjectsInitialized$runtime_release", "recordModified", "state", "recordModified$runtime_release", "recordPrevious", "recordPrevious$runtime_release", "recordPreviousList", "recordPreviousList$runtime_release", "recordPreviousPinnedSnapshot", "recordPreviousPinnedSnapshot$runtime_release", "recordPreviousPinnedSnapshots", "handles", "recordPreviousPinnedSnapshots$runtime_release", "releasePinnedSnapshotsForCloseLocked", "releasePinnedSnapshotsForCloseLocked$runtime_release", "releasePreviouslyPinnedSnapshotsLocked", "takeNestedMutableSnapshot", "takeNestedSnapshot", "validateNotApplied", "validateNotAppliedOrPinned", "Companion", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Snapshot.kt */
public class MutableSnapshot extends Snapshot {
    public static final int $stable = 8;
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int[] EmptyIntArray = new int[0];
    private boolean applied;
    private List<? extends StateObject> merged;
    private MutableScatterSet<StateObject> modified;
    private SnapshotIdSet previousIds = SnapshotIdSet.Companion.getEMPTY();
    private int[] previousPinnedSnapshots = EmptyIntArray;
    private final Function1<Object, Unit> readObserver;
    private int snapshots = 1;
    private int writeCount;
    private final Function1<Object, Unit> writeObserver;

    public boolean getReadOnly() {
        return false;
    }

    /* renamed from: getReadObserver$runtime_release */
    public Function1<Object, Unit> getReadObserver() {
        return this.readObserver;
    }

    public Function1<Object, Unit> getWriteObserver$runtime_release() {
        return this.writeObserver;
    }

    public MutableSnapshot(int i, SnapshotIdSet snapshotIdSet, Function1<Object, Unit> function1, Function1<Object, Unit> function12) {
        super(i, snapshotIdSet, (DefaultConstructorMarker) null);
        this.readObserver = function1;
        this.writeObserver = function12;
    }

    public boolean hasPendingChanges() {
        MutableScatterSet<StateObject> modified$runtime_release = getModified$runtime_release();
        return modified$runtime_release != null && modified$runtime_release.isNotEmpty();
    }

    public static /* synthetic */ MutableSnapshot takeNestedMutableSnapshot$default(MutableSnapshot mutableSnapshot, Function1 function1, Function1 function12, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                function1 = null;
            }
            if ((i & 2) != 0) {
                function12 = null;
            }
            return mutableSnapshot.takeNestedMutableSnapshot(function1, function12);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: takeNestedMutableSnapshot");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x005f, code lost:
        if (getDisposed$runtime_release() != false) goto L_0x009e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0061, code lost:
        r9 = getId();
        r10 = androidx.compose.runtime.snapshots.SnapshotKt.getLock();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0069, code lost:
        monitor-enter(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        r0 = androidx.compose.runtime.snapshots.SnapshotKt.nextSnapshotId;
        androidx.compose.runtime.snapshots.SnapshotKt.nextSnapshotId = r0 + 1;
        setId$runtime_release(r0);
        androidx.compose.runtime.snapshots.SnapshotKt.openSnapshots = androidx.compose.runtime.snapshots.SnapshotKt.openSnapshots.set(getId());
        r0 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0087, code lost:
        monitor-exit(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0088, code lost:
        setInvalid$runtime_release(androidx.compose.runtime.snapshots.SnapshotKt.addRange(getInvalid$runtime_release(), r9 + 1, getId()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x009a, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x009d, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00a0, code lost:
        return r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0059, code lost:
        if (getApplied$runtime_release() != false) goto L_0x009e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.compose.runtime.snapshots.MutableSnapshot takeNestedMutableSnapshot(kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> r9, kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> r10) {
        /*
            r8 = this;
            r8.validateNotDisposed$runtime_release()
            r8.validateNotAppliedOrPinned()
            int r0 = r8.getId()
            r8.recordPrevious$runtime_release(r0)
            java.lang.Object r1 = androidx.compose.runtime.snapshots.SnapshotKt.getLock()
            monitor-enter(r1)
            int r3 = androidx.compose.runtime.snapshots.SnapshotKt.nextSnapshotId     // Catch:{ all -> 0x00a3 }
            int r0 = r3 + 1
            androidx.compose.runtime.snapshots.SnapshotKt.nextSnapshotId = r0     // Catch:{ all -> 0x00a3 }
            androidx.compose.runtime.snapshots.SnapshotIdSet r0 = androidx.compose.runtime.snapshots.SnapshotKt.openSnapshots     // Catch:{ all -> 0x00a3 }
            androidx.compose.runtime.snapshots.SnapshotIdSet r0 = r0.set(r3)     // Catch:{ all -> 0x00a3 }
            androidx.compose.runtime.snapshots.SnapshotKt.openSnapshots = r0     // Catch:{ all -> 0x00a3 }
            androidx.compose.runtime.snapshots.SnapshotIdSet r0 = r8.getInvalid$runtime_release()     // Catch:{ all -> 0x00a3 }
            androidx.compose.runtime.snapshots.SnapshotIdSet r2 = r0.set(r3)     // Catch:{ all -> 0x00a3 }
            r8.setInvalid$runtime_release(r2)     // Catch:{ all -> 0x00a3 }
            androidx.compose.runtime.snapshots.NestedMutableSnapshot r2 = new androidx.compose.runtime.snapshots.NestedMutableSnapshot     // Catch:{ all -> 0x00a3 }
            int r4 = r8.getId()     // Catch:{ all -> 0x00a3 }
            int r4 = r4 + 1
            androidx.compose.runtime.snapshots.SnapshotIdSet r4 = androidx.compose.runtime.snapshots.SnapshotKt.addRange(r0, r4, r3)     // Catch:{ all -> 0x00a3 }
            kotlin.jvm.functions.Function1 r0 = r8.getReadObserver()     // Catch:{ all -> 0x00a3 }
            r5 = 4
            r6 = 0
            r7 = 0
            kotlin.jvm.functions.Function1 r5 = androidx.compose.runtime.snapshots.SnapshotKt.mergedReadObserver$default(r9, r0, r7, r5, r6)     // Catch:{ all -> 0x00a3 }
            kotlin.jvm.functions.Function1 r9 = r8.getWriteObserver$runtime_release()     // Catch:{ all -> 0x00a3 }
            kotlin.jvm.functions.Function1 r6 = androidx.compose.runtime.snapshots.SnapshotKt.mergedWriteObserver(r10, r9)     // Catch:{ all -> 0x00a3 }
            r7 = r8
            r2.<init>(r3, r4, r5, r6, r7)     // Catch:{ all -> 0x00a1 }
            monitor-exit(r1)
            boolean r9 = r8.getApplied$runtime_release()
            if (r9 != 0) goto L_0x009e
            boolean r9 = r8.getDisposed$runtime_release()
            if (r9 != 0) goto L_0x009e
            int r9 = r8.getId()
            java.lang.Object r10 = androidx.compose.runtime.snapshots.SnapshotKt.getLock()
            monitor-enter(r10)
            int r0 = androidx.compose.runtime.snapshots.SnapshotKt.nextSnapshotId     // Catch:{ all -> 0x009a }
            int r1 = r0 + 1
            androidx.compose.runtime.snapshots.SnapshotKt.nextSnapshotId = r1     // Catch:{ all -> 0x009a }
            r8.setId$runtime_release(r0)     // Catch:{ all -> 0x009a }
            androidx.compose.runtime.snapshots.SnapshotIdSet r0 = androidx.compose.runtime.snapshots.SnapshotKt.openSnapshots     // Catch:{ all -> 0x009a }
            int r1 = r8.getId()     // Catch:{ all -> 0x009a }
            androidx.compose.runtime.snapshots.SnapshotIdSet r0 = r0.set(r1)     // Catch:{ all -> 0x009a }
            androidx.compose.runtime.snapshots.SnapshotKt.openSnapshots = r0     // Catch:{ all -> 0x009a }
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x009a }
            monitor-exit(r10)
            androidx.compose.runtime.snapshots.SnapshotIdSet r10 = r8.getInvalid$runtime_release()
            int r9 = r9 + 1
            int r0 = r8.getId()
            androidx.compose.runtime.snapshots.SnapshotIdSet r9 = androidx.compose.runtime.snapshots.SnapshotKt.addRange(r10, r9, r0)
            r8.setInvalid$runtime_release(r9)
            goto L_0x009e
        L_0x009a:
            r0 = move-exception
            r9 = r0
            monitor-exit(r10)
            throw r9
        L_0x009e:
            androidx.compose.runtime.snapshots.MutableSnapshot r2 = (androidx.compose.runtime.snapshots.MutableSnapshot) r2
            return r2
        L_0x00a1:
            r0 = move-exception
            goto L_0x00a5
        L_0x00a3:
            r0 = move-exception
            r7 = r8
        L_0x00a5:
            r9 = r0
            monitor-exit(r1)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.MutableSnapshot.takeNestedMutableSnapshot(kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1):androidx.compose.runtime.snapshots.MutableSnapshot");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00b7, code lost:
        r1.applied = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00ba, code lost:
        if (r3 == null) goto L_0x00df;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00bc, code lost:
        r6 = androidx.compose.runtime.collection.ScatterSetWrapperKt.wrapIntoSet(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00ca, code lost:
        if (r6.isEmpty() != false) goto L_0x00df;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00cc, code lost:
        r7 = r4.size();
        r8 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00d1, code lost:
        if (r8 >= r7) goto L_0x00df;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00d3, code lost:
        ((kotlin.jvm.functions.Function2) r4.get(r8)).invoke(r6, r1);
        r8 = r8 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00df, code lost:
        if (r0 == null) goto L_0x0101;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00e5, code lost:
        if (r0.isNotEmpty() == false) goto L_0x0101;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00e7, code lost:
        r6 = androidx.compose.runtime.collection.ScatterSetWrapperKt.wrapIntoSet(r0);
        r7 = r4.size();
        r8 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00f3, code lost:
        if (r8 >= r7) goto L_0x0101;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00f5, code lost:
        ((kotlin.jvm.functions.Function2) r4.get(r8)).invoke(r6, r1);
        r8 = r8 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0101, code lost:
        r4 = androidx.compose.runtime.snapshots.SnapshotKt.getLock();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0105, code lost:
        monitor-enter(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:?, code lost:
        releasePinnedSnapshotsForCloseLocked$runtime_release();
        androidx.compose.runtime.snapshots.SnapshotKt.checkAndOverwriteUnusedRecordsLocked();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0114, code lost:
        if (r3 == null) goto L_0x0156;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0116, code lost:
        r3 = r3;
        r14 = r3.elements;
        r3 = r3.metadata;
        r15 = r3.length - 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x011f, code lost:
        if (r15 < 0) goto L_0x0156;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0121, code lost:
        r5 = 0;
        r16 = 128;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0124, code lost:
        r6 = r3[r5];
        r18 = 255;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x012e, code lost:
        if (((((~r6) << 7) & r6) & -9187201950435737472L) == -9187201950435737472L) goto L_0x0151;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0130, code lost:
        r8 = 8 - ((~(r5 - r15)) >>> 31);
        r9 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0138, code lost:
        if (r9 >= r8) goto L_0x014f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x013e, code lost:
        if ((r6 & 255) >= 128) goto L_0x014b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0140, code lost:
        androidx.compose.runtime.snapshots.SnapshotKt.processForUnusedRecordsLocked((androidx.compose.runtime.snapshots.StateObject) r14[(r5 << 3) + r9]);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x014b, code lost:
        r6 = r6 >> 8;
        r9 = r9 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x014f, code lost:
        if (r8 != 8) goto L_0x015a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0151, code lost:
        if (r5 == r15) goto L_0x015a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0153, code lost:
        r5 = r5 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0156, code lost:
        r16 = 128;
        r18 = 255;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x015a, code lost:
        if (r0 == null) goto L_0x0197;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x015c, code lost:
        r0 = r0;
        r3 = r0.elements;
        r0 = r0.metadata;
        r5 = r0.length - 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0165, code lost:
        if (r5 < 0) goto L_0x0197;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0167, code lost:
        r6 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0168, code lost:
        r7 = r0[r6];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0170, code lost:
        if (((((~r7) << 7) & r7) & -9187201950435737472L) == -9187201950435737472L) goto L_0x0192;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0172, code lost:
        r9 = 8 - ((~(r6 - r5)) >>> 31);
        r14 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x017a, code lost:
        if (r14 >= r9) goto L_0x0190;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0180, code lost:
        if ((r7 & r18) >= r16) goto L_0x018c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0182, code lost:
        androidx.compose.runtime.snapshots.SnapshotKt.processForUnusedRecordsLocked((androidx.compose.runtime.snapshots.StateObject) r3[(r6 << 3) + r14]);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x018c, code lost:
        r7 = r7 >> 8;
        r14 = r14 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0190, code lost:
        if (r9 != 8) goto L_0x0197;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x0192, code lost:
        if (r6 == r5) goto L_0x0197;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x0194, code lost:
        r6 = r6 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0197, code lost:
        r0 = r1.merged;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0199, code lost:
        if (r0 == null) goto L_0x01ae;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x019b, code lost:
        r3 = r0.size();
        r5 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x01a0, code lost:
        if (r5 >= r3) goto L_0x01ae;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x01a2, code lost:
        androidx.compose.runtime.snapshots.SnapshotKt.processForUnusedRecordsLocked((androidx.compose.runtime.snapshots.StateObject) r0.get(r5));
        r5 = r5 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x01ae, code lost:
        r1.merged = null;
        r0 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x01b2, code lost:
        monitor-exit(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x01b7, code lost:
        return androidx.compose.runtime.snapshots.SnapshotApplyResult.Success.INSTANCE;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.compose.runtime.snapshots.SnapshotApplyResult apply() {
        /*
            r22 = this;
            r1 = r22
            androidx.collection.MutableScatterSet r0 = r1.getModified$runtime_release()
            r2 = 0
            if (r0 == 0) goto L_0x002e
            java.util.concurrent.atomic.AtomicReference r3 = androidx.compose.runtime.snapshots.SnapshotKt.currentGlobalSnapshot
            java.lang.Object r3 = r3.get()
            androidx.compose.runtime.snapshots.MutableSnapshot r3 = (androidx.compose.runtime.snapshots.MutableSnapshot) r3
            androidx.compose.runtime.snapshots.SnapshotIdSet r4 = androidx.compose.runtime.snapshots.SnapshotKt.openSnapshots
            java.util.concurrent.atomic.AtomicReference r5 = androidx.compose.runtime.snapshots.SnapshotKt.currentGlobalSnapshot
            java.lang.Object r5 = r5.get()
            androidx.compose.runtime.snapshots.GlobalSnapshot r5 = (androidx.compose.runtime.snapshots.GlobalSnapshot) r5
            int r5 = r5.getId()
            androidx.compose.runtime.snapshots.SnapshotIdSet r4 = r4.clear(r5)
            java.util.Map r3 = androidx.compose.runtime.snapshots.SnapshotKt.optimisticMerges(r3, r1, r4)
            goto L_0x002f
        L_0x002e:
            r3 = r2
        L_0x002f:
            java.util.List r4 = kotlin.collections.CollectionsKt.emptyList()
            java.lang.Object r5 = androidx.compose.runtime.snapshots.SnapshotKt.getLock()
            monitor-enter(r5)
            r6 = r1
            androidx.compose.runtime.snapshots.Snapshot r6 = (androidx.compose.runtime.snapshots.Snapshot) r6     // Catch:{ all -> 0x01bb }
            androidx.compose.runtime.snapshots.SnapshotKt.validateOpen(r6)     // Catch:{ all -> 0x01bb }
            if (r0 == 0) goto L_0x008b
            int r6 = r0.getSize()     // Catch:{ all -> 0x01bb }
            if (r6 != 0) goto L_0x0047
            goto L_0x008b
        L_0x0047:
            java.util.concurrent.atomic.AtomicReference r4 = androidx.compose.runtime.snapshots.SnapshotKt.currentGlobalSnapshot     // Catch:{ all -> 0x01bb }
            java.lang.Object r4 = r4.get()     // Catch:{ all -> 0x01bb }
            androidx.compose.runtime.snapshots.GlobalSnapshot r4 = (androidx.compose.runtime.snapshots.GlobalSnapshot) r4     // Catch:{ all -> 0x01bb }
            int r6 = androidx.compose.runtime.snapshots.SnapshotKt.nextSnapshotId     // Catch:{ all -> 0x01bb }
            androidx.compose.runtime.snapshots.SnapshotIdSet r7 = androidx.compose.runtime.snapshots.SnapshotKt.openSnapshots     // Catch:{ all -> 0x01bb }
            int r8 = r4.getId()     // Catch:{ all -> 0x01bb }
            androidx.compose.runtime.snapshots.SnapshotIdSet r7 = r7.clear(r8)     // Catch:{ all -> 0x01bb }
            androidx.compose.runtime.snapshots.SnapshotApplyResult r3 = r1.innerApplyLocked$runtime_release(r6, r3, r7)     // Catch:{ all -> 0x01bb }
            androidx.compose.runtime.snapshots.SnapshotApplyResult$Success r6 = androidx.compose.runtime.snapshots.SnapshotApplyResult.Success.INSTANCE     // Catch:{ all -> 0x01bb }
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r6)     // Catch:{ all -> 0x01bb }
            if (r6 != 0) goto L_0x006f
            monitor-exit(r5)
            return r3
        L_0x006f:
            r1.closeLocked$runtime_release()     // Catch:{ all -> 0x01bb }
            r3 = r4
            androidx.compose.runtime.snapshots.Snapshot r3 = (androidx.compose.runtime.snapshots.Snapshot) r3     // Catch:{ all -> 0x01bb }
            kotlin.jvm.functions.Function1 r6 = androidx.compose.runtime.snapshots.SnapshotKt.emptyLambda     // Catch:{ all -> 0x01bb }
            java.lang.Object unused = androidx.compose.runtime.snapshots.SnapshotKt.takeNewGlobalSnapshot(r3, r6)     // Catch:{ all -> 0x01bb }
            androidx.collection.MutableScatterSet r3 = r4.getModified$runtime_release()     // Catch:{ all -> 0x01bb }
            r1.setModified(r2)     // Catch:{ all -> 0x01bb }
            r4.setModified(r2)     // Catch:{ all -> 0x01bb }
            java.util.List r4 = androidx.compose.runtime.snapshots.SnapshotKt.applyObservers     // Catch:{ all -> 0x01bb }
            goto L_0x00b4
        L_0x008b:
            r1.closeLocked$runtime_release()     // Catch:{ all -> 0x01bb }
            java.util.concurrent.atomic.AtomicReference r3 = androidx.compose.runtime.snapshots.SnapshotKt.currentGlobalSnapshot     // Catch:{ all -> 0x01bb }
            java.lang.Object r3 = r3.get()     // Catch:{ all -> 0x01bb }
            androidx.compose.runtime.snapshots.GlobalSnapshot r3 = (androidx.compose.runtime.snapshots.GlobalSnapshot) r3     // Catch:{ all -> 0x01bb }
            r6 = r3
            androidx.compose.runtime.snapshots.Snapshot r6 = (androidx.compose.runtime.snapshots.Snapshot) r6     // Catch:{ all -> 0x01bb }
            kotlin.jvm.functions.Function1 r7 = androidx.compose.runtime.snapshots.SnapshotKt.emptyLambda     // Catch:{ all -> 0x01bb }
            java.lang.Object unused = androidx.compose.runtime.snapshots.SnapshotKt.takeNewGlobalSnapshot(r6, r7)     // Catch:{ all -> 0x01bb }
            androidx.collection.MutableScatterSet r3 = r3.getModified$runtime_release()     // Catch:{ all -> 0x01bb }
            if (r3 == 0) goto L_0x00b3
            boolean r6 = r3.isNotEmpty()     // Catch:{ all -> 0x01bb }
            if (r6 == 0) goto L_0x00b3
            java.util.List r4 = androidx.compose.runtime.snapshots.SnapshotKt.applyObservers     // Catch:{ all -> 0x01bb }
            goto L_0x00b4
        L_0x00b3:
            r3 = r2
        L_0x00b4:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x01bb }
            monitor-exit(r5)
            r5 = 1
            r1.applied = r5
            if (r3 == 0) goto L_0x00df
            r6 = r3
            androidx.collection.ScatterSet r6 = (androidx.collection.ScatterSet) r6
            java.util.Set r6 = androidx.compose.runtime.collection.ScatterSetWrapperKt.wrapIntoSet(r6)
            r7 = r6
            java.util.Collection r7 = (java.util.Collection) r7
            boolean r7 = r7.isEmpty()
            if (r7 != 0) goto L_0x00df
            int r7 = r4.size()
            r8 = 0
        L_0x00d1:
            if (r8 >= r7) goto L_0x00df
            java.lang.Object r9 = r4.get(r8)
            kotlin.jvm.functions.Function2 r9 = (kotlin.jvm.functions.Function2) r9
            r9.invoke(r6, r1)
            int r8 = r8 + 1
            goto L_0x00d1
        L_0x00df:
            if (r0 == 0) goto L_0x0101
            boolean r6 = r0.isNotEmpty()
            if (r6 == 0) goto L_0x0101
            r6 = r0
            androidx.collection.ScatterSet r6 = (androidx.collection.ScatterSet) r6
            java.util.Set r6 = androidx.compose.runtime.collection.ScatterSetWrapperKt.wrapIntoSet(r6)
            int r7 = r4.size()
            r8 = 0
        L_0x00f3:
            if (r8 >= r7) goto L_0x0101
            java.lang.Object r9 = r4.get(r8)
            kotlin.jvm.functions.Function2 r9 = (kotlin.jvm.functions.Function2) r9
            r9.invoke(r6, r1)
            int r8 = r8 + 1
            goto L_0x00f3
        L_0x0101:
            java.lang.Object r4 = androidx.compose.runtime.snapshots.SnapshotKt.getLock()
            monitor-enter(r4)
            r1.releasePinnedSnapshotsForCloseLocked$runtime_release()     // Catch:{ all -> 0x01b8 }
            androidx.compose.runtime.snapshots.SnapshotKt.checkAndOverwriteUnusedRecordsLocked()     // Catch:{ all -> 0x01b8 }
            r10 = 7
            r11 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            r13 = 8
            if (r3 == 0) goto L_0x0156
            androidx.collection.ScatterSet r3 = (androidx.collection.ScatterSet) r3     // Catch:{ all -> 0x01b8 }
            java.lang.Object[] r14 = r3.elements     // Catch:{ all -> 0x01b8 }
            long[] r3 = r3.metadata     // Catch:{ all -> 0x01b8 }
            int r15 = r3.length     // Catch:{ all -> 0x01b8 }
            int r15 = r15 + -2
            if (r15 < 0) goto L_0x0156
            r5 = 0
            r16 = 128(0x80, double:6.32E-322)
        L_0x0124:
            r6 = r3[r5]     // Catch:{ all -> 0x01b8 }
            r18 = 255(0xff, double:1.26E-321)
            long r8 = ~r6     // Catch:{ all -> 0x01b8 }
            long r8 = r8 << r10
            long r8 = r8 & r6
            long r8 = r8 & r11
            int r8 = (r8 > r11 ? 1 : (r8 == r11 ? 0 : -1))
            if (r8 == 0) goto L_0x0151
            int r8 = r5 - r15
            int r8 = ~r8     // Catch:{ all -> 0x01b8 }
            int r8 = r8 >>> 31
            int r8 = 8 - r8
            r9 = 0
        L_0x0138:
            if (r9 >= r8) goto L_0x014f
            long r20 = r6 & r18
            int r20 = (r20 > r16 ? 1 : (r20 == r16 ? 0 : -1))
            if (r20 >= 0) goto L_0x014b
            int r20 = r5 << 3
            int r20 = r20 + r9
            r20 = r14[r20]     // Catch:{ all -> 0x01b8 }
            androidx.compose.runtime.snapshots.StateObject r20 = (androidx.compose.runtime.snapshots.StateObject) r20     // Catch:{ all -> 0x01b8 }
            androidx.compose.runtime.snapshots.SnapshotKt.processForUnusedRecordsLocked(r20)     // Catch:{ all -> 0x01b8 }
        L_0x014b:
            long r6 = r6 >> r13
            int r9 = r9 + 1
            goto L_0x0138
        L_0x014f:
            if (r8 != r13) goto L_0x015a
        L_0x0151:
            if (r5 == r15) goto L_0x015a
            int r5 = r5 + 1
            goto L_0x0124
        L_0x0156:
            r16 = 128(0x80, double:6.32E-322)
            r18 = 255(0xff, double:1.26E-321)
        L_0x015a:
            if (r0 == 0) goto L_0x0197
            androidx.collection.ScatterSet r0 = (androidx.collection.ScatterSet) r0     // Catch:{ all -> 0x01b8 }
            java.lang.Object[] r3 = r0.elements     // Catch:{ all -> 0x01b8 }
            long[] r0 = r0.metadata     // Catch:{ all -> 0x01b8 }
            int r5 = r0.length     // Catch:{ all -> 0x01b8 }
            int r5 = r5 + -2
            if (r5 < 0) goto L_0x0197
            r6 = 0
        L_0x0168:
            r7 = r0[r6]     // Catch:{ all -> 0x01b8 }
            long r14 = ~r7     // Catch:{ all -> 0x01b8 }
            long r14 = r14 << r10
            long r14 = r14 & r7
            long r14 = r14 & r11
            int r9 = (r14 > r11 ? 1 : (r14 == r11 ? 0 : -1))
            if (r9 == 0) goto L_0x0192
            int r9 = r6 - r5
            int r9 = ~r9     // Catch:{ all -> 0x01b8 }
            int r9 = r9 >>> 31
            int r9 = 8 - r9
            r14 = 0
        L_0x017a:
            if (r14 >= r9) goto L_0x0190
            long r20 = r7 & r18
            int r15 = (r20 > r16 ? 1 : (r20 == r16 ? 0 : -1))
            if (r15 >= 0) goto L_0x018c
            int r15 = r6 << 3
            int r15 = r15 + r14
            r15 = r3[r15]     // Catch:{ all -> 0x01b8 }
            androidx.compose.runtime.snapshots.StateObject r15 = (androidx.compose.runtime.snapshots.StateObject) r15     // Catch:{ all -> 0x01b8 }
            androidx.compose.runtime.snapshots.SnapshotKt.processForUnusedRecordsLocked(r15)     // Catch:{ all -> 0x01b8 }
        L_0x018c:
            long r7 = r7 >> r13
            int r14 = r14 + 1
            goto L_0x017a
        L_0x0190:
            if (r9 != r13) goto L_0x0197
        L_0x0192:
            if (r6 == r5) goto L_0x0197
            int r6 = r6 + 1
            goto L_0x0168
        L_0x0197:
            java.util.List<? extends androidx.compose.runtime.snapshots.StateObject> r0 = r1.merged     // Catch:{ all -> 0x01b8 }
            if (r0 == 0) goto L_0x01ae
            int r3 = r0.size()     // Catch:{ all -> 0x01b8 }
            r5 = 0
        L_0x01a0:
            if (r5 >= r3) goto L_0x01ae
            java.lang.Object r6 = r0.get(r5)     // Catch:{ all -> 0x01b8 }
            androidx.compose.runtime.snapshots.StateObject r6 = (androidx.compose.runtime.snapshots.StateObject) r6     // Catch:{ all -> 0x01b8 }
            androidx.compose.runtime.snapshots.SnapshotKt.processForUnusedRecordsLocked(r6)     // Catch:{ all -> 0x01b8 }
            int r5 = r5 + 1
            goto L_0x01a0
        L_0x01ae:
            r1.merged = r2     // Catch:{ all -> 0x01b8 }
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x01b8 }
            monitor-exit(r4)
            androidx.compose.runtime.snapshots.SnapshotApplyResult$Success r0 = androidx.compose.runtime.snapshots.SnapshotApplyResult.Success.INSTANCE
            androidx.compose.runtime.snapshots.SnapshotApplyResult r0 = (androidx.compose.runtime.snapshots.SnapshotApplyResult) r0
            return r0
        L_0x01b8:
            r0 = move-exception
            monitor-exit(r4)
            throw r0
        L_0x01bb:
            r0 = move-exception
            monitor-exit(r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.MutableSnapshot.apply():androidx.compose.runtime.snapshots.SnapshotApplyResult");
    }

    public Snapshot getRoot() {
        return this;
    }

    public void dispose() {
        if (!getDisposed$runtime_release()) {
            super.dispose();
            nestedDeactivated$runtime_release(this);
        }
    }

    public Snapshot takeNestedSnapshot(Function1<Object, Unit> function1) {
        NestedReadonlySnapshot nestedReadonlySnapshot;
        validateNotDisposed$runtime_release();
        validateNotAppliedOrPinned();
        int id = getId();
        recordPrevious$runtime_release(getId());
        synchronized (SnapshotKt.getLock()) {
            int access$getNextSnapshotId$p = SnapshotKt.nextSnapshotId;
            SnapshotKt.nextSnapshotId = access$getNextSnapshotId$p + 1;
            SnapshotKt.openSnapshots = SnapshotKt.openSnapshots.set(access$getNextSnapshotId$p);
            nestedReadonlySnapshot = new NestedReadonlySnapshot(access$getNextSnapshotId$p, SnapshotKt.addRange(getInvalid$runtime_release(), id + 1, access$getNextSnapshotId$p), SnapshotKt.mergedReadObserver$default(function1, getReadObserver(), false, 4, (Object) null), this);
        }
        if (!getApplied$runtime_release() && !getDisposed$runtime_release()) {
            int id2 = getId();
            synchronized (SnapshotKt.getLock()) {
                int access$getNextSnapshotId$p2 = SnapshotKt.nextSnapshotId;
                SnapshotKt.nextSnapshotId = access$getNextSnapshotId$p2 + 1;
                setId$runtime_release(access$getNextSnapshotId$p2);
                SnapshotKt.openSnapshots = SnapshotKt.openSnapshots.set(getId());
                Unit unit = Unit.INSTANCE;
            }
            setInvalid$runtime_release(SnapshotKt.addRange(getInvalid$runtime_release(), id2 + 1, getId()));
        }
        return nestedReadonlySnapshot;
    }

    public void nestedActivated$runtime_release(Snapshot snapshot) {
        this.snapshots++;
    }

    public void nestedDeactivated$runtime_release(Snapshot snapshot) {
        if (!(this.snapshots > 0)) {
            PreconditionsKt.throwIllegalArgumentException("no pending nested snapshots");
        }
        int i = this.snapshots - 1;
        this.snapshots = i;
        if (i == 0 && !this.applied) {
            abandon();
        }
    }

    public void notifyObjectsInitialized$runtime_release() {
        if (!this.applied && !getDisposed$runtime_release()) {
            advance$runtime_release();
        }
    }

    public void closeLocked$runtime_release() {
        SnapshotKt.openSnapshots = SnapshotKt.openSnapshots.clear(getId()).andNot(this.previousIds);
    }

    public void releasePinnedSnapshotsForCloseLocked$runtime_release() {
        releasePreviouslyPinnedSnapshotsLocked();
        super.releasePinnedSnapshotsForCloseLocked$runtime_release();
    }

    private final void validateNotApplied() {
        if (this.applied) {
            PreconditionsKt.throwIllegalStateException("Unsupported operation on a snapshot that has been applied");
        }
    }

    private final void validateNotAppliedOrPinned() {
        if (!(!this.applied || this.pinningTrackingHandle >= 0)) {
            PreconditionsKt.throwIllegalStateException("Unsupported operation on a disposed or applied snapshot");
        }
    }

    private final void abandon() {
        MutableScatterSet<StateObject> modified$runtime_release = getModified$runtime_release();
        if (modified$runtime_release != null) {
            validateNotApplied();
            setModified((MutableScatterSet<StateObject>) null);
            int id = getId();
            ScatterSet scatterSet = modified$runtime_release;
            Object[] objArr = scatterSet.elements;
            long[] jArr = scatterSet.metadata;
            int length = jArr.length - 2;
            if (length >= 0) {
                int i = 0;
                while (true) {
                    long j = jArr[i];
                    if ((((~j) << 7) & j & -9187201950435737472L) != -9187201950435737472L) {
                        int i2 = 8 - ((~(i - length)) >>> 31);
                        for (int i3 = 0; i3 < i2; i3++) {
                            if ((255 & j) < 128) {
                                for (StateRecord firstStateRecord = ((StateObject) objArr[(i << 3) + i3]).getFirstStateRecord(); firstStateRecord != null; firstStateRecord = firstStateRecord.getNext$runtime_release()) {
                                    if (firstStateRecord.getSnapshotId$runtime_release() == id || CollectionsKt.contains(this.previousIds, Integer.valueOf(firstStateRecord.getSnapshotId$runtime_release()))) {
                                        firstStateRecord.setSnapshotId$runtime_release(0);
                                    }
                                }
                            }
                            j >>= 8;
                        }
                        if (i2 != 8) {
                            break;
                        }
                    }
                    if (i == length) {
                        break;
                    }
                    i++;
                }
            }
        }
        closeAndReleasePinning$runtime_release();
    }

    public final SnapshotApplyResult innerApplyLocked$runtime_release(int i, Map<StateRecord, ? extends StateRecord> map, SnapshotIdSet snapshotIdSet) {
        SnapshotIdSet snapshotIdSet2;
        Object[] objArr;
        long[] jArr;
        SnapshotIdSet snapshotIdSet3;
        Object[] objArr2;
        long[] jArr2;
        int i2;
        StateRecord access$readable;
        StateRecord stateRecord;
        Pair pair;
        Map<StateRecord, ? extends StateRecord> map2 = map;
        SnapshotIdSet or = getInvalid$runtime_release().set(getId()).or(this.previousIds);
        MutableScatterSet<StateObject> modified$runtime_release = getModified$runtime_release();
        Intrinsics.checkNotNull(modified$runtime_release);
        ScatterSet scatterSet = modified$runtime_release;
        Object[] objArr3 = scatterSet.elements;
        long[] jArr3 = scatterSet.metadata;
        int length = jArr3.length - 2;
        List list = null;
        List<? extends StateObject> list2 = null;
        if (length >= 0) {
            int i3 = 0;
            while (true) {
                long j = jArr3[i3];
                if ((((~j) << 7) & j & -9187201950435737472L) != -9187201950435737472L) {
                    int i4 = 8;
                    int i5 = 8 - ((~(i3 - length)) >>> 31);
                    int i6 = 0;
                    while (i6 < i5) {
                        if ((j & 255) < 128) {
                            StateObject stateObject = (StateObject) objArr3[(i3 << 3) + i6];
                            i2 = i4;
                            StateRecord firstStateRecord = stateObject.getFirstStateRecord();
                            jArr2 = jArr3;
                            objArr2 = objArr3;
                            List list3 = list;
                            StateRecord access$readable2 = SnapshotKt.readable(firstStateRecord, i, snapshotIdSet);
                            if (access$readable2 == null || (access$readable = SnapshotKt.readable(firstStateRecord, getId(), or)) == null) {
                                snapshotIdSet3 = or;
                            } else {
                                snapshotIdSet3 = or;
                                if (access$readable.getSnapshotId$runtime_release() != 1 && !Intrinsics.areEqual((Object) access$readable2, (Object) access$readable)) {
                                    StateRecord access$readable3 = SnapshotKt.readable(firstStateRecord, getId(), getInvalid$runtime_release());
                                    if (access$readable3 != null) {
                                        if (map2 == null || (stateRecord = (StateRecord) map2.get(access$readable2)) == null) {
                                            MutableSnapshot mutableSnapshot = this;
                                            stateRecord = stateObject.mergeRecords(access$readable, access$readable2, access$readable3);
                                        }
                                        if (stateRecord == null) {
                                            return new SnapshotApplyResult.Failure(this);
                                        }
                                        if (!Intrinsics.areEqual((Object) stateRecord, (Object) access$readable3)) {
                                            if (Intrinsics.areEqual((Object) stateRecord, (Object) access$readable2)) {
                                                List arrayList = list3 == null ? new ArrayList() : list3;
                                                arrayList.add(TuplesKt.to(stateObject, access$readable2.create()));
                                                if (list2 == null) {
                                                    list2 = new ArrayList<>();
                                                }
                                                list2.add(stateObject);
                                                list = arrayList;
                                            } else {
                                                list = list3 == null ? new ArrayList() : list3;
                                                if (!Intrinsics.areEqual((Object) stateRecord, (Object) access$readable)) {
                                                    pair = TuplesKt.to(stateObject, stateRecord);
                                                } else {
                                                    pair = TuplesKt.to(stateObject, access$readable.create());
                                                }
                                                list.add(pair);
                                            }
                                        }
                                    } else {
                                        Void unused = SnapshotKt.readError();
                                        throw new KotlinNothingValueException();
                                    }
                                }
                            }
                            list = list3;
                        } else {
                            snapshotIdSet3 = or;
                            jArr2 = jArr3;
                            objArr2 = objArr3;
                            List list4 = list;
                            i2 = i4;
                        }
                        j >>= i2;
                        i6++;
                        i4 = i2;
                        jArr3 = jArr2;
                        objArr3 = objArr2;
                        or = snapshotIdSet3;
                    }
                    snapshotIdSet2 = or;
                    jArr = jArr3;
                    objArr = objArr3;
                    List list5 = list;
                    if (i5 != i4) {
                        break;
                    }
                } else {
                    snapshotIdSet2 = or;
                    jArr = jArr3;
                    objArr = objArr3;
                }
                if (i3 == length) {
                    break;
                }
                i3++;
                jArr3 = jArr;
                objArr3 = objArr;
                or = snapshotIdSet2;
            }
        }
        if (list != null) {
            advance$runtime_release();
            int size = list.size();
            for (int i7 = 0; i7 < size; i7++) {
                Pair pair2 = (Pair) list.get(i7);
                StateObject stateObject2 = (StateObject) pair2.component1();
                StateRecord stateRecord2 = (StateRecord) pair2.component2();
                stateRecord2.setSnapshotId$runtime_release(getId());
                synchronized (SnapshotKt.getLock()) {
                    stateRecord2.setNext$runtime_release(stateObject2.getFirstStateRecord());
                    stateObject2.prependStateRecord(stateRecord2);
                    Unit unit = Unit.INSTANCE;
                }
            }
        }
        if (list2 != null) {
            int size2 = list2.size();
            for (int i8 = 0; i8 < size2; i8++) {
                modified$runtime_release.remove((StateObject) list2.get(i8));
            }
            List<? extends StateObject> list6 = this.merged;
            if (list6 != null) {
                list2 = CollectionsKt.plus(list6, list2);
            }
            this.merged = list2;
        }
        return SnapshotApplyResult.Success.INSTANCE;
    }

    public final <T> T advance$runtime_release(Function0<? extends T> function0) {
        recordPrevious$runtime_release(getId());
        T invoke = function0.invoke();
        if (getApplied$runtime_release() || getDisposed$runtime_release()) {
            return invoke;
        }
        int id = getId();
        synchronized (SnapshotKt.getLock()) {
            int access$getNextSnapshotId$p = SnapshotKt.nextSnapshotId;
            SnapshotKt.nextSnapshotId = access$getNextSnapshotId$p + 1;
            setId$runtime_release(access$getNextSnapshotId$p);
            SnapshotKt.openSnapshots = SnapshotKt.openSnapshots.set(getId());
            Unit unit = Unit.INSTANCE;
        }
        setInvalid$runtime_release(SnapshotKt.addRange(getInvalid$runtime_release(), id + 1, getId()));
        return invoke;
    }

    public final void recordPreviousPinnedSnapshot$runtime_release(int i) {
        if (i >= 0) {
            this.previousPinnedSnapshots = ArraysKt.plus(this.previousPinnedSnapshots, i);
        }
    }

    public final void recordPreviousPinnedSnapshots$runtime_release(int[] iArr) {
        if (iArr.length != 0) {
            int[] iArr2 = this.previousPinnedSnapshots;
            if (iArr2.length != 0) {
                iArr = ArraysKt.plus(iArr2, iArr);
            }
            this.previousPinnedSnapshots = iArr;
        }
    }

    private final void releasePreviouslyPinnedSnapshotsLocked() {
        for (int releasePinningLocked : this.previousPinnedSnapshots) {
            SnapshotKt.releasePinningLocked(releasePinningLocked);
        }
    }

    public void recordModified$runtime_release(StateObject stateObject) {
        MutableScatterSet<StateObject> modified$runtime_release = getModified$runtime_release();
        if (modified$runtime_release == null) {
            modified$runtime_release = ScatterSetKt.mutableScatterSetOf();
            setModified(modified$runtime_release);
        }
        modified$runtime_release.add(stateObject);
    }

    public int getWriteCount$runtime_release() {
        return this.writeCount;
    }

    public void setWriteCount$runtime_release(int i) {
        this.writeCount = i;
    }

    public MutableScatterSet<StateObject> getModified$runtime_release() {
        return this.modified;
    }

    public void setModified(MutableScatterSet<StateObject> mutableScatterSet) {
        this.modified = mutableScatterSet;
    }

    public final List<StateObject> getMerged$runtime_release() {
        return this.merged;
    }

    public final void setMerged$runtime_release(List<? extends StateObject> list) {
        this.merged = list;
    }

    public final SnapshotIdSet getPreviousIds$runtime_release() {
        return this.previousIds;
    }

    public final void setPreviousIds$runtime_release(SnapshotIdSet snapshotIdSet) {
        this.previousIds = snapshotIdSet;
    }

    public final int[] getPreviousPinnedSnapshots$runtime_release() {
        return this.previousPinnedSnapshots;
    }

    public final void setPreviousPinnedSnapshots$runtime_release(int[] iArr) {
        this.previousPinnedSnapshots = iArr;
    }

    public final boolean getApplied$runtime_release() {
        return this.applied;
    }

    public final void setApplied$runtime_release(boolean z) {
        this.applied = z;
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Landroidx/compose/runtime/snapshots/MutableSnapshot$Companion;", "", "()V", "EmptyIntArray", "", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: Snapshot.kt */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final void advance$runtime_release() {
        recordPrevious$runtime_release(getId());
        Unit unit = Unit.INSTANCE;
        if (!getApplied$runtime_release() && !getDisposed$runtime_release()) {
            int id = getId();
            synchronized (SnapshotKt.getLock()) {
                int access$getNextSnapshotId$p = SnapshotKt.nextSnapshotId;
                SnapshotKt.nextSnapshotId = access$getNextSnapshotId$p + 1;
                setId$runtime_release(access$getNextSnapshotId$p);
                SnapshotKt.openSnapshots = SnapshotKt.openSnapshots.set(getId());
                Unit unit2 = Unit.INSTANCE;
            }
            setInvalid$runtime_release(SnapshotKt.addRange(getInvalid$runtime_release(), id + 1, getId()));
        }
    }

    public final void recordPrevious$runtime_release(int i) {
        synchronized (SnapshotKt.getLock()) {
            this.previousIds = this.previousIds.set(i);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void recordPreviousList$runtime_release(SnapshotIdSet snapshotIdSet) {
        synchronized (SnapshotKt.getLock()) {
            this.previousIds = this.previousIds.or(snapshotIdSet);
            Unit unit = Unit.INSTANCE;
        }
    }
}
