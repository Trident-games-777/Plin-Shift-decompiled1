package com.plinkofortune.cash.winspin.profile;

import android.graphics.Bitmap;
import android.net.Uri;
import android.webkit.WebView;
import android.widget.FrameLayout;
import com.plinkofortune.cash.winspin.nav.OgNFEsnlSFL;
import com.plinkofortune.cash.winspin.terms.BkcRXzpXGNH;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u001c\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\f\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016¨\u0006\u000f"}, d2 = {"com/plinkofortune/cash/winspin/profile/PcAtMNHQpJHd$webListener$2$1", "Lcom/plinkofortune/cash/winspin/terms/BkcRXzpXGNH;", "onPageStarted", "", "url", "", "favicon", "Landroid/graphics/Bitmap;", "onPageCommitVisible", "onPageFinished", "view", "Landroid/webkit/WebView;", "shouldOverrideUrlLoading", "uri", "Landroid/net/Uri;", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: PcAtMNHQpJHd.kt */
public final class PcAtMNHQpJHd$webListener$2$1 implements BkcRXzpXGNH {
    final /* synthetic */ PcAtMNHQpJHd this$0;

    PcAtMNHQpJHd$webListener$2$1(PcAtMNHQpJHd pcAtMNHQpJHd) {
        this.this$0 = pcAtMNHQpJHd;
    }

    public void onPageStarted(String str, Bitmap bitmap) {
        FrameLayout access$getProgressBarGroup$p = this.this$0.progressBarGroup;
        if (access$getProgressBarGroup$p != null) {
            access$getProgressBarGroup$p.setVisibility(0);
        }
        OgNFEsnlSFL access$getWebViewController$p = this.this$0.webViewController;
        if (access$getWebViewController$p != null) {
            access$getWebViewController$p.onPageStarted(str, bitmap);
        }
    }

    public void onPageCommitVisible(String str) {
        OgNFEsnlSFL access$getWebViewController$p = this.this$0.webViewController;
        if (access$getWebViewController$p != null) {
            access$getWebViewController$p.onPageCommitVisible(str);
        }
    }

    public void onPageFinished(WebView webView, String str) {
        if (webView != null) {
            webView.clearFocus();
        }
        FrameLayout access$getProgressBarGroup$p = this.this$0.progressBarGroup;
        if (access$getProgressBarGroup$p != null) {
            access$getProgressBarGroup$p.setVisibility(8);
        }
        this.this$0.flushCookies();
        OgNFEsnlSFL access$getWebViewController$p = this.this$0.webViewController;
        if (access$getWebViewController$p != null) {
            access$getWebViewController$p.onPageFinished(webView, str);
        }
    }

    public void shouldOverrideUrlLoading(Uri uri) {
        OgNFEsnlSFL access$getWebViewController$p = this.this$0.webViewController;
        if (access$getWebViewController$p != null) {
            access$getWebViewController$p.shouldOverrideUrlLoading(uri);
        }
    }
}
