package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.ViewGroup;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzenw implements zzhfx {
    private final zzhgp zza;
    private final zzhgp zzb;
    private final zzhgp zzc;

    public zzenw(zzhgp zzhgp, zzhgp zzhgp2, zzhgp zzhgp3, zzhgp zzhgp4) {
        this.zza = zzhgp2;
        this.zzb = zzhgp3;
        this.zzc = zzhgp4;
    }

    /* renamed from: zza */
    public final zzenu zzb() {
        zzges zzc2 = zzfin.zzc();
        zzges zzges = zzc2;
        Context zza2 = ((zzchq) this.zza).zza();
        Context context = zza2;
        zzffo zza3 = ((zzcwd) this.zzb).zza();
        zzffo zzffo = zza3;
        ViewGroup zza4 = ((zzcpb) this.zzc).zza();
        ViewGroup viewGroup = zza4;
        return new zzenu(zzc2, zza2, zza3, zza4);
    }
}
