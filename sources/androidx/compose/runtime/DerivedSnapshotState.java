package androidx.compose.runtime;

import androidx.collection.ObjectIntMap;
import androidx.collection.ObjectIntMapKt;
import androidx.compose.runtime.DerivedState;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.SnapshotKt;
import androidx.compose.runtime.snapshots.StateObject;
import androidx.compose.runtime.snapshots.StateObjectImpl;
import androidx.compose.runtime.snapshots.StateRecord;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001'B#\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u001eJ:\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u00132\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00132\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020!2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0002J\b\u0010\"\u001a\u00020#H\u0002J\u0010\u0010$\u001a\u00020%2\u0006\u0010\u001a\u001a\u00020\u0015H\u0016J\b\u0010&\u001a\u00020#H\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\n8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\r\u001a\u0004\u0018\u00018\u00008G¢\u0006\f\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\u00020\u00158VX\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0006\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00028\u00008VX\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0011¨\u0006("}, d2 = {"Landroidx/compose/runtime/DerivedSnapshotState;", "T", "Landroidx/compose/runtime/snapshots/StateObjectImpl;", "Landroidx/compose/runtime/DerivedState;", "calculation", "Lkotlin/Function0;", "policy", "Landroidx/compose/runtime/SnapshotMutationPolicy;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/SnapshotMutationPolicy;)V", "currentRecord", "Landroidx/compose/runtime/DerivedState$Record;", "getCurrentRecord", "()Landroidx/compose/runtime/DerivedState$Record;", "debuggerDisplayValue", "getDebuggerDisplayValue$annotations", "()V", "getDebuggerDisplayValue", "()Ljava/lang/Object;", "first", "Landroidx/compose/runtime/DerivedSnapshotState$ResultRecord;", "firstStateRecord", "Landroidx/compose/runtime/snapshots/StateRecord;", "getFirstStateRecord", "()Landroidx/compose/runtime/snapshots/StateRecord;", "getPolicy", "()Landroidx/compose/runtime/SnapshotMutationPolicy;", "value", "getValue", "current", "snapshot", "Landroidx/compose/runtime/snapshots/Snapshot;", "readable", "forceDependencyReads", "", "displayValue", "", "prependStateRecord", "", "toString", "ResultRecord", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: DerivedState.kt */
final class DerivedSnapshotState<T> extends StateObjectImpl implements DerivedState<T> {
    private final Function0<T> calculation;
    private ResultRecord<T> first = new ResultRecord<>();
    private final SnapshotMutationPolicy<T> policy;

    public static /* synthetic */ void getDebuggerDisplayValue$annotations() {
    }

    public SnapshotMutationPolicy<T> getPolicy() {
        return this.policy;
    }

