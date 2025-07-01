package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzgou {
    private final Map zza;
    private final zzgos zzb;
    private final Class zzc;
    private final zzgnd zzd;

    /* synthetic */ zzgou(Map map, List list, zzgos zzgos, zzgnd zzgnd, Class cls, zzgot zzgot) {
        this.zza = map;
        this.zzb = zzgos;
        this.zzc = cls;
        this.zzd = zzgnd;
    }

    public static zzgor zzb(Class cls) {
        return new zzgor(cls, (zzgot) null);
    }

    public final zzgnd zza() {
        return this.zzd;
    }

    @Nullable
    public final zzgos zzc() {
        return this.zzb;
    }

    public final Class zzd() {
        return this.zzc;
    }

    public final Collection zze() {
        return this.zza.values();
    }

    public final List zzf(byte[] bArr) {
        List list = (List) this.zza.get(zzgwu.zzb(bArr));
        if (list != null) {
            return list;
        }
        return Collections.emptyList();
    }

    public final boolean zzg() {
        return !this.zzd.zza().isEmpty();
    }
}
