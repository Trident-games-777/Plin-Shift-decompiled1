package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.webkit.JsResult;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzcfe implements DialogInterface.OnClickListener {
    final /* synthetic */ JsResult zza;

    zzcfe(JsResult jsResult) {
        this.zza = jsResult;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.zza.confirm();
    }
}
