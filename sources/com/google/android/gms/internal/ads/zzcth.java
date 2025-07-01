package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzcth implements zzhfx {
    private final zzhgp zza;
    private final zzhgp zzb;
    private final zzhgp zzc;

    public zzcth(zzhgp zzhgp, zzhgp zzhgp2, zzhgp zzhgp3) {
        this.zza = zzhgp;
        this.zzb = zzhgp2;
        this.zzc = zzhgp3;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzcad zza2 = ((zzcig) this.zzb).zzb();
        zzcad zzcad = zza2;
        zzffo zza3 = ((zzcwd) this.zzc).zza();
        zzffo zzffo = zza3;
        zzbzs zzc2 = zza2.zzc((Clock) this.zza.zzb(), zza3.zzf);
        zzbzs zzbzs = zzc2;
        return zzc2;
    }
}
