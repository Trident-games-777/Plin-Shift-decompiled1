package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzcxb implements zzhfx {
    private final zzhgp zza;
    private final zzhgp zzb;
    private final zzhgp zzc;

    public zzcxb(zzhgp zzhgp, zzhgp zzhgp2, zzhgp zzhgp3, zzhgp zzhgp4) {
        this.zza = zzhgp;
        this.zzb = zzhgp2;
        this.zzc = zzhgp4;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzcwy zza2 = ((zzcxa) this.zza).zzb();
        zzcwy zzcwy = zza2;
        Set zzc2 = ((zzhgl) this.zzb).zzb();
        Set set = zzc2;
        return new zzcwz(zza2, zzc2, zzfin.zzc(), (ScheduledExecutorService) this.zzc.zzb());
    }
}
