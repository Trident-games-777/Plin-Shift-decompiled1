package com.google.android.gms.internal.ads;

import android.content.DialogInterface;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzbsg implements DialogInterface.OnClickListener {
    final /* synthetic */ zzbsh zza;

    zzbsg(zzbsh zzbsh) {
        this.zza = zzbsh;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.zza.zzh("User canceled the download.");
    }
}
