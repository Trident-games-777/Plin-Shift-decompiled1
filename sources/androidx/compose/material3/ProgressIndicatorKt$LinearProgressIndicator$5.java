package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: ProgressIndicator.kt */
final class ProgressIndicatorKt$LinearProgressIndicator$5 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ long $color;
    final /* synthetic */ Function1<DrawScope, Unit> $drawStopIndicator;
    final /* synthetic */ float $gapSize;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ Function0<Float> $progress;
    final /* synthetic */ int $strokeCap;
    final /* synthetic */ long $trackColor;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ProgressIndicatorKt$LinearProgressIndicator$5(Function0<Float> function0, Modifier modifier, long j, long j2, int i, float f, Function1<? super DrawScope, Unit> function1, int i2, int i3) {
        super(2);
        this.$progress = function0;
        this.$modifier = modifier;
        this.$color = j;
        this.$trackColor = j2;
        this.$strokeCap = i;
        this.$gapSize = f;
        this.$drawStopIndicator = function1;
        this.$$changed = i2;
        this.$$default = i3;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        ProgressIndicatorKt.m2353LinearProgressIndicatorGJbTh5U(this.$progress, this.$modifier, this.$color, this.$trackColor, this.$strokeCap, this.$gapSize, this.$drawStopIndicator, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
    }
}
