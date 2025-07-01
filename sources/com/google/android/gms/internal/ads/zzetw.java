package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.internal.client.zzbe;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzetw implements zzevy {
    public final zzfes zza;

    public zzetw(zzfes zzfes) {
        this.zza = zzfes;
    }

    public final /* bridge */ /* synthetic */ void zzj(Object obj) {
        Bundle bundle = (Bundle) obj;
        if (this.zza != null) {
            if (!((Boolean) zzbe.zzc().zza(zzbcn.zzlE)).booleanValue()) {
                bundle.putBoolean("render_in_browser", this.zza.zzd());
                bundle.putBoolean("disable_ml", this.zza.zzc());
            }
        }
    }
}
