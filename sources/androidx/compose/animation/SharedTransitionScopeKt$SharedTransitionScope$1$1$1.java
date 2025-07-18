package androidx.compose.animation;

import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"<anonymous>", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "invoke-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: SharedTransitionScope.kt */
final class SharedTransitionScopeKt$SharedTransitionScope$1$1$1 extends Lambda implements Function3<MeasureScope, Measurable, Constraints, MeasureResult> {
    final /* synthetic */ SharedTransitionScopeImpl $sharedScope;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SharedTransitionScopeKt$SharedTransitionScope$1$1$1(SharedTransitionScopeImpl sharedTransitionScopeImpl) {
        super(3);
        this.$sharedScope = sharedTransitionScopeImpl;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return m120invoke3p2s80s((MeasureScope) obj, (Measurable) obj2, ((Constraints) obj3).m7058unboximpl());
    }

    /* renamed from: invoke-3p2s80s  reason: not valid java name */
    public final MeasureResult m120invoke3p2s80s(final MeasureScope measureScope, Measurable measurable, long j) {
        final Placeable r9 = measurable.m5848measureBRTryo0(j);
        int width = r9.getWidth();
        int height = r9.getHeight();
        final SharedTransitionScopeImpl sharedTransitionScopeImpl = this.$sharedScope;
        return MeasureScope.layout$default(measureScope, width, height, (Map) null, new Function1<Placeable.PlacementScope, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Placeable.PlacementScope) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Placeable.PlacementScope placementScope) {
                LayoutCoordinates coordinates = placementScope.getCoordinates();
                if (coordinates != null) {
                    if (!measureScope.isLookingAhead()) {
                        sharedTransitionScopeImpl.setRoot$animation_release(coordinates);
                    } else {
                        sharedTransitionScopeImpl.setNullableLookaheadRoot$animation_release(coordinates);
                    }
                }
                Placeable.PlacementScope.place$default(placementScope, r9, 0, 0, 0.0f, 4, (Object) null);
            }
        }, 4, (Object) null);
    }
}
