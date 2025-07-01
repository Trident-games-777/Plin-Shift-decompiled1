package com.google.android.gms.internal.ads;

import android.content.ComponentName;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.browser.customtabs.CustomTabsServiceConnection;
import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzhgr extends CustomTabsServiceConnection {
    private final WeakReference zza;

    public zzhgr(zzbdo zzbdo) {
        this.zza = new WeakReference(zzbdo);
    }

    public final void onCustomTabsServiceConnected(ComponentName componentName, CustomTabsClient customTabsClient) {
        zzbdo zzbdo = (zzbdo) this.zza.get();
        if (zzbdo != null) {
            zzbdo.zzc(customTabsClient);
        }
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        zzbdo zzbdo = (zzbdo) this.zza.get();
        if (zzbdo != null) {
            zzbdo.zzd();
        }
    }
}
