package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzapf implements Runnable {
    private final zzapp zza;
    private final zzapv zzb;
    private final Runnable zzc;

    public zzapf(zzapp zzapp, zzapv zzapv, Runnable runnable) {
        this.zza = zzapp;
        this.zzb = zzapv;
        this.zzc = runnable;
    }

    public final void run() {
        this.zza.zzw();
        zzapv zzapv = this.zzb;
        if (zzapv.zzc()) {
            this.zza.zzo(zzapv.zza);
        } else {
            this.zza.zzn(zzapv.zzc);
        }
        if (this.zzb.zzd) {
            this.zza.zzm("intermediate-response");
        } else {
            this.zza.zzp("done");
        }
        Runnable runnable = this.zzc;
        if (runnable != null) {
            runnable.run();
        }
    }
}
