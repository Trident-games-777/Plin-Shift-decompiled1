package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.window.DialogProperties;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidAlertDialog.android.kt */
final class AndroidAlertDialog_androidKt$AlertDialog$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$changed1;
    final /* synthetic */ int $$default;
    final /* synthetic */ Function2<Composer, Integer, Unit> $confirmButton;
    final /* synthetic */ long $containerColor;
    final /* synthetic */ Function2<Composer, Integer, Unit> $dismissButton;
    final /* synthetic */ Function2<Composer, Integer, Unit> $icon;
    final /* synthetic */ long $iconContentColor;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ Function0<Unit> $onDismissRequest;
    final /* synthetic */ DialogProperties $properties;
    final /* synthetic */ Shape $shape;
    final /* synthetic */ Function2<Composer, Integer, Unit> $text;
    final /* synthetic */ long $textContentColor;
    final /* synthetic */ Function2<Composer, Integer, Unit> $title;
    final /* synthetic */ long $titleContentColor;
    final /* synthetic */ float $tonalElevation;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AndroidAlertDialog_androidKt$AlertDialog$1(Function0<Unit> function0, Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, Function2<? super Composer, ? super Integer, Unit> function25, Shape shape, long j, long j2, long j3, long j4, float f, DialogProperties dialogProperties, int i, int i2, int i3) {
        super(2);
        this.$onDismissRequest = function0;
        this.$confirmButton = function2;
        this.$modifier = modifier;
        this.$dismissButton = function22;
        this.$icon = function23;
        this.$title = function24;
        this.$text = function25;
        this.$shape = shape;
        this.$containerColor = j;
        this.$iconContentColor = j2;
        this.$titleContentColor = j3;
        this.$textContentColor = j4;
        this.$tonalElevation = f;
        this.$properties = dialogProperties;
        this.$$changed = i;
        this.$$changed1 = i2;
        this.$$default = i3;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        Function0<Unit> function0 = this.$onDismissRequest;
        Function2<Composer, Integer, Unit> function2 = this.$confirmButton;
        Modifier modifier = this.$modifier;
        Function2<Composer, Integer, Unit> function22 = this.$dismissButton;
        Function2<Composer, Integer, Unit> function23 = this.$icon;
        Function2<Composer, Integer, Unit> function24 = this.$title;
        Function2<Composer, Integer, Unit> function25 = this.$text;
        Shape shape = this.$shape;
        long j = this.$containerColor;
        long j2 = this.$iconContentColor;
        long j3 = this.$titleContentColor;
        Function0<Unit> function02 = function0;
        Function2<Composer, Integer, Unit> function26 = function2;
        long j4 = this.$textContentColor;
        float f = this.$tonalElevation;
        DialogProperties dialogProperties = this.$properties;
        DialogProperties dialogProperties2 = dialogProperties;
        Function2<Composer, Integer, Unit> function27 = function26;
        long j5 = j4;
        float f2 = f;
        AndroidAlertDialog_androidKt.m1710AlertDialogOix01E0(function02, function27, modifier, function22, function23, function24, function25, shape, j, j2, j3, j5, f2, dialogProperties2, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), RecomposeScopeImplKt.updateChangedFlags(this.$$changed1), this.$$default);
    }
}
