package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzs;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzcjh implements zzfbh {
    private final zzciy zza;
    private Context zzb;
    private String zzc;
    private zzs zzd;

    /* synthetic */ zzcjh(zzciy zzciy, zzckd zzckd) {
        this.zza = zzciy;
    }

    public final zzfbi zzd() {
        zzhgf.zzc(this.zzb, Context.class);
        zzhgf.zzc(this.zzc, String.class);
        zzhgf.zzc(this.zzd, zzs.class);
        return new zzcji(this.zza, this.zzb, this.zzc, this.zzd, (zzckd) null);
    }

    public final /* bridge */ /* synthetic */ zzfbh zza(zzs zzs) {
        zzs.getClass();
        zzs zzs2 = zzs;
        this.zzd = zzs;
        return this;
    }

    public final /* bridge */ /* synthetic */ zzfbh zzb(String str) {
        str.getClass();
        String str2 = str;
        this.zzc = str;
        return this;
    }

    public final /* bridge */ /* synthetic */ zzfbh zzc(Context context) {
        context.getClass();
        Context context2 = context;
        this.zzb = context;
        return this;
    }
}
