package com.google.android.gms.internal.ads;

import androidx.collection.ArrayMap;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzdkv implements Runnable {
    public final /* synthetic */ zzcfk zza;

    public /* synthetic */ zzdkv(zzcfk zzcfk) {
        this.zza = zzcfk;
    }

    public final void run() {
        this.zza.zzd("onSdkImpression", new ArrayMap());
    }
}
