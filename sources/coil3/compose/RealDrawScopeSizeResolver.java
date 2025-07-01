package coil3.compose;

import androidx.compose.ui.geometry.Size;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J\u000e\u0010\u000b\u001a\u00020\fH@¢\u0006\u0002\u0010\rR\u001a\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcoil3/compose/RealDrawScopeSizeResolver;", "Lcoil3/compose/DrawScopeSizeResolver;", "<init>", "()V", "latestSize", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/compose/ui/geometry/Size;", "connect", "", "sizes", "size", "Lcoil3/size/Size;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "coil-compose-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: DrawScopeSizeResolver.kt */
final class RealDrawScopeSizeResolver implements DrawScopeSizeResolver {
    private final MutableSharedFlow<Flow<Size>> latestSize = SharedFlowKt.MutableSharedFlow$default(1, 0, BufferOverflow.DROP_OLDEST, 2, (Object) null);

    public void connect(Flow<Size> flow) {
        this.latestSize.tryEmit(flow);
    }

    public Object size(Continuation<? super coil3.size.Size> continuation) {
        return FlowKt.first(new RealDrawScopeSizeResolver$size$$inlined$mapNotNull$1(FlowKt.transformLatest(this.latestSize, new RealDrawScopeSizeResolver$size$2((Continuation<? super RealDrawScopeSizeResolver$size$2>) null))), continuation);
    }
}
