package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzewd implements zzhfx {
    private final zzhgp zza;
    private final zzhgp zzb;
    private final zzhgp zzc;
    private final zzhgp zzd;

    public zzewd(zzhgp zzhgp, zzhgp zzhgp2, zzhgp zzhgp3, zzhgp zzhgp4, zzhgp zzhgp5) {
        this.zza = zzhgp;
        this.zzb = zzhgp3;
        this.zzc = zzhgp4;
        this.zzd = zzhgp5;
    }

    /* renamed from: zza */
    public final zzewc zzb() {
        Context zza2 = ((zzchq) this.zza).zza();
        Context context = zza2;
        Set zzc2 = ((zzhgl) this.zzb).zzb();
        Set set = zzc2;
        return new zzewc(zza2, zzfin.zzc(), zzc2, (zzfkl) this.zzc.zzb(), (zzdsm) this.zzd.zzb());
    }
}
