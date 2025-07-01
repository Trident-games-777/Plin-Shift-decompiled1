package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzfbw implements zzfck {
    private final zzfhc zza;
    private final Executor zzb;
    private final zzgee zzc = new zzfbu(this);

    public zzfbw(zzfhc zzfhc, Executor executor) {
        this.zza = zzfhc;
        this.zzb = executor;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zza(zzcvt zzcvt, zzfce zzfce) throws Exception {
        zzfhc zzfhc = this.zza;
        zzfhm zzfhm = zzfce.zzb;
        zzbvx zzbvx = zzfce.zza;
        zzfhl zzb2 = zzfhc.zzb(zzfhm);
        if (!(zzb2 == null || zzbvx == null)) {
            zzgei.zzr(zzcvt.zzb().zzh(zzbvx), this.zzc, this.zzb);
        }
        return zzgei.zzh(new zzfbv(zzfhm, zzbvx, zzb2));
    }

    public final ListenableFuture zzb(zzfcl zzfcl, zzfcj zzfcj, zzcvt zzcvt) {
        return (zzgdz) zzgei.zze((zzgdz) zzgei.zzn(zzgdz.zzu(new zzfcg(this.zza, zzcvt, this.zzb).zzc()), new zzfbs(this, zzcvt), this.zzb), Exception.class, new zzfbt(this), this.zzb);
    }

    public final /* bridge */ /* synthetic */ ListenableFuture zzc(zzfcl zzfcl, zzfcj zzfcj, Object obj) {
        zzcvt zzcvt = null;
        return zzb(zzfcl, zzfcj, (zzcvt) null);
    }

    public final /* bridge */ /* synthetic */ Object zzd() {
        return null;
    }
}
