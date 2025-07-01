package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zze;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzbok implements zzcaq {
    final /* synthetic */ zzcao zza;
    final /* synthetic */ zzbno zzb;

    zzbok(zzbom zzbom, zzcao zzcao, zzbno zzbno) {
        this.zza = zzcao;
        this.zzb = zzbno;
    }

    public final void zza() {
        zze.zza("callJs > getEngine: Promise rejected");
        this.zza.zzd(new zzbnx("Unable to obtain a JavascriptEngine."));
        this.zzb.zzb();
    }
}
