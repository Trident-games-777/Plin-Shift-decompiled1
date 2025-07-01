package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import com.google.android.gms.ads.internal.overlay.zzm;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzedv implements DialogInterface.OnCancelListener {
    public final /* synthetic */ zzeea zza;
    public final /* synthetic */ zzm zzb;

    public /* synthetic */ zzedv(zzeea zzeea, zzm zzm) {
        this.zza = zzeea;
        this.zzb = zzm;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.zza.zzm(this.zzb, dialogInterface);
    }
}
