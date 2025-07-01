package com.google.android.gms.internal.ads;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzakc {
    public static void zza(zzakd zzakd, zzakh zzakh, zzdg zzdg) {
        for (int i = 0; i < zzakd.zza(); i++) {
            long zzb = zzakd.zzb(i);
            List zzc = zzakd.zzc(zzb);
            if (!zzc.isEmpty()) {
                if (i != zzakd.zza() - 1) {
                    long zzb2 = zzakd.zzb(i + 1) - zzakd.zzb(i);
                    if (zzb2 > 0) {
                        zzdg.zza(new zzaka(zzc, zzb, zzb2));
                    }
                } else {
                    throw new IllegalStateException();
                }
            }
        }
    }
}
