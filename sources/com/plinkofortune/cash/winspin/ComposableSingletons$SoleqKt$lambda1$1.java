package com.plinkofortune.cash.winspin;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.plinkofortune.cash.winspin.nav.AppNavKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* renamed from: com.plinkofortune.cash.winspin.ComposableSingletons$SoleqKt$lambda-1$1  reason: invalid class name */
/* compiled from: Soleq.kt */
final class ComposableSingletons$SoleqKt$lambda1$1 implements Function2<Composer, Integer, Unit> {
    public static final ComposableSingletons$SoleqKt$lambda1$1 INSTANCE = new ComposableSingletons$SoleqKt$lambda1$1();

    ComposableSingletons$SoleqKt$lambda1$1() {
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        if ((i & 3) != 2 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2023027856, i, -1, StringFog.decrypt(new byte[]{75, 66, -1, -3, -84, -17, -9, 115, 67, 66, -12, -68, -82, -9, -21, 115, 77, 3, -15, -78, -81, -21, -80, 106, 65, 67, -31, -93, -75, -19, -80, 94, 71, SignedBytes.MAX_POWER_OF_TWO, -30, -68, -81, -30, -4, 113, 77, 126, -5, -67, -69, -17, -5, 105, 71, 67, -31, -9, -113, -20, -14, 120, 89, 102, -26, -3, -80, -30, -13, Byte.MAX_VALUE, 76, 76, -65, -30, -14, -65, -1, 115, 71, 67, -21, -66, -77, -10, -19, 35, 8, 5, -63, -68, -80, -26, -17, 51, 67, 89, -88, -25, -24, -86}, new byte[]{40, 45, -110, -45, -36, -125, -98, Ascii.GS}));
            }
            AppNavKt.AppNav(composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
