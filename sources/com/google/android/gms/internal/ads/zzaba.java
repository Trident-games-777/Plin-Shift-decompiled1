package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzaba implements Runnable {
    public final /* synthetic */ zzabf zza;
    public final /* synthetic */ Exception zzb;

    public /* synthetic */ zzaba(zzabf zzabf, Exception exc) {
        this.zza = zzabf;
        this.zzb = exc;
    }

    public final void run() {
        this.zza.zzo(this.zzb);
    }
}
