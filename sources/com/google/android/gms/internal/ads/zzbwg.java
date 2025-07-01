package com.google.android.gms.internal.ads;

import com.google.android.gms.common.internal.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzbwg extends zzbwi {
    private final String zza;
    private final int zzb;

    public zzbwg(String str, int i) {
        this.zza = str;
        this.zzb = i;
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof zzbwg)) {
            zzbwg zzbwg = (zzbwg) obj;
            if (Objects.equal(this.zza, zzbwg.zza)) {
                if (Objects.equal(Integer.valueOf(this.zzb), Integer.valueOf(zzbwg.zzb))) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int zzb() {
        return this.zzb;
    }

    public final String zzc() {
        return this.zza;
    }
}
