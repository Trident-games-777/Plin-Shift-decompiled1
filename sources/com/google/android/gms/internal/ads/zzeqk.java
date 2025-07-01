package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzeqk implements zzevz {
    private final zzfbr zza;

    zzeqk(zzfbr zzfbr) {
        this.zza = zzfbr;
    }

    public final int zza() {
        return 15;
    }

    public final ListenableFuture zzb() {
        zzfbr zzfbr = this.zza;
        zzeqj zzeqj = null;
        if (!(zzfbr == null || zzfbr.zza() == null || zzfbr.zza().isEmpty())) {
            zzeqj = new zzeqj(this);
        }
        return zzgei.zzh(zzeqj);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzc(Bundle bundle) {
        bundle.putString("key_schema", this.zza.zza());
    }
}
