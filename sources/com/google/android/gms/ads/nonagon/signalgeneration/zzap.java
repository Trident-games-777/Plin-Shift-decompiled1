package com.google.android.gms.ads.nonagon.signalgeneration;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import androidx.browser.customtabs.CustomTabsCallback;
import androidx.browser.customtabs.CustomTabsClient;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.client.zzm;
import com.google.android.gms.ads.internal.client.zzs;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.zzbu;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzavc;
import com.google.android.gms.internal.ads.zzavd;
import com.google.android.gms.internal.ads.zzbcn;
import com.google.android.gms.internal.ads.zzbds;
import com.google.android.gms.internal.ads.zzbeg;
import com.google.android.gms.internal.ads.zzbes;
import com.google.android.gms.internal.ads.zzbtv;
import com.google.android.gms.internal.ads.zzbue;
import com.google.android.gms.internal.ads.zzbze;
import com.google.android.gms.internal.ads.zzbzg;
import com.google.android.gms.internal.ads.zzbzl;
import com.google.android.gms.internal.ads.zzcaj;
import com.google.android.gms.internal.ads.zzchk;
import com.google.android.gms.internal.ads.zzdoc;
import com.google.android.gms.internal.ads.zzdrv;
import com.google.android.gms.internal.ads.zzdsr;
import com.google.android.gms.internal.ads.zzffs;
import com.google.android.gms.internal.ads.zzfgn;
import com.google.android.gms.internal.ads.zzfjz;
import com.google.android.gms.internal.ads.zzfka;
import com.google.android.gms.internal.ads.zzfkl;
import com.google.android.gms.internal.ads.zzfko;
import com.google.android.gms.internal.ads.zzflr;
import com.google.android.gms.internal.ads.zzfxf;
import com.google.android.gms.internal.ads.zzgdz;
import com.google.android.gms.internal.ads.zzgei;
import com.google.android.gms.internal.ads.zzges;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzap extends zzbzg {
    protected static final List zza = new ArrayList(Arrays.asList(new String[]{"/aclk", "/pcs/click", "/dbm/clk"}));
    protected static final List zzb = new ArrayList(Arrays.asList(new String[]{".doubleclick.net", ".googleadservices.com"}));
    protected static final List zzc = new ArrayList(Arrays.asList(new String[]{"/pagead/adview", "/pcs/view", "/pagead/conversion", "/dbm/ad"}));
    protected static final List zzd = new ArrayList(Arrays.asList(new String[]{".doubleclick.net", ".googleadservices.com", ".googlesyndication.com"}));
    public static final /* synthetic */ int zze = 0;
    /* access modifiers changed from: private */
    public final String zzA;
    private final List zzB;
    private final List zzC;
    private final List zzD;
    private final List zzE;
    private final AtomicBoolean zzF = new AtomicBoolean(false);
    /* access modifiers changed from: private */
    public final AtomicBoolean zzG = new AtomicBoolean(false);
    /* access modifiers changed from: private */
    public final AtomicInteger zzH = new AtomicInteger(0);
    private final zzbds zzI;
    private final zzj zzJ;
    private final zza zzK;
    private final zzchk zzf;
    /* access modifiers changed from: private */
    public Context zzg;
    private final zzavc zzh;
    private final zzffs zzi;
    private final zzfgn zzj;
    private final zzges zzk;
    private final ScheduledExecutorService zzl;
    private zzbue zzm;
    private Point zzn = new Point();
    private Point zzo = new Point();
    /* access modifiers changed from: private */
    public final zzdsr zzp;
    /* access modifiers changed from: private */
    public final zzflr zzq;
    /* access modifiers changed from: private */
    public final boolean zzr;
    /* access modifiers changed from: private */
    public final boolean zzs;
    /* access modifiers changed from: private */
    public final boolean zzt;
    /* access modifiers changed from: private */
    public final boolean zzu;
    /* access modifiers changed from: private */
    public final String zzv;
    /* access modifiers changed from: private */
    public final String zzw;
    /* access modifiers changed from: private */
    public final AtomicInteger zzx = new AtomicInteger(0);
    /* access modifiers changed from: private */
    public final VersionInfoParcel zzy;
    /* access modifiers changed from: private */
    public String zzz;

    public zzap(zzchk zzchk, Context context, zzavc zzavc, zzfgn zzfgn, zzges zzges, ScheduledExecutorService scheduledExecutorService, zzdsr zzdsr, zzflr zzflr, VersionInfoParcel versionInfoParcel, zzbds zzbds, zzffs zzffs, zzj zzj2, zza zza2) {
        List list;
        this.zzf = zzchk;
        this.zzg = context;
        this.zzh = zzavc;
        this.zzi = zzffs;
        this.zzj = zzfgn;
        this.zzk = zzges;
        this.zzl = scheduledExecutorService;
        this.zzp = zzdsr;
        this.zzq = zzflr;
        this.zzy = versionInfoParcel;
        this.zzI = zzbds;
        this.zzr = ((Boolean) zzbe.zzc().zza(zzbcn.zzgV)).booleanValue();
        this.zzs = ((Boolean) zzbe.zzc().zza(zzbcn.zzgU)).booleanValue();
        this.zzt = ((Boolean) zzbe.zzc().zza(zzbcn.zzgX)).booleanValue();
        this.zzu = ((Boolean) zzbe.zzc().zza(zzbcn.zzgZ)).booleanValue();
        this.zzv = (String) zzbe.zzc().zza(zzbcn.zzgY);
        this.zzw = (String) zzbe.zzc().zza(zzbcn.zzha);
        this.zzA = (String) zzbe.zzc().zza(zzbcn.zzhb);
        this.zzJ = zzj2;
        this.zzK = zza2;
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzhc)).booleanValue()) {
            this.zzB = zzaa((String) zzbe.zzc().zza(zzbcn.zzhd));
            this.zzC = zzaa((String) zzbe.zzc().zza(zzbcn.zzhe));
            this.zzD = zzaa((String) zzbe.zzc().zza(zzbcn.zzhf));
            list = zzaa((String) zzbe.zzc().zza(zzbcn.zzhg));
        } else {
            this.zzB = zza;
            this.zzC = zzb;
            this.zzD = zzc;
            list = zzd;
        }
        this.zzE = list;
    }

    static /* bridge */ /* synthetic */ void zzH(zzap zzap, List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (zzap.zzO((Uri) it.next())) {
                zzap.zzx.getAndIncrement();
                return;
            }
        }
    }

    static final /* synthetic */ Uri zzQ(Uri uri, String str) {
        return !TextUtils.isEmpty(str) ? zzZ(uri, "nas", str) : uri;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.google.android.gms.ads.nonagon.signalgeneration.zzx zzR(android.content.Context r8, java.lang.String r9, java.lang.String r10, com.google.android.gms.ads.internal.client.zzs r11, com.google.android.gms.ads.internal.client.zzm r12, android.os.Bundle r13) {
        /*
            r7 = this;
            com.google.android.gms.internal.ads.zzffm r0 = new com.google.android.gms.internal.ads.zzffm
            r0.<init>()
            java.lang.String r1 = "REWARDED"
            boolean r2 = r1.equals(r10)
            java.lang.String r3 = "REWARDED_INTERSTITIAL"
            r4 = 3
            r5 = 2
            if (r2 == 0) goto L_0x0019
            com.google.android.gms.internal.ads.zzfez r2 = r0.zzp()
            r2.zza(r5)
            goto L_0x0026
        L_0x0019:
            boolean r2 = r3.equals(r10)
            if (r2 == 0) goto L_0x0026
            com.google.android.gms.internal.ads.zzfez r2 = r0.zzp()
            r2.zza(r4)
        L_0x0026:
            com.google.android.gms.internal.ads.zzchk r2 = r7.zzf
            com.google.android.gms.ads.nonagon.signalgeneration.zzw r2 = r2.zzp()
            com.google.android.gms.internal.ads.zzcvu r6 = new com.google.android.gms.internal.ads.zzcvu
            r6.<init>()
            r6.zze(r8)
            if (r9 != 0) goto L_0x0038
            java.lang.String r9 = "adUnitId"
        L_0x0038:
            r0.zzt(r9)
            if (r12 != 0) goto L_0x0046
            com.google.android.gms.ads.internal.client.zzn r9 = new com.google.android.gms.ads.internal.client.zzn
            r9.<init>()
            com.google.android.gms.ads.internal.client.zzm r12 = r9.zza()
        L_0x0046:
            r0.zzH(r12)
            r9 = 1
            if (r11 != 0) goto L_0x00aa
            int r11 = r10.hashCode()
            r12 = 4
            switch(r11) {
                case -1999289321: goto L_0x0079;
                case -428325382: goto L_0x006f;
                case 543046670: goto L_0x0067;
                case 1854800829: goto L_0x005f;
                case 1951953708: goto L_0x0055;
                default: goto L_0x0054;
            }
        L_0x0054:
            goto L_0x0083
        L_0x0055:
            java.lang.String r11 = "BANNER"
            boolean r11 = r10.equals(r11)
            if (r11 == 0) goto L_0x0083
            r11 = 0
            goto L_0x0084
        L_0x005f:
            boolean r11 = r10.equals(r3)
            if (r11 == 0) goto L_0x0083
            r11 = r5
            goto L_0x0084
        L_0x0067:
            boolean r11 = r10.equals(r1)
            if (r11 == 0) goto L_0x0083
            r11 = r9
            goto L_0x0084
        L_0x006f:
            java.lang.String r11 = "APP_OPEN_AD"
            boolean r11 = r10.equals(r11)
            if (r11 == 0) goto L_0x0083
            r11 = r12
            goto L_0x0084
        L_0x0079:
            java.lang.String r11 = "NATIVE"
            boolean r11 = r10.equals(r11)
            if (r11 == 0) goto L_0x0083
            r11 = r4
            goto L_0x0084
        L_0x0083:
            r11 = -1
        L_0x0084:
            if (r11 == 0) goto L_0x00a3
            if (r11 == r9) goto L_0x009e
            if (r11 == r5) goto L_0x009e
            if (r11 == r4) goto L_0x0099
            if (r11 == r12) goto L_0x0094
            com.google.android.gms.ads.internal.client.zzs r11 = new com.google.android.gms.ads.internal.client.zzs
            r11.<init>()
            goto L_0x00aa
        L_0x0094:
            com.google.android.gms.ads.internal.client.zzs r11 = com.google.android.gms.ads.internal.client.zzs.zzb()
            goto L_0x00aa
        L_0x0099:
            com.google.android.gms.ads.internal.client.zzs r11 = com.google.android.gms.ads.internal.client.zzs.zzc()
            goto L_0x00aa
        L_0x009e:
            com.google.android.gms.ads.internal.client.zzs r11 = com.google.android.gms.ads.internal.client.zzs.zzd()
            goto L_0x00aa
        L_0x00a3:
            com.google.android.gms.ads.internal.client.zzs r11 = new com.google.android.gms.ads.internal.client.zzs
            com.google.android.gms.ads.AdSize r12 = com.google.android.gms.ads.AdSize.BANNER
            r11.<init>((android.content.Context) r8, (com.google.android.gms.ads.AdSize) r12)
        L_0x00aa:
            r0.zzs(r11)
            r0.zzz(r9)
            r0.zzA(r13)
            com.google.android.gms.internal.ads.zzffo r8 = r0.zzJ()
            r6.zzi(r8)
            com.google.android.gms.internal.ads.zzcvw r8 = r6.zzj()
            r2.zza(r8)
            com.google.android.gms.ads.nonagon.signalgeneration.zzas r8 = new com.google.android.gms.ads.nonagon.signalgeneration.zzas
            r8.<init>()
            r8.zza(r10)
            com.google.android.gms.ads.nonagon.signalgeneration.zzau r9 = new com.google.android.gms.ads.nonagon.signalgeneration.zzau
            r10 = 0
            r9.<init>(r8, r10)
            r2.zzb(r9)
            com.google.android.gms.internal.ads.zzdcd r8 = new com.google.android.gms.internal.ads.zzdcd
            r8.<init>()
            com.google.android.gms.ads.nonagon.signalgeneration.zzx r8 = r2.zzc()
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.nonagon.signalgeneration.zzap.zzR(android.content.Context, java.lang.String, java.lang.String, com.google.android.gms.ads.internal.client.zzs, com.google.android.gms.ads.internal.client.zzm, android.os.Bundle):com.google.android.gms.ads.nonagon.signalgeneration.zzx");
    }

    private final ListenableFuture zzS(String str) {
        zzdoc[] zzdocArr = new zzdoc[1];
        ListenableFuture zzn2 = zzgei.zzn(this.zzj.zza(), new zzaa(this, zzdocArr, str), this.zzk);
        zzn2.addListener(new zzab(this, zzdocArr), this.zzk);
        return (zzgdz) zzgei.zze((zzgdz) zzgei.zzm((zzgdz) zzgei.zzo(zzgdz.zzu(zzn2), (long) ((Integer) zzbe.zzc().zza(zzbcn.zzhn)).intValue(), TimeUnit.MILLISECONDS, this.zzl), new zzah(), this.zzk), Exception.class, new zzai(), this.zzk);
    }

    /* access modifiers changed from: private */
    public final void zzT() {
        zzap zzap;
        ListenableFuture listenableFuture;
        if (((Boolean) zzbes.zzb.zze()).booleanValue()) {
            this.zzJ.zzb();
            return;
        }
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzkK)).booleanValue()) {
            listenableFuture = zzgei.zzk(new zzy(this), zzcaj.zza);
            zzap = this;
        } else {
            zzap = this;
            listenableFuture = zzap.zzR(this.zzg, (String) null, AdFormat.BANNER.name(), (zzs) null, (zzm) null, new Bundle()).zzb();
        }
        zzgei.zzr(listenableFuture, new zzao(this), zzap.zzf.zzC());
    }

    private final void zzU() {
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzjg)).booleanValue()) {
            if (!((Boolean) zzbe.zzc().zza(zzbcn.zzjj)).booleanValue()) {
                if (!((Boolean) zzbe.zzc().zza(zzbcn.zzjn)).booleanValue() || !this.zzF.getAndSet(true)) {
                    zzT();
                }
            }
        }
    }

    private final void zzV(List list, IObjectWrapper iObjectWrapper, zzbtv zzbtv, boolean z) {
        ListenableFuture listenableFuture;
        if (!((Boolean) zzbe.zzc().zza(zzbcn.zzhm)).booleanValue()) {
            com.google.android.gms.ads.internal.util.client.zzm.zzj("The updating URL feature is not enabled.");
            try {
                zzbtv.zze("The updating URL feature is not enabled.");
            } catch (RemoteException e) {
                com.google.android.gms.ads.internal.util.client.zzm.zzh("", e);
            }
        } else {
            Iterator it = list.iterator();
            int i = 0;
            while (it.hasNext()) {
                if (zzO((Uri) it.next())) {
                    i++;
                }
            }
            if (i > 1) {
                com.google.android.gms.ads.internal.util.client.zzm.zzj("Multiple google urls found: ".concat(String.valueOf(String.valueOf(list))));
            }
            ArrayList arrayList = new ArrayList();
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                Uri uri = (Uri) it2.next();
                if (!zzO(uri)) {
                    com.google.android.gms.ads.internal.util.client.zzm.zzj("Not a Google URL: ".concat(String.valueOf(String.valueOf(uri))));
                    listenableFuture = zzgei.zzh(uri);
                } else {
                    listenableFuture = this.zzk.zzb(new zzac(this, uri, iObjectWrapper));
                    if (zzY()) {
                        listenableFuture = zzgei.zzn(listenableFuture, new zzad(this), this.zzk);
                    } else {
                        com.google.android.gms.ads.internal.util.client.zzm.zzi("Asset view map is empty.");
                    }
                }
                arrayList.add(listenableFuture);
            }
            zzgei.zzr(zzgei.zzd(arrayList), new zzan(this, zzbtv, z), this.zzf.zzC());
        }
    }

    private final void zzW(List list, IObjectWrapper iObjectWrapper, zzbtv zzbtv, boolean z) {
        if (!((Boolean) zzbe.zzc().zza(zzbcn.zzhm)).booleanValue()) {
            try {
                zzbtv.zze("The updating URL feature is not enabled.");
            } catch (RemoteException e) {
                com.google.android.gms.ads.internal.util.client.zzm.zzh("", e);
            }
        } else {
            ListenableFuture zzb2 = this.zzk.zzb(new zzaj(this, list, iObjectWrapper));
            if (zzY()) {
                zzb2 = zzgei.zzn(zzb2, new zzak(this), this.zzk);
            } else {
                com.google.android.gms.ads.internal.util.client.zzm.zzi("Asset view map is empty.");
            }
            zzgei.zzr(zzb2, new zzam(this, zzbtv, z), this.zzf.zzC());
        }
    }

    private static boolean zzX(Uri uri, List list, List list2) {
        String host = uri.getHost();
        String path = uri.getPath();
        if (!(host == null || path == null)) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (path.contains((String) it.next())) {
                    Iterator it2 = list2.iterator();
                    while (it2.hasNext()) {
                        if (host.endsWith((String) it2.next())) {
                            return true;
                        }
                    }
                    continue;
                }
            }
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.zzb;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean zzY() {
        /*
            r1 = this;
            com.google.android.gms.internal.ads.zzbue r0 = r1.zzm
            if (r0 == 0) goto L_0x0010
            java.util.Map r0 = r0.zzb
            if (r0 == 0) goto L_0x0010
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x0010
            r0 = 1
            return r0
        L_0x0010:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.nonagon.signalgeneration.zzap.zzY():boolean");
    }

    /* access modifiers changed from: private */
    public static final Uri zzZ(Uri uri, String str, String str2) {
        String uri2 = uri.toString();
        int indexOf = uri2.indexOf("&adurl=");
        if (indexOf == -1) {
            indexOf = uri2.indexOf("?adurl=");
        }
        if (indexOf == -1) {
            return uri.buildUpon().appendQueryParameter(str, str2).build();
        }
        int i = indexOf + 1;
        return Uri.parse(uri2.substring(0, i) + str + "=" + str2 + "&" + uri2.substring(i));
    }

    private static final List zzaa(String str) {
        String[] split = TextUtils.split(str, ",");
        ArrayList arrayList = new ArrayList();
        for (String str2 : split) {
            if (!zzfxf.zzd(str2)) {
                arrayList.add(str2);
            }
        }
        return arrayList;
    }

    static /* bridge */ /* synthetic */ zzfkl zzr(ListenableFuture listenableFuture, zzbzl zzbzl) {
        String str;
        if (!zzfko.zza() || !((Boolean) zzbeg.zze.zze()).booleanValue()) {
            return null;
        }
        try {
            zzfkl zza2 = ((zzx) zzgei.zzp(listenableFuture)).zza();
            zza2.zzd(new ArrayList(Collections.singletonList(zzbzl.zzb)));
            zzm zzm2 = zzbzl.zzd;
            if (zzm2 == null) {
                str = "";
            } else {
                str = zzm2.zzp;
            }
            zza2.zzb(str);
            zza2.zzf(zzbzl.zzd.zzm);
            return zza2;
        } catch (ExecutionException e) {
            zzv.zzp().zzw(e, "SignalGeneratorImpl.getConfiguredCriticalUserJourney");
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ArrayList zzB(List list, String str) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Uri uri = (Uri) it.next();
            if (!zzP(uri) || TextUtils.isEmpty(str)) {
                arrayList.add(uri);
            } else {
                arrayList.add(zzZ(uri, "nas", str));
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ArrayList zzC(List list, IObjectWrapper iObjectWrapper) throws Exception {
        String zzh2 = this.zzh.zzc() != null ? this.zzh.zzc().zzh(this.zzg, (View) ObjectWrapper.unwrap(iObjectWrapper), (Activity) null) : "";
        if (!TextUtils.isEmpty(zzh2)) {
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Uri uri = (Uri) it.next();
                if (!zzP(uri)) {
                    com.google.android.gms.ads.internal.util.client.zzm.zzj("Not a Google URL: ".concat(String.valueOf(String.valueOf(uri))));
                    arrayList.add(uri);
                } else {
                    arrayList.add(zzZ(uri, "ms", zzh2));
                }
            }
            if (!arrayList.isEmpty()) {
                return arrayList;
            }
            throw new Exception("Empty impression URLs result.");
        }
        throw new Exception("Failed to get view signals.");
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzJ(zzdoc[] zzdocArr) {
        zzdoc zzdoc = zzdocArr[0];
        if (zzdoc != null) {
            this.zzj.zzb(zzgei.zzh(zzdoc));
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean zzO(Uri uri) {
        return zzX(uri, this.zzB, this.zzC);
    }

    /* access modifiers changed from: package-private */
    public final boolean zzP(Uri uri) {
        return zzX(uri, this.zzD, this.zzE);
    }

    public final IObjectWrapper zze(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, String str, IObjectWrapper iObjectWrapper3) {
        if (!((Boolean) zzbe.zzc().zza(zzbcn.zzjt)).booleanValue()) {
            return ObjectWrapper.wrap(null);
        }
        this.zzI.zzg((Context) ObjectWrapper.unwrap(iObjectWrapper), (CustomTabsClient) ObjectWrapper.unwrap(iObjectWrapper2), str, (CustomTabsCallback) ObjectWrapper.unwrap(iObjectWrapper3));
        if (((Boolean) zzbes.zzb.zze()).booleanValue()) {
            this.zzJ.zzb();
        }
        if (((Boolean) zzbes.zza.zze()).booleanValue()) {
            this.zzK.zzb();
        }
        return ObjectWrapper.wrap(this.zzI.zzb());
    }

    public final void zzf(IObjectWrapper iObjectWrapper, zzbzl zzbzl, zzbze zzbze) {
        ListenableFuture listenableFuture;
        ListenableFuture listenableFuture2;
        ListenableFuture listenableFuture3;
        ListenableFuture listenableFuture4;
        Bundle bundle = new Bundle();
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzci)).booleanValue()) {
            bundle.putLong(zzdrv.PUBLIC_API_CALL.zza(), zzbzl.zzd.zzz);
            bundle.putLong(zzdrv.DYNAMITE_ENTER.zza(), zzv.zzC().currentTimeMillis());
        }
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        this.zzg = context;
        zzfka zza2 = zzfjz.zza(context, 22);
        zza2.zzi();
        if ("UNKNOWN".equals(zzbzl.zzb)) {
            List arrayList = new ArrayList();
            if (!((String) zzbe.zzc().zza(zzbcn.zzhl)).isEmpty()) {
                arrayList = Arrays.asList(((String) zzbe.zzc().zza(zzbcn.zzhl)).split(","));
            }
            if (arrayList.contains(zzv.zzc(zzbzl.zzd))) {
                listenableFuture4 = zzgei.zzg(new IllegalArgumentException("Unknown format is no longer supported."));
                listenableFuture3 = zzgei.zzg(new IllegalArgumentException("Unknown format is no longer supported."));
                listenableFuture = listenableFuture3;
                listenableFuture2 = listenableFuture4;
                zzgei.zzr(listenableFuture, new zzal(this, listenableFuture2, zzbzl, zzbze, zza2), this.zzf.zzC());
            }
        }
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzkK)).booleanValue()) {
            listenableFuture4 = zzcaj.zza.zzb(new zzaf(this, zzbzl, bundle));
            listenableFuture3 = zzgei.zzn(listenableFuture4, new zzag(), zzcaj.zza);
            listenableFuture = listenableFuture3;
            listenableFuture2 = listenableFuture4;
            zzgei.zzr(listenableFuture, new zzal(this, listenableFuture2, zzbzl, zzbze, zza2), this.zzf.zzC());
        }
        zzx zzR = zzR(this.zzg, zzbzl.zza, zzbzl.zzb, zzbzl.zzc, zzbzl.zzd, bundle);
        ListenableFuture zzh2 = zzgei.zzh(zzR);
        listenableFuture = zzR.zzb();
        listenableFuture2 = zzh2;
        zzgei.zzr(listenableFuture, new zzal(this, listenableFuture2, zzbzl, zzbze, zza2), this.zzf.zzC());
    }

    public final void zzg(zzbue zzbue) {
        this.zzm = zzbue;
        this.zzj.zzc(1);
    }

    public final void zzh(List list, IObjectWrapper iObjectWrapper, zzbtv zzbtv) {
        zzV(list, iObjectWrapper, zzbtv, true);
    }

    public final void zzi(List list, IObjectWrapper iObjectWrapper, zzbtv zzbtv) {
        zzW(list, iObjectWrapper, zzbtv, true);
    }

    public final void zzj(IObjectWrapper iObjectWrapper) {
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzjf)).booleanValue()) {
            if (!((Boolean) zzbe.zzc().zza(zzbcn.zzhk)).booleanValue()) {
                zzU();
            }
            WebView webView = (WebView) ObjectWrapper.unwrap(iObjectWrapper);
            if (webView == null) {
                com.google.android.gms.ads.internal.util.client.zzm.zzg("The webView cannot be null.");
                return;
            }
            zze zze2 = new zze(webView, this.zzK, zzcaj.zze);
            webView.addJavascriptInterface(new TaggingLibraryJsInterface(webView, this.zzh, this.zzp, this.zzq, this.zzi, this.zzJ, this.zzK, zze2), "gmaSdk");
            if (((Boolean) zzbe.zzc().zza(zzbcn.zzjp)).booleanValue()) {
                zzv.zzp().zzs();
            }
            if (((Boolean) zzbes.zza.zze()).booleanValue()) {
                this.zzK.zzb();
                zzcaj.zzd.scheduleWithFixedDelay(new zzd(zze2), 0, (long) ((Integer) zzbe.zzc().zza(zzbcn.zzjq)).intValue(), TimeUnit.MILLISECONDS);
            }
            if (((Boolean) zzbe.zzc().zza(zzbcn.zzhk)).booleanValue()) {
                zzU();
            }
        }
    }

    public final void zzk(IObjectWrapper iObjectWrapper) {
        View view;
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzhm)).booleanValue()) {
            MotionEvent motionEvent = (MotionEvent) ObjectWrapper.unwrap(iObjectWrapper);
            zzbue zzbue = this.zzm;
            if (zzbue == null) {
                view = null;
            } else {
                view = zzbue.zza;
            }
            this.zzn = zzbu.zza(motionEvent, view);
            if (motionEvent.getAction() == 0) {
                this.zzo = this.zzn;
            }
            MotionEvent obtain = MotionEvent.obtain(motionEvent);
            obtain.setLocation((float) this.zzn.x, (float) this.zzn.y);
            this.zzh.zzd(obtain);
            obtain.recycle();
        }
    }

    public final void zzl(List list, IObjectWrapper iObjectWrapper, zzbtv zzbtv) {
        zzV(list, iObjectWrapper, zzbtv, false);
    }

    public final void zzm(List list, IObjectWrapper iObjectWrapper, zzbtv zzbtv) {
        zzW(list, iObjectWrapper, zzbtv, false);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Uri zzn(Uri uri, IObjectWrapper iObjectWrapper) throws Exception {
        zzffs zzffs;
        try {
            if (!((Boolean) zzbe.zzc().zza(zzbcn.zzlI)).booleanValue() || (zzffs = this.zzi) == null) {
                uri = this.zzh.zza(uri, this.zzg, (View) ObjectWrapper.unwrap(iObjectWrapper), (Activity) null);
            } else {
                uri = zzffs.zza(uri, this.zzg, (View) ObjectWrapper.unwrap(iObjectWrapper), (Activity) null);
            }
        } catch (zzavd e) {
            com.google.android.gms.ads.internal.util.client.zzm.zzk("", e);
        }
        if (uri.getQueryParameter("ms") != null) {
            return uri;
        }
        throw new Exception("Failed to append spam signals to click url.");
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzx zzq(zzbzl zzbzl, Bundle bundle) throws Exception {
        return zzR(this.zzg, zzbzl.zza, zzbzl.zzb, zzbzl.zzc, zzbzl.zzd, bundle);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zzu() throws Exception {
        return zzR(this.zzg, (String) null, AdFormat.BANNER.name(), (zzs) null, (zzm) null, new Bundle()).zzb();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zzv(zzdoc[] zzdocArr, String str, zzdoc zzdoc) throws Exception {
        zzdocArr[0] = zzdoc;
        Context context = this.zzg;
        zzbue zzbue = this.zzm;
        Map map = zzbue.zzb;
        JSONObject zzd2 = zzbu.zzd(context, map, map, zzbue.zza, (ImageView.ScaleType) null);
        JSONObject zzg2 = zzbu.zzg(this.zzg, this.zzm.zza);
        JSONObject zzf2 = zzbu.zzf(this.zzm.zza);
        JSONObject zze2 = zzbu.zze(this.zzg, this.zzm.zza);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("asset_view_signal", zzd2);
        jSONObject.put("ad_view_signal", zzg2);
        jSONObject.put("scroll_view_signal", zzf2);
        jSONObject.put("lock_screen_signal", zze2);
        if ("google.afma.nativeAds.getPublisherCustomRenderedClickSignals".equals(str)) {
            jSONObject.put("click_signal", zzbu.zzc((String) null, this.zzg, this.zzo, this.zzn));
        }
        return zzdoc.zzg(str, jSONObject);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zzw(ArrayList arrayList) throws Exception {
        return zzgei.zzm(zzS("google.afma.nativeAds.getPublisherCustomRenderedImpressionSignals"), new zzz(this, arrayList), this.zzk);
    }
}
