package com.google.android.gms.internal.ads;

import android.app.UiModeManager;
import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzfom {
    private static UiModeManager zza;

    public static zzfnc zza() {
        UiModeManager uiModeManager = zza;
        if (uiModeManager == null) {
            return zzfnc.OTHER;
        }
        int currentModeType = uiModeManager.getCurrentModeType();
        if (currentModeType == 1) {
            return zzfnc.MOBILE;
        }
        if (currentModeType != 4) {
            return zzfnc.OTHER;
        }
        return zzfnc.CTV;
    }

    public static void zzb(Context context) {
        if (context != null) {
            zza = (UiModeManager) context.getSystemService("uimode");
        }
    }
}
