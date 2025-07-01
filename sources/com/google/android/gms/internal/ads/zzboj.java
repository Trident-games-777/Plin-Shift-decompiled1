package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zze;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzboj implements zzcas {
    final /* synthetic */ zzbno zza;
    final /* synthetic */ Object zzb;
    final /* synthetic */ zzcao zzc;
    final /* synthetic */ zzbom zzd;

    zzboj(zzbom zzbom, zzbno zzbno, Object obj, zzcao zzcao) {
        this.zza = zzbno;
        this.zzb = obj;
        this.zzc = zzcao;
        this.zzd = zzbom;
    }

    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        zze.zza("callJs > getEngine: Promise fulfilled");
        Object obj2 = this.zzb;
        zzcao zzcao = this.zzc;
        zzbom.zzd(this.zzd, this.zza, (zzbnv) obj, obj2, zzcao);
    }
}
