package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzn;
import com.google.android.gms.ads.internal.zzv;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzegp implements zzdgv {
    public final /* synthetic */ zzcao zza;

    public /* synthetic */ zzegp(zzcao zzcao) {
        this.zza = zzcao;
    }

    public final void zza(boolean z, Context context, zzcwz zzcwz) {
        zzcao zzcao = this.zza;
        try {
            zzv.zzj();
            zzn.zza(context, (AdOverlayInfoParcel) zzcao.get(), true);
        } catch (Exception unused) {
        }
    }
}
