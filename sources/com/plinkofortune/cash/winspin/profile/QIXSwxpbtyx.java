package com.plinkofortune.cash.winspin.profile;

import android.content.ClipData;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Message;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.webkit.PermissionRequest;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.fragment.app.FragmentActivity;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.plinkofortune.cash.winspin.StringFog;
import com.plinkofortune.cash.winspin.nav.OgNFEsnlSFL;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.io.encoding.Base64;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import okio.Utf8;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0007\u0018\u0000 [2\u00020\u0001:\u0001[BS\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00128\u0010\u0006\u001a4\u0012\u0015\u0012\u0013\u0018\u00010\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\f¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\u0007¢\u0006\u0004\b\u000f\u0010\u0010J,\u00100\u001a\u00020\u001e2\b\u0010\u000b\u001a\u0004\u0018\u00010\b2\u0006\u00101\u001a\u00020\u001e2\u0006\u00102\u001a\u00020\u001e2\b\u00103\u001a\u0004\u0018\u000104H\u0016J\u0012\u00105\u001a\u00020\u000e2\b\u00106\u001a\u0004\u0018\u00010\bH\u0016J\u001a\u00107\u001a\u00020\u000e2\b\u0010\u000b\u001a\u0004\u0018\u00010\b2\u0006\u0010\r\u001a\u00020\fH\u0016J\u0012\u00108\u001a\u00020\u000e2\b\u00109\u001a\u0004\u0018\u00010'H\u0016J2\u0010:\u001a\u00020\u001e2\b\u0010;\u001a\u0004\u0018\u00010\b2\u0014\u0010<\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u001b\u0018\u00010\u001a2\b\u0010=\u001a\u0004\u0018\u00010>H\u0016J\u001c\u0010?\u001a\u00020\u000e2\b\u0010\u000b\u001a\u0004\u0018\u00010*2\b\u0010@\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010A\u001a\u00020\u000eH\u0016J\u0006\u0010B\u001a\u00020\u000eJ\u0010\u0010C\u001a\u00020\u001e2\u0006\u0010D\u001a\u00020\u001eH\u0002J%\u0010E\u001a\u00020-2\u000e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001b2\u0006\u0010\"\u001a\u00020\u001eH\u0002¢\u0006\u0002\u0010FJ\b\u0010G\u001a\u00020-H\u0002J\b\u0010H\u001a\u00020-H\u0002J\u0012\u0010I\u001a\u0004\u0018\u00010\u001c2\u0006\u0010J\u001a\u00020 H\u0002J\u0012\u0010K\u001a\u0004\u0018\u00010L2\u0006\u0010J\u001a\u00020 H\u0002J!\u0010M\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001c\u0018\u00010\u001b2\b\u0010N\u001a\u0004\u0018\u00010-H\u0002¢\u0006\u0002\u0010OJ\n\u0010P\u001a\u0004\u0018\u00010\u001cH\u0002J\u0012\u0010Q\u001a\u00020\u001e2\b\u0010R\u001a\u0004\u0018\u00010\u001cH\u0002J\b\u0010S\u001a\u00020\u001eH\u0002J\u001d\u0010T\u001a\u00020\u001e2\u000e\u0010U\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001bH\u0002¢\u0006\u0002\u0010VJ\u001d\u0010W\u001a\u00020\u001e2\u000e\u0010U\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001bH\u0002¢\u0006\u0002\u0010VJ\u001d\u0010X\u001a\u00020\u001e2\u000e\u0010U\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001bH\u0002¢\u0006\u0002\u0010VJ%\u0010Y\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010 0\u001b2\u000e\u0010U\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001bH\u0002¢\u0006\u0002\u0010ZR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\u0002\n\u0000R@\u0010\u0006\u001a4\u0012\u0015\u0012\u0013\u0018\u00010\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\f¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\u0007X\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0011\u001a\u0004\u0018\u00010\u00128BX\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0019\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u001b\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001bX\u000e¢\u0006\u0004\n\u0002\u0010!R\u000e\u0010\"\u001a\u00020\u001eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u001eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u001eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010+\u001a\u0010\u0012\f\u0012\n .*\u0004\u0018\u00010-0-0,X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010/\u001a\u0010\u0012\f\u0012\n .*\u0004\u0018\u00010 0 0,X\u0004¢\u0006\u0002\n\u0000¨\u0006\\"}, d2 = {"Lcom/plinkofortune/cash/winspin/profile/QIXSwxpbtyx;", "Landroid/webkit/WebChromeClient;", "fragment", "Lcom/plinkofortune/cash/winspin/profile/PcAtMNHQpJHd;", "webViewController", "Lcom/plinkofortune/cash/winspin/nav/OgNFEsnlSFL;", "progressChanged", "Lkotlin/Function2;", "Landroid/webkit/WebView;", "Lkotlin/ParameterName;", "name", "view", "", "newProgress", "", "<init>", "(Lcom/plinkofortune/cash/winspin/profile/PcAtMNHQpJHd;Lcom/plinkofortune/cash/winspin/nav/OgNFEsnlSFL;Lkotlin/jvm/functions/Function2;)V", "controller", "Landroidx/core/view/WindowInsetsControllerCompat;", "getController", "()Landroidx/core/view/WindowInsetsControllerCompat;", "controller$delegate", "Lkotlin/Lazy;", "customViewCallback", "Landroid/webkit/WebChromeClient$CustomViewCallback;", "contentCallback", "Landroid/webkit/ValueCallback;", "", "Landroid/net/Uri;", "contentPermissionRequested", "", "acceptTypes", "", "[Ljava/lang/String;", "allowMultiple", "captureEnabled", "videoOutputFileUri", "imageOutputFileUri", "videoCallback", "Landroid/webkit/PermissionRequest;", "videoPermissionRequested", "customView", "Landroid/view/View;", "contentLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "videoLauncher", "onCreateWindow", "isDialog", "isUserGesture", "resultMsg", "Landroid/os/Message;", "onCloseWindow", "window", "onProgressChanged", "onPermissionRequest", "request", "onShowFileChooser", "webView", "filePathCallback", "fileChooserParams", "Landroid/webkit/WebChromeClient$FileChooserParams;", "onShowCustomView", "callback", "onHideCustomView", "onDestroy", "startPickerIntent", "grantedCameraPermission", "getFileChooserIntent", "([Ljava/lang/String;Z)Landroid/content/Intent;", "getPhotoIntent", "getVideoIntent", "getOutputUri", "intentType", "getCapturedFile", "Ljava/io/File;", "getSelectedFiles", "data", "(Landroid/content/Intent;)[Landroid/net/Uri;", "getCapturedMediaFile", "isFileNotEmpty", "uri", "needsCameraPermission", "acceptsAny", "types", "([Ljava/lang/String;)Z", "acceptsImages", "acceptsVideo", "getAcceptedMimeType", "([Ljava/lang/String;)[Ljava/lang/String;", "Companion", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: QIXSwxpbtyx.kt */
public final class QIXSwxpbtyx extends WebChromeClient {
    public static final int $stable = 8;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String DEFAULT_MIME_TYPES = StringFog.decrypt(new byte[]{47, -101, -59}, new byte[]{5, -76, -17, 35, -12, 116, -40, -76});
    private String[] acceptTypes;
    private boolean allowMultiple;
    private boolean captureEnabled;
    private ValueCallback<Uri[]> contentCallback;
    private final ActivityResultLauncher<Intent> contentLauncher;
    private boolean contentPermissionRequested;
    private final Lazy controller$delegate = LazyKt.lazy(new QIXSwxpbtyx$$ExternalSyntheticLambda0(this));
    private View customView;
    private WebChromeClient.CustomViewCallback customViewCallback;
    private final PcAtMNHQpJHd fragment;
    private Uri imageOutputFileUri;
    private final Function2<WebView, Integer, Unit> progressChanged;
    private PermissionRequest videoCallback;
    private final ActivityResultLauncher<String> videoLauncher;
    private Uri videoOutputFileUri;
    private boolean videoPermissionRequested;
    private final OgNFEsnlSFL webViewController;

    public QIXSwxpbtyx(PcAtMNHQpJHd pcAtMNHQpJHd, OgNFEsnlSFL ogNFEsnlSFL, Function2<? super WebView, ? super Integer, Unit> function2) {
        Intrinsics.checkNotNullParameter(pcAtMNHQpJHd, StringFog.decrypt(new byte[]{Ascii.SO, 17, -94, 100, 101, -62, 3, -48}, new byte[]{104, 99, -61, 3, 8, -89, 109, -92}));
        Intrinsics.checkNotNullParameter(function2, StringFog.decrypt(new byte[]{109, -38, -116, 107, 19, 4, -5, 126, 94, -64, -126, 98, 6, 4, -20}, new byte[]{Ascii.GS, -88, -29, Ascii.FF, 97, 97, -120, Ascii.CR}));
        this.fragment = pcAtMNHQpJHd;
        this.webViewController = ogNFEsnlSFL;
        this.progressChanged = function2;
        ActivityResultLauncher<Intent> registerForActivityResult = pcAtMNHQpJHd.registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new QIXSwxpbtyx$$ExternalSyntheticLambda1(this));
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult, StringFog.decrypt(new byte[]{-36, -92, Ascii.CR, 65, Ascii.DLE, 55, 46, 108, -24, -82, Ascii.CAN, 105, 0, 55, 34, 104, -57, -75, 19, 122, 6, 48, 62, 114, -38, -23, 68, 6, 77, 106}, new byte[]{-82, -63, 106, 40, 99, 67, 75, Ascii.RS}));
        this.contentLauncher = registerForActivityResult;
        ActivityResultLauncher<String> registerForActivityResult2 = pcAtMNHQpJHd.registerForActivityResult(new ActivityResultContracts.RequestPermission(), new QIXSwxpbtyx$$ExternalSyntheticLambda2(this));
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult2, StringFog.decrypt(new byte[]{66, 32, Utf8.REPLACEMENT_BYTE, -123, Base64.padSymbol, -62, Base64.padSymbol, -29, 118, 42, 42, -83, 45, -62, 49, -25, 89, 49, 33, -66, 43, -59, 45, -3, 68, 109, 118, -62, 96, -97}, new byte[]{48, 69, 88, -20, 78, -74, 88, -111}));
        this.videoLauncher = registerForActivityResult2;
    }

    private final WindowInsetsControllerCompat getController() {
        return (WindowInsetsControllerCompat) this.controller$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final WindowInsetsControllerCompat controller_delegate$lambda$1(QIXSwxpbtyx qIXSwxpbtyx) {
        FragmentActivity activity = qIXSwxpbtyx.fragment.getActivity();
        if (activity != null) {
            return new WindowInsetsControllerCompat(activity.getWindow(), activity.getWindow().getDecorView());
        }
        return null;
    }

    /* access modifiers changed from: private */
    public static final void contentLauncher$lambda$2(QIXSwxpbtyx qIXSwxpbtyx, ActivityResult activityResult) {
        Uri[] uriArr;
        List filterNotNull;
        Intrinsics.checkNotNullParameter(activityResult, StringFog.decrypt(new byte[]{67, -123, Utf8.REPLACEMENT_BYTE, 113, 55, -10}, new byte[]{49, -32, 76, 4, 91, -126, -75, 62}));
        if (qIXSwxpbtyx.contentCallback != null) {
            Uri[] selectedFiles = activityResult.getResultCode() == -1 ? qIXSwxpbtyx.getSelectedFiles(activityResult.getData()) : null;
            if (selectedFiles == null || (filterNotNull = ArraysKt.filterNotNull(selectedFiles)) == null || (uriArr = (Uri[]) filterNotNull.toArray(new Uri[0])) == null) {
                uriArr = new Uri[0];
            }
            ValueCallback<Uri[]> valueCallback = qIXSwxpbtyx.contentCallback;
            if (valueCallback != null) {
                valueCallback.onReceiveValue(uriArr);
            }
            qIXSwxpbtyx.contentCallback = null;
            qIXSwxpbtyx.imageOutputFileUri = null;
            qIXSwxpbtyx.videoOutputFileUri = null;
            qIXSwxpbtyx.acceptTypes = null;
        }
    }

    /* access modifiers changed from: private */
    public static final void videoLauncher$lambda$3(QIXSwxpbtyx qIXSwxpbtyx, boolean z) {
        if (qIXSwxpbtyx.contentPermissionRequested) {
            qIXSwxpbtyx.contentPermissionRequested = false;
            qIXSwxpbtyx.startPickerIntent(z);
        }
        if (qIXSwxpbtyx.videoPermissionRequested) {
            qIXSwxpbtyx.videoPermissionRequested = false;
            if (z) {
                PermissionRequest permissionRequest = qIXSwxpbtyx.videoCallback;
                if (permissionRequest != null) {
                    permissionRequest.grant(new String[]{StringFog.decrypt(new byte[]{37, 76, -66, 52, -50, -25, -124, -48, 51, 71, -72, 45, -56, -6, -50, -116, 33, 81, -75, 51, -45, -19, -123, -48, Ascii.DC2, 107, -98, 3, -18, -47, -93, -65, Ascii.DC4, 118, -113, Ascii.DC4, -28}, new byte[]{68, 34, -38, 70, -95, -114, -32, -2})});
                }
            } else {
                PermissionRequest permissionRequest2 = qIXSwxpbtyx.videoCallback;
                if (permissionRequest2 != null) {
                    permissionRequest2.deny();
                }
            }
            qIXSwxpbtyx.videoCallback = null;
        }
    }

    public boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
        OgNFEsnlSFL ogNFEsnlSFL = this.webViewController;
        if (ogNFEsnlSFL == null) {
            return true;
        }
        ogNFEsnlSFL.openNewTab(z, new QIXSwxpbtyx$$ExternalSyntheticLambda3(message));
        return true;
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateWindow$lambda$4(Message message, WebView webView) {
        Intrinsics.checkNotNullParameter(webView, StringFog.decrypt(new byte[]{97, 37, 73, 48, -23, 112, 78, -50, 103, 53, 122, 56, -8, 98}, new byte[]{2, 87, 44, 81, -99, Ascii.NAK, 42, -103}));
        WebView.WebViewTransport webViewTransport = null;
        Object obj = message != null ? message.obj : null;
        if (obj instanceof WebView.WebViewTransport) {
            webViewTransport = (WebView.WebViewTransport) obj;
        }
        if (webViewTransport != null) {
            webViewTransport.setWebView(webView);
        }
        if (message != null) {
            message.sendToTarget();
        }
        return Unit.INSTANCE;
    }

    public void onCloseWindow(WebView webView) {
        OgNFEsnlSFL ogNFEsnlSFL = this.webViewController;
        if (ogNFEsnlSFL != null) {
            ogNFEsnlSFL.closeTopTab();
        }
        if (webView != null) {
            webView.destroy();
        }
    }

    public void onProgressChanged(WebView webView, int i) {
        this.progressChanged.invoke(webView, Integer.valueOf(i));
    }

    public void onPermissionRequest(PermissionRequest permissionRequest) {
        if (permissionRequest != null) {
            String[] resources = permissionRequest.getResources();
            Intrinsics.checkNotNullExpressionValue(resources, StringFog.decrypt(new byte[]{-81, -58, -109, -19, 0, 70, 66, 89, -70, -64, -126, -52, 77, Ascii.ESC, 3, 2, -31}, new byte[]{-56, -93, -25, -65, 101, 53, 45, 44}));
            if (!ArraysKt.contains((T[]) (Object[]) resources, StringFog.decrypt(new byte[]{-93, -49, 94, -94, Ascii.GS, 65, -107, -103, -75, -60, 88, -69, Ascii.ESC, 92, -33, -59, -89, -46, 85, -91, 0, 75, -108, -103, -108, -24, 126, -107, Base64.padSymbol, 119, -78, -10, -110, -11, 111, -126, 55}, new byte[]{-62, -95, 58, -48, 114, 40, -15, -73}))) {
                permissionRequest.deny();
                return;
            }
            FragmentActivity activity = this.fragment.getActivity();
            if (activity != null) {
                if (ContextCompat.checkSelfPermission(activity, StringFog.decrypt(new byte[]{86, Byte.MAX_VALUE, Ascii.ETB, 122, -9, 72, Utf8.REPLACEMENT_BYTE, -79, 71, 116, 1, 101, -15, 82, 40, -10, 88, Byte.MAX_VALUE, 93, 75, -39, 108, Ascii.RS, -51, 118}, new byte[]{55, 17, 115, 8, -104, 33, 91, -97})) == 0) {
                    permissionRequest.grant(permissionRequest.getResources());
                    return;
                }
                this.videoCallback = permissionRequest;
                this.videoPermissionRequested = true;
                this.videoLauncher.launch(StringFog.decrypt(new byte[]{-93, 59, -92, -33, -84, -65, Ascii.FF, -68, -78, 48, -78, -64, -86, -91, Ascii.ESC, -5, -83, 59, -18, -18, -126, -101, 45, -64, -125}, new byte[]{-62, 85, -64, -83, -61, -42, 104, -110}));
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0014, code lost:
        if (r4.getMode() == 1) goto L_0x0018;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onShowFileChooser(android.webkit.WebView r2, android.webkit.ValueCallback<android.net.Uri[]> r3, android.webkit.WebChromeClient.FileChooserParams r4) {
        /*
            r1 = this;
            r1.contentCallback = r3
            if (r4 == 0) goto L_0x0009
            java.lang.String[] r2 = r4.getAcceptTypes()
            goto L_0x000a
        L_0x0009:
            r2 = 0
        L_0x000a:
            r1.acceptTypes = r2
            r2 = 0
            if (r4 == 0) goto L_0x0017
            int r3 = r4.getMode()
            r0 = 1
            if (r3 != r0) goto L_0x0017
            goto L_0x0018
        L_0x0017:
            r0 = r2
        L_0x0018:
            r1.allowMultiple = r0
            if (r4 == 0) goto L_0x0021
            boolean r3 = r4.isCaptureEnabled()
            goto L_0x0022
        L_0x0021:
            r3 = r2
        L_0x0022:
            r1.captureEnabled = r3
            boolean r2 = r1.startPickerIntent(r2)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.plinkofortune.cash.winspin.profile.QIXSwxpbtyx.onShowFileChooser(android.webkit.WebView, android.webkit.ValueCallback, android.webkit.WebChromeClient$FileChooserParams):boolean");
    }

    public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback2) {
        if (view != null) {
            if (this.customView != null) {
                onHideCustomView();
                return;
            }
            this.customView = view;
            this.customViewCallback = customViewCallback2;
            this.fragment.addFullScreenView(view);
            WindowInsetsControllerCompat controller = getController();
            if (controller != null) {
                controller.setSystemBarsBehavior(2);
            }
            WindowInsetsControllerCompat controller2 = getController();
            if (controller2 != null) {
                controller2.hide(WindowInsetsCompat.Type.systemBars());
            }
        }
    }

    public void onHideCustomView() {
        View view = this.customView;
        if (view != null) {
            PcAtMNHQpJHd pcAtMNHQpJHd = this.fragment;
            Intrinsics.checkNotNull(view);
            pcAtMNHQpJHd.removeFullScreenView(view);
            this.customView = null;
            WebChromeClient.CustomViewCallback customViewCallback2 = this.customViewCallback;
            if (customViewCallback2 != null) {
                customViewCallback2.onCustomViewHidden();
            }
            this.customViewCallback = null;
            WindowInsetsControllerCompat controller = getController();
            if (controller != null) {
                controller.show(WindowInsetsCompat.Type.systemBars());
            }
        }
    }

    public final void onDestroy() {
        this.contentLauncher.unregister();
        this.videoLauncher.unregister();
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00ce A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean startPickerIntent(boolean r9) {
        /*
            r8 = this;
            com.plinkofortune.cash.winspin.profile.PcAtMNHQpJHd r0 = r8.fragment
            androidx.fragment.app.FragmentActivity r0 = r0.getActivity()
            r1 = 0
            if (r0 != 0) goto L_0x000a
            return r1
        L_0x000a:
            java.lang.String[] r2 = r8.acceptTypes
            boolean r2 = r8.acceptsImages(r2)
            java.lang.String[] r3 = r8.acceptTypes
            boolean r3 = r8.acceptsVideo(r3)
            boolean r4 = r8.captureEnabled
            r5 = 1
            r6 = 8
            if (r4 == 0) goto L_0x004c
            if (r9 != 0) goto L_0x003e
            boolean r9 = r8.needsCameraPermission()
            if (r9 != 0) goto L_0x0026
            goto L_0x003e
        L_0x0026:
            r8.contentPermissionRequested = r5
            androidx.activity.result.ActivityResultLauncher<java.lang.String> r9 = r8.videoLauncher
            r0 = 25
            byte[] r0 = new byte[r0]
            r0 = {50, 71, -13, 4, -119, -73, -105, 99, 35, 76, -27, 27, -113, -83, -128, 36, 60, 71, -71, 53, -89, -109, -74, 31, 18} // fill-array
            byte[] r1 = new byte[r6]
            r1 = {83, 41, -105, 118, -26, -34, -13, 77} // fill-array
            java.lang.String r0 = com.plinkofortune.cash.winspin.StringFog.decrypt(r0, r1)
            r9.launch(r0)
            return r5
        L_0x003e:
            if (r2 == 0) goto L_0x0045
            android.content.Intent r9 = r8.getPhotoIntent()
            goto L_0x004d
        L_0x0045:
            if (r3 == 0) goto L_0x004c
            android.content.Intent r9 = r8.getVideoIntent()
            goto L_0x004d
        L_0x004c:
            r9 = 0
        L_0x004d:
            if (r9 != 0) goto L_0x00bc
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            boolean r4 = r8.needsCameraPermission()
            if (r4 != 0) goto L_0x006c
            if (r2 == 0) goto L_0x0063
            android.content.Intent r2 = r8.getPhotoIntent()
            r9.add(r2)
        L_0x0063:
            if (r3 == 0) goto L_0x006c
            android.content.Intent r2 = r8.getVideoIntent()
            r9.add(r2)
        L_0x006c:
            java.lang.String[] r2 = r8.acceptTypes
            boolean r3 = r8.allowMultiple
            android.content.Intent r2 = r8.getFileChooserIntent(r2, r3)
            android.content.Intent r3 = new android.content.Intent
            r4 = 29
            byte[] r4 = new byte[r4]
            r4 = {118, 121, 72, 63, -122, 47, 111, -49, 126, 121, 88, 40, -121, 50, 37, -128, 116, 99, 69, 34, -121, 104, 72, -87, 88, 88, 127, 8, -69} // fill-array
            byte[] r7 = new byte[r6]
            r7 = {23, 23, 44, 77, -23, 70, 11, -31} // fill-array
            java.lang.String r4 = com.plinkofortune.cash.winspin.StringFog.decrypt(r4, r7)
            r3.<init>(r4)
            r4 = 27
            byte[] r4 = new byte[r4]
            r4 = {-70, 115, 85, -39, -116, -93, 113, -79, -78, 115, 69, -50, -115, -66, 59, -6, -93, 105, 67, -54, -51, -125, 91, -53, -98, 83, 101} // fill-array
            byte[] r7 = new byte[r6]
            r7 = {-37, 29, 49, -85, -29, -54, 21, -97} // fill-array
            java.lang.String r4 = com.plinkofortune.cash.winspin.StringFog.decrypt(r4, r7)
            android.os.Parcelable r2 = (android.os.Parcelable) r2
            r3.putExtra(r4, r2)
            r2 = 36
            byte[] r2 = new byte[r2]
            r2 = {-5, -56, 122, -28, -48, 43, -73, -78, -13, -56, 106, -13, -47, 54, -3, -7, -30, -46, 108, -9, -111, 11, -99, -43, -50, -17, 95, -38, -32, 11, -99, -56, -33, -24, 74, -59} // fill-array
            byte[] r4 = new byte[r6]
            r4 = {-102, -90, 30, -106, -65, 66, -45, -100} // fill-array
            java.lang.String r2 = com.plinkofortune.cash.winspin.StringFog.decrypt(r2, r4)
            java.util.Collection r9 = (java.util.Collection) r9
            android.content.Intent[] r4 = new android.content.Intent[r1]
            java.lang.Object[] r9 = r9.toArray(r4)
            android.os.Parcelable[] r9 = (android.os.Parcelable[]) r9
            r3.putExtra(r2, r9)
            r9 = r3
        L_0x00bc:
            android.content.pm.PackageManager r0 = r0.getPackageManager()
            if (r0 == 0) goto L_0x00ce
            android.content.ComponentName r0 = r9.resolveActivity(r0)
            if (r0 == 0) goto L_0x00ce
            androidx.activity.result.ActivityResultLauncher<android.content.Intent> r0 = r8.contentLauncher
            r0.launch(r9)
            return r5
        L_0x00ce:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.plinkofortune.cash.winspin.profile.QIXSwxpbtyx.startPickerIntent(boolean):boolean");
    }

    private final Intent getFileChooserIntent(String[] strArr, boolean z) {
        Intent intent = new Intent(StringFog.decrypt(new byte[]{-127, 99, 40, -78, -65, -102, Ascii.GS, 83, -119, 99, 56, -91, -66, -121, 87, Ascii.FS, -125, 121, 37, -81, -66, -35, 62, 56, -76, 82, Ascii.SI, -113, -98, -89, 60, 51, -76}, new byte[]{-32, Ascii.CR, 76, -64, -48, -13, 121, 125}));
        intent.addCategory(StringFog.decrypt(new byte[]{55, 4, Base64.padSymbol, Base64.padSymbol, 9, 96, 115, 42, Utf8.REPLACEMENT_BYTE, 4, 45, 42, 8, 125, 57, 103, 55, Ascii.RS, 60, 40, 9, 123, 110, 42, Ascii.EM, 58, Ascii.FS, 1, 39, 75, 91, 65}, new byte[]{86, 106, 89, 79, 102, 9, Ascii.ETB, 4}));
        intent.setType(DEFAULT_MIME_TYPES);
        intent.putExtra(StringFog.decrypt(new byte[]{72, -109, 32, 101, 77, -82, -19, Ascii.DLE, SignedBytes.MAX_POWER_OF_TWO, -109, 48, 114, 76, -77, -89, 91, 81, -119, 54, 118, Ascii.FF, -118, -64, 115, 108, -94, Ascii.DLE, 78, 114, -126, -38}, new byte[]{41, -3, 68, Ascii.ETB, 34, -57, -119, 62}), getAcceptedMimeType(strArr));
        intent.putExtra(StringFog.decrypt(new byte[]{-51, -105, 95, -119, -45, 60, -103, -82, -59, -105, 79, -98, -46, 33, -45, -27, -44, -115, 73, -102, -110, Ascii.DC4, -79, -52, -29, -82, 100, -74, -23, Ascii.EM, -87, -55, -4, -75, 126}, new byte[]{-84, -7, 59, -5, -68, 85, -3, Byte.MIN_VALUE}), z);
        return intent;
    }

    private final Intent getPhotoIntent() {
        Intent intent = new Intent(StringFog.decrypt(new byte[]{-103, 75, -3, 82, 97, 96, Ascii.EM, Ascii.SYN, -107, SignedBytes.MAX_POWER_OF_TWO, -3, 73, 111, 39, Ascii.FS, 91, -116, 76, -10, 78, 32, SignedBytes.MAX_POWER_OF_TWO, 48, 121, -65, 96, -58, 99, 79, 89, 41, 109, -86, 96}, new byte[]{-8, 37, -103, 32, Ascii.SO, 9, 125, 56}));
        this.imageOutputFileUri = getOutputUri(StringFog.decrypt(new byte[]{Ascii.NAK, -111, 95, Ascii.VT, 106, 76, -70, 33, Ascii.EM, -102, 95, Ascii.DLE, 100, Ascii.VT, -65, 108, 0, -106, 84, Ascii.ETB, 43, 108, -109, 78, 51, -70, 100, 58, 68, 117, -118, 90, 38, -70}, new byte[]{116, -1, 59, 121, 5, 37, -34, Ascii.SI}));
        intent.putExtra(StringFog.decrypt(new byte[]{-52, -73, -72, -115, -19, 120}, new byte[]{-93, -62, -52, -3, -104, Ascii.FF, -107, -84}), this.imageOutputFileUri);
        return intent;
    }

    private final Intent getVideoIntent() {
        Intent intent = new Intent(StringFog.decrypt(new byte[]{-71, 84, 74, 75, 35, 79, 80, Ascii.SO, -75, 95, 74, 80, 45, 8, 85, 67, -84, 83, 65, 87, 98, 112, 125, 100, -99, 117, 113, 122, Ascii.CR, 118, 96, 117, -118, Byte.MAX_VALUE}, new byte[]{-40, 58, 46, 57, 76, 38, 52, 32}));
        this.videoOutputFileUri = getOutputUri(StringFog.decrypt(new byte[]{-16, 116, -27, -7, 111, -31, Ascii.ETB, -41, -4, Byte.MAX_VALUE, -27, -30, 97, -90, Ascii.DC2, -102, -27, 115, -18, -27, 46, -34, 58, -67, -44, 85, -34, -56, 65, -40, 39, -84, -61, 95}, new byte[]{-111, Ascii.SUB, -127, -117, 0, -120, 115, -7}));
        intent.putExtra(StringFog.decrypt(new byte[]{-57, Ascii.VT, 47, 0, 1, -75}, new byte[]{-88, 126, 91, 112, 116, -63, 33, -38}), this.videoOutputFileUri);
        return intent;
    }

    private final Uri getOutputUri(String str) {
        File file;
        FragmentActivity activity = this.fragment.getActivity();
        if (activity == null) {
            return null;
        }
        try {
            file = getCapturedFile(str);
        } catch (IOException unused) {
            file = null;
        }
        if (file == null) {
            return null;
        }
        try {
            return FileProvider.getUriForFile(activity, activity.getPackageName() + ".fileprovider", file);
        } catch (Exception unused2) {
            return null;
        }
    }

    private final File getCapturedFile(String str) {
        File externalFilesDir;
        FragmentActivity activity = this.fragment.getActivity();
        if (activity == null || (externalFilesDir = activity.getExternalFilesDir((String) null)) == null) {
            return null;
        }
        if (Intrinsics.areEqual((Object) str, (Object) StringFog.decrypt(new byte[]{93, 41, 17, -83, -17, -37, Ascii.SUB, -9, 81, 34, 17, -74, -31, -100, Ascii.US, -70, 72, 46, Ascii.SUB, -79, -82, -5, 51, -104, 123, 2, 42, -100, -63, -30, 42, -116, 110, 2}, new byte[]{60, 71, 117, -33, Byte.MIN_VALUE, -78, 126, -39}))) {
            return File.createTempFile(StringFog.decrypt(new byte[]{118, 92, -83, -36, 42}, new byte[]{Ascii.US, 49, -52, -69, 79, -16, 46, 120}), StringFog.decrypt(new byte[]{86, -65, 125, -9}, new byte[]{120, -43, Ascii.CR, -112, 69, 113, 79, 94}), externalFilesDir);
        }
        if (Intrinsics.areEqual((Object) str, (Object) StringFog.decrypt(new byte[]{85, -27, -124, 87, 83, -94, -109, 66, 89, -18, -124, 76, 93, -27, -106, Ascii.SI, SignedBytes.MAX_POWER_OF_TWO, -30, -113, 75, Ascii.DC2, -99, -66, 40, 113, -60, -65, 102, 125, -101, -93, 57, 102, -50}, new byte[]{52, -117, -32, 37, 60, -53, -9, 108}))) {
            return File.createTempFile(StringFog.decrypt(new byte[]{78, Ascii.ESC, 17, -28, -16}, new byte[]{56, 114, 117, -127, -97, -83, -19, 113}), StringFog.decrypt(new byte[]{72, -55, -111, 123}, new byte[]{102, -92, -31, 79, 49, 48, 95, 86}), externalFilesDir);
        }
        return null;
    }

    private final Uri[] getSelectedFiles(Intent intent) {
        ClipData clipData;
        if (intent != null && intent.getData() != null) {
            return WebChromeClient.FileChooserParams.parseResult(-1, intent);
        }
        if (intent == null || (clipData = intent.getClipData()) == null) {
            Uri capturedMediaFile = getCapturedMediaFile();
            if (capturedMediaFile == null) {
                return null;
            }
            return new Uri[]{capturedMediaFile};
        }
        int itemCount = clipData.getItemCount();
        Uri[] uriArr = new Uri[itemCount];
        for (int i = 0; i < itemCount; i++) {
            uriArr[i] = clipData.getItemAt(i).getUri();
        }
        return uriArr;
    }

    private final Uri getCapturedMediaFile() {
        Uri uri = this.imageOutputFileUri;
        if (uri != null && isFileNotEmpty(uri)) {
            return this.imageOutputFileUri;
        }
        Uri uri2 = this.videoOutputFileUri;
        if (uri2 == null || !isFileNotEmpty(uri2)) {
            return null;
        }
        return this.videoOutputFileUri;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0045, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r8, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0049, code lost:
        throw r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean isFileNotEmpty(android.net.Uri r8) {
        /*
            r7 = this;
            com.plinkofortune.cash.winspin.profile.PcAtMNHQpJHd r0 = r7.fragment
            androidx.fragment.app.FragmentActivity r0 = r0.getActivity()
            r1 = 0
            if (r0 != 0) goto L_0x000a
            return r1
        L_0x000a:
            if (r8 != 0) goto L_0x000d
            return r1
        L_0x000d:
            android.content.ContentResolver r0 = r0.getContentResolver()     // Catch:{ IOException -> 0x004a }
            r2 = 1
            byte[] r3 = new byte[r2]     // Catch:{ IOException -> 0x004a }
            r4 = 50
            r3[r1] = r4     // Catch:{ IOException -> 0x004a }
            r4 = 8
            byte[] r4 = new byte[r4]     // Catch:{ IOException -> 0x004a }
            r4 = {64, -39, -98, 27, 106, 40, -3, -118} // fill-array     // Catch:{ IOException -> 0x004a }
            java.lang.String r3 = com.plinkofortune.cash.winspin.StringFog.decrypt(r3, r4)     // Catch:{ IOException -> 0x004a }
            android.content.res.AssetFileDescriptor r8 = r0.openAssetFileDescriptor(r8, r3)     // Catch:{ IOException -> 0x004a }
            if (r8 == 0) goto L_0x004a
            java.io.Closeable r8 = (java.io.Closeable) r8     // Catch:{ IOException -> 0x004a }
            r0 = r8
            android.content.res.AssetFileDescriptor r0 = (android.content.res.AssetFileDescriptor) r0     // Catch:{ all -> 0x0043 }
            long r3 = r0.getLength()     // Catch:{ all -> 0x0043 }
            r5 = 0
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 <= 0) goto L_0x003a
            r0 = r2
            goto L_0x003b
        L_0x003a:
            r0 = r1
        L_0x003b:
            r3 = 0
            kotlin.io.CloseableKt.closeFinally(r8, r3)     // Catch:{ IOException -> 0x004a }
            if (r0 != r2) goto L_0x0042
            return r2
        L_0x0042:
            return r1
        L_0x0043:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x0045 }
        L_0x0045:
            r2 = move-exception
            kotlin.io.CloseableKt.closeFinally(r8, r0)     // Catch:{ IOException -> 0x004a }
            throw r2     // Catch:{ IOException -> 0x004a }
        L_0x004a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.plinkofortune.cash.winspin.profile.QIXSwxpbtyx.isFileNotEmpty(android.net.Uri):boolean");
    }

    private final boolean needsCameraPermission() {
        String[] strArr;
        FragmentActivity activity = this.fragment.getActivity();
        if (activity == null) {
            return false;
        }
        try {
            strArr = activity.getPackageManager().getPackageInfo(activity.getPackageName(), 4096).requestedPermissions;
        } catch (PackageManager.NameNotFoundException unused) {
            strArr = null;
        }
        if (strArr == null || !ArraysKt.contains((T[]) strArr, StringFog.decrypt(new byte[]{-117, -1, 7, 3, 53, 73, -48, -103, -102, -12, 17, Ascii.FS, 51, 83, -57, -34, -123, -1, 77, 50, Ascii.ESC, 109, -15, -27, -85}, new byte[]{-22, -111, 99, 113, 90, 32, -76, -73})) || ContextCompat.checkSelfPermission(activity, StringFog.decrypt(new byte[]{-105, -52, -4, -35, 45, 81, -41, Ascii.FS, -122, -57, -22, -62, 43, 75, -64, 91, -103, -52, -74, -20, 3, 117, -10, 96, -73}, new byte[]{-10, -94, -104, -81, 66, 56, -77, 50})) == 0) {
            return false;
        }
        return true;
    }

    private final boolean acceptsAny(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return true;
        }
        for (String areEqual : strArr) {
            if (Intrinsics.areEqual((Object) areEqual, (Object) DEFAULT_MIME_TYPES)) {
                return true;
            }
        }
        return false;
    }

    private final boolean acceptsImages(String[] strArr) {
        String[] acceptedMimeType = getAcceptedMimeType(strArr);
        if (!acceptsAny(strArr)) {
            int length = acceptedMimeType.length;
            int i = 0;
            while (i < length) {
                String str = acceptedMimeType[i];
                if (str == null || !StringsKt.contains$default((CharSequence) str, (CharSequence) StringFog.decrypt(new byte[]{0, -96, 2, -106, -7}, new byte[]{105, -51, 99, -15, -100, -86, 105, -85}), false, 2, (Object) null)) {
                    i++;
                }
            }
            return false;
        }
        return true;
    }

    private final boolean acceptsVideo(String[] strArr) {
        String[] acceptedMimeType = getAcceptedMimeType(strArr);
        if (!acceptsAny(strArr)) {
            int length = acceptedMimeType.length;
            int i = 0;
            while (i < length) {
                String str = acceptedMimeType[i];
                if (str == null || !StringsKt.contains$default((CharSequence) str, (CharSequence) StringFog.decrypt(new byte[]{97, -33, -99, 60, -87}, new byte[]{Ascii.ETB, -74, -7, 89, -58, -29, 45, 123}), false, 2, (Object) null)) {
                    i++;
                }
            }
            return false;
        }
        return true;
    }

    private final String[] getAcceptedMimeType(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return new String[]{DEFAULT_MIME_TYPES};
        }
        List arrayList = new ArrayList();
        Iterator it = ArrayIteratorKt.iterator(strArr);
        while (it.hasNext()) {
            String str = (String) it.next();
            CharSequence charSequence = str;
            if (new Regex(StringFog.decrypt(new byte[]{116, 98, -4, 59, Ascii.FF}, new byte[]{40, 76, -96, 76, 39, 96, -56, -10})).matches(charSequence)) {
                String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(StringsKt.replace$default(str, StringFog.decrypt(new byte[]{Ascii.CR}, new byte[]{35, -14, 111, -1, 77, -43, -123, 114}), "", false, 4, (Object) null));
                if (mimeTypeFromExtension != null) {
                    arrayList.add(mimeTypeFromExtension);
                }
            } else if (charSequence.length() > 0) {
                arrayList.add(str);
            }
        }
        if (!arrayList.isEmpty()) {
            return (String[]) arrayList.toArray(new String[0]);
        }
        return new String[]{DEFAULT_MIME_TYPES};
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/plinkofortune/cash/winspin/profile/QIXSwxpbtyx$Companion;", "", "<init>", "()V", "DEFAULT_MIME_TYPES", "", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* compiled from: QIXSwxpbtyx.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
