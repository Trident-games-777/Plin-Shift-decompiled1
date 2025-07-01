package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzfjh {
    final /* synthetic */ zzfjj zza;
    private final Object zzb;
    private final String zzc;
    private final ListenableFuture zzd;
    private final List zze;
    private final ListenableFuture zzf;

    private zzfjh(zzfjj zzfjj, Object obj, String str, ListenableFuture listenableFuture, List list, ListenableFuture listenableFuture2) {
        this.zza = zzfjj;
        this.zzb = obj;
        this.zzc = str;
        this.zzd = listenableFuture;
        this.zze = list;
        this.zzf = listenableFuture2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* synthetic */ zzfjh(com.google.android.gms.internal.ads.zzfjj r1, java.lang.Object r2, java.lang.String r3, com.google.common.util.concurrent.ListenableFuture r4, java.util.List r5, com.google.common.util.concurrent.ListenableFuture r6, com.google.android.gms.internal.ads.zzfji r7) {
        /*
            r0 = this;
            r7 = r6
            r6 = r5
            r5 = r4
            r4 = 0
            r3 = r2
            r2 = r1
            r1 = r0
            r1.<init>(r2, r3, r4, r5, r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfjh.<init>(com.google.android.gms.internal.ads.zzfjj, java.lang.Object, java.lang.String, com.google.common.util.concurrent.ListenableFuture, java.util.List, com.google.common.util.concurrent.ListenableFuture, com.google.android.gms.internal.ads.zzfji):void");
    }

    public final zzfix zza() {
        Object obj = this.zzb;
        String str = this.zzc;
        if (str == null) {
            str = this.zza.zzf(obj);
        }
        zzfix zzfix = new zzfix(obj, str, this.zzf);
        this.zza.zzd.zza(zzfix);
        this.zzd.addListener(new zzfjf(this, zzfix), zzcaj.zzf);
        zzgei.zzr(zzfix, new zzfjg(this, zzfix), zzcaj.zzf);
        return zzfix;
    }

    public final zzfjh zzb(Object obj) {
        return this.zza.zzb(obj, zza());
    }

    public final zzfjh zzc(Class cls, zzgdp zzgdp) {
        return new zzfjh(this.zza, this.zzb, this.zzc, this.zzd, this.zze, zzgei.zzf(this.zzf, cls, zzgdp, this.zza.zzb));
    }

    public final zzfjh zzd(ListenableFuture listenableFuture) {
        return zzg(new zzfje(listenableFuture), zzcaj.zzf);
    }

    public final zzfjh zze(zzfiv zzfiv) {
        return zzf(new zzfjd(zzfiv));
    }

    public final zzfjh zzf(zzgdp zzgdp) {
        return zzg(zzgdp, this.zza.zzb);
    }

    public final zzfjh zzg(zzgdp zzgdp, Executor executor) {
        return new zzfjh(this.zza, this.zzb, this.zzc, this.zzd, this.zze, zzgei.zzn(this.zzf, zzgdp, executor));
    }

    public final zzfjh zzh(String str) {
        return new zzfjh(this.zza, this.zzb, str, this.zzd, this.zze, this.zzf);
    }

    public final zzfjh zzi(long j, TimeUnit timeUnit) {
        return new zzfjh(this.zza, this.zzb, this.zzc, this.zzd, this.zze, zzgei.zzo(this.zzf, j, timeUnit, this.zza.zzc));
    }
}
