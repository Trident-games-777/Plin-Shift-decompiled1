package com.google.android.gms.ads.nonagon.signalgeneration;

import android.util.Pair;
import com.google.android.gms.internal.ads.zzdsh;
import com.google.android.gms.internal.ads.zzdsr;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzu implements Runnable {
    public final /* synthetic */ zzdsr zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ Pair[] zzc;

    public /* synthetic */ zzu(zzdsr zzdsr, zzdsh zzdsh, String str, Pair[] pairArr) {
        this.zza = zzdsr;
        this.zzb = str;
        this.zzc = pairArr;
    }

    public final void run() {
        zzv.zze(this.zza, (zzdsh) null, this.zzb, this.zzc);
    }
}
