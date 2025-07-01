package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzbe;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzerg implements zzhfx {
    public static zzerg zza() {
        return zzerf.zza;
    }

    public final /* synthetic */ Object zzb() {
        List arrayList = new ArrayList();
        if (!((String) zzbe.zzc().zza(zzbcn.zzlu)).isEmpty()) {
            arrayList = Arrays.asList(((String) zzbe.zzc().zza(zzbcn.zzlu)).split(","));
        }
        zzhgf.zzb(arrayList);
        List list = arrayList;
        return arrayList;
    }
}
