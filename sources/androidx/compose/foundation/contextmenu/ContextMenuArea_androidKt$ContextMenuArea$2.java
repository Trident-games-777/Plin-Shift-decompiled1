package androidx.compose.foundation.contextmenu;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: ContextMenuArea.android.kt */
final class ContextMenuArea_androidKt$ContextMenuArea$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ Function2<Composer, Integer, Unit> $content;
    final /* synthetic */ Function1<ContextMenuScope, Unit> $contextMenuBuilderBlock;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ Function0<Unit> $onDismiss;
    final /* synthetic */ ContextMenuState $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ContextMenuArea_androidKt$ContextMenuArea$2(ContextMenuState contextMenuState, Function0<Unit> function0, Function1<? super ContextMenuScope, Unit> function1, Modifier modifier, boolean z, Function2<? super Composer, ? super Integer, Unit> function2, int i, int i2) {
        super(2);
        this.$state = contextMenuState;
        this.$onDismiss = function0;
        this.$contextMenuBuilderBlock = function1;
        this.$modifier = modifier;
        this.$enabled = z;
        this.$content = function2;
        this.$$changed = i;
        this.$$default = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        ContextMenuArea_androidKt.ContextMenuArea(this.$state, this.$onDismiss, this.$contextMenuBuilderBlock, this.$modifier, this.$enabled, this.$content, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
    }
}
