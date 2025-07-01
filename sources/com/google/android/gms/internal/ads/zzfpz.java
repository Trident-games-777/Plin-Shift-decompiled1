package com.google.android.gms.internal.ads;

import android.content.Context;
import coil3.disk.DiskLruCache;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzfpz {
    public static zzfri zza(Context context, int i, int i2, String str, String str2, String str3, zzfpp zzfpp) {
        return new zzfpy(context, 1, i2, str, str2, DiskLruCache.VERSION, zzfpp).zza(50000);
    }
}
