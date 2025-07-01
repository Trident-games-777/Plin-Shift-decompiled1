package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzepe implements zzevz {
    private final zzges zza;
    private final zzffo zzb;
    private final zzcad zzc;

    public zzepe(zzges zzges, zzffo zzffo, zzcad zzcad) {
        this.zza = zzges;
        this.zzb = zzffo;
        this.zzc = zzcad;
    }

    public final int zza() {
        return 9;
    }

    public final ListenableFuture zzb() {
        return this.zza.zzb(new zzepd(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzepf zzc() throws Exception {
        return new zzepf(this.zzb.zzj, this.zzc.zzm());
    }
}
