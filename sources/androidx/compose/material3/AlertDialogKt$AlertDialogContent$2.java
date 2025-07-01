package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AlertDialog.kt */
final class AlertDialogKt$AlertDialogContent$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$changed1;
    final /* synthetic */ int $$default;
    final /* synthetic */ long $buttonContentColor;
    final /* synthetic */ Function2<Composer, Integer, Unit> $buttons;
    final /* synthetic */ long $containerColor;
    final /* synthetic */ Function2<Composer, Integer, Unit> $icon;
    final /* synthetic */ long $iconContentColor;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ Shape $shape;
    final /* synthetic */ Function2<Composer, Integer, Unit> $text;
    final /* synthetic */ long $textContentColor;
    final /* synthetic */ Function2<Composer, Integer, Unit> $title;
    final /* synthetic */ long $titleContentColor;
    final /* synthetic */ float $tonalElevation;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AlertDialogKt$AlertDialogContent$2(Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, Shape shape, long j, float f, long j2, long j3, long j4, long j5, int i, int i2, int i3) {
        super(2);
        this.$buttons = function2;
        this.$modifier = modifier;
        this.$icon = function22;
        this.$title = function23;
        this.$text = function24;
        this.$shape = shape;
        this.$containerColor = j;
        this.$tonalElevation = f;
        this.$buttonContentColor = j2;
        this.$iconContentColor = j3;
        this.$titleContentColor = j4;
        this.$textContentColor = j5;
        this.$$changed = i;
        this.$$changed1 = i2;
        this.$$default = i3;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        Function2<Composer, Integer, Unit> function2 = this.$buttons;
        Modifier modifier = this.$modifier;
        Function2<Composer, Integer, Unit> function22 = this.$icon;
        Function2<Composer, Integer, Unit> function23 = this.$title;
        Function2<Composer, Integer, Unit> function24 = this.$text;
        Shape shape = this.$shape;
        long j = this.$containerColor;
        float f = this.$tonalElevation;
        long j2 = this.$buttonContentColor;
        long j3 = this.$iconContentColor;
        long j4 = this.$titleContentColor;
        Function2<Composer, Integer, Unit> function25 = function2;
        long j5 = this.$textContentColor;
        int updateChangedFlags = RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1);
        int i2 = updateChangedFlags;
        Function2<Composer, Integer, Unit> function26 = function25;
        long j6 = j5;
        AlertDialogKt.m1704AlertDialogContent4hvqGtA(function26, modifier, function22, function23, function24, shape, j, f, j2, j3, j4, j6, composer, i2, RecomposeScopeImplKt.updateChangedFlags(this.$$changed1), this.$$default);
    }
}
