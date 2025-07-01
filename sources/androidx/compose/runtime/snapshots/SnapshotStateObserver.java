package androidx.compose.runtime.snapshots;

import androidx.collection.MutableObjectIntMap;
import androidx.collection.MutableScatterMap;
import androidx.collection.MutableScatterSet;
import androidx.collection.ObjectIntMap;
import androidx.collection.ScatterSet;
import androidx.compose.animation.core.MutatorMutex$$ExternalSyntheticBackportWithForwarding0;
import androidx.compose.runtime.ActualJvm_jvmKt;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DerivedState;
import androidx.compose.runtime.DerivedStateObserver;
import androidx.compose.runtime.PreconditionsKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.collection.ScopeMap;
import androidx.compose.runtime.snapshots.ReaderKind;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Deprecated;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u0001\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u00017B.\u0012'\u0010\u0002\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\u0010\tJ\u0016\u0010\u001d\u001a\u00020\u00052\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00010\fH\u0002J\u0006\u0010\u001f\u001a\u00020\u0005J\u000e\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u0001J)\u0010!\u001a\u00020\u00052!\u0010\"\u001a\u001d\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u00150\u0003J\b\u0010#\u001a\u00020\u0015H\u0002J&\u0010$\u001a\u00020\u0011\"\b\b\u0000\u0010%*\u00020\u00012\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u0002H%\u0012\u0004\u0012\u00020\u00050\u0003H\u0002J\u001d\u0010'\u001a\u00020\u00052\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00050\u0003H\bJ\u001e\u0010)\u001a\u00020\u00052\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00010\f2\u0006\u0010+\u001a\u00020\rH\u0007J?\u0010,\u001a\u00020\u0005\"\b\b\u0000\u0010%*\u00020\u00012\u0006\u0010 \u001a\u0002H%2\u0012\u0010-\u001a\u000e\u0012\u0004\u0012\u0002H%\u0012\u0004\u0012\u00020\u00050\u00032\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010.J\u0010\u0010/\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\fH\u0002J\u001d\u00100\u001a\u00020\u00052\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00150\u0003H\bJ\b\u00101\u001a\u000202H\u0002J\b\u00103\u001a\u00020\u0005H\u0002J\u0006\u00104\u001a\u00020\u0005J\u0006\u00105\u001a\u00020\u0005J\u0016\u00106\u001a\u00020\u00052\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0007R&\u0010\n\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\f\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00050\u000bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00110\u0017X\u0004¢\u0006\u0002\n\u0000R/\u0010\u0002\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\u00050\u0003X\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0018\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0019j\n\u0012\u0006\u0012\u0004\u0018\u00010\u0001`\u001aX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00050\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000¨\u00068"}, d2 = {"Landroidx/compose/runtime/snapshots/SnapshotStateObserver;", "", "onChangedExecutor", "Lkotlin/Function1;", "Lkotlin/Function0;", "", "Lkotlin/ParameterName;", "name", "callback", "(Lkotlin/jvm/functions/Function1;)V", "applyObserver", "Lkotlin/Function2;", "", "Landroidx/compose/runtime/snapshots/Snapshot;", "applyUnsubscribe", "Landroidx/compose/runtime/snapshots/ObserverHandle;", "currentMap", "Landroidx/compose/runtime/snapshots/SnapshotStateObserver$ObservedScopeMap;", "currentMapThreadId", "", "isPaused", "", "observedScopeMaps", "Landroidx/compose/runtime/collection/MutableVector;", "pendingChanges", "Ljava/util/concurrent/atomic/AtomicReference;", "Landroidx/compose/runtime/AtomicReference;", "readObserver", "sendingNotifications", "addChanges", "set", "clear", "scope", "clearIf", "predicate", "drainChanges", "ensureMap", "T", "onChanged", "forEachScopeMap", "block", "notifyChanges", "changes", "snapshot", "observeReads", "onValueChangedForScope", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "removeChanges", "removeScopeMapIf", "report", "", "sendNotifications", "start", "stop", "withNoObservations", "ObservedScopeMap", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: SnapshotStateObserver.kt */
public final class SnapshotStateObserver {
    public static final int $stable = 8;
    private final Function2<Set<? extends Object>, Snapshot, Unit> applyObserver = new SnapshotStateObserver$applyObserver$1(this);
    private ObserverHandle applyUnsubscribe;
    /* access modifiers changed from: private */
    public ObservedScopeMap currentMap;
    private long currentMapThreadId = -1;
    /* access modifiers changed from: private */
    public boolean isPaused;
    /* access modifiers changed from: private */
    public final MutableVector<ObservedScopeMap> observedScopeMaps = new MutableVector<>(new ObservedScopeMap[16], 0);
    private final Function1<Function0<Unit>, Unit> onChangedExecutor;
    private final AtomicReference<Object> pendingChanges = new AtomicReference<>((Object) null);
    private final Function1<Object, Unit> readObserver = new SnapshotStateObserver$readObserver$1(this);
    /* access modifiers changed from: private */
    public boolean sendingNotifications;

    public SnapshotStateObserver(Function1<? super Function0<Unit>, Unit> function1) {
        this.onChangedExecutor = function1;
    }

    /* access modifiers changed from: private */
    public final boolean drainChanges() {
        boolean z;
        synchronized (this.observedScopeMaps) {
            z = this.sendingNotifications;
        }
        if (z) {
            return false;
        }
        boolean z2 = false;
        while (true) {
            Set<Object> removeChanges = removeChanges();
            if (removeChanges == null) {
                return z2;
            }
            synchronized (this.observedScopeMaps) {
                MutableVector<ObservedScopeMap> mutableVector = this.observedScopeMaps;
                int size = mutableVector.getSize();
                if (size > 0) {
                    Object[] content = mutableVector.getContent();
                    int i = 0;
                    do {
                        if (!((ObservedScopeMap) content[i]).recordInvalidation(removeChanges)) {
                            if (!z2) {
                                z2 = false;
                                i++;
                            }
                        }
                        z2 = true;
                        i++;
                    } while (i < size);
                }
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    /* access modifiers changed from: private */
    public final void sendNotifications() {
        this.onChangedExecutor.invoke(new SnapshotStateObserver$sendNotifications$1(this));
    }

    /* access modifiers changed from: private */
    public final void addChanges(Set<? extends Object> set) {
        Object obj;
        Collection collection;
        do {
            obj = this.pendingChanges.get();
            if (obj == null) {
                collection = set;
            } else if (obj instanceof Set) {
                collection = CollectionsKt.listOf(obj, set);
            } else if (obj instanceof List) {
                collection = CollectionsKt.plus((Collection) obj, CollectionsKt.listOf(set));
            } else {
                report();
                throw new KotlinNothingValueException();
            }
        } while (!MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m(this.pendingChanges, obj, collection));
    }

    private final Set<Object> removeChanges() {
        Object obj;
        Object obj2;
        Set<Object> set;
        do {
            obj = this.pendingChanges.get();
            obj2 = null;
            if (obj == null) {
                return null;
            }
            if (obj instanceof Set) {
                set = (Set) obj;
            } else if (obj instanceof List) {
                List list = (List) obj;
                Set<Object> set2 = (Set) list.get(0);
                if (list.size() == 2) {
                    obj2 = list.get(1);
                } else if (list.size() > 2) {
                    obj2 = list.subList(1, list.size());
                }
                set = set2;
            } else {
                report();
                throw new KotlinNothingValueException();
            }
        } while (!MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m(this.pendingChanges, obj, obj2));
        return set;
    }

    private final Void report() {
        ComposerKt.composeRuntimeError("Unexpected notification");
        throw new KotlinNothingValueException();
    }

    private final void forEachScopeMap(Function1<? super ObservedScopeMap, Unit> function1) {
        synchronized (this.observedScopeMaps) {
            MutableVector<ObservedScopeMap> mutableVector = this.observedScopeMaps;
            int size = mutableVector.getSize();
            if (size > 0) {
                Object[] content = mutableVector.getContent();
                int i = 0;
                do {
                    function1.invoke(content[i]);
                    i++;
                } while (i < size);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    private final void removeScopeMapIf(Function1<? super ObservedScopeMap, Boolean> function1) {
        synchronized (this.observedScopeMaps) {
            MutableVector<ObservedScopeMap> mutableVector = this.observedScopeMaps;
            int size = mutableVector.getSize();
            int i = 0;
            for (int i2 = 0; i2 < size; i2++) {
                if (function1.invoke(mutableVector.getContent()[i2]).booleanValue()) {
                    i++;
                } else if (i > 0) {
                    mutableVector.getContent()[i2 - i] = mutableVector.getContent()[i2];
                }
            }
            int i3 = size - i;
            ArraysKt.fill((T[]) mutableVector.getContent(), null, i3, size);
            mutableVector.setSize(i3);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final <T> void observeReads(T t, Function1<? super T, Unit> function1, Function0<Unit> function0) {
        ObservedScopeMap ensureMap;
        synchronized (this.observedScopeMaps) {
            ensureMap = ensureMap(function1);
        }
        boolean z = this.isPaused;
        ObservedScopeMap observedScopeMap = this.currentMap;
        long j = this.currentMapThreadId;
        if (j != -1) {
            if (!(j == ActualJvm_jvmKt.currentThreadId())) {
                PreconditionsKt.throwIllegalArgumentException("Detected multithreaded access to SnapshotStateObserver: previousThreadId=" + j + "), currentThread={id=" + ActualJvm_jvmKt.currentThreadId() + ", name=" + ActualJvm_jvmKt.currentThreadName() + "}. Note that observation on multiple threads in layout/draw is not supported. Make sure your measure/layout/draw for each Owner (AndroidComposeView) is executed on the same thread.");
            }
        }
        try {
            this.isPaused = false;
            this.currentMap = ensureMap;
            this.currentMapThreadId = ActualJvm_jvmKt.currentThreadId();
            ensureMap.observe(t, this.readObserver, function0);
        } finally {
            this.currentMap = observedScopeMap;
            this.isPaused = z;
            this.currentMapThreadId = j;
        }
    }

    @Deprecated(message = "Replace with Snapshot.withoutReadObservation()", replaceWith = @ReplaceWith(expression = "Snapshot.withoutReadObservation(block)", imports = {"androidx.compose.runtime.snapshots.Snapshot"}))
    public final void withNoObservations(Function0<Unit> function0) {
        boolean z = this.isPaused;
        this.isPaused = true;
        try {
            function0.invoke();
        } finally {
            this.isPaused = z;
        }
    }

    public final void start() {
        this.applyUnsubscribe = Snapshot.Companion.registerApplyObserver(this.applyObserver);
    }

    public final void stop() {
        ObserverHandle observerHandle = this.applyUnsubscribe;
        if (observerHandle != null) {
            observerHandle.dispose();
        }
    }

    public final void notifyChanges(Set<? extends Object> set, Snapshot snapshot) {
        this.applyObserver.invoke(set, snapshot);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: java.lang.Object[]} */
    /* JADX WARNING: type inference failed for: r3v3 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final <T> androidx.compose.runtime.snapshots.SnapshotStateObserver.ObservedScopeMap ensureMap(kotlin.jvm.functions.Function1<? super T, kotlin.Unit> r6) {
        /*
            r5 = this;
            androidx.compose.runtime.collection.MutableVector<androidx.compose.runtime.snapshots.SnapshotStateObserver$ObservedScopeMap> r0 = r5.observedScopeMaps
            int r1 = r0.getSize()
            if (r1 <= 0) goto L_0x001d
            java.lang.Object[] r0 = r0.getContent()
            r2 = 0
        L_0x000d:
            r3 = r0[r2]
            r4 = r3
            androidx.compose.runtime.snapshots.SnapshotStateObserver$ObservedScopeMap r4 = (androidx.compose.runtime.snapshots.SnapshotStateObserver.ObservedScopeMap) r4
            kotlin.jvm.functions.Function1 r4 = r4.getOnChanged()
            if (r4 != r6) goto L_0x0019
            goto L_0x001e
        L_0x0019:
            int r2 = r2 + 1
            if (r2 < r1) goto L_0x000d
        L_0x001d:
            r3 = 0
        L_0x001e:
            androidx.compose.runtime.snapshots.SnapshotStateObserver$ObservedScopeMap r3 = (androidx.compose.runtime.snapshots.SnapshotStateObserver.ObservedScopeMap) r3
            if (r3 != 0) goto L_0x0039
            androidx.compose.runtime.snapshots.SnapshotStateObserver$ObservedScopeMap r0 = new androidx.compose.runtime.snapshots.SnapshotStateObserver$ObservedScopeMap
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.Function1<kotlin.Any, kotlin.Unit>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6, r1)
            r1 = 1
            java.lang.Object r6 = kotlin.jvm.internal.TypeIntrinsics.beforeCheckcastToFunctionOfArity(r6, r1)
            kotlin.jvm.functions.Function1 r6 = (kotlin.jvm.functions.Function1) r6
            r0.<init>(r6)
            androidx.compose.runtime.collection.MutableVector<androidx.compose.runtime.snapshots.SnapshotStateObserver$ObservedScopeMap> r6 = r5.observedScopeMaps
            r6.add(r0)
            return r0
        L_0x0039:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.SnapshotStateObserver.ensureMap(kotlin.jvm.functions.Function1):androidx.compose.runtime.snapshots.SnapshotStateObserver$ObservedScopeMap");
    }

    @Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u0006\u0010\u001f\u001a\u00020\u0004J\u0010\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u0001H\u0002J\u000e\u0010\"\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u0001J\u0006\u0010#\u001a\u00020$J\u0006\u0010%\u001a\u00020\u0004J0\u0010&\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00012\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00040)J\u0014\u0010*\u001a\u00020$2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00010,J\u000e\u0010-\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u0001J.\u0010-\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00012\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00010\bH\u0002J\u0018\u00100\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00012\u0006\u0010.\u001a\u00020\u0001H\u0002J)\u00101\u001a\u00020\u00042!\u00102\u001a\u001d\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b(!\u0012\u0004\u0012\u00020$0\u0003J\u0012\u00105\u001a\u00020\u00042\n\u00106\u001a\u0006\u0012\u0002\b\u00030\rR\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u0001\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r0\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00010\u0014X\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R6\u0010\u0017\u001a*\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0018j\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r\u0012\u0006\u0012\u0004\u0018\u00010\u0001`\u0019X\u0004¢\u0006\u0002\n\u0000R \u0010\u001a\u001a\u0014\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\b0\u001bX\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u001c\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r0\u001dX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\fX\u0004¢\u0006\u0002\n\u0000¨\u00067"}, d2 = {"Landroidx/compose/runtime/snapshots/SnapshotStateObserver$ObservedScopeMap;", "", "onChanged", "Lkotlin/Function1;", "", "(Lkotlin/jvm/functions/Function1;)V", "currentScope", "currentScopeReads", "Landroidx/collection/MutableObjectIntMap;", "currentToken", "", "dependencyToDerivedStates", "Landroidx/compose/runtime/collection/ScopeMap;", "Landroidx/compose/runtime/DerivedState;", "deriveStateScopeCount", "derivedStateObserver", "Landroidx/compose/runtime/DerivedStateObserver;", "getDerivedStateObserver", "()Landroidx/compose/runtime/DerivedStateObserver;", "invalidated", "Landroidx/collection/MutableScatterSet;", "getOnChanged", "()Lkotlin/jvm/functions/Function1;", "recordedDerivedStateValues", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "scopeToValues", "Landroidx/collection/MutableScatterMap;", "statesToReread", "Landroidx/compose/runtime/collection/MutableVector;", "valueToScopes", "clear", "clearObsoleteStateReads", "scope", "clearScopeObservations", "hasScopeObservations", "", "notifyInvalidatedScopes", "observe", "readObserver", "block", "Lkotlin/Function0;", "recordInvalidation", "changes", "", "recordRead", "value", "recordedValues", "removeObservation", "removeScopeIf", "predicate", "Lkotlin/ParameterName;", "name", "rereadDerivedState", "derivedState", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: SnapshotStateObserver.kt */
    private static final class ObservedScopeMap {
        private Object currentScope;
        private MutableObjectIntMap<Object> currentScopeReads;
        private int currentToken = -1;
        private final ScopeMap<Object, DerivedState<?>> dependencyToDerivedStates = new ScopeMap<>();
        /* access modifiers changed from: private */
        public int deriveStateScopeCount;
        private final DerivedStateObserver derivedStateObserver = new SnapshotStateObserver$ObservedScopeMap$derivedStateObserver$1(this);
        private final MutableScatterSet<Object> invalidated = new MutableScatterSet<>(0, 1, (DefaultConstructorMarker) null);
        private final Function1<Object, Unit> onChanged;
        private final HashMap<DerivedState<?>, Object> recordedDerivedStateValues = new HashMap<>();
        private final MutableScatterMap<Object, MutableObjectIntMap<Object>> scopeToValues = new MutableScatterMap<>(0, 1, (DefaultConstructorMarker) null);
        private final MutableVector<DerivedState<?>> statesToReread = new MutableVector<>(new DerivedState[16], 0);
        private final ScopeMap<Object, Object> valueToScopes = new ScopeMap<>();

        public ObservedScopeMap(Function1<Object, Unit> function1) {
            this.onChanged = function1;
        }

        public final Function1<Object, Unit> getOnChanged() {
            return this.onChanged;
        }

        public final DerivedStateObserver getDerivedStateObserver() {
            return this.derivedStateObserver;
        }

        public final void recordRead(Object obj) {
            Object obj2 = this.currentScope;
            Intrinsics.checkNotNull(obj2);
            int i = this.currentToken;
            MutableObjectIntMap<Object> mutableObjectIntMap = this.currentScopeReads;
            if (mutableObjectIntMap == null) {
                mutableObjectIntMap = new MutableObjectIntMap<>(0, 1, (DefaultConstructorMarker) null);
                this.currentScopeReads = mutableObjectIntMap;
                this.scopeToValues.set(obj2, mutableObjectIntMap);
                Unit unit = Unit.INSTANCE;
            }
            recordRead(obj, i, obj2, mutableObjectIntMap);
        }

        private final void recordRead(Object obj, int i, Object obj2, MutableObjectIntMap<Object> mutableObjectIntMap) {
            int i2;
            int i3;
            int i4;
            Object obj3 = obj;
            int i5 = i;
            if (this.deriveStateScopeCount <= 0) {
                int put = mutableObjectIntMap.put(obj3, i5, -1);
                int i6 = 2;
                if (!(obj3 instanceof DerivedState) || put == i5) {
                    i2 = 2;
                    i3 = -1;
                } else {
                    DerivedState.Record currentRecord = ((DerivedState) obj3).getCurrentRecord();
                    this.recordedDerivedStateValues.put(obj3, currentRecord.getCurrentValue());
                    ObjectIntMap<StateObject> dependencies = currentRecord.getDependencies();
                    ScopeMap<Object, DerivedState<?>> scopeMap = this.dependencyToDerivedStates;
                    scopeMap.removeScope(obj3);
                    Object[] objArr = dependencies.keys;
                    long[] jArr = dependencies.metadata;
                    int length = jArr.length - 2;
                    if (length >= 0) {
                        int i7 = 0;
                        while (true) {
                            long j = jArr[i7];
                            if ((((~j) << 7) & j & -9187201950435737472L) != -9187201950435737472L) {
                                int i8 = 8 - ((~(i7 - length)) >>> 31);
                                int i9 = 0;
                                while (i9 < i8) {
                                    if ((j & 255) < 128) {
                                        i4 = i6;
                                        StateObject stateObject = (StateObject) objArr[(i7 << 3) + i9];
                                        if (stateObject instanceof StateObjectImpl) {
                                            ReaderKind.Companion companion = ReaderKind.Companion;
                                            ((StateObjectImpl) stateObject).m3818recordReadInh_f27i8$runtime_release(ReaderKind.m3804constructorimpl(i4));
                                        }
                                        scopeMap.add(stateObject, obj3);
                                    } else {
                                        i4 = i6;
                                    }
                                    j >>= 8;
                                    i9++;
                                    i6 = i4;
                                }
                                i2 = i6;
                                if (i8 != 8) {
                                    break;
                                }
                            } else {
                                i2 = i6;
                            }
                            if (i7 == length) {
                                break;
                            }
                            i7++;
                            i6 = i2;
                        }
                    } else {
                        i2 = 2;
                    }
                    i3 = -1;
                }
                if (put == i3) {
                    if (obj3 instanceof StateObjectImpl) {
                        ReaderKind.Companion companion2 = ReaderKind.Companion;
                        ((StateObjectImpl) obj3).m3818recordReadInh_f27i8$runtime_release(ReaderKind.m3804constructorimpl(i2));
                    }
                    this.valueToScopes.add(obj3, obj2);
                }
            }
        }

        /* JADX INFO: finally extract failed */
        public final void observe(Object obj, Function1<Object, Unit> function1, Function0<Unit> function0) {
            Object obj2 = this.currentScope;
            MutableObjectIntMap<Object> mutableObjectIntMap = this.currentScopeReads;
            int i = this.currentToken;
            this.currentScope = obj;
            this.currentScopeReads = this.scopeToValues.get(obj);
            if (this.currentToken == -1) {
                this.currentToken = SnapshotKt.currentSnapshot().getId();
            }
            DerivedStateObserver derivedStateObserver2 = this.derivedStateObserver;
            MutableVector<DerivedStateObserver> derivedStateObservers = SnapshotStateKt.derivedStateObservers();
            try {
                derivedStateObservers.add(derivedStateObserver2);
                Snapshot.Companion.observe(function1, (Function1<Object, Unit>) null, function0);
                derivedStateObservers.removeAt(derivedStateObservers.getSize() - 1);
                Object obj3 = this.currentScope;
                Intrinsics.checkNotNull(obj3);
                clearObsoleteStateReads(obj3);
                this.currentScope = obj2;
                this.currentScopeReads = mutableObjectIntMap;
                this.currentToken = i;
            } catch (Throwable th) {
                derivedStateObservers.removeAt(derivedStateObservers.getSize() - 1);
                throw th;
            }
        }

        private final void clearObsoleteStateReads(Object obj) {
            int i = this.currentToken;
            MutableObjectIntMap<Object> mutableObjectIntMap = this.currentScopeReads;
            if (mutableObjectIntMap != null) {
                long[] jArr = mutableObjectIntMap.metadata;
                int length = jArr.length - 2;
                if (length >= 0) {
                    int i2 = 0;
                    while (true) {
                        long j = jArr[i2];
                        if ((((~j) << 7) & j & -9187201950435737472L) != -9187201950435737472L) {
                            int i3 = 8 - ((~(i2 - length)) >>> 31);
                            for (int i4 = 0; i4 < i3; i4++) {
                                if ((255 & j) < 128) {
                                    int i5 = (i2 << 3) + i4;
                                    Object obj2 = mutableObjectIntMap.keys[i5];
                                    boolean z = mutableObjectIntMap.values[i5] != i;
                                    Object obj3 = obj;
                                    if (z) {
                                        removeObservation(obj3, obj2);
                                    }
                                    if (z) {
                                        mutableObjectIntMap.removeValueAt(i5);
                                    }
                                } else {
                                    Object obj4 = obj;
                                }
                                j >>= 8;
                            }
                            Object obj5 = obj;
                            if (i3 != 8) {
                                return;
                            }
                        } else {
                            Object obj6 = obj;
                        }
                        if (i2 != length) {
                            i2++;
                        } else {
                            return;
                        }
                    }
                }
            }
        }

        public final void clearScopeObservations(Object obj) {
            Object obj2 = obj;
            MutableObjectIntMap remove = this.scopeToValues.remove(obj2);
            if (remove != null) {
                ObjectIntMap objectIntMap = remove;
                Object[] objArr = objectIntMap.keys;
                int[] iArr = objectIntMap.values;
                long[] jArr = objectIntMap.metadata;
                int length = jArr.length - 2;
                if (length >= 0) {
                    int i = 0;
                    while (true) {
                        long j = jArr[i];
                        if ((((~j) << 7) & j & -9187201950435737472L) != -9187201950435737472L) {
                            int i2 = 8 - ((~(i - length)) >>> 31);
                            for (int i3 = 0; i3 < i2; i3++) {
                                if ((255 & j) < 128) {
                                    int i4 = (i << 3) + i3;
                                    Object obj3 = objArr[i4];
                                    int i5 = iArr[i4];
                                    removeObservation(obj2, obj3);
                                }
                                j >>= 8;
                            }
                            if (i2 != 8) {
                                return;
                            }
                        }
                        if (i != length) {
                            i++;
                        } else {
                            return;
                        }
                    }
                }
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:30:0x00b7  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void removeScopeIf(kotlin.jvm.functions.Function1<java.lang.Object, java.lang.Boolean> r34) {
            /*
                r33 = this;
                r0 = r33
                androidx.collection.MutableScatterMap<java.lang.Object, androidx.collection.MutableObjectIntMap<java.lang.Object>> r1 = r0.scopeToValues
                r2 = r1
                androidx.collection.ScatterMap r2 = (androidx.collection.ScatterMap) r2
                long[] r2 = r2.metadata
                int r3 = r2.length
                int r3 = r3 + -2
                if (r3 < 0) goto L_0x00e5
                r5 = 0
            L_0x000f:
                r6 = r2[r5]
                long r8 = ~r6
                r10 = 7
                long r8 = r8 << r10
                long r8 = r8 & r6
                r11 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
                long r8 = r8 & r11
                int r8 = (r8 > r11 ? 1 : (r8 == r11 ? 0 : -1))
                if (r8 == 0) goto L_0x00db
                int r8 = r5 - r3
                int r8 = ~r8
                int r8 = r8 >>> 31
                r9 = 8
                int r8 = 8 - r8
                r13 = 0
            L_0x0029:
                if (r13 >= r8) goto L_0x00d5
                r14 = 255(0xff, double:1.26E-321)
                long r16 = r6 & r14
                r18 = 128(0x80, double:6.32E-322)
                int r16 = (r16 > r18 ? 1 : (r16 == r18 ? 0 : -1))
                if (r16 >= 0) goto L_0x00bd
                int r16 = r5 << 3
                int r4 = r16 + r13
                r16 = r10
                java.lang.Object[] r10 = r1.keys
                r10 = r10[r4]
                r20 = r11
                java.lang.Object[] r11 = r1.values
                r11 = r11[r4]
                androidx.collection.MutableObjectIntMap r11 = (androidx.collection.MutableObjectIntMap) r11
                r12 = r34
                java.lang.Object r22 = r12.invoke(r10)
                java.lang.Boolean r22 = (java.lang.Boolean) r22
                boolean r23 = r22.booleanValue()
                if (r23 == 0) goto L_0x00ad
                androidx.collection.ObjectIntMap r11 = (androidx.collection.ObjectIntMap) r11
                r23 = r14
                java.lang.Object[] r14 = r11.keys
                int[] r15 = r11.values
                long[] r11 = r11.metadata
                r25 = r9
                int r9 = r11.length
                int r9 = r9 + -2
                if (r9 < 0) goto L_0x00ad
                r26 = r2
                r27 = r6
                r2 = 0
            L_0x006b:
                r6 = r11[r2]
                r29 = r11
                long r11 = ~r6
                long r11 = r11 << r16
                long r11 = r11 & r6
                long r11 = r11 & r20
                int r11 = (r11 > r20 ? 1 : (r11 == r20 ? 0 : -1))
                if (r11 == 0) goto L_0x00a2
                int r11 = r2 - r9
                int r11 = ~r11
                int r11 = r11 >>> 31
                int r11 = 8 - r11
                r12 = 0
            L_0x0081:
                if (r12 >= r11) goto L_0x009e
                long r30 = r6 & r23
                int r30 = (r30 > r18 ? 1 : (r30 == r18 ? 0 : -1))
                if (r30 >= 0) goto L_0x0097
                int r30 = r2 << 3
                int r30 = r30 + r12
                r31 = r6
                r6 = r14[r30]
                r7 = r15[r30]
                r0.removeObservation(r10, r6)
                goto L_0x0099
            L_0x0097:
                r31 = r6
            L_0x0099:
                long r6 = r31 >> r25
                int r12 = r12 + 1
                goto L_0x0081
            L_0x009e:
                r6 = r25
                if (r11 != r6) goto L_0x00b1
            L_0x00a2:
                if (r2 == r9) goto L_0x00b1
                int r2 = r2 + 1
                r12 = r34
                r11 = r29
                r25 = 8
                goto L_0x006b
            L_0x00ad:
                r26 = r2
                r27 = r6
            L_0x00b1:
                boolean r2 = r22.booleanValue()
                if (r2 == 0) goto L_0x00ba
                r1.removeValueAt(r4)
            L_0x00ba:
                r6 = 8
                goto L_0x00c6
            L_0x00bd:
                r26 = r2
                r27 = r6
                r16 = r10
                r20 = r11
                r6 = r9
            L_0x00c6:
                long r9 = r27 >> r6
                int r13 = r13 + 1
                r11 = r9
                r9 = r6
                r6 = r11
                r10 = r16
                r11 = r20
                r2 = r26
                goto L_0x0029
            L_0x00d5:
                r26 = r2
                r6 = r9
                if (r8 != r6) goto L_0x00e5
                goto L_0x00dd
            L_0x00db:
                r26 = r2
            L_0x00dd:
                if (r5 == r3) goto L_0x00e5
                int r5 = r5 + 1
                r2 = r26
                goto L_0x000f
            L_0x00e5:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.SnapshotStateObserver.ObservedScopeMap.removeScopeIf(kotlin.jvm.functions.Function1):void");
        }

        public final boolean hasScopeObservations() {
            return this.scopeToValues.isNotEmpty();
        }

        private final void removeObservation(Object obj, Object obj2) {
            this.valueToScopes.remove(obj2, obj);
            if ((obj2 instanceof DerivedState) && !this.valueToScopes.contains(obj2)) {
                this.dependencyToDerivedStates.removeScope(obj2);
                this.recordedDerivedStateValues.remove(obj2);
            }
        }

        public final void clear() {
            this.valueToScopes.clear();
            this.scopeToValues.clear();
            this.dependencyToDerivedStates.clear();
            this.recordedDerivedStateValues.clear();
        }

        /* JADX WARNING: Removed duplicated region for block: B:224:0x0510  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean recordInvalidation(java.util.Set<? extends java.lang.Object> r45) {
            /*
                r44 = this;
                r0 = r44
                r1 = r45
                androidx.compose.runtime.collection.ScopeMap<java.lang.Object, androidx.compose.runtime.DerivedState<?>> r2 = r0.dependencyToDerivedStates
                java.util.HashMap<androidx.compose.runtime.DerivedState<?>, java.lang.Object> r3 = r0.recordedDerivedStateValues
                androidx.compose.runtime.collection.ScopeMap<java.lang.Object, java.lang.Object> r4 = r0.valueToScopes
                androidx.collection.MutableScatterSet<java.lang.Object> r5 = r0.invalidated
                boolean r6 = r1 instanceof androidx.compose.runtime.collection.ScatterSetWrapper
                java.lang.String r7 = "null cannot be cast to non-null type androidx.compose.runtime.DerivedState<kotlin.Any?>"
                r13 = 2
                r16 = 128(0x80, double:6.32E-322)
                r8 = 8
                r18 = 0
                if (r6 == 0) goto L_0x0323
                androidx.compose.runtime.collection.ScatterSetWrapper r1 = (androidx.compose.runtime.collection.ScatterSetWrapper) r1
                androidx.collection.ScatterSet r1 = r1.getSet$runtime_release()
                java.lang.Object[] r6 = r1.elements
                long[] r1 = r1.metadata
                r19 = 1
                int r9 = r1.length
                int r9 = r9 - r13
                if (r9 < 0) goto L_0x031f
                r23 = r13
                r10 = r18
                r11 = r10
                r20 = 255(0xff, double:1.26E-321)
                r22 = 7
            L_0x0032:
                r12 = r1[r10]
                r24 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
                long r14 = ~r12
                long r14 = r14 << r22
                long r14 = r14 & r12
                long r14 = r14 & r24
                int r14 = (r14 > r24 ? 1 : (r14 == r24 ? 0 : -1))
                if (r14 == 0) goto L_0x0306
                int r14 = r10 - r9
                int r14 = ~r14
                int r14 = r14 >>> 31
                int r14 = 8 - r14
                r15 = r18
            L_0x004c:
                if (r15 >= r14) goto L_0x02ee
                long r26 = r12 & r20
                int r26 = (r26 > r16 ? 1 : (r26 == r16 ? 0 : -1))
                if (r26 >= 0) goto L_0x02c8
                int r26 = r10 << 3
                int r26 = r26 + r15
                r27 = r8
                r8 = r6[r26]
                r26 = r1
                boolean r1 = r8 instanceof androidx.compose.runtime.snapshots.StateObjectImpl
                if (r1 == 0) goto L_0x0081
                r1 = r8
                androidx.compose.runtime.snapshots.StateObjectImpl r1 = (androidx.compose.runtime.snapshots.StateObjectImpl) r1
                androidx.compose.runtime.snapshots.ReaderKind$Companion r28 = androidx.compose.runtime.snapshots.ReaderKind.Companion
                r28 = r4
                int r4 = androidx.compose.runtime.snapshots.ReaderKind.m3804constructorimpl(r23)
                boolean r1 = r1.m3817isReadInh_f27i8$runtime_release(r4)
                if (r1 != 0) goto L_0x0083
                r35 = r6
                r36 = r7
                r32 = r9
                r33 = r10
                r30 = r12
                r40 = r14
                goto L_0x02c5
            L_0x0081:
                r28 = r4
            L_0x0083:
                boolean r1 = r2.contains(r8)
                if (r1 == 0) goto L_0x025f
                androidx.collection.MutableScatterMap r1 = r2.getMap()
                java.lang.Object r1 = r1.get(r8)
                if (r1 == 0) goto L_0x025f
                boolean r4 = r1 instanceof androidx.collection.MutableScatterSet
                if (r4 == 0) goto L_0x01d4
                androidx.collection.MutableScatterSet r1 = (androidx.collection.MutableScatterSet) r1
                androidx.collection.ScatterSet r1 = (androidx.collection.ScatterSet) r1
                java.lang.Object[] r4 = r1.elements
                long[] r1 = r1.metadata
                r45 = r4
                int r4 = r1.length
                int r4 = r4 + -2
                if (r4 < 0) goto L_0x01c4
                r29 = r1
                r30 = r12
                r1 = r18
                r13 = r11
            L_0x00ad:
                r11 = r29[r1]
                r32 = r9
                r33 = r10
                long r9 = ~r11
                long r9 = r9 << r22
                long r9 = r9 & r11
                long r9 = r9 & r24
                int r9 = (r9 > r24 ? 1 : (r9 == r24 ? 0 : -1))
                if (r9 == 0) goto L_0x01aa
                int r9 = r1 - r4
                int r9 = ~r9
                int r9 = r9 >>> 31
                int r9 = 8 - r9
                r10 = r18
            L_0x00c6:
                if (r10 >= r9) goto L_0x019f
                long r34 = r11 & r20
                int r34 = (r34 > r16 ? 1 : (r34 == r16 ? 0 : -1))
                if (r34 >= 0) goto L_0x0185
                int r34 = r1 << 3
                int r34 = r34 + r10
                r34 = r45[r34]
                r35 = r6
                r6 = r34
                androidx.compose.runtime.DerivedState r6 = (androidx.compose.runtime.DerivedState) r6
                kotlin.jvm.internal.Intrinsics.checkNotNull(r6, r7)
                r34 = r10
                java.lang.Object r10 = r3.get(r6)
                androidx.compose.runtime.SnapshotMutationPolicy r36 = r6.getPolicy()
                if (r36 != 0) goto L_0x00ed
                androidx.compose.runtime.SnapshotMutationPolicy r36 = androidx.compose.runtime.SnapshotStateKt.structuralEqualityPolicy()
            L_0x00ed:
                r37 = r11
                r11 = r36
                androidx.compose.runtime.DerivedState$Record r12 = r6.getCurrentRecord()
                java.lang.Object r12 = r12.getCurrentValue()
                boolean r10 = r11.equivalent(r12, r10)
                if (r10 != 0) goto L_0x017b
                androidx.collection.MutableScatterMap r10 = r28.getMap()
                java.lang.Object r6 = r10.get(r6)
                if (r6 == 0) goto L_0x0178
                boolean r10 = r6 instanceof androidx.collection.MutableScatterSet
                if (r10 == 0) goto L_0x016e
                androidx.collection.MutableScatterSet r6 = (androidx.collection.MutableScatterSet) r6
                androidx.collection.ScatterSet r6 = (androidx.collection.ScatterSet) r6
                java.lang.Object[] r10 = r6.elements
                long[] r6 = r6.metadata
                int r11 = r6.length
                int r11 = r11 + -2
                if (r11 < 0) goto L_0x0165
                r39 = r6
                r36 = r7
                r12 = r18
            L_0x0120:
                r6 = r39[r12]
                r41 = r13
                r40 = r14
                long r13 = ~r6
                long r13 = r13 << r22
                long r13 = r13 & r6
                long r13 = r13 & r24
                int r13 = (r13 > r24 ? 1 : (r13 == r24 ? 0 : -1))
                if (r13 == 0) goto L_0x015a
                int r13 = r12 - r11
                int r13 = ~r13
                int r13 = r13 >>> 31
                int r13 = 8 - r13
                r14 = r18
            L_0x0139:
                if (r14 >= r13) goto L_0x0156
                long r42 = r6 & r20
                int r42 = (r42 > r16 ? 1 : (r42 == r16 ? 0 : -1))
                if (r42 >= 0) goto L_0x014f
                int r41 = r12 << 3
                int r41 = r41 + r14
                r42 = r6
                r6 = r10[r41]
                r5.add(r6)
                r41 = r19
                goto L_0x0151
            L_0x014f:
                r42 = r6
            L_0x0151:
                long r6 = r42 >> r27
                int r14 = r14 + 1
                goto L_0x0139
            L_0x0156:
                r6 = r27
                if (r13 != r6) goto L_0x016b
            L_0x015a:
                r13 = r41
                if (r12 == r11) goto L_0x0169
                int r12 = r12 + 1
                r14 = r40
                r27 = 8
                goto L_0x0120
            L_0x0165:
                r36 = r7
                r40 = r14
            L_0x0169:
                r41 = r13
            L_0x016b:
                r13 = r41
                goto L_0x018f
            L_0x016e:
                r36 = r7
                r40 = r14
                r5.add(r6)
                r13 = r19
                goto L_0x018f
            L_0x0178:
                r36 = r7
                goto L_0x018d
            L_0x017b:
                r36 = r7
                r40 = r14
                androidx.compose.runtime.collection.MutableVector<androidx.compose.runtime.DerivedState<?>> r7 = r0.statesToReread
                r7.add(r6)
                goto L_0x018f
            L_0x0185:
                r35 = r6
                r36 = r7
                r34 = r10
                r37 = r11
            L_0x018d:
                r40 = r14
            L_0x018f:
                r6 = 8
                long r11 = r37 >> r6
                int r10 = r34 + 1
                r27 = r6
                r6 = r35
                r7 = r36
                r14 = r40
                goto L_0x00c6
            L_0x019f:
                r35 = r6
                r36 = r7
                r40 = r14
                r6 = r27
                if (r9 != r6) goto L_0x01d1
                goto L_0x01b0
            L_0x01aa:
                r35 = r6
                r36 = r7
                r40 = r14
            L_0x01b0:
                if (r1 == r4) goto L_0x01c2
                int r1 = r1 + 1
                r9 = r32
                r10 = r33
                r6 = r35
                r7 = r36
                r14 = r40
                r27 = 8
                goto L_0x00ad
            L_0x01c2:
                r11 = r13
                goto L_0x01d0
            L_0x01c4:
                r35 = r6
                r36 = r7
                r32 = r9
                r33 = r10
                r30 = r12
                r40 = r14
            L_0x01d0:
                r13 = r11
            L_0x01d1:
                r11 = r13
                goto L_0x026b
            L_0x01d4:
                r35 = r6
                r36 = r7
                r32 = r9
                r33 = r10
                r30 = r12
                r40 = r14
                androidx.compose.runtime.DerivedState r1 = (androidx.compose.runtime.DerivedState) r1
                java.lang.Object r4 = r3.get(r1)
                androidx.compose.runtime.SnapshotMutationPolicy r6 = r1.getPolicy()
                if (r6 != 0) goto L_0x01f0
                androidx.compose.runtime.SnapshotMutationPolicy r6 = androidx.compose.runtime.SnapshotStateKt.structuralEqualityPolicy()
            L_0x01f0:
                androidx.compose.runtime.DerivedState$Record r7 = r1.getCurrentRecord()
                java.lang.Object r7 = r7.getCurrentValue()
                boolean r4 = r6.equivalent(r7, r4)
                if (r4 != 0) goto L_0x0259
                androidx.collection.MutableScatterMap r4 = r28.getMap()
                java.lang.Object r1 = r4.get(r1)
                if (r1 == 0) goto L_0x026b
                boolean r4 = r1 instanceof androidx.collection.MutableScatterSet
                if (r4 == 0) goto L_0x0253
                androidx.collection.MutableScatterSet r1 = (androidx.collection.MutableScatterSet) r1
                androidx.collection.ScatterSet r1 = (androidx.collection.ScatterSet) r1
                java.lang.Object[] r4 = r1.elements
                long[] r1 = r1.metadata
                int r6 = r1.length
                int r6 = r6 + -2
                if (r6 < 0) goto L_0x026b
                r7 = r18
            L_0x021b:
                r9 = r1[r7]
                long r12 = ~r9
                long r12 = r12 << r22
                long r12 = r12 & r9
                long r12 = r12 & r24
                int r12 = (r12 > r24 ? 1 : (r12 == r24 ? 0 : -1))
                if (r12 == 0) goto L_0x024e
                int r12 = r7 - r6
                int r12 = ~r12
                int r12 = r12 >>> 31
                r27 = 8
                int r12 = 8 - r12
                r13 = r18
            L_0x0232:
                if (r13 >= r12) goto L_0x024a
                long r37 = r9 & r20
                int r14 = (r37 > r16 ? 1 : (r37 == r16 ? 0 : -1))
                if (r14 >= 0) goto L_0x0244
                int r11 = r7 << 3
                int r11 = r11 + r13
                r11 = r4[r11]
                r5.add(r11)
                r11 = r19
            L_0x0244:
                r14 = 8
                long r9 = r9 >> r14
                int r13 = r13 + 1
                goto L_0x0232
            L_0x024a:
                r14 = 8
                if (r12 != r14) goto L_0x026b
            L_0x024e:
                if (r7 == r6) goto L_0x026b
                int r7 = r7 + 1
                goto L_0x021b
            L_0x0253:
                r5.add(r1)
                r11 = r19
                goto L_0x026b
            L_0x0259:
                androidx.compose.runtime.collection.MutableVector<androidx.compose.runtime.DerivedState<?>> r4 = r0.statesToReread
                r4.add(r1)
                goto L_0x026b
            L_0x025f:
                r35 = r6
                r36 = r7
                r32 = r9
                r33 = r10
                r30 = r12
                r40 = r14
            L_0x026b:
                androidx.collection.MutableScatterMap r1 = r28.getMap()
                java.lang.Object r1 = r1.get(r8)
                if (r1 == 0) goto L_0x02c5
                boolean r4 = r1 instanceof androidx.collection.MutableScatterSet
                if (r4 == 0) goto L_0x02c0
                androidx.collection.MutableScatterSet r1 = (androidx.collection.MutableScatterSet) r1
                androidx.collection.ScatterSet r1 = (androidx.collection.ScatterSet) r1
                java.lang.Object[] r4 = r1.elements
                long[] r1 = r1.metadata
                int r6 = r1.length
                int r6 = r6 + -2
                if (r6 < 0) goto L_0x02c5
                r7 = r18
            L_0x0288:
                r8 = r1[r7]
                long r12 = ~r8
                long r12 = r12 << r22
                long r12 = r12 & r8
                long r12 = r12 & r24
                int r10 = (r12 > r24 ? 1 : (r12 == r24 ? 0 : -1))
                if (r10 == 0) goto L_0x02bb
                int r10 = r7 - r6
                int r10 = ~r10
                int r10 = r10 >>> 31
                r27 = 8
                int r10 = 8 - r10
                r12 = r18
            L_0x029f:
                if (r12 >= r10) goto L_0x02b7
                long r13 = r8 & r20
                int r13 = (r13 > r16 ? 1 : (r13 == r16 ? 0 : -1))
                if (r13 >= 0) goto L_0x02b1
                int r11 = r7 << 3
                int r11 = r11 + r12
                r11 = r4[r11]
                r5.add(r11)
                r11 = r19
            L_0x02b1:
                r14 = 8
                long r8 = r8 >> r14
                int r12 = r12 + 1
                goto L_0x029f
            L_0x02b7:
                r14 = 8
                if (r10 != r14) goto L_0x02c5
            L_0x02bb:
                if (r7 == r6) goto L_0x02c5
                int r7 = r7 + 1
                goto L_0x0288
            L_0x02c0:
                r5.add(r1)
                r11 = r19
            L_0x02c5:
                r14 = 8
                goto L_0x02d9
            L_0x02c8:
                r26 = r1
                r28 = r4
                r35 = r6
                r36 = r7
                r32 = r9
                r33 = r10
                r30 = r12
                r40 = r14
                r14 = r8
            L_0x02d9:
                long r12 = r30 >> r14
                int r15 = r15 + 1
                r8 = r14
                r1 = r26
                r4 = r28
                r9 = r32
                r10 = r33
                r6 = r35
                r7 = r36
                r14 = r40
                goto L_0x004c
            L_0x02ee:
                r26 = r14
                r14 = r8
                r8 = r26
                r26 = r1
                r28 = r4
                r35 = r6
                r36 = r7
                r32 = r9
                r33 = r10
                if (r8 != r14) goto L_0x056b
                r9 = r32
                r1 = r33
                goto L_0x030f
            L_0x0306:
                r26 = r1
                r28 = r4
                r35 = r6
                r36 = r7
                r1 = r10
            L_0x030f:
                if (r1 == r9) goto L_0x056b
                int r10 = r1 + 1
                r1 = r26
                r4 = r28
                r6 = r35
                r7 = r36
                r8 = 8
                goto L_0x0032
            L_0x031f:
                r11 = r18
                goto L_0x056b
            L_0x0323:
                r28 = r4
                r36 = r7
                r23 = r13
                r19 = 1
                r20 = 255(0xff, double:1.26E-321)
                r22 = 7
                r24 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
                java.lang.Iterable r1 = (java.lang.Iterable) r1
                java.util.Iterator r1 = r1.iterator()
                r11 = r18
            L_0x033c:
                boolean r4 = r1.hasNext()
                if (r4 == 0) goto L_0x056b
                java.lang.Object r4 = r1.next()
                boolean r6 = r4 instanceof androidx.compose.runtime.snapshots.StateObjectImpl
                if (r6 == 0) goto L_0x0361
                r6 = r4
                androidx.compose.runtime.snapshots.StateObjectImpl r6 = (androidx.compose.runtime.snapshots.StateObjectImpl) r6
                androidx.compose.runtime.snapshots.ReaderKind$Companion r7 = androidx.compose.runtime.snapshots.ReaderKind.Companion
                int r7 = androidx.compose.runtime.snapshots.ReaderKind.m3804constructorimpl(r23)
                boolean r6 = r6.m3817isReadInh_f27i8$runtime_release(r7)
                if (r6 != 0) goto L_0x0361
                r45 = r1
                r29 = r2
            L_0x035d:
                r14 = 8
                goto L_0x0565
            L_0x0361:
                boolean r6 = r2.contains(r4)
                if (r6 == 0) goto L_0x0502
                androidx.collection.MutableScatterMap r6 = r2.getMap()
                java.lang.Object r6 = r6.get(r4)
                if (r6 == 0) goto L_0x0502
                boolean r7 = r6 instanceof androidx.collection.MutableScatterSet
                if (r7 == 0) goto L_0x047f
                androidx.collection.MutableScatterSet r6 = (androidx.collection.MutableScatterSet) r6
                androidx.collection.ScatterSet r6 = (androidx.collection.ScatterSet) r6
                java.lang.Object[] r7 = r6.elements
                long[] r6 = r6.metadata
                int r8 = r6.length
                int r8 = r8 + -2
                if (r8 < 0) goto L_0x0502
                r9 = r18
            L_0x0384:
                r12 = r6[r9]
                long r14 = ~r12
                long r14 = r14 << r22
                long r14 = r14 & r12
                long r14 = r14 & r24
                int r10 = (r14 > r24 ? 1 : (r14 == r24 ? 0 : -1))
                if (r10 == 0) goto L_0x046d
                int r10 = r9 - r8
                int r10 = ~r10
                int r10 = r10 >>> 31
                r27 = 8
                int r10 = 8 - r10
                r14 = r18
            L_0x039b:
                if (r14 >= r10) goto L_0x0462
                long r29 = r12 & r20
                int r15 = (r29 > r16 ? 1 : (r29 == r16 ? 0 : -1))
                if (r15 >= 0) goto L_0x044c
                int r15 = r9 << 3
                int r15 = r15 + r14
                r15 = r7[r15]
                androidx.compose.runtime.DerivedState r15 = (androidx.compose.runtime.DerivedState) r15
                r45 = r1
                r1 = r36
                kotlin.jvm.internal.Intrinsics.checkNotNull(r15, r1)
                java.lang.Object r1 = r3.get(r15)
                androidx.compose.runtime.SnapshotMutationPolicy r26 = r15.getPolicy()
                if (r26 != 0) goto L_0x03bf
                androidx.compose.runtime.SnapshotMutationPolicy r26 = androidx.compose.runtime.SnapshotStateKt.structuralEqualityPolicy()
            L_0x03bf:
                r29 = r2
                r2 = r26
                androidx.compose.runtime.DerivedState$Record r26 = r15.getCurrentRecord()
                r30 = r6
                java.lang.Object r6 = r26.getCurrentValue()
                boolean r1 = r2.equivalent(r6, r1)
                if (r1 != 0) goto L_0x0444
                androidx.collection.MutableScatterMap r1 = r28.getMap()
                java.lang.Object r1 = r1.get(r15)
                if (r1 == 0) goto L_0x0452
                boolean r2 = r1 instanceof androidx.collection.MutableScatterSet
                if (r2 == 0) goto L_0x043c
                androidx.collection.MutableScatterSet r1 = (androidx.collection.MutableScatterSet) r1
                androidx.collection.ScatterSet r1 = (androidx.collection.ScatterSet) r1
                java.lang.Object[] r2 = r1.elements
                long[] r1 = r1.metadata
                int r6 = r1.length
                int r6 = r6 + -2
                if (r6 < 0) goto L_0x0437
                r31 = r1
                r26 = r2
                r15 = r18
            L_0x03f4:
                r1 = r31[r15]
                r32 = r12
                r13 = r11
                long r11 = ~r1
                long r11 = r11 << r22
                long r11 = r11 & r1
                long r11 = r11 & r24
                int r11 = (r11 > r24 ? 1 : (r11 == r24 ? 0 : -1))
                if (r11 == 0) goto L_0x042f
                int r11 = r15 - r6
                int r11 = ~r11
                int r11 = r11 >>> 31
                r27 = 8
                int r11 = 8 - r11
                r12 = r18
            L_0x040e:
                if (r12 >= r11) goto L_0x042b
                long r34 = r1 & r20
                int r34 = (r34 > r16 ? 1 : (r34 == r16 ? 0 : -1))
                if (r34 >= 0) goto L_0x0420
                int r13 = r15 << 3
                int r13 = r13 + r12
                r13 = r26[r13]
                r5.add(r13)
                r13 = r19
            L_0x0420:
                r34 = r1
                r1 = 8
                long r34 = r34 >> r1
                int r12 = r12 + 1
                r1 = r34
                goto L_0x040e
            L_0x042b:
                r1 = 8
                if (r11 != r1) goto L_0x043a
            L_0x042f:
                r11 = r13
                if (r15 == r6) goto L_0x0439
                int r15 = r15 + 1
                r12 = r32
                goto L_0x03f4
            L_0x0437:
                r32 = r12
            L_0x0439:
                r13 = r11
            L_0x043a:
                r11 = r13
                goto L_0x0454
            L_0x043c:
                r32 = r12
                r5.add(r1)
                r11 = r19
                goto L_0x0454
            L_0x0444:
                r32 = r12
                androidx.compose.runtime.collection.MutableVector<androidx.compose.runtime.DerivedState<?>> r1 = r0.statesToReread
                r1.add(r15)
                goto L_0x0454
            L_0x044c:
                r45 = r1
                r29 = r2
                r30 = r6
            L_0x0452:
                r32 = r12
            L_0x0454:
                r6 = 8
                long r12 = r32 >> r6
                int r14 = r14 + 1
                r1 = r45
                r2 = r29
                r6 = r30
                goto L_0x039b
            L_0x0462:
                r45 = r1
                r29 = r2
                r30 = r6
                r6 = 8
                if (r10 != r6) goto L_0x0506
                goto L_0x0473
            L_0x046d:
                r45 = r1
                r29 = r2
                r30 = r6
            L_0x0473:
                if (r9 == r8) goto L_0x0506
                int r9 = r9 + 1
                r1 = r45
                r2 = r29
                r6 = r30
                goto L_0x0384
            L_0x047f:
                r45 = r1
                r29 = r2
                androidx.compose.runtime.DerivedState r6 = (androidx.compose.runtime.DerivedState) r6
                java.lang.Object r1 = r3.get(r6)
                androidx.compose.runtime.SnapshotMutationPolicy r2 = r6.getPolicy()
                if (r2 != 0) goto L_0x0493
                androidx.compose.runtime.SnapshotMutationPolicy r2 = androidx.compose.runtime.SnapshotStateKt.structuralEqualityPolicy()
            L_0x0493:
                androidx.compose.runtime.DerivedState$Record r7 = r6.getCurrentRecord()
                java.lang.Object r7 = r7.getCurrentValue()
                boolean r1 = r2.equivalent(r7, r1)
                if (r1 != 0) goto L_0x04fc
                androidx.collection.MutableScatterMap r1 = r28.getMap()
                java.lang.Object r1 = r1.get(r6)
                if (r1 == 0) goto L_0x0506
                boolean r2 = r1 instanceof androidx.collection.MutableScatterSet
                if (r2 == 0) goto L_0x04f6
                androidx.collection.MutableScatterSet r1 = (androidx.collection.MutableScatterSet) r1
                androidx.collection.ScatterSet r1 = (androidx.collection.ScatterSet) r1
                java.lang.Object[] r2 = r1.elements
                long[] r1 = r1.metadata
                int r6 = r1.length
                int r6 = r6 + -2
                if (r6 < 0) goto L_0x0506
                r7 = r18
            L_0x04be:
                r8 = r1[r7]
                long r12 = ~r8
                long r12 = r12 << r22
                long r12 = r12 & r8
                long r12 = r12 & r24
                int r10 = (r12 > r24 ? 1 : (r12 == r24 ? 0 : -1))
                if (r10 == 0) goto L_0x04f1
                int r10 = r7 - r6
                int r10 = ~r10
                int r10 = r10 >>> 31
                r27 = 8
                int r10 = 8 - r10
                r12 = r18
            L_0x04d5:
                if (r12 >= r10) goto L_0x04ed
                long r13 = r8 & r20
                int r13 = (r13 > r16 ? 1 : (r13 == r16 ? 0 : -1))
                if (r13 >= 0) goto L_0x04e7
                int r11 = r7 << 3
                int r11 = r11 + r12
                r11 = r2[r11]
                r5.add(r11)
                r11 = r19
            L_0x04e7:
                r14 = 8
                long r8 = r8 >> r14
                int r12 = r12 + 1
                goto L_0x04d5
            L_0x04ed:
                r14 = 8
                if (r10 != r14) goto L_0x0506
            L_0x04f1:
                if (r7 == r6) goto L_0x0506
                int r7 = r7 + 1
                goto L_0x04be
            L_0x04f6:
                r5.add(r1)
                r11 = r19
                goto L_0x0506
            L_0x04fc:
                androidx.compose.runtime.collection.MutableVector<androidx.compose.runtime.DerivedState<?>> r1 = r0.statesToReread
                r1.add(r6)
                goto L_0x0506
            L_0x0502:
                r45 = r1
                r29 = r2
            L_0x0506:
                androidx.collection.MutableScatterMap r1 = r28.getMap()
                java.lang.Object r1 = r1.get(r4)
                if (r1 == 0) goto L_0x035d
                boolean r2 = r1 instanceof androidx.collection.MutableScatterSet
                if (r2 == 0) goto L_0x055e
                androidx.collection.MutableScatterSet r1 = (androidx.collection.MutableScatterSet) r1
                androidx.collection.ScatterSet r1 = (androidx.collection.ScatterSet) r1
                java.lang.Object[] r2 = r1.elements
                long[] r1 = r1.metadata
                int r4 = r1.length
                int r4 = r4 + -2
                if (r4 < 0) goto L_0x035d
                r6 = r18
            L_0x0523:
                r7 = r1[r6]
                long r9 = ~r7
                long r9 = r9 << r22
                long r9 = r9 & r7
                long r9 = r9 & r24
                int r9 = (r9 > r24 ? 1 : (r9 == r24 ? 0 : -1))
                if (r9 == 0) goto L_0x0557
                int r9 = r6 - r4
                int r9 = ~r9
                int r9 = r9 >>> 31
                r27 = 8
                int r9 = 8 - r9
                r10 = r18
            L_0x053a:
                if (r10 >= r9) goto L_0x0552
                long r12 = r7 & r20
                int r12 = (r12 > r16 ? 1 : (r12 == r16 ? 0 : -1))
                if (r12 >= 0) goto L_0x054c
                int r11 = r6 << 3
                int r11 = r11 + r10
                r11 = r2[r11]
                r5.add(r11)
                r11 = r19
            L_0x054c:
                r14 = 8
                long r7 = r7 >> r14
                int r10 = r10 + 1
                goto L_0x053a
            L_0x0552:
                r14 = 8
                if (r9 != r14) goto L_0x0565
                goto L_0x0559
            L_0x0557:
                r14 = 8
            L_0x0559:
                if (r6 == r4) goto L_0x0565
                int r6 = r6 + 1
                goto L_0x0523
            L_0x055e:
                r14 = 8
                r5.add(r1)
                r11 = r19
            L_0x0565:
                r1 = r45
                r2 = r29
                goto L_0x033c
            L_0x056b:
                androidx.compose.runtime.collection.MutableVector<androidx.compose.runtime.DerivedState<?>> r1 = r0.statesToReread
                boolean r1 = r1.isNotEmpty()
                if (r1 == 0) goto L_0x0593
                androidx.compose.runtime.collection.MutableVector<androidx.compose.runtime.DerivedState<?>> r1 = r0.statesToReread
                int r2 = r1.getSize()
                if (r2 <= 0) goto L_0x058e
                java.lang.Object[] r1 = r1.getContent()
            L_0x057f:
                r3 = r1[r18]
                androidx.compose.runtime.DerivedState r3 = (androidx.compose.runtime.DerivedState) r3
                r0.rereadDerivedState(r3)
                int r3 = r18 + 1
                if (r3 < r2) goto L_0x058b
                goto L_0x058e
            L_0x058b:
                r18 = r3
                goto L_0x057f
            L_0x058e:
                androidx.compose.runtime.collection.MutableVector<androidx.compose.runtime.DerivedState<?>> r1 = r0.statesToReread
                r1.clear()
            L_0x0593:
                return r11
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.SnapshotStateObserver.ObservedScopeMap.recordInvalidation(java.util.Set):boolean");
        }

        public final void rereadDerivedState(DerivedState<?> derivedState) {
            long[] jArr;
            long[] jArr2;
            int i;
            MutableObjectIntMap mutableObjectIntMap;
            DerivedState<?> derivedState2 = derivedState;
            MutableScatterMap<Object, MutableObjectIntMap<Object>> mutableScatterMap = this.scopeToValues;
            int id = SnapshotKt.currentSnapshot().getId();
            Object obj = this.valueToScopes.getMap().get(derivedState2);
            if (obj == null) {
                return;
            }
            if (obj instanceof MutableScatterSet) {
                ScatterSet scatterSet = (MutableScatterSet) obj;
                Object[] objArr = scatterSet.elements;
                long[] jArr3 = scatterSet.metadata;
                int length = jArr3.length - 2;
                if (length >= 0) {
                    int i2 = 0;
                    while (true) {
                        long j = jArr3[i2];
                        if ((((~j) << 7) & j & -9187201950435737472L) != -9187201950435737472L) {
                            int i3 = 8;
                            int i4 = 8 - ((~(i2 - length)) >>> 31);
                            int i5 = 0;
                            while (i5 < i4) {
                                if ((j & 255) < 128) {
                                    i = i3;
                                    Object obj2 = objArr[(i2 << 3) + i5];
                                    MutableObjectIntMap mutableObjectIntMap2 = mutableScatterMap.get(obj2);
                                    jArr2 = jArr3;
                                    if (mutableObjectIntMap2 == null) {
                                        mutableObjectIntMap = new MutableObjectIntMap(0, 1, (DefaultConstructorMarker) null);
                                        mutableScatterMap.set(obj2, mutableObjectIntMap);
                                        Unit unit = Unit.INSTANCE;
                                    } else {
                                        mutableObjectIntMap = mutableObjectIntMap2;
                                    }
                                    recordRead(derivedState2, id, obj2, mutableObjectIntMap);
                                } else {
                                    jArr2 = jArr3;
                                    i = i3;
                                }
                                j >>= i;
                                i5++;
                                i3 = i;
                                jArr3 = jArr2;
                            }
                            jArr = jArr3;
                            if (i4 != i3) {
                                return;
                            }
                        } else {
                            jArr = jArr3;
                        }
                        if (i2 != length) {
                            i2++;
                            jArr3 = jArr;
                        } else {
                            return;
                        }
                    }
                }
            } else {
                MutableObjectIntMap mutableObjectIntMap3 = mutableScatterMap.get(obj);
                if (mutableObjectIntMap3 == null) {
                    mutableObjectIntMap3 = new MutableObjectIntMap(0, 1, (DefaultConstructorMarker) null);
                    mutableScatterMap.set(obj, mutableObjectIntMap3);
                    Unit unit2 = Unit.INSTANCE;
                }
                recordRead(derivedState2, id, obj, mutableObjectIntMap3);
            }
        }

        public final void notifyInvalidatedScopes() {
            MutableScatterSet<Object> mutableScatterSet = this.invalidated;
            ScatterSet scatterSet = mutableScatterSet;
            Function1<Object, Unit> function1 = this.onChanged;
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
                                function1.invoke(objArr[(i << 3) + i3]);
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
            mutableScatterSet.clear();
        }
    }

    public final void clear(Object obj) {
        synchronized (this.observedScopeMaps) {
            MutableVector<ObservedScopeMap> mutableVector = this.observedScopeMaps;
            int size = mutableVector.getSize();
            int i = 0;
            for (int i2 = 0; i2 < size; i2++) {
                ObservedScopeMap observedScopeMap = (ObservedScopeMap) mutableVector.getContent()[i2];
                observedScopeMap.clearScopeObservations(obj);
                if (!observedScopeMap.hasScopeObservations()) {
                    i++;
                } else if (i > 0) {
                    mutableVector.getContent()[i2 - i] = mutableVector.getContent()[i2];
                }
            }
            int i3 = size - i;
            ArraysKt.fill((T[]) mutableVector.getContent(), null, i3, size);
            mutableVector.setSize(i3);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void clearIf(Function1<Object, Boolean> function1) {
        synchronized (this.observedScopeMaps) {
            MutableVector<ObservedScopeMap> mutableVector = this.observedScopeMaps;
            int size = mutableVector.getSize();
            int i = 0;
            for (int i2 = 0; i2 < size; i2++) {
                ObservedScopeMap observedScopeMap = (ObservedScopeMap) mutableVector.getContent()[i2];
                observedScopeMap.removeScopeIf(function1);
                if (!observedScopeMap.hasScopeObservations()) {
                    i++;
                } else if (i > 0) {
                    mutableVector.getContent()[i2 - i] = mutableVector.getContent()[i2];
                }
            }
            int i3 = size - i;
            ArraysKt.fill((T[]) mutableVector.getContent(), null, i3, size);
            mutableVector.setSize(i3);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void clear() {
        synchronized (this.observedScopeMaps) {
            MutableVector<ObservedScopeMap> mutableVector = this.observedScopeMaps;
            int size = mutableVector.getSize();
            if (size > 0) {
                Object[] content = mutableVector.getContent();
                int i = 0;
                do {
                    ((ObservedScopeMap) content[i]).clear();
                    i++;
                } while (i < size);
            }
            Unit unit = Unit.INSTANCE;
        }
    }
}
