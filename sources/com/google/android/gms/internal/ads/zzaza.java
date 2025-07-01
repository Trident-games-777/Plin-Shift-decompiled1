package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.admanager.AppEventListener;
import com.google.android.gms.ads.internal.client.zzcl;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
public final class zzaza extends zzcl {
    private final AppEventListener zza;

    public zzaza(AppEventListener appEventListener) {
        this.zza = appEventListener;
    }

    public final AppEventListener zzb() {
        return this.zza;
    }

    public final void zzc(String str, String str2) {
        this.zza.onAppEvent(str, str2);
    }
}
