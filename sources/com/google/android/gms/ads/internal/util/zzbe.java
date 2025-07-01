package com.google.android.gms.ads.internal.util;

import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzbe {
    /* access modifiers changed from: private */
    public final List zza = new ArrayList();
    /* access modifiers changed from: private */
    public final List zzb = new ArrayList();
    /* access modifiers changed from: private */
    public final List zzc = new ArrayList();

    public final zzbe zza(String str, double d, double d2) {
        int i = 0;
        while (i < this.zza.size()) {
            double doubleValue = ((Double) this.zzc.get(i)).doubleValue();
            double doubleValue2 = ((Double) this.zzb.get(i)).doubleValue();
            if (d < doubleValue || (doubleValue == d && d2 < doubleValue2)) {
                break;
            }
            i++;
        }
        this.zza.add(i, str);
        this.zzc.add(i, Double.valueOf(d));
        this.zzb.add(i, Double.valueOf(d2));
        return this;
    }

    public final zzbg zzb() {
        return new zzbg(this, (zzbf) null);
    }
}
