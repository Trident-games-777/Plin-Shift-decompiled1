package com.google.android.gms.internal.ads;

import java.util.Comparator;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzazo implements Comparator {
    zzazo(zzazq zzazq) {
    }

    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        zzazu zzazu = (zzazu) obj;
        zzazu zzazu2 = (zzazu) obj2;
        int i = zzazu.zzc - zzazu2.zzc;
        if (i != 0) {
            return i;
        }
        return Long.compare(zzazu.zza, zzazu2.zza);
    }
}
