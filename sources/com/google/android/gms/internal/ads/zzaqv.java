package com.google.android.gms.internal.ads;

import android.content.Context;
import java.io.File;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzaqv implements zzaqk {
    final /* synthetic */ Context zza;
    private File zzb = null;

    zzaqv(Context context) {
        this.zza = context;
    }

    public final File zza() {
        if (this.zzb == null) {
            this.zzb = new File(this.zza.getCacheDir(), "volley");
        }
        return this.zzb;
    }
}
