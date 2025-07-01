package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzcjp implements zzdtw {
    /* access modifiers changed from: private */
    public final Context zza;
    private final zzbkq zzb;
    private final zzciy zzc;
    private final zzcjp zzd = this;
    private final zzhgg zze;
    private final zzhgg zzf;
    private final zzhgg zzg;
    private final zzhgg zzh;

    /* synthetic */ zzcjp(zzciy zzciy, Context context, zzbkq zzbkq, zzckd zzckd) {
        this.zzc = zzciy;
        this.zza = context;
        this.zzb = zzbkq;
        zzhfx zza2 = zzhfy.zza(this);
        this.zze = zza2;
        zzhfx zza3 = zzhfy.zza(zzbkq);
        this.zzf = zza3;
        zzdts zzdts = new zzdts(zza3);
        this.zzg = zzdts;
        this.zzh = zzhfw.zzc(new zzdtu(zza2, zzdts));
    }

    public final zzdtn zzb() {
        return new zzcjm(this.zzc, this.zzd, (zzckd) null);
    }

    public final zzdtt zzd() {
        return (zzdtt) this.zzh.zzb();
    }
}
