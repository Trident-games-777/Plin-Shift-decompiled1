package com.google.android.gms.internal.ads;

import android.telephony.TelephonyCallback;
import android.telephony.TelephonyDisplayInfo;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzdy extends TelephonyCallback implements TelephonyCallback.DisplayInfoListener {
    private final zzeb zza;

    public zzdy(zzeb zzeb) {
        this.zza = zzeb;
    }

    public final void onDisplayInfoChanged(TelephonyDisplayInfo telephonyDisplayInfo) {
        int overrideNetworkType = telephonyDisplayInfo.getOverrideNetworkType();
        int i = 5;
        boolean z = overrideNetworkType == 3 || overrideNetworkType == 4 || overrideNetworkType == 5;
        zzeb zzeb = this.zza;
        if (true == z) {
            i = 10;
        }
        zzeb.zzc(zzeb, i);
    }
}
