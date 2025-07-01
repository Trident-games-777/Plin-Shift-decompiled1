package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzqm {
    private final zzcm[] zza;
    private final zzre zzb;
    private final zzcp zzc;

    public zzqm(zzcm... zzcmArr) {
        zzre zzre = new zzre();
        zzcp zzcp = new zzcp();
        zzcm[] zzcmArr2 = new zzcm[2];
        this.zza = zzcmArr2;
        System.arraycopy(zzcmArr, 0, zzcmArr2, 0, 0);
        this.zzb = zzre;
        this.zzc = zzcp;
        zzcmArr2[0] = zzre;
        zzcmArr2[1] = zzcp;
    }

    public final long zza(long j) {
        return this.zzc.zzg() ? this.zzc.zzi(j) : j;
    }

    public final long zzb() {
        return this.zzb.zzo();
    }

    public final zzbj zzc(zzbj zzbj) {
        this.zzc.zzk(zzbj.zzb);
        this.zzc.zzj(zzbj.zzc);
        return zzbj;
    }

    public final boolean zzd(boolean z) {
        this.zzb.zzp(z);
        return z;
    }

    public final zzcm[] zze() {
        return this.zza;
    }
}
