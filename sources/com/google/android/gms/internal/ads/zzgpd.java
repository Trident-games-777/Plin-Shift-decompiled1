package com.google.android.gms.internal.ads;

import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzgpd {
    private final Class zza;
    private final zzgwu zzb;

    /* synthetic */ zzgpd(Class cls, zzgwu zzgwu, zzgpf zzgpf) {
        this.zza = cls;
        this.zzb = zzgwu;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzgpd)) {
            return false;
        }
        zzgpd zzgpd = (zzgpd) obj;
        if (!zzgpd.zza.equals(this.zza) || !zzgpd.zzb.equals(this.zzb)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{this.zza, this.zzb});
    }

    public final String toString() {
        zzgwu zzgwu = this.zzb;
        String simpleName = this.zza.getSimpleName();
        String valueOf = String.valueOf(zzgwu);
        return simpleName + ", object identifier: " + valueOf;
    }
}
