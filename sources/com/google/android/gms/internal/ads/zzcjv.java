package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzcjv implements zzfem {
    private final zzciy zza;
    private Context zzb;
    private String zzc;

    /* synthetic */ zzcjv(zzciy zzciy, zzckd zzckd) {
        this.zza = zzciy;
    }

    public final /* synthetic */ zzfem zza(String str) {
        this.zzc = str;
        return this;
    }

    public final zzfen zzc() {
        zzhgf.zzc(this.zzb, Context.class);
        return new zzcjw(this.zza, this.zzb, this.zzc, (zzckd) null);
    }

    public final /* bridge */ /* synthetic */ zzfem zzb(Context context) {
        context.getClass();
        Context context2 = context;
        this.zzb = context;
        return this;
    }
}
