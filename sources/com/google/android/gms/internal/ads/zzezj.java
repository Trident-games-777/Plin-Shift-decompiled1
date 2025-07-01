package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzbe;
import java.util.HashSet;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzezj implements zzhfx {
    public static zzewc zza(Context context, zzbzn zzbzn, zzbzo zzbzo, Object obj, zzexf zzexf, zzeym zzeym, zzhfr zzhfr, zzhfr zzhfr2, zzhfr zzhfr3, zzhfr zzhfr4, zzhfr zzhfr5, zzhfr zzhfr6, zzhfr zzhfr7, Executor executor, zzfkl zzfkl, zzdsm zzdsm) {
        HashSet hashSet = new HashSet();
        hashSet.add((zzeyf) obj);
        hashSet.add(zzexf);
        hashSet.add(zzeym);
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzfI)).booleanValue()) {
            hashSet.add((zzevz) zzhfr.zzb());
        }
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzfJ)).booleanValue()) {
            hashSet.add((zzevz) zzhfr2.zzb());
        }
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzfL)).booleanValue()) {
            hashSet.add((zzevz) zzhfr4.zzb());
        }
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzfM)).booleanValue()) {
            hashSet.add((zzevz) zzhfr5.zzb());
        }
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzdc)).booleanValue()) {
            hashSet.add((zzevz) zzhfr7.zzb());
        }
        zzewc zzewc = new zzewc(context, executor, hashSet, zzfkl, zzdsm);
        zzewc zzewc2 = zzewc;
        return zzewc;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        throw null;
    }
}
