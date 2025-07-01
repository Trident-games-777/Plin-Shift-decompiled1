package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public abstract class zzgms {
    private final zzgwu zza;
    private final Class zzb;

    /* synthetic */ zzgms(zzgwu zzgwu, Class cls, zzgmr zzgmr) {
        this.zza = zzgwu;
        this.zzb = cls;
    }

    public static zzgms zzb(zzgmq zzgmq, zzgwu zzgwu, Class cls) {
        return new zzgmp(zzgwu, cls, zzgmq);
    }

    public abstract zzgfw zza(zzgpb zzgpb, @Nullable zzggn zzggn) throws GeneralSecurityException;

    public final zzgwu zzc() {
        return this.zza;
    }

    public final Class zzd() {
        return this.zzb;
    }
}
