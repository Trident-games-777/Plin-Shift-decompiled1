package com.google.android.gms.internal.ads;

import android.os.Bundle;
import coil3.disk.DiskLruCache;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzesw implements zzevy {
    public final String zza;
    public final boolean zzb;

    public zzesw(String str, boolean z) {
        this.zza = str;
        this.zzb = z;
    }

    public final /* bridge */ /* synthetic */ void zzj(Object obj) {
        Bundle bundle = (Bundle) obj;
        bundle.putString("gct", this.zza);
        if (this.zzb) {
            bundle.putString("de", DiskLruCache.VERSION);
        }
    }
}
