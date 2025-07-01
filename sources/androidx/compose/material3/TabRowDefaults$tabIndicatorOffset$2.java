package androidx.compose.material3;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/ui/Modifier;", "invoke", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TabRow.kt */
final class TabRowDefaults$tabIndicatorOffset$2 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {
    final /* synthetic */ TabPosition $currentTabPosition;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TabRowDefaults$tabIndicatorOffset$2(TabPosition tabPosition) {
        super(3);
        this.$currentTabPosition = tabPosition;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
    }

    public final Modifier invoke(Modifier modifier, Composer composer, int i) {
        composer.startReplaceGroup(-1541271084);
        ComposerKt.sourceInformation(composer, "C1266@53909L151,1271@54112L150,1277@54370L53:TabRow.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1541271084, i, -1, "androidx.compose.material3.TabRowDefaults.tabIndicatorOffset.<anonymous> (TabRow.kt:1265)");
        }
        Composer composer2 = composer;
        State<Dp> r9 = AnimateAsStateKt.m140animateDpAsStateAjpBEmI(this.$currentTabPosition.m2580getWidthD9Ej5fM(), TabRowKt.TabRowIndicatorSpec, (String) null, (Function1<? super Dp, Unit>) null, composer2, 0, 12);
        State<Dp> r10 = AnimateAsStateKt.m140animateDpAsStateAjpBEmI(this.$currentTabPosition.m2578getLeftD9Ej5fM(), TabRowKt.TabRowIndicatorSpec, (String) null, (Function1<? super Dp, Unit>) null, composer2, 0, 12);
        Modifier wrapContentSize$default = SizeKt.wrapContentSize$default(SizeKt.fillMaxWidth$default(modifier, 0.0f, 1, (Object) null), Alignment.Companion.getBottomStart(), false, 2, (Object) null);
        ComposerKt.sourceInformationMarkerStart(composer2, -1825077707, "CC(remember):TabRow.kt#9igjgp");
        boolean changed = composer2.changed((Object) r10);
        Object rememberedValue = composer2.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new TabRowDefaults$tabIndicatorOffset$2$1$1(r10);
            composer2.updateRememberedValue(rememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer2);
        Modifier r8 = SizeKt.m850width3ABfNKs(OffsetKt.offset(wrapContentSize$default, (Function1) rememberedValue), invoke$lambda$0(r9));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer2.endReplaceGroup();
        return r8;
    }

    private static final float invoke$lambda$0(State<Dp> state) {
        return state.getValue().m7125unboximpl();
    }

    /* access modifiers changed from: private */
    public static final float invoke$lambda$1(State<Dp> state) {
        return state.getValue().m7125unboximpl();
    }
}
