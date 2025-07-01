package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzfmv {
    private boolean zza;

    /* access modifiers changed from: package-private */
    public final void zza(Context context) {
        zzfor.zzc(context, "Application Context cannot be null");
        if (!this.zza) {
            this.zza = true;
            zzfnz.zzb().zzd(context);
            zzfnq.zza().zzd(context);
            zzfom.zzb(context);
            zzfon.zzd(context);
            zzfoq.zza(context);
            zzfnw.zzb().zzc(context);
            zzfnp.zza().zzd(context);
            zzfob.zza().zze(context);
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean zzb() {
        return this.zza;
    }
}
