package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzgpc {
    /* access modifiers changed from: private */
    public final Map zza;
    /* access modifiers changed from: private */
    public final Map zzb;
    /* access modifiers changed from: private */
    public final Map zzc;
    /* access modifiers changed from: private */
    public final Map zzd;

    public zzgpc() {
        this.zza = new HashMap();
        this.zzb = new HashMap();
        this.zzc = new HashMap();
        this.zzd = new HashMap();
    }

    public final zzgpc zza(zzgms zzgms) throws GeneralSecurityException {
        zzgpd zzgpd = new zzgpd(zzgms.zzd(), zzgms.zzc(), (zzgpf) null);
        if (this.zzb.containsKey(zzgpd)) {
            zzgms zzgms2 = (zzgms) this.zzb.get(zzgpd);
            if (zzgms2.equals(zzgms) && zzgms.equals(zzgms2)) {
                return this;
            }
            throw new GeneralSecurityException("Attempt to register non-equal parser for already existing object of type: ".concat(zzgpd.toString()));
        }
        this.zzb.put(zzgpd, zzgms);
        return this;
    }

    public final zzgpc zzb(zzgmw zzgmw) throws GeneralSecurityException {
        zzgpe zzgpe = new zzgpe(zzgmw.zzc(), zzgmw.zzd(), (zzgpf) null);
        if (this.zza.containsKey(zzgpe)) {
            zzgmw zzgmw2 = (zzgmw) this.zza.get(zzgpe);
            if (zzgmw2.equals(zzgmw) && zzgmw.equals(zzgmw2)) {
                return this;
            }
            throw new GeneralSecurityException("Attempt to register non-equal serializer for already existing object of type: ".concat(zzgpe.toString()));
        }
        this.zza.put(zzgpe, zzgmw);
        return this;
    }

    public final zzgpc zzc(zzgoe zzgoe) throws GeneralSecurityException {
        zzgpd zzgpd = new zzgpd(zzgoe.zzd(), zzgoe.zzc(), (zzgpf) null);
        if (this.zzd.containsKey(zzgpd)) {
            zzgoe zzgoe2 = (zzgoe) this.zzd.get(zzgpd);
            if (zzgoe2.equals(zzgoe) && zzgoe.equals(zzgoe2)) {
                return this;
            }
            throw new GeneralSecurityException("Attempt to register non-equal parser for already existing object of type: ".concat(zzgpd.toString()));
        }
        this.zzd.put(zzgpd, zzgoe);
        return this;
    }

    public final zzgpc zzd(zzgoi zzgoi) throws GeneralSecurityException {
        zzgpe zzgpe = new zzgpe(zzgoi.zzc(), zzgoi.zzd(), (zzgpf) null);
        if (this.zzc.containsKey(zzgpe)) {
            zzgoi zzgoi2 = (zzgoi) this.zzc.get(zzgpe);
            if (zzgoi2.equals(zzgoi) && zzgoi.equals(zzgoi2)) {
                return this;
            }
            throw new GeneralSecurityException("Attempt to register non-equal serializer for already existing object of type: ".concat(zzgpe.toString()));
        }
        this.zzc.put(zzgpe, zzgoi);
        return this;
    }

    public zzgpc(zzgpg zzgpg) {
        this.zza = new HashMap(zzgpg.zza);
        this.zzb = new HashMap(zzgpg.zzb);
        this.zzc = new HashMap(zzgpg.zzc);
        this.zzd = new HashMap(zzgpg.zzd);
    }
}
