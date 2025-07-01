package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
public final class zzhbo {
    private static final zzhbo zza = new zzhbo(0, new int[0], new Object[0], false);
    private int zzb;
    private int[] zzc;
    private Object[] zzd;
    private int zze;
    private boolean zzf;

    private zzhbo() {
        this(0, new int[8], new Object[8], true);
    }

    private zzhbo(int i, int[] iArr, Object[] objArr, boolean z) {
        this.zze = -1;
        this.zzb = i;
        this.zzc = iArr;
        this.zzd = objArr;
        this.zzf = z;
    }

    public static zzhbo zzc() {
        return zza;
    }

    static zzhbo zze(zzhbo zzhbo, zzhbo zzhbo2) {
        int i = zzhbo.zzb + zzhbo2.zzb;
        int[] copyOf = Arrays.copyOf(zzhbo.zzc, i);
        System.arraycopy(zzhbo2.zzc, 0, copyOf, zzhbo.zzb, zzhbo2.zzb);
        Object[] copyOf2 = Arrays.copyOf(zzhbo.zzd, i);
        System.arraycopy(zzhbo2.zzd, 0, copyOf2, zzhbo.zzb, zzhbo2.zzb);
        return new zzhbo(i, copyOf, copyOf2, true);
    }

    static zzhbo zzf() {
        return new zzhbo();
    }

