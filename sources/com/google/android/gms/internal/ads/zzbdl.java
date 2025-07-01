package com.google.android.gms.internal.ads;

import android.os.Bundle;
import androidx.browser.customtabs.CustomTabsCallback;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzbdl extends CustomTabsCallback {
    final /* synthetic */ zzbdm zza;

    zzbdl(zzbdm zzbdm) {
        this.zza = zzbdm;
    }

    public final void onNavigationEvent(int i, Bundle bundle) {
        this.zza.zze(i);
    }
}
