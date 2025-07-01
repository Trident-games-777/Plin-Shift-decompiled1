package com.google.android.gms.internal.consent_sdk;

import android.app.Application;
import android.os.Handler;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.ump:user-messaging-platform@@3.0.0 */
public final class zzv implements zzdn {
    private final zzds zza;
    private final zzds zzb;
    private final zzds zzc;
    private final zzds zzd;
    private final zzds zze;
    private final zzds zzf;
    private final zzds zzg;

    public zzv(zzds zzds, zzds zzds2, zzds zzds3, zzds zzds4, zzds zzds5, zzds zzds6, zzds zzds7, zzds zzds8, zzds zzds9) {
        this.zza = zzds;
        this.zzb = zzds2;
        this.zzc = zzds5;
        this.zzd = zzds6;
        this.zze = zzds7;
        this.zzf = zzds8;
        this.zzg = zzds9;
    }

    /* renamed from: zzb */
    public final zzu zza() {
        Handler zzb2 = zzas.zzb();
        Handler handler = zzb2;
        Executor zzb3 = zzau.zzb();
        Executor executor = zzb3;
        zzl zzb4 = ((zzo) this.zze).zza();
        zzx zzb5 = ((zzaa) this.zzf).zza();
        zzl zzl = zzb4;
        zzx zzx = zzb5;
        return new zzu((Application) this.zza.zza(), (zzab) this.zzb.zza(), zzb2, zzb3, (zzap) this.zzc.zza(), (zzbn) this.zzd.zza(), zzb4, zzb5, (zze) this.zzg.zza());
    }
}
