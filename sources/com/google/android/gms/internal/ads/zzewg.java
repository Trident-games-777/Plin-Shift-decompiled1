package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.internal.client.zzbc;
import com.google.android.gms.ads.internal.client.zzbe;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzewg implements zzevy {
    private final int zza;
    private final int zzb;

    zzewg(int i, int i2) {
        this.zza = i;
        this.zzb = i2;
    }

    public final /* bridge */ /* synthetic */ void zzj(Object obj) {
        Bundle bundle = (Bundle) obj;
        bundle.putInt("sessions_without_flags", this.zza);
        bundle.putInt("crashes_without_flags", this.zzb);
        int i = zzbc.zza;
        if (zzbe.zzc().zze()) {
            bundle.putBoolean("did_reset", true);
        }
    }
}
