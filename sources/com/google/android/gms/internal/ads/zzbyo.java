package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzg;
import com.google.android.gms.common.util.Clock;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzbyo {
    private Context zza;
    private Clock zzb;
    private zzg zzc;
    private zzbyv zzd;

    private zzbyo() {
        throw null;
    }

    /* synthetic */ zzbyo(zzbyq zzbyq) {
    }

    public final zzbyo zza(zzg zzg) {
        zzg zzg2 = zzg;
        this.zzc = zzg;
        return this;
    }

    public final zzbyo zzd(zzbyv zzbyv) {
        zzbyv zzbyv2 = zzbyv;
        this.zzd = zzbyv;
        return this;
    }

    public final zzbyw zze() {
        zzhgf.zzc(this.zza, Context.class);
        zzhgf.zzc(this.zzb, Clock.class);
        zzhgf.zzc(this.zzc, zzg.class);
        zzhgf.zzc(this.zzd, zzbyv.class);
        return new zzbyp(this.zza, this.zzb, this.zzc, this.zzd, (zzbyq) null);
    }

    public final zzbyo zzb(Context context) {
        context.getClass();
        Context context2 = context;
        this.zza = context;
        return this;
    }

    public final zzbyo zzc(Clock clock) {
        clock.getClass();
        Clock clock2 = clock;
        this.zzb = clock;
        return this;
    }
}
