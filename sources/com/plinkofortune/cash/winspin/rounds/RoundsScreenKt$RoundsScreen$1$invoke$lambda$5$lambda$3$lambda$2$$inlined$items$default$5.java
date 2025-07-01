package com.plinkofortune.cash.winspin.rounds;

import androidx.compose.foundation.lazy.grid.LazyGridItemScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import com.google.common.base.Ascii;
import com.plinkofortune.cash.winspin.StringFog;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Lambda;
import okio.Utf8;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u000b¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "Landroidx/compose/foundation/lazy/grid/LazyGridItemScope;", "it", "", "invoke", "(Landroidx/compose/foundation/lazy/grid/LazyGridItemScope;ILandroidx/compose/runtime/Composer;I)V", "androidx/compose/foundation/lazy/grid/LazyGridDslKt$items$5"}, k = 3, mv = {2, 0, 0}, xi = 48)
/* compiled from: LazyGridDsl.kt */
public final class RoundsScreenKt$RoundsScreen$1$invoke$lambda$5$lambda$3$lambda$2$$inlined$items$default$5 extends Lambda implements Function4<LazyGridItemScope, Integer, Composer, Integer, Unit> {
    final /* synthetic */ List $items;
    final /* synthetic */ Function1 $mortal$inlined;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RoundsScreenKt$RoundsScreen$1$invoke$lambda$5$lambda$3$lambda$2$$inlined$items$default$5(List list, Function1 function1) {
        super(4);
        this.$items = list;
        this.$mortal$inlined = function1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        invoke((LazyGridItemScope) obj, ((Number) obj2).intValue(), (Composer) obj3, ((Number) obj4).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(LazyGridItemScope lazyGridItemScope, int i, Composer composer, int i2) {
        int i3;
        ComposerKt.sourceInformation(composer, StringFog.decrypt(new byte[]{75, -17, -61, -14, 38, -105, -124, -118, Utf8.REPLACEMENT_BYTE, -21, -71, -12, 84, -100, -15, -35, 114, -94, -78, -76, Ascii.SI, -62, -7, -49, 100, -11, -98, -78, 69, -111, -118, -123, 57, -83, -124}, new byte[]{8, -37, -11, -58, 102, -90, -67, -68}));
        if ((i2 & 6) == 0) {
            i3 = (composer.changed((Object) lazyGridItemScope) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            i3 |= composer.changed(i) ? 32 : 16;
        }
        if ((i3 & 147) != 146 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(699646206, i3, -1, StringFog.decrypt(new byte[]{8, -111, -120, -81, 93, -78, -100, 6, 71, -100, -125, -80, 66, -76, -117, Ascii.ESC, 71, -103, -125, -88, 92, -65, -103, 10, 0, -112, -126, -13, 94, -70, -126, 7, 71, -104, -98, -76, 86, -11, -111, 10, Ascii.FF, -110, -97, -13, Ascii.SO, -70, -106, 17, 7, -122, -127, -78, 71, -88, -58, 94, 65, -77, -115, -89, 75, -100, -118, Ascii.ETB, Ascii.CR, -69, -97, -79, Ascii.FS, -80, -116, 68, 93, -55, -40, -12}, new byte[]{105, -1, -20, -35, 50, -37, -8, 126}));
            }
            RoundModel roundModel = (RoundModel) this.$items.get(i);
            composer.startReplaceGroup(548089598);
            composer.startReplaceGroup(-536508523);
            boolean changed = composer.changed((Object) roundModel) | composer.changed((Object) this.$mortal$inlined);
            Object rememberedValue = composer.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new RoundsScreenKt$RoundsScreen$1$1$1$1$1$1$1(roundModel, this.$mortal$inlined);
                composer.updateRememberedValue(rememberedValue);
            }
            composer.endReplaceGroup();
            OneRoundKt.OneRound(roundModel, (Function0) rememberedValue, composer, 0);
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
