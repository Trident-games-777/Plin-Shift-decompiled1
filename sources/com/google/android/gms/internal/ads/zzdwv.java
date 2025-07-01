package com.google.android.gms.internal.ads;

import android.os.Binder;
import android.os.Bundle;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzv;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzdwv {
    private final zzges zza;
    private final zzges zzb;
    private final zzdyd zzc;
    private final zzhfr zzd;

    public zzdwv(zzges zzges, zzges zzges2, zzdyd zzdyd, zzhfr zzhfr) {
        this.zza = zzges;
        this.zzb = zzges2;
        this.zzc = zzdyd;
        this.zzd = zzhfr;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdyx zza(zzbvx zzbvx) throws Exception {
        return (zzdyx) this.zzc.zza(zzbvx).get((long) ((Integer) zzbe.zzc().zza(zzbcn.zzfx)).intValue(), TimeUnit.SECONDS);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zzb(zzbvx zzbvx, int i, zzdyw zzdyw) throws Exception {
        Bundle bundle;
        if (!(zzbvx == null || (bundle = zzbvx.zzm) == null)) {
            bundle.putBoolean("ls", true);
        }
        return zzgei.zzn(((zzebg) this.zzd.zzb()).zzc(zzbvx, i), new zzdwr(zzbvx), this.zzb);
    }

    public final ListenableFuture zzc(zzbvx zzbvx) {
        ListenableFuture listenableFuture;
        String str = zzbvx.zzd;
        zzv.zzq();
        if (zzs.zzC(str)) {
            listenableFuture = zzgei.zzg(new zzdyw(1));
        } else {
            listenableFuture = zzgei.zzf(this.zza.zzb(new zzdws(this, zzbvx)), ExecutionException.class, new zzdwt(), this.zzb);
        }
        return zzgei.zzf(listenableFuture, zzdyw.class, new zzdwu(this, zzbvx, Binder.getCallingUid()), this.zzb);
    }
}
