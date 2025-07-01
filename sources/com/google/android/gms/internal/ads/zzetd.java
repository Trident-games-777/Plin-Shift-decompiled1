package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.nonagon.signalgeneration.zzv;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzetd implements zzevz {
    private final zzges zza;
    private final zzffo zzb;

    zzetd(zzges zzges, zzffo zzffo) {
        this.zza = zzges;
        this.zzb = zzffo;
    }

    public final int zza() {
        return 21;
    }

    public final ListenableFuture zzb() {
        return this.zza.zzb(new zzetc(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzete zzc() throws Exception {
        return new zzete("requester_type_2".equals(zzv.zzc(this.zzb.zzd)));
    }
}
