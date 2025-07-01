package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzewf implements zzevz {
    private final Context zza;
    private final zzges zzb;

    zzewf(Context context, zzges zzges) {
        this.zza = context;
        this.zzb = zzges;
    }

    public final int zza() {
        return 59;
    }

    public final ListenableFuture zzb() {
        if (((Boolean) zzbef.zzb.zze()).booleanValue()) {
            return this.zzb.zzb(new zzewe(this));
        }
        return zzgei.zzh((Object) null);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzewg zzc() throws Exception {
        Context context = this.zza;
        return new zzewg(zzbbx.zzb(context), zzbbx.zza(context));
    }
}
