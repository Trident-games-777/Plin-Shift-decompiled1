package com.google.android.gms.internal.consent_sdk;

import android.app.Application;
import android.os.Handler;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.ump:user-messaging-platform@@3.0.0 */
public final class zzcb implements zzdn {
    private final zzds zza;
    private final zzds zzb;
    private final zzds zzc;
    private final zzds zzd;
    private final zzds zze;
    private final zzds zzf;

    public zzcb(zzds zzds, zzds zzds2, zzds zzds3, zzds zzds4, zzds zzds5, zzds zzds6, zzds zzds7, zzds zzds8) {
        this.zza = zzds;
        this.zzb = zzds2;
        this.zzc = zzds5;
        this.zzd = zzds6;
        this.zze = zzds7;
        this.zzf = zzds8;
    }

    /* renamed from: zzb */
    public final zzca zza() {
        Handler zzb2 = zzas.zzb();
        Handler handler = zzb2;
        Executor zzb3 = zzau.zzb();
        Executor executor = zzb3;
        zzan zzb4 = ((zzao) this.zzd).zza();
        zzan zzan = zzb4;
        return new zzca((Application) this.zza.zza(), (zzbw) this.zzb.zza(), zzb2, zzb3, (zze) this.zzc.zza(), zzb4, (zzbb) this.zze.zza(), (zzap) this.zzf.zza());
    }
}
