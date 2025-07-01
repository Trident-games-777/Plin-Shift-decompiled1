package com.google.android.gms.internal.ads;

import androidx.constraintlayout.widget.ConstraintLayout;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import sun.misc.Unsafe;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
final class zzhal<T> implements zzhbb<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzhbu.zzi();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzhai zzg;
    private final boolean zzh;
    private final boolean zzi;
    private final int[] zzj;
    private final int zzk;
    private final int zzl;
    private final zzhbn zzm;
    private final zzgyi zzn;

    private zzhal(int[] iArr, Object[] objArr, int i, int i2, zzhai zzhai, boolean z, int[] iArr2, int i3, int i4, zzhao zzhao, zzgzv zzgzv, zzhbn zzhbn, zzgyi zzgyi, zzhad zzhad) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i;
        this.zzf = i2;
        this.zzi = zzhai instanceof zzgyx;
        boolean z2 = false;
        if (zzgyi != null && (zzhai instanceof zzgyt)) {
            z2 = true;
        }
        this.zzh = z2;
        this.zzj = iArr2;
        this.zzk = i3;
        this.zzl = i4;
        this.zzm = zzhbn;
        this.zzn = zzgyi;
        this.zzg = zzhai;
    }

    private final Object zzA(Object obj, int i) {
        zzhbb zzx = zzx(i);
        int zzu = zzu(i) & 1048575;
        if (!zzN(obj, i)) {
            return zzx.zze();
        }
        Object object = zzb.getObject(obj, (long) zzu);
        if (zzQ(object)) {
            return object;
        }
        Object zze2 = zzx.zze();
        if (object != null) {
            zzx.zzg(zze2, object);
        }
        return zze2;
    }

    private final Object zzB(Object obj, int i, int i2) {
        zzhbb zzx = zzx(i2);
        if (!zzR(obj, i, i2)) {
            return zzx.zze();
        }
        Object object = zzb.getObject(obj, (long) (zzu(i2) & 1048575));
        if (zzQ(object)) {
            return object;
        }
        Object zze2 = zzx.zze();
        if (object != null) {
            zzx.zzg(zze2, object);
        }
        return zze2;
    }

    private static Field zzC(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            throw new RuntimeException("Field " + str + " for " + cls.getName() + " not found. Known fields are " + Arrays.toString(declaredFields));
        }
    }

    private static void zzD(Object obj) {
        if (!zzQ(obj)) {
            throw new IllegalArgumentException("Mutating immutable message: ".concat(String.valueOf(String.valueOf(obj))));
        }
    }

    private final void zzE(Object obj, Object obj2, int i) {
        if (zzN(obj2, i)) {
            Unsafe unsafe = zzb;
            long zzu = (long) (zzu(i) & 1048575);
            Object object = unsafe.getObject(obj2, zzu);
            if (object != null) {
                zzhbb zzx = zzx(i);
                if (!zzN(obj, i)) {
                    if (!zzQ(object)) {
                        unsafe.putObject(obj, zzu, object);
                    } else {
                        Object zze2 = zzx.zze();
                        zzx.zzg(zze2, object);
                        unsafe.putObject(obj, zzu, zze2);
                    }
                    zzH(obj, i);
                    return;
                }
                Object object2 = unsafe.getObject(obj, zzu);
                if (!zzQ(object2)) {
                    Object zze3 = zzx.zze();
                    zzx.zzg(zze3, object2);
                    unsafe.putObject(obj, zzu, zze3);
                    object2 = zze3;
                }
                zzx.zzg(object2, object);
                return;
            }
            int i2 = this.zzc[i];
            String obj3 = obj2.toString();
            throw new IllegalStateException("Source subfield " + i2 + " is present but null: " + obj3);
        }
    }

    private final void zzF(Object obj, Object obj2, int i) {
        int i2 = this.zzc[i];
        if (zzR(obj2, i2, i)) {
            Unsafe unsafe = zzb;
            long zzu = (long) (zzu(i) & 1048575);
            Object object = unsafe.getObject(obj2, zzu);
            if (object != null) {
                zzhbb zzx = zzx(i);
                if (!zzR(obj, i2, i)) {
                    if (!zzQ(object)) {
                        unsafe.putObject(obj, zzu, object);
                    } else {
                        Object zze2 = zzx.zze();
                        zzx.zzg(zze2, object);
                        unsafe.putObject(obj, zzu, zze2);
                    }
                    zzI(obj, i2, i);
                    return;
                }
                Object object2 = unsafe.getObject(obj, zzu);
                if (!zzQ(object2)) {
                    Object zze3 = zzx.zze();
                    zzx.zzg(zze3, object2);
                    unsafe.putObject(obj, zzu, zze3);
                    object2 = zze3;
                }
                zzx.zzg(object2, object);
                return;
            }
            int i3 = this.zzc[i];
            String obj3 = obj2.toString();
            throw new IllegalStateException("Source subfield " + i3 + " is present but null: " + obj3);
        }
    }

    private final void zzG(Object obj, int i, zzhav zzhav) throws IOException {
        long j = (long) (i & 1048575);
        if (zzM(i)) {
            zzhbu.zzv(obj, j, zzhav.zzs());
        } else if (this.zzi) {
            zzhbu.zzv(obj, j, zzhav.zzr());
        } else {
            zzhbu.zzv(obj, j, zzhav.zzp());
        }
    }

    private final void zzH(Object obj, int i) {
        int zzr = zzr(i);
        long j = (long) (1048575 & zzr);
        if (j != 1048575) {
            zzhbu.zzt(obj, j, (1 << (zzr >>> 20)) | zzhbu.zzd(obj, j));
        }
    }

    private final void zzI(Object obj, int i, int i2) {
        zzhbu.zzt(obj, (long) (zzr(i2) & 1048575), i);
    }

    private final void zzJ(Object obj, int i, Object obj2) {
        zzb.putObject(obj, (long) (zzu(i) & 1048575), obj2);
        zzH(obj, i);
    }

    private final void zzK(Object obj, int i, int i2, Object obj2) {
        zzb.putObject(obj, (long) (zzu(i2) & 1048575), obj2);
        zzI(obj, i, i2);
    }

    private final boolean zzL(Object obj, Object obj2, int i) {
        return zzN(obj, i) == zzN(obj2, i);
    }

    private static boolean zzM(int i) {
        return (i & 536870912) != 0;
    }

    private final boolean zzN(Object obj, int i) {
        int zzr = zzr(i);
        long j = (long) (zzr & 1048575);
        if (j == 1048575) {
            int zzu = zzu(i);
            long j2 = (long) (zzu & 1048575);
            switch (zzt(zzu)) {
                case 0:
                    return Double.doubleToRawLongBits(zzhbu.zzb(obj, j2)) != 0;
                case 1:
                    return Float.floatToRawIntBits(zzhbu.zzc(obj, j2)) != 0;
                case 2:
                    return zzhbu.zzf(obj, j2) != 0;
                case 3:
                    return zzhbu.zzf(obj, j2) != 0;
                case 4:
                    return zzhbu.zzd(obj, j2) != 0;
                case 5:
                    return zzhbu.zzf(obj, j2) != 0;
                case 6:
                    return zzhbu.zzd(obj, j2) != 0;
                case 7:
                    return zzhbu.zzz(obj, j2);
                case 8:
                    Object zzh2 = zzhbu.zzh(obj, j2);
                    if (zzh2 instanceof String) {
                        return !((String) zzh2).isEmpty();
                    }
                    if (zzh2 instanceof zzgxp) {
                        return !zzgxp.zzb.equals(zzh2);
                    }
                    throw new IllegalArgumentException();
                case 9:
                    return zzhbu.zzh(obj, j2) != null;
                case 10:
                    return !zzgxp.zzb.equals(zzhbu.zzh(obj, j2));
                case 11:
                    return zzhbu.zzd(obj, j2) != 0;
                case 12:
                    return zzhbu.zzd(obj, j2) != 0;
                case 13:
                    return zzhbu.zzd(obj, j2) != 0;
                case 14:
                    return zzhbu.zzf(obj, j2) != 0;
                case 15:
                    return zzhbu.zzd(obj, j2) != 0;
                case 16:
                    return zzhbu.zzf(obj, j2) != 0;
                case 17:
                    return zzhbu.zzh(obj, j2) != null;
                default:
                    throw new IllegalArgumentException();
            }
        } else {
            return (zzhbu.zzd(obj, j) & (1 << (zzr >>> 20))) != 0;
        }
    }

    private final boolean zzO(Object obj, int i, int i2, int i3, int i4) {
        if (i2 == 1048575) {
            return zzN(obj, i);
        }
        return (i3 & i4) != 0;
    }

    private static boolean zzP(Object obj, int i, zzhbb zzhbb) {
        return zzhbb.zzl(zzhbu.zzh(obj, (long) (i & 1048575)));
    }

    private static boolean zzQ(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof zzgyx) {
            return ((zzgyx) obj).zzcf();
        }
        return true;
    }

    private final boolean zzR(Object obj, int i, int i2) {
        return zzhbu.zzd(obj, (long) (zzr(i2) & 1048575)) == i;
    }

    private static boolean zzS(Object obj, long j) {
        return ((Boolean) zzhbu.zzh(obj, j)).booleanValue();
    }

    private static final void zzT(int i, Object obj, zzhcc zzhcc) throws IOException {
        if (obj instanceof String) {
            zzhcc.zzG(i, (String) obj);
        } else {
            zzhcc.zzd(i, (zzgxp) obj);
        }
    }

    static zzhbo zzd(Object obj) {
        zzgyx zzgyx = (zzgyx) obj;
        zzhbo zzhbo = zzgyx.zzt;
        if (zzhbo != zzhbo.zzc()) {
            return zzhbo;
        }
        zzhbo zzf2 = zzhbo.zzf();
        zzgyx.zzt = zzf2;
        return zzf2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:122:0x026d  */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x0270  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x028a  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x028d  */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x0352  */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x03a3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static com.google.android.gms.internal.ads.zzhal zzm(java.lang.Class r32, com.google.android.gms.internal.ads.zzhaf r33, com.google.android.gms.internal.ads.zzhao r34, com.google.android.gms.internal.ads.zzgzv r35, com.google.android.gms.internal.ads.zzhbn r36, com.google.android.gms.internal.ads.zzgyi r37, com.google.android.gms.internal.ads.zzhad r38) {
        /*
            r0 = r33
            boolean r1 = r0 instanceof com.google.android.gms.internal.ads.zzhau
            if (r1 == 0) goto L_0x040f
            com.google.android.gms.internal.ads.zzhau r0 = (com.google.android.gms.internal.ads.zzhau) r0
            java.lang.String r1 = r0.zzd()
            int r2 = r1.length()
            r3 = 0
            char r4 = r1.charAt(r3)
            r5 = 55296(0xd800, float:7.7486E-41)
            if (r4 < r5) goto L_0x0025
            r4 = 1
        L_0x001b:
            int r7 = r4 + 1
            char r4 = r1.charAt(r4)
            if (r4 < r5) goto L_0x0026
            r4 = r7
            goto L_0x001b
        L_0x0025:
            r7 = 1
        L_0x0026:
            int r4 = r7 + 1
            char r7 = r1.charAt(r7)
            if (r7 < r5) goto L_0x0045
            r7 = r7 & 8191(0x1fff, float:1.1478E-41)
            r9 = 13
        L_0x0032:
            int r10 = r4 + 1
            char r4 = r1.charAt(r4)
            if (r4 < r5) goto L_0x0042
            r4 = r4 & 8191(0x1fff, float:1.1478E-41)
            int r4 = r4 << r9
            r7 = r7 | r4
            int r9 = r9 + 13
            r4 = r10
            goto L_0x0032
        L_0x0042:
            int r4 = r4 << r9
            r7 = r7 | r4
            r4 = r10
        L_0x0045:
            if (r7 != 0) goto L_0x0056
            int[] r7 = zza
            r9 = r3
            r10 = r9
            r11 = r10
            r12 = r11
            r13 = r12
            r17 = r13
            r16 = r7
            r7 = r17
            goto L_0x016a
        L_0x0056:
            int r7 = r4 + 1
            char r4 = r1.charAt(r4)
            if (r4 < r5) goto L_0x0075
            r4 = r4 & 8191(0x1fff, float:1.1478E-41)
            r9 = 13
        L_0x0062:
            int r10 = r7 + 1
            char r7 = r1.charAt(r7)
            if (r7 < r5) goto L_0x0072
            r7 = r7 & 8191(0x1fff, float:1.1478E-41)
            int r7 = r7 << r9
            r4 = r4 | r7
            int r9 = r9 + 13
            r7 = r10
            goto L_0x0062
        L_0x0072:
            int r7 = r7 << r9
            r4 = r4 | r7
            r7 = r10
        L_0x0075:
            int r9 = r7 + 1
            char r7 = r1.charAt(r7)
            if (r7 < r5) goto L_0x0094
            r7 = r7 & 8191(0x1fff, float:1.1478E-41)
            r10 = 13
        L_0x0081:
            int r11 = r9 + 1
            char r9 = r1.charAt(r9)
            if (r9 < r5) goto L_0x0091
            r9 = r9 & 8191(0x1fff, float:1.1478E-41)
            int r9 = r9 << r10
            r7 = r7 | r9
            int r10 = r10 + 13
            r9 = r11
            goto L_0x0081
        L_0x0091:
            int r9 = r9 << r10
            r7 = r7 | r9
            r9 = r11
        L_0x0094:
            int r10 = r9 + 1
            char r9 = r1.charAt(r9)
            if (r9 < r5) goto L_0x00b3
            r9 = r9 & 8191(0x1fff, float:1.1478E-41)
            r11 = 13
        L_0x00a0:
            int r12 = r10 + 1
            char r10 = r1.charAt(r10)
            if (r10 < r5) goto L_0x00b0
            r10 = r10 & 8191(0x1fff, float:1.1478E-41)
            int r10 = r10 << r11
            r9 = r9 | r10
            int r11 = r11 + 13
            r10 = r12
            goto L_0x00a0
        L_0x00b0:
            int r10 = r10 << r11
            r9 = r9 | r10
            r10 = r12
        L_0x00b3:
            int r11 = r10 + 1
            char r10 = r1.charAt(r10)
            if (r10 < r5) goto L_0x00d2
            r10 = r10 & 8191(0x1fff, float:1.1478E-41)
            r12 = 13
        L_0x00bf:
            int r13 = r11 + 1
            char r11 = r1.charAt(r11)
            if (r11 < r5) goto L_0x00cf
            r11 = r11 & 8191(0x1fff, float:1.1478E-41)
            int r11 = r11 << r12
            r10 = r10 | r11
            int r12 = r12 + 13
            r11 = r13
            goto L_0x00bf
        L_0x00cf:
            int r11 = r11 << r12
            r10 = r10 | r11
            r11 = r13
        L_0x00d2:
            int r12 = r11 + 1
            char r11 = r1.charAt(r11)
            if (r11 < r5) goto L_0x00f1
            r11 = r11 & 8191(0x1fff, float:1.1478E-41)
            r13 = 13
        L_0x00de:
            int r14 = r12 + 1
            char r12 = r1.charAt(r12)
            if (r12 < r5) goto L_0x00ee
            r12 = r12 & 8191(0x1fff, float:1.1478E-41)
            int r12 = r12 << r13
            r11 = r11 | r12
            int r13 = r13 + 13
            r12 = r14
            goto L_0x00de
        L_0x00ee:
            int r12 = r12 << r13
            r11 = r11 | r12
            r12 = r14
        L_0x00f1:
            int r13 = r12 + 1
            char r12 = r1.charAt(r12)
            if (r12 < r5) goto L_0x0110
            r12 = r12 & 8191(0x1fff, float:1.1478E-41)
            r14 = 13
        L_0x00fd:
            int r15 = r13 + 1
            char r13 = r1.charAt(r13)
            if (r13 < r5) goto L_0x010d
            r13 = r13 & 8191(0x1fff, float:1.1478E-41)
            int r13 = r13 << r14
            r12 = r12 | r13
            int r14 = r14 + 13
            r13 = r15
            goto L_0x00fd
        L_0x010d:
            int r13 = r13 << r14
            r12 = r12 | r13
            r13 = r15
        L_0x0110:
            int r14 = r13 + 1
            char r13 = r1.charAt(r13)
            if (r13 < r5) goto L_0x0131
            r13 = r13 & 8191(0x1fff, float:1.1478E-41)
            r15 = 13
        L_0x011c:
            int r16 = r14 + 1
            char r14 = r1.charAt(r14)
            if (r14 < r5) goto L_0x012d
            r14 = r14 & 8191(0x1fff, float:1.1478E-41)
            int r14 = r14 << r15
            r13 = r13 | r14
            int r15 = r15 + 13
            r14 = r16
            goto L_0x011c
        L_0x012d:
            int r14 = r14 << r15
            r13 = r13 | r14
            r14 = r16
        L_0x0131:
            int r15 = r14 + 1
            char r14 = r1.charAt(r14)
            if (r14 < r5) goto L_0x0154
            r14 = r14 & 8191(0x1fff, float:1.1478E-41)
            r16 = 13
        L_0x013d:
            int r17 = r15 + 1
            char r15 = r1.charAt(r15)
            if (r15 < r5) goto L_0x014f
            r15 = r15 & 8191(0x1fff, float:1.1478E-41)
            int r15 = r15 << r16
            r14 = r14 | r15
            int r16 = r16 + 13
            r15 = r17
            goto L_0x013d
        L_0x014f:
            int r15 = r15 << r16
            r14 = r14 | r15
            r15 = r17
        L_0x0154:
            int r16 = r14 + r12
            int r13 = r16 + r13
            int r16 = r4 + r4
            int r16 = r16 + r7
            int[] r7 = new int[r13]
            r13 = r12
            r12 = r9
            r9 = r13
            r13 = r10
            r17 = r14
            r10 = r16
            r16 = r7
            r7 = r4
            r4 = r15
        L_0x016a:
            sun.misc.Unsafe r14 = zzb
            java.lang.Object[] r15 = r0.zze()
            com.google.android.gms.internal.ads.zzhai r18 = r0.zza()
            java.lang.Class r3 = r18.getClass()
            int r18 = r17 + r9
            int r9 = r11 + r11
            int r11 = r11 * 3
            int[] r11 = new int[r11]
            java.lang.Object[] r9 = new java.lang.Object[r9]
            r21 = r17
            r22 = r18
            r19 = 0
            r20 = 0
        L_0x018a:
            if (r4 >= r2) goto L_0x03f5
            int r23 = r4 + 1
            char r4 = r1.charAt(r4)
            if (r4 < r5) goto L_0x01b2
            r4 = r4 & 8191(0x1fff, float:1.1478E-41)
            r8 = r23
            r23 = 13
        L_0x019a:
            int r24 = r8 + 1
            char r8 = r1.charAt(r8)
            if (r8 < r5) goto L_0x01ac
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            int r8 = r8 << r23
            r4 = r4 | r8
            int r23 = r23 + 13
            r8 = r24
            goto L_0x019a
        L_0x01ac:
            int r8 = r8 << r23
            r4 = r4 | r8
            r8 = r24
            goto L_0x01b4
        L_0x01b2:
            r8 = r23
        L_0x01b4:
            int r23 = r8 + 1
            char r8 = r1.charAt(r8)
            if (r8 < r5) goto L_0x01da
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            r6 = r23
            r23 = 13
        L_0x01c2:
            int r25 = r6 + 1
            char r6 = r1.charAt(r6)
            if (r6 < r5) goto L_0x01d4
            r6 = r6 & 8191(0x1fff, float:1.1478E-41)
            int r6 = r6 << r23
            r8 = r8 | r6
            int r23 = r23 + 13
            r6 = r25
            goto L_0x01c2
        L_0x01d4:
            int r6 = r6 << r23
            r8 = r8 | r6
            r6 = r25
            goto L_0x01dc
        L_0x01da:
            r6 = r23
        L_0x01dc:
            r5 = r8 & 1024(0x400, float:1.435E-42)
            if (r5 == 0) goto L_0x01e6
            int r5 = r19 + 1
            r16[r19] = r20
            r19 = r5
        L_0x01e6:
            r5 = r8 & 255(0xff, float:3.57E-43)
            r25 = r0
            r0 = r8 & 2048(0x800, float:2.87E-42)
            r26 = r0
            r0 = 51
            if (r5 < r0) goto L_0x02a7
            int r0 = r6 + 1
            char r6 = r1.charAt(r6)
            r27 = r0
            r0 = 55296(0xd800, float:7.7486E-41)
            if (r6 < r0) goto L_0x0226
            r6 = r6 & 8191(0x1fff, float:1.1478E-41)
            r30 = r27
            r27 = r6
            r6 = r30
            r30 = 13
        L_0x0209:
            int r31 = r6 + 1
            char r6 = r1.charAt(r6)
            if (r6 < r0) goto L_0x021f
            r0 = r6 & 8191(0x1fff, float:1.1478E-41)
            int r0 = r0 << r30
            r27 = r27 | r0
            int r30 = r30 + 13
            r6 = r31
            r0 = 55296(0xd800, float:7.7486E-41)
            goto L_0x0209
        L_0x021f:
            int r0 = r6 << r30
            r6 = r27 | r0
            r0 = r31
            goto L_0x0228
        L_0x0226:
            r0 = r27
        L_0x0228:
            r27 = r0
            int r0 = r5 + -51
            r30 = r2
            r2 = 9
            if (r0 == r2) goto L_0x0254
            r2 = 17
            if (r0 != r2) goto L_0x0237
            goto L_0x0254
        L_0x0237:
            r2 = 12
            if (r0 != r2) goto L_0x0262
            int r0 = r25.zzc()
            r2 = 1
            if (r0 == r2) goto L_0x0247
            if (r26 == 0) goto L_0x0245
            goto L_0x0247
        L_0x0245:
            r0 = 0
            goto L_0x0264
        L_0x0247:
            int r0 = r10 + 1
            int r24 = r20 / 3
            int r24 = r24 + r24
            int r24 = r24 + 1
            r10 = r15[r10]
            r9[r24] = r10
            goto L_0x0261
        L_0x0254:
            r2 = 1
            int r0 = r10 + 1
            int r24 = r20 / 3
            int r24 = r24 + r24
            int r28 = r24 + 1
            r2 = r15[r10]
            r9[r28] = r2
        L_0x0261:
            r10 = r0
        L_0x0262:
            r0 = r26
        L_0x0264:
            int r6 = r6 + r6
            r2 = r15[r6]
            r26 = r0
            boolean r0 = r2 instanceof java.lang.reflect.Field
            if (r0 == 0) goto L_0x0270
            java.lang.reflect.Field r2 = (java.lang.reflect.Field) r2
            goto L_0x0278
        L_0x0270:
            java.lang.String r2 = (java.lang.String) r2
            java.lang.reflect.Field r2 = zzC(r3, r2)
            r15[r6] = r2
        L_0x0278:
            r28 = r6
            r0 = r7
            long r6 = r14.objectFieldOffset(r2)
            int r2 = (int) r6
            int r6 = r28 + 1
            r7 = r15[r6]
            r31 = r0
            boolean r0 = r7 instanceof java.lang.reflect.Field
            if (r0 == 0) goto L_0x028d
            java.lang.reflect.Field r7 = (java.lang.reflect.Field) r7
            goto L_0x0295
        L_0x028d:
            java.lang.String r7 = (java.lang.String) r7
            java.lang.reflect.Field r7 = zzC(r3, r7)
            r15[r6] = r7
        L_0x0295:
            long r6 = r14.objectFieldOffset(r7)
            int r0 = (int) r6
            r28 = r0
            r7 = r1
            r0 = r26
            r6 = r27
            r1 = 0
            r23 = 55296(0xd800, float:7.7486E-41)
            goto L_0x03b9
        L_0x02a7:
            r30 = r2
            r31 = r7
            int r0 = r10 + 1
            r2 = r15[r10]
            java.lang.String r2 = (java.lang.String) r2
            java.lang.reflect.Field r2 = zzC(r3, r2)
            r7 = 9
            if (r5 == r7) goto L_0x0332
            r7 = 17
            if (r5 != r7) goto L_0x02bf
            goto L_0x0332
        L_0x02bf:
            r7 = 27
            if (r5 == r7) goto L_0x0323
            r7 = 49
            if (r5 != r7) goto L_0x02ce
            int r10 = r10 + 2
            r28 = r0
            r0 = 1
            goto L_0x0328
        L_0x02ce:
            r7 = 12
            if (r5 == r7) goto L_0x0306
            r7 = 30
            if (r5 == r7) goto L_0x0306
            r7 = 44
            if (r5 != r7) goto L_0x02db
            goto L_0x0306
        L_0x02db:
            r7 = 50
            if (r5 != r7) goto L_0x0302
            int r7 = r10 + 2
            int r28 = r21 + 1
            r16[r21] = r20
            int r21 = r20 / 3
            r0 = r15[r0]
            int r21 = r21 + r21
            r9[r21] = r0
            if (r26 == 0) goto L_0x02fc
            int r21 = r21 + 1
            int r0 = r10 + 3
            r7 = r15[r7]
            r9[r21] = r7
            r10 = r0
            r7 = r1
            r21 = r28
            goto L_0x0342
        L_0x02fc:
            r10 = r7
            r21 = r28
            r26 = 0
            goto L_0x0330
        L_0x0302:
            r28 = r0
            r0 = 1
            goto L_0x033f
        L_0x0306:
            int r7 = r25.zzc()
            r28 = r0
            r0 = 1
            if (r7 == r0) goto L_0x0318
            if (r26 == 0) goto L_0x0312
            goto L_0x0318
        L_0x0312:
            r7 = r1
            r10 = r28
            r26 = 0
            goto L_0x0342
        L_0x0318:
            int r10 = r10 + 2
            int r7 = r20 / 3
            int r7 = r7 + r7
            int r7 = r7 + r0
            r24 = r15[r28]
            r9[r7] = r24
            goto L_0x0330
        L_0x0323:
            r28 = r0
            r0 = 1
            int r10 = r10 + 2
        L_0x0328:
            int r7 = r20 / 3
            int r7 = r7 + r7
            int r7 = r7 + r0
            r24 = r15[r28]
            r9[r7] = r24
        L_0x0330:
            r7 = r1
            goto L_0x0342
        L_0x0332:
            r28 = r0
            r0 = 1
            int r7 = r20 / 3
            int r7 = r7 + r7
            int r7 = r7 + r0
            java.lang.Class r10 = r2.getType()
            r9[r7] = r10
        L_0x033f:
            r7 = r1
            r10 = r28
        L_0x0342:
            long r0 = r14.objectFieldOffset(r2)
            int r2 = (int) r0
            r0 = r8 & 4096(0x1000, float:5.74E-42)
            r1 = 1048575(0xfffff, float:1.469367E-39)
            if (r0 == 0) goto L_0x03a3
            r0 = 17
            if (r5 > r0) goto L_0x03a3
            int r0 = r6 + 1
            char r1 = r7.charAt(r6)
            r6 = 55296(0xd800, float:7.7486E-41)
            if (r1 < r6) goto L_0x0377
            r1 = r1 & 8191(0x1fff, float:1.1478E-41)
            r23 = 13
        L_0x0361:
            int r28 = r0 + 1
            char r0 = r7.charAt(r0)
            if (r0 < r6) goto L_0x0373
            r0 = r0 & 8191(0x1fff, float:1.1478E-41)
            int r0 = r0 << r23
            r1 = r1 | r0
            int r23 = r23 + 13
            r0 = r28
            goto L_0x0361
        L_0x0373:
            int r0 = r0 << r23
            r1 = r1 | r0
            goto L_0x0379
        L_0x0377:
            r28 = r0
        L_0x0379:
            int r0 = r31 + r31
            int r23 = r1 / 32
            int r0 = r0 + r23
            r6 = r15[r0]
            r29 = r0
            boolean r0 = r6 instanceof java.lang.reflect.Field
            if (r0 == 0) goto L_0x038a
            java.lang.reflect.Field r6 = (java.lang.reflect.Field) r6
            goto L_0x0392
        L_0x038a:
            java.lang.String r6 = (java.lang.String) r6
            java.lang.reflect.Field r6 = zzC(r3, r6)
            r15[r29] = r6
        L_0x0392:
            r29 = r1
            long r0 = r14.objectFieldOffset(r6)
            int r0 = (int) r0
            int r1 = r29 % 32
            r6 = r28
            r23 = 55296(0xd800, float:7.7486E-41)
            r28 = r0
            goto L_0x03a9
        L_0x03a3:
            r23 = 55296(0xd800, float:7.7486E-41)
            r28 = r1
            r1 = 0
        L_0x03a9:
            r0 = 18
            if (r5 < r0) goto L_0x03b7
            r0 = 49
            if (r5 > r0) goto L_0x03b7
            int r0 = r22 + 1
            r16[r22] = r2
            r22 = r0
        L_0x03b7:
            r0 = r26
        L_0x03b9:
            int r26 = r20 + 1
            r11[r20] = r4
            int r4 = r20 + 2
            r27 = r0
            r0 = r8 & 512(0x200, float:7.175E-43)
            if (r0 == 0) goto L_0x03c8
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x03c9
        L_0x03c8:
            r0 = 0
        L_0x03c9:
            r8 = r8 & 256(0x100, float:3.59E-43)
            if (r8 == 0) goto L_0x03d0
            r8 = 268435456(0x10000000, float:2.5243549E-29)
            goto L_0x03d1
        L_0x03d0:
            r8 = 0
        L_0x03d1:
            if (r27 == 0) goto L_0x03d6
            r27 = -2147483648(0xffffffff80000000, float:-0.0)
            goto L_0x03d8
        L_0x03d6:
            r27 = 0
        L_0x03d8:
            int r5 = r5 << 20
            r0 = r0 | r8
            r0 = r0 | r27
            r0 = r0 | r5
            r0 = r0 | r2
            r11[r26] = r0
            int r20 = r20 + 3
            int r0 = r1 << 20
            r0 = r0 | r28
            r11[r4] = r0
            r4 = r6
            r1 = r7
            r5 = r23
            r0 = r25
            r2 = r30
            r7 = r31
            goto L_0x018a
        L_0x03f5:
            r25 = r0
            com.google.android.gms.internal.ads.zzhal r0 = new com.google.android.gms.internal.ads.zzhal
            com.google.android.gms.internal.ads.zzhai r14 = r25.zza()
            r15 = 0
            r19 = r34
            r20 = r35
            r21 = r36
            r22 = r37
            r23 = r38
            r10 = r11
            r11 = r9
            r9 = r0
            r9.<init>(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23)
            return r9
        L_0x040f:
            com.google.android.gms.internal.ads.zzhbk r0 = (com.google.android.gms.internal.ads.zzhbk) r0
            r0 = 0
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzhal.zzm(java.lang.Class, com.google.android.gms.internal.ads.zzhaf, com.google.android.gms.internal.ads.zzhao, com.google.android.gms.internal.ads.zzgzv, com.google.android.gms.internal.ads.zzhbn, com.google.android.gms.internal.ads.zzgyi, com.google.android.gms.internal.ads.zzhad):com.google.android.gms.internal.ads.zzhal");
    }

    private static double zzn(Object obj, long j) {
        return ((Double) zzhbu.zzh(obj, j)).doubleValue();
    }

    private static float zzo(Object obj, long j) {
        return ((Float) zzhbu.zzh(obj, j)).floatValue();
    }

    private static int zzp(Object obj, long j) {
        return ((Integer) zzhbu.zzh(obj, j)).intValue();
    }

    private final int zzq(int i) {
        if (i < this.zze || i > this.zzf) {
            return -1;
        }
        return zzs(i, 0);
    }

    private final int zzr(int i) {
        return this.zzc[i + 2];
    }

    private final int zzs(int i, int i2) {
        int length = (this.zzc.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int i5 = this.zzc[i4];
            if (i == i5) {
                return i4;
            }
            if (i < i5) {
                length = i3 - 1;
            } else {
                i2 = i3 + 1;
            }
        }
        return -1;
    }

    private static int zzt(int i) {
        return (i >>> 20) & 255;
    }

    private final int zzu(int i) {
        return this.zzc[i + 1];
    }

    private static long zzv(Object obj, long j) {
        return ((Long) zzhbu.zzh(obj, j)).longValue();
    }

    private final zzgzd zzw(int i) {
        int i2 = i / 3;
        return (zzgzd) this.zzd[i2 + i2 + 1];
    }

    private final zzhbb zzx(int i) {
        Object[] objArr = this.zzd;
        int i2 = i / 3;
        int i3 = i2 + i2;
        zzhbb zzhbb = (zzhbb) objArr[i3];
        if (zzhbb != null) {
            return zzhbb;
        }
        zzhbb zzb2 = zzhas.zza().zzb((Class) objArr[i3 + 1]);
        this.zzd[i3] = zzb2;
        return zzb2;
    }

    private final Object zzy(Object obj, int i, Object obj2, zzhbn zzhbn, Object obj3) {
        int i2 = this.zzc[i];
        Object zzh2 = zzhbu.zzh(obj, (long) (zzu(i) & 1048575));
        if (zzh2 == null || zzw(i) == null) {
            return obj2;
        }
        zzhac zzhac = (zzhac) zzh2;
        zzhab zzhab = (zzhab) zzz(i);
        throw null;
    }

    private final Object zzz(int i) {
        int i2 = i / 3;
        return this.zzd[i2 + i2];
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x0376, code lost:
        r8 = (r8 + r9) + r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x0378, code lost:
        r9 = r14 + r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x0397, code lost:
        r8 = r8 * r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:200:0x054c, code lost:
        r9 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:202:0x055e, code lost:
        r9 = r9 + r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:205:0x0576, code lost:
        r9 = r14 + r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:230:0x0630, code lost:
        r0 = r0 + (r8 + r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:249:0x06a0, code lost:
        r0 = r0 + 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:259:0x06e5, code lost:
        r0 = r0 + r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:263:0x06f4, code lost:
        r0 = r0 + 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:264:0x06f6, code lost:
        r9 = r14 + r0;
        r0 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:265:0x06fb, code lost:
        r0 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:270:0x0711, code lost:
        r2 = r2 + 3;
        r1 = r18;
        r8 = 1048575;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0103, code lost:
        r5 = r5 + (r9 + r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x01ad, code lost:
        r5 = r5 + r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x01bc, code lost:
        r5 = r5 + 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x01cc, code lost:
        r5 = r5 + 8;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zza(java.lang.Object r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            sun.misc.Unsafe r6 = zzb
            r7 = 0
            r8 = 1048575(0xfffff, float:1.469367E-39)
            r2 = r7
            r4 = r2
            r9 = r4
            r3 = r8
        L_0x000e:
            int[] r5 = r0.zzc
            int r5 = r5.length
            if (r2 >= r5) goto L_0x071a
            int r5 = r0.zzu(r2)
            int r10 = zzt(r5)
            int[] r11 = r0.zzc
            int r12 = r2 + 2
            r13 = r11[r2]
            r11 = r11[r12]
            r12 = r11 & r8
            r14 = 17
            r15 = 1
            if (r10 > r14) goto L_0x003c
            if (r12 == r3) goto L_0x0037
            if (r12 != r8) goto L_0x0030
            r3 = r7
            goto L_0x0035
        L_0x0030:
            long r3 = (long) r12
            int r3 = r6.getInt(r1, r3)
        L_0x0035:
            r4 = r3
            r3 = r12
        L_0x0037:
            int r11 = r11 >>> 20
            int r11 = r15 << r11
            goto L_0x003d
        L_0x003c:
            r11 = r7
        L_0x003d:
            r5 = r5 & r8
            com.google.android.gms.internal.ads.zzgyn r12 = com.google.android.gms.internal.ads.zzgyn.DOUBLE_LIST_PACKED
            int r12 = r12.zza()
            if (r10 < r12) goto L_0x004b
            com.google.android.gms.internal.ads.zzgyn r12 = com.google.android.gms.internal.ads.zzgyn.SINT64_LIST_PACKED
            r12.zza()
        L_0x004b:
            r14 = r9
            long r8 = (long) r5
            r16 = 63
            switch(r10) {
                case 0: goto L_0x06fe;
                case 1: goto L_0x06e7;
                case 2: goto L_0x06d0;
                case 3: goto L_0x06ba;
                case 4: goto L_0x06a3;
                case 5: goto L_0x0693;
                case 6: goto L_0x0685;
                case 7: goto L_0x0675;
                case 8: goto L_0x0649;
                case 9: goto L_0x0634;
                case 10: goto L_0x0615;
                case 11: goto L_0x05fe;
                case 12: goto L_0x05e6;
                case 13: goto L_0x05d7;
                case 14: goto L_0x05c8;
                case 15: goto L_0x05ac;
                case 16: goto L_0x0590;
                case 17: goto L_0x057a;
                case 18: goto L_0x056c;
                case 19: goto L_0x0561;
                case 20: goto L_0x053e;
                case 21: goto L_0x0522;
                case 22: goto L_0x0506;
                case 23: goto L_0x04fa;
                case 24: goto L_0x04ee;
                case 25: goto L_0x04d4;
                case 26: goto L_0x0473;
                case 27: goto L_0x0432;
                case 28: goto L_0x0400;
                case 29: goto L_0x03e6;
                case 30: goto L_0x03cc;
                case 31: goto L_0x03c0;
                case 32: goto L_0x03b4;
                case 33: goto L_0x039a;
                case 34: goto L_0x037c;
                case 35: goto L_0x0360;
                case 36: goto L_0x0349;
                case 37: goto L_0x0332;
                case 38: goto L_0x031b;
                case 39: goto L_0x0304;
                case 40: goto L_0x02ec;
                case 41: goto L_0x02d4;
                case 42: goto L_0x02ba;
                case 43: goto L_0x02a2;
                case 44: goto L_0x028a;
                case 45: goto L_0x0272;
                case 46: goto L_0x025a;
                case 47: goto L_0x0242;
                case 48: goto L_0x022a;
                case 49: goto L_0x0200;
                case 50: goto L_0x01d0;
                case 51: goto L_0x01c0;
                case 52: goto L_0x01b0;
                case 53: goto L_0x0199;
                case 54: goto L_0x0184;
                case 55: goto L_0x016e;
                case 56: goto L_0x0161;
                case 57: goto L_0x0154;
                case 58: goto L_0x0145;
                case 59: goto L_0x011b;
                case 60: goto L_0x0107;
                case 61: goto L_0x00e9;
                case 62: goto L_0x00d3;
                case 63: goto L_0x00bc;
                case 64: goto L_0x00ae;
                case 65: goto L_0x00a0;
                case 66: goto L_0x0085;
                case 67: goto L_0x006a;
                case 68: goto L_0x0054;
                default: goto L_0x0052;
            }
        L_0x0052:
            goto L_0x0710
        L_0x0054:
            boolean r5 = r0.zzR(r1, r13, r2)
            if (r5 == 0) goto L_0x0710
            java.lang.Object r5 = r6.getObject(r1, r8)
            com.google.android.gms.internal.ads.zzhai r5 = (com.google.android.gms.internal.ads.zzhai) r5
            com.google.android.gms.internal.ads.zzhbb r8 = r0.zzx(r2)
            int r5 = com.google.android.gms.internal.ads.zzgyc.zzy(r13, r5, r8)
            goto L_0x0576
        L_0x006a:
            boolean r5 = r0.zzR(r1, r13, r2)
            if (r5 == 0) goto L_0x0710
            int r5 = r13 << 3
            long r8 = zzv(r1, r8)
            long r10 = r8 + r8
            long r8 = r8 >> r16
            int r5 = com.google.android.gms.internal.ads.zzgyc.zzD(r5)
            long r8 = r8 ^ r10
            int r8 = com.google.android.gms.internal.ads.zzgyc.zzE(r8)
            goto L_0x01ad
        L_0x0085:
            boolean r5 = r0.zzR(r1, r13, r2)
            if (r5 == 0) goto L_0x0710
            int r5 = r13 << 3
            int r8 = zzp(r1, r8)
            int r9 = r8 + r8
            int r8 = r8 >> 31
            int r5 = com.google.android.gms.internal.ads.zzgyc.zzD(r5)
            r8 = r8 ^ r9
            int r8 = com.google.android.gms.internal.ads.zzgyc.zzD(r8)
            goto L_0x01ad
        L_0x00a0:
            boolean r5 = r0.zzR(r1, r13, r2)
            if (r5 == 0) goto L_0x0710
            int r5 = r13 << 3
            int r5 = com.google.android.gms.internal.ads.zzgyc.zzD(r5)
            goto L_0x01cc
        L_0x00ae:
            boolean r5 = r0.zzR(r1, r13, r2)
            if (r5 == 0) goto L_0x0710
            int r5 = r13 << 3
            int r5 = com.google.android.gms.internal.ads.zzgyc.zzD(r5)
            goto L_0x01bc
        L_0x00bc:
            boolean r5 = r0.zzR(r1, r13, r2)
            if (r5 == 0) goto L_0x0710
            int r5 = r13 << 3
            int r8 = zzp(r1, r8)
            long r8 = (long) r8
            int r5 = com.google.android.gms.internal.ads.zzgyc.zzD(r5)
            int r8 = com.google.android.gms.internal.ads.zzgyc.zzE(r8)
            goto L_0x01ad
        L_0x00d3:
            boolean r5 = r0.zzR(r1, r13, r2)
            if (r5 == 0) goto L_0x0710
            int r5 = r13 << 3
            int r8 = zzp(r1, r8)
            int r5 = com.google.android.gms.internal.ads.zzgyc.zzD(r5)
            int r8 = com.google.android.gms.internal.ads.zzgyc.zzD(r8)
            goto L_0x01ad
        L_0x00e9:
            boolean r5 = r0.zzR(r1, r13, r2)
            if (r5 == 0) goto L_0x0710
            int r5 = r13 << 3
            java.lang.Object r8 = r6.getObject(r1, r8)
            com.google.android.gms.internal.ads.zzgxp r8 = (com.google.android.gms.internal.ads.zzgxp) r8
            int r5 = com.google.android.gms.internal.ads.zzgyc.zzD(r5)
            int r8 = r8.zzd()
            int r9 = com.google.android.gms.internal.ads.zzgyc.zzD(r8)
        L_0x0103:
            int r9 = r9 + r8
            int r5 = r5 + r9
            goto L_0x0576
        L_0x0107:
            boolean r5 = r0.zzR(r1, r13, r2)
            if (r5 == 0) goto L_0x0710
            java.lang.Object r5 = r6.getObject(r1, r8)
            com.google.android.gms.internal.ads.zzhbb r8 = r0.zzx(r2)
            int r5 = com.google.android.gms.internal.ads.zzhbd.zzh(r13, r5, r8)
            goto L_0x0576
        L_0x011b:
            boolean r5 = r0.zzR(r1, r13, r2)
            if (r5 == 0) goto L_0x0710
            int r5 = r13 << 3
            java.lang.Object r8 = r6.getObject(r1, r8)
            boolean r9 = r8 instanceof com.google.android.gms.internal.ads.zzgxp
            if (r9 == 0) goto L_0x013a
            com.google.android.gms.internal.ads.zzgxp r8 = (com.google.android.gms.internal.ads.zzgxp) r8
            int r5 = com.google.android.gms.internal.ads.zzgyc.zzD(r5)
            int r8 = r8.zzd()
            int r9 = com.google.android.gms.internal.ads.zzgyc.zzD(r8)
            goto L_0x0103
        L_0x013a:
            java.lang.String r8 = (java.lang.String) r8
            int r5 = com.google.android.gms.internal.ads.zzgyc.zzD(r5)
            int r8 = com.google.android.gms.internal.ads.zzgyc.zzC(r8)
            goto L_0x01ad
        L_0x0145:
            boolean r5 = r0.zzR(r1, r13, r2)
            if (r5 == 0) goto L_0x0710
            int r5 = r13 << 3
            int r5 = com.google.android.gms.internal.ads.zzgyc.zzD(r5)
            int r5 = r5 + r15
            goto L_0x0576
        L_0x0154:
            boolean r5 = r0.zzR(r1, r13, r2)
            if (r5 == 0) goto L_0x0710
            int r5 = r13 << 3
            int r5 = com.google.android.gms.internal.ads.zzgyc.zzD(r5)
            goto L_0x01bc
        L_0x0161:
            boolean r5 = r0.zzR(r1, r13, r2)
            if (r5 == 0) goto L_0x0710
            int r5 = r13 << 3
            int r5 = com.google.android.gms.internal.ads.zzgyc.zzD(r5)
            goto L_0x01cc
        L_0x016e:
            boolean r5 = r0.zzR(r1, r13, r2)
            if (r5 == 0) goto L_0x0710
            int r5 = r13 << 3
            int r8 = zzp(r1, r8)
            long r8 = (long) r8
            int r5 = com.google.android.gms.internal.ads.zzgyc.zzD(r5)
            int r8 = com.google.android.gms.internal.ads.zzgyc.zzE(r8)
            goto L_0x01ad
        L_0x0184:
            boolean r5 = r0.zzR(r1, r13, r2)
            if (r5 == 0) goto L_0x0710
            int r5 = r13 << 3
            long r8 = zzv(r1, r8)
            int r5 = com.google.android.gms.internal.ads.zzgyc.zzD(r5)
            int r8 = com.google.android.gms.internal.ads.zzgyc.zzE(r8)
            goto L_0x01ad
        L_0x0199:
            boolean r5 = r0.zzR(r1, r13, r2)
            if (r5 == 0) goto L_0x0710
            int r5 = r13 << 3
            long r8 = zzv(r1, r8)
            int r5 = com.google.android.gms.internal.ads.zzgyc.zzD(r5)
            int r8 = com.google.android.gms.internal.ads.zzgyc.zzE(r8)
        L_0x01ad:
            int r5 = r5 + r8
            goto L_0x0576
        L_0x01b0:
            boolean r5 = r0.zzR(r1, r13, r2)
            if (r5 == 0) goto L_0x0710
            int r5 = r13 << 3
            int r5 = com.google.android.gms.internal.ads.zzgyc.zzD(r5)
        L_0x01bc:
            int r5 = r5 + 4
            goto L_0x0576
        L_0x01c0:
            boolean r5 = r0.zzR(r1, r13, r2)
            if (r5 == 0) goto L_0x0710
            int r5 = r13 << 3
            int r5 = com.google.android.gms.internal.ads.zzgyc.zzD(r5)
        L_0x01cc:
            int r5 = r5 + 8
            goto L_0x0576
        L_0x01d0:
            java.lang.Object r5 = r6.getObject(r1, r8)
            java.lang.Object r8 = r0.zzz(r2)
            com.google.android.gms.internal.ads.zzhac r5 = (com.google.android.gms.internal.ads.zzhac) r5
            com.google.android.gms.internal.ads.zzhab r8 = (com.google.android.gms.internal.ads.zzhab) r8
            boolean r8 = r5.isEmpty()
            if (r8 != 0) goto L_0x0710
            java.util.Set r5 = r5.entrySet()
            java.util.Iterator r5 = r5.iterator()
            boolean r8 = r5.hasNext()
            if (r8 != 0) goto L_0x01f2
            goto L_0x0710
        L_0x01f2:
            java.lang.Object r1 = r5.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            r1.getKey()
            r1.getValue()
            r1 = 0
            throw r1
        L_0x0200:
            java.lang.Object r5 = r6.getObject(r1, r8)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.ads.zzhbb r8 = r0.zzx(r2)
            int r9 = com.google.android.gms.internal.ads.zzhbd.zza
            int r9 = r5.size()
            if (r9 != 0) goto L_0x0214
            r11 = r7
            goto L_0x0226
        L_0x0214:
            r10 = r7
            r11 = r10
        L_0x0216:
            if (r10 >= r9) goto L_0x0226
            java.lang.Object r15 = r5.get(r10)
            com.google.android.gms.internal.ads.zzhai r15 = (com.google.android.gms.internal.ads.zzhai) r15
            int r15 = com.google.android.gms.internal.ads.zzgyc.zzy(r13, r15, r8)
            int r11 = r11 + r15
            int r10 = r10 + 1
            goto L_0x0216
        L_0x0226:
            int r9 = r14 + r11
            goto L_0x0711
        L_0x022a:
            java.lang.Object r5 = r6.getObject(r1, r8)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.ads.zzhbd.zzj(r5)
            if (r5 <= 0) goto L_0x0710
            int r8 = r13 << 3
            int r8 = com.google.android.gms.internal.ads.zzgyc.zzD(r8)
            int r9 = com.google.android.gms.internal.ads.zzgyc.zzD(r5)
            goto L_0x0376
        L_0x0242:
            java.lang.Object r5 = r6.getObject(r1, r8)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.ads.zzhbd.zzi(r5)
            if (r5 <= 0) goto L_0x0710
            int r8 = r13 << 3
            int r8 = com.google.android.gms.internal.ads.zzgyc.zzD(r8)
            int r9 = com.google.android.gms.internal.ads.zzgyc.zzD(r5)
            goto L_0x0376
        L_0x025a:
            java.lang.Object r5 = r6.getObject(r1, r8)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.ads.zzhbd.zze(r5)
            if (r5 <= 0) goto L_0x0710
            int r8 = r13 << 3
            int r8 = com.google.android.gms.internal.ads.zzgyc.zzD(r8)
            int r9 = com.google.android.gms.internal.ads.zzgyc.zzD(r5)
            goto L_0x0376
        L_0x0272:
            java.lang.Object r5 = r6.getObject(r1, r8)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.ads.zzhbd.zzc(r5)
            if (r5 <= 0) goto L_0x0710
            int r8 = r13 << 3
            int r8 = com.google.android.gms.internal.ads.zzgyc.zzD(r8)
            int r9 = com.google.android.gms.internal.ads.zzgyc.zzD(r5)
            goto L_0x0376
        L_0x028a:
            java.lang.Object r5 = r6.getObject(r1, r8)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.ads.zzhbd.zza(r5)
            if (r5 <= 0) goto L_0x0710
            int r8 = r13 << 3
            int r8 = com.google.android.gms.internal.ads.zzgyc.zzD(r8)
            int r9 = com.google.android.gms.internal.ads.zzgyc.zzD(r5)
            goto L_0x0376
        L_0x02a2:
            java.lang.Object r5 = r6.getObject(r1, r8)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.ads.zzhbd.zzk(r5)
            if (r5 <= 0) goto L_0x0710
            int r8 = r13 << 3
            int r8 = com.google.android.gms.internal.ads.zzgyc.zzD(r8)
            int r9 = com.google.android.gms.internal.ads.zzgyc.zzD(r5)
            goto L_0x0376
        L_0x02ba:
            java.lang.Object r5 = r6.getObject(r1, r8)
            java.util.List r5 = (java.util.List) r5
            int r8 = com.google.android.gms.internal.ads.zzhbd.zza
            int r5 = r5.size()
            if (r5 <= 0) goto L_0x0710
            int r8 = r13 << 3
            int r8 = com.google.android.gms.internal.ads.zzgyc.zzD(r8)
            int r9 = com.google.android.gms.internal.ads.zzgyc.zzD(r5)
            goto L_0x0376
        L_0x02d4:
            java.lang.Object r5 = r6.getObject(r1, r8)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.ads.zzhbd.zzc(r5)
            if (r5 <= 0) goto L_0x0710
            int r8 = r13 << 3
            int r8 = com.google.android.gms.internal.ads.zzgyc.zzD(r8)
            int r9 = com.google.android.gms.internal.ads.zzgyc.zzD(r5)
            goto L_0x0376
        L_0x02ec:
            java.lang.Object r5 = r6.getObject(r1, r8)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.ads.zzhbd.zze(r5)
            if (r5 <= 0) goto L_0x0710
            int r8 = r13 << 3
            int r8 = com.google.android.gms.internal.ads.zzgyc.zzD(r8)
            int r9 = com.google.android.gms.internal.ads.zzgyc.zzD(r5)
            goto L_0x0376
        L_0x0304:
            java.lang.Object r5 = r6.getObject(r1, r8)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.ads.zzhbd.zzf(r5)
            if (r5 <= 0) goto L_0x0710
            int r8 = r13 << 3
            int r8 = com.google.android.gms.internal.ads.zzgyc.zzD(r8)
            int r9 = com.google.android.gms.internal.ads.zzgyc.zzD(r5)
            goto L_0x0376
        L_0x031b:
            java.lang.Object r5 = r6.getObject(r1, r8)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.ads.zzhbd.zzl(r5)
            if (r5 <= 0) goto L_0x0710
            int r8 = r13 << 3
            int r8 = com.google.android.gms.internal.ads.zzgyc.zzD(r8)
            int r9 = com.google.android.gms.internal.ads.zzgyc.zzD(r5)
            goto L_0x0376
        L_0x0332:
            java.lang.Object r5 = r6.getObject(r1, r8)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.ads.zzhbd.zzg(r5)
            if (r5 <= 0) goto L_0x0710
            int r8 = r13 << 3
            int r8 = com.google.android.gms.internal.ads.zzgyc.zzD(r8)
            int r9 = com.google.android.gms.internal.ads.zzgyc.zzD(r5)
            goto L_0x0376
        L_0x0349:
            java.lang.Object r5 = r6.getObject(r1, r8)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.ads.zzhbd.zzc(r5)
            if (r5 <= 0) goto L_0x0710
            int r8 = r13 << 3
            int r8 = com.google.android.gms.internal.ads.zzgyc.zzD(r8)
            int r9 = com.google.android.gms.internal.ads.zzgyc.zzD(r5)
            goto L_0x0376
        L_0x0360:
            java.lang.Object r5 = r6.getObject(r1, r8)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.ads.zzhbd.zze(r5)
            if (r5 <= 0) goto L_0x0710
            int r8 = r13 << 3
            int r8 = com.google.android.gms.internal.ads.zzgyc.zzD(r8)
            int r9 = com.google.android.gms.internal.ads.zzgyc.zzD(r5)
        L_0x0376:
            int r8 = r8 + r9
            int r8 = r8 + r5
        L_0x0378:
            int r9 = r14 + r8
            goto L_0x0711
        L_0x037c:
            java.lang.Object r5 = r6.getObject(r1, r8)
            java.util.List r5 = (java.util.List) r5
            int r8 = com.google.android.gms.internal.ads.zzhbd.zza
            int r8 = r5.size()
            if (r8 != 0) goto L_0x038d
        L_0x038a:
            r5 = r7
            goto L_0x0576
        L_0x038d:
            int r9 = r13 << 3
            int r5 = com.google.android.gms.internal.ads.zzhbd.zzj(r5)
            int r9 = com.google.android.gms.internal.ads.zzgyc.zzD(r9)
        L_0x0397:
            int r8 = r8 * r9
            goto L_0x01ad
        L_0x039a:
            java.lang.Object r5 = r6.getObject(r1, r8)
            java.util.List r5 = (java.util.List) r5
            int r8 = com.google.android.gms.internal.ads.zzhbd.zza
            int r8 = r5.size()
            if (r8 != 0) goto L_0x03a9
            goto L_0x038a
        L_0x03a9:
            int r9 = r13 << 3
            int r5 = com.google.android.gms.internal.ads.zzhbd.zzi(r5)
            int r9 = com.google.android.gms.internal.ads.zzgyc.zzD(r9)
            goto L_0x0397
        L_0x03b4:
            java.lang.Object r5 = r6.getObject(r1, r8)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.ads.zzhbd.zzd(r13, r5, r7)
            goto L_0x0576
        L_0x03c0:
            java.lang.Object r5 = r6.getObject(r1, r8)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.ads.zzhbd.zzb(r13, r5, r7)
            goto L_0x0576
        L_0x03cc:
            java.lang.Object r5 = r6.getObject(r1, r8)
            java.util.List r5 = (java.util.List) r5
            int r8 = com.google.android.gms.internal.ads.zzhbd.zza
            int r8 = r5.size()
            if (r8 != 0) goto L_0x03db
            goto L_0x038a
        L_0x03db:
            int r9 = r13 << 3
            int r5 = com.google.android.gms.internal.ads.zzhbd.zza(r5)
            int r9 = com.google.android.gms.internal.ads.zzgyc.zzD(r9)
            goto L_0x0397
        L_0x03e6:
            java.lang.Object r5 = r6.getObject(r1, r8)
            java.util.List r5 = (java.util.List) r5
            int r8 = com.google.android.gms.internal.ads.zzhbd.zza
            int r8 = r5.size()
            if (r8 != 0) goto L_0x03f5
            goto L_0x038a
        L_0x03f5:
            int r9 = r13 << 3
            int r5 = com.google.android.gms.internal.ads.zzhbd.zzk(r5)
            int r9 = com.google.android.gms.internal.ads.zzgyc.zzD(r9)
            goto L_0x0397
        L_0x0400:
            java.lang.Object r5 = r6.getObject(r1, r8)
            java.util.List r5 = (java.util.List) r5
            int r8 = com.google.android.gms.internal.ads.zzhbd.zza
            int r8 = r5.size()
            if (r8 != 0) goto L_0x0411
            r8 = r7
            goto L_0x0378
        L_0x0411:
            int r9 = r13 << 3
            int r9 = com.google.android.gms.internal.ads.zzgyc.zzD(r9)
            int r8 = r8 * r9
            r9 = r7
        L_0x0419:
            int r10 = r5.size()
            if (r9 >= r10) goto L_0x0378
            java.lang.Object r10 = r5.get(r9)
            com.google.android.gms.internal.ads.zzgxp r10 = (com.google.android.gms.internal.ads.zzgxp) r10
            int r10 = r10.zzd()
            int r11 = com.google.android.gms.internal.ads.zzgyc.zzD(r10)
            int r11 = r11 + r10
            int r8 = r8 + r11
            int r9 = r9 + 1
            goto L_0x0419
        L_0x0432:
            java.lang.Object r5 = r6.getObject(r1, r8)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.ads.zzhbb r8 = r0.zzx(r2)
            int r9 = com.google.android.gms.internal.ads.zzhbd.zza
            int r9 = r5.size()
            if (r9 != 0) goto L_0x0446
            r10 = r7
            goto L_0x046f
        L_0x0446:
            int r10 = r13 << 3
            int r10 = com.google.android.gms.internal.ads.zzgyc.zzD(r10)
            int r10 = r10 * r9
            r11 = r7
        L_0x044e:
            if (r11 >= r9) goto L_0x046f
            java.lang.Object r13 = r5.get(r11)
            boolean r15 = r13 instanceof com.google.android.gms.internal.ads.zzgzt
            if (r15 == 0) goto L_0x0465
            com.google.android.gms.internal.ads.zzgzt r13 = (com.google.android.gms.internal.ads.zzgzt) r13
            int r13 = r13.zza()
            int r15 = com.google.android.gms.internal.ads.zzgyc.zzD(r13)
            int r15 = r15 + r13
            int r10 = r10 + r15
            goto L_0x046c
        L_0x0465:
            com.google.android.gms.internal.ads.zzhai r13 = (com.google.android.gms.internal.ads.zzhai) r13
            int r13 = com.google.android.gms.internal.ads.zzgyc.zzA(r13, r8)
            int r10 = r10 + r13
        L_0x046c:
            int r11 = r11 + 1
            goto L_0x044e
        L_0x046f:
            int r9 = r14 + r10
            goto L_0x0711
        L_0x0473:
            java.lang.Object r5 = r6.getObject(r1, r8)
            java.util.List r5 = (java.util.List) r5
            int r8 = com.google.android.gms.internal.ads.zzhbd.zza
            int r8 = r5.size()
            if (r8 != 0) goto L_0x0483
            goto L_0x054c
        L_0x0483:
            int r9 = r13 << 3
            int r9 = com.google.android.gms.internal.ads.zzgyc.zzD(r9)
            int r9 = r9 * r8
            boolean r10 = r5 instanceof com.google.android.gms.internal.ads.zzgzu
            if (r10 == 0) goto L_0x04b2
            com.google.android.gms.internal.ads.zzgzu r5 = (com.google.android.gms.internal.ads.zzgzu) r5
            r10 = r7
        L_0x0491:
            if (r10 >= r8) goto L_0x055e
            java.lang.Object r11 = r5.zzc()
            boolean r13 = r11 instanceof com.google.android.gms.internal.ads.zzgxp
            if (r13 == 0) goto L_0x04a8
            com.google.android.gms.internal.ads.zzgxp r11 = (com.google.android.gms.internal.ads.zzgxp) r11
            int r11 = r11.zzd()
            int r13 = com.google.android.gms.internal.ads.zzgyc.zzD(r11)
            int r13 = r13 + r11
            int r9 = r9 + r13
            goto L_0x04af
        L_0x04a8:
            java.lang.String r11 = (java.lang.String) r11
            int r11 = com.google.android.gms.internal.ads.zzgyc.zzC(r11)
            int r9 = r9 + r11
        L_0x04af:
            int r10 = r10 + 1
            goto L_0x0491
        L_0x04b2:
            r10 = r7
        L_0x04b3:
            if (r10 >= r8) goto L_0x055e
            java.lang.Object r11 = r5.get(r10)
            boolean r13 = r11 instanceof com.google.android.gms.internal.ads.zzgxp
            if (r13 == 0) goto L_0x04ca
            com.google.android.gms.internal.ads.zzgxp r11 = (com.google.android.gms.internal.ads.zzgxp) r11
            int r11 = r11.zzd()
            int r13 = com.google.android.gms.internal.ads.zzgyc.zzD(r11)
            int r13 = r13 + r11
            int r9 = r9 + r13
            goto L_0x04d1
        L_0x04ca:
            java.lang.String r11 = (java.lang.String) r11
            int r11 = com.google.android.gms.internal.ads.zzgyc.zzC(r11)
            int r9 = r9 + r11
        L_0x04d1:
            int r10 = r10 + 1
            goto L_0x04b3
        L_0x04d4:
            java.lang.Object r5 = r6.getObject(r1, r8)
            java.util.List r5 = (java.util.List) r5
            int r8 = com.google.android.gms.internal.ads.zzhbd.zza
            int r5 = r5.size()
            if (r5 != 0) goto L_0x04e4
            goto L_0x038a
        L_0x04e4:
            int r8 = r13 << 3
            int r8 = com.google.android.gms.internal.ads.zzgyc.zzD(r8)
            int r8 = r8 + r15
            int r5 = r5 * r8
            goto L_0x0576
        L_0x04ee:
            java.lang.Object r5 = r6.getObject(r1, r8)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.ads.zzhbd.zzb(r13, r5, r7)
            goto L_0x0576
        L_0x04fa:
            java.lang.Object r5 = r6.getObject(r1, r8)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.ads.zzhbd.zzd(r13, r5, r7)
            goto L_0x0576
        L_0x0506:
            java.lang.Object r5 = r6.getObject(r1, r8)
            java.util.List r5 = (java.util.List) r5
            int r8 = com.google.android.gms.internal.ads.zzhbd.zza
            int r8 = r5.size()
            if (r8 != 0) goto L_0x0516
            goto L_0x038a
        L_0x0516:
            int r9 = r13 << 3
            int r5 = com.google.android.gms.internal.ads.zzhbd.zzf(r5)
            int r9 = com.google.android.gms.internal.ads.zzgyc.zzD(r9)
            goto L_0x0397
        L_0x0522:
            java.lang.Object r5 = r6.getObject(r1, r8)
            java.util.List r5 = (java.util.List) r5
            int r8 = com.google.android.gms.internal.ads.zzhbd.zza
            int r8 = r5.size()
            if (r8 != 0) goto L_0x0532
            goto L_0x038a
        L_0x0532:
            int r9 = r13 << 3
            int r5 = com.google.android.gms.internal.ads.zzhbd.zzl(r5)
            int r9 = com.google.android.gms.internal.ads.zzgyc.zzD(r9)
            goto L_0x0397
        L_0x053e:
            java.lang.Object r5 = r6.getObject(r1, r8)
            java.util.List r5 = (java.util.List) r5
            int r8 = com.google.android.gms.internal.ads.zzhbd.zza
            int r8 = r5.size()
            if (r8 != 0) goto L_0x054e
        L_0x054c:
            r9 = r7
            goto L_0x055e
        L_0x054e:
            int r8 = r13 << 3
            int r9 = com.google.android.gms.internal.ads.zzhbd.zzg(r5)
            int r5 = r5.size()
            int r8 = com.google.android.gms.internal.ads.zzgyc.zzD(r8)
            int r5 = r5 * r8
            int r9 = r9 + r5
        L_0x055e:
            int r9 = r9 + r14
            goto L_0x0711
        L_0x0561:
            java.lang.Object r5 = r6.getObject(r1, r8)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.ads.zzhbd.zzb(r13, r5, r7)
            goto L_0x0576
        L_0x056c:
            java.lang.Object r5 = r6.getObject(r1, r8)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.ads.zzhbd.zzd(r13, r5, r7)
        L_0x0576:
            int r9 = r14 + r5
            goto L_0x0711
        L_0x057a:
            r5 = r11
            boolean r5 = r0.zzO(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x0710
            java.lang.Object r5 = r6.getObject(r1, r8)
            com.google.android.gms.internal.ads.zzhai r5 = (com.google.android.gms.internal.ads.zzhai) r5
            com.google.android.gms.internal.ads.zzhbb r8 = r0.zzx(r2)
            int r5 = com.google.android.gms.internal.ads.zzgyc.zzy(r13, r5, r8)
            goto L_0x0576
        L_0x0590:
            r5 = r11
            boolean r5 = r0.zzO(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x06fb
            int r0 = r13 << 3
            long r8 = r6.getLong(r1, r8)
            long r10 = r8 + r8
            long r8 = r8 >> r16
            int r0 = com.google.android.gms.internal.ads.zzgyc.zzD(r0)
            long r8 = r8 ^ r10
            int r5 = com.google.android.gms.internal.ads.zzgyc.zzE(r8)
            goto L_0x06e5
        L_0x05ac:
            r5 = r11
            boolean r5 = r0.zzO(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x06fb
            int r0 = r13 << 3
            int r5 = r6.getInt(r1, r8)
            int r8 = r5 + r5
            int r5 = r5 >> 31
            int r0 = com.google.android.gms.internal.ads.zzgyc.zzD(r0)
            r5 = r5 ^ r8
            int r5 = com.google.android.gms.internal.ads.zzgyc.zzD(r5)
            goto L_0x06e5
        L_0x05c8:
            r5 = r11
            boolean r5 = r0.zzO(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x06fb
            int r0 = r13 << 3
            int r0 = com.google.android.gms.internal.ads.zzgyc.zzD(r0)
            goto L_0x06a0
        L_0x05d7:
            r5 = r11
            boolean r5 = r0.zzO(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x06fb
            int r0 = r13 << 3
            int r0 = com.google.android.gms.internal.ads.zzgyc.zzD(r0)
            goto L_0x06f4
        L_0x05e6:
            r5 = r11
            boolean r5 = r0.zzO(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x06fb
            int r0 = r13 << 3
            int r5 = r6.getInt(r1, r8)
            long r8 = (long) r5
            int r0 = com.google.android.gms.internal.ads.zzgyc.zzD(r0)
            int r5 = com.google.android.gms.internal.ads.zzgyc.zzE(r8)
            goto L_0x06e5
        L_0x05fe:
            r5 = r11
            boolean r5 = r0.zzO(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x06fb
            int r0 = r13 << 3
            int r5 = r6.getInt(r1, r8)
            int r0 = com.google.android.gms.internal.ads.zzgyc.zzD(r0)
            int r5 = com.google.android.gms.internal.ads.zzgyc.zzD(r5)
            goto L_0x06e5
        L_0x0615:
            r5 = r11
            boolean r5 = r0.zzO(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x06fb
            int r0 = r13 << 3
            java.lang.Object r5 = r6.getObject(r1, r8)
            com.google.android.gms.internal.ads.zzgxp r5 = (com.google.android.gms.internal.ads.zzgxp) r5
            int r0 = com.google.android.gms.internal.ads.zzgyc.zzD(r0)
            int r5 = r5.zzd()
            int r8 = com.google.android.gms.internal.ads.zzgyc.zzD(r5)
        L_0x0630:
            int r8 = r8 + r5
            int r0 = r0 + r8
            goto L_0x06f6
        L_0x0634:
            r5 = r11
            boolean r5 = r0.zzO(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x0710
            java.lang.Object r5 = r6.getObject(r1, r8)
            com.google.android.gms.internal.ads.zzhbb r8 = r0.zzx(r2)
            int r5 = com.google.android.gms.internal.ads.zzhbd.zzh(r13, r5, r8)
            goto L_0x0576
        L_0x0649:
            r5 = r11
            boolean r5 = r0.zzO(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x06fb
            int r0 = r13 << 3
            java.lang.Object r5 = r6.getObject(r1, r8)
            boolean r8 = r5 instanceof com.google.android.gms.internal.ads.zzgxp
            if (r8 == 0) goto L_0x0669
            com.google.android.gms.internal.ads.zzgxp r5 = (com.google.android.gms.internal.ads.zzgxp) r5
            int r0 = com.google.android.gms.internal.ads.zzgyc.zzD(r0)
            int r5 = r5.zzd()
            int r8 = com.google.android.gms.internal.ads.zzgyc.zzD(r5)
            goto L_0x0630
        L_0x0669:
            java.lang.String r5 = (java.lang.String) r5
            int r0 = com.google.android.gms.internal.ads.zzgyc.zzD(r0)
            int r5 = com.google.android.gms.internal.ads.zzgyc.zzC(r5)
            goto L_0x06e5
        L_0x0675:
            r5 = r11
            boolean r5 = r0.zzO(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x06fb
            int r0 = r13 << 3
            int r0 = com.google.android.gms.internal.ads.zzgyc.zzD(r0)
            int r0 = r0 + r15
            goto L_0x06f6
        L_0x0685:
            r5 = r11
            boolean r5 = r0.zzO(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x06fb
            int r0 = r13 << 3
            int r0 = com.google.android.gms.internal.ads.zzgyc.zzD(r0)
            goto L_0x06f4
        L_0x0693:
            r5 = r11
            boolean r5 = r0.zzO(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x06fb
            int r0 = r13 << 3
            int r0 = com.google.android.gms.internal.ads.zzgyc.zzD(r0)
        L_0x06a0:
            int r0 = r0 + 8
            goto L_0x06f6
        L_0x06a3:
            r5 = r11
            boolean r5 = r0.zzO(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x06fb
            int r0 = r13 << 3
            int r5 = r6.getInt(r1, r8)
            long r8 = (long) r5
            int r0 = com.google.android.gms.internal.ads.zzgyc.zzD(r0)
            int r5 = com.google.android.gms.internal.ads.zzgyc.zzE(r8)
            goto L_0x06e5
        L_0x06ba:
            r5 = r11
            boolean r5 = r0.zzO(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x06fb
            int r0 = r13 << 3
            long r8 = r6.getLong(r1, r8)
            int r0 = com.google.android.gms.internal.ads.zzgyc.zzD(r0)
            int r5 = com.google.android.gms.internal.ads.zzgyc.zzE(r8)
            goto L_0x06e5
        L_0x06d0:
            r5 = r11
            boolean r5 = r0.zzO(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x06fb
            int r0 = r13 << 3
            long r8 = r6.getLong(r1, r8)
            int r0 = com.google.android.gms.internal.ads.zzgyc.zzD(r0)
            int r5 = com.google.android.gms.internal.ads.zzgyc.zzE(r8)
        L_0x06e5:
            int r0 = r0 + r5
            goto L_0x06f6
        L_0x06e7:
            r5 = r11
            boolean r5 = r0.zzO(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x06fb
            int r0 = r13 << 3
            int r0 = com.google.android.gms.internal.ads.zzgyc.zzD(r0)
        L_0x06f4:
            int r0 = r0 + 4
        L_0x06f6:
            int r9 = r14 + r0
            r0 = r17
            goto L_0x0711
        L_0x06fb:
            r0 = r17
            goto L_0x0710
        L_0x06fe:
            r5 = r11
            boolean r5 = r0.zzO(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x0710
            int r1 = r13 << 3
            int r1 = com.google.android.gms.internal.ads.zzgyc.zzD(r1)
            int r1 = r1 + 8
            int r9 = r14 + r1
            goto L_0x0711
        L_0x0710:
            r9 = r14
        L_0x0711:
            int r2 = r2 + 3
            r1 = r18
            r8 = 1048575(0xfffff, float:1.469367E-39)
            goto L_0x000e
        L_0x071a:
            r14 = r9
            r1 = r18
            com.google.android.gms.internal.ads.zzgyx r1 = (com.google.android.gms.internal.ads.zzgyx) r1
            com.google.android.gms.internal.ads.zzhbo r1 = r1.zzt
            r2 = r1
            com.google.android.gms.internal.ads.zzhbo r2 = (com.google.android.gms.internal.ads.zzhbo) r2
            int r1 = r1.zza()
            int r9 = r14 + r1
            boolean r1 = r0.zzh
            if (r1 == 0) goto L_0x077f
            r1 = r18
            com.google.android.gms.internal.ads.zzgyt r1 = (com.google.android.gms.internal.ads.zzgyt) r1
            com.google.android.gms.internal.ads.zzgym r1 = r1.zza
            com.google.android.gms.internal.ads.zzhbj r2 = r1.zza
            int r2 = r2.zzc()
            r3 = r7
        L_0x073b:
            if (r7 >= r2) goto L_0x0758
            com.google.android.gms.internal.ads.zzhbj r4 = r1.zza
            java.util.Map$Entry r4 = r4.zzg(r7)
            r5 = r4
            com.google.android.gms.internal.ads.zzhbf r5 = (com.google.android.gms.internal.ads.zzhbf) r5
            java.lang.Comparable r5 = r5.zza()
            com.google.android.gms.internal.ads.zzgyl r5 = (com.google.android.gms.internal.ads.zzgyl) r5
            java.lang.Object r4 = r4.getValue()
            int r4 = com.google.android.gms.internal.ads.zzgym.zzc(r5, r4)
            int r3 = r3 + r4
            int r7 = r7 + 1
            goto L_0x073b
        L_0x0758:
            com.google.android.gms.internal.ads.zzhbj r1 = r1.zza
            java.lang.Iterable r1 = r1.zzd()
            java.util.Iterator r1 = r1.iterator()
        L_0x0762:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x077e
            java.lang.Object r2 = r1.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            java.lang.Object r4 = r2.getKey()
            com.google.android.gms.internal.ads.zzgyl r4 = (com.google.android.gms.internal.ads.zzgyl) r4
            java.lang.Object r2 = r2.getValue()
            int r2 = com.google.android.gms.internal.ads.zzgym.zzc(r4, r2)
            int r3 = r3 + r2
            goto L_0x0762
        L_0x077e:
            int r9 = r9 + r3
        L_0x077f:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzhal.zza(java.lang.Object):int");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x01b8, code lost:
        r1 = r1 + r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0212, code lost:
        r2 = (int) (r2 ^ (r2 >>> 32));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x0216, code lost:
        r1 = r1 + r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x0217, code lost:
        r0 = r0 + 3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzb(java.lang.Object r9) {
        /*
            r8 = this;
            r0 = 0
            r1 = r0
        L_0x0002:
            int[] r2 = r8.zzc
            int r2 = r2.length
            if (r0 >= r2) goto L_0x021b
            int r2 = r8.zzu(r0)
            int[] r3 = r8.zzc
            r4 = 1048575(0xfffff, float:1.469367E-39)
            r4 = r4 & r2
            int r2 = zzt(r2)
            r3 = r3[r0]
            long r4 = (long) r4
            r6 = 37
            r7 = 32
            switch(r2) {
                case 0: goto L_0x0206;
                case 1: goto L_0x01fb;
                case 2: goto L_0x01f2;
                case 3: goto L_0x01e9;
                case 4: goto L_0x01e2;
                case 5: goto L_0x01d9;
                case 6: goto L_0x01d2;
                case 7: goto L_0x01c7;
                case 8: goto L_0x01ba;
                case 9: goto L_0x01ac;
                case 10: goto L_0x01a0;
                case 11: goto L_0x0198;
                case 12: goto L_0x0190;
                case 13: goto L_0x0188;
                case 14: goto L_0x017e;
                case 15: goto L_0x0176;
                case 16: goto L_0x016c;
                case 17: goto L_0x015f;
                case 18: goto L_0x0153;
                case 19: goto L_0x0153;
                case 20: goto L_0x0153;
                case 21: goto L_0x0153;
                case 22: goto L_0x0153;
                case 23: goto L_0x0153;
                case 24: goto L_0x0153;
                case 25: goto L_0x0153;
                case 26: goto L_0x0153;
                case 27: goto L_0x0153;
                case 28: goto L_0x0153;
                case 29: goto L_0x0153;
                case 30: goto L_0x0153;
                case 31: goto L_0x0153;
                case 32: goto L_0x0153;
                case 33: goto L_0x0153;
                case 34: goto L_0x0153;
                case 35: goto L_0x0153;
                case 36: goto L_0x0153;
                case 37: goto L_0x0153;
                case 38: goto L_0x0153;
                case 39: goto L_0x0153;
                case 40: goto L_0x0153;
                case 41: goto L_0x0153;
                case 42: goto L_0x0153;
                case 43: goto L_0x0153;
                case 44: goto L_0x0153;
                case 45: goto L_0x0153;
                case 46: goto L_0x0153;
                case 47: goto L_0x0153;
                case 48: goto L_0x0153;
                case 49: goto L_0x0153;
                case 50: goto L_0x0147;
                case 51: goto L_0x0133;
                case 52: goto L_0x0121;
                case 53: goto L_0x0111;
                case 54: goto L_0x0101;
                case 55: goto L_0x00f3;
                case 56: goto L_0x00e3;
                case 57: goto L_0x00d5;
                case 58: goto L_0x00c3;
                case 59: goto L_0x00af;
                case 60: goto L_0x009d;
                case 61: goto L_0x008b;
                case 62: goto L_0x007d;
                case 63: goto L_0x006f;
                case 64: goto L_0x0061;
                case 65: goto L_0x0051;
                case 66: goto L_0x0043;
                case 67: goto L_0x0033;
                case 68: goto L_0x0021;
                default: goto L_0x001f;
            }
        L_0x001f:
            goto L_0x0217
        L_0x0021:
            boolean r2 = r8.zzR(r9, r3, r0)
            if (r2 == 0) goto L_0x0217
            int r1 = r1 * 53
            java.lang.Object r2 = com.google.android.gms.internal.ads.zzhbu.zzh(r9, r4)
            int r2 = r2.hashCode()
            goto L_0x0216
        L_0x0033:
            boolean r2 = r8.zzR(r9, r3, r0)
            if (r2 == 0) goto L_0x0217
            int r1 = r1 * 53
            long r2 = zzv(r9, r4)
            byte[] r4 = com.google.android.gms.internal.ads.zzgzk.zzb
            goto L_0x0212
        L_0x0043:
            boolean r2 = r8.zzR(r9, r3, r0)
            if (r2 == 0) goto L_0x0217
            int r1 = r1 * 53
            int r2 = zzp(r9, r4)
            goto L_0x0216
        L_0x0051:
            boolean r2 = r8.zzR(r9, r3, r0)
            if (r2 == 0) goto L_0x0217
            int r1 = r1 * 53
            long r2 = zzv(r9, r4)
            byte[] r4 = com.google.android.gms.internal.ads.zzgzk.zzb
            goto L_0x0212
        L_0x0061:
            boolean r2 = r8.zzR(r9, r3, r0)
            if (r2 == 0) goto L_0x0217
            int r1 = r1 * 53
            int r2 = zzp(r9, r4)
            goto L_0x0216
        L_0x006f:
            boolean r2 = r8.zzR(r9, r3, r0)
            if (r2 == 0) goto L_0x0217
            int r1 = r1 * 53
            int r2 = zzp(r9, r4)
            goto L_0x0216
        L_0x007d:
            boolean r2 = r8.zzR(r9, r3, r0)
            if (r2 == 0) goto L_0x0217
            int r1 = r1 * 53
            int r2 = zzp(r9, r4)
            goto L_0x0216
        L_0x008b:
            boolean r2 = r8.zzR(r9, r3, r0)
            if (r2 == 0) goto L_0x0217
            int r1 = r1 * 53
            java.lang.Object r2 = com.google.android.gms.internal.ads.zzhbu.zzh(r9, r4)
            int r2 = r2.hashCode()
            goto L_0x0216
        L_0x009d:
            boolean r2 = r8.zzR(r9, r3, r0)
            if (r2 == 0) goto L_0x0217
            int r1 = r1 * 53
            java.lang.Object r2 = com.google.android.gms.internal.ads.zzhbu.zzh(r9, r4)
            int r2 = r2.hashCode()
            goto L_0x0216
        L_0x00af:
            boolean r2 = r8.zzR(r9, r3, r0)
            if (r2 == 0) goto L_0x0217
            int r1 = r1 * 53
            java.lang.Object r2 = com.google.android.gms.internal.ads.zzhbu.zzh(r9, r4)
            java.lang.String r2 = (java.lang.String) r2
            int r2 = r2.hashCode()
            goto L_0x0216
        L_0x00c3:
            boolean r2 = r8.zzR(r9, r3, r0)
            if (r2 == 0) goto L_0x0217
            int r1 = r1 * 53
            boolean r2 = zzS(r9, r4)
            int r2 = com.google.android.gms.internal.ads.zzgzk.zza(r2)
            goto L_0x0216
        L_0x00d5:
            boolean r2 = r8.zzR(r9, r3, r0)
            if (r2 == 0) goto L_0x0217
            int r1 = r1 * 53
            int r2 = zzp(r9, r4)
            goto L_0x0216
        L_0x00e3:
            boolean r2 = r8.zzR(r9, r3, r0)
            if (r2 == 0) goto L_0x0217
            int r1 = r1 * 53
            long r2 = zzv(r9, r4)
            byte[] r4 = com.google.android.gms.internal.ads.zzgzk.zzb
            goto L_0x0212
        L_0x00f3:
            boolean r2 = r8.zzR(r9, r3, r0)
            if (r2 == 0) goto L_0x0217
            int r1 = r1 * 53
            int r2 = zzp(r9, r4)
            goto L_0x0216
        L_0x0101:
            boolean r2 = r8.zzR(r9, r3, r0)
            if (r2 == 0) goto L_0x0217
            int r1 = r1 * 53
            long r2 = zzv(r9, r4)
            byte[] r4 = com.google.android.gms.internal.ads.zzgzk.zzb
            goto L_0x0212
        L_0x0111:
            boolean r2 = r8.zzR(r9, r3, r0)
            if (r2 == 0) goto L_0x0217
            int r1 = r1 * 53
            long r2 = zzv(r9, r4)
            byte[] r4 = com.google.android.gms.internal.ads.zzgzk.zzb
            goto L_0x0212
        L_0x0121:
            boolean r2 = r8.zzR(r9, r3, r0)
            if (r2 == 0) goto L_0x0217
            int r1 = r1 * 53
            float r2 = zzo(r9, r4)
            int r2 = java.lang.Float.floatToIntBits(r2)
            goto L_0x0216
        L_0x0133:
            boolean r2 = r8.zzR(r9, r3, r0)
            if (r2 == 0) goto L_0x0217
            int r1 = r1 * 53
            double r2 = zzn(r9, r4)
            long r2 = java.lang.Double.doubleToLongBits(r2)
            byte[] r4 = com.google.android.gms.internal.ads.zzgzk.zzb
            goto L_0x0212
        L_0x0147:
            int r1 = r1 * 53
            java.lang.Object r2 = com.google.android.gms.internal.ads.zzhbu.zzh(r9, r4)
            int r2 = r2.hashCode()
            goto L_0x0216
        L_0x0153:
            int r1 = r1 * 53
            java.lang.Object r2 = com.google.android.gms.internal.ads.zzhbu.zzh(r9, r4)
            int r2 = r2.hashCode()
            goto L_0x0216
        L_0x015f:
            int r1 = r1 * 53
            java.lang.Object r2 = com.google.android.gms.internal.ads.zzhbu.zzh(r9, r4)
            if (r2 == 0) goto L_0x01b8
            int r6 = r2.hashCode()
            goto L_0x01b8
        L_0x016c:
            int r1 = r1 * 53
            long r2 = com.google.android.gms.internal.ads.zzhbu.zzf(r9, r4)
            byte[] r4 = com.google.android.gms.internal.ads.zzgzk.zzb
            goto L_0x0212
        L_0x0176:
            int r1 = r1 * 53
            int r2 = com.google.android.gms.internal.ads.zzhbu.zzd(r9, r4)
            goto L_0x0216
        L_0x017e:
            int r1 = r1 * 53
            long r2 = com.google.android.gms.internal.ads.zzhbu.zzf(r9, r4)
            byte[] r4 = com.google.android.gms.internal.ads.zzgzk.zzb
            goto L_0x0212
        L_0x0188:
            int r1 = r1 * 53
            int r2 = com.google.android.gms.internal.ads.zzhbu.zzd(r9, r4)
            goto L_0x0216
        L_0x0190:
            int r1 = r1 * 53
            int r2 = com.google.android.gms.internal.ads.zzhbu.zzd(r9, r4)
            goto L_0x0216
        L_0x0198:
            int r1 = r1 * 53
            int r2 = com.google.android.gms.internal.ads.zzhbu.zzd(r9, r4)
            goto L_0x0216
        L_0x01a0:
            int r1 = r1 * 53
            java.lang.Object r2 = com.google.android.gms.internal.ads.zzhbu.zzh(r9, r4)
            int r2 = r2.hashCode()
            goto L_0x0216
        L_0x01ac:
            int r1 = r1 * 53
            java.lang.Object r2 = com.google.android.gms.internal.ads.zzhbu.zzh(r9, r4)
            if (r2 == 0) goto L_0x01b8
            int r6 = r2.hashCode()
        L_0x01b8:
            int r1 = r1 + r6
            goto L_0x0217
        L_0x01ba:
            int r1 = r1 * 53
            java.lang.Object r2 = com.google.android.gms.internal.ads.zzhbu.zzh(r9, r4)
            java.lang.String r2 = (java.lang.String) r2
            int r2 = r2.hashCode()
            goto L_0x0216
        L_0x01c7:
            int r1 = r1 * 53
            boolean r2 = com.google.android.gms.internal.ads.zzhbu.zzz(r9, r4)
            int r2 = com.google.android.gms.internal.ads.zzgzk.zza(r2)
            goto L_0x0216
        L_0x01d2:
            int r1 = r1 * 53
            int r2 = com.google.android.gms.internal.ads.zzhbu.zzd(r9, r4)
            goto L_0x0216
        L_0x01d9:
            int r1 = r1 * 53
            long r2 = com.google.android.gms.internal.ads.zzhbu.zzf(r9, r4)
            byte[] r4 = com.google.android.gms.internal.ads.zzgzk.zzb
            goto L_0x0212
        L_0x01e2:
            int r1 = r1 * 53
            int r2 = com.google.android.gms.internal.ads.zzhbu.zzd(r9, r4)
            goto L_0x0216
        L_0x01e9:
            int r1 = r1 * 53
            long r2 = com.google.android.gms.internal.ads.zzhbu.zzf(r9, r4)
            byte[] r4 = com.google.android.gms.internal.ads.zzgzk.zzb
            goto L_0x0212
        L_0x01f2:
            int r1 = r1 * 53
            long r2 = com.google.android.gms.internal.ads.zzhbu.zzf(r9, r4)
            byte[] r4 = com.google.android.gms.internal.ads.zzgzk.zzb
            goto L_0x0212
        L_0x01fb:
            int r1 = r1 * 53
            float r2 = com.google.android.gms.internal.ads.zzhbu.zzc(r9, r4)
            int r2 = java.lang.Float.floatToIntBits(r2)
            goto L_0x0216
        L_0x0206:
            int r1 = r1 * 53
            double r2 = com.google.android.gms.internal.ads.zzhbu.zzb(r9, r4)
            long r2 = java.lang.Double.doubleToLongBits(r2)
            byte[] r4 = com.google.android.gms.internal.ads.zzgzk.zzb
        L_0x0212:
            long r4 = r2 >>> r7
            long r2 = r2 ^ r4
            int r2 = (int) r2
        L_0x0216:
            int r1 = r1 + r2
        L_0x0217:
            int r0 = r0 + 3
            goto L_0x0002
        L_0x021b:
            int r1 = r1 * 53
            r0 = r9
            com.google.android.gms.internal.ads.zzgyx r0 = (com.google.android.gms.internal.ads.zzgyx) r0
            com.google.android.gms.internal.ads.zzhbo r0 = r0.zzt
            int r0 = r0.hashCode()
            int r1 = r1 + r0
            boolean r0 = r8.zzh
            if (r0 == 0) goto L_0x0238
            int r1 = r1 * 53
            com.google.android.gms.internal.ads.zzgyt r9 = (com.google.android.gms.internal.ads.zzgyt) r9
            com.google.android.gms.internal.ads.zzgym r9 = r9.zza
            com.google.android.gms.internal.ads.zzhbj r9 = r9.zza
            int r9 = r9.hashCode()
            int r1 = r1 + r9
        L_0x0238:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzhal.zzb(java.lang.Object):int");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v0, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v3, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v3, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v4, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v5, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v8, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v5, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v10, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v6, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v13, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v12, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v19, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v14, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v10, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v7, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v7, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v8, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v8, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v6, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v11, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v8, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v9, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v21, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v13, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v8, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v13, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v9, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v15, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v10, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v17, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v11, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v18, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v12, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v19, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v13, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v21, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v14, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v23, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v15, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v24, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v16, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v26, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v27, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v28, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v26, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v17, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v27, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v13, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v18, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v28, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v29, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v30, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v19, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v30, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v31, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v31, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v32, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v21, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v33, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v32, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v34, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v22, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v35, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v33, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v34, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v36, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v24, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v37, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v38, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v39, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v25, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v40, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v26, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v28, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v10, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v20, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v31, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v32, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v33, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v34, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v35, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v36, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v39, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v34, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v41, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v42, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v43, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v40, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v42, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v44, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v45, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v46, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v47, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v48, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v44, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v49, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v50, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v51, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v52, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v53, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v54, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v56, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v57, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v58, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v59, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v60, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v71, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v73, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v64, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v66, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v67, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v68, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r35v3, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v71, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v73, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v75, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v76, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v77, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v80, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v79, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v80, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v81, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v82, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v84, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v85, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v84, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v86, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v35, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v88, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v89, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v91, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v92, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v92, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v94, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v95, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v96, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v100, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v98, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v99, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v100, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v106, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v108, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v39, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v122, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v104, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v113, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v12, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v74, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v13, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v75, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v12, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v26, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v25, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v13, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v14, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v77, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v15, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v78, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v15, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v16, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v81, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v17, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v18, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v82, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v17, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v83, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v21, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v86, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v22, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v87, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v19, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v24, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v90, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v25, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v26, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v27, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v21, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v91, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v28, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v22, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v94, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v29, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v95, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v30, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v96, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v31, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v97, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v162, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v98, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v99, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v100, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v101, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v32, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v23, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v105, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v33, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v34, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v106, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v24, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v35, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v107, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v36, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v108, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v37, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v109, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v38, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v39, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v112, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v40, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v114, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v27, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v48, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v53, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v117, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v118, resolved type: byte} */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:225:0x05ea  */
    /* JADX WARNING: Removed duplicated region for block: B:546:0x078d A[SYNTHETIC] */
    final int zzc(java.lang.Object r33, byte[] r34, int r35, int r36, int r37, com.google.android.gms.internal.ads.zzgxd r38) throws java.io.IOException {
        /*
            r32 = this;
            r0 = r32
            r2 = r33
            r7 = r34
            r8 = r36
            r10 = r38
            zzD(r2)
            sun.misc.Unsafe r1 = zzb
            r12 = -1
            r3 = r35
            r4 = r12
            r5 = 0
            r6 = 0
            r14 = 1048575(0xfffff, float:1.469367E-39)
            r15 = 0
        L_0x0019:
            if (r3 >= r8) goto L_0x0b86
            int r6 = r3 + 1
            byte r3 = r7[r3]
            if (r3 >= 0) goto L_0x0027
            int r6 = com.google.android.gms.internal.ads.zzgxe.zzi(r3, r7, r6, r10)
            int r3 = r10.zza
        L_0x0027:
            r31 = r6
            r6 = r3
            r3 = r31
            int r11 = r6 >>> 3
            r16 = 1048575(0xfffff, float:1.469367E-39)
            r13 = 3
            if (r11 <= r4) goto L_0x0044
            int r5 = r5 / r13
            int r4 = r0.zze
            if (r11 < r4) goto L_0x0042
            int r4 = r0.zzf
            if (r11 > r4) goto L_0x0042
            int r4 = r0.zzs(r11, r5)
            goto L_0x0048
        L_0x0042:
            r4 = r12
            goto L_0x0048
        L_0x0044:
            int r4 = r0.zzq(r11)
        L_0x0048:
            r17 = 0
            if (r4 != r12) goto L_0x005c
            r9 = r37
            r25 = r1
            r12 = r6
            r13 = r11
            r19 = r14
            r24 = r15
            r11 = 0
            r14 = r2
            r15 = r3
            r3 = r7
            goto L_0x0b2b
        L_0x005c:
            r5 = r6 & 7
            int[] r12 = r0.zzc
            int r18 = r4 + 1
            r13 = r12[r18]
            r18 = r4
            int r4 = zzt(r13)
            r19 = r6
            r6 = r13 & r16
            r20 = r11
            r21 = r12
            long r11 = (long) r6
            r22 = 0
            java.lang.String r6 = ""
            java.lang.String r8 = "CodedInputStream encountered an embedded string or message which claimed to have negative size."
            r24 = r11
            r11 = 17
            r26 = 1
            if (r4 > r11) goto L_0x0388
            int r11 = r18 + 2
            r11 = r21[r11]
            int r21 = r11 >>> 20
            int r21 = r26 << r21
            r11 = r11 & r16
            if (r11 == r14) goto L_0x00a6
            r12 = r16
            r27 = r13
            if (r14 == r12) goto L_0x009a
            long r12 = (long) r14
            r1.putInt(r2, r12, r15)
            r12 = 1048575(0xfffff, float:1.469367E-39)
        L_0x009a:
            if (r11 != r12) goto L_0x009e
            r15 = 0
            goto L_0x00a4
        L_0x009e:
            long r12 = (long) r11
            int r12 = r1.getInt(r2, r12)
            r15 = r12
        L_0x00a4:
            r14 = r11
            goto L_0x00a8
        L_0x00a6:
            r27 = r13
        L_0x00a8:
            switch(r4) {
                case 0: goto L_0x0343;
                case 1: goto L_0x030f;
                case 2: goto L_0x02da;
                case 3: goto L_0x02da;
                case 4: goto L_0x02ae;
                case 5: goto L_0x0278;
                case 6: goto L_0x0244;
                case 7: goto L_0x0219;
                case 8: goto L_0x01bf;
                case 9: goto L_0x0184;
                case 10: goto L_0x0161;
                case 11: goto L_0x02ae;
                case 12: goto L_0x0129;
                case 13: goto L_0x0244;
                case 14: goto L_0x0278;
                case 15: goto L_0x010d;
                case 16: goto L_0x00e6;
                default: goto L_0x00ab;
            }
        L_0x00ab:
            r35 = r10
            r10 = r7
            r7 = r35
            r35 = r14
            r4 = r15
            r11 = r18
            r12 = r19
            r15 = r1
            r14 = r2
            r1 = 3
            if (r5 != r1) goto L_0x0379
            r8 = r4 | r21
            java.lang.Object r1 = r0.zzA(r14, r11)
            int r2 = r20 << 3
            r6 = r2 | 4
            com.google.android.gms.internal.ads.zzhbb r2 = r0.zzx(r11)
            r5 = r36
            r4 = r3
            r3 = r10
            int r2 = com.google.android.gms.internal.ads.zzgxe.zzl(r1, r2, r3, r4, r5, r6, r7)
            r0.zzJ(r14, r11, r1)
            r7 = r34
            r10 = r38
            r3 = r2
            r5 = r11
            r6 = r12
            r2 = r14
            r1 = r15
            r4 = r20
            r12 = -1
            r14 = r35
            r15 = r8
            goto L_0x0306
        L_0x00e6:
            if (r5 != 0) goto L_0x0102
            r15 = r15 | r21
            int r8 = com.google.android.gms.internal.ads.zzgxe.zzk(r7, r3, r10)
            long r3 = r10.zzb
            long r5 = com.google.android.gms.internal.ads.zzgxv.zzF(r3)
            r11 = r18
            r12 = r19
            r3 = r24
            r1.putLong(r2, r3, r5)
            r3 = r8
            r5 = r11
            r6 = r12
            goto L_0x0303
        L_0x0102:
            r11 = r18
            r12 = r19
            r35 = r14
            r4 = r15
            r15 = r1
            r14 = r2
            goto L_0x0379
        L_0x010d:
            r13 = r2
            r35 = r14
            r2 = r15
            r11 = r18
            r12 = r19
            r14 = r24
            if (r5 != 0) goto L_0x0180
            r2 = r2 | r21
            int r3 = com.google.android.gms.internal.ads.zzgxe.zzh(r7, r3, r10)
            int r4 = r10.zza
            int r4 = com.google.android.gms.internal.ads.zzgxv.zzD(r4)
            r1.putInt(r13, r14, r4)
            goto L_0x0179
        L_0x0129:
            r13 = r2
            r35 = r14
            r2 = r15
            r11 = r18
            r12 = r19
            r14 = r24
            if (r5 != 0) goto L_0x0180
            int r3 = com.google.android.gms.internal.ads.zzgxe.zzh(r7, r3, r10)
            int r4 = r10.zza
            com.google.android.gms.internal.ads.zzgzd r5 = r0.zzw(r11)
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            r6 = r27 & r6
            if (r6 == 0) goto L_0x015b
            if (r5 == 0) goto L_0x015b
            boolean r5 = r5.zza(r4)
            if (r5 == 0) goto L_0x014e
            goto L_0x015b
        L_0x014e:
            com.google.android.gms.internal.ads.zzhbo r5 = zzd(r13)
            long r14 = (long) r4
            java.lang.Long r4 = java.lang.Long.valueOf(r14)
            r5.zzj(r12, r4)
            goto L_0x0179
        L_0x015b:
            r2 = r2 | r21
            r1.putInt(r13, r14, r4)
            goto L_0x0179
        L_0x0161:
            r13 = r2
            r35 = r14
            r2 = r15
            r11 = r18
            r12 = r19
            r14 = r24
            r4 = 2
            if (r5 != r4) goto L_0x0180
            r2 = r2 | r21
            int r3 = com.google.android.gms.internal.ads.zzgxe.zza(r7, r3, r10)
            java.lang.Object r4 = r10.zzc
            r1.putObject(r13, r14, r4)
        L_0x0179:
            r14 = r35
            r8 = r36
            r15 = r2
            goto L_0x026c
        L_0x0180:
            r15 = r1
            r4 = r2
            goto L_0x0275
        L_0x0184:
            r13 = r2
            r35 = r14
            r2 = r15
            r11 = r18
            r12 = r19
            r4 = 2
            if (r5 != r4) goto L_0x01b7
            r15 = r2 | r21
            r2 = r1
            java.lang.Object r1 = r0.zzA(r13, r11)
            r4 = r2
            com.google.android.gms.internal.ads.zzhbb r2 = r0.zzx(r11)
            r5 = r4
            r4 = r3
            r3 = r7
            r7 = r5
            r5 = r36
            r6 = r10
            int r2 = com.google.android.gms.internal.ads.zzgxe.zzm(r1, r2, r3, r4, r5, r6)
            r10 = r3
            r3 = r1
            r1 = r6
            r0.zzJ(r13, r11, r3)
            r3 = r10
            r10 = r1
            r1 = r7
            r7 = r3
            r14 = r35
            r8 = r36
            r3 = r2
            goto L_0x026c
        L_0x01b7:
            r31 = r7
            r7 = r1
            r1 = r10
            r10 = r31
            goto L_0x0273
        L_0x01bf:
            r35 = r7
            r7 = r1
            r1 = r10
            r10 = r35
            r13 = r2
            r35 = r14
            r2 = r15
            r11 = r18
            r12 = r19
            r14 = r24
            r4 = 2
            if (r5 != r4) goto L_0x0273
            boolean r4 = zzM(r27)
            if (r4 == 0) goto L_0x01f4
            int r3 = com.google.android.gms.internal.ads.zzgxe.zzh(r10, r3, r1)
            int r4 = r1.zza
            if (r4 < 0) goto L_0x01ee
            r2 = r2 | r21
            if (r4 != 0) goto L_0x01e7
            r1.zzc = r6
            goto L_0x020d
        L_0x01e7:
            java.lang.String r5 = com.google.android.gms.internal.ads.zzhbz.zzh(r10, r3, r4)
            r1.zzc = r5
            goto L_0x020c
        L_0x01ee:
            com.google.android.gms.internal.ads.zzgzm r1 = new com.google.android.gms.internal.ads.zzgzm
            r1.<init>((java.lang.String) r8)
            throw r1
        L_0x01f4:
            r2 = r2 | r21
            int r3 = com.google.android.gms.internal.ads.zzgxe.zzh(r10, r3, r1)
            int r4 = r1.zza
            if (r4 < 0) goto L_0x0213
            if (r4 != 0) goto L_0x0203
            r1.zzc = r6
            goto L_0x020d
        L_0x0203:
            java.lang.String r5 = new java.lang.String
            java.nio.charset.Charset r6 = com.google.android.gms.internal.ads.zzgzk.zza
            r5.<init>(r10, r3, r4, r6)
            r1.zzc = r5
        L_0x020c:
            int r3 = r3 + r4
        L_0x020d:
            java.lang.Object r4 = r1.zzc
            r7.putObject(r13, r14, r4)
            goto L_0x023e
        L_0x0213:
            com.google.android.gms.internal.ads.zzgzm r1 = new com.google.android.gms.internal.ads.zzgzm
            r1.<init>((java.lang.String) r8)
            throw r1
        L_0x0219:
            r35 = r7
            r7 = r1
            r1 = r10
            r10 = r35
            r13 = r2
            r35 = r14
            r2 = r15
            r11 = r18
            r12 = r19
            r14 = r24
            if (r5 != 0) goto L_0x0273
            r2 = r2 | r21
            int r3 = com.google.android.gms.internal.ads.zzgxe.zzk(r10, r3, r1)
            long r4 = r1.zzb
            int r4 = (r4 > r22 ? 1 : (r4 == r22 ? 0 : -1))
            if (r4 == 0) goto L_0x023a
            r4 = r26
            goto L_0x023b
        L_0x023a:
            r4 = 0
        L_0x023b:
            com.google.android.gms.internal.ads.zzhbu.zzp(r13, r14, r4)
        L_0x023e:
            r4 = r10
            r10 = r1
            r1 = r7
            r7 = r4
            goto L_0x0179
        L_0x0244:
            r35 = r7
            r7 = r1
            r1 = r10
            r10 = r35
            r13 = r2
            r35 = r14
            r2 = r15
            r11 = r18
            r12 = r19
            r14 = r24
            r4 = 5
            if (r5 != r4) goto L_0x0273
            int r4 = r3 + 4
            r2 = r2 | r21
            int r3 = com.google.android.gms.internal.ads.zzgxe.zzb(r10, r3)
            r7.putInt(r13, r14, r3)
            r3 = r10
            r10 = r1
            r1 = r7
            r7 = r3
            r14 = r35
            r8 = r36
            r15 = r2
            r3 = r4
        L_0x026c:
            r5 = r11
            r6 = r12
            r2 = r13
            r4 = r20
            goto L_0x0376
        L_0x0273:
            r4 = r2
            r15 = r7
        L_0x0275:
            r14 = r13
            goto L_0x0379
        L_0x0278:
            r35 = r7
            r7 = r1
            r1 = r10
            r10 = r35
            r13 = r2
            r35 = r14
            r2 = r15
            r11 = r18
            r12 = r19
            r14 = r24
            r4 = r26
            if (r5 != r4) goto L_0x02a8
            int r8 = r3 + 8
            r17 = r2 | r21
            long r5 = com.google.android.gms.internal.ads.zzgxe.zzn(r10, r3)
            r2 = r7
            r7 = r1
            r1 = r2
            r2 = r13
            r3 = r14
            r1.putLong(r2, r3, r5)
            r3 = r10
            r10 = r7
            r7 = r3
            r14 = r35
            r3 = r8
            r5 = r11
            r6 = r12
            r15 = r17
            goto L_0x0303
        L_0x02a8:
            r4 = r7
            r7 = r1
            r15 = r4
            r14 = r13
            goto L_0x030c
        L_0x02ae:
            r35 = r10
            r10 = r7
            r7 = r35
            r4 = r1
            r1 = r2
            r35 = r14
            r2 = r15
            r11 = r18
            r12 = r19
            r14 = r24
            if (r5 != 0) goto L_0x030a
            r2 = r2 | r21
            int r3 = com.google.android.gms.internal.ads.zzgxe.zzh(r10, r3, r7)
            int r5 = r7.zza
            r4.putInt(r1, r14, r5)
            r5 = r10
            r10 = r7
            r7 = r5
            r14 = r35
            r8 = r36
            r15 = r2
            r5 = r11
            r6 = r12
            r12 = -1
            r2 = r1
            r1 = r4
            goto L_0x033f
        L_0x02da:
            r35 = r10
            r10 = r7
            r7 = r35
            r4 = r1
            r1 = r2
            r35 = r14
            r2 = r15
            r11 = r18
            r12 = r19
            r14 = r24
            if (r5 != 0) goto L_0x030a
            r8 = r2 | r21
            int r13 = com.google.android.gms.internal.ads.zzgxe.zzk(r10, r3, r7)
            long r5 = r7.zzb
            r2 = r1
            r1 = r4
            r3 = r14
            r1.putLong(r2, r3, r5)
            r3 = r10
            r10 = r7
            r7 = r3
            r14 = r35
            r15 = r8
            r5 = r11
            r6 = r12
            r3 = r13
        L_0x0303:
            r4 = r20
            r12 = -1
        L_0x0306:
            r8 = r36
            goto L_0x0019
        L_0x030a:
            r14 = r1
            r15 = r4
        L_0x030c:
            r4 = r2
            goto L_0x0379
        L_0x030f:
            r35 = r10
            r10 = r7
            r7 = r35
            r35 = r14
            r4 = r15
            r11 = r18
            r12 = r19
            r6 = 5
            r15 = r1
            r14 = r2
            r1 = r24
            if (r5 != r6) goto L_0x0379
            int r5 = r3 + 4
            r4 = r4 | r21
            int r3 = com.google.android.gms.internal.ads.zzgxe.zzb(r10, r3)
            float r3 = java.lang.Float.intBitsToFloat(r3)
            com.google.android.gms.internal.ads.zzhbu.zzs(r14, r1, r3)
            r1 = r10
            r10 = r7
            r7 = r1
            r8 = r36
            r3 = r5
            r5 = r11
            r6 = r12
            r2 = r14
            r1 = r15
            r12 = -1
            r14 = r35
            r15 = r4
        L_0x033f:
            r4 = r20
            goto L_0x0019
        L_0x0343:
            r35 = r10
            r10 = r7
            r7 = r35
            r35 = r14
            r4 = r15
            r11 = r18
            r12 = r19
            r6 = r26
            r15 = r1
            r14 = r2
            r1 = r24
            if (r5 != r6) goto L_0x0379
            int r5 = r3 + 8
            r4 = r4 | r21
            long r18 = com.google.android.gms.internal.ads.zzgxe.zzn(r10, r3)
            r6 = r4
            double r3 = java.lang.Double.longBitsToDouble(r18)
            com.google.android.gms.internal.ads.zzhbu.zzr(r14, r1, r3)
            r1 = r10
            r10 = r7
            r7 = r1
            r8 = r36
            r3 = r5
            r5 = r11
            r2 = r14
            r1 = r15
            r4 = r20
            r14 = r35
            r15 = r6
            r6 = r12
        L_0x0376:
            r12 = -1
            goto L_0x0019
        L_0x0379:
            r19 = r35
            r9 = r37
            r10 = r38
            r24 = r4
            r25 = r15
            r13 = r20
            r15 = r3
            goto L_0x090c
        L_0x0388:
            r10 = r1
            r27 = r13
            r11 = r18
            r12 = r19
            r13 = r2
            r1 = r24
            r7 = 27
            r18 = 10
            if (r4 != r7) goto L_0x03eb
            r7 = 2
            if (r5 != r7) goto L_0x03d8
            java.lang.Object r4 = r10.getObject(r13, r1)
            com.google.android.gms.internal.ads.zzgzj r4 = (com.google.android.gms.internal.ads.zzgzj) r4
            boolean r5 = r4.zzc()
            if (r5 != 0) goto L_0x03b9
            int r5 = r4.size()
            if (r5 != 0) goto L_0x03ae
            goto L_0x03b0
        L_0x03ae:
            int r18 = r5 + r5
        L_0x03b0:
            r5 = r18
            com.google.android.gms.internal.ads.zzgzj r4 = r4.zzf(r5)
            r10.putObject(r13, r1, r4)
        L_0x03b9:
            r6 = r4
            com.google.android.gms.internal.ads.zzhbb r1 = r0.zzx(r11)
            r5 = r36
            r7 = r38
            r4 = r3
            r2 = r12
            r3 = r34
            int r1 = com.google.android.gms.internal.ads.zzgxe.zze(r1, r2, r3, r4, r5, r6, r7)
            r7 = r3
            r8 = r5
            r5 = r11
            r6 = r12
            r2 = r13
            r4 = r20
            r12 = -1
            r3 = r1
            r1 = r10
            r10 = r38
            goto L_0x0019
        L_0x03d8:
            r7 = r36
            r4 = r3
            r3 = r34
            r3 = r38
            r25 = r10
            r19 = r14
            r24 = r15
            r15 = r4
            r14 = r13
            r13 = r20
            goto L_0x0909
        L_0x03eb:
            r7 = r36
            r25 = r10
            r19 = r14
            r24 = r15
            r14 = r38
            r15 = r3
            r3 = r34
            r10 = 49
            java.lang.String r9 = "Protocol message had invalid UTF-8."
            if (r4 > r10) goto L_0x08d6
            r10 = r27
            r27 = r9
            long r9 = (long) r10
            r28 = r9
            sun.misc.Unsafe r9 = zzb
            java.lang.Object r10 = r9.getObject(r13, r1)
            com.google.android.gms.internal.ads.zzgzj r10 = (com.google.android.gms.internal.ads.zzgzj) r10
            boolean r21 = r10.zzc()
            if (r21 != 0) goto L_0x0428
            int r21 = r10.size()
            if (r21 != 0) goto L_0x041a
            goto L_0x041c
        L_0x041a:
            int r18 = r21 + r21
        L_0x041c:
            r30 = r4
            r4 = r18
            com.google.android.gms.internal.ads.zzgzj r10 = r10.zzf(r4)
            r9.putObject(r13, r1, r10)
            goto L_0x042a
        L_0x0428:
            r30 = r4
        L_0x042a:
            java.lang.String r1 = "While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length."
            switch(r30) {
                case 18: goto L_0x0845;
                case 19: goto L_0x07ed;
                case 20: goto L_0x07a1;
                case 21: goto L_0x07a1;
                case 22: goto L_0x0781;
                case 23: goto L_0x0734;
                case 24: goto L_0x06e8;
                case 25: goto L_0x0687;
                case 26: goto L_0x05be;
                case 27: goto L_0x059d;
                case 28: goto L_0x0533;
                case 29: goto L_0x0781;
                case 30: goto L_0x04fe;
                case 31: goto L_0x06e8;
                case 32: goto L_0x0734;
                case 33: goto L_0x049f;
                case 34: goto L_0x044d;
                case 35: goto L_0x0845;
                case 36: goto L_0x07ed;
                case 37: goto L_0x07a1;
                case 38: goto L_0x07a1;
                case 39: goto L_0x0781;
                case 40: goto L_0x0734;
                case 41: goto L_0x06e8;
                case 42: goto L_0x0687;
                case 43: goto L_0x0781;
                case 44: goto L_0x04fe;
                case 45: goto L_0x06e8;
                case 46: goto L_0x0734;
                case 47: goto L_0x049f;
                case 48: goto L_0x044d;
                default: goto L_0x042f;
            }
        L_0x042f:
            r9 = r7
            r6 = r14
            r1 = 3
            r14 = r13
            r13 = r20
            if (r5 != r1) goto L_0x08bb
            r1 = r12 & -8
            r5 = r1 | 4
            com.google.android.gms.internal.ads.zzhbb r1 = r0.zzx(r11)
            r2 = r3
            r4 = r9
            r3 = r15
            int r7 = com.google.android.gms.internal.ads.zzgxe.zzc(r1, r2, r3, r4, r5, r6)
            java.lang.Object r2 = r6.zzc
            r10.add(r2)
            goto L_0x089f
        L_0x044d:
            r4 = 2
            if (r5 != r4) goto L_0x0474
            int r2 = com.google.android.gms.internal.ads.zzgxe.zza
            com.google.android.gms.internal.ads.zzgzx r10 = (com.google.android.gms.internal.ads.zzgzx) r10
            int r2 = com.google.android.gms.internal.ads.zzgxe.zzh(r3, r15, r14)
            int r4 = r14.zza
            int r4 = r4 + r2
        L_0x045b:
            if (r2 >= r4) goto L_0x046b
            int r2 = com.google.android.gms.internal.ads.zzgxe.zzk(r3, r2, r14)
            long r5 = r14.zzb
            long r5 = com.google.android.gms.internal.ads.zzgxv.zzF(r5)
            r10.zzg(r5)
            goto L_0x045b
        L_0x046b:
            if (r2 != r4) goto L_0x046e
            goto L_0x04bf
        L_0x046e:
            com.google.android.gms.internal.ads.zzgzm r2 = new com.google.android.gms.internal.ads.zzgzm
            r2.<init>((java.lang.String) r1)
            throw r2
        L_0x0474:
            if (r5 != 0) goto L_0x04f8
            int r1 = com.google.android.gms.internal.ads.zzgxe.zza
            com.google.android.gms.internal.ads.zzgzx r10 = (com.google.android.gms.internal.ads.zzgzx) r10
            int r1 = com.google.android.gms.internal.ads.zzgxe.zzk(r3, r15, r14)
            long r4 = r14.zzb
            long r4 = com.google.android.gms.internal.ads.zzgxv.zzF(r4)
            r10.zzg(r4)
        L_0x0487:
            if (r1 >= r7) goto L_0x04f2
            int r2 = com.google.android.gms.internal.ads.zzgxe.zzh(r3, r1, r14)
            int r4 = r14.zza
            if (r12 != r4) goto L_0x04f2
            int r1 = com.google.android.gms.internal.ads.zzgxe.zzk(r3, r2, r14)
            long r4 = r14.zzb
            long r4 = com.google.android.gms.internal.ads.zzgxv.zzF(r4)
            r10.zzg(r4)
            goto L_0x0487
        L_0x049f:
            r4 = 2
            if (r5 != r4) goto L_0x04c7
            int r2 = com.google.android.gms.internal.ads.zzgxe.zza
            com.google.android.gms.internal.ads.zzgyy r10 = (com.google.android.gms.internal.ads.zzgyy) r10
            int r2 = com.google.android.gms.internal.ads.zzgxe.zzh(r3, r15, r14)
            int r4 = r14.zza
            int r4 = r4 + r2
        L_0x04ad:
            if (r2 >= r4) goto L_0x04bd
            int r2 = com.google.android.gms.internal.ads.zzgxe.zzh(r3, r2, r14)
            int r5 = r14.zza
            int r5 = com.google.android.gms.internal.ads.zzgxv.zzD(r5)
            r10.zzi(r5)
            goto L_0x04ad
        L_0x04bd:
            if (r2 != r4) goto L_0x04c1
        L_0x04bf:
            r1 = r2
            goto L_0x04f2
        L_0x04c1:
            com.google.android.gms.internal.ads.zzgzm r2 = new com.google.android.gms.internal.ads.zzgzm
            r2.<init>((java.lang.String) r1)
            throw r2
        L_0x04c7:
            if (r5 != 0) goto L_0x04f8
            int r1 = com.google.android.gms.internal.ads.zzgxe.zza
            com.google.android.gms.internal.ads.zzgyy r10 = (com.google.android.gms.internal.ads.zzgyy) r10
            int r1 = com.google.android.gms.internal.ads.zzgxe.zzh(r3, r15, r14)
            int r2 = r14.zza
            int r2 = com.google.android.gms.internal.ads.zzgxv.zzD(r2)
            r10.zzi(r2)
        L_0x04da:
            if (r1 >= r7) goto L_0x04f2
            int r2 = com.google.android.gms.internal.ads.zzgxe.zzh(r3, r1, r14)
            int r4 = r14.zza
            if (r12 != r4) goto L_0x04f2
            int r1 = com.google.android.gms.internal.ads.zzgxe.zzh(r3, r2, r14)
            int r2 = r14.zza
            int r2 = com.google.android.gms.internal.ads.zzgxv.zzD(r2)
            r10.zzi(r2)
            goto L_0x04da
        L_0x04f2:
            r3 = r14
            r14 = r13
            r13 = r20
            goto L_0x08bd
        L_0x04f8:
            r3 = r14
            r14 = r13
            r13 = r20
            goto L_0x08bc
        L_0x04fe:
            r4 = 2
            if (r5 != r4) goto L_0x050a
            int r1 = com.google.android.gms.internal.ads.zzgxe.zzf(r3, r15, r10, r14)
            r9 = r7
            r5 = r10
            r7 = r1
            r10 = r3
            goto L_0x0518
        L_0x050a:
            if (r5 != 0) goto L_0x052d
            r2 = r3
            r4 = r7
            r5 = r10
            r1 = r12
            r6 = r14
            r3 = r15
            int r7 = com.google.android.gms.internal.ads.zzgxe.zzj(r1, r2, r3, r4, r5, r6)
            r10 = r2
            r9 = r4
        L_0x0518:
            com.google.android.gms.internal.ads.zzgzd r4 = r0.zzw(r11)
            r3 = r5
            r5 = 0
            com.google.android.gms.internal.ads.zzhbn r6 = r0.zzm
            r1 = r13
            r2 = r20
            com.google.android.gms.internal.ads.zzhbd.zzn(r1, r2, r3, r4, r5, r6)
            r13 = r2
            r1 = r7
        L_0x0528:
            r3 = r14
            r14 = r33
            goto L_0x08bd
        L_0x052d:
            r10 = r3
            r9 = r7
            r13 = r20
            goto L_0x0598
        L_0x0533:
            r4 = r10
            r10 = r3
            r3 = r4
            r9 = r7
            r13 = r20
            r4 = 2
            if (r5 != r4) goto L_0x0598
            int r2 = com.google.android.gms.internal.ads.zzgxe.zzh(r10, r15, r14)
            int r4 = r14.zza
            if (r4 < 0) goto L_0x0592
            int r5 = r10.length
            int r5 = r5 - r2
            if (r4 > r5) goto L_0x058c
            if (r4 != 0) goto L_0x0550
            com.google.android.gms.internal.ads.zzgxp r4 = com.google.android.gms.internal.ads.zzgxp.zzb
            r3.add(r4)
            goto L_0x0558
        L_0x0550:
            com.google.android.gms.internal.ads.zzgxp r5 = com.google.android.gms.internal.ads.zzgxp.zzv(r10, r2, r4)
            r3.add(r5)
        L_0x0557:
            int r2 = r2 + r4
        L_0x0558:
            if (r2 >= r9) goto L_0x058a
            int r4 = com.google.android.gms.internal.ads.zzgxe.zzh(r10, r2, r14)
            int r5 = r14.zza
            if (r12 != r5) goto L_0x058a
            int r2 = com.google.android.gms.internal.ads.zzgxe.zzh(r10, r4, r14)
            int r4 = r14.zza
            if (r4 < 0) goto L_0x0584
            int r5 = r10.length
            int r5 = r5 - r2
            if (r4 > r5) goto L_0x057e
            if (r4 != 0) goto L_0x0576
            com.google.android.gms.internal.ads.zzgxp r4 = com.google.android.gms.internal.ads.zzgxp.zzb
            r3.add(r4)
            goto L_0x0558
        L_0x0576:
            com.google.android.gms.internal.ads.zzgxp r5 = com.google.android.gms.internal.ads.zzgxp.zzv(r10, r2, r4)
            r3.add(r5)
            goto L_0x0557
        L_0x057e:
            com.google.android.gms.internal.ads.zzgzm r2 = new com.google.android.gms.internal.ads.zzgzm
            r2.<init>((java.lang.String) r1)
            throw r2
        L_0x0584:
            com.google.android.gms.internal.ads.zzgzm r1 = new com.google.android.gms.internal.ads.zzgzm
            r1.<init>((java.lang.String) r8)
            throw r1
        L_0x058a:
            r1 = r2
            goto L_0x0528
        L_0x058c:
            com.google.android.gms.internal.ads.zzgzm r2 = new com.google.android.gms.internal.ads.zzgzm
            r2.<init>((java.lang.String) r1)
            throw r2
        L_0x0592:
            com.google.android.gms.internal.ads.zzgzm r1 = new com.google.android.gms.internal.ads.zzgzm
            r1.<init>((java.lang.String) r8)
            throw r1
        L_0x0598:
            r3 = r14
            r14 = r33
            goto L_0x08bc
        L_0x059d:
            r4 = r10
            r10 = r3
            r3 = r4
            r9 = r7
            r13 = r20
            r4 = 2
            if (r5 != r4) goto L_0x05b8
            com.google.android.gms.internal.ads.zzhbb r1 = r0.zzx(r11)
            r6 = r3
            r5 = r9
            r3 = r10
            r2 = r12
            r7 = r14
            r4 = r15
            r14 = r33
            int r1 = com.google.android.gms.internal.ads.zzgxe.zze(r1, r2, r3, r4, r5, r6, r7)
            goto L_0x078d
        L_0x05b8:
            r3 = r10
            r7 = r14
            r14 = r33
            goto L_0x0684
        L_0x05be:
            r9 = r7
            r7 = r14
            r4 = 2
            r14 = r13
            r13 = r20
            if (r5 != r4) goto L_0x0684
            r1 = 536870912(0x20000000, double:2.652494739E-315)
            long r1 = r28 & r1
            int r1 = (r1 > r22 ? 1 : (r1 == r22 ? 0 : -1))
            if (r1 != 0) goto L_0x0617
            int r1 = com.google.android.gms.internal.ads.zzgxe.zzh(r3, r15, r7)
            int r2 = r7.zza
            if (r2 < 0) goto L_0x0611
            if (r2 != 0) goto L_0x05dd
            r10.add(r6)
            goto L_0x05e8
        L_0x05dd:
            java.lang.String r4 = new java.lang.String
            java.nio.charset.Charset r5 = com.google.android.gms.internal.ads.zzgzk.zza
            r4.<init>(r3, r1, r2, r5)
            r10.add(r4)
        L_0x05e7:
            int r1 = r1 + r2
        L_0x05e8:
            if (r1 >= r9) goto L_0x078d
            int r2 = com.google.android.gms.internal.ads.zzgxe.zzh(r3, r1, r7)
            int r4 = r7.zza
            if (r12 != r4) goto L_0x078d
            int r1 = com.google.android.gms.internal.ads.zzgxe.zzh(r3, r2, r7)
            int r2 = r7.zza
            if (r2 < 0) goto L_0x060b
            if (r2 != 0) goto L_0x0600
            r10.add(r6)
            goto L_0x05e8
        L_0x0600:
            java.lang.String r4 = new java.lang.String
            java.nio.charset.Charset r5 = com.google.android.gms.internal.ads.zzgzk.zza
            r4.<init>(r3, r1, r2, r5)
            r10.add(r4)
            goto L_0x05e7
        L_0x060b:
            com.google.android.gms.internal.ads.zzgzm r1 = new com.google.android.gms.internal.ads.zzgzm
            r1.<init>((java.lang.String) r8)
            throw r1
        L_0x0611:
            com.google.android.gms.internal.ads.zzgzm r1 = new com.google.android.gms.internal.ads.zzgzm
            r1.<init>((java.lang.String) r8)
            throw r1
        L_0x0617:
            int r1 = com.google.android.gms.internal.ads.zzgxe.zzh(r3, r15, r7)
            int r2 = r7.zza
            if (r2 < 0) goto L_0x067e
            if (r2 != 0) goto L_0x0625
            r10.add(r6)
            goto L_0x063b
        L_0x0625:
            int r4 = r1 + r2
            boolean r5 = com.google.android.gms.internal.ads.zzhbz.zzi(r3, r1, r4)
            if (r5 == 0) goto L_0x0676
            java.lang.String r5 = new java.lang.String
            r35 = r4
            java.nio.charset.Charset r4 = com.google.android.gms.internal.ads.zzgzk.zza
            r5.<init>(r3, r1, r2, r4)
            r10.add(r5)
        L_0x0639:
            r1 = r35
        L_0x063b:
            if (r1 >= r9) goto L_0x078d
            int r2 = com.google.android.gms.internal.ads.zzgxe.zzh(r3, r1, r7)
            int r4 = r7.zza
            if (r12 != r4) goto L_0x078d
            int r1 = com.google.android.gms.internal.ads.zzgxe.zzh(r3, r2, r7)
            int r2 = r7.zza
            if (r2 < 0) goto L_0x0670
            if (r2 != 0) goto L_0x0653
            r10.add(r6)
            goto L_0x063b
        L_0x0653:
            int r4 = r1 + r2
            boolean r5 = com.google.android.gms.internal.ads.zzhbz.zzi(r3, r1, r4)
            if (r5 == 0) goto L_0x0668
            java.lang.String r5 = new java.lang.String
            r35 = r4
            java.nio.charset.Charset r4 = com.google.android.gms.internal.ads.zzgzk.zza
            r5.<init>(r3, r1, r2, r4)
            r10.add(r5)
            goto L_0x0639
        L_0x0668:
            com.google.android.gms.internal.ads.zzgzm r1 = new com.google.android.gms.internal.ads.zzgzm
            r4 = r27
            r1.<init>((java.lang.String) r4)
            throw r1
        L_0x0670:
            com.google.android.gms.internal.ads.zzgzm r1 = new com.google.android.gms.internal.ads.zzgzm
            r1.<init>((java.lang.String) r8)
            throw r1
        L_0x0676:
            r4 = r27
            com.google.android.gms.internal.ads.zzgzm r1 = new com.google.android.gms.internal.ads.zzgzm
            r1.<init>((java.lang.String) r4)
            throw r1
        L_0x067e:
            com.google.android.gms.internal.ads.zzgzm r1 = new com.google.android.gms.internal.ads.zzgzm
            r1.<init>((java.lang.String) r8)
            throw r1
        L_0x0684:
            r3 = r7
            goto L_0x08bc
        L_0x0687:
            r9 = r7
            r7 = r14
            r4 = 2
            r14 = r13
            r13 = r20
            if (r5 != r4) goto L_0x06b7
            int r2 = com.google.android.gms.internal.ads.zzgxe.zza
            com.google.android.gms.internal.ads.zzgxf r10 = (com.google.android.gms.internal.ads.zzgxf) r10
            int r2 = com.google.android.gms.internal.ads.zzgxe.zzh(r3, r15, r7)
            int r4 = r7.zza
            int r4 = r4 + r2
        L_0x069a:
            if (r2 >= r4) goto L_0x06ad
            int r2 = com.google.android.gms.internal.ads.zzgxe.zzk(r3, r2, r7)
            long r5 = r7.zzb
            int r5 = (r5 > r22 ? 1 : (r5 == r22 ? 0 : -1))
            if (r5 == 0) goto L_0x06a8
            r5 = 1
            goto L_0x06a9
        L_0x06a8:
            r5 = 0
        L_0x06a9:
            r10.zzg(r5)
            goto L_0x069a
        L_0x06ad:
            if (r2 != r4) goto L_0x06b1
            goto L_0x0755
        L_0x06b1:
            com.google.android.gms.internal.ads.zzgzm r2 = new com.google.android.gms.internal.ads.zzgzm
            r2.<init>((java.lang.String) r1)
            throw r2
        L_0x06b7:
            if (r5 != 0) goto L_0x0684
            int r1 = com.google.android.gms.internal.ads.zzgxe.zza
            com.google.android.gms.internal.ads.zzgxf r10 = (com.google.android.gms.internal.ads.zzgxf) r10
            int r1 = com.google.android.gms.internal.ads.zzgxe.zzk(r3, r15, r7)
            long r4 = r7.zzb
            int r2 = (r4 > r22 ? 1 : (r4 == r22 ? 0 : -1))
            if (r2 == 0) goto L_0x06c9
            r2 = 1
            goto L_0x06ca
        L_0x06c9:
            r2 = 0
        L_0x06ca:
            r10.zzg(r2)
        L_0x06cd:
            if (r1 >= r9) goto L_0x078d
            int r2 = com.google.android.gms.internal.ads.zzgxe.zzh(r3, r1, r7)
            int r4 = r7.zza
            if (r12 != r4) goto L_0x078d
            int r1 = com.google.android.gms.internal.ads.zzgxe.zzk(r3, r2, r7)
            long r4 = r7.zzb
            int r2 = (r4 > r22 ? 1 : (r4 == r22 ? 0 : -1))
            if (r2 == 0) goto L_0x06e3
            r2 = 1
            goto L_0x06e4
        L_0x06e3:
            r2 = 0
        L_0x06e4:
            r10.zzg(r2)
            goto L_0x06cd
        L_0x06e8:
            r9 = r7
            r7 = r14
            r4 = 2
            r14 = r13
            r13 = r20
            if (r5 != r4) goto L_0x0710
            int r2 = com.google.android.gms.internal.ads.zzgxe.zza
            com.google.android.gms.internal.ads.zzgyy r10 = (com.google.android.gms.internal.ads.zzgyy) r10
            int r2 = com.google.android.gms.internal.ads.zzgxe.zzh(r3, r15, r7)
            int r4 = r7.zza
            int r4 = r4 + r2
        L_0x06fb:
            if (r2 >= r4) goto L_0x0707
            int r5 = com.google.android.gms.internal.ads.zzgxe.zzb(r3, r2)
            r10.zzi(r5)
            int r2 = r2 + 4
            goto L_0x06fb
        L_0x0707:
            if (r2 != r4) goto L_0x070a
            goto L_0x0755
        L_0x070a:
            com.google.android.gms.internal.ads.zzgzm r2 = new com.google.android.gms.internal.ads.zzgzm
            r2.<init>((java.lang.String) r1)
            throw r2
        L_0x0710:
            r4 = 5
            if (r5 != r4) goto L_0x0684
            int r1 = r15 + 4
            int r2 = com.google.android.gms.internal.ads.zzgxe.zza
            com.google.android.gms.internal.ads.zzgyy r10 = (com.google.android.gms.internal.ads.zzgyy) r10
            int r2 = com.google.android.gms.internal.ads.zzgxe.zzb(r3, r15)
            r10.zzi(r2)
        L_0x0720:
            if (r1 >= r9) goto L_0x078d
            int r2 = com.google.android.gms.internal.ads.zzgxe.zzh(r3, r1, r7)
            int r4 = r7.zza
            if (r12 != r4) goto L_0x078d
            int r1 = com.google.android.gms.internal.ads.zzgxe.zzb(r3, r2)
            r10.zzi(r1)
            int r1 = r2 + 4
            goto L_0x0720
        L_0x0734:
            r9 = r7
            r7 = r14
            r4 = 2
            r14 = r13
            r13 = r20
            if (r5 != r4) goto L_0x075d
            int r2 = com.google.android.gms.internal.ads.zzgxe.zza
            com.google.android.gms.internal.ads.zzgzx r10 = (com.google.android.gms.internal.ads.zzgzx) r10
            int r2 = com.google.android.gms.internal.ads.zzgxe.zzh(r3, r15, r7)
            int r4 = r7.zza
            int r4 = r4 + r2
        L_0x0747:
            if (r2 >= r4) goto L_0x0753
            long r5 = com.google.android.gms.internal.ads.zzgxe.zzn(r3, r2)
            r10.zzg(r5)
            int r2 = r2 + 8
            goto L_0x0747
        L_0x0753:
            if (r2 != r4) goto L_0x0757
        L_0x0755:
            r1 = r2
            goto L_0x078d
        L_0x0757:
            com.google.android.gms.internal.ads.zzgzm r2 = new com.google.android.gms.internal.ads.zzgzm
            r2.<init>((java.lang.String) r1)
            throw r2
        L_0x075d:
            r4 = 1
            if (r5 != r4) goto L_0x0684
            int r1 = r15 + 8
            int r2 = com.google.android.gms.internal.ads.zzgxe.zza
            com.google.android.gms.internal.ads.zzgzx r10 = (com.google.android.gms.internal.ads.zzgzx) r10
            long r4 = com.google.android.gms.internal.ads.zzgxe.zzn(r3, r15)
            r10.zzg(r4)
        L_0x076d:
            if (r1 >= r9) goto L_0x078d
            int r2 = com.google.android.gms.internal.ads.zzgxe.zzh(r3, r1, r7)
            int r4 = r7.zza
            if (r12 != r4) goto L_0x078d
            long r4 = com.google.android.gms.internal.ads.zzgxe.zzn(r3, r2)
            r10.zzg(r4)
            int r1 = r2 + 8
            goto L_0x076d
        L_0x0781:
            r9 = r7
            r7 = r14
            r4 = 2
            r14 = r13
            r13 = r20
            if (r5 != r4) goto L_0x0790
            int r1 = com.google.android.gms.internal.ads.zzgxe.zzf(r3, r15, r10, r7)
        L_0x078d:
            r3 = r7
            goto L_0x08bd
        L_0x0790:
            if (r5 != 0) goto L_0x0684
            r2 = r3
            r6 = r7
            r4 = r9
            r5 = r10
            r1 = r12
            r3 = r15
            int r5 = com.google.android.gms.internal.ads.zzgxe.zzj(r1, r2, r3, r4, r5, r6)
            r3 = r2
            r1 = r5
        L_0x079e:
            r3 = r6
            goto L_0x08bd
        L_0x07a1:
            r9 = r7
            r6 = r14
            r4 = 2
            r14 = r13
            r13 = r20
            if (r5 != r4) goto L_0x07ca
            int r2 = com.google.android.gms.internal.ads.zzgxe.zza
            com.google.android.gms.internal.ads.zzgzx r10 = (com.google.android.gms.internal.ads.zzgzx) r10
            int r2 = com.google.android.gms.internal.ads.zzgxe.zzh(r3, r15, r6)
            int r4 = r6.zza
            int r4 = r4 + r2
        L_0x07b4:
            if (r2 >= r4) goto L_0x07c0
            int r2 = com.google.android.gms.internal.ads.zzgxe.zzk(r3, r2, r6)
            long r7 = r6.zzb
            r10.zzg(r7)
            goto L_0x07b4
        L_0x07c0:
            if (r2 != r4) goto L_0x07c4
            goto L_0x086a
        L_0x07c4:
            com.google.android.gms.internal.ads.zzgzm r2 = new com.google.android.gms.internal.ads.zzgzm
            r2.<init>((java.lang.String) r1)
            throw r2
        L_0x07ca:
            if (r5 != 0) goto L_0x08bb
            int r1 = com.google.android.gms.internal.ads.zzgxe.zza
            com.google.android.gms.internal.ads.zzgzx r10 = (com.google.android.gms.internal.ads.zzgzx) r10
            int r1 = com.google.android.gms.internal.ads.zzgxe.zzk(r3, r15, r6)
            long r4 = r6.zzb
            r10.zzg(r4)
        L_0x07d9:
            if (r1 >= r9) goto L_0x079e
            int r2 = com.google.android.gms.internal.ads.zzgxe.zzh(r3, r1, r6)
            int r4 = r6.zza
            if (r12 != r4) goto L_0x079e
            int r1 = com.google.android.gms.internal.ads.zzgxe.zzk(r3, r2, r6)
            long r4 = r6.zzb
            r10.zzg(r4)
            goto L_0x07d9
        L_0x07ed:
            r9 = r7
            r6 = r14
            r4 = 2
            r14 = r13
            r13 = r20
            if (r5 != r4) goto L_0x0819
            int r2 = com.google.android.gms.internal.ads.zzgxe.zza
            com.google.android.gms.internal.ads.zzgyo r10 = (com.google.android.gms.internal.ads.zzgyo) r10
            int r2 = com.google.android.gms.internal.ads.zzgxe.zzh(r3, r15, r6)
            int r4 = r6.zza
            int r4 = r4 + r2
        L_0x0800:
            if (r2 >= r4) goto L_0x0810
            int r5 = com.google.android.gms.internal.ads.zzgxe.zzb(r3, r2)
            float r5 = java.lang.Float.intBitsToFloat(r5)
            r10.zzh(r5)
            int r2 = r2 + 4
            goto L_0x0800
        L_0x0810:
            if (r2 != r4) goto L_0x0813
            goto L_0x086a
        L_0x0813:
            com.google.android.gms.internal.ads.zzgzm r2 = new com.google.android.gms.internal.ads.zzgzm
            r2.<init>((java.lang.String) r1)
            throw r2
        L_0x0819:
            r4 = 5
            if (r5 != r4) goto L_0x08bb
            int r1 = r15 + 4
            int r2 = com.google.android.gms.internal.ads.zzgxe.zza
            com.google.android.gms.internal.ads.zzgyo r10 = (com.google.android.gms.internal.ads.zzgyo) r10
            int r2 = com.google.android.gms.internal.ads.zzgxe.zzb(r3, r15)
            float r2 = java.lang.Float.intBitsToFloat(r2)
            r10.zzh(r2)
        L_0x082d:
            if (r1 >= r9) goto L_0x079e
            int r2 = com.google.android.gms.internal.ads.zzgxe.zzh(r3, r1, r6)
            int r4 = r6.zza
            if (r12 != r4) goto L_0x079e
            int r1 = com.google.android.gms.internal.ads.zzgxe.zzb(r3, r2)
            float r1 = java.lang.Float.intBitsToFloat(r1)
            r10.zzh(r1)
            int r1 = r2 + 4
            goto L_0x082d
        L_0x0845:
            r9 = r7
            r6 = r14
            r4 = 2
            r14 = r13
            r13 = r20
            if (r5 != r4) goto L_0x0873
            int r2 = com.google.android.gms.internal.ads.zzgxe.zza
            com.google.android.gms.internal.ads.zzgye r10 = (com.google.android.gms.internal.ads.zzgye) r10
            int r2 = com.google.android.gms.internal.ads.zzgxe.zzh(r3, r15, r6)
            int r4 = r6.zza
            int r4 = r4 + r2
        L_0x0858:
            if (r2 >= r4) goto L_0x0868
            long r7 = com.google.android.gms.internal.ads.zzgxe.zzn(r3, r2)
            double r7 = java.lang.Double.longBitsToDouble(r7)
            r10.zzh(r7)
            int r2 = r2 + 8
            goto L_0x0858
        L_0x0868:
            if (r2 != r4) goto L_0x086d
        L_0x086a:
            r1 = r2
            goto L_0x079e
        L_0x086d:
            com.google.android.gms.internal.ads.zzgzm r2 = new com.google.android.gms.internal.ads.zzgzm
            r2.<init>((java.lang.String) r1)
            throw r2
        L_0x0873:
            r4 = 1
            if (r5 != r4) goto L_0x08bb
            int r1 = r15 + 8
            int r2 = com.google.android.gms.internal.ads.zzgxe.zza
            com.google.android.gms.internal.ads.zzgye r10 = (com.google.android.gms.internal.ads.zzgye) r10
            long r4 = com.google.android.gms.internal.ads.zzgxe.zzn(r3, r15)
            double r4 = java.lang.Double.longBitsToDouble(r4)
            r10.zzh(r4)
        L_0x0887:
            if (r1 >= r9) goto L_0x079e
            int r2 = com.google.android.gms.internal.ads.zzgxe.zzh(r3, r1, r6)
            int r4 = r6.zza
            if (r12 != r4) goto L_0x079e
            long r4 = com.google.android.gms.internal.ads.zzgxe.zzn(r3, r2)
            double r4 = java.lang.Double.longBitsToDouble(r4)
            r10.zzh(r4)
            int r1 = r2 + 8
            goto L_0x0887
        L_0x089f:
            if (r7 >= r4) goto L_0x08b8
            r2 = r34
            int r3 = com.google.android.gms.internal.ads.zzgxe.zzh(r2, r7, r6)
            int r8 = r6.zza
            if (r12 != r8) goto L_0x08b8
            int r7 = com.google.android.gms.internal.ads.zzgxe.zzc(r1, r2, r3, r4, r5, r6)
            r3 = r6
            java.lang.Object r2 = r3.zzc
            r10.add(r2)
            r4 = r36
            goto L_0x089f
        L_0x08b8:
            r3 = r6
            r1 = r7
            goto L_0x08bd
        L_0x08bb:
            r3 = r6
        L_0x08bc:
            r1 = r15
        L_0x08bd:
            if (r1 == r15) goto L_0x08d2
            r7 = r34
            r8 = r36
            r10 = r3
            r5 = r11
            r6 = r12
            r4 = r13
            r2 = r14
            r14 = r19
            r15 = r24
            r12 = -1
            r3 = r1
            r1 = r25
            goto L_0x0019
        L_0x08d2:
            r9 = r37
            r15 = r1
            goto L_0x090b
        L_0x08d6:
            r30 = r4
            r4 = r9
            r3 = r14
            r10 = r27
            r14 = r13
            r13 = r20
            r7 = 50
            r8 = r30
            if (r8 != r7) goto L_0x0910
            r7 = 2
            if (r5 != r7) goto L_0x0909
            sun.misc.Unsafe r3 = zzb
            java.lang.Object r4 = r0.zzz(r11)
            java.lang.Object r5 = r3.getObject(r14, r1)
            boolean r6 = com.google.android.gms.internal.ads.zzhad.zza(r5)
            if (r6 == 0) goto L_0x0906
            com.google.android.gms.internal.ads.zzhac r6 = com.google.android.gms.internal.ads.zzhac.zza()
            com.google.android.gms.internal.ads.zzhac r6 = r6.zzb()
            com.google.android.gms.internal.ads.zzhad.zzb(r6, r5)
            r3.putObject(r14, r1, r6)
        L_0x0906:
            com.google.android.gms.internal.ads.zzhab r4 = (com.google.android.gms.internal.ads.zzhab) r4
            throw r17
        L_0x0909:
            r9 = r37
        L_0x090b:
            r10 = r3
        L_0x090c:
            r3 = r34
            goto L_0x0b2b
        L_0x0910:
            int r7 = r11 + 2
            sun.misc.Unsafe r9 = zzb
            r7 = r21[r7]
            r16 = 1048575(0xfffff, float:1.469367E-39)
            r7 = r7 & r16
            r30 = r8
            long r7 = (long) r7
            switch(r30) {
                case 51: goto L_0x0af4;
                case 52: goto L_0x0ad6;
                case 53: goto L_0x0abd;
                case 54: goto L_0x0abd;
                case 55: goto L_0x0aa4;
                case 56: goto L_0x0a89;
                case 57: goto L_0x0a6e;
                case 58: goto L_0x0a4b;
                case 59: goto L_0x0a0d;
                case 60: goto L_0x09e6;
                case 61: goto L_0x09ca;
                case 62: goto L_0x0aa4;
                case 63: goto L_0x0991;
                case 64: goto L_0x0a6e;
                case 65: goto L_0x0a89;
                case 66: goto L_0x0970;
                case 67: goto L_0x0953;
                case 68: goto L_0x0929;
                default: goto L_0x0921;
            }
        L_0x0921:
            r10 = r3
            r18 = r11
            r11 = r15
            r3 = r34
            goto L_0x0b12
        L_0x0929:
            r3 = 3
            if (r5 != r3) goto L_0x094a
            r1 = r12 & -8
            r6 = r1 | 4
            java.lang.Object r1 = r0.zzB(r14, r13, r11)
            com.google.android.gms.internal.ads.zzhbb r2 = r0.zzx(r11)
            r3 = r34
            r5 = r36
            r7 = r38
            r4 = r15
            int r2 = com.google.android.gms.internal.ads.zzgxe.zzl(r1, r2, r3, r4, r5, r6, r7)
            r6 = r7
            r0.zzK(r14, r13, r11, r1)
            r10 = r6
            goto L_0x0a00
        L_0x094a:
            r3 = r34
            r10 = r38
            r18 = r11
            r11 = r15
            goto L_0x0b12
        L_0x0953:
            r6 = r3
            r4 = r15
            r3 = r34
            if (r5 != 0) goto L_0x09e4
            int r5 = com.google.android.gms.internal.ads.zzgxe.zzk(r3, r4, r6)
            r18 = r11
            long r10 = r6.zzb
            long r10 = com.google.android.gms.internal.ads.zzgxv.zzF(r10)
            java.lang.Long r10 = java.lang.Long.valueOf(r10)
            r9.putObject(r14, r1, r10)
            r9.putInt(r14, r7, r13)
            goto L_0x098c
        L_0x0970:
            r6 = r3
            r18 = r11
            r4 = r15
            r3 = r34
            if (r5 != 0) goto L_0x09c6
            int r5 = com.google.android.gms.internal.ads.zzgxe.zzh(r3, r4, r6)
            int r10 = r6.zza
            int r10 = com.google.android.gms.internal.ads.zzgxv.zzD(r10)
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            r9.putObject(r14, r1, r10)
            r9.putInt(r14, r7, r13)
        L_0x098c:
            r11 = r4
            r4 = r5
            r10 = r6
            goto L_0x0b13
        L_0x0991:
            r6 = r3
            r18 = r11
            r4 = r15
            r3 = r34
            if (r5 != 0) goto L_0x09c6
            int r5 = com.google.android.gms.internal.ads.zzgxe.zzh(r3, r4, r6)
            int r10 = r6.zza
            r11 = r18
            com.google.android.gms.internal.ads.zzgzd r15 = r0.zzw(r11)
            if (r15 == 0) goto L_0x09bb
            boolean r15 = r15.zza(r10)
            if (r15 == 0) goto L_0x09ae
            goto L_0x09bb
        L_0x09ae:
            com.google.android.gms.internal.ads.zzhbo r1 = zzd(r14)
            long r7 = (long) r10
            java.lang.Long r2 = java.lang.Long.valueOf(r7)
            r1.zzj(r12, r2)
            goto L_0x09dd
        L_0x09bb:
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            r9.putObject(r14, r1, r10)
            r9.putInt(r14, r7, r13)
            goto L_0x09dd
        L_0x09c6:
            r11 = r4
            r10 = r6
            goto L_0x0b12
        L_0x09ca:
            r6 = r3
            r4 = r15
            r15 = 2
            r3 = r34
            if (r5 != r15) goto L_0x09e4
            int r5 = com.google.android.gms.internal.ads.zzgxe.zza(r3, r4, r6)
            java.lang.Object r10 = r6.zzc
            r9.putObject(r14, r1, r10)
            r9.putInt(r14, r7, r13)
        L_0x09dd:
            r10 = r6
            r18 = r11
            r11 = r4
        L_0x09e1:
            r4 = r5
            goto L_0x0b13
        L_0x09e4:
            r10 = r6
            goto L_0x0a08
        L_0x09e6:
            r6 = r3
            r4 = r15
            r15 = 2
            r3 = r34
            if (r5 != r15) goto L_0x0a06
            java.lang.Object r1 = r0.zzB(r14, r13, r11)
            com.google.android.gms.internal.ads.zzhbb r2 = r0.zzx(r11)
            r5 = r36
            int r2 = com.google.android.gms.internal.ads.zzgxe.zzm(r1, r2, r3, r4, r5, r6)
            r0.zzK(r14, r13, r11, r1)
            r10 = r38
        L_0x0a00:
            r18 = r11
            r11 = r4
            r4 = r2
            goto L_0x0b13
        L_0x0a06:
            r10 = r38
        L_0x0a08:
            r18 = r11
            r11 = r4
            goto L_0x0b12
        L_0x0a0d:
            r27 = r10
            r18 = r11
            r11 = r15
            r15 = 2
            r10 = r3
            r3 = r34
            if (r5 != r15) goto L_0x0b12
            int r5 = com.google.android.gms.internal.ads.zzgxe.zzh(r3, r11, r10)
            int r15 = r10.zza
            if (r15 != 0) goto L_0x0a24
            r9.putObject(r14, r1, r6)
            goto L_0x0a47
        L_0x0a24:
            int r6 = r5 + r15
            r20 = 536870912(0x20000000, float:1.0842022E-19)
            r20 = r27 & r20
            if (r20 == 0) goto L_0x0a39
            boolean r20 = com.google.android.gms.internal.ads.zzhbz.zzi(r3, r5, r6)
            if (r20 == 0) goto L_0x0a33
            goto L_0x0a39
        L_0x0a33:
            com.google.android.gms.internal.ads.zzgzm r1 = new com.google.android.gms.internal.ads.zzgzm
            r1.<init>((java.lang.String) r4)
            throw r1
        L_0x0a39:
            java.lang.String r4 = new java.lang.String
            r35 = r6
            java.nio.charset.Charset r6 = com.google.android.gms.internal.ads.zzgzk.zza
            r4.<init>(r3, r5, r15, r6)
            r9.putObject(r14, r1, r4)
            r5 = r35
        L_0x0a47:
            r9.putInt(r14, r7, r13)
            goto L_0x09e1
        L_0x0a4b:
            r10 = r3
            r18 = r11
            r11 = r15
            r3 = r34
            if (r5 != 0) goto L_0x0b12
            int r4 = com.google.android.gms.internal.ads.zzgxe.zzk(r3, r11, r10)
            long r5 = r10.zzb
            int r5 = (r5 > r22 ? 1 : (r5 == r22 ? 0 : -1))
            if (r5 == 0) goto L_0x0a60
            r26 = 1
            goto L_0x0a62
        L_0x0a60:
            r26 = 0
        L_0x0a62:
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r26)
            r9.putObject(r14, r1, r5)
            r9.putInt(r14, r7, r13)
            goto L_0x0b13
        L_0x0a6e:
            r10 = r3
            r18 = r11
            r11 = r15
            r4 = 5
            r3 = r34
            if (r5 != r4) goto L_0x0b12
            int r4 = r11 + 4
            int r5 = com.google.android.gms.internal.ads.zzgxe.zzb(r3, r11)
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r9.putObject(r14, r1, r5)
            r9.putInt(r14, r7, r13)
            goto L_0x0b13
        L_0x0a89:
            r10 = r3
            r18 = r11
            r11 = r15
            r4 = 1
            r3 = r34
            if (r5 != r4) goto L_0x0b12
            int r4 = r11 + 8
            long r5 = com.google.android.gms.internal.ads.zzgxe.zzn(r3, r11)
            java.lang.Long r5 = java.lang.Long.valueOf(r5)
            r9.putObject(r14, r1, r5)
            r9.putInt(r14, r7, r13)
            goto L_0x0b13
        L_0x0aa4:
            r10 = r3
            r18 = r11
            r11 = r15
            r3 = r34
            if (r5 != 0) goto L_0x0b12
            int r4 = com.google.android.gms.internal.ads.zzgxe.zzh(r3, r11, r10)
            int r5 = r10.zza
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r9.putObject(r14, r1, r5)
            r9.putInt(r14, r7, r13)
            goto L_0x0b13
        L_0x0abd:
            r10 = r3
            r18 = r11
            r11 = r15
            r3 = r34
            if (r5 != 0) goto L_0x0b12
            int r4 = com.google.android.gms.internal.ads.zzgxe.zzk(r3, r11, r10)
            long r5 = r10.zzb
            java.lang.Long r5 = java.lang.Long.valueOf(r5)
            r9.putObject(r14, r1, r5)
            r9.putInt(r14, r7, r13)
            goto L_0x0b13
        L_0x0ad6:
            r10 = r3
            r18 = r11
            r11 = r15
            r4 = 5
            r3 = r34
            if (r5 != r4) goto L_0x0b12
            int r4 = r11 + 4
            int r5 = com.google.android.gms.internal.ads.zzgxe.zzb(r3, r11)
            float r5 = java.lang.Float.intBitsToFloat(r5)
            java.lang.Float r5 = java.lang.Float.valueOf(r5)
            r9.putObject(r14, r1, r5)
            r9.putInt(r14, r7, r13)
            goto L_0x0b13
        L_0x0af4:
            r10 = r3
            r18 = r11
            r11 = r15
            r4 = 1
            r3 = r34
            if (r5 != r4) goto L_0x0b12
            int r4 = r11 + 8
            long r5 = com.google.android.gms.internal.ads.zzgxe.zzn(r3, r11)
            double r5 = java.lang.Double.longBitsToDouble(r5)
            java.lang.Double r5 = java.lang.Double.valueOf(r5)
            r9.putObject(r14, r1, r5)
            r9.putInt(r14, r7, r13)
            goto L_0x0b13
        L_0x0b12:
            r4 = r11
        L_0x0b13:
            if (r4 == r11) goto L_0x0b26
            r8 = r36
            r7 = r3
            r3 = r4
            r6 = r12
            r4 = r13
            r2 = r14
            r5 = r18
            r14 = r19
            r15 = r24
            r1 = r25
            goto L_0x0376
        L_0x0b26:
            r9 = r37
            r15 = r4
            r11 = r18
        L_0x0b2b:
            if (r12 != r9) goto L_0x0b34
            if (r9 == 0) goto L_0x0b34
            r7 = r36
            r6 = r12
            goto L_0x0b91
        L_0x0b34:
            boolean r1 = r0.zzh
            if (r1 == 0) goto L_0x0b63
            com.google.android.gms.internal.ads.zzgyh r1 = r10.zzd
            int r2 = com.google.android.gms.internal.ads.zzgyh.zzb
            int r2 = com.google.android.gms.internal.ads.zzhas.zza
            com.google.android.gms.internal.ads.zzgyh r2 = com.google.android.gms.internal.ads.zzgyh.zza
            if (r1 == r2) goto L_0x0b63
            com.google.android.gms.internal.ads.zzhai r1 = r0.zzg
            com.google.android.gms.internal.ads.zzgyh r2 = r10.zzd
            int r4 = com.google.android.gms.internal.ads.zzgxe.zza
            com.google.android.gms.internal.ads.zzgyv r1 = r2.zzc(r1, r13)
            if (r1 != 0) goto L_0x0b5f
            com.google.android.gms.internal.ads.zzhbo r5 = zzd(r14)
            r4 = r36
            r2 = r3
            r6 = r10
            r1 = r12
            r3 = r15
            int r3 = com.google.android.gms.internal.ads.zzgxe.zzg(r1, r2, r3, r4, r5, r6)
            r7 = r36
            goto L_0x0b74
        L_0x0b5f:
            r1 = r14
            com.google.android.gms.internal.ads.zzgyt r1 = (com.google.android.gms.internal.ads.zzgyt) r1
            throw r17
        L_0x0b63:
            r3 = r15
            com.google.android.gms.internal.ads.zzhbo r5 = zzd(r14)
            r2 = r34
            r4 = r36
            r6 = r38
            r1 = r12
            int r3 = com.google.android.gms.internal.ads.zzgxe.zzg(r1, r2, r3, r4, r5, r6)
            r7 = r4
        L_0x0b74:
            r10 = r38
            r8 = r7
            r5 = r11
            r6 = r12
            r4 = r13
            r2 = r14
            r14 = r19
            r15 = r24
            r1 = r25
            r12 = -1
            r7 = r34
            goto L_0x0019
        L_0x0b86:
            r9 = r37
            r25 = r1
            r7 = r8
            r19 = r14
            r24 = r15
            r14 = r2
            r15 = r3
        L_0x0b91:
            r1 = r19
            r2 = r24
            r12 = 1048575(0xfffff, float:1.469367E-39)
            if (r1 == r12) goto L_0x0ba0
            long r3 = (long) r1
            r1 = r25
            r1.putInt(r14, r3, r2)
        L_0x0ba0:
            int r1 = r0.zzk
            r8 = r1
        L_0x0ba3:
            int r1 = r0.zzl
            if (r8 >= r1) goto L_0x0bbd
            int[] r1 = r0.zzj
            com.google.android.gms.internal.ads.zzhbn r4 = r0.zzm
            r2 = r1[r8]
            r3 = 0
            r5 = r33
            r1 = r14
            r0.zzy(r1, r2, r3, r4, r5)
            com.google.android.gms.internal.ads.zzhbo r3 = (com.google.android.gms.internal.ads.zzhbo) r3
            int r8 = r8 + 1
            r0 = r32
            r14 = r33
            goto L_0x0ba3
        L_0x0bbd:
            java.lang.String r0 = "Failed to parse the message."
            if (r9 != 0) goto L_0x0bca
            if (r15 != r7) goto L_0x0bc4
            goto L_0x0bce
        L_0x0bc4:
            com.google.android.gms.internal.ads.zzgzm r1 = new com.google.android.gms.internal.ads.zzgzm
            r1.<init>((java.lang.String) r0)
            throw r1
        L_0x0bca:
            if (r15 > r7) goto L_0x0bcf
            if (r6 != r9) goto L_0x0bcf
        L_0x0bce:
            return r15
        L_0x0bcf:
            com.google.android.gms.internal.ads.zzgzm r1 = new com.google.android.gms.internal.ads.zzgzm
            r1.<init>((java.lang.String) r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzhal.zzc(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.ads.zzgxd):int");
    }

    public final Object zze() {
        return ((zzgyx) this.zzg).zzbj();
    }

    public final void zzf(Object obj) {
        if (zzQ(obj)) {
            if (obj instanceof zzgyx) {
                zzgyx zzgyx = (zzgyx) obj;
                zzgyx.zzbV();
                zzgyx.zzbU();
                zzgyx.zzbX();
            }
            int[] iArr = this.zzc;
            for (int i = 0; i < iArr.length; i += 3) {
                int zzu = zzu(i);
                int i2 = 1048575 & zzu;
                int zzt = zzt(zzu);
                long j = (long) i2;
                if (zzt != 9) {
                    if (zzt == 60 || zzt == 68) {
                        if (zzR(obj, this.zzc[i], i)) {
                            zzx(i).zzf(zzb.getObject(obj, j));
                        }
                    } else {
                        switch (zzt) {
                            case 17:
                                break;
                            case 18:
                            case 19:
                            case 20:
                            case 21:
                            case 22:
                            case 23:
                            case 24:
                            case 25:
                            case 26:
                            case 27:
                            case 28:
                            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HORIZONTAL_BIAS:
                            case 30:
                            case 31:
                            case 32:
                            case 33:
                            case 34:
                            case 35:
                            case 36:
                            case 37:
                            case 38:
                            case 39:
                            case 40:
                            case 41:
                            case 42:
                            case 43:
                            case 44:
                            case 45:
                            case 46:
                            case 47:
                            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE:
                            case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX:
                                ((zzgzj) zzhbu.zzh(obj, j)).zzb();
                                continue;
                            case 50:
                                Unsafe unsafe = zzb;
                                Object object = unsafe.getObject(obj, j);
                                if (object != null) {
                                    ((zzhac) object).zzc();
                                    unsafe.putObject(obj, j, object);
                                    break;
                                } else {
                                    continue;
                                }
                        }
                    }
                }
                if (zzN(obj, i)) {
                    zzx(i).zzf(zzb.getObject(obj, j));
                }
            }
            this.zzm.zzi(obj);
            if (this.zzh) {
                this.zzn.zza(obj);
            }
        }
    }

    public final void zzg(Object obj, Object obj2) {
        zzD(obj);
        obj2.getClass();
        for (int i = 0; i < this.zzc.length; i += 3) {
            int zzu = zzu(i);
            int i2 = 1048575 & zzu;
            int[] iArr = this.zzc;
            int zzt = zzt(zzu);
            int i3 = iArr[i];
            long j = (long) i2;
            switch (zzt) {
                case 0:
                    if (!zzN(obj2, i)) {
                        break;
                    } else {
                        zzhbu.zzr(obj, j, zzhbu.zzb(obj2, j));
                        zzH(obj, i);
                        break;
                    }
                case 1:
                    if (!zzN(obj2, i)) {
                        break;
                    } else {
                        zzhbu.zzs(obj, j, zzhbu.zzc(obj2, j));
                        zzH(obj, i);
                        break;
                    }
                case 2:
                    if (!zzN(obj2, i)) {
                        break;
                    } else {
                        zzhbu.zzu(obj, j, zzhbu.zzf(obj2, j));
                        zzH(obj, i);
                        break;
                    }
                case 3:
                    if (!zzN(obj2, i)) {
                        break;
                    } else {
                        zzhbu.zzu(obj, j, zzhbu.zzf(obj2, j));
                        zzH(obj, i);
                        break;
                    }
                case 4:
                    if (!zzN(obj2, i)) {
                        break;
                    } else {
                        zzhbu.zzt(obj, j, zzhbu.zzd(obj2, j));
                        zzH(obj, i);
                        break;
                    }
                case 5:
                    if (!zzN(obj2, i)) {
                        break;
                    } else {
                        zzhbu.zzu(obj, j, zzhbu.zzf(obj2, j));
                        zzH(obj, i);
                        break;
                    }
                case 6:
                    if (!zzN(obj2, i)) {
                        break;
                    } else {
                        zzhbu.zzt(obj, j, zzhbu.zzd(obj2, j));
                        zzH(obj, i);
                        break;
                    }
                case 7:
                    if (!zzN(obj2, i)) {
                        break;
                    } else {
                        zzhbu.zzp(obj, j, zzhbu.zzz(obj2, j));
                        zzH(obj, i);
                        break;
                    }
                case 8:
                    if (!zzN(obj2, i)) {
                        break;
                    } else {
                        zzhbu.zzv(obj, j, zzhbu.zzh(obj2, j));
                        zzH(obj, i);
                        break;
                    }
                case 9:
                    zzE(obj, obj2, i);
                    break;
                case 10:
                    if (!zzN(obj2, i)) {
                        break;
                    } else {
                        zzhbu.zzv(obj, j, zzhbu.zzh(obj2, j));
                        zzH(obj, i);
                        break;
                    }
                case 11:
                    if (!zzN(obj2, i)) {
                        break;
                    } else {
                        zzhbu.zzt(obj, j, zzhbu.zzd(obj2, j));
                        zzH(obj, i);
                        break;
                    }
                case 12:
                    if (!zzN(obj2, i)) {
                        break;
                    } else {
                        zzhbu.zzt(obj, j, zzhbu.zzd(obj2, j));
                        zzH(obj, i);
                        break;
                    }
                case 13:
                    if (!zzN(obj2, i)) {
                        break;
                    } else {
                        zzhbu.zzt(obj, j, zzhbu.zzd(obj2, j));
                        zzH(obj, i);
                        break;
                    }
                case 14:
                    if (!zzN(obj2, i)) {
                        break;
                    } else {
                        zzhbu.zzu(obj, j, zzhbu.zzf(obj2, j));
                        zzH(obj, i);
                        break;
                    }
                case 15:
                    if (!zzN(obj2, i)) {
                        break;
                    } else {
                        zzhbu.zzt(obj, j, zzhbu.zzd(obj2, j));
                        zzH(obj, i);
                        break;
                    }
                case 16:
                    if (!zzN(obj2, i)) {
                        break;
                    } else {
                        zzhbu.zzu(obj, j, zzhbu.zzf(obj2, j));
                        zzH(obj, i);
                        break;
                    }
                case 17:
                    zzE(obj, obj2, i);
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HORIZONTAL_BIAS:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX:
                    zzgzj zzgzj = (zzgzj) zzhbu.zzh(obj, j);
                    zzgzj zzgzj2 = (zzgzj) zzhbu.zzh(obj2, j);
                    int size = zzgzj.size();
                    int size2 = zzgzj2.size();
                    if (size > 0 && size2 > 0) {
                        if (!zzgzj.zzc()) {
                            zzgzj = zzgzj.zzf(size2 + size);
                        }
                        zzgzj.addAll(zzgzj2);
                    }
                    if (size > 0) {
                        zzgzj2 = zzgzj;
                    }
                    zzhbu.zzv(obj, j, zzgzj2);
                    break;
                case 50:
                    int i4 = zzhbd.zza;
                    zzhbu.zzv(obj, j, zzhad.zzb(zzhbu.zzh(obj, j), zzhbu.zzh(obj2, j)));
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                    if (!zzR(obj2, i3, i)) {
                        break;
                    } else {
                        zzhbu.zzv(obj, j, zzhbu.zzh(obj2, j));
                        zzI(obj, i3, i);
                        break;
                    }
                case LockFreeTaskQueueCore.FROZEN_SHIFT /*60*/:
                    zzF(obj, obj2, i);
                    break;
                case LockFreeTaskQueueCore.CLOSED_SHIFT /*61*/:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (!zzR(obj2, i3, i)) {
                        break;
                    } else {
                        zzhbu.zzv(obj, j, zzhbu.zzh(obj2, j));
                        zzI(obj, i3, i);
                        break;
                    }
                case 68:
                    zzF(obj, obj2, i);
                    break;
            }
        }
        zzhbd.zzq(this.zzm, obj, obj2);
        if (this.zzh) {
            zzhbd.zzp(this.zzn, obj, obj2);
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x0162, code lost:
        r2 = r3;
        r1 = r5;
        r5 = r6;
     */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* JADX WARNING: Removed duplicated region for block: B:196:0x05cc A[SYNTHETIC, Splitter:B:196:0x05cc] */
    /* JADX WARNING: Removed duplicated region for block: B:205:0x05ea  */
    /* JADX WARNING: Removed duplicated region for block: B:216:0x05ff A[LOOP:5: B:214:0x05fb->B:216:0x05ff, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:218:0x060e  */
    /* JADX WARNING: Removed duplicated region for block: B:226:0x05d6 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:235:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzh(java.lang.Object r12, com.google.android.gms.internal.ads.zzhav r13, com.google.android.gms.internal.ads.zzgyh r14) throws java.io.IOException {
        /*
            r11 = this;
            r14.getClass()
            zzD(r12)
            com.google.android.gms.internal.ads.zzhbn r5 = r11.zzm
            r0 = 0
            r4 = r0
        L_0x000a:
            int r2 = r13.zzc()     // Catch:{ all -> 0x05f3 }
            int r1 = r11.zzq(r2)     // Catch:{ all -> 0x05f3 }
            r7 = 0
            if (r1 >= 0) goto L_0x0094
            r1 = 2147483647(0x7fffffff, float:NaN)
            if (r2 != r1) goto L_0x0037
            int r13 = r11.zzk
        L_0x001c:
            int r14 = r11.zzl
            if (r13 >= r14) goto L_0x0030
            int[] r14 = r11.zzj
            r3 = r14[r13]
            r6 = r12
            r1 = r11
            r2 = r12
            r1.zzy(r2, r3, r4, r5, r6)
            r6 = r5
            r5 = r4
            int r13 = r13 + 1
            r5 = r6
            goto L_0x001c
        L_0x0030:
            r6 = r5
            r5 = r4
            r2 = r12
            r5 = r6
            r12 = r11
            goto L_0x05e8
        L_0x0037:
            r1 = r11
            r6 = r5
            r5 = r4
            boolean r3 = r1.zzh     // Catch:{ all -> 0x008b }
            if (r3 != 0) goto L_0x0040
            r2 = r0
            goto L_0x0046
        L_0x0040:
            com.google.android.gms.internal.ads.zzhai r3 = r1.zzg     // Catch:{ all -> 0x008b }
            com.google.android.gms.internal.ads.zzgyv r2 = r14.zzc(r3, r2)     // Catch:{ all -> 0x008b }
        L_0x0046:
            if (r2 != 0) goto L_0x0085
            if (r5 != 0) goto L_0x0054
            java.lang.Object r4 = r6.zza(r12)     // Catch:{ all -> 0x004f }
            goto L_0x0055
        L_0x004f:
            r0 = move-exception
            r13 = r0
            r2 = r12
            r12 = r1
            goto L_0x0090
        L_0x0054:
            r4 = r5
        L_0x0055:
            boolean r2 = r6.zzk(r4, r13, r7)     // Catch:{ all -> 0x007d }
            if (r2 != 0) goto L_0x0078
            int r13 = r1.zzk
        L_0x005d:
            int r14 = r1.zzl
            if (r13 >= r14) goto L_0x0072
            int[] r14 = r1.zzj
            r3 = r14[r13]
            r5 = r6
            r6 = r12
            r2 = r12
            r1.zzy(r2, r3, r4, r5, r6)
            r12 = r1
            r3 = r2
            r6 = r5
            int r13 = r13 + 1
            r12 = r3
            goto L_0x005d
        L_0x0072:
            r3 = r12
            r12 = r1
            r2 = r3
            r5 = r6
            goto L_0x05e8
        L_0x0078:
            r3 = r12
            r12 = r1
        L_0x007a:
            r12 = r3
            r5 = r6
            goto L_0x000a
        L_0x007d:
            r0 = move-exception
            r3 = r12
            r12 = r1
            r13 = r0
            r2 = r3
            r5 = r6
            goto L_0x05f9
        L_0x0085:
            r3 = r12
            r12 = r1
            r13 = r3
            com.google.android.gms.internal.ads.zzgyt r13 = (com.google.android.gms.internal.ads.zzgyt) r13     // Catch:{ all -> 0x0226 }
            throw r0     // Catch:{ all -> 0x0226 }
        L_0x008b:
            r0 = move-exception
            r3 = r12
            r12 = r1
        L_0x008e:
            r13 = r0
            r2 = r3
        L_0x0090:
            r1 = r5
            r5 = r6
            goto L_0x05f8
        L_0x0094:
            r3 = r12
            r6 = r5
            r12 = r11
            r5 = r4
            int r4 = r11.zzu(r1)     // Catch:{ all -> 0x05ee }
            int r8 = zzt(r4)     // Catch:{ zzgzl -> 0x05c6 }
            r9 = 1048575(0xfffff, float:1.469367E-39)
            switch(r8) {
                case 0: goto L_0x0595;
                case 1: goto L_0x0583;
                case 2: goto L_0x0571;
                case 3: goto L_0x055f;
                case 4: goto L_0x054d;
                case 5: goto L_0x053a;
                case 6: goto L_0x0527;
                case 7: goto L_0x0514;
                case 8: goto L_0x0505;
                case 9: goto L_0x04ef;
                case 10: goto L_0x04dc;
                case 11: goto L_0x04c9;
                case 12: goto L_0x04a1;
                case 13: goto L_0x048e;
                case 14: goto L_0x047b;
                case 15: goto L_0x0468;
                case 16: goto L_0x0455;
                case 17: goto L_0x043f;
                case 18: goto L_0x0430;
                case 19: goto L_0x0421;
                case 20: goto L_0x0412;
                case 21: goto L_0x0403;
                case 22: goto L_0x03f4;
                case 23: goto L_0x03e5;
                case 24: goto L_0x03d6;
                case 25: goto L_0x03c7;
                case 26: goto L_0x039f;
                case 27: goto L_0x038c;
                case 28: goto L_0x037d;
                case 29: goto L_0x036e;
                case 30: goto L_0x0344;
                case 31: goto L_0x0335;
                case 32: goto L_0x0326;
                case 33: goto L_0x0317;
                case 34: goto L_0x0308;
                case 35: goto L_0x02f9;
                case 36: goto L_0x02ea;
                case 37: goto L_0x02db;
                case 38: goto L_0x02cc;
                case 39: goto L_0x02bd;
                case 40: goto L_0x02ae;
                case 41: goto L_0x029f;
                case 42: goto L_0x0290;
                case 43: goto L_0x0281;
                case 44: goto L_0x0269;
                case 45: goto L_0x025d;
                case 46: goto L_0x0251;
                case 47: goto L_0x0245;
                case 48: goto L_0x0239;
                case 49: goto L_0x0229;
                case 50: goto L_0x01f0;
                case 51: goto L_0x01de;
                case 52: goto L_0x01cd;
                case 53: goto L_0x01bc;
                case 54: goto L_0x01ab;
                case 55: goto L_0x019a;
                case 56: goto L_0x0189;
                case 57: goto L_0x0178;
                case 58: goto L_0x0167;
                case 59: goto L_0x015c;
                case 60: goto L_0x014b;
                case 61: goto L_0x013e;
                case 62: goto L_0x012d;
                case 63: goto L_0x0109;
                case 64: goto L_0x00f8;
                case 65: goto L_0x00e7;
                case 66: goto L_0x00d5;
                case 67: goto L_0x00c3;
                case 68: goto L_0x00b1;
                default: goto L_0x00a6;
            }
        L_0x00a6:
            r2 = r3
            r1 = r5
            r5 = r6
            if (r1 != 0) goto L_0x05aa
            java.lang.Object r4 = r5.zza(r2)     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            goto L_0x05ab
        L_0x00b1:
            java.lang.Object r4 = r11.zzB(r3, r2, r1)     // Catch:{  }
            com.google.android.gms.internal.ads.zzhai r4 = (com.google.android.gms.internal.ads.zzhai) r4     // Catch:{  }
            com.google.android.gms.internal.ads.zzhbb r8 = r11.zzx(r1)     // Catch:{  }
            r13.zzt(r4, r8, r14)     // Catch:{  }
            r11.zzK(r3, r2, r1, r4)     // Catch:{  }
            goto L_0x0162
        L_0x00c3:
            r4 = r4 & r9
            long r8 = r13.zzn()     // Catch:{  }
            java.lang.Long r8 = java.lang.Long.valueOf(r8)     // Catch:{  }
            long r9 = (long) r4     // Catch:{  }
            com.google.android.gms.internal.ads.zzhbu.zzv(r3, r9, r8)     // Catch:{  }
            r11.zzI(r3, r2, r1)     // Catch:{  }
            goto L_0x0162
        L_0x00d5:
            r4 = r4 & r9
            int r8 = r13.zzi()     // Catch:{  }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{  }
            long r9 = (long) r4     // Catch:{  }
            com.google.android.gms.internal.ads.zzhbu.zzv(r3, r9, r8)     // Catch:{  }
            r11.zzI(r3, r2, r1)     // Catch:{  }
            goto L_0x0162
        L_0x00e7:
            r4 = r4 & r9
            long r8 = r13.zzm()     // Catch:{  }
            java.lang.Long r8 = java.lang.Long.valueOf(r8)     // Catch:{  }
            long r9 = (long) r4     // Catch:{  }
            com.google.android.gms.internal.ads.zzhbu.zzv(r3, r9, r8)     // Catch:{  }
            r11.zzI(r3, r2, r1)     // Catch:{  }
            goto L_0x0162
        L_0x00f8:
            r4 = r4 & r9
            int r8 = r13.zzh()     // Catch:{  }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{  }
            long r9 = (long) r4     // Catch:{  }
            com.google.android.gms.internal.ads.zzhbu.zzv(r3, r9, r8)     // Catch:{  }
            r11.zzI(r3, r2, r1)     // Catch:{  }
            goto L_0x0162
        L_0x0109:
            int r8 = r13.zze()     // Catch:{  }
            com.google.android.gms.internal.ads.zzgzd r10 = r11.zzw(r1)     // Catch:{  }
            if (r10 == 0) goto L_0x0120
            boolean r10 = r10.zza(r8)     // Catch:{  }
            if (r10 == 0) goto L_0x011a
            goto L_0x0120
        L_0x011a:
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzhbd.zzo(r3, r2, r8, r5, r6)     // Catch:{  }
            goto L_0x007a
        L_0x0120:
            r4 = r4 & r9
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{  }
            long r9 = (long) r4     // Catch:{  }
            com.google.android.gms.internal.ads.zzhbu.zzv(r3, r9, r8)     // Catch:{  }
            r11.zzI(r3, r2, r1)     // Catch:{  }
            goto L_0x0162
        L_0x012d:
            r4 = r4 & r9
            int r8 = r13.zzj()     // Catch:{  }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{  }
            long r9 = (long) r4     // Catch:{  }
            com.google.android.gms.internal.ads.zzhbu.zzv(r3, r9, r8)     // Catch:{  }
            r11.zzI(r3, r2, r1)     // Catch:{  }
            goto L_0x0162
        L_0x013e:
            r4 = r4 & r9
            com.google.android.gms.internal.ads.zzgxp r8 = r13.zzp()     // Catch:{  }
            long r9 = (long) r4     // Catch:{  }
            com.google.android.gms.internal.ads.zzhbu.zzv(r3, r9, r8)     // Catch:{  }
            r11.zzI(r3, r2, r1)     // Catch:{  }
            goto L_0x0162
        L_0x014b:
            java.lang.Object r4 = r11.zzB(r3, r2, r1)     // Catch:{  }
            com.google.android.gms.internal.ads.zzhai r4 = (com.google.android.gms.internal.ads.zzhai) r4     // Catch:{  }
            com.google.android.gms.internal.ads.zzhbb r8 = r11.zzx(r1)     // Catch:{  }
            r13.zzu(r4, r8, r14)     // Catch:{  }
            r11.zzK(r3, r2, r1, r4)     // Catch:{  }
            goto L_0x0162
        L_0x015c:
            r11.zzG(r3, r4, r13)     // Catch:{  }
            r11.zzI(r3, r2, r1)     // Catch:{  }
        L_0x0162:
            r2 = r3
            r1 = r5
            r5 = r6
            goto L_0x05a6
        L_0x0167:
            r4 = r4 & r9
            boolean r8 = r13.zzN()     // Catch:{  }
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r8)     // Catch:{  }
            long r9 = (long) r4     // Catch:{  }
            com.google.android.gms.internal.ads.zzhbu.zzv(r3, r9, r8)     // Catch:{  }
            r11.zzI(r3, r2, r1)     // Catch:{  }
            goto L_0x0162
        L_0x0178:
            r4 = r4 & r9
            int r8 = r13.zzf()     // Catch:{  }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{  }
            long r9 = (long) r4     // Catch:{  }
            com.google.android.gms.internal.ads.zzhbu.zzv(r3, r9, r8)     // Catch:{  }
            r11.zzI(r3, r2, r1)     // Catch:{  }
            goto L_0x0162
        L_0x0189:
            r4 = r4 & r9
            long r8 = r13.zzk()     // Catch:{  }
            java.lang.Long r8 = java.lang.Long.valueOf(r8)     // Catch:{  }
            long r9 = (long) r4     // Catch:{  }
            com.google.android.gms.internal.ads.zzhbu.zzv(r3, r9, r8)     // Catch:{  }
            r11.zzI(r3, r2, r1)     // Catch:{  }
            goto L_0x0162
        L_0x019a:
            r4 = r4 & r9
            int r8 = r13.zzg()     // Catch:{  }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{  }
            long r9 = (long) r4     // Catch:{  }
            com.google.android.gms.internal.ads.zzhbu.zzv(r3, r9, r8)     // Catch:{  }
            r11.zzI(r3, r2, r1)     // Catch:{  }
            goto L_0x0162
        L_0x01ab:
            r4 = r4 & r9
            long r8 = r13.zzo()     // Catch:{  }
            java.lang.Long r8 = java.lang.Long.valueOf(r8)     // Catch:{  }
            long r9 = (long) r4     // Catch:{  }
            com.google.android.gms.internal.ads.zzhbu.zzv(r3, r9, r8)     // Catch:{  }
            r11.zzI(r3, r2, r1)     // Catch:{  }
            goto L_0x0162
        L_0x01bc:
            r4 = r4 & r9
            long r8 = r13.zzl()     // Catch:{  }
            java.lang.Long r8 = java.lang.Long.valueOf(r8)     // Catch:{  }
            long r9 = (long) r4     // Catch:{  }
            com.google.android.gms.internal.ads.zzhbu.zzv(r3, r9, r8)     // Catch:{  }
            r11.zzI(r3, r2, r1)     // Catch:{  }
            goto L_0x0162
        L_0x01cd:
            r4 = r4 & r9
            float r8 = r13.zzb()     // Catch:{  }
            java.lang.Float r8 = java.lang.Float.valueOf(r8)     // Catch:{  }
            long r9 = (long) r4     // Catch:{  }
            com.google.android.gms.internal.ads.zzhbu.zzv(r3, r9, r8)     // Catch:{  }
            r11.zzI(r3, r2, r1)     // Catch:{  }
            goto L_0x0162
        L_0x01de:
            r4 = r4 & r9
            double r8 = r13.zza()     // Catch:{  }
            java.lang.Double r8 = java.lang.Double.valueOf(r8)     // Catch:{  }
            long r9 = (long) r4     // Catch:{  }
            com.google.android.gms.internal.ads.zzhbu.zzv(r3, r9, r8)     // Catch:{  }
            r11.zzI(r3, r2, r1)     // Catch:{  }
            goto L_0x0162
        L_0x01f0:
            java.lang.Object r2 = r11.zzz(r1)     // Catch:{  }
            int r1 = r11.zzu(r1)     // Catch:{  }
            r1 = r1 & r9
            long r8 = (long) r1     // Catch:{  }
            java.lang.Object r1 = com.google.android.gms.internal.ads.zzhbu.zzh(r3, r8)     // Catch:{  }
            if (r1 == 0) goto L_0x0216
            boolean r4 = com.google.android.gms.internal.ads.zzhad.zza(r1)     // Catch:{  }
            if (r4 == 0) goto L_0x0221
            com.google.android.gms.internal.ads.zzhac r4 = com.google.android.gms.internal.ads.zzhac.zza()     // Catch:{  }
            com.google.android.gms.internal.ads.zzhac r4 = r4.zzb()     // Catch:{  }
            com.google.android.gms.internal.ads.zzhad.zzb(r4, r1)     // Catch:{  }
            com.google.android.gms.internal.ads.zzhbu.zzv(r3, r8, r4)     // Catch:{  }
            r1 = r4
            goto L_0x0221
        L_0x0216:
            com.google.android.gms.internal.ads.zzhac r1 = com.google.android.gms.internal.ads.zzhac.zza()     // Catch:{  }
            com.google.android.gms.internal.ads.zzhac r1 = r1.zzb()     // Catch:{  }
            com.google.android.gms.internal.ads.zzhbu.zzv(r3, r8, r1)     // Catch:{  }
        L_0x0221:
            com.google.android.gms.internal.ads.zzhac r1 = (com.google.android.gms.internal.ads.zzhac) r1     // Catch:{  }
            com.google.android.gms.internal.ads.zzhab r2 = (com.google.android.gms.internal.ads.zzhab) r2     // Catch:{  }
            throw r0     // Catch:{  }
        L_0x0226:
            r0 = move-exception
            goto L_0x008e
        L_0x0229:
            r2 = r4 & r9
            com.google.android.gms.internal.ads.zzhbb r1 = r11.zzx(r1)     // Catch:{  }
            long r8 = (long) r2     // Catch:{  }
            java.util.List r2 = com.google.android.gms.internal.ads.zzgzv.zza(r3, r8)     // Catch:{  }
            r13.zzC(r2, r1, r14)     // Catch:{  }
            goto L_0x0162
        L_0x0239:
            r1 = r4 & r9
            long r1 = (long) r1     // Catch:{  }
            java.util.List r1 = com.google.android.gms.internal.ads.zzgzv.zza(r3, r1)     // Catch:{  }
            r13.zzJ(r1)     // Catch:{  }
            goto L_0x0162
        L_0x0245:
            r1 = r4 & r9
            long r1 = (long) r1     // Catch:{  }
            java.util.List r1 = com.google.android.gms.internal.ads.zzgzv.zza(r3, r1)     // Catch:{  }
            r13.zzI(r1)     // Catch:{  }
            goto L_0x0162
        L_0x0251:
            r1 = r4 & r9
            long r1 = (long) r1     // Catch:{  }
            java.util.List r1 = com.google.android.gms.internal.ads.zzgzv.zza(r3, r1)     // Catch:{  }
            r13.zzH(r1)     // Catch:{  }
            goto L_0x0162
        L_0x025d:
            r1 = r4 & r9
            long r1 = (long) r1     // Catch:{  }
            java.util.List r1 = com.google.android.gms.internal.ads.zzgzv.zza(r3, r1)     // Catch:{  }
            r13.zzG(r1)     // Catch:{  }
            goto L_0x0162
        L_0x0269:
            r4 = r4 & r9
            long r8 = (long) r4
            java.util.List r4 = com.google.android.gms.internal.ads.zzgzv.zza(r3, r8)     // Catch:{ zzgzl -> 0x05c6 }
            r13.zzy(r4)     // Catch:{ zzgzl -> 0x05c6 }
            r8 = r1
            r1 = r3
            r3 = r4
            com.google.android.gms.internal.ads.zzgzd r4 = r11.zzw(r8)     // Catch:{ zzgzl -> 0x0364, all -> 0x0360 }
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzhbd.zzn(r1, r2, r3, r4, r5, r6)     // Catch:{ zzgzl -> 0x0364, all -> 0x0360 }
            r2 = r1
            r5 = r6
            goto L_0x05a7
        L_0x0281:
            r2 = r3
            r1 = r5
            r5 = r6
            r3 = r4 & r9
            long r3 = (long) r3
            java.util.List r3 = com.google.android.gms.internal.ads.zzgzv.zza(r2, r3)     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            r13.zzL(r3)     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            goto L_0x05a6
        L_0x0290:
            r2 = r3
            r1 = r5
            r5 = r6
            r3 = r4 & r9
            long r3 = (long) r3     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            java.util.List r3 = com.google.android.gms.internal.ads.zzgzv.zza(r2, r3)     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            r13.zzv(r3)     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            goto L_0x05a6
        L_0x029f:
            r2 = r3
            r1 = r5
            r5 = r6
            r3 = r4 & r9
            long r3 = (long) r3     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            java.util.List r3 = com.google.android.gms.internal.ads.zzgzv.zza(r2, r3)     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            r13.zzz(r3)     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            goto L_0x05a6
        L_0x02ae:
            r2 = r3
            r1 = r5
            r5 = r6
            r3 = r4 & r9
            long r3 = (long) r3     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            java.util.List r3 = com.google.android.gms.internal.ads.zzgzv.zza(r2, r3)     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            r13.zzA(r3)     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            goto L_0x05a6
        L_0x02bd:
            r2 = r3
            r1 = r5
            r5 = r6
            r3 = r4 & r9
            long r3 = (long) r3     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            java.util.List r3 = com.google.android.gms.internal.ads.zzgzv.zza(r2, r3)     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            r13.zzD(r3)     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            goto L_0x05a6
        L_0x02cc:
            r2 = r3
            r1 = r5
            r5 = r6
            r3 = r4 & r9
            long r3 = (long) r3     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            java.util.List r3 = com.google.android.gms.internal.ads.zzgzv.zza(r2, r3)     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            r13.zzM(r3)     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            goto L_0x05a6
        L_0x02db:
            r2 = r3
            r1 = r5
            r5 = r6
            r3 = r4 & r9
            long r3 = (long) r3     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            java.util.List r3 = com.google.android.gms.internal.ads.zzgzv.zza(r2, r3)     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            r13.zzE(r3)     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            goto L_0x05a6
        L_0x02ea:
            r2 = r3
            r1 = r5
            r5 = r6
            r3 = r4 & r9
            long r3 = (long) r3     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            java.util.List r3 = com.google.android.gms.internal.ads.zzgzv.zza(r2, r3)     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            r13.zzB(r3)     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            goto L_0x05a6
        L_0x02f9:
            r2 = r3
            r1 = r5
            r5 = r6
            r3 = r4 & r9
            long r3 = (long) r3     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            java.util.List r3 = com.google.android.gms.internal.ads.zzgzv.zza(r2, r3)     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            r13.zzx(r3)     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            goto L_0x05a6
        L_0x0308:
            r2 = r3
            r1 = r5
            r5 = r6
            r3 = r4 & r9
            long r3 = (long) r3     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            java.util.List r3 = com.google.android.gms.internal.ads.zzgzv.zza(r2, r3)     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            r13.zzJ(r3)     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            goto L_0x05a6
        L_0x0317:
            r2 = r3
            r1 = r5
            r5 = r6
            r3 = r4 & r9
            long r3 = (long) r3     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            java.util.List r3 = com.google.android.gms.internal.ads.zzgzv.zza(r2, r3)     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            r13.zzI(r3)     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            goto L_0x05a6
        L_0x0326:
            r2 = r3
            r1 = r5
            r5 = r6
            r3 = r4 & r9
            long r3 = (long) r3     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            java.util.List r3 = com.google.android.gms.internal.ads.zzgzv.zza(r2, r3)     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            r13.zzH(r3)     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            goto L_0x05a6
        L_0x0335:
            r2 = r3
            r1 = r5
            r5 = r6
            r3 = r4 & r9
            long r3 = (long) r3     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            java.util.List r3 = com.google.android.gms.internal.ads.zzgzv.zza(r2, r3)     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            r13.zzG(r3)     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            goto L_0x05a6
        L_0x0344:
            r8 = r1
            r1 = r5
            r5 = r6
            r4 = r4 & r9
            long r9 = (long) r4
            java.util.List r4 = com.google.android.gms.internal.ads.zzgzv.zza(r3, r9)     // Catch:{ zzgzl -> 0x036b, all -> 0x0367 }
            r13.zzy(r4)     // Catch:{ zzgzl -> 0x036b, all -> 0x0367 }
            r6 = r5
            r5 = r1
            r1 = r3
            r3 = r4
            com.google.android.gms.internal.ads.zzgzd r4 = r11.zzw(r8)     // Catch:{ zzgzl -> 0x0364, all -> 0x0360 }
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzhbd.zzn(r1, r2, r3, r4, r5, r6)     // Catch:{ zzgzl -> 0x0364, all -> 0x0360 }
            r2 = r1
            r5 = r6
            goto L_0x05a7
        L_0x0360:
            r0 = move-exception
            r2 = r1
            goto L_0x05f0
        L_0x0364:
            r2 = r1
            goto L_0x05c7
        L_0x0367:
            r0 = move-exception
            r2 = r3
            goto L_0x05f7
        L_0x036b:
            r2 = r3
            goto L_0x05c9
        L_0x036e:
            r2 = r3
            r1 = r5
            r5 = r6
            r3 = r4 & r9
            long r3 = (long) r3
            java.util.List r3 = com.google.android.gms.internal.ads.zzgzv.zza(r2, r3)     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            r13.zzL(r3)     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            goto L_0x05a6
        L_0x037d:
            r2 = r3
            r1 = r5
            r5 = r6
            r3 = r4 & r9
            long r3 = (long) r3     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            java.util.List r3 = com.google.android.gms.internal.ads.zzgzv.zza(r2, r3)     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            r13.zzw(r3)     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            goto L_0x05a6
        L_0x038c:
            r8 = r1
            r2 = r3
            r1 = r5
            r5 = r6
            com.google.android.gms.internal.ads.zzhbb r3 = r11.zzx(r8)     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            r4 = r4 & r9
            long r8 = (long) r4     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            java.util.List r4 = com.google.android.gms.internal.ads.zzgzv.zza(r2, r8)     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            r13.zzF(r4, r3, r14)     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            goto L_0x05a6
        L_0x039f:
            r2 = r3
            r1 = r5
            r5 = r6
            boolean r3 = zzM(r4)     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            if (r3 == 0) goto L_0x03b8
            r3 = r4 & r9
            long r3 = (long) r3     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            java.util.List r3 = com.google.android.gms.internal.ads.zzgzv.zza(r2, r3)     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            r4 = r13
            com.google.android.gms.internal.ads.zzgxw r4 = (com.google.android.gms.internal.ads.zzgxw) r4     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            r6 = 1
            r4.zzK(r3, r6)     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            goto L_0x05a6
        L_0x03b8:
            r3 = r4 & r9
            long r3 = (long) r3     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            java.util.List r3 = com.google.android.gms.internal.ads.zzgzv.zza(r2, r3)     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            r4 = r13
            com.google.android.gms.internal.ads.zzgxw r4 = (com.google.android.gms.internal.ads.zzgxw) r4     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            r4.zzK(r3, r7)     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            goto L_0x05a6
        L_0x03c7:
            r2 = r3
            r1 = r5
            r5 = r6
            r3 = r4 & r9
            long r3 = (long) r3     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            java.util.List r3 = com.google.android.gms.internal.ads.zzgzv.zza(r2, r3)     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            r13.zzv(r3)     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            goto L_0x05a6
        L_0x03d6:
            r2 = r3
            r1 = r5
            r5 = r6
            r3 = r4 & r9
            long r3 = (long) r3     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            java.util.List r3 = com.google.android.gms.internal.ads.zzgzv.zza(r2, r3)     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            r13.zzz(r3)     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            goto L_0x05a6
        L_0x03e5:
            r2 = r3
            r1 = r5
            r5 = r6
            r3 = r4 & r9
            long r3 = (long) r3     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            java.util.List r3 = com.google.android.gms.internal.ads.zzgzv.zza(r2, r3)     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            r13.zzA(r3)     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            goto L_0x05a6
        L_0x03f4:
            r2 = r3
            r1 = r5
            r5 = r6
            r3 = r4 & r9
            long r3 = (long) r3     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            java.util.List r3 = com.google.android.gms.internal.ads.zzgzv.zza(r2, r3)     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            r13.zzD(r3)     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            goto L_0x05a6
        L_0x0403:
            r2 = r3
            r1 = r5
            r5 = r6
            r3 = r4 & r9
            long r3 = (long) r3     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            java.util.List r3 = com.google.android.gms.internal.ads.zzgzv.zza(r2, r3)     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            r13.zzM(r3)     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            goto L_0x05a6
        L_0x0412:
            r2 = r3
            r1 = r5
            r5 = r6
            r3 = r4 & r9
            long r3 = (long) r3     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            java.util.List r3 = com.google.android.gms.internal.ads.zzgzv.zza(r2, r3)     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            r13.zzE(r3)     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            goto L_0x05a6
        L_0x0421:
            r2 = r3
            r1 = r5
            r5 = r6
            r3 = r4 & r9
            long r3 = (long) r3     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            java.util.List r3 = com.google.android.gms.internal.ads.zzgzv.zza(r2, r3)     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            r13.zzB(r3)     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            goto L_0x05a6
        L_0x0430:
            r2 = r3
            r1 = r5
            r5 = r6
            r3 = r4 & r9
            long r3 = (long) r3     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            java.util.List r3 = com.google.android.gms.internal.ads.zzgzv.zza(r2, r3)     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            r13.zzx(r3)     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            goto L_0x05a6
        L_0x043f:
            r8 = r1
            r2 = r3
            r1 = r5
            r5 = r6
            java.lang.Object r3 = r11.zzA(r2, r8)     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            com.google.android.gms.internal.ads.zzhai r3 = (com.google.android.gms.internal.ads.zzhai) r3     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            com.google.android.gms.internal.ads.zzhbb r4 = r11.zzx(r8)     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            r13.zzt(r3, r4, r14)     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            r11.zzJ(r2, r8, r3)     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            goto L_0x05a6
        L_0x0455:
            r8 = r1
            r2 = r3
            r1 = r5
            r5 = r6
            r3 = r4 & r9
            long r9 = r13.zzn()     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            long r3 = (long) r3     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            com.google.android.gms.internal.ads.zzhbu.zzu(r2, r3, r9)     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            r11.zzH(r2, r8)     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            goto L_0x05a6
        L_0x0468:
            r8 = r1
            r2 = r3
            r1 = r5
            r5 = r6
            r3 = r4 & r9
            int r4 = r13.zzi()     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            long r9 = (long) r3     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            com.google.android.gms.internal.ads.zzhbu.zzt(r2, r9, r4)     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            r11.zzH(r2, r8)     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            goto L_0x05a6
        L_0x047b:
            r8 = r1
            r2 = r3
            r1 = r5
            r5 = r6
            r3 = r4 & r9
            long r9 = r13.zzm()     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            long r3 = (long) r3     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            com.google.android.gms.internal.ads.zzhbu.zzu(r2, r3, r9)     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            r11.zzH(r2, r8)     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            goto L_0x05a6
        L_0x048e:
            r8 = r1
            r2 = r3
            r1 = r5
            r5 = r6
            r3 = r4 & r9
            int r4 = r13.zzh()     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            long r9 = (long) r3     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            com.google.android.gms.internal.ads.zzhbu.zzt(r2, r9, r4)     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            r11.zzH(r2, r8)     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            goto L_0x05a6
        L_0x04a1:
            r8 = r3
            r3 = r2
            r2 = r8
            r8 = r1
            r1 = r5
            r5 = r6
            int r6 = r13.zze()     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            com.google.android.gms.internal.ads.zzgzd r10 = r11.zzw(r8)     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            if (r10 == 0) goto L_0x04be
            boolean r10 = r10.zza(r6)     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            if (r10 == 0) goto L_0x04b8
            goto L_0x04be
        L_0x04b8:
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzhbd.zzo(r2, r3, r6, r1, r5)     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            goto L_0x05a7
        L_0x04be:
            r3 = r4 & r9
            long r3 = (long) r3     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            com.google.android.gms.internal.ads.zzhbu.zzt(r2, r3, r6)     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            r11.zzH(r2, r8)     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            goto L_0x05a6
        L_0x04c9:
            r8 = r1
            r2 = r3
            r1 = r5
            r5 = r6
            r3 = r4 & r9
            int r4 = r13.zzj()     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            long r9 = (long) r3     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            com.google.android.gms.internal.ads.zzhbu.zzt(r2, r9, r4)     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            r11.zzH(r2, r8)     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            goto L_0x05a6
        L_0x04dc:
            r8 = r1
            r2 = r3
            r1 = r5
            r5 = r6
            r3 = r4 & r9
            com.google.android.gms.internal.ads.zzgxp r4 = r13.zzp()     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            long r9 = (long) r3     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            com.google.android.gms.internal.ads.zzhbu.zzv(r2, r9, r4)     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            r11.zzH(r2, r8)     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            goto L_0x05a6
        L_0x04ef:
            r8 = r1
            r2 = r3
            r1 = r5
            r5 = r6
            java.lang.Object r3 = r11.zzA(r2, r8)     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            com.google.android.gms.internal.ads.zzhai r3 = (com.google.android.gms.internal.ads.zzhai) r3     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            com.google.android.gms.internal.ads.zzhbb r4 = r11.zzx(r8)     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            r13.zzu(r3, r4, r14)     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            r11.zzJ(r2, r8, r3)     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            goto L_0x05a6
        L_0x0505:
            r8 = r1
            r2 = r3
            r1 = r5
            r5 = r6
            r11.zzG(r2, r4, r13)     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            r11.zzH(r2, r8)     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            goto L_0x05a6
        L_0x0511:
            r0 = move-exception
            goto L_0x05f7
        L_0x0514:
            r8 = r1
            r2 = r3
            r1 = r5
            r5 = r6
            r3 = r4 & r9
            boolean r4 = r13.zzN()     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            long r9 = (long) r3     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            com.google.android.gms.internal.ads.zzhbu.zzp(r2, r9, r4)     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            r11.zzH(r2, r8)     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            goto L_0x05a6
        L_0x0527:
            r8 = r1
            r2 = r3
            r1 = r5
            r5 = r6
            r3 = r4 & r9
            int r4 = r13.zzf()     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            long r9 = (long) r3     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            com.google.android.gms.internal.ads.zzhbu.zzt(r2, r9, r4)     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            r11.zzH(r2, r8)     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            goto L_0x05a6
        L_0x053a:
            r8 = r1
            r2 = r3
            r1 = r5
            r5 = r6
            r3 = r4 & r9
            long r9 = r13.zzk()     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            long r3 = (long) r3     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            com.google.android.gms.internal.ads.zzhbu.zzu(r2, r3, r9)     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            r11.zzH(r2, r8)     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            goto L_0x05a6
        L_0x054d:
            r8 = r1
            r2 = r3
            r1 = r5
            r5 = r6
            r3 = r4 & r9
            int r4 = r13.zzg()     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            long r9 = (long) r3     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            com.google.android.gms.internal.ads.zzhbu.zzt(r2, r9, r4)     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            r11.zzH(r2, r8)     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            goto L_0x05a6
        L_0x055f:
            r8 = r1
            r2 = r3
            r1 = r5
            r5 = r6
            r3 = r4 & r9
            long r9 = r13.zzo()     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            long r3 = (long) r3     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            com.google.android.gms.internal.ads.zzhbu.zzu(r2, r3, r9)     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            r11.zzH(r2, r8)     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            goto L_0x05a6
        L_0x0571:
            r8 = r1
            r2 = r3
            r1 = r5
            r5 = r6
            r3 = r4 & r9
            long r9 = r13.zzl()     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            long r3 = (long) r3     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            com.google.android.gms.internal.ads.zzhbu.zzu(r2, r3, r9)     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            r11.zzH(r2, r8)     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            goto L_0x05a6
        L_0x0583:
            r8 = r1
            r2 = r3
            r1 = r5
            r5 = r6
            r3 = r4 & r9
            float r4 = r13.zzb()     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            long r9 = (long) r3     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            com.google.android.gms.internal.ads.zzhbu.zzs(r2, r9, r4)     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            r11.zzH(r2, r8)     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            goto L_0x05a6
        L_0x0595:
            r8 = r1
            r2 = r3
            r1 = r5
            r5 = r6
            r3 = r4 & r9
            double r9 = r13.zza()     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            long r3 = (long) r3     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            com.google.android.gms.internal.ads.zzhbu.zzr(r2, r3, r9)     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
            r11.zzH(r2, r8)     // Catch:{ zzgzl -> 0x05c9, all -> 0x0511 }
        L_0x05a6:
            r4 = r1
        L_0x05a7:
            r12 = r2
            goto L_0x000a
        L_0x05aa:
            r4 = r1
        L_0x05ab:
            boolean r1 = r5.zzk(r4, r13, r7)     // Catch:{ zzgzl -> 0x05ca }
            if (r1 != 0) goto L_0x05a7
            int r13 = r12.zzk
        L_0x05b3:
            int r14 = r12.zzl
            if (r13 >= r14) goto L_0x05e8
            int[] r14 = r12.zzj
            r3 = r14[r13]
            r6 = r2
            r1 = r12
            r1.zzy(r2, r3, r4, r5, r6)
            int r13 = r13 + 1
            goto L_0x05b3
        L_0x05c3:
            r0 = move-exception
            r13 = r0
            goto L_0x05f9
        L_0x05c6:
            r2 = r3
        L_0x05c7:
            r1 = r5
            r5 = r6
        L_0x05c9:
            r4 = r1
        L_0x05ca:
            if (r4 != 0) goto L_0x05d0
            java.lang.Object r4 = r5.zza(r2)     // Catch:{ all -> 0x05c3 }
        L_0x05d0:
            boolean r1 = r5.zzk(r4, r13, r7)     // Catch:{ all -> 0x05c3 }
            if (r1 != 0) goto L_0x05a7
            int r13 = r12.zzk
        L_0x05d8:
            int r14 = r12.zzl
            if (r13 >= r14) goto L_0x05e8
            int[] r14 = r12.zzj
            r3 = r14[r13]
            r6 = r2
            r1 = r12
            r1.zzy(r2, r3, r4, r5, r6)
            int r13 = r13 + 1
            goto L_0x05d8
        L_0x05e8:
            if (r4 == 0) goto L_0x05ed
            r5.zzj(r2, r4)
        L_0x05ed:
            return
        L_0x05ee:
            r0 = move-exception
            r2 = r3
        L_0x05f0:
            r1 = r5
            r5 = r6
            goto L_0x05f7
        L_0x05f3:
            r0 = move-exception
            r2 = r12
            r1 = r4
            r12 = r11
        L_0x05f7:
            r13 = r0
        L_0x05f8:
            r4 = r1
        L_0x05f9:
            int r14 = r12.zzk
        L_0x05fb:
            int r0 = r12.zzl
            if (r14 >= r0) goto L_0x060c
            int[] r0 = r12.zzj
            r3 = r0[r14]
            r6 = r2
            r1 = r12
            r1.zzy(r2, r3, r4, r5, r6)
            int r14 = r14 + 1
            r12 = r11
            goto L_0x05fb
        L_0x060c:
            if (r4 == 0) goto L_0x0611
            r5.zzj(r2, r4)
        L_0x0611:
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzhal.zzh(java.lang.Object, com.google.android.gms.internal.ads.zzhav, com.google.android.gms.internal.ads.zzgyh):void");
    }

    public final void zzi(Object obj, byte[] bArr, int i, int i2, zzgxd zzgxd) throws IOException {
        zzc(obj, bArr, i, i2, 0, zzgxd);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v7, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: java.util.Map$Entry} */
    /* JADX WARNING: Code restructure failed: missing block: B:172:0x04e1, code lost:
        r0 = r20;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:176:0x04f2, code lost:
        r2 = r2 + 3;
        r5 = r4;
        r4 = r3;
        r3 = r11;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:179:0x04fd  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0031  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzj(java.lang.Object r21, com.google.android.gms.internal.ads.zzhcc r22) throws java.io.IOException {
        /*
            r20 = this;
            r0 = r20
            r1 = r21
            r6 = r22
            boolean r2 = r0.zzh
            if (r2 == 0) goto L_0x0023
            r2 = r1
            com.google.android.gms.internal.ads.zzgyt r2 = (com.google.android.gms.internal.ads.zzgyt) r2
            com.google.android.gms.internal.ads.zzgym r2 = r2.zza
            com.google.android.gms.internal.ads.zzhbj r3 = r2.zza
            boolean r3 = r3.isEmpty()
            if (r3 != 0) goto L_0x0023
            java.util.Iterator r2 = r2.zzf()
            java.lang.Object r3 = r2.next()
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            r8 = r2
            goto L_0x0025
        L_0x0023:
            r3 = 0
            r8 = 0
        L_0x0025:
            int[] r9 = r0.zzc
            sun.misc.Unsafe r10 = zzb
            r2 = 0
            r4 = 1048575(0xfffff, float:1.469367E-39)
            r5 = 0
        L_0x002e:
            int r13 = r9.length
            if (r2 >= r13) goto L_0x04f9
            int r13 = r0.zzu(r2)
            int[] r14 = r0.zzc
            int r15 = zzt(r13)
            r16 = 0
            r7 = r14[r2]
            r12 = 17
            r17 = 1048575(0xfffff, float:1.469367E-39)
            if (r15 > r12) goto L_0x006c
            int r12 = r2 + 2
            r12 = r14[r12]
            r14 = r12 & r17
            if (r14 == r4) goto L_0x005e
            r11 = r17
            r18 = 1
            if (r14 != r11) goto L_0x0056
            r5 = 0
            goto L_0x005c
        L_0x0056:
            long r4 = (long) r14
            int r4 = r10.getInt(r1, r4)
            r5 = r4
        L_0x005c:
            r4 = r14
            goto L_0x0060
        L_0x005e:
            r18 = 1
        L_0x0060:
            int r11 = r12 >>> 20
            int r11 = r18 << r11
            r19 = r11
            r11 = r3
            r3 = r4
            r4 = r5
            r5 = r19
            goto L_0x0072
        L_0x006c:
            r18 = 1
            r11 = r3
            r3 = r4
            r4 = r5
            r5 = 0
        L_0x0072:
            if (r11 == 0) goto L_0x0093
            java.lang.Object r12 = r11.getKey()
            com.google.android.gms.internal.ads.zzgyu r12 = (com.google.android.gms.internal.ads.zzgyu) r12
            int r12 = r12.zza
            if (r12 > r7) goto L_0x0093
            com.google.android.gms.internal.ads.zzgyi r12 = r0.zzn
            r12.zzb(r6, r11)
            boolean r11 = r8.hasNext()
            if (r11 == 0) goto L_0x0090
            java.lang.Object r11 = r8.next()
            java.util.Map$Entry r11 = (java.util.Map.Entry) r11
            goto L_0x0072
        L_0x0090:
            r11 = r16
            goto L_0x0072
        L_0x0093:
            r17 = 1048575(0xfffff, float:1.469367E-39)
            r12 = r13 & r17
            long r12 = (long) r12
            switch(r15) {
                case 0: goto L_0x04e4;
                case 1: goto L_0x04d3;
                case 2: goto L_0x04c4;
                case 3: goto L_0x04b5;
                case 4: goto L_0x04a6;
                case 5: goto L_0x0497;
                case 6: goto L_0x0488;
                case 7: goto L_0x0479;
                case 8: goto L_0x046a;
                case 9: goto L_0x0456;
                case 10: goto L_0x0444;
                case 11: goto L_0x0434;
                case 12: goto L_0x0424;
                case 13: goto L_0x0414;
                case 14: goto L_0x0404;
                case 15: goto L_0x03f4;
                case 16: goto L_0x03e4;
                case 17: goto L_0x03d0;
                case 18: goto L_0x03c0;
                case 19: goto L_0x03b0;
                case 20: goto L_0x03a0;
                case 21: goto L_0x0390;
                case 22: goto L_0x0380;
                case 23: goto L_0x0370;
                case 24: goto L_0x0360;
                case 25: goto L_0x0350;
                case 26: goto L_0x0341;
                case 27: goto L_0x032e;
                case 28: goto L_0x031f;
                case 29: goto L_0x030f;
                case 30: goto L_0x02ff;
                case 31: goto L_0x02ef;
                case 32: goto L_0x02df;
                case 33: goto L_0x02cf;
                case 34: goto L_0x02bf;
                case 35: goto L_0x02ae;
                case 36: goto L_0x029d;
                case 37: goto L_0x028c;
                case 38: goto L_0x027b;
                case 39: goto L_0x026a;
                case 40: goto L_0x0259;
                case 41: goto L_0x0248;
                case 42: goto L_0x0237;
                case 43: goto L_0x0226;
                case 44: goto L_0x0215;
                case 45: goto L_0x0204;
                case 46: goto L_0x01f3;
                case 47: goto L_0x01e2;
                case 48: goto L_0x01d1;
                case 49: goto L_0x01be;
                case 50: goto L_0x01af;
                case 51: goto L_0x01a0;
                case 52: goto L_0x0191;
                case 53: goto L_0x0182;
                case 54: goto L_0x0173;
                case 55: goto L_0x0164;
                case 56: goto L_0x0155;
                case 57: goto L_0x0146;
                case 58: goto L_0x0137;
                case 59: goto L_0x0128;
                case 60: goto L_0x0115;
                case 61: goto L_0x0105;
                case 62: goto L_0x00f7;
                case 63: goto L_0x00e9;
                case 64: goto L_0x00db;
                case 65: goto L_0x00cd;
                case 66: goto L_0x00bf;
                case 67: goto L_0x00b1;
                case 68: goto L_0x009f;
                default: goto L_0x009c;
            }
        L_0x009c:
            r14 = 0
            goto L_0x04f2
        L_0x009f:
            boolean r5 = r0.zzR(r1, r7, r2)
            if (r5 == 0) goto L_0x009c
            java.lang.Object r5 = r10.getObject(r1, r12)
            com.google.android.gms.internal.ads.zzhbb r12 = r0.zzx(r2)
            r6.zzq(r7, r5, r12)
            goto L_0x009c
        L_0x00b1:
            boolean r5 = r0.zzR(r1, r7, r2)
            if (r5 == 0) goto L_0x009c
            long r12 = zzv(r1, r12)
            r6.zzD(r7, r12)
            goto L_0x009c
        L_0x00bf:
            boolean r5 = r0.zzR(r1, r7, r2)
            if (r5 == 0) goto L_0x009c
            int r5 = zzp(r1, r12)
            r6.zzB(r7, r5)
            goto L_0x009c
        L_0x00cd:
            boolean r5 = r0.zzR(r1, r7, r2)
            if (r5 == 0) goto L_0x009c
            long r12 = zzv(r1, r12)
            r6.zzz(r7, r12)
            goto L_0x009c
        L_0x00db:
            boolean r5 = r0.zzR(r1, r7, r2)
            if (r5 == 0) goto L_0x009c
            int r5 = zzp(r1, r12)
            r6.zzx(r7, r5)
            goto L_0x009c
        L_0x00e9:
            boolean r5 = r0.zzR(r1, r7, r2)
            if (r5 == 0) goto L_0x009c
            int r5 = zzp(r1, r12)
            r6.zzi(r7, r5)
            goto L_0x009c
        L_0x00f7:
            boolean r5 = r0.zzR(r1, r7, r2)
            if (r5 == 0) goto L_0x009c
            int r5 = zzp(r1, r12)
            r6.zzI(r7, r5)
            goto L_0x009c
        L_0x0105:
            boolean r5 = r0.zzR(r1, r7, r2)
            if (r5 == 0) goto L_0x009c
            java.lang.Object r5 = r10.getObject(r1, r12)
            com.google.android.gms.internal.ads.zzgxp r5 = (com.google.android.gms.internal.ads.zzgxp) r5
            r6.zzd(r7, r5)
            goto L_0x009c
        L_0x0115:
            boolean r5 = r0.zzR(r1, r7, r2)
            if (r5 == 0) goto L_0x009c
            java.lang.Object r5 = r10.getObject(r1, r12)
            com.google.android.gms.internal.ads.zzhbb r12 = r0.zzx(r2)
            r6.zzv(r7, r5, r12)
            goto L_0x009c
        L_0x0128:
            boolean r5 = r0.zzR(r1, r7, r2)
            if (r5 == 0) goto L_0x009c
            java.lang.Object r5 = r10.getObject(r1, r12)
            zzT(r7, r5, r6)
            goto L_0x009c
        L_0x0137:
            boolean r5 = r0.zzR(r1, r7, r2)
            if (r5 == 0) goto L_0x009c
            boolean r5 = zzS(r1, r12)
            r6.zzb(r7, r5)
            goto L_0x009c
        L_0x0146:
            boolean r5 = r0.zzR(r1, r7, r2)
            if (r5 == 0) goto L_0x009c
            int r5 = zzp(r1, r12)
            r6.zzk(r7, r5)
            goto L_0x009c
        L_0x0155:
            boolean r5 = r0.zzR(r1, r7, r2)
            if (r5 == 0) goto L_0x009c
            long r12 = zzv(r1, r12)
            r6.zzm(r7, r12)
            goto L_0x009c
        L_0x0164:
            boolean r5 = r0.zzR(r1, r7, r2)
            if (r5 == 0) goto L_0x009c
            int r5 = zzp(r1, r12)
            r6.zzr(r7, r5)
            goto L_0x009c
        L_0x0173:
            boolean r5 = r0.zzR(r1, r7, r2)
            if (r5 == 0) goto L_0x009c
            long r12 = zzv(r1, r12)
            r6.zzK(r7, r12)
            goto L_0x009c
        L_0x0182:
            boolean r5 = r0.zzR(r1, r7, r2)
            if (r5 == 0) goto L_0x009c
            long r12 = zzv(r1, r12)
            r6.zzt(r7, r12)
            goto L_0x009c
        L_0x0191:
            boolean r5 = r0.zzR(r1, r7, r2)
            if (r5 == 0) goto L_0x009c
            float r5 = zzo(r1, r12)
            r6.zzo(r7, r5)
            goto L_0x009c
        L_0x01a0:
            boolean r5 = r0.zzR(r1, r7, r2)
            if (r5 == 0) goto L_0x009c
            double r12 = zzn(r1, r12)
            r6.zzf(r7, r12)
            goto L_0x009c
        L_0x01af:
            java.lang.Object r5 = r10.getObject(r1, r12)
            if (r5 != 0) goto L_0x01b7
            goto L_0x009c
        L_0x01b7:
            java.lang.Object r1 = r0.zzz(r2)
            com.google.android.gms.internal.ads.zzhab r1 = (com.google.android.gms.internal.ads.zzhab) r1
            throw r16
        L_0x01be:
            int[] r5 = r0.zzc
            r5 = r5[r2]
            java.lang.Object r7 = r10.getObject(r1, r12)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.ads.zzhbb r12 = r0.zzx(r2)
            com.google.android.gms.internal.ads.zzhbd.zzy(r5, r7, r6, r12)
            goto L_0x009c
        L_0x01d1:
            int[] r5 = r0.zzc
            r5 = r5[r2]
            java.lang.Object r7 = r10.getObject(r1, r12)
            java.util.List r7 = (java.util.List) r7
            r14 = r18
            com.google.android.gms.internal.ads.zzhbd.zzF(r5, r7, r6, r14)
            goto L_0x009c
        L_0x01e2:
            r14 = r18
            int[] r5 = r0.zzc
            r5 = r5[r2]
            java.lang.Object r7 = r10.getObject(r1, r12)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.ads.zzhbd.zzE(r5, r7, r6, r14)
            goto L_0x009c
        L_0x01f3:
            r14 = r18
            int[] r5 = r0.zzc
            r5 = r5[r2]
            java.lang.Object r7 = r10.getObject(r1, r12)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.ads.zzhbd.zzD(r5, r7, r6, r14)
            goto L_0x009c
        L_0x0204:
            r14 = r18
            int[] r5 = r0.zzc
            r5 = r5[r2]
            java.lang.Object r7 = r10.getObject(r1, r12)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.ads.zzhbd.zzC(r5, r7, r6, r14)
            goto L_0x009c
        L_0x0215:
            r14 = r18
            int[] r5 = r0.zzc
            r5 = r5[r2]
            java.lang.Object r7 = r10.getObject(r1, r12)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.ads.zzhbd.zzu(r5, r7, r6, r14)
            goto L_0x009c
        L_0x0226:
            r14 = r18
            int[] r5 = r0.zzc
            r5 = r5[r2]
            java.lang.Object r7 = r10.getObject(r1, r12)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.ads.zzhbd.zzH(r5, r7, r6, r14)
            goto L_0x009c
        L_0x0237:
            r14 = r18
            int[] r5 = r0.zzc
            r5 = r5[r2]
            java.lang.Object r7 = r10.getObject(r1, r12)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.ads.zzhbd.zzr(r5, r7, r6, r14)
            goto L_0x009c
        L_0x0248:
            r14 = r18
            int[] r5 = r0.zzc
            r5 = r5[r2]
            java.lang.Object r7 = r10.getObject(r1, r12)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.ads.zzhbd.zzv(r5, r7, r6, r14)
            goto L_0x009c
        L_0x0259:
            r14 = r18
            int[] r5 = r0.zzc
            r5 = r5[r2]
            java.lang.Object r7 = r10.getObject(r1, r12)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.ads.zzhbd.zzw(r5, r7, r6, r14)
            goto L_0x009c
        L_0x026a:
            r14 = r18
            int[] r5 = r0.zzc
            r5 = r5[r2]
            java.lang.Object r7 = r10.getObject(r1, r12)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.ads.zzhbd.zzz(r5, r7, r6, r14)
            goto L_0x009c
        L_0x027b:
            r14 = r18
            int[] r5 = r0.zzc
            r5 = r5[r2]
            java.lang.Object r7 = r10.getObject(r1, r12)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.ads.zzhbd.zzI(r5, r7, r6, r14)
            goto L_0x009c
        L_0x028c:
            r14 = r18
            int[] r5 = r0.zzc
            r5 = r5[r2]
            java.lang.Object r7 = r10.getObject(r1, r12)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.ads.zzhbd.zzA(r5, r7, r6, r14)
            goto L_0x009c
        L_0x029d:
            r14 = r18
            int[] r5 = r0.zzc
            r5 = r5[r2]
            java.lang.Object r7 = r10.getObject(r1, r12)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.ads.zzhbd.zzx(r5, r7, r6, r14)
            goto L_0x009c
        L_0x02ae:
            r14 = r18
            int[] r5 = r0.zzc
            r5 = r5[r2]
            java.lang.Object r7 = r10.getObject(r1, r12)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.ads.zzhbd.zzt(r5, r7, r6, r14)
            goto L_0x009c
        L_0x02bf:
            int[] r5 = r0.zzc
            r5 = r5[r2]
            java.lang.Object r7 = r10.getObject(r1, r12)
            java.util.List r7 = (java.util.List) r7
            r14 = 0
            com.google.android.gms.internal.ads.zzhbd.zzF(r5, r7, r6, r14)
            goto L_0x04f2
        L_0x02cf:
            r14 = 0
            int[] r5 = r0.zzc
            r5 = r5[r2]
            java.lang.Object r7 = r10.getObject(r1, r12)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.ads.zzhbd.zzE(r5, r7, r6, r14)
            goto L_0x04f2
        L_0x02df:
            r14 = 0
            int[] r5 = r0.zzc
            r5 = r5[r2]
            java.lang.Object r7 = r10.getObject(r1, r12)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.ads.zzhbd.zzD(r5, r7, r6, r14)
            goto L_0x04f2
        L_0x02ef:
            r14 = 0
            int[] r5 = r0.zzc
            r5 = r5[r2]
            java.lang.Object r7 = r10.getObject(r1, r12)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.ads.zzhbd.zzC(r5, r7, r6, r14)
            goto L_0x04f2
        L_0x02ff:
            r14 = 0
            int[] r5 = r0.zzc
            r5 = r5[r2]
            java.lang.Object r7 = r10.getObject(r1, r12)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.ads.zzhbd.zzu(r5, r7, r6, r14)
            goto L_0x04f2
        L_0x030f:
            r14 = 0
            int[] r5 = r0.zzc
            r5 = r5[r2]
            java.lang.Object r7 = r10.getObject(r1, r12)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.ads.zzhbd.zzH(r5, r7, r6, r14)
            goto L_0x04f2
        L_0x031f:
            int[] r5 = r0.zzc
            r5 = r5[r2]
            java.lang.Object r7 = r10.getObject(r1, r12)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.ads.zzhbd.zzs(r5, r7, r6)
            goto L_0x009c
        L_0x032e:
            int[] r5 = r0.zzc
            r5 = r5[r2]
            java.lang.Object r7 = r10.getObject(r1, r12)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.ads.zzhbb r12 = r0.zzx(r2)
            com.google.android.gms.internal.ads.zzhbd.zzB(r5, r7, r6, r12)
            goto L_0x009c
        L_0x0341:
            int[] r5 = r0.zzc
            r5 = r5[r2]
            java.lang.Object r7 = r10.getObject(r1, r12)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.ads.zzhbd.zzG(r5, r7, r6)
            goto L_0x009c
        L_0x0350:
            int[] r5 = r0.zzc
            r5 = r5[r2]
            java.lang.Object r7 = r10.getObject(r1, r12)
            java.util.List r7 = (java.util.List) r7
            r14 = 0
            com.google.android.gms.internal.ads.zzhbd.zzr(r5, r7, r6, r14)
            goto L_0x04f2
        L_0x0360:
            r14 = 0
            int[] r5 = r0.zzc
            r5 = r5[r2]
            java.lang.Object r7 = r10.getObject(r1, r12)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.ads.zzhbd.zzv(r5, r7, r6, r14)
            goto L_0x04f2
        L_0x0370:
            r14 = 0
            int[] r5 = r0.zzc
            r5 = r5[r2]
            java.lang.Object r7 = r10.getObject(r1, r12)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.ads.zzhbd.zzw(r5, r7, r6, r14)
            goto L_0x04f2
        L_0x0380:
            r14 = 0
            int[] r5 = r0.zzc
            r5 = r5[r2]
            java.lang.Object r7 = r10.getObject(r1, r12)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.ads.zzhbd.zzz(r5, r7, r6, r14)
            goto L_0x04f2
        L_0x0390:
            r14 = 0
            int[] r5 = r0.zzc
            r5 = r5[r2]
            java.lang.Object r7 = r10.getObject(r1, r12)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.ads.zzhbd.zzI(r5, r7, r6, r14)
            goto L_0x04f2
        L_0x03a0:
            r14 = 0
            int[] r5 = r0.zzc
            r5 = r5[r2]
            java.lang.Object r7 = r10.getObject(r1, r12)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.ads.zzhbd.zzA(r5, r7, r6, r14)
            goto L_0x04f2
        L_0x03b0:
            r14 = 0
            int[] r5 = r0.zzc
            r5 = r5[r2]
            java.lang.Object r7 = r10.getObject(r1, r12)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.ads.zzhbd.zzx(r5, r7, r6, r14)
            goto L_0x04f2
        L_0x03c0:
            r14 = 0
            int[] r5 = r0.zzc
            r5 = r5[r2]
            java.lang.Object r7 = r10.getObject(r1, r12)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.ads.zzhbd.zzt(r5, r7, r6, r14)
            goto L_0x04f2
        L_0x03d0:
            r14 = 0
            boolean r5 = r0.zzO(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x04f2
            java.lang.Object r5 = r10.getObject(r1, r12)
            com.google.android.gms.internal.ads.zzhbb r12 = r0.zzx(r2)
            r6.zzq(r7, r5, r12)
            goto L_0x04f2
        L_0x03e4:
            r14 = 0
            boolean r5 = r0.zzO(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x04e1
            long r12 = r10.getLong(r1, r12)
            r6.zzD(r7, r12)
            goto L_0x04e1
        L_0x03f4:
            r14 = 0
            boolean r5 = r0.zzO(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x04e1
            int r0 = r10.getInt(r1, r12)
            r6.zzB(r7, r0)
            goto L_0x04e1
        L_0x0404:
            r14 = 0
            boolean r5 = r0.zzO(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x04e1
            long r12 = r10.getLong(r1, r12)
            r6.zzz(r7, r12)
            goto L_0x04e1
        L_0x0414:
            r14 = 0
            boolean r5 = r0.zzO(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x04e1
            int r0 = r10.getInt(r1, r12)
            r6.zzx(r7, r0)
            goto L_0x04e1
        L_0x0424:
            r14 = 0
            boolean r5 = r0.zzO(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x04e1
            int r0 = r10.getInt(r1, r12)
            r6.zzi(r7, r0)
            goto L_0x04e1
        L_0x0434:
            r14 = 0
            boolean r5 = r0.zzO(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x04e1
            int r0 = r10.getInt(r1, r12)
            r6.zzI(r7, r0)
            goto L_0x04e1
        L_0x0444:
            r14 = 0
            boolean r5 = r0.zzO(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x04e1
            java.lang.Object r0 = r10.getObject(r1, r12)
            com.google.android.gms.internal.ads.zzgxp r0 = (com.google.android.gms.internal.ads.zzgxp) r0
            r6.zzd(r7, r0)
            goto L_0x04e1
        L_0x0456:
            r14 = 0
            boolean r5 = r0.zzO(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x04f2
            java.lang.Object r5 = r10.getObject(r1, r12)
            com.google.android.gms.internal.ads.zzhbb r12 = r0.zzx(r2)
            r6.zzv(r7, r5, r12)
            goto L_0x04f2
        L_0x046a:
            r14 = 0
            boolean r5 = r0.zzO(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x04e1
            java.lang.Object r0 = r10.getObject(r1, r12)
            zzT(r7, r0, r6)
            goto L_0x04e1
        L_0x0479:
            r14 = 0
            boolean r5 = r0.zzO(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x04e1
            boolean r0 = com.google.android.gms.internal.ads.zzhbu.zzz(r1, r12)
            r6.zzb(r7, r0)
            goto L_0x04e1
        L_0x0488:
            r14 = 0
            boolean r5 = r0.zzO(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x04e1
            int r0 = r10.getInt(r1, r12)
            r6.zzk(r7, r0)
            goto L_0x04e1
        L_0x0497:
            r14 = 0
            boolean r5 = r0.zzO(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x04e1
            long r12 = r10.getLong(r1, r12)
            r6.zzm(r7, r12)
            goto L_0x04e1
        L_0x04a6:
            r14 = 0
            boolean r5 = r0.zzO(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x04e1
            int r0 = r10.getInt(r1, r12)
            r6.zzr(r7, r0)
            goto L_0x04e1
        L_0x04b5:
            r14 = 0
            boolean r5 = r0.zzO(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x04e1
            long r12 = r10.getLong(r1, r12)
            r6.zzK(r7, r12)
            goto L_0x04e1
        L_0x04c4:
            r14 = 0
            boolean r5 = r0.zzO(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x04e1
            long r12 = r10.getLong(r1, r12)
            r6.zzt(r7, r12)
            goto L_0x04e1
        L_0x04d3:
            r14 = 0
            boolean r5 = r0.zzO(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x04e1
            float r0 = com.google.android.gms.internal.ads.zzhbu.zzc(r1, r12)
            r6.zzo(r7, r0)
        L_0x04e1:
            r0 = r20
            goto L_0x04f2
        L_0x04e4:
            r14 = 0
            boolean r5 = r0.zzO(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x04f2
            double r12 = com.google.android.gms.internal.ads.zzhbu.zzb(r1, r12)
            r6.zzf(r7, r12)
        L_0x04f2:
            int r2 = r2 + 3
            r5 = r4
            r4 = r3
            r3 = r11
            goto L_0x002e
        L_0x04f9:
            r16 = 0
        L_0x04fb:
            if (r3 == 0) goto L_0x0513
            com.google.android.gms.internal.ads.zzgyi r2 = r0.zzn
            r2.zzb(r6, r3)
            boolean r2 = r8.hasNext()
            if (r2 == 0) goto L_0x0510
            java.lang.Object r2 = r8.next()
            r3 = r2
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            goto L_0x04fb
        L_0x0510:
            r3 = r16
            goto L_0x04fb
        L_0x0513:
            com.google.android.gms.internal.ads.zzgyx r1 = (com.google.android.gms.internal.ads.zzgyx) r1
            com.google.android.gms.internal.ads.zzhbo r1 = r1.zzt
            r2 = r1
            com.google.android.gms.internal.ads.zzhbo r2 = (com.google.android.gms.internal.ads.zzhbo) r2
            r1.zzl(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzhal.zzj(java.lang.Object, com.google.android.gms.internal.ads.zzhcc):void");
    }

    public final boolean zzk(Object obj, Object obj2) {
        boolean z;
        for (int i = 0; i < this.zzc.length; i += 3) {
            int zzu = zzu(i);
            long j = (long) (zzu & 1048575);
            switch (zzt(zzu)) {
                case 0:
                    if (zzL(obj, obj2, i) && Double.doubleToLongBits(zzhbu.zzb(obj, j)) == Double.doubleToLongBits(zzhbu.zzb(obj2, j))) {
                        continue;
                    }
                case 1:
                    if (zzL(obj, obj2, i) && Float.floatToIntBits(zzhbu.zzc(obj, j)) == Float.floatToIntBits(zzhbu.zzc(obj2, j))) {
                        continue;
                    }
                case 2:
                    if (zzL(obj, obj2, i) && zzhbu.zzf(obj, j) == zzhbu.zzf(obj2, j)) {
                        continue;
                    }
                case 3:
                    if (zzL(obj, obj2, i) && zzhbu.zzf(obj, j) == zzhbu.zzf(obj2, j)) {
                        continue;
                    }
                case 4:
                    if (zzL(obj, obj2, i) && zzhbu.zzd(obj, j) == zzhbu.zzd(obj2, j)) {
                        continue;
                    }
                case 5:
                    if (zzL(obj, obj2, i) && zzhbu.zzf(obj, j) == zzhbu.zzf(obj2, j)) {
                        continue;
                    }
                case 6:
                    if (zzL(obj, obj2, i) && zzhbu.zzd(obj, j) == zzhbu.zzd(obj2, j)) {
                        continue;
                    }
                case 7:
                    if (zzL(obj, obj2, i) && zzhbu.zzz(obj, j) == zzhbu.zzz(obj2, j)) {
                        continue;
                    }
                case 8:
                    if (zzL(obj, obj2, i) && zzhbd.zzJ(zzhbu.zzh(obj, j), zzhbu.zzh(obj2, j))) {
                        continue;
                    }
                case 9:
                    if (zzL(obj, obj2, i) && zzhbd.zzJ(zzhbu.zzh(obj, j), zzhbu.zzh(obj2, j))) {
                        continue;
                    }
                case 10:
                    if (zzL(obj, obj2, i) && zzhbd.zzJ(zzhbu.zzh(obj, j), zzhbu.zzh(obj2, j))) {
                        continue;
                    }
                case 11:
                    if (zzL(obj, obj2, i) && zzhbu.zzd(obj, j) == zzhbu.zzd(obj2, j)) {
                        continue;
                    }
                case 12:
                    if (zzL(obj, obj2, i) && zzhbu.zzd(obj, j) == zzhbu.zzd(obj2, j)) {
                        continue;
                    }
                case 13:
                    if (zzL(obj, obj2, i) && zzhbu.zzd(obj, j) == zzhbu.zzd(obj2, j)) {
                        continue;
                    }
                case 14:
                    if (zzL(obj, obj2, i) && zzhbu.zzf(obj, j) == zzhbu.zzf(obj2, j)) {
                        continue;
                    }
                case 15:
                    if (zzL(obj, obj2, i) && zzhbu.zzd(obj, j) == zzhbu.zzd(obj2, j)) {
                        continue;
                    }
                case 16:
                    if (zzL(obj, obj2, i) && zzhbu.zzf(obj, j) == zzhbu.zzf(obj2, j)) {
                        continue;
                    }
                case 17:
                    if (zzL(obj, obj2, i) && zzhbd.zzJ(zzhbu.zzh(obj, j), zzhbu.zzh(obj2, j))) {
                        continue;
                    }
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HORIZONTAL_BIAS:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX:
                    z = zzhbd.zzJ(zzhbu.zzh(obj, j), zzhbu.zzh(obj2, j));
                    break;
                case 50:
                    z = zzhbd.zzJ(zzhbu.zzh(obj, j), zzhbu.zzh(obj2, j));
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                case LockFreeTaskQueueCore.FROZEN_SHIFT /*60*/:
                case LockFreeTaskQueueCore.CLOSED_SHIFT /*61*/:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                case 68:
                    long zzr = (long) (zzr(i) & 1048575);
                    if (zzhbu.zzd(obj, zzr) == zzhbu.zzd(obj2, zzr) && zzhbd.zzJ(zzhbu.zzh(obj, j), zzhbu.zzh(obj2, j))) {
                        continue;
                    }
            }
            if (!z) {
                return false;
            }
        }
        if (!((zzgyx) obj).zzt.equals(((zzgyx) obj2).zzt)) {
            return false;
        }
        if (this.zzh) {
            return ((zzgyt) obj).zza.equals(((zzgyt) obj2).zza);
        }
        return true;
    }

    public final boolean zzl(Object obj) {
        int i;
        int i2;
        int i3 = 0;
        int i4 = 0;
        int i5 = 1048575;
        while (i3 < this.zzk) {
            int[] iArr = this.zzj;
            int[] iArr2 = this.zzc;
            int i6 = iArr[i3];
            int i7 = iArr2[i6];
            int zzu = zzu(i6);
            int i8 = this.zzc[i6 + 2];
            int i9 = i8 & 1048575;
            int i10 = 1 << (i8 >>> 20);
            if (i9 != i5) {
                if (i9 != 1048575) {
                    i4 = zzb.getInt(obj, (long) i9);
                }
                i = i4;
                i2 = i9;
            } else {
                i2 = i5;
                i = i4;
            }
            Object obj2 = obj;
            if ((268435456 & zzu) != 0 && !zzO(obj2, i6, i2, i, i10)) {
                return false;
            }
            int zzt = zzt(zzu);
            if (zzt != 9 && zzt != 17) {
                if (zzt != 27) {
                    if (zzt == 60 || zzt == 68) {
                        if (zzR(obj2, i7, i6) && !zzP(obj2, zzu, zzx(i6))) {
                            return false;
                        }
                    } else if (zzt != 49) {
                        if (zzt == 50 && !((zzhac) zzhbu.zzh(obj2, (long) (zzu & 1048575))).isEmpty()) {
                            zzhab zzhab = (zzhab) zzz(i6);
                            throw null;
                        }
                    }
                }
                List list = (List) zzhbu.zzh(obj2, (long) (zzu & 1048575));
                if (!list.isEmpty()) {
                    zzhbb zzx = zzx(i6);
                    for (int i11 = 0; i11 < list.size(); i11++) {
                        if (!zzx.zzl(list.get(i11))) {
                            return false;
                        }
                    }
                    continue;
                } else {
                    continue;
                }
            } else if (zzO(obj2, i6, i2, i, i10) && !zzP(obj2, zzu, zzx(i6))) {
                return false;
            }
            i3++;
            obj = obj2;
            i5 = i2;
            i4 = i;
        }
        return !this.zzh || ((zzgyt) obj).zza.zzi();
    }
}
