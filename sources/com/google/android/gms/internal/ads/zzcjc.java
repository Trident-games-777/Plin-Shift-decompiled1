package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzcjc implements zzezt {
    private final zzciy zza;
    private Context zzb;
    private String zzc;

    /* synthetic */ zzcjc(zzciy zzciy, zzckd zzckd) {
        this.zza = zzciy;
    }

    public final zzezu zzc() {
        zzhgf.zzc(this.zzb, Context.class);
        zzhgf.zzc(this.zzc, String.class);
        return new zzcjd(this.zza, this.zzb, this.zzc, (zzckd) null);
    }

    public final /* bridge */ /* synthetic */ zzezt zza(String str) {
        str.getClass();
        String str2 = str;
        this.zzc = str;
        return this;
    }

    public final /* bridge */ /* synthetic */ zzezt zzb(Context context) {
        context.getClass();
        Context context2 = context;
        this.zzb = context;
        return this;
    }
}
