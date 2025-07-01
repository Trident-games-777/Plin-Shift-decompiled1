package com.google.android.gms.ads.nonagon.signalgeneration;

import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.ads.query.QueryInfo;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzl {
    private final QueryInfo zza;
    private final String zzb;
    private final long zzc;
    private final int zzd;
    private final AtomicBoolean zze = new AtomicBoolean(false);

    public zzl(QueryInfo queryInfo, String str, long j, int i) {
        this.zza = queryInfo;
        this.zzb = str;
        this.zzc = j;
        this.zzd = i;
    }

    public final int zza() {
        return this.zzd;
    }

    public final QueryInfo zzb() {
        return this.zza;
    }

    public final String zzc() {
        return this.zzb;
    }

    public final void zzd() {
        this.zze.set(true);
    }

    public final boolean zze() {
        return this.zzc <= zzv.zzC().currentTimeMillis();
    }

    public final boolean zzf() {
        return this.zze.get();
    }
}
