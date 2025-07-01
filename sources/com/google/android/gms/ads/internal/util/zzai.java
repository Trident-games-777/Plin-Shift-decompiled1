package com.google.android.gms.ads.internal.util;

import android.content.DialogInterface;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzai implements DialogInterface.OnClickListener {
    public final /* synthetic */ zzat zza;
    public final /* synthetic */ String zzb;

    public /* synthetic */ zzai(zzat zzat, String str) {
        this.zza = zzat;
        this.zzb = str;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.zza.zzi(this.zzb, dialogInterface, i);
    }
}
