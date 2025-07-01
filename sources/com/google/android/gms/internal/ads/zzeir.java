package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.common.util.concurrent.ListenableFuture;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzeir extends zzeik {
    private final zzchk zza;
    private final zzcvu zzb;
    private final zzdcf zzc;
    private final zzeiv zzd;
    @Nullable
    private final zzffg zze;
    private final zzefg zzf;

    public zzeir(zzchk zzchk, zzcvu zzcvu, zzdcf zzdcf, @Nullable zzffg zzffg, zzeiv zzeiv, zzefg zzefg) {
        this.zza = zzchk;
        this.zzb = zzcvu;
        this.zzc = zzdcf;
        this.zze = zzffg;
        this.zzd = zzeiv;
        this.zzf = zzefg;
    }

    /* access modifiers changed from: protected */
    public final ListenableFuture zzc(zzffo zzffo, Bundle bundle, zzfet zzfet, zzfff zzfff) {
        zzffg zzffg;
        zzcvu zzcvu = this.zzb;
        zzcvu.zzi(zzffo);
        zzcvu.zzf(bundle);
        zzcvu.zzg(new zzcvo(zzfff, zzfet, this.zzd));
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzdF)).booleanValue() && (zzffg = this.zze) != null) {
            this.zzb.zzh(zzffg);
        }
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzdG)).booleanValue()) {
            this.zzb.zzd(this.zzf);
        }
        zzchk zzchk = this.zza;
        zzcvu zzcvu2 = this.zzb;
        zzdov zzi = zzchk.zzi();
        zzi.zzd(zzcvu2.zzj());
        zzi.zzc(this.zzc);
        zzcsy zzb2 = zzi.zze().zzb();
        return zzb2.zzi(zzb2.zzj());
    }
}
