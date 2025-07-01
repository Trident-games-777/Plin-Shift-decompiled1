package com.google.android.gms.internal.ads;

import android.os.Bundle;
import coil3.disk.DiskLruCache;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzenr implements zzevy {
    private final boolean zza;

    public zzenr(boolean z) {
        this.zza = z;
    }

    public final /* bridge */ /* synthetic */ void zzj(Object obj) {
        String str;
        Bundle bundle = (Bundle) obj;
        if (true != this.zza) {
            str = "0";
        } else {
            str = DiskLruCache.VERSION;
        }
        bundle.putString("adid_p", str);
    }
}
