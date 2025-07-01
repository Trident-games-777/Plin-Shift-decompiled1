package com.google.android.gms.internal.ads;

import android.view.View;
import java.util.UUID;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public abstract class zzfmw {
    public static zzfmw zza(zzfmx zzfmx, zzfmy zzfmy) {
        zzfor.zza();
        return new zzfna(zzfmx, zzfmy, UUID.randomUUID().toString());
    }

    public abstract void zzb(View view, zzfnd zzfnd, String str);

    public abstract void zzc();

    public abstract void zzd(View view);

    public abstract void zze();
}
