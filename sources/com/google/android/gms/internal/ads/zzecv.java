package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzg;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzecv implements zzhfx {
    private final zzhgp zza;
    private final zzhgp zzb;
    private final zzhgp zzc;
    private final zzhgp zzd;
    private final zzhgp zze;

    public zzecv(zzhgp zzhgp, zzhgp zzhgp2, zzhgp zzhgp3, zzhgp zzhgp4, zzhgp zzhgp5) {
        this.zza = zzhgp;
        this.zzb = zzhgp2;
        this.zzc = zzhgp3;
        this.zzd = zzhgp4;
        this.zze = zzhgp5;
    }

    /* renamed from: zza */
    public final zzect zzb() {
        Context zza2 = ((zzchq) this.zza).zza();
        Context context = zza2;
        zzcvq zza3 = ((zzcvr) this.zzb).zzb();
        zzcvq zzcvq = zza3;
        zzech zza4 = ((zzeci) this.zzd).zzb();
        zzech zzech = zza4;
        zzg zza5 = ((zzcho) this.zze).zzb();
        zzg zzg = zza5;
        return new zzect(zza2, zza3, (zzecl) this.zzc.zzb(), zza4, zza5);
    }
}
