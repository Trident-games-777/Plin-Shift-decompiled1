package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzgnp {
    public static final /* synthetic */ int zza = 0;
    private static final zzgno zzb = new zzgnn();
    private static final zzgnp zzc = zze();
    private final Map zzd = new HashMap();

    public static zzgnp zzb() {
        return zzc;
    }

    private final synchronized zzgfw zzd(zzggj zzggj, @Nullable Integer num) throws GeneralSecurityException {
        zzgno zzgno;
        zzgno = (zzgno) this.zzd.get(zzggj.getClass());
        if (zzgno != null) {
        } else {
            String obj = zzggj.toString();
            throw new GeneralSecurityException("Cannot create a new key for parameters " + obj + ": no key creator for this class was registered.");
        }
        return zzgno.zza(zzggj, num);
    }

    private static zzgnp zze() {
        zzgnp zzgnp = new zzgnp();
        try {
            zzgnp.zzc(zzb, zzgna.class);
            return zzgnp;
        } catch (GeneralSecurityException e) {
            throw new IllegalStateException("unexpected error.", e);
        }
    }

    public final zzgfw zza(zzggj zzggj, @Nullable Integer num) throws GeneralSecurityException {
        return zzd(zzggj, num);
    }

    public final synchronized void zzc(zzgno zzgno, Class cls) throws GeneralSecurityException {
        zzgno zzgno2 = (zzgno) this.zzd.get(cls);
        if (zzgno2 != null) {
            if (!zzgno2.equals(zzgno)) {
                String obj = cls.toString();
                throw new GeneralSecurityException("Different key creator for parameters class " + obj + " already inserted");
            }
        }
        this.zzd.put(cls, zzgno);
    }
}
