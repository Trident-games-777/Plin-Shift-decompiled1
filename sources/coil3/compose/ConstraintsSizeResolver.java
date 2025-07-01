package coil3.compose;

import androidx.compose.ui.layout.LayoutModifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import coil3.size.SizeResolver;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000e\u0010\b\u001a\u00020\tH@¢\u0006\u0002\u0010\nJ#\u0010\u000b\u001a\u00020\f*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u0007¢\u0006\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcoil3/compose/ConstraintsSizeResolver;", "Lcoil3/size/SizeResolver;", "Landroidx/compose/ui/layout/LayoutModifier;", "<init>", "()V", "latestConstraints", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Landroidx/compose/ui/unit/Constraints;", "size", "Lcoil3/size/Size;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "setConstraints", "", "setConstraints-BRTryo0", "(J)V", "coil-compose-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: ConstraintsSizeResolver.kt */
public final class ConstraintsSizeResolver implements SizeResolver, LayoutModifier {
    public static final int $stable = 0;
    private final MutableSharedFlow<Constraints> latestConstraints = SharedFlowKt.MutableSharedFlow$default(1, 0, BufferOverflow.DROP_OLDEST, 2, (Object) null);

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object size(kotlin.coroutines.Continuation<? super coil3.size.Size> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof coil3.compose.ConstraintsSizeResolver$size$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            coil3.compose.ConstraintsSizeResolver$size$1 r0 = (coil3.compose.ConstraintsSizeResolver$size$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            coil3.compose.ConstraintsSizeResolver$size$1 r0 = new coil3.compose.ConstraintsSizeResolver$size$1
            r0.<init>(r5, r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0032
            if (r2 != r3) goto L_0x002a
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x004a
        L_0x002a:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r6)
            kotlinx.coroutines.flow.MutableSharedFlow<androidx.compose.ui.unit.Constraints> r6 = r5.latestConstraints
            kotlinx.coroutines.flow.Flow r6 = (kotlinx.coroutines.flow.Flow) r6
            coil3.compose.ConstraintsSizeResolver$size$2 r2 = new coil3.compose.ConstraintsSizeResolver$size$2
            r4 = 0
            r2.<init>(r4)
            kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2
            r0.label = r3
            java.lang.Object r6 = kotlinx.coroutines.flow.FlowKt.first(r6, r2, r0)
            if (r6 != r1) goto L_0x004a
            return r1
        L_0x004a:
            androidx.compose.ui.unit.Constraints r6 = (androidx.compose.ui.unit.Constraints) r6
            long r0 = r6.m7058unboximpl()
            coil3.size.Size r6 = coil3.compose.internal.UtilsKt.m7497toSizeBRTryo0(r0)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: coil3.compose.ConstraintsSizeResolver.size(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public MeasureResult m7467measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        this.latestConstraints.tryEmit(Constraints.m7040boximpl(j));
        Placeable r9 = measurable.m5848measureBRTryo0(j);
        return MeasureScope.layout$default(measureScope, r9.getWidth(), r9.getHeight(), (Map) null, new ConstraintsSizeResolver$$ExternalSyntheticLambda0(r9), 4, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final Unit measure_3p2s80s$lambda$0(Placeable placeable, Placeable.PlacementScope placementScope) {
        Placeable.PlacementScope.place$default(placementScope, placeable, 0, 0, 0.0f, 4, (Object) null);
        return Unit.INSTANCE;
    }

    /* renamed from: setConstraints-BRTryo0  reason: not valid java name */
    public final void m7468setConstraintsBRTryo0(long j) {
        this.latestConstraints.tryEmit(Constraints.m7040boximpl(j));
    }
}
