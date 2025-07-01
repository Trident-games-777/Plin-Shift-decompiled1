package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzcqr implements Runnable {
    public final /* synthetic */ zzcfk zza;

    public /* synthetic */ zzcqr(zzcfk zzcfk) {
        this.zza = zzcfk;
    }

    public final void run() {
        this.zza.onPause();
    }
}
