package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzeqh implements zzevy {
    private final double zza;
    private final boolean zzb;

    public zzeqh(double d, boolean z) {
        this.zza = d;
        this.zzb = z;
    }

    public final /* bridge */ /* synthetic */ void zzj(Object obj) {
        Bundle bundle = (Bundle) obj;
        Bundle zza2 = zzfgc.zza(bundle, "device");
        bundle.putBundle("device", zza2);
        Bundle zza3 = zzfgc.zza(zza2, "battery");
        zza2.putBundle("battery", zza3);
        zza3.putBoolean("is_charging", this.zzb);
        zza3.putDouble("battery_level", this.zza);
    }
}
