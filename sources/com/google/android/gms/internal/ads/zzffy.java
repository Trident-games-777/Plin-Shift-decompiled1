package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzbc;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.zzv;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzffy implements zzgee {
    final /* synthetic */ zzcfk zza;
    final /* synthetic */ zzcnb zzb;
    final /* synthetic */ zzflr zzc;
    final /* synthetic */ zzedp zzd;

    zzffy(zzcfk zzcfk, zzcnb zzcnb, zzflr zzflr, zzedp zzedp) {
        this.zza = zzcfk;
        this.zzb = zzcnb;
        this.zzc = zzflr;
        this.zzd = zzedp;
    }

    public final void zza(Throwable th) {
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        String str = (String) obj;
        if (!this.zza.zzD().zzai) {
            if (!((Boolean) zzbe.zzc().zza(zzbcn.zzjI)).booleanValue() || this.zzb == null || !zzcnb.zzj(str)) {
                this.zzc.zzc(str, (zzfkl) null);
            } else {
                this.zzb.zzi(str, this.zzc, zzbc.zze());
            }
        } else {
            long currentTimeMillis = zzv.zzC().currentTimeMillis();
            String str2 = this.zza.zzR().zzb;
            int i = 2;
            if (!zzv.zzp().zzA(this.zza.getContext())) {
                if ((!((Boolean) zzbe.zzc().zza(zzbcn.zzge)).booleanValue() || !this.zza.zzD().zzS) && this.zza.zzD().zzad == null) {
                    i = 1;
                }
            }
            this.zzd.zzd(new zzedr(currentTimeMillis, str2, str, i));
        }
    }
}
