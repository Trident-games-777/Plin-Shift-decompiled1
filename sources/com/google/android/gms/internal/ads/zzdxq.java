package com.google.android.gms.internal.ads;

import android.os.Binder;
import android.os.Bundle;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzv;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzdxq {
    private final ScheduledExecutorService zza;
    private final zzges zzb;
    private final zzges zzc;
    private final zzdyj zzd;
    private final zzhfr zze;

    public zzdxq(ScheduledExecutorService scheduledExecutorService, zzges zzges, zzges zzges2, zzdyj zzdyj, zzhfr zzhfr) {
        this.zza = scheduledExecutorService;
        this.zzb = zzges;
        this.zzc = zzges2;
        this.zzd = zzdyj;
        this.zze = zzhfr;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdyx zza(zzbvx zzbvx) throws Exception {
        return (zzdyx) this.zzd.zza(zzbvx).get((long) ((Integer) zzbe.zzc().zza(zzbcn.zzfx)).intValue(), TimeUnit.SECONDS);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zzb(zzbvx zzbvx, int i, Throwable th) throws Exception {
        Bundle bundle;
        if (!(zzbvx == null || (bundle = zzbvx.zzm) == null)) {
            bundle.putBoolean("ls", true);
        }
        return zzgei.zzn(((zzebg) this.zze.zzb()).zzd(zzbvx, i), new zzdxn(zzbvx), this.zzb);
    }

    public final ListenableFuture zzc(zzbvx zzbvx) {
        ListenableFuture listenableFuture;
        String str = zzbvx.zzd;
        zzv.zzq();
        if (zzs.zzC(str)) {
            listenableFuture = zzgei.zzg(new zzdyw(1));
        } else {
            if (((Boolean) zzbe.zzc().zza(zzbcn.zzhi)).booleanValue()) {
                listenableFuture = this.zzc.zzb(new zzdxo(this, zzbvx));
            } else {
                listenableFuture = this.zzd.zza(zzbvx);
            }
        }
        int callingUid = Binder.getCallingUid();
        zzgdz zzu = zzgdz.zzu(listenableFuture);
        zzbce zzbce = zzbcn.zzfx;
        return (zzgdz) zzgei.zzf((zzgdz) zzgei.zzo(zzu, (long) ((Integer) zzbe.zzc().zza(zzbce)).intValue(), TimeUnit.SECONDS, this.zza), Throwable.class, new zzdxp(this, zzbvx, callingUid), this.zzb);
    }
}
