package com.google.android.gms.internal.ads;

import java.io.Serializable;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzgbi extends zzgaz implements Serializable {
    final zzgaz zza;

    zzgbi(zzgaz zzgaz) {
        zzgaz zzgaz2 = zzgaz;
        this.zza = zzgaz;
    }

    public final int compare(Object obj, Object obj2) {
        return this.zza.compare(obj2, obj);
    }

    public final boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzgbi) {
            return this.zza.equals(((zzgbi) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return -this.zza.hashCode();
    }

    public final String toString() {
        return this.zza.toString().concat(".reverse()");
    }
}
