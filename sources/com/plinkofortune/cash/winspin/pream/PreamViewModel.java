package com.plinkofortune.cash.winspin.pream;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.google.common.base.Ascii;
import com.plinkofortune.cash.winspin.StringFog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0007\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u000b\u001a\u00020\bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/plinkofortune/cash/winspin/pream/PreamViewModel;", "Landroidx/lifecycle/ViewModel;", "appContext", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "pream", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "getPream", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "ddt", "Companion", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: PreamViewModel.kt */
public final class PreamViewModel extends ViewModel {
    public static final int $stable = 8;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final ViewModelProvider.Factory Factory = new PreamViewModel$Companion$Factory$1();
    private final Context appContext;
    private final MutableStateFlow<Boolean> pream = StateFlowKt.MutableStateFlow(Boolean.valueOf(ddt()));

    public PreamViewModel(Context context) {
        Intrinsics.checkNotNullParameter(context, StringFog.decrypt(new byte[]{-8, -53, 36, 97, 73, -57, -43, 1, -31, -49}, new byte[]{-103, -69, 84, 34, 38, -87, -95, 100}));
        this.appContext = context;
    }

    public final MutableStateFlow<Boolean> getPream() {
        return this.pream;
    }

    private final boolean ddt() {
        NetworkCapabilities networkCapabilities;
        Object systemService = this.appContext.getSystemService(StringFog.decrypt(new byte[]{-60, -112, -88, -8, -117, -12, -49, 39, -47, -106, -78, -17}, new byte[]{-89, -1, -58, -106, -18, -105, -69, 78}));
        Intrinsics.checkNotNull(systemService, StringFog.decrypt(new byte[]{Ascii.RS, -29, -20, 108, 72, -31, 101, 6, Ascii.RS, -7, -12, 32, 10, -25, 36, Ascii.VT, 17, -27, -12, 32, Ascii.FS, -19, 36, 6, Ascii.US, -8, -83, 110, Ascii.GS, -18, 104, 72, 4, -17, -16, 101, 72, -29, 106, Ascii.FF, 2, -7, -23, 100, 70, -20, 97, Ascii.FS, 94, -43, -17, 110, 6, -25, 103, Ascii.FS, Ascii.EM, -32, -23, 116, 17, -49, 101, 6, 17, -15, -27, 114}, new byte[]{112, -106, Byte.MIN_VALUE, 0, 104, -126, 4, 104}));
        ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
        Network activeNetwork = connectivityManager.getActiveNetwork();
        if (activeNetwork == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) == null) {
            return false;
        }
        if (!networkCapabilities.hasTransport(1) && !networkCapabilities.hasTransport(0) && !networkCapabilities.hasTransport(3) && !networkCapabilities.hasTransport(4)) {
            return false;
        }
        return true;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/plinkofortune/cash/winspin/pream/PreamViewModel$Companion;", "", "<init>", "()V", "Factory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getFactory", "()Landroidx/lifecycle/ViewModelProvider$Factory;", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* compiled from: PreamViewModel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ViewModelProvider.Factory getFactory() {
            return PreamViewModel.Factory;
        }
    }
}
