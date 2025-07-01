package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.zzv;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzdir implements zzgee {
    final /* synthetic */ String zza = "Google";
    final /* synthetic */ zzdit zzb;

    zzdir(zzdit zzdit, String str, boolean z) {
        this.zzb = zzdit;
    }

    public final void zza(Throwable th) {
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzfl)).booleanValue()) {
            zzv.zzp().zzv(th, "omid native display exp");
        }
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        this.zzb.zze.zzT((zzcfk) obj);
        zzdit zzdit = this.zzb;
        zzcao zzp = zzdit.zze.zzp();
        zzeew zzf = zzdit.zzf(this.zza, true);
        if (zzf != null && zzp != null) {
            zzp.zzc(zzf);
        } else if (zzp != null) {
            zzp.cancel(false);
        }
    }
}
