package com.google.android.gms.internal.ads;

import java.util.HashSet;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzax {
    private static final HashSet zza = new HashSet();
    private static String zzb = "media3.common";

    public static synchronized String zza() {
        String str;
        synchronized (zzax.class) {
            str = zzb;
        }
        return str;
    }

    public static synchronized void zzb(String str) {
        synchronized (zzax.class) {
            if (zza.add(str)) {
                String str2 = zzb;
                zzb = str2 + ", " + str;
            }
        }
    }
}
