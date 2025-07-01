package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzgmo {
    private static final Logger zza = Logger.getLogger(zzgmo.class.getName());
    private static final zzgmo zzb = new zzgmo();
    private final ConcurrentMap zzc = new ConcurrentHashMap();
    private final ConcurrentMap zzd = new ConcurrentHashMap();

    public static zzgmo zzc() {
        return zzb;
    }

    private final synchronized zzgfx zzg(String str) throws GeneralSecurityException {
        if (this.zzc.containsKey(str)) {
        } else {
            throw new GeneralSecurityException("No key manager found for key type ".concat(String.valueOf(str)));
        }
        return (zzgfx) this.zzc.get(str);
    }

    private final synchronized void zzh(zzgfx zzgfx, boolean z, boolean z2) throws GeneralSecurityException {
        String str = ((zzgmx) zzgfx).zza;
        if (this.zzd.containsKey(str)) {
            if (!((Boolean) this.zzd.get(str)).booleanValue()) {
                throw new GeneralSecurityException("New keys are already disallowed for key type ".concat(str));
            }
        }
        zzgfx zzgfx2 = (zzgfx) this.zzc.get(str);
        if (zzgfx2 != null) {
            if (!zzgfx2.getClass().equals(zzgfx.getClass())) {
                zza.logp(Level.WARNING, "com.google.crypto.tink.internal.KeyManagerRegistry", "insertKeyManager", "Attempted overwrite of a registered key manager for key type ".concat(str));
                throw new GeneralSecurityException(String.format("typeUrl (%s) is already registered with %s, cannot be re-registered with %s", new Object[]{str, zzgfx2.getClass().getName(), zzgfx.getClass().getName()}));
            }
        }
        this.zzc.putIfAbsent(str, zzgfx);
        this.zzd.put(str, true);
    }

    public final zzgfx zza(String str, Class cls) throws GeneralSecurityException {
        zzgfx zzg = zzg(str);
        if (zzg.zzb().equals(cls)) {
            return zzg;
        }
        String name = cls.getName();
        String valueOf = String.valueOf(zzg.getClass());
        String obj = zzg.zzb().toString();
        throw new GeneralSecurityException("Primitive type " + name + " not supported by key manager of type " + valueOf + ", which only supports: " + obj);
    }

    public final zzgfx zzb(String str) throws GeneralSecurityException {
        return zzg(str);
    }

    public final synchronized void zzd(zzgfx zzgfx, boolean z) throws GeneralSecurityException {
        zzf(zzgfx, 1, true);
    }

    public final boolean zze(String str) {
        return ((Boolean) this.zzd.get(str)).booleanValue();
    }

    public final synchronized void zzf(zzgfx zzgfx, int i, boolean z) throws GeneralSecurityException {
        if (zzgmh.zza(i)) {
            zzh(zzgfx, false, true);
        } else {
            throw new GeneralSecurityException("Cannot register key manager: FIPS compatibility insufficient");
        }
    }
}
