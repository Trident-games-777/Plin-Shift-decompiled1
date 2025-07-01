package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzbe;
import java.util.regex.Matcher;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzdxu implements zzgee {
    final /* synthetic */ zzdxv zza;

    zzdxu(zzdxv zzdxv) {
        this.zza = zzdxv;
    }

    public final void zza(Throwable th) {
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzgc)).booleanValue()) {
            Matcher matcher = zzdxv.zza.matcher(th.getMessage());
            if (matcher.matches()) {
                this.zza.zzf.zzi(Integer.parseInt(matcher.group(1)));
            }
        }
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzfff zzfff = (zzfff) obj;
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzgc)).booleanValue()) {
            this.zza.zzf.zzi(zzfff.zzb.zzb.zzf);
            this.zza.zzf.zzj(zzfff.zzb.zzb.zzg);
        }
    }
}
