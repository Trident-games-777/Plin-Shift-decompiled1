package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzdrp implements zzfjs {
    private final Map zza;
    private final zzbbl zzb;

    zzdrp(zzbbl zzbbl, Map map) {
        this.zza = map;
        this.zzb = zzbbl;
    }

    public final void zzd(zzfjl zzfjl, String str) {
        if (this.zza.containsKey(zzfjl)) {
            this.zzb.zzc(((zzdro) this.zza.get(zzfjl)).zzb);
        }
    }

    public final void zzdC(zzfjl zzfjl, String str) {
    }

    public final void zzdD(zzfjl zzfjl, String str, Throwable th) {
        if (this.zza.containsKey(zzfjl)) {
            this.zzb.zzc(((zzdro) this.zza.get(zzfjl)).zzc);
        }
    }

    public final void zzdE(zzfjl zzfjl, String str) {
        if (this.zza.containsKey(zzfjl)) {
            this.zzb.zzc(((zzdro) this.zza.get(zzfjl)).zza);
        }
    }
}
