package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzv;
import com.google.firebase.messaging.Constants;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzduo extends zzbls {
    final /* synthetic */ Object zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ long zzc;
    final /* synthetic */ zzfka zzd;
    final /* synthetic */ zzcao zze;
    final /* synthetic */ zzdup zzf;

    zzduo(zzdup zzdup, Object obj, String str, long j, zzfka zzfka, zzcao zzcao) {
        this.zza = obj;
        this.zzb = str;
        this.zzc = j;
        this.zzd = zzfka;
        this.zze = zzcao;
        this.zzf = zzdup;
    }

    public final void zze(String str) {
        synchronized (this.zza) {
            this.zzf.zzv(this.zzb, false, str, (int) (zzv.zzC().elapsedRealtime() - this.zzc));
            this.zzf.zzl.zzb(this.zzb, Constants.IPC_BUNDLE_KEY_SEND_ERROR);
            this.zzf.zzo.zzb(this.zzb, Constants.IPC_BUNDLE_KEY_SEND_ERROR);
            zzfko zze2 = this.zzf.zzp;
            zzfka zzfka = this.zzd;
            zzfka.zzc(str);
            zzfka.zzg(false);
            zze2.zzb(zzfka.zzm());
            this.zze.zzc(false);
        }
    }

    public final void zzf() {
        synchronized (this.zza) {
            this.zzf.zzv(this.zzb, true, "", (int) (zzv.zzC().elapsedRealtime() - this.zzc));
            this.zzf.zzl.zzd(this.zzb);
            this.zzf.zzo.zzd(this.zzb);
            zzfko zze2 = this.zzf.zzp;
            zzfka zzfka = this.zzd;
            zzfka.zzg(true);
            zze2.zzb(zzfka.zzm());
            this.zze.zzc(true);
        }
    }
}
