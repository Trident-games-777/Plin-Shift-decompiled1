package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzewa implements Runnable {
    public final /* synthetic */ zzewc zza;
    public final /* synthetic */ long zzb;
    public final /* synthetic */ zzevz zzc;
    public final /* synthetic */ Bundle zzd;

    public /* synthetic */ zzewa(zzewc zzewc, long j, zzevz zzevz, Bundle bundle) {
        this.zza = zzewc;
        this.zzb = j;
        this.zzc = zzevz;
        this.zzd = bundle;
    }

    public final void run() {
        this.zza.zzb(this.zzb, this.zzc, this.zzd);
    }
}
