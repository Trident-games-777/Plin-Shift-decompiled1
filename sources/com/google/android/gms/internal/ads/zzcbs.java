package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzcbs implements Runnable {
    final /* synthetic */ boolean zza;
    final /* synthetic */ zzcbt zzb;

    zzcbs(zzcbt zzcbt, boolean z) {
        this.zza = z;
        this.zzb = zzcbt;
    }

    public final void run() {
        this.zzb.zzK("windowVisibilityChanged", "isVisible", String.valueOf(this.zza));
    }
}
