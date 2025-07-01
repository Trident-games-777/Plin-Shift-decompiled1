package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.util.zze;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzbnq implements zzcaq {
    final /* synthetic */ zzbno zza;

    zzbnq(zzbnt zzbnt, zzbno zzbno) {
        this.zza = zzbno;
    }

    public final void zza() {
        zze.zza("Rejecting reference for JS Engine.");
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzhq)).booleanValue()) {
            this.zza.zzh(new IllegalStateException("Unable to create JS engine reference."), "SdkJavascriptFactory.createNewReference.FailureCallback");
        } else {
            this.zza.zzg();
        }
    }
}
