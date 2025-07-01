package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.DialogInterface;
import com.google.android.gms.ads.internal.overlay.zzm;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzedt implements DialogInterface.OnClickListener {
    public final /* synthetic */ zzeea zza;
    public final /* synthetic */ Activity zzb;
    public final /* synthetic */ zzm zzc;

    public /* synthetic */ zzedt(zzeea zzeea, Activity activity, zzm zzm) {
        this.zza = zzeea;
        this.zzb = activity;
        this.zzc = zzm;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.zza.zzk(this.zzb, this.zzc, dialogInterface, i);
    }
}
