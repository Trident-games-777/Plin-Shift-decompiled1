package com.plinkofortune.cash.winspin.leader;

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
import com.google.common.primitives.SignedBytes;
import com.plinkofortune.cash.winspin.StringFog;
import com.plinkofortune.cash.winspin.ToolbarColumnKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import okio.Utf8;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\u001a\u001b\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\u0007¢\u0006\u0002\u0010\u0004¨\u0006\u0005²\u0006\u0010\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0002"}, d2 = {"LeaderScreen", "", "back", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "app_release", "leaders", "", "Lcom/plinkofortune/cash/winspin/leader/LeaderModel;"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* compiled from: LeaderScreen.kt */
public final class LeaderScreenKt {
    /* access modifiers changed from: private */
    public static final Unit LeaderScreen$lambda$1(Function0 function0, int i, Composer composer, int i2) {
        LeaderScreen(function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void LeaderScreen(Function0<Unit> function0, Composer composer, int i) {
        int i2;
        CreationExtras creationExtras;
        int i3 = 4;
        Intrinsics.checkNotNullParameter(function0, StringFog.decrypt(new byte[]{-31, -86, -1, 68}, new byte[]{-125, -53, -100, 47, 99, -54, 39, -52}));
        Composer startRestartGroup = composer.startRestartGroup(-475679935);
        if ((i & 6) == 0) {
            if (!startRestartGroup.changedInstance(function0)) {
                i3 = 2;
            }
            i2 = i | i3;
        } else {
            i2 = i;
        }
        if ((i2 & 3) != 2 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-475679935, i2, -1, StringFog.decrypt(new byte[]{-77, -58, 56, Byte.MIN_VALUE, 45, -79, 94, -30, -69, -58, 51, -63, 47, -87, 66, -30, -75, -121, 54, -49, 46, -75, Ascii.EM, -5, -71, -57, 38, -34, 52, -77, Ascii.EM, -32, -75, -56, 49, -53, 47, -13, 123, -23, -79, -51, 48, -36, Ascii.SO, -66, 69, -23, -75, -57, 117, -122, 17, -72, 86, -24, -75, -37, 6, -51, 47, -72, 82, -30, -2, -62, 33, -108, 110, -27, Ascii.RS}, new byte[]{-48, -87, 85, -82, 93, -35, 55, -116}));
            }
            ViewModelProvider.Factory factory = LeaderViewModel.Companion.getFactory();
            startRestartGroup.startReplaceableGroup(1729797275);
            ComposerKt.sourceInformation(startRestartGroup, StringFog.decrypt(new byte[]{33, 43, Ascii.FF, 49, 83, 49, 113, 45, Ascii.CR, Ascii.FF, 65, 43, 19, 4, 46, 83, 78, 90, 8, 118, 19, 126, 51, 84, 34, 90, 17, 119, 8, Ascii.CAN, 49, 76, 84, 92, 100, 117, 2, 99, 49, 44, 84, 91, Ascii.RS, 17, 83, 49, 113, 45, Ascii.CR, Ascii.FF, 65, 43, Ascii.DC4, Utf8.REPLACEMENT_BYTE, 114, 67, 81, Ascii.FS, 78, 38, Ascii.FF, 99}, new byte[]{98, 104, 36, 71, 58, 84, 6, 96}));
            ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(startRestartGroup, 6);
            if (current != null) {
                if (current instanceof HasDefaultViewModelProviderFactory) {
                    creationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                } else {
                    creationExtras = CreationExtras.Empty.INSTANCE;
                }
                ViewModel viewModel = ViewModelKt.viewModel(Reflection.getOrCreateKotlinClass(LeaderViewModel.class), current, (String) null, factory, creationExtras, startRestartGroup, 0, 0);
                startRestartGroup.endReplaceableGroup();
                ToolbarColumnKt.ToolbarColumn(function0, ComposableLambdaKt.rememberComposableLambda(-929161396, true, new LeaderScreenKt$LeaderScreen$1(SnapshotStateKt.collectAsState(((LeaderViewModel) viewModel).getLeaders(), (CoroutineContext) null, startRestartGroup, 0, 1)), startRestartGroup, 54), startRestartGroup, (i2 & 14) | 48);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                throw new IllegalStateException(StringFog.decrypt(new byte[]{-14, -98, -62, 65, -22, 75, -7, -60, -45, -107, -121, 123, -48, 90, -31, -5, -39, -66, -107, 121, -26, 92, -82, -2, -35, -126, -62, 103, -15, 65, -8, -32, -40, -108, -122, 55, -11, 71, -17, -87, -16, -98, -127, 118, -17, 120, -25, -20, -53, -68, -115, 115, -26, 66, -35, -3, -45, -125, -121, 88, -12, SignedBytes.MAX_POWER_OF_TWO, -21, -5}, new byte[]{-68, -15, -30, Ascii.ETB, -125, 46, -114, -119}).toString());
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new LeaderScreenKt$$ExternalSyntheticLambda0(function0, i));
        }
    }

    /* access modifiers changed from: private */
    public static final List<LeaderModel> LeaderScreen$lambda$0(State<? extends List<LeaderModel>> state) {
        return (List) state.getValue();
    }
}
