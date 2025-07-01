package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzdzz {
    private final zzges zza;
    private final zzdzu zzb;
    private final zzfjr zzc;

    zzdzz(zzges zzges, zzdzu zzdzu, zzfjr zzfjr) {
        this.zza = zzges;
        this.zzb = zzdzu;
        this.zzc = zzfjr;
    }

    public final ListenableFuture zza(zzbvx zzbvx) {
        zzfjh zzb2 = this.zzc.zzb(zzfjl.GMS_SIGNALS, zzgei.zzm(zzgei.zzh((Object) null), new zzdzw(zzbvx), this.zza));
        zzdzu zzdzu = this.zzb;
        Objects.requireNonNull(zzdzu);
        return zzgei.zzm(zzb2.zzf(new zzdzx(zzdzu)).zza(), new zzdzy(this, zzbvx), this.zza);
    }
}
