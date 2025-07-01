package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzgox implements zzgpb {
    private final zzgwu zza;
    private final zzgue zzb;

    private zzgox(zzgue zzgue, zzgwu zzgwu) {
        this.zzb = zzgue;
        this.zza = zzgwu;
    }

    public static zzgox zza(zzgue zzgue) throws GeneralSecurityException {
        return new zzgox(zzgue, zzgpj.zza(zzgue.zzi()));
    }

    public static zzgox zzb(zzgue zzgue) {
        return new zzgox(zzgue, zzgpj.zzb(zzgue.zzi()));
    }

    public final zzgue zzc() {
        return this.zzb;
    }

    public final zzgwu zzd() {
        return this.zza;
    }
}
