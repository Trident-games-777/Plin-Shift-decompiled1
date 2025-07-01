package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;

@Deprecated
@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzbda {
    private final Map zza = new HashMap();
    private final zzbdc zzb;

    public zzbda(zzbdc zzbdc) {
        this.zzb = zzbdc;
    }

    public final zzbdc zza() {
        return this.zzb;
    }

    public final void zzb(String str, zzbcz zzbcz) {
        this.zza.put(str, zzbcz);
    }

    public final void zzc(String str, String str2, long j) {
        zzbcz zzbcz = (zzbcz) this.zza.get(str2);
        String[] strArr = {str};
        if (zzbcz != null) {
            this.zzb.zze(zzbcz, j, strArr);
        }
        this.zza.put(str, new zzbcz(j, (String) null, (zzbcz) null));
    }
}
