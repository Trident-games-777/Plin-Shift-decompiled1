package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
public final class zzhbm extends RuntimeException {
    public zzhbm(zzhai zzhai) {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
    }

    public final zzgzm zza() {
        return new zzgzm(getMessage());
    }
}
