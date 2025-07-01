package com.google.android.gms.ads.internal.client;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
public final /* synthetic */ class zzeo implements Runnable {
    public final /* synthetic */ zzex zza;
    public final /* synthetic */ Context zzb;

    public /* synthetic */ zzeo(zzex zzex, Context context, String str) {
        this.zza = zzex;
        this.zzb = context;
    }

    public final void run() {
        this.zza.zzp(this.zzb, (String) null);
    }
}
