package com.plinkofortune.cash.winspin.terms;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;
import androidx.fragment.app.FragmentActivity;
import com.google.common.base.Ascii;
import com.plinkofortune.cash.winspin.StringFog;
import com.plinkofortune.cash.winspin.nav.OgNFEsnlSFL;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ&\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u001c\u0010\u0012\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u001c\u0010\u0013\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u001c\u0010\u0014\u001a\u00020\u00152\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/plinkofortune/cash/winspin/terms/CywwbraAvEhb;", "Landroid/webkit/WebViewClient;", "activity", "Landroidx/fragment/app/FragmentActivity;", "webListener", "Lcom/plinkofortune/cash/winspin/terms/BkcRXzpXGNH;", "webViewController", "Lcom/plinkofortune/cash/winspin/nav/OgNFEsnlSFL;", "<init>", "(Landroidx/fragment/app/FragmentActivity;Lcom/plinkofortune/cash/winspin/terms/BkcRXzpXGNH;Lcom/plinkofortune/cash/winspin/nav/OgNFEsnlSFL;)V", "onPageStarted", "", "view", "Landroid/webkit/WebView;", "url", "", "favicon", "Landroid/graphics/Bitmap;", "onPageCommitVisible", "onPageFinished", "shouldOverrideUrlLoading", "", "request", "Landroid/webkit/WebResourceRequest;", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: CywwbraAvEhb.kt */
public final class CywwbraAvEhb extends WebViewClient {
    public static final int $stable = 8;
    private final FragmentActivity activity;
    private final BkcRXzpXGNH webListener;
    private final OgNFEsnlSFL webViewController;

    public CywwbraAvEhb(FragmentActivity fragmentActivity, BkcRXzpXGNH bkcRXzpXGNH, OgNFEsnlSFL ogNFEsnlSFL) {
        Intrinsics.checkNotNullParameter(fragmentActivity, StringFog.decrypt(new byte[]{81, -10, 1, -2, 122, 109, -118, Ascii.FF}, new byte[]{48, -107, 117, -105, Ascii.FF, 4, -2, 117}));
        Intrinsics.checkNotNullParameter(bkcRXzpXGNH, StringFog.decrypt(new byte[]{-32, -52, -72, 77, -31, 72, -41, -18, -7, -52, -88}, new byte[]{-105, -87, -38, 1, -120, 59, -93, -117}));
        Intrinsics.checkNotNullParameter(ogNFEsnlSFL, StringFog.decrypt(new byte[]{-60, -93, -67, Byte.MAX_VALUE, 87, 107, -32, -24, -36, -88, -85, 91, 81, 98, -5, -50, -63}, new byte[]{-77, -58, -33, 41, 62, Ascii.SO, -105, -85}));
        this.activity = fragmentActivity;
        this.webListener = bkcRXzpXGNH;
        this.webViewController = ogNFEsnlSFL;
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        this.webViewController.getSavedStateHelper().save();
        this.webListener.onPageStarted(str, bitmap);
    }

    public void onPageCommitVisible(WebView webView, String str) {
        super.onPageCommitVisible(webView, str);
        this.webListener.onPageCommitVisible(str);
    }

    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        this.webViewController.getSavedStateHelper().save();
        this.webListener.onPageFinished(webView, str);
    }

    public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        Uri url;
        Intent intent = null;
        this.webListener.shouldOverrideUrlLoading(webResourceRequest != null ? webResourceRequest.getUrl() : null);
        String scheme = (webResourceRequest == null || (url = webResourceRequest.getUrl()) == null) ? null : url.getScheme();
        if (Intrinsics.areEqual((Object) scheme, (Object) StringFog.decrypt(new byte[]{-107, -101, -29, 100, 103, 76}, new byte[]{-4, -11, -105, 1, 9, 56, -79, 126}))) {
            intent = Intent.parseUri(webResourceRequest.getUrl().toString(), 1);
        } else if (Intrinsics.areEqual((Object) scheme, (Object) StringFog.decrypt(new byte[]{-97, -28, 87, -33, 101, -82}, new byte[]{-14, -123, 62, -77, 17, -63, -92, -124}))) {
            intent = new Intent(StringFog.decrypt(new byte[]{Ascii.DC4, -54, 85, -44, 54, -12, -70, 98, Ascii.FS, -54, 69, -61, 55, -23, -16, 45, Ascii.SYN, -48, 88, -55, 55, -77, -115, 9, 59, -32, 101, -23}, new byte[]{117, -92, 49, -90, 89, -99, -34, 76}), webResourceRequest.getUrl());
        } else if (Intrinsics.areEqual((Object) scheme, (Object) StringFog.decrypt(new byte[]{117, 79, 52}, new byte[]{1, 42, 88, -8, 69, Ascii.CR, 2, 92}))) {
            intent = new Intent(StringFog.decrypt(new byte[]{-4, 5, -87, 92, -126, 87, 68, 109, -12, 5, -71, 75, -125, 74, Ascii.SO, 34, -2, Ascii.US, -92, 65, -125, Ascii.DLE, 100, 10, -36, 39}, new byte[]{-99, 107, -51, 46, -19, 62, 32, 67}), webResourceRequest.getUrl());
        } else if (scheme != null && !Intrinsics.areEqual((Object) scheme, (Object) StringFog.decrypt(new byte[]{108, 86, -125, -64}, new byte[]{4, 34, -9, -80, -107, -105, -14, 123})) && !Intrinsics.areEqual((Object) scheme, (Object) StringFog.decrypt(new byte[]{78, 76, 125, 69, Ascii.DLE}, new byte[]{38, 56, 9, 53, 99, 41, -2, 112}))) {
            intent = new Intent(StringFog.decrypt(new byte[]{62, 57, Ascii.DLE, 114, 123, -21, 123, -66, 54, 57, 0, 101, 122, -10, 49, -15, 60, 35, Ascii.GS, 111, 122, -84, 73, -39, Ascii.SUB, 0}, new byte[]{95, 87, 116, 0, Ascii.DC4, -126, Ascii.US, -112}), webResourceRequest.getUrl());
        }
        if (intent == null) {
            return false;
        }
        try {
            this.activity.startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            Toast.makeText(this.activity, StringFog.decrypt(new byte[]{-116, -96, -77, 38, -104, 1, -79, -20, -95, -82, -25, 46, -121, Ascii.US, -3, -29, -83, -70, -3, 35, -56, 5, -78, -91, -86, -82, -3, 35, -124, Ascii.DC4, -3, -15, -86, -86, -77, 53, -115, 0, -88, -32, -79, -69}, new byte[]{-62, -49, -109, 71, -24, 113, -35, -123}), 1).show();
        }
        return true;
    }
}
