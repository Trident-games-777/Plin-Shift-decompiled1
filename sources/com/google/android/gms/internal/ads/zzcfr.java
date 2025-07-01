package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzr;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzcfr implements zzr {
    private final zzcfk zza;
    private final zzr zzb;

    public zzcfr(zzcfk zzcfk, zzr zzr) {
        this.zza = zzcfk;
        this.zzb = zzr;
    }

    public final void zzdH() {
    }

    public final void zzdk() {
    }

    public final void zzdq() {
        zzr zzr = this.zzb;
        if (zzr != null) {
            zzr.zzdq();
        }
    }

    public final void zzdr() {
        zzr zzr = this.zzb;
        if (zzr != null) {
            zzr.zzdr();
        }
        this.zza.zzaa();
    }

    public final void zzdt() {
        zzr zzr = this.zzb;
        if (zzr != null) {
            zzr.zzdt();
        }
    }

    public final void zzdu(int i) {
        zzr zzr = this.zzb;
        if (zzr != null) {
            zzr.zzdu(i);
        }
        this.zza.zzY();
    }
}
