package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.Bundle;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzat {
    public static final zzat zza = new zzat(new zzas());
    public final Uri zzb = null;
    public final String zzc = null;
    public final Bundle zzd = null;

    static {
        Integer.toString(0, 36);
        Integer.toString(1, 36);
        Integer.toString(2, 36);
    }

    private zzat(zzas zzas) {
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzat)) {
            return false;
        }
        zzat zzat = (zzat) obj;
        Uri uri = zzat.zzb;
        if (Objects.equals((Object) null, (Object) null)) {
            String str = zzat.zzc;
            if (Objects.equals((Object) null, (Object) null)) {
                Bundle bundle = zzat.zzd;
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return 0;
    }
}
