package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzv;

@Deprecated
/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzbcu {
    public static boolean zza(zzbdc zzbdc, zzbcz zzbcz, String... strArr) {
        if (zzbcz == null) {
            return false;
        }
        zzbdc.zze(zzbcz, zzv.zzC().elapsedRealtime(), strArr);
        return true;
    }
}
