package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzfbz implements zzfck {
    private zzcvt zza;

    /* renamed from: zza */
    public final synchronized zzcvt zzd() {
        return this.zza;
    }

    public final /* bridge */ /* synthetic */ ListenableFuture zzc(zzfcl zzfcl, zzfcj zzfcj, Object obj) {
        zzcvt zzcvt = null;
        return zzb(zzfcl, zzfcj, (zzcvt) null);
    }

    public final synchronized ListenableFuture zzb(zzfcl zzfcl, zzfcj zzfcj, zzcvt zzcvt) {
        zzcsy zzb;
        if (zzcvt != null) {
            this.zza = zzcvt;
        } else {
            this.zza = (zzcvt) zzfcj.zza(zzfcl.zzb).zzh();
        }
        zzb = this.zza.zzb();
        return zzb.zzi(zzb.zzj());
    }
}
