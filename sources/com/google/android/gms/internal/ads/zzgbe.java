package com.google.android.gms.internal.ads;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzgbe extends zzfzo {
    private final transient Object[] zza;
    private final transient int zzb;
    private final transient int zzc;

    zzgbe(Object[] objArr, int i, int i2) {
        this.zza = objArr;
        this.zzb = i;
        this.zzc = i2;
    }

    public final Object get(int i) {
        zzfwq.zza(i, this.zzc, FirebaseAnalytics.Param.INDEX);
        return Objects.requireNonNull(this.zza[i + i + this.zzb]);
    }

    public final int size() {
        return this.zzc;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzf() {
        return true;
    }
}
