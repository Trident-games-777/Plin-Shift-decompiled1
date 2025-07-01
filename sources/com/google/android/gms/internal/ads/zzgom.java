package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public abstract class zzgom {
    private final Class zza;
    private final Class zzb;

    /* synthetic */ zzgom(Class cls, Class cls2, zzgol zzgol) {
        this.zza = cls;
        this.zzb = cls2;
    }

    public static zzgom zzb(zzgok zzgok, Class cls, Class cls2) {
        return new zzgoj(cls, cls2, zzgok);
    }

    public abstract Object zza(zzgfw zzgfw) throws GeneralSecurityException;

    public final Class zzc() {
        return this.zza;
    }

    public final Class zzd() {
        return this.zzb;
    }
}
