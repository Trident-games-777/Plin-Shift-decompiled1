package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzcbr implements Runnable {
    final /* synthetic */ zzcbt zza;

    zzcbr(zzcbt zzcbt) {
        this.zza = zzcbt;
    }

    public final void run() {
        this.zza.zzK("surfaceDestroyed", new String[0]);
    }
}
