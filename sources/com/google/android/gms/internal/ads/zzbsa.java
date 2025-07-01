package com.google.android.gms.internal.ads;

import android.content.DialogInterface;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzbsa implements DialogInterface.OnClickListener {
    final /* synthetic */ zzbsb zza;

    zzbsa(zzbsb zzbsb) {
        this.zza = zzbsb;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.zza.zzh("Operation denied by user.");
    }
}
