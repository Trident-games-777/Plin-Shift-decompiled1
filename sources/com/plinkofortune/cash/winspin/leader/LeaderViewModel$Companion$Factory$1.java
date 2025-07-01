package com.plinkofortune.cash.winspin.leader;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.google.common.base.Ascii;
import com.plinkofortune.cash.winspin.GlobalRepoKt;
import com.plinkofortune.cash.winspin.StringFog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J-\u0010\u0002\u001a\u0002H\u0003\"\b\b\u0000\u0010\u0003*\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00030\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"com/plinkofortune/cash/winspin/leader/LeaderViewModel$Companion$Factory$1", "Landroidx/lifecycle/ViewModelProvider$Factory;", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "extras", "Landroidx/lifecycle/viewmodel/CreationExtras;", "(Ljava/lang/Class;Landroidx/lifecycle/viewmodel/CreationExtras;)Landroidx/lifecycle/ViewModel;", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: LeaderViewModel.kt */
public final class LeaderViewModel$Companion$Factory$1 implements ViewModelProvider.Factory {
    LeaderViewModel$Companion$Factory$1() {
    }

    public <T extends ViewModel> T create(Class<T> cls, CreationExtras creationExtras) {
        Intrinsics.checkNotNullParameter(cls, StringFog.decrypt(new byte[]{-8, Ascii.RS, -119, -116, -91, Ascii.FS, -112, -42, -26, 2}, new byte[]{-107, 113, -19, -23, -55, 95, -4, -73}));
        Intrinsics.checkNotNullParameter(creationExtras, StringFog.decrypt(new byte[]{-16, -111, 3, -88, 2, -118}, new byte[]{-107, -23, 119, -38, 99, -7, -97, -43}));
        return (ViewModel) new LeaderViewModel(GlobalRepoKt.repo(creationExtras));
    }
}
