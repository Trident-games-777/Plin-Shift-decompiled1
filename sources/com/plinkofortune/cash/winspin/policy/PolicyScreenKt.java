package com.plinkofortune.cash.winspin.policy;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import com.google.common.base.Ascii;
import com.plinkofortune.cash.winspin.StringFog;
import com.plinkofortune.cash.winspin.ToolbarColumnKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import okio.Utf8;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001b\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\u0007¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"PolicyScreen", "", "back", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "app_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* compiled from: PolicyScreen.kt */
public final class PolicyScreenKt {
    /* access modifiers changed from: private */
    public static final Unit PolicyScreen$lambda$0(Function0 function0, int i, Composer composer, int i2) {
        PolicyScreen(function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void PolicyScreen(Function0<Unit> function0, Composer composer, int i) {
        int i2;
        int i3 = 4;
        Intrinsics.checkNotNullParameter(function0, StringFog.decrypt(new byte[]{-104, -57, -125, 36}, new byte[]{-6, -90, -32, 79, -42, -110, -72, -103}));
        Composer startRestartGroup = composer.startRestartGroup(-1945903528);
        if ((i & 6) == 0) {
            if (!startRestartGroup.changedInstance(function0)) {
                i3 = 2;
            }
            i2 = i3 | i;
        } else {
            i2 = i;
        }
        if ((i2 & 3) != 2 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1945903528, i2, -1, StringFog.decrypt(new byte[]{4, -79, Ascii.SI, -52, 91, -105, -30, 52, Ascii.FF, -79, 4, -115, 89, -113, -2, 52, 2, -16, 1, -125, 88, -109, -91, 45, Ascii.SO, -80, 17, -110, 66, -107, -91, 42, 8, -78, Ascii.VT, -127, 82, -43, -37, 53, Ascii.VT, -73, 1, -101, 120, -104, -7, Utf8.REPLACEMENT_BYTE, 2, -80, 66, -54, 123, -108, -25, 51, 4, -89, 49, -127, 89, -98, -18, 52, 73, -75, Ascii.SYN, -40, Ascii.CAN, -49, -94}, new byte[]{103, -34, 98, -30, 43, -5, -117, 90}));
            }
            ToolbarColumnKt.ToolbarColumn(function0, ComposableSingletons$PolicyScreenKt.INSTANCE.m7787getLambda1$app_release(), startRestartGroup, (i2 & 14) | 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new PolicyScreenKt$$ExternalSyntheticLambda0(function0, i));
        }
    }
}
