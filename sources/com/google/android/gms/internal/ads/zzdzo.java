package com.google.android.gms.internal.ads;

import android.os.Binder;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzv;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutionException;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzdzo {
    private final zzges zza;
    private final zzges zzb;
    private final zzeaj zzc;
    private final zzhfr zzd;

    zzdzo(zzges zzges, zzges zzges2, zzeaj zzeaj, zzhfr zzhfr) {
        this.zza = zzges;
        this.zzb = zzges2;
        this.zzc = zzeaj;
        this.zzd = zzhfr;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zza(zzbvb zzbvb) throws Exception {
        return this.zzc.zza(zzbvb, ((Long) zzbe.zzc().zza(zzbcn.zzlk)).longValue());
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zzb(zzbvb zzbvb, int i, zzdyw zzdyw) throws Exception {
        return ((zzebq) this.zzd.zzb()).zzb(zzbvb, i);
    }

    public final ListenableFuture zzc(zzbvb zzbvb) {
        ListenableFuture listenableFuture;
        String str = zzbvb.zzf;
        zzv.zzq();
        if (zzs.zzC(str)) {
            listenableFuture = zzgei.zzg(new zzdyw(1, "Ads service proxy force local"));
        } else {
            listenableFuture = zzgei.zzf(zzgei.zzk(new zzdzl(this, zzbvb), this.zza), ExecutionException.class, new zzdzm(), this.zzb);
        }
        return zzgei.zzf(listenableFuture, zzdyw.class, new zzdzn(this, zzbvb, Binder.getCallingUid()), this.zzb);
    }
}
