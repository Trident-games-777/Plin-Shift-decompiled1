package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzgae {
    public static ArrayList zza(int i) {
        zzfyl.zza(i, "initialArraySize");
        return new ArrayList(i);
    }

    public static List zzb(List list, zzfwh zzfwh) {
        if (list instanceof RandomAccess) {
            return new zzgab(list, zzfwh);
        }
        return new zzgad(list, zzfwh);
    }
}
