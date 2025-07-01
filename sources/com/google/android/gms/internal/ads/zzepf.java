package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.client.zzy;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzepf implements zzevy {
    private final zzy zza;
    private final boolean zzb;

    public zzepf(zzy zzy, boolean z) {
        this.zza = zzy;
        this.zzb = z;
    }

    public final /* bridge */ /* synthetic */ void zzj(Object obj) {
        Bundle bundle = (Bundle) obj;
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzfo)).booleanValue()) {
            bundle.putBoolean("app_switched", this.zzb);
        }
        zzy zzy = this.zza;
        if (zzy != null) {
            int i = zzy.zza;
            if (i == 1) {
                bundle.putString("avo", "p");
            } else if (i == 2) {
                bundle.putString("avo", "l");
            }
        }
    }
}
