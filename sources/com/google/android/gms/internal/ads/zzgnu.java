package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzgnu {
    private static final zzgnu zza = new zzgnu();
    private static final zzgns zzb = new zzgns((zzgnt) null);
    private final AtomicReference zzc = new AtomicReference();

    public static zzgnu zzb() {
        return zza;
    }

    public final zzgnf zza() {
        zzgnf zzgnf = (zzgnf) this.zzc.get();
        return zzgnf == null ? zzb : zzgnf;
    }
}
