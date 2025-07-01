package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzm;
import com.google.android.gms.ads.internal.client.zzy;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzfbp implements zzfhx {
    public final zzfcj zza;
    public final zzfcl zzb;
    public final zzm zzc;
    public final String zzd;
    public final Executor zze;
    public final zzy zzf;
    public final zzfhm zzg;

    public zzfbp(zzfcj zzfcj, zzfcl zzfcl, zzm zzm, String str, Executor executor, zzy zzy, zzfhm zzfhm) {
        this.zza = zzfcj;
        this.zzb = zzfcl;
        this.zzc = zzm;
        this.zzd = str;
        this.zze = executor;
        this.zzf = zzy;
        this.zzg = zzfhm;
    }

    public final zzfhm zza() {
        return this.zzg;
    }

    public final Executor zzb() {
        return this.zze;
    }
}
