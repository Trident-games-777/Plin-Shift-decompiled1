package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
final class zzbsq extends zzbhb {
    final /* synthetic */ zzbst zza;

    /* synthetic */ zzbsq(zzbst zzbst, zzbss zzbss) {
        this.zza = zzbst;
    }

    public final void zze(zzbgs zzbgs, String str) {
        zzbst zzbst = this.zza;
        if (zzbst.zzb != null) {
            zzbst.zzb.onCustomClick(zzbst.zzf(zzbgs), str);
        }
    }
}
