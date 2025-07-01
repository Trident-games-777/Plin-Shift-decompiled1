package com.google.android.gms.internal.ads;

import androidx.core.view.ViewCompat;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzamz implements zzamm {
    private final zzed zza = new zzed(new byte[15], 2);
    private final zzec zzb = new zzec();
    private final zzed zzc = new zzed();
    private int zzd = 0;
    private String zze;
    private zzadx zzf;
    private double zzg = -9.223372036854776E18d;
    private double zzh = -9.223372036854776E18d;
    private boolean zzi;
    private boolean zzj = true;
    private int zzk;
    private int zzl;
    private boolean zzm = true;
    private int zzn;
    private int zzo;
    private final zzana zzp = new zzana();
    private int zzq = -2147483647;
    private int zzr = -1;
    private int zzs;
    private long zzt = -1;
    private boolean zzu;

    private static final void zzf(zzed zzed, zzed zzed2, boolean z) {
        int zzd2 = zzed.zzd();
        int min = Math.min(zzed.zzb(), zzed2.zzb());
        zzed.zzH(zzed2.zzN(), zzed2.zzd(), min);
        zzed2.zzM(min);
        if (z) {
            zzed.zzL(zzd2);
        }
    }

    public final void zza(zzed zzed) throws zzbh {
        int i;
        zzdb.zzb(this.zzf);
        while (zzed.zzb() > 0) {
            int i2 = this.zzd;
            int i3 = 0;
            if (i2 == 0) {
                int i4 = this.zzk;
                if ((i4 & 2) == 0) {
                    zzed.zzL(zzed.zze());
                } else {
                    if ((i4 & 4) == 0) {
                        while (true) {
                            if (zzed.zzb() <= 0) {
                                break;
                            }
                            int i5 = this.zzl << 8;
                            this.zzl = i5;
                            int zzm2 = i5 | zzed.zzm();
                            this.zzl = zzm2;
                            if ((zzm2 & ViewCompat.MEASURED_SIZE_MASK) == 12583333) {
                                zzed.zzL(zzed.zzd() - 3);
                                this.zzl = 0;
                                break;
                            }
                        }
                    }
                    this.zzd = 1;
                }
            } else if (i2 != 1) {
                int i6 = this.zzp.zza;
                if (i6 == 1 || i6 == 17) {
                    zzf(zzed, this.zzc, true);
                }
                int min = Math.min(zzed.zzb(), this.zzp.zzc - this.zzn);
                this.zzf.zzq(zzed, min);
                int i7 = this.zzn + min;
                this.zzn = i7;
                zzana zzana = this.zzp;
                if (i7 == zzana.zzc) {
                    int i8 = zzana.zza;
                    if (i8 == 1) {
                        byte[] zzN = this.zzc.zzN();
                        zzanb zza2 = zzand.zza(new zzec(zzN, zzN.length));
                        this.zzq = zza2.zzb;
                        this.zzr = zza2.zzc;
                        long j = this.zzt;
                        long j2 = this.zzp.zzb;
                        if (j != j2) {
                            this.zzt = j2;
                            int i9 = zza2.zza;
                            String str = "mhm1";
                            if (i9 != -1) {
                                str = str.concat(String.valueOf(String.format(".%02X", new Object[]{Integer.valueOf(i9)})));
                            }
                            byte[] bArr = zza2.zzd;
                            zzfzo zzfzo = null;
                            if (bArr != null && bArr.length > 0) {
                                zzfzo = zzfzo.zzp(zzen.zzf, bArr);
                            }
                            zzab zzab = new zzab();
                            zzab.zzL(this.zze);
                            zzab.zzZ("audio/mhm1");
                            zzab.zzaa(this.zzq);
                            zzab.zzA(str);
                            zzab.zzM(zzfzo);
                            this.zzf.zzl(zzab.zzaf());
                        }
                        this.zzu = true;
                    } else if (i8 == 17) {
                        byte[] zzN2 = this.zzc.zzN();
                        zzec zzec = new zzec(zzN2, zzN2.length);
                        if (zzec.zzp()) {
                            zzec.zzn(2);
                            i3 = zzec.zzd(13);
                        }
                        this.zzs = i3;
                    } else if (i8 == 2) {
                        if (this.zzu) {
                            this.zzj = false;
                            i = 1;
                        } else {
                            i = 0;
                        }
                        int i10 = this.zzr - this.zzs;
                        double d = (double) this.zzq;
                        long round = Math.round(this.zzg);
                        if (this.zzi) {
                            this.zzi = false;
                            this.zzg = this.zzh;
                        } else {
                            this.zzg += (((double) i10) * 1000000.0d) / d;
                        }
                        this.zzf.zzs(round, i, this.zzo, 0, (zzadw) null);
                        this.zzu = false;
                        this.zzs = 0;
                        this.zzo = 0;
                    }
                    this.zzd = 1;
                }
            } else {
                zzf(zzed, this.zza, false);
                zzed zzed2 = this.zza;
                if (zzed2.zzb() == 0) {
                    zzec zzec2 = this.zzb;
                    int zze2 = zzed2.zze();
                    zzec2.zzk(zzed2.zzN(), zze2);
                    if (zzand.zzb(this.zzb, this.zzp)) {
                        this.zzn = 0;
                        this.zzo += this.zzp.zzc + zze2;
                        this.zza.zzL(0);
                        zzadx zzadx = this.zzf;
                        zzed zzed3 = this.zza;
                        zzadx.zzq(zzed3, zzed3.zze());
                        this.zza.zzI(2);
                        this.zzc.zzI(this.zzp.zzc);
                        this.zzm = true;
                        this.zzd = 2;
                    } else {
                        zzed zzed4 = this.zza;
                        if (zzed4.zze() < 15) {
                            zzed4.zzK(zzed4.zze() + 1);
                        }
                    }
                }
                this.zzm = false;
            }
        }
    }

    public final void zzb(zzacu zzacu, zzaoa zzaoa) {
        zzaoa.zzc();
        this.zze = zzaoa.zzb();
        this.zzf = zzacu.zzw(zzaoa.zza(), 1);
    }

    public final void zzc(boolean z) {
    }

    public final void zzd(long j, int i) {
        this.zzk = i;
        if (!this.zzj && (this.zzo != 0 || !this.zzm)) {
            this.zzi = true;
        }
        if (j != -9223372036854775807L) {
            double d = (double) j;
            if (this.zzi) {
                this.zzh = d;
            } else {
                this.zzg = d;
            }
        }
    }

    public final void zze() {
        this.zzd = 0;
        this.zzl = 0;
        this.zza.zzI(2);
        this.zzn = 0;
        this.zzo = 0;
        this.zzq = -2147483647;
        this.zzr = -1;
        this.zzs = 0;
        this.zzt = -1;
        this.zzu = false;
        this.zzi = false;
        this.zzm = true;
        this.zzj = true;
        this.zzg = -9.223372036854776E18d;
        this.zzh = -9.223372036854776E18d;
    }
}
