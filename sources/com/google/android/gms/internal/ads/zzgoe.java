package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public abstract class zzgoe {
    private final zzgwu zza;
    private final Class zzb;

    /* synthetic */ zzgoe(zzgwu zzgwu, Class cls, zzgod zzgod) {
        this.zza = zzgwu;
        this.zzb = cls;
    }

    public static zzgoe zzb(zzgoc zzgoc, zzgwu zzgwu, Class cls) {
        return new zzgob(zzgwu, cls, zzgoc);
    }

    public abstract zzggj zza(zzgpb zzgpb) throws GeneralSecurityException;

    public final zzgwu zzc() {
        return this.zza;
    }

    public final Class zzd() {
        return this.zzb;
    }
}
