package com.google.android.gms.ads.nonagon.signalgeneration;

import android.content.Context;
import com.google.android.gms.internal.ads.zzchq;
import com.google.android.gms.internal.ads.zzdsr;
import com.google.android.gms.internal.ads.zzfin;
import com.google.android.gms.internal.ads.zzhfx;
import com.google.android.gms.internal.ads.zzhgp;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzm implements zzhfx {
    private final zzhgp zza;
    private final zzhgp zzb;

    public zzm(zzhgp zzhgp, zzhgp zzhgp2, zzhgp zzhgp3) {
        this.zza = zzhgp;
        this.zzb = zzhgp2;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        Context zza2 = ((zzchq) this.zza).zza();
        Context context = zza2;
        return new zzj(zza2, (zzdsr) this.zzb.zzb(), zzfin.zzc());
    }
}
