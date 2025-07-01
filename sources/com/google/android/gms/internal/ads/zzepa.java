package com.google.android.gms.internal.ads;

import android.content.ContentResolver;
import android.content.Context;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzepa implements zzevz {
    private final Context zza;
    private final zzges zzb;

    zzepa(zzges zzges, Context context) {
        this.zzb = zzges;
        this.zza = context;
    }

    public final int zza() {
        return 61;
    }

    public final ListenableFuture zzb() {
        if (!((Boolean) zzbe.zzc().zza(zzbcn.zzmA)).booleanValue()) {
            return zzgei.zzh(new zzepb((String) null, false));
        }
        ContentResolver contentResolver = this.zza.getContentResolver();
        if (contentResolver == null) {
            return zzgei.zzh(new zzepb((String) null, false));
        }
        return this.zzb.zzb(new zzeoz(contentResolver));
    }
}
