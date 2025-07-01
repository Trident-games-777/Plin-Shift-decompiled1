package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzdeg implements zzhfx {
    private final zzhgp zza;
    private final zzhgp zzb;
    private final zzhgp zzc;

    public zzdeg(zzhgp zzhgp, zzhgp zzhgp2, zzhgp zzhgp3) {
        this.zza = zzhgp;
        this.zzb = zzhgp2;
        this.zzc = zzhgp3;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        Set zzc2 = ((zzhgl) this.zzb).zzb();
        Set set = zzc2;
        zzfet zza2 = ((zzcsh) this.zzc).zza();
        zzfet zzfet = zza2;
        return new zzdef((Context) this.zza.zzb(), zzc2, zza2);
    }
}
