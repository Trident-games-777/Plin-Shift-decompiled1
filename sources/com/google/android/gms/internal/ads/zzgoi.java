package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public abstract class zzgoi {
    private final Class zza;
    private final Class zzb;

    /* synthetic */ zzgoi(Class cls, Class cls2, zzgoh zzgoh) {
        this.zza = cls;
        this.zzb = cls2;
    }

    public static zzgoi zzb(zzgog zzgog, Class cls, Class cls2) {
        return new zzgof(cls, cls2, zzgog);
    }

    public abstract zzgpb zza(zzggj zzggj) throws GeneralSecurityException;

    public final Class zzc() {
        return this.zza;
    }

    public final Class zzd() {
        return this.zzb;
    }
}
