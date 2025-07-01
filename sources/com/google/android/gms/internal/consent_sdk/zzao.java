package com.google.android.gms.internal.consent_sdk;

import android.app.Application;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.ump:user-messaging-platform@@3.0.0 */
public final class zzao implements zzdn {
    private final zzds zza;
    private final zzds zzb;

    public zzao(zzds zzds, zzds zzds2, zzds zzds3) {
        this.zza = zzds;
        this.zzb = zzds2;
    }

    /* renamed from: zzb */
    public final zzan zza() {
        Executor zzb2 = zzau.zzb();
        Executor executor = zzb2;
        return new zzan((Application) this.zza.zza(), (zzap) this.zzb.zza(), zzb2);
    }
}
