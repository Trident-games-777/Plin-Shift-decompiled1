package com.google.android.gms.internal.ads;

import android.content.Context;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzftn {
    private static zzftn zzb;
    final zzftj zza;

    private zzftn(Context context) {
        this.zza = zzftj.zzb(context);
        zzfti.zza(context);
    }

    public static final zzftn zza(Context context) {
        zzftn zzftn;
        synchronized (zzftn.class) {
            if (zzb == null) {
                zzb = new zzftn(context);
            }
            zzftn = zzb;
        }
        return zzftn;
    }

    public final void zzb(zzfth zzfth) throws IOException {
        synchronized (zzftn.class) {
            this.zza.zze("vendor_scoped_gpid_v2_id");
            this.zza.zze("vendor_scoped_gpid_v2_creation_time");
        }
    }
}
