package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzapn implements Runnable {
    final /* synthetic */ String zza;
    final /* synthetic */ long zzb;
    final /* synthetic */ zzapp zzc;

    zzapn(zzapp zzapp, String str, long j) {
        this.zza = str;
        this.zzb = j;
        this.zzc = zzapp;
    }

    public final void run() {
        this.zzc.zza.zza(this.zza, this.zzb);
        zzapp zzapp = this.zzc;
        zzapp.zza.zzb(zzapp.toString());
    }
}
