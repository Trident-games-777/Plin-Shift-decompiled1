package com.google.android.gms.internal.ads;

import android.os.SystemClock;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzlg {
    private static final zzur zzu = new zzur(new Object(), -1);
    public final zzbv zza;
    public final zzur zzb;
    public final long zzc;
    public final long zzd;
    public final int zze;
    public final zzig zzf;
    public final boolean zzg;
    public final zzwr zzh;
    public final zzyk zzi;
    public final List zzj;
    public final zzur zzk;
    public final boolean zzl;
    public final int zzm;
    public final int zzn;
    public final zzbj zzo;
    public final boolean zzp = false;
    public volatile long zzq;
    public volatile long zzr;
    public volatile long zzs;
    public volatile long zzt;

    public zzlg(zzbv zzbv, zzur zzur, long j, long j2, int i, zzig zzig, boolean z, zzwr zzwr, zzyk zzyk, List list, zzur zzur2, boolean z2, int i2, int i3, zzbj zzbj, long j3, long j4, long j5, long j6, boolean z3) {
        this.zza = zzbv;
        this.zzb = zzur;
        this.zzc = j;
        this.zzd = j2;
        this.zze = i;
        this.zzf = zzig;
        this.zzg = z;
        this.zzh = zzwr;
        this.zzi = zzyk;
        this.zzj = list;
        this.zzk = zzur2;
        this.zzl = z2;
        this.zzm = i2;
        this.zzn = i3;
        this.zzo = zzbj;
        this.zzq = j3;
        this.zzr = j4;
        this.zzs = j5;
        this.zzt = j6;
    }

    public static zzlg zzg(zzyk zzyk) {
        zzbv zzbv = zzbv.zza;
        zzur zzur = zzu;
        return new zzlg(zzbv, zzur, -9223372036854775807L, 0, 1, (zzig) null, false, zzwr.zza, zzyk, zzfzo.zzn(), zzur, false, 1, 0, zzbj.zza, 0, 0, 0, 0, false);
    }

    public static zzur zzh() {
        return zzu;
    }

    public final zzlg zza(zzur zzur) {
        boolean z = this.zzl;
        int i = this.zzm;
        int i2 = this.zzn;
        zzbj zzbj = this.zzo;
        long j = this.zzq;
        long j2 = this.zzr;
        long j3 = this.zzs;
        long j4 = this.zzt;
        int i3 = i;
        int i4 = i2;
        long j5 = j3;
        long j6 = j4;
        return new zzlg(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, this.zzh, this.zzi, this.zzj, zzur, z, i3, i4, zzbj, j, j2, j5, j6, false);
    }

    public final zzlg zzb(zzur zzur, long j, long j2, long j3, long j4, zzwr zzwr, zzyk zzyk, List list) {
        zzur zzur2 = this.zzk;
        boolean z = this.zzl;
        int i = this.zzm;
        int i2 = this.zzn;
        zzbj zzbj = this.zzo;
        long j5 = this.zzq;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        int i3 = i2;
        zzbj zzbj2 = zzbj;
        return new zzlg(this.zza, zzur, j2, j3, this.zze, this.zzf, this.zzg, zzwr, zzyk, list, zzur2, z, i, i3, zzbj2, j5, j4, j, elapsedRealtime, false);
    }

    public final zzlg zzc(boolean z, int i, int i2) {
        zzbj zzbj = this.zzo;
        long j = this.zzq;
        long j2 = this.zzr;
        long j3 = this.zzs;
        long j4 = this.zzt;
        zzbj zzbj2 = zzbj;
        long j5 = j;
        long j6 = j4;
        return new zzlg(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, this.zzh, this.zzi, this.zzj, this.zzk, z, i, i2, zzbj2, j5, j2, j3, j6, false);
    }

    public final zzlg zzd(zzig zzig) {
        boolean z = this.zzg;
        zzwr zzwr = this.zzh;
        zzyk zzyk = this.zzi;
        List list = this.zzj;
        zzur zzur = this.zzk;
        boolean z2 = this.zzl;
        int i = this.zzm;
        int i2 = this.zzn;
        zzbj zzbj = this.zzo;
        long j = this.zzq;
        long j2 = this.zzr;
        int i3 = i2;
        zzbj zzbj2 = zzbj;
        long j3 = j;
        long j4 = j2;
        return new zzlg(this.zza, this.zzb, this.zzc, this.zzd, this.zze, zzig, z, zzwr, zzyk, list, zzur, z2, i, i3, zzbj2, j3, j4, this.zzs, this.zzt, false);
    }

    public final zzlg zze(int i) {
        zzig zzig = this.zzf;
        boolean z = this.zzg;
        zzwr zzwr = this.zzh;
        zzyk zzyk = this.zzi;
        List list = this.zzj;
        zzur zzur = this.zzk;
        boolean z2 = this.zzl;
        int i2 = this.zzm;
        int i3 = this.zzn;
        zzbj zzbj = this.zzo;
        long j = this.zzq;
        long j2 = this.zzr;
        int i4 = i2;
        int i5 = i4;
        int i6 = i3;
        zzbj zzbj2 = zzbj;
        long j3 = j;
        long j4 = j2;
        return new zzlg(this.zza, this.zzb, this.zzc, this.zzd, i, zzig, z, zzwr, zzyk, list, zzur, z2, i5, i6, zzbj2, j3, j4, this.zzs, this.zzt, false);
    }

    public final zzlg zzf(zzbv zzbv) {
        return new zzlg(zzbv, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, this.zzh, this.zzi, this.zzj, this.zzk, this.zzl, this.zzm, this.zzn, this.zzo, this.zzq, this.zzr, this.zzs, this.zzt, false);
    }

    public final boolean zzi() {
        return this.zze == 3 && this.zzl && this.zzn == 0;
    }
}
