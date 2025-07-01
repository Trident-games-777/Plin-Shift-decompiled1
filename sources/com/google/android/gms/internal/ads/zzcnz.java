package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzcnz implements zzhfx {
    private final zzhgp zza;
    private final zzhgp zzb;
    private final zzhgp zzc;
    private final zzhgp zzd;
    private final zzhgp zze;

    public zzcnz(zzhgp zzhgp, zzhgp zzhgp2, zzhgp zzhgp3, zzhgp zzhgp4, zzhgp zzhgp5) {
        this.zza = zzhgp;
        this.zzb = zzhgp2;
        this.zzc = zzhgp3;
        this.zzd = zzhgp4;
        this.zze = zzhgp5;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzcny((zzbor) this.zza.zzb(), (zzcnu) this.zzb.zzb(), (Executor) this.zzc.zzb(), (zzcnt) this.zzd.zzb(), (Clock) this.zze.zzb());
    }
}
