package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
final class zzgym {
    private static final zzgym zzb = new zzgym(true);
    final zzhbj zza = new zzhbe();
    private boolean zzc;
    private boolean zzd;

    private zzgym() {
    }

    static int zza(zzhca zzhca, int i, Object obj) {
        int zzD = zzgyc.zzD(i << 3);
        if (zzhca == zzhca.GROUP) {
            zzhai zzhai = (zzhai) obj;
            byte[] bArr = zzgzk.zzb;
            if (!(zzhai instanceof zzgwz)) {
                zzD += zzD;
            } else {
                zzgwz zzgwz = (zzgwz) zzhai;
                throw null;
            }
        }
        return zzD + zzb(zzhca, obj);
    }

    static int zzb(zzhca zzhca, Object obj) {
        int zzd2;
        int zzD;
        zzhca zzhca2 = zzhca.DOUBLE;
        zzhcb zzhcb = zzhcb.INT;
        switch (zzhca.ordinal()) {
            case 0:
                ((Double) obj).doubleValue();
                int i = zzgyc.zzf;
                return 8;
            case 1:
                ((Float) obj).floatValue();
                int i2 = zzgyc.zzf;
                return 4;
            case 2:
                return zzgyc.zzE(((Long) obj).longValue());
            case 3:
                return zzgyc.zzE(((Long) obj).longValue());
            case 4:
                return zzgyc.zzE((long) ((Integer) obj).intValue());
            case 5:
                ((Long) obj).longValue();
                int i3 = zzgyc.zzf;
                return 8;
            case 6:
                ((Integer) obj).intValue();
                int i4 = zzgyc.zzf;
                return 4;
            case 7:
                ((Boolean) obj).booleanValue();
                int i5 = zzgyc.zzf;
                return 1;
            case 8:
                if (obj instanceof zzgxp) {
                    int i6 = zzgyc.zzf;
                    zzd2 = ((zzgxp) obj).zzd();
                    zzD = zzgyc.zzD(zzd2);
                    break;
                } else {
                    return zzgyc.zzC((String) obj);
                }
            case 9:
                int i7 = zzgyc.zzf;
                return ((zzhai) obj).zzaY();
            case 10:
                if (obj instanceof zzgzs) {
                    int i8 = zzgyc.zzf;
                    zzd2 = ((zzgzs) obj).zza();
                    zzD = zzgyc.zzD(zzd2);
                    break;
                } else {
                    return zzgyc.zzz((zzhai) obj);
                }
            case 11:
                if (!(obj instanceof zzgxp)) {
                    int i9 = zzgyc.zzf;
                    zzd2 = ((byte[]) obj).length;
                    zzD = zzgyc.zzD(zzd2);
                    break;
                } else {
                    int i10 = zzgyc.zzf;
                    zzd2 = ((zzgxp) obj).zzd();
                    zzD = zzgyc.zzD(zzd2);
                    break;
                }
            case 12:
                return zzgyc.zzD(((Integer) obj).intValue());
            case 13:
                if (obj instanceof zzgzb) {
                    return zzgyc.zzE((long) ((zzgzb) obj).zza());
                }
                return zzgyc.zzE((long) ((Integer) obj).intValue());
            case 14:
                ((Integer) obj).intValue();
                int i11 = zzgyc.zzf;
                return 4;
            case 15:
                ((Long) obj).longValue();
                int i12 = zzgyc.zzf;
                return 8;
            case 16:
                int intValue = ((Integer) obj).intValue();
                return zzgyc.zzD((intValue >> 31) ^ (intValue + intValue));
            case 17:
                long longValue = ((Long) obj).longValue();
                return zzgyc.zzE((longValue >> 63) ^ (longValue + longValue));
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
        return zzD + zzd2;
    }

    public static int zzc(zzgyl zzgyl, Object obj) {
        zzhca zzb2 = zzgyl.zzb();
        int zza2 = zzgyl.zza();
        if (!zzgyl.zze()) {
            return zza(zzb2, zza2, obj);
        }
        List list = (List) obj;
        int size = list.size();
        int i = 0;
        if (!zzgyl.zzd()) {
            int i2 = 0;
            while (i < size) {
                i2 += zza(zzb2, zza2, list.get(i));
                i++;
            }
            return i2;
        } else if (list.isEmpty()) {
            return 0;
        } else {
            int i3 = 0;
            while (i < size) {
                i3 += zzb(zzb2, list.get(i));
                i++;
            }
            return zzgyc.zzD(zza2 << 3) + i3 + zzgyc.zzD(i3);
        }
    }

    public static zzgym zze() {
        return zzb;
    }

    private static boolean zzj(Map.Entry entry) {
        zzgyl zzgyl = (zzgyl) entry.getKey();
        if (zzgyl.zzc() != zzhcb.MESSAGE) {
            return true;
        }
        if (!zzgyl.zze()) {
            return zzk(entry.getValue());
        }
        List list = (List) entry.getValue();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (!zzk(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    private static boolean zzk(Object obj) {
        if (obj instanceof zzhaj) {
            return ((zzhaj) obj).zzbw();
        }
        if (obj instanceof zzgzs) {
            return true;
        }
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
    }

    private static final int zzl(Map.Entry entry) {
        int i;
        int zzD;
        int zzD2;
        zzgyl zzgyl = (zzgyl) entry.getKey();
        Object value = entry.getValue();
        if (zzgyl.zzc() != zzhcb.MESSAGE || zzgyl.zze() || zzgyl.zzd()) {
            return zzc(zzgyl, value);
        }
        if (value instanceof zzgzs) {
            int zza2 = ((zzgyl) entry.getKey()).zza();
            int zzD3 = zzgyc.zzD(8);
            i = zzD3 + zzD3;
            zzD = zzgyc.zzD(16) + zzgyc.zzD(zza2);
            int zzD4 = zzgyc.zzD(24);
            int zza3 = ((zzgzs) value).zza();
            zzD2 = zzD4 + zzgyc.zzD(zza3) + zza3;
        } else {
            int zza4 = ((zzgyl) entry.getKey()).zza();
            int zzD5 = zzgyc.zzD(8);
            i = zzD5 + zzD5;
            zzD = zzgyc.zzD(16) + zzgyc.zzD(zza4);
            zzD2 = zzgyc.zzD(24) + zzgyc.zzz((zzhai) value);
        }
        return i + zzD + zzD2;
    }

    private static final void zzm(zzgyl zzgyl, Object obj) {
        boolean z;
        zzhca zzb2 = zzgyl.zzb();
        byte[] bArr = zzgzk.zzb;
        obj.getClass();
        zzhca zzhca = zzhca.DOUBLE;
        zzhcb zzhcb = zzhcb.INT;
        switch (zzb2.zza().ordinal()) {
            case 0:
                z = obj instanceof Integer;
                break;
            case 1:
                z = obj instanceof Long;
                break;
            case 2:
                z = obj instanceof Float;
                break;
            case 3:
                z = obj instanceof Double;
                break;
            case 4:
                z = obj instanceof Boolean;
                break;
            case 5:
                z = obj instanceof String;
                break;
            case 6:
                if ((obj instanceof zzgxp) || (obj instanceof byte[])) {
                    return;
                }
            case 7:
                if ((obj instanceof Integer) || (obj instanceof zzgzb)) {
                    return;
                }
            case 8:
                if ((obj instanceof zzhai) || (obj instanceof zzgzs)) {
                    return;
                }
        }
        if (z) {
            return;
        }
        throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", new Object[]{Integer.valueOf(zzgyl.zza()), zzgyl.zzb().zza(), obj.getClass().getName()}));
    }

    public final /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzgym zzgym = new zzgym();
        int zzc2 = this.zza.zzc();
        for (int i = 0; i < zzc2; i++) {
            Map.Entry zzg = this.zza.zzg(i);
            zzgym.zzh((zzgyl) ((zzhbf) zzg).zza(), zzg.getValue());
        }
        for (Map.Entry entry : this.zza.zzd()) {
            zzgym.zzh((zzgyl) entry.getKey(), entry.getValue());
        }
        zzgym.zzd = this.zzd;
        return zzgym;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzgym)) {
            return false;
        }
        return this.zza.equals(((zzgym) obj).zza);
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final int zzd() {
        int zzc2 = this.zza.zzc();
        int i = 0;
        for (int i2 = 0; i2 < zzc2; i2++) {
            i += zzl(this.zza.zzg(i2));
        }
        for (Map.Entry zzl : this.zza.zzd()) {
            i += zzl(zzl);
        }
        return i;
    }

    public final Iterator zzf() {
        if (this.zza.isEmpty()) {
            return Collections.emptyIterator();
        }
        if (this.zzd) {
            return new zzgzq(this.zza.entrySet().iterator());
        }
        return this.zza.entrySet().iterator();
    }

    public final void zzg() {
        if (!this.zzc) {
            int zzc2 = this.zza.zzc();
            for (int i = 0; i < zzc2; i++) {
                Object value = this.zza.zzg(i).getValue();
                if (value instanceof zzgyx) {
                    ((zzgyx) value).zzbW();
                }
            }
            for (Map.Entry value2 : this.zza.zzd()) {
                Object value3 = value2.getValue();
                if (value3 instanceof zzgyx) {
                    ((zzgyx) value3).zzbW();
                }
            }
            this.zza.zza();
            this.zzc = true;
        }
    }

    public final void zzh(zzgyl zzgyl, Object obj) {
        if (!zzgyl.zze()) {
            zzm(zzgyl, obj);
        } else if (obj instanceof List) {
            List list = (List) obj;
            int size = list.size();
            ArrayList arrayList = new ArrayList(size);
            for (int i = 0; i < size; i++) {
                Object obj2 = list.get(i);
                zzm(zzgyl, obj2);
                arrayList.add(obj2);
            }
            obj = arrayList;
        } else {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
        if (obj instanceof zzgzs) {
            this.zzd = true;
        }
        this.zza.put(zzgyl, obj);
    }

    public final boolean zzi() {
        int zzc2 = this.zza.zzc();
        for (int i = 0; i < zzc2; i++) {
            if (!zzj(this.zza.zzg(i))) {
                return false;
            }
        }
        for (Map.Entry zzj : this.zza.zzd()) {
            if (!zzj(zzj)) {
                return false;
            }
        }
        return true;
    }

    private zzgym(boolean z) {
        zzg();
        zzg();
    }
}
