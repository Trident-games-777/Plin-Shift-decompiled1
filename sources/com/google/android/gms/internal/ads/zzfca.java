package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzfca implements zzfck {
    private final zzfck zza;
    private zzcvt zzb;

    public zzfca(zzfck zzfck) {
        this.zza = zzfck;
    }

    /* renamed from: zza */
    public final synchronized zzcvt zzd() {
        return this.zzb;
    }

    public final synchronized ListenableFuture zzb(zzfcl zzfcl, zzfcj zzfcj, zzcvt zzcvt) {
        this.zzb = zzcvt;
        if (zzfcl.zza != null) {
            zzcsy zzb2 = this.zzb.zzb();
            return zzb2.zzi(zzb2.zzk(zzgei.zzh(zzfcl.zza)));
        }
        zzcvt zzcvt2 = zzcvt;
        return ((zzfbz) this.zza).zzb(zzfcl, zzfcj, zzcvt);
    }

    public final /* bridge */ /* synthetic */ ListenableFuture zzc(zzfcl zzfcl, zzfcj zzfcj, Object obj) {
        zzcvt zzcvt = null;
        return zzb(zzfcl, zzfcj, (zzcvt) null);
    }
}
