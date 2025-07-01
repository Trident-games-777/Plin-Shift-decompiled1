package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public abstract class zzgmw {
    private final Class zza;
    private final Class zzb;

    /* synthetic */ zzgmw(Class cls, Class cls2, zzgmv zzgmv) {
        this.zza = cls;
        this.zzb = cls2;
    }

    public static zzgmw zzb(zzgmu zzgmu, Class cls, Class cls2) {
        return new zzgmt(cls, cls2, zzgmu);
    }

    public abstract zzgpb zza(zzgfw zzgfw, @Nullable zzggn zzggn) throws GeneralSecurityException;

    public final Class zzc() {
        return this.zza;
    }

    public final Class zzd() {
        return this.zzb;
    }
}
