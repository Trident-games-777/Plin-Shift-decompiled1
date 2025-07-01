package androidx.compose.runtime;

import androidx.collection.MutableIntList;
import androidx.collection.MutableScatterMap;
import androidx.collection.MutableScatterSet;
import androidx.collection.ObjectIntMap;
import androidx.collection.ScatterSet;
import androidx.collection.ScatterSetKt;
import androidx.compose.runtime.DerivedState;
import androidx.compose.runtime.changelist.ChangeList;
import androidx.compose.runtime.collection.ScatterSetWrapper;
import androidx.compose.runtime.collection.ScopeMap;
import androidx.compose.runtime.snapshots.ReaderKind;
import androidx.compose.runtime.snapshots.StateObject;
import androidx.compose.runtime.snapshots.StateObjectImpl;
import androidx.compose.runtime.tooling.CompositionObserver;
import androidx.compose.runtime.tooling.CompositionObserverHandle;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000ì\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0002¥\u0001B%\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\b\u0010X\u001a\u00020\u001aH\u0016J\u0018\u0010Y\u001a\u00020\u001a2\u0006\u0010Z\u001a\u00020,2\u0006\u0010[\u001a\u00020\u0013H\u0002J\u001e\u0010Y\u001a\u00020\u001a2\f\u0010\\\u001a\b\u0012\u0004\u0012\u00020,0+2\u0006\u0010[\u001a\u00020\u0013H\u0002J\b\u0010]\u001a\u00020\u001aH\u0016J\u0010\u0010^\u001a\u00020\u001a2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010_\u001a\u00020\u001aH\u0016J\b\u0010`\u001a\u00020\u001aH\u0016J\b\u0010a\u001a\u00020\u001aH\u0002J \u0010b\u001a\u00020\u001a2\u0011\u0010c\u001a\r\u0012\u0004\u0012\u00020\u001a0\u0019¢\u0006\u0002\b\u001bH\u0016¢\u0006\u0002\u0010\u001fJ \u0010d\u001a\u00020\u001a2\u0011\u0010c\u001a\r\u0012\u0004\u0012\u00020\u001a0\u0019¢\u0006\u0002\b\u001bH\u0002¢\u0006\u0002\u0010\u001fJ\r\u0010e\u001a\u00020:H\u0000¢\u0006\u0002\bfJ\b\u0010g\u001a\u00020\u001aH\u0016J3\u0010h\u001a\u0002Hi\"\u0004\b\u0000\u0010i2\b\u0010j\u001a\u0004\u0018\u00010\u00012\u0006\u0010k\u001a\u00020:2\f\u0010l\u001a\b\u0012\u0004\u0012\u0002Hi0\u0019H\u0016¢\u0006\u0002\u0010mJ\b\u0010n\u001a\u00020\u001aH\u0016J\u0010\u0010o\u001a\u00020\u001a2\u0006\u0010p\u001a\u00020qH\u0016J\b\u0010r\u001a\u00020\u001aH\u0002J\b\u0010s\u001a\u00020\u001aH\u0002J#\u0010t\u001a\u0004\u0018\u0001Hu\"\u0004\b\u0000\u0010u2\f\u0010v\u001a\b\u0012\u0004\u0012\u0002Hu0wH\u0016¢\u0006\u0002\u0010xJ\"\u0010y\u001a\u0002Hu\"\u0004\b\u0000\u0010u2\f\u0010l\u001a\b\u0012\u0004\u0012\u0002Hu0\u0019H\b¢\u0006\u0002\u0010zJC\u0010{\u001a\u0002Hu\"\u0004\b\u0000\u0010u2-\u0010l\u001a)\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020,00¢\u0006\f\b}\u0012\b\b~\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u0002Hu0|H\b¢\u0006\u0002\u0010J)\u0010\u0001\u001a\u00020\u001a2\u001e\u0010\u0001\u001a\u0019\u0012\u0015\u0012\u0013\u0012\u0005\u0012\u00030\u0001\u0012\u0007\u0012\u0005\u0018\u00010\u00010\u00010$H\u0016J\u001e\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020%2\t\u0010\u0001\u001a\u0004\u0018\u00010,H\u0016J\t\u0010\u0001\u001a\u00020\u001aH\u0016J(\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020%2\b\u0010\u0001\u001a\u00030\u00012\t\u0010\u0001\u001a\u0004\u0018\u00010,H\u0002J\u000f\u0010\u0001\u001a\u00020\u001a2\u0006\u0010v\u001a\u00020:J\u0011\u0010\u0001\u001a\u00020\u001a2\u0006\u0010Z\u001a\u00020,H\u0002J\u001a\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u0001H\u0000¢\u0006\u0003\b\u0001J\f\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0002J\u0017\u0010\u0001\u001a\u00020\u00132\f\u0010\\\u001a\b\u0012\u0004\u0012\u00020,0+H\u0016J\u0017\u0010\u0001\u001a\u00020\u001a2\f\u0010l\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0016J\t\u0010\u0001\u001a\u00020\u0013H\u0016J\u0012\u0010\u0001\u001a\u00020\u001a2\u0007\u0010\u0001\u001a\u00020%H\u0016J\u0017\u0010\u0001\u001a\u00020\u001a2\f\u0010\\\u001a\b\u0012\u0004\u0012\u00020,0+H\u0016J\u0011\u0010\u0001\u001a\u00020\u001a2\u0006\u0010Z\u001a\u00020,H\u0016J\u0011\u0010\u0001\u001a\u00020\u001a2\u0006\u0010Z\u001a\u00020,H\u0016J\u001b\u0010\u0001\u001a\u00020\u001a2\n\u0010p\u001a\u0006\u0012\u0002\b\u000301H\u0000¢\u0006\u0003\b\u0001J!\u0010\u0001\u001a\u00020\u001a2\u0007\u0010\u0001\u001a\u00020,2\u0007\u0010\u0001\u001a\u00020%H\u0000¢\u0006\u0003\b\u0001J!\u0010\u0001\u001a\u00020\u001a2\u0011\u0010c\u001a\r\u0012\u0004\u0012\u00020\u001a0\u0019¢\u0006\u0002\b\u001bH\u0016¢\u0006\u0002\u0010\u001fJ!\u0010\u0001\u001a\u00020\u001a2\u0011\u0010c\u001a\r\u0012\u0004\u0012\u00020\u001a0\u0019¢\u0006\u0002\b\u001bH\u0016¢\u0006\u0002\u0010\u001fJ\u0015\u0010 \u0001\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020,00H\u0002J#\u0010¡\u0001\u001a\u0002Hu\"\u0004\b\u0000\u0010u2\f\u0010l\u001a\b\u0012\u0004\u0012\u0002Hu0\u0019H\b¢\u0006\u0002\u0010zJ\u001d\u0010¢\u0001\u001a\u00020\u00132\u0007\u0010\u0001\u001a\u00020%2\t\u0010\u0001\u001a\u0004\u0018\u00010,H\u0002J\u0011\u0010£\u0001\u001a\u00020\u001a2\u0006\u0010S\u001a\u00020TH\u0002J\t\u0010¤\u0001\u001a\u00020\u001aH\u0016R\u0010\u0010\f\u001a\u0004\u0018\u00010\nX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0010\u0010\u0011R\u0012\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u00020\u00138BX\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000R'\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\u001a0\u0019¢\u0006\u0002\b\u001bX\u000e¢\u0006\u0010\n\u0002\u0010 \u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u000e\u0010!\u001a\u00020\"X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$8AX\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'R\u0014\u0010(\u001a\b\u0012\u0004\u0012\u00020%0)X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010*\u001a\b\u0012\u0004\u0012\u00020,0+8AX\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.R\u001e\u0010/\u001a\u0012\u0012\u0004\u0012\u00020,\u0012\b\u0012\u0006\u0012\u0002\b\u00030100X\u0004¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u0014\u00103\u001a\u00020\u00138VX\u0004¢\u0006\u0006\u001a\u0004\b4\u0010\u0015R\u0014\u00105\u001a\u00020\u00138VX\u0004¢\u0006\u0006\u001a\u0004\b6\u0010\u0015R\u0014\u00107\u001a\b\u0012\u0004\u0012\u00020%0)X\u0004¢\u0006\u0002\n\u0000R\u0010\u00108\u001a\u0004\u0018\u00010\u0000X\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020:X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010;\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020,00X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010<\u001a\u00020\u00138VX\u0004¢\u0006\u0006\u001a\u0004\b<\u0010\u0015R\u0014\u0010=\u001a\u00020\u00138VX\u0004¢\u0006\u0006\u001a\u0004\b=\u0010\u0015R\u0011\u0010>\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b>\u0010\u0015R\u000e\u0010?\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020,X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010A\u001a\u000e\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020%00X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010B\u001a\u000e\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020%00X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010C\u001a\b\u0012\u0004\u0012\u00020,0+8AX\u0004¢\u0006\u0006\u001a\u0004\bD\u0010.R\u0014\u0010E\u001a\u00020FX\u0004¢\u0006\b\n\u0000\u001a\u0004\bG\u0010HR\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R \u0010I\u001a\u00020\u0013X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bJ\u0010\u0011\u001a\u0004\bK\u0010\u0015\"\u0004\bL\u0010MR\"\u0010N\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010,0Oj\n\u0012\u0006\u0012\u0004\u0018\u00010,`PX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\bQ\u0010RR\u001a\u0010S\u001a\u00020TX\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bU\u0010\u0011\u001a\u0004\bV\u0010W¨\u0006¦\u0001"}, d2 = {"Landroidx/compose/runtime/CompositionImpl;", "Landroidx/compose/runtime/ControlledComposition;", "Landroidx/compose/runtime/ReusableComposition;", "Landroidx/compose/runtime/RecomposeScopeOwner;", "Landroidx/compose/runtime/CompositionServices;", "parent", "Landroidx/compose/runtime/CompositionContext;", "applier", "Landroidx/compose/runtime/Applier;", "recomposeContext", "Lkotlin/coroutines/CoroutineContext;", "(Landroidx/compose/runtime/CompositionContext;Landroidx/compose/runtime/Applier;Lkotlin/coroutines/CoroutineContext;)V", "_recomposeContext", "abandonSet", "", "Landroidx/compose/runtime/RememberObserver;", "getAbandonSet$annotations", "()V", "areChildrenComposing", "", "getAreChildrenComposing", "()Z", "changes", "Landroidx/compose/runtime/changelist/ChangeList;", "composable", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "getComposable", "()Lkotlin/jvm/functions/Function2;", "setComposable", "(Lkotlin/jvm/functions/Function2;)V", "Lkotlin/jvm/functions/Function2;", "composer", "Landroidx/compose/runtime/ComposerImpl;", "conditionalScopes", "", "Landroidx/compose/runtime/RecomposeScopeImpl;", "getConditionalScopes$runtime_release", "()Ljava/util/List;", "conditionallyInvalidatedScopes", "Landroidx/collection/MutableScatterSet;", "derivedStateDependencies", "", "", "getDerivedStateDependencies$runtime_release", "()Ljava/util/Set;", "derivedStates", "Landroidx/compose/runtime/collection/ScopeMap;", "Landroidx/compose/runtime/DerivedState;", "disposed", "hasInvalidations", "getHasInvalidations", "hasPendingChanges", "getHasPendingChanges", "invalidatedScopes", "invalidationDelegate", "invalidationDelegateGroup", "", "invalidations", "isComposing", "isDisposed", "isRoot", "lateChanges", "lock", "observations", "observationsProcessed", "observedObjects", "getObservedObjects$runtime_release", "observerHolder", "Landroidx/compose/runtime/CompositionObserverHolder;", "getObserverHolder$runtime_release", "()Landroidx/compose/runtime/CompositionObserverHolder;", "pendingInvalidScopes", "getPendingInvalidScopes$runtime_release$annotations", "getPendingInvalidScopes$runtime_release", "setPendingInvalidScopes$runtime_release", "(Z)V", "pendingModifications", "Ljava/util/concurrent/atomic/AtomicReference;", "Landroidx/compose/runtime/AtomicReference;", "getRecomposeContext", "()Lkotlin/coroutines/CoroutineContext;", "slotTable", "Landroidx/compose/runtime/SlotTable;", "getSlotTable$runtime_release$annotations", "getSlotTable$runtime_release", "()Landroidx/compose/runtime/SlotTable;", "abandonChanges", "addPendingInvalidationsLocked", "value", "forgetConditionalScopes", "values", "applyChanges", "applyChangesInLocked", "applyLateChanges", "changesApplied", "cleanUpDerivedStateObservations", "composeContent", "content", "composeInitial", "composerStacksSizes", "composerStacksSizes$runtime_release", "deactivate", "delegateInvalidations", "R", "to", "groupIndex", "block", "(Landroidx/compose/runtime/ControlledComposition;ILkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "dispose", "disposeUnusedMovableContent", "state", "Landroidx/compose/runtime/MovableContentState;", "drainPendingModificationsForCompositionLocked", "drainPendingModificationsLocked", "getCompositionService", "T", "key", "Landroidx/compose/runtime/CompositionServiceKey;", "(Landroidx/compose/runtime/CompositionServiceKey;)Ljava/lang/Object;", "guardChanges", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "guardInvalidationsLocked", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "insertMovableContent", "references", "Lkotlin/Pair;", "Landroidx/compose/runtime/MovableContentStateReference;", "invalidate", "Landroidx/compose/runtime/InvalidationResult;", "scope", "instance", "invalidateAll", "invalidateChecked", "anchor", "Landroidx/compose/runtime/Anchor;", "invalidateGroupsWithKey", "invalidateScopeOfLocked", "observe", "Landroidx/compose/runtime/tooling/CompositionObserverHandle;", "observer", "Landroidx/compose/runtime/tooling/CompositionObserver;", "observe$runtime_release", "observesAnyOf", "prepareCompose", "recompose", "recomposeScopeReleased", "recordModificationsOf", "recordReadOf", "recordWriteOf", "removeDerivedStateObservation", "removeDerivedStateObservation$runtime_release", "removeObservation", "removeObservation$runtime_release", "setContent", "setContentWithReuse", "takeInvalidations", "trackAbandonedValues", "tryImminentInvalidation", "validateRecomposeScopeAnchors", "verifyConsistent", "RememberEventDispatcher", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Composition.kt */
public final class CompositionImpl implements ControlledComposition, ReusableComposition, RecomposeScopeOwner, CompositionServices {
    public static final int $stable = 8;
    private final CoroutineContext _recomposeContext;
    private final Set<RememberObserver> abandonSet;
    private final Applier<?> applier;
    private final ChangeList changes;
    private Function2<? super Composer, ? super Integer, Unit> composable;
    private final ComposerImpl composer;
    private final MutableScatterSet<RecomposeScopeImpl> conditionallyInvalidatedScopes;
    private final ScopeMap<Object, DerivedState<?>> derivedStates;
    private boolean disposed;
    private final MutableScatterSet<RecomposeScopeImpl> invalidatedScopes;
    private CompositionImpl invalidationDelegate;
    private int invalidationDelegateGroup;
    private ScopeMap<RecomposeScopeImpl, Object> invalidations;
    private final boolean isRoot;
    private final ChangeList lateChanges;
    /* access modifiers changed from: private */
    public final Object lock;
    /* access modifiers changed from: private */
    public final ScopeMap<Object, RecomposeScopeImpl> observations;
    private final ScopeMap<Object, RecomposeScopeImpl> observationsProcessed;
    private final CompositionObserverHolder observerHolder;
    private final CompositionContext parent;
    private boolean pendingInvalidScopes;
    private final AtomicReference<Object> pendingModifications;
    private final SlotTable slotTable;

    private static /* synthetic */ void getAbandonSet$annotations() {
    }

    public static /* synthetic */ void getPendingInvalidScopes$runtime_release$annotations() {
    }

    public static /* synthetic */ void getSlotTable$runtime_release$annotations() {
    }

    public CompositionImpl(CompositionContext compositionContext, Applier<?> applier2, CoroutineContext coroutineContext) {
        this.parent = compositionContext;
        this.applier = applier2;
        this.pendingModifications = new AtomicReference<>((Object) null);
        this.lock = new Object();
        Set<RememberObserver> asMutableSet = new MutableScatterSet(0, 1, (DefaultConstructorMarker) null).asMutableSet();
        this.abandonSet = asMutableSet;
        SlotTable slotTable2 = new SlotTable();
        if (compositionContext.getCollectingCallByInformation$runtime_release()) {
            slotTable2.collectCalledByInformation();
        }
        if (compositionContext.getCollectingSourceInformation$runtime_release()) {
            slotTable2.collectSourceInformation();
        }
        this.slotTable = slotTable2;
        this.observations = new ScopeMap<>();
        this.invalidatedScopes = new MutableScatterSet<>(0, 1, (DefaultConstructorMarker) null);
        this.conditionallyInvalidatedScopes = new MutableScatterSet<>(0, 1, (DefaultConstructorMarker) null);
        this.derivedStates = new ScopeMap<>();
        ChangeList changeList = new ChangeList();
        this.changes = changeList;
        ChangeList changeList2 = new ChangeList();
        this.lateChanges = changeList2;
        this.observationsProcessed = new ScopeMap<>();
        this.invalidations = new ScopeMap<>();
        this.observerHolder = new CompositionObserverHolder((CompositionObserver) null, false, 3, (DefaultConstructorMarker) null);
        CompositionContext compositionContext2 = compositionContext;
        ComposerImpl composerImpl = new ComposerImpl(applier2, compositionContext2, slotTable2, asMutableSet, changeList, changeList2, this);
        compositionContext2.registerComposer$runtime_release(composerImpl);
        this.composer = composerImpl;
        this._recomposeContext = coroutineContext;
        this.isRoot = compositionContext2 instanceof Recomposer;
        this.composable = ComposableSingletons$CompositionKt.INSTANCE.m3639getLambda1$runtime_release();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CompositionImpl(CompositionContext compositionContext, Applier applier2, CoroutineContext coroutineContext, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(compositionContext, applier2, (i & 4) != 0 ? null : coroutineContext);
    }

    public final SlotTable getSlotTable$runtime_release() {
        return this.slotTable;
    }

    public final Set<Object> getObservedObjects$runtime_release() {
        return this.observations.getMap().asMap().keySet();
    }

    public final Set<Object> getDerivedStateDependencies$runtime_release() {
        return this.derivedStates.getMap().asMap().keySet();
    }

    public final List<RecomposeScopeImpl> getConditionalScopes$runtime_release() {
        return CollectionsKt.toList(this.conditionallyInvalidatedScopes.asSet());
    }

    public final boolean getPendingInvalidScopes$runtime_release() {
        return this.pendingInvalidScopes;
    }

    public final void setPendingInvalidScopes$runtime_release(boolean z) {
        this.pendingInvalidScopes = z;
    }

    public final CompositionObserverHolder getObserverHolder$runtime_release() {
        return this.observerHolder;
    }

    public final CoroutineContext getRecomposeContext() {
        CoroutineContext coroutineContext = this._recomposeContext;
        return coroutineContext == null ? this.parent.getRecomposeCoroutineContext$runtime_release() : coroutineContext;
    }

    public final boolean isRoot() {
        return this.isRoot;
    }

    private final boolean getAreChildrenComposing() {
        return this.composer.getAreChildrenComposing$runtime_release();
    }

    public final Function2<Composer, Integer, Unit> getComposable() {
        return this.composable;
    }

    public final void setComposable(Function2<? super Composer, ? super Integer, Unit> function2) {
        this.composable = function2;
    }

    public boolean isComposing() {
        return this.composer.isComposing$runtime_release();
    }

    public boolean isDisposed() {
        return this.disposed;
    }

    public boolean getHasPendingChanges() {
        boolean hasPendingChanges$runtime_release;
        synchronized (this.lock) {
            hasPendingChanges$runtime_release = this.composer.getHasPendingChanges$runtime_release();
        }
        return hasPendingChanges$runtime_release;
    }

    public void setContent(Function2<? super Composer, ? super Integer, Unit> function2) {
        composeInitial(function2);
    }

    public void setContentWithReuse(Function2<? super Composer, ? super Integer, Unit> function2) {
        this.composer.startReuseFromRoot();
        composeInitial(function2);
        this.composer.endReuseFromRoot();
    }

    private final void composeInitial(Function2<? super Composer, ? super Integer, Unit> function2) {
        if (this.disposed) {
            PreconditionsKt.throwIllegalStateException("The composition is disposed");
        }
        this.composable = function2;
        this.parent.composeInitial$runtime_release(this, function2);
    }

    public final CompositionObserverHandle observe$runtime_release(CompositionObserver compositionObserver) {
        synchronized (this.lock) {
            this.observerHolder.setObserver(compositionObserver);
            this.observerHolder.setRoot(true);
            Unit unit = Unit.INSTANCE;
        }
        return new CompositionImpl$observe$2(this, compositionObserver);
    }

    public final void invalidateGroupsWithKey(int i) {
        List<RecomposeScopeImpl> invalidateGroupsWithKey$runtime_release;
        synchronized (this.lock) {
            invalidateGroupsWithKey$runtime_release = this.slotTable.invalidateGroupsWithKey$runtime_release(i);
        }
        if (invalidateGroupsWithKey$runtime_release != null) {
            int size = invalidateGroupsWithKey$runtime_release.size();
            int i2 = 0;
            while (i2 < size) {
                if (invalidateGroupsWithKey$runtime_release.get(i2).invalidateForResult((Object) null) != InvalidationResult.IGNORED) {
                    i2++;
                }
            }
            return;
        }
        if (this.composer.forceRecomposeScopes$runtime_release()) {
            this.parent.invalidate$runtime_release(this);
        }
    }

    private final void drainPendingModificationsForCompositionLocked() {
        Object andSet = this.pendingModifications.getAndSet(CompositionKt.PendingApplyNoModifications);
        if (andSet == null) {
            return;
        }
        if (Intrinsics.areEqual(andSet, CompositionKt.PendingApplyNoModifications)) {
            ComposerKt.composeRuntimeError("pending composition has not been applied");
            throw new KotlinNothingValueException();
        } else if (andSet instanceof Set) {
            addPendingInvalidationsLocked((Set<? extends Object>) (Set) andSet, true);
        } else if (andSet instanceof Object[]) {
            for (Set addPendingInvalidationsLocked : (Set[]) andSet) {
                addPendingInvalidationsLocked((Set<? extends Object>) addPendingInvalidationsLocked, true);
            }
        } else {
            ComposerKt.composeRuntimeError("corrupt pendingModifications drain: " + this.pendingModifications);
            throw new KotlinNothingValueException();
        }
    }

    private final void drainPendingModificationsLocked() {
        Object andSet = this.pendingModifications.getAndSet((Object) null);
        if (Intrinsics.areEqual(andSet, CompositionKt.PendingApplyNoModifications)) {
            return;
        }
        if (andSet instanceof Set) {
            addPendingInvalidationsLocked((Set<? extends Object>) (Set) andSet, false);
        } else if (andSet instanceof Object[]) {
            for (Set addPendingInvalidationsLocked : (Set[]) andSet) {
                addPendingInvalidationsLocked((Set<? extends Object>) addPendingInvalidationsLocked, false);
            }
        } else if (andSet == null) {
            ComposerKt.composeRuntimeError("calling recordModificationsOf and applyChanges concurrently is not supported");
            throw new KotlinNothingValueException();
        } else {
            ComposerKt.composeRuntimeError("corrupt pendingModifications drain: " + this.pendingModifications);
            throw new KotlinNothingValueException();
        }
    }

    public void composeContent(Function2<? super Composer, ? super Integer, Unit> function2) {
        try {
            synchronized (this.lock) {
                drainPendingModificationsForCompositionLocked();
                ScopeMap<RecomposeScopeImpl, Object> takeInvalidations = takeInvalidations();
                try {
                    CompositionObserver observer = observer();
                    if (observer != null) {
                        Map<RecomposeScopeImpl, Set<Object>> asMap = takeInvalidations.asMap();
                        Intrinsics.checkNotNull(asMap, "null cannot be cast to non-null type kotlin.collections.Map<androidx.compose.runtime.RecomposeScope, kotlin.collections.Set<kotlin.Any>?>");
                        observer.onBeginComposition(this, asMap);
                    }
                    this.composer.composeContent$runtime_release(takeInvalidations, function2);
                    if (observer != null) {
                        observer.onEndComposition(this);
                        Unit unit = Unit.INSTANCE;
                    }
                } catch (Exception e) {
                    this.invalidations = takeInvalidations;
                    throw e;
                }
            }
        } catch (Throwable th) {
            try {
                if (!this.abandonSet.isEmpty()) {
                    new RememberEventDispatcher(this.abandonSet).dispatchAbandons();
                }
                throw th;
            } catch (Exception e2) {
                abandonChanges();
                throw e2;
            }
        }
    }

    /* JADX INFO: finally extract failed */
    public void dispose() {
        synchronized (this.lock) {
            if (this.composer.isComposing$runtime_release()) {
                PreconditionsKt.throwIllegalStateException("Composition is disposed while composing. If dispose is triggered by a call in @Composable function, consider wrapping it with SideEffect block.");
            }
            if (!this.disposed) {
                this.disposed = true;
                this.composable = ComposableSingletons$CompositionKt.INSTANCE.m3640getLambda2$runtime_release();
                ChangeList deferredChanges$runtime_release = this.composer.getDeferredChanges$runtime_release();
                if (deferredChanges$runtime_release != null) {
                    applyChangesInLocked(deferredChanges$runtime_release);
                }
                boolean z = this.slotTable.getGroupsSize() > 0;
                if (z || !this.abandonSet.isEmpty()) {
                    RememberEventDispatcher rememberEventDispatcher = new RememberEventDispatcher(this.abandonSet);
                    if (z) {
                        this.applier.onBeginChanges();
                        SlotWriter openWriter = this.slotTable.openWriter();
                        try {
                            ComposerKt.removeCurrentGroup(openWriter, rememberEventDispatcher);
                            Unit unit = Unit.INSTANCE;
                            openWriter.close(true);
                            this.applier.clear();
                            this.applier.onEndChanges();
                            rememberEventDispatcher.dispatchRememberObservers();
                        } catch (Throwable th) {
                            openWriter.close(false);
                            throw th;
                        }
                    }
                    rememberEventDispatcher.dispatchAbandons();
                }
                this.composer.dispose$runtime_release();
            }
            Unit unit2 = Unit.INSTANCE;
        }
        this.parent.unregisterComposition$runtime_release(this);
    }

    public boolean getHasInvalidations() {
        boolean z;
        synchronized (this.lock) {
            z = this.invalidations.getSize() > 0;
        }
        return z;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: java.util.Set<? extends java.lang.Object>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: java.util.Set<? extends java.lang.Object>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v10, resolved type: java.util.Set<? extends java.lang.Object>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v11, resolved type: java.util.Set<? extends java.lang.Object>} */
    /* JADX WARNING: type inference failed for: r2v5, types: [java.util.Set[]] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void recordModificationsOf(java.util.Set<? extends java.lang.Object> r5) {
        /*
            r4 = this;
        L_0x0000:
            java.util.concurrent.atomic.AtomicReference<java.lang.Object> r0 = r4.pendingModifications
            java.lang.Object r0 = r0.get()
            r1 = 1
            if (r0 != 0) goto L_0x000b
            r2 = r1
            goto L_0x0013
        L_0x000b:
            java.lang.Object r2 = androidx.compose.runtime.CompositionKt.PendingApplyNoModifications
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r2)
        L_0x0013:
            if (r2 == 0) goto L_0x0017
            r2 = r5
            goto L_0x0034
        L_0x0017:
            boolean r2 = r0 instanceof java.util.Set
            if (r2 == 0) goto L_0x0024
            r2 = 2
            java.util.Set[] r2 = new java.util.Set[r2]
            r3 = 0
            r2[r3] = r0
            r2[r1] = r5
            goto L_0x0034
        L_0x0024:
            boolean r1 = r0 instanceof java.lang.Object[]
            if (r1 == 0) goto L_0x004c
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.Array<kotlin.collections.Set<kotlin.Any>>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0, r1)
            r1 = r0
            java.util.Set[] r1 = (java.util.Set[]) r1
            java.lang.Object[] r2 = kotlin.collections.ArraysKt.plus((T[]) r1, r5)
        L_0x0034:
            java.util.concurrent.atomic.AtomicReference<java.lang.Object> r1 = r4.pendingModifications
            boolean r1 = androidx.compose.animation.core.MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m(r1, r0, r2)
            if (r1 == 0) goto L_0x0000
            if (r0 != 0) goto L_0x004b
            java.lang.Object r5 = r4.lock
            monitor-enter(r5)
            r4.drainPendingModificationsLocked()     // Catch:{ all -> 0x0048 }
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0048 }
            monitor-exit(r5)
            return
        L_0x0048:
            r0 = move-exception
            monitor-exit(r5)
            throw r0
        L_0x004b:
            return
        L_0x004c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "corrupt pendingModifications: "
            r0.<init>(r1)
            java.util.concurrent.atomic.AtomicReference<java.lang.Object> r1 = r4.pendingModifications
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r0 = r0.toString()
            r5.<init>(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.CompositionImpl.recordModificationsOf(java.util.Set):void");
    }

    public void prepareCompose(Function0<Unit> function0) {
        this.composer.prepareCompose$runtime_release(function0);
    }

    private final void addPendingInvalidationsLocked(Object obj, boolean z) {
        Object obj2 = obj;
        Object obj3 = this.observations.getMap().get(obj2);
        if (obj3 == null) {
            return;
        }
        if (obj3 instanceof MutableScatterSet) {
            ScatterSet scatterSet = (MutableScatterSet) obj3;
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
                                RecomposeScopeImpl recomposeScopeImpl = (RecomposeScopeImpl) objArr[(i << 3) + i3];
                                if (!this.observationsProcessed.remove(obj2, recomposeScopeImpl) && recomposeScopeImpl.invalidateForResult(obj2) != InvalidationResult.IGNORED) {
                                    if (!recomposeScopeImpl.isConditional() || z) {
                                        this.invalidatedScopes.add(recomposeScopeImpl);
                                    } else {
                                        this.conditionallyInvalidatedScopes.add(recomposeScopeImpl);
                                    }
                                }
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
        } else {
            RecomposeScopeImpl recomposeScopeImpl2 = (RecomposeScopeImpl) obj3;
            if (!this.observationsProcessed.remove(obj2, recomposeScopeImpl2) && recomposeScopeImpl2.invalidateForResult(obj2) != InvalidationResult.IGNORED) {
                if (!recomposeScopeImpl2.isConditional() || z) {
                    this.invalidatedScopes.add(recomposeScopeImpl2);
                } else {
                    this.conditionallyInvalidatedScopes.add(recomposeScopeImpl2);
                }
            }
        }
    }

    private final void cleanUpDerivedStateObservations() {
        long j;
        long j2;
        char c;
        long j3;
        long[] jArr;
        int i;
        long[] jArr2;
        long j4;
        long j5;
        char c2;
        int i2;
        int i3;
        long[] jArr3;
        int i4;
        MutableScatterMap<Object, Object> map = this.derivedStates.getMap();
        long[] jArr4 = map.metadata;
        int length = jArr4.length - 2;
        long j6 = 255;
        char c3 = 7;
        long j7 = -9187201950435737472L;
        int i5 = 8;
        if (length >= 0) {
            int i6 = 0;
            while (true) {
                long j8 = jArr4[i6];
                j3 = 128;
                if ((((~j8) << c3) & j8 & j7) != j7) {
                    int i7 = 8 - ((~(i6 - length)) >>> 31);
                    int i8 = 0;
                    while (i8 < i7) {
                        if ((j8 & j6) < 128) {
                            j5 = j6;
                            int i9 = (i6 << 3) + i8;
                            Object obj = map.keys[i9];
                            Object obj2 = map.values[i9];
                            c2 = c3;
                            boolean z = true;
                            if (obj2 instanceof MutableScatterSet) {
                                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type androidx.collection.MutableScatterSet<Scope of androidx.compose.runtime.collection.ScopeMap.removeScopeIf$lambda$2>");
                                MutableScatterSet mutableScatterSet = (MutableScatterSet) obj2;
                                Object[] objArr = mutableScatterSet.elements;
                                j4 = j7;
                                long[] jArr5 = mutableScatterSet.metadata;
                                int length2 = jArr5.length - 2;
                                if (length2 >= 0) {
                                    int i10 = i5;
                                    int i11 = 0;
                                    while (true) {
                                        long j9 = jArr5[i11];
                                        Object[] objArr2 = objArr;
                                        long[] jArr6 = jArr5;
                                        if ((((~j9) << c2) & j9 & j4) != j4) {
                                            int i12 = 8 - ((~(i11 - length2)) >>> 31);
                                            int i13 = 0;
                                            while (i13 < i12) {
                                                if ((j9 & j5) < 128) {
                                                    jArr3 = jArr4;
                                                    int i14 = (i11 << 3) + i13;
                                                    i3 = i8;
                                                    i4 = i13;
                                                    if (!this.observations.contains((DerivedState) objArr2[i14])) {
                                                        mutableScatterSet.removeElementAt(i14);
                                                    }
                                                } else {
                                                    jArr3 = jArr4;
                                                    i3 = i8;
                                                    i4 = i13;
                                                }
                                                j9 >>= i10;
                                                i13 = i4 + 1;
                                                jArr4 = jArr3;
                                                i8 = i3;
                                            }
                                            jArr2 = jArr4;
                                            i = i8;
                                            if (i12 != i10) {
                                                break;
                                            }
                                        } else {
                                            jArr2 = jArr4;
                                            i = i8;
                                        }
                                        int i15 = i11;
                                        if (i15 == length2) {
                                            break;
                                        }
                                        i11 = i15 + 1;
                                        objArr = objArr2;
                                        jArr5 = jArr6;
                                        jArr4 = jArr2;
                                        i8 = i;
                                        i10 = 8;
                                    }
                                } else {
                                    jArr2 = jArr4;
                                    i = i8;
                                }
                                z = mutableScatterSet.isEmpty();
                            } else {
                                jArr2 = jArr4;
                                i = i8;
                                j4 = j7;
                                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type Scope of androidx.compose.runtime.collection.ScopeMap.removeScopeIf$lambda$2");
                                if (this.observations.contains((DerivedState) obj2)) {
                                    z = false;
                                }
                            }
                            if (z) {
                                map.removeValueAt(i9);
                            }
                            i2 = 8;
                        } else {
                            jArr2 = jArr4;
                            i = i8;
                            j5 = j6;
                            c2 = c3;
                            j4 = j7;
                            i2 = i5;
                        }
                        j8 >>= i2;
                        i8 = i + 1;
                        i5 = i2;
                        c3 = c2;
                        j6 = j5;
                        j7 = j4;
                        jArr4 = jArr2;
                    }
                    jArr = jArr4;
                    j2 = j6;
                    c = c3;
                    j = j7;
                    if (i7 != i5) {
                        break;
                    }
                } else {
                    jArr = jArr4;
                    j2 = j6;
                    c = c3;
                    j = j7;
                }
                if (i6 == length) {
                    break;
                }
                i6++;
                c3 = c;
                j6 = j2;
                j7 = j;
                jArr4 = jArr;
                i5 = 8;
            }
        } else {
            j2 = 255;
            c = 7;
            j = -9187201950435737472L;
            j3 = 128;
        }
        if (this.conditionallyInvalidatedScopes.isNotEmpty()) {
            MutableScatterSet<RecomposeScopeImpl> mutableScatterSet2 = this.conditionallyInvalidatedScopes;
            Object[] objArr3 = mutableScatterSet2.elements;
            long[] jArr7 = mutableScatterSet2.metadata;
            int length3 = jArr7.length - 2;
            if (length3 >= 0) {
                int i16 = 0;
                while (true) {
                    long j10 = jArr7[i16];
                    if ((((~j10) << c) & j10 & j) != j) {
                        int i17 = 8 - ((~(i16 - length3)) >>> 31);
                        for (int i18 = 0; i18 < i17; i18++) {
                            if ((j10 & j2) < j3) {
                                int i19 = (i16 << 3) + i18;
                                if (!((RecomposeScopeImpl) objArr3[i19]).isConditional()) {
                                    mutableScatterSet2.removeElementAt(i19);
                                }
                            }
                            j10 >>= 8;
                        }
                        if (i17 != 8) {
                            return;
                        }
                    }
                    if (i16 != length3) {
                        i16++;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    public void recordReadOf(Object obj) {
        RecomposeScopeImpl currentRecomposeScope$runtime_release;
        int i;
        int i2;
        int i3;
        Object obj2 = obj;
        if (!getAreChildrenComposing() && (currentRecomposeScope$runtime_release = this.composer.getCurrentRecomposeScope$runtime_release()) != null) {
            int i4 = 1;
            currentRecomposeScope$runtime_release.setUsed(true);
            if (!currentRecomposeScope$runtime_release.recordRead(obj2)) {
                if (obj2 instanceof StateObjectImpl) {
                    ReaderKind.Companion companion = ReaderKind.Companion;
                    ((StateObjectImpl) obj2).m3818recordReadInh_f27i8$runtime_release(ReaderKind.m3804constructorimpl(1));
                }
                this.observations.add(obj2, currentRecomposeScope$runtime_release);
                if (obj2 instanceof DerivedState) {
                    DerivedState derivedState = (DerivedState) obj2;
                    DerivedState.Record currentRecord = derivedState.getCurrentRecord();
                    this.derivedStates.removeScope(obj2);
                    ObjectIntMap<StateObject> dependencies = currentRecord.getDependencies();
                    Object[] objArr = dependencies.keys;
                    long[] jArr = dependencies.metadata;
                    int length = jArr.length - 2;
                    if (length >= 0) {
                        int i5 = 0;
                        while (true) {
                            long j = jArr[i5];
                            if ((((~j) << 7) & j & -9187201950435737472L) != -9187201950435737472L) {
                                int i6 = 8;
                                int i7 = 8 - ((~(i5 - length)) >>> 31);
                                int i8 = 0;
                                while (i8 < i7) {
                                    if ((j & 255) < 128) {
                                        i3 = i4;
                                        StateObject stateObject = (StateObject) objArr[(i5 << 3) + i8];
                                        if (stateObject instanceof StateObjectImpl) {
                                            ReaderKind.Companion companion2 = ReaderKind.Companion;
                                            i2 = i6;
                                            ((StateObjectImpl) stateObject).m3818recordReadInh_f27i8$runtime_release(ReaderKind.m3804constructorimpl(i3));
                                        } else {
                                            i2 = i6;
                                        }
                                        this.derivedStates.add(stateObject, obj2);
                                    } else {
                                        i3 = i4;
                                        i2 = i6;
                                    }
                                    j >>= i2;
                                    i8++;
                                    i4 = i3;
                                    i6 = i2;
                                }
                                i = i4;
                                if (i7 != i6) {
                                    break;
                                }
                            } else {
                                i = i4;
                            }
                            if (i5 == length) {
                                break;
                            }
                            i5++;
                            i4 = i;
                        }
                    }
                    currentRecomposeScope$runtime_release.recordDerivedStateValue(derivedState, currentRecord.getCurrentValue());
                }
            }
        }
    }

    private final void invalidateScopeOfLocked(Object obj) {
        Object obj2 = this.observations.getMap().get(obj);
        if (obj2 == null) {
            return;
        }
        if (obj2 instanceof MutableScatterSet) {
            ScatterSet scatterSet = (MutableScatterSet) obj2;
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
                                RecomposeScopeImpl recomposeScopeImpl = (RecomposeScopeImpl) objArr[(i << 3) + i3];
                                if (recomposeScopeImpl.invalidateForResult(obj) == InvalidationResult.IMMINENT) {
                                    this.observationsProcessed.add(obj, recomposeScopeImpl);
                                }
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
        } else {
            RecomposeScopeImpl recomposeScopeImpl2 = (RecomposeScopeImpl) obj2;
            if (recomposeScopeImpl2.invalidateForResult(obj) == InvalidationResult.IMMINENT) {
                this.observationsProcessed.add(obj, recomposeScopeImpl2);
            }
        }
    }

    public void recordWriteOf(Object obj) {
        synchronized (this.lock) {
            invalidateScopeOfLocked(obj);
            Object obj2 = this.derivedStates.getMap().get(obj);
            if (obj2 != null) {
                if (obj2 instanceof MutableScatterSet) {
                    ScatterSet scatterSet = (MutableScatterSet) obj2;
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
                                        invalidateScopeOfLocked((DerivedState) objArr[(i << 3) + i3]);
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
                } else {
                    invalidateScopeOfLocked((DerivedState) obj2);
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public boolean recompose() {
        ScopeMap<RecomposeScopeImpl, Object> takeInvalidations;
        boolean recompose$runtime_release;
        synchronized (this.lock) {
            drainPendingModificationsForCompositionLocked();
            try {
                takeInvalidations = takeInvalidations();
                CompositionObserver observer = observer();
                if (observer != null) {
                    Map<RecomposeScopeImpl, Set<Object>> asMap = takeInvalidations.asMap();
                    Intrinsics.checkNotNull(asMap, "null cannot be cast to non-null type kotlin.collections.Map<androidx.compose.runtime.RecomposeScope, kotlin.collections.Set<kotlin.Any>?>");
                    observer.onBeginComposition(this, asMap);
                }
                recompose$runtime_release = this.composer.recompose$runtime_release(takeInvalidations);
                if (!recompose$runtime_release) {
                    drainPendingModificationsLocked();
                }
                if (observer != null) {
                    observer.onEndComposition(this);
                }
            } catch (Exception e) {
                this.invalidations = takeInvalidations;
                throw e;
            } catch (Throwable th) {
                try {
                    if (!this.abandonSet.isEmpty()) {
                        new RememberEventDispatcher(this.abandonSet).dispatchAbandons();
                    }
                    throw th;
                } catch (Exception e2) {
                    abandonChanges();
                    throw e2;
                }
            }
        }
        return recompose$runtime_release;
    }

    /* JADX INFO: finally extract failed */
    public void disposeUnusedMovableContent(MovableContentState movableContentState) {
        RememberEventDispatcher rememberEventDispatcher = new RememberEventDispatcher(this.abandonSet);
        SlotWriter openWriter = movableContentState.getSlotTable$runtime_release().openWriter();
        try {
            ComposerKt.removeCurrentGroup(openWriter, rememberEventDispatcher);
            Unit unit = Unit.INSTANCE;
            openWriter.close(true);
            rememberEventDispatcher.dispatchRememberObservers();
        } catch (Throwable th) {
            openWriter.close(false);
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:108:0x01c2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void applyChangesInLocked(androidx.compose.runtime.changelist.ChangeList r33) {
        /*
            r32 = this;
            r1 = r32
            androidx.compose.runtime.CompositionImpl$RememberEventDispatcher r2 = new androidx.compose.runtime.CompositionImpl$RememberEventDispatcher
            java.util.Set<androidx.compose.runtime.RememberObserver> r0 = r1.abandonSet
            r2.<init>(r0)
            boolean r0 = r33.isEmpty()     // Catch:{ all -> 0x01b7 }
            if (r0 == 0) goto L_0x001b
            androidx.compose.runtime.changelist.ChangeList r0 = r1.lateChanges
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x01a1
            r2.dispatchAbandons()
            return
        L_0x001b:
            java.lang.String r0 = "Compose:applyChanges"
            androidx.compose.runtime.Trace r3 = androidx.compose.runtime.Trace.INSTANCE     // Catch:{ all -> 0x01b7 }
            java.lang.Object r3 = r3.beginSection(r0)     // Catch:{ all -> 0x01b7 }
            androidx.compose.runtime.Applier<?> r0 = r1.applier     // Catch:{ all -> 0x01ac }
            r0.onBeginChanges()     // Catch:{ all -> 0x01ac }
            androidx.compose.runtime.SlotTable r0 = r1.slotTable     // Catch:{ all -> 0x01ac }
            androidx.compose.runtime.SlotWriter r4 = r0.openWriter()     // Catch:{ all -> 0x01ac }
            r5 = 0
            androidx.compose.runtime.Applier<?> r0 = r1.applier     // Catch:{ all -> 0x01a2 }
            r6 = r2
            androidx.compose.runtime.RememberManager r6 = (androidx.compose.runtime.RememberManager) r6     // Catch:{ all -> 0x01a2 }
            r7 = r33
            r7.executeAndFlushAllPendingChanges(r0, r4, r6)     // Catch:{ all -> 0x01a2 }
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x01a2 }
            r0 = 1
            r4.close(r0)     // Catch:{ all -> 0x01ac }
            androidx.compose.runtime.Applier<?> r4 = r1.applier     // Catch:{ all -> 0x01ac }
            r4.onEndChanges()     // Catch:{ all -> 0x01ac }
            kotlin.Unit r4 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x01ac }
            androidx.compose.runtime.Trace r4 = androidx.compose.runtime.Trace.INSTANCE     // Catch:{ all -> 0x01b7 }
            r4.endSection(r3)     // Catch:{ all -> 0x01b7 }
            r2.dispatchRememberObservers()     // Catch:{ all -> 0x01b7 }
            r2.dispatchSideEffects()     // Catch:{ all -> 0x01b7 }
            boolean r3 = r1.pendingInvalidScopes     // Catch:{ all -> 0x01b7 }
            if (r3 == 0) goto L_0x0194
            java.lang.String r3 = "Compose:unobserve"
            androidx.compose.runtime.Trace r4 = androidx.compose.runtime.Trace.INSTANCE     // Catch:{ all -> 0x01b7 }
            java.lang.Object r3 = r4.beginSection(r3)     // Catch:{ all -> 0x01b7 }
            r1.pendingInvalidScopes = r5     // Catch:{ all -> 0x018b }
            androidx.compose.runtime.collection.ScopeMap<java.lang.Object, androidx.compose.runtime.RecomposeScopeImpl> r4 = r1.observations     // Catch:{ all -> 0x018b }
            androidx.collection.MutableScatterMap r4 = r4.getMap()     // Catch:{ all -> 0x018b }
            r6 = r4
            androidx.collection.ScatterMap r6 = (androidx.collection.ScatterMap) r6     // Catch:{ all -> 0x018b }
            long[] r6 = r6.metadata     // Catch:{ all -> 0x018b }
            int r7 = r6.length     // Catch:{ all -> 0x018b }
            int r7 = r7 + -2
            if (r7 < 0) goto L_0x017c
            r8 = r5
        L_0x0070:
            r9 = r6[r8]     // Catch:{ all -> 0x018b }
            long r11 = ~r9     // Catch:{ all -> 0x018b }
            r13 = 7
            long r11 = r11 << r13
            long r11 = r11 & r9
            r14 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r11 = r11 & r14
            int r11 = (r11 > r14 ? 1 : (r11 == r14 ? 0 : -1))
            if (r11 == 0) goto L_0x016c
            int r11 = r8 - r7
            int r11 = ~r11     // Catch:{ all -> 0x018b }
            int r11 = r11 >>> 31
            r12 = 8
            int r11 = 8 - r11
            r0 = r5
        L_0x008a:
            if (r0 >= r11) goto L_0x0164
            r16 = 255(0xff, double:1.26E-321)
            long r18 = r9 & r16
            r20 = 128(0x80, double:6.32E-322)
            int r18 = (r18 > r20 ? 1 : (r18 == r20 ? 0 : -1))
            if (r18 >= 0) goto L_0x0147
            int r18 = r8 << 3
            r19 = r13
            int r13 = r18 + r0
            r22 = r14
            java.lang.Object[] r14 = r4.keys     // Catch:{ all -> 0x018b }
            r14 = r14[r13]     // Catch:{ all -> 0x018b }
            java.lang.Object[] r14 = r4.values     // Catch:{ all -> 0x018b }
            r14 = r14[r13]     // Catch:{ all -> 0x018b }
            boolean r15 = r14 instanceof androidx.collection.MutableScatterSet     // Catch:{ all -> 0x018b }
            if (r15 == 0) goto L_0x0127
            java.lang.String r15 = "null cannot be cast to non-null type androidx.collection.MutableScatterSet<Scope of androidx.compose.runtime.collection.ScopeMap.removeScopeIf$lambda$2>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r14, r15)     // Catch:{ all -> 0x018b }
            androidx.collection.MutableScatterSet r14 = (androidx.collection.MutableScatterSet) r14     // Catch:{ all -> 0x018b }
            java.lang.Object[] r15 = r14.elements     // Catch:{ all -> 0x018b }
            r5 = r14
            androidx.collection.ScatterSet r5 = (androidx.collection.ScatterSet) r5     // Catch:{ all -> 0x018b }
            long[] r5 = r5.metadata     // Catch:{ all -> 0x018b }
            r24 = r12
            int r12 = r5.length     // Catch:{ all -> 0x018b }
            int r12 = r12 + -2
            r25 = r0
            if (r12 < 0) goto L_0x011c
            r27 = r5
            r26 = r6
            r0 = 0
        L_0x00c6:
            r5 = r27[r0]     // Catch:{ all -> 0x018b }
            r28 = r9
            long r9 = ~r5
            long r9 = r9 << r19
            long r9 = r9 & r5
            long r9 = r9 & r22
            int r9 = (r9 > r22 ? 1 : (r9 == r22 ? 0 : -1))
            if (r9 == 0) goto L_0x010f
            int r9 = r0 - r12
            int r9 = ~r9
            int r9 = r9 >>> 31
            int r9 = 8 - r9
            r10 = 0
        L_0x00dc:
            if (r10 >= r9) goto L_0x0108
            long r30 = r5 & r16
            int r30 = (r30 > r20 ? 1 : (r30 == r20 ? 0 : -1))
            if (r30 >= 0) goto L_0x00e7
            r30 = 1
            goto L_0x00e9
        L_0x00e7:
            r30 = 0
        L_0x00e9:
            if (r30 == 0) goto L_0x00ff
            int r30 = r0 << 3
            r31 = r2
            int r2 = r30 + r10
            r30 = r15[r2]     // Catch:{ all -> 0x0189 }
            androidx.compose.runtime.RecomposeScopeImpl r30 = (androidx.compose.runtime.RecomposeScopeImpl) r30     // Catch:{ all -> 0x0189 }
            boolean r30 = r30.getValid()     // Catch:{ all -> 0x0189 }
            if (r30 != 0) goto L_0x0101
            r14.removeElementAt(r2)     // Catch:{ all -> 0x0189 }
            goto L_0x0101
        L_0x00ff:
            r31 = r2
        L_0x0101:
            long r5 = r5 >> r24
            int r10 = r10 + 1
            r2 = r31
            goto L_0x00dc
        L_0x0108:
            r31 = r2
            r2 = r24
            if (r9 != r2) goto L_0x0122
            goto L_0x0111
        L_0x010f:
            r31 = r2
        L_0x0111:
            if (r0 == r12) goto L_0x0122
            int r0 = r0 + 1
            r9 = r28
            r2 = r31
            r24 = 8
            goto L_0x00c6
        L_0x011c:
            r31 = r2
            r26 = r6
            r28 = r9
        L_0x0122:
            boolean r0 = r14.isEmpty()     // Catch:{ all -> 0x0189 }
            goto L_0x013f
        L_0x0127:
            r25 = r0
            r31 = r2
            r26 = r6
            r28 = r9
            java.lang.String r0 = "null cannot be cast to non-null type Scope of androidx.compose.runtime.collection.ScopeMap.removeScopeIf$lambda$2"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r14, r0)     // Catch:{ all -> 0x0189 }
            androidx.compose.runtime.RecomposeScopeImpl r14 = (androidx.compose.runtime.RecomposeScopeImpl) r14     // Catch:{ all -> 0x0189 }
            boolean r0 = r14.getValid()     // Catch:{ all -> 0x0189 }
            if (r0 != 0) goto L_0x013e
            r0 = 1
            goto L_0x013f
        L_0x013e:
            r0 = 0
        L_0x013f:
            if (r0 == 0) goto L_0x0144
            r4.removeValueAt(r13)     // Catch:{ all -> 0x0189 }
        L_0x0144:
            r2 = 8
            goto L_0x0154
        L_0x0147:
            r25 = r0
            r31 = r2
            r26 = r6
            r28 = r9
            r19 = r13
            r22 = r14
            r2 = r12
        L_0x0154:
            long r9 = r28 >> r2
            int r0 = r25 + 1
            r12 = r2
            r13 = r19
            r14 = r22
            r6 = r26
            r2 = r31
            r5 = 0
            goto L_0x008a
        L_0x0164:
            r31 = r2
            r26 = r6
            r2 = r12
            if (r11 != r2) goto L_0x017e
            goto L_0x0170
        L_0x016c:
            r31 = r2
            r26 = r6
        L_0x0170:
            if (r8 == r7) goto L_0x017e
            int r8 = r8 + 1
            r6 = r26
            r2 = r31
            r0 = 1
            r5 = 0
            goto L_0x0070
        L_0x017c:
            r31 = r2
        L_0x017e:
            r1.cleanUpDerivedStateObservations()     // Catch:{ all -> 0x0189 }
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0189 }
            androidx.compose.runtime.Trace r0 = androidx.compose.runtime.Trace.INSTANCE     // Catch:{ all -> 0x01b5 }
            r0.endSection(r3)     // Catch:{ all -> 0x01b5 }
            goto L_0x0196
        L_0x0189:
            r0 = move-exception
            goto L_0x018e
        L_0x018b:
            r0 = move-exception
            r31 = r2
        L_0x018e:
            androidx.compose.runtime.Trace r2 = androidx.compose.runtime.Trace.INSTANCE     // Catch:{ all -> 0x01b5 }
            r2.endSection(r3)     // Catch:{ all -> 0x01b5 }
            throw r0     // Catch:{ all -> 0x01b5 }
        L_0x0194:
            r31 = r2
        L_0x0196:
            androidx.compose.runtime.changelist.ChangeList r0 = r1.lateChanges
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x01a1
            r31.dispatchAbandons()
        L_0x01a1:
            return
        L_0x01a2:
            r0 = move-exception
            r31 = r2
            r2 = 0
            r4.close(r2)     // Catch:{ all -> 0x01aa }
            throw r0     // Catch:{ all -> 0x01aa }
        L_0x01aa:
            r0 = move-exception
            goto L_0x01af
        L_0x01ac:
            r0 = move-exception
            r31 = r2
        L_0x01af:
            androidx.compose.runtime.Trace r2 = androidx.compose.runtime.Trace.INSTANCE     // Catch:{ all -> 0x01b5 }
            r2.endSection(r3)     // Catch:{ all -> 0x01b5 }
            throw r0     // Catch:{ all -> 0x01b5 }
        L_0x01b5:
            r0 = move-exception
            goto L_0x01ba
        L_0x01b7:
            r0 = move-exception
            r31 = r2
        L_0x01ba:
            androidx.compose.runtime.changelist.ChangeList r2 = r1.lateChanges
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L_0x01c5
            r31.dispatchAbandons()
        L_0x01c5:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.CompositionImpl.applyChangesInLocked(androidx.compose.runtime.changelist.ChangeList):void");
    }

    public void applyChanges() {
        synchronized (this.lock) {
            try {
                applyChangesInLocked(this.changes);
                drainPendingModificationsLocked();
                Unit unit = Unit.INSTANCE;
                Unit unit2 = Unit.INSTANCE;
            } catch (Exception e) {
                abandonChanges();
                throw e;
            } catch (Throwable th) {
                if (!this.abandonSet.isEmpty()) {
                    new RememberEventDispatcher(this.abandonSet).dispatchAbandons();
                }
                throw th;
            }
        }
    }

    public void applyLateChanges() {
        synchronized (this.lock) {
            try {
                if (this.lateChanges.isNotEmpty()) {
                    applyChangesInLocked(this.lateChanges);
                }
                Unit unit = Unit.INSTANCE;
                Unit unit2 = Unit.INSTANCE;
            } catch (Exception e) {
                abandonChanges();
                throw e;
            } catch (Throwable th) {
                if (!this.abandonSet.isEmpty()) {
                    new RememberEventDispatcher(this.abandonSet).dispatchAbandons();
                }
                throw th;
            }
        }
    }

    public void changesApplied() {
        synchronized (this.lock) {
            try {
                this.composer.changesApplied$runtime_release();
                if (!this.abandonSet.isEmpty()) {
                    new RememberEventDispatcher(this.abandonSet).dispatchAbandons();
                }
                Unit unit = Unit.INSTANCE;
                Unit unit2 = Unit.INSTANCE;
            } catch (Exception e) {
                abandonChanges();
                throw e;
            } catch (Throwable th) {
                if (!this.abandonSet.isEmpty()) {
                    new RememberEventDispatcher(this.abandonSet).dispatchAbandons();
                }
                throw th;
            }
        }
    }

    private final <T> T guardInvalidationsLocked(Function1<? super ScopeMap<RecomposeScopeImpl, Object>, ? extends T> function1) {
        ScopeMap<RecomposeScopeImpl, Object> takeInvalidations = takeInvalidations();
        try {
            return function1.invoke(takeInvalidations);
        } catch (Exception e) {
            this.invalidations = takeInvalidations;
            throw e;
        }
    }

    public void abandonChanges() {
        this.pendingModifications.set((Object) null);
        this.changes.clear();
        this.lateChanges.clear();
        if (!this.abandonSet.isEmpty()) {
            new RememberEventDispatcher(this.abandonSet).dispatchAbandons();
        }
    }

    public void invalidateAll() {
        synchronized (this.lock) {
            for (Object obj : this.slotTable.getSlots()) {
                RecomposeScopeImpl recomposeScopeImpl = obj instanceof RecomposeScopeImpl ? (RecomposeScopeImpl) obj : null;
                if (recomposeScopeImpl != null) {
                    recomposeScopeImpl.invalidate();
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public void verifyConsistent() {
        synchronized (this.lock) {
            if (!isComposing()) {
                this.composer.verifyConsistent$runtime_release();
                this.slotTable.verifyWellFormed();
                validateRecomposeScopeAnchors(this.slotTable);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public <R> R delegateInvalidations(ControlledComposition controlledComposition, int i, Function0<? extends R> function0) {
        if (controlledComposition == null || Intrinsics.areEqual((Object) controlledComposition, (Object) this) || i < 0) {
            return function0.invoke();
        }
        this.invalidationDelegate = (CompositionImpl) controlledComposition;
        this.invalidationDelegateGroup = i;
        try {
            return function0.invoke();
        } finally {
            this.invalidationDelegate = null;
            this.invalidationDelegateGroup = 0;
        }
    }

    public InvalidationResult invalidate(RecomposeScopeImpl recomposeScopeImpl, Object obj) {
        CompositionImpl compositionImpl;
        if (recomposeScopeImpl.getDefaultsInScope()) {
            recomposeScopeImpl.setDefaultsInvalid(true);
        }
        Anchor anchor = recomposeScopeImpl.getAnchor();
        if (anchor == null || !anchor.getValid()) {
            return InvalidationResult.IGNORED;
        }
        if (!this.slotTable.ownsAnchor(anchor)) {
            synchronized (this.lock) {
                compositionImpl = this.invalidationDelegate;
            }
            if (compositionImpl == null || !compositionImpl.tryImminentInvalidation(recomposeScopeImpl, obj)) {
                return InvalidationResult.IGNORED;
            }
            return InvalidationResult.IMMINENT;
        } else if (!recomposeScopeImpl.getCanRecompose()) {
            return InvalidationResult.IGNORED;
        } else {
            return invalidateChecked(recomposeScopeImpl, anchor, obj);
        }
    }

    public void recomposeScopeReleased(RecomposeScopeImpl recomposeScopeImpl) {
        this.pendingInvalidScopes = true;
    }

    public <T> T getCompositionService(CompositionServiceKey<T> compositionServiceKey) {
        if (Intrinsics.areEqual((Object) compositionServiceKey, (Object) CompositionKt.getCompositionImplServiceKey())) {
            return this;
        }
        return null;
    }

    private final boolean tryImminentInvalidation(RecomposeScopeImpl recomposeScopeImpl, Object obj) {
        return isComposing() && this.composer.tryImminentInvalidation$runtime_release(recomposeScopeImpl, obj);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00b4, code lost:
        if (r6 == null) goto L_0x00bb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00ba, code lost:
        return r6.invalidateChecked(r0, r2, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00bb, code lost:
        r1.parent.invalidate$runtime_release(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00c7, code lost:
        if (isComposing() == false) goto L_0x00cc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00cb, code lost:
        return androidx.compose.runtime.InvalidationResult.DEFERRED;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00ce, code lost:
        return androidx.compose.runtime.InvalidationResult.SCHEDULED;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final androidx.compose.runtime.InvalidationResult invalidateChecked(androidx.compose.runtime.RecomposeScopeImpl r21, androidx.compose.runtime.Anchor r22, java.lang.Object r23) {
        /*
            r20 = this;
            r1 = r20
            r0 = r21
            r2 = r22
            r3 = r23
            java.lang.Object r4 = r1.lock
            monitor-enter(r4)
            androidx.compose.runtime.CompositionImpl r5 = r1.invalidationDelegate     // Catch:{ all -> 0x00cf }
            r6 = 0
            if (r5 == 0) goto L_0x001d
            androidx.compose.runtime.SlotTable r7 = r1.slotTable     // Catch:{ all -> 0x00cf }
            int r8 = r1.invalidationDelegateGroup     // Catch:{ all -> 0x00cf }
            boolean r7 = r7.groupContainsAnchor(r8, r2)     // Catch:{ all -> 0x00cf }
            if (r7 == 0) goto L_0x001b
            goto L_0x001c
        L_0x001b:
            r5 = r6
        L_0x001c:
            r6 = r5
        L_0x001d:
            if (r6 != 0) goto L_0x00b3
            boolean r5 = r1.tryImminentInvalidation(r0, r3)     // Catch:{ all -> 0x00cf }
            if (r5 == 0) goto L_0x0029
            androidx.compose.runtime.InvalidationResult r0 = androidx.compose.runtime.InvalidationResult.IMMINENT     // Catch:{ all -> 0x00cf }
            monitor-exit(r4)
            return r0
        L_0x0029:
            androidx.compose.runtime.tooling.CompositionObserver r5 = r1.observer()     // Catch:{ all -> 0x00cf }
            if (r3 != 0) goto L_0x0038
            androidx.compose.runtime.collection.ScopeMap<androidx.compose.runtime.RecomposeScopeImpl, java.lang.Object> r5 = r1.invalidations     // Catch:{ all -> 0x00cf }
            androidx.compose.runtime.ScopeInvalidated r7 = androidx.compose.runtime.ScopeInvalidated.INSTANCE     // Catch:{ all -> 0x00cf }
            r5.set(r0, r7)     // Catch:{ all -> 0x00cf }
            goto L_0x00b3
        L_0x0038:
            if (r5 != 0) goto L_0x0047
            boolean r5 = r3 instanceof androidx.compose.runtime.DerivedState     // Catch:{ all -> 0x00cf }
            if (r5 != 0) goto L_0x0047
            androidx.compose.runtime.collection.ScopeMap<androidx.compose.runtime.RecomposeScopeImpl, java.lang.Object> r5 = r1.invalidations     // Catch:{ all -> 0x00cf }
            androidx.compose.runtime.ScopeInvalidated r7 = androidx.compose.runtime.ScopeInvalidated.INSTANCE     // Catch:{ all -> 0x00cf }
            r5.set(r0, r7)     // Catch:{ all -> 0x00cf }
            goto L_0x00b3
        L_0x0047:
            androidx.compose.runtime.collection.ScopeMap<androidx.compose.runtime.RecomposeScopeImpl, java.lang.Object> r5 = r1.invalidations     // Catch:{ all -> 0x00cf }
            androidx.collection.MutableScatterMap r5 = r5.getMap()     // Catch:{ all -> 0x00cf }
            java.lang.Object r5 = r5.get(r0)     // Catch:{ all -> 0x00cf }
            if (r5 == 0) goto L_0x00ae
            boolean r7 = r5 instanceof androidx.collection.MutableScatterSet     // Catch:{ all -> 0x00cf }
            if (r7 == 0) goto L_0x00a9
            androidx.collection.MutableScatterSet r5 = (androidx.collection.MutableScatterSet) r5     // Catch:{ all -> 0x00cf }
            androidx.collection.ScatterSet r5 = (androidx.collection.ScatterSet) r5     // Catch:{ all -> 0x00cf }
            java.lang.Object[] r7 = r5.elements     // Catch:{ all -> 0x00cf }
            long[] r5 = r5.metadata     // Catch:{ all -> 0x00cf }
            int r8 = r5.length     // Catch:{ all -> 0x00cf }
            int r8 = r8 + -2
            if (r8 < 0) goto L_0x00ae
            r10 = 0
        L_0x0065:
            r11 = r5[r10]     // Catch:{ all -> 0x00cf }
            long r13 = ~r11     // Catch:{ all -> 0x00cf }
            r15 = 7
            long r13 = r13 << r15
            long r13 = r13 & r11
            r15 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r13 = r13 & r15
            int r13 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r13 == 0) goto L_0x00a4
            int r13 = r10 - r8
            int r13 = ~r13     // Catch:{ all -> 0x00cf }
            int r13 = r13 >>> 31
            r14 = 8
            int r13 = 8 - r13
            r15 = 0
        L_0x007f:
            if (r15 >= r13) goto L_0x00a1
            r16 = 255(0xff, double:1.26E-321)
            long r16 = r11 & r16
            r18 = 128(0x80, double:6.32E-322)
            int r16 = (r16 > r18 ? 1 : (r16 == r18 ? 0 : -1))
            if (r16 >= 0) goto L_0x0098
            int r16 = r10 << 3
            int r16 = r16 + r15
            r9 = r7[r16]     // Catch:{ all -> 0x00cf }
            r16 = r14
            androidx.compose.runtime.ScopeInvalidated r14 = androidx.compose.runtime.ScopeInvalidated.INSTANCE     // Catch:{ all -> 0x00cf }
            if (r9 != r14) goto L_0x009a
            goto L_0x00b3
        L_0x0098:
            r16 = r14
        L_0x009a:
            long r11 = r11 >> r16
            int r15 = r15 + 1
            r14 = r16
            goto L_0x007f
        L_0x00a1:
            r9 = r14
            if (r13 != r9) goto L_0x00ae
        L_0x00a4:
            if (r10 == r8) goto L_0x00ae
            int r10 = r10 + 1
            goto L_0x0065
        L_0x00a9:
            androidx.compose.runtime.ScopeInvalidated r7 = androidx.compose.runtime.ScopeInvalidated.INSTANCE     // Catch:{ all -> 0x00cf }
            if (r5 != r7) goto L_0x00ae
            goto L_0x00b3
        L_0x00ae:
            androidx.compose.runtime.collection.ScopeMap<androidx.compose.runtime.RecomposeScopeImpl, java.lang.Object> r5 = r1.invalidations     // Catch:{ all -> 0x00cf }
            r5.add(r0, r3)     // Catch:{ all -> 0x00cf }
        L_0x00b3:
            monitor-exit(r4)
            if (r6 == 0) goto L_0x00bb
            androidx.compose.runtime.InvalidationResult r0 = r6.invalidateChecked(r0, r2, r3)
            return r0
        L_0x00bb:
            androidx.compose.runtime.CompositionContext r0 = r1.parent
            r2 = r1
            androidx.compose.runtime.ControlledComposition r2 = (androidx.compose.runtime.ControlledComposition) r2
            r0.invalidate$runtime_release(r2)
            boolean r0 = r1.isComposing()
            if (r0 == 0) goto L_0x00cc
            androidx.compose.runtime.InvalidationResult r0 = androidx.compose.runtime.InvalidationResult.DEFERRED
            return r0
        L_0x00cc:
            androidx.compose.runtime.InvalidationResult r0 = androidx.compose.runtime.InvalidationResult.SCHEDULED
            return r0
        L_0x00cf:
            r0 = move-exception
            monitor-exit(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.CompositionImpl.invalidateChecked(androidx.compose.runtime.RecomposeScopeImpl, androidx.compose.runtime.Anchor, java.lang.Object):androidx.compose.runtime.InvalidationResult");
    }

    public final void removeObservation$runtime_release(Object obj, RecomposeScopeImpl recomposeScopeImpl) {
        this.observations.remove(obj, recomposeScopeImpl);
    }

    public final void removeDerivedStateObservation$runtime_release(DerivedState<?> derivedState) {
        if (!this.observations.contains(derivedState)) {
            this.derivedStates.removeScope(derivedState);
        }
    }

    private final ScopeMap<RecomposeScopeImpl, Object> takeInvalidations() {
        ScopeMap<RecomposeScopeImpl, Object> scopeMap = this.invalidations;
        this.invalidations = new ScopeMap<>();
        return scopeMap;
    }

    private final void validateRecomposeScopeAnchors(SlotTable slotTable2) {
        Object[] slots = slotTable2.getSlots();
        Collection arrayList = new ArrayList();
        for (Object obj : slots) {
            RecomposeScopeImpl recomposeScopeImpl = obj instanceof RecomposeScopeImpl ? (RecomposeScopeImpl) obj : null;
            if (recomposeScopeImpl != null) {
                arrayList.add(recomposeScopeImpl);
            }
        }
        List list = (List) arrayList;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            RecomposeScopeImpl recomposeScopeImpl2 = (RecomposeScopeImpl) list.get(i);
            Anchor anchor = recomposeScopeImpl2.getAnchor();
            if (anchor != null && !slotTable2.slotsOf$runtime_release(anchor.toIndexFor(slotTable2)).contains(recomposeScopeImpl2)) {
                PreconditionsKt.throwIllegalStateException("Misaligned anchor " + anchor + " in scope " + recomposeScopeImpl2 + " encountered, scope found at " + ArraysKt.indexOf((T[]) slotTable2.getSlots(), recomposeScopeImpl2));
            }
        }
    }

    private final <T> T trackAbandonedValues(Function0<? extends T> function0) {
        try {
            return function0.invoke();
        } catch (Throwable th) {
            if (!this.abandonSet.isEmpty()) {
                new RememberEventDispatcher(this.abandonSet).dispatchAbandons();
            }
            throw th;
        }
    }

    private final CompositionObserver observer() {
        CompositionObserverHolder compositionObserverHolder = this.observerHolder;
        if (compositionObserverHolder.getRoot()) {
            return compositionObserverHolder.getObserver();
        }
        CompositionObserverHolder observerHolder$runtime_release = this.parent.getObserverHolder$runtime_release();
        CompositionObserver observer = observerHolder$runtime_release != null ? observerHolder$runtime_release.getObserver() : null;
        if (!Intrinsics.areEqual((Object) observer, (Object) compositionObserverHolder.getObserver())) {
            compositionObserverHolder.setObserver(observer);
        }
        return observer;
    }

    public void deactivate() {
        SlotWriter openWriter;
        synchronized (this.lock) {
            boolean z = this.slotTable.getGroupsSize() > 0;
            if (z || !this.abandonSet.isEmpty()) {
                Object beginSection = Trace.INSTANCE.beginSection("Compose:deactivate");
                try {
                    RememberEventDispatcher rememberEventDispatcher = new RememberEventDispatcher(this.abandonSet);
                    if (z) {
                        this.applier.onBeginChanges();
                        openWriter = this.slotTable.openWriter();
                        ComposerKt.deactivateCurrentGroup(openWriter, rememberEventDispatcher);
                        Unit unit = Unit.INSTANCE;
                        openWriter.close(true);
                        this.applier.onEndChanges();
                        rememberEventDispatcher.dispatchRememberObservers();
                    }
                    rememberEventDispatcher.dispatchAbandons();
                    Unit unit2 = Unit.INSTANCE;
                    Trace.INSTANCE.endSection(beginSection);
                } catch (Throwable th) {
                    Trace.INSTANCE.endSection(beginSection);
                    throw th;
                }
            }
            this.observations.clear();
            this.derivedStates.clear();
            this.invalidations.clear();
            this.changes.clear();
            this.lateChanges.clear();
            this.composer.deactivate$runtime_release();
            Unit unit3 = Unit.INSTANCE;
        }
    }

    public final int composerStacksSizes$runtime_release() {
        return this.composer.stacksSize$runtime_release();
    }

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\b\u0002\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J(\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0017H\u0016J\u0006\u0010\u001a\u001a\u00020\u0013J\u0006\u0010\u001b\u001a\u00020\u0013J\u0006\u0010\u001c\u001a\u00020\u0013J(\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0017H\u0016J\u0010\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J(\u0010\u001f\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0017H\u0002J(\u0010\r\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0017H\u0016J\u0010\u0010\u0010\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0004H\u0016J\u0016\u0010 \u001a\u00020\u00132\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\tX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00120\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Landroidx/compose/runtime/CompositionImpl$RememberEventDispatcher;", "Landroidx/compose/runtime/RememberManager;", "abandoning", "", "Landroidx/compose/runtime/RememberObserver;", "(Ljava/util/Set;)V", "afters", "Landroidx/collection/MutableIntList;", "leaving", "", "", "pending", "priorities", "releasing", "Landroidx/collection/MutableScatterSet;", "Landroidx/compose/runtime/ComposeNodeLifecycleCallback;", "remembering", "sideEffects", "Lkotlin/Function0;", "", "deactivating", "instance", "endRelativeOrder", "", "priority", "endRelativeAfter", "dispatchAbandons", "dispatchRememberObservers", "dispatchSideEffects", "forgetting", "processPendingLeaving", "recordLeaving", "sideEffect", "effect", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: Composition.kt */
    private static final class RememberEventDispatcher implements RememberManager {
        private final Set<RememberObserver> abandoning;
        private final MutableIntList afters = new MutableIntList(0, 1, (DefaultConstructorMarker) null);
        private final List<Object> leaving = new ArrayList();
        private final List<Object> pending = new ArrayList();
        private final MutableIntList priorities = new MutableIntList(0, 1, (DefaultConstructorMarker) null);
        private MutableScatterSet<ComposeNodeLifecycleCallback> releasing;
        private final List<RememberObserver> remembering = new ArrayList();
        private final List<Function0<Unit>> sideEffects = new ArrayList();

        public RememberEventDispatcher(Set<RememberObserver> set) {
            this.abandoning = set;
        }

        public void remembering(RememberObserver rememberObserver) {
            this.remembering.add(rememberObserver);
        }

        public void forgetting(RememberObserver rememberObserver, int i, int i2, int i3) {
            recordLeaving(rememberObserver, i, i2, i3);
        }

        public void sideEffect(Function0<Unit> function0) {
            this.sideEffects.add(function0);
        }

        public void deactivating(ComposeNodeLifecycleCallback composeNodeLifecycleCallback, int i, int i2, int i3) {
            recordLeaving(composeNodeLifecycleCallback, i, i2, i3);
        }

        public void releasing(ComposeNodeLifecycleCallback composeNodeLifecycleCallback, int i, int i2, int i3) {
            MutableScatterSet<ComposeNodeLifecycleCallback> mutableScatterSet = this.releasing;
            if (mutableScatterSet == null) {
                mutableScatterSet = ScatterSetKt.mutableScatterSetOf();
                this.releasing = mutableScatterSet;
            }
            mutableScatterSet.plusAssign(composeNodeLifecycleCallback);
            recordLeaving(composeNodeLifecycleCallback, i, i2, i3);
        }

        public final void dispatchRememberObservers() {
            processPendingLeaving(Integer.MIN_VALUE);
            if (!this.leaving.isEmpty()) {
                Object beginSection = Trace.INSTANCE.beginSection("Compose:onForgotten");
                try {
                    MutableScatterSet<ComposeNodeLifecycleCallback> mutableScatterSet = this.releasing;
                    for (int size = this.leaving.size() - 1; -1 < size; size--) {
                        Object obj = this.leaving.get(size);
                        if (obj instanceof RememberObserver) {
                            this.abandoning.remove(obj);
                            ((RememberObserver) obj).onForgotten();
                        }
                        if (obj instanceof ComposeNodeLifecycleCallback) {
                            if (mutableScatterSet == null || !mutableScatterSet.contains(obj)) {
                                ((ComposeNodeLifecycleCallback) obj).onDeactivate();
                            } else {
                                ((ComposeNodeLifecycleCallback) obj).onRelease();
                            }
                        }
                    }
                    Unit unit = Unit.INSTANCE;
                } finally {
                    Trace.INSTANCE.endSection(beginSection);
                }
            }
            if (!this.remembering.isEmpty()) {
                Object beginSection2 = Trace.INSTANCE.beginSection("Compose:onRemembered");
                try {
                    List<RememberObserver> list = this.remembering;
                    int size2 = list.size();
                    for (int i = 0; i < size2; i++) {
                        RememberObserver rememberObserver = list.get(i);
                        this.abandoning.remove(rememberObserver);
                        rememberObserver.onRemembered();
                    }
                    Unit unit2 = Unit.INSTANCE;
                } finally {
                    Trace.INSTANCE.endSection(beginSection2);
                }
            }
        }

        public final void dispatchSideEffects() {
            if (!this.sideEffects.isEmpty()) {
                Object beginSection = Trace.INSTANCE.beginSection("Compose:sideeffects");
                try {
                    List<Function0<Unit>> list = this.sideEffects;
                    int size = list.size();
                    for (int i = 0; i < size; i++) {
                        list.get(i).invoke();
                    }
                    this.sideEffects.clear();
                    Unit unit = Unit.INSTANCE;
                } finally {
                    Trace.INSTANCE.endSection(beginSection);
                }
            }
        }

        public final void dispatchAbandons() {
            if (!this.abandoning.isEmpty()) {
                Object beginSection = Trace.INSTANCE.beginSection("Compose:abandons");
                try {
                    Iterator<RememberObserver> it = this.abandoning.iterator();
                    while (it.hasNext()) {
                        it.remove();
                        it.next().onAbandoned();
                    }
                    Unit unit = Unit.INSTANCE;
                } finally {
                    Trace.INSTANCE.endSection(beginSection);
                }
            }
        }

        private final void recordLeaving(Object obj, int i, int i2, int i3) {
            processPendingLeaving(i);
            if (i3 < 0 || i3 >= i) {
                this.leaving.add(obj);
                return;
            }
            this.pending.add(obj);
            this.priorities.add(i2);
            this.afters.add(i3);
        }

        private final void processPendingLeaving(int i) {
            if (!this.pending.isEmpty()) {
                int i2 = 0;
                int i3 = 0;
                List list = null;
                MutableIntList mutableIntList = null;
                MutableIntList mutableIntList2 = null;
                while (i3 < this.afters.getSize()) {
                    if (i <= this.afters.get(i3)) {
                        Object remove = this.pending.remove(i3);
                        int removeAt = this.afters.removeAt(i3);
                        int removeAt2 = this.priorities.removeAt(i3);
                        if (list == null) {
                            list = CollectionsKt.mutableListOf(remove);
                            mutableIntList2 = new MutableIntList(0, 1, (DefaultConstructorMarker) null);
                            mutableIntList2.add(removeAt);
                            mutableIntList = new MutableIntList(0, 1, (DefaultConstructorMarker) null);
                            mutableIntList.add(removeAt2);
                        } else {
                            Intrinsics.checkNotNull(mutableIntList, "null cannot be cast to non-null type androidx.collection.MutableIntList");
                            Intrinsics.checkNotNull(mutableIntList2, "null cannot be cast to non-null type androidx.collection.MutableIntList");
                            list.add(remove);
                            mutableIntList2.add(removeAt);
                            mutableIntList.add(removeAt2);
                        }
                    } else {
                        i3++;
                    }
                }
                if (list != null) {
                    Intrinsics.checkNotNull(mutableIntList, "null cannot be cast to non-null type androidx.collection.MutableIntList");
                    Intrinsics.checkNotNull(mutableIntList2, "null cannot be cast to non-null type androidx.collection.MutableIntList");
                    int size = list.size() - 1;
                    while (i2 < size) {
                        int i4 = i2 + 1;
                        int size2 = list.size();
                        for (int i5 = i4; i5 < size2; i5++) {
                            int i6 = mutableIntList2.get(i2);
                            int i7 = mutableIntList2.get(i5);
                            if (i6 < i7 || (i7 == i6 && mutableIntList.get(i2) < mutableIntList.get(i5))) {
                                CompositionKt.swap(list, i2, i5);
                                CompositionKt.swap(mutableIntList, i2, i5);
                                CompositionKt.swap(mutableIntList2, i2, i5);
                            }
                        }
                        i2 = i4;
                    }
                    this.leaving.addAll(list);
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0068  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean observesAnyOf(java.util.Set<? extends java.lang.Object> r15) {
        /*
            r14 = this;
            boolean r0 = r15 instanceof androidx.compose.runtime.collection.ScatterSetWrapper
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x005c
            androidx.compose.runtime.collection.ScatterSetWrapper r15 = (androidx.compose.runtime.collection.ScatterSetWrapper) r15
            androidx.collection.ScatterSet r15 = r15.getSet$runtime_release()
            java.lang.Object[] r0 = r15.elements
            long[] r15 = r15.metadata
            int r3 = r15.length
            int r3 = r3 + -2
            if (r3 < 0) goto L_0x007d
            r4 = r1
        L_0x0016:
            r5 = r15[r4]
            long r7 = ~r5
            r9 = 7
            long r7 = r7 << r9
            long r7 = r7 & r5
            r9 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r7 = r7 & r9
            int r7 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r7 == 0) goto L_0x0057
            int r7 = r4 - r3
            int r7 = ~r7
            int r7 = r7 >>> 31
            r8 = 8
            int r7 = 8 - r7
            r9 = r1
        L_0x0030:
            if (r9 >= r7) goto L_0x0055
            r10 = 255(0xff, double:1.26E-321)
            long r10 = r10 & r5
            r12 = 128(0x80, double:6.32E-322)
            int r10 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r10 >= 0) goto L_0x0051
            int r10 = r4 << 3
            int r10 = r10 + r9
            r10 = r0[r10]
            androidx.compose.runtime.collection.ScopeMap<java.lang.Object, androidx.compose.runtime.RecomposeScopeImpl> r11 = r14.observations
            boolean r11 = r11.contains(r10)
            if (r11 != 0) goto L_0x0050
            androidx.compose.runtime.collection.ScopeMap<java.lang.Object, androidx.compose.runtime.DerivedState<?>> r11 = r14.derivedStates
            boolean r10 = r11.contains(r10)
            if (r10 == 0) goto L_0x0051
        L_0x0050:
            return r2
        L_0x0051:
            long r5 = r5 >> r8
            int r9 = r9 + 1
            goto L_0x0030
        L_0x0055:
            if (r7 != r8) goto L_0x007d
        L_0x0057:
            if (r4 == r3) goto L_0x007d
            int r4 = r4 + 1
            goto L_0x0016
        L_0x005c:
            java.lang.Iterable r15 = (java.lang.Iterable) r15
            java.util.Iterator r15 = r15.iterator()
        L_0x0062:
            boolean r0 = r15.hasNext()
            if (r0 == 0) goto L_0x007d
            java.lang.Object r0 = r15.next()
            androidx.compose.runtime.collection.ScopeMap<java.lang.Object, androidx.compose.runtime.RecomposeScopeImpl> r3 = r14.observations
            boolean r3 = r3.contains(r0)
            if (r3 != 0) goto L_0x007c
            androidx.compose.runtime.collection.ScopeMap<java.lang.Object, androidx.compose.runtime.DerivedState<?>> r3 = r14.derivedStates
            boolean r0 = r3.contains(r0)
            if (r0 == 0) goto L_0x0062
        L_0x007c:
            return r2
        L_0x007d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.CompositionImpl.observesAnyOf(java.util.Set):boolean");
    }

    private final void addPendingInvalidationsLocked(Set<? extends Object> set, boolean z) {
        char c;
        long j;
        long j2;
        long j3;
        String str;
        int i;
        long[] jArr;
        int i2;
        long j4;
        String str2;
        int i3;
        int i4;
        long[] jArr2;
        boolean z2;
        int i5;
        String str3;
        long[] jArr3;
        long j5;
        int i6;
        int i7;
        long[] jArr4;
        boolean z3;
        long j6;
        long[] jArr5;
        int i8;
        int i9;
        long[] jArr6;
        int i10;
        char c2;
        int i11;
        long[] jArr7;
        Set<? extends Object> set2 = set;
        boolean z4 = z;
        Object obj = null;
        int i12 = 8;
        if (set2 instanceof ScatterSetWrapper) {
            ScatterSet set$runtime_release = ((ScatterSetWrapper) set2).getSet$runtime_release();
            Object[] objArr = set$runtime_release.elements;
            long[] jArr8 = set$runtime_release.metadata;
            int length = jArr8.length - 2;
            if (length >= 0) {
                int i13 = 0;
                j3 = 128;
                j2 = 255;
                while (true) {
                    long j7 = jArr8[i13];
                    char c3 = 7;
                    j = -9187201950435737472L;
                    if ((((~j7) << 7) & j7 & -9187201950435737472L) != -9187201950435737472L) {
                        int i14 = 8 - ((~(i13 - length)) >>> 31);
                        int i15 = 0;
                        while (i15 < i14) {
                            if ((j7 & 255) < 128) {
                                Object obj2 = objArr[(i13 << 3) + i15];
                                c2 = c3;
                                if (obj2 instanceof RecomposeScopeImpl) {
                                    ((RecomposeScopeImpl) obj2).invalidateForResult(obj);
                                } else {
                                    addPendingInvalidationsLocked(obj2, z4);
                                    Object obj3 = this.derivedStates.getMap().get(obj2);
                                    if (obj3 != null) {
                                        if (obj3 instanceof MutableScatterSet) {
                                            ScatterSet scatterSet = (MutableScatterSet) obj3;
                                            Object[] objArr2 = scatterSet.elements;
                                            long[] jArr9 = scatterSet.metadata;
                                            int length2 = jArr9.length - 2;
                                            if (length2 >= 0) {
                                                i9 = i13;
                                                int i16 = 0;
                                                while (true) {
                                                    long j8 = jArr9[i16];
                                                    int i17 = i12;
                                                    i10 = length;
                                                    if ((((~j8) << c2) & j8 & -9187201950435737472L) != -9187201950435737472L) {
                                                        int i18 = 8 - ((~(i16 - length2)) >>> 31);
                                                        int i19 = 0;
                                                        while (i19 < i18) {
                                                            if ((j8 & 255) < 128) {
                                                                jArr7 = jArr8;
                                                                addPendingInvalidationsLocked((Object) (DerivedState) objArr2[(i16 << 3) + i19], z4);
                                                            } else {
                                                                jArr7 = jArr8;
                                                            }
                                                            j8 >>= i17;
                                                            i19++;
                                                            jArr8 = jArr7;
                                                        }
                                                        jArr6 = jArr8;
                                                        if (i18 != i17) {
                                                            break;
                                                        }
                                                    } else {
                                                        jArr6 = jArr8;
                                                    }
                                                    if (i16 == length2) {
                                                        break;
                                                    }
                                                    i16++;
                                                    length = i10;
                                                    jArr8 = jArr6;
                                                    i12 = 8;
                                                }
                                            }
                                        } else {
                                            jArr6 = jArr8;
                                            i9 = i13;
                                            i10 = length;
                                            addPendingInvalidationsLocked((Object) (DerivedState) obj3, z4);
                                        }
                                        i11 = 8;
                                    }
                                }
                                jArr6 = jArr8;
                                i9 = i13;
                                i10 = length;
                                i11 = 8;
                            } else {
                                jArr6 = jArr8;
                                i9 = i13;
                                c2 = c3;
                                i10 = length;
                                i11 = i12;
                            }
                            j7 >>= i11;
                            i15++;
                            i13 = i9;
                            i12 = i11;
                            c3 = c2;
                            length = i10;
                            jArr8 = jArr6;
                            obj = null;
                        }
                        jArr5 = jArr8;
                        int i20 = i13;
                        c = c3;
                        int i21 = length;
                        if (i14 != i12) {
                            break;
                        }
                        i8 = i20;
                        length = i21;
                    } else {
                        jArr5 = jArr8;
                        c = 7;
                        i8 = i13;
                    }
                    if (i8 == length) {
                        break;
                    }
                    i13 = i8 + 1;
                    jArr8 = jArr5;
                    obj = null;
                    i12 = 8;
                }
            } else {
                j3 = 128;
                j2 = 255;
                j = -9187201950435737472L;
                c = 7;
            }
        } else {
            j3 = 128;
            j2 = 255;
            j = -9187201950435737472L;
            c = 7;
            for (Object next : set2) {
                if (next instanceof RecomposeScopeImpl) {
                    ((RecomposeScopeImpl) next).invalidateForResult((Object) null);
                } else {
                    addPendingInvalidationsLocked(next, z4);
                    Object obj4 = this.derivedStates.getMap().get(next);
                    if (obj4 != null) {
                        if (obj4 instanceof MutableScatterSet) {
                            ScatterSet scatterSet2 = (MutableScatterSet) obj4;
                            Object[] objArr3 = scatterSet2.elements;
                            long[] jArr10 = scatterSet2.metadata;
                            int length3 = jArr10.length - 2;
                            if (length3 >= 0) {
                                int i22 = 0;
                                while (true) {
                                    long j9 = jArr10[i22];
                                    if ((((~j9) << 7) & j9 & -9187201950435737472L) != -9187201950435737472L) {
                                        int i23 = 8 - ((~(i22 - length3)) >>> 31);
                                        for (int i24 = 0; i24 < i23; i24++) {
                                            if ((j9 & 255) < 128) {
                                                addPendingInvalidationsLocked((Object) (DerivedState) objArr3[(i22 << 3) + i24], z4);
                                            }
                                            j9 >>= 8;
                                        }
                                        if (i23 != 8) {
                                            break;
                                        }
                                    }
                                    if (i22 == length3) {
                                        break;
                                    }
                                    i22++;
                                }
                            }
                        } else {
                            addPendingInvalidationsLocked((Object) (DerivedState) obj4, z4);
                        }
                    }
                }
            }
        }
        MutableScatterSet<RecomposeScopeImpl> mutableScatterSet = this.conditionallyInvalidatedScopes;
        MutableScatterSet<RecomposeScopeImpl> mutableScatterSet2 = this.invalidatedScopes;
        String str4 = "null cannot be cast to non-null type androidx.collection.MutableScatterSet<Scope of androidx.compose.runtime.collection.ScopeMap.removeScopeIf$lambda$2>";
        if (z4 && mutableScatterSet.isNotEmpty()) {
            MutableScatterMap<Object, Object> map = this.observations.getMap();
            long[] jArr11 = map.metadata;
            int length4 = jArr11.length - 2;
            if (length4 >= 0) {
                int i25 = 0;
                while (true) {
                    long j10 = jArr11[i25];
                    if ((((~j10) << c) & j10 & j) != j) {
                        int i26 = 8 - ((~(i25 - length4)) >>> 31);
                        int i27 = 0;
                        while (i27 < i26) {
                            if ((j10 & j2) < j3) {
                                int i28 = (i25 << 3) + i27;
                                Object obj5 = map.keys[i28];
                                Object obj6 = map.values[i28];
                                if (obj6 instanceof MutableScatterSet) {
                                    Intrinsics.checkNotNull(obj6, str4);
                                    MutableScatterSet mutableScatterSet3 = (MutableScatterSet) obj6;
                                    Object[] objArr4 = mutableScatterSet3.elements;
                                    jArr4 = jArr11;
                                    long[] jArr12 = mutableScatterSet3.metadata;
                                    j5 = j10;
                                    int length5 = jArr12.length - 2;
                                    if (length5 >= 0) {
                                        long[] jArr13 = jArr12;
                                        i7 = length4;
                                        int i29 = 0;
                                        while (true) {
                                            long j11 = jArr13[i29];
                                            i6 = i26;
                                            Object[] objArr5 = objArr4;
                                            if ((((~j11) << c) & j11 & j) != j) {
                                                int i30 = 8 - ((~(i29 - length5)) >>> 31);
                                                int i31 = 0;
                                                while (i31 < i30) {
                                                    if ((j11 & j2) < j3) {
                                                        j6 = j11;
                                                        int i32 = (i29 << 3) + i31;
                                                        RecomposeScopeImpl recomposeScopeImpl = (RecomposeScopeImpl) objArr5[i32];
                                                        if (mutableScatterSet.contains(recomposeScopeImpl) || mutableScatterSet2.contains(recomposeScopeImpl)) {
                                                            mutableScatterSet3.removeElementAt(i32);
                                                        }
                                                    } else {
                                                        j6 = j11;
                                                    }
                                                    i31++;
                                                    j11 = j6 >> 8;
                                                }
                                                if (i30 != 8) {
                                                    break;
                                                }
                                            }
                                            if (i29 == length5) {
                                                break;
                                            }
                                            i29++;
                                            i26 = i6;
                                            objArr4 = objArr5;
                                        }
                                    } else {
                                        i7 = length4;
                                        i6 = i26;
                                    }
                                    z3 = mutableScatterSet3.isEmpty();
                                } else {
                                    jArr4 = jArr11;
                                    i7 = length4;
                                    j5 = j10;
                                    i6 = i26;
                                    Intrinsics.checkNotNull(obj6, "null cannot be cast to non-null type Scope of androidx.compose.runtime.collection.ScopeMap.removeScopeIf$lambda$2");
                                    RecomposeScopeImpl recomposeScopeImpl2 = (RecomposeScopeImpl) obj6;
                                    z3 = mutableScatterSet.contains(recomposeScopeImpl2) || mutableScatterSet2.contains(recomposeScopeImpl2);
                                }
                                if (z3) {
                                    map.removeValueAt(i28);
                                }
                            } else {
                                jArr4 = jArr11;
                                i7 = length4;
                                j5 = j10;
                                i6 = i26;
                            }
                            j10 = j5 >> 8;
                            i27++;
                            jArr11 = jArr4;
                            length4 = i7;
                            i26 = i6;
                        }
                        jArr3 = jArr11;
                        int i33 = length4;
                        if (i26 != 8) {
                            break;
                        }
                        length4 = i33;
                    } else {
                        jArr3 = jArr11;
                    }
                    if (i25 == length4) {
                        break;
                    }
                    i25++;
                    jArr11 = jArr3;
                }
            }
            mutableScatterSet.clear();
            cleanUpDerivedStateObservations();
        } else if (mutableScatterSet2.isNotEmpty()) {
            MutableScatterMap<Object, Object> map2 = this.observations.getMap();
            long[] jArr14 = map2.metadata;
            int length6 = jArr14.length - 2;
            if (length6 >= 0) {
                int i34 = 0;
                while (true) {
                    long j12 = jArr14[i34];
                    if ((((~j12) << c) & j12 & j) != j) {
                        int i35 = 8 - ((~(i34 - length6)) >>> 31);
                        int i36 = 0;
                        while (i36 < i35) {
                            if ((j12 & j2) < j3) {
                                int i37 = (i34 << 3) + i36;
                                Object obj7 = map2.keys[i37];
                                Object obj8 = map2.values[i37];
                                if (obj8 instanceof MutableScatterSet) {
                                    Intrinsics.checkNotNull(obj8, str4);
                                    MutableScatterSet mutableScatterSet4 = (MutableScatterSet) obj8;
                                    Object[] objArr6 = mutableScatterSet4.elements;
                                    long[] jArr15 = mutableScatterSet4.metadata;
                                    int length7 = jArr15.length - 2;
                                    jArr2 = jArr14;
                                    if (length7 >= 0) {
                                        j4 = j12;
                                        int i38 = 0;
                                        while (true) {
                                            long j13 = jArr15[i38];
                                            i4 = length6;
                                            i3 = i34;
                                            if ((((~j13) << c) & j13 & j) != j) {
                                                int i39 = 8 - ((~(i38 - length7)) >>> 31);
                                                int i40 = 0;
                                                while (i40 < i39) {
                                                    if ((j13 & j2) < j3) {
                                                        str3 = str4;
                                                        int i41 = (i38 << 3) + i40;
                                                        i5 = i40;
                                                        if (mutableScatterSet2.contains((RecomposeScopeImpl) objArr6[i41])) {
                                                            mutableScatterSet4.removeElementAt(i41);
                                                        }
                                                    } else {
                                                        str3 = str4;
                                                        i5 = i40;
                                                    }
                                                    j13 >>= 8;
                                                    i40 = i5 + 1;
                                                    str4 = str3;
                                                }
                                                str2 = str4;
                                                if (i39 != 8) {
                                                    break;
                                                }
                                            } else {
                                                str2 = str4;
                                            }
                                            if (i38 == length7) {
                                                break;
                                            }
                                            i38++;
                                            length6 = i4;
                                            i34 = i3;
                                            str4 = str2;
                                        }
                                    } else {
                                        str2 = str4;
                                        i4 = length6;
                                        i3 = i34;
                                        j4 = j12;
                                    }
                                    z2 = mutableScatterSet4.isEmpty();
                                } else {
                                    jArr2 = jArr14;
                                    str2 = str4;
                                    i4 = length6;
                                    i3 = i34;
                                    j4 = j12;
                                    Intrinsics.checkNotNull(obj8, "null cannot be cast to non-null type Scope of androidx.compose.runtime.collection.ScopeMap.removeScopeIf$lambda$2");
                                    z2 = mutableScatterSet2.contains((RecomposeScopeImpl) obj8);
                                }
                                if (z2) {
                                    map2.removeValueAt(i37);
                                }
                            } else {
                                jArr2 = jArr14;
                                str2 = str4;
                                i4 = length6;
                                i3 = i34;
                                j4 = j12;
                            }
                            j12 = j4 >> 8;
                            i36++;
                            jArr14 = jArr2;
                            length6 = i4;
                            i34 = i3;
                            str4 = str2;
                        }
                        jArr = jArr14;
                        str = str4;
                        i = length6;
                        int i42 = i34;
                        if (i35 != 8) {
                            break;
                        }
                        i2 = i42;
                    } else {
                        jArr = jArr14;
                        str = str4;
                        i = length6;
                        i2 = i34;
                    }
                    int i43 = i;
                    if (i2 == i43) {
                        break;
                    }
                    i34 = i2 + 1;
                    length6 = i43;
                    jArr14 = jArr;
                    str4 = str;
                }
            }
            cleanUpDerivedStateObservations();
            mutableScatterSet2.clear();
        }
    }

    public void insertMovableContent(List<Pair<MovableContentStateReference, MovableContentStateReference>> list) {
        int size = list.size();
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= size) {
                z = true;
                break;
            } else if (!Intrinsics.areEqual((Object) ((MovableContentStateReference) list.get(i).getFirst()).getComposition$runtime_release(), (Object) this)) {
                break;
            } else {
                i++;
            }
        }
        ComposerKt.runtimeCheck(z);
        try {
            this.composer.insertMovableContentReferences(list);
            Unit unit = Unit.INSTANCE;
        } catch (Exception e) {
            abandonChanges();
            throw e;
        } catch (Throwable th) {
            if (!this.abandonSet.isEmpty()) {
                new RememberEventDispatcher(this.abandonSet).dispatchAbandons();
            }
            throw th;
        }
    }

    private final <T> T guardChanges(Function0<? extends T> function0) {
        try {
            return function0.invoke();
        } catch (Exception e) {
            abandonChanges();
            throw e;
        } catch (Throwable th) {
            if (!this.abandonSet.isEmpty()) {
                new RememberEventDispatcher(this.abandonSet).dispatchAbandons();
            }
            throw th;
        }
    }
}
