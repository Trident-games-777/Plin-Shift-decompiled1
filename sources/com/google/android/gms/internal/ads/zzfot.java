package com.google.android.gms.internal.ads;

import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzfot {
    private final zzfnu zza;
    private final ArrayList zzb;

    public zzfot(zzfnu zzfnu, String str) {
        ArrayList arrayList = new ArrayList();
        this.zzb = arrayList;
        this.zza = zzfnu;
        arrayList.add(str);
    }

    public final zzfnu zza() {
        return this.zza;
    }

    public final ArrayList zzb() {
        return this.zzb;
    }

    public final void zzc(String str) {
        this.zzb.add(str);
    }
}