    private final void zzn(int i) {
        int[] iArr = this.zzc;
        if (i > iArr.length) {
            int i2 = this.zzb;
            int i3 = i2 + (i2 / 2);
            if (i3 >= i) {
                i = i3;
            }
            if (i < 8) {
                i = 8;
            }
            this.zzc = Arrays.copyOf(iArr, i);
            this.zzd = Arrays.copyOf(this.zzd, i);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzhbo)) {
            return false;
        }
        zzhbo zzhbo = (zzhbo) obj;
        int i = this.zzb;
        if (i == zzhbo.zzb) {
            int[] iArr = this.zzc;
            int[] iArr2 = zzhbo.zzc;
            int i2 = 0;
            while (true) {
                if (i2 >= i) {
                    Object[] objArr = this.zzd;
                    Object[] objArr2 = zzhbo.zzd;
                    int i3 = this.zzb;
                    int i4 = 0;
                    while (i4 < i3) {
                        if (objArr[i4].equals(objArr2[i4])) {
                            i4++;
                        }
                    }
                    return true;
                } else if (iArr[i2] != iArr2[i2]) {
                    break;
                } else {
                    i2++;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = this.zzb;
        int i2 = i + 527;
        int[] iArr = this.zzc;
        int i3 = 17;
        int i4 = 17;
        for (int i5 = 0; i5 < i; i5++) {
            i4 = (i4 * 31) + iArr[i5];
        }
        int i6 = ((i2 * 31) + i4) * 31;
        Object[] objArr = this.zzd;
        int i7 = this.zzb;
        for (int i8 = 0; i8 < i7; i8++) {
            i3 = (i3 * 31) + objArr[i8].hashCode();
        }
        return i6 + i3;
    }

    public final int zza() {
        int i;
        int i2;
        int i3;
        int i4 = this.zze;
        if (i4 != -1) {
            return i4;
        }
        int i5 = 0;
        for (int i6 = 0; i6 < this.zzb; i6++) {
            int i7 = this.zzc[i6];
            int i8 = i7 >>> 3;
            int i9 = i7 & 7;
            if (i9 != 0) {
                if (i9 == 1) {
                    ((Long) this.zzd[i6]).longValue();
                    i = zzgyc.zzD(i8 << 3) + 8;
                } else if (i9 == 2) {
                    int zzD = zzgyc.zzD(i8 << 3);
                    int zzd2 = ((zzgxp) this.zzd[i6]).zzd();
                    i = zzD + zzgyc.zzD(zzd2) + zzd2;
                } else if (i9 == 3) {
                    int zzD2 = zzgyc.zzD(i8 << 3);
                    i3 = zzD2 + zzD2;
                    i2 = ((zzhbo) this.zzd[i6]).zza();
                } else if (i9 == 5) {
                    ((Integer) this.zzd[i6]).intValue();
                    i = zzgyc.zzD(i8 << 3) + 4;
                } else {
                    throw new IllegalStateException(new zzgzl("Protocol message tag had invalid wire type."));
                }
                i5 += i;
            } else {
                int i10 = i8 << 3;
                long longValue = ((Long) this.zzd[i6]).longValue();
                i3 = zzgyc.zzD(i10);
                i2 = zzgyc.zzE(longValue);
            }
            i = i3 + i2;
            i5 += i;
        }
        this.zze = i5;
        return i5;
    }

    public final int zzb() {
        int i = this.zze;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.zzb; i3++) {
            int zzD = zzgyc.zzD(8);
            int zzD2 = zzgyc.zzD(16) + zzgyc.zzD(this.zzc[i3] >>> 3);
            int zzD3 = zzgyc.zzD(24);
            int zzd2 = ((zzgxp) this.zzd[i3]).zzd();
            i2 += zzD + zzD + zzD2 + zzD3 + zzgyc.zzD(zzd2) + zzd2;
        }
        this.zze = i2;
        return i2;
    }

    /* access modifiers changed from: package-private */
    public final zzhbo zzd(zzhbo zzhbo) {
        if (zzhbo.equals(zza)) {
            return this;
        }
        zzg();
        int i = this.zzb + zzhbo.zzb;
        zzn(i);
        System.arraycopy(zzhbo.zzc, 0, this.zzc, this.zzb, zzhbo.zzb);
        System.arraycopy(zzhbo.zzd, 0, this.zzd, this.zzb, zzhbo.zzb);
        this.zzb = i;
        return this;
    }

    /* access modifiers changed from: package-private */
    public final void zzg() {
        if (!this.zzf) {
            throw new UnsupportedOperationException();
        }
    }

    public final void zzh() {
        if (this.zzf) {
            this.zzf = false;
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzi(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < this.zzb; i2++) {
            zzhak.zzb(sb, i, String.valueOf(this.zzc[i2] >>> 3), this.zzd[i2]);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzj(int i, Object obj) {
        zzg();
        zzn(this.zzb + 1);
        int[] iArr = this.zzc;
        int i2 = this.zzb;
        iArr[i2] = i;
        this.zzd[i2] = obj;
        this.zzb = i2 + 1;
    }

    /* access modifiers changed from: package-private */
    public final void zzk(zzhcc zzhcc) throws IOException {
        for (int i = 0; i < this.zzb; i++) {
            zzhcc.zzw(this.zzc[i] >>> 3, this.zzd[i]);
        }
    }

    public final void zzl(zzhcc zzhcc) throws IOException {
        if (this.zzb != 0) {
            for (int i = 0; i < this.zzb; i++) {
                int i2 = this.zzc[i];
                Object obj = this.zzd[i];
                int i3 = i2 & 7;
                int i4 = i2 >>> 3;
                if (i3 == 0) {
                    zzhcc.zzt(i4, ((Long) obj).longValue());
                } else if (i3 == 1) {
                    zzhcc.zzm(i4, ((Long) obj).longValue());
                } else if (i3 == 2) {
                    zzhcc.zzd(i4, (zzgxp) obj);
                } else if (i3 == 3) {
                    zzhcc.zzF(i4);
                    ((zzhbo) obj).zzl(zzhcc);
                    zzhcc.zzh(i4);
                } else if (i3 == 5) {
                    zzhcc.zzk(i4, ((Integer) obj).intValue());
                } else {
                    throw new RuntimeException(new zzgzl("Protocol message tag had invalid wire type."));
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean zzm(int i, zzgxv zzgxv) throws IOException {
        int zzl;
        zzg();
        int i2 = i & 7;
        if (i2 == 0) {
            zzj(i, Long.valueOf(zzgxv.zzo()));
            return true;
        } else if (i2 == 1) {
            zzj(i, Long.valueOf(zzgxv.zzn()));
            return true;
        } else if (i2 == 2) {
            zzj(i, zzgxv.zzv());
            return true;
        } else if (i2 == 3) {
            zzhbo zzhbo = new zzhbo();
            do {
                zzl = zzgxv.zzl();
                if (zzl == 0 || !zzhbo.zzm(zzl, zzgxv)) {
                    zzgxv.zzy(4 | ((i >>> 3) << 3));
                    zzj(i, zzhbo);
                }
                zzl = zzgxv.zzl();
                break;
            } while (!zzhbo.zzm(zzl, zzgxv));
            zzgxv.zzy(4 | ((i >>> 3) << 3));
            zzj(i, zzhbo);
            return true;
        } else if (i2 == 4) {
            return false;
        } else {
            if (i2 == 5) {
                zzj(i, Integer.valueOf(zzgxv.zzf()));
                return true;
            }
            throw new zzgzl("Protocol message tag had invalid wire type.");
        }
    }
}
