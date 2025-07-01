package com.google.android.gms.internal.ads;

import android.content.pm.PackageInfo;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzexf implements zzevz {
    private final Executor zza;
    private final String zzb;

    public zzexf(zzbzq zzbzq, Executor executor, String str, PackageInfo packageInfo, int i) {
        this.zza = executor;
        this.zzb = str;
    }

    public final int zza() {
        return 41;
    }

    public final ListenableFuture zzb() {
        return zzgei.zzf(zzgei.zzm(zzgei.zzh(this.zzb), new zzexd(), this.zza), Throwable.class, new zzexe(this), this.zza);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zzc(Throwable th) throws Exception {
        return zzgei.zzh(new zzexg(this.zzb));
    }
}
