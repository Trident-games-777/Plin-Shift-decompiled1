package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzbor {
    private final zzbnu zza;
    private ListenableFuture zzb;

    zzbor(zzbnu zzbnu) {
        this.zza = zzbnu;
    }

    private final void zzd() {
        if (this.zzb == null) {
            zzcao zzcao = new zzcao();
            this.zzb = zzcao;
            this.zza.zzb((zzavc) null).zzj(new zzboo(zzcao), new zzbop(zzcao));
        }
    }

    public final zzbou zza(String str, zzbob zzbob, zzboa zzboa) {
        zzd();
        return new zzbou(this.zzb, "google.afma.activeView.handleUpdate", zzbob, zzboa);
    }

    public final void zzb(String str, zzbjr zzbjr) {
        zzd();
        this.zzb = zzgei.zzn(this.zzb, new zzboq(str, zzbjr), zzcaj.zzf);
    }

    public final void zzc(String str, zzbjr zzbjr) {
        this.zzb = zzgei.zzm(this.zzb, new zzbon(str, zzbjr), zzcaj.zzf);
    }
}
