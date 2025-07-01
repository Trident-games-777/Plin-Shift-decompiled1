package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.client.zzm;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
final class zzbub extends zzbtu {
    final /* synthetic */ List zza;

    zzbub(zzbud zzbud, List list) {
        this.zza = list;
    }

    public final void zze(String str) {
        zzm.zzg("Error recording click: ".concat(String.valueOf(str)));
    }

    public final void zzf(List list) {
        zzm.zzi("Recorded click: ".concat(this.zza.toString()));
    }
}
