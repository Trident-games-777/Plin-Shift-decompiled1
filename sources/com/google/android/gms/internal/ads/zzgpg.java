package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzgpg {
    /* access modifiers changed from: private */
    public final Map zza;
    /* access modifiers changed from: private */
    public final Map zzb;
    /* access modifiers changed from: private */
    public final Map zzc;
    /* access modifiers changed from: private */
    public final Map zzd;

    /* synthetic */ zzgpg(zzgpc zzgpc, zzgpf zzgpf) {
        this.zza = new HashMap(zzgpc.zza);
        this.zzb = new HashMap(zzgpc.zzb);
        this.zzc = new HashMap(zzgpc.zzc);
        this.zzd = new HashMap(zzgpc.zzd);
    }

    public final zzgfw zza(zzgpb zzgpb, @Nullable zzggn zzggn) throws GeneralSecurityException {
        zzgpd zzgpd = new zzgpd(zzgpb.getClass(), zzgpb.zzd(), (zzgpf) null);
        if (this.zzb.containsKey(zzgpd)) {
            return ((zzgms) this.zzb.get(zzgpd)).zza(zzgpb, zzggn);
        }
        String obj = zzgpd.toString();
        throw new GeneralSecurityException("No Key Parser for requested key type " + obj + " available");
    }

    public final zzggj zzb(zzgpb zzgpb) throws GeneralSecurityException {
        zzgpd zzgpd = new zzgpd(zzgpb.getClass(), zzgpb.zzd(), (zzgpf) null);
        if (this.zzd.containsKey(zzgpd)) {
            return ((zzgoe) this.zzd.get(zzgpd)).zza(zzgpb);
        }
        String obj = zzgpd.toString();
        throw new GeneralSecurityException("No Parameters Parser for requested key type " + obj + " available");
    }

    public final zzgpb zzc(zzgfw zzgfw, Class cls, @Nullable zzggn zzggn) throws GeneralSecurityException {
        zzgpe zzgpe = new zzgpe(zzgfw.getClass(), cls, (zzgpf) null);
        if (this.zza.containsKey(zzgpe)) {
            return ((zzgmw) this.zza.get(zzgpe)).zza(zzgfw, zzggn);
        }
        String obj = zzgpe.toString();
        throw new GeneralSecurityException("No Key serializer for " + obj + " available");
    }

    public final zzgpb zzd(zzggj zzggj, Class cls) throws GeneralSecurityException {
        zzgpe zzgpe = new zzgpe(zzggj.getClass(), cls, (zzgpf) null);
        if (this.zzc.containsKey(zzgpe)) {
            return ((zzgoi) this.zzc.get(zzgpe)).zza(zzggj);
        }
        String obj = zzgpe.toString();
        throw new GeneralSecurityException("No Key Format serializer for " + obj + " available");
    }

    public final boolean zzi(zzgpb zzgpb) {
        return this.zzb.containsKey(new zzgpd(zzgpb.getClass(), zzgpb.zzd(), (zzgpf) null));
    }

    public final boolean zzj(zzgpb zzgpb) {
        return this.zzd.containsKey(new zzgpd(zzgpb.getClass(), zzgpb.zzd(), (zzgpf) null));
    }
}
