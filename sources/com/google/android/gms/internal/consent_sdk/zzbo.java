package com.google.android.gms.internal.consent_sdk;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.ump:user-messaging-platform@@3.0.0 */
public final class zzbo implements zzdn {
    private final zzds zza;

    public zzbo(zzds zzds, zzds zzds2) {
        this.zza = zzds;
    }

    public final /* bridge */ /* synthetic */ Object zza() {
        Executor zzb = zzau.zzb();
        Executor executor = zzb;
        return new zzbn(this.zza, zzb);
    }
}
