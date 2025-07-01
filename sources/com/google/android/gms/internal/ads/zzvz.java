package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzvz {
    private final zzed zza = new zzed(32);
    private zzvy zzb;
    private zzvy zzc;
    private zzvy zzd;
    private long zze;
    private final zzys zzf;

    public zzvz(zzys zzys) {
        this.zzf = zzys;
        zzvy zzvy = new zzvy(0, 65536);
        this.zzb = zzvy;
        this.zzc = zzvy;
        this.zzd = zzvy;
    }

    private final int zzi(int i) {
        zzvy zzvy = this.zzd;
        if (zzvy.zzc == null) {
            zzyl zzb2 = this.zzf.zzb();
            zzvy zzvy2 = new zzvy(this.zzd.zzb, 65536);
            zzvy.zzc = zzb2;
            zzvy.zzd = zzvy2;
        }
        return Math.min(i, (int) (this.zzd.zzb - this.zze));
    }

    private static zzvy zzj(zzvy zzvy, long j) {
        while (j >= zzvy.zzb) {
            zzvy = zzvy.zzd;
        }
        return zzvy;
    }

    private static zzvy zzk(zzvy zzvy, long j, ByteBuffer byteBuffer, int i) {
        zzvy zzj = zzj(zzvy, j);
        while (i > 0) {
            int min = Math.min(i, (int) (zzj.zzb - j));
            byteBuffer.put(zzj.zzc.zza, zzj.zza(j), min);
            i -= min;
            j += (long) min;
            if (j == zzj.zzb) {
                zzj = zzj.zzd;
            }
        }
        return zzj;
    }

    private static zzvy zzl(zzvy zzvy, long j, byte[] bArr, int i) {
        zzvy zzj = zzj(zzvy, j);
        int i2 = i;
        while (i2 > 0) {
            int min = Math.min(i2, (int) (zzj.zzb - j));
            System.arraycopy(zzj.zzc.zza, zzj.zza(j), bArr, i - i2, min);
            i2 -= min;
            j += (long) min;
            if (j == zzj.zzb) {
                zzj = zzj.zzd;
            }
        }
        return zzj;
    }

    private static zzvy zzm(zzvy zzvy, zzhm zzhm, zzwb zzwb, zzed zzed) {
        zzvy zzvy2;
        zzhm zzhm2 = zzhm;
        zzwb zzwb2 = zzwb;
        zzed zzed2 = zzed;
        if (zzhm2.zzl()) {
            long j = zzwb2.zzb;
            int i = 1;
            zzed2.zzI(1);
            zzvy zzl = zzl(zzvy, j, zzed2.zzN(), 1);
            long j2 = j + 1;
            byte b = zzed2.zzN()[0];
            byte b2 = b & 128;
            byte b3 = b & Byte.MAX_VALUE;
            zzhj zzhj = zzhm2.zzb;
            byte[] bArr = zzhj.zza;
            if (bArr == null) {
                zzhj.zza = new byte[16];
            } else {
                Arrays.fill(bArr, (byte) 0);
            }
            boolean z = b2 != 0;
            zzvy2 = zzl(zzl, j2, zzhj.zza, b3);
            long j3 = j2 + ((long) b3);
            if (z) {
                zzed2.zzI(2);
                zzvy2 = zzl(zzvy2, j3, zzed2.zzN(), 2);
                j3 += 2;
                i = zzed2.zzq();
            }
            int i2 = i;
            int[] iArr = zzhj.zzd;
            if (iArr == null || iArr.length < i2) {
                iArr = new int[i2];
            }
            int[] iArr2 = iArr;
            int[] iArr3 = zzhj.zze;
            if (iArr3 == null || iArr3.length < i2) {
                iArr3 = new int[i2];
            }
            int[] iArr4 = iArr3;
            if (z) {
                int i3 = i2 * 6;
                zzed2.zzI(i3);
                zzvy2 = zzl(zzvy2, j3, zzed2.zzN(), i3);
                j3 += (long) i3;
                zzed2.zzL(0);
                for (int i4 = 0; i4 < i2; i4++) {
                    iArr2[i4] = zzed2.zzq();
                    iArr4[i4] = zzed2.zzp();
                }
            } else {
                iArr2[0] = 0;
                iArr4[0] = zzwb2.zza - ((int) (j3 - zzwb2.zzb));
            }
            zzadw zzadw = zzwb2.zzc;
            int i5 = zzen.zza;
            zzadw zzadw2 = zzadw;
            zzhj.zzc(i2, iArr2, iArr4, zzadw.zzb, zzhj.zza, zzadw.zza, zzadw.zzc, zzadw.zzd);
            long j4 = zzwb2.zzb;
            int i6 = (int) (j3 - j4);
            zzwb2.zzb = j4 + ((long) i6);
            zzwb2.zza -= i6;
        } else {
            zzvy2 = zzvy;
        }
        if (zzhm2.zze()) {
            zzed2.zzI(4);
            zzvy zzl2 = zzl(zzvy2, zzwb2.zzb, zzed2.zzN(), 4);
            int zzp = zzed2.zzp();
            zzwb2.zzb += 4;
            zzwb2.zza -= 4;
            zzhm2.zzj(zzp);
            zzvy zzk = zzk(zzl2, zzwb2.zzb, zzhm2.zzc, zzp);
            zzwb2.zzb += (long) zzp;
            int i7 = zzwb2.zza - zzp;
            zzwb2.zza = i7;
            ByteBuffer byteBuffer = zzhm2.zzf;
            if (byteBuffer == null || byteBuffer.capacity() < i7) {
                zzhm2.zzf = ByteBuffer.allocate(i7);
            } else {
                zzhm2.zzf.clear();
            }
            return zzk(zzk, zzwb2.zzb, zzhm2.zzf, zzwb2.zza);
        }
        zzhm2.zzj(zzwb2.zza);
        return zzk(zzvy2, zzwb2.zzb, zzhm2.zzc, zzwb2.zza);
    }

    private final void zzn(int i) {
        long j = this.zze + ((long) i);
        this.zze = j;
        zzvy zzvy = this.zzd;
        if (j == zzvy.zzb) {
            this.zzd = zzvy.zzd;
        }
    }

    public final int zza(zzn zzn, int i, boolean z) throws IOException {
        int zzi = zzi(i);
        zzvy zzvy = this.zzd;
        int zza2 = zzn.zza(zzvy.zzc.zza, zzvy.zza(this.zze), zzi);
        if (zza2 != -1) {
            zzn(zza2);
            return zza2;
        } else if (z) {
            return -1;
        } else {
            throw new EOFException();
        }
    }

    public final long zzb() {
        return this.zze;
    }

    public final void zzc(long j) {
        zzvy zzvy;
        if (j != -1) {
            while (true) {
                zzvy = this.zzb;
                if (j < zzvy.zzb) {
                    break;
                }
                this.zzf.zzc(zzvy.zzc);
                this.zzb = this.zzb.zzb();
            }
            if (this.zzc.zza < zzvy.zza) {
                this.zzc = zzvy;
            }
        }
    }

    public final void zzd(zzhm zzhm, zzwb zzwb) {
        zzm(this.zzc, zzhm, zzwb, this.zza);
    }

    public final void zze(zzhm zzhm, zzwb zzwb) {
        this.zzc = zzm(this.zzc, zzhm, zzwb, this.zza);
    }

    public final void zzf() {
        zzvy zzvy = this.zzb;
        if (zzvy.zzc != null) {
            this.zzf.zzd(zzvy);
            zzvy.zzb();
        }
        this.zzb.zze(0, 65536);
        zzvy zzvy2 = this.zzb;
        this.zzc = zzvy2;
        this.zzd = zzvy2;
        this.zze = 0;
        this.zzf.zzg();
    }

    public final void zzg() {
        this.zzc = this.zzb;
    }

    public final void zzh(zzed zzed, int i) {
        while (i > 0) {
            int zzi = zzi(i);
            zzvy zzvy = this.zzd;
            zzed.zzH(zzvy.zzc.zza, zzvy.zza(this.zze), zzi);
            i -= zzi;
            zzn(zzi);
        }
    }
}
