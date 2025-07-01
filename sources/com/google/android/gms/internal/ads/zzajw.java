package com.google.android.gms.internal.ads;

import androidx.compose.animation.core.AnimationKt;
import java.io.IOException;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
abstract class zzajw {
    private final zzajp zza = new zzajp();
    private zzadx zzb;
    private zzacu zzc;
    private zzajr zzd;
    private long zze;
    private long zzf;
    private long zzg;
    private int zzh;
    private int zzi;
    private zzajt zzj = new zzajt();
    private long zzk;
    private boolean zzl;
    private boolean zzm;

    /* access modifiers changed from: protected */
    public abstract long zza(zzed zzed);

    /* access modifiers changed from: protected */
    public void zzb(boolean z) {
        int i;
        if (z) {
            this.zzj = new zzajt();
            this.zzf = 0;
            i = 0;
        } else {
            i = 1;
        }
        this.zzh = i;
        this.zze = -1;
        this.zzg = 0;
    }

    /* access modifiers changed from: protected */
    @EnsuresNonNullIf(expression = {"#3.format"}, result = false)
    public abstract boolean zzc(zzed zzed, long j, zzajt zzajt) throws IOException;

    /* access modifiers changed from: package-private */
    public final int zze(zzacs zzacs, zzadn zzadn) throws IOException {
        zzacs zzacs2 = zzacs;
        zzdb.zzb(this.zzb);
        int i = zzen.zza;
        int i2 = this.zzh;
        if (i2 == 0) {
            while (this.zza.zze(zzacs2)) {
                long zzf2 = zzacs2.zzf();
                long j = this.zzf;
                this.zzk = zzf2 - j;
                if (zzc(this.zza.zza(), j, this.zzj)) {
                    this.zzf = zzacs2.zzf();
                } else {
                    zzad zzad = this.zzj.zza;
                    this.zzi = zzad.zzD;
                    if (!this.zzm) {
                        this.zzb.zzl(zzad);
                        this.zzm = true;
                    }
                    zzajr zzajr = this.zzj.zzb;
                    if (zzajr != null) {
                        this.zzd = zzajr;
                    } else if (zzacs2.zzd() == -1) {
                        this.zzd = new zzaju((zzajv) null);
                    } else {
                        zzajq zzb2 = this.zza.zzb();
                        this.zzd = new zzajl(this, this.zzf, zzacs.zzd(), (long) (zzb2.zzd + zzb2.zze), zzb2.zzb, (zzb2.zza & 4) != 0);
                    }
                    this.zzh = 2;
                    this.zza.zzd();
                    return 0;
                }
            }
            this.zzh = 3;
            return -1;
        } else if (i2 == 1) {
            zzacs2.zzk((int) this.zzf);
            this.zzh = 2;
            return 0;
        } else if (i2 != 2) {
            return -1;
        } else {
            long zzd2 = this.zzd.zzd(zzacs2);
            if (zzd2 >= 0) {
                zzadn.zza = zzd2;
                return 1;
            }
            if (zzd2 < -1) {
                zzi(-(zzd2 + 2));
            }
            if (!this.zzl) {
                zzadq zze2 = this.zzd.zze();
                zzdb.zzb(zze2);
                zzadq zzadq = zze2;
                this.zzc.zzO(zze2);
                this.zzl = true;
            }
            if (this.zzk > 0 || this.zza.zze(zzacs2)) {
                this.zzk = 0;
                zzed zza2 = this.zza.zza();
                long zza3 = zza(zza2);
                if (zza3 >= 0) {
                    long j2 = this.zzg;
                    if (j2 + zza3 >= this.zze) {
                        long zzf3 = zzf(j2);
                        this.zzb.zzq(zza2, zza2.zze());
                        this.zzb.zzs(zzf3, 1, zza2.zze(), 0, (zzadw) null);
                        this.zze = -1;
                    }
                }
                this.zzg += zza3;
                return 0;
            }
            this.zzh = 3;
            return -1;
        }
    }

    /* access modifiers changed from: protected */
    public final long zzf(long j) {
        return (j * AnimationKt.MillisToNanos) / ((long) this.zzi);
    }

    /* access modifiers changed from: protected */
    public final long zzg(long j) {
        return (((long) this.zzi) * j) / AnimationKt.MillisToNanos;
    }

    /* access modifiers changed from: package-private */
    public final void zzh(zzacu zzacu, zzadx zzadx) {
        this.zzc = zzacu;
        this.zzb = zzadx;
        zzb(true);
    }

    /* access modifiers changed from: protected */
    public void zzi(long j) {
        this.zzg = j;
    }

    /* access modifiers changed from: package-private */
    public final void zzj(long j, long j2) {
        this.zza.zzc();
        if (j == 0) {
            zzb(!this.zzl);
        } else if (this.zzh != 0) {
            this.zze = zzg(j2);
            zzajr zzajr = this.zzd;
            int i = zzen.zza;
            zzajr zzajr2 = zzajr;
            zzajr.zzg(this.zze);
            this.zzh = 2;
        }
    }
}
