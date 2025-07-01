package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzgnm {
    public static final zzgne zza = new zzgnk((zzgnl) null);

    public static zzgnj zza(zzgou zzgou) {
        zzgfy zzgfy;
        zzgng zzgng = new zzgng();
        zzgng.zzb(zzgou.zza());
        for (List it : zzgou.zze()) {
            Iterator it2 = it.iterator();
            while (true) {
                if (it2.hasNext()) {
                    zzgos zzgos = (zzgos) it2.next();
                    int zzf = zzgos.zzf() - 2;
                    if (zzf == 1) {
                        zzgfy = zzgfy.zza;
                    } else if (zzf == 2) {
                        zzgfy = zzgfy.zzb;
                    } else if (zzf == 3) {
                        zzgfy = zzgfy.zzc;
                    } else {
                        throw new IllegalStateException("Unknown key status");
                    }
                    int zza2 = zzgos.zza();
                    String zze = zzgos.zze();
                    if (zze.startsWith("type.googleapis.com/google.crypto.")) {
                        zze = zze.substring(34);
                    }
                    zzgng.zza(zzgfy, zza2, zze, zzgos.zzb().name());
                }
            }
        }
        if (zzgou.zzc() != null) {
            zzgng.zzc(zzgou.zzc().zza());
        }
        try {
            return zzgng.zzd();
        } catch (GeneralSecurityException e) {
            throw new IllegalStateException(e);
        }
    }
}
