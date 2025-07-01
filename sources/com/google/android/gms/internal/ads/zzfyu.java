package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzfyu extends zzfyi {
    final /* synthetic */ zzfyx zza;
    private final Object zzb;
    private int zzc;

    zzfyu(zzfyx zzfyx, int i) {
        this.zza = zzfyx;
        this.zzb = zzfyx.zzg(zzfyx, i);
        this.zzc = i;
    }

    private final void zza() {
        int i = this.zzc;
        if (i == -1 || i >= this.zza.size() || !zzfwn.zza(this.zzb, zzfyx.zzg(this.zza, this.zzc))) {
            this.zzc = this.zza.zzw(this.zzb);
        }
    }

    public final Object getKey() {
        return this.zzb;
    }

    public final Object getValue() {
        Map zzl = this.zza.zzl();
        if (zzl != null) {
            return zzl.get(this.zzb);
        }
        zza();
        int i = this.zzc;
        if (i == -1) {
            return null;
        }
        return zzfyx.zzj(this.zza, i);
    }

    public final Object setValue(Object obj) {
        Map zzl = this.zza.zzl();
        if (zzl != null) {
            return zzl.put(this.zzb, obj);
        }
        zza();
        int i = this.zzc;
        if (i == -1) {
            this.zza.put(this.zzb, obj);
            return null;
        }
        zzfyx zzfyx = this.zza;
        Object zzj = zzfyx.zzj(zzfyx, i);
        zzfyx.zzn(zzfyx, this.zzc, obj);
        return zzj;
    }
}
