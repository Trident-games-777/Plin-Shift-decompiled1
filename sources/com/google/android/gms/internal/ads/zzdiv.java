package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzdiv {
    private zzbfv zza;

    public zzdiv(zzdig zzdig) {
        this.zza = zzdig;
    }

    public final synchronized zzbfv zza() {
        return this.zza;
    }

    public final synchronized void zzb(zzbfv zzbfv) {
        this.zza = zzbfv;
    }
}
