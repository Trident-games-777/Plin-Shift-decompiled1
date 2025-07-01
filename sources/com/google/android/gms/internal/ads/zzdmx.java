package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzbe;
import java.util.Map;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzdmx {
    private final Executor zza;
    private final zzcoi zzb;
    private final zzdef zzc;
    private final zzcnb zzd;

    zzdmx(Executor executor, zzcoi zzcoi, zzdef zzdef, zzcnb zzcnb) {
        this.zza = executor;
        this.zzc = zzdef;
        this.zzb = zzcoi;
        this.zzd = zzcnb;
    }

    public final void zza(zzcfk zzcfk) {
        if (zzcfk != null) {
            this.zzc.zza(zzcfk.zzF());
            this.zzc.zzo(new zzdmt(zzcfk), this.zza);
            this.zzc.zzo(new zzdmu(zzcfk), this.zza);
            this.zzc.zzo(this.zzb, this.zza);
            this.zzb.zzf(zzcfk);
            zzchc zzN = zzcfk.zzN();
            if (((Boolean) zzbe.zzc().zza(zzbcn.zzjN)).booleanValue() && zzN != null) {
                zzN.zzK(this.zzd);
                zzN.zzL(this.zzd, (zzedp) null, (zzdsm) null);
            }
            zzcfk.zzag("/trackActiveViewUnit", new zzdmv(this));
            zzcfk.zzag("/untrackActiveViewUnit", new zzdmw(this));
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(zzcfk zzcfk, Map map) {
        this.zzb.zzb();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzc(zzcfk zzcfk, Map map) {
        this.zzb.zza();
    }
}
