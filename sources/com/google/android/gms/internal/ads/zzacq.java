package com.google.android.gms.internal.ads;

import androidx.compose.animation.core.AnimationKt;
import com.google.android.material.internal.ViewUtils;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzacq {
    public static final /* synthetic */ int zza = 0;
    private static final int[] zzb = {1, 2, 2, 2, 2, 3, 3, 4, 4, 5, 6, 6, 6, 7, 8, 8};
    private static final int[] zzc = {-1, 8000, 16000, 32000, -1, -1, 11025, 22050, 44100, -1, -1, 12000, 24000, 48000, -1, -1};
    private static final int[] zzd = {64, 112, 128, 192, 224, 256, 384, 448, 512, 640, ViewUtils.EDGE_TO_EDGE_FLAGS, 896, 1024, 1152, 1280, 1536, 1920, 2048, 2304, 2560, 2688, 2816, 2823, 2944, 3072, 3840, 4096, 6144, 7680};
    private static final int[] zze = {8000, 16000, 32000, 64000, 128000, 22050, 44100, 88200, 176400, 352800, 12000, 24000, 48000, 96000, 192000, 384000};
    private static final int[] zzf = {5, 8, 10, 12};
    private static final int[] zzg = {6, 9, 12, 15};
    private static final int[] zzh = {2, 4, 6, 8};
    private static final int[] zzi = {9, 11, 13, 16};
    private static final int[] zzj = {5, 8, 10, 12};

    public static int zza(byte[] bArr) {
        zzec zzg2 = zzg(bArr);
        zzg2.zzn(42);
        return zzg2.zzd(true != zzg2.zzp() ? 8 : 12) + 1;
    }

    public static int zzb(byte[] bArr) {
        zzec zzg2 = zzg(bArr);
        zzg2.zzn(32);
        return zzf(zzg2, zzj, true) + 1;
    }

    public static zzad zzc(byte[] bArr, String str, String str2, int i, zzw zzw) {
        int i2;
        zzec zzg2 = zzg(bArr);
        zzg2.zzn(60);
        int i3 = zzb[zzg2.zzd(6)];
        int i4 = zzc[zzg2.zzd(4)];
        int zzd2 = zzg2.zzd(5);
        if (zzd2 >= 29) {
            i2 = -1;
        } else {
            i2 = (zzd[zzd2] * 1000) / 2;
        }
        zzg2.zzn(10);
        int i5 = i3 + (zzg2.zzd(2) > 0 ? 1 : 0);
        zzab zzab = new zzab();
        zzab.zzL(str);
        zzab.zzZ("audio/vnd.dts");
        zzab.zzy(i2);
        zzab.zzz(i5);
        zzab.zzaa(i4);
        zzab.zzF((zzw) null);
        zzab.zzP(str2);
        zzab.zzX(i);
        return zzab.zzaf();
    }

    public static zzaco zzd(byte[] bArr) throws zzbh {
        int i;
        int i2;
        long j;
        int i3;
        zzec zzg2 = zzg(bArr);
        zzg2.zzn(40);
        int zzd2 = zzg2.zzd(2);
        boolean zzp = zzg2.zzp();
        int i4 = true != zzp ? 16 : 20;
        zzg2.zzn(true != zzp ? 8 : 12);
        int zzd3 = zzg2.zzd(i4) + 1;
        boolean zzp2 = zzg2.zzp();
        int i5 = -1;
        int i6 = 0;
        if (zzp2) {
            i = zzg2.zzd(2);
            int zzd4 = zzg2.zzd(3) + 1;
            if (zzg2.zzp()) {
                zzg2.zzn(36);
            }
            int zzd5 = zzg2.zzd(3) + 1;
            int zzd6 = zzg2.zzd(3) + 1;
            if (zzd5 == 1 && zzd6 == 1) {
                int i7 = zzd2 + 1;
                int zzd7 = zzg2.zzd(i7);
                for (int i8 = 0; i8 < i7; i8++) {
                    if (((zzd7 >> i8) & 1) == 1) {
                        zzg2.zzn(8);
                    }
                }
                int i9 = zzd4 * 512;
                if (zzg2.zzp()) {
                    zzg2.zzn(2);
                    int zzd8 = (zzg2.zzd(2) + 1) << 2;
                    int zzd9 = zzg2.zzd(2) + 1;
                    while (i6 < zzd9) {
                        zzg2.zzn(zzd8);
                        i6++;
                    }
                }
                i6 = i9;
            } else {
                throw zzbh.zzc("Multiple audio presentations or assets not supported");
            }
        } else {
            i = -1;
        }
        zzg2.zzn(i4);
        zzg2.zzn(12);
        if (zzp2) {
            if (zzg2.zzp()) {
                zzg2.zzn(4);
            }
            if (zzg2.zzp()) {
                zzg2.zzn(24);
            }
            if (zzg2.zzp()) {
                zzg2.zzo(zzg2.zzd(10) + 1);
            }
            zzg2.zzn(5);
            i2 = zze[zzg2.zzd(4)];
            i5 = zzg2.zzd(8) + 1;
        } else {
            i2 = -2147483647;
        }
        int i10 = i2;
        if (zzp2) {
            if (i == 0) {
                i3 = 32000;
            } else if (i == 1) {
                i3 = 44100;
            } else if (i == 2) {
                i3 = 48000;
            } else {
                throw zzbh.zza("Unsupported reference clock code in DTS HD header: " + i, (Throwable) null);
            }
            j = zzen.zzu((long) i6, AnimationKt.MillisToNanos, (long) i3, RoundingMode.FLOOR);
        } else {
            j = -9223372036854775807L;
        }
        return new zzaco("audio/vnd.dts.hd;profile=lbr", i5, i10, zzd3, j, 0, (zzacp) null);
    }

    public static zzaco zze(byte[] bArr, AtomicInteger atomicInteger) throws zzbh {
        long j;
        int i;
        AtomicInteger atomicInteger2;
        int i2;
        int i3;
        byte[] bArr2 = bArr;
        zzec zzg2 = zzg(bArr2);
        int zzd2 = zzg2.zzd(32);
        int zzf2 = zzf(zzg2, zzf, true);
        int i4 = zzf2 + 1;
        char c = zzd2 == 1078008818 ? (char) 1 : 0;
        if (c == 0) {
            j = -9223372036854775807L;
            i = -2147483647;
        } else if (zzg2.zzp()) {
            int i5 = zzf2 - 1;
            if (((bArr2[zzf2] & 255) | ((char) (bArr2[i5] << 8))) == zzen.zze(bArr2, 0, i5, 65535)) {
                int zzd3 = zzg2.zzd(2);
                if (zzd3 == 0) {
                    i2 = 512;
                } else if (zzd3 == 1) {
                    i2 = 480;
                } else if (zzd3 == 2) {
                    i2 = 384;
                } else {
                    throw zzbh.zza("Unsupported base duration index in DTS UHD header: " + zzd3, (Throwable) null);
                }
                int zzd4 = zzg2.zzd(3) + 1;
                int zzd5 = zzg2.zzd(2);
                if (zzd5 == 0) {
                    i3 = 32000;
                } else if (zzd5 == 1) {
                    i3 = 44100;
                } else if (zzd5 == 2) {
                    i3 = 48000;
                } else {
                    throw zzbh.zza("Unsupported clock rate index in DTS UHD header: " + zzd5, (Throwable) null);
                }
                if (zzg2.zzp()) {
                    zzg2.zzn(36);
                }
                i = (1 << zzg2.zzd(2)) * i3;
                j = zzen.zzu((long) (i2 * zzd4), AnimationKt.MillisToNanos, (long) i3, RoundingMode.FLOOR);
            } else {
                throw zzbh.zza("CRC check failed", (Throwable) null);
            }
        } else {
            throw zzbh.zzc("Only supports full channel mask-based audio presentation");
        }
        int i6 = i;
        long j2 = j;
        int i7 = 0;
        for (char c2 = 0; c2 < c; c2 = 1) {
            i7 += zzf(zzg2, zzg, true);
        }
        for (int i8 = 0; i8 <= 0; i8++) {
            if (c != 0) {
                atomicInteger2 = atomicInteger;
                atomicInteger2.set(zzf(zzg2, zzh, true));
            } else {
                atomicInteger2 = atomicInteger;
            }
            i7 += atomicInteger2.get() != 0 ? zzf(zzg2, zzi, true) : 0;
        }
        return new zzaco("audio/vnd.dts.uhd;profile=p2", 2, i6, i4 + i7, j2, 0, (zzacp) null);
    }

    private static int zzf(zzec zzec, int[] iArr, boolean z) {
        int i = 0;
        for (int i2 = 0; i2 < 3 && zzec.zzp(); i2++) {
            i++;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < i; i4++) {
            i3 += 1 << iArr[i4];
        }
        return i3 + zzec.zzd(iArr[i]);
    }

    private static zzec zzg(byte[] bArr) {
        byte b = bArr[0];
        if (b == Byte.MAX_VALUE || b == 100 || b == 64 || b == 113) {
            return new zzec(bArr, bArr.length);
        }
        byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
        byte b2 = copyOf[0];
        if (b2 == -2 || b2 == -1 || b2 == 37 || b2 == -14 || b2 == -24) {
            for (int i = 0; i < copyOf.length - 1; i += 2) {
                byte b3 = copyOf[i];
                int i2 = i + 1;
                copyOf[i] = copyOf[i2];
                copyOf[i2] = b3;
            }
        }
        int length = copyOf.length;
        zzec zzec = new zzec(copyOf, length);
        if (copyOf[0] == 31) {
            zzec zzec2 = new zzec(copyOf, length);
            while (zzec2.zza() >= 16) {
                zzec2.zzn(2);
                zzec.zzg(zzec2.zzd(14), 14);
            }
        }
        zzec.zzk(copyOf, copyOf.length);
        return zzec;
    }
}
