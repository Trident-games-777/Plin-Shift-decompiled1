package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.zzm;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzeka implements zzdgv {
    public final /* synthetic */ zzefe zza;

    public /* synthetic */ zzeka(zzefe zzefe) {
        this.zza = zzefe;
    }

    public final void zza(boolean z, Context context, zzcwz zzcwz) {
        zzefe zzefe = this.zza;
        try {
            ((zzfgm) zzefe.zzb).zzv(z);
            ((zzfgm) zzefe.zzb).zzA();
        } catch (zzffv e) {
            zzm.zzk("Cannot show rewarded video.", e);
            throw new zzdgu(e.getCause());
        }
    }
}
