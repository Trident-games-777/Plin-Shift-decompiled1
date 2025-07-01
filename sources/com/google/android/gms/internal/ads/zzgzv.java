package com.google.android.gms.internal.ads;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
final class zzgzv {
    zzgzv() {
    }

    public static final List zza(Object obj, long j) {
        zzgzj zzgzj = (zzgzj) zzhbu.zzh(obj, j);
        if (zzgzj.zzc()) {
            return zzgzj;
        }
        int size = zzgzj.size();
        zzgzj zzf = zzgzj.zzf(size == 0 ? 10 : size + size);
        zzhbu.zzv(obj, j, zzf);
        return zzf;
    }
}
