package com.google.android.gms.internal.ads;

import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzgoo {
    private final Class zza;
    private final Class zzb;

    /* synthetic */ zzgoo(Class cls, Class cls2, zzgop zzgop) {
        this.zza = cls;
        this.zzb = cls2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzgoo)) {
            return false;
        }
        zzgoo zzgoo = (zzgoo) obj;
        if (!zzgoo.zza.equals(this.zza) || !zzgoo.zzb.equals(this.zzb)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{this.zza, this.zzb});
    }

    public final String toString() {
        Class cls = this.zzb;
        String simpleName = this.zza.getSimpleName();
        String simpleName2 = cls.getSimpleName();
        return simpleName + " with primitive type: " + simpleName2;
    }
}
