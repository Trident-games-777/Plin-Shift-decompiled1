package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.internal.ads.zzbcn;
import com.google.android.gms.internal.ads.zzcaj;
import com.google.android.gms.internal.ads.zzcfk;
import com.google.android.gms.internal.ads.zzfuj;
import com.google.android.gms.internal.ads.zzfuk;
import com.google.android.gms.internal.ads.zzful;
import com.google.android.gms.internal.ads.zzfum;
import com.google.android.gms.internal.ads.zzfvf;
import com.google.android.gms.internal.ads.zzfvh;
import com.google.android.gms.internal.ads.zzfvi;
import com.google.android.gms.internal.ads.zzfvj;
import com.google.android.gms.internal.ads.zzfvk;
import com.google.android.gms.internal.ads.zzfvx;
import com.google.firebase.messaging.Constants;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzz {
    private String zza = null;
    private String zzb = null;
    private zzcfk zzc = null;
    private zzful zzd = null;
    private boolean zze = false;
    private zzfvi zzf;

    private final zzfvk zzl() {
        zzfvj zzc2 = zzfvk.zzc();
        if (!((Boolean) zzbe.zzc().zza(zzbcn.zzlf)).booleanValue() || TextUtils.isEmpty(this.zzb)) {
            String str = this.zza;
            if (str != null) {
                zzc2.zzb(str);
            } else {
                zzf("Missing session token and/or appId", "onLMDupdate");
            }
        } else {
            zzc2.zza(this.zzb);
        }
        return zzc2.zzc();
    }

    private final void zzm() {
        if (this.zzf == null) {
            this.zzf = new zzy(this);
        }
    }

    public final synchronized void zza(zzcfk zzcfk, Context context) {
        this.zzc = zzcfk;
        if (!zzk(context)) {
            zzf("Unable to bind", "on_play_store_bind");
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("action", "fetch_completed");
        zze("on_play_store_bind", hashMap);
    }

    public final void zzb() {
        zzful zzful;
        if (!this.zze || (zzful = this.zzd) == null) {
            zze.zza("LastMileDelivery not connected");
            return;
        }
        zzful.zza(zzl(), this.zzf);
        zzd("onLMDOverlayCollapse");
    }

    public final void zzc() {
        zzful zzful;
        if (!this.zze || (zzful = this.zzd) == null) {
            zze.zza("LastMileDelivery not connected");
            return;
        }
        zzfuj zzc2 = zzfuk.zzc();
        if (!((Boolean) zzbe.zzc().zza(zzbcn.zzlf)).booleanValue() || TextUtils.isEmpty(this.zzb)) {
            String str = this.zza;
            if (str != null) {
                zzc2.zzb(str);
            } else {
                zzf("Missing session token and/or appId", "onLMDupdate");
            }
        } else {
            zzc2.zza(this.zzb);
        }
        zzful.zzb(zzc2.zzc(), this.zzf);
    }

    /* access modifiers changed from: package-private */
    public final void zzd(String str) {
        zze(str, new HashMap());
    }

    /* access modifiers changed from: package-private */
    public final void zze(String str, Map map) {
        zzcaj.zze.execute(new zzx(this, str, map));
    }

    /* access modifiers changed from: package-private */
    public final void zzf(String str, String str2) {
        zze.zza(str);
        if (this.zzc != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("message", str);
            hashMap.put("action", str2);
            zze("onError", hashMap);
        }
    }

    public final void zzg() {
        zzful zzful;
        if (!this.zze || (zzful = this.zzd) == null) {
            zze.zza("LastMileDelivery not connected");
            return;
        }
        zzful.zzc(zzl(), this.zzf);
        zzd("onLMDOverlayExpand");
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzh(String str, Map map) {
        zzcfk zzcfk = this.zzc;
        if (zzcfk != null) {
            zzcfk.zzd(str, map);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzi(zzfvh zzfvh) {
        if (!TextUtils.isEmpty(zzfvh.zzb())) {
            if (!((Boolean) zzbe.zzc().zza(zzbcn.zzlf)).booleanValue()) {
                this.zza = zzfvh.zzb();
            }
        }
        switch (zzfvh.zza()) {
            case 8152:
                zzd("onLMDOverlayOpened");
                return;
            case 8153:
                zzd("onLMDOverlayClicked");
                return;
            case 8155:
                zzd("onLMDOverlayClose");
                return;
            case 8157:
                this.zza = null;
                this.zzb = null;
                this.zze = false;
                return;
            case 8160:
            case 8161:
            case 8162:
                HashMap hashMap = new HashMap();
                hashMap.put(Constants.IPC_BUNDLE_KEY_SEND_ERROR, String.valueOf(zzfvh.zza()));
                zze("onLMDOverlayFailedToOpen", hashMap);
                return;
            default:
                return;
        }
    }

    public final void zzj(zzcfk zzcfk, zzfvf zzfvf) {
        if (zzcfk == null) {
            zzf("adWebview missing", "onLMDShow");
            return;
        }
        this.zzc = zzcfk;
        if (this.zze || zzk(zzcfk.getContext())) {
            if (((Boolean) zzbe.zzc().zza(zzbcn.zzlf)).booleanValue()) {
                this.zzb = zzfvf.zzh();
            }
            zzm();
            zzful zzful = this.zzd;
            if (zzful != null) {
                zzful.zzd(zzfvf, this.zzf);
                return;
            }
            return;
        }
        zzf("LMDOverlay not bound", "on_play_store_bind");
    }

    public final synchronized boolean zzk(Context context) {
        if (!zzfvx.zza(context)) {
            return false;
        }
        try {
            this.zzd = zzfum.zza(context);
        } catch (NullPointerException e) {
            zze.zza("Error connecting LMD Overlay service");
            zzv.zzp().zzw(e, "LastMileDeliveryOverlay.bindLastMileDeliveryService");
        }
        if (this.zzd == null) {
            this.zze = false;
            return false;
        }
        zzm();
        this.zze = true;
        return true;
    }
}
