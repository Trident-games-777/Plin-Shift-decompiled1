package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzfcx implements zzhfx {
    private final zzhgp zza;
    private final zzhgp zzb;
    private final zzhgp zzc;
    private final zzhgp zzd;
    private final zzhgp zze;

    public zzfcx(zzhgp zzhgp, zzhgp zzhgp2, zzhgp zzhgp3, zzhgp zzhgp4, zzhgp zzhgp5, zzhgp zzhgp6) {
        this.zza = zzhgp;
        this.zzb = zzhgp2;
        this.zzc = zzhgp3;
        this.zzd = zzhgp4;
        this.zze = zzhgp5;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzffm zzffm = new zzffm();
        zzffm zzffm2 = zzffm;
        return new zzfcw((Context) this.zza.zzb(), (Executor) this.zzb.zzb(), (zzchk) this.zzc.zzb(), (zzems) this.zzd.zzb(), (zzfdw) this.zze.zzb(), zzffm);
    }
}
