package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzm;
import com.google.android.gms.ads.internal.client.zzs;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzdty implements zzdtm {
    /* access modifiers changed from: private */
    public final long zza;
    private final zzena zzb;

    zzdty(long j, Context context, zzdtr zzdtr, zzchk zzchk, String str) {
        this.zza = j;
        zzfcy zzv = zzchk.zzv();
        zzv.zzc(context);
        zzv.zza(new zzs());
        zzv.zzb(str);
        zzena zza2 = zzv.zzd().zza();
        this.zzb = zza2;
        zza2.zzD(new zzdtx(this, zzdtr));
    }

    public final void zza() {
        this.zzb.zzx();
    }

    public final void zzb(zzm zzm) {
        this.zzb.zzab(zzm);
    }

    public final void zzc() {
        this.zzb.zzW(ObjectWrapper.wrap(null));
    }
}
