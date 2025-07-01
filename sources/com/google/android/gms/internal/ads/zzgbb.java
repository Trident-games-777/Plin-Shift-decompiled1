package com.google.android.gms.internal.ads;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.AbstractMap;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzgbb extends zzfzo {
    final /* synthetic */ zzgbc zza;

    zzgbb(zzgbc zzgbc) {
        this.zza = zzgbc;
    }

    public final /* bridge */ /* synthetic */ Object get(int i) {
        zzfwq.zza(i, this.zza.zzc, FirebaseAnalytics.Param.INDEX);
        int i2 = i + i;
        return new AbstractMap.SimpleImmutableEntry(Objects.requireNonNull(this.zza.zzb[i2]), Objects.requireNonNull(this.zza.zzb[i2 + 1]));
    }

    public final int size() {
        return this.zza.zzc;
    }

    public final boolean zzf() {
        return true;
    }
}
