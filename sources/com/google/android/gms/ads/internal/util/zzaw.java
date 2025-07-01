package com.google.android.gms.ads.internal.util;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import com.google.android.gms.ads.internal.zzv;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzaw implements Runnable {
    final /* synthetic */ Context zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ boolean zzc;
    final /* synthetic */ boolean zzd;

    zzaw(zzax zzax, Context context, String str, boolean z, boolean z2) {
        this.zza = context;
        this.zzb = str;
        this.zzc = z;
        this.zzd = z2;
    }

    public final void run() {
        zzv.zzq();
        AlertDialog.Builder zzK = zzs.zzK(this.zza);
        zzK.setMessage(this.zzb);
        if (this.zzc) {
            zzK.setTitle("Error");
        } else {
            zzK.setTitle("Info");
        }
        if (this.zzd) {
            zzK.setNeutralButton("Dismiss", (DialogInterface.OnClickListener) null);
        } else {
            zzK.setPositiveButton("Learn More", new zzav(this));
            zzK.setNegativeButton("Dismiss", (DialogInterface.OnClickListener) null);
        }
        zzK.create().show();
    }
}
