package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzk {
    private int zza;
    private int zzb;
    private int zzc;
    private byte[] zzd;
    private int zze;
    private int zzf;

    public zzk() {
        this.zza = -1;
        this.zzb = -1;
        this.zzc = -1;
        this.zze = -1;
        this.zzf = -1;
    }

    /* synthetic */ zzk(zzm zzm, zzl zzl) {
        this.zza = zzm.zzb;
        this.zzb = zzm.zzc;
        this.zzc = zzm.zzd;
        this.zzd = zzm.zze;
        this.zze = zzm.zzf;
        this.zzf = zzm.zzg;
    }

    public final zzk zza(int i) {
        this.zzf = i;
        return this;
    }

    public final zzk zzb(int i) {
        this.zzb = i;
        return this;
    }

    public final zzk zzc(int i) {
        this.zza = i;
        return this;
    }

    public final zzk zzd(int i) {
        this.zzc = i;
        return this;
    }

    public final zzk zze(byte[] bArr) {
        this.zzd = bArr;
        return this;
    }

    public final zzk zzf(int i) {
        this.zze = i;
        return this;
    }

    public final zzm zzg() {
        return new zzm(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, (zzl) null);
    }
}
