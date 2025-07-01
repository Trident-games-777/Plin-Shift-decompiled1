package com.google.android.gms.internal.ads;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzduk implements Runnable {
    public final /* synthetic */ zzdup zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ zzblt zzc;
    public final /* synthetic */ zzfgm zzd;
    public final /* synthetic */ List zze;

    public /* synthetic */ zzduk(zzdup zzdup, String str, zzblt zzblt, zzfgm zzfgm, List list) {
        this.zza = zzdup;
        this.zzb = str;
        this.zzc = zzblt;
        this.zzd = zzfgm;
        this.zze = list;
    }

    public final void run() {
        this.zza.zzn(this.zzb, this.zzc, this.zzd, this.zze);
    }
}
