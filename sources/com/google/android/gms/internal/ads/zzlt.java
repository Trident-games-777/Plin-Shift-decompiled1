package com.google.android.gms.internal.ads;

import android.content.Context;

@Deprecated
/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzlt {
    private final zzip zza;

    @Deprecated
    public zzlt(Context context, zzcep zzcep) {
        this.zza = new zzip(context, zzcep);
    }

    @Deprecated
    public final zzlt zza(zzkl zzkl) {
        zzip zzip = this.zza;
        zzdb.zzf(!zzip.zzr);
        zzkl.getClass();
        zzip.zzf = new zzih(zzkl);
        return this;
    }

    @Deprecated
    public final zzlt zzb(zzyj zzyj) {
        zzip zzip = this.zza;
        zzdb.zzf(!zzip.zzr);
        zzyj.getClass();
        zzip.zze = new zzio(zzyj);
        return this;
    }

    @Deprecated
    public final zzlu zzc() {
        zzip zzip = this.zza;
        zzdb.zzf(!zzip.zzr);
        zzip.zzr = true;
        return new zzlu(zzip);
    }
}
