package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzefp implements zzdgv {
    public final /* synthetic */ zzefe zza;

    public /* synthetic */ zzefp(zzefe zzefe) {
        this.zza = zzefe;
    }

    public final void zza(boolean z, Context context, zzcwz zzcwz) {
        zzefe zzefe = this.zza;
        try {
            ((zzfgm) zzefe.zzb).zzv(z);
            ((zzfgm) zzefe.zzb).zzw(context);
        } catch (zzffv e) {
            throw new zzdgu(e.getCause());
        }
    }
}
