package com.google.android.gms.internal.ads;

import android.net.TrafficStats;
import android.net.Uri;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.core.view.ViewCompat;
import androidx.webkit.ProxyConfig;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzac;
import com.google.android.gms.ads.internal.overlay.zzc;
import com.google.android.gms.ads.internal.overlay.zzn;
import com.google.android.gms.ads.internal.overlay.zzr;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzl;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzb;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.common.util.Predicate;
import com.google.common.net.HttpHeaders;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.annotation.ParametersAreNonnullByDefault;
import okhttp3.internal.ws.WebSocketProtocol;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public class zzcfs extends WebViewClient implements zzchc {
    public static final /* synthetic */ int zzb = 0;
    private boolean zzA;
    private boolean zzB;
    private int zzC;
    private boolean zzD;
    private final HashSet zzE;
    private final zzeea zzF;
    private View.OnAttachStateChangeListener zzG;
    protected zzbyh zza;
    private final zzcfk zzc;
    private final zzbbl zzd;
    private final HashMap zze = new HashMap();
    private final Object zzf = new Object();
    private zza zzg;
    private zzr zzh;
    private zzcha zzi;
    private zzchb zzj;
    private zzbih zzk;
    private zzbij zzl;
    private zzdel zzm;
    private boolean zzn;
    private boolean zzo;
    private int zzp = 0;
    private String zzq = "";
    private String zzr = "";
    private boolean zzs;
    private boolean zzt;
    private boolean zzu;
    private boolean zzv;
    private zzac zzw;
    private zzbsj zzx;
    private zzb zzy;
    private zzbse zzz;

    public zzcfs(zzcfk zzcfk, zzbbl zzbbl, boolean z, zzbsj zzbsj, zzbse zzbse, zzeea zzeea) {
        this.zzd = zzbbl;
        this.zzc = zzcfk;
        this.zzs = z;
        this.zzx = zzbsj;
        this.zzz = null;
        this.zzE = new HashSet(Arrays.asList(((String) zzbe.zzc().zza(zzbcn.zzfD)).split(",")));
        this.zzF = zzeea;
    }

    private static WebResourceResponse zzV() {
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzaR)).booleanValue()) {
            return new WebResourceResponse("", "", new ByteArrayInputStream(new byte[0]));
        }
        return null;
    }

    private final WebResourceResponse zzW(String str, Map map) throws IOException {
        HttpURLConnection httpURLConnection;
        WebResourceResponse webResourceResponse;
        String str2;
        URL url = new URL(str);
        try {
            TrafficStats.setThreadStatsTag(264);
            int i = 0;
            while (true) {
                i++;
                if (i <= 20) {
                    URLConnection openConnection = url.openConnection();
                    openConnection.setConnectTimeout(10000);
                    openConnection.setReadTimeout(10000);
                    for (Map.Entry entry : map.entrySet()) {
                        openConnection.addRequestProperty((String) entry.getKey(), (String) entry.getValue());
                    }
                    if (openConnection instanceof HttpURLConnection) {
                        httpURLConnection = (HttpURLConnection) openConnection;
                        zzv.zzq().zzf(this.zzc.getContext(), this.zzc.zzn().afmaVersion, false, httpURLConnection, false, 60000);
                        webResourceResponse = null;
                        zzl zzl2 = new zzl((String) null);
                        zzl2.zzc(httpURLConnection, (byte[]) null);
                        int responseCode = httpURLConnection.getResponseCode();
                        zzl2.zze(httpURLConnection, responseCode);
                        if (responseCode < 300 || responseCode >= 400) {
                            zzv.zzq();
                            zzv.zzq();
                            String contentType = httpURLConnection.getContentType();
                        } else {
                            String headerField = httpURLConnection.getHeaderField(HttpHeaders.LOCATION);
                            if (headerField != null) {
                                if (!headerField.startsWith("tel:")) {
                                    URL url2 = new URL(url, headerField);
                                    String protocol = url2.getProtocol();
                                    if (protocol != null) {
                                        if (!protocol.equals(ProxyConfig.MATCH_HTTP) && !protocol.equals(ProxyConfig.MATCH_HTTPS)) {
                                            zzm.zzj("Unsupported scheme: " + protocol);
                                            webResourceResponse = zzV();
                                            break;
                                        }
                                        zzm.zze("Redirecting to " + headerField);
                                        httpURLConnection.disconnect();
                                        url = url2;
                                    } else {
                                        zzm.zzj("Protocol is null");
                                        webResourceResponse = zzV();
                                        break;
                                    }
                                } else {
                                    break;
                                }
                            } else {
                                throw new IOException("Missing Location header in redirect");
                            }
                        }
                    } else {
                        throw new IOException("Invalid protocol.");
                    }
                } else {
                    TrafficStats.clearThreadStatsTag();
                    throw new IOException("Too many redirects (20)");
                }
            }
            zzv.zzq();
            zzv.zzq();
            String contentType2 = httpURLConnection.getContentType();
            String str3 = "";
            if (TextUtils.isEmpty(contentType2)) {
                str2 = str3;
            } else {
                str2 = contentType2.split(";")[0].trim();
            }
            zzv.zzq();
            String contentType3 = httpURLConnection.getContentType();
            if (!TextUtils.isEmpty(contentType3)) {
                String[] split = contentType3.split(";");
                if (split.length != 1) {
                    int i2 = 1;
                    while (true) {
                        if (i2 >= split.length) {
                            break;
                        }
                        if (split[i2].trim().startsWith("charset")) {
                            String[] split2 = split[i2].trim().split("=");
                            if (split2.length > 1) {
                                str3 = split2[1].trim();
                                break;
                            }
                        }
                        i2++;
                    }
                }
            }
            String str4 = str3;
            Map headerFields = httpURLConnection.getHeaderFields();
            HashMap hashMap = new HashMap(headerFields.size());
            for (Map.Entry entry2 : headerFields.entrySet()) {
                if (!(entry2.getKey() == null || entry2.getValue() == null || ((List) entry2.getValue()).isEmpty())) {
                    hashMap.put((String) entry2.getKey(), (String) ((List) entry2.getValue()).get(0));
                }
            }
            webResourceResponse = zzv.zzr().zzb(str2, str4, httpURLConnection.getResponseCode(), httpURLConnection.getResponseMessage(), hashMap, httpURLConnection.getInputStream());
            return webResourceResponse;
        } finally {
            TrafficStats.clearThreadStatsTag();
        }
    }

    /* access modifiers changed from: private */
    public final void zzX(Map map, List list, String str) {
        if (zze.zzc()) {
            zze.zza("Received GMSG: ".concat(str));
            for (String str2 : map.keySet()) {
                zze.zza("  " + str2 + ": " + ((String) map.get(str2)));
            }
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((zzbjr) it.next()).zza(this.zzc, map);
        }
    }

    private final void zzY() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.zzG;
        if (onAttachStateChangeListener != null) {
            ((View) this.zzc).removeOnAttachStateChangeListener(onAttachStateChangeListener);
        }
    }

    /* access modifiers changed from: private */
    public final void zzZ(View view, zzbyh zzbyh, int i) {
        if (zzbyh.zzi() && i > 0) {
            zzbyh.zzg(view);
            if (zzbyh.zzi()) {
                zzs.zza.postDelayed(new zzcfl(this, view, zzbyh, i), 100);
            }
        }
    }

    private static final boolean zzaa(zzcfk zzcfk) {
        if (zzcfk.zzD() != null) {
            return zzcfk.zzD().zzai;
        }
        return false;
    }

    private static final boolean zzab(boolean z, zzcfk zzcfk) {
        return z && !zzcfk.zzO().zzi() && !zzcfk.zzU().equals("interstitial_mb");
    }

    public final void onAdClicked() {
        zza zza2 = this.zzg;
        if (zza2 != null) {
            zza2.onAdClicked();
        }
    }

    public final void onLoadResource(WebView webView, String str) {
        zze.zza("Loading resource: ".concat(String.valueOf(str)));
        Uri parse = Uri.parse(str);
        if ("gmsg".equalsIgnoreCase(parse.getScheme()) && "mobileads.google.com".equalsIgnoreCase(parse.getHost())) {
            zzj(parse);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001d, code lost:
        if (r2 == null) goto L_0x0025;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001f, code lost:
        r2.zza();
        r1.zzj = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0025, code lost:
        zzg();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002e, code lost:
        if (r1.zzc.zzL() == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0040, code lost:
        if (((java.lang.Boolean) com.google.android.gms.ads.internal.client.zzbe.zzc().zza(com.google.android.gms.internal.ads.zzbcn.zzlD)).booleanValue() == false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0042, code lost:
        r1.zzc.zzL().zzG(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0018, code lost:
        r1.zzA = true;
        r2 = r1.zzj;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onPageFinished(android.webkit.WebView r2, java.lang.String r3) {
        /*
            r1 = this;
            java.lang.Object r2 = r1.zzf
            monitor-enter(r2)
            com.google.android.gms.internal.ads.zzcfk r0 = r1.zzc     // Catch:{ all -> 0x004c }
            boolean r0 = r0.zzaE()     // Catch:{ all -> 0x004c }
            if (r0 == 0) goto L_0x0017
            java.lang.String r3 = "Blank page loaded, 1..."
            com.google.android.gms.ads.internal.util.zze.zza(r3)     // Catch:{ all -> 0x004c }
            com.google.android.gms.internal.ads.zzcfk r3 = r1.zzc     // Catch:{ all -> 0x004c }
            r3.zzX()     // Catch:{ all -> 0x004c }
            monitor-exit(r2)     // Catch:{ all -> 0x004c }
            return
        L_0x0017:
            monitor-exit(r2)     // Catch:{ all -> 0x004c }
            r2 = 1
            r1.zzA = r2
            com.google.android.gms.internal.ads.zzchb r2 = r1.zzj
            if (r2 == 0) goto L_0x0025
            r2.zza()
            r2 = 0
            r1.zzj = r2
        L_0x0025:
            r1.zzg()
            com.google.android.gms.internal.ads.zzcfk r2 = r1.zzc
            com.google.android.gms.ads.internal.overlay.zzm r2 = r2.zzL()
            if (r2 == 0) goto L_0x004b
            com.google.android.gms.internal.ads.zzbce r2 = com.google.android.gms.internal.ads.zzbcn.zzlD
            com.google.android.gms.internal.ads.zzbcl r0 = com.google.android.gms.ads.internal.client.zzbe.zzc()
            java.lang.Object r2 = r0.zza(r2)
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            if (r2 == 0) goto L_0x004b
            com.google.android.gms.internal.ads.zzcfk r2 = r1.zzc
            com.google.android.gms.ads.internal.overlay.zzm r2 = r2.zzL()
            r2.zzG(r3)
        L_0x004b:
            return
        L_0x004c:
            r3 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x004c }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcfs.onPageFinished(android.webkit.WebView, java.lang.String):void");
    }

    public final void onReceivedError(WebView webView, int i, String str, String str2) {
        this.zzo = true;
        this.zzp = i;
        this.zzq = str;
        this.zzr = str2;
    }

    public final boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        return this.zzc.zzaD(renderProcessGoneDetail.didCrash(), renderProcessGoneDetail.rendererPriorityAtExit());
    }

    public final WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        return zzc(str, Collections.emptyMap());
    }

    public final boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        if (keyCode == 79 || keyCode == 222) {
            return true;
        }
        switch (keyCode) {
            case 85:
            case 86:
            case 87:
            case 88:
            case 89:
            case 90:
            case 91:
                return true;
            default:
                switch (keyCode) {
                    case WebSocketProtocol.PAYLOAD_SHORT /*126*/:
                    case 127:
                    case 128:
                    case 129:
                    case 130:
                        return true;
                    default:
                        return false;
                }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x00e8  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00ec  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean shouldOverrideUrlLoading(android.webkit.WebView r13, java.lang.String r14) {
        /*
            r12 = this;
            java.lang.String r0 = "AdWebView shouldOverrideUrlLoading: "
            java.lang.String r1 = java.lang.String.valueOf(r14)
            java.lang.String r0 = r0.concat(r1)
            com.google.android.gms.ads.internal.util.zze.zza(r0)
            android.net.Uri r0 = android.net.Uri.parse(r14)
            java.lang.String r1 = r0.getScheme()
            java.lang.String r2 = "gmsg"
            boolean r1 = r2.equalsIgnoreCase(r1)
            r2 = 1
            if (r1 == 0) goto L_0x002f
            java.lang.String r1 = r0.getHost()
            java.lang.String r3 = "mobileads.google.com"
            boolean r1 = r3.equalsIgnoreCase(r1)
            if (r1 == 0) goto L_0x002f
            r12.zzj(r0)
            goto L_0x010f
        L_0x002f:
            boolean r1 = r12.zzn
            if (r1 == 0) goto L_0x006e
            com.google.android.gms.internal.ads.zzcfk r1 = r12.zzc
            android.webkit.WebView r1 = r1.zzG()
            if (r13 != r1) goto L_0x006e
            java.lang.String r1 = r0.getScheme()
            java.lang.String r3 = "http"
            boolean r3 = r3.equalsIgnoreCase(r1)
            if (r3 != 0) goto L_0x004f
            java.lang.String r3 = "https"
            boolean r1 = r3.equalsIgnoreCase(r1)
            if (r1 == 0) goto L_0x006e
        L_0x004f:
            com.google.android.gms.ads.internal.client.zza r0 = r12.zzg
            r1 = 0
            if (r0 == 0) goto L_0x0060
            r0.onAdClicked()
            com.google.android.gms.internal.ads.zzbyh r0 = r12.zza
            if (r0 == 0) goto L_0x005e
            r0.zzh(r14)
        L_0x005e:
            r12.zzg = r1
        L_0x0060:
            com.google.android.gms.internal.ads.zzdel r0 = r12.zzm
            if (r0 == 0) goto L_0x0069
            r0.zzdG()
            r12.zzm = r1
        L_0x0069:
            boolean r13 = super.shouldOverrideUrlLoading(r13, r14)
            return r13
        L_0x006e:
            com.google.android.gms.internal.ads.zzcfk r13 = r12.zzc
            android.webkit.WebView r13 = r13.zzG()
            boolean r13 = r13.willNotDraw()
            if (r13 != 0) goto L_0x0102
            com.google.android.gms.internal.ads.zzcfk r13 = r12.zzc     // Catch:{ zzavd -> 0x00d0 }
            com.google.android.gms.internal.ads.zzavc r13 = r13.zzI()     // Catch:{ zzavd -> 0x00d0 }
            com.google.android.gms.internal.ads.zzcfk r1 = r12.zzc     // Catch:{ zzavd -> 0x00d0 }
            com.google.android.gms.internal.ads.zzffs r1 = r1.zzS()     // Catch:{ zzavd -> 0x00d0 }
            com.google.android.gms.internal.ads.zzbce r3 = com.google.android.gms.internal.ads.zzbcn.zzlI     // Catch:{ zzavd -> 0x00d0 }
            com.google.android.gms.internal.ads.zzbcl r4 = com.google.android.gms.ads.internal.client.zzbe.zzc()     // Catch:{ zzavd -> 0x00d0 }
            java.lang.Object r3 = r4.zza(r3)     // Catch:{ zzavd -> 0x00d0 }
            java.lang.Boolean r3 = (java.lang.Boolean) r3     // Catch:{ zzavd -> 0x00d0 }
            boolean r3 = r3.booleanValue()     // Catch:{ zzavd -> 0x00d0 }
            if (r3 == 0) goto L_0x00b5
            if (r1 == 0) goto L_0x00b5
            if (r13 == 0) goto L_0x00dd
            boolean r13 = r13.zzf(r0)     // Catch:{ zzavd -> 0x00d0 }
            if (r13 == 0) goto L_0x00dd
            com.google.android.gms.internal.ads.zzcfk r13 = r12.zzc     // Catch:{ zzavd -> 0x00d0 }
            android.content.Context r13 = r13.getContext()     // Catch:{ zzavd -> 0x00d0 }
            com.google.android.gms.internal.ads.zzcfk r3 = r12.zzc     // Catch:{ zzavd -> 0x00d0 }
            android.app.Activity r4 = r3.zzi()     // Catch:{ zzavd -> 0x00d0 }
            android.view.View r3 = (android.view.View) r3     // Catch:{ zzavd -> 0x00d0 }
            android.net.Uri r0 = r1.zza(r0, r13, r3, r4)     // Catch:{ zzavd -> 0x00d0 }
            goto L_0x00dd
        L_0x00b5:
            if (r13 == 0) goto L_0x00dd
            boolean r1 = r13.zzf(r0)     // Catch:{ zzavd -> 0x00d0 }
            if (r1 == 0) goto L_0x00dd
            com.google.android.gms.internal.ads.zzcfk r1 = r12.zzc     // Catch:{ zzavd -> 0x00d0 }
            android.content.Context r1 = r1.getContext()     // Catch:{ zzavd -> 0x00d0 }
            com.google.android.gms.internal.ads.zzcfk r3 = r12.zzc     // Catch:{ zzavd -> 0x00d0 }
            android.app.Activity r4 = r3.zzi()     // Catch:{ zzavd -> 0x00d0 }
            android.view.View r3 = (android.view.View) r3     // Catch:{ zzavd -> 0x00d0 }
            android.net.Uri r0 = r13.zza(r0, r1, r3, r4)     // Catch:{ zzavd -> 0x00d0 }
            goto L_0x00dd
        L_0x00d0:
            java.lang.String r13 = java.lang.String.valueOf(r14)
            java.lang.String r1 = "Unable to append parameter to URL: "
            java.lang.String r13 = r1.concat(r13)
            com.google.android.gms.ads.internal.util.client.zzm.zzj(r13)
        L_0x00dd:
            com.google.android.gms.ads.internal.zzb r13 = r12.zzy
            if (r13 == 0) goto L_0x00ec
            boolean r1 = r13.zzc()
            if (r1 == 0) goto L_0x00e8
            goto L_0x00ec
        L_0x00e8:
            r13.zzb(r14)
            goto L_0x010f
        L_0x00ec:
            com.google.android.gms.ads.internal.overlay.zzc r3 = new com.google.android.gms.ads.internal.overlay.zzc
            java.lang.String r5 = r0.toString()
            r10 = 0
            r11 = 0
            java.lang.String r4 = "android.intent.action.VIEW"
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11)
            r13 = 0
            r12.zzu(r3, r2, r13)
            goto L_0x010f
        L_0x0102:
            java.lang.String r13 = java.lang.String.valueOf(r14)
            java.lang.String r14 = "AdWebView unable to handle URL: "
            java.lang.String r13 = r14.concat(r13)
            com.google.android.gms.ads.internal.util.client.zzm.zzj(r13)
        L_0x010f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcfs.shouldOverrideUrlLoading(android.webkit.WebView, java.lang.String):boolean");
    }

    public final void zzA(String str, zzbjr zzbjr) {
        synchronized (this.zzf) {
            List list = (List) this.zze.get(str);
            if (list == null) {
                list = new CopyOnWriteArrayList();
                this.zze.put(str, list);
            }
            list.add(zzbjr);
        }
    }

    public final void zzB(zzcha zzcha) {
        this.zzi = zzcha;
    }

    public final void zzC(int i, int i2) {
        zzbse zzbse = this.zzz;
        if (zzbse != null) {
            zzbse.zze(i, i2);
        }
    }

    public final void zzD(boolean z) {
        this.zzn = false;
    }

    public final void zzE(boolean z) {
        synchronized (this.zzf) {
            this.zzu = true;
        }
    }

    public final void zzF(boolean z) {
        synchronized (this.zzf) {
            this.zzv = z;
        }
    }

    public final void zzG() {
        synchronized (this.zzf) {
            this.zzn = false;
            this.zzs = true;
            zzcaj.zze.execute(new zzcfm(this));
        }
    }

    public final void zzH(boolean z) {
        synchronized (this.zzf) {
            this.zzt = true;
        }
    }

    public final void zzI(zzchb zzchb) {
        this.zzj = zzchb;
    }

    public final void zzJ(zzcnb zzcnb, zzedp zzedp, zzflr zzflr) {
        zzN("/click");
        if (zzedp == null || zzflr == null) {
            zzA("/click", new zzbip(this.zzm, zzcnb));
        } else {
            zzA("/click", new zzffw(this.zzm, zzcnb, zzflr, zzedp));
        }
    }

    public final void zzK(zzcnb zzcnb) {
        zzN("/click");
        zzA("/click", new zzbip(this.zzm, zzcnb));
    }

    public final void zzL(zzcnb zzcnb, zzedp zzedp, zzdsm zzdsm) {
        zzN("/open");
        zzA("/open", new zzbkd(this.zzy, this.zzz, zzedp, zzdsm, zzcnb));
    }

    public final void zzM(zzfet zzfet) {
        if (zzv.zzo().zzp(this.zzc.getContext())) {
            zzN("/logScionEvent");
            new HashMap();
            zzA("/logScionEvent", new zzbjx(this.zzc.getContext(), zzfet.zzaw));
        }
    }

    public final void zzN(String str) {
        synchronized (this.zzf) {
            List list = (List) this.zze.get(str);
            if (list != null) {
                list.clear();
            }
        }
    }

    public final void zzO(String str, zzbjr zzbjr) {
        synchronized (this.zzf) {
            List list = (List) this.zze.get(str);
            if (list != null) {
                list.remove(zzbjr);
            }
        }
    }

    public final void zzP(String str, Predicate predicate) {
        synchronized (this.zzf) {
            List<zzbjr> list = (List) this.zze.get(str);
            if (list != null) {
                ArrayList arrayList = new ArrayList();
                for (zzbjr zzbjr : list) {
                    if (predicate.apply(zzbjr)) {
                        arrayList.add(zzbjr);
                    }
                }
                list.removeAll(arrayList);
            }
        }
    }

    public final boolean zzQ() {
        boolean z;
        synchronized (this.zzf) {
            z = this.zzu;
        }
        return z;
    }

    public final boolean zzR() {
        boolean z;
        synchronized (this.zzf) {
            z = this.zzv;
        }
        return z;
    }

    public final boolean zzS() {
        boolean z;
        synchronized (this.zzf) {
            z = this.zzs;
        }
        return z;
    }

    public final boolean zzT() {
        boolean z;
        synchronized (this.zzf) {
            z = this.zzt;
        }
        return z;
    }

    public final void zzU(zza zza2, zzbih zzbih, zzr zzr2, zzbij zzbij, zzac zzac, boolean z, zzbju zzbju, zzb zzb2, zzbsl zzbsl, zzbyh zzbyh, zzedp zzedp, zzflr zzflr, zzdsm zzdsm, zzbkl zzbkl, zzdel zzdel, zzbkk zzbkk, zzbke zzbke, zzbjs zzbjs, zzcnb zzcnb) {
        zzbih zzbih2 = zzbih;
        zzbij zzbij2 = zzbij;
        zzbju zzbju2 = zzbju;
        zzbsl zzbsl2 = zzbsl;
        zzbyh zzbyh2 = zzbyh;
        zzflr zzflr2 = zzflr;
        zzbkl zzbkl2 = zzbkl;
        zzdel zzdel2 = zzdel;
        zzbkk zzbkk2 = zzbkk;
        zzbke zzbke2 = zzbke;
        zzbjs zzbjs2 = zzbjs;
        zzb zzb3 = zzb2 == null ? new zzb(this.zzc.getContext(), zzbyh2, (zzbux) null) : zzb2;
        this.zzz = new zzbse(this.zzc, zzbsl2);
        this.zza = zzbyh2;
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzaY)).booleanValue()) {
            zzA("/adMetadata", new zzbig(zzbih2));
        }
        if (zzbij2 != null) {
            zzA("/appEvent", new zzbii(zzbij2));
        }
        zzA("/backButton", zzbjq.zzj);
        zzA("/refresh", zzbjq.zzk);
        zzA("/canOpenApp", zzbjq.zzb);
        zzA("/canOpenURLs", zzbjq.zza);
        zzA("/canOpenIntents", zzbjq.zzc);
        zzA("/close", zzbjq.zzd);
        zzA("/customClose", zzbjq.zze);
        zzA("/instrument", zzbjq.zzn);
        zzA("/delayPageLoaded", zzbjq.zzp);
        zzA("/delayPageClosed", zzbjq.zzq);
        zzA("/getLocationInfo", zzbjq.zzr);
        zzA("/log", zzbjq.zzg);
        zzA("/mraid", new zzbjy(zzb3, this.zzz, zzbsl2));
        zzbsj zzbsj = this.zzx;
        if (zzbsj != null) {
            zzA("/mraidLoaded", zzbsj);
        }
        zzcnb zzcnb2 = zzcnb;
        zzb zzb4 = zzb3;
        zzedp zzedp2 = zzedp;
        zzA("/open", new zzbkd(zzb4, this.zzz, zzedp2, zzdsm, zzcnb2));
        zzA("/precache", new zzcds());
        zzA("/touch", zzbjq.zzi);
        zzA("/video", zzbjq.zzl);
        zzA("/videoMeta", zzbjq.zzm);
        if (zzedp2 == null || zzflr2 == null) {
            zzA("/click", new zzbip(zzdel2, zzcnb2));
            zzA("/httpTrack", zzbjq.zzf);
        } else {
            zzA("/click", new zzffw(zzdel2, zzcnb2, zzflr2, zzedp2));
            zzA("/httpTrack", new zzffx(zzflr2, zzedp2));
        }
        if (zzv.zzo().zzp(this.zzc.getContext())) {
            Map hashMap = new HashMap();
            if (this.zzc.zzD() != null) {
                hashMap = this.zzc.zzD().zzaw;
            }
            zzA("/logScionEvent", new zzbjx(this.zzc.getContext(), hashMap));
        }
        if (zzbju2 != null) {
            zzA("/setInterstitialProperties", new zzbjt(zzbju2));
        }
        if (zzbkl2 != null) {
            if (((Boolean) zzbe.zzc().zza(zzbcn.zziz)).booleanValue()) {
                zzA("/inspectorNetworkExtras", zzbkl2);
            }
        }
        if (((Boolean) zzbe.zzc().zza(zzbcn.zziS)).booleanValue() && zzbkk2 != null) {
            zzA("/shareSheet", zzbkk2);
        }
        if (((Boolean) zzbe.zzc().zza(zzbcn.zziX)).booleanValue() && zzbke2 != null) {
            zzA("/inspectorOutOfContextTest", zzbke2);
        }
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzjb)).booleanValue() && zzbjs2 != null) {
            zzA("/inspectorStorage", zzbjs2);
        }
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzlg)).booleanValue()) {
            zzA("/bindPlayStoreOverlay", zzbjq.zzu);
            zzA("/presentPlayStoreOverlay", zzbjq.zzv);
            zzA("/expandPlayStoreOverlay", zzbjq.zzw);
            zzA("/collapsePlayStoreOverlay", zzbjq.zzx);
            zzA("/closePlayStoreOverlay", zzbjq.zzy);
        }
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzdq)).booleanValue()) {
            zzA("/setPAIDPersonalizationEnabled", zzbjq.zzA);
            zzA("/resetPAID", zzbjq.zzz);
        }
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzlC)).booleanValue()) {
            zzcfk zzcfk = this.zzc;
            if (zzcfk.zzD() != null && zzcfk.zzD().zzar) {
                zzA("/writeToLocalStorage", zzbjq.zzB);
                zzA("/clearLocalStorageKeys", zzbjq.zzC);
            }
        }
        this.zzg = zza2;
        this.zzh = zzr2;
        this.zzk = zzbih2;
        this.zzl = zzbij2;
        this.zzw = zzac;
        this.zzy = zzb4;
        this.zzm = zzdel2;
        this.zzn = z;
    }

    public final ViewTreeObserver.OnGlobalLayoutListener zza() {
        synchronized (this.zzf) {
        }
        return null;
    }

    public final ViewTreeObserver.OnScrollChangedListener zzb() {
        synchronized (this.zzf) {
        }
        return null;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0143, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0145, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0172, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0174, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0178, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0179, code lost:
        r11 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x01a8, code lost:
        com.google.android.gms.ads.internal.zzv.zzp().zzw(r0, "AdWebViewClient.interceptRequest.gcache");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x01fa, code lost:
        com.google.android.gms.ads.internal.zzv.zzp().zzw(r0, "AdWebViewClient.interceptRequest.gcache");
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x02c8 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00b4 A[SYNTHETIC, Splitter:B:23:0x00b4] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0178 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:31:0x0108] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x01a8 A[Catch:{ all -> 0x01de }] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x01fa A[Catch:{ all -> 0x01de }] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0251 A[Catch:{ Exception | NoClassDefFoundError -> 0x02c9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x029f A[Catch:{ Exception | NoClassDefFoundError -> 0x02c9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x02c3 A[Catch:{ Exception | NoClassDefFoundError -> 0x02c9 }] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:62:0x0196=Splitter:B:62:0x0196, B:72:0x01e8=Splitter:B:72:0x01e8} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.webkit.WebResourceResponse zzc(java.lang.String r21, java.util.Map r22) {
        /*
            r20 = this;
            r1 = r20
            r2 = r21
            java.lang.String r3 = "AdWebViewClient.interceptRequest.gcache"
            java.lang.String r0 = "range"
            java.lang.String r4 = "ms"
            java.lang.String r5 = "Cache connection took "
            java.util.HashMap r6 = new java.util.HashMap     // Catch:{ Exception -> 0x02cb, NoClassDefFoundError -> 0x02c9 }
            r6.<init>()     // Catch:{ Exception -> 0x02cb, NoClassDefFoundError -> 0x02c9 }
            com.google.android.gms.internal.ads.zzcfk r7 = r1.zzc     // Catch:{ Exception -> 0x02cb, NoClassDefFoundError -> 0x02c9 }
            com.google.android.gms.internal.ads.zzfet r7 = r7.zzD()     // Catch:{ Exception -> 0x02cb, NoClassDefFoundError -> 0x02c9 }
            if (r7 == 0) goto L_0x0021
            com.google.android.gms.internal.ads.zzcfk r6 = r1.zzc     // Catch:{ Exception -> 0x02cb, NoClassDefFoundError -> 0x02c9 }
            com.google.android.gms.internal.ads.zzfet r6 = r6.zzD()     // Catch:{ Exception -> 0x02cb, NoClassDefFoundError -> 0x02c9 }
            java.util.Map r6 = r6.zzaw     // Catch:{ Exception -> 0x02cb, NoClassDefFoundError -> 0x02c9 }
        L_0x0021:
            com.google.android.gms.internal.ads.zzcfk r7 = r1.zzc     // Catch:{ Exception -> 0x02cb, NoClassDefFoundError -> 0x02c9 }
            android.content.Context r7 = r7.getContext()     // Catch:{ Exception -> 0x02cb, NoClassDefFoundError -> 0x02c9 }
            boolean r8 = r1.zzD     // Catch:{ Exception -> 0x02cb, NoClassDefFoundError -> 0x02c9 }
            java.lang.String r6 = com.google.android.gms.internal.ads.zzbyx.zzc(r2, r7, r8, r6)     // Catch:{ Exception -> 0x02cb, NoClassDefFoundError -> 0x02c9 }
            boolean r7 = r6.equals(r2)     // Catch:{ Exception -> 0x02cb, NoClassDefFoundError -> 0x02c9 }
            if (r7 != 0) goto L_0x003a
            r7 = r22
            android.webkit.WebResourceResponse r0 = r1.zzW(r6, r7)     // Catch:{ Exception -> 0x02cb, NoClassDefFoundError -> 0x02c9 }
            return r0
        L_0x003a:
            r7 = r22
            android.net.Uri r6 = android.net.Uri.parse(r2)     // Catch:{ Exception -> 0x02cb, NoClassDefFoundError -> 0x02c9 }
            com.google.android.gms.internal.ads.zzbax r6 = com.google.android.gms.internal.ads.zzbax.zza(r6)     // Catch:{ Exception -> 0x02cb, NoClassDefFoundError -> 0x02c9 }
            if (r6 == 0) goto L_0x02ad
            java.util.HashMap r14 = new java.util.HashMap     // Catch:{ Exception -> 0x02cb, NoClassDefFoundError -> 0x02c9 }
            r14.<init>()     // Catch:{ Exception -> 0x02cb, NoClassDefFoundError -> 0x02c9 }
            java.lang.String r9 = "Access-Control-Allow-Origin"
            java.lang.String r10 = "*"
            r14.put(r9, r10)     // Catch:{ Exception -> 0x02cb, NoClassDefFoundError -> 0x02c9 }
            android.net.Uri r9 = android.net.Uri.parse(r2)     // Catch:{ Exception -> 0x02cb, NoClassDefFoundError -> 0x02c9 }
            java.util.Set r10 = r9.getQueryParameterNames()     // Catch:{ Exception -> 0x02cb, NoClassDefFoundError -> 0x02c9 }
            boolean r10 = r10.contains(r0)     // Catch:{ Exception -> 0x02cb, NoClassDefFoundError -> 0x02c9 }
            r11 = 0
            r13 = 1
            if (r10 == 0) goto L_0x0097
            r10 = 45
            com.google.android.gms.internal.ads.zzfwf r10 = com.google.android.gms.internal.ads.zzfwf.zzc(r10)     // Catch:{ Exception -> 0x02cb, NoClassDefFoundError -> 0x02c9 }
            com.google.android.gms.internal.ads.zzfxd r10 = com.google.android.gms.internal.ads.zzfxd.zzb(r10)     // Catch:{ Exception -> 0x02cb, NoClassDefFoundError -> 0x02c9 }
            java.lang.String r0 = r9.getQueryParameter(r0)     // Catch:{ Exception -> 0x02cb, NoClassDefFoundError -> 0x02c9 }
            java.util.List r0 = r10.zze(r0)     // Catch:{ Exception -> 0x02cb, NoClassDefFoundError -> 0x02c9 }
            int r9 = r0.size()     // Catch:{ Exception -> 0x02cb, NoClassDefFoundError -> 0x02c9 }
            r10 = 2
            if (r9 != r10) goto L_0x0097
            java.lang.Object r9 = r0.get(r11)     // Catch:{ Exception -> 0x02cb, NoClassDefFoundError -> 0x02c9 }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ Exception -> 0x02cb, NoClassDefFoundError -> 0x02c9 }
            int r9 = java.lang.Integer.parseInt(r9)     // Catch:{ Exception -> 0x02cb, NoClassDefFoundError -> 0x02c9 }
            java.lang.Object r0 = r0.get(r13)     // Catch:{ Exception -> 0x02cb, NoClassDefFoundError -> 0x02c9 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ Exception -> 0x02cb, NoClassDefFoundError -> 0x02c9 }
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ Exception -> 0x02cb, NoClassDefFoundError -> 0x02c9 }
            int r0 = r0 + r13
            if (r9 <= 0) goto L_0x0095
            long r11 = (long) r9     // Catch:{ Exception -> 0x02cb, NoClassDefFoundError -> 0x02c9 }
            r6.zzh = r11     // Catch:{ Exception -> 0x02cb, NoClassDefFoundError -> 0x02c9 }
        L_0x0095:
            int r0 = r0 - r9
            goto L_0x0098
        L_0x0097:
            r0 = -1
        L_0x0098:
            com.google.android.gms.internal.ads.zzbce r9 = com.google.android.gms.internal.ads.zzbcn.zzep     // Catch:{ Exception -> 0x02cb, NoClassDefFoundError -> 0x02c9 }
            com.google.android.gms.internal.ads.zzbcl r11 = com.google.android.gms.ads.internal.client.zzbe.zzc()     // Catch:{ Exception -> 0x02cb, NoClassDefFoundError -> 0x02c9 }
            java.lang.Object r9 = r11.zza(r9)     // Catch:{ Exception -> 0x02cb, NoClassDefFoundError -> 0x02c9 }
            java.lang.Boolean r9 = (java.lang.Boolean) r9     // Catch:{ Exception -> 0x02cb, NoClassDefFoundError -> 0x02c9 }
            boolean r9 = r9.booleanValue()     // Catch:{ Exception -> 0x02cb, NoClassDefFoundError -> 0x02c9 }
            java.lang.String r11 = "X-Afma-Gcache-CachedBytes"
            java.lang.String r12 = "X-Afma-Gcache-IsDownloaded"
            r16 = 0
            java.lang.String r8 = "X-Afma-Gcache-IsGcacheHit"
            java.lang.String r10 = "X-Afma-Gcache-HasAdditionalMetadataFromReadV2"
            if (r9 == 0) goto L_0x0251
            com.google.android.gms.internal.ads.zzcfk r9 = r1.zzc     // Catch:{ Exception -> 0x02cb, NoClassDefFoundError -> 0x02c9 }
            java.lang.String r9 = r9.zzr()     // Catch:{ Exception -> 0x02cb, NoClassDefFoundError -> 0x02c9 }
            java.lang.String r9 = com.google.android.gms.internal.ads.zzfxf.zzc(r9)     // Catch:{ Exception -> 0x02cb, NoClassDefFoundError -> 0x02c9 }
            r6.zzi = r9     // Catch:{ Exception -> 0x02cb, NoClassDefFoundError -> 0x02c9 }
            com.google.android.gms.internal.ads.zzcfk r9 = r1.zzc     // Catch:{ Exception -> 0x02cb, NoClassDefFoundError -> 0x02c9 }
            int r9 = r9.zzf()     // Catch:{ Exception -> 0x02cb, NoClassDefFoundError -> 0x02c9 }
            r6.zzj = r9     // Catch:{ Exception -> 0x02cb, NoClassDefFoundError -> 0x02c9 }
            boolean r9 = r6.zzg     // Catch:{ Exception -> 0x02cb, NoClassDefFoundError -> 0x02c9 }
            if (r9 == 0) goto L_0x00d9
            com.google.android.gms.internal.ads.zzbce r9 = com.google.android.gms.internal.ads.zzbcn.zzer     // Catch:{ Exception -> 0x02cb, NoClassDefFoundError -> 0x02c9 }
            com.google.android.gms.internal.ads.zzbcl r15 = com.google.android.gms.ads.internal.client.zzbe.zzc()     // Catch:{ Exception -> 0x02cb, NoClassDefFoundError -> 0x02c9 }
            java.lang.Object r9 = r15.zza(r9)     // Catch:{ Exception -> 0x02cb, NoClassDefFoundError -> 0x02c9 }
            java.lang.Long r9 = (java.lang.Long) r9     // Catch:{ Exception -> 0x02cb, NoClassDefFoundError -> 0x02c9 }
            goto L_0x00e5
        L_0x00d9:
            com.google.android.gms.internal.ads.zzbce r9 = com.google.android.gms.internal.ads.zzbcn.zzeq     // Catch:{ Exception -> 0x02cb, NoClassDefFoundError -> 0x02c9 }
            com.google.android.gms.internal.ads.zzbcl r15 = com.google.android.gms.ads.internal.client.zzbe.zzc()     // Catch:{ Exception -> 0x02cb, NoClassDefFoundError -> 0x02c9 }
            java.lang.Object r9 = r15.zza(r9)     // Catch:{ Exception -> 0x02cb, NoClassDefFoundError -> 0x02c9 }
            java.lang.Long r9 = (java.lang.Long) r9     // Catch:{ Exception -> 0x02cb, NoClassDefFoundError -> 0x02c9 }
        L_0x00e5:
            r17 = r14
            long r13 = r9.longValue()     // Catch:{ Exception -> 0x02cb, NoClassDefFoundError -> 0x02c9 }
            com.google.android.gms.common.util.Clock r9 = com.google.android.gms.ads.internal.zzv.zzC()     // Catch:{ Exception -> 0x02cb, NoClassDefFoundError -> 0x02c9 }
            long r18 = r9.elapsedRealtime()     // Catch:{ Exception -> 0x02cb, NoClassDefFoundError -> 0x02c9 }
            com.google.android.gms.ads.internal.zzv.zzd()     // Catch:{ Exception -> 0x02cb, NoClassDefFoundError -> 0x02c9 }
            com.google.android.gms.internal.ads.zzcfk r9 = r1.zzc     // Catch:{ Exception -> 0x02cb, NoClassDefFoundError -> 0x02c9 }
            android.content.Context r9 = r9.getContext()     // Catch:{ Exception -> 0x02cb, NoClassDefFoundError -> 0x02c9 }
            java.util.concurrent.Future r6 = com.google.android.gms.internal.ads.zzbbi.zza(r9, r6)     // Catch:{ Exception -> 0x02cb, NoClassDefFoundError -> 0x02c9 }
            java.util.concurrent.TimeUnit r9 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ ExecutionException -> 0x01e2, TimeoutException -> 0x01e0, InterruptedException -> 0x0190, all -> 0x018c }
            java.lang.Object r9 = r6.get(r13, r9)     // Catch:{ ExecutionException -> 0x01e2, TimeoutException -> 0x01e0, InterruptedException -> 0x0190, all -> 0x018c }
            com.google.android.gms.internal.ads.zzbbj r9 = (com.google.android.gms.internal.ads.zzbbj) r9     // Catch:{ ExecutionException -> 0x01e2, TimeoutException -> 0x01e0, InterruptedException -> 0x0190, all -> 0x018c }
            boolean r13 = r9.zzd()     // Catch:{ ExecutionException -> 0x0185, TimeoutException -> 0x0183, InterruptedException -> 0x017c, all -> 0x0178 }
            java.lang.String r13 = java.lang.Boolean.toString(r13)     // Catch:{ ExecutionException -> 0x0185, TimeoutException -> 0x0183, InterruptedException -> 0x017c, all -> 0x0178 }
            r14 = r17
            r14.put(r10, r13)     // Catch:{ ExecutionException -> 0x0176, TimeoutException -> 0x0174, InterruptedException -> 0x0172, all -> 0x0178 }
            boolean r10 = r9.zzf()     // Catch:{ ExecutionException -> 0x0176, TimeoutException -> 0x0174, InterruptedException -> 0x0172, all -> 0x0178 }
            java.lang.String r10 = java.lang.Boolean.toString(r10)     // Catch:{ ExecutionException -> 0x0176, TimeoutException -> 0x0174, InterruptedException -> 0x0172, all -> 0x0178 }
            r14.put(r8, r10)     // Catch:{ ExecutionException -> 0x0176, TimeoutException -> 0x0174, InterruptedException -> 0x0172, all -> 0x0178 }
            boolean r8 = r9.zze()     // Catch:{ ExecutionException -> 0x0176, TimeoutException -> 0x0174, InterruptedException -> 0x0172, all -> 0x0178 }
            java.lang.String r8 = java.lang.Boolean.toString(r8)     // Catch:{ ExecutionException -> 0x0176, TimeoutException -> 0x0174, InterruptedException -> 0x0172, all -> 0x0178 }
            r14.put(r12, r8)     // Catch:{ ExecutionException -> 0x0176, TimeoutException -> 0x0174, InterruptedException -> 0x0172, all -> 0x0178 }
            long r12 = r9.zza()     // Catch:{ ExecutionException -> 0x0176, TimeoutException -> 0x0174, InterruptedException -> 0x0172, all -> 0x0178 }
            java.lang.String r8 = java.lang.Long.toString(r12)     // Catch:{ ExecutionException -> 0x0176, TimeoutException -> 0x0174, InterruptedException -> 0x0172, all -> 0x0178 }
            r14.put(r11, r8)     // Catch:{ ExecutionException -> 0x0176, TimeoutException -> 0x0174, InterruptedException -> 0x0172, all -> 0x0178 }
            java.io.InputStream r8 = r9.zzc()     // Catch:{ ExecutionException -> 0x0176, TimeoutException -> 0x0174, InterruptedException -> 0x0172, all -> 0x0178 }
            r9 = -1
            if (r0 == r9) goto L_0x0149
            long r9 = (long) r0
            java.io.InputStream r8 = com.google.android.gms.internal.ads.zzgce.zza(r8, r9)     // Catch:{ ExecutionException -> 0x0147, TimeoutException -> 0x0145, InterruptedException -> 0x0143, all -> 0x0178 }
            goto L_0x0149
        L_0x0143:
            r0 = move-exception
            goto L_0x0181
        L_0x0145:
            r0 = move-exception
            goto L_0x018a
        L_0x0147:
            r0 = move-exception
            goto L_0x018a
        L_0x0149:
            com.google.android.gms.common.util.Clock r0 = com.google.android.gms.ads.internal.zzv.zzC()     // Catch:{ Exception -> 0x02cb, NoClassDefFoundError -> 0x02c9 }
            long r9 = r0.elapsedRealtime()     // Catch:{ Exception -> 0x02cb, NoClassDefFoundError -> 0x02c9 }
            long r9 = r9 - r18
            com.google.android.gms.internal.ads.zzftd r0 = com.google.android.gms.ads.internal.util.zzs.zza     // Catch:{ Exception -> 0x02cb, NoClassDefFoundError -> 0x02c9 }
            com.google.android.gms.internal.ads.zzcfo r3 = new com.google.android.gms.internal.ads.zzcfo     // Catch:{ Exception -> 0x02cb, NoClassDefFoundError -> 0x02c9 }
            r15 = 1
            r3.<init>(r1, r15, r9)     // Catch:{ Exception -> 0x02cb, NoClassDefFoundError -> 0x02c9 }
            r0.post(r3)     // Catch:{ Exception -> 0x02cb, NoClassDefFoundError -> 0x02c9 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02cb, NoClassDefFoundError -> 0x02c9 }
            r0.<init>(r5)     // Catch:{ Exception -> 0x02cb, NoClassDefFoundError -> 0x02c9 }
            r0.append(r9)     // Catch:{ Exception -> 0x02cb, NoClassDefFoundError -> 0x02c9 }
            r0.append(r4)     // Catch:{ Exception -> 0x02cb, NoClassDefFoundError -> 0x02c9 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x02cb, NoClassDefFoundError -> 0x02c9 }
        L_0x016d:
            com.google.android.gms.ads.internal.util.zze.zza(r0)     // Catch:{ Exception -> 0x02cb, NoClassDefFoundError -> 0x02c9 }
            goto L_0x0299
        L_0x0172:
            r0 = move-exception
            goto L_0x017f
        L_0x0174:
            r0 = move-exception
            goto L_0x0188
        L_0x0176:
            r0 = move-exception
            goto L_0x0188
        L_0x0178:
            r0 = move-exception
            r11 = 1
            goto L_0x022a
        L_0x017c:
            r0 = move-exception
            r14 = r17
        L_0x017f:
            r8 = r16
        L_0x0181:
            r11 = 1
            goto L_0x0196
        L_0x0183:
            r0 = move-exception
            goto L_0x0186
        L_0x0185:
            r0 = move-exception
        L_0x0186:
            r14 = r17
        L_0x0188:
            r8 = r16
        L_0x018a:
            r11 = 1
            goto L_0x01e8
        L_0x018c:
            r0 = move-exception
            r11 = 0
            goto L_0x022a
        L_0x0190:
            r0 = move-exception
            r14 = r17
            r8 = r16
            r11 = 0
        L_0x0196:
            com.google.android.gms.internal.ads.zzbce r9 = com.google.android.gms.internal.ads.zzbcn.zzeu     // Catch:{ all -> 0x01de }
            com.google.android.gms.internal.ads.zzbcl r10 = com.google.android.gms.ads.internal.client.zzbe.zzc()     // Catch:{ all -> 0x01de }
            java.lang.Object r9 = r10.zza(r9)     // Catch:{ all -> 0x01de }
            java.lang.Boolean r9 = (java.lang.Boolean) r9     // Catch:{ all -> 0x01de }
            boolean r9 = r9.booleanValue()     // Catch:{ all -> 0x01de }
            if (r9 == 0) goto L_0x01af
            com.google.android.gms.internal.ads.zzbzz r9 = com.google.android.gms.ads.internal.zzv.zzp()     // Catch:{ all -> 0x01de }
            r9.zzw(r0, r3)     // Catch:{ all -> 0x01de }
        L_0x01af:
            r15 = 1
            r6.cancel(r15)     // Catch:{ all -> 0x01de }
            java.lang.Thread r0 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x01de }
            r0.interrupt()     // Catch:{ all -> 0x01de }
            com.google.android.gms.common.util.Clock r0 = com.google.android.gms.ads.internal.zzv.zzC()     // Catch:{ Exception -> 0x02cb, NoClassDefFoundError -> 0x02c9 }
            long r9 = r0.elapsedRealtime()     // Catch:{ Exception -> 0x02cb, NoClassDefFoundError -> 0x02c9 }
            long r9 = r9 - r18
            com.google.android.gms.internal.ads.zzftd r0 = com.google.android.gms.ads.internal.util.zzs.zza     // Catch:{ Exception -> 0x02cb, NoClassDefFoundError -> 0x02c9 }
            com.google.android.gms.internal.ads.zzcfo r3 = new com.google.android.gms.internal.ads.zzcfo     // Catch:{ Exception -> 0x02cb, NoClassDefFoundError -> 0x02c9 }
            r3.<init>(r1, r11, r9)     // Catch:{ Exception -> 0x02cb, NoClassDefFoundError -> 0x02c9 }
            r0.post(r3)     // Catch:{ Exception -> 0x02cb, NoClassDefFoundError -> 0x02c9 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02cb, NoClassDefFoundError -> 0x02c9 }
            r0.<init>(r5)     // Catch:{ Exception -> 0x02cb, NoClassDefFoundError -> 0x02c9 }
            r0.append(r9)     // Catch:{ Exception -> 0x02cb, NoClassDefFoundError -> 0x02c9 }
            r0.append(r4)     // Catch:{ Exception -> 0x02cb, NoClassDefFoundError -> 0x02c9 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x02cb, NoClassDefFoundError -> 0x02c9 }
            goto L_0x016d
        L_0x01de:
            r0 = move-exception
            goto L_0x022a
        L_0x01e0:
            r0 = move-exception
            goto L_0x01e3
        L_0x01e2:
            r0 = move-exception
        L_0x01e3:
            r14 = r17
            r8 = r16
            r11 = 0
        L_0x01e8:
            com.google.android.gms.internal.ads.zzbce r9 = com.google.android.gms.internal.ads.zzbcn.zzeu     // Catch:{ all -> 0x01de }
            com.google.android.gms.internal.ads.zzbcl r10 = com.google.android.gms.ads.internal.client.zzbe.zzc()     // Catch:{ all -> 0x01de }
            java.lang.Object r9 = r10.zza(r9)     // Catch:{ all -> 0x01de }
            java.lang.Boolean r9 = (java.lang.Boolean) r9     // Catch:{ all -> 0x01de }
            boolean r9 = r9.booleanValue()     // Catch:{ all -> 0x01de }
            if (r9 == 0) goto L_0x0201
            com.google.android.gms.internal.ads.zzbzz r9 = com.google.android.gms.ads.internal.zzv.zzp()     // Catch:{ all -> 0x01de }
            r9.zzw(r0, r3)     // Catch:{ all -> 0x01de }
        L_0x0201:
            r15 = 1
            r6.cancel(r15)     // Catch:{ all -> 0x01de }
            com.google.android.gms.common.util.Clock r0 = com.google.android.gms.ads.internal.zzv.zzC()     // Catch:{ Exception -> 0x02cb, NoClassDefFoundError -> 0x02c9 }
            long r9 = r0.elapsedRealtime()     // Catch:{ Exception -> 0x02cb, NoClassDefFoundError -> 0x02c9 }
            long r9 = r9 - r18
            com.google.android.gms.internal.ads.zzftd r0 = com.google.android.gms.ads.internal.util.zzs.zza     // Catch:{ Exception -> 0x02cb, NoClassDefFoundError -> 0x02c9 }
            com.google.android.gms.internal.ads.zzcfo r3 = new com.google.android.gms.internal.ads.zzcfo     // Catch:{ Exception -> 0x02cb, NoClassDefFoundError -> 0x02c9 }
            r3.<init>(r1, r11, r9)     // Catch:{ Exception -> 0x02cb, NoClassDefFoundError -> 0x02c9 }
            r0.post(r3)     // Catch:{ Exception -> 0x02cb, NoClassDefFoundError -> 0x02c9 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02cb, NoClassDefFoundError -> 0x02c9 }
            r0.<init>(r5)     // Catch:{ Exception -> 0x02cb, NoClassDefFoundError -> 0x02c9 }
            r0.append(r9)     // Catch:{ Exception -> 0x02cb, NoClassDefFoundError -> 0x02c9 }
            r0.append(r4)     // Catch:{ Exception -> 0x02cb, NoClassDefFoundError -> 0x02c9 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x02cb, NoClassDefFoundError -> 0x02c9 }
            goto L_0x016d
        L_0x022a:
            com.google.android.gms.common.util.Clock r2 = com.google.android.gms.ads.internal.zzv.zzC()     // Catch:{ Exception -> 0x02cb, NoClassDefFoundError -> 0x02c9 }
            long r2 = r2.elapsedRealtime()     // Catch:{ Exception -> 0x02cb, NoClassDefFoundError -> 0x02c9 }
            long r2 = r2 - r18
            com.google.android.gms.internal.ads.zzftd r6 = com.google.android.gms.ads.internal.util.zzs.zza     // Catch:{ Exception -> 0x02cb, NoClassDefFoundError -> 0x02c9 }
            com.google.android.gms.internal.ads.zzcfo r7 = new com.google.android.gms.internal.ads.zzcfo     // Catch:{ Exception -> 0x02cb, NoClassDefFoundError -> 0x02c9 }
            r7.<init>(r1, r11, r2)     // Catch:{ Exception -> 0x02cb, NoClassDefFoundError -> 0x02c9 }
            r6.post(r7)     // Catch:{ Exception -> 0x02cb, NoClassDefFoundError -> 0x02c9 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02cb, NoClassDefFoundError -> 0x02c9 }
            r6.<init>(r5)     // Catch:{ Exception -> 0x02cb, NoClassDefFoundError -> 0x02c9 }
            r6.append(r2)     // Catch:{ Exception -> 0x02cb, NoClassDefFoundError -> 0x02c9 }
            r6.append(r4)     // Catch:{ Exception -> 0x02cb, NoClassDefFoundError -> 0x02c9 }
            java.lang.String r2 = r6.toString()     // Catch:{ Exception -> 0x02cb, NoClassDefFoundError -> 0x02c9 }
            com.google.android.gms.ads.internal.util.zze.zza(r2)     // Catch:{ Exception -> 0x02cb, NoClassDefFoundError -> 0x02c9 }
            throw r0     // Catch:{ Exception -> 0x02cb, NoClassDefFoundError -> 0x02c9 }
        L_0x0251:
            com.google.android.gms.internal.ads.zzbat r3 = com.google.android.gms.ads.internal.zzv.zzc()     // Catch:{ Exception -> 0x02cb, NoClassDefFoundError -> 0x02c9 }
            com.google.android.gms.internal.ads.zzbau r3 = r3.zzb(r6)     // Catch:{ Exception -> 0x02cb, NoClassDefFoundError -> 0x02c9 }
            if (r3 == 0) goto L_0x029b
            boolean r4 = r3.zze()     // Catch:{ Exception -> 0x02cb, NoClassDefFoundError -> 0x02c9 }
            if (r4 == 0) goto L_0x029b
            boolean r4 = r3.zzd()     // Catch:{ Exception -> 0x02cb, NoClassDefFoundError -> 0x02c9 }
            java.lang.String r4 = java.lang.Boolean.toString(r4)     // Catch:{ Exception -> 0x02cb, NoClassDefFoundError -> 0x02c9 }
            r14.put(r10, r4)     // Catch:{ Exception -> 0x02cb, NoClassDefFoundError -> 0x02c9 }
            boolean r4 = r3.zzg()     // Catch:{ Exception -> 0x02cb, NoClassDefFoundError -> 0x02c9 }
            java.lang.String r4 = java.lang.Boolean.toString(r4)     // Catch:{ Exception -> 0x02cb, NoClassDefFoundError -> 0x02c9 }
            r14.put(r8, r4)     // Catch:{ Exception -> 0x02cb, NoClassDefFoundError -> 0x02c9 }
            boolean r4 = r3.zzf()     // Catch:{ Exception -> 0x02cb, NoClassDefFoundError -> 0x02c9 }
            java.lang.String r4 = java.lang.Boolean.toString(r4)     // Catch:{ Exception -> 0x02cb, NoClassDefFoundError -> 0x02c9 }
            r14.put(r12, r4)     // Catch:{ Exception -> 0x02cb, NoClassDefFoundError -> 0x02c9 }
            long r4 = r3.zza()     // Catch:{ Exception -> 0x02cb, NoClassDefFoundError -> 0x02c9 }
            java.lang.String r4 = java.lang.Long.toString(r4)     // Catch:{ Exception -> 0x02cb, NoClassDefFoundError -> 0x02c9 }
            r14.put(r11, r4)     // Catch:{ Exception -> 0x02cb, NoClassDefFoundError -> 0x02c9 }
            java.io.InputStream r8 = r3.zzc()     // Catch:{ Exception -> 0x02cb, NoClassDefFoundError -> 0x02c9 }
            r15 = -1
            if (r0 == r15) goto L_0x0299
            long r3 = (long) r0     // Catch:{ Exception -> 0x02cb, NoClassDefFoundError -> 0x02c9 }
            java.io.InputStream r8 = com.google.android.gms.internal.ads.zzgce.zza(r8, r3)     // Catch:{ Exception -> 0x02cb, NoClassDefFoundError -> 0x02c9 }
        L_0x0299:
            r15 = r8
            goto L_0x029d
        L_0x029b:
            r15 = r16
        L_0x029d:
            if (r15 == 0) goto L_0x02af
            android.webkit.WebResourceResponse r9 = new android.webkit.WebResourceResponse     // Catch:{ Exception -> 0x02cb, NoClassDefFoundError -> 0x02c9 }
            java.lang.String r10 = ""
            java.lang.String r11 = ""
            java.lang.String r13 = "OK"
            r12 = 200(0xc8, float:2.8E-43)
            r9.<init>(r10, r11, r12, r13, r14, r15)     // Catch:{ Exception -> 0x02cb, NoClassDefFoundError -> 0x02c9 }
            return r9
        L_0x02ad:
            r16 = 0
        L_0x02af:
            boolean r0 = com.google.android.gms.ads.internal.util.client.zzl.zzk()     // Catch:{ Exception -> 0x02cb, NoClassDefFoundError -> 0x02c9 }
            if (r0 == 0) goto L_0x02c8
            com.google.android.gms.internal.ads.zzbdx r0 = com.google.android.gms.internal.ads.zzbej.zzb     // Catch:{ Exception -> 0x02cb, NoClassDefFoundError -> 0x02c9 }
            java.lang.Object r0 = r0.zze()     // Catch:{ Exception -> 0x02cb, NoClassDefFoundError -> 0x02c9 }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ Exception -> 0x02cb, NoClassDefFoundError -> 0x02c9 }
            boolean r0 = r0.booleanValue()     // Catch:{ Exception -> 0x02cb, NoClassDefFoundError -> 0x02c9 }
            if (r0 == 0) goto L_0x02c8
            android.webkit.WebResourceResponse r0 = r20.zzW(r21, r22)     // Catch:{ Exception -> 0x02cb, NoClassDefFoundError -> 0x02c9 }
            return r0
        L_0x02c8:
            return r16
        L_0x02c9:
            r0 = move-exception
            goto L_0x02cc
        L_0x02cb:
            r0 = move-exception
        L_0x02cc:
            java.lang.String r2 = "AdWebViewClient.interceptRequest"
            com.google.android.gms.internal.ads.zzbzz r3 = com.google.android.gms.ads.internal.zzv.zzp()
            r3.zzw(r0, r2)
            android.webkit.WebResourceResponse r0 = zzV()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcfs.zzc(java.lang.String, java.util.Map):android.webkit.WebResourceResponse");
    }

    public final zzb zzd() {
        return this.zzy;
    }

    public final void zzdG() {
        zzdel zzdel = this.zzm;
        if (zzdel != null) {
            zzdel.zzdG();
        }
    }

    public final void zzdf() {
        zzdel zzdel = this.zzm;
        if (zzdel != null) {
            zzdel.zzdf();
        }
    }

    public final void zzg() {
        if (this.zzi != null && ((this.zzA && this.zzC <= 0) || this.zzB || this.zzo)) {
            boolean z = true;
            if (((Boolean) zzbe.zzc().zza(zzbcn.zzbW)).booleanValue() && this.zzc.zzm() != null) {
                zzbcu.zza(this.zzc.zzm().zza(), this.zzc.zzk(), "awfllc");
            }
            zzcha zzcha = this.zzi;
            if (this.zzB || this.zzo) {
                z = false;
            }
            zzcha.zza(z, this.zzp, this.zzq, this.zzr);
            this.zzi = null;
        }
        this.zzc.zzaf();
    }

    public final void zzh() {
        zzbyh zzbyh = this.zza;
        if (zzbyh != null) {
            zzbyh.zze();
            this.zza = null;
        }
        zzY();
        synchronized (this.zzf) {
            this.zze.clear();
            this.zzg = null;
            this.zzh = null;
            this.zzi = null;
            this.zzj = null;
            this.zzk = null;
            this.zzl = null;
            this.zzn = false;
            this.zzs = false;
            this.zzt = false;
            this.zzu = false;
            this.zzw = null;
            this.zzy = null;
            this.zzx = null;
            zzbse zzbse = this.zzz;
            if (zzbse != null) {
                zzbse.zza(true);
                this.zzz = null;
            }
        }
    }

    public final void zzi(boolean z) {
        this.zzD = z;
    }

    public final void zzj(Uri uri) {
        String str;
        zze.zza("Received GMSG: ".concat(String.valueOf(String.valueOf(uri))));
        HashMap hashMap = this.zze;
        String path = uri.getPath();
        List list = (List) hashMap.get(path);
        if (path == null || list == null) {
            zze.zza("No GMSG handler found for GMSG: ".concat(String.valueOf(String.valueOf(uri))));
            if (((Boolean) zzbe.zzc().zza(zzbcn.zzgC)).booleanValue() && zzv.zzp().zzg() != null) {
                if (path == null || path.length() < 2) {
                    str = "null";
                } else {
                    str = path.substring(1);
                }
                zzcaj.zza.execute(new zzcfn(str));
                return;
            }
            return;
        }
        String encodedQuery = uri.getEncodedQuery();
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzfC)).booleanValue() && this.zzE.contains(path) && encodedQuery != null) {
            if (encodedQuery.length() >= ((Integer) zzbe.zzc().zza(zzbcn.zzfE)).intValue()) {
                zze.zza("Parsing gmsg query params on BG thread: ".concat(path));
                zzgei.zzr(zzv.zzq().zzb(uri), new zzcfq(this, list, path, uri), zzcaj.zze);
                return;
            }
        }
        zzv.zzq();
        zzX(zzs.zzP(uri), list, path);
    }

    public final void zzk() {
        zzbbl zzbbl = this.zzd;
        if (zzbbl != null) {
            zzbbl.zzc(10005);
        }
        this.zzB = true;
        this.zzp = 10004;
        this.zzq = "Page loaded delay cancel.";
        zzg();
        this.zzc.destroy();
    }

    public final void zzl() {
        synchronized (this.zzf) {
        }
        this.zzC++;
        zzg();
    }

    public final void zzm() {
        this.zzC--;
        zzg();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzn() {
        this.zzc.zzad();
        com.google.android.gms.ads.internal.overlay.zzm zzL = this.zzc.zzL();
        if (zzL != null) {
            zzL.zzz();
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzo(boolean z, long j) {
        this.zzc.zzv(z, j);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzp(View view, zzbyh zzbyh, int i) {
        zzZ(view, zzbyh, i - 1);
    }

    public final void zzq(int i, int i2, boolean z) {
        zzbsj zzbsj = this.zzx;
        if (zzbsj != null) {
            zzbsj.zzb(i, i2);
        }
        zzbse zzbse = this.zzz;
        if (zzbse != null) {
            zzbse.zzd(i, i2, false);
        }
    }

    public final void zzr() {
        zzbyh zzbyh = this.zza;
        if (zzbyh != null) {
            WebView zzG2 = this.zzc.zzG();
            if (ViewCompat.isAttachedToWindow(zzG2)) {
                zzZ(zzG2, zzbyh, 10);
                return;
            }
            zzY();
            zzcfp zzcfp = new zzcfp(this, zzbyh);
            this.zzG = zzcfp;
            ((View) this.zzc).addOnAttachStateChangeListener(zzcfp);
        }
    }

    public final void zzu(zzc zzc2, boolean z, boolean z2) {
        zzcfk zzcfk = this.zzc;
        boolean zzaF = zzcfk.zzaF();
        boolean z3 = false;
        boolean z4 = zzab(zzaF, zzcfk) || z2;
        if (z4 || !z) {
            z3 = true;
        }
        zzdel zzdel = null;
        zza zza2 = z4 ? null : this.zzg;
        zzr zzr2 = zzaF ? null : this.zzh;
        zzac zzac = this.zzw;
        zzcfk zzcfk2 = this.zzc;
        VersionInfoParcel zzn2 = zzcfk2.zzn();
        if (!z3) {
            zzdel = this.zzm;
        }
        zzx(new AdOverlayInfoParcel(zzc2, zza2, zzr2, zzac, zzn2, zzcfk2, zzdel));
    }

    public final void zzv(String str, String str2, int i) {
        zzeea zzeea = this.zzF;
        zzcfk zzcfk = this.zzc;
        zzx(new AdOverlayInfoParcel(zzcfk, zzcfk.zzn(), str, str2, 14, zzeea));
    }

    public final void zzw(boolean z, int i, boolean z2) {
        zzdel zzdel;
        zzcfk zzcfk = this.zzc;
        boolean zzab = zzab(zzcfk.zzaF(), zzcfk);
        boolean z3 = true;
        if (!zzab && z2) {
            z3 = false;
        }
        zzeea zzeea = null;
        zza zza2 = zzab ? null : this.zzg;
        zzr zzr2 = this.zzh;
        zzac zzac = this.zzw;
        zzcfk zzcfk2 = this.zzc;
        VersionInfoParcel zzn2 = zzcfk2.zzn();
        if (z3) {
            zzdel = null;
        } else {
            zzdel = this.zzm;
        }
        if (zzaa(this.zzc)) {
            zzeea = this.zzF;
        }
        zzx(new AdOverlayInfoParcel(zza2, zzr2, zzac, zzcfk2, z, i, zzn2, zzdel, zzeea));
    }

    public final void zzx(AdOverlayInfoParcel adOverlayInfoParcel) {
        zzc zzc2;
        zzbse zzbse = this.zzz;
        boolean zzf2 = zzbse != null ? zzbse.zzf() : false;
        zzv.zzj();
        zzn.zza(this.zzc.getContext(), adOverlayInfoParcel, !zzf2);
        zzbyh zzbyh = this.zza;
        if (zzbyh != null) {
            String str = adOverlayInfoParcel.zzl;
            if (str == null && (zzc2 = adOverlayInfoParcel.zza) != null) {
                str = zzc2.zzb;
            }
            zzbyh.zzh(str);
        }
    }

    public final void zzy(boolean z, int i, String str, String str2, boolean z2) {
        zza zza2;
        zzdel zzdel;
        zzcfk zzcfk = this.zzc;
        boolean zzaF = zzcfk.zzaF();
        boolean zzab = zzab(zzaF, zzcfk);
        boolean z3 = true;
        if (!zzab && z2) {
            z3 = false;
        }
        zzeea zzeea = null;
        if (zzab) {
            zza2 = null;
        } else {
            zza2 = this.zzg;
        }
        zzcfr zzcfr = zzaF ? null : new zzcfr(this.zzc, this.zzh);
        zzbih zzbih = this.zzk;
        zzbij zzbij = this.zzl;
        zzac zzac = this.zzw;
        zzcfk zzcfk2 = this.zzc;
        VersionInfoParcel zzn2 = zzcfk2.zzn();
        if (z3) {
            zzdel = null;
        } else {
            zzdel = this.zzm;
        }
        if (zzaa(this.zzc)) {
            zzeea = this.zzF;
        }
        zzx(new AdOverlayInfoParcel(zza2, (zzr) zzcfr, zzbih, zzbij, zzac, zzcfk2, z, i, str, str2, zzn2, zzdel, (zzbsz) zzeea));
    }

    public final void zzz(boolean z, int i, String str, boolean z2, boolean z3) {
        zza zza2;
        zzdel zzdel;
        zzcfk zzcfk = this.zzc;
        boolean zzaF = zzcfk.zzaF();
        boolean zzab = zzab(zzaF, zzcfk);
        boolean z4 = true;
        if (!zzab && z2) {
            z4 = false;
        }
        zzeea zzeea = null;
        if (zzab) {
            zza2 = null;
        } else {
            zza2 = this.zzg;
        }
        zzcfr zzcfr = zzaF ? null : new zzcfr(this.zzc, this.zzh);
        zzbih zzbih = this.zzk;
        zzbij zzbij = this.zzl;
        zzac zzac = this.zzw;
        zzcfk zzcfk2 = this.zzc;
        VersionInfoParcel zzn2 = zzcfk2.zzn();
        if (z4) {
            zzdel = null;
        } else {
            zzdel = this.zzm;
        }
        if (zzaa(this.zzc)) {
            zzeea = this.zzF;
        }
        zzx(new AdOverlayInfoParcel(zza2, (zzr) zzcfr, zzbih, zzbij, zzac, zzcfk2, z, i, str, zzn2, zzdel, (zzbsz) zzeea, z3));
    }
}
