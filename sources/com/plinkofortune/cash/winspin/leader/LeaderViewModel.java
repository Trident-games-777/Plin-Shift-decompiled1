package com.plinkofortune.cash.winspin.leader;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelProvider;
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

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/plinkofortune/cash/winspin/leader/LeaderViewModel;", "Landroidx/lifecycle/ViewModel;", "repo", "Lcom/plinkofortune/cash/winspin/GlobalRepo;", "<init>", "(Lcom/plinkofortune/cash/winspin/GlobalRepo;)V", "leaders", "Lkotlinx/coroutines/flow/StateFlow;", "", "Lcom/plinkofortune/cash/winspin/leader/LeaderModel;", "getLeaders", "()Lkotlinx/coroutines/flow/StateFlow;", "Companion", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: LeaderViewModel.kt */
public final class LeaderViewModel extends ViewModel {
    public static final int $stable = 8;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final ViewModelProvider.Factory Factory = new LeaderViewModel$Companion$Factory$1();
    private final StateFlow<List<LeaderModel>> leaders;
    private final GlobalRepo repo;

    public LeaderViewModel(GlobalRepo globalRepo) {
        Intrinsics.checkNotNullParameter(globalRepo, StringFog.decrypt(new byte[]{-84, 96, -3, -72}, new byte[]{-34, 5, -115, -41, 82, 66, 60, 80}));
        this.repo = globalRepo;
        this.leaders = FlowKt.stateIn(globalRepo.getLeaders(), ViewModelKt.getViewModelScope(this), SharingStarted.Companion.getEagerly(), CollectionsKt.emptyList());
    }

    public final StateFlow<List<LeaderModel>> getLeaders() {
        return this.leaders;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/plinkofortune/cash/winspin/leader/LeaderViewModel$Companion;", "", "<init>", "()V", "Factory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getFactory", "()Landroidx/lifecycle/ViewModelProvider$Factory;", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* compiled from: LeaderViewModel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ViewModelProvider.Factory getFactory() {
            return LeaderViewModel.Factory;
        }
    }
}
