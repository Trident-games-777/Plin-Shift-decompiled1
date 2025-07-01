package com.plinkofortune.cash.winspin.rounds;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelProvider;
import com.google.common.base.Ascii;
import com.plinkofortune.cash.winspin.GlobalRepo;
import com.plinkofortune.cash.winspin.StringFog;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/plinkofortune/cash/winspin/rounds/RoundsViewModel;", "Landroidx/lifecycle/ViewModel;", "storage", "Lcom/plinkofortune/cash/winspin/GlobalRepo;", "<init>", "(Lcom/plinkofortune/cash/winspin/GlobalRepo;)V", "rounds", "Lkotlinx/coroutines/flow/StateFlow;", "", "Lcom/plinkofortune/cash/winspin/rounds/RoundModel;", "getRounds", "()Lkotlinx/coroutines/flow/StateFlow;", "Companion", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: RoundsViewModel.kt */
public final class RoundsViewModel extends ViewModel {
    public static final int $stable = 8;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final ViewModelProvider.Factory Factory = new RoundsViewModel$Companion$Factory$1();
    private final StateFlow<List<RoundModel>> rounds;
    private final GlobalRepo storage;

    public RoundsViewModel(GlobalRepo globalRepo) {
        Intrinsics.checkNotNullParameter(globalRepo, StringFog.decrypt(new byte[]{-51, Ascii.SO, -86, 114, 105, 108, -127}, new byte[]{-66, 122, -59, 0, 8, Ascii.VT, -28, 101}));
        this.storage = globalRepo;
        this.rounds = FlowKt.stateIn(globalRepo.getRounds(), ViewModelKt.getViewModelScope(this), SharingStarted.Companion.getEagerly(), CollectionsKt.emptyList());
    }

    public final StateFlow<List<RoundModel>> getRounds() {
        return this.rounds;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/plinkofortune/cash/winspin/rounds/RoundsViewModel$Companion;", "", "<init>", "()V", "Factory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getFactory", "()Landroidx/lifecycle/ViewModelProvider$Factory;", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* compiled from: RoundsViewModel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ViewModelProvider.Factory getFactory() {
            return RoundsViewModel.Factory;
        }
    }
}
