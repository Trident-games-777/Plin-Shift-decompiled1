package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
final class zzgyj extends zzgyi {
    zzgyj() {
    }

    /* access modifiers changed from: package-private */
    public final void zza(Object obj) {
        ((zzgyt) obj).zza.zzg();
    }

    /* access modifiers changed from: package-private */
    public final void zzb(zzhcc zzhcc, Map.Entry entry) throws IOException {
        zzgyu zzgyu = (zzgyu) entry.getKey();
        if (zzgyu.zzc) {
            zzhca zzhca = zzhca.DOUBLE;
            switch (zzgyu.zzb.ordinal()) {
                case 0:
                    zzhbd.zzt(zzgyu.zza, (List) entry.getValue(), zzhcc, zzgyu.zzd);
                    return;
                case 1:
                    zzhbd.zzx(zzgyu.zza, (List) entry.getValue(), zzhcc, zzgyu.zzd);
                    return;
                case 2:
                    zzhbd.zzA(zzgyu.zza, (List) entry.getValue(), zzhcc, zzgyu.zzd);
                    return;
                case 3:
                    zzhbd.zzI(zzgyu.zza, (List) entry.getValue(), zzhcc, zzgyu.zzd);
                    return;
                case 4:
                    zzhbd.zzz(zzgyu.zza, (List) entry.getValue(), zzhcc, zzgyu.zzd);
                    return;
                case 5:
                    zzhbd.zzw(zzgyu.zza, (List) entry.getValue(), zzhcc, zzgyu.zzd);
                    return;
                case 6:
                    zzhbd.zzv(zzgyu.zza, (List) entry.getValue(), zzhcc, zzgyu.zzd);
                    return;
                case 7:
                    zzhbd.zzr(zzgyu.zza, (List) entry.getValue(), zzhcc, zzgyu.zzd);
                    return;
                case 8:
                    zzhbd.zzG(zzgyu.zza, (List) entry.getValue(), zzhcc);
                    return;
                case 9:
                    List list = (List) entry.getValue();
                    if (list != null && !list.isEmpty()) {
                        zzhbd.zzy(zzgyu.zza, (List) entry.getValue(), zzhcc, zzhas.zza().zzb(list.get(0).getClass()));
                        return;
                    }
                    return;
                case 10:
                    List list2 = (List) entry.getValue();
                    if (list2 != null && !list2.isEmpty()) {
                        zzhbd.zzB(zzgyu.zza, (List) entry.getValue(), zzhcc, zzhas.zza().zzb(list2.get(0).getClass()));
                        return;
                    }
                    return;
                case 11:
                    zzhbd.zzs(zzgyu.zza, (List) entry.getValue(), zzhcc);
                    return;
                case 12:
                    zzhbd.zzH(zzgyu.zza, (List) entry.getValue(), zzhcc, zzgyu.zzd);
                    return;
                case 13:
                    zzhbd.zzz(zzgyu.zza, (List) entry.getValue(), zzhcc, zzgyu.zzd);
                    return;
                case 14:
                    zzhbd.zzC(zzgyu.zza, (List) entry.getValue(), zzhcc, zzgyu.zzd);
                    return;
                case 15:
                    zzhbd.zzD(zzgyu.zza, (List) entry.getValue(), zzhcc, zzgyu.zzd);
                    return;
                case 16:
                    zzhbd.zzE(zzgyu.zza, (List) entry.getValue(), zzhcc, zzgyu.zzd);
                    return;
                case 17:
                    zzhbd.zzF(zzgyu.zza, (List) entry.getValue(), zzhcc, zzgyu.zzd);
                    return;
                default:
                    return;
            }
        } else {
            zzhca zzhca2 = zzhca.DOUBLE;
            switch (zzgyu.zzb.ordinal()) {
                case 0:
                    zzhcc.zzf(zzgyu.zza, ((Double) entry.getValue()).doubleValue());
                    return;
                case 1:
                    zzhcc.zzo(zzgyu.zza, ((Float) entry.getValue()).floatValue());
                    return;
                case 2:
                    zzhcc.zzt(zzgyu.zza, ((Long) entry.getValue()).longValue());
                    return;
                case 3:
                    zzhcc.zzK(zzgyu.zza, ((Long) entry.getValue()).longValue());
                    return;
                case 4:
                    zzhcc.zzr(zzgyu.zza, ((Integer) entry.getValue()).intValue());
                    return;
                case 5:
                    zzhcc.zzm(zzgyu.zza, ((Long) entry.getValue()).longValue());
                    return;
                case 6:
                    zzhcc.zzk(zzgyu.zza, ((Integer) entry.getValue()).intValue());
                    return;
                case 7:
                    zzhcc.zzb(zzgyu.zza, ((Boolean) entry.getValue()).booleanValue());
                    return;
                case 8:
                    zzhcc.zzG(zzgyu.zza, (String) entry.getValue());
                    return;
                case 9:
                    zzhcc.zzq(zzgyu.zza, entry.getValue(), zzhas.zza().zzb(entry.getValue().getClass()));
                    return;
                case 10:
                    zzhcc.zzv(zzgyu.zza, entry.getValue(), zzhas.zza().zzb(entry.getValue().getClass()));
                    return;
                case 11:
                    zzhcc.zzd(zzgyu.zza, (zzgxp) entry.getValue());
                    return;
                case 12:
                    zzhcc.zzI(zzgyu.zza, ((Integer) entry.getValue()).intValue());
                    return;
                case 13:
                    zzhcc.zzr(zzgyu.zza, ((Integer) entry.getValue()).intValue());
                    return;
                case 14:
                    zzhcc.zzx(zzgyu.zza, ((Integer) entry.getValue()).intValue());
                    return;
                case 15:
                    zzhcc.zzz(zzgyu.zza, ((Long) entry.getValue()).longValue());
                    return;
                case 16:
                    zzhcc.zzB(zzgyu.zza, ((Integer) entry.getValue()).intValue());
                    return;
                case 17:
                    zzhcc.zzD(zzgyu.zza, ((Long) entry.getValue()).longValue());
                    return;
                default:
                    return;
            }
        }
    }
}
