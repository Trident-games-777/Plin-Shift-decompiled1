package com.google.android.gms.internal.consent_sdk;

import android.os.Handler;

/* compiled from: com.google.android.ump:user-messaging-platform@@3.0.0 */
public final class zzbv implements zzdn {
    private final zzds zza;
    private final zzds zzb;

    public zzbv(zzds zzds, zzds zzds2, zzds zzds3) {
        this.zza = zzds;
        this.zzb = zzds3;
    }

    /* renamed from: zzb */
    public final zzbu zza() {
        Handler zzb2 = zzas.zzb();
        Handler handler = zzb2;
        zzca zzb3 = ((zzcb) this.zzb).zza();
        zzca zzca = zzb3;
        return new zzbu((zzbw) this.zza.zza(), zzb2, zzb3);
    }
}