    public DerivedSnapshotState(Function0<? extends T> function0, SnapshotMutationPolicy<T> snapshotMutationPolicy) {
        this.calculation = function0;
        this.policy = snapshotMutationPolicy;
    }

    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 +*\u0004\b\u0001\u0010\u00012\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001+B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0002H\u0016J\b\u0010#\u001a\u00020\u0002H\u0016J\u001a\u0010$\u001a\u00020%2\n\u0010&\u001a\u0006\u0012\u0002\b\u00030'2\u0006\u0010(\u001a\u00020)J\u001a\u0010*\u001a\u00020\u00152\n\u0010&\u001a\u0006\u0012\u0002\b\u00030'2\u0006\u0010(\u001a\u00020)R\u0014\u0010\u0005\u001a\u00028\u00018VX\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R \u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R\u001a\u0010\u001d\u001a\u00020\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0017\"\u0004\b\u001f\u0010\u0019¨\u0006,"}, d2 = {"Landroidx/compose/runtime/DerivedSnapshotState$ResultRecord;", "T", "Landroidx/compose/runtime/snapshots/StateRecord;", "Landroidx/compose/runtime/DerivedState$Record;", "()V", "currentValue", "getCurrentValue", "()Ljava/lang/Object;", "dependencies", "Landroidx/collection/ObjectIntMap;", "Landroidx/compose/runtime/snapshots/StateObject;", "getDependencies", "()Landroidx/collection/ObjectIntMap;", "setDependencies", "(Landroidx/collection/ObjectIntMap;)V", "result", "", "getResult", "setResult", "(Ljava/lang/Object;)V", "resultHash", "", "getResultHash", "()I", "setResultHash", "(I)V", "validSnapshotId", "getValidSnapshotId", "setValidSnapshotId", "validSnapshotWriteCount", "getValidSnapshotWriteCount", "setValidSnapshotWriteCount", "assign", "", "value", "create", "isValid", "", "derivedState", "Landroidx/compose/runtime/DerivedState;", "snapshot", "Landroidx/compose/runtime/snapshots/Snapshot;", "readableHash", "Companion", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: DerivedState.kt */
    public static final class ResultRecord<T> extends StateRecord implements DerivedState.Record<T> {
        public static final int $stable = 8;
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        /* access modifiers changed from: private */
        public static final Object Unset = new Object();
        private ObjectIntMap<StateObject> dependencies = ObjectIntMapKt.emptyObjectIntMap();
        private Object result = Unset;
        private int resultHash;
        private int validSnapshotId;
        private int validSnapshotWriteCount;

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Landroidx/compose/runtime/DerivedSnapshotState$ResultRecord$Companion;", "", "()V", "Unset", "getUnset", "()Ljava/lang/Object;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* compiled from: DerivedState.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final Object getUnset() {
                return ResultRecord.Unset;
            }
        }

        public final int getValidSnapshotId() {
            return this.validSnapshotId;
        }

        public final void setValidSnapshotId(int i) {
            this.validSnapshotId = i;
        }

        public final int getValidSnapshotWriteCount() {
            return this.validSnapshotWriteCount;
        }

        public final void setValidSnapshotWriteCount(int i) {
            this.validSnapshotWriteCount = i;
        }

        public ObjectIntMap<StateObject> getDependencies() {
            return this.dependencies;
        }

        public void setDependencies(ObjectIntMap<StateObject> objectIntMap) {
            this.dependencies = objectIntMap;
        }

        public final Object getResult() {
            return this.result;
        }

        public final void setResult(Object obj) {
            this.result = obj;
        }

        public final int getResultHash() {
            return this.resultHash;
        }

        public final void setResultHash(int i) {
            this.resultHash = i;
        }

        public void assign(StateRecord stateRecord) {
            Intrinsics.checkNotNull(stateRecord, "null cannot be cast to non-null type androidx.compose.runtime.DerivedSnapshotState.ResultRecord<T of androidx.compose.runtime.DerivedSnapshotState.ResultRecord>");
            ResultRecord resultRecord = (ResultRecord) stateRecord;
            setDependencies(resultRecord.getDependencies());
            this.result = resultRecord.result;
            this.resultHash = resultRecord.resultHash;
        }

        public StateRecord create() {
            return new ResultRecord();
        }

        public T getCurrentValue() {
            return this.result;
        }

        public final boolean isValid(DerivedState<?> derivedState, Snapshot snapshot) {
            boolean z;
            boolean z2;
            synchronized (SnapshotKt.getLock()) {
                z = false;
                z2 = (this.validSnapshotId == snapshot.getId() && this.validSnapshotWriteCount == snapshot.getWriteCount$runtime_release()) ? false : true;
            }
            if (this.result != Unset && (!z2 || this.resultHash == readableHash(derivedState, snapshot))) {
                z = true;
            }
            if (!z || !z2) {
                return z;
            }
            synchronized (SnapshotKt.getLock()) {
                this.validSnapshotId = snapshot.getId();
                this.validSnapshotWriteCount = snapshot.getWriteCount$runtime_release();
                Unit unit = Unit.INSTANCE;
            }
            return z;
        }

