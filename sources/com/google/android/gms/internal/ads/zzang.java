package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzang implements zzaob {
    private final zzamm zza;
    private final zzec zzb = new zzec(new byte[10], 10);
    private int zzc = 0;
    private int zzd;
    private zzek zze;
    private boolean zzf;
    private boolean zzg;
    private boolean zzh;
    private int zzi;
    private int zzj;
    private boolean zzk;

    public zzang(zzamm zzamm) {
        this.zza = zzamm;
    }

    private final void zze(int i) {
        this.zzc = i;
        this.zzd = 0;
    }

    private final boolean zzf(zzed zzed, byte[] bArr, int i) {
        int min = Math.min(zzed.zzb(), i - this.zzd);
        if (min <= 0) {
            return true;
        }
        if (bArr == null) {
            zzed.zzM(min);
        } else {
            zzed.zzH(bArr, this.zzd, min);
        }
        int i2 = this.zzd + min;
        this.zzd = i2;
        if (i2 == i) {
            return true;
        }
        return false;
    }

    public final void zza(zzed zzed, int i) throws zzbh {
        int i2;
        int i3;
        long j;
        long j2;
        zzed zzed2 = zzed;
        zzdb.zzb(this.zze);
        int i4 = -1;
        int i5 = 2;
        if ((i & 1) != 0) {
            int i6 = this.zzc;
            if (!(i6 == 0 || i6 == 1)) {
                if (i6 != 2) {
                    int i7 = this.zzj;
                    if (i7 != -1) {
                        zzdt.zzf("PesReader", "Unexpected start indicator: expected " + i7 + " more bytes");
                    }
                    this.zza.zzc(zzed2.zze() == 0);
                } else {
                    zzdt.zzf("PesReader", "Unexpected start indicator reading extended header");
                }
            }
            zze(1);
        }
        int i8 = i;
        while (zzed2.zzb() > 0) {
            int i9 = this.zzc;
            if (i9 == 0) {
                i2 = i5;
                zzed2.zzM(zzed2.zzb());
            } else if (i9 != 1) {
                if (i9 != i5) {
                    int zzb2 = zzed2.zzb();
                    int i10 = this.zzj;
                    int i11 = i10 == i4 ? 0 : zzb2 - i10;
                    if (i11 > 0) {
                        zzb2 -= i11;
                        zzed2.zzK(zzed2.zzd() + zzb2);
                    }
                    this.zza.zza(zzed2);
                    int i12 = this.zzj;
                    if (i12 != i4) {
                        int i13 = i12 - zzb2;
                        this.zzj = i13;
                        if (i13 == 0) {
                            this.zza.zzc(false);
                            zze(1);
                        }
                    }
                } else {
                    if (zzf(zzed2, this.zzb.zza, Math.min(10, this.zzi)) && zzf(zzed2, (byte[]) null, this.zzi)) {
                        this.zzb.zzl(0);
                        if (this.zzf) {
                            this.zzb.zzn(4);
                            long zzd2 = (long) this.zzb.zzd(3);
                            this.zzb.zzn(1);
                            int zzd3 = this.zzb.zzd(15) << 15;
                            this.zzb.zzn(1);
                            long zzd4 = (long) this.zzb.zzd(15);
                            this.zzb.zzn(1);
                            if (this.zzh || !this.zzg) {
                                j2 = zzd2;
                            } else {
                                this.zzb.zzn(4);
                                j2 = zzd2;
                                this.zzb.zzn(1);
                                this.zzb.zzn(1);
                                this.zzb.zzn(1);
                                this.zze.zzb((((long) this.zzb.zzd(3)) << 30) | ((long) (this.zzb.zzd(15) << 15)) | ((long) this.zzb.zzd(15)));
                                this.zzh = true;
                            }
                            j = this.zze.zzb((j2 << 30) | ((long) zzd3) | zzd4);
                        } else {
                            j = -9223372036854775807L;
                        }
                        i8 |= true != this.zzk ? 0 : 4;
                        this.zza.zzd(j, i8);
                        zze(3);
                        i4 = -1;
                        i5 = 2;
                    }
                }
                i2 = i5;
            } else if (zzf(zzed2, this.zzb.zza, 9)) {
                this.zzb.zzl(0);
                int zzd5 = this.zzb.zzd(24);
                if (zzd5 != 1) {
                    zzdt.zzf("PesReader", "Unexpected start code prefix: " + zzd5);
                    i4 = -1;
                    this.zzj = -1;
                    i3 = 0;
                    i2 = 2;
                } else {
                    this.zzb.zzn(8);
                    zzec zzec = this.zzb;
                    int zzd6 = zzec.zzd(16);
                    zzec.zzn(5);
                    this.zzk = this.zzb.zzp();
                    i2 = 2;
                    this.zzb.zzn(2);
                    this.zzf = this.zzb.zzp();
                    this.zzg = this.zzb.zzp();
                    this.zzb.zzn(6);
                    int zzd7 = this.zzb.zzd(8);
                    this.zzi = zzd7;
                    if (zzd6 == 0) {
                        this.zzj = -1;
                        i4 = -1;
                    } else {
                        int i14 = (zzd6 - 3) - zzd7;
                        this.zzj = i14;
                        if (i14 < 0) {
                            zzdt.zzf("PesReader", "Found negative packet payload size: " + i14);
                            i4 = -1;
                            this.zzj = -1;
                        } else {
                            i4 = -1;
                        }
                    }
                    i3 = 2;
                }
                zze(i3);
            } else {
                i4 = -1;
                i2 = 2;
            }
            i5 = i2;
        }
    }

    public final void zzb(zzek zzek, zzacu zzacu, zzaoa zzaoa) {
        this.zze = zzek;
        this.zza.zzb(zzacu, zzaoa);
    }

    public final void zzc() {
        this.zzc = 0;
        this.zzd = 0;
        this.zzh = false;
        this.zza.zze();
    }

    public final boolean zzd(boolean z) {
        return this.zzc == 3 && this.zzj == -1;
    }
}
