package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzwf implements zzadx {
    private boolean zzA;
    private zzrq zzB;
    private final zzvz zza;
    private final zzwb zzb = new zzwb();
    private final zzwm zzc = new zzwm(new zzwa());
    private final zzrp zzd;
    private final zzrk zze;
    private zzwd zzf;
    private zzad zzg;
    private int zzh = 1000;
    private long[] zzi = new long[1000];
    private long[] zzj = new long[1000];
    private int[] zzk = new int[1000];
    private int[] zzl = new int[1000];
    private long[] zzm = new long[1000];
    private zzadw[] zzn = new zzadw[1000];
    private int zzo;
    private int zzp;
    private int zzq;
    private int zzr;
    private long zzs = Long.MIN_VALUE;
    private long zzt = Long.MIN_VALUE;
    private long zzu = Long.MIN_VALUE;
    private boolean zzv;
    private boolean zzw = true;
    private boolean zzx = true;
    private zzad zzy;
    private boolean zzz = true;

    protected zzwf(zzys zzys, zzrp zzrp, zzrk zzrk) {
        this.zzd = zzrp;
        this.zze = zzrk;
        this.zza = new zzvz(zzys);
    }

    private final int zzA(int i, int i2, long j, boolean z) {
        int i3 = -1;
        for (int i4 = 0; i4 < i2; i4++) {
            int i5 = (this.zzm[i] > j ? 1 : (this.zzm[i] == j ? 0 : -1));
            if (i5 > 0) {
                break;
            }
            if (!z || (this.zzl[i] & 1) != 0) {
                if (i5 == 0) {
                    return i4;
                }
                i3 = i4;
            }
            i++;
            if (i == this.zzh) {
                i = 0;
            }
        }
        return i3;
    }

    private final int zzB(int i) {
        int i2 = this.zzq + i;
        int i3 = this.zzh;
        return i2 < i3 ? i2 : i2 - i3;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0027, code lost:
        return -3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final synchronized int zzC(com.google.android.gms.internal.ads.zzkj r7, com.google.android.gms.internal.ads.zzhm r8, boolean r9, boolean r10, com.google.android.gms.internal.ads.zzwb r11) {
        /*
            r6 = this;
            monitor-enter(r6)
            r0 = 0
            r8.zzd = r0     // Catch:{ all -> 0x0092 }
            boolean r0 = r6.zzK()     // Catch:{ all -> 0x0092 }
            r1 = -5
            r2 = -3
            r3 = -4
            if (r0 != 0) goto L_0x0032
            if (r10 != 0) goto L_0x0028
            boolean r10 = r6.zzv     // Catch:{ all -> 0x0092 }
            if (r10 == 0) goto L_0x0014
            goto L_0x0028
        L_0x0014:
            com.google.android.gms.internal.ads.zzad r8 = r6.zzy     // Catch:{ all -> 0x0092 }
            if (r8 == 0) goto L_0x0026
            if (r9 != 0) goto L_0x001e
            com.google.android.gms.internal.ads.zzad r9 = r6.zzg     // Catch:{ all -> 0x0092 }
            if (r8 == r9) goto L_0x0026
        L_0x001e:
            r9 = r8
            com.google.android.gms.internal.ads.zzad r9 = (com.google.android.gms.internal.ads.zzad) r9     // Catch:{ all -> 0x0092 }
            r6.zzH(r8, r7)     // Catch:{ all -> 0x0092 }
            monitor-exit(r6)
            return r1
        L_0x0026:
            monitor-exit(r6)
            return r2
        L_0x0028:
            r7 = 4
            r8.zzc(r7)     // Catch:{ all -> 0x0092 }
            r9 = -9223372036854775808
            r8.zze = r9     // Catch:{ all -> 0x0092 }
            monitor-exit(r6)
            return r3
        L_0x0032:
            com.google.android.gms.internal.ads.zzwm r0 = r6.zzc     // Catch:{ all -> 0x0092 }
            int r4 = r6.zzp     // Catch:{ all -> 0x0092 }
            int r5 = r6.zzr     // Catch:{ all -> 0x0092 }
            int r4 = r4 + r5
            java.lang.Object r0 = r0.zza(r4)     // Catch:{ all -> 0x0092 }
            com.google.android.gms.internal.ads.zzwc r0 = (com.google.android.gms.internal.ads.zzwc) r0     // Catch:{ all -> 0x0092 }
            com.google.android.gms.internal.ads.zzad r0 = r0.zza     // Catch:{ all -> 0x0092 }
            if (r9 != 0) goto L_0x008d
            com.google.android.gms.internal.ads.zzad r9 = r6.zzg     // Catch:{ all -> 0x0092 }
            if (r0 == r9) goto L_0x0048
            goto L_0x008d
        L_0x0048:
            int r7 = r6.zzr     // Catch:{ all -> 0x0092 }
            int r7 = r6.zzB(r7)     // Catch:{ all -> 0x0092 }
            boolean r9 = r6.zzL(r7)     // Catch:{ all -> 0x0092 }
            if (r9 != 0) goto L_0x0059
            r7 = 1
            r8.zzd = r7     // Catch:{ all -> 0x0092 }
            monitor-exit(r6)
            return r2
        L_0x0059:
            int[] r9 = r6.zzl     // Catch:{ all -> 0x0092 }
            r9 = r9[r7]     // Catch:{ all -> 0x0092 }
            r8.zzc(r9)     // Catch:{ all -> 0x0092 }
            int r9 = r6.zzr     // Catch:{ all -> 0x0092 }
            int r0 = r6.zzo     // Catch:{ all -> 0x0092 }
            int r0 = r0 + -1
            if (r9 != r0) goto L_0x0073
            if (r10 != 0) goto L_0x006e
            boolean r9 = r6.zzv     // Catch:{ all -> 0x0092 }
            if (r9 == 0) goto L_0x0073
        L_0x006e:
            r9 = 536870912(0x20000000, float:1.0842022E-19)
            r8.zza(r9)     // Catch:{ all -> 0x0092 }
        L_0x0073:
            long[] r9 = r6.zzm     // Catch:{ all -> 0x0092 }
            r9 = r9[r7]     // Catch:{ all -> 0x0092 }
            r8.zze = r9     // Catch:{ all -> 0x0092 }
            int[] r8 = r6.zzk     // Catch:{ all -> 0x0092 }
            r8 = r8[r7]     // Catch:{ all -> 0x0092 }
            r11.zza = r8     // Catch:{ all -> 0x0092 }
            long[] r8 = r6.zzj     // Catch:{ all -> 0x0092 }
            r8 = r8[r7]     // Catch:{ all -> 0x0092 }
            r11.zzb = r8     // Catch:{ all -> 0x0092 }
            com.google.android.gms.internal.ads.zzadw[] r8 = r6.zzn     // Catch:{ all -> 0x0092 }
            r7 = r8[r7]     // Catch:{ all -> 0x0092 }
            r11.zzc = r7     // Catch:{ all -> 0x0092 }
            monitor-exit(r6)
            return r3
        L_0x008d:
            r6.zzH(r0, r7)     // Catch:{ all -> 0x0092 }
            monitor-exit(r6)
            return r1
        L_0x0092:
            r7 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x0092 }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzwf.zzC(com.google.android.gms.internal.ads.zzkj, com.google.android.gms.internal.ads.zzhm, boolean, boolean, com.google.android.gms.internal.ads.zzwb):int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0030, code lost:
        return -1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final synchronized long zzD(long r8, boolean r10, boolean r11) {
        /*
            r7 = this;
            monitor-enter(r7)
            int r10 = r7.zzo     // Catch:{ all -> 0x0033 }
            if (r10 == 0) goto L_0x002e
            long[] r0 = r7.zzm     // Catch:{ all -> 0x0033 }
            int r2 = r7.zzq     // Catch:{ all -> 0x0033 }
            r0 = r0[r2]     // Catch:{ all -> 0x0033 }
            int r0 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r0 >= 0) goto L_0x0010
            goto L_0x002e
        L_0x0010:
            if (r11 == 0) goto L_0x001d
            int r11 = r7.zzr     // Catch:{ all -> 0x0019 }
            if (r11 == r10) goto L_0x001d
            int r10 = r11 + 1
            goto L_0x001d
        L_0x0019:
            r0 = move-exception
            r8 = r0
            r1 = r7
            goto L_0x0036
        L_0x001d:
            r3 = r10
            r6 = 0
            r1 = r7
            r4 = r8
            int r8 = r1.zzA(r2, r3, r4, r6)     // Catch:{ all -> 0x0038 }
            r9 = -1
            if (r8 == r9) goto L_0x002f
            long r8 = r7.zzF(r8)     // Catch:{ all -> 0x0038 }
            monitor-exit(r7)
            return r8
        L_0x002e:
            r1 = r7
        L_0x002f:
            monitor-exit(r7)
            r8 = -1
            return r8
        L_0x0033:
            r0 = move-exception
            r1 = r7
        L_0x0035:
            r8 = r0
        L_0x0036:
            monitor-exit(r7)     // Catch:{ all -> 0x0038 }
            throw r8
        L_0x0038:
            r0 = move-exception
            goto L_0x0035
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzwf.zzD(long, boolean, boolean):long");
    }

    private final synchronized long zzE() {
        int i = this.zzo;
        if (i == 0) {
            return -1;
        }
        return zzF(i);
    }

    private final synchronized void zzG(long j, int i, long j2, int i2, zzadw zzadw) {
        int i3 = this.zzo;
        if (i3 > 0) {
            int zzB2 = zzB(i3 - 1);
            zzdb.zzd(this.zzj[zzB2] + ((long) this.zzk[zzB2]) <= j2);
        }
        this.zzv = (536870912 & i) != 0;
        this.zzu = Math.max(this.zzu, j);
        int zzB3 = zzB(this.zzo);
        this.zzm[zzB3] = j;
        this.zzj[zzB3] = j2;
        this.zzk[zzB3] = i2;
        this.zzl[zzB3] = i;
        this.zzn[zzB3] = zzadw;
        this.zzi[zzB3] = 0;
        if (this.zzc.zzf() || !((zzwc) this.zzc.zzb()).zza.equals(this.zzy)) {
            zzad zzad = this.zzy;
            if (zzad != null) {
                zzad zzad2 = zzad;
                this.zzc.zzc(this.zzp + this.zzo, new zzwc(zzad, this.zzd.zzb(this.zze, zzad), (zzwe) null));
            } else {
                throw null;
            }
        }
        int i4 = this.zzo + 1;
        this.zzo = i4;
        int i5 = this.zzh;
        if (i4 == i5) {
            int i6 = i5 + 1000;
            long[] jArr = new long[i6];
            long[] jArr2 = new long[i6];
            long[] jArr3 = new long[i6];
            int[] iArr = new int[i6];
            int[] iArr2 = new int[i6];
            zzadw[] zzadwArr = new zzadw[i6];
            int i7 = this.zzq;
            int i8 = i5 - i7;
            System.arraycopy(this.zzj, i7, jArr2, 0, i8);
            System.arraycopy(this.zzm, this.zzq, jArr3, 0, i8);
            System.arraycopy(this.zzl, this.zzq, iArr, 0, i8);
            System.arraycopy(this.zzk, this.zzq, iArr2, 0, i8);
            System.arraycopy(this.zzn, this.zzq, zzadwArr, 0, i8);
            System.arraycopy(this.zzi, this.zzq, jArr, 0, i8);
            int i9 = this.zzq;
            System.arraycopy(this.zzj, 0, jArr2, i8, i9);
            System.arraycopy(this.zzm, 0, jArr3, i8, i9);
            System.arraycopy(this.zzl, 0, iArr, i8, i9);
            System.arraycopy(this.zzk, 0, iArr2, i8, i9);
            System.arraycopy(this.zzn, 0, zzadwArr, i8, i9);
            System.arraycopy(this.zzi, 0, jArr, i8, i9);
            this.zzj = jArr2;
            this.zzm = jArr3;
            this.zzl = iArr;
            this.zzk = iArr2;
            this.zzn = zzadwArr;
            this.zzi = jArr;
            this.zzq = 0;
            this.zzh = i6;
        }
    }

    private final void zzH(zzad zzad, zzkj zzkj) {
        zzw zzw2;
        zzad zzad2 = this.zzg;
        if (zzad2 == null) {
            zzw2 = null;
        } else {
            zzw2 = zzad2.zzs;
        }
        this.zzg = zzad;
        zzw zzw3 = zzad.zzs;
        zzkj.zza = zzad.zzc(this.zzd.zza(zzad));
        zzkj.zzb = this.zzB;
        if (zzad2 == null || !Objects.equals(zzw2, zzw3)) {
            zzrq zzc2 = this.zzd.zzc(this.zze, zzad);
            this.zzB = zzc2;
            zzkj.zzb = zzc2;
        }
    }

    private final void zzI() {
        if (this.zzB != null) {
            this.zzB = null;
            this.zzg = null;
        }
    }

    private final synchronized void zzJ() {
        this.zzr = 0;
        this.zza.zzg();
    }

    private final boolean zzK() {
        return this.zzr != this.zzo;
    }

    private final boolean zzL(int i) {
        if (this.zzB == null) {
            return true;
        }
        int i2 = this.zzl[i];
        return false;
    }

    private final synchronized boolean zzM(zzad zzad) {
        this.zzx = false;
        if (Objects.equals(zzad, this.zzy)) {
            return false;
        }
        if (this.zzc.zzf() || !((zzwc) this.zzc.zzb()).zza.equals(zzad)) {
            this.zzy = zzad;
        } else {
            this.zzy = ((zzwc) this.zzc.zzb()).zza;
        }
        boolean z = this.zzz;
        zzad zzad2 = this.zzy;
        this.zzz = z & zzbg.zzf(zzad2.zzo, zzad2.zzk);
        this.zzA = false;
        return true;
    }

    public final int zza() {
        return this.zzp;
    }

    public final int zzb() {
        return this.zzp + this.zzr;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0036, code lost:
        if (r9 != -1) goto L_0x0039;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0038, code lost:
        return 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0039, code lost:
        return r9;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized int zzc(long r9, boolean r11) {
        /*
            r8 = this;
            monitor-enter(r8)
            int r0 = r8.zzr     // Catch:{ all -> 0x003d }
            int r2 = r8.zzB(r0)     // Catch:{ all -> 0x003d }
            boolean r1 = r8.zzK()     // Catch:{ all -> 0x003d }
            r7 = 0
            if (r1 == 0) goto L_0x003a
            long[] r1 = r8.zzm     // Catch:{ all -> 0x003d }
            r3 = r1[r2]     // Catch:{ all -> 0x003d }
            int r1 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r1 >= 0) goto L_0x0017
            goto L_0x003a
        L_0x0017:
            long r3 = r8.zzu     // Catch:{ all -> 0x003d }
            int r1 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r1 <= 0) goto L_0x0029
            if (r11 != 0) goto L_0x0020
            goto L_0x0029
        L_0x0020:
            int r9 = r8.zzo     // Catch:{ all -> 0x0025 }
            int r9 = r9 - r0
            monitor-exit(r8)
            return r9
        L_0x0025:
            r0 = move-exception
            r9 = r0
            r1 = r8
            goto L_0x0040
        L_0x0029:
            int r11 = r8.zzo     // Catch:{ all -> 0x003d }
            int r3 = r11 - r0
            r6 = 1
            r1 = r8
            r4 = r9
            int r9 = r1.zzA(r2, r3, r4, r6)     // Catch:{ all -> 0x0042 }
            r10 = -1
            monitor-exit(r8)
            if (r9 != r10) goto L_0x0039
            return r7
        L_0x0039:
            return r9
        L_0x003a:
            r1 = r8
            monitor-exit(r8)
            return r7
        L_0x003d:
            r0 = move-exception
            r1 = r8
        L_0x003f:
            r9 = r0
        L_0x0040:
            monitor-exit(r8)     // Catch:{ all -> 0x0042 }
            throw r9
        L_0x0042:
            r0 = move-exception
            goto L_0x003f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzwf.zzc(long, boolean):int");
    }

    public final int zzd() {
        return this.zzp + this.zzo;
    }

    public final int zze(zzkj zzkj, zzhm zzhm, int i, boolean z) {
        zzhm zzhm2 = zzhm;
        int zzC = zzC(zzkj, zzhm2, (i & 2) != 0, z, this.zzb);
        if (zzC != -4) {
            return zzC;
        }
        if (!zzhm2.zzf()) {
            int i2 = i & 1;
            if ((i & 4) == 0) {
                if (i2 != 0) {
                    this.zza.zzd(zzhm2, this.zzb);
                    return -4;
                }
                this.zza.zze(zzhm2, this.zzb);
            } else if (i2 != 0) {
                return -4;
            }
            this.zzr++;
        }
        return -4;
    }

    public final /* synthetic */ int zzf(zzn zzn2, int i, boolean z) {
        return zzadv.zza(this, zzn2, i, z);
    }

    public final int zzg(zzn zzn2, int i, boolean z, int i2) throws IOException {
        return this.zza.zza(zzn2, i, z);
    }

    public final synchronized long zzh() {
        return this.zzu;
    }

    public final synchronized zzad zzi() {
        if (this.zzx) {
            return null;
        }
        return this.zzy;
    }

    public final void zzj(long j, boolean z, boolean z2) {
        this.zza.zzc(zzD(j, false, z2));
    }

    public final void zzk() {
        this.zza.zzc(zzE());
    }

    public final void zzl(zzad zzad) {
        boolean zzM = zzM(zzad);
        zzwd zzwd = this.zzf;
        if (zzwd != null && zzM) {
            zzwd.zzM(zzad);
        }
    }

    public final void zzm() throws IOException {
        zzrq zzrq = this.zzB;
        if (zzrq != null) {
            zzri zza2 = zzrq.zza();
            zzri zzri = zza2;
            throw zza2;
        }
    }

    public final void zzn() {
        zzk();
        zzI();
    }

    public final void zzo() {
        zzp(true);
        zzI();
    }

    public final void zzp(boolean z) {
        this.zza.zzf();
        this.zzo = 0;
        this.zzp = 0;
        this.zzq = 0;
        this.zzr = 0;
        this.zzw = true;
        this.zzs = Long.MIN_VALUE;
        this.zzt = Long.MIN_VALUE;
        this.zzu = Long.MIN_VALUE;
        this.zzv = false;
        this.zzc.zzd();
        if (z) {
            this.zzy = null;
            this.zzx = true;
            this.zzz = true;
        }
    }

    public final /* synthetic */ void zzq(zzed zzed, int i) {
        zzadv.zzb(this, zzed, i);
    }

    public final void zzr(zzed zzed, int i, int i2) {
        this.zza.zzh(zzed, i);
    }

    public final void zzs(long j, int i, int i2, int i3, zzadw zzadw) {
        if (this.zzw) {
            if ((i & 1) != 0) {
                this.zzw = false;
            } else {
                return;
            }
        }
        if (this.zzz) {
            if (j < this.zzs) {
                return;
            }
            if ((i & 1) == 0) {
                if (!this.zzA) {
                    zzdt.zzf("SampleQueue", "Overriding unexpected non-sync sample for format: ".concat(String.valueOf(String.valueOf(this.zzy))));
                    this.zzA = true;
                }
                i |= 1;
            }
        }
        zzG(j, i, (this.zza.zzb() - ((long) i2)) - ((long) i3), i2, zzadw);
    }

    public final void zzt(long j) {
        this.zzs = j;
    }

    public final void zzu(zzwd zzwd) {
        this.zzf = zzwd;
    }

    public final synchronized void zzv(int i) {
        boolean z = false;
        if (i >= 0) {
            try {
                if (this.zzr + i <= this.zzo) {
                    z = true;
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        zzdb.zzd(z);
        this.zzr += i;
    }

    public final synchronized boolean zzw() {
        return this.zzv;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x001c, code lost:
        return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean zzx(boolean r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = r3.zzK()     // Catch:{ all -> 0x003e }
            r1 = 1
            if (r0 != 0) goto L_0x001d
            if (r4 != 0) goto L_0x001b
            boolean r4 = r3.zzv     // Catch:{ all -> 0x003e }
            if (r4 != 0) goto L_0x001b
            com.google.android.gms.internal.ads.zzad r4 = r3.zzy     // Catch:{ all -> 0x003e }
            r0 = 0
            if (r4 == 0) goto L_0x001a
            com.google.android.gms.internal.ads.zzad r2 = r3.zzg     // Catch:{ all -> 0x003e }
            if (r4 == r2) goto L_0x0018
            goto L_0x001b
        L_0x0018:
            monitor-exit(r3)
            return r0
        L_0x001a:
            r1 = r0
        L_0x001b:
            monitor-exit(r3)
            return r1
        L_0x001d:
            com.google.android.gms.internal.ads.zzwm r4 = r3.zzc     // Catch:{ all -> 0x003e }
            int r0 = r3.zzp     // Catch:{ all -> 0x003e }
            int r2 = r3.zzr     // Catch:{ all -> 0x003e }
            int r0 = r0 + r2
            java.lang.Object r4 = r4.zza(r0)     // Catch:{ all -> 0x003e }
            com.google.android.gms.internal.ads.zzwc r4 = (com.google.android.gms.internal.ads.zzwc) r4     // Catch:{ all -> 0x003e }
            com.google.android.gms.internal.ads.zzad r4 = r4.zza     // Catch:{ all -> 0x003e }
            com.google.android.gms.internal.ads.zzad r0 = r3.zzg     // Catch:{ all -> 0x003e }
            if (r4 == r0) goto L_0x0032
            monitor-exit(r3)
            return r1
        L_0x0032:
            int r4 = r3.zzr     // Catch:{ all -> 0x003e }
            int r4 = r3.zzB(r4)     // Catch:{ all -> 0x003e }
            boolean r4 = r3.zzL(r4)     // Catch:{ all -> 0x003e }
            monitor-exit(r3)
            return r4
        L_0x003e:
            r4 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x003e }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzwf.zzx(boolean):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0019, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean zzy(int r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            r3.zzJ()     // Catch:{ all -> 0x001b }
            int r0 = r3.zzp     // Catch:{ all -> 0x001b }
            if (r4 < r0) goto L_0x0018
            int r1 = r3.zzo     // Catch:{ all -> 0x001b }
            int r1 = r1 + r0
            if (r4 <= r1) goto L_0x000e
            goto L_0x0018
        L_0x000e:
            r1 = -9223372036854775808
            r3.zzs = r1     // Catch:{ all -> 0x001b }
            int r4 = r4 - r0
            r3.zzr = r4     // Catch:{ all -> 0x001b }
            monitor-exit(r3)
            r4 = 1
            return r4
        L_0x0018:
            monitor-exit(r3)
            r4 = 0
            return r4
        L_0x001b:
            r4 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x001b }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzwf.zzy(int):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:40:0x006b, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean zzz(long r11, boolean r13) {
        /*
            r10 = this;
            monitor-enter(r10)
            r10.zzJ()     // Catch:{ all -> 0x006c }
            int r0 = r10.zzr     // Catch:{ all -> 0x006c }
            int r2 = r10.zzB(r0)     // Catch:{ all -> 0x006c }
            boolean r1 = r10.zzK()     // Catch:{ all -> 0x006c }
            r7 = 0
            if (r1 == 0) goto L_0x0069
            long[] r1 = r10.zzm     // Catch:{ all -> 0x006c }
            r3 = r1[r2]     // Catch:{ all -> 0x006c }
            int r1 = (r11 > r3 ? 1 : (r11 == r3 ? 0 : -1))
            if (r1 < 0) goto L_0x0069
            long r3 = r10.zzu     // Catch:{ all -> 0x006c }
            int r1 = (r11 > r3 ? 1 : (r11 == r3 ? 0 : -1))
            r8 = 1
            if (r1 <= 0) goto L_0x0023
            if (r13 == 0) goto L_0x0069
            r13 = r8
        L_0x0023:
            boolean r1 = r10.zzz     // Catch:{ all -> 0x006c }
            r9 = -1
            if (r1 == 0) goto L_0x0052
            int r1 = r10.zzo     // Catch:{ all -> 0x004e }
            int r1 = r1 - r0
            r0 = r7
        L_0x002c:
            if (r0 >= r1) goto L_0x0044
            long[] r3 = r10.zzm     // Catch:{ all -> 0x004e }
            r3 = r3[r2]     // Catch:{ all -> 0x004e }
            int r3 = (r3 > r11 ? 1 : (r3 == r11 ? 0 : -1))
            if (r3 >= 0) goto L_0x0040
            int r2 = r2 + 1
            int r3 = r10.zzh     // Catch:{ all -> 0x004e }
            if (r2 != r3) goto L_0x003d
            r2 = r7
        L_0x003d:
            int r0 = r0 + 1
            goto L_0x002c
        L_0x0040:
            r1 = r10
            r4 = r11
            r11 = r0
            goto L_0x005d
        L_0x0044:
            if (r13 == 0) goto L_0x004a
            r4 = r11
            r11 = r1
            r1 = r10
            goto L_0x005d
        L_0x004a:
            r1 = r10
            r4 = r11
            r11 = r9
            goto L_0x005d
        L_0x004e:
            r0 = move-exception
            r11 = r0
            r1 = r10
            goto L_0x006f
        L_0x0052:
            int r13 = r10.zzo     // Catch:{ all -> 0x006c }
            int r3 = r13 - r0
            r6 = 1
            r1 = r10
            r4 = r11
            int r11 = r1.zzA(r2, r3, r4, r6)     // Catch:{ all -> 0x0071 }
        L_0x005d:
            if (r11 != r9) goto L_0x0060
            goto L_0x006a
        L_0x0060:
            r1.zzs = r4     // Catch:{ all -> 0x0071 }
            int r12 = r1.zzr     // Catch:{ all -> 0x0071 }
            int r12 = r12 + r11
            r1.zzr = r12     // Catch:{ all -> 0x0071 }
            monitor-exit(r10)
            return r8
        L_0x0069:
            r1 = r10
        L_0x006a:
            monitor-exit(r10)
            return r7
        L_0x006c:
            r0 = move-exception
            r1 = r10
        L_0x006e:
            r11 = r0
        L_0x006f:
            monitor-exit(r10)     // Catch:{ all -> 0x0071 }
            throw r11
        L_0x0071:
            r0 = move-exception
            goto L_0x006e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzwf.zzz(long, boolean):boolean");
    }

    private final long zzF(int i) {
        long j = this.zzt;
        long j2 = Long.MIN_VALUE;
        if (i != 0) {
            int zzB2 = zzB(i - 1);
            for (int i2 = 0; i2 < i; i2++) {
                j2 = Math.max(j2, this.zzm[zzB2]);
                if ((this.zzl[zzB2] & 1) != 0) {
                    break;
                }
                zzB2--;
                if (zzB2 == -1) {
                    zzB2 = this.zzh - 1;
                }
            }
        }
        this.zzt = Math.max(j, j2);
        this.zzo -= i;
        int i3 = this.zzp + i;
        this.zzp = i3;
        int i4 = this.zzq + i;
        this.zzq = i4;
        int i5 = this.zzh;
        if (i4 >= i5) {
            this.zzq = i4 - i5;
        }
        int i6 = this.zzr - i;
        this.zzr = i6;
        if (i6 < 0) {
            this.zzr = 0;
        }
        this.zzc.zze(i3);
        if (this.zzo != 0) {
            return this.zzj[this.zzq];
        }
        int i7 = this.zzq;
        if (i7 == 0) {
            i7 = this.zzh;
        }
        int i8 = i7 - 1;
        return this.zzj[i8] + ((long) this.zzk[i8]);
    }
}
