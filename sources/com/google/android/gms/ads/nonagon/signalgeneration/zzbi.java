package com.google.android.gms.ads.nonagon.signalgeneration;

import android.webkit.ValueCallback;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzbi implements Runnable {
    public final /* synthetic */ zzbk zza;
    public final /* synthetic */ String zzb;

    public /* synthetic */ zzbi(zzbk zzbk, String str) {
        this.zza = zzbk;
        this.zzb = str;
    }

    public final void run() {
        this.zza.zzb.zzb.evaluateJavascript(this.zzb, (ValueCallback) null);
    }
}
