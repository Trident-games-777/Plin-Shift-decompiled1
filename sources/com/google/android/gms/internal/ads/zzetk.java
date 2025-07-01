package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzv;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzetk implements zzevz {
    private final Context zza;
    private final Intent zzb;

    zzetk(Context context, Intent intent) {
        this.zza = context;
        this.zzb = intent;
    }

    public final int zza() {
        return 60;
    }

    public final ListenableFuture zzb() {
        zze.zza("HsdpMigrationSignal.produce");
        if (!((Boolean) zzbe.zzc().zza(zzbcn.zzmx)).booleanValue()) {
            return zzgei.zzh(new zzetl((Boolean) null));
        }
        boolean z = false;
        try {
            if (this.zzb.resolveActivity(this.zza.getPackageManager()) != null) {
                z = true;
            }
        } catch (Exception e) {
            zzv.zzp().zzw(e, "HsdpMigrationSignal.isHsdpMigrationSupported");
        }
        return zzgei.zzh(new zzetl(Boolean.valueOf(z)));
    }
}
