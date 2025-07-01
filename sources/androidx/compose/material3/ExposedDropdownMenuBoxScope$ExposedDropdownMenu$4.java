package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: ExposedDropdownMenu.android.kt */
final class ExposedDropdownMenuBoxScope$ExposedDropdownMenu$4 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$changed1;
    final /* synthetic */ int $$default;
    final /* synthetic */ BorderStroke $border;
    final /* synthetic */ long $containerColor;
    final /* synthetic */ Function3<ColumnScope, Composer, Integer, Unit> $content;
    final /* synthetic */ boolean $expanded;
    final /* synthetic */ boolean $focusable;
    final /* synthetic */ boolean $matchTextFieldWidth;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ Function0<Unit> $onDismissRequest;
    final /* synthetic */ ScrollState $scrollState;
    final /* synthetic */ float $shadowElevation;
    final /* synthetic */ Shape $shape;
    final /* synthetic */ ExposedDropdownMenuBoxScope $tmp0_rcvr;
    final /* synthetic */ float $tonalElevation;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ExposedDropdownMenuBoxScope$ExposedDropdownMenu$4(ExposedDropdownMenuBoxScope exposedDropdownMenuBoxScope, boolean z, Function0<Unit> function0, Modifier modifier, ScrollState scrollState, boolean z2, boolean z3, Shape shape, long j, float f, float f2, BorderStroke borderStroke, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, int i, int i2, int i3) {
        super(2);
        this.$tmp0_rcvr = exposedDropdownMenuBoxScope;
        this.$expanded = z;
        this.$onDismissRequest = function0;
        this.$modifier = modifier;
        this.$scrollState = scrollState;
        this.$focusable = z2;
        this.$matchTextFieldWidth = z3;
        this.$shape = shape;
        this.$containerColor = j;
        this.$tonalElevation = f;
        this.$shadowElevation = f2;
        this.$border = borderStroke;
        this.$content = function3;
        this.$$changed = i;
        this.$$changed1 = i2;
        this.$$default = i3;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        this.$tmp0_rcvr.m2051ExposedDropdownMenukbRbctU(this.$expanded, this.$onDismissRequest, this.$modifier, this.$scrollState, this.$focusable, this.$matchTextFieldWidth, this.$shape, this.$containerColor, this.$tonalElevation, this.$shadowElevation, this.$border, this.$content, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), RecomposeScopeImplKt.updateChangedFlags(this.$$changed1), this.$$default);
    }
}
