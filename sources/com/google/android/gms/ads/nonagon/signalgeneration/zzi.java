package com.google.android.gms.ads.nonagon.signalgeneration;

import com.google.android.gms.ads.AdRequest;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzi implements Callable {
    public final /* synthetic */ zzj zza;
    public final /* synthetic */ AdRequest zzb;
    public final /* synthetic */ zzk zzc;

    public /* synthetic */ zzi(zzj zzj, AdRequest adRequest, zzk zzk) {
        this.zza = zzj;
        this.zzb = adRequest;
        this.zzc = zzk;
    }

    public final Object call() {
        return this.zza.zza(this.zzb, this.zzc);
    }
}
