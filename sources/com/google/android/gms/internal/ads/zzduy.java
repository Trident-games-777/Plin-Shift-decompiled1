package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzbc;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.ads.internal.client.zzw;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.firebase.messaging.Constants;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzduy implements zzcwp, zzczj, zzcye {
    private final zzdvk zza;
    private final String zzb;
    private final String zzc;
    private int zzd;
    private zzdux zze;
    private zzcwf zzf;
    private zze zzg;
    private String zzh = "";
    private String zzi = "";
    private String zzj = "";
    private JSONObject zzk;
    private JSONObject zzl;
    private boolean zzm;
    private boolean zzn;
    private boolean zzo;

    zzduy(zzdvk zzdvk, zzffo zzffo, String str) {
        this.zza = zzdvk;
        this.zzc = str;
        this.zzb = zzffo.zzf;
        this.zzd = 0;
        this.zze = zzdux.AD_REQUESTED;
    }

    private static JSONObject zzh(zze zze2) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("errorDomain", zze2.zzc);
        jSONObject.put("errorCode", zze2.zza);
        jSONObject.put("errorDescription", zze2.zzb);
        zze zze3 = zze2.zzd;
        jSONObject.put("underlyingError", zze3 == null ? null : zzh(zze3));
        return jSONObject;
    }

    private final JSONObject zzi(zzcwf zzcwf) throws JSONException {
        JSONObject jSONObject;
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("winningAdapterClassName", zzcwf.zzg());
        jSONObject2.put("responseSecsSinceEpoch", zzcwf.zzc());
        jSONObject2.put("responseId", zzcwf.zzi());
        if (((Boolean) zzbe.zzc().zza(zzbcn.zziQ)).booleanValue()) {
            String zzd2 = zzcwf.zzd();
            if (!TextUtils.isEmpty(zzd2)) {
                zzm.zze("Bidding data: ".concat(String.valueOf(zzd2)));
                jSONObject2.put("biddingData", new JSONObject(zzd2));
            }
        }
        if (!TextUtils.isEmpty(this.zzh)) {
            jSONObject2.put("adRequestUrl", this.zzh);
        }
        if (!TextUtils.isEmpty(this.zzi)) {
            jSONObject2.put("postBody", this.zzi);
        }
        if (!TextUtils.isEmpty(this.zzj)) {
            jSONObject2.put("adResponseBody", this.zzj);
        }
        JSONObject jSONObject3 = this.zzk;
        if (jSONObject3 != null) {
            jSONObject2.put("adResponseHeaders", jSONObject3);
        }
        JSONObject jSONObject4 = this.zzl;
        if (jSONObject4 != null) {
            jSONObject2.put("transactionExtras", jSONObject4);
        }
        if (((Boolean) zzbe.zzc().zza(zzbcn.zziT)).booleanValue()) {
            jSONObject2.put("hasExceededMemoryLimit", this.zzo);
        }
        JSONArray jSONArray = new JSONArray();
        for (zzw zzw : zzcwf.zzj()) {
            JSONObject jSONObject5 = new JSONObject();
            jSONObject5.put("adapterClassName", zzw.zza);
            jSONObject5.put("latencyMillis", zzw.zzb);
            if (((Boolean) zzbe.zzc().zza(zzbcn.zziR)).booleanValue()) {
                jSONObject5.put("credentials", zzbc.zzb().zzi(zzw.zzd));
            }
            zze zze2 = zzw.zzc;
            if (zze2 == null) {
                jSONObject = null;
            } else {
                jSONObject = zzh(zze2);
            }
            jSONObject5.put(Constants.IPC_BUNDLE_KEY_SEND_ERROR, jSONObject);
            jSONArray.put(jSONObject5);
        }
        jSONObject2.put("adNetworks", jSONArray);
        return jSONObject2;
    }

    public final void zza(zzcrq zzcrq) {
        if (this.zza.zzq()) {
            this.zzf = zzcrq.zzm();
            this.zze = zzdux.AD_LOADED;
            if (((Boolean) zzbe.zzc().zza(zzbcn.zziX)).booleanValue()) {
                this.zza.zzf(this.zzb, this);
            }
        }
    }

    public final String zzc() {
        return this.zzc;
    }

    public final JSONObject zzd() throws JSONException {
        JSONObject jSONObject;
        IBinder iBinder;
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("state", this.zze);
        jSONObject2.put("format", zzfet.zza(this.zzd));
        if (((Boolean) zzbe.zzc().zza(zzbcn.zziX)).booleanValue()) {
            jSONObject2.put("isOutOfContext", this.zzm);
            if (this.zzm) {
                jSONObject2.put("shown", this.zzn);
            }
        }
        zzcwf zzcwf = this.zzf;
        if (zzcwf != null) {
            jSONObject = zzi(zzcwf);
        } else {
            zze zze2 = this.zzg;
            JSONObject jSONObject3 = null;
            if (!(zze2 == null || (iBinder = zze2.zze) == null)) {
                zzcwf zzcwf2 = (zzcwf) iBinder;
                jSONObject3 = zzi(zzcwf2);
                if (zzcwf2.zzj().isEmpty()) {
                    JSONArray jSONArray = new JSONArray();
                    jSONArray.put(zzh(this.zzg));
                    jSONObject3.put("errors", jSONArray);
                }
            }
            jSONObject = jSONObject3;
        }
        jSONObject2.put("responseInfo", jSONObject);
        return jSONObject2;
    }

    public final void zzdB(zze zze2) {
        if (this.zza.zzq()) {
            this.zze = zzdux.AD_LOAD_FAILED;
            this.zzg = zze2;
            if (((Boolean) zzbe.zzc().zza(zzbcn.zziX)).booleanValue()) {
                this.zza.zzf(this.zzb, this);
            }
        }
    }

    public final void zzdn(zzbvx zzbvx) {
        if (!((Boolean) zzbe.zzc().zza(zzbcn.zziX)).booleanValue() && this.zza.zzq()) {
            this.zza.zzf(this.zzb, this);
        }
    }

    public final void zzdo(zzfff zzfff) {
        if (this.zza.zzq()) {
            int i = 0;
            if (!zzfff.zzb.zza.isEmpty()) {
                this.zzd = ((zzfet) zzfff.zzb.zza.get(0)).zzb;
            }
            if (!TextUtils.isEmpty(zzfff.zzb.zzb.zzl)) {
                this.zzh = zzfff.zzb.zzb.zzl;
            }
            if (!TextUtils.isEmpty(zzfff.zzb.zzb.zzm)) {
                this.zzi = zzfff.zzb.zzb.zzm;
            }
            if (zzfff.zzb.zzb.zzp.length() > 0) {
                this.zzl = zzfff.zzb.zzb.zzp;
            }
            if (!((Boolean) zzbe.zzc().zza(zzbcn.zziT)).booleanValue()) {
                return;
            }
            if (!this.zza.zzs()) {
                this.zzo = true;
                return;
            }
            if (!TextUtils.isEmpty(zzfff.zzb.zzb.zzn)) {
                this.zzj = zzfff.zzb.zzb.zzn;
            }
            if (zzfff.zzb.zzb.zzo.length() > 0) {
                this.zzk = zzfff.zzb.zzb.zzo;
            }
            zzdvk zzdvk = this.zza;
            JSONObject jSONObject = this.zzk;
            if (jSONObject != null) {
                i = jSONObject.toString().length();
            }
            if (!TextUtils.isEmpty(this.zzj)) {
                i += this.zzj.length();
            }
            zzdvk.zzk((long) i);
        }
    }

    public final void zze() {
        this.zzm = true;
    }

    public final void zzf() {
        this.zzn = true;
    }

    public final boolean zzg() {
        return this.zze != zzdux.AD_REQUESTED;
    }
}
