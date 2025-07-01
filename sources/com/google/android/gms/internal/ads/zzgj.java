package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzgj implements zzgc {
    private final Context zza;
    private final zzgc zzb;

    public zzgj(Context context) {
        zzgl zzgl = new zzgl();
        this.zza = context.getApplicationContext();
        this.zzb = zzgl;
    }

    public final /* bridge */ /* synthetic */ zzgd zza() {
        return new zzgk(this.zza, ((zzgl) this.zzb).zza());
    }
}
