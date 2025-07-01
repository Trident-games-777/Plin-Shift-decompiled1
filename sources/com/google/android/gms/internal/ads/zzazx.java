package com.google.android.gms.internal.ads;

import java.util.Comparator;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzazx implements Comparator {
    public zzazx(zzazy zzazy) {
    }

    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        zzazm zzazm = (zzazm) obj;
        zzazm zzazm2 = (zzazm) obj2;
        if (zzazm.zzd() < zzazm2.zzd()) {
            return -1;
        }
        if (zzazm.zzd() > zzazm2.zzd()) {
            return 1;
        }
        if (zzazm.zzb() < zzazm2.zzb()) {
            return -1;
        }
        if (zzazm.zzb() > zzazm2.zzb()) {
            return 1;
        }
        float zza = (zzazm.zza() - zzazm.zzd()) * (zzazm.zzc() - zzazm.zzb());
        float zza2 = (zzazm2.zza() - zzazm2.zzd()) * (zzazm2.zzc() - zzazm2.zzb());
        if (zza > zza2) {
            return -1;
        }
        if (zza < zza2) {
            return 1;
        }
        return 0;
    }
}
