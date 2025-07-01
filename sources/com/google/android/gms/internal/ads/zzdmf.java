package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.client.zzm;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzdmf implements zzgee {
    final /* synthetic */ zzcao zza;

    zzdmf(zzdmg zzdmg, zzcao zzcao) {
        this.zza = zzcao;
    }

    public final void zza(Throwable th) {
        zzm.zzg("Failed to load media data due to video view load failure.");
        this.zza.zzd(th);
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzcfk zzcfk = (zzcfk) obj;
        if (zzcfk != null) {
            zzcfk.zzag("/video", new zzcdd(new zzdme(this)));
            zzcfk.zzaa();
            return;
        }
        this.zza.zzd(new zzeiz(1, "Missing webview from video view future."));
    }
}
