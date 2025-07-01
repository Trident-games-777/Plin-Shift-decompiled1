package com.plinkofortune.cash.winspin.rounds;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.lifecycle.viewmodel.compose.ViewModelKt;
import com.google.common.base.Ascii;
import com.plinkofortune.cash.winspin.StringFog;
import com.plinkofortune.cash.winspin.ToolbarColumnKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.io.encoding.Base64;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import okio.Utf8;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\u001a/\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005H\u0007¢\u0006\u0002\u0010\u0007¨\u0006\b²\u0006\u0010\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0002"}, d2 = {"RoundsScreen", "", "back", "Lkotlin/Function0;", "mortal", "Lkotlin/Function1;", "", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "app_release", "rounds", "", "Lcom/plinkofortune/cash/winspin/rounds/RoundModel;"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* compiled from: RoundsScreen.kt */
public final class RoundsScreenKt {
    /* access modifiers changed from: private */
    public static final Unit RoundsScreen$lambda$1(Function0 function0, Function1 function1, int i, Composer composer, int i2) {
        RoundsScreen(function0, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void RoundsScreen(Function0<Unit> function0, Function1<? super Integer, Unit> function1, Composer composer, int i) {
        int i2;
        CreationExtras creationExtras;
        int i3 = 4;
        Intrinsics.checkNotNullParameter(function0, StringFog.decrypt(new byte[]{Ascii.DC4, Ascii.ESC, -121, Byte.MAX_VALUE}, new byte[]{118, 122, -28, Ascii.DC4, -122, -54, -26, 105}));
        Intrinsics.checkNotNullParameter(function1, StringFog.decrypt(new byte[]{-98, -119, -27, 114, 122, 98}, new byte[]{-13, -26, -105, 6, Ascii.ESC, Ascii.SO, -79, 89}));
        Composer startRestartGroup = composer.startRestartGroup(-170844686);
        if ((i & 6) == 0) {
            if (!startRestartGroup.changedInstance(function0)) {
                i3 = 2;
            }
            i2 = i | i3;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        if ((i2 & 19) != 18 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-170844686, i2, -1, StringFog.decrypt(new byte[]{-6, 49, -7, 112, 4, -105, -93, -86, -14, 49, -14, 49, 6, -113, -65, -86, -4, 112, -9, Utf8.REPLACEMENT_BYTE, 7, -109, -28, -77, -16, 48, -25, 46, Ascii.GS, -107, -28, -74, -10, 43, -6, 58, 7, -43, -104, -85, -20, 48, -16, 45, 39, -104, -72, -95, -4, 48, -76, 118, 38, -108, -65, -86, -3, 45, -57, Base64.padSymbol, 6, -98, -81, -86, -73, 53, -32, 100, 71, -56, -29}, new byte[]{-103, 94, -108, 94, 116, -5, -54, -60}));
            }
            ViewModelProvider.Factory factory = RoundsViewModel.Companion.getFactory();
            startRestartGroup.startReplaceableGroup(1729797275);
            ComposerKt.sourceInformation(startRestartGroup, StringFog.decrypt(new byte[]{-31, 46, -104, 85, -63, -72, 76, -14, -51, 9, -43, 79, -127, -115, 19, -116, -114, 95, -100, Ascii.DC2, -127, -9, Ascii.SO, -117, -30, 95, -123, 19, -102, -111, Ascii.FF, -109, -108, 89, -16, 17, -112, -22, Ascii.FF, -13, -108, 94, -118, 117, -63, -72, 76, -14, -51, 9, -43, 79, -122, -74, 79, -100, -111, Ascii.EM, -38, 66, -98, -22}, new byte[]{-94, 109, -80, 35, -88, -35, 59, -65}));
            ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(startRestartGroup, 6);
            if (current != null) {
                if (current instanceof HasDefaultViewModelProviderFactory) {
                    creationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                } else {
                    creationExtras = CreationExtras.Empty.INSTANCE;
                }
                ViewModel viewModel = ViewModelKt.viewModel(Reflection.getOrCreateKotlinClass(RoundsViewModel.class), current, (String) null, factory, creationExtras, startRestartGroup, 0, 0);
                startRestartGroup.endReplaceableGroup();
                ToolbarColumnKt.ToolbarColumn(function0, ComposableLambdaKt.rememberComposableLambda(-435800003, true, new RoundsScreenKt$RoundsScreen$1(SnapshotStateKt.collectAsState(((RoundsViewModel) viewModel).getRounds(), (CoroutineContext) null, startRestartGroup, 0, 1), function1), startRestartGroup, 54), startRestartGroup, (i2 & 14) | 48);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                throw new IllegalStateException(StringFog.decrypt(new byte[]{Ascii.FS, -51, 46, -39, Ascii.SO, 68, -32, -68, Base64.padSymbol, -58, 107, -29, 52, 85, -8, -125, 55, -19, 121, -31, 2, 83, -73, -122, 51, -47, 46, -1, Ascii.NAK, 78, -31, -104, 54, -57, 106, -81, 17, 72, -10, -47, Ascii.RS, -51, 109, -18, Ascii.VT, 119, -2, -108, 37, -17, 97, -21, 2, 77, -60, -123, Base64.padSymbol, -48, 107, -64, Ascii.DLE, 79, -14, -125}, new byte[]{82, -94, Ascii.SO, -113, 103, 33, -105, -15}).toString());
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new RoundsScreenKt$$ExternalSyntheticLambda0(function0, function1, i));
        }
    }

    /* access modifiers changed from: private */
    public static final List<RoundModel> RoundsScreen$lambda$0(State<? extends List<RoundModel>> state) {
        return (List) state.getValue();
    }
}
