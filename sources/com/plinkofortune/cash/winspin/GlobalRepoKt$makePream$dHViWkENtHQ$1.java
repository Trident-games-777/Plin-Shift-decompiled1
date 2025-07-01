package com.plinkofortune.cash.winspin;

import android.webkit.WebView;
import androidx.fragment.app.FragmentActivity;
import com.plinkofortune.cash.winspin.nav.OgNFEsnlSFL;
import com.plinkofortune.cash.winspin.profile.DHViWkENtHQ;
import com.plinkofortune.cash.winspin.terms.XwqWGZEeOAxxKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"com/plinkofortune/cash/winspin/GlobalRepoKt$makePream$dHViWkENtHQ$1", "Lcom/plinkofortune/cash/winspin/profile/DHViWkENtHQ;", "onPageFinished", "", "view", "Landroid/webkit/WebView;", "url", "", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: GlobalRepo.kt */
public final class GlobalRepoKt$makePream$dHViWkENtHQ$1 extends DHViWkENtHQ {
    final /* synthetic */ Ref.BooleanRef $false7;
    final /* synthetic */ Ref.ObjectRef<OgNFEsnlSFL> $ogNFEsnlSFL;
    final /* synthetic */ FragmentActivity $root;
    final /* synthetic */ Ref.BooleanRef $true4;

    GlobalRepoKt$makePream$dHViWkENtHQ$1(Ref.BooleanRef booleanRef, Ref.BooleanRef booleanRef2, FragmentActivity fragmentActivity, Ref.ObjectRef<OgNFEsnlSFL> objectRef) {
        this.$true4 = booleanRef;
        this.$false7 = booleanRef2;
        this.$root = fragmentActivity;
        this.$ogNFEsnlSFL = objectRef;
    }

    public void onPageFinished(WebView webView, String str) {
        if (this.$true4.element) {
            this.$true4.element = false;
            if (this.$false7.element) {
                XwqWGZEeOAxxKt.tympsmAacFI(this.$root, (OgNFEsnlSFL) this.$ogNFEsnlSFL.element);
            }
        }
    }
}
