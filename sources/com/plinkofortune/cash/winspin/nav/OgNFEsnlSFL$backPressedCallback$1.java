package com.plinkofortune.cash.winspin.nav;

import androidx.activity.OnBackPressedCallback;
import androidx.fragment.app.Fragment;
import com.plinkofortune.cash.winspin.StringFog;
import com.plinkofortune.cash.winspin.profile.PcAtMNHQpJHd;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.io.encoding.Base64;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/plinkofortune/cash/winspin/nav/OgNFEsnlSFL$backPressedCallback$1", "Landroidx/activity/OnBackPressedCallback;", "handleOnBackPressed", "", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: OgNFEsnlSFL.kt */
public final class OgNFEsnlSFL$backPressedCallback$1 extends OnBackPressedCallback {
    final /* synthetic */ OgNFEsnlSFL this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OgNFEsnlSFL$backPressedCallback$1(OgNFEsnlSFL ogNFEsnlSFL) {
        super(true);
        this.this$0 = ogNFEsnlSFL;
    }

    public void handleOnBackPressed() {
        List<Fragment> fragments = this.this$0.activity.getSupportFragmentManager().getFragments();
        Intrinsics.checkNotNullExpressionValue(fragments, StringFog.decrypt(new byte[]{-123, -14, -1, Base64.padSymbol, 40, 45, -48, 69, -121, -7, -1, 8, 114, 98, -103, 6, -53}, new byte[]{-30, -105, -117, 123, 90, 76, -73, 40}));
        Object lastOrNull = CollectionsKt.lastOrNull(fragments);
        PcAtMNHQpJHd pcAtMNHQpJHd = lastOrNull instanceof PcAtMNHQpJHd ? (PcAtMNHQpJHd) lastOrNull : null;
        if (pcAtMNHQpJHd != null) {
            if (pcAtMNHQpJHd.canGoBack()) {
                pcAtMNHQpJHd.goBack();
            } else if (!pcAtMNHQpJHd.isRoot()) {
                this.this$0.closeTopTab();
            }
        }
    }
}
