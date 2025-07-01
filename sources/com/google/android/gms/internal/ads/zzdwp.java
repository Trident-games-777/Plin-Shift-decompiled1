package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.ads.nonagon.signalgeneration.zzbd;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzdwp implements zzczj, zzdex {
    private final Context zza;
    private final zzdsm zzb;

    zzdwp(Context context, zzdsm zzdsm) {
        this.zza = context;
        this.zzb = zzdsm;
    }

    private final void zzd(Context context) {
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzeF)).booleanValue()) {
            zzcaj.zza.execute(new zzdwo(this, context));
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzc(Context context) {
        zzv.zzf().zzb(context, this.zzb);
    }

    public final void zzdn(zzbvx zzbvx) {
        zzd(this.zza);
    }

    public final void zzdo(zzfff zzfff) {
    }

    public final void zze(zzbd zzbd) {
        zzd(this.zza);
    }

    public final void zzf(String str) {
    }
}
