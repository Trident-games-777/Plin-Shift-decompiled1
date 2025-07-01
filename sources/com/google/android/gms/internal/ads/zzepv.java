package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzepv implements zzevz {
    private final zzges zza;
    private final VersionInfoParcel zzb;

    zzepv(VersionInfoParcel versionInfoParcel, zzges zzges) {
        this.zzb = versionInfoParcel;
        this.zza = zzges;
    }

    public final int zza() {
        return 54;
    }

    public final ListenableFuture zzb() {
        return this.zza.zzb(new zzepu(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzepw zzc() throws Exception {
        return zzepw.zzb(this.zzb);
    }
}
