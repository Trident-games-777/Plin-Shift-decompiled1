package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@22.1.2 */
public final class zzbe {
    private static zzaf zza(zzaf zzaf, zzh zzh, zzal zzal, Boolean bool, Boolean bool2) {
        zzaf zzaf2 = new zzaf();
        Iterator<Integer> zzg = zzaf.zzg();
        while (zzg.hasNext()) {
            int intValue = zzg.next().intValue();
            if (zzaf.zzc(intValue)) {
                zzaq zza = zzal.zza(zzh, (List<zzaq>) Arrays.asList(new zzaq[]{zzaf.zza(intValue), new zzai(Double.valueOf((double) intValue)), zzaf}));
                if (zza.zzd().equals(bool)) {
                    break;
                } else if (bool2 == null || zza.zzd().equals(bool2)) {
                    zzaf2.zzb(intValue, zza);
                }
            }
        }
        return zzaf2;
    }

    private static zzaf zza(zzaf zzaf, zzh zzh, zzal zzal) {
        return zza(zzaf, zzh, zzal, (Boolean) null, (Boolean) null);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0110, code lost:
        r20 = r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.measurement.zzaq zza(java.lang.String r24, com.google.android.gms.internal.measurement.zzaf r25, com.google.android.gms.internal.measurement.zzh r26, java.util.List<com.google.android.gms.internal.measurement.zzaq> r27) {
        /*
            r0 = r24
            r3 = r27
            r0.hashCode()
            int r4 = r0.hashCode()
            java.lang.String r5 = "reverse"
            java.lang.String r6 = "slice"
            java.lang.String r7 = "shift"
            java.lang.String r8 = "every"
            java.lang.String r9 = "sort"
            java.lang.String r10 = "some"
            java.lang.String r11 = "join"
            java.lang.String r12 = "pop"
            java.lang.String r13 = "map"
            java.lang.String r14 = "lastIndexOf"
            java.lang.String r15 = "forEach"
            r16 = r4
            java.lang.String r4 = "filter"
            java.lang.String r1 = "toString"
            r19 = 1
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r19)
            r20 = -1
            switch(r16) {
                case -1776922004: goto L_0x013b;
                case -1354795244: goto L_0x012d;
                case -1274492040: goto L_0x0121;
                case -934873754: goto L_0x0113;
                case -895859076: goto L_0x0104;
                case -678635926: goto L_0x00f9;
                case -467511597: goto L_0x00ee;
                case -277637751: goto L_0x00e0;
                case 107868: goto L_0x00d3;
                case 111185: goto L_0x00c6;
                case 3267882: goto L_0x00b9;
                case 3452698: goto L_0x00aa;
                case 3536116: goto L_0x009c;
                case 3536286: goto L_0x008e;
                case 96891675: goto L_0x0080;
                case 109407362: goto L_0x0072;
                case 109526418: goto L_0x0064;
                case 965561430: goto L_0x0054;
                case 1099846370: goto L_0x0046;
                case 1943291465: goto L_0x0036;
                default: goto L_0x0032;
            }
        L_0x0032:
            r16 = r2
            goto L_0x0146
        L_0x0036:
            r16 = r2
            java.lang.String r2 = "indexOf"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x0042
            goto L_0x0146
        L_0x0042:
            r0 = 19
            goto L_0x0110
        L_0x0046:
            r16 = r2
            boolean r0 = r0.equals(r5)
            if (r0 != 0) goto L_0x0050
            goto L_0x0146
        L_0x0050:
            r0 = 18
            goto L_0x0110
        L_0x0054:
            r16 = r2
            java.lang.String r2 = "reduceRight"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x0060
            goto L_0x0146
        L_0x0060:
            r0 = 17
            goto L_0x0110
        L_0x0064:
            r16 = r2
            boolean r0 = r0.equals(r6)
            if (r0 != 0) goto L_0x006e
            goto L_0x0146
        L_0x006e:
            r0 = 16
            goto L_0x0110
        L_0x0072:
            r16 = r2
            boolean r0 = r0.equals(r7)
            if (r0 != 0) goto L_0x007c
            goto L_0x0146
        L_0x007c:
            r0 = 15
            goto L_0x0110
        L_0x0080:
            r16 = r2
            boolean r0 = r0.equals(r8)
            if (r0 != 0) goto L_0x008a
            goto L_0x0146
        L_0x008a:
            r0 = 14
            goto L_0x0110
        L_0x008e:
            r16 = r2
            boolean r0 = r0.equals(r9)
            if (r0 != 0) goto L_0x0098
            goto L_0x0146
        L_0x0098:
            r0 = 13
            goto L_0x0110
        L_0x009c:
            r16 = r2
            boolean r0 = r0.equals(r10)
            if (r0 != 0) goto L_0x00a6
            goto L_0x0146
        L_0x00a6:
            r0 = 12
            goto L_0x0110
        L_0x00aa:
            r16 = r2
            java.lang.String r2 = "push"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x00b6
            goto L_0x0146
        L_0x00b6:
            r0 = 11
            goto L_0x0110
        L_0x00b9:
            r16 = r2
            boolean r0 = r0.equals(r11)
            if (r0 != 0) goto L_0x00c3
            goto L_0x0146
        L_0x00c3:
            r0 = 10
            goto L_0x0110
        L_0x00c6:
            r16 = r2
            boolean r0 = r0.equals(r12)
            if (r0 != 0) goto L_0x00d0
            goto L_0x0146
        L_0x00d0:
            r0 = 9
            goto L_0x0110
        L_0x00d3:
            r16 = r2
            boolean r0 = r0.equals(r13)
            if (r0 != 0) goto L_0x00dd
            goto L_0x0146
        L_0x00dd:
            r0 = 8
            goto L_0x0110
        L_0x00e0:
            r16 = r2
            java.lang.String r2 = "unshift"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x00ec
            goto L_0x0146
        L_0x00ec:
            r0 = 7
            goto L_0x0110
        L_0x00ee:
            r16 = r2
            boolean r0 = r0.equals(r14)
            if (r0 != 0) goto L_0x00f7
            goto L_0x0146
        L_0x00f7:
            r0 = 6
            goto L_0x0110
        L_0x00f9:
            r16 = r2
            boolean r0 = r0.equals(r15)
            if (r0 != 0) goto L_0x0102
            goto L_0x0146
        L_0x0102:
            r0 = 5
            goto L_0x0110
        L_0x0104:
            r16 = r2
            java.lang.String r2 = "splice"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x010f
            goto L_0x0146
        L_0x010f:
            r0 = 4
        L_0x0110:
            r20 = r0
            goto L_0x0146
        L_0x0113:
            r16 = r2
            java.lang.String r2 = "reduce"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x011e
            goto L_0x0146
        L_0x011e:
            r20 = 3
            goto L_0x0146
        L_0x0121:
            r16 = r2
            boolean r0 = r0.equals(r4)
            if (r0 != 0) goto L_0x012a
            goto L_0x0146
        L_0x012a:
            r20 = 2
            goto L_0x0146
        L_0x012d:
            r16 = r2
            java.lang.String r2 = "concat"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x0138
            goto L_0x0146
        L_0x0138:
            r20 = r19
            goto L_0x0146
        L_0x013b:
            r16 = r2
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0144
            goto L_0x0146
        L_0x0144:
            r20 = 0
        L_0x0146:
            r21 = -4616189618054758400(0xbff0000000000000, double:-1.0)
            java.lang.String r2 = "Callback should be a method"
            r23 = r1
            r0 = 0
            switch(r20) {
                case 0: goto L_0x076c;
                case 1: goto L_0x070c;
                case 2: goto L_0x06b1;
                case 3: goto L_0x06a6;
                case 4: goto L_0x05e6;
                case 5: goto L_0x05b7;
                case 6: goto L_0x0517;
                case 7: goto L_0x048d;
                case 8: goto L_0x045c;
                case 9: goto L_0x0443;
                case 10: goto L_0x0403;
                case 11: goto L_0x03d2;
                case 12: goto L_0x035b;
                case 13: goto L_0x0302;
                case 14: goto L_0x02c2;
                case 15: goto L_0x02ab;
                case 16: goto L_0x022c;
                case 17: goto L_0x0222;
                case 18: goto L_0x01ed;
                case 19: goto L_0x0159;
                default: goto L_0x0151;
            }
        L_0x0151:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Command not supported"
            r0.<init>(r1)
            throw r0
        L_0x0159:
            java.lang.String r2 = "indexOf"
            r4 = 2
            com.google.android.gms.internal.measurement.zzg.zzc(r2, r4, r3)
            com.google.android.gms.internal.measurement.zzaq r2 = com.google.android.gms.internal.measurement.zzaq.zzc
            boolean r4 = r3.isEmpty()
            if (r4 != 0) goto L_0x0175
            r4 = 0
            java.lang.Object r2 = r3.get(r4)
            com.google.android.gms.internal.measurement.zzaq r2 = (com.google.android.gms.internal.measurement.zzaq) r2
            r5 = r26
            com.google.android.gms.internal.measurement.zzaq r2 = r5.zza((com.google.android.gms.internal.measurement.zzaq) r2)
            goto L_0x0177
        L_0x0175:
            r5 = r26
        L_0x0177:
            int r4 = r3.size()
            r6 = r19
            if (r4 <= r6) goto L_0x01b4
            java.lang.Object r3 = r3.get(r6)
            com.google.android.gms.internal.measurement.zzaq r3 = (com.google.android.gms.internal.measurement.zzaq) r3
            com.google.android.gms.internal.measurement.zzaq r3 = r5.zza((com.google.android.gms.internal.measurement.zzaq) r3)
            java.lang.Double r3 = r3.zze()
            double r3 = r3.doubleValue()
            double r3 = com.google.android.gms.internal.measurement.zzg.zza((double) r3)
            int r5 = r25.zzb()
            double r5 = (double) r5
            int r5 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r5 < 0) goto L_0x01a8
            com.google.android.gms.internal.measurement.zzai r0 = new com.google.android.gms.internal.measurement.zzai
            java.lang.Double r1 = java.lang.Double.valueOf(r21)
            r0.<init>(r1)
            return r0
        L_0x01a8:
            int r0 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r0 >= 0) goto L_0x01b3
            int r0 = r25.zzb()
            double r0 = (double) r0
            double r0 = r0 + r3
            goto L_0x01b4
        L_0x01b3:
            r0 = r3
        L_0x01b4:
            java.util.Iterator r3 = r25.zzg()
        L_0x01b8:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x01e3
            java.lang.Object r4 = r3.next()
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r4 = r4.intValue()
            double r5 = (double) r4
            int r7 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            r15 = r25
            if (r7 < 0) goto L_0x01b8
            com.google.android.gms.internal.measurement.zzaq r4 = r15.zza((int) r4)
            boolean r4 = com.google.android.gms.internal.measurement.zzg.zza(r4, r2)
            if (r4 == 0) goto L_0x01b8
            com.google.android.gms.internal.measurement.zzai r0 = new com.google.android.gms.internal.measurement.zzai
            java.lang.Double r1 = java.lang.Double.valueOf(r5)
            r0.<init>(r1)
            return r0
        L_0x01e3:
            com.google.android.gms.internal.measurement.zzai r0 = new com.google.android.gms.internal.measurement.zzai
            java.lang.Double r1 = java.lang.Double.valueOf(r21)
            r0.<init>(r1)
            return r0
        L_0x01ed:
            r15 = r25
            r4 = 0
            com.google.android.gms.internal.measurement.zzg.zza((java.lang.String) r5, (int) r4, (java.util.List<com.google.android.gms.internal.measurement.zzaq>) r3)
            int r0 = r15.zzb()
            if (r0 == 0) goto L_0x035a
            r2 = 0
        L_0x01fa:
            int r1 = r0 / 2
            if (r2 >= r1) goto L_0x035a
            boolean r1 = r15.zzc((int) r2)
            if (r1 == 0) goto L_0x021f
            com.google.android.gms.internal.measurement.zzaq r1 = r15.zza((int) r2)
            r3 = 0
            r15.zzb(r2, r3)
            int r3 = r0 + -1
            int r3 = r3 - r2
            boolean r4 = r15.zzc((int) r3)
            if (r4 == 0) goto L_0x021c
            com.google.android.gms.internal.measurement.zzaq r4 = r15.zza((int) r3)
            r15.zzb(r2, r4)
        L_0x021c:
            r15.zzb(r3, r1)
        L_0x021f:
            int r2 = r2 + 1
            goto L_0x01fa
        L_0x0222:
            r15 = r25
            r5 = r26
            r4 = 0
            com.google.android.gms.internal.measurement.zzaq r0 = zza((com.google.android.gms.internal.measurement.zzaf) r15, (com.google.android.gms.internal.measurement.zzh) r5, (java.util.List<com.google.android.gms.internal.measurement.zzaq>) r3, (boolean) r4)
            return r0
        L_0x022c:
            r15 = r25
            r5 = r26
            r2 = 2
            r4 = 0
            com.google.android.gms.internal.measurement.zzg.zzc(r6, r2, r3)
            boolean r2 = r3.isEmpty()
            if (r2 == 0) goto L_0x0240
            com.google.android.gms.internal.measurement.zzaq r0 = r15.zzc()
            return r0
        L_0x0240:
            int r2 = r15.zzb()
            double r6 = (double) r2
            java.lang.Object r2 = r3.get(r4)
            com.google.android.gms.internal.measurement.zzaq r2 = (com.google.android.gms.internal.measurement.zzaq) r2
            com.google.android.gms.internal.measurement.zzaq r2 = r5.zza((com.google.android.gms.internal.measurement.zzaq) r2)
            java.lang.Double r2 = r2.zze()
            double r8 = r2.doubleValue()
            double r8 = com.google.android.gms.internal.measurement.zzg.zza((double) r8)
            int r2 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r2 >= 0) goto L_0x0265
            double r8 = r8 + r6
            double r8 = java.lang.Math.max(r8, r0)
            goto L_0x0269
        L_0x0265:
            double r8 = java.lang.Math.min(r8, r6)
        L_0x0269:
            int r2 = r3.size()
            r4 = 2
            if (r2 != r4) goto L_0x0295
            r2 = 1
            java.lang.Object r2 = r3.get(r2)
            com.google.android.gms.internal.measurement.zzaq r2 = (com.google.android.gms.internal.measurement.zzaq) r2
            com.google.android.gms.internal.measurement.zzaq r2 = r5.zza((com.google.android.gms.internal.measurement.zzaq) r2)
            java.lang.Double r2 = r2.zze()
            double r2 = r2.doubleValue()
            double r2 = com.google.android.gms.internal.measurement.zzg.zza((double) r2)
            int r4 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r4 >= 0) goto L_0x0291
            double r6 = r6 + r2
            double r6 = java.lang.Math.max(r6, r0)
            goto L_0x0295
        L_0x0291:
            double r6 = java.lang.Math.min(r6, r2)
        L_0x0295:
            com.google.android.gms.internal.measurement.zzaf r0 = new com.google.android.gms.internal.measurement.zzaf
            r0.<init>()
            int r1 = (int) r8
        L_0x029b:
            double r2 = (double) r1
            int r2 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r2 >= 0) goto L_0x02aa
            com.google.android.gms.internal.measurement.zzaq r2 = r15.zza((int) r1)
            r0.zza((com.google.android.gms.internal.measurement.zzaq) r2)
            int r1 = r1 + 1
            goto L_0x029b
        L_0x02aa:
            return r0
        L_0x02ab:
            r15 = r25
            r4 = 0
            com.google.android.gms.internal.measurement.zzg.zza((java.lang.String) r7, (int) r4, (java.util.List<com.google.android.gms.internal.measurement.zzaq>) r3)
            int r0 = r15.zzb()
            if (r0 != 0) goto L_0x02ba
            com.google.android.gms.internal.measurement.zzaq r0 = com.google.android.gms.internal.measurement.zzaq.zzc
            return r0
        L_0x02ba:
            com.google.android.gms.internal.measurement.zzaq r0 = r15.zza((int) r4)
            r15.zzb((int) r4)
            return r0
        L_0x02c2:
            r15 = r25
            r5 = r26
            r6 = r19
            r4 = 0
            com.google.android.gms.internal.measurement.zzg.zza((java.lang.String) r8, (int) r6, (java.util.List<com.google.android.gms.internal.measurement.zzaq>) r3)
            java.lang.Object r0 = r3.get(r4)
            com.google.android.gms.internal.measurement.zzaq r0 = (com.google.android.gms.internal.measurement.zzaq) r0
            com.google.android.gms.internal.measurement.zzaq r0 = r5.zza((com.google.android.gms.internal.measurement.zzaq) r0)
            boolean r1 = r0 instanceof com.google.android.gms.internal.measurement.zzar
            if (r1 == 0) goto L_0x02fc
            int r1 = r15.zzb()
            if (r1 == 0) goto L_0x02f9
            com.google.android.gms.internal.measurement.zzar r0 = (com.google.android.gms.internal.measurement.zzar) r0
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r4)
            r6 = r16
            com.google.android.gms.internal.measurement.zzaf r0 = zza(r15, r5, r0, r1, r6)
            int r0 = r0.zzb()
            int r1 = r15.zzb()
            if (r0 == r1) goto L_0x02f9
            com.google.android.gms.internal.measurement.zzaq r0 = com.google.android.gms.internal.measurement.zzaq.zzi
            return r0
        L_0x02f9:
            com.google.android.gms.internal.measurement.zzaq r0 = com.google.android.gms.internal.measurement.zzaq.zzh
            return r0
        L_0x02fc:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r0.<init>(r2)
            throw r0
        L_0x0302:
            r15 = r25
            r5 = r26
            r6 = r19
            com.google.android.gms.internal.measurement.zzg.zzc(r9, r6, r3)
            int r0 = r15.zzb()
            r4 = 2
            if (r0 < r4) goto L_0x035a
            java.util.List r0 = r15.zzi()
            boolean r1 = r3.isEmpty()
            if (r1 != 0) goto L_0x0336
            r4 = 0
            java.lang.Object r1 = r3.get(r4)
            com.google.android.gms.internal.measurement.zzaq r1 = (com.google.android.gms.internal.measurement.zzaq) r1
            com.google.android.gms.internal.measurement.zzaq r1 = r5.zza((com.google.android.gms.internal.measurement.zzaq) r1)
            boolean r2 = r1 instanceof com.google.android.gms.internal.measurement.zzal
            if (r2 == 0) goto L_0x032e
            com.google.android.gms.internal.measurement.zzal r1 = (com.google.android.gms.internal.measurement.zzal) r1
            goto L_0x0337
        L_0x032e:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Comparator should be a method"
            r0.<init>(r1)
            throw r0
        L_0x0336:
            r1 = 0
        L_0x0337:
            com.google.android.gms.internal.measurement.zzbh r2 = new com.google.android.gms.internal.measurement.zzbh
            r2.<init>(r1, r5)
            java.util.Collections.sort(r0, r2)
            r15.zzj()
            java.util.Iterator r0 = r0.iterator()
            r2 = 0
        L_0x0347:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x035a
            java.lang.Object r1 = r0.next()
            com.google.android.gms.internal.measurement.zzaq r1 = (com.google.android.gms.internal.measurement.zzaq) r1
            int r3 = r2 + 1
            r15.zzb(r2, r1)
            r2 = r3
            goto L_0x0347
        L_0x035a:
            return r15
        L_0x035b:
            r15 = r25
            r5 = r26
            r6 = r19
            com.google.android.gms.internal.measurement.zzg.zza((java.lang.String) r10, (int) r6, (java.util.List<com.google.android.gms.internal.measurement.zzaq>) r3)
            r4 = 0
            java.lang.Object r0 = r3.get(r4)
            com.google.android.gms.internal.measurement.zzaq r0 = (com.google.android.gms.internal.measurement.zzaq) r0
            com.google.android.gms.internal.measurement.zzaq r0 = r5.zza((com.google.android.gms.internal.measurement.zzaq) r0)
            boolean r1 = r0 instanceof com.google.android.gms.internal.measurement.zzal
            if (r1 == 0) goto L_0x03cc
            int r1 = r15.zzb()
            if (r1 == 0) goto L_0x03c9
            com.google.android.gms.internal.measurement.zzal r0 = (com.google.android.gms.internal.measurement.zzal) r0
            java.util.Iterator r1 = r15.zzg()
        L_0x037f:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x03c9
            java.lang.Object r2 = r1.next()
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            boolean r3 = r15.zzc((int) r2)
            if (r3 == 0) goto L_0x03c7
            r3 = 3
            com.google.android.gms.internal.measurement.zzaq[] r4 = new com.google.android.gms.internal.measurement.zzaq[r3]
            com.google.android.gms.internal.measurement.zzaq r6 = r15.zza((int) r2)
            r18 = 0
            r4[r18] = r6
            com.google.android.gms.internal.measurement.zzai r6 = new com.google.android.gms.internal.measurement.zzai
            double r7 = (double) r2
            java.lang.Double r2 = java.lang.Double.valueOf(r7)
            r6.<init>(r2)
            r19 = 1
            r4[r19] = r6
            r17 = 2
            r4[r17] = r15
            java.util.List r2 = java.util.Arrays.asList(r4)
            com.google.android.gms.internal.measurement.zzaq r2 = r0.zza((com.google.android.gms.internal.measurement.zzh) r5, (java.util.List<com.google.android.gms.internal.measurement.zzaq>) r2)
            java.lang.Boolean r2 = r2.zzd()
            boolean r2 = r2.booleanValue()
            if (r2 == 0) goto L_0x037f
            com.google.android.gms.internal.measurement.zzaq r0 = com.google.android.gms.internal.measurement.zzaq.zzh
            return r0
        L_0x03c7:
            r3 = 3
            goto L_0x037f
        L_0x03c9:
            com.google.android.gms.internal.measurement.zzaq r0 = com.google.android.gms.internal.measurement.zzaq.zzi
            return r0
        L_0x03cc:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r0.<init>(r2)
            throw r0
        L_0x03d2:
            r15 = r25
            r5 = r26
            boolean r0 = r3.isEmpty()
            if (r0 != 0) goto L_0x03f4
            java.util.Iterator r0 = r3.iterator()
        L_0x03e0:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x03f4
            java.lang.Object r1 = r0.next()
            com.google.android.gms.internal.measurement.zzaq r1 = (com.google.android.gms.internal.measurement.zzaq) r1
            com.google.android.gms.internal.measurement.zzaq r1 = r5.zza((com.google.android.gms.internal.measurement.zzaq) r1)
            r15.zza((com.google.android.gms.internal.measurement.zzaq) r1)
            goto L_0x03e0
        L_0x03f4:
            com.google.android.gms.internal.measurement.zzai r0 = new com.google.android.gms.internal.measurement.zzai
            int r1 = r15.zzb()
            double r1 = (double) r1
            java.lang.Double r1 = java.lang.Double.valueOf(r1)
            r0.<init>(r1)
            return r0
        L_0x0403:
            r15 = r25
            r5 = r26
            r6 = r19
            com.google.android.gms.internal.measurement.zzg.zzc(r11, r6, r3)
            int r0 = r15.zzb()
            if (r0 != 0) goto L_0x0415
            com.google.android.gms.internal.measurement.zzaq r0 = com.google.android.gms.internal.measurement.zzaq.zzj
            return r0
        L_0x0415:
            boolean r0 = r3.isEmpty()
            if (r0 != 0) goto L_0x0437
            r4 = 0
            java.lang.Object r0 = r3.get(r4)
            com.google.android.gms.internal.measurement.zzaq r0 = (com.google.android.gms.internal.measurement.zzaq) r0
            com.google.android.gms.internal.measurement.zzaq r0 = r5.zza((com.google.android.gms.internal.measurement.zzaq) r0)
            boolean r1 = r0 instanceof com.google.android.gms.internal.measurement.zzao
            if (r1 != 0) goto L_0x0434
            boolean r1 = r0 instanceof com.google.android.gms.internal.measurement.zzax
            if (r1 == 0) goto L_0x042f
            goto L_0x0434
        L_0x042f:
            java.lang.String r0 = r0.zzf()
            goto L_0x0439
        L_0x0434:
            java.lang.String r0 = ""
            goto L_0x0439
        L_0x0437:
            java.lang.String r0 = ","
        L_0x0439:
            com.google.android.gms.internal.measurement.zzas r1 = new com.google.android.gms.internal.measurement.zzas
            java.lang.String r0 = r15.zzb((java.lang.String) r0)
            r1.<init>(r0)
            return r1
        L_0x0443:
            r15 = r25
            r4 = 0
            com.google.android.gms.internal.measurement.zzg.zza((java.lang.String) r12, (int) r4, (java.util.List<com.google.android.gms.internal.measurement.zzaq>) r3)
            int r0 = r15.zzb()
            if (r0 != 0) goto L_0x0452
            com.google.android.gms.internal.measurement.zzaq r0 = com.google.android.gms.internal.measurement.zzaq.zzc
            return r0
        L_0x0452:
            r6 = 1
            int r0 = r0 - r6
            com.google.android.gms.internal.measurement.zzaq r1 = r15.zza((int) r0)
            r15.zzb((int) r0)
            return r1
        L_0x045c:
            r15 = r25
            r5 = r26
            r6 = r19
            r4 = 0
            com.google.android.gms.internal.measurement.zzg.zza((java.lang.String) r13, (int) r6, (java.util.List<com.google.android.gms.internal.measurement.zzaq>) r3)
            java.lang.Object r0 = r3.get(r4)
            com.google.android.gms.internal.measurement.zzaq r0 = (com.google.android.gms.internal.measurement.zzaq) r0
            com.google.android.gms.internal.measurement.zzaq r0 = r5.zza((com.google.android.gms.internal.measurement.zzaq) r0)
            boolean r1 = r0 instanceof com.google.android.gms.internal.measurement.zzar
            if (r1 == 0) goto L_0x0487
            int r1 = r15.zzb()
            if (r1 != 0) goto L_0x0480
            com.google.android.gms.internal.measurement.zzaf r0 = new com.google.android.gms.internal.measurement.zzaf
            r0.<init>()
            return r0
        L_0x0480:
            com.google.android.gms.internal.measurement.zzar r0 = (com.google.android.gms.internal.measurement.zzar) r0
            com.google.android.gms.internal.measurement.zzaf r0 = zza(r15, r5, r0)
            return r0
        L_0x0487:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r0.<init>(r2)
            throw r0
        L_0x048d:
            r15 = r25
            r5 = r26
            boolean r0 = r3.isEmpty()
            if (r0 != 0) goto L_0x0508
            com.google.android.gms.internal.measurement.zzaf r0 = new com.google.android.gms.internal.measurement.zzaf
            r0.<init>()
            java.util.Iterator r1 = r3.iterator()
        L_0x04a0:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x04c0
            java.lang.Object r2 = r1.next()
            com.google.android.gms.internal.measurement.zzaq r2 = (com.google.android.gms.internal.measurement.zzaq) r2
            com.google.android.gms.internal.measurement.zzaq r2 = r5.zza((com.google.android.gms.internal.measurement.zzaq) r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.measurement.zzaj
            if (r3 != 0) goto L_0x04b8
            r0.zza((com.google.android.gms.internal.measurement.zzaq) r2)
            goto L_0x04a0
        L_0x04b8:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "Argument evaluation failed"
            r0.<init>(r1)
            throw r0
        L_0x04c0:
            int r1 = r0.zzb()
            java.util.Iterator r2 = r15.zzg()
        L_0x04c8:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x04e5
            java.lang.Object r3 = r2.next()
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r4 = r3.intValue()
            int r4 = r4 + r1
            int r3 = r3.intValue()
            com.google.android.gms.internal.measurement.zzaq r3 = r15.zza((int) r3)
            r0.zzb(r4, r3)
            goto L_0x04c8
        L_0x04e5:
            r15.zzj()
            java.util.Iterator r1 = r0.zzg()
        L_0x04ec:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0508
            java.lang.Object r2 = r1.next()
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r3 = r2.intValue()
            int r2 = r2.intValue()
            com.google.android.gms.internal.measurement.zzaq r2 = r0.zza((int) r2)
            r15.zzb(r3, r2)
            goto L_0x04ec
        L_0x0508:
            com.google.android.gms.internal.measurement.zzai r0 = new com.google.android.gms.internal.measurement.zzai
            int r1 = r15.zzb()
            double r1 = (double) r1
            java.lang.Double r1 = java.lang.Double.valueOf(r1)
            r0.<init>(r1)
            return r0
        L_0x0517:
            r15 = r25
            r5 = r26
            r4 = 2
            com.google.android.gms.internal.measurement.zzg.zzc(r14, r4, r3)
            com.google.android.gms.internal.measurement.zzaq r2 = com.google.android.gms.internal.measurement.zzaq.zzc
            boolean r4 = r3.isEmpty()
            if (r4 != 0) goto L_0x0532
            r4 = 0
            java.lang.Object r2 = r3.get(r4)
            com.google.android.gms.internal.measurement.zzaq r2 = (com.google.android.gms.internal.measurement.zzaq) r2
            com.google.android.gms.internal.measurement.zzaq r2 = r5.zza((com.google.android.gms.internal.measurement.zzaq) r2)
        L_0x0532:
            int r4 = r15.zzb()
            r6 = 1
            int r4 = r4 - r6
            double r7 = (double) r4
            int r4 = r3.size()
            if (r4 <= r6) goto L_0x0575
            java.lang.Object r3 = r3.get(r6)
            com.google.android.gms.internal.measurement.zzaq r3 = (com.google.android.gms.internal.measurement.zzaq) r3
            com.google.android.gms.internal.measurement.zzaq r3 = r5.zza((com.google.android.gms.internal.measurement.zzaq) r3)
            java.lang.Double r4 = r3.zze()
            double r4 = r4.doubleValue()
            boolean r4 = java.lang.Double.isNaN(r4)
            if (r4 == 0) goto L_0x055e
            int r3 = r15.zzb()
            int r3 = r3 - r6
            double r3 = (double) r3
            goto L_0x056a
        L_0x055e:
            java.lang.Double r3 = r3.zze()
            double r3 = r3.doubleValue()
            double r3 = com.google.android.gms.internal.measurement.zzg.zza((double) r3)
        L_0x056a:
            r7 = r3
            int r3 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
            if (r3 >= 0) goto L_0x0575
            int r3 = r15.zzb()
            double r3 = (double) r3
            double r7 = r7 + r3
        L_0x0575:
            int r0 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
            if (r0 >= 0) goto L_0x0583
            com.google.android.gms.internal.measurement.zzai r0 = new com.google.android.gms.internal.measurement.zzai
            java.lang.Double r1 = java.lang.Double.valueOf(r21)
            r0.<init>(r1)
            return r0
        L_0x0583:
            int r0 = r15.zzb()
            double r0 = (double) r0
            double r0 = java.lang.Math.min(r0, r7)
            int r0 = (int) r0
        L_0x058d:
            if (r0 < 0) goto L_0x05ad
            boolean r1 = r15.zzc((int) r0)
            if (r1 == 0) goto L_0x05aa
            com.google.android.gms.internal.measurement.zzaq r1 = r15.zza((int) r0)
            boolean r1 = com.google.android.gms.internal.measurement.zzg.zza(r1, r2)
            if (r1 == 0) goto L_0x05aa
            com.google.android.gms.internal.measurement.zzai r1 = new com.google.android.gms.internal.measurement.zzai
            double r2 = (double) r0
            java.lang.Double r0 = java.lang.Double.valueOf(r2)
            r1.<init>(r0)
            return r1
        L_0x05aa:
            int r0 = r0 + -1
            goto L_0x058d
        L_0x05ad:
            com.google.android.gms.internal.measurement.zzai r0 = new com.google.android.gms.internal.measurement.zzai
            java.lang.Double r1 = java.lang.Double.valueOf(r21)
            r0.<init>(r1)
            return r0
        L_0x05b7:
            r1 = r25
            r5 = r26
            r6 = r19
            com.google.android.gms.internal.measurement.zzg.zza((java.lang.String) r15, (int) r6, (java.util.List<com.google.android.gms.internal.measurement.zzaq>) r3)
            r4 = 0
            java.lang.Object r0 = r3.get(r4)
            com.google.android.gms.internal.measurement.zzaq r0 = (com.google.android.gms.internal.measurement.zzaq) r0
            com.google.android.gms.internal.measurement.zzaq r0 = r5.zza((com.google.android.gms.internal.measurement.zzaq) r0)
            boolean r3 = r0 instanceof com.google.android.gms.internal.measurement.zzar
            if (r3 == 0) goto L_0x05e0
            int r2 = r1.zza()
            if (r2 != 0) goto L_0x05d8
            com.google.android.gms.internal.measurement.zzaq r0 = com.google.android.gms.internal.measurement.zzaq.zzc
            return r0
        L_0x05d8:
            com.google.android.gms.internal.measurement.zzar r0 = (com.google.android.gms.internal.measurement.zzar) r0
            zza(r1, r5, r0)
            com.google.android.gms.internal.measurement.zzaq r0 = com.google.android.gms.internal.measurement.zzaq.zzc
            return r0
        L_0x05e0:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r0.<init>(r2)
            throw r0
        L_0x05e6:
            r1 = r25
            r5 = r26
            boolean r0 = r3.isEmpty()
            if (r0 == 0) goto L_0x05f6
            com.google.android.gms.internal.measurement.zzaf r0 = new com.google.android.gms.internal.measurement.zzaf
            r0.<init>()
            return r0
        L_0x05f6:
            r4 = 0
            java.lang.Object r0 = r3.get(r4)
            com.google.android.gms.internal.measurement.zzaq r0 = (com.google.android.gms.internal.measurement.zzaq) r0
            com.google.android.gms.internal.measurement.zzaq r0 = r5.zza((com.google.android.gms.internal.measurement.zzaq) r0)
            java.lang.Double r0 = r0.zze()
            double r6 = r0.doubleValue()
            double r6 = com.google.android.gms.internal.measurement.zzg.zza((double) r6)
            int r0 = (int) r6
            if (r0 >= 0) goto L_0x061a
            int r2 = r1.zzb()
            int r0 = r0 + r2
            int r0 = java.lang.Math.max(r4, r0)
            goto L_0x0624
        L_0x061a:
            int r2 = r1.zzb()
            if (r0 <= r2) goto L_0x0624
            int r0 = r1.zzb()
        L_0x0624:
            int r2 = r1.zzb()
            com.google.android.gms.internal.measurement.zzaf r4 = new com.google.android.gms.internal.measurement.zzaf
            r4.<init>()
            int r6 = r3.size()
            r7 = 1
            if (r6 <= r7) goto L_0x0695
            java.lang.Object r6 = r3.get(r7)
            com.google.android.gms.internal.measurement.zzaq r6 = (com.google.android.gms.internal.measurement.zzaq) r6
            com.google.android.gms.internal.measurement.zzaq r6 = r5.zza((com.google.android.gms.internal.measurement.zzaq) r6)
            java.lang.Double r6 = r6.zze()
            double r6 = r6.doubleValue()
            double r6 = com.google.android.gms.internal.measurement.zzg.zza((double) r6)
            int r6 = (int) r6
            r7 = 0
            int r6 = java.lang.Math.max(r7, r6)
            if (r6 <= 0) goto L_0x0668
            r7 = r0
        L_0x0653:
            int r8 = r0 + r6
            int r8 = java.lang.Math.min(r2, r8)
            if (r7 >= r8) goto L_0x0668
            com.google.android.gms.internal.measurement.zzaq r8 = r1.zza((int) r0)
            r4.zza((com.google.android.gms.internal.measurement.zzaq) r8)
            r1.zzb((int) r0)
            int r7 = r7 + 1
            goto L_0x0653
        L_0x0668:
            int r2 = r3.size()
            r6 = 2
            if (r2 <= r6) goto L_0x06a5
            r2 = r6
        L_0x0670:
            int r7 = r3.size()
            if (r2 >= r7) goto L_0x06a5
            java.lang.Object r7 = r3.get(r2)
            com.google.android.gms.internal.measurement.zzaq r7 = (com.google.android.gms.internal.measurement.zzaq) r7
            com.google.android.gms.internal.measurement.zzaq r7 = r5.zza((com.google.android.gms.internal.measurement.zzaq) r7)
            boolean r8 = r7 instanceof com.google.android.gms.internal.measurement.zzaj
            if (r8 != 0) goto L_0x068d
            int r8 = r0 + r2
            int r8 = r8 - r6
            r1.zza((int) r8, (com.google.android.gms.internal.measurement.zzaq) r7)
            int r2 = r2 + 1
            goto L_0x0670
        L_0x068d:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Failed to parse elements to add"
            r0.<init>(r1)
            throw r0
        L_0x0695:
            if (r0 >= r2) goto L_0x06a5
            com.google.android.gms.internal.measurement.zzaq r3 = r1.zza((int) r0)
            r4.zza((com.google.android.gms.internal.measurement.zzaq) r3)
            r3 = 0
            r1.zzb(r0, r3)
            int r0 = r0 + 1
            goto L_0x0695
        L_0x06a5:
            return r4
        L_0x06a6:
            r1 = r25
            r5 = r26
            r7 = r19
            com.google.android.gms.internal.measurement.zzaq r0 = zza((com.google.android.gms.internal.measurement.zzaf) r1, (com.google.android.gms.internal.measurement.zzh) r5, (java.util.List<com.google.android.gms.internal.measurement.zzaq>) r3, (boolean) r7)
            return r0
        L_0x06b1:
            r1 = r25
            r5 = r26
            r6 = r16
            r7 = r19
            com.google.android.gms.internal.measurement.zzg.zza((java.lang.String) r4, (int) r7, (java.util.List<com.google.android.gms.internal.measurement.zzaq>) r3)
            r4 = 0
            java.lang.Object r0 = r3.get(r4)
            com.google.android.gms.internal.measurement.zzaq r0 = (com.google.android.gms.internal.measurement.zzaq) r0
            com.google.android.gms.internal.measurement.zzaq r0 = r5.zza((com.google.android.gms.internal.measurement.zzaq) r0)
            boolean r3 = r0 instanceof com.google.android.gms.internal.measurement.zzar
            if (r3 == 0) goto L_0x0706
            int r2 = r1.zza()
            if (r2 != 0) goto L_0x06d7
            com.google.android.gms.internal.measurement.zzaf r0 = new com.google.android.gms.internal.measurement.zzaf
            r0.<init>()
            return r0
        L_0x06d7:
            com.google.android.gms.internal.measurement.zzaq r2 = r1.zzc()
            com.google.android.gms.internal.measurement.zzaf r2 = (com.google.android.gms.internal.measurement.zzaf) r2
            com.google.android.gms.internal.measurement.zzar r0 = (com.google.android.gms.internal.measurement.zzar) r0
            r3 = 0
            com.google.android.gms.internal.measurement.zzaf r0 = zza(r1, r5, r0, r3, r6)
            com.google.android.gms.internal.measurement.zzaf r1 = new com.google.android.gms.internal.measurement.zzaf
            r1.<init>()
            java.util.Iterator r0 = r0.zzg()
        L_0x06ed:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x0705
            java.lang.Object r3 = r0.next()
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            com.google.android.gms.internal.measurement.zzaq r3 = r2.zza((int) r3)
            r1.zza((com.google.android.gms.internal.measurement.zzaq) r3)
            goto L_0x06ed
        L_0x0705:
            return r1
        L_0x0706:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r0.<init>(r2)
            throw r0
        L_0x070c:
            r1 = r25
            r5 = r26
            com.google.android.gms.internal.measurement.zzaq r0 = r1.zzc()
            com.google.android.gms.internal.measurement.zzaf r0 = (com.google.android.gms.internal.measurement.zzaf) r0
            boolean r1 = r3.isEmpty()
            if (r1 != 0) goto L_0x076b
            java.util.Iterator r1 = r3.iterator()
        L_0x0720:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x076b
            java.lang.Object r2 = r1.next()
            com.google.android.gms.internal.measurement.zzaq r2 = (com.google.android.gms.internal.measurement.zzaq) r2
            com.google.android.gms.internal.measurement.zzaq r2 = r5.zza((com.google.android.gms.internal.measurement.zzaq) r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.measurement.zzaj
            if (r3 != 0) goto L_0x0763
            int r3 = r0.zzb()
            boolean r4 = r2 instanceof com.google.android.gms.internal.measurement.zzaf
            if (r4 == 0) goto L_0x075f
            com.google.android.gms.internal.measurement.zzaf r2 = (com.google.android.gms.internal.measurement.zzaf) r2
            java.util.Iterator r4 = r2.zzg()
        L_0x0742:
            boolean r6 = r4.hasNext()
            if (r6 == 0) goto L_0x0720
            java.lang.Object r6 = r4.next()
            java.lang.Integer r6 = (java.lang.Integer) r6
            int r7 = r6.intValue()
            int r7 = r7 + r3
            int r6 = r6.intValue()
            com.google.android.gms.internal.measurement.zzaq r6 = r2.zza((int) r6)
            r0.zzb(r7, r6)
            goto L_0x0742
        L_0x075f:
            r0.zzb(r3, r2)
            goto L_0x0720
        L_0x0763:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "Failed evaluation of arguments"
            r0.<init>(r1)
            throw r0
        L_0x076b:
            return r0
        L_0x076c:
            r1 = r25
            r0 = r23
            r4 = 0
            com.google.android.gms.internal.measurement.zzg.zza((java.lang.String) r0, (int) r4, (java.util.List<com.google.android.gms.internal.measurement.zzaq>) r3)
            com.google.android.gms.internal.measurement.zzas r0 = new com.google.android.gms.internal.measurement.zzas
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzbe.zza(java.lang.String, com.google.android.gms.internal.measurement.zzaf, com.google.android.gms.internal.measurement.zzh, java.util.List):com.google.android.gms.internal.measurement.zzaq");
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0096 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.android.gms.internal.measurement.zzaq zza(com.google.android.gms.internal.measurement.zzaf r9, com.google.android.gms.internal.measurement.zzh r10, java.util.List<com.google.android.gms.internal.measurement.zzaq> r11, boolean r12) {
        /*
            java.lang.String r0 = "reduce"
            r1 = 1
            com.google.android.gms.internal.measurement.zzg.zzb((java.lang.String) r0, (int) r1, (java.util.List<com.google.android.gms.internal.measurement.zzaq>) r11)
            r2 = 2
            com.google.android.gms.internal.measurement.zzg.zzc(r0, r2, r11)
            r0 = 0
            java.lang.Object r3 = r11.get(r0)
            com.google.android.gms.internal.measurement.zzaq r3 = (com.google.android.gms.internal.measurement.zzaq) r3
            com.google.android.gms.internal.measurement.zzaq r3 = r10.zza((com.google.android.gms.internal.measurement.zzaq) r3)
            boolean r4 = r3 instanceof com.google.android.gms.internal.measurement.zzal
            if (r4 == 0) goto L_0x009f
            int r4 = r11.size()
            if (r4 != r2) goto L_0x0036
            java.lang.Object r11 = r11.get(r1)
            com.google.android.gms.internal.measurement.zzaq r11 = (com.google.android.gms.internal.measurement.zzaq) r11
            com.google.android.gms.internal.measurement.zzaq r11 = r10.zza((com.google.android.gms.internal.measurement.zzaq) r11)
            boolean r4 = r11 instanceof com.google.android.gms.internal.measurement.zzaj
            if (r4 != 0) goto L_0x002e
            goto L_0x003d
        L_0x002e:
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            java.lang.String r10 = "Failed to parse initial value"
            r9.<init>(r10)
            throw r9
        L_0x0036:
            int r11 = r9.zzb()
            if (r11 == 0) goto L_0x0097
            r11 = 0
        L_0x003d:
            com.google.android.gms.internal.measurement.zzal r3 = (com.google.android.gms.internal.measurement.zzal) r3
            int r4 = r9.zzb()
            if (r12 == 0) goto L_0x0047
            r5 = r0
            goto L_0x0049
        L_0x0047:
            int r5 = r4 + -1
        L_0x0049:
            if (r12 == 0) goto L_0x004d
            int r4 = r4 - r1
            goto L_0x004e
        L_0x004d:
            r4 = r0
        L_0x004e:
            if (r12 == 0) goto L_0x0052
            r12 = r1
            goto L_0x0053
        L_0x0052:
            r12 = -1
        L_0x0053:
            if (r11 != 0) goto L_0x005a
            com.google.android.gms.internal.measurement.zzaq r11 = r9.zza((int) r5)
            goto L_0x0094
        L_0x005a:
            int r6 = r4 - r5
            int r6 = r6 * r12
            if (r6 < 0) goto L_0x0096
            boolean r6 = r9.zzc((int) r5)
            if (r6 == 0) goto L_0x0094
            r6 = 4
            com.google.android.gms.internal.measurement.zzaq[] r6 = new com.google.android.gms.internal.measurement.zzaq[r6]
            r6[r0] = r11
            com.google.android.gms.internal.measurement.zzaq r11 = r9.zza((int) r5)
            r6[r1] = r11
            com.google.android.gms.internal.measurement.zzai r11 = new com.google.android.gms.internal.measurement.zzai
            double r7 = (double) r5
            java.lang.Double r7 = java.lang.Double.valueOf(r7)
            r11.<init>(r7)
            r6[r2] = r11
            r11 = 3
            r6[r11] = r9
            java.util.List r11 = java.util.Arrays.asList(r6)
            com.google.android.gms.internal.measurement.zzaq r11 = r3.zza((com.google.android.gms.internal.measurement.zzh) r10, (java.util.List<com.google.android.gms.internal.measurement.zzaq>) r11)
            boolean r6 = r11 instanceof com.google.android.gms.internal.measurement.zzaj
            if (r6 != 0) goto L_0x008c
            goto L_0x0094
        L_0x008c:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "Reduce operation failed"
            r9.<init>(r10)
            throw r9
        L_0x0094:
            int r5 = r5 + r12
            goto L_0x005a
        L_0x0096:
            return r11
        L_0x0097:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "Empty array with no initial value error"
            r9.<init>(r10)
            throw r9
        L_0x009f:
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            java.lang.String r10 = "Callback should be a method"
            r9.<init>(r10)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzbe.zza(com.google.android.gms.internal.measurement.zzaf, com.google.android.gms.internal.measurement.zzh, java.util.List, boolean):com.google.android.gms.internal.measurement.zzaq");
    }
}
