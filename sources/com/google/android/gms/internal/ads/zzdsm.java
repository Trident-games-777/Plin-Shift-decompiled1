package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzbe;
import java.util.Map;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzdsm {
    /* access modifiers changed from: private */
    public final zzdsr zza;
    /* access modifiers changed from: private */
    public final Executor zzb;
    /* access modifiers changed from: private */
    public final Map zzc;

    public zzdsm(zzdsr zzdsr, Executor executor) {
        this.zza = zzdsr;
        this.zzc = zzdsr.zza();
        this.zzb = executor;
    }

    public final zzdsl zza() {
        zzdsl zzdsl = new zzdsl(this);
        zzdsl unused = zzdsl.zzb.putAll(zzdsl.zza.zzc);
        return zzdsl;
    }

    public final void zze() {
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzln)).booleanValue()) {
            zzdsl zza2 = zza();
            zza2.zzb("action", "pecr");
            zza2.zzf();
        }
    }
}
