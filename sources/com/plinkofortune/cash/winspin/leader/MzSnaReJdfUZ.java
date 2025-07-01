package com.plinkofortune.cash.winspin.leader;

import android.graphics.Paint;
import android.os.Build;
import android.webkit.CookieManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.plinkofortune.cash.winspin.StringFog;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.io.encoding.Base64;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import okio.Utf8;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0007J\u001a\u0010\f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0002¨\u0006\u000f"}, d2 = {"Lcom/plinkofortune/cash/winspin/leader/MzSnaReJdfUZ;", "", "<init>", "()V", "hVzQupCCYcRf", "", "view", "Landroid/webkit/WebView;", "viewClient", "Landroid/webkit/WebViewClient;", "chromeClient", "Landroid/webkit/WebChromeClient;", "setupUserAgent", "isUserAgentReduced", "", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: MzSnaReJdfUZ.kt */
public final class MzSnaReJdfUZ {
    public static final int $stable = 0;
    public static final MzSnaReJdfUZ INSTANCE = new MzSnaReJdfUZ();

    private MzSnaReJdfUZ() {
    }

    public final void hVzQupCCYcRf(WebView webView, WebViewClient webViewClient, WebChromeClient webChromeClient) {
        Intrinsics.checkNotNullParameter(webView, StringFog.decrypt(new byte[]{-84, Ascii.SUB, 5, 73}, new byte[]{-38, 115, 96, 62, 46, -5, -45, 106}));
        Intrinsics.checkNotNullParameter(webViewClient, StringFog.decrypt(new byte[]{81, 98, Utf8.REPLACEMENT_BYTE, -85, 75, -54, -123, -9, 73, Byte.MAX_VALUE}, new byte[]{39, Ascii.VT, 90, -36, 8, -90, -20, -110}));
        webView.setWebViewClient(webViewClient);
        webView.setWebChromeClient(webChromeClient);
        webView.setFocusable(true);
        webView.setFocusableInTouchMode(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setDisplayZoomControls(false);
        webView.getSettings().setSupportMultipleWindows(true);
        webView.getSettings().setMediaPlaybackRequiresUserGesture(true);
        webView.getSettings().setDatabaseEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);
        CookieManager.getInstance().setAcceptCookie(true);
        CookieManager.getInstance().setAcceptThirdPartyCookies(webView, true);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setUseWideViewPort(true);
        webView.getSettings().setSupportZoom(true);
        webView.setVerticalScrollBarEnabled(true);
        webView.setHorizontalScrollBarEnabled(true);
        webView.getSettings().setMixedContentMode(0);
        webView.getSettings().setAllowContentAccess(true);
        webView.getSettings().setAllowFileAccess(true);
        webView.getSettings().setAllowFileAccessFromFileURLs(false);
        webView.getSettings().setAllowUniversalAccessFromFileURLs(false);
        webView.getSettings().setBlockNetworkImage(false);
        webView.getSettings().setBlockNetworkLoads(false);
        webView.getSettings().setCacheMode(-1);
        webView.getSettings().setLoadsImagesAutomatically(true);
        webView.setInitialScale(0);
        webView.getSettings().setNeedInitialFocus(true);
        webView.getSettings().setOffscreenPreRaster(false);
        webView.getSettings().setSaveFormData(true);
        webView.getSettings().setSafeBrowsingEnabled(false);
        webView.setLayerType(2, (Paint) null);
        String path = webView.getContext().getCacheDir().getPath();
        Intrinsics.checkNotNull(path);
        if (path.length() > 0 && Build.VERSION.SDK_INT < 33) {
            try {
                Class<?> cls = Class.forName(StringFog.decrypt(new byte[]{76, Ascii.DLE, 43, 110, -123, 93, -103, 88, 90, Ascii.ESC, 45, 119, -125, SignedBytes.MAX_POWER_OF_TWO, -45, 33, 72, Ascii.FS, Ascii.FS, 121, -98, SignedBytes.MAX_POWER_OF_TWO, -108, Ascii.CAN, 74, Ascii.CR}, new byte[]{45, 126, 79, Ascii.FS, -22, 52, -3, 118}));
                Method declaredMethod = cls.getDeclaredMethod(StringFog.decrypt(new byte[]{-84, 7, Ascii.VT, 40, 77, 34, 103, 19, -68, 10, Ascii.SUB, 57, 92, 38, 76}, new byte[]{-33, 98, Byte.MAX_VALUE, 105, Base64.padSymbol, 82, 36, 114}), new Class[]{String.class});
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(webView.getSettings(), new Object[]{path});
                Method declaredMethod2 = cls.getDeclaredMethod(StringFog.decrypt(new byte[]{-20, 120, -100, -25, -14, 121, 9, 41, -4, 117, -115, -29, -20, 104, 40, 36, -6, 121}, new byte[]{-97, Ascii.GS, -24, -90, -126, 9, 74, 72}), new Class[]{Boolean.TYPE});
                declaredMethod2.setAccessible(true);
                declaredMethod2.invoke(webView.getSettings(), new Object[]{true});
            } catch (Throwable unused) {
            }
        }
        setupUserAgent$default(this, webView, false, 2, (Object) null);
    }

