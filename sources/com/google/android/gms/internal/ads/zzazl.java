package com.google.android.gms.internal.ads;

import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.TextView;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.common.util.PlatformVersion;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONException;
import org.json.JSONObject;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzazl extends Thread {
    private boolean zza = false;
    private boolean zzb = false;
    private final Object zzc;
    private final zzazc zzd;
    private final int zze;
    private final int zzf;
    private final int zzg;
    private final int zzh;
    private final int zzi;
    private final int zzj;
    private final int zzk;
    private final int zzl;
    private final String zzm;
    private final boolean zzn;
    private final boolean zzo;

    public zzazl() {
        zzazc zzazc = new zzazc();
        this.zzd = zzazc;
        this.zzc = new Object();
        this.zzf = ((Long) zzbee.zzd.zze()).intValue();
        this.zzg = ((Long) zzbee.zza.zze()).intValue();
        this.zzh = ((Long) zzbee.zze.zze()).intValue();
        this.zzi = ((Long) zzbee.zzc.zze()).intValue();
        this.zzj = ((Integer) zzbe.zzc().zza(zzbcn.zzab)).intValue();
        this.zzk = ((Integer) zzbe.zzc().zza(zzbcn.zzac)).intValue();
        this.zzl = ((Integer) zzbe.zzc().zza(zzbcn.zzad)).intValue();
        this.zze = ((Long) zzbee.zzf.zze()).intValue();
        this.zzm = (String) zzbe.zzc().zza(zzbcn.zzaf);
        this.zzn = ((Boolean) zzbe.zzc().zza(zzbcn.zzag)).booleanValue();
        this.zzo = ((Boolean) zzbe.zzc().zza(zzbcn.zzah)).booleanValue();
        ((Boolean) zzbe.zzc().zza(zzbcn.zzai)).booleanValue();
        setName("ContentFetchTask");
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processHandlersOutBlocks(RegionMaker.java:1008)
        	at jadx.core.dex.visitors.regions.RegionMaker.processTryCatchBlocks(RegionMaker.java:978)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
        */
    /* JADX WARNING: Missing exception handler attribute for start block: B:48:0x00dc */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00dc A[LOOP:2: B:48:0x00dc->B:62:0x00dc, LOOP_START, SYNTHETIC] */
    public final void run() {
        /*
            r6 = this;
        L_0x0000:
            com.google.android.gms.internal.ads.zzazg r0 = com.google.android.gms.ads.internal.zzv.zzb()     // Catch:{ all -> 0x00a8 }
            android.content.Context r0 = r0.zzb()     // Catch:{ all -> 0x00a8 }
            if (r0 != 0) goto L_0x000c
            goto L_0x00b2
        L_0x000c:
            java.lang.String r1 = "activity"
            java.lang.Object r1 = r0.getSystemService(r1)     // Catch:{ all -> 0x00a8 }
            android.app.ActivityManager r1 = (android.app.ActivityManager) r1     // Catch:{ all -> 0x00a8 }
            java.lang.String r2 = "keyguard"
            java.lang.Object r2 = r0.getSystemService(r2)     // Catch:{ all -> 0x00a8 }
            android.app.KeyguardManager r2 = (android.app.KeyguardManager) r2     // Catch:{ all -> 0x00a8 }
            if (r1 == 0) goto L_0x00b2
            if (r2 == 0) goto L_0x00b2
            java.util.List r1 = r1.getRunningAppProcesses()     // Catch:{ all -> 0x00a8 }
            if (r1 == 0) goto L_0x00b2
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x00a8 }
        L_0x002a:
            boolean r3 = r1.hasNext()     // Catch:{ all -> 0x00a8 }
            if (r3 == 0) goto L_0x00b2
            java.lang.Object r3 = r1.next()     // Catch:{ all -> 0x00a8 }
            android.app.ActivityManager$RunningAppProcessInfo r3 = (android.app.ActivityManager.RunningAppProcessInfo) r3     // Catch:{ all -> 0x00a8 }
            int r4 = android.os.Process.myPid()     // Catch:{ all -> 0x00a8 }
            int r5 = r3.pid     // Catch:{ all -> 0x00a8 }
            if (r4 != r5) goto L_0x002a
            int r1 = r3.importance     // Catch:{ all -> 0x00a8 }
            r3 = 100
            if (r1 != r3) goto L_0x00b2
            boolean r1 = r2.inKeyguardRestrictedInputMode()     // Catch:{ all -> 0x00a8 }
            if (r1 != 0) goto L_0x00b2
            java.lang.String r1 = "power"
            java.lang.Object r0 = r0.getSystemService(r1)     // Catch:{ all -> 0x00a8 }
            android.os.PowerManager r0 = (android.os.PowerManager) r0     // Catch:{ all -> 0x00a8 }
            if (r0 == 0) goto L_0x00b2
            boolean r0 = r0.isScreenOn()     // Catch:{ all -> 0x00a8 }
            if (r0 == 0) goto L_0x00b2
            com.google.android.gms.internal.ads.zzazg r0 = com.google.android.gms.ads.internal.zzv.zzb()     // Catch:{ InterruptedException -> 0x00d3, Exception -> 0x00c3 }
            android.app.Activity r0 = r0.zza()     // Catch:{ InterruptedException -> 0x00d3, Exception -> 0x00c3 }
            if (r0 != 0) goto L_0x006d
            java.lang.String r0 = "ContentFetchThread: no activity. Sleeping."
            com.google.android.gms.ads.internal.util.client.zzm.zze(r0)     // Catch:{ InterruptedException -> 0x00d3, Exception -> 0x00c3 }
            r6.zze()     // Catch:{ InterruptedException -> 0x00d3, Exception -> 0x00c3 }
            goto L_0x00ba
        L_0x006d:
            r1 = 0
            android.view.Window r2 = r0.getWindow()     // Catch:{ Exception -> 0x008e }
            if (r2 == 0) goto L_0x009d
            android.view.Window r2 = r0.getWindow()     // Catch:{ Exception -> 0x008e }
            android.view.View r2 = r2.getDecorView()     // Catch:{ Exception -> 0x008e }
            if (r2 == 0) goto L_0x009d
            android.view.Window r0 = r0.getWindow()     // Catch:{ Exception -> 0x008e }
            android.view.View r0 = r0.getDecorView()     // Catch:{ Exception -> 0x008e }
            r2 = 16908290(0x1020002, float:2.3877235E-38)
            android.view.View r1 = r0.findViewById(r2)     // Catch:{ Exception -> 0x008e }
            goto L_0x009d
        L_0x008e:
            r0 = move-exception
            com.google.android.gms.internal.ads.zzbzz r2 = com.google.android.gms.ads.internal.zzv.zzp()     // Catch:{ InterruptedException -> 0x00d3, Exception -> 0x00c3 }
            java.lang.String r3 = "ContentFetchTask.extractContent"
            r2.zzw(r0, r3)     // Catch:{ InterruptedException -> 0x00d3, Exception -> 0x00c3 }
            java.lang.String r0 = "Failed getting root view of activity. Content not extracted."
            com.google.android.gms.ads.internal.util.client.zzm.zze(r0)     // Catch:{ InterruptedException -> 0x00d3, Exception -> 0x00c3 }
        L_0x009d:
            if (r1 == 0) goto L_0x00ba
            com.google.android.gms.internal.ads.zzazh r0 = new com.google.android.gms.internal.ads.zzazh     // Catch:{ InterruptedException -> 0x00d3, Exception -> 0x00c3 }
            r0.<init>(r6, r1)     // Catch:{ InterruptedException -> 0x00d3, Exception -> 0x00c3 }
            r1.post(r0)     // Catch:{ InterruptedException -> 0x00d3, Exception -> 0x00c3 }
            goto L_0x00ba
        L_0x00a8:
            r0 = move-exception
            com.google.android.gms.internal.ads.zzbzz r1 = com.google.android.gms.ads.internal.zzv.zzp()     // Catch:{ InterruptedException -> 0x00d3, Exception -> 0x00c3 }
            java.lang.String r2 = "ContentFetchTask.isInForeground"
            r1.zzw(r0, r2)     // Catch:{ InterruptedException -> 0x00d3, Exception -> 0x00c3 }
        L_0x00b2:
            java.lang.String r0 = "ContentFetchTask: sleeping"
            com.google.android.gms.ads.internal.util.client.zzm.zze(r0)     // Catch:{ InterruptedException -> 0x00d3, Exception -> 0x00c3 }
            r6.zze()     // Catch:{ InterruptedException -> 0x00d3, Exception -> 0x00c3 }
        L_0x00ba:
            int r0 = r6.zze     // Catch:{ InterruptedException -> 0x00d3, Exception -> 0x00c3 }
            int r0 = r0 * 1000
            long r0 = (long) r0     // Catch:{ InterruptedException -> 0x00d3, Exception -> 0x00c3 }
            java.lang.Thread.sleep(r0)     // Catch:{ InterruptedException -> 0x00d3, Exception -> 0x00c3 }
            goto L_0x00d9
        L_0x00c3:
            r0 = move-exception
            java.lang.String r1 = "Error in ContentFetchTask"
            com.google.android.gms.ads.internal.util.client.zzm.zzh(r1, r0)
            java.lang.String r1 = "ContentFetchTask.run"
            com.google.android.gms.internal.ads.zzbzz r2 = com.google.android.gms.ads.internal.zzv.zzp()
            r2.zzw(r0, r1)
            goto L_0x00d9
        L_0x00d3:
            r0 = move-exception
            java.lang.String r1 = "Error in ContentFetchTask"
            com.google.android.gms.ads.internal.util.client.zzm.zzh(r1, r0)
        L_0x00d9:
            java.lang.Object r0 = r6.zzc
            monitor-enter(r0)
        L_0x00dc:
            boolean r1 = r6.zzb     // Catch:{ all -> 0x00ee }
            if (r1 == 0) goto L_0x00eb
            java.lang.String r1 = "ContentFetchTask: waiting"
            com.google.android.gms.ads.internal.util.client.zzm.zze(r1)     // Catch:{ InterruptedException -> 0x00dc }
            java.lang.Object r1 = r6.zzc     // Catch:{ InterruptedException -> 0x00dc }
            r1.wait()     // Catch:{ InterruptedException -> 0x00dc }
            goto L_0x00dc
        L_0x00eb:
            monitor-exit(r0)     // Catch:{ all -> 0x00ee }
            goto L_0x0000
        L_0x00ee:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00ee }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzazl.run():void");
    }

    /* access modifiers changed from: package-private */
    public final zzazk zza(View view, zzazb zzazb) {
        if (view != null) {
            boolean globalVisibleRect = view.getGlobalVisibleRect(new Rect());
            if (!(view instanceof TextView) || (view instanceof EditText)) {
                zzazb zzazb2 = zzazb;
                if ((view instanceof WebView) && !(view instanceof zzcfk)) {
                    WebView webView = (WebView) view;
                    if (PlatformVersion.isAtLeastKitKat()) {
                        zzazb2.zzf();
                        webView.post(new zzazj(this, zzazb2, webView, globalVisibleRect));
                        return new zzazk(this, 0, 1);
                    }
                } else if (view instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    int i = 0;
                    int i2 = 0;
                    for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                        zzazk zza2 = zza(viewGroup.getChildAt(i3), zzazb2);
                        i += zza2.zza;
                        i2 += zza2.zzb;
                    }
                    return new zzazk(this, i, i2);
                }
            } else {
                CharSequence text = ((TextView) view).getText();
                if (!TextUtils.isEmpty(text)) {
                    zzazb.zzh(text.toString(), globalVisibleRect, view.getX(), view.getY(), (float) view.getWidth(), (float) view.getHeight());
                    return new zzazk(this, 1, 0);
                }
            }
        }
        return new zzazk(this, 0, 0);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x006b, code lost:
        if (r10 == 0) goto L_0x006d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzb(android.view.View r10) {
        /*
            r9 = this;
            com.google.android.gms.internal.ads.zzazb r0 = new com.google.android.gms.internal.ads.zzazb     // Catch:{ Exception -> 0x007d }
            int r1 = r9.zzf     // Catch:{ Exception -> 0x007d }
            int r2 = r9.zzg     // Catch:{ Exception -> 0x007d }
            int r3 = r9.zzh     // Catch:{ Exception -> 0x007d }
            int r4 = r9.zzi     // Catch:{ Exception -> 0x007d }
            int r5 = r9.zzj     // Catch:{ Exception -> 0x007d }
            int r6 = r9.zzk     // Catch:{ Exception -> 0x007d }
            int r7 = r9.zzl     // Catch:{ Exception -> 0x007d }
            boolean r8 = r9.zzo     // Catch:{ Exception -> 0x007d }
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x007d }
            com.google.android.gms.internal.ads.zzazg r1 = com.google.android.gms.ads.internal.zzv.zzb()     // Catch:{ Exception -> 0x007d }
            android.content.Context r1 = r1.zzb()     // Catch:{ Exception -> 0x007d }
            if (r1 == 0) goto L_0x0051
            java.lang.String r2 = r9.zzm     // Catch:{ Exception -> 0x007d }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x007d }
            if (r2 != 0) goto L_0x0051
            android.content.res.Resources r2 = r1.getResources()     // Catch:{ Exception -> 0x007d }
            com.google.android.gms.internal.ads.zzbce r3 = com.google.android.gms.internal.ads.zzbcn.zzae     // Catch:{ Exception -> 0x007d }
            com.google.android.gms.internal.ads.zzbcl r4 = com.google.android.gms.ads.internal.client.zzbe.zzc()     // Catch:{ Exception -> 0x007d }
            java.lang.Object r3 = r4.zza(r3)     // Catch:{ Exception -> 0x007d }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ Exception -> 0x007d }
            java.lang.String r4 = "id"
            java.lang.String r1 = r1.getPackageName()     // Catch:{ Exception -> 0x007d }
            int r1 = r2.getIdentifier(r3, r4, r1)     // Catch:{ Exception -> 0x007d }
            java.lang.Object r1 = r10.getTag(r1)     // Catch:{ Exception -> 0x007d }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ Exception -> 0x007d }
            if (r1 == 0) goto L_0x0051
            java.lang.String r2 = r9.zzm     // Catch:{ Exception -> 0x007d }
            boolean r1 = r1.equals(r2)     // Catch:{ Exception -> 0x007d }
            if (r1 != 0) goto L_0x0076
        L_0x0051:
            com.google.android.gms.internal.ads.zzazk r10 = r9.zza(r10, r0)     // Catch:{ Exception -> 0x007d }
            r0.zzj()     // Catch:{ Exception -> 0x007d }
            int r1 = r10.zza     // Catch:{ Exception -> 0x007d }
            if (r1 != 0) goto L_0x0060
            int r1 = r10.zzb     // Catch:{ Exception -> 0x007d }
            if (r1 == 0) goto L_0x0076
        L_0x0060:
            int r10 = r10.zzb     // Catch:{ Exception -> 0x007d }
            if (r10 != 0) goto L_0x006b
            int r10 = r0.zzb()     // Catch:{ Exception -> 0x007d }
            if (r10 == 0) goto L_0x0076
            goto L_0x006d
        L_0x006b:
            if (r10 != 0) goto L_0x0077
        L_0x006d:
            com.google.android.gms.internal.ads.zzazc r10 = r9.zzd     // Catch:{ Exception -> 0x007d }
            boolean r10 = r10.zzc(r0)     // Catch:{ Exception -> 0x007d }
            if (r10 != 0) goto L_0x0076
            goto L_0x0077
        L_0x0076:
            return
        L_0x0077:
            com.google.android.gms.internal.ads.zzazc r10 = r9.zzd     // Catch:{ Exception -> 0x007d }
            r10.zza(r0)     // Catch:{ Exception -> 0x007d }
            return
        L_0x007d:
            r0 = move-exception
            r10 = r0
            java.lang.String r0 = "Exception in fetchContentOnUIThread"
            com.google.android.gms.ads.internal.util.client.zzm.zzh(r0, r10)
            java.lang.String r0 = "ContentFetchTask.fetchContent"
            com.google.android.gms.internal.ads.zzbzz r1 = com.google.android.gms.ads.internal.zzv.zzp()
            r1.zzw(r10, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzazl.zzb(android.view.View):void");
    }

    /* access modifiers changed from: package-private */
    public final void zzc(zzazb zzazb, WebView webView, String str, boolean z) {
        zzazb zzazb2;
        zzazb.zze();
        try {
            if (!TextUtils.isEmpty(str)) {
                String optString = new JSONObject(str).optString("text");
                if (this.zzn || TextUtils.isEmpty(webView.getTitle())) {
                    zzazb2 = zzazb;
                    zzazb2.zzi(optString, z, webView.getX(), webView.getY(), (float) webView.getWidth(), (float) webView.getHeight());
                } else {
                    String title = webView.getTitle();
                    zzazb zzazb3 = zzazb;
                    zzazb3.zzi(title + "\n" + optString, z, webView.getX(), webView.getY(), (float) webView.getWidth(), (float) webView.getHeight());
                    zzazb2 = zzazb3;
                }
            } else {
                zzazb2 = zzazb;
            }
            if (zzazb2.zzl()) {
                this.zzd.zzb(zzazb2);
            }
        } catch (JSONException unused) {
            zzm.zze("Json string may be malformed.");
        } catch (Throwable th) {
            Throwable th2 = th;
            zzm.zzf("Failed to get webview content.", th2);
            zzv.zzp().zzw(th2, "ContentFetchTask.processWebViewContent");
        }
    }

    public final void zzd() {
        synchronized (this.zzc) {
            if (this.zza) {
                zzm.zze("Content hash thread already started, quitting...");
                return;
            }
            this.zza = true;
            start();
        }
    }

    public final void zze() {
        synchronized (this.zzc) {
            this.zzb = true;
            zzm.zze("ContentFetchThread: paused, pause = true");
        }
    }
}
