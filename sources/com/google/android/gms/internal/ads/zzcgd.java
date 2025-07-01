package com.google.android.gms.internal.ads;

import android.webkit.ValueCallback;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzcgd implements Runnable {
    public final /* synthetic */ zzcgj zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ ValueCallback zzc;

    public /* synthetic */ zzcgd(zzcgj zzcgj, String str, ValueCallback valueCallback) {
        this.zza = zzcgj;
        this.zzb = str;
        this.zzc = valueCallback;
    }

    public final void run() {
        this.zza.zzaU(this.zzb, this.zzc);
    }
}
