package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzac;
import com.google.android.gms.ads.internal.util.zzg;
import com.google.android.gms.ads.internal.zzv;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzcmh implements zzclr {
    private final Context zza;
    private final zzg zzb = zzv.zzp().zzi();

    public zzcmh(Context context) {
        this.zza = context;
    }

    public final void zza(Map map) {
        String str;
        if (!map.isEmpty() && (str = (String) map.get("gad_idless")) != null) {
            zzg zzg = this.zzb;
            boolean parseBoolean = Boolean.parseBoolean(str);
            zzg.zzD(parseBoolean);
            if (parseBoolean) {
                zzac.zzc(this.zza);
            }
        }
    }
}
