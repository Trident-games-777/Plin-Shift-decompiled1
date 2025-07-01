package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzs;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzfbg implements zzhfx {
    private final zzhgp zza;
    private final zzhgp zzb;
    private final zzhgp zzc;
    private final zzhgp zzd;
    private final zzhgp zze;
    private final zzhgp zzf;
    private final zzhgp zzg;

    public zzfbg(zzhgp zzhgp, zzhgp zzhgp2, zzhgp zzhgp3, zzhgp zzhgp4, zzhgp zzhgp5, zzhgp zzhgp6, zzhgp zzhgp7, zzhgp zzhgp8) {
        this.zza = zzhgp;
        this.zzb = zzhgp2;
        this.zzc = zzhgp3;
        this.zzd = zzhgp4;
        this.zze = zzhgp5;
        this.zzf = zzhgp6;
        this.zzg = zzhgp8;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzffm zzffm = new zzffm();
        zzffm zzffm2 = zzffm;
        return new zzfbf((Context) this.zza.zzb(), (Executor) this.zzb.zzb(), (zzs) this.zzc.zzb(), (zzchk) this.zzd.zzb(), (zzems) this.zze.zzb(), (zzemw) this.zzf.zzb(), zzffm, (zzdbk) this.zzg.zzb());
    }
}
