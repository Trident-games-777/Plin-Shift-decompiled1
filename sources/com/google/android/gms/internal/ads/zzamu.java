package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzamu {
    private final zzadx zza;
    private long zzb;
    private boolean zzc;
    private int zzd;
    private long zze;
    private boolean zzf;
    private boolean zzg;
    private boolean zzh;
    private boolean zzi;
    private boolean zzj;
    private long zzk;
    private long zzl;
    private boolean zzm;

    public zzamu(zzadx zzadx) {
        this.zza = zzadx;
    }

    private final void zzf(int i) {
        long j = this.zzl;
        if (j != -9223372036854775807L) {
            this.zza.zzs(j, this.zzm ? 1 : 0, (int) (this.zzb - this.zzk), i, (zzadw) null);
        }
    }

    public final void zza(long j) {
        this.zzm = this.zzc;
        zzf((int) (j - this.zzb));
        this.zzk = this.zzb;
        this.zzb = j;
        zzf(0);
        this.zzi = false;
    }

    public final void zzb(long j, int i, boolean z) {
        if (this.zzj && this.zzg) {
            this.zzm = this.zzc;
            this.zzj = false;
        } else if (this.zzh || this.zzg) {
            if (z && this.zzi) {
                zzf(i + ((int) (j - this.zzb)));
            }
            this.zzk = this.zzb;
            this.zzl = this.zze;
            this.zzm = this.zzc;
            this.zzi = true;
        }
    }

    public final void zzc(byte[] bArr, int i, int i2) {
        if (this.zzf) {
            int i3 = this.zzd;
            int i4 = (i + 2) - i3;
            if (i4 < i2) {
                this.zzg = (bArr[i4] & 128) != 0;
                this.zzf = false;
                return;
            }
            this.zzd = i3 + (i2 - i);
        }
    }

    public final void zzd() {
        this.zzf = false;
        this.zzg = false;
        this.zzh = false;
        this.zzi = false;
        this.zzj = false;
    }

    public final void zze(long j, int i, int i2, long j2, boolean z) {
        boolean z2 = false;
        this.zzg = false;
        this.zzh = false;
        this.zze = j2;
        this.zzd = 0;
        this.zzb = j;
        if (i2 >= 32 && i2 != 40) {
            if (this.zzi && !this.zzj) {
                if (z) {
                    zzf(i);
                }
                this.zzi = false;
            }
            if (i2 <= 35 || i2 == 39) {
                this.zzh = !this.zzj;
                this.zzj = true;
            }
        }
        boolean z3 = i2 >= 16 && i2 <= 21;
        this.zzc = z3;
        if (z3 || i2 <= 9) {
            z2 = true;
        }
        this.zzf = z2;
    }
}
