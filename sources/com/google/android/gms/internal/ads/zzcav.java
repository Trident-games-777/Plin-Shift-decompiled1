package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.zzv;
import java.util.concurrent.atomic.AtomicInteger;

@Deprecated
/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public class zzcav {
    private final zzcao zza;
    /* access modifiers changed from: private */
    public final AtomicInteger zzb = new AtomicInteger(0);

    public zzcav() {
        zzcao zzcao = new zzcao();
        this.zza = zzcao;
        zzgei.zzr(zzcao, new zzcat(this), zzcaj.zzf);
    }

    @Deprecated
    public final int zze() {
        return this.zzb.get();
    }

    @Deprecated
    public final void zzg() {
        this.zza.zzd(new Exception());
    }

    @Deprecated
    public final void zzh(Throwable th, String str) {
        this.zza.zzd(th);
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzhq)).booleanValue()) {
            zzv.zzp().zzv(th, str);
        }
    }

    @Deprecated
    public final void zzi(Object obj) {
        this.zza.zzc(obj);
    }

    @Deprecated
    public final void zzj(zzcas zzcas, zzcaq zzcaq) {
        zzgei.zzr(this.zza, new zzcau(this, zzcas, zzcaq), zzcaj.zzf);
    }
}
