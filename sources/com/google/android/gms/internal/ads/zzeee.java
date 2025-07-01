package com.google.android.gms.internal.ads;

import android.view.View;
import com.google.android.gms.ads.internal.client.zzbe;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzeee implements Runnable {
    public final /* synthetic */ zzfmw zza;
    public final /* synthetic */ View zzb;

    public /* synthetic */ zzeee(zzfmw zzfmw, View view) {
        this.zza = zzfmw;
        this.zzb = view;
    }

    public final void run() {
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzfb)).booleanValue() && zzfmu.zzb()) {
            this.zza.zzb(this.zzb, zzfnd.NOT_VISIBLE, "Ad overlay");
        }
    }
}
