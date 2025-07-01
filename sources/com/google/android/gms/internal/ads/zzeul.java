package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzeul implements zzhfx {
    private final zzhgp zza;
    private final zzhgp zzb;

    public zzeul(zzhgp zzhgp, zzhgp zzhgp2, zzhgp zzhgp3) {
        this.zza = zzhgp2;
        this.zzb = zzhgp3;
    }

    /* renamed from: zza */
    public final zzeuj zzb() {
        zzges zzc = zzfin.zzc();
        zzges zzges = zzc;
        Context zza2 = ((zzchq) this.zza).zza();
        Context context = zza2;
        return new zzeuj(zzc, zza2, (Set) this.zzb.zzb());
    }
}
