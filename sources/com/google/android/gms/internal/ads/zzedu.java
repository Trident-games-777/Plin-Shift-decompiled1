package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import com.google.android.gms.ads.internal.overlay.zzm;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzedu implements DialogInterface.OnClickListener {
    public final /* synthetic */ zzeea zza;
    public final /* synthetic */ zzm zzb;

    public /* synthetic */ zzedu(zzeea zzeea, zzm zzm) {
        this.zza = zzeea;
        this.zzb = zzm;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.zza.zzl(this.zzb, dialogInterface, i);
    }
}
