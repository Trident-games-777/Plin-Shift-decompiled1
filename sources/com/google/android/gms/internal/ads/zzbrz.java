package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.content.Intent;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzv;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzbrz implements DialogInterface.OnClickListener {
    final /* synthetic */ zzbsb zza;

    zzbrz(zzbsb zzbsb) {
        this.zza = zzbsb;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        zzbsb zzbsb = this.zza;
        Intent zzb = zzbsb.zzb();
        zzv.zzq();
        zzs.zzT(zzbsb.zzb, zzb);
    }
}
