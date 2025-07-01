package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzux implements Runnable {
    public final /* synthetic */ zzva zza;
    public final /* synthetic */ zzvb zzb;
    public final /* synthetic */ zzui zzc;
    public final /* synthetic */ zzun zzd;
    public final /* synthetic */ IOException zze;
    public final /* synthetic */ boolean zzf;

    public /* synthetic */ zzux(zzva zzva, zzvb zzvb, zzui zzui, zzun zzun, IOException iOException, boolean z) {
        this.zza = zzva;
        this.zzb = zzvb;
        this.zzc = zzui;
        this.zzd = zzun;
        this.zze = iOException;
        this.zzf = z;
    }

    public final void run() {
        this.zzb.zzai(0, this.zza.zzb, this.zzc, this.zzd, this.zze, this.zzf);
    }
}
