package com.google.android.gms.ads.nonagon.signalgeneration;

import com.google.android.gms.internal.ads.zzdsh;
import java.util.ArrayDeque;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzn implements Runnable {
    public final /* synthetic */ zzq zza;
    public final /* synthetic */ zzdsh zzb;
    public final /* synthetic */ ArrayDeque zzc;
    public final /* synthetic */ ArrayDeque zzd;

    public /* synthetic */ zzn(zzq zzq, zzdsh zzdsh, ArrayDeque arrayDeque, ArrayDeque arrayDeque2) {
        this.zza = zzq;
        this.zzb = zzdsh;
        this.zzc = arrayDeque;
        this.zzd = arrayDeque2;
    }

    public final void run() {
        this.zza.zze(this.zzb, this.zzc, this.zzd);
    }
}
