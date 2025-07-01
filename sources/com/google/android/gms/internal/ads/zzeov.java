package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzeov {
    private final AtomicBoolean zza = new AtomicBoolean(false);
    private zzeou zzb;

    /* access modifiers changed from: package-private */
    public final zzeou zza() {
        return this.zzb;
    }

    /* access modifiers changed from: package-private */
    public final void zzb(zzeou zzeou) {
        this.zzb = zzeou;
    }

    public final void zzc(boolean z) {
        this.zza.set(true);
    }

    public final boolean zzd() {
        return this.zza.get();
    }
}
