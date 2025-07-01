package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzerj implements zzhfx {
    private final zzhgp zza;
    private final zzhgp zzb;
    private final zzhgp zzc;

    public zzerj(zzhgp zzhgp, zzhgp zzhgp2, zzhgp zzhgp3, zzhgp zzhgp4) {
        this.zza = zzhgp;
        this.zzb = zzhgp2;
        this.zzc = zzhgp4;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzetk zza2 = ((zzetm) this.zza).zzb();
        zzetk zzetk = zza2;
        zzeqp zzeqp = new zzeqp(zza2, ((Long) zzbec.zze.zze()).longValue(), (Clock) this.zzb.zzb(), zzfin.zzc(), (zzdsm) this.zzc.zzb());
        zzeqp zzeqp2 = zzeqp;
        return zzeqp;
    }
}
