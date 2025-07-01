package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzgnw {
    private static final zzgnw zza = new zzgnw();
    private final AtomicReference zzb = new AtomicReference(new zzgoq(new zzgon((zzgop) null), (zzgop) null));

    zzgnw() {
    }

    public static zzgnw zza() {
        return zza;
    }

    public final Class zzb(Class cls) throws GeneralSecurityException {
        return ((zzgoq) this.zzb.get()).zza(cls);
    }

    public final Object zzc(zzgfw zzgfw, Class cls) throws GeneralSecurityException {
        return ((zzgoq) this.zzb.get()).zzb(zzgfw, cls);
    }

    public final Object zzd(zzgou zzgou, Class cls) throws GeneralSecurityException {
        return ((zzgoq) this.zzb.get()).zzc(zzgou, cls);
    }

    public final synchronized void zze(zzgom zzgom) throws GeneralSecurityException {
        zzgon zzgon = new zzgon((zzgoq) this.zzb.get(), (zzgop) null);
        zzgon.zza(zzgom);
        this.zzb.set(new zzgoq(zzgon, (zzgop) null));
    }

    public final synchronized void zzf(zzgov zzgov) throws GeneralSecurityException {
        zzgon zzgon = new zzgon((zzgoq) this.zzb.get(), (zzgop) null);
        zzgon.zzb(zzgov);
        this.zzb.set(new zzgoq(zzgon, (zzgop) null));
    }
}
