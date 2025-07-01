package com.google.android.gms.internal.ads;

import android.view.View;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public class zzdfn {
    private final zzdgv zza;
    private final zzcfk zzb;

    public zzdfn(zzdgv zzdgv, zzcfk zzcfk) {
        this.zza = zzdgv;
        this.zzb = zzcfk;
    }

    public final View zza() {
        zzcfk zzcfk = this.zzb;
        if (zzcfk == null) {
            return null;
        }
        return zzcfk.zzG();
    }

    public final View zzb() {
        zzcfk zzcfk = this.zzb;
        if (zzcfk != null) {
            return zzcfk.zzG();
        }
        return null;
    }

    public final zzcfk zzc() {
        return this.zzb;
    }

    public final zzded zzd(Executor executor) {
        return new zzded(new zzdfm(this.zzb), executor);
    }

    public final zzdgv zze() {
        return this.zza;
    }

    public Set zzf(zzcvj zzcvj) {
        return Collections.singleton(new zzded(zzcvj, zzcaj.zzf));
    }

    public Set zzg(zzcvj zzcvj) {
        return Collections.singleton(new zzded(zzcvj, zzcaj.zzf));
    }
}
