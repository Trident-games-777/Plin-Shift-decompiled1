package androidx.compose.runtime;

import androidx.collection.MutableScatterSet;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.collection.ScatterSetWrapperKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet;
import androidx.compose.runtime.snapshots.MutableSnapshot;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.SnapshotApplyResult;
import androidx.compose.runtime.tooling.CompositionData;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.Result;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

@Metadata(d1 = {"\u0000\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010#\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u0000 ½\u00012\u00020\u0001:\n½\u0001¾\u0001¿\u0001À\u0001Á\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010`\u001a\u00020_2\u0006\u0010a\u001a\u00020\u0007H\u0002J\u0010\u0010b\u001a\u00020_2\u0006\u0010c\u001a\u00020dH\u0002J\u0006\u0010e\u001a\u00020fJ\u000e\u0010g\u001a\u00020_H@¢\u0006\u0002\u0010hJ\u000e\u0010i\u001a\u00020_H@¢\u0006\u0002\u0010hJ\u0006\u0010j\u001a\u00020_J\b\u0010k\u001a\u00020_H\u0002J\u0006\u0010l\u001a\u00020_J*\u0010m\u001a\u00020_2\u0006\u0010a\u001a\u00020\u00072\u0011\u0010n\u001a\r\u0012\u0004\u0012\u00020_0o¢\u0006\u0002\bpH\u0010¢\u0006\u0004\bq\u0010rJ:\u0010s\u001a\u0002Ht\"\u0004\b\u0000\u0010t2\u0006\u0010a\u001a\u00020\u00072\u000e\u0010u\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010U2\f\u0010v\u001a\b\u0012\u0004\u0012\u0002Ht0oH\b¢\u0006\u0002\u0010wJ\u0015\u0010x\u001a\u00020_2\u0006\u0010y\u001a\u00020\"H\u0010¢\u0006\u0002\bzJ\u0010\u0010{\u001a\n\u0012\u0004\u0012\u00020_\u0018\u00010^H\u0002J\b\u0010|\u001a\u00020_H\u0002J\u0015\u0010}\u001a\u00020_2\u0006\u0010y\u001a\u00020\"H\u0010¢\u0006\u0002\b~J\u0016\u0010\u001a\u00020_2\u0006\u0010a\u001a\u00020\u0007H\u0010¢\u0006\u0003\b\u0001J\u0019\u0010\u0001\u001a\u00020_2\b\u0010\u0001\u001a\u00030\u0001H\u0010¢\u0006\u0003\b\u0001J\u000f\u0010\u0001\u001a\u00020_H@¢\u0006\u0002\u0010hJ \u0010\u0001\u001a\u00020_2\u0006\u0010y\u001a\u00020\"2\u0007\u0010\u0001\u001a\u00020#H\u0010¢\u0006\u0003\b\u0001J\u0019\u0010\u0001\u001a\u0004\u0018\u00010#2\u0006\u0010y\u001a\u00020\"H\u0010¢\u0006\u0003\b\u0001J\u0007\u0010\u0001\u001a\u00020_J\u0011\u0010\u0001\u001a\u00020_2\u0006\u0010a\u001a\u00020\u0007H\u0002J.\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\u00070\t2\r\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\"0\t2\u000e\u0010u\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010UH\u0002J#\u0010\u0001\u001a\u0004\u0018\u00010\u00072\u0006\u0010a\u001a\u00020\u00072\u000e\u0010u\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010UH\u0002J0\u0010\u0001\u001a\u00020_2\r\u0010\u0001\u001a\b0\u0001j\u0003`\u00012\u000b\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010\u00072\t\b\u0002\u0010\u0001\u001a\u00020\u0017H\u0002J\u001e\u0010\u0001\u001a\u000f\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020_0\u00012\u0006\u0010a\u001a\u00020\u0007H\u0002JV\u0010\u0001\u001a\u00020_2D\u0010v\u001a@\b\u0001\u0012\u0005\u0012\u00030\u0001\u0012\u0017\u0012\u00150\u0001¢\u0006\u000f\b\u0001\u0012\n\b\u0001\u0012\u0005\b\b(\u0001\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020_0\u0001\u0012\u0006\u0012\u0004\u0018\u00010'0\u0001¢\u0006\u0003\b \u0001H@¢\u0006\u0003\u0010¡\u0001J\t\u0010¢\u0001\u001a\u00020\u0017H\u0002J \u0010¢\u0001\u001a\u00020_2\u0014\u0010£\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020_0\u0001H\bJ\u0011\u0010¤\u0001\u001a\u00020_2\u0006\u0010a\u001a\u00020\u0007H\u0002J\u001f\u0010¥\u0001\u001a\u00020_2\u000e\u0010¦\u0001\u001a\t\u0012\u0005\u0012\u00030§\u00010*H\u0010¢\u0006\u0003\b¨\u0001J\u0017\u0010©\u0001\u001a\u00020_2\u0006\u0010a\u001a\u00020\u0007H\u0010¢\u0006\u0003\bª\u0001J\u0012\u0010«\u0001\u001a\u00020_2\u0007\u0010¬\u0001\u001a\u00020QH\u0002J\u0011\u0010­\u0001\u001a\u00020_2\u0006\u0010a\u001a\u00020\u0007H\u0002J\u0017\u0010®\u0001\u001a\u00020_2\u0006\u0010a\u001a\u00020\u0007H\u0010¢\u0006\u0003\b¯\u0001J\u000b\u0010°\u0001\u001a\u0004\u0018\u000109H\u0002J\u0007\u0010±\u0001\u001a\u00020_J\t\u0010²\u0001\u001a\u00020_H\u0002J$\u0010³\u0001\u001a\u00020_2\b\u0010\u0001\u001a\u00030\u00012\b\u0010´\u0001\u001a\u00030µ\u0001H@¢\u0006\u0003\u0010¶\u0001J\u000f\u0010·\u0001\u001a\u00020_H@¢\u0006\u0002\u0010hJ\u0018\u0010¸\u0001\u001a\u00020_2\u0006\u0010L\u001a\u00020\u0003H@¢\u0006\u0003\u0010¹\u0001J\u0017\u0010º\u0001\u001a\u00020_2\u0006\u0010a\u001a\u00020\u0007H\u0010¢\u0006\u0003\b»\u0001J.\u0010¼\u0001\u001a\u000f\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020_0\u00012\u0006\u0010a\u001a\u00020\u00072\u000e\u0010u\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010UH\u0002R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0010@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u00020\u00178PX\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u00178PX\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0019R\u0014\u0010\u001c\u001a\u00020\u00178PX\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0019R\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00070\u001fX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020#0!X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010$\u001a\b\u0012\u0004\u0012\u00020\"0\u0006X\u0004¢\u0006\u0002\n\u0000R(\u0010%\u001a\u001c\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010'0&\u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0\u00060!X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010)\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010*X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010+\u001a\u00020,8PX\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.R\u000e\u0010/\u001a\u00020,X\u000e¢\u0006\u0002\n\u0000R\u0017\u00100\u001a\b\u0012\u0004\u0012\u00020\f018F¢\u0006\u0006\u001a\u0004\b2\u00103R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u00105R\u000e\u00106\u001a\u000207X\u0004¢\u0006\u0002\n\u0000R\u0010\u00108\u001a\u0004\u0018\u000109X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010:\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010<\u001a\u00020\u00178BX\u0004¢\u0006\u0006\u001a\u0004\b=\u0010\u0019R\u0014\u0010>\u001a\u00020\u00178BX\u0004¢\u0006\u0006\u001a\u0004\b?\u0010\u0019R\u0014\u0010@\u001a\u00020\u00178BX\u0004¢\u0006\u0006\u001a\u0004\bA\u0010\u0019R\u0014\u0010B\u001a\u00020\u00178BX\u0004¢\u0006\u0006\u001a\u0004\bC\u0010\u0019R\u0011\u0010D\u001a\u00020\u00178F¢\u0006\u0006\u001a\u0004\bE\u0010\u0019R\u0014\u0010F\u001a\u00020\u00178BX\u0004¢\u0006\u0006\u001a\u0004\bG\u0010\u0019R\u000e\u0010H\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010I\u001a\b\u0012\u0004\u0012\u00020\u00070\t8BX\u0004¢\u0006\u0006\u001a\u0004\bJ\u0010KR\u0014\u0010L\u001a\u00020\u00038PX\u0004¢\u0006\u0006\u001a\u0004\bM\u00105R\u0012\u0010N\u001a\u00060OR\u00020\u0000X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010P\u001a\u0004\u0018\u00010QX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010R\u001a\u00020\u00178BX\u0004¢\u0006\u0006\u001a\u0004\bS\u0010\u0019R\u0014\u0010T\u001a\b\u0012\u0004\u0012\u00020'0UX\u000e¢\u0006\u0002\n\u0000R \u0010V\u001a\b\u0012\u0004\u0012\u00020\f0W8FX\u0004¢\u0006\f\u0012\u0004\bX\u0010Y\u001a\u0004\bZ\u0010[R\u000e\u0010\\\u001a\u00020'X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010]\u001a\n\u0012\u0004\u0012\u00020_\u0018\u00010^X\u000e¢\u0006\u0002\n\u0000¨\u0006Â\u0001"}, d2 = {"Landroidx/compose/runtime/Recomposer;", "Landroidx/compose/runtime/CompositionContext;", "effectCoroutineContext", "Lkotlin/coroutines/CoroutineContext;", "(Lkotlin/coroutines/CoroutineContext;)V", "_knownCompositions", "", "Landroidx/compose/runtime/ControlledComposition;", "_knownCompositionsCache", "", "_state", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Landroidx/compose/runtime/Recomposer$State;", "broadcastFrameClock", "Landroidx/compose/runtime/BroadcastFrameClock;", "<set-?>", "", "changeCount", "getChangeCount", "()J", "closeCause", "", "collectingCallByInformation", "", "getCollectingCallByInformation$runtime_release", "()Z", "collectingParameterInformation", "getCollectingParameterInformation$runtime_release", "collectingSourceInformation", "getCollectingSourceInformation$runtime_release", "compositionInvalidations", "Landroidx/compose/runtime/collection/MutableVector;", "compositionValueStatesAvailable", "", "Landroidx/compose/runtime/MovableContentStateReference;", "Landroidx/compose/runtime/MovableContentState;", "compositionValuesAwaitingInsert", "compositionValuesRemoved", "Landroidx/compose/runtime/MovableContent;", "", "compositionsAwaitingApply", "compositionsRemoved", "", "compoundHashKey", "", "getCompoundHashKey$runtime_release", "()I", "concurrentCompositionsOutstanding", "currentState", "Lkotlinx/coroutines/flow/StateFlow;", "getCurrentState", "()Lkotlinx/coroutines/flow/StateFlow;", "getEffectCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "effectJob", "Lkotlinx/coroutines/CompletableJob;", "errorState", "Landroidx/compose/runtime/Recomposer$RecomposerErrorState;", "failedCompositions", "frameClockPaused", "hasBroadcastFrameClockAwaiters", "getHasBroadcastFrameClockAwaiters", "hasBroadcastFrameClockAwaitersLocked", "getHasBroadcastFrameClockAwaitersLocked", "hasConcurrentFrameWorkLocked", "getHasConcurrentFrameWorkLocked", "hasFrameWorkLocked", "getHasFrameWorkLocked", "hasPendingWork", "getHasPendingWork", "hasSchedulingWork", "getHasSchedulingWork", "isClosed", "knownCompositions", "getKnownCompositions", "()Ljava/util/List;", "recomposeCoroutineContext", "getRecomposeCoroutineContext$runtime_release", "recomposerInfo", "Landroidx/compose/runtime/Recomposer$RecomposerInfoImpl;", "runnerJob", "Lkotlinx/coroutines/Job;", "shouldKeepRecomposing", "getShouldKeepRecomposing", "snapshotInvalidations", "Landroidx/collection/MutableScatterSet;", "state", "Lkotlinx/coroutines/flow/Flow;", "getState$annotations", "()V", "getState", "()Lkotlinx/coroutines/flow/Flow;", "stateLock", "workContinuation", "Lkotlinx/coroutines/CancellableContinuation;", "", "addKnownCompositionLocked", "composition", "applyAndCheck", "snapshot", "Landroidx/compose/runtime/snapshots/MutableSnapshot;", "asRecomposerInfo", "Landroidx/compose/runtime/RecomposerInfo;", "awaitIdle", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitWorkAvailable", "cancel", "clearKnownCompositionsLocked", "close", "composeInitial", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "composeInitial$runtime_release", "(Landroidx/compose/runtime/ControlledComposition;Lkotlin/jvm/functions/Function2;)V", "composing", "T", "modifiedValues", "block", "(Landroidx/compose/runtime/ControlledComposition;Landroidx/collection/MutableScatterSet;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "deletedMovableContent", "reference", "deletedMovableContent$runtime_release", "deriveStateLocked", "discardUnusedValues", "insertMovableContent", "insertMovableContent$runtime_release", "invalidate", "invalidate$runtime_release", "invalidateScope", "scope", "Landroidx/compose/runtime/RecomposeScopeImpl;", "invalidateScope$runtime_release", "join", "movableContentStateReleased", "data", "movableContentStateReleased$runtime_release", "movableContentStateResolve", "movableContentStateResolve$runtime_release", "pauseCompositionFrameClock", "performInitialMovableContentInserts", "performInsertValues", "references", "performRecompose", "processCompositionError", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "failedInitialComposition", "recoverable", "readObserverOf", "Lkotlin/Function1;", "recompositionRunner", "Lkotlin/Function3;", "Lkotlinx/coroutines/CoroutineScope;", "Landroidx/compose/runtime/MonotonicFrameClock;", "Lkotlin/ParameterName;", "name", "parentFrameClock", "Lkotlin/coroutines/Continuation;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "recordComposerModifications", "onEachInvalidComposition", "recordFailedCompositionLocked", "recordInspectionTable", "table", "Landroidx/compose/runtime/tooling/CompositionData;", "recordInspectionTable$runtime_release", "registerComposition", "registerComposition$runtime_release", "registerRunnerJob", "callingJob", "removeKnownCompositionLocked", "reportRemovedComposition", "reportRemovedComposition$runtime_release", "resetErrorState", "resumeCompositionFrameClock", "retryFailedCompositions", "runFrameLoop", "frameSignal", "Landroidx/compose/runtime/ProduceFrameSignal;", "(Landroidx/compose/runtime/MonotonicFrameClock;Landroidx/compose/runtime/ProduceFrameSignal;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "runRecomposeAndApplyChanges", "runRecomposeConcurrentlyAndApplyChanges", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unregisterComposition", "unregisterComposition$runtime_release", "writeObserverOf", "Companion", "HotReloadable", "RecomposerErrorState", "RecomposerInfoImpl", "State", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Recomposer.kt */
public final class Recomposer extends CompositionContext {
    public static final int $stable = 8;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final AtomicReference<Boolean> _hotReloadEnabled = new AtomicReference<>(false);
    /* access modifiers changed from: private */
    public static final MutableStateFlow<PersistentSet<RecomposerInfoImpl>> _runningRecomposers = StateFlowKt.MutableStateFlow(ExtensionsKt.persistentSetOf());
    private final List<ControlledComposition> _knownCompositions = new ArrayList();
    private List<? extends ControlledComposition> _knownCompositionsCache;
    /* access modifiers changed from: private */
    public final MutableStateFlow<State> _state = StateFlowKt.MutableStateFlow(State.Inactive);
    /* access modifiers changed from: private */
    public final BroadcastFrameClock broadcastFrameClock;
    /* access modifiers changed from: private */
    public long changeCount;
    /* access modifiers changed from: private */
    public Throwable closeCause;
    /* access modifiers changed from: private */
    public final MutableVector<ControlledComposition> compositionInvalidations = new MutableVector<>(new ControlledComposition[16], 0);
    private final Map<MovableContentStateReference, MovableContentState> compositionValueStatesAvailable = new LinkedHashMap();
    /* access modifiers changed from: private */
    public final List<MovableContentStateReference> compositionValuesAwaitingInsert = new ArrayList();
    private final Map<MovableContent<Object>, List<MovableContentStateReference>> compositionValuesRemoved = new LinkedHashMap();
    /* access modifiers changed from: private */
    public final List<ControlledComposition> compositionsAwaitingApply = new ArrayList();
    /* access modifiers changed from: private */
    public Set<ControlledComposition> compositionsRemoved;
    /* access modifiers changed from: private */
    public int concurrentCompositionsOutstanding;
    private final CoroutineContext effectCoroutineContext;
    private final CompletableJob effectJob;
    /* access modifiers changed from: private */
    public RecomposerErrorState errorState;
    private List<ControlledComposition> failedCompositions;
    private boolean frameClockPaused;
    /* access modifiers changed from: private */
    public boolean isClosed;
    /* access modifiers changed from: private */
    public final RecomposerInfoImpl recomposerInfo;
    /* access modifiers changed from: private */
    public Job runnerJob;
    /* access modifiers changed from: private */
    public MutableScatterSet<Object> snapshotInvalidations = new MutableScatterSet<>(0, 1, (DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public final Object stateLock = new Object();
    /* access modifiers changed from: private */
    public CancellableContinuation<? super Unit> workContinuation;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Landroidx/compose/runtime/Recomposer$State;", "", "(Ljava/lang/String;I)V", "ShutDown", "ShuttingDown", "Inactive", "InactivePendingWork", "Idle", "PendingWork", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: Recomposer.kt */
    public enum State {
        ShutDown,
        ShuttingDown,
        Inactive,
        InactivePendingWork,
        Idle,
        PendingWork
    }

    @Deprecated(message = "Replaced by currentState as a StateFlow", replaceWith = @ReplaceWith(expression = "currentState", imports = {}))
    public static /* synthetic */ void getState$annotations() {
    }

    public boolean getCollectingParameterInformation$runtime_release() {
        return false;
    }

    public boolean getCollectingSourceInformation$runtime_release() {
        return false;
    }

    public int getCompoundHashKey$runtime_release() {
        return 1000;
    }

    public void recordInspectionTable$runtime_release(Set<CompositionData> set) {
    }

    public void registerComposition$runtime_release(ControlledComposition controlledComposition) {
    }

    public Recomposer(CoroutineContext coroutineContext) {
        BroadcastFrameClock broadcastFrameClock2 = new BroadcastFrameClock(new Recomposer$broadcastFrameClock$1(this));
        this.broadcastFrameClock = broadcastFrameClock2;
        CompletableJob Job = JobKt.Job((Job) coroutineContext.get(Job.Key));
        Job.invokeOnCompletion(new Recomposer$effectJob$1$1(this));
        this.effectJob = Job;
        this.effectCoroutineContext = coroutineContext.plus(broadcastFrameClock2).plus(Job);
        this.recomposerInfo = new RecomposerInfoImpl();
    }

    public final long getChangeCount() {
        return this.changeCount;
    }

    /* access modifiers changed from: private */
    public final List<ControlledComposition> getKnownCompositions() {
        List<? extends ControlledComposition> list = this._knownCompositionsCache;
        if (list == null) {
            Recomposer recomposer = this;
            List<ControlledComposition> list2 = this._knownCompositions;
            list = list2.isEmpty() ? CollectionsKt.emptyList() : new ArrayList<>(list2);
            this._knownCompositionsCache = list;
        }
        return list;
    }

    public CoroutineContext getEffectCoroutineContext() {
        return this.effectCoroutineContext;
    }

    public CoroutineContext getRecomposeCoroutineContext$runtime_release() {
        return EmptyCoroutineContext.INSTANCE;
    }

    private final boolean getHasBroadcastFrameClockAwaitersLocked() {
        return !this.frameClockPaused && this.broadcastFrameClock.getHasAwaiters();
    }

    /* access modifiers changed from: private */
    public final boolean getHasBroadcastFrameClockAwaiters() {
        boolean hasBroadcastFrameClockAwaitersLocked;
        synchronized (this.stateLock) {
            hasBroadcastFrameClockAwaitersLocked = getHasBroadcastFrameClockAwaitersLocked();
        }
        return hasBroadcastFrameClockAwaitersLocked;
    }

    /* access modifiers changed from: private */
    public final CancellableContinuation<Unit> deriveStateLocked() {
        State state;
        if (this._state.getValue().compareTo(State.ShuttingDown) <= 0) {
            clearKnownCompositionsLocked();
            this.snapshotInvalidations = new MutableScatterSet<>(0, 1, (DefaultConstructorMarker) null);
            this.compositionInvalidations.clear();
            this.compositionsAwaitingApply.clear();
            this.compositionValuesAwaitingInsert.clear();
            this.failedCompositions = null;
            CancellableContinuation<? super Unit> cancellableContinuation = this.workContinuation;
            if (cancellableContinuation != null) {
                CancellableContinuation.DefaultImpls.cancel$default(cancellableContinuation, (Throwable) null, 1, (Object) null);
            }
            this.workContinuation = null;
            this.errorState = null;
            return null;
        }
        if (this.errorState != null) {
            state = State.Inactive;
        } else if (this.runnerJob == null) {
            this.snapshotInvalidations = new MutableScatterSet<>(0, 1, (DefaultConstructorMarker) null);
            this.compositionInvalidations.clear();
            if (getHasBroadcastFrameClockAwaitersLocked()) {
                state = State.InactivePendingWork;
            } else {
                state = State.Inactive;
            }
        } else if (this.compositionInvalidations.isNotEmpty() || this.snapshotInvalidations.isNotEmpty() || !this.compositionsAwaitingApply.isEmpty() || !this.compositionValuesAwaitingInsert.isEmpty() || this.concurrentCompositionsOutstanding > 0 || getHasBroadcastFrameClockAwaitersLocked()) {
            state = State.PendingWork;
        } else {
            state = State.Idle;
        }
        this._state.setValue(state);
        if (state != State.PendingWork) {
            return null;
        }
        CancellableContinuation<? super Unit> cancellableContinuation2 = this.workContinuation;
        this.workContinuation = null;
        return cancellableContinuation2;
    }

    /* access modifiers changed from: private */
    public final boolean getShouldKeepRecomposing() {
        boolean z;
        synchronized (this.stateLock) {
            z = this.isClosed;
        }
        if (!z) {
            return true;
        }
        for (Job isActive : this.effectJob.getChildren()) {
            if (isActive.isActive()) {
                return true;
            }
        }
        return false;
    }

    public final Flow<State> getState() {
        return getCurrentState();
    }

    public final StateFlow<State> getCurrentState() {
        return this._state;
    }

    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019J\u0006\u0010\u001a\u001a\u00020\u0015J\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cR\u0014\u0010\u0003\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\f8VX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108VX\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001e"}, d2 = {"Landroidx/compose/runtime/Recomposer$RecomposerInfoImpl;", "Landroidx/compose/runtime/RecomposerInfo;", "(Landroidx/compose/runtime/Recomposer;)V", "changeCount", "", "getChangeCount", "()J", "currentError", "Landroidx/compose/runtime/RecomposerErrorInfo;", "getCurrentError", "()Landroidx/compose/runtime/RecomposerErrorInfo;", "hasPendingWork", "", "getHasPendingWork", "()Z", "state", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/compose/runtime/Recomposer$State;", "getState", "()Lkotlinx/coroutines/flow/Flow;", "invalidateGroupsWithKey", "", "key", "", "resetErrorState", "Landroidx/compose/runtime/Recomposer$RecomposerErrorState;", "retryFailedCompositions", "saveStateAndDisposeForHotReload", "", "Landroidx/compose/runtime/Recomposer$HotReloadable;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: Recomposer.kt */
    private final class RecomposerInfoImpl implements RecomposerInfo {
        public RecomposerInfoImpl() {
        }

        public Flow<State> getState() {
            return Recomposer.this.getCurrentState();
        }

        public boolean getHasPendingWork() {
            return Recomposer.this.getHasPendingWork();
        }

        public long getChangeCount() {
            return Recomposer.this.getChangeCount();
        }

        public final RecomposerErrorInfo getCurrentError() {
            RecomposerErrorState access$getErrorState$p;
            Object access$getStateLock$p = Recomposer.this.stateLock;
            Recomposer recomposer = Recomposer.this;
            synchronized (access$getStateLock$p) {
                access$getErrorState$p = recomposer.errorState;
            }
            return access$getErrorState$p;
        }

        public final void invalidateGroupsWithKey(int i) {
            List access$getKnownCompositions;
            Object access$getStateLock$p = Recomposer.this.stateLock;
            Recomposer recomposer = Recomposer.this;
            synchronized (access$getStateLock$p) {
                access$getKnownCompositions = recomposer.getKnownCompositions();
            }
            ArrayList arrayList = new ArrayList(access$getKnownCompositions.size());
            int size = access$getKnownCompositions.size();
            for (int i2 = 0; i2 < size; i2++) {
                ControlledComposition controlledComposition = (ControlledComposition) access$getKnownCompositions.get(i2);
                CompositionImpl compositionImpl = controlledComposition instanceof CompositionImpl ? (CompositionImpl) controlledComposition : null;
                if (compositionImpl != null) {
                    arrayList.add(compositionImpl);
                }
            }
            List list = arrayList;
            int size2 = list.size();
            for (int i3 = 0; i3 < size2; i3++) {
                ((CompositionImpl) list.get(i3)).invalidateGroupsWithKey(i);
            }
        }

        public final List<HotReloadable> saveStateAndDisposeForHotReload() {
            List access$getKnownCompositions;
            Object access$getStateLock$p = Recomposer.this.stateLock;
            Recomposer recomposer = Recomposer.this;
            synchronized (access$getStateLock$p) {
                access$getKnownCompositions = recomposer.getKnownCompositions();
            }
            ArrayList arrayList = new ArrayList(access$getKnownCompositions.size());
            int size = access$getKnownCompositions.size();
            for (int i = 0; i < size; i++) {
                ControlledComposition controlledComposition = (ControlledComposition) access$getKnownCompositions.get(i);
                CompositionImpl compositionImpl = controlledComposition instanceof CompositionImpl ? (CompositionImpl) controlledComposition : null;
                if (compositionImpl != null) {
                    arrayList.add(compositionImpl);
                }
            }
            List list = arrayList;
            ArrayList arrayList2 = new ArrayList(list.size());
            int size2 = list.size();
            for (int i2 = 0; i2 < size2; i2++) {
                HotReloadable hotReloadable = new HotReloadable((CompositionImpl) list.get(i2));
                hotReloadable.clearContent();
                arrayList2.add(hotReloadable);
            }
            return arrayList2;
        }

        public final RecomposerErrorState resetErrorState() {
            return Recomposer.this.resetErrorState();
        }

        public final void retryFailedCompositions() {
            Recomposer.this.retryFailedCompositions();
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\n\u001a\u00020\u0007J\u0006\u0010\u000b\u001a\u00020\u0007J\u0006\u0010\f\u001a\u00020\u0007R\u001b\u0010\u0005\u001a\r\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\bX\u000e¢\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Landroidx/compose/runtime/Recomposer$HotReloadable;", "", "composition", "Landroidx/compose/runtime/CompositionImpl;", "(Landroidx/compose/runtime/CompositionImpl;)V", "composable", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "Lkotlin/jvm/functions/Function2;", "clearContent", "recompose", "resetContent", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: Recomposer.kt */
    private static final class HotReloadable {
        private Function2<? super Composer, ? super Integer, Unit> composable;
        private final CompositionImpl composition;

        public HotReloadable(CompositionImpl compositionImpl) {
            this.composition = compositionImpl;
            this.composable = compositionImpl.getComposable();
        }

        public final void clearContent() {
            if (this.composition.isRoot()) {
                this.composition.setContent(ComposableSingletons$RecomposerKt.INSTANCE.m3641getLambda1$runtime_release());
            }
        }

        public final void resetContent() {
            this.composition.setComposable(this.composable);
        }

        public final void recompose() {
            if (this.composition.isRoot()) {
                this.composition.setContent(this.composable);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006¢\u0006\u0002\u0010\u0007R\u0018\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Landroidx/compose/runtime/Recomposer$RecomposerErrorState;", "Landroidx/compose/runtime/RecomposerErrorInfo;", "recoverable", "", "cause", "Ljava/lang/Exception;", "Lkotlin/Exception;", "(ZLjava/lang/Exception;)V", "getCause", "()Ljava/lang/Exception;", "getRecoverable", "()Z", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: Recomposer.kt */
    private static final class RecomposerErrorState implements RecomposerErrorInfo {
        private final Exception cause;
        private final boolean recoverable;

        public RecomposerErrorState(boolean z, Exception exc) {
            this.recoverable = z;
            this.cause = exc;
        }

        public boolean getRecoverable() {
            return this.recoverable;
        }

        public Exception getCause() {
            return this.cause;
        }
    }

    public final RecomposerInfo asRecomposerInfo() {
        return this.recomposerInfo;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0024, code lost:
        r0 = r9.stateLock;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0026, code lost:
        monitor-enter(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        r2 = getKnownCompositions();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002b, code lost:
        monitor-exit(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        r0 = r9;
        r0 = r2.size();
        r6 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0034, code lost:
        if (r6 >= r0) goto L_0x0054;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0036, code lost:
        r2.get(r6).recordModificationsOf(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x004f, code lost:
        if (r9._state.getValue().compareTo(androidx.compose.runtime.Recomposer.State.ShuttingDown) <= 0) goto L_0x0054;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0051, code lost:
        r6 = r6 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0054, code lost:
        r0 = r9.stateLock;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0056, code lost:
        monitor-enter(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        r9.snapshotInvalidations = new androidx.collection.MutableScatterSet<>(0, 1, (kotlin.jvm.internal.DefaultConstructorMarker) null);
        r2 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        monitor-exit(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0061, code lost:
        r0 = r9.stateLock;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0063, code lost:
        monitor-enter(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0068, code lost:
        if (deriveStateLocked() != null) goto L_0x0070;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x006a, code lost:
        r1 = getHasFrameWorkLocked();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x006e, code lost:
        monitor-exit(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x006f, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x007b, code lost:
        throw new java.lang.IllegalStateException("called outside of runRecomposeAndApplyChanges".toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0082, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0085, code lost:
        monitor-enter(r9.stateLock);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:?, code lost:
        r9.snapshotInvalidations.addAll(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x008e, code lost:
        throw r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean recordComposerModifications() {
        /*
            r9 = this;
            java.lang.Object r0 = r9.stateLock
            monitor-enter(r0)
            androidx.collection.MutableScatterSet<java.lang.Object> r1 = r9.snapshotInvalidations     // Catch:{ all -> 0x0095 }
            boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x0095 }
            if (r1 == 0) goto L_0x0011
            boolean r1 = r9.getHasFrameWorkLocked()     // Catch:{ all -> 0x0095 }
            monitor-exit(r0)
            return r1
        L_0x0011:
            androidx.collection.MutableScatterSet<java.lang.Object> r1 = r9.snapshotInvalidations     // Catch:{ all -> 0x0095 }
            androidx.collection.ScatterSet r1 = (androidx.collection.ScatterSet) r1     // Catch:{ all -> 0x0095 }
            java.util.Set r1 = androidx.compose.runtime.collection.ScatterSetWrapperKt.wrapIntoSet(r1)     // Catch:{ all -> 0x0095 }
            androidx.collection.MutableScatterSet r2 = new androidx.collection.MutableScatterSet     // Catch:{ all -> 0x0095 }
            r3 = 0
            r4 = 1
            r5 = 0
            r2.<init>(r5, r4, r3)     // Catch:{ all -> 0x0095 }
            r9.snapshotInvalidations = r2     // Catch:{ all -> 0x0095 }
            monitor-exit(r0)
            java.lang.Object r0 = r9.stateLock
            monitor-enter(r0)
            java.util.List r2 = r9.getKnownCompositions()     // Catch:{ all -> 0x0092 }
            monitor-exit(r0)
            r0 = r9
            androidx.compose.runtime.Recomposer r0 = (androidx.compose.runtime.Recomposer) r0     // Catch:{ all -> 0x0082 }
            int r0 = r2.size()     // Catch:{ all -> 0x0082 }
            r6 = r5
        L_0x0034:
            if (r6 >= r0) goto L_0x0054
            java.lang.Object r7 = r2.get(r6)     // Catch:{ all -> 0x0082 }
            androidx.compose.runtime.ControlledComposition r7 = (androidx.compose.runtime.ControlledComposition) r7     // Catch:{ all -> 0x0082 }
            r7.recordModificationsOf(r1)     // Catch:{ all -> 0x0082 }
            kotlinx.coroutines.flow.MutableStateFlow<androidx.compose.runtime.Recomposer$State> r7 = r9._state     // Catch:{ all -> 0x0082 }
            java.lang.Object r7 = r7.getValue()     // Catch:{ all -> 0x0082 }
            androidx.compose.runtime.Recomposer$State r7 = (androidx.compose.runtime.Recomposer.State) r7     // Catch:{ all -> 0x0082 }
            androidx.compose.runtime.Recomposer$State r8 = androidx.compose.runtime.Recomposer.State.ShuttingDown     // Catch:{ all -> 0x0082 }
            java.lang.Enum r8 = (java.lang.Enum) r8     // Catch:{ all -> 0x0082 }
            int r7 = r7.compareTo(r8)     // Catch:{ all -> 0x0082 }
            if (r7 <= 0) goto L_0x0054
            int r6 = r6 + 1
            goto L_0x0034
        L_0x0054:
            java.lang.Object r0 = r9.stateLock     // Catch:{ all -> 0x0082 }
            monitor-enter(r0)     // Catch:{ all -> 0x0082 }
            androidx.collection.MutableScatterSet r2 = new androidx.collection.MutableScatterSet     // Catch:{ all -> 0x007f }
            r2.<init>(r5, r4, r3)     // Catch:{ all -> 0x007f }
            r9.snapshotInvalidations = r2     // Catch:{ all -> 0x007f }
            kotlin.Unit r2 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x007f }
            monitor-exit(r0)     // Catch:{ all -> 0x0082 }
            java.lang.Object r0 = r9.stateLock
            monitor-enter(r0)
            kotlinx.coroutines.CancellableContinuation r1 = r9.deriveStateLocked()     // Catch:{ all -> 0x007c }
            if (r1 != 0) goto L_0x0070
            boolean r1 = r9.getHasFrameWorkLocked()     // Catch:{ all -> 0x007c }
            monitor-exit(r0)
            return r1
        L_0x0070:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException     // Catch:{ all -> 0x007c }
            java.lang.String r2 = "called outside of runRecomposeAndApplyChanges"
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x007c }
            r1.<init>(r2)     // Catch:{ all -> 0x007c }
            throw r1     // Catch:{ all -> 0x007c }
        L_0x007c:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        L_0x007f:
            r2 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0082 }
            throw r2     // Catch:{ all -> 0x0082 }
        L_0x0082:
            r0 = move-exception
            java.lang.Object r2 = r9.stateLock
            monitor-enter(r2)
            androidx.collection.MutableScatterSet<java.lang.Object> r3 = r9.snapshotInvalidations     // Catch:{ all -> 0x008f }
            java.lang.Iterable r1 = (java.lang.Iterable) r1     // Catch:{ all -> 0x008f }
            r3.addAll(r1)     // Catch:{ all -> 0x008f }
            monitor-exit(r2)
            throw r0
        L_0x008f:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        L_0x0092:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        L_0x0095:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.Recomposer.recordComposerModifications():boolean");
    }

    private final void recordComposerModifications(Function1<? super ControlledComposition, Unit> function1) {
        MutableScatterSet access$getSnapshotInvalidations$p;
        int i;
        synchronized (this.stateLock) {
            access$getSnapshotInvalidations$p = this.snapshotInvalidations;
            i = 0;
            if (access$getSnapshotInvalidations$p.isNotEmpty()) {
                this.snapshotInvalidations = new MutableScatterSet(0, 1, (DefaultConstructorMarker) null);
            }
        }
        Set wrapIntoSet = ScatterSetWrapperKt.wrapIntoSet(access$getSnapshotInvalidations$p);
        if (!wrapIntoSet.isEmpty()) {
            List access$getKnownCompositions = getKnownCompositions();
            int size = access$getKnownCompositions.size();
            for (int i2 = 0; i2 < size; i2++) {
                ((ControlledComposition) access$getKnownCompositions.get(i2)).recordModificationsOf(wrapIntoSet);
            }
        }
        MutableVector access$getCompositionInvalidations$p = this.compositionInvalidations;
        int size2 = access$getCompositionInvalidations$p.getSize();
        if (size2 > 0) {
            Object[] content = access$getCompositionInvalidations$p.getContent();
            do {
                function1.invoke(content[i]);
                i++;
            } while (i < size2);
        }
        this.compositionInvalidations.clear();
        synchronized (this.stateLock) {
            if (deriveStateLocked() == null) {
                Unit unit = Unit.INSTANCE;
            } else {
                throw new IllegalStateException("called outside of runRecomposeAndApplyChanges".toString());
            }
        }
    }

    /* access modifiers changed from: private */
    public final void registerRunnerJob(Job job) {
        synchronized (this.stateLock) {
            Throwable th = this.closeCause;
            if (th != null) {
                throw th;
            } else if (this._state.getValue().compareTo(State.ShuttingDown) <= 0) {
                throw new IllegalStateException("Recomposer shut down".toString());
            } else if (this.runnerJob == null) {
                this.runnerJob = job;
                deriveStateLocked();
            } else {
                throw new IllegalStateException("Recomposer already running".toString());
            }
        }
    }

    public final Object runRecomposeAndApplyChanges(Continuation<? super Unit> continuation) {
        Object recompositionRunner = recompositionRunner(new Recomposer$runRecomposeAndApplyChanges$2(this, (Continuation<? super Recomposer$runRecomposeAndApplyChanges$2>) null), continuation);
        return recompositionRunner == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? recompositionRunner : Unit.INSTANCE;
    }

    static /* synthetic */ void processCompositionError$default(Recomposer recomposer, Exception exc, ControlledComposition controlledComposition, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            controlledComposition = null;
        }
        if ((i & 4) != 0) {
            z = false;
        }
        recomposer.processCompositionError(exc, controlledComposition, z);
    }

    private final void processCompositionError(Exception exc, ControlledComposition controlledComposition, boolean z) {
        if (!_hotReloadEnabled.get().booleanValue() || (exc instanceof ComposeRuntimeError)) {
            synchronized (this.stateLock) {
                RecomposerErrorState recomposerErrorState = this.errorState;
                if (recomposerErrorState == null) {
                    this.errorState = new RecomposerErrorState(false, exc);
                    Unit unit = Unit.INSTANCE;
                } else {
                    throw recomposerErrorState.getCause();
                }
            }
            throw exc;
        }
        synchronized (this.stateLock) {
            ActualAndroid_androidKt.logError("Error was captured in composition while live edit was enabled.", exc);
            this.compositionsAwaitingApply.clear();
            this.compositionInvalidations.clear();
            this.snapshotInvalidations = new MutableScatterSet<>(0, 1, (DefaultConstructorMarker) null);
            this.compositionValuesAwaitingInsert.clear();
            this.compositionValuesRemoved.clear();
            this.compositionValueStatesAvailable.clear();
            this.errorState = new RecomposerErrorState(z, exc);
            if (controlledComposition != null) {
                recordFailedCompositionLocked(controlledComposition);
            }
            deriveStateLocked();
        }
    }

    private final void clearKnownCompositionsLocked() {
        this._knownCompositions.clear();
        this._knownCompositionsCache = CollectionsKt.emptyList();
    }

    private final void removeKnownCompositionLocked(ControlledComposition controlledComposition) {
        this._knownCompositions.remove(controlledComposition);
        this._knownCompositionsCache = null;
    }

    private final void addKnownCompositionLocked(ControlledComposition controlledComposition) {
        this._knownCompositions.add(controlledComposition);
        this._knownCompositionsCache = null;
    }

    /* access modifiers changed from: private */
    public final RecomposerErrorState resetErrorState() {
        RecomposerErrorState recomposerErrorState;
        synchronized (this.stateLock) {
            recomposerErrorState = this.errorState;
            if (recomposerErrorState != null) {
                this.errorState = null;
                deriveStateLocked();
            }
        }
        return recomposerErrorState;
    }

    /* access modifiers changed from: private */
    public final void retryFailedCompositions() {
        List<ControlledComposition> list;
        int i;
        synchronized (this.stateLock) {
            list = this.failedCompositions;
            this.failedCompositions = null;
        }
        if (list != null) {
            while (true) {
                i = 0;
                try {
                    if (list.isEmpty()) {
                        break;
                    }
                    ControlledComposition controlledComposition = (ControlledComposition) CollectionsKt.removeLast(list);
                    if (controlledComposition instanceof CompositionImpl) {
                        controlledComposition.invalidateAll();
                        controlledComposition.setContent(((CompositionImpl) controlledComposition).getComposable());
                        if (this.errorState != null) {
                            break;
                        }
                    }
                } catch (Throwable th) {
                    if (!list.isEmpty()) {
                        synchronized (this.stateLock) {
                            int size = list.size();
                            while (i < size) {
                                recordFailedCompositionLocked(list.get(i));
                                i++;
                            }
                            Unit unit = Unit.INSTANCE;
                        }
                    }
                    throw th;
                }
            }
            if (!list.isEmpty()) {
                synchronized (this.stateLock) {
                    int size2 = list.size();
                    while (i < size2) {
                        recordFailedCompositionLocked(list.get(i));
                        i++;
                    }
                    Unit unit2 = Unit.INSTANCE;
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public final void recordFailedCompositionLocked(ControlledComposition controlledComposition) {
        List<ControlledComposition> list = this.failedCompositions;
        if (list == null) {
            list = new ArrayList<>();
            this.failedCompositions = list;
        }
        if (!list.contains(controlledComposition)) {
            list.add(controlledComposition);
        }
        removeKnownCompositionLocked(controlledComposition);
    }

    public final Object runRecomposeConcurrentlyAndApplyChanges(CoroutineContext coroutineContext, Continuation<? super Unit> continuation) {
        Object recompositionRunner = recompositionRunner(new Recomposer$runRecomposeConcurrentlyAndApplyChanges$2(coroutineContext, this, (Continuation<? super Recomposer$runRecomposeConcurrentlyAndApplyChanges$2>) null), continuation);
        return recompositionRunner == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? recompositionRunner : Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x00a9, code lost:
        if (r5.withFrameNanos(new androidx.compose.runtime.Recomposer$runFrameLoop$2(r6, r9, r8, r2), r0) != r1) goto L_0x0040;
     */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object runFrameLoop(androidx.compose.runtime.MonotonicFrameClock r8, androidx.compose.runtime.ProduceFrameSignal r9, kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            r7 = this;
            boolean r0 = r10 instanceof androidx.compose.runtime.Recomposer$runFrameLoop$1
            if (r0 == 0) goto L_0x0014
            r0 = r10
            androidx.compose.runtime.Recomposer$runFrameLoop$1 r0 = (androidx.compose.runtime.Recomposer$runFrameLoop$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L_0x0019
        L_0x0014:
            androidx.compose.runtime.Recomposer$runFrameLoop$1 r0 = new androidx.compose.runtime.Recomposer$runFrameLoop$1
            r0.<init>(r7, r10)
        L_0x0019:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0066
            if (r2 == r4) goto L_0x004e
            if (r2 != r3) goto L_0x0046
            java.lang.Object r8 = r0.L$4
            java.util.List r8 = (java.util.List) r8
            java.lang.Object r9 = r0.L$3
            java.util.List r9 = (java.util.List) r9
            java.lang.Object r2 = r0.L$2
            androidx.compose.runtime.ProduceFrameSignal r2 = (androidx.compose.runtime.ProduceFrameSignal) r2
            java.lang.Object r5 = r0.L$1
            androidx.compose.runtime.MonotonicFrameClock r5 = (androidx.compose.runtime.MonotonicFrameClock) r5
            java.lang.Object r6 = r0.L$0
            androidx.compose.runtime.Recomposer r6 = (androidx.compose.runtime.Recomposer) r6
            kotlin.ResultKt.throwOnFailure(r10)
        L_0x0040:
            r10 = r9
            r9 = r2
            r2 = r8
            r8 = r5
            r5 = r6
            goto L_0x0078
        L_0x0046:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x004e:
            java.lang.Object r8 = r0.L$4
            java.util.List r8 = (java.util.List) r8
            java.lang.Object r9 = r0.L$3
            java.util.List r9 = (java.util.List) r9
            java.lang.Object r2 = r0.L$2
            androidx.compose.runtime.ProduceFrameSignal r2 = (androidx.compose.runtime.ProduceFrameSignal) r2
            java.lang.Object r5 = r0.L$1
            androidx.compose.runtime.MonotonicFrameClock r5 = (androidx.compose.runtime.MonotonicFrameClock) r5
            java.lang.Object r6 = r0.L$0
            androidx.compose.runtime.Recomposer r6 = (androidx.compose.runtime.Recomposer) r6
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x0092
        L_0x0066:
            kotlin.ResultKt.throwOnFailure(r10)
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
            java.util.List r10 = (java.util.List) r10
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.List r2 = (java.util.List) r2
            r5 = r7
        L_0x0078:
            java.lang.Object r6 = r5.stateLock
            r0.L$0 = r5
            r0.L$1 = r8
            r0.L$2 = r9
            r0.L$3 = r10
            r0.L$4 = r2
            r0.label = r4
            java.lang.Object r6 = r9.awaitFrameRequest(r6, r0)
            if (r6 != r1) goto L_0x008d
            goto L_0x00ab
        L_0x008d:
            r6 = r5
            r5 = r8
            r8 = r2
            r2 = r9
            r9 = r10
        L_0x0092:
            androidx.compose.runtime.Recomposer$runFrameLoop$2 r10 = new androidx.compose.runtime.Recomposer$runFrameLoop$2
            r10.<init>(r6, r9, r8, r2)
            kotlin.jvm.functions.Function1 r10 = (kotlin.jvm.functions.Function1) r10
            r0.L$0 = r6
            r0.L$1 = r5
            r0.L$2 = r2
            r0.L$3 = r9
            r0.L$4 = r8
            r0.label = r3
            java.lang.Object r10 = r5.withFrameNanos(r10, r0)
            if (r10 != r1) goto L_0x0040
        L_0x00ab:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.Recomposer.runFrameLoop(androidx.compose.runtime.MonotonicFrameClock, androidx.compose.runtime.ProduceFrameSignal, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final boolean getHasSchedulingWork() {
        boolean z;
        synchronized (this.stateLock) {
            z = this.snapshotInvalidations.isNotEmpty() || this.compositionInvalidations.isNotEmpty() || getHasBroadcastFrameClockAwaitersLocked();
        }
        return z;
    }

    /* access modifiers changed from: private */
    public final Object awaitWorkAvailable(Continuation<? super Unit> continuation) {
        if (getHasSchedulingWork()) {
            return Unit.INSTANCE;
        }
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        CancellableContinuation cancellableContinuation = cancellableContinuationImpl;
        synchronized (this.stateLock) {
            if (!getHasSchedulingWork()) {
                this.workContinuation = cancellableContinuation;
                cancellableContinuation = null;
            }
        }
        if (cancellableContinuation != null) {
            Result.Companion companion = Result.Companion;
            cancellableContinuation.resumeWith(Result.m7823constructorimpl(Unit.INSTANCE));
        }
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? result : Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public final Object recompositionRunner(Function3<? super CoroutineScope, ? super MonotonicFrameClock, ? super Continuation<? super Unit>, ? extends Object> function3, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(this.broadcastFrameClock, new Recomposer$recompositionRunner$2(this, function3, MonotonicFrameClockKt.getMonotonicFrameClock(continuation.getContext()), (Continuation<? super Recomposer$recompositionRunner$2>) null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    public final void cancel() {
        synchronized (this.stateLock) {
            if (this._state.getValue().compareTo(State.Idle) >= 0) {
                this._state.setValue(State.ShuttingDown);
            }
            Unit unit = Unit.INSTANCE;
        }
        Job.DefaultImpls.cancel$default((Job) this.effectJob, (CancellationException) null, 1, (Object) null);
    }

    public final void close() {
        if (this.effectJob.complete()) {
            synchronized (this.stateLock) {
                this.isClosed = true;
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    public final Object join(Continuation<? super Unit> continuation) {
        Object first = FlowKt.first(getCurrentState(), new Recomposer$join$2((Continuation<? super Recomposer$join$2>) null), continuation);
        return first == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? first : Unit.INSTANCE;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        performInitialMovableContentInserts(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
        r8.applyChanges();
        r8.applyLateChanges();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0060, code lost:
        if (r0 != false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0062, code lost:
        androidx.compose.runtime.snapshots.Snapshot.Companion.notifyObjectsInitialized();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0068, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0069, code lost:
        r1 = r7;
        processCompositionError$default(r1, r0, (androidx.compose.runtime.ControlledComposition) null, false, 6, (java.lang.Object) null);
        r5 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0074, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0075, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0076, code lost:
        r5 = r7;
        processCompositionError(r0, r8, true);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x007b, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void composeInitial$runtime_release(androidx.compose.runtime.ControlledComposition r8, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r9) {
        /*
            r7 = this;
            boolean r0 = r8.isComposing()
            r1 = 1
            androidx.compose.runtime.snapshots.Snapshot$Companion r2 = androidx.compose.runtime.snapshots.Snapshot.Companion     // Catch:{ Exception -> 0x0093 }
            kotlin.jvm.functions.Function1 r3 = r7.readObserverOf(r8)     // Catch:{ Exception -> 0x0093 }
            r4 = 0
            kotlin.jvm.functions.Function1 r4 = r7.writeObserverOf(r8, r4)     // Catch:{ Exception -> 0x0093 }
            androidx.compose.runtime.snapshots.MutableSnapshot r2 = r2.takeMutableSnapshot(r3, r4)     // Catch:{ Exception -> 0x0093 }
            r3 = r2
            androidx.compose.runtime.snapshots.Snapshot r3 = (androidx.compose.runtime.snapshots.Snapshot) r3     // Catch:{ all -> 0x008a }
            androidx.compose.runtime.snapshots.Snapshot r4 = r3.makeCurrent()     // Catch:{ all -> 0x008a }
            r8.composeContent(r9)     // Catch:{ all -> 0x0081 }
            kotlin.Unit r9 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0081 }
            r3.restoreCurrent(r4)     // Catch:{ all -> 0x008a }
            r7.applyAndCheck(r2)     // Catch:{ Exception -> 0x0093 }
            if (r0 != 0) goto L_0x002d
            androidx.compose.runtime.snapshots.Snapshot$Companion r9 = androidx.compose.runtime.snapshots.Snapshot.Companion
            r9.notifyObjectsInitialized()
        L_0x002d:
            java.lang.Object r9 = r7.stateLock
            monitor-enter(r9)
            kotlinx.coroutines.flow.MutableStateFlow<androidx.compose.runtime.Recomposer$State> r2 = r7._state     // Catch:{ all -> 0x007c }
            java.lang.Object r2 = r2.getValue()     // Catch:{ all -> 0x007c }
            androidx.compose.runtime.Recomposer$State r2 = (androidx.compose.runtime.Recomposer.State) r2     // Catch:{ all -> 0x007c }
            androidx.compose.runtime.Recomposer$State r3 = androidx.compose.runtime.Recomposer.State.ShuttingDown     // Catch:{ all -> 0x007c }
            java.lang.Enum r3 = (java.lang.Enum) r3     // Catch:{ all -> 0x007c }
            int r2 = r2.compareTo(r3)     // Catch:{ all -> 0x007c }
            if (r2 <= 0) goto L_0x0054
            java.util.List r2 = r7.getKnownCompositions()     // Catch:{ all -> 0x0050 }
            boolean r2 = r2.contains(r8)     // Catch:{ all -> 0x0050 }
            if (r2 != 0) goto L_0x0054
            r7.addKnownCompositionLocked(r8)     // Catch:{ all -> 0x0050 }
            goto L_0x0054
        L_0x0050:
            r0 = move-exception
            r8 = r0
            r5 = r7
            goto L_0x007f
        L_0x0054:
            kotlin.Unit r2 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x007c }
            monitor-exit(r9)
            r7.performInitialMovableContentInserts(r8)     // Catch:{ Exception -> 0x0075 }
            r8.applyChanges()     // Catch:{ Exception -> 0x0068 }
            r8.applyLateChanges()     // Catch:{ Exception -> 0x0068 }
            if (r0 != 0) goto L_0x0067
            androidx.compose.runtime.snapshots.Snapshot$Companion r8 = androidx.compose.runtime.snapshots.Snapshot.Companion
            r8.notifyObjectsInitialized()
        L_0x0067:
            return
        L_0x0068:
            r0 = move-exception
            r8 = r0
            r2 = r8
            r5 = 6
            r6 = 0
            r3 = 0
            r4 = 0
            r1 = r7
            processCompositionError$default(r1, r2, r3, r4, r5, r6)
            r5 = r1
            return
        L_0x0075:
            r0 = move-exception
            r5 = r7
            r9 = r0
            r7.processCompositionError(r9, r8, r1)
            return
        L_0x007c:
            r0 = move-exception
            r5 = r7
            r8 = r0
        L_0x007f:
            monitor-exit(r9)
            throw r8
        L_0x0081:
            r0 = move-exception
            r5 = r7
            r9 = r0
            r3.restoreCurrent(r4)     // Catch:{ all -> 0x0088 }
            throw r9     // Catch:{ all -> 0x0088 }
        L_0x0088:
            r0 = move-exception
            goto L_0x008c
        L_0x008a:
            r0 = move-exception
            r5 = r7
        L_0x008c:
            r9 = r0
            r7.applyAndCheck(r2)     // Catch:{ Exception -> 0x0091 }
            throw r9     // Catch:{ Exception -> 0x0091 }
        L_0x0091:
            r0 = move-exception
            goto L_0x0095
        L_0x0093:
            r0 = move-exception
            r5 = r7
        L_0x0095:
            r9 = r0
            r7.processCompositionError(r9, r8, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.Recomposer.composeInitial$runtime_release(androidx.compose.runtime.ControlledComposition, kotlin.jvm.functions.Function2):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0030, code lost:
        if (r0.isEmpty() != false) goto L_0x003a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0032, code lost:
        performInsertValues(r0, (androidx.collection.MutableScatterSet<java.lang.Object>) null);
        performInitialMovableContentInserts$fillToInsert(r0, r5, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x003a, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001f, code lost:
        r0 = new java.util.ArrayList();
        performInitialMovableContentInserts$fillToInsert(r0, r5, r6);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void performInitialMovableContentInserts(androidx.compose.runtime.ControlledComposition r6) {
        /*
            r5 = this;
            java.lang.Object r0 = r5.stateLock
            monitor-enter(r0)
            java.util.List<androidx.compose.runtime.MovableContentStateReference> r1 = r5.compositionValuesAwaitingInsert     // Catch:{ all -> 0x0040 }
            int r2 = r1.size()     // Catch:{ all -> 0x0040 }
            r3 = 0
        L_0x000a:
            if (r3 >= r2) goto L_0x003e
            java.lang.Object r4 = r1.get(r3)     // Catch:{ all -> 0x0040 }
            androidx.compose.runtime.MovableContentStateReference r4 = (androidx.compose.runtime.MovableContentStateReference) r4     // Catch:{ all -> 0x0040 }
            androidx.compose.runtime.ControlledComposition r4 = r4.getComposition$runtime_release()     // Catch:{ all -> 0x0040 }
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r6)     // Catch:{ all -> 0x0040 }
            if (r4 == 0) goto L_0x003b
            kotlin.Unit r1 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0040 }
            monitor-exit(r0)
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.List r0 = (java.util.List) r0
            performInitialMovableContentInserts$fillToInsert(r0, r5, r6)
        L_0x0029:
            r1 = r0
            java.util.Collection r1 = (java.util.Collection) r1
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L_0x003a
            r1 = 0
            r5.performInsertValues(r0, r1)
            performInitialMovableContentInserts$fillToInsert(r0, r5, r6)
            goto L_0x0029
        L_0x003a:
            return
        L_0x003b:
            int r3 = r3 + 1
            goto L_0x000a
        L_0x003e:
            monitor-exit(r0)
            return
        L_0x0040:
            r6 = move-exception
            monitor-exit(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.Recomposer.performInitialMovableContentInserts(androidx.compose.runtime.ControlledComposition):void");
    }

    private static final void performInitialMovableContentInserts$fillToInsert(List<MovableContentStateReference> list, Recomposer recomposer, ControlledComposition controlledComposition) {
        list.clear();
        synchronized (recomposer.stateLock) {
            Iterator<MovableContentStateReference> it = recomposer.compositionValuesAwaitingInsert.iterator();
            while (it.hasNext()) {
                MovableContentStateReference next = it.next();
                if (Intrinsics.areEqual((Object) next.getComposition$runtime_release(), (Object) controlledComposition)) {
                    list.add(next);
                    it.remove();
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    /* access modifiers changed from: private */
    public final ControlledComposition performRecompose(ControlledComposition controlledComposition, MutableScatterSet<Object> mutableScatterSet) {
        Set<ControlledComposition> set;
        Snapshot snapshot;
        Snapshot makeCurrent;
        if (controlledComposition.isComposing() || controlledComposition.isDisposed() || ((set = this.compositionsRemoved) != null && set.contains(controlledComposition))) {
            return null;
        }
        MutableSnapshot takeMutableSnapshot = Snapshot.Companion.takeMutableSnapshot(readObserverOf(controlledComposition), writeObserverOf(controlledComposition, mutableScatterSet));
        try {
            snapshot = takeMutableSnapshot;
            makeCurrent = snapshot.makeCurrent();
            if (mutableScatterSet != null) {
                if (mutableScatterSet.isNotEmpty()) {
                    controlledComposition.prepareCompose(new Recomposer$performRecompose$1$1(mutableScatterSet, controlledComposition));
                }
            }
            boolean recompose = controlledComposition.recompose();
            snapshot.restoreCurrent(makeCurrent);
            applyAndCheck(takeMutableSnapshot);
            if (recompose) {
                return controlledComposition;
            }
            return null;
        } catch (Throwable th) {
            applyAndCheck(takeMutableSnapshot);
            throw th;
        }
    }

    /* access modifiers changed from: private */
    public final void discardUnusedValues() {
        int i;
        List list;
        synchronized (this.stateLock) {
            if (!this.compositionValuesRemoved.isEmpty()) {
                List flatten = CollectionsKt.flatten(this.compositionValuesRemoved.values());
                this.compositionValuesRemoved.clear();
                ArrayList arrayList = new ArrayList(flatten.size());
                int size = flatten.size();
                for (int i2 = 0; i2 < size; i2++) {
                    MovableContentStateReference movableContentStateReference = (MovableContentStateReference) flatten.get(i2);
                    arrayList.add(TuplesKt.to(movableContentStateReference, this.compositionValueStatesAvailable.get(movableContentStateReference)));
                }
                list = arrayList;
                this.compositionValueStatesAvailable.clear();
            } else {
                list = CollectionsKt.emptyList();
            }
        }
        int size2 = list.size();
        for (i = 0; i < size2; i++) {
            Pair pair = (Pair) list.get(i);
            MovableContentStateReference movableContentStateReference2 = (MovableContentStateReference) pair.component1();
            MovableContentState movableContentState = (MovableContentState) pair.component2();
            if (movableContentState != null) {
                movableContentStateReference2.getComposition$runtime_release().disposeUnusedMovableContent(movableContentState);
            }
        }
    }

    private final Function1<Object, Unit> readObserverOf(ControlledComposition controlledComposition) {
        return new Recomposer$readObserverOf$1(controlledComposition);
    }

    private final Function1<Object, Unit> writeObserverOf(ControlledComposition controlledComposition, MutableScatterSet<Object> mutableScatterSet) {
        return new Recomposer$writeObserverOf$1(controlledComposition, mutableScatterSet);
    }

    private final <T> T composing(ControlledComposition controlledComposition, MutableScatterSet<Object> mutableScatterSet, Function0<? extends T> function0) {
        Snapshot snapshot;
        Snapshot makeCurrent;
        MutableSnapshot takeMutableSnapshot = Snapshot.Companion.takeMutableSnapshot(readObserverOf(controlledComposition), writeObserverOf(controlledComposition, mutableScatterSet));
        try {
            snapshot = takeMutableSnapshot;
            makeCurrent = snapshot.makeCurrent();
            T invoke = function0.invoke();
            snapshot.restoreCurrent(makeCurrent);
            applyAndCheck(takeMutableSnapshot);
            return invoke;
        } catch (Throwable th) {
            applyAndCheck(takeMutableSnapshot);
            throw th;
        }
    }

    private final void applyAndCheck(MutableSnapshot mutableSnapshot) {
        try {
            if (mutableSnapshot.apply() instanceof SnapshotApplyResult.Failure) {
                throw new IllegalStateException("Unsupported concurrent change during composition. A state object was modified by composition as well as being modified outside composition.".toString());
            }
        } finally {
            mutableSnapshot.dispose();
        }
    }

    public final boolean getHasPendingWork() {
        boolean z;
        synchronized (this.stateLock) {
            z = this.snapshotInvalidations.isNotEmpty() || this.compositionInvalidations.isNotEmpty() || this.concurrentCompositionsOutstanding > 0 || !this.compositionsAwaitingApply.isEmpty() || getHasBroadcastFrameClockAwaitersLocked();
        }
        return z;
    }

    private final boolean getHasFrameWorkLocked() {
        return this.compositionInvalidations.isNotEmpty() || getHasBroadcastFrameClockAwaitersLocked();
    }

    /* access modifiers changed from: private */
    public final boolean getHasConcurrentFrameWorkLocked() {
        return !this.compositionsAwaitingApply.isEmpty() || getHasBroadcastFrameClockAwaitersLocked();
    }

    public final Object awaitIdle(Continuation<? super Unit> continuation) {
        Object collect = FlowKt.collect(FlowKt.takeWhile(getCurrentState(), new Recomposer$awaitIdle$2((Continuation<? super Recomposer$awaitIdle$2>) null)), continuation);
        return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
    }

    public final void pauseCompositionFrameClock() {
        synchronized (this.stateLock) {
            this.frameClockPaused = true;
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void resumeCompositionFrameClock() {
        CancellableContinuation<Unit> cancellableContinuation;
        synchronized (this.stateLock) {
            if (this.frameClockPaused) {
                this.frameClockPaused = false;
                cancellableContinuation = deriveStateLocked();
            } else {
                cancellableContinuation = null;
            }
        }
        if (cancellableContinuation != null) {
            Result.Companion companion = Result.Companion;
            cancellableContinuation.resumeWith(Result.m7823constructorimpl(Unit.INSTANCE));
        }
    }

    public boolean getCollectingCallByInformation$runtime_release() {
        return _hotReloadEnabled.get().booleanValue();
    }

    public void unregisterComposition$runtime_release(ControlledComposition controlledComposition) {
        synchronized (this.stateLock) {
            removeKnownCompositionLocked(controlledComposition);
            this.compositionInvalidations.remove(controlledComposition);
            this.compositionsAwaitingApply.remove(controlledComposition);
            Unit unit = Unit.INSTANCE;
        }
    }

    public void invalidate$runtime_release(ControlledComposition controlledComposition) {
        CancellableContinuation<Unit> cancellableContinuation;
        synchronized (this.stateLock) {
            if (!this.compositionInvalidations.contains(controlledComposition)) {
                this.compositionInvalidations.add(controlledComposition);
                cancellableContinuation = deriveStateLocked();
            } else {
                cancellableContinuation = null;
            }
        }
        if (cancellableContinuation != null) {
            Result.Companion companion = Result.Companion;
            cancellableContinuation.resumeWith(Result.m7823constructorimpl(Unit.INSTANCE));
        }
    }

    public void invalidateScope$runtime_release(RecomposeScopeImpl recomposeScopeImpl) {
        CancellableContinuation<Unit> deriveStateLocked;
        synchronized (this.stateLock) {
            this.snapshotInvalidations.add(recomposeScopeImpl);
            deriveStateLocked = deriveStateLocked();
        }
        if (deriveStateLocked != null) {
            Result.Companion companion = Result.Companion;
            deriveStateLocked.resumeWith(Result.m7823constructorimpl(Unit.INSTANCE));
        }
    }

    public void insertMovableContent$runtime_release(MovableContentStateReference movableContentStateReference) {
        CancellableContinuation<Unit> deriveStateLocked;
        synchronized (this.stateLock) {
            this.compositionValuesAwaitingInsert.add(movableContentStateReference);
            deriveStateLocked = deriveStateLocked();
        }
        if (deriveStateLocked != null) {
            Result.Companion companion = Result.Companion;
            deriveStateLocked.resumeWith(Result.m7823constructorimpl(Unit.INSTANCE));
        }
    }

    public void deletedMovableContent$runtime_release(MovableContentStateReference movableContentStateReference) {
        synchronized (this.stateLock) {
            RecomposerKt.addMultiValue(this.compositionValuesRemoved, movableContentStateReference.getContent$runtime_release(), movableContentStateReference);
        }
    }

    public void movableContentStateReleased$runtime_release(MovableContentStateReference movableContentStateReference, MovableContentState movableContentState) {
        synchronized (this.stateLock) {
            this.compositionValueStatesAvailable.put(movableContentStateReference, movableContentState);
            Unit unit = Unit.INSTANCE;
        }
    }

    public void reportRemovedComposition$runtime_release(ControlledComposition controlledComposition) {
        synchronized (this.stateLock) {
            Set<ControlledComposition> set = this.compositionsRemoved;
            if (set == null) {
                set = new LinkedHashSet<>();
                this.compositionsRemoved = set;
            }
            set.add(controlledComposition);
        }
    }

    public MovableContentState movableContentStateResolve$runtime_release(MovableContentStateReference movableContentStateReference) {
        MovableContentState remove;
        synchronized (this.stateLock) {
            remove = this.compositionValueStatesAvailable.remove(movableContentStateReference);
        }
        return remove;
    }

    @Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0013\u001a\u00020\u00142\n\u0010\u0015\u001a\u00060\u000bR\u00020\fH\u0002J\r\u0010\u0016\u001a\u00020\u0014H\u0000¢\u0006\u0002\b\u0017J\u0013\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0000¢\u0006\u0002\b\u001bJ\u0015\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u001eH\u0000¢\u0006\u0002\b\u001fJ\u0015\u0010 \u001a\u00020\u00142\u0006\u0010!\u001a\u00020\u0001H\u0000¢\u0006\u0002\b\"J\u0014\u0010#\u001a\u00020\u00142\n\u0010\u0015\u001a\u00060\u000bR\u00020\fH\u0002J\r\u0010$\u001a\u00020\u0001H\u0000¢\u0006\u0002\b%J\u0015\u0010&\u001a\u00020\u00142\u0006\u0010'\u001a\u00020\u0005H\u0000¢\u0006\u0002\b(R.\u0010\u0003\u001a\"\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u0004j\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u0005`\u0007X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u000bR\u00020\f0\n0\tX\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u000e8F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006)"}, d2 = {"Landroidx/compose/runtime/Recomposer$Companion;", "", "()V", "_hotReloadEnabled", "Ljava/util/concurrent/atomic/AtomicReference;", "", "kotlin.jvm.PlatformType", "Landroidx/compose/runtime/AtomicReference;", "_runningRecomposers", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentSet;", "Landroidx/compose/runtime/Recomposer$RecomposerInfoImpl;", "Landroidx/compose/runtime/Recomposer;", "runningRecomposers", "Lkotlinx/coroutines/flow/StateFlow;", "", "Landroidx/compose/runtime/RecomposerInfo;", "getRunningRecomposers", "()Lkotlinx/coroutines/flow/StateFlow;", "addRunning", "", "info", "clearErrors", "clearErrors$runtime_release", "getCurrentErrors", "", "Landroidx/compose/runtime/RecomposerErrorInfo;", "getCurrentErrors$runtime_release", "invalidateGroupsWithKey", "key", "", "invalidateGroupsWithKey$runtime_release", "loadStateAndComposeForHotReload", "token", "loadStateAndComposeForHotReload$runtime_release", "removeRunning", "saveStateAndDisposeForHotReload", "saveStateAndDisposeForHotReload$runtime_release", "setHotReloadEnabled", "value", "setHotReloadEnabled$runtime_release", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: Recomposer.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final StateFlow<Set<RecomposerInfo>> getRunningRecomposers() {
            return Recomposer._runningRecomposers;
        }

        public final void setHotReloadEnabled$runtime_release(boolean z) {
            Recomposer._hotReloadEnabled.set(Boolean.valueOf(z));
        }

        /* access modifiers changed from: private */
        /*  JADX ERROR: StackOverflow in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: 
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
            	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
            */
        public final void addRunning(androidx.compose.runtime.Recomposer.RecomposerInfoImpl r4) {
            /*
                r3 = this;
            L_0x0000:
                kotlinx.coroutines.flow.MutableStateFlow r0 = androidx.compose.runtime.Recomposer._runningRecomposers
                java.lang.Object r0 = r0.getValue()
                androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet r0 = (androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet) r0
                androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet r1 = r0.add(r4)
                if (r0 == r1) goto L_0x001a
                kotlinx.coroutines.flow.MutableStateFlow r2 = androidx.compose.runtime.Recomposer._runningRecomposers
                boolean r0 = r2.compareAndSet(r0, r1)
                if (r0 == 0) goto L_0x0000
            L_0x001a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.Recomposer.Companion.addRunning(androidx.compose.runtime.Recomposer$RecomposerInfoImpl):void");
        }

        /* access modifiers changed from: private */
        /*  JADX ERROR: StackOverflow in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: 
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
            	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
            */
        public final void removeRunning(androidx.compose.runtime.Recomposer.RecomposerInfoImpl r4) {
            /*
                r3 = this;
            L_0x0000:
                kotlinx.coroutines.flow.MutableStateFlow r0 = androidx.compose.runtime.Recomposer._runningRecomposers
                java.lang.Object r0 = r0.getValue()
                androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet r0 = (androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet) r0
                androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet r1 = r0.remove(r4)
                if (r0 == r1) goto L_0x001a
                kotlinx.coroutines.flow.MutableStateFlow r2 = androidx.compose.runtime.Recomposer._runningRecomposers
                boolean r0 = r2.compareAndSet(r0, r1)
                if (r0 == 0) goto L_0x0000
            L_0x001a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.Recomposer.Companion.removeRunning(androidx.compose.runtime.Recomposer$RecomposerInfoImpl):void");
        }

        public final Object saveStateAndDisposeForHotReload$runtime_release() {
            Recomposer._hotReloadEnabled.set(true);
            Collection arrayList = new ArrayList();
            for (RecomposerInfoImpl saveStateAndDisposeForHotReload : (Iterable) Recomposer._runningRecomposers.getValue()) {
                CollectionsKt.addAll(arrayList, saveStateAndDisposeForHotReload.saveStateAndDisposeForHotReload());
            }
            return (List) arrayList;
        }

        public final void loadStateAndComposeForHotReload$runtime_release(Object obj) {
            Recomposer._hotReloadEnabled.set(true);
            for (RecomposerInfoImpl resetErrorState : (Iterable) Recomposer._runningRecomposers.getValue()) {
                resetErrorState.resetErrorState();
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<androidx.compose.runtime.Recomposer.HotReloadable>");
            List list = (List) obj;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                ((HotReloadable) list.get(i)).resetContent();
            }
            int size2 = list.size();
            for (int i2 = 0; i2 < size2; i2++) {
                ((HotReloadable) list.get(i2)).recompose();
            }
            for (RecomposerInfoImpl retryFailedCompositions : (Iterable) Recomposer._runningRecomposers.getValue()) {
                retryFailedCompositions.retryFailedCompositions();
            }
        }

        public final void invalidateGroupsWithKey$runtime_release(int i) {
            Recomposer._hotReloadEnabled.set(true);
            for (RecomposerInfoImpl recomposerInfoImpl : (Iterable) Recomposer._runningRecomposers.getValue()) {
                RecomposerErrorInfo currentError = recomposerInfoImpl.getCurrentError();
                if (currentError == null || currentError.getRecoverable()) {
                    recomposerInfoImpl.resetErrorState();
                    recomposerInfoImpl.invalidateGroupsWithKey(i);
                    recomposerInfoImpl.retryFailedCompositions();
                }
            }
        }

        public final List<RecomposerErrorInfo> getCurrentErrors$runtime_release() {
            Collection arrayList = new ArrayList();
            for (RecomposerInfoImpl currentError : (Iterable) Recomposer._runningRecomposers.getValue()) {
                RecomposerErrorInfo currentError2 = currentError.getCurrentError();
                if (currentError2 != null) {
                    arrayList.add(currentError2);
                }
            }
            return (List) arrayList;
        }

        public final void clearErrors$runtime_release() {
            Collection arrayList = new ArrayList();
            for (RecomposerInfoImpl resetErrorState : (Iterable) Recomposer._runningRecomposers.getValue()) {
                RecomposerErrorState resetErrorState2 = resetErrorState.resetErrorState();
                if (resetErrorState2 != null) {
                    arrayList.add(resetErrorState2);
                }
            }
            List list = (List) arrayList;
        }
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00c9, code lost:
        r0 = r11.size();
        r3 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00ce, code lost:
        if (r3 >= r0) goto L_0x014c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00da, code lost:
        if (((kotlin.Pair) r11.get(r3)).getSecond() == null) goto L_0x00df;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00dc, code lost:
        r3 = r3 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00df, code lost:
        r0 = new java.util.ArrayList(r11.size());
        r3 = r11.size();
        r4 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00ed, code lost:
        if (r4 >= r3) goto L_0x010e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00ef, code lost:
        r10 = (kotlin.Pair) r11.get(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00f9, code lost:
        if (r10.getSecond() != null) goto L_0x0102;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00fb, code lost:
        r10 = (androidx.compose.runtime.MovableContentStateReference) r10.getFirst();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0102, code lost:
        r10 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0103, code lost:
        if (r10 == null) goto L_0x010b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0105, code lost:
        r0.add(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x010b, code lost:
        r4 = r4 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x010e, code lost:
        r0 = r0;
        r3 = r1.stateLock;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0112, code lost:
        monitor-enter(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:?, code lost:
        kotlin.collections.CollectionsKt.addAll(r1.compositionValuesAwaitingInsert, r0);
        r0 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:?, code lost:
        monitor-exit(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x011f, code lost:
        r0 = new java.util.ArrayList(r11.size());
        r3 = r11.size();
        r4 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x012d, code lost:
        if (r4 >= r3) goto L_0x0145;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x012f, code lost:
        r10 = r11.get(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x013a, code lost:
        if (((kotlin.Pair) r10).getSecond() == null) goto L_0x0142;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x013c, code lost:
        r0.add(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0142, code lost:
        r4 = r4 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0145, code lost:
        r11 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x015e, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:?, code lost:
        r7.restoreCurrent(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0162, code lost:
        throw r0;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<androidx.compose.runtime.ControlledComposition> performInsertValues(java.util.List<androidx.compose.runtime.MovableContentStateReference> r17, androidx.collection.MutableScatterSet<java.lang.Object> r18) {
        /*
            r16 = this;
            r1 = r16
            java.util.HashMap r0 = new java.util.HashMap
            int r2 = r17.size()
            r0.<init>(r2)
            int r2 = r17.size()
            r4 = 0
        L_0x0010:
            if (r4 >= r2) goto L_0x0038
            r5 = r17
            java.lang.Object r6 = r5.get(r4)
            r7 = r6
            androidx.compose.runtime.MovableContentStateReference r7 = (androidx.compose.runtime.MovableContentStateReference) r7
            androidx.compose.runtime.ControlledComposition r7 = r7.getComposition$runtime_release()
            r8 = r0
            java.util.Map r8 = (java.util.Map) r8
            java.lang.Object r9 = r8.get(r7)
            if (r9 != 0) goto L_0x0030
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            r8.put(r7, r9)
        L_0x0030:
            java.util.ArrayList r9 = (java.util.ArrayList) r9
            r9.add(r6)
            int r4 = r4 + 1
            goto L_0x0010
        L_0x0038:
            java.util.Map r0 = (java.util.Map) r0
            java.util.Set r2 = r0.entrySet()
            java.util.Iterator r2 = r2.iterator()
        L_0x0042:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L_0x0168
            java.lang.Object r4 = r2.next()
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4
            java.lang.Object r5 = r4.getKey()
            androidx.compose.runtime.ControlledComposition r5 = (androidx.compose.runtime.ControlledComposition) r5
            java.lang.Object r4 = r4.getValue()
            java.util.List r4 = (java.util.List) r4
            boolean r6 = r5.isComposing()
            r6 = r6 ^ 1
            androidx.compose.runtime.ComposerKt.runtimeCheck(r6)
            androidx.compose.runtime.snapshots.Snapshot$Companion r6 = androidx.compose.runtime.snapshots.Snapshot.Companion
            kotlin.jvm.functions.Function1 r7 = r1.readObserverOf(r5)
            r8 = r18
            kotlin.jvm.functions.Function1 r9 = r1.writeObserverOf(r5, r8)
            androidx.compose.runtime.snapshots.MutableSnapshot r6 = r6.takeMutableSnapshot(r7, r9)
            r7 = r6
            androidx.compose.runtime.snapshots.Snapshot r7 = (androidx.compose.runtime.snapshots.Snapshot) r7     // Catch:{ all -> 0x0163 }
            androidx.compose.runtime.snapshots.Snapshot r9 = r7.makeCurrent()     // Catch:{ all -> 0x0163 }
            java.lang.Object r10 = r1.stateLock     // Catch:{ all -> 0x015e }
            monitor-enter(r10)     // Catch:{ all -> 0x015e }
            java.util.ArrayList r11 = new java.util.ArrayList     // Catch:{ all -> 0x015b }
            int r12 = r4.size()     // Catch:{ all -> 0x015b }
            r11.<init>(r12)     // Catch:{ all -> 0x015b }
            int r12 = r4.size()     // Catch:{ all -> 0x015b }
            r13 = 0
        L_0x008b:
            if (r13 >= r12) goto L_0x00ae
            java.lang.Object r14 = r4.get(r13)     // Catch:{ all -> 0x015b }
            r15 = r11
            java.util.Collection r15 = (java.util.Collection) r15     // Catch:{ all -> 0x015b }
            androidx.compose.runtime.MovableContentStateReference r14 = (androidx.compose.runtime.MovableContentStateReference) r14     // Catch:{ all -> 0x015b }
            java.util.Map<androidx.compose.runtime.MovableContent<java.lang.Object>, java.util.List<androidx.compose.runtime.MovableContentStateReference>> r3 = r1.compositionValuesRemoved     // Catch:{ all -> 0x015b }
            r17 = r0
            androidx.compose.runtime.MovableContent r0 = r14.getContent$runtime_release()     // Catch:{ all -> 0x015b }
            java.lang.Object r0 = androidx.compose.runtime.RecomposerKt.removeLastMultiValue(r3, r0)     // Catch:{ all -> 0x015b }
            kotlin.Pair r0 = kotlin.TuplesKt.to(r14, r0)     // Catch:{ all -> 0x015b }
            r15.add(r0)     // Catch:{ all -> 0x015b }
            int r13 = r13 + 1
            r0 = r17
            goto L_0x008b
        L_0x00ae:
            r17 = r0
            java.util.List r11 = (java.util.List) r11     // Catch:{ all -> 0x015b }
            monitor-exit(r10)     // Catch:{ all -> 0x015e }
            int r0 = r11.size()     // Catch:{ all -> 0x015e }
            r3 = 0
        L_0x00b8:
            if (r3 >= r0) goto L_0x014c
            java.lang.Object r4 = r11.get(r3)     // Catch:{ all -> 0x015e }
            kotlin.Pair r4 = (kotlin.Pair) r4     // Catch:{ all -> 0x015e }
            java.lang.Object r4 = r4.getSecond()     // Catch:{ all -> 0x015e }
            if (r4 != 0) goto L_0x00c9
            int r3 = r3 + 1
            goto L_0x00b8
        L_0x00c9:
            int r0 = r11.size()     // Catch:{ all -> 0x015e }
            r3 = 0
        L_0x00ce:
            if (r3 >= r0) goto L_0x014c
            java.lang.Object r4 = r11.get(r3)     // Catch:{ all -> 0x015e }
            kotlin.Pair r4 = (kotlin.Pair) r4     // Catch:{ all -> 0x015e }
            java.lang.Object r4 = r4.getSecond()     // Catch:{ all -> 0x015e }
            if (r4 == 0) goto L_0x00df
            int r3 = r3 + 1
            goto L_0x00ce
        L_0x00df:
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x015e }
            int r3 = r11.size()     // Catch:{ all -> 0x015e }
            r0.<init>(r3)     // Catch:{ all -> 0x015e }
            int r3 = r11.size()     // Catch:{ all -> 0x015e }
            r4 = 0
        L_0x00ed:
            if (r4 >= r3) goto L_0x010e
            java.lang.Object r10 = r11.get(r4)     // Catch:{ all -> 0x015e }
            kotlin.Pair r10 = (kotlin.Pair) r10     // Catch:{ all -> 0x015e }
            java.lang.Object r12 = r10.getSecond()     // Catch:{ all -> 0x015e }
            if (r12 != 0) goto L_0x0102
            java.lang.Object r10 = r10.getFirst()     // Catch:{ all -> 0x015e }
            androidx.compose.runtime.MovableContentStateReference r10 = (androidx.compose.runtime.MovableContentStateReference) r10     // Catch:{ all -> 0x015e }
            goto L_0x0103
        L_0x0102:
            r10 = 0
        L_0x0103:
            if (r10 == 0) goto L_0x010b
            r12 = r0
            java.util.Collection r12 = (java.util.Collection) r12     // Catch:{ all -> 0x015e }
            r12.add(r10)     // Catch:{ all -> 0x015e }
        L_0x010b:
            int r4 = r4 + 1
            goto L_0x00ed
        L_0x010e:
            java.util.List r0 = (java.util.List) r0     // Catch:{ all -> 0x015e }
            java.lang.Object r3 = r1.stateLock     // Catch:{ all -> 0x015e }
            monitor-enter(r3)     // Catch:{ all -> 0x015e }
            java.util.List<androidx.compose.runtime.MovableContentStateReference> r4 = r1.compositionValuesAwaitingInsert     // Catch:{ all -> 0x0149 }
            java.util.Collection r4 = (java.util.Collection) r4     // Catch:{ all -> 0x0149 }
            java.lang.Iterable r0 = (java.lang.Iterable) r0     // Catch:{ all -> 0x0149 }
            kotlin.collections.CollectionsKt.addAll(r4, r0)     // Catch:{ all -> 0x0149 }
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0149 }
            monitor-exit(r3)     // Catch:{ all -> 0x015e }
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x015e }
            int r3 = r11.size()     // Catch:{ all -> 0x015e }
            r0.<init>(r3)     // Catch:{ all -> 0x015e }
            int r3 = r11.size()     // Catch:{ all -> 0x015e }
            r4 = 0
        L_0x012d:
            if (r4 >= r3) goto L_0x0145
            java.lang.Object r10 = r11.get(r4)     // Catch:{ all -> 0x015e }
            r12 = r10
            kotlin.Pair r12 = (kotlin.Pair) r12     // Catch:{ all -> 0x015e }
            java.lang.Object r12 = r12.getSecond()     // Catch:{ all -> 0x015e }
            if (r12 == 0) goto L_0x0142
            r12 = r0
            java.util.Collection r12 = (java.util.Collection) r12     // Catch:{ all -> 0x015e }
            r12.add(r10)     // Catch:{ all -> 0x015e }
        L_0x0142:
            int r4 = r4 + 1
            goto L_0x012d
        L_0x0145:
            r11 = r0
            java.util.List r11 = (java.util.List) r11     // Catch:{ all -> 0x015e }
            goto L_0x014c
        L_0x0149:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x015e }
            throw r0     // Catch:{ all -> 0x015e }
        L_0x014c:
            r5.insertMovableContent(r11)     // Catch:{ all -> 0x015e }
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x015e }
            r7.restoreCurrent(r9)     // Catch:{ all -> 0x0163 }
            r1.applyAndCheck(r6)
            r0 = r17
            goto L_0x0042
        L_0x015b:
            r0 = move-exception
            monitor-exit(r10)     // Catch:{ all -> 0x015e }
            throw r0     // Catch:{ all -> 0x015e }
        L_0x015e:
            r0 = move-exception
            r7.restoreCurrent(r9)     // Catch:{ all -> 0x0163 }
            throw r0     // Catch:{ all -> 0x0163 }
        L_0x0163:
            r0 = move-exception
            r1.applyAndCheck(r6)
            throw r0
        L_0x0168:
            r17 = r0
            java.util.Set r0 = r17.keySet()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.List r0 = kotlin.collections.CollectionsKt.toList(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.Recomposer.performInsertValues(java.util.List, androidx.collection.MutableScatterSet):java.util.List");
    }
}
