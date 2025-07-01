package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.util.zzac;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzevw implements zzevz {
    private final zzges zza;
    private final Context zzb;

    zzevw(zzges zzges, Context context) {
        this.zza = zzges;
        this.zzb = context;
    }

    public final int zza() {
        return 37;
    }

    public final ListenableFuture zzb() {
        return this.zza.zzb(new zzevu(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzevy zzc() throws Exception {
        zzbce zzbce = zzbcn.zzfY;
        Bundle zzb2 = zzac.zzb(this.zzb, (String) zzbe.zzc().zza(zzbce));
        if (zzb2.isEmpty()) {
            return null;
        }
        return new zzevv(zzb2);
    }
}
