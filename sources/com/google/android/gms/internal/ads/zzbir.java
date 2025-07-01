package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzbc;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzbir implements zzgdp {
    public final /* synthetic */ zzcnb zza;
    public final /* synthetic */ String zzb;

    public /* synthetic */ zzbir(zzcnb zzcnb, String str) {
        this.zza = zzcnb;
        this.zzb = str;
    }

    public final ListenableFuture zza(Object obj) {
        zzcnb zzcnb;
        String str = (String) obj;
        zzbjr zzbjr = zzbjq.zza;
        if (!((Boolean) zzbe.zzc().zza(zzbcn.zzjI)).booleanValue() || (zzcnb = this.zza) == null || !zzcnb.zzj(this.zzb)) {
            return zzgei.zzh(str);
        }
        return zzcnb.zzb(str, zzbc.zze());
    }
}
