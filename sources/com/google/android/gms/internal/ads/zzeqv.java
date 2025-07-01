package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzeqv implements zzevz {
    private final zzges zza;
    private final zzdqi zzb;
    private final String zzc;
    private final zzffo zzd;

    public zzeqv(zzges zzges, zzdqi zzdqi, zzffo zzffo, String str) {
        this.zza = zzges;
        this.zzb = zzdqi;
        this.zzd = zzffo;
        this.zzc = str;
    }

    public final int zza() {
        return 17;
    }

    public final ListenableFuture zzb() {
        return this.zza.zzb(new zzequ(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzeqw zzc() throws Exception {
        zzdqi zzdqi = this.zzb;
        return new zzeqw(zzdqi.zzb(this.zzd.zzf, this.zzc), zzdqi.zza());
    }
}
