package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzggh {
    private static final CopyOnWriteArrayList zza = new CopyOnWriteArrayList();

    public static zzggg zza(String str) throws GeneralSecurityException {
        Iterator it = zza.iterator();
        while (it.hasNext()) {
            zzggg zzggg = (zzggg) it.next();
            if (zzggg.zza()) {
                return zzggg;
            }
        }
        throw new GeneralSecurityException("No KMS client does support: ".concat(String.valueOf(str)));
    }
}
