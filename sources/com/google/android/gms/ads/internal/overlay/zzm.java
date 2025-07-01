package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.Toolbar;
import androidx.core.view.ViewCompat;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbcn;
import com.google.android.gms.internal.ads.zzbsz;
import com.google.android.gms.internal.ads.zzbtf;
import com.google.android.gms.internal.ads.zzcfk;
import com.google.android.gms.internal.ads.zzeeb;
import com.google.android.gms.internal.ads.zzeec;
import com.google.android.gms.internal.ads.zzeeu;
import com.google.android.gms.internal.ads.zzeew;
import java.util.Collections;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public class zzm extends zzbtf implements zzag {
    static final int zza = Color.argb(0, 0, 0, 0);
    protected final Activity zzb;
    AdOverlayInfoParcel zzc;
    zzcfk zzd;
    zzi zze;
    zzu zzf;
    boolean zzg = false;
    FrameLayout zzh;
    WebChromeClient.CustomViewCallback zzi;
    boolean zzj = false;
    boolean zzk = false;
    zzh zzl;
    boolean zzm = false;
    int zzn = 1;
    private final Object zzo = new Object();
    private final View.OnClickListener zzp = new zzf(this);
    private Runnable zzq;
    private boolean zzr;
    private boolean zzs;
    private boolean zzt = false;
    private boolean zzu = false;
    private boolean zzv = true;
    private Toolbar zzw;

    public zzm(Activity activity) {
        this.zzb = activity;
    }

    private final void zzJ(View view) {
        zzeew zzQ;
        zzeeu zzP;
        zzcfk zzcfk = this.zzd;
        if (zzcfk != null) {
            if (!((Boolean) zzbe.zzc().zza(zzbcn.zzfe)).booleanValue() || (zzP = zzcfk.zzP()) == null) {
                if (((Boolean) zzbe.zzc().zza(zzbcn.zzfd)).booleanValue() && (zzQ = zzcfk.zzQ()) != null && zzQ.zzb()) {
                    zzv.zzB().zzg(zzQ.zza(), view);
                    return;
                }
                return;
            }
            zzP.zza(view);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0031, code lost:
        if (((java.lang.Boolean) com.google.android.gms.ads.internal.client.zzbe.zzc().zza(com.google.android.gms.internal.ads.zzbcn.zzaN)).booleanValue() != false) goto L_0x0033;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0045, code lost:
        if (((java.lang.Boolean) com.google.android.gms.ads.internal.client.zzbe.zzc().zza(com.google.android.gms.internal.ads.zzbcn.zzaM)).booleanValue() != false) goto L_0x004a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0048, code lost:
        r1 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = r0.zzo;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzK(android.content.res.Configuration r6) {
        /*
            r5 = this;
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r0 = r5.zzc
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0010
            com.google.android.gms.ads.internal.zzl r0 = r0.zzo
            if (r0 == 0) goto L_0x0010
            boolean r0 = r0.zzb
            if (r0 == 0) goto L_0x0010
            r0 = r1
            goto L_0x0011
        L_0x0010:
            r0 = r2
        L_0x0011:
            android.app.Activity r3 = r5.zzb
            com.google.android.gms.ads.internal.util.zzaa r4 = com.google.android.gms.ads.internal.zzv.zzr()
            boolean r6 = r4.zzd(r3, r6)
            boolean r3 = r5.zzk
            if (r3 == 0) goto L_0x0033
            if (r0 != 0) goto L_0x0033
            com.google.android.gms.internal.ads.zzbce r0 = com.google.android.gms.internal.ads.zzbcn.zzaN
            com.google.android.gms.internal.ads.zzbcl r3 = com.google.android.gms.ads.internal.client.zzbe.zzc()
            java.lang.Object r0 = r3.zza(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x0048
        L_0x0033:
            if (r6 == 0) goto L_0x004a
            com.google.android.gms.internal.ads.zzbce r6 = com.google.android.gms.internal.ads.zzbcn.zzaM
            com.google.android.gms.internal.ads.zzbcl r0 = com.google.android.gms.ads.internal.client.zzbe.zzc()
            java.lang.Object r6 = r0.zza(r6)
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            if (r6 == 0) goto L_0x0048
            goto L_0x004a
        L_0x0048:
            r1 = r2
            goto L_0x0057
        L_0x004a:
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r6 = r5.zzc
            if (r6 == 0) goto L_0x0057
            com.google.android.gms.ads.internal.zzl r6 = r6.zzo
            if (r6 == 0) goto L_0x0057
            boolean r6 = r6.zzg
            if (r6 == 0) goto L_0x0057
            r2 = r1
        L_0x0057:
            android.app.Activity r6 = r5.zzb
            android.view.Window r6 = r6.getWindow()
            com.google.android.gms.internal.ads.zzbce r0 = com.google.android.gms.internal.ads.zzbcn.zzbl
            com.google.android.gms.internal.ads.zzbcl r3 = com.google.android.gms.ads.internal.client.zzbe.zzc()
            java.lang.Object r0 = r3.zza(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x0083
            android.view.View r6 = r6.getDecorView()
            if (r1 == 0) goto L_0x007d
            if (r2 == 0) goto L_0x007a
            r0 = 5894(0x1706, float:8.259E-42)
            goto L_0x007f
        L_0x007a:
            r0 = 5380(0x1504, float:7.539E-42)
            goto L_0x007f
        L_0x007d:
            r0 = 256(0x100, float:3.59E-43)
        L_0x007f:
            r6.setSystemUiVisibility(r0)
            return
        L_0x0083:
            r0 = 1024(0x400, float:1.435E-42)
            r3 = 2048(0x800, float:2.87E-42)
            if (r1 == 0) goto L_0x009b
            r6.addFlags(r0)
            r6.clearFlags(r3)
            if (r2 == 0) goto L_0x009a
            android.view.View r6 = r6.getDecorView()
            r0 = 4098(0x1002, float:5.743E-42)
            r6.setSystemUiVisibility(r0)
        L_0x009a:
            return
        L_0x009b:
            r6.addFlags(r3)
            r6.clearFlags(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.overlay.zzm.zzK(android.content.res.Configuration):void");
    }

    private static final void zzL(zzeew zzeew, View view) {
        if (zzeew != null && view != null) {
            if (!((Boolean) zzbe.zzc().zza(zzbcn.zzfd)).booleanValue() || !zzeew.zzb()) {
                zzv.zzB().zzj(zzeew.zza(), view);
            }
        }
    }

    public final void zzA(int i) {
        if (this.zzb.getApplicationInfo().targetSdkVersion >= ((Integer) zzbe.zzc().zza(zzbcn.zzfR)).intValue()) {
            if (this.zzb.getApplicationInfo().targetSdkVersion <= ((Integer) zzbe.zzc().zza(zzbcn.zzfS)).intValue()) {
                if (Build.VERSION.SDK_INT >= ((Integer) zzbe.zzc().zza(zzbcn.zzfT)).intValue()) {
                    if (Build.VERSION.SDK_INT <= ((Integer) zzbe.zzc().zza(zzbcn.zzfU)).intValue()) {
                        return;
                    }
                }
            }
        }
        try {
            this.zzb.setRequestedOrientation(i);
        } catch (Throwable th) {
            zzv.zzp().zzv(th, "AdOverlay.setRequestedOrientation");
        }
    }

    public final void zzB(boolean z) {
        if (z) {
            this.zzl.setBackgroundColor(0);
        } else {
            this.zzl.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        }
    }

    public final void zzC(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        FrameLayout frameLayout = new FrameLayout(this.zzb);
        this.zzh = frameLayout;
        frameLayout.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        this.zzh.addView(view, -1, -1);
        this.zzb.setContentView(this.zzh);
        this.zzs = true;
        this.zzi = customViewCallback;
        this.zzg = true;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x0278  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x0287  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00a5 A[SYNTHETIC, Splitter:B:38:0x00a5] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0175  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0186  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x019e  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x01ae  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzD(boolean r32) throws com.google.android.gms.ads.internal.overlay.zzg {
        /*
            r31 = this;
            r1 = r31
            boolean r0 = r1.zzs
            r2 = 1
            if (r0 != 0) goto L_0x000c
            android.app.Activity r0 = r1.zzb
            r0.requestWindowFeature(r2)
        L_0x000c:
            android.app.Activity r0 = r1.zzb
            android.view.Window r0 = r0.getWindow()
            if (r0 == 0) goto L_0x02b6
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r3 = r1.zzc
            com.google.android.gms.internal.ads.zzcfk r3 = r3.zzd
            r4 = 0
            if (r3 == 0) goto L_0x0020
            com.google.android.gms.internal.ads.zzchc r3 = r3.zzN()
            goto L_0x0021
        L_0x0020:
            r3 = r4
        L_0x0021:
            r5 = 0
            if (r3 == 0) goto L_0x002c
            boolean r3 = r3.zzS()
            if (r3 == 0) goto L_0x002c
            r10 = r2
            goto L_0x002d
        L_0x002c:
            r10 = r5
        L_0x002d:
            r1.zzm = r5
            if (r10 == 0) goto L_0x0064
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r3 = r1.zzc
            int r3 = r3.zzj
            r6 = 6
            if (r3 != r6) goto L_0x004c
            android.app.Activity r3 = r1.zzb
            android.content.res.Resources r3 = r3.getResources()
            android.content.res.Configuration r3 = r3.getConfiguration()
            int r3 = r3.orientation
            if (r3 != r2) goto L_0x0048
            r3 = r2
            goto L_0x0049
        L_0x0048:
            r3 = r5
        L_0x0049:
            r1.zzm = r3
            goto L_0x0065
        L_0x004c:
            r6 = 7
            if (r3 != r6) goto L_0x0064
            android.app.Activity r3 = r1.zzb
            android.content.res.Resources r3 = r3.getResources()
            android.content.res.Configuration r3 = r3.getConfiguration()
            int r3 = r3.orientation
            r6 = 2
            if (r3 != r6) goto L_0x0060
            r3 = r2
            goto L_0x0061
        L_0x0060:
            r3 = r5
        L_0x0061:
            r1.zzm = r3
            goto L_0x0065
        L_0x0064:
            r3 = r5
        L_0x0065:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r7 = "Delay onShow to next orientation change: "
            r6.<init>(r7)
            r6.append(r3)
            java.lang.String r3 = r6.toString()
            com.google.android.gms.ads.internal.util.client.zzm.zze(r3)
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r3 = r1.zzc
            int r3 = r3.zzj
            r1.zzA(r3)
            r3 = 16777216(0x1000000, float:2.3509887E-38)
            r0.setFlags(r3, r3)
            java.lang.String r0 = "Hardware acceleration on the AdActivity window enabled."
            com.google.android.gms.ads.internal.util.client.zzm.zze(r0)
            boolean r0 = r1.zzk
            if (r0 != 0) goto L_0x0093
            com.google.android.gms.ads.internal.overlay.zzh r0 = r1.zzl
            r3 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            r0.setBackgroundColor(r3)
            goto L_0x009a
        L_0x0093:
            com.google.android.gms.ads.internal.overlay.zzh r0 = r1.zzl
            int r3 = zza
            r0.setBackgroundColor(r3)
        L_0x009a:
            android.app.Activity r0 = r1.zzb
            com.google.android.gms.ads.internal.overlay.zzh r3 = r1.zzl
            r0.setContentView(r3)
            r1.zzs = r2
            if (r32 == 0) goto L_0x0175
            com.google.android.gms.ads.internal.zzv.zzA()     // Catch:{ Exception -> 0x0167 }
            android.app.Activity r6 = r1.zzb     // Catch:{ Exception -> 0x0167 }
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r0 = r1.zzc     // Catch:{ Exception -> 0x0167 }
            com.google.android.gms.internal.ads.zzcfk r0 = r0.zzd     // Catch:{ Exception -> 0x0167 }
            if (r0 == 0) goto L_0x00b6
            com.google.android.gms.internal.ads.zzche r0 = r0.zzO()     // Catch:{ Exception -> 0x0167 }
            r7 = r0
            goto L_0x00b7
        L_0x00b6:
            r7 = r4
        L_0x00b7:
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r0 = r1.zzc     // Catch:{ Exception -> 0x0167 }
            com.google.android.gms.internal.ads.zzcfk r0 = r0.zzd     // Catch:{ Exception -> 0x0167 }
            if (r0 == 0) goto L_0x00c3
            java.lang.String r0 = r0.zzU()     // Catch:{ Exception -> 0x0167 }
            r8 = r0
            goto L_0x00c4
        L_0x00c3:
            r8 = r4
        L_0x00c4:
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r0 = r1.zzc     // Catch:{ Exception -> 0x0167 }
            com.google.android.gms.ads.internal.util.client.VersionInfoParcel r13 = r0.zzm     // Catch:{ Exception -> 0x0167 }
            com.google.android.gms.internal.ads.zzcfk r0 = r0.zzd     // Catch:{ Exception -> 0x0167 }
            if (r0 == 0) goto L_0x00d3
            com.google.android.gms.ads.internal.zza r0 = r0.zzj()     // Catch:{ Exception -> 0x0167 }
            r16 = r0
            goto L_0x00d5
        L_0x00d3:
            r16 = r4
        L_0x00d5:
            com.google.android.gms.internal.ads.zzbbl r17 = com.google.android.gms.internal.ads.zzbbl.zza()     // Catch:{ Exception -> 0x0167 }
            r20 = 0
            r21 = 0
            r9 = 1
            r11 = 0
            r12 = 0
            r14 = 0
            r15 = 0
            r18 = 0
            r19 = 0
            com.google.android.gms.internal.ads.zzcfk r0 = com.google.android.gms.internal.ads.zzcfx.zza(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21)     // Catch:{ Exception -> 0x0167 }
            r1.zzd = r0     // Catch:{ Exception -> 0x0167 }
            com.google.android.gms.internal.ads.zzchc r11 = r0.zzN()
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r0 = r1.zzc
            com.google.android.gms.internal.ads.zzbih r13 = r0.zzp
            com.google.android.gms.internal.ads.zzbij r15 = r0.zze
            com.google.android.gms.ads.internal.overlay.zzac r3 = r0.zzi
            com.google.android.gms.internal.ads.zzcfk r0 = r0.zzd
            if (r0 == 0) goto L_0x0107
            com.google.android.gms.internal.ads.zzchc r0 = r0.zzN()
            com.google.android.gms.ads.internal.zzb r0 = r0.zzd()
            r19 = r0
            goto L_0x0109
        L_0x0107:
            r19 = r4
        L_0x0109:
            r29 = 0
            r30 = 0
            r12 = 0
            r14 = 0
            r17 = 1
            r18 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            r28 = 0
            r16 = r3
            r11.zzU(r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30)
            com.google.android.gms.internal.ads.zzcfk r0 = r1.zzd
            com.google.android.gms.internal.ads.zzchc r0 = r0.zzN()
            com.google.android.gms.ads.internal.overlay.zze r3 = new com.google.android.gms.ads.internal.overlay.zze
            r3.<init>(r1)
            r0.zzB(r3)
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r0 = r1.zzc
            java.lang.String r3 = r0.zzl
            if (r3 == 0) goto L_0x0144
            com.google.android.gms.internal.ads.zzcfk r0 = r1.zzd
            r0.loadUrl(r3)
            goto L_0x0155
        L_0x0144:
            java.lang.String r13 = r0.zzh
            if (r13 == 0) goto L_0x015f
            com.google.android.gms.internal.ads.zzcfk r11 = r1.zzd
            java.lang.String r12 = r0.zzf
            java.lang.String r15 = "UTF-8"
            r16 = 0
            java.lang.String r14 = "text/html"
            r11.loadDataWithBaseURL(r12, r13, r14, r15, r16)
        L_0x0155:
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r0 = r1.zzc
            com.google.android.gms.internal.ads.zzcfk r0 = r0.zzd
            if (r0 == 0) goto L_0x0180
            r0.zzaw(r1)
            goto L_0x0180
        L_0x015f:
            com.google.android.gms.ads.internal.overlay.zzg r0 = new com.google.android.gms.ads.internal.overlay.zzg
            java.lang.String r2 = "No URL or HTML to display in ad overlay."
            r0.<init>(r2)
            throw r0
        L_0x0167:
            r0 = move-exception
            java.lang.String r2 = "Error obtaining webview."
            com.google.android.gms.ads.internal.util.client.zzm.zzh(r2, r0)
            com.google.android.gms.ads.internal.overlay.zzg r2 = new com.google.android.gms.ads.internal.overlay.zzg
            java.lang.String r3 = "Could not obtain webview for the overlay."
            r2.<init>(r3, r0)
            throw r2
        L_0x0175:
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r0 = r1.zzc
            com.google.android.gms.internal.ads.zzcfk r0 = r0.zzd
            r1.zzd = r0
            android.app.Activity r3 = r1.zzb
            r0.zzan(r3)
        L_0x0180:
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r0 = r1.zzc
            boolean r0 = r0.zzw
            if (r0 == 0) goto L_0x0193
            android.webkit.CookieManager r0 = android.webkit.CookieManager.getInstance()
            com.google.android.gms.internal.ads.zzcfk r3 = r1.zzd
            android.webkit.WebView r3 = r3.zzG()
            r0.setAcceptThirdPartyCookies(r3, r5)
        L_0x0193:
            com.google.android.gms.internal.ads.zzcfk r0 = r1.zzd
            r0.zzai(r1)
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r0 = r1.zzc
            com.google.android.gms.internal.ads.zzcfk r0 = r0.zzd
            if (r0 == 0) goto L_0x01a7
            com.google.android.gms.internal.ads.zzeew r0 = r0.zzQ()
            com.google.android.gms.ads.internal.overlay.zzh r3 = r1.zzl
            zzL(r0, r3)
        L_0x01a7:
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r0 = r1.zzc
            int r0 = r0.zzk
            r3 = 5
            if (r0 == r3) goto L_0x0269
            com.google.android.gms.internal.ads.zzcfk r0 = r1.zzd
            android.view.ViewParent r0 = r0.getParent()
            if (r0 == 0) goto L_0x01c5
            boolean r6 = r0 instanceof android.view.ViewGroup
            if (r6 == 0) goto L_0x01c5
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            com.google.android.gms.internal.ads.zzcfk r6 = r1.zzd
            android.view.View r6 = r6.zzF()
            r0.removeView(r6)
        L_0x01c5:
            boolean r0 = r1.zzk
            if (r0 == 0) goto L_0x01ce
            com.google.android.gms.internal.ads.zzcfk r0 = r1.zzd
            r0.zzam()
        L_0x01ce:
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r0 = r1.zzc
            boolean r0 = r0.zzw
            r6 = -1
            if (r0 == 0) goto L_0x025e
            android.app.Activity r0 = r1.zzb
            android.widget.Toolbar r7 = new android.widget.Toolbar
            r7.<init>(r0)
            r1.zzw = r7
            int r0 = android.view.View.generateViewId()
            r7.setId(r0)
            com.google.android.gms.internal.ads.zzcfk r0 = r1.zzd
            android.view.View r0 = r0.zzF()
            int r7 = android.view.View.generateViewId()
            r0.setId(r7)
            android.widget.Toolbar r0 = r1.zzw
            r7 = -12303292(0xffffffffff444444, float:-2.6088314E38)
            r0.setBackgroundColor(r7)
            android.widget.Toolbar r0 = r1.zzw
            r0.setVisibility(r5)
            com.google.android.gms.internal.ads.zzbzz r0 = com.google.android.gms.ads.internal.zzv.zzp()     // Catch:{ NullPointerException -> 0x0215, NotFoundException -> 0x0213 }
            android.content.res.Resources r0 = r0.zze()     // Catch:{ NullPointerException -> 0x0215, NotFoundException -> 0x0213 }
            int r7 = com.google.android.gms.ads.impl.R.drawable.admob_close_button_white_cross     // Catch:{ NullPointerException -> 0x0215, NotFoundException -> 0x0213 }
            android.graphics.drawable.Drawable r0 = r0.getDrawable(r7, r4)     // Catch:{ NullPointerException -> 0x0215, NotFoundException -> 0x0213 }
            android.widget.Toolbar r4 = r1.zzw     // Catch:{ NullPointerException -> 0x0215, NotFoundException -> 0x0213 }
            r4.setNavigationIcon(r0)     // Catch:{ NullPointerException -> 0x0215, NotFoundException -> 0x0213 }
            goto L_0x021b
        L_0x0213:
            r0 = move-exception
            goto L_0x0216
        L_0x0215:
            r0 = move-exception
        L_0x0216:
            java.lang.String r4 = "Error obtaining close icon."
            com.google.android.gms.ads.internal.util.zze.zzb(r4, r0)
        L_0x021b:
            android.widget.Toolbar r0 = r1.zzw
            android.view.View$OnClickListener r4 = r1.zzp
            r0.setNavigationOnClickListener(r4)
            android.widget.Toolbar r0 = r1.zzw
            r0.setTitleMarginStart(r5)
            android.widget.RelativeLayout$LayoutParams r0 = new android.widget.RelativeLayout$LayoutParams
            r4 = -2
            r0.<init>(r6, r4)
            r5 = 10
            r0.addRule(r5)
            com.google.android.gms.ads.internal.overlay.zzh r5 = r1.zzl
            android.widget.Toolbar r7 = r1.zzw
            r5.addView(r7, r0)
            android.widget.RelativeLayout$LayoutParams r0 = new android.widget.RelativeLayout$LayoutParams
            r0.<init>(r6, r4)
            android.widget.Toolbar r4 = r1.zzw
            int r4 = r4.getId()
            r5 = 3
            r0.addRule(r5, r4)
            r4 = 12
            r0.addRule(r4)
            com.google.android.gms.ads.internal.overlay.zzh r4 = r1.zzl
            com.google.android.gms.internal.ads.zzcfk r5 = r1.zzd
            android.view.View r5 = r5.zzF()
            r4.addView(r5, r0)
            android.widget.Toolbar r0 = r1.zzw
            r1.zzJ(r0)
            goto L_0x0269
        L_0x025e:
            com.google.android.gms.ads.internal.overlay.zzh r0 = r1.zzl
            com.google.android.gms.internal.ads.zzcfk r4 = r1.zzd
            android.view.View r4 = r4.zzF()
            r0.addView(r4, r6, r6)
        L_0x0269:
            if (r32 != 0) goto L_0x0272
            boolean r0 = r1.zzm
            if (r0 != 0) goto L_0x0272
            r1.zze()
        L_0x0272:
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r0 = r1.zzc
            int r0 = r0.zzk
            if (r0 == r3) goto L_0x0287
            r1.zzw(r10)
            com.google.android.gms.internal.ads.zzcfk r0 = r1.zzd
            boolean r0 = r0.zzaB()
            if (r0 == 0) goto L_0x02a8
            r1.zzy(r10, r2)
            return
        L_0x0287:
            android.app.Activity r0 = r1.zzb
            com.google.android.gms.internal.ads.zzeeb r2 = com.google.android.gms.internal.ads.zzeec.zze()
            r2.zza(r0)
            r2.zzb(r1)
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r0 = r1.zzc
            java.lang.String r0 = r0.zzq
            r2.zzc(r0)
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r0 = r1.zzc
            java.lang.String r0 = r0.zzr
            r2.zzd(r0)
            com.google.android.gms.internal.ads.zzeec r0 = r2.zze()
            r1.zzf(r0)     // Catch:{ zzg -> 0x02ab, RemoteException -> 0x02a9 }
        L_0x02a8:
            return
        L_0x02a9:
            r0 = move-exception
            goto L_0x02ac
        L_0x02ab:
            r0 = move-exception
        L_0x02ac:
            com.google.android.gms.ads.internal.overlay.zzg r2 = new com.google.android.gms.ads.internal.overlay.zzg
            java.lang.String r3 = r0.getMessage()
            r2.<init>(r3, r0)
            throw r2
        L_0x02b6:
            com.google.android.gms.ads.internal.overlay.zzg r0 = new com.google.android.gms.ads.internal.overlay.zzg
            java.lang.String r2 = "Invalid activity, no window available."
            r0.<init>(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.overlay.zzm.zzD(boolean):void");
    }

    public final void zzE() {
        synchronized (this.zzo) {
            this.zzr = true;
            if (this.zzq != null) {
                zzs.zza.removeCallbacks(this.zzq);
                zzs.zza.post(this.zzq);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void zzF() {
        AdOverlayInfoParcel adOverlayInfoParcel;
        zzr zzr2;
        if (this.zzb.isFinishing() && !this.zzt) {
            this.zzt = true;
            zzcfk zzcfk = this.zzd;
            if (zzcfk != null) {
                zzcfk.zzZ(this.zzn - 1);
                synchronized (this.zzo) {
                    if (!this.zzr && this.zzd.zzaC()) {
                        if (((Boolean) zzbe.zzc().zza(zzbcn.zzeP)).booleanValue() && !this.zzu && (adOverlayInfoParcel = this.zzc) != null && (zzr2 = adOverlayInfoParcel.zzc) != null) {
                            zzr2.zzdq();
                        }
                        this.zzq = new zzd(this);
                        zzs.zza.postDelayed(this.zzq, ((Long) zzbe.zzc().zza(zzbcn.zzbe)).longValue());
                        return;
                    }
                }
            }
            zzc();
        }
    }

    public final void zzG(String str) {
        Toolbar toolbar = this.zzw;
        if (toolbar != null) {
            toolbar.setSubtitle(str);
        }
    }

    public final boolean zzH() {
        this.zzn = 1;
        if (this.zzd == null) {
            return true;
        }
        if (!((Boolean) zzbe.zzc().zza(zzbcn.zziz)).booleanValue() || !this.zzd.canGoBack()) {
            boolean zzaH = this.zzd.zzaH();
            if (!zzaH) {
                this.zzd.zzd("onbackblocked", Collections.emptyMap());
            }
            return zzaH;
        }
        this.zzd.goBack();
        return false;
    }

    public final void zzb() {
        this.zzn = 3;
        this.zzb.finish();
        AdOverlayInfoParcel adOverlayInfoParcel = this.zzc;
        if (adOverlayInfoParcel != null && adOverlayInfoParcel.zzk == 5) {
            this.zzb.overridePendingTransition(0, 0);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzc() {
        zzcfk zzcfk;
        zzr zzr2;
        if (!this.zzu) {
            this.zzu = true;
            zzcfk zzcfk2 = this.zzd;
            if (zzcfk2 != null) {
                this.zzl.removeView(zzcfk2.zzF());
                zzi zzi2 = this.zze;
                if (zzi2 != null) {
                    this.zzd.zzan(zzi2.zzd);
                    this.zzd.zzaq(false);
                    if (((Boolean) zzbe.zzc().zza(zzbcn.zzmq)).booleanValue() && this.zzd.getParent() != null) {
                        ((ViewGroup) this.zzd.getParent()).removeView(this.zzd.zzF());
                    }
                    ViewGroup viewGroup = this.zze.zzc;
                    View zzF = this.zzd.zzF();
                    zzi zzi3 = this.zze;
                    viewGroup.addView(zzF, zzi3.zza, zzi3.zzb);
                    this.zze = null;
                } else if (this.zzb.getApplicationContext() != null) {
                    this.zzd.zzan(this.zzb.getApplicationContext());
                }
                this.zzd = null;
            }
            AdOverlayInfoParcel adOverlayInfoParcel = this.zzc;
            if (!(adOverlayInfoParcel == null || (zzr2 = adOverlayInfoParcel.zzc) == null)) {
                zzr2.zzdu(this.zzn);
            }
            AdOverlayInfoParcel adOverlayInfoParcel2 = this.zzc;
            if (adOverlayInfoParcel2 != null && (zzcfk = adOverlayInfoParcel2.zzd) != null) {
                zzL(zzcfk.zzQ(), this.zzc.zzd.zzF());
            }
        }
    }

    public final void zzd() {
        this.zzl.zzb = true;
    }

    /* access modifiers changed from: protected */
    public final void zze() {
        this.zzd.zzaa();
    }

    public final void zzf(zzeec zzeec) throws zzg, RemoteException {
        zzbsz zzbsz;
        AdOverlayInfoParcel adOverlayInfoParcel = this.zzc;
        if (adOverlayInfoParcel == null || (zzbsz = adOverlayInfoParcel.zzv) == null) {
            throw new zzg("noioou");
        }
        zzbsz.zzg(ObjectWrapper.wrap(zzeec));
    }

    public final void zzg() {
        AdOverlayInfoParcel adOverlayInfoParcel = this.zzc;
        if (adOverlayInfoParcel != null && this.zzg) {
            zzA(adOverlayInfoParcel.zzj);
        }
        if (this.zzh != null) {
            this.zzb.setContentView(this.zzl);
            this.zzs = true;
            this.zzh.removeAllViews();
            this.zzh = null;
        }
        WebChromeClient.CustomViewCallback customViewCallback = this.zzi;
        if (customViewCallback != null) {
            customViewCallback.onCustomViewHidden();
            this.zzi = null;
        }
        this.zzg = false;
    }

    public final void zzh(int i, int i2, Intent intent) {
    }

    public final void zzi() {
        this.zzn = 1;
    }

    public final void zzj() {
        this.zzn = 2;
        this.zzb.finish();
    }

    public final void zzk(IObjectWrapper iObjectWrapper) {
        zzK((Configuration) ObjectWrapper.unwrap(iObjectWrapper));
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x0080 A[Catch:{ zzg -> 0x0104 }] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00d3 A[Catch:{ zzg -> 0x0104 }] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00f8 A[Catch:{ zzg -> 0x0104 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void zzl(android.os.Bundle r9) {
        /*
            r8 = this;
            boolean r0 = r8.zzs
            r1 = 1
            if (r0 != 0) goto L_0x000a
            android.app.Activity r0 = r8.zzb
            r0.requestWindowFeature(r1)
        L_0x000a:
            r0 = 0
            if (r9 == 0) goto L_0x0017
            java.lang.String r2 = "com.google.android.gms.ads.internal.overlay.hasResumed"
            boolean r2 = r9.getBoolean(r2, r0)
            if (r2 == 0) goto L_0x0017
            r2 = r1
            goto L_0x0018
        L_0x0017:
            r2 = r0
        L_0x0018:
            r8.zzj = r2
            r2 = 4
            android.app.Activity r3 = r8.zzb     // Catch:{ zzg -> 0x0104 }
            android.content.Intent r3 = r3.getIntent()     // Catch:{ zzg -> 0x0104 }
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r3 = com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel.zza(r3)     // Catch:{ zzg -> 0x0104 }
            r8.zzc = r3     // Catch:{ zzg -> 0x0104 }
            if (r3 == 0) goto L_0x00fc
            boolean r3 = r3.zzw     // Catch:{ zzg -> 0x0104 }
            if (r3 == 0) goto L_0x0032
            android.app.Activity r3 = r8.zzb     // Catch:{ zzg -> 0x0104 }
            r3.setShowWhenLocked(r1)     // Catch:{ zzg -> 0x0104 }
        L_0x0032:
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r3 = r8.zzc     // Catch:{ zzg -> 0x0104 }
            com.google.android.gms.ads.internal.util.client.VersionInfoParcel r3 = r3.zzm     // Catch:{ zzg -> 0x0104 }
            int r3 = r3.clientJarVersion     // Catch:{ zzg -> 0x0104 }
            r4 = 7500000(0x7270e0, float:1.0509738E-38)
            if (r3 <= r4) goto L_0x003f
            r8.zzn = r2     // Catch:{ zzg -> 0x0104 }
        L_0x003f:
            android.app.Activity r3 = r8.zzb     // Catch:{ zzg -> 0x0104 }
            android.content.Intent r3 = r3.getIntent()     // Catch:{ zzg -> 0x0104 }
            if (r3 == 0) goto L_0x0055
            android.app.Activity r3 = r8.zzb     // Catch:{ zzg -> 0x0104 }
            android.content.Intent r3 = r3.getIntent()     // Catch:{ zzg -> 0x0104 }
            java.lang.String r4 = "shouldCallOnOverlayOpened"
            boolean r3 = r3.getBooleanExtra(r4, r1)     // Catch:{ zzg -> 0x0104 }
            r8.zzv = r3     // Catch:{ zzg -> 0x0104 }
        L_0x0055:
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r3 = r8.zzc     // Catch:{ zzg -> 0x0104 }
            com.google.android.gms.ads.internal.zzl r4 = r3.zzo     // Catch:{ zzg -> 0x0104 }
            r5 = 5
            if (r4 == 0) goto L_0x0063
            boolean r6 = r4.zza     // Catch:{ zzg -> 0x0104 }
            r8.zzk = r6     // Catch:{ zzg -> 0x0104 }
            if (r6 == 0) goto L_0x007e
            goto L_0x0069
        L_0x0063:
            int r6 = r3.zzk     // Catch:{ zzg -> 0x0104 }
            if (r6 != r5) goto L_0x007c
            r8.zzk = r1     // Catch:{ zzg -> 0x0104 }
        L_0x0069:
            int r3 = r3.zzk     // Catch:{ zzg -> 0x0104 }
            if (r3 == r5) goto L_0x007e
            int r3 = r4.zzf     // Catch:{ zzg -> 0x0104 }
            r4 = -1
            if (r3 == r4) goto L_0x007e
            com.google.android.gms.ads.internal.overlay.zzk r3 = new com.google.android.gms.ads.internal.overlay.zzk     // Catch:{ zzg -> 0x0104 }
            r4 = 0
            r3.<init>(r8, r4)     // Catch:{ zzg -> 0x0104 }
            r3.zzb()     // Catch:{ zzg -> 0x0104 }
            goto L_0x007e
        L_0x007c:
            r8.zzk = r0     // Catch:{ zzg -> 0x0104 }
        L_0x007e:
            if (r9 != 0) goto L_0x00ac
            boolean r9 = r8.zzv     // Catch:{ zzg -> 0x0104 }
            if (r9 == 0) goto L_0x0096
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r9 = r8.zzc     // Catch:{ zzg -> 0x0104 }
            com.google.android.gms.internal.ads.zzcwz r9 = r9.zzt     // Catch:{ zzg -> 0x0104 }
            if (r9 == 0) goto L_0x008d
            r9.zze()     // Catch:{ zzg -> 0x0104 }
        L_0x008d:
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r9 = r8.zzc     // Catch:{ zzg -> 0x0104 }
            com.google.android.gms.ads.internal.overlay.zzr r9 = r9.zzc     // Catch:{ zzg -> 0x0104 }
            if (r9 == 0) goto L_0x0096
            r9.zzdr()     // Catch:{ zzg -> 0x0104 }
        L_0x0096:
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r9 = r8.zzc     // Catch:{ zzg -> 0x0104 }
            int r3 = r9.zzk     // Catch:{ zzg -> 0x0104 }
            if (r3 == r1) goto L_0x00ac
            com.google.android.gms.ads.internal.client.zza r9 = r9.zzb     // Catch:{ zzg -> 0x0104 }
            if (r9 == 0) goto L_0x00a3
            r9.onAdClicked()     // Catch:{ zzg -> 0x0104 }
        L_0x00a3:
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r9 = r8.zzc     // Catch:{ zzg -> 0x0104 }
            com.google.android.gms.internal.ads.zzdel r9 = r9.zzu     // Catch:{ zzg -> 0x0104 }
            if (r9 == 0) goto L_0x00ac
            r9.zzdG()     // Catch:{ zzg -> 0x0104 }
        L_0x00ac:
            com.google.android.gms.ads.internal.overlay.zzh r9 = new com.google.android.gms.ads.internal.overlay.zzh     // Catch:{ zzg -> 0x0104 }
            android.app.Activity r3 = r8.zzb     // Catch:{ zzg -> 0x0104 }
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r4 = r8.zzc     // Catch:{ zzg -> 0x0104 }
            java.lang.String r6 = r4.zzn     // Catch:{ zzg -> 0x0104 }
            com.google.android.gms.ads.internal.util.client.VersionInfoParcel r7 = r4.zzm     // Catch:{ zzg -> 0x0104 }
            java.lang.String r7 = r7.afmaVersion     // Catch:{ zzg -> 0x0104 }
            java.lang.String r4 = r4.zzs     // Catch:{ zzg -> 0x0104 }
            r9.<init>(r3, r6, r7, r4)     // Catch:{ zzg -> 0x0104 }
            r8.zzl = r9     // Catch:{ zzg -> 0x0104 }
            r3 = 1000(0x3e8, float:1.401E-42)
            r9.setId(r3)     // Catch:{ zzg -> 0x0104 }
            com.google.android.gms.ads.internal.util.zzaa r9 = com.google.android.gms.ads.internal.zzv.zzr()     // Catch:{ zzg -> 0x0104 }
            android.app.Activity r3 = r8.zzb     // Catch:{ zzg -> 0x0104 }
            r9.zzk(r3)     // Catch:{ zzg -> 0x0104 }
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r9 = r8.zzc     // Catch:{ zzg -> 0x0104 }
            int r3 = r9.zzk     // Catch:{ zzg -> 0x0104 }
            if (r3 == r1) goto L_0x00f8
            r4 = 2
            if (r3 == r4) goto L_0x00eb
            r9 = 3
            if (r3 == r9) goto L_0x00e7
            if (r3 != r5) goto L_0x00df
            r8.zzD(r0)     // Catch:{ zzg -> 0x0104 }
            return
        L_0x00df:
            com.google.android.gms.ads.internal.overlay.zzg r9 = new com.google.android.gms.ads.internal.overlay.zzg     // Catch:{ zzg -> 0x0104 }
            java.lang.String r0 = "Could not determine ad overlay type."
            r9.<init>(r0)     // Catch:{ zzg -> 0x0104 }
            throw r9     // Catch:{ zzg -> 0x0104 }
        L_0x00e7:
            r8.zzD(r1)     // Catch:{ zzg -> 0x0104 }
            return
        L_0x00eb:
            com.google.android.gms.ads.internal.overlay.zzi r1 = new com.google.android.gms.ads.internal.overlay.zzi     // Catch:{ zzg -> 0x0104 }
            com.google.android.gms.internal.ads.zzcfk r9 = r9.zzd     // Catch:{ zzg -> 0x0104 }
            r1.<init>(r9)     // Catch:{ zzg -> 0x0104 }
            r8.zze = r1     // Catch:{ zzg -> 0x0104 }
            r8.zzD(r0)     // Catch:{ zzg -> 0x0104 }
            return
        L_0x00f8:
            r8.zzD(r0)     // Catch:{ zzg -> 0x0104 }
            return
        L_0x00fc:
            com.google.android.gms.ads.internal.overlay.zzg r9 = new com.google.android.gms.ads.internal.overlay.zzg     // Catch:{ zzg -> 0x0104 }
            java.lang.String r0 = "Could not get info for ad overlay."
            r9.<init>(r0)     // Catch:{ zzg -> 0x0104 }
            throw r9     // Catch:{ zzg -> 0x0104 }
        L_0x0104:
            r9 = move-exception
            java.lang.String r9 = r9.getMessage()
            com.google.android.gms.ads.internal.util.client.zzm.zzj(r9)
            r8.zzn = r2
            android.app.Activity r9 = r8.zzb
            r9.finish()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.overlay.zzm.zzl(android.os.Bundle):void");
    }

    public final void zzm() {
        zzcfk zzcfk = this.zzd;
        if (zzcfk != null) {
            try {
                this.zzl.removeView(zzcfk.zzF());
            } catch (NullPointerException unused) {
            }
        }
        zzF();
    }

    public final void zzn() {
        if (this.zzm) {
            this.zzm = false;
            zze();
        }
    }

    public final void zzo() {
        zzr zzr2;
        zzg();
        AdOverlayInfoParcel adOverlayInfoParcel = this.zzc;
        if (!(adOverlayInfoParcel == null || (zzr2 = adOverlayInfoParcel.zzc) == null)) {
            zzr2.zzdk();
        }
        if (!((Boolean) zzbe.zzc().zza(zzbcn.zzeR)).booleanValue() && this.zzd != null && (!this.zzb.isFinishing() || this.zze == null)) {
            this.zzd.onPause();
        }
        zzF();
    }

    public final void zzp(int i, String[] strArr, int[] iArr) {
        if (i == 12345) {
            Activity activity = this.zzb;
            zzeeb zze2 = zzeec.zze();
            zze2.zza(activity);
            zze2.zzb(this.zzc.zzk == 5 ? this : null);
            try {
                this.zzc.zzv.zzf(strArr, iArr, ObjectWrapper.wrap(zze2.zze()));
            } catch (RemoteException unused) {
            }
        }
    }

    public final void zzq() {
    }

    public final void zzr() {
        zzr zzr2;
        AdOverlayInfoParcel adOverlayInfoParcel = this.zzc;
        if (!(adOverlayInfoParcel == null || (zzr2 = adOverlayInfoParcel.zzc) == null)) {
            zzr2.zzdH();
        }
        zzK(this.zzb.getResources().getConfiguration());
        if (!((Boolean) zzbe.zzc().zza(zzbcn.zzeR)).booleanValue()) {
            zzcfk zzcfk = this.zzd;
            if (zzcfk == null || zzcfk.zzaE()) {
                com.google.android.gms.ads.internal.util.client.zzm.zzj("The webview does not exist. Ignoring action.");
            } else {
                this.zzd.onResume();
            }
        }
    }

    public final void zzs(Bundle bundle) {
        bundle.putBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", this.zzj);
    }

    public final void zzt() {
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzeR)).booleanValue()) {
            zzcfk zzcfk = this.zzd;
            if (zzcfk == null || zzcfk.zzaE()) {
                com.google.android.gms.ads.internal.util.client.zzm.zzj("The webview does not exist. Ignoring action.");
            } else {
                this.zzd.onResume();
            }
        }
    }

    public final void zzu() {
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzeR)).booleanValue() && this.zzd != null && (!this.zzb.isFinishing() || this.zze == null)) {
            this.zzd.onPause();
        }
        zzF();
    }

    public final void zzv() {
        zzr zzr2;
        AdOverlayInfoParcel adOverlayInfoParcel = this.zzc;
        if (adOverlayInfoParcel != null && (zzr2 = adOverlayInfoParcel.zzc) != null) {
            zzr2.zzdt();
        }
    }

    public final void zzw(boolean z) {
        if (!this.zzc.zzw) {
            int intValue = ((Integer) zzbe.zzc().zza(zzbcn.zzeU)).intValue();
            int i = 0;
            boolean z2 = ((Boolean) zzbe.zzc().zza(zzbcn.zzbh)).booleanValue() || z;
            zzt zzt2 = new zzt();
            zzt2.zzd = 50;
            zzt2.zza = true != z2 ? 0 : intValue;
            if (true != z2) {
                i = intValue;
            }
            zzt2.zzb = i;
            zzt2.zzc = intValue;
            this.zzf = new zzu(this.zzb, zzt2, this);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(10);
            layoutParams.addRule(true != z2 ? 9 : 11);
            zzy(z, this.zzc.zzg);
            this.zzl.addView(this.zzf, layoutParams);
            zzJ(this.zzf);
        }
    }

    public final void zzx() {
        this.zzs = true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0018, code lost:
        r0 = (r0 = r6.zzc).zzo;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzy(boolean r7, boolean r8) {
        /*
            r6 = this;
            com.google.android.gms.internal.ads.zzbce r0 = com.google.android.gms.internal.ads.zzbcn.zzbf
            com.google.android.gms.internal.ads.zzbcl r1 = com.google.android.gms.ads.internal.client.zzbe.zzc()
            java.lang.Object r0 = r1.zza(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0022
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r0 = r6.zzc
            if (r0 == 0) goto L_0x0022
            com.google.android.gms.ads.internal.zzl r0 = r0.zzo
            if (r0 == 0) goto L_0x0022
            boolean r0 = r0.zzh
            if (r0 == 0) goto L_0x0022
            r0 = r1
            goto L_0x0023
        L_0x0022:
            r0 = r2
        L_0x0023:
            com.google.android.gms.internal.ads.zzbce r3 = com.google.android.gms.internal.ads.zzbcn.zzbg
            com.google.android.gms.internal.ads.zzbcl r4 = com.google.android.gms.ads.internal.client.zzbe.zzc()
            java.lang.Object r3 = r4.zza(r3)
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            boolean r3 = r3.booleanValue()
            if (r3 == 0) goto L_0x0043
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r3 = r6.zzc
            if (r3 == 0) goto L_0x0043
            com.google.android.gms.ads.internal.zzl r3 = r3.zzo
            if (r3 == 0) goto L_0x0043
            boolean r3 = r3.zzi
            if (r3 == 0) goto L_0x0043
            r3 = r1
            goto L_0x0044
        L_0x0043:
            r3 = r2
        L_0x0044:
            if (r7 == 0) goto L_0x005a
            if (r8 == 0) goto L_0x005a
            if (r0 == 0) goto L_0x005a
            if (r3 != 0) goto L_0x005a
            com.google.android.gms.internal.ads.zzbsk r7 = new com.google.android.gms.internal.ads.zzbsk
            com.google.android.gms.internal.ads.zzcfk r4 = r6.zzd
            java.lang.String r5 = "useCustomClose"
            r7.<init>(r4, r5)
            java.lang.String r4 = "Custom close has been disabled for interstitial ads in this ad slot."
            r7.zzh(r4)
        L_0x005a:
            com.google.android.gms.ads.internal.overlay.zzu r7 = r6.zzf
            if (r7 == 0) goto L_0x0069
            if (r3 != 0) goto L_0x0066
            if (r8 == 0) goto L_0x0065
            if (r0 != 0) goto L_0x0065
            goto L_0x0066
        L_0x0065:
            r1 = r2
        L_0x0066:
            r7.zzb(r1)
        L_0x0069:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.overlay.zzm.zzy(boolean, boolean):void");
    }

    public final void zzz() {
        this.zzl.removeView(this.zzf);
        zzw(true);
    }
}
