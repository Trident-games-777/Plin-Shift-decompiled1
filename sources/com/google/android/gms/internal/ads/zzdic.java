package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.HashSet;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzdic implements zzhfx {
    private final zzhgp zza;
    private final zzhgp zzb;

    public zzdic(zzhgp zzhgp, zzhgp zzhgp2) {
        this.zza = zzhgp;
        this.zzb = zzhgp2;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzfet zza2 = ((zzcsh) this.zzb).zza();
        zzfet zzfet = zza2;
        zzdef zzdef = new zzdef((Context) this.zza.zzb(), new HashSet(), zza2);
        zzdef zzdef2 = zzdef;
        return zzdef;
    }
}
