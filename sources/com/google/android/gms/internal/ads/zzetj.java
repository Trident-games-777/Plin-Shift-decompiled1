package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.ViewGroup;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzetj implements zzhfx {
    private final zzhgp zza;
    private final zzhgp zzb;
    private final zzhgp zzc;

    public zzetj(zzhgp zzhgp, zzhgp zzhgp2, zzhgp zzhgp3, zzhgp zzhgp4) {
        this.zza = zzhgp2;
        this.zzb = zzhgp3;
        this.zzc = zzhgp4;
    }

    /* renamed from: zza */
    public final zzeth zzb() {
        zzges zzc2 = zzfin.zzc();
        zzges zzges = zzc2;
        ViewGroup zza2 = ((zzcpb) this.zza).zza();
        ViewGroup viewGroup = zza2;
        Set zzc3 = ((zzhgl) this.zzc).zzb();
        Set set = zzc3;
        return new zzeth(zzc2, zza2, (Context) this.zzb.zzb(), zzc3);
    }
}
