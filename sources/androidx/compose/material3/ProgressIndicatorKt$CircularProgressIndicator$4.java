package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: ProgressIndicator.kt */
final class ProgressIndicatorKt$CircularProgressIndicator$4 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ long $color;
    final /* synthetic */ float $gapSize;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ Function0<Float> $progress;
    final /* synthetic */ int $strokeCap;
    final /* synthetic */ float $strokeWidth;
    final /* synthetic */ long $trackColor;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ProgressIndicatorKt$CircularProgressIndicator$4(Function0<Float> function0, Modifier modifier, long j, float f, long j2, int i, float f2, int i2, int i3) {
        super(2);
        this.$progress = function0;
        this.$modifier = modifier;
        this.$color = j;
        this.$strokeWidth = f;
        this.$trackColor = j2;
        this.$strokeCap = i;
        this.$gapSize = f2;
        this.$$changed = i2;
        this.$$default = i3;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        ProgressIndicatorKt.m2348CircularProgressIndicatorIyT6zlY(this.$progress, this.$modifier, this.$color, this.$strokeWidth, this.$trackColor, this.$strokeCap, this.$gapSize, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
    }
}
