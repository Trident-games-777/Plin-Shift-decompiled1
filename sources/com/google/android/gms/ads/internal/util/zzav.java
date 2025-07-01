package com.google.android.gms.ads.internal.util;

import android.content.DialogInterface;
import android.net.Uri;
import com.google.android.gms.ads.internal.zzv;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzav implements DialogInterface.OnClickListener {
    final /* synthetic */ zzaw zza;

    zzav(zzaw zzaw) {
        this.zza = zzaw;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        zzv.zzq();
        zzs.zzU(this.zza.zza, Uri.parse("https://support.google.com/dfp_premium/answer/7160685#push"));
    }
}
