package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import androidx.collection.ArrayMap;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.client.zzdd;
import com.google.android.gms.ads.internal.client.zzdh;
import com.google.android.gms.ads.internal.client.zzdr;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzdit extends zzcrq {
    public static final /* synthetic */ int zzc = 0;
    private final Executor zzd;
    /* access modifiers changed from: private */
    public final zzdiy zze;
    private final zzdjg zzf;
    private final zzdjy zzg;
    private final zzdjd zzh;
    private final zzdjj zzi;
    private final zzhfr zzj;
    private final zzhfr zzk;
    private final zzhfr zzl;
    private final zzhfr zzm;
    private final zzhfr zzn;
    /* access modifiers changed from: private */
    public zzdku zzo;
    private boolean zzp;
    private boolean zzq;
    private boolean zzr;
    private final zzbyr zzs;
    private final zzavc zzt;
    private final VersionInfoParcel zzu;
    private final Context zzv;
    private final zzdiv zzw;
    private final zzemv zzx;
    /* access modifiers changed from: private */
    public final Map zzy = new HashMap();
    private final List zzz = new ArrayList();

    static {
        zzfzo.zzs("3010", "3008", "1005", "1009", "2011", "2007");
    }

    public zzdit(zzcrp zzcrp, Executor executor, zzdiy zzdiy, zzdjg zzdjg, zzdjy zzdjy, zzdjd zzdjd, zzdjj zzdjj, zzhfr zzhfr, zzhfr zzhfr2, zzhfr zzhfr3, zzhfr zzhfr4, zzhfr zzhfr5, zzbyr zzbyr, zzavc zzavc, VersionInfoParcel versionInfoParcel, Context context, zzdiv zzdiv, zzemv zzemv, zzayo zzayo) {
        super(zzcrp);
        this.zzd = executor;
        this.zze = zzdiy;
        this.zzf = zzdjg;
        this.zzg = zzdjy;
        this.zzh = zzdjd;
        this.zzi = zzdjj;
        this.zzj = zzhfr;
        this.zzk = zzhfr2;
        this.zzl = zzhfr3;
        this.zzm = zzhfr4;
        this.zzn = zzhfr5;
        this.zzs = zzbyr;
        this.zzt = zzavc;
        this.zzu = versionInfoParcel;
        this.zzv = context;
        this.zzw = zzdiv;
        this.zzx = zzemv;
    }

    public static boolean zzY(View view) {
        if (!((Boolean) zzbe.zzc().zza(zzbcn.zzkl)).booleanValue()) {
            return view.isShown() && view.getGlobalVisibleRect(new Rect(), (Point) null);
        }
        zzv.zzq();
        long zzw2 = zzs.zzw(view);
        if (view.isShown() && view.getGlobalVisibleRect(new Rect(), (Point) null)) {
            if (zzw2 >= ((long) ((Integer) zzbe.zzc().zza(zzbcn.zzkm)).intValue())) {
                return true;
            }
        }
        return false;
    }

    private final synchronized ImageView.ScaleType zzaa() {
        zzdku zzdku = this.zzo;
        if (zzdku == null) {
            zzm.zze("Ad should be associated with an ad view before calling getMediaviewScaleType()");
            return null;
        }
        IObjectWrapper zzj2 = zzdku.zzj();
        if (zzj2 != null) {
            return (ImageView.ScaleType) ObjectWrapper.unwrap(zzj2);
        }
        return zzdjy.zza;
    }

    private final void zzab(String str, boolean z) {
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzfk)).booleanValue()) {
            ListenableFuture zzw2 = this.zze.zzw();
            if (zzw2 != null) {
                zzgei.zzr(zzw2, new zzdir(this, "Google", true), this.zzd);
                return;
            }
            return;
        }
        zzf("Google", true);
    }

    private final synchronized void zzac(View view, Map map, Map map2) {
        this.zzg.zzd(this.zzo);
        this.zzf.zzq(view, map, map2, zzaa());
        this.zzq = true;
    }

    /* access modifiers changed from: private */
    public final void zzad(View view, zzeew zzeew) {
        zzcfk zzr2 = this.zze.zzr();
        if (this.zzh.zzd() && zzeew != null && zzr2 != null && view != null) {
            zzv.zzB().zzj(zzeew.zza(), view);
        }
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00b6, code lost:
        return;
     */
    /* renamed from: zzae */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzz(com.google.android.gms.internal.ads.zzdku r8) {
        /*
            r7 = this;
            monitor-enter(r7)
            boolean r0 = r7.zzp     // Catch:{ all -> 0x00b7 }
            if (r0 == 0) goto L_0x0007
            goto L_0x00b5
        L_0x0007:
            r7.zzo = r8     // Catch:{ all -> 0x00b7 }
            com.google.android.gms.internal.ads.zzdjy r0 = r7.zzg     // Catch:{ all -> 0x00b7 }
            r0.zze(r8)     // Catch:{ all -> 0x00b7 }
            com.google.android.gms.internal.ads.zzdjg r1 = r7.zzf     // Catch:{ all -> 0x00b7 }
            android.view.View r2 = r8.zzf()     // Catch:{ all -> 0x00b7 }
            java.util.Map r3 = r8.zzm()     // Catch:{ all -> 0x00b7 }
            java.util.Map r4 = r8.zzn()     // Catch:{ all -> 0x00b7 }
            r6 = r8
            r5 = r8
            r1.zzy(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x00b7 }
            com.google.android.gms.internal.ads.zzbce r8 = com.google.android.gms.internal.ads.zzbcn.zzcJ     // Catch:{ all -> 0x00b7 }
            com.google.android.gms.internal.ads.zzbcl r0 = com.google.android.gms.ads.internal.client.zzbe.zzc()     // Catch:{ all -> 0x00b7 }
            java.lang.Object r8 = r0.zza(r8)     // Catch:{ all -> 0x00b7 }
            java.lang.Boolean r8 = (java.lang.Boolean) r8     // Catch:{ all -> 0x00b7 }
            boolean r8 = r8.booleanValue()     // Catch:{ all -> 0x00b7 }
            if (r8 == 0) goto L_0x0042
            com.google.android.gms.internal.ads.zzavc r8 = r7.zzt     // Catch:{ all -> 0x00b7 }
            com.google.android.gms.internal.ads.zzaux r8 = r8.zzc()     // Catch:{ all -> 0x00b7 }
            if (r8 == 0) goto L_0x0042
            android.view.View r0 = r5.zzf()     // Catch:{ all -> 0x00b7 }
            r8.zzo(r0)     // Catch:{ all -> 0x00b7 }
        L_0x0042:
            com.google.android.gms.internal.ads.zzbce r8 = com.google.android.gms.internal.ads.zzbcn.zzbQ     // Catch:{ all -> 0x00b7 }
            com.google.android.gms.internal.ads.zzbcl r0 = com.google.android.gms.ads.internal.client.zzbe.zzc()     // Catch:{ all -> 0x00b7 }
            java.lang.Object r8 = r0.zza(r8)     // Catch:{ all -> 0x00b7 }
            java.lang.Boolean r8 = (java.lang.Boolean) r8     // Catch:{ all -> 0x00b7 }
            boolean r8 = r8.booleanValue()     // Catch:{ all -> 0x00b7 }
            if (r8 == 0) goto L_0x00a4
            com.google.android.gms.internal.ads.zzfet r8 = r7.zzb     // Catch:{ all -> 0x00b7 }
            boolean r0 = r8.zzak     // Catch:{ all -> 0x00b7 }
            if (r0 != 0) goto L_0x005b
            goto L_0x00a4
        L_0x005b:
            org.json.JSONObject r8 = r8.zzaj     // Catch:{ all -> 0x00b7 }
            java.util.Iterator r8 = r8.keys()     // Catch:{ all -> 0x00b7 }
            if (r8 == 0) goto L_0x00a4
        L_0x0063:
            boolean r0 = r8.hasNext()     // Catch:{ all -> 0x00b7 }
            if (r0 == 0) goto L_0x00a4
            java.lang.Object r0 = r8.next()     // Catch:{ all -> 0x00b7 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ all -> 0x00b7 }
            com.google.android.gms.internal.ads.zzdku r1 = r7.zzo     // Catch:{ all -> 0x00b7 }
            java.util.Map r1 = r1.zzl()     // Catch:{ all -> 0x00b7 }
            java.lang.Object r1 = r1.get(r0)     // Catch:{ all -> 0x00b7 }
            java.lang.ref.WeakReference r1 = (java.lang.ref.WeakReference) r1     // Catch:{ all -> 0x00b7 }
            java.util.Map r2 = r7.zzy     // Catch:{ all -> 0x00b7 }
            r3 = 0
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)     // Catch:{ all -> 0x00b7 }
            r2.put(r0, r3)     // Catch:{ all -> 0x00b7 }
            if (r1 == 0) goto L_0x0063
            java.lang.Object r1 = r1.get()     // Catch:{ all -> 0x00b7 }
            android.view.View r1 = (android.view.View) r1     // Catch:{ all -> 0x00b7 }
            if (r1 == 0) goto L_0x0063
            android.content.Context r2 = r7.zzv     // Catch:{ all -> 0x00b7 }
            com.google.android.gms.internal.ads.zzayn r3 = new com.google.android.gms.internal.ads.zzayn     // Catch:{ all -> 0x00b7 }
            r3.<init>(r2, r1)     // Catch:{ all -> 0x00b7 }
            java.util.List r1 = r7.zzz     // Catch:{ all -> 0x00b7 }
            r1.add(r3)     // Catch:{ all -> 0x00b7 }
            com.google.android.gms.internal.ads.zzdiq r1 = new com.google.android.gms.internal.ads.zzdiq     // Catch:{ all -> 0x00b7 }
            r1.<init>(r7, r0)     // Catch:{ all -> 0x00b7 }
            r3.zzc(r1)     // Catch:{ all -> 0x00b7 }
            goto L_0x0063
        L_0x00a4:
            com.google.android.gms.internal.ads.zzayn r8 = r5.zzi()     // Catch:{ all -> 0x00b7 }
            if (r8 == 0) goto L_0x00b5
            com.google.android.gms.internal.ads.zzayn r8 = r5.zzi()     // Catch:{ all -> 0x00b7 }
            com.google.android.gms.internal.ads.zzbyr r0 = r7.zzs     // Catch:{ all -> 0x00b7 }
            r8.zzc(r0)     // Catch:{ all -> 0x00b7 }
            monitor-exit(r7)
            return
        L_0x00b5:
            monitor-exit(r7)
            return
        L_0x00b7:
            r0 = move-exception
            r8 = r0
            monitor-exit(r7)     // Catch:{ all -> 0x00b7 }
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdit.zzz(com.google.android.gms.internal.ads.zzdku):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: zzaf */
    public final void zzA(zzdku zzdku) {
        this.zzf.zzz(zzdku.zzf(), zzdku.zzl());
        if (zzdku.zzh() != null) {
            zzdku.zzh().setClickable(false);
            zzdku.zzh().removeAllViews();
        }
        if (zzdku.zzi() != null) {
            zzdku.zzi().zze(this.zzs);
        }
        this.zzo = null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0088, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzB(android.view.View r4, java.util.Map r5, java.util.Map r6, boolean r7) {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = r3.zzq     // Catch:{ all -> 0x008e }
            if (r0 == 0) goto L_0x0007
            goto L_0x0087
        L_0x0007:
            com.google.android.gms.internal.ads.zzbce r0 = com.google.android.gms.internal.ads.zzbcn.zzbQ     // Catch:{ all -> 0x008e }
            com.google.android.gms.internal.ads.zzbcl r1 = com.google.android.gms.ads.internal.client.zzbe.zzc()     // Catch:{ all -> 0x008e }
            java.lang.Object r0 = r1.zza(r0)     // Catch:{ all -> 0x008e }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x008e }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x008e }
            if (r0 == 0) goto L_0x0044
            com.google.android.gms.internal.ads.zzfet r0 = r3.zzb     // Catch:{ all -> 0x008e }
            boolean r0 = r0.zzak     // Catch:{ all -> 0x008e }
            if (r0 == 0) goto L_0x0044
            java.util.Map r0 = r3.zzy     // Catch:{ all -> 0x008e }
            java.util.Set r0 = r0.keySet()     // Catch:{ all -> 0x008e }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x008e }
        L_0x0029:
            boolean r1 = r0.hasNext()     // Catch:{ all -> 0x008e }
            if (r1 == 0) goto L_0x0044
            java.lang.Object r1 = r0.next()     // Catch:{ all -> 0x008e }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ all -> 0x008e }
            java.util.Map r2 = r3.zzy     // Catch:{ all -> 0x008e }
            java.lang.Object r1 = r2.get(r1)     // Catch:{ all -> 0x008e }
            java.lang.Boolean r1 = (java.lang.Boolean) r1     // Catch:{ all -> 0x008e }
            boolean r1 = r1.booleanValue()     // Catch:{ all -> 0x008e }
            if (r1 != 0) goto L_0x0029
            goto L_0x0087
        L_0x0044:
            if (r7 != 0) goto L_0x0089
            com.google.android.gms.internal.ads.zzbce r7 = com.google.android.gms.internal.ads.zzbcn.zzdW     // Catch:{ all -> 0x008e }
            com.google.android.gms.internal.ads.zzbcl r0 = com.google.android.gms.ads.internal.client.zzbe.zzc()     // Catch:{ all -> 0x008e }
            java.lang.Object r7 = r0.zza(r7)     // Catch:{ all -> 0x008e }
            java.lang.Boolean r7 = (java.lang.Boolean) r7     // Catch:{ all -> 0x008e }
            boolean r7 = r7.booleanValue()     // Catch:{ all -> 0x008e }
            if (r7 == 0) goto L_0x0087
            if (r5 == 0) goto L_0x0087
            java.util.Set r7 = r5.entrySet()     // Catch:{ all -> 0x008e }
            java.util.Iterator r7 = r7.iterator()     // Catch:{ all -> 0x008e }
        L_0x0062:
            boolean r0 = r7.hasNext()     // Catch:{ all -> 0x008e }
            if (r0 == 0) goto L_0x0087
            java.lang.Object r0 = r7.next()     // Catch:{ all -> 0x008e }
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0     // Catch:{ all -> 0x008e }
            java.lang.Object r0 = r0.getValue()     // Catch:{ all -> 0x008e }
            java.lang.ref.WeakReference r0 = (java.lang.ref.WeakReference) r0     // Catch:{ all -> 0x008e }
            java.lang.Object r0 = r0.get()     // Catch:{ all -> 0x008e }
            android.view.View r0 = (android.view.View) r0     // Catch:{ all -> 0x008e }
            if (r0 == 0) goto L_0x0062
            boolean r0 = zzY(r0)     // Catch:{ all -> 0x008e }
            if (r0 == 0) goto L_0x0062
            r3.zzac(r4, r5, r6)     // Catch:{ all -> 0x008e }
            monitor-exit(r3)
            return
        L_0x0087:
            monitor-exit(r3)
            return
        L_0x0089:
            r3.zzac(r4, r5, r6)     // Catch:{ all -> 0x008e }
            monitor-exit(r3)
            return
        L_0x008e:
            r4 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x008e }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdit.zzB(android.view.View, java.util.Map, java.util.Map, boolean):void");
    }

    public final synchronized void zzC(zzdh zzdh) {
        this.zzf.zzj(zzdh);
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0034, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzD(android.view.View r10, android.view.View r11, java.util.Map r12, java.util.Map r13, boolean r14) {
        /*
            r9 = this;
            monitor-enter(r9)
            com.google.android.gms.internal.ads.zzdjy r0 = r9.zzg     // Catch:{ all -> 0x0035 }
            com.google.android.gms.internal.ads.zzdku r1 = r9.zzo     // Catch:{ all -> 0x0035 }
            r0.zzc(r1)     // Catch:{ all -> 0x0035 }
            android.widget.ImageView$ScaleType r8 = r9.zzaa()     // Catch:{ all -> 0x0035 }
            com.google.android.gms.internal.ads.zzdjg r2 = r9.zzf     // Catch:{ all -> 0x0035 }
            r3 = r10
            r4 = r11
            r5 = r12
            r6 = r13
            r7 = r14
            r2.zzk(r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x0035 }
            boolean r10 = r9.zzr     // Catch:{ all -> 0x0035 }
            if (r10 == 0) goto L_0x0033
            com.google.android.gms.internal.ads.zzdiy r10 = r9.zze     // Catch:{ all -> 0x0035 }
            com.google.android.gms.internal.ads.zzcfk r11 = r10.zzs()     // Catch:{ all -> 0x0035 }
            if (r11 != 0) goto L_0x0023
            goto L_0x0033
        L_0x0023:
            com.google.android.gms.internal.ads.zzcfk r10 = r10.zzs()     // Catch:{ all -> 0x0035 }
            androidx.collection.ArrayMap r11 = new androidx.collection.ArrayMap     // Catch:{ all -> 0x0035 }
            r11.<init>()     // Catch:{ all -> 0x0035 }
            java.lang.String r12 = "onSdkAdUserInteractionClick"
            r10.zzd(r12, r11)     // Catch:{ all -> 0x0035 }
            monitor-exit(r9)
            return
        L_0x0033:
            monitor-exit(r9)
            return
        L_0x0035:
            r0 = move-exception
            r10 = r0
            monitor-exit(r9)     // Catch:{ all -> 0x0035 }
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdit.zzD(android.view.View, android.view.View, java.util.Map, java.util.Map, boolean):void");
    }

    public final synchronized void zzE(View view, int i) {
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzlh)).booleanValue()) {
            zzdku zzdku = this.zzo;
            if (zzdku == null) {
                zzm.zze("Ad should be associated with an ad view before calling performClickForCustomGesture()");
            } else {
                this.zzd.execute(new zzdin(this, view, zzdku instanceof zzdjs, i));
            }
        }
    }

    public final synchronized void zzF(String str) {
        this.zzf.zzl(str);
    }

    public final synchronized void zzG(Bundle bundle) {
        this.zzf.zzm(bundle);
    }

    public final synchronized void zzH() {
        zzdku zzdku = this.zzo;
        if (zzdku == null) {
            zzm.zze("Ad should be associated with an ad view before calling recordCustomClickGesture()");
        } else {
            this.zzd.execute(new zzdip(this, zzdku instanceof zzdjs));
        }
    }

    public final void zzI(Bundle bundle) {
        zzcfk zzs2 = this.zze.zzs();
        if (zzs2 == null) {
            zzm.zzg("Video webview is null");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            for (String str : bundle.keySet()) {
                jSONObject.put(str, bundle.get(str));
            }
            this.zzd.execute(new zzdim(zzs2, jSONObject));
        } catch (JSONException e) {
            zzm.zzh("Error reading event signals", e);
        }
    }

    public final synchronized void zzJ() {
        if (!this.zzq) {
            this.zzf.zzr();
        }
    }

    public final void zzK(View view) {
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzfk)).booleanValue()) {
            zzcao zzp2 = this.zze.zzp();
            if (zzp2 != null) {
                zzgei.zzr(zzp2, new zzdis(this, view), this.zzd);
                return;
            }
            return;
        }
        zzad(view, this.zze.zzu());
    }

    public final synchronized void zzL(View view, MotionEvent motionEvent, View view2) {
        this.zzf.zzs(view, motionEvent, view2);
    }

    public final synchronized void zzM(Bundle bundle) {
        this.zzf.zzt(bundle);
    }

    public final synchronized void zzN(View view) {
        this.zzf.zzu(view);
    }

    public final synchronized void zzO() {
        this.zzf.zzv();
    }

    public final synchronized void zzP(zzdd zzdd) {
        this.zzf.zzw(zzdd);
    }

    public final synchronized void zzQ(zzdr zzdr) {
        this.zzx.zza(zzdr);
    }

    public final synchronized void zzR(zzbhs zzbhs) {
        this.zzf.zzx(zzbhs);
    }

    public final synchronized void zzS(zzdku zzdku) {
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzbO)).booleanValue()) {
            zzs.zza.post(new zzdii(this, zzdku));
        } else {
            zzz(zzdku);
        }
    }

    public final synchronized void zzT(zzdku zzdku) {
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzbO)).booleanValue()) {
            zzs.zza.post(new zzdij(this, zzdku));
        } else {
            zzA(zzdku);
        }
    }

    public final boolean zzU() {
        return this.zzh.zze();
    }

    public final synchronized boolean zzV() {
        return this.zzf.zzA();
    }

    public final synchronized boolean zzW() {
        return this.zzf.zzB();
    }

    public final boolean zzX() {
        return this.zzh.zzd();
    }

    public final synchronized boolean zzZ(Bundle bundle) {
        if (this.zzq) {
            return true;
        }
        boolean zzC = this.zzf.zzC(bundle);
        this.zzq = zzC;
        return zzC;
    }

    public final synchronized int zza() {
        return this.zzf.zza();
    }

    public final synchronized void zzb() {
        this.zzp = true;
        this.zzd.execute(new zzdio(this));
        super.zzb();
    }

    public final zzdiv zzc() {
        return this.zzw;
    }

    public final zzeew zzf(String str, boolean z) {
        String str2;
        zzees zzees;
        zzeet zzeet;
        zzeet zzeet2;
        String str3;
        if (!this.zzh.zzd() || TextUtils.isEmpty(str)) {
            return null;
        }
        zzdiy zzdiy = this.zze;
        zzcfk zzr2 = zzdiy.zzr();
        zzcfk zzs2 = zzdiy.zzs();
        if (zzr2 == null && zzs2 == null) {
            zzm.zzj("Omid display and video webview are null. Skipping initialization.");
            return null;
        }
        boolean z2 = false;
        boolean z3 = zzr2 != null;
        boolean z4 = zzs2 != null;
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzfi)).booleanValue()) {
            this.zzh.zza();
            int zzc2 = this.zzh.zza().zzc();
            int i = zzc2 - 1;
            if (i != 0) {
                if (i != 1) {
                    if (zzc2 != 1) {
                        str3 = zzc2 != 2 ? "UNKNOWN" : "DISPLAY";
                    } else {
                        str3 = "VIDEO";
                    }
                    zzm.zzj("Unknown omid media type: " + str3 + ". Not initializing Omid.");
                    return null;
                } else if (zzr2 != null) {
                    z4 = false;
                    z2 = true;
                } else {
                    zzm.zzj("Omid media type was display but there was no display webview.");
                    return null;
                }
            } else if (zzs2 != null) {
                z4 = true;
            } else {
                zzm.zzj("Omid media type was video but there was no video webview.");
                return null;
            }
        } else {
            z2 = z3;
        }
        if (z2) {
            str2 = null;
        } else {
            str2 = "javascript";
            zzr2 = zzs2;
        }
        zzr2.zzG();
        if (!zzv.zzB().zzl(this.zzv)) {
            zzm.zzj("Failed to initialize omid in InternalNativeAd");
            return null;
        }
        VersionInfoParcel versionInfoParcel = this.zzu;
        String str4 = versionInfoParcel.buddyApkVersion + "." + versionInfoParcel.clientJarVersion;
        if (z4) {
            zzees = zzees.VIDEO;
            zzeet = zzeet.DEFINED_BY_JAVASCRIPT;
        } else {
            zzdiy zzdiy2 = this.zze;
            zzees zzees2 = zzees.NATIVE_DISPLAY;
            if (zzdiy2.zzc() == 3) {
                zzeet2 = zzeet.UNSPECIFIED;
            } else {
                zzeet2 = zzeet.ONE_PIXEL;
            }
            zzeet = zzeet2;
            zzees = zzees2;
        }
        zzeew zzb = zzv.zzB().zzb(str4, zzr2.zzG(), "", "javascript", str2, str, zzeet, zzees, this.zzb.zzal);
        if (zzb == null) {
            zzm.zzj("Failed to create omid session in InternalNativeAd");
            return null;
        }
        this.zze.zzW(zzb);
        zzr2.zzat(zzb);
        if (z4) {
            zzv.zzB().zzj(zzb.zza(), zzs2.zzF());
            this.zzr = true;
        }
        if (z) {
            zzv.zzB().zzk(zzb.zza());
            zzr2.zzd("onSdkLoaded", new ArrayMap());
        }
        return zzb;
    }

    public final String zzg() {
        return this.zzh.zzb();
    }

    public final synchronized JSONObject zzi(View view, Map map, Map map2) {
        return this.zzf.zze(view, map, map2, zzaa());
    }

    public final synchronized JSONObject zzj(View view, Map map, Map map2) {
        return this.zzf.zzf(view, map, map2, zzaa());
    }

    public final void zzk() {
        this.zzd.execute(new zzdik(this));
        if (this.zze.zzc() != 7) {
            Executor executor = this.zzd;
            zzdjg zzdjg = this.zzf;
            Objects.requireNonNull(zzdjg);
            executor.execute(new zzdil(zzdjg));
        }
        super.zzk();
    }

    public final void zzu(View view) {
        zzeew zzu2 = this.zze.zzu();
        if (this.zzh.zzd() && zzu2 != null && view != null) {
            zzv.zzB().zzg(zzu2.zza(), view);
        }
    }

    public final synchronized void zzv() {
        this.zzf.zzh();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzw() {
        this.zzf.zzi();
        this.zze.zzI();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzx(View view, boolean z, int i) {
        this.zzf.zzo(view, this.zzo.zzf(), this.zzo.zzl(), this.zzo.zzm(), z, zzaa(), i);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzy(boolean z) {
        this.zzf.zzo((View) null, this.zzo.zzf(), this.zzo.zzl(), this.zzo.zzm(), z, zzaa(), 0);
    }

    public static /* synthetic */ void zzl(zzdit zzdit) {
        try {
            zzdiy zzdiy = zzdit.zze;
            int zzc2 = zzdiy.zzc();
            if (zzc2 != 1) {
                if (zzc2 != 2) {
                    if (zzc2 != 3) {
                        if (zzc2 != 6) {
                            if (zzc2 != 7) {
                                zzm.zzg("Wrong native template id!");
                                return;
                            }
                            zzdjj zzdjj = zzdit.zzi;
                            if (zzdjj.zzg() != null) {
                                zzdjj.zzg().zzg((zzbme) zzdit.zzm.zzb());
                            }
                        } else if (zzdit.zzi.zzf() != null) {
                            zzdit.zzab("Google", true);
                            zzdit.zzi.zzf().zze((zzbhv) zzdit.zzl.zzb());
                        }
                    } else if (zzdit.zzi.zzd(zzdiy.zzA()) != null) {
                        if (zzdit.zze.zzs() != null) {
                            zzdit.zzf("Google", true);
                        }
                        zzdit.zzi.zzd(zzdit.zze.zzA()).zze((zzbgs) zzdit.zzn.zzb());
                    }
                } else if (zzdit.zzi.zza() != null) {
                    zzdit.zzab("Google", true);
                    zzdit.zzi.zza().zze((zzbgn) zzdit.zzk.zzb());
                }
            } else if (zzdit.zzi.zzb() != null) {
                zzdit.zzab("Google", true);
                zzdit.zzi.zzb().zze((zzbgp) zzdit.zzj.zzb());
            }
        } catch (RemoteException e) {
            zzm.zzh("RemoteException when notifyAdLoad is called", e);
        }
    }
}
