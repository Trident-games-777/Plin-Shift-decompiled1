package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzaoc {
    public static int zza(byte[] bArr, int i, int i2) {
        while (i < i2 && bArr[i] != 71) {
            i++;
        }
        return i;
    }

    public static long zzb(zzed zzed, int i, int i2) {
        zzed.zzL(i);
        if (zzed.zzb() < 5) {
            return -9223372036854775807L;
        }
        int zzg = zzed.zzg();
        if ((8388608 & zzg) != 0 || ((zzg >> 8) & 8191) != i2 || (zzg & 32) == 0 || zzed.zzm() < 7 || zzed.zzb() < 7 || (zzed.zzm() & 16) != 16) {
            return -9223372036854775807L;
        }
        byte[] bArr = new byte[6];
        zzed.zzH(bArr, 0, 6);
        long j = ((long) bArr[3]) & 255;
        return ((((long) bArr[0]) & 255) << 25) | ((((long) bArr[1]) & 255) << 17) | ((((long) bArr[2]) & 255) << 9) | (j + j) | ((((long) bArr[4]) & 255) >> 7);
    }
}
