package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzuj implements zzup, zzuo {
    public final zzur zza;
    private final long zzb;
    private zzut zzc;
    private zzup zzd;
    private zzuo zze;
    private long zzf = -9223372036854775807L;
    private final zzys zzg;

    public zzuj(zzur zzur, zzys zzys, long j) {
        this.zza = zzur;
        this.zzg = zzys;
        this.zzb = j;
    }

    private final long zzv(long j) {
        long j2 = this.zzf;
        return j2 != -9223372036854775807L ? j2 : j;
    }

    public final long zza(long j, zzls zzls) {
        zzup zzup = this.zzd;
        int i = zzen.zza;
        zzup zzup2 = zzup;
        return zzup.zza(j, zzls);
    }

    public final long zzb() {
        zzup zzup = this.zzd;
        int i = zzen.zza;
        zzup zzup2 = zzup;
        return zzup.zzb();
    }

    public final long zzc() {
        zzup zzup = this.zzd;
        int i = zzen.zza;
        zzup zzup2 = zzup;
        return zzup.zzc();
    }

    public final long zzd() {
        zzup zzup = this.zzd;
        int i = zzen.zza;
        zzup zzup2 = zzup;
        return zzup.zzd();
    }

    public final long zze(long j) {
        zzup zzup = this.zzd;
        int i = zzen.zza;
        zzup zzup2 = zzup;
        return zzup.zze(j);
    }

    public final long zzf(zzyd[] zzydArr, boolean[] zArr, zzwg[] zzwgArr, boolean[] zArr2, long j) {
        long j2 = this.zzf;
        long j3 = (j2 == -9223372036854775807L || j != this.zzb) ? j : j2;
        this.zzf = -9223372036854775807L;
        zzup zzup = this.zzd;
        int i = zzen.zza;
        zzup zzup2 = zzup;
        return zzup.zzf(zzydArr, zArr, zzwgArr, zArr2, j3);
    }

    public final /* bridge */ /* synthetic */ void zzg(zzwi zzwi) {
        zzup zzup = (zzup) zzwi;
        zzuo zzuo = this.zze;
        int i = zzen.zza;
        zzuo zzuo2 = zzuo;
        zzuo.zzg(this);
    }

    public final zzwr zzh() {
        zzup zzup = this.zzd;
        int i = zzen.zza;
        zzup zzup2 = zzup;
        return zzup.zzh();
    }

    public final void zzi(zzup zzup) {
        zzuo zzuo = this.zze;
        int i = zzen.zza;
        zzuo zzuo2 = zzuo;
        zzuo.zzi(this);
    }

    public final void zzj(long j, boolean z) {
        zzup zzup = this.zzd;
        int i = zzen.zza;
        zzup zzup2 = zzup;
        zzup.zzj(j, false);
    }

    public final void zzk() throws IOException {
        zzup zzup = this.zzd;
        if (zzup != null) {
            zzup.zzk();
            return;
        }
        zzut zzut = this.zzc;
        if (zzut != null) {
            zzut.zzz();
        }
    }

    public final void zzl(zzuo zzuo, long j) {
        this.zze = zzuo;
        zzup zzup = this.zzd;
        if (zzup != null) {
            zzup.zzl(this, zzv(this.zzb));
        }
    }

    public final void zzm(long j) {
        zzup zzup = this.zzd;
        int i = zzen.zza;
        zzup zzup2 = zzup;
        zzup.zzm(j);
    }

    public final long zzn() {
        return this.zzf;
    }

    public final boolean zzo(zzko zzko) {
        zzup zzup = this.zzd;
        return zzup != null && zzup.zzo(zzko);
    }

    public final boolean zzp() {
        zzup zzup = this.zzd;
        return zzup != null && zzup.zzp();
    }

    public final long zzq() {
        return this.zzb;
    }

    public final void zzr(zzur zzur) {
        long zzv = zzv(this.zzb);
        zzut zzut = this.zzc;
        zzut.getClass();
        zzut zzut2 = zzut;
        zzup zzI = zzut.zzI(zzur, this.zzg, zzv);
        this.zzd = zzI;
        if (this.zze != null) {
            zzI.zzl(this, zzv);
        }
    }

    public final void zzs(long j) {
        this.zzf = j;
    }

    public final void zzu(zzut zzut) {
        zzdb.zzf(this.zzc == null);
        this.zzc = zzut;
    }

    public final void zzt() {
        zzup zzup = this.zzd;
        if (zzup != null) {
            zzut zzut = this.zzc;
            zzut.getClass();
            zzut zzut2 = zzut;
            zzut.zzG(zzup);
        }
    }
}
