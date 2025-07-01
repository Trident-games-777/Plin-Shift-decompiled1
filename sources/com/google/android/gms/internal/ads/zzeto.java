package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzv;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzeto implements zzevz {
    private final zzges zza;
    private final zzdvk zzb;

    zzeto(zzges zzges, zzdvk zzdvk) {
        this.zza = zzges;
        this.zzb = zzdvk;
    }

    public final int zza() {
        return 23;
    }

    public final ListenableFuture zzb() {
        return this.zza.zzb(new zzetn(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzetp zzc() throws Exception {
        zzdvk zzdvk = this.zzb;
        String zzc = zzdvk.zzc();
        boolean zzr = zzdvk.zzr();
        boolean zzl = zzv.zzt().zzl();
        zzdvk zzdvk2 = this.zzb;
        return new zzetp(zzc, zzr, zzl, zzdvk2.zzp(), zzdvk2.zzs());
    }
}
