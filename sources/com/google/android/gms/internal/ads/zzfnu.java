package com.google.android.gms.internal.ads;

import android.view.View;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzfnu {
    private final zzfpi zza;
    private final String zzb;
    private final zzfnd zzc;
    private final String zzd = "Ad overlay";

    public zzfnu(View view, zzfnd zzfnd, String str) {
        this.zza = new zzfpi(view);
        this.zzb = view.getClass().getCanonicalName();
        this.zzc = zzfnd;
    }

    public final zzfnd zza() {
        return this.zzc;
    }

    public final zzfpi zzb() {
        return this.zza;
    }

    public final String zzc() {
        return this.zzd;
    }

    public final String zzd() {
        return this.zzb;
    }
}
