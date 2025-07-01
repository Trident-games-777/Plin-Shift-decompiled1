package com.google.android.gms.internal.ads;

import android.util.Pair;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzaok {
    public static Pair zza(zzacs zzacs) throws IOException {
        zzacs.zzj();
        zzaoj zzd = zzd(1684108385, zzacs, new zzed(8));
        zzacs.zzk(8);
        return Pair.create(Long.valueOf(zzacs.zzf()), Long.valueOf(zzd.zzb));
    }

    public static zzaoi zzb(zzacs zzacs) throws IOException {
        byte[] bArr;
        zzed zzed = new zzed(16);
        zzaoj zzd = zzd(1718449184, zzacs, zzed);
        zzdb.zzf(zzd.zzb >= 16);
        zzacs.zzh(zzed.zzN(), 0, 16);
        zzed.zzL(0);
        int zzk = zzed.zzk();
        int zzk2 = zzed.zzk();
        int zzj = zzed.zzj();
        int zzj2 = zzed.zzj();
        int zzk3 = zzed.zzk();
        int zzk4 = zzed.zzk();
        int i = ((int) zzd.zzb) - 16;
        if (i > 0) {
            bArr = new byte[i];
            zzacs.zzh(bArr, 0, i);
        } else {
            bArr = zzen.zzf;
        }
        zzacs.zzk((int) (zzacs.zze() - zzacs.zzf()));
        return new zzaoi(zzk, zzk2, zzj, zzj2, zzk3, zzk4, bArr);
    }

    public static boolean zzc(zzacs zzacs) throws IOException {
        zzed zzed = new zzed(8);
        int i = zzaoj.zza(zzacs, zzed).zza;
        if (i != 1380533830 && i != 1380333108) {
            return false;
        }
        zzacs.zzh(zzed.zzN(), 0, 4);
        zzed.zzL(0);
        int zzg = zzed.zzg();
        if (zzg == 1463899717) {
            return true;
        }
        zzdt.zzc("WavHeaderReader", "Unsupported form type: " + zzg);
        return false;
    }

    private static zzaoj zzd(int i, zzacs zzacs, zzed zzed) throws IOException {
        zzaoj zza = zzaoj.zza(zzacs, zzed);
        while (true) {
            int i2 = zza.zza;
            if (i2 == i) {
                return zza;
            }
            zzdt.zzf("WavHeaderReader", "Ignoring unknown WAV chunk: " + i2);
            long j = zza.zzb;
            long j2 = 8 + j;
            if ((1 & j) != 0) {
                j2 = j + 9;
            }
            if (j2 <= 2147483647L) {
                zzacs.zzk((int) j2);
                zza = zzaoj.zza(zzacs, zzed);
            } else {
                int i3 = zza.zza;
                throw zzbh.zzc("Chunk is too large (~2GB+) to skip; id: " + i3);
            }
        }
    }
}
