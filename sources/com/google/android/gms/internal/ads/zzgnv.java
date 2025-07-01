package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzgnv {
    private static final zzgnv zza = new zzgnv();
    private final Map zzb = new HashMap();

    zzgnv() {
    }

    public static zzgnv zzb() {
        return zza;
    }

    public final synchronized zzggj zza(String str) throws GeneralSecurityException {
        if (this.zzb.containsKey("AES128_GCM")) {
        } else {
            throw new GeneralSecurityException("Name AES128_GCM does not exist");
        }
        return (zzggj) this.zzb.get("AES128_GCM");
    }

    public final synchronized void zzc(String str, zzggj zzggj) throws GeneralSecurityException {
        if (!this.zzb.containsKey(str)) {
            this.zzb.put(str, zzggj);
        } else if (!((zzggj) this.zzb.get(str)).equals(zzggj)) {
            String valueOf = String.valueOf(this.zzb.get(str));
            String valueOf2 = String.valueOf(zzggj);
            throw new GeneralSecurityException("Parameters object with name " + str + " already exists (" + valueOf + "), cannot insert " + valueOf2);
        }
    }

    public final synchronized void zzd(Map map) throws GeneralSecurityException {
        for (Map.Entry entry : map.entrySet()) {
            zzc((String) entry.getKey(), (zzggj) entry.getValue());
        }
    }
}
