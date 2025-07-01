package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzexb implements zzhfx {
    private final zzhgp zza;
    private final zzhgp zzb;
    private final zzhgp zzc;
    private final zzhgp zzd;
    private final zzhgp zze;

    public zzexb(zzhgp zzhgp, zzhgp zzhgp2, zzhgp zzhgp3, zzhgp zzhgp4, zzhgp zzhgp5, zzhgp zzhgp6, zzhgp zzhgp7) {
        this.zza = zzhgp2;
        this.zzb = zzhgp3;
        this.zzc = zzhgp5;
        this.zzd = zzhgp6;
        this.zze = zzhgp7;
    }

    public static zzewz zza(zzbzq zzbzq, Context context, ScheduledExecutorService scheduledExecutorService, Executor executor, int i, boolean z, boolean z2) {
        return new zzewz(zzbzq, context, scheduledExecutorService, executor, i, z, z2);
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzbzq zza2 = zzclk.zza();
        zzbzq zzbzq = zza2;
        Context zza3 = ((zzchq) this.zza).zza();
        Context context = zza3;
        Integer zza4 = ((zzeyx) this.zzc).zzb();
        Integer num = zza4;
        int intValue = zza4.intValue();
        Boolean zza5 = ((zzeyy) this.zzd).zzb();
        Boolean bool = zza5;
        boolean booleanValue = zza5.booleanValue();
        Boolean zza6 = ((zzeza) this.zze).zzb();
        Boolean bool2 = zza6;
        return new zzewz(zza2, zza3, (ScheduledExecutorService) this.zzb.zzb(), zzfin.zzc(), intValue, booleanValue, zza6.booleanValue());
    }
}
