package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.window.PopupProperties;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidMenu.android.kt */
final class AndroidMenu_androidKt$DropdownMenu$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$changed1;
    final /* synthetic */ int $$default;
    final /* synthetic */ BorderStroke $border;
    final /* synthetic */ long $containerColor;
    final /* synthetic */ Function3<ColumnScope, Composer, Integer, Unit> $content;
    final /* synthetic */ boolean $expanded;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ long $offset;
    final /* synthetic */ Function0<Unit> $onDismissRequest;
    final /* synthetic */ PopupProperties $properties;
    final /* synthetic */ ScrollState $scrollState;
    final /* synthetic */ float $shadowElevation;
    final /* synthetic */ Shape $shape;
    final /* synthetic */ float $tonalElevation;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AndroidMenu_androidKt$DropdownMenu$2(boolean z, Function0<Unit> function0, Modifier modifier, long j, ScrollState scrollState, PopupProperties popupProperties, Shape shape, long j2, float f, float f2, BorderStroke borderStroke, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, int i, int i2, int i3) {
        super(2);
        this.$expanded = z;
        this.$onDismissRequest = function0;
        this.$modifier = modifier;
        this.$offset = j;
        this.$scrollState = scrollState;
        this.$properties = popupProperties;
        this.$shape = shape;
        this.$containerColor = j2;
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
        AndroidMenu_androidKt.m1713DropdownMenuIlH_yew(this.$expanded, this.$onDismissRequest, this.$modifier, this.$offset, this.$scrollState, this.$properties, this.$shape, this.$containerColor, this.$tonalElevation, this.$shadowElevation, this.$border, this.$content, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), RecomposeScopeImplKt.updateChangedFlags(this.$$changed1), this.$$default);
    }
}
