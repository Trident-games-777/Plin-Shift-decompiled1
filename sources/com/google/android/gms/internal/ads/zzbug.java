package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.client.zzr;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
public final /* synthetic */ class zzbug implements Runnable {
    public final /* synthetic */ zzr zza;
    public final /* synthetic */ String zzb;

    public /* synthetic */ zzbug(zzr zzr, String str) {
        this.zza = zzr;
        this.zzb = str;
    }

    public final void run() {
        this.zza.zza(this.zzb);
    }
}
