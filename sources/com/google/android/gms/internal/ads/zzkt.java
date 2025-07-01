package com.google.android.gms.internal.ads;

import android.util.Pair;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzkt {
    private final zzbt zza = new zzbt();
    private final zzbu zzb = new zzbu();
    private final zzlw zzc;
    private final zzdm zzd;
    private long zze;
    private int zzf;
    private boolean zzg;
    private zzkq zzh;
    private zzkq zzi;
    private zzkq zzj;
    private int zzk;
    private Object zzl;
    private long zzm;
    private zziq zzn;
    private List zzo = new ArrayList();
    private final zzjz zzp;

    public zzkt(zzlw zzlw, zzdm zzdm, zzjz zzjz, zziq zziq) {
        this.zzc = zzlw;
        this.zzd = zzdm;
        this.zzp = zzjz;
        this.zzn = zziq;
    }

    private final zzkr zzA(zzbv zzbv, Object obj, long j, long j2, long j3) {
        long j4;
        long j5;
        long j6;
        zzbv zzbv2 = zzbv;
        Object obj2 = obj;
        long j7 = j;
        zzbv2.zzn(obj2, this.zza);
        int zzc2 = this.zza.zzc(j7);
        if (zzc2 != -1) {
            this.zza.zzj(zzc2);
        }
        if (zzc2 == -1) {
            this.zza.zzb();
        } else {
            this.zza.zzk(zzc2);
        }
        zzur zzur = new zzur(obj2, j3, zzc2);
        boolean zzG = zzG(zzur);
        boolean zzE = zzE(zzbv2, zzur);
        boolean zzD = zzD(zzbv2, zzur, zzG);
        if (zzc2 != -1) {
            this.zza.zzk(zzc2);
        }
        if (zzc2 != -1) {
            this.zza.zzg(zzc2);
            j4 = 0;
        } else {
            j4 = -9223372036854775807L;
        }
        if (j4 != -9223372036854775807L) {
            j6 = 0;
            j5 = 0;
        } else {
            j6 = j4;
            j5 = this.zza.zzd;
        }
        if (j5 != -9223372036854775807L && j7 >= j5) {
            j7 = Math.max(0, j5 - 1);
        }
        return new zzkr(zzur, j7, j2, j6, j5, false, zzG, zzE, zzD);
    }

    private static zzur zzB(zzbv zzbv, Object obj, long j, long j2, zzbu zzbu, zzbt zzbt) {
        zzbv.zzn(obj, zzbt);
        zzbv.zze(zzbt.zzc, zzbu, 0);
        zzbv.zza(obj);
        zzbt.zzb();
        zzbv.zzn(obj, zzbt);
        long j3 = j;
        int zzd2 = zzbt.zzd(j3);
        if (zzd2 == -1) {
            return new zzur(obj, j2, zzbt.zzc(j3));
        }
        return new zzur(obj, zzd2, zzbt.zze(zzd2), j2);
    }

    private final void zzC() {
        zzur zzur;
        zzfzl zzfzl = new zzfzl();
        for (zzkq zzkq = this.zzh; zzkq != null; zzkq = zzkq.zzg()) {
            zzfzl.zzf(zzkq.zzf.zza);
        }
        zzkq zzkq2 = this.zzi;
        if (zzkq2 == null) {
            zzur = null;
        } else {
            zzur = zzkq2.zzf.zza;
        }
        this.zzd.zzh(new zzks(this, zzfzl, zzur));
    }

    private final boolean zzD(zzbv zzbv, zzur zzur, boolean z) {
        int zza2 = zzbv.zza(zzur.zza);
        if (!zzbv.zze(zzbv.zzd(zza2, this.zza, false).zzc, this.zzb, 0).zzi) {
            if (zzbv.zzi(zza2, this.zza, this.zzb, this.zzf, this.zzg) != -1 || !z) {
                return false;
            }
            return true;
        }
        return false;
    }

    private final boolean zzE(zzbv zzbv, zzur zzur) {
        if (!zzG(zzur)) {
            return false;
        }
        int i = zzbv.zzn(zzur.zza, this.zza).zzc;
        if (zzbv.zze(i, this.zzb, 0).zzo == zzbv.zza(zzur.zza)) {
            return true;
        }
        return false;
    }

    private final boolean zzF(zzbv zzbv) {
        zzbv zzbv2;
        zzkq zzkq = this.zzh;
        if (zzkq == null) {
            return true;
        }
        int zza2 = zzbv.zza(zzkq.zzb);
        while (true) {
            zzbv2 = zzbv;
            zza2 = zzbv2.zzi(zza2, this.zza, this.zzb, this.zzf, this.zzg);
            while (true) {
                zzkq.getClass();
                zzkq zzkq2 = zzkq;
                if (zzkq.zzg() == null || zzkq.zzf.zzg) {
                    zzkq zzg2 = zzkq.zzg();
                } else {
                    zzkq = zzkq.zzg();
                }
            }
            zzkq zzg22 = zzkq.zzg();
            if (zza2 == -1 || zzg22 == null || zzbv2.zza(zzg22.zzb) != zza2) {
                boolean zzq = zzq(zzkq);
                zzkq.zzf = zzh(zzbv2, zzkq.zzf);
            } else {
                zzkq = zzg22;
                zzbv = zzbv2;
            }
        }
        boolean zzq2 = zzq(zzkq);
        zzkq.zzf = zzh(zzbv2, zzkq.zzf);
        if (!zzq2) {
            return true;
        }
        return false;
    }

    private static final boolean zzG(zzur zzur) {
        return !zzur.zzb() && zzur.zze == -1;
    }

    static boolean zzo(long j, long j2) {
        return j == -9223372036854775807L || j == j2;
    }

    private final long zzv(zzbv zzbv, Object obj, int i) {
        zzbv.zzn(obj, this.zza);
        this.zza.zzg(i);
        long j = this.zza.zzg.zza(i).zzg;
        return 0;
    }

    private final long zzw(Object obj) {
        for (int i = 0; i < this.zzo.size(); i++) {
            zzkq zzkq = (zzkq) this.zzo.get(i);
            if (zzkq.zzb.equals(obj)) {
                return zzkq.zzf.zza.zzd;
            }
        }
        return -1;
    }

    private final zzkr zzx(zzbv zzbv, zzkq zzkq, long j) {
        zzbv zzbv2;
        long j2;
        Object obj;
        zzbv zzbv3 = zzbv;
        zzkq zzkq2 = zzkq;
        zzkr zzkr = zzkq2.zzf;
        long zze2 = (zzkq2.zze() + zzkr.zze) - j;
        if (zzkr.zzg) {
            long j3 = 0;
            int zzi2 = zzbv3.zzi(zzbv3.zza(zzkr.zza.zza), this.zza, this.zzb, this.zzf, this.zzg);
            if (zzi2 == -1) {
                return null;
            }
            int i = zzbv3.zzd(zzi2, this.zza, true).zzc;
            Object obj2 = this.zza.zzb;
            obj2.getClass();
            long j4 = zzkr.zza.zzd;
            if (zzbv3.zze(i, this.zzb, 0).zzn == zzi2) {
                Pair zzm2 = zzbv3.zzm(this.zzb, this.zza, i, -9223372036854775807L, Math.max(0, zze2));
                if (zzm2 == null) {
                    return null;
                }
                Object obj3 = zzm2.first;
                long longValue = ((Long) zzm2.second).longValue();
                zzkq zzg2 = zzkq2.zzg();
                if (zzg2 == null || !zzg2.zzb.equals(obj3)) {
                    long zzw = zzw(obj3);
                    if (zzw == -1) {
                        zzw = this.zze;
                        this.zze = 1 + zzw;
                    }
                    j4 = zzw;
                } else {
                    j4 = zzg2.zzf.zza.zzd;
                }
                obj = obj3;
                j2 = longValue;
                j3 = -9223372036854775807L;
            } else {
                obj = obj2;
                j2 = 0;
            }
            zzbv zzbv4 = zzbv;
            zzur zzB = zzB(zzbv4, obj, j2, j4, this.zzb, this.zza);
            if (!(j3 == -9223372036854775807L || zzkr.zzc == -9223372036854775807L)) {
                zzbv4.zzn(zzkr.zza.zza, this.zza).zzb();
                int i2 = this.zza.zzg.zzd;
            }
            return zzy(zzbv4, zzB, j3, j2);
        }
        zzur zzur = zzkr.zza;
        zzbv3.zzn(zzur.zza, this.zza);
        if (zzur.zzb()) {
            int i3 = zzur.zzb;
            if (this.zza.zza(i3) == -1) {
                return null;
            }
            int zza2 = this.zza.zzg.zza(i3).zza(zzur.zzc);
            if (zza2 < 0) {
                return zzz(zzbv3, zzur.zza, i3, zza2, zzkr.zzc, zzur.zzd);
            }
            long j5 = zzkr.zzc;
            if (j5 == -9223372036854775807L) {
                zzbu zzbu = this.zzb;
                zzbt zzbt = this.zza;
                zzbv zzbv5 = zzbv;
                Pair zzm3 = zzbv5.zzm(zzbu, zzbt, zzbt.zzc, -9223372036854775807L, Math.max(0, zze2));
                zzbv2 = zzbv5;
                if (zzm3 == null) {
                    return null;
                }
                j5 = ((Long) zzm3.second).longValue();
            } else {
                zzbv2 = zzbv;
            }
            zzv(zzbv2, zzur.zza, zzur.zzb);
            return zzA(zzbv, zzur.zza, Math.max(0, j5), zzkr.zzc, zzur.zzd);
        }
        int i4 = zzur.zze;
        if (i4 != -1) {
            this.zza.zzj(i4);
        }
        zzbt zzbt2 = this.zza;
        int i5 = zzur.zze;
        int zze3 = zzbt2.zze(i5);
        zzbt2.zzk(i5);
        if (zze3 != this.zza.zza(zzur.zze)) {
            return zzz(zzbv, zzur.zza, zzur.zze, zze3, zzkr.zze, zzur.zzd);
        }
        zzbv zzbv6 = zzbv;
        zzv(zzbv6, zzur.zza, zzur.zze);
        return zzA(zzbv6, zzur.zza, 0, zzkr.zze, zzur.zzd);
    }

    private final zzkr zzy(zzbv zzbv, zzur zzur, long j, long j2) {
        zzbv.zzn(zzur.zza, this.zza);
        if (zzur.zzb()) {
            return zzz(zzbv, zzur.zza, zzur.zzb, zzur.zzc, j, zzur.zzd);
        }
        return zzA(zzbv, zzur.zza, j2, j, zzur.zzd);
    }

    private final zzkr zzz(zzbv zzbv, Object obj, int i, int i2, long j, long j2) {
        zzur zzur = new zzur(obj, i, i2, j2);
        Object obj2 = zzur.zza;
        long zzf2 = zzbv.zzn(obj2, this.zza).zzf(zzur.zzb, zzur.zzc);
        if (i2 == this.zza.zze(i)) {
            this.zza.zzh();
        }
        this.zza.zzk(zzur.zzb);
        long j3 = 0;
        if (zzf2 != -9223372036854775807L && zzf2 <= 0) {
            j3 = Math.max(0, -1 + zzf2);
        }
        return new zzkr(zzur, j3, j, -9223372036854775807L, zzf2, false, false, false, false);
    }

    public final zzkq zza() {
        zzkq zzkq = this.zzh;
        if (zzkq == null) {
            return null;
        }
        if (zzkq == this.zzi) {
            this.zzi = zzkq.zzg();
        }
        zzkq.zzn();
        int i = this.zzk - 1;
        this.zzk = i;
        if (i == 0) {
            this.zzj = null;
            zzkq zzkq2 = this.zzh;
            this.zzl = zzkq2.zzb;
            this.zzm = zzkq2.zzf.zza.zzd;
        }
        this.zzh = this.zzh.zzg();
        zzC();
        return this.zzh;
    }

    public final zzkq zzb() {
        zzkq zzkq = this.zzi;
        zzdb.zzb(zzkq);
        zzkq zzkq2 = zzkq;
        this.zzi = zzkq.zzg();
        zzC();
        zzkq zzkq3 = this.zzi;
        zzdb.zzb(zzkq3);
        zzkq zzkq4 = zzkq3;
        return zzkq3;
    }

    public final zzkq zzd() {
        return this.zzj;
    }

    public final zzkq zze() {
        return this.zzh;
    }

    public final zzkq zzf() {
        return this.zzi;
    }

    public final zzkr zzg(long j, zzlg zzlg) {
        zzkq zzkq = this.zzj;
        if (zzkq == null) {
            return zzy(zzlg.zza, zzlg.zzb, zzlg.zzc, zzlg.zzs);
        }
        return zzx(zzlg.zza, zzkq, j);
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0063  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzkr zzh(com.google.android.gms.internal.ads.zzbv r16, com.google.android.gms.internal.ads.zzkr r17) {
        /*
            r15 = this;
            r1 = r16
            r2 = r17
            com.google.android.gms.internal.ads.zzur r3 = r2.zza
            boolean r12 = zzG(r3)
            boolean r13 = r15.zzE(r1, r3)
            boolean r14 = r15.zzD(r1, r3, r12)
            com.google.android.gms.internal.ads.zzur r4 = r2.zza
            java.lang.Object r4 = r4.zza
            com.google.android.gms.internal.ads.zzbt r5 = r15.zza
            r1.zzn(r4, r5)
            boolean r1 = r3.zzb()
            r4 = -1
            r5 = 0
            r7 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r1 != 0) goto L_0x0035
            int r1 = r3.zze
            if (r1 != r4) goto L_0x002e
            goto L_0x0035
        L_0x002e:
            com.google.android.gms.internal.ads.zzbt r9 = r15.zza
            r9.zzg(r1)
            r9 = r5
            goto L_0x0036
        L_0x0035:
            r9 = r7
        L_0x0036:
            boolean r1 = r3.zzb()
            if (r1 == 0) goto L_0x0049
            com.google.android.gms.internal.ads.zzbt r1 = r15.zza
            int r5 = r3.zzb
            int r6 = r3.zzc
            long r5 = r1.zzf(r5, r6)
        L_0x0046:
            r7 = r9
            r9 = r5
            goto L_0x0055
        L_0x0049:
            int r1 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r1 == 0) goto L_0x0050
            r7 = r5
            r9 = r7
            goto L_0x0055
        L_0x0050:
            com.google.android.gms.internal.ads.zzbt r1 = r15.zza
            long r5 = r1.zzd
            goto L_0x0046
        L_0x0055:
            boolean r1 = r3.zzb()
            if (r1 == 0) goto L_0x0063
            com.google.android.gms.internal.ads.zzbt r1 = r15.zza
            int r4 = r3.zzb
            r1.zzk(r4)
            goto L_0x006c
        L_0x0063:
            int r1 = r3.zze
            if (r1 == r4) goto L_0x006c
            com.google.android.gms.internal.ads.zzbt r4 = r15.zza
            r4.zzk(r1)
        L_0x006c:
            com.google.android.gms.internal.ads.zzkr r1 = new com.google.android.gms.internal.ads.zzkr
            r5 = r3
            long r3 = r2.zzb
            r16 = r1
            long r0 = r2.zzc
            r11 = 0
            r2 = r5
            r5 = r0
            r1 = r16
            r1.<init>(r2, r3, r5, r7, r9, r11, r12, r13, r14)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzkt.zzh(com.google.android.gms.internal.ads.zzbv, com.google.android.gms.internal.ads.zzkr):com.google.android.gms.internal.ads.zzkr");
    }

    public final zzur zzi(zzbv zzbv, Object obj, long j) {
        long j2;
        int zza2;
        int i = zzbv.zzn(obj, this.zza).zzc;
        Object obj2 = this.zzl;
        if (obj2 == null || (zza2 = zzbv.zza(obj2)) == -1 || zzbv.zzd(zza2, this.zza, false).zzc != i) {
            zzkq zzkq = this.zzh;
            while (true) {
                if (zzkq == null) {
                    zzkq zzkq2 = this.zzh;
                    while (true) {
                        if (zzkq2 != null) {
                            int zza3 = zzbv.zza(zzkq2.zzb);
                            if (zza3 != -1 && zzbv.zzd(zza3, this.zza, false).zzc == i) {
                                j2 = zzkq2.zzf.zza.zzd;
                                break;
                            }
                            zzkq2 = zzkq2.zzg();
                        } else {
                            j2 = zzw(obj);
                            if (j2 == -1) {
                                j2 = this.zze;
                                this.zze = 1 + j2;
                                if (this.zzh == null) {
                                    this.zzl = obj;
                                    this.zzm = j2;
                                }
                            }
                        }
                    }
                } else if (zzkq.zzb.equals(obj)) {
                    j2 = zzkq.zzf.zza.zzd;
                    break;
                } else {
                    zzkq = zzkq.zzg();
                }
            }
        } else {
            j2 = this.zzm;
        }
        zzbv.zzn(obj, this.zza);
        zzbv.zze(this.zza.zzc, this.zzb, 0);
        int zza4 = zzbv.zza(obj);
        Object obj3 = obj;
        while (true) {
            zzbu zzbu = this.zzb;
            if (zza4 >= zzbu.zzn) {
                zzbv.zzd(zza4, this.zza, true);
                this.zza.zzb();
                zzbt zzbt = this.zza;
                if (zzbt.zzd(zzbt.zzd) != -1) {
                    obj3 = this.zza.zzb;
                    obj3.getClass();
                }
                zza4--;
            } else {
                return zzB(zzbv, obj3, j, j2, zzbu, this.zza);
            }
        }
    }

    public final void zzj() {
        if (this.zzk != 0) {
            zzkq zzkq = this.zzh;
            zzdb.zzb(zzkq);
            zzkq zzkq2 = zzkq;
            this.zzl = zzkq.zzb;
            this.zzm = zzkq.zzf.zza.zzd;
            while (zzkq != null) {
                zzkq.zzn();
                zzkq = zzkq.zzg();
            }
            this.zzh = null;
            this.zzj = null;
            this.zzi = null;
            this.zzk = 0;
            zzC();
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzk(zzfzl zzfzl, zzur zzur) {
        this.zzc.zzT(zzfzl.zzi(), zzur);
    }

    public final void zzl(long j) {
        zzkq zzkq = this.zzj;
        if (zzkq != null) {
            zzkq.zzm(j);
        }
    }

    public final void zzm() {
        if (!this.zzo.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < this.zzo.size(); i++) {
                ((zzkq) this.zzo.get(i)).zzn();
            }
            this.zzo = arrayList;
        }
    }

    public final void zzn(zzbv zzbv, zziq zziq) {
        this.zzn = zziq;
        long j = zziq.zzb;
        zzm();
    }

    public final boolean zzp(zzup zzup) {
        zzkq zzkq = this.zzj;
        return zzkq != null && zzkq.zza == zzup;
    }

    public final boolean zzq(zzkq zzkq) {
        zzdb.zzb(zzkq);
        boolean z = false;
        if (zzkq.equals(this.zzj)) {
            return false;
        }
        this.zzj = zzkq;
        while (zzkq.zzg() != null) {
            zzkq = zzkq.zzg();
            zzkq.getClass();
            zzkq zzkq2 = zzkq;
            if (zzkq == this.zzi) {
                this.zzi = this.zzh;
                z = true;
            }
            zzkq.zzn();
            this.zzk--;
        }
        zzkq zzkq3 = this.zzj;
        zzkq3.getClass();
        zzkq zzkq4 = zzkq3;
        zzkq3.zzo((zzkq) null);
        zzC();
        return z;
    }

    public final boolean zzr() {
        zzkq zzkq = this.zzj;
        if (zzkq != null) {
            return !zzkq.zzf.zzi && zzkq.zzr() && this.zzj.zzf.zze != -9223372036854775807L && this.zzk < 100;
        }
        return true;
    }

    public final boolean zzs(zzbv zzbv, long j, long j2) {
        zzkr zzkr;
        long j3;
        boolean z;
        zzkq zzkq = null;
        for (zzkq zzkq2 = this.zzh; zzkq2 != null; zzkq2 = zzkq2.zzg()) {
            zzkr zzkr2 = zzkq2.zzf;
            if (zzkq == null) {
                zzkr = zzh(zzbv, zzkr2);
                long j4 = j;
            } else {
                zzkr zzx = zzx(zzbv, zzkq, j);
                if (zzx == null) {
                    return !zzq(zzkq);
                }
                if (zzkr2.zzb != zzx.zzb || !zzkr2.zza.equals(zzx.zza)) {
                    return !zzq(zzkq);
                }
                zzkr = zzx;
            }
            zzkq2.zzf = zzkr.zza(zzkr2.zzc);
            if (!zzo(zzkr2.zze, zzkr.zze)) {
                zzkq2.zzq();
                long j5 = zzkr.zze;
                if (j5 == -9223372036854775807L) {
                    j3 = Long.MAX_VALUE;
                } else {
                    j3 = j5 + zzkq2.zze();
                }
                if (zzkq2 == this.zzi) {
                    boolean z2 = zzkq2.zzf.zzf;
                    if (j2 == Long.MIN_VALUE || j2 >= j3) {
                        z = true;
                        return zzq(zzkq2) && !z;
                    }
                }
                z = false;
                if (zzq(zzkq2)) {
                }
            }
            zzkq = zzkq2;
        }
        return true;
    }

    public final boolean zzt(zzbv zzbv, int i) {
        this.zzf = i;
        return zzF(zzbv);
    }

    public final boolean zzu(zzbv zzbv, boolean z) {
        this.zzg = z;
        return zzF(zzbv);
    }

    public final zzkq zzc(zzkr zzkr) {
        long j;
        zzkq zzkq;
        zzkq zzkq2 = this.zzj;
        if (zzkq2 == null) {
            j = 1000000000000L;
        } else {
            j = (zzkq2.zze() + zzkq2.zzf.zze) - zzkr.zzb;
        }
        int i = 0;
        while (true) {
            if (i >= this.zzo.size()) {
                zzkq = null;
                break;
            }
            zzkr zzkr2 = ((zzkq) this.zzo.get(i)).zzf;
            if (zzo(zzkr2.zze, zzkr.zze) && zzkr2.zzb == zzkr.zzb && zzkr2.zza.equals(zzkr.zza)) {
                zzkq = (zzkq) this.zzo.remove(i);
                break;
            }
            i++;
        }
        if (zzkq == null) {
            zzkq = zzkh.zzd(this.zzp.zza, zzkr, j);
        } else {
            zzkq.zzf = zzkr;
            zzkq.zzp(j);
        }
        zzkq zzkq3 = this.zzj;
        if (zzkq3 != null) {
            zzkq3.zzo(zzkq);
        } else {
            this.zzh = zzkq;
            this.zzi = zzkq;
        }
        this.zzl = null;
        this.zzj = zzkq;
        this.zzk++;
        zzC();
        return zzkq;
    }
}
