package androidx.compose.runtime;

import androidx.collection.MutableObjectIntMap;
import androidx.collection.MutableScatterMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "composition", "Landroidx/compose/runtime/Composition;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: RecomposeScopeImpl.kt */
final class RecomposeScopeImpl$end$1$2 extends Lambda implements Function1<Composition, Unit> {
    final /* synthetic */ MutableObjectIntMap<Object> $instances;
    final /* synthetic */ int $token;
    final /* synthetic */ RecomposeScopeImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RecomposeScopeImpl$end$1$2(RecomposeScopeImpl recomposeScopeImpl, int i, MutableObjectIntMap<Object> mutableObjectIntMap) {
        super(1);
        this.this$0 = recomposeScopeImpl;
        this.$token = i;
        this.$instances = mutableObjectIntMap;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Composition) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Composition composition) {
        int i;
        Composition composition2 = composition;
        if (this.this$0.currentToken == this.$token && Intrinsics.areEqual((Object) this.$instances, (Object) this.this$0.trackedInstances) && (composition2 instanceof CompositionImpl)) {
            MutableObjectIntMap<Object> mutableObjectIntMap = this.$instances;
            int i2 = this.$token;
            RecomposeScopeImpl recomposeScopeImpl = this.this$0;
            long[] jArr = mutableObjectIntMap.metadata;
            int length = jArr.length - 2;
            if (length >= 0) {
                int i3 = 0;
                while (true) {
                    long j = jArr[i3];
                    if ((((~j) << 7) & j & -9187201950435737472L) != -9187201950435737472L) {
                        int i4 = 8;
                        int i5 = 8 - ((~(i3 - length)) >>> 31);
                        int i6 = 0;
                        while (i6 < i5) {
                            if ((255 & j) < 128) {
                                int i7 = (i3 << 3) + i6;
                                Object obj = mutableObjectIntMap.keys[i7];
                                boolean z = mutableObjectIntMap.values[i7] != i2;
                                i = i4;
                                if (z) {
                                    CompositionImpl compositionImpl = (CompositionImpl) composition2;
                                    compositionImpl.removeObservation$runtime_release(obj, recomposeScopeImpl);
                                    if (obj instanceof DerivedState) {
                                        compositionImpl.removeDerivedStateObservation$runtime_release((DerivedState) obj);
                                        MutableScatterMap access$getTrackedDependencies$p = recomposeScopeImpl.trackedDependencies;
                                        if (access$getTrackedDependencies$p != null) {
                                            access$getTrackedDependencies$p.remove(obj);
                                        }
                                    }
                                }
                                if (z) {
                                    mutableObjectIntMap.removeValueAt(i7);
                                }
                            } else {
                                i = i4;
                            }
                            j >>= i;
                            i6++;
                            i4 = i;
                        }
                        if (i5 != i4) {
                            return;
                        }
                    }
                    if (i3 != length) {
                        i3++;
                    } else {
                        return;
                    }
                }
            }
        }
    }
}
