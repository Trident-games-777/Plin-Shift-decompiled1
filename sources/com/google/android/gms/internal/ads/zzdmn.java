package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzs;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzdmn implements zzgdp {
    public final /* synthetic */ zzdmy zza;
    public final /* synthetic */ zzs zzb;
    public final /* synthetic */ zzfet zzc;
    public final /* synthetic */ zzfew zzd;
    public final /* synthetic */ String zze;
    public final /* synthetic */ String zzf;

    public /* synthetic */ zzdmn(zzdmy zzdmy, zzs zzs, zzfet zzfet, zzfew zzfew, String str, String str2) {
        this.zza = zzdmy;
        this.zzb = zzs;
        this.zzc = zzfet;
        this.zzd = zzfew;
        this.zze = str;
        this.zzf = str2;
    }

    public final ListenableFuture zza(Object obj) {
        return this.zza.zzd(this.zzb, this.zzc, this.zzd, this.zze, this.zzf, obj);
    }
}
