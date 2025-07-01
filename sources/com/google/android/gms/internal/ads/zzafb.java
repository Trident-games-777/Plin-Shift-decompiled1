package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
abstract class zzafb {
    protected final zzadx zza;

    protected zzafb(zzadx zzadx) {
        this.zza = zzadx;
    }

    /* access modifiers changed from: protected */
    public abstract boolean zza(zzed zzed) throws zzbh;

    /* access modifiers changed from: protected */
    public abstract boolean zzb(zzed zzed, long j) throws zzbh;

    public final boolean zzf(zzed zzed, long j) throws zzbh {
        return zza(zzed) && zzb(zzed, j);
    }
}
