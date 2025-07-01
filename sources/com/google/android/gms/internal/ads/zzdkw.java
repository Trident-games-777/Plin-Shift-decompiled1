package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.zzv;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzdkw implements zzgee {
    final /* synthetic */ zzdkx zza;

    zzdkw(zzdkx zzdkx) {
        this.zza = zzdkx;
    }

    public final void zza(Throwable th) {
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzfl)).booleanValue()) {
            zzv.zzp().zzw(th, "omid native display exp");
        }
    }

    /* renamed from: zzc */
    public final void zzb(List list) {
        try {
            zzcfk zzcfk = (zzcfk) list.get(0);
            if (zzcfk != null) {
                this.zza.zzb(zzcfk);
            }
        } catch (ClassCastException | IndexOutOfBoundsException e) {
            if (((Boolean) zzbe.zzc().zza(zzbcn.zzfl)).booleanValue()) {
                zzv.zzp().zzw(e, "omid native display exp");
            }
        }
    }
}
