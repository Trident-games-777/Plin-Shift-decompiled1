package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.zzr;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzfls implements zzhfx {
    private final zzhgp zza;
    private final zzhgp zzb;
    private final zzhgp zzc;

    public zzfls(zzhgp zzhgp, zzhgp zzhgp2, zzhgp zzhgp3, zzhgp zzhgp4) {
        this.zza = zzhgp;
        this.zzb = zzhgp3;
        this.zzc = zzhgp4;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        Context zza2 = ((zzchq) this.zza).zza();
        Context context = zza2;
        return new zzflr(zza2, zzfin.zzc(), (zzr) this.zzb.zzb(), (zzfko) this.zzc.zzb());
    }
}
