package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzeih implements zzhfx {
    private final zzhgp zza;
    private final zzhgp zzb;
    private final zzhgp zzc;
    private final zzhgp zzd;

    public zzeih(zzhgp zzhgp, zzhgp zzhgp2, zzhgp zzhgp3, zzhgp zzhgp4, zzhgp zzhgp5) {
        this.zza = zzhgp2;
        this.zzb = zzhgp3;
        this.zzc = zzhgp4;
        this.zzd = zzhgp5;
    }

    /* renamed from: zza */
    public final zzeif zzb() {
        return new zzeif(zzfin.zzc(), (ScheduledExecutorService) this.zza.zzb(), (zzcrt) this.zzb.zzb(), (zzeiv) this.zzc.zzb(), (zzfln) this.zzd.zzb());
    }
}
