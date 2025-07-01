package com.google.android.gms.internal.ads;

import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzbmz implements Runnable {
    public final /* synthetic */ zzbnu zza;
    public final /* synthetic */ zzbnt zzb;
    public final /* synthetic */ zzbmp zzc;
    public final /* synthetic */ ArrayList zzd;
    public final /* synthetic */ long zze;

    public /* synthetic */ zzbmz(zzbnu zzbnu, zzbnt zzbnt, zzbmp zzbmp, ArrayList arrayList, long j) {
        this.zza = zzbnu;
        this.zzb = zzbnt;
        this.zzc = zzbmp;
        this.zzd = arrayList;
        this.zze = j;
    }

    public final void run() {
        this.zza.zzi(this.zzb, this.zzc, this.zzd, this.zze);
    }
}
