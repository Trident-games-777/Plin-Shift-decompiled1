package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzapa implements Runnable {
    final /* synthetic */ zzapp zza;
    final /* synthetic */ zzapb zzb;

    zzapa(zzapb zzapb, zzapp zzapp) {
        this.zza = zzapp;
        this.zzb = zzapb;
    }

    public final void run() {
        try {
            this.zzb.zzc.put(this.zza);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
    }
}
