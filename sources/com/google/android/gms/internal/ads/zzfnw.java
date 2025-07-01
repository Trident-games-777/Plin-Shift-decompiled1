package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzfnw {
    private static final zzfnw zza = new zzfnw();
    private Context zzb;

    private zzfnw() {
    }

    public static zzfnw zzb() {
        return zza;
    }

    public final Context zza() {
        return this.zzb;
    }

    public final void zzc(Context context) {
        this.zzb = context != null ? context.getApplicationContext() : null;
    }
}
