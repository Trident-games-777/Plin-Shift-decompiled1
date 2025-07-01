package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzgon {
    /* access modifiers changed from: private */
    public final Map zza;
    /* access modifiers changed from: private */
    public final Map zzb;

    private zzgon() {
        this.zza = new HashMap();
        this.zzb = new HashMap();
    }

    public final zzgon zza(zzgom zzgom) throws GeneralSecurityException {
        if (zzgom != null) {
            zzgoo zzgoo = new zzgoo(zzgom.zzc(), zzgom.zzd(), (zzgop) null);
            if (this.zza.containsKey(zzgoo)) {
                zzgom zzgom2 = (zzgom) this.zza.get(zzgoo);
                if (zzgom2.equals(zzgom) && zzgom.equals(zzgom2)) {
                    return this;
                }
                throw new GeneralSecurityException("Attempt to register non-equal PrimitiveConstructor object for already existing object of type: ".concat(zzgoo.toString()));
            }
            this.zza.put(zzgoo, zzgom);
            return this;
        }
        throw new NullPointerException("primitive constructor must be non-null");
    }

    public final zzgon zzb(zzgov zzgov) throws GeneralSecurityException {
        Map map = this.zzb;
        Class zzb2 = zzgov.zzb();
        if (map.containsKey(zzb2)) {
            zzgov zzgov2 = (zzgov) this.zzb.get(zzb2);
            if (zzgov2.equals(zzgov) && zzgov.equals(zzgov2)) {
                return this;
            }
            throw new GeneralSecurityException("Attempt to register non-equal PrimitiveWrapper object or input class object for already existing object of type".concat(zzb2.toString()));
        }
        this.zzb.put(zzb2, zzgov);
        return this;
    }

    /* synthetic */ zzgon(zzgop zzgop) {
        this.zza = new HashMap();
        this.zzb = new HashMap();
    }

    /* synthetic */ zzgon(zzgoq zzgoq, zzgop zzgop) {
        this.zza = new HashMap(zzgoq.zza);
        this.zzb = new HashMap(zzgoq.zzb);
    }
}
