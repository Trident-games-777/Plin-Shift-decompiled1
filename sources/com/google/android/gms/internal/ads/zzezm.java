package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzbe;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzezm implements zzevz {
    private final zzbzz zza;
    private final boolean zzb;
    private final boolean zzc;
    private final ScheduledExecutorService zzd;
    private final zzges zze;

    zzezm(zzbzz zzbzz, boolean z, boolean z2, zzbzo zzbzo, zzges zzges, String str, ScheduledExecutorService scheduledExecutorService) {
        this.zza = zzbzz;
        this.zzb = z;
        this.zzc = z2;
        this.zze = zzges;
        this.zzd = scheduledExecutorService;
    }

    public final int zza() {
        return 50;
    }

    public final ListenableFuture zzb() {
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzgS)).booleanValue() && this.zzc) {
            return zzgei.zzh((Object) null);
        }
        if (!this.zzb) {
            return zzgei.zzh((Object) null);
        }
        return zzgei.zze(zzgei.zzo(zzgei.zzm(zzgei.zzh((Object) null), new zzezk(), this.zze), ((Long) zzbfb.zzb.zze()).longValue(), TimeUnit.MILLISECONDS, this.zzd), Exception.class, new zzezl(this), this.zze);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzezn zzc(Exception exc) {
        this.zza.zzw(exc, "TrustlessTokenSignal");
        return null;
    }
}
