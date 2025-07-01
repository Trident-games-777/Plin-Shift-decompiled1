package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzfbl implements zzfck {
    private zzcvt zza;
    private final Executor zzb = zzgey.zzb();

    public final zzcvt zza() {
        return this.zza;
    }

    public final ListenableFuture zzb(zzfcl zzfcl, zzfcj zzfcj, zzcvt zzcvt) {
        zzcvs zza2 = zzfcj.zza(zzfcl.zzb);
        zza2.zzb(new zzfco(true));
        zzcvt zzcvt2 = (zzcvt) zza2.zzh();
        this.zza = zzcvt2;
        zzcsy zzb2 = zzcvt2.zzb();
        zzfhl zzfhl = new zzfhl();
        return (zzgdz) zzgei.zzm((zzgdz) zzgei.zzn(zzgdz.zzu(zzb2.zzj()), new zzfbj(this, zzfhl, zzb2), this.zzb), new zzfbk(zzfhl), this.zzb);
    }

    public final /* bridge */ /* synthetic */ ListenableFuture zzc(zzfcl zzfcl, zzfcj zzfcj, Object obj) {
        zzcvt zzcvt = null;
        return zzb(zzfcl, zzfcj, (zzcvt) null);
    }

    public final /* synthetic */ Object zzd() {
        return this.zza;
    }
}
