package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zze;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzcnf implements zzcwp {
    private final zzfew zza;
    private final zzfff zzb;
    private final zzfln zzc;
    private final zzflr zzd;

    public zzcnf(zzfff zzfff, zzflr zzflr, zzfln zzfln) {
        this.zzb = zzfff;
        this.zzd = zzflr;
        this.zzc = zzfln;
        this.zza = zzfff.zzb.zzb;
    }

    public final void zzdB(zze zze) {
        List list = this.zza.zza;
        this.zzd.zzd(this.zzc.zzc(this.zzb, (zzfet) null, list));
    }
}
