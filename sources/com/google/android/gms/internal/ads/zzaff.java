package com.google.android.gms.internal.ads;

import coil3.util.UtilsKt;
import java.io.IOException;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzaff implements zzacr {
    private final zzed zza = new zzed(6);
    private zzacu zzb;
    private int zzc;
    private int zzd;
    private int zze;
    private long zzf = -1;
    private zzagz zzg;
    private zzacs zzh;
    private zzafi zzi;
    private zzaiy zzj;

    private final int zza(zzacs zzacs) throws IOException {
        this.zza.zzI(2);
        ((zzacg) zzacs).zzm(this.zza.zzN(), 0, 2, false);
        return this.zza.zzq();
    }

    public final int zzb(zzacs zzacs, zzadn zzadn) throws IOException {
        String zzy;
        zzafh zza2;
        long j;
        zzacs zzacs2 = zzacs;
        zzadn zzadn2 = zzadn;
        int i = this.zzc;
        long j2 = -1;
        if (i == 0) {
            this.zza.zzI(2);
            zzacs2.zzi(this.zza.zzN(), 0, 2);
            int zzq = this.zza.zzq();
            this.zzd = zzq;
            if (zzq == 65498) {
                if (this.zzf != -1) {
                    this.zzc = 4;
                } else {
                    zzg();
                }
            } else if ((zzq < 65488 || zzq > 65497) && zzq != 65281) {
                this.zzc = 1;
            }
            return 0;
        } else if (i == 1) {
            this.zza.zzI(2);
            zzacs2.zzi(this.zza.zzN(), 0, 2);
            this.zze = this.zza.zzq() - 2;
            this.zzc = 2;
            return 0;
        } else if (i == 2) {
            if (this.zzd == 65505) {
                zzed zzed = new zzed(this.zze);
                zzacs2.zzi(zzed.zzN(), 0, this.zze);
                if (this.zzg == null && "http://ns.adobe.com/xap/1.0/".equals(zzed.zzy(0)) && (zzy = zzed.zzy(0)) != null) {
                    long zzd2 = zzacs2.zzd();
                    zzagz zzagz = null;
                    if (!(zzd2 == -1 || (zza2 = zzafl.zza(zzy)) == null || zza2.zzb.size() < 2)) {
                        int size = zza2.zzb.size() - 1;
                        long j3 = -1;
                        long j4 = -1;
                        long j5 = -1;
                        long j6 = -1;
                        boolean z = false;
                        while (size >= 0) {
                            zzafg zzafg = (zzafg) zza2.zzb.get(size);
                            long j7 = j2;
                            boolean equals = "video/mp4".equals(zzafg.zza) | z;
                            if (size == 0) {
                                zzd2 -= zzafg.zzc;
                                j = 0;
                            } else {
                                j = zzd2 - zzafg.zzb;
                            }
                            long j8 = j;
                            long j9 = zzd2;
                            zzd2 = j8;
                            if (equals && zzd2 != j9) {
                                j6 = j9 - zzd2;
                                j5 = zzd2;
                                equals = false;
                            }
                            if (size == 0) {
                                j4 = j9;
                            }
                            if (size == 0) {
                                j3 = zzd2;
                            }
                            size--;
                            z = equals;
                            j2 = j7;
                        }
                        long j10 = j2;
                        if (!(j5 == j10 || j6 == j10 || j3 == j10 || j4 == j10)) {
                            zzagz = new zzagz(j3, j4, zza2.zza, j5, j6);
                        }
                    }
                    this.zzg = zzagz;
                    if (zzagz != null) {
                        this.zzf = zzagz.zzd;
                    }
                }
            } else {
                zzacs2.zzk(this.zze);
            }
            this.zzc = 0;
            return 0;
        } else if (i == 4) {
            long zzf2 = zzacs2.zzf();
            long j11 = this.zzf;
            if (zzf2 == j11) {
                if (!zzacs2.zzm(this.zza.zzN(), 0, 1, true)) {
                    zzg();
                } else {
                    zzacs2.zzj();
                    if (this.zzj == null) {
                        this.zzj = new zzaiy(zzakg.zza, 8);
                    }
                    zzafi zzafi = new zzafi(zzacs2, this.zzf);
                    this.zzi = zzafi;
                    if (this.zzj.zzi(zzafi)) {
                        zzaiy zzaiy = this.zzj;
                        long j12 = this.zzf;
                        zzacu zzacu = this.zzb;
                        zzacu.getClass();
                        zzacu zzacu2 = zzacu;
                        zzaiy.zze(new zzafk(j12, zzacu));
                        zzagz zzagz2 = this.zzg;
                        zzagz2.getClass();
                        zzagz zzagz3 = zzagz2;
                        zzacu zzacu3 = this.zzb;
                        zzacu3.getClass();
                        zzacu zzacu4 = zzacu3;
                        zzadx zzw = zzacu3.zzw(1024, 4);
                        zzab zzab = new zzab();
                        zzab.zzC(UtilsKt.MIME_TYPE_JPEG);
                        zzab.zzS(new zzbd(-9223372036854775807L, zzagz2));
                        zzw.zzl(zzab.zzaf());
                        this.zzc = 5;
                    } else {
                        zzg();
                    }
                }
                return 0;
            }
            zzadn2.zza = j11;
            return 1;
        } else if (i == 5) {
            if (this.zzi == null || zzacs2 != this.zzh) {
                this.zzh = zzacs2;
                this.zzi = new zzafi(zzacs2, this.zzf);
            }
            zzaiy zzaiy2 = this.zzj;
            zzaiy2.getClass();
            zzaiy zzaiy3 = zzaiy2;
            int zzb2 = zzaiy2.zzb(this.zzi, zzadn2);
            if (zzb2 == 1) {
                zzadn2.zza += this.zzf;
            }
            return zzb2;
        } else if (i == 6) {
            return -1;
        } else {
            throw new IllegalStateException();
        }
    }

    public final /* synthetic */ zzacr zzc() {
        return this;
    }

    public final /* synthetic */ List zzd() {
        return zzfzo.zzn();
    }

    public final void zze(zzacu zzacu) {
        this.zzb = zzacu;
    }

    public final boolean zzi(zzacs zzacs) throws IOException {
        if (zza(zzacs) != 65496) {
            return false;
        }
        int zza2 = zza(zzacs);
        this.zzd = zza2;
        if (zza2 == 65504) {
            this.zza.zzI(2);
            zzacg zzacg = (zzacg) zzacs;
            zzacg.zzm(this.zza.zzN(), 0, 2, false);
            zzacg.zzl(this.zza.zzq() - 2, false);
            zza2 = zza(zzacs);
            this.zzd = zza2;
        }
        if (zza2 == 65505) {
            zzacg zzacg2 = (zzacg) zzacs;
            zzacg2.zzl(2, false);
            this.zza.zzI(6);
            zzacg2.zzm(this.zza.zzN(), 0, 6, false);
            if (this.zza.zzu() == 1165519206 && this.zza.zzq() == 0) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final void zzf(long j, long j2) {
        if (j == 0) {
            this.zzc = 0;
            this.zzj = null;
        } else if (this.zzc == 5) {
            zzaiy zzaiy = this.zzj;
            zzaiy.getClass();
            zzaiy zzaiy2 = zzaiy;
            zzaiy.zzf(j, j2);
        }
    }

    private final void zzg() {
        zzacu zzacu = this.zzb;
        zzacu.getClass();
        zzacu zzacu2 = zzacu;
        zzacu.zzD();
        this.zzb.zzO(new zzadp(-9223372036854775807L, 0));
        this.zzc = 6;
    }
}
