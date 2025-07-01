package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzgoq {
    /* access modifiers changed from: private */
    public final Map zza;
    /* access modifiers changed from: private */
    public final Map zzb;

    /* synthetic */ zzgoq(zzgon zzgon, zzgop zzgop) {
        this.zza = new HashMap(zzgon.zza);
        this.zzb = new HashMap(zzgon.zzb);
    }

    public final Class zza(Class cls) throws GeneralSecurityException {
        if (this.zzb.containsKey(cls)) {
            return ((zzgov) this.zzb.get(cls)).zza();
        }
        String obj = cls.toString();
        throw new GeneralSecurityException("No input primitive class for " + obj + " available");
    }

    public final Object zzb(zzgfw zzgfw, Class cls) throws GeneralSecurityException {
        zzgoo zzgoo = new zzgoo(zzgfw.getClass(), cls, (zzgop) null);
        if (this.zza.containsKey(zzgoo)) {
            return ((zzgom) this.zza.get(zzgoo)).zza(zzgfw);
        }
        String obj = zzgoo.toString();
        throw new GeneralSecurityException("No PrimitiveConstructor for " + obj + " available");
    }

    public final Object zzc(zzgou zzgou, Class cls) throws GeneralSecurityException {
        if (this.zzb.containsKey(cls)) {
            zzgov zzgov = (zzgov) this.zzb.get(cls);
            if (zzgou.zzd().equals(zzgov.zza()) && zzgov.zza().equals(zzgou.zzd())) {
                return zzgov.zzc(zzgou);
            }
            throw new GeneralSecurityException("Input primitive type of the wrapper doesn't match the type of primitives in the provided PrimitiveSet");
        }
        throw new GeneralSecurityException("No wrapper found for ".concat(cls.toString()));
    }
}
