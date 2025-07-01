package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzgkf extends zzggt {
    private final zzgke zza;

    private zzgkf(zzgke zzgke, int i) {
        this.zza = zzgke;
    }

    public static zzgkf zzb(zzgke zzgke, int i) throws GeneralSecurityException {
        return new zzgkf(zzgke, 8);
    }

    public final boolean equals(Object obj) {
        return (obj instanceof zzgkf) && ((zzgkf) obj).zza == this.zza;
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{zzgkf.class, this.zza, 8});
    }

    public final String toString() {
        String obj = this.zza.toString();
        return "X-AES-GCM Parameters (variant: " + obj + "salt_size_bytes: 8)";
    }

    public final boolean zza() {
        return this.zza != zzgke.zza;
    }
}
