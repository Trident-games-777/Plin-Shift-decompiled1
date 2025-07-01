package androidx.compose.runtime;

import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterSet;
import androidx.compose.runtime.Recomposer;
import androidx.compose.runtime.collection.ScatterSetWrapper;
import androidx.compose.runtime.snapshots.ReaderKind;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.StateObjectImpl;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CancellableContinuation;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "changed", "", "", "<anonymous parameter 1>", "Landroidx/compose/runtime/snapshots/Snapshot;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Recomposer.kt */
final class Recomposer$recompositionRunner$2$unregisterApplyObserver$1 extends Lambda implements Function2<Set<? extends Object>, Snapshot, Unit> {
    final /* synthetic */ Recomposer this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Recomposer$recompositionRunner$2$unregisterApplyObserver$1(Recomposer recomposer) {
        super(2);
        this.this$0 = recomposer;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Set<? extends Object>) (Set) obj, (Snapshot) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(Set<? extends Object> set, Snapshot snapshot) {
        CancellableContinuation cancellableContinuation;
        Set<? extends Object> set2 = set;
        Object access$getStateLock$p = this.this$0.stateLock;
        Recomposer recomposer = this.this$0;
        synchronized (access$getStateLock$p) {
            if (((Recomposer.State) recomposer._state.getValue()).compareTo(Recomposer.State.Idle) >= 0) {
                MutableScatterSet access$getSnapshotInvalidations$p = recomposer.snapshotInvalidations;
                if (set2 instanceof ScatterSetWrapper) {
                    ScatterSet set$runtime_release = ((ScatterSetWrapper) set2).getSet$runtime_release();
                    Object[] objArr = set$runtime_release.elements;
                    long[] jArr = set$runtime_release.metadata;
                    int length = jArr.length - 2;
                    if (length >= 0) {
                        int i = 0;
                        while (true) {
                            long j = jArr[i];
                            if ((((~j) << 7) & j & -9187201950435737472L) != -9187201950435737472L) {
                                int i2 = 8 - ((~(i - length)) >>> 31);
                                for (int i3 = 0; i3 < i2; i3++) {
                                    if ((255 & j) < 128) {
                                        Object obj = objArr[(i << 3) + i3];
                                        if (obj instanceof StateObjectImpl) {
                                            ReaderKind.Companion companion = ReaderKind.Companion;
                                            if (!((StateObjectImpl) obj).m3817isReadInh_f27i8$runtime_release(ReaderKind.m3804constructorimpl(1))) {
                                            }
                                        }
                                        access$getSnapshotInvalidations$p.add(obj);
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
                    for (Object next : set2) {
                        if (next instanceof StateObjectImpl) {
                            ReaderKind.Companion companion2 = ReaderKind.Companion;
                            if (!((StateObjectImpl) next).m3817isReadInh_f27i8$runtime_release(ReaderKind.m3804constructorimpl(1))) {
                            }
                        }
                        access$getSnapshotInvalidations$p.add(next);
                    }
                }
                cancellableContinuation = recomposer.deriveStateLocked();
            } else {
                cancellableContinuation = null;
            }
        }
        if (cancellableContinuation != null) {
            Result.Companion companion3 = Result.Companion;
            cancellableContinuation.resumeWith(Result.m7823constructorimpl(Unit.INSTANCE));
        }
    }
}
