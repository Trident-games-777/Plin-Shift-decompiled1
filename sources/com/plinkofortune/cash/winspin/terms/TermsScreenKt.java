package com.plinkofortune.cash.winspin.terms;

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

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001b\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\u0007¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"TermsScreen", "", "back", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "app_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* compiled from: TermsScreen.kt */
public final class TermsScreenKt {
    /* access modifiers changed from: private */
    public static final Unit TermsScreen$lambda$0(Function0 function0, int i, Composer composer, int i2) {
        TermsScreen(function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void TermsScreen(Function0<Unit> function0, Composer composer, int i) {
        int i2;
        int i3 = 4;
        Intrinsics.checkNotNullParameter(function0, StringFog.decrypt(new byte[]{-127, -101, -17, 112}, new byte[]{-29, -6, -116, Ascii.ESC, 83, 96, 39, 34}));
        Composer startRestartGroup = composer.startRestartGroup(-894519783);
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
                ComposerKt.traceEventStart(-894519783, i2, -1, StringFog.decrypt(new byte[]{-82, -71, 77, Ascii.ESC, 76, -52, -85, -106, -90, -71, 70, 90, 78, -44, -73, -106, -88, -8, 67, 84, 79, -56, -20, -113, -92, -72, 83, 69, 85, -50, -20, -116, -88, -92, 77, 70, Ascii.DC2, -12, -89, -118, -96, -91, 115, 86, 78, -59, -89, -106, -19, -2, 116, 80, 78, -51, -79, -85, -82, -92, 69, 80, 82, -114, -87, -116, -9, -27, Ascii.DC4, Ascii.FS}, new byte[]{-51, -42, 32, 53, 60, -96, -62, -8}));
            }
            ToolbarColumnKt.ToolbarColumn(function0, ComposableSingletons$TermsScreenKt.INSTANCE.m7818getLambda1$app_release(), startRestartGroup, (i2 & 14) | 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new TermsScreenKt$$ExternalSyntheticLambda0(function0, i));
        }
    }
}
