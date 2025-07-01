package com.google.android.gms.internal.ads;

import android.view.View;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public class zzcpk {
    private final zzcro zza;
    private final View zzb;
    private final zzfeu zzc;
    private final zzcfk zzd;

    public zzcpk(View view, zzcfk zzcfk, zzcro zzcro, zzfeu zzfeu) {
        this.zzb = view;
        this.zzd = zzcfk;
        this.zza = zzcro;
        this.zzc = zzfeu;
    }

    public final View zza() {
        return this.zzb;
    }

    public final zzcfk zzb() {
        return this.zzd;
    }

    public final zzcro zzc() {
        return this.zza;
    }

    public zzcxy zzd(Set set) {
        return new zzcxy(set);
    }

    public final zzfeu zze() {
        return this.zzc;
    }
}
