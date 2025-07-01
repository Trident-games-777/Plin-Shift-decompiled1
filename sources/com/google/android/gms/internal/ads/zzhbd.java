package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
final class zzhbd {
    public static final /* synthetic */ int zza = 0;
    private static final zzhbn zzb = new zzhbp();

    static {
        int i = zzhas.zza;
    }

    public static void zzA(int i, List list, zzhcc zzhcc, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzhcc.zzu(i, list, z);
        }
    }

    public static void zzB(int i, List list, zzhcc zzhcc, zzhbb zzhbb) throws IOException {
        if (list != null && !list.isEmpty()) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                ((zzgyd) zzhcc).zzv(i, list.get(i2), zzhbb);
            }
        }
    }

    public static void zzC(int i, List list, zzhcc zzhcc, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzhcc.zzy(i, list, z);
        }
    }

    public static void zzD(int i, List list, zzhcc zzhcc, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzhcc.zzA(i, list, z);
        }
    }

    public static void zzE(int i, List list, zzhcc zzhcc, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzhcc.zzC(i, list, z);
        }
    }

    public static void zzF(int i, List list, zzhcc zzhcc, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzhcc.zzE(i, list, z);
        }
    }

    public static void zzG(int i, List list, zzhcc zzhcc) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzhcc.zzH(i, list);
        }
    }

    public static void zzH(int i, List list, zzhcc zzhcc, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzhcc.zzJ(i, list, z);
        }
    }

    public static void zzI(int i, List list, zzhcc zzhcc, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzhcc.zzL(i, list, z);
        }
    }

    static boolean zzJ(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    static int zza(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgyy) {
            zzgyy zzgyy = (zzgyy) list;
            int i2 = 0;
            while (i < size) {
                i2 += zzgyc.zzE((long) zzgyy.zzd(i));
                i++;
            }
            return i2;
        }
        int i3 = 0;
        while (i < size) {
            i3 += zzgyc.zzE((long) ((Integer) list.get(i)).intValue());
            i++;
        }
        return i3;
    }

    static int zzb(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzgyc.zzD(i << 3) + 4);
    }

    static int zzc(List list) {
        return list.size() * 4;
    }

    static int zzd(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzgyc.zzD(i << 3) + 8);
    }

    static int zze(List list) {
        return list.size() * 8;
    }

    static int zzf(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgyy) {
            zzgyy zzgyy = (zzgyy) list;
            int i2 = 0;
            while (i < size) {
                i2 += zzgyc.zzE((long) zzgyy.zzd(i));
                i++;
            }
            return i2;
        }
        int i3 = 0;
        while (i < size) {
            i3 += zzgyc.zzE((long) ((Integer) list.get(i)).intValue());
            i++;
        }
        return i3;
    }

    static int zzg(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgzx) {
            zzgzx zzgzx = (zzgzx) list;
            int i2 = 0;
            while (i < size) {
                i2 += zzgyc.zzE(zzgzx.zza(i));
                i++;
            }
            return i2;
        }
        int i3 = 0;
        while (i < size) {
            i3 += zzgyc.zzE(((Long) list.get(i)).longValue());
            i++;
        }
        return i3;
    }

    static int zzh(int i, Object obj, zzhbb zzhbb) {
        int i2 = i << 3;
        if (!(obj instanceof zzgzt)) {
            return zzgyc.zzD(i2) + zzgyc.zzA((zzhai) obj, zzhbb);
        }
        int zzD = zzgyc.zzD(i2);
        int zza2 = ((zzgzt) obj).zza();
        return zzD + zzgyc.zzD(zza2) + zza2;
    }

    static int zzi(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgyy) {
            zzgyy zzgyy = (zzgyy) list;
            int i2 = 0;
            while (i < size) {
                int zzd = zzgyy.zzd(i);
                i2 += zzgyc.zzD((zzd >> 31) ^ (zzd + zzd));
                i++;
            }
            return i2;
        }
        int i3 = 0;
        while (i < size) {
            int intValue = ((Integer) list.get(i)).intValue();
            i3 += zzgyc.zzD((intValue >> 31) ^ (intValue + intValue));
            i++;
        }
        return i3;
    }

    static int zzj(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgzx) {
            zzgzx zzgzx = (zzgzx) list;
            int i2 = 0;
            while (i < size) {
                long zza2 = zzgzx.zza(i);
                i2 += zzgyc.zzE((zza2 >> 63) ^ (zza2 + zza2));
                i++;
            }
            return i2;
        }
        int i3 = 0;
        while (i < size) {
            long longValue = ((Long) list.get(i)).longValue();
            i3 += zzgyc.zzE((longValue >> 63) ^ (longValue + longValue));
            i++;
        }
        return i3;
    }

    static int zzk(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgyy) {
            zzgyy zzgyy = (zzgyy) list;
            int i2 = 0;
            while (i < size) {
                i2 += zzgyc.zzD(zzgyy.zzd(i));
                i++;
            }
            return i2;
        }
        int i3 = 0;
        while (i < size) {
            i3 += zzgyc.zzD(((Integer) list.get(i)).intValue());
            i++;
        }
        return i3;
    }

    static int zzl(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgzx) {
            zzgzx zzgzx = (zzgzx) list;
            int i2 = 0;
            while (i < size) {
                i2 += zzgyc.zzE(zzgzx.zza(i));
                i++;
            }
            return i2;
        }
        int i3 = 0;
        while (i < size) {
            i3 += zzgyc.zzE(((Long) list.get(i)).longValue());
            i++;
        }
        return i3;
    }

    public static zzhbn zzm() {
        return zzb;
    }

    static Object zzn(Object obj, int i, List list, zzgzd zzgzd, Object obj2, zzhbn zzhbn) {
        if (zzgzd == null) {
            return obj2;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                int intValue = ((Integer) list.get(i3)).intValue();
                if (zzgzd.zza(intValue)) {
                    if (i3 != i2) {
                        list.set(i2, Integer.valueOf(intValue));
                    }
                    i2++;
                } else {
                    obj2 = zzo(obj, i, intValue, obj2, zzhbn);
                }
            }
            if (i2 != size) {
                list.subList(i2, size).clear();
            }
            return obj2;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            int intValue2 = ((Integer) it.next()).intValue();
            if (!zzgzd.zza(intValue2)) {
                obj2 = zzo(obj, i, intValue2, obj2, zzhbn);
                it.remove();
            }
        }
        return obj2;
    }

    static Object zzo(Object obj, int i, int i2, Object obj2, zzhbn zzhbn) {
        if (obj2 == null) {
            obj2 = zzhbn.zza(obj);
        }
        zzhbn.zzh(obj2, i, (long) i2);
        return obj2;
    }

    static void zzp(zzgyi zzgyi, Object obj, Object obj2) {
        if (!((zzgyt) obj2).zza.zza.isEmpty()) {
            zzgyt zzgyt = (zzgyt) obj;
            throw null;
        }
    }

    static void zzq(zzhbn zzhbn, Object obj, Object obj2) {
        zzgyx zzgyx = (zzgyx) obj;
        zzhbo zzhbo = zzgyx.zzt;
        zzhbo zzhbo2 = ((zzgyx) obj2).zzt;
        zzhbo zzhbo3 = zzhbo;
        zzhbo zzhbo4 = zzhbo2;
        if (!zzhbo.zzc().equals(zzhbo2)) {
            if (zzhbo.zzc().equals(zzhbo)) {
                zzhbo = zzhbo.zze(zzhbo, zzhbo2);
            } else {
                zzhbo.zzd(zzhbo2);
            }
        }
        zzhbo zzhbo5 = zzhbo;
        zzgyx.zzt = zzhbo;
    }

    public static void zzr(int i, List list, zzhcc zzhcc, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzhcc.zzc(i, list, z);
        }
    }

    public static void zzs(int i, List list, zzhcc zzhcc) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzhcc.zze(i, list);
        }
    }

    public static void zzt(int i, List list, zzhcc zzhcc, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzhcc.zzg(i, list, z);
        }
    }

    public static void zzu(int i, List list, zzhcc zzhcc, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzhcc.zzj(i, list, z);
        }
    }

    public static void zzv(int i, List list, zzhcc zzhcc, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzhcc.zzl(i, list, z);
        }
    }

    public static void zzw(int i, List list, zzhcc zzhcc, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzhcc.zzn(i, list, z);
        }
    }

    public static void zzx(int i, List list, zzhcc zzhcc, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzhcc.zzp(i, list, z);
        }
    }

    public static void zzy(int i, List list, zzhcc zzhcc, zzhbb zzhbb) throws IOException {
        if (list != null && !list.isEmpty()) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                ((zzgyd) zzhcc).zzq(i, list.get(i2), zzhbb);
            }
        }
    }

    public static void zzz(int i, List list, zzhcc zzhcc, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzhcc.zzs(i, list, z);
        }
    }
}
