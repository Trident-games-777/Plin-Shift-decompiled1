package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
public final class zzbco {
    static List zza() {
        ArrayList arrayList = new ArrayList();
        zzc(arrayList, zzbdx.zzc("gad:dynamite_module:experiment_id", ""));
        zzc(arrayList, zzbek.zza);
        zzc(arrayList, zzbek.zzb);
        zzc(arrayList, zzbek.zzc);
        zzc(arrayList, zzbek.zzd);
        zzc(arrayList, zzbek.zze);
        zzc(arrayList, zzbek.zzu);
        zzc(arrayList, zzbek.zzf);
        zzc(arrayList, zzbek.zzm);
        zzc(arrayList, zzbek.zzn);
        zzc(arrayList, zzbek.zzo);
        zzc(arrayList, zzbek.zzp);
        zzc(arrayList, zzbek.zzq);
        zzc(arrayList, zzbek.zzr);
        zzc(arrayList, zzbek.zzs);
        zzc(arrayList, zzbek.zzt);
        zzc(arrayList, zzbek.zzg);
        zzc(arrayList, zzbek.zzh);
        zzc(arrayList, zzbek.zzi);
        zzc(arrayList, zzbek.zzj);
        zzc(arrayList, zzbek.zzk);
        zzc(arrayList, zzbek.zzl);
        return arrayList;
    }

    static List zzb() {
        ArrayList arrayList = new ArrayList();
        zzc(arrayList, zzbey.zza);
        return arrayList;
    }

    private static void zzc(List list, zzbdx zzbdx) {
        String str = (String) zzbdx.zze();
        if (!TextUtils.isEmpty(str)) {
            list.add(str);
        }
    }
}
