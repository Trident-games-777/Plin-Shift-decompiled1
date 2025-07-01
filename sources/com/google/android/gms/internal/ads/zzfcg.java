package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzfcg {
    private final zzfhc zza;
    private final zzcvt zzb;
    private final Executor zzc;
    /* access modifiers changed from: private */
    public zzfce zzd;

    public zzfcg(zzfhc zzfhc, zzcvt zzcvt, Executor executor) {
        this.zza = zzfhc;
        this.zzb = zzcvt;
        this.zzc = executor;
    }

    /* access modifiers changed from: private */
    @Deprecated
    public final zzfhm zze() {
        zzffo zzg = this.zzb.zzg();
        return this.zza.zzc(zzg.zzd, zzg.zzf, zzg.zzj);
    }

    public final ListenableFuture zzc() {
        ListenableFuture listenableFuture;
        zzfce zzfce = this.zzd;
        if (zzfce != null) {
            return zzgei.zzh(zzfce);
        }
        if (!((Boolean) zzbeu.zza.zze()).booleanValue()) {
            zzfce zzfce2 = new zzfce((zzbvx) null, zze(), (zzfcf) null);
            this.zzd = zzfce2;
            listenableFuture = zzgei.zzh(zzfce2);
        } else {
            Class<zzdyw> cls = zzdyw.class;
            listenableFuture = (zzgdz) zzgei.zze((zzgdz) zzgei.zzm(zzgdz.zzu(this.zzb.zzb().zze(this.zza.zza())), new zzfcd(this), this.zzc), cls, new zzfcc(this), this.zzc);
        }
        return zzgei.zzm(listenableFuture, new zzfcb(), this.zzc);
    }
}
