package androidx.compose.material3.pulltorefresh;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.ProgressIndicatorKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u000b¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "refreshing", "", "invoke", "(ZLandroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: PullToRefresh.kt */
final class PullToRefreshDefaults$Indicator$1$1 extends Lambda implements Function3<Boolean, Composer, Integer, Unit> {
    final /* synthetic */ long $color;
    final /* synthetic */ PullToRefreshState $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PullToRefreshDefaults$Indicator$1$1(long j, PullToRefreshState pullToRefreshState) {
        super(3);
        this.$color = j;
        this.$state = pullToRefreshState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke(((Boolean) obj).booleanValue(), (Composer) obj2, ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C:PullToRefresh.kt#djiw08");
        if ((i & 6) == 0) {
            i |= composer.changed(z) ? 4 : 2;
        }
        if ((i & 19) != 18 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(167807595, i, -1, "androidx.compose.material3.pulltorefresh.PullToRefreshDefaults.Indicator.<anonymous>.<anonymous> (PullToRefresh.kt:455)");
            }
            if (z) {
                composer.startReplaceGroup(576835739);
                ComposerKt.sourceInformation(composer, "456@17267L201");
                Composer composer2 = composer;
                ProgressIndicatorKt.m2349CircularProgressIndicatorLxG7B9w(SizeKt.m845size3ABfNKs(Modifier.Companion, PullToRefreshKt.getSpinnerSize()), this.$color, PullToRefreshKt.StrokeWidth, 0, 0, composer2, 390, 24);
                composer2.endReplaceGroup();
            } else {
                Composer composer3 = composer;
                composer3.startReplaceGroup(577079337);
                ComposerKt.sourceInformation(composer3, "463@17581L26,462@17514L155");
                ComposerKt.sourceInformationMarkerStart(composer3, -1505402512, "CC(remember):PullToRefresh.kt#9igjgp");
                boolean changed = composer3.changed((Object) this.$state);
                PullToRefreshState pullToRefreshState = this.$state;
                Object rememberedValue = composer3.rememberedValue();
                if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new PullToRefreshDefaults$Indicator$1$1$1$1(pullToRefreshState);
                    composer3.updateRememberedValue(rememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer3);
                PullToRefreshKt.m3010CircularArrowProgressIndicatorRPmYEkk((Function0) rememberedValue, this.$color, composer3, 0);
                composer3.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
