package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzcco implements Runnable {
    public final /* synthetic */ zzccx zza;
    public final /* synthetic */ int zzb;
    public final /* synthetic */ int zzc;

    public /* synthetic */ zzcco(zzccx zzccx, int i, int i2) {
        this.zza = zzccx;
        this.zzb = i;
        this.zzc = i2;
    }

    public final void run() {
        this.zza.zzO(this.zzb, this.zzc);
    }
}
