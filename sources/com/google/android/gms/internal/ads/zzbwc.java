package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzv;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzbwc implements Callable {
    final /* synthetic */ Context zza;
    final /* synthetic */ zzbwe zzb;

    zzbwc(zzbwe zzbwe, Context context) {
        this.zza = context;
        this.zzb = zzbwe;
    }

    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        zzbwb zzbwb;
        zzbwd zzbwd = (zzbwd) this.zzb.zza.get(this.zza);
        if (zzbwd != null) {
            if (zzbwd.zza + ((Long) zzbec.zzd.zze()).longValue() >= zzv.zzC().currentTimeMillis()) {
                zzbwb = new zzbwa(this.zza, zzbwd.zzb).zza();
                zzbwe zzbwe = this.zzb;
                zzbwe.zza.put(this.zza, new zzbwd(zzbwe, zzbwb));
                return zzbwb;
            }
        }
        zzbwb = new zzbwa(this.zza).zza();
        zzbwe zzbwe2 = this.zzb;
        zzbwe2.zza.put(this.zza, new zzbwd(zzbwe2, zzbwb));
        return zzbwb;
    }
}
