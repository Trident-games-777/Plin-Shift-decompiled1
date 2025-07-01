package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzcni implements Runnable {
    public final /* synthetic */ zzcnn zza;
    public final /* synthetic */ int zzb;
    public final /* synthetic */ int zzc;

    public /* synthetic */ zzcni(zzcnn zzcnn, int i, int i2) {
        this.zza = zzcnn;
        this.zzb = i;
        this.zzc = i2;
    }

    public final void run() {
        this.zza.zzo(this.zzb, this.zzc);
    }
}
