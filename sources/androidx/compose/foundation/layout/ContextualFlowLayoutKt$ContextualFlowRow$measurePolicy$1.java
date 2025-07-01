package androidx.compose.foundation.layout;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u000b¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", "index", "", "info", "Landroidx/compose/foundation/layout/FlowLineInfo;", "invoke", "(ILandroidx/compose/foundation/layout/FlowLineInfo;Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: ContextualFlowLayout.kt */
final class ContextualFlowLayoutKt$ContextualFlowRow$measurePolicy$1 extends Lambda implements Function4<Integer, FlowLineInfo, Composer, Integer, Unit> {
    final /* synthetic */ Function4<ContextualFlowRowScope, Integer, Composer, Integer, Unit> $content;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ContextualFlowLayoutKt$ContextualFlowRow$measurePolicy$1(Function4<? super ContextualFlowRowScope, ? super Integer, ? super Composer, ? super Integer, Unit> function4) {
        super(4);
        this.$content = function4;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        invoke(((Number) obj).intValue(), (FlowLineInfo) obj2, (Composer) obj3, ((Number) obj4).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i, FlowLineInfo flowLineInfo, Composer composer, int i2) {
        ComposerKt.sourceInformation(composer, "C97@4208L14:ContextualFlowLayout.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-8464804, i2, -1, "androidx.compose.foundation.layout.ContextualFlowRow.<anonymous> (ContextualFlowLayout.kt:91)");
        }
        this.$content.invoke(new ContextualFlowRowScopeImpl(flowLineInfo.getLineIndex$foundation_layout_release(), flowLineInfo.getPositionInLine$foundation_layout_release(), flowLineInfo.m701getMaxMainAxisSizeD9Ej5fM$foundation_layout_release(), flowLineInfo.m700getMaxCrossAxisSizeD9Ej5fM$foundation_layout_release(), (DefaultConstructorMarker) null), Integer.valueOf(i), composer, Integer.valueOf((i2 << 3) & 112));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
