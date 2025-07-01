package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.internal.client.zzs;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzffu {
    public static zzs zza(Context context, List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzfeu zzfeu = (zzfeu) it.next();
            if (zzfeu.zzc) {
                arrayList.add(AdSize.FLUID);
            } else {
                arrayList.add(new AdSize(zzfeu.zza, zzfeu.zzb));
            }
        }
        return new zzs(context, (AdSize[]) arrayList.toArray(new AdSize[arrayList.size()]));
    }

    public static zzfeu zzb(zzs zzs) {
        return zzs.zzi ? new zzfeu(-3, 0, true) : new zzfeu(zzs.zze, zzs.zzb, false);
    }
}
