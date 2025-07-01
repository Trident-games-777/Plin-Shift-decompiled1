package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.formats.zzf;
import com.google.android.gms.ads.formats.zzg;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
public final class zzbic {
    /* access modifiers changed from: private */
    public final zzg zza;
    /* access modifiers changed from: private */
    public final zzf zzb;
    private zzbgt zzc;

    public zzbic(zzg zzg, zzf zzf) {
        this.zza = zzg;
        this.zzb = zzf;
    }

    /* access modifiers changed from: private */
    public final synchronized zzbgt zzf(zzbgs zzbgs) {
        zzbgt zzbgt = this.zzc;
        if (zzbgt != null) {
            return zzbgt;
        }
        zzbgt zzbgt2 = new zzbgt(zzbgs);
        this.zzc = zzbgt2;
        return zzbgt2;
    }

    public final zzbhc zzc() {
        if (this.zzb == null) {
            return null;
        }
        return new zzbhz(this, (zzbib) null);
    }

    public final zzbhf zzd() {
        return new zzbia(this, (zzbib) null);
    }
}
