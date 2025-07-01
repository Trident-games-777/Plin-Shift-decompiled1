package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzv;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutionException;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzdzu {
    private final zzges zza;
    private final zzges zzb;
    private final zzeam zzc;

    zzdzu(zzges zzges, zzges zzges2, zzeam zzeam) {
        this.zza = zzges;
        this.zzb = zzges2;
        this.zzc = zzeam;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zza(zzbuv zzbuv) throws Exception {
        return this.zzc.zza(zzbuv, ((Long) zzbe.zzc().zza(zzbcn.zzlj)).longValue());
    }

    public final ListenableFuture zzb(zzbuv zzbuv) {
        ListenableFuture listenableFuture;
        String str = zzbuv.zzb;
        zzv.zzq();
        if (zzs.zzC(str)) {
            listenableFuture = zzgei.zzg(new zzdyw(1, "Ads signal service force local"));
        } else {
            listenableFuture = zzgei.zzf(zzgei.zzk(new zzdzq(this, zzbuv), this.zza), ExecutionException.class, new zzdzr(), this.zzb);
        }
        return (zzgdz) zzgei.zzn((zzgdz) zzgei.zzf(zzgdz.zzu(listenableFuture), zzdyw.class, new zzdzs(), this.zzb), new zzdzt(), this.zzb);
    }
}
