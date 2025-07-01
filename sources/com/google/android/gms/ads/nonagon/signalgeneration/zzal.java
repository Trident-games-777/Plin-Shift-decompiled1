package com.google.android.gms.ads.nonagon.signalgeneration;

import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.internal.ads.zzbcn;
import com.google.android.gms.internal.ads.zzbeg;
import com.google.android.gms.internal.ads.zzbze;
import com.google.android.gms.internal.ads.zzbzl;
import com.google.android.gms.internal.ads.zzfka;
import com.google.android.gms.internal.ads.zzfkl;
import com.google.android.gms.internal.ads.zzgee;
import com.google.common.util.concurrent.ListenableFuture;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzal implements zzgee {
    final /* synthetic */ ListenableFuture zza;
    final /* synthetic */ zzbzl zzb;
    final /* synthetic */ zzbze zzc;
    final /* synthetic */ zzfka zzd;
    final /* synthetic */ zzap zze;

    zzal(zzap zzap, ListenableFuture listenableFuture, zzbzl zzbzl, zzbze zzbze, zzfka zzfka) {
        this.zza = listenableFuture;
        this.zzb = zzbzl;
        this.zzc = zzbze;
        this.zzd = zzfka;
        this.zze = zzap;
    }

    public final void zza(Throwable th) {
        String message = th.getMessage();
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzhr)).booleanValue()) {
            zzv.zzp().zzv(th, "SignalGeneratorImpl.generateSignals");
        } else {
            zzv.zzp().zzw(th, "SignalGeneratorImpl.generateSignals");
        }
        zzfkl zzr = zzap.zzr(this.zza, this.zzb);
        if (((Boolean) zzbeg.zze.zze()).booleanValue() && zzr != null) {
            zzfka zzfka = this.zzd;
            zzfka.zzh(th);
            zzfka.zzg(false);
            zzr.zza(zzfka);
            zzr.zzh();
        }
        try {
            if (!"Unknown format is no longer supported.".equals(message)) {
                message = "Internal error. " + message;
            }
            this.zzc.zzb(message);
        } catch (RemoteException e) {
            zzm.zzh("", e);
        }
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzbd zzbd = (zzbd) obj;
        zzfkl zzr = zzap.zzr(this.zza, this.zzb);
        this.zze.zzG.set(true);
        if (!((Boolean) zzbe.zzc().zza(zzbcn.zzhm)).booleanValue()) {
            try {
                this.zzc.zzb("QueryInfo generation has been disabled.");
            } catch (RemoteException e) {
                zzm.zzg("QueryInfo generation has been disabled.".concat(e.toString()));
            }
            if (((Boolean) zzbeg.zze.zze()).booleanValue() && zzr != null) {
                zzfka zzfka = this.zzd;
                zzfka.zzc("QueryInfo generation has been disabled.");
                zzfka.zzg(false);
                zzr.zza(zzfka);
                zzr.zzh();
            }
        } else if (zzbd == null) {
            try {
                this.zzc.zzc((String) null, (String) null, (Bundle) null);
                this.zzd.zzg(true);
                if (((Boolean) zzbeg.zze.zze()).booleanValue() && zzr != null) {
                    zzr.zza(this.zzd);
                    zzr.zzh();
                }
            } catch (RemoteException e2) {
                zzfka zzfka2 = this.zzd;
                zzfka2.zzh(e2);
                zzfka2.zzg(false);
                zzm.zzh("", e2);
                zzv.zzp().zzw(e2, "SignalGeneratorImpl.generateSignals.onSuccess");
                if (((Boolean) zzbeg.zze.zze()).booleanValue() && zzr != null) {
                    zzr.zza(this.zzd);
                    zzr.zzh();
                }
            } catch (Throwable th) {
                if (((Boolean) zzbeg.zze.zze()).booleanValue() && zzr != null) {
                    zzr.zza(this.zzd);
                    zzr.zzh();
                }
                throw th;
            }
        } else {
            try {
                if (TextUtils.isEmpty(new JSONObject(zzbd.zzb).optString("request_id", ""))) {
                    zzm.zzj("The request ID is empty in request JSON.");
                    this.zzc.zzb("Internal error: request ID is empty in request JSON.");
                    zzfka zzfka3 = this.zzd;
                    zzfka3.zzc("Request ID empty");
                    zzfka3.zzg(false);
                    if (((Boolean) zzbeg.zze.zze()).booleanValue() && zzr != null) {
                        zzr.zza(this.zzd);
                        zzr.zzh();
                        return;
                    }
                    return;
                }
                Bundle bundle = zzbd.zzd;
                zzap zzap = this.zze;
                if (zzap.zzu && bundle != null && bundle.getInt(zzap.zzw, -1) == -1) {
                    zzap zzap2 = this.zze;
                    bundle.putInt(zzap2.zzw, zzap2.zzx.get());
                }
                zzap zzap3 = this.zze;
                if (zzap3.zzt && bundle != null && TextUtils.isEmpty(bundle.getString(zzap3.zzv))) {
                    if (TextUtils.isEmpty(this.zze.zzz)) {
                        zzap zzap4 = this.zze;
                        zzs zzq = zzv.zzq();
                        zzap zzap5 = this.zze;
                        zzap4.zzz = zzq.zzc(zzap5.zzg, zzap5.zzy.afmaVersion);
                    }
                    zzap zzap6 = this.zze;
                    bundle.putString(zzap6.zzv, zzap6.zzz);
                }
                this.zzc.zzc(zzbd.zza, zzbd.zzb, bundle);
                this.zzd.zzg(true);
                if (((Boolean) zzbeg.zze.zze()).booleanValue() && zzr != null) {
                    zzr.zza(this.zzd);
                    zzr.zzh();
                }
            } catch (JSONException e3) {
                zzm.zzj("Failed to create JSON object from the request string.");
                zzbze zzbze = this.zzc;
                String obj2 = e3.toString();
                zzbze.zzb("Internal error for request JSON: " + obj2);
                zzfka zzfka4 = this.zzd;
                zzfka4.zzh(e3);
                zzfka4.zzg(false);
                zzv.zzp().zzw(e3, "SignalGeneratorImpl.generateSignals.onSuccess");
                if (((Boolean) zzbeg.zze.zze()).booleanValue() && zzr != null) {
                    zzr.zza(this.zzd);
                    zzr.zzh();
                }
            }
        }
    }
}
