package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzg;
import com.google.android.gms.common.util.Clock;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzbyp extends zzbyw {
    private final Clock zzb;
    private final zzhgg zzc;
    private final zzhgg zzd;
    private final zzhgg zze;
    private final zzhgg zzf;
    private final zzhgg zzg;
    private final zzhgg zzh;
    private final zzhgg zzi;
    private final zzhgg zzj;

    /* synthetic */ zzbyp(Context context, Clock clock, zzg zzg2, zzbyv zzbyv, zzbyq zzbyq) {
        this.zzb = clock;
        zzhfx zza = zzhfy.zza(context);
        this.zzc = zza;
        zzhfx zza2 = zzhfy.zza(zzg2);
        this.zzd = zza2;
        this.zze = zzhfw.zzc(new zzbyj(zza, zza2));
        zzhfx zza3 = zzhfy.zza(clock);
        this.zzf = zza3;
        zzhfx zza4 = zzhfy.zza(zzbyv);
        this.zzg = zza4;
        zzhgg zzc2 = zzhfw.zzc(new zzbyl(zza3, zza2, zza4));
        this.zzh = zzc2;
        zzbyn zzbyn = new zzbyn(zza3, zzc2);
        this.zzi = zzbyn;
        this.zzj = zzhfw.zzc(new zzbzb(zza, zzbyn));
    }

    /* access modifiers changed from: package-private */
    public final zzbyi zza() {
        return (zzbyi) this.zze.zzb();
    }

    /* access modifiers changed from: package-private */
    public final zzbym zzb() {
        return new zzbym(this.zzb, (zzbyk) this.zzh.zzb());
    }

    /* access modifiers changed from: package-private */
    public final zzbza zzc() {
        return (zzbza) this.zzj.zzb();
    }
}
