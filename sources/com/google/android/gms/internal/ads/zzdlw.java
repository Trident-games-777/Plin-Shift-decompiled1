package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzs;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzdlw implements zzgdp {
    public final /* synthetic */ zzdmg zza;
    public final /* synthetic */ zzs zzb;
    public final /* synthetic */ zzfet zzc;
    public final /* synthetic */ zzfew zzd;
    public final /* synthetic */ String zze;
    public final /* synthetic */ String zzf;

    public /* synthetic */ zzdlw(zzdmg zzdmg, zzs zzs, zzfet zzfet, zzfew zzfew, String str, String str2) {
        this.zza = zzdmg;
        this.zzb = zzs;
        this.zzc = zzfet;
        this.zzd = zzfew;
        this.zze = str;
        this.zzf = str2;
    }

    public final ListenableFuture zza(Object obj) {
        return this.zza.zzb(this.zzb, this.zzc, this.zzd, this.zze, this.zzf, obj);
    }
}
