package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzacz {
    public static zzadb zzb(zzed zzed) {
        zzed.zzM(1);
        int zzo = zzed.zzo();
        long zzd = (long) zzed.zzd();
        long j = (long) zzo;
        int i = zzo / 18;
        long[] jArr = new long[i];
        long[] jArr2 = new long[i];
        int i2 = 0;
        while (true) {
            if (i2 >= i) {
                break;
            }
            long zzt = zzed.zzt();
            if (zzt == -1) {
                jArr = Arrays.copyOf(jArr, i2);
                jArr2 = Arrays.copyOf(jArr2, i2);
                break;
            }
            jArr[i2] = zzt;
            jArr2[i2] = zzed.zzt();
            zzed.zzM(2);
            i2++;
        }
        zzed.zzM((int) ((zzd + j) - ((long) zzed.zzd())));
        return new zzadb(jArr, jArr2);
    }

    public static zzbd zza(zzacs zzacs, boolean z) throws IOException {
        zzbd zza = new zzadh().zza(zzacs, z ? null : zzagk.zza);
        if (zza == null || zza.zza() == 0) {
            return null;
        }
        return zza;
    }
}
