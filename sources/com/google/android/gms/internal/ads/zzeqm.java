package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzeqm implements Runnable {
    public final /* synthetic */ zzeqp zza;

    public /* synthetic */ zzeqm(zzeqp zzeqp) {
        this.zza = zzeqp;
    }

    public final void run() {
        this.zza.zzd.execute(new zzeqn(this.zza));
    }
}
