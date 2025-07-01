package androidx.compose.animation;

import androidx.collection.ScatterMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: SharedTransitionScope.kt */
final class SharedTransitionScopeImpl$observeAnimatingBlock$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ SharedTransitionScopeImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SharedTransitionScopeImpl$observeAnimatingBlock$1(SharedTransitionScopeImpl sharedTransitionScopeImpl) {
        super(0);
        this.this$0 = sharedTransitionScopeImpl;
    }

    public final void invoke() {
        ScatterMap access$getSharedElements$p = this.this$0.sharedElements;
        Object[] objArr = access$getSharedElements$p.keys;
        Object[] objArr2 = access$getSharedElements$p.values;
        long[] jArr = access$getSharedElements$p.metadata;
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
                            Object obj = objArr[i4];
                            if (((SharedElement) objArr2[i4]).isAnimating()) {
                                return;
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
    }
}