    static /* synthetic */ void setupUserAgent$default(MzSnaReJdfUZ mzSnaReJdfUZ, WebView webView, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        mzSnaReJdfUZ.setupUserAgent(webView, z);
    }

    private final void setupUserAgent(WebView webView, boolean z) {
        String str;
        String str2;
        String str3;
        String str4;
        if (z) {
            String userAgentString = webView.getSettings().getUserAgentString();
            Regex regex = new Regex(StringFog.decrypt(new byte[]{100, 120, -94, -27, 6, 65, 105, -93, 32, 43, -1, -9, 98, 114, SignedBytes.MAX_POWER_OF_TWO, -31, 100, 120, -93, -124, 56, 7}, new byte[]{76, 71, -98, -40, 75, 46, 19, -54}));
            Intrinsics.checkNotNull(userAgentString);
            CharSequence charSequence = userAgentString;
            MatchResult find$default = Regex.find$default(regex, charSequence, 0, 2, (Object) null);
            if (find$default == null || (str = find$default.getValue()) == null) {
                str = StringFog.decrypt(new byte[]{Ascii.RS, 73, 59}, new byte[]{43, 103, Ascii.VT, 49, -2, -7, 85, 34});
            }
            MatchResult find$default2 = Regex.find$default(new Regex(StringFog.decrypt(new byte[]{96, -4, -64, 114, 53, 58, 122, 1, 45, -108, -103, 45, Utf8.REPLACEMENT_BYTE, 35, 126, 66, 97, -97, -81, 100, 92, 117, 55, 49, 59, -22}, new byte[]{72, -61, -4, 79, 116, 74, 10, 109})), charSequence, 0, 2, (Object) null);
            if (find$default2 == null || (str2 = find$default2.getValue()) == null) {
                str2 = StringFog.decrypt(new byte[]{Ascii.CR, 9, 119, 4, -119, -53}, new byte[]{56, 58, SignedBytes.MAX_POWER_OF_TWO, 42, -70, -3, -66, Ascii.VT});
            }
            MatchResult find$default3 = Regex.find$default(new Regex(StringFog.decrypt(new byte[]{83, 111, -109, 109, 80, -91, 33, -76, Ascii.SYN, 53, Byte.MIN_VALUE, 121, 72, -3, 126, -30, 38, 123, -121, 111, 46, -111, 125, -14}, new byte[]{123, 80, -81, 80, 19, -51, 83, -37})), charSequence, 0, 2, (Object) null);
            if (find$default3 == null || (str3 = find$default3.getValue()) == null) {
                str3 = StringFog.decrypt(new byte[]{-98, -125, 44}, new byte[]{-81, -79, Ascii.US, 44, -66, 67, 70, 76});
            }
            MatchResult find$default4 = Regex.find$default(new Regex(StringFog.decrypt(new byte[]{38, 74, 33, 38, 90, Ascii.US, 73, -66, 124, Ascii.FS, 50, 50, 85, 45, 4}, new byte[]{Ascii.SO, 117, Ascii.GS, Ascii.ESC, 9, 126, 47, -33})), charSequence, 0, 2, (Object) null);
            if (find$default4 == null || (str4 = find$default4.getValue()) == null) {
                str4 = StringFog.decrypt(new byte[]{Ascii.SI, 56, -83, -94, -14, -104}, new byte[]{58, Ascii.VT, -102, -116, -63, -82, -53, 42});
            }
            webView.getSettings().setUserAgentString("Mozilla/" + str + " (Linux; Android 10; K) AppleWebKit/" + str2 + " (KHTML, like Gecko) Chrome/" + str3 + ".0.0.0 Mobile Safari/" + str4);
            return;
        }
        WebSettings settings = webView.getSettings();
        String userAgentString2 = webView.getSettings().getUserAgentString();
        Intrinsics.checkNotNullExpressionValue(userAgentString2, StringFog.decrypt(new byte[]{109, Ascii.RS, -37, Utf8.REPLACEMENT_BYTE, 0, -55, Ascii.US, -13, 109, Ascii.RS, -63, Ascii.RS, 32, -40, Ascii.US, -37, 100, Ascii.FS, -121, 68, 93, -126, 68}, new byte[]{10, 123, -81, 106, 115, -84, 109, -78}));
        settings.setUserAgentString(new Regex(StringFog.decrypt(new byte[]{-109, -49, -32, 45, 59, 58, -6, -54, -55, -121, -87, 53, 35, 105, -16, -4, -112, -88, -77, 115}, new byte[]{-69, -12, -64, 90, 77, 70, -84, -81})).replace((CharSequence) userAgentString2, ""));
    }
}
