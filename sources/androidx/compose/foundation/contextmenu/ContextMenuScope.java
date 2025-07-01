package androidx.compose.foundation.contextmenu;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0007\b\u0000¢\u0006\u0002\u0010\u0002J\u0017\u0010\f\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0006H\u0001¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\nH\u0000¢\u0006\u0002\b\u0010Jl\u0010\u0011\u001a\u00020\n2\u0011\u0010\u0012\u001a\r\u0012\u0004\u0012\u00020\u00140\u0013¢\u0006\u0002\b\u000b2\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00182*\b\u0002\u0010\u0019\u001a$\u0012\u0013\u0012\u00110\u001a¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005¢\u0006\u0002\b\u000b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\n0\u0013¢\u0006\u0002\u0010\u001dR4\u0010\u0003\u001a(\u0012$\u0012\"\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005¢\u0006\u0002\b\u000b0\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Landroidx/compose/foundation/contextmenu/ContextMenuScope;", "", "()V", "composables", "Landroidx/compose/runtime/snapshots/SnapshotStateList;", "Lkotlin/Function1;", "Landroidx/compose/foundation/contextmenu/ContextMenuColors;", "Lkotlin/ParameterName;", "name", "colors", "", "Landroidx/compose/runtime/Composable;", "Content", "Content$foundation_release", "(Landroidx/compose/foundation/contextmenu/ContextMenuColors;Landroidx/compose/runtime/Composer;I)V", "clear", "clear$foundation_release", "item", "label", "Lkotlin/Function0;", "", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "leadingIcon", "Landroidx/compose/ui/graphics/Color;", "iconColor", "onClick", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function0;)V", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ContextMenuUi.android.kt */
public final class ContextMenuScope {
    public static final int $stable = 0;
    private final SnapshotStateList<Function3<ContextMenuColors, Composer, Integer, Unit>> composables = SnapshotStateKt.mutableStateListOf();

    public final void Content$foundation_release(ContextMenuColors contextMenuColors, Composer composer, int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(1320309496);
        ComposerKt.sourceInformation(startRestartGroup, "C(Content)*234@8533L18:ContextMenuUi.android.kt#3xeu6s");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed((Object) contextMenuColors) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed((Object) this) ? 32 : 16;
        }
        if ((i2 & 19) != 18 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1320309496, i2, -1, "androidx.compose.foundation.contextmenu.ContextMenuScope.Content (ContextMenuUi.android.kt:233)");
            }
            List list = this.composables;
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                ((Function3) list.get(i3)).invoke(contextMenuColors, startRestartGroup, Integer.valueOf(i2 & 14));
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new ContextMenuScope$Content$2(this, contextMenuColors, i));
        }
    }

    public final void clear$foundation_release() {
        this.composables.clear();
    }

    public static /* synthetic */ void item$default(ContextMenuScope contextMenuScope, Function2 function2, Modifier modifier, boolean z, Function3 function3, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            modifier = Modifier.Companion;
        }
        Modifier modifier2 = modifier;
        if ((i & 4) != 0) {
            z = true;
        }
        boolean z2 = z;
        if ((i & 8) != 0) {
            function3 = null;
        }
        contextMenuScope.item(function2, modifier2, z2, function3, function0);
    }

    public final void item(Function2<? super Composer, ? super Integer, String> function2, Modifier modifier, boolean z, Function3<? super Color, ? super Composer, ? super Integer, Unit> function3, Function0<Unit> function0) {
        this.composables.add(ComposableLambdaKt.composableLambdaInstance(262103052, true, new ContextMenuScope$item$1(function2, z, modifier, function3, function0)));
    }
}