        public final int readableHash(DerivedState<?> derivedState, Snapshot snapshot) {
            ObjectIntMap<StateObject> dependencies2;
            int i;
            int i2;
            int i3;
            StateRecord stateRecord;
            DerivedState<?> derivedState2 = derivedState;
            Snapshot snapshot2 = snapshot;
            synchronized (SnapshotKt.getLock()) {
                dependencies2 = getDependencies();
            }
            int i4 = 7;
            if (!dependencies2.isNotEmpty()) {
                return 7;
            }
            MutableVector<DerivedStateObserver> derivedStateObservers = SnapshotStateKt.derivedStateObservers();
            int size = derivedStateObservers.getSize();
            if (size > 0) {
                Object[] content = derivedStateObservers.getContent();
                int i5 = 0;
                do {
                    ((DerivedStateObserver) content[i5]).start(derivedState2);
                    i5++;
                } while (i5 < size);
            }
            try {
                Object[] objArr = dependencies2.keys;
                int[] iArr = dependencies2.values;
                long[] jArr = dependencies2.metadata;
                int length = jArr.length - 2;
                if (length >= 0) {
                    i = 7;
                    int i6 = 0;
                    while (true) {
                        long j = jArr[i6];
                        if ((((~j) << i4) & j & -9187201950435737472L) != -9187201950435737472L) {
                            int i7 = 8;
                            int i8 = 8 - ((~(i6 - length)) >>> 31);
                            i2 = i4;
                            int i9 = 0;
                            while (i9 < i8) {
                                if ((j & 255) < 128) {
                                    int i10 = (i6 << 3) + i9;
                                    Object obj = objArr[i10];
                                    int i11 = iArr[i10];
                                    i3 = i7;
                                    StateObject stateObject = (StateObject) obj;
                                    if (i11 == 1) {
                                        if (stateObject instanceof DerivedSnapshotState) {
                                            stateRecord = ((DerivedSnapshotState) stateObject).current(snapshot2);
                                        } else {
                                            stateRecord = SnapshotKt.current(stateObject.getFirstStateRecord(), snapshot2);
                                        }
                                        i = (((i * 31) + ActualJvm_jvmKt.identityHashCode(stateRecord)) * 31) + stateRecord.getSnapshotId$runtime_release();
                                    }
                                } else {
                                    i3 = i7;
                                }
                                j >>= i3;
                                i9++;
                                i7 = i3;
                            }
                            if (i8 != i7) {
                                break;
                            }
                        } else {
                            i2 = i4;
                        }
                        if (i6 == length) {
                            i4 = i;
                            break;
                        }
                        i6++;
                        i4 = i2;
                    }
                }
                i = i4;
                Unit unit = Unit.INSTANCE;
                int size2 = derivedStateObservers.getSize();
                if (size2 > 0) {
                    Object[] content2 = derivedStateObservers.getContent();
                    int i12 = 0;
                    do {
                        ((DerivedStateObserver) content2[i12]).done(derivedState2);
                        i12++;
                    } while (i12 < size2);
                }
                return i;
            } catch (Throwable th) {
                int size3 = derivedStateObservers.getSize();
                if (size3 > 0) {
                    Object[] content3 = derivedStateObservers.getContent();
                    int i13 = 0;
                    do {
                        ((DerivedStateObserver) content3[i13]).done(derivedState2);
                        i13++;
                    } while (i13 < size3);
                }
                throw th;
            }
        }
    }

    public final StateRecord current(Snapshot snapshot) {
        return currentRecord((ResultRecord) SnapshotKt.current(this.first, snapshot), snapshot, false, this.calculation);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r25v1, resolved type: androidx.compose.runtime.collection.MutableVector} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r25v2, resolved type: androidx.compose.runtime.collection.MutableVector} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r25v3, resolved type: androidx.compose.runtime.collection.MutableVector} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r25v4, resolved type: androidx.compose.runtime.collection.MutableVector} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r25v6, resolved type: kotlin.jvm.functions.Function0<? extends T>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r25v7, resolved type: kotlin.jvm.functions.Function0<? extends T>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r25v8, resolved type: kotlin.jvm.functions.Function0<? extends T>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r25v9, resolved type: kotlin.jvm.functions.Function0<? extends T>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r25v10, resolved type: kotlin.jvm.functions.Function0<? extends T>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v11, resolved type: kotlin.jvm.functions.Function0<? extends T>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r25v11, resolved type: kotlin.jvm.functions.Function0<? extends T>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r25v12, resolved type: kotlin.jvm.functions.Function0<? extends T>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r25v13, resolved type: androidx.compose.runtime.collection.MutableVector} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r25v14, resolved type: kotlin.jvm.functions.Function0<? extends T>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r25v16, resolved type: kotlin.jvm.functions.Function0<? extends T>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r25v17, resolved type: androidx.compose.runtime.collection.MutableVector} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r25v19, resolved type: kotlin.jvm.functions.Function0<? extends T>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r25v20, resolved type: androidx.compose.runtime.collection.MutableVector} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r25v21, resolved type: kotlin.jvm.functions.Function0<? extends T>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r25v22, resolved type: androidx.compose.runtime.collection.MutableVector} */
    /* JADX WARNING: type inference failed for: r4v5, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARNING: type inference failed for: r4v8 */
    /* JADX WARNING: type inference failed for: r4v9 */
    /* JADX WARNING: type inference failed for: r4v10 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00f3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final androidx.compose.runtime.DerivedSnapshotState.ResultRecord<T> currentRecord(androidx.compose.runtime.DerivedSnapshotState.ResultRecord<T> r22, androidx.compose.runtime.snapshots.Snapshot r23, boolean r24, kotlin.jvm.functions.Function0<? extends T> r25) {
        /*
            r21 = this;
            r1 = r21
            r0 = r22
            r2 = r1
            androidx.compose.runtime.DerivedState r2 = (androidx.compose.runtime.DerivedState) r2
            r3 = r23
            boolean r4 = r0.isValid(r2, r3)
            r5 = 1
            r6 = 0
            if (r4 == 0) goto L_0x0106
            if (r24 == 0) goto L_0x0105
            androidx.compose.runtime.collection.MutableVector r4 = androidx.compose.runtime.SnapshotStateKt.derivedStateObservers()
            int r7 = r4.getSize()
            if (r7 <= 0) goto L_0x002c
            java.lang.Object[] r8 = r4.getContent()
            r9 = r6
        L_0x0022:
            r10 = r8[r9]
            androidx.compose.runtime.DerivedStateObserver r10 = (androidx.compose.runtime.DerivedStateObserver) r10
            r10.start(r2)
            int r9 = r9 + r5
            if (r9 < r7) goto L_0x0022
        L_0x002c:
            androidx.collection.ObjectIntMap r7 = r0.getDependencies()     // Catch:{ all -> 0x00e8 }
            androidx.compose.runtime.SnapshotThreadLocal r8 = androidx.compose.runtime.SnapshotStateKt__DerivedStateKt.calculationBlockNestedLevel     // Catch:{ all -> 0x00e8 }
            java.lang.Object r8 = r8.get()     // Catch:{ all -> 0x00e8 }
            androidx.compose.runtime.internal.IntRef r8 = (androidx.compose.runtime.internal.IntRef) r8     // Catch:{ all -> 0x00e8 }
            if (r8 != 0) goto L_0x0048
            androidx.compose.runtime.internal.IntRef r8 = new androidx.compose.runtime.internal.IntRef     // Catch:{ all -> 0x00e8 }
            r8.<init>(r6)     // Catch:{ all -> 0x00e8 }
            androidx.compose.runtime.SnapshotThreadLocal r9 = androidx.compose.runtime.SnapshotStateKt__DerivedStateKt.calculationBlockNestedLevel     // Catch:{ all -> 0x00e8 }
            r9.set(r8)     // Catch:{ all -> 0x00e8 }
        L_0x0048:
            int r9 = r8.getElement()     // Catch:{ all -> 0x00e8 }
            java.lang.Object[] r10 = r7.keys     // Catch:{ all -> 0x00e8 }
            int[] r11 = r7.values     // Catch:{ all -> 0x00e8 }
            long[] r7 = r7.metadata     // Catch:{ all -> 0x00e8 }
            int r12 = r7.length     // Catch:{ all -> 0x00e8 }
            int r12 = r12 + -2
            if (r12 < 0) goto L_0x00c6
            r13 = r6
        L_0x0058:
            r14 = r7[r13]     // Catch:{ all -> 0x00e8 }
            r16 = r5
            long r5 = ~r14
            r17 = 7
            long r5 = r5 << r17
            long r5 = r5 & r14
            r17 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r5 = r5 & r17
            int r5 = (r5 > r17 ? 1 : (r5 == r17 ? 0 : -1))
            if (r5 == 0) goto L_0x00b8
            int r5 = r13 - r12
            int r5 = ~r5
            int r5 = r5 >>> 31
            r6 = 8
            int r5 = 8 - r5
            r24 = r6
            r6 = 0
        L_0x0079:
            if (r6 >= r5) goto L_0x00b1
            r17 = 255(0xff, double:1.26E-321)
            long r17 = r14 & r17
            r19 = 128(0x80, double:6.32E-322)
            int r17 = (r17 > r19 ? 1 : (r17 == r19 ? 0 : -1))
            if (r17 >= 0) goto L_0x00a6
            int r17 = r13 << 3
            int r17 = r17 + r6
            r18 = r10[r17]     // Catch:{ all -> 0x00a2 }
            r17 = r11[r17]     // Catch:{ all -> 0x00a2 }
            r3 = r18
            androidx.compose.runtime.snapshots.StateObject r3 = (androidx.compose.runtime.snapshots.StateObject) r3     // Catch:{ all -> 0x00a2 }
            r25 = r4
            int r4 = r9 + r17
            r8.setElement(r4)     // Catch:{ all -> 0x00e6 }
            kotlin.jvm.functions.Function1 r4 = r23.getReadObserver()     // Catch:{ all -> 0x00e6 }
            if (r4 == 0) goto L_0x00a8
            r4.invoke(r3)     // Catch:{ all -> 0x00e6 }
            goto L_0x00a8
        L_0x00a2:
            r0 = move-exception
            r25 = r4
            goto L_0x00ed
        L_0x00a6:
            r25 = r4
        L_0x00a8:
            long r14 = r14 >> r24
            int r6 = r6 + 1
            r3 = r23
            r4 = r25
            goto L_0x0079
        L_0x00b1:
            r3 = r24
            r25 = r4
            if (r5 != r3) goto L_0x00ca
            goto L_0x00ba
        L_0x00b8:
            r25 = r4
        L_0x00ba:
            if (r13 == r12) goto L_0x00ca
            int r13 = r13 + 1
            r3 = r23
            r4 = r25
            r5 = r16
            r6 = 0
            goto L_0x0058
        L_0x00c6:
            r25 = r4
            r16 = r5
        L_0x00ca:
            r8.setElement(r9)     // Catch:{ all -> 0x00e6 }
            kotlin.Unit r3 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00e6 }
            int r3 = r25.getSize()
            if (r3 <= 0) goto L_0x0105
            java.lang.Object[] r4 = r25.getContent()
            r6 = 0
        L_0x00da:
            r5 = r4[r6]
            androidx.compose.runtime.DerivedStateObserver r5 = (androidx.compose.runtime.DerivedStateObserver) r5
            r5.done(r2)
            int r6 = r6 + 1
            if (r6 < r3) goto L_0x00da
            goto L_0x0105
        L_0x00e6:
            r0 = move-exception
            goto L_0x00ed
        L_0x00e8:
            r0 = move-exception
            r25 = r4
            r16 = r5
        L_0x00ed:
            int r3 = r25.getSize()
            if (r3 <= 0) goto L_0x0104
            java.lang.Object[] r4 = r25.getContent()
            r6 = 0
        L_0x00f8:
            r5 = r4[r6]
            androidx.compose.runtime.DerivedStateObserver r5 = (androidx.compose.runtime.DerivedStateObserver) r5
            r5.done(r2)
            int r6 = r6 + 1
            if (r6 >= r3) goto L_0x0104
            goto L_0x00f8
        L_0x0104:
            throw r0
        L_0x0105:
            return r0
        L_0x0106:
            r16 = r5
            androidx.collection.MutableObjectIntMap r3 = new androidx.collection.MutableObjectIntMap
            r4 = 0
            r6 = 0
            r3.<init>(r6, r5, r4)
            androidx.compose.runtime.SnapshotThreadLocal r5 = androidx.compose.runtime.SnapshotStateKt__DerivedStateKt.calculationBlockNestedLevel
            java.lang.Object r5 = r5.get()
            androidx.compose.runtime.internal.IntRef r5 = (androidx.compose.runtime.internal.IntRef) r5
            if (r5 != 0) goto L_0x0127
            androidx.compose.runtime.internal.IntRef r5 = new androidx.compose.runtime.internal.IntRef
            r5.<init>(r6)
            androidx.compose.runtime.SnapshotThreadLocal r7 = androidx.compose.runtime.SnapshotStateKt__DerivedStateKt.calculationBlockNestedLevel
            r7.set(r5)
        L_0x0127:
            int r7 = r5.getElement()
            androidx.compose.runtime.collection.MutableVector r8 = androidx.compose.runtime.SnapshotStateKt.derivedStateObservers()
            int r9 = r8.getSize()
            if (r9 <= 0) goto L_0x0147
            java.lang.Object[] r10 = r8.getContent()
            r11 = r6
        L_0x013a:
            r12 = r10[r11]
            androidx.compose.runtime.DerivedStateObserver r12 = (androidx.compose.runtime.DerivedStateObserver) r12
            r12.start(r2)
            r16 = 1
            int r11 = r11 + 1
            if (r11 < r9) goto L_0x013a
        L_0x0147:
            int r9 = r7 + 1
            r5.setElement(r9)     // Catch:{ all -> 0x0208 }
            androidx.compose.runtime.snapshots.Snapshot$Companion r9 = androidx.compose.runtime.snapshots.Snapshot.Companion     // Catch:{ all -> 0x0208 }
            androidx.compose.runtime.DerivedSnapshotState$currentRecord$result$1$1$result$1 r10 = new androidx.compose.runtime.DerivedSnapshotState$currentRecord$result$1$1$result$1     // Catch:{ all -> 0x0208 }
            r10.<init>(r1, r5, r3, r7)     // Catch:{ all -> 0x0208 }
            kotlin.jvm.functions.Function1 r10 = (kotlin.jvm.functions.Function1) r10     // Catch:{ all -> 0x0208 }
            r11 = r25
            java.lang.Object r4 = r9.observe(r10, r4, r11)     // Catch:{ all -> 0x0208 }
            r5.setElement(r7)     // Catch:{ all -> 0x0208 }
            int r5 = r8.getSize()
            if (r5 <= 0) goto L_0x0175
            java.lang.Object[] r7 = r8.getContent()
        L_0x0168:
            r8 = r7[r6]
            androidx.compose.runtime.DerivedStateObserver r8 = (androidx.compose.runtime.DerivedStateObserver) r8
            r8.done(r2)
            r16 = 1
            int r6 = r6 + 1
            if (r6 < r5) goto L_0x0168
        L_0x0175:
            java.lang.Object r2 = androidx.compose.runtime.snapshots.SnapshotKt.getLock()
            monitor-enter(r2)
            androidx.compose.runtime.snapshots.Snapshot$Companion r5 = androidx.compose.runtime.snapshots.Snapshot.Companion     // Catch:{ all -> 0x0205 }
            androidx.compose.runtime.snapshots.Snapshot r5 = r5.getCurrent()     // Catch:{ all -> 0x0205 }
            java.lang.Object r6 = r0.getResult()     // Catch:{ all -> 0x0205 }
            androidx.compose.runtime.DerivedSnapshotState$ResultRecord$Companion r7 = androidx.compose.runtime.DerivedSnapshotState.ResultRecord.Companion     // Catch:{ all -> 0x0205 }
            java.lang.Object r7 = r7.getUnset()     // Catch:{ all -> 0x0205 }
            if (r6 == r7) goto L_0x01ad
            androidx.compose.runtime.SnapshotMutationPolicy r6 = r1.getPolicy()     // Catch:{ all -> 0x0205 }
            if (r6 == 0) goto L_0x01ad
            java.lang.Object r7 = r0.getResult()     // Catch:{ all -> 0x0205 }
            boolean r6 = r6.equivalent(r4, r7)     // Catch:{ all -> 0x0205 }
            r7 = 1
            if (r6 != r7) goto L_0x01ad
            androidx.collection.ObjectIntMap r3 = (androidx.collection.ObjectIntMap) r3     // Catch:{ all -> 0x0205 }
            r0.setDependencies(r3)     // Catch:{ all -> 0x0205 }
            r3 = r1
            androidx.compose.runtime.DerivedState r3 = (androidx.compose.runtime.DerivedState) r3     // Catch:{ all -> 0x0205 }
            int r3 = r0.readableHash(r3, r5)     // Catch:{ all -> 0x0205 }
            r0.setResultHash(r3)     // Catch:{ all -> 0x0205 }
            goto L_0x01cc
        L_0x01ad:
            androidx.compose.runtime.DerivedSnapshotState$ResultRecord<T> r0 = r1.first     // Catch:{ all -> 0x0205 }
            androidx.compose.runtime.snapshots.StateRecord r0 = (androidx.compose.runtime.snapshots.StateRecord) r0     // Catch:{ all -> 0x0205 }
            r6 = r1
            androidx.compose.runtime.snapshots.StateObject r6 = (androidx.compose.runtime.snapshots.StateObject) r6     // Catch:{ all -> 0x0205 }
            androidx.compose.runtime.snapshots.StateRecord r0 = androidx.compose.runtime.snapshots.SnapshotKt.newWritableRecord(r0, r6, r5)     // Catch:{ all -> 0x0205 }
            androidx.compose.runtime.DerivedSnapshotState$ResultRecord r0 = (androidx.compose.runtime.DerivedSnapshotState.ResultRecord) r0     // Catch:{ all -> 0x0205 }
            androidx.collection.ObjectIntMap r3 = (androidx.collection.ObjectIntMap) r3     // Catch:{ all -> 0x0205 }
            r0.setDependencies(r3)     // Catch:{ all -> 0x0205 }
            r3 = r1
            androidx.compose.runtime.DerivedState r3 = (androidx.compose.runtime.DerivedState) r3     // Catch:{ all -> 0x0205 }
            int r3 = r0.readableHash(r3, r5)     // Catch:{ all -> 0x0205 }
            r0.setResultHash(r3)     // Catch:{ all -> 0x0205 }
            r0.setResult(r4)     // Catch:{ all -> 0x0205 }
        L_0x01cc:
            monitor-exit(r2)
            androidx.compose.runtime.SnapshotThreadLocal r2 = androidx.compose.runtime.SnapshotStateKt__DerivedStateKt.calculationBlockNestedLevel
            java.lang.Object r2 = r2.get()
            androidx.compose.runtime.internal.IntRef r2 = (androidx.compose.runtime.internal.IntRef) r2
            if (r2 == 0) goto L_0x0204
            int r2 = r2.getElement()
            if (r2 != 0) goto L_0x0204
            androidx.compose.runtime.snapshots.Snapshot$Companion r2 = androidx.compose.runtime.snapshots.Snapshot.Companion
            r2.notifyObjectsInitialized()
            java.lang.Object r2 = androidx.compose.runtime.snapshots.SnapshotKt.getLock()
            monitor-enter(r2)
            androidx.compose.runtime.snapshots.Snapshot$Companion r3 = androidx.compose.runtime.snapshots.Snapshot.Companion     // Catch:{ all -> 0x0201 }
            androidx.compose.runtime.snapshots.Snapshot r3 = r3.getCurrent()     // Catch:{ all -> 0x0201 }
            int r4 = r3.getId()     // Catch:{ all -> 0x0201 }
            r0.setValidSnapshotId(r4)     // Catch:{ all -> 0x0201 }
            int r3 = r3.getWriteCount$runtime_release()     // Catch:{ all -> 0x0201 }
            r0.setValidSnapshotWriteCount(r3)     // Catch:{ all -> 0x0201 }
            kotlin.Unit r3 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0201 }
            monitor-exit(r2)
            return r0
        L_0x0201:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        L_0x0204:
            return r0
        L_0x0205:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        L_0x0208:
            r0 = move-exception
            int r3 = r8.getSize()
            if (r3 <= 0) goto L_0x0221
            java.lang.Object[] r4 = r8.getContent()
        L_0x0213:
            r5 = r4[r6]
            androidx.compose.runtime.DerivedStateObserver r5 = (androidx.compose.runtime.DerivedStateObserver) r5
            r5.done(r2)
            r16 = 1
            int r6 = r6 + 1
            if (r6 >= r3) goto L_0x0221
            goto L_0x0213
        L_0x0221:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.DerivedSnapshotState.currentRecord(androidx.compose.runtime.DerivedSnapshotState$ResultRecord, androidx.compose.runtime.snapshots.Snapshot, boolean, kotlin.jvm.functions.Function0):androidx.compose.runtime.DerivedSnapshotState$ResultRecord");
    }

    public StateRecord getFirstStateRecord() {
        return this.first;
    }

    public void prependStateRecord(StateRecord stateRecord) {
        Intrinsics.checkNotNull(stateRecord, "null cannot be cast to non-null type androidx.compose.runtime.DerivedSnapshotState.ResultRecord<T of androidx.compose.runtime.DerivedSnapshotState>");
        this.first = (ResultRecord) stateRecord;
    }

    public T getValue() {
        Function1<Object, Unit> readObserver = Snapshot.Companion.getCurrent().getReadObserver();
        if (readObserver != null) {
            readObserver.invoke(this);
        }
        Snapshot current = Snapshot.Companion.getCurrent();
        return currentRecord((ResultRecord) SnapshotKt.current(this.first, current), current, true, this.calculation).getResult();
    }

    public DerivedState.Record<T> getCurrentRecord() {
        Snapshot current = Snapshot.Companion.getCurrent();
        return currentRecord((ResultRecord) SnapshotKt.current(this.first, current), current, false, this.calculation);
    }

    public String toString() {
        ResultRecord resultRecord = (ResultRecord) SnapshotKt.current(this.first);
        return "DerivedState(value=" + displayValue() + ")@" + hashCode();
    }

    public final T getDebuggerDisplayValue() {
        ResultRecord resultRecord = (ResultRecord) SnapshotKt.current(this.first);
        if (resultRecord.isValid(this, Snapshot.Companion.getCurrent())) {
            return resultRecord.getResult();
        }
        return null;
    }

    private final String displayValue() {
        ResultRecord resultRecord = (ResultRecord) SnapshotKt.current(this.first);
        if (resultRecord.isValid(this, Snapshot.Companion.getCurrent())) {
            return String.valueOf(resultRecord.getResult());
        }
        return "<Not calculated>";
    }
}
