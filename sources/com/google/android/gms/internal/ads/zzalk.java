package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzalk {
    public static zzall zza(zzall zzall, String[] strArr, Map map) {
        int length;
        int i = 0;
        if (zzall == null) {
            if (strArr == null) {
                return null;
            }
            int length2 = strArr.length;
            if (length2 == 1) {
                return (zzall) map.get(strArr[0]);
            }
            if (length2 > 1) {
                zzall zzall2 = new zzall();
                while (i < length2) {
                    zzall2.zzl((zzall) map.get(strArr[i]));
                    i++;
                }
                return zzall2;
            }
        } else if (strArr != null && strArr.length == 1) {
            zzall.zzl((zzall) map.get(strArr[0]));
            return zzall;
        } else if (strArr != null && (length = strArr.length) > 1) {
            while (i < length) {
                zzall.zzl((zzall) map.get(strArr[i]));
                i++;
            }
        }
        return zzall;
    }
}
