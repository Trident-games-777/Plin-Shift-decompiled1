package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zze;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzfjx implements zzddq, zzcxc, zzddu {
    private final zzfkl zza;
    private final zzfka zzb;

    zzfjx(Context context, zzfkl zzfkl) {
        this.zza = zzfkl;
        this.zzb = zzfjz.zza(context, 13);
    }

    public final void zza() {
    }

    public final void zzb() {
        if (((Boolean) zzbeg.zzd.zze()).booleanValue()) {
            zzfkl zzfkl = this.zza;
            zzfka zzfka = this.zzb;
            zzfka.zzg(true);
            zzfkl.zza(zzfka);
        }
    }

    public final void zzk() {
    }

    public final void zzl() {
        if (((Boolean) zzbeg.zzd.zze()).booleanValue()) {
            this.zzb.zzi();
        }
    }

    public final void zzq(zze zze) {
        if (((Boolean) zzbeg.zzd.zze()).booleanValue()) {
            zzfkl zzfkl = this.zza;
            zzfka zzfka = this.zzb;
            zzfka.zzc(zze.zza().toString());
            zzfka.zzg(false);
            zzfkl.zza(zzfka);
        }
    }
}
