package com.google.android.gms.internal.ads;

import javax.crypto.Cipher;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzgky {
    public static final /* synthetic */ int zza = 0;
    private static final ThreadLocal zzb = new zzgkx();

    public static Cipher zza() {
        return (Cipher) zzb.get();
    }
}
