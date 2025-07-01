package com.google.android.gms.internal.ads;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzhgk {
    private final List zza;
    private final List zzb;

    /* synthetic */ zzhgk(int i, int i2, zzhgj zzhgj) {
        this.zza = zzhfu.zzc(i);
        this.zzb = zzhfu.zzc(i2);
    }

    public final zzhgk zza(zzhgg zzhgg) {
        this.zzb.add(zzhgg);
        return this;
    }

    public final zzhgk zzb(zzhgg zzhgg) {
        this.zza.add(zzhgg);
        return this;
    }

    public final zzhgl zzc() {
        return new zzhgl(this.zza, this.zzb, (zzhgj) null);
    }
}
