package androidx.compose.animation;

import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntSizeKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"<anonymous>", "Landroidx/compose/ui/layout/MeasureResult;", "T", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "invoke-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AnimatedVisibility.kt */
final class AnimatedVisibilityKt$AnimatedEnterExitImpl$2$1 extends Lambda implements Function3<MeasureScope, Measurable, Constraints, MeasureResult> {
    final /* synthetic */ OnLookaheadMeasured $onLookaheadMeasured;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AnimatedVisibilityKt$AnimatedEnterExitImpl$2$1(OnLookaheadMeasured onLookaheadMeasured) {
        super(3);
        this.$onLookaheadMeasured = onLookaheadMeasured;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return m72invoke3p2s80s((MeasureScope) obj, (Measurable) obj2, ((Constraints) obj3).m7058unboximpl());
    }

    /* renamed from: invoke-3p2s80s  reason: not valid java name */
    public final MeasureResult m72invoke3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        Placeable r11 = measurable.m5848measureBRTryo0(j);
        OnLookaheadMeasured onLookaheadMeasured = this.$onLookaheadMeasured;
        if (measureScope.isLookingAhead()) {
            onLookaheadMeasured.m104invokeozmzZPI(IntSizeKt.IntSize(r11.getWidth(), r11.getHeight()));
        }
        return MeasureScope.layout$default(measureScope, r11.getWidth(), r11.getHeight(), (Map) null, new AnimatedVisibilityKt$AnimatedEnterExitImpl$2$1$1$1(r11), 4, (Object) null);
    }
}
