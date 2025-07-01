package com.google.android.gms.internal.ads;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzcd {
    public static final zzcd zza = new zzcd(zzfzo.zzn());
    private final zzfzo zzb;

    static {
        Integer.toString(0, 36);
    }

    public zzcd(List list) {
        this.zzb = zzfzo.zzl(list);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.zzb.equals(((zzcd) obj).zzb);
    }

    public final int hashCode() {
        return this.zzb.hashCode();
    }

    public final zzfzo zza() {
        return this.zzb;
    }

    public final boolean zzb(int i) {
        for (int i2 = 0; i2 < this.zzb.size(); i2++) {
            zzcc zzcc = (zzcc) this.zzb.get(i2);
            if (zzcc.zzc() && zzcc.zza() == i) {
                return true;
            }
        }
        return false;
    }
}
