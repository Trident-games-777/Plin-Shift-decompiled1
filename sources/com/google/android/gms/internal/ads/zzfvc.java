package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzfvc extends zzftv {
    final /* synthetic */ zzfvd zza;
    private final zzfvi zzb;

    zzfvc(zzfvd zzfvd, zzfvi zzfvi) {
        this.zza = zzfvd;
        this.zzb = zzfvi;
    }

    public final void zzb(Bundle bundle) {
        int i = bundle.getInt("statusCode", 8150);
        String string = bundle.getString("sessionToken");
        zzfvg zzc = zzfvh.zzc();
        zzc.zzb(i);
        if (string != null) {
            zzc.zza(string);
        }
        this.zzb.zza(zzc.zzc());
        if (i == 8157) {
            this.zza.zza();
        }
    }
}
