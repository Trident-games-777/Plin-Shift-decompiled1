package com.google.android.gms.internal.ads;

import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzavg extends zzats {
    public Long zza;
    public Long zzb;
    public Long zzc;

    public zzavg() {
    }

    public zzavg(String str) {
        HashMap zza2 = zza(str);
        if (zza2 != null) {
            this.zza = (Long) zza2.get(0);
            this.zzb = (Long) zza2.get(1);
            this.zzc = (Long) zza2.get(2);
        }
    }

    /* access modifiers changed from: protected */
    public final HashMap zzb() {
        HashMap hashMap = new HashMap();
        hashMap.put(0, this.zza);
        hashMap.put(1, this.zzb);
        hashMap.put(2, this.zzc);
        return hashMap;
    }
}
