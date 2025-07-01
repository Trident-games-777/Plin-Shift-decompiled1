package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzgnz {
    private static final zzgnz zza = ((zzgnz) zzgpi.zza(new zzgnx()));
    private final AtomicReference zzb = new AtomicReference(new zzgpg(new zzgpc(), (zzgpf) null));

    public static zzgnz zzc() {
        return zza;
    }

    public final zzgfw zza(zzgpb zzgpb, @Nullable zzggn zzggn) throws GeneralSecurityException {
        return ((zzgpg) this.zzb.get()).zza(zzgpb, zzggn);
    }

    public final zzggj zzb(zzgpb zzgpb) throws GeneralSecurityException {
        return ((zzgpg) this.zzb.get()).zzb(zzgpb);
    }

    public final zzgpb zzd(zzgfw zzgfw, Class cls, @Nullable zzggn zzggn) throws GeneralSecurityException {
        return ((zzgpg) this.zzb.get()).zzc(zzgfw, cls, zzggn);
    }

    public final zzgpb zze(zzggj zzggj, Class cls) throws GeneralSecurityException {
        return ((zzgpg) this.zzb.get()).zzd(zzggj, cls);
    }

    public final synchronized void zzf(zzgms zzgms) throws GeneralSecurityException {
        zzgpc zzgpc = new zzgpc((zzgpg) this.zzb.get());
        zzgpc.zza(zzgms);
        this.zzb.set(new zzgpg(zzgpc, (zzgpf) null));
    }

    public final synchronized void zzg(zzgmw zzgmw) throws GeneralSecurityException {
        zzgpc zzgpc = new zzgpc((zzgpg) this.zzb.get());
        zzgpc.zzb(zzgmw);
        this.zzb.set(new zzgpg(zzgpc, (zzgpf) null));
    }

    public final synchronized void zzh(zzgoe zzgoe) throws GeneralSecurityException {
        zzgpc zzgpc = new zzgpc((zzgpg) this.zzb.get());
        zzgpc.zzc(zzgoe);
        this.zzb.set(new zzgpg(zzgpc, (zzgpf) null));
    }

    public final synchronized void zzi(zzgoi zzgoi) throws GeneralSecurityException {
        zzgpc zzgpc = new zzgpc((zzgpg) this.zzb.get());
        zzgpc.zzd(zzgoi);
        this.zzb.set(new zzgpg(zzgpc, (zzgpf) null));
    }

    public final boolean zzj(zzgpb zzgpb) {
        return ((zzgpg) this.zzb.get()).zzi(zzgpb);
    }

    public final boolean zzk(zzgpb zzgpb) {
        return ((zzgpg) this.zzb.get()).zzj(zzgpb);
    }
}
