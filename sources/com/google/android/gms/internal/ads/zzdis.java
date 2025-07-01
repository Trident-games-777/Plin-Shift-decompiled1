package com.google.android.gms.internal.ads;

import android.view.View;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.zzv;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzdis implements zzgee {
    final /* synthetic */ View zza;
    final /* synthetic */ zzdit zzb;

    zzdis(zzdit zzdit, View view) {
        this.zza = view;
        this.zzb = zzdit;
    }

    public final void zza(Throwable th) {
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzfl)).booleanValue()) {
            zzv.zzp().zzv(th, "omid native display exp");
        }
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        this.zzb.zzad(this.zza, (zzeew) obj);
    }
}
