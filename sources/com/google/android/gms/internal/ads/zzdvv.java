package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.client.zzdl;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzac;
import com.google.android.gms.ads.internal.overlay.zzr;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzb;
import com.google.android.gms.ads.internal.zzn;
import com.google.android.gms.ads.internal.zzv;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzdvv implements zzr, zzcha {
    private final Context zza;
    private final VersionInfoParcel zzb;
    private zzdvk zzc;
    private zzcfk zzd;
    private boolean zze;
    private boolean zzf;
    private long zzg;
    private zzdl zzh;
    private boolean zzi;

    zzdvv(Context context, VersionInfoParcel versionInfoParcel) {
        this.zza = context;
        this.zzb = versionInfoParcel;
    }

    private final synchronized boolean zzl(zzdl zzdl) {
        if (!((Boolean) zzbe.zzc().zza(zzbcn.zziz)).booleanValue()) {
            zzm.zzj("Ad inspector had an internal error.");
            try {
                zzdl.zze(zzfgq.zzd(16, (String) null, (zze) null));
            } catch (RemoteException unused) {
            }
        } else if (this.zzc == null) {
            zzm.zzj("Ad inspector had an internal error.");
            try {
                zzv.zzp().zzw(new NullPointerException("InspectorManager null"), "InspectorUi.shouldOpenUi");
                zzdl.zze(zzfgq.zzd(16, (String) null, (zze) null));
            } catch (RemoteException unused2) {
            }
        } else {
            if (!this.zze && !this.zzf) {
                if (zzv.zzC().currentTimeMillis() >= this.zzg + ((long) ((Integer) zzbe.zzc().zza(zzbcn.zziC)).intValue())) {
                    return true;
                }
            }
            zzm.zzj("Ad inspector cannot be opened because it is already open.");
            try {
                zzdl.zze(zzfgq.zzd(19, (String) null, (zze) null));
            } catch (RemoteException unused3) {
            }
        }
        return false;
        return false;
        return false;
    }

    public final synchronized void zza(boolean z, int i, String str, String str2) {
        if (z) {
            com.google.android.gms.ads.internal.util.zze.zza("Ad inspector loaded.");
            this.zze = true;
            zzk("");
            return;
        }
        zzm.zzj("Ad inspector failed to load.");
        try {
            zzbzz zzp = zzv.zzp();
            zzp.zzw(new Exception("Failed to load UI. Error code: " + i + ", Description: " + str + ", Failing URL: " + str2), "InspectorUi.onAdWebViewFinishedLoading 0");
            zzdl zzdl = this.zzh;
            if (zzdl != null) {
                zzdl.zze(zzfgq.zzd(17, (String) null, (zze) null));
            }
        } catch (RemoteException e) {
            zzv.zzp().zzw(e, "InspectorUi.onAdWebViewFinishedLoading 1");
        }
        this.zzi = true;
        this.zzd.destroy();
    }

    public final void zzdH() {
    }

    public final void zzdk() {
    }

    public final void zzdq() {
    }

    public final synchronized void zzdr() {
        this.zzf = true;
        zzk("");
    }

    public final void zzdt() {
    }

    public final synchronized void zzdu(int i) {
        this.zzd.destroy();
        if (!this.zzi) {
            com.google.android.gms.ads.internal.util.zze.zza("Inspector closed.");
            zzdl zzdl = this.zzh;
            if (zzdl != null) {
                try {
                    zzdl.zze((zze) null);
                } catch (RemoteException unused) {
                }
            }
        }
        this.zzf = false;
        this.zze = false;
        this.zzg = 0;
        this.zzi = false;
        this.zzh = null;
    }

    public final Activity zzg() {
        zzcfk zzcfk = this.zzd;
        if (zzcfk == null || zzcfk.zzaE()) {
            return null;
        }
        return this.zzd.zzi();
    }

    public final void zzh(zzdvk zzdvk) {
        this.zzc = zzdvk;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzi(String str) {
        JSONObject zze2 = this.zzc.zze();
        if (!TextUtils.isEmpty(str)) {
            try {
                zze2.put("redirectUrl", str);
            } catch (JSONException unused) {
            }
        }
        this.zzd.zzb("window.inspectorInfo", zze2.toString());
    }

    public final synchronized void zzj(zzdl zzdl, zzbkl zzbkl, zzbke zzbke, zzbjs zzbjs) {
        zzdl zzdl2 = zzdl;
        synchronized (this) {
            if (zzl(zzdl)) {
                try {
                    zzv.zzA();
                    zzcfk zza2 = zzcfx.zza(this.zza, zzche.zza(), "", false, false, (zzavc) null, (zzbdu) null, this.zzb, (zzbdc) null, (zzn) null, (zza) null, zzbbl.zza(), (zzfet) null, (zzfew) null, (zzeea) null, (zzffs) null);
                    this.zzd = zza2;
                    zzchc zzN = zza2.zzN();
                    if (zzN == null) {
                        zzm.zzj("Failed to obtain a web view for the ad inspector");
                        try {
                            zzv.zzp().zzw(new NullPointerException("Failed to obtain a web view for the ad inspector"), "InspectorUi.openInspector 2");
                            zzdl2.zze(zzfgq.zzd(17, "Failed to obtain a web view for the ad inspector", (zze) null));
                        } catch (RemoteException e) {
                            zzv.zzp().zzw(e, "InspectorUi.openInspector 3");
                        }
                    } else {
                        this.zzh = zzdl2;
                        zzN.zzU((com.google.android.gms.ads.internal.client.zza) null, (zzbih) null, (zzr) null, (zzbij) null, (zzac) null, false, (zzbju) null, (zzb) null, (zzbsl) null, (zzbyh) null, (zzedp) null, (zzflr) null, (zzdsm) null, zzbkl, (zzdel) null, new zzbkk(this.zza), zzbke, zzbjs, (zzcnb) null);
                        zzN.zzB(this);
                        this.zzd.loadUrl((String) zzbe.zzc().zza(zzbcn.zziA));
                        zzv.zzj();
                        com.google.android.gms.ads.internal.overlay.zzn.zza(this.zza, new AdOverlayInfoParcel(this, this.zzd, 1, this.zzb), true);
                        this.zzg = zzv.zzC().currentTimeMillis();
                    }
                } catch (zzcfw e2) {
                    zzm.zzk("Failed to obtain a web view for the ad inspector", e2);
                    try {
                        zzv.zzp().zzw(e2, "InspectorUi.openInspector 0");
                        zzdl2.zze(zzfgq.zzd(17, "Failed to obtain a web view for the ad inspector", (zze) null));
                    } catch (RemoteException e3) {
                        zzv.zzp().zzw(e3, "InspectorUi.openInspector 1");
                    }
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0017, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzk(java.lang.String r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = r2.zze     // Catch:{ all -> 0x0018 }
            if (r0 == 0) goto L_0x0016
            boolean r0 = r2.zzf     // Catch:{ all -> 0x0018 }
            if (r0 != 0) goto L_0x000a
            goto L_0x0016
        L_0x000a:
            com.google.android.gms.internal.ads.zzges r0 = com.google.android.gms.internal.ads.zzcaj.zze     // Catch:{ all -> 0x0018 }
            com.google.android.gms.internal.ads.zzdvu r1 = new com.google.android.gms.internal.ads.zzdvu     // Catch:{ all -> 0x0018 }
            r1.<init>(r2, r3)     // Catch:{ all -> 0x0018 }
            r0.execute(r1)     // Catch:{ all -> 0x0018 }
            monitor-exit(r2)
            return
        L_0x0016:
            monitor-exit(r2)
            return
        L_0x0018:
            r3 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0018 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdvv.zzk(java.lang.String):void");
    }
}
