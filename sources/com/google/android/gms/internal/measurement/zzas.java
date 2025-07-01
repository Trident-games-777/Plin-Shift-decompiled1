package com.google.android.gms.internal.measurement;

import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-measurement@@22.1.2 */
public final class zzas implements zzaq, Iterable<zzaq> {
    /* access modifiers changed from: private */
    public final String zza;

    public final int hashCode() {
        return this.zza.hashCode();
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:100:0x01a5, code lost:
        r5 = r24;
        r4 = r5.zza(r3.get(0)).zzf();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x01bb, code lost:
        if (r3.size() >= 2) goto L_0x01be;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x01be, code lost:
        r0 = r5.zza(r3.get(1)).zze().doubleValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x01e4, code lost:
        return new com.google.android.gms.internal.measurement.zzai(java.lang.Double.valueOf((double) r2.indexOf(r4, (int) com.google.android.gms.internal.measurement.zzg.zza(r0))));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x01e5, code lost:
        r7 = r22;
        r5 = r24;
        r3 = r25;
        com.google.android.gms.internal.measurement.zzg.zzc("replace", 2, r3);
        r0 = com.google.android.gms.internal.measurement.zzaq.zzc.zzf();
        r1 = com.google.android.gms.internal.measurement.zzaq.zzc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x01fb, code lost:
        if (r3.isEmpty() != false) goto L_0x021d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x01fd, code lost:
        r0 = r5.zza(r3.get(0)).zzf();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x0211, code lost:
        if (r3.size() <= 1) goto L_0x021d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x0213, code lost:
        r1 = r5.zza(r3.get(1));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x021d, code lost:
        r2 = r7.zza;
        r3 = r2.indexOf(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x0223, code lost:
        if (r3 >= 0) goto L_0x0227;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x0229, code lost:
        if ((r1 instanceof com.google.android.gms.internal.measurement.zzal) == false) goto L_0x0253;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x022b, code lost:
        r1 = ((com.google.android.gms.internal.measurement.zzal) r1).zza(r5, (java.util.List<com.google.android.gms.internal.measurement.zzaq>) java.util.Arrays.asList(new com.google.android.gms.internal.measurement.zzaq[]{new com.google.android.gms.internal.measurement.zzas(r0), new com.google.android.gms.internal.measurement.zzai(java.lang.Double.valueOf((double) r3)), r7}));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x027f, code lost:
        return new com.google.android.gms.internal.measurement.zzas(r2.substring(0, r3) + r1.zzf() + r2.substring(r3 + r0.length()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x0280, code lost:
        r5 = r24;
        r3 = r25;
        com.google.android.gms.internal.measurement.zzg.zzc("substring", 2, r3);
        r0 = r22.zza;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x0290, code lost:
        if (r3.isEmpty() != false) goto L_0x02ab;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x0292, code lost:
        r1 = (int) com.google.android.gms.internal.measurement.zzg.zza(r5.zza(r3.get(0)).zze().doubleValue());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x02ab, code lost:
        r1 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x02b1, code lost:
        if (r3.size() <= 1) goto L_0x02cb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x02b3, code lost:
        r2 = (int) com.google.android.gms.internal.measurement.zzg.zza(r5.zza(r3.get(1)).zze().doubleValue());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x02cb, code lost:
        r2 = r0.length();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x02cf, code lost:
        r1 = java.lang.Math.min(java.lang.Math.max(r1, 0), r0.length());
        r2 = java.lang.Math.min(java.lang.Math.max(r2, 0), r0.length());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x02f9, code lost:
        return new com.google.android.gms.internal.measurement.zzas(r0.substring(java.lang.Math.min(r1, r2), java.lang.Math.max(r1, r2)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x02fa, code lost:
        r7 = r22;
        r5 = r24;
        r3 = r25;
        com.google.android.gms.internal.measurement.zzg.zzc("split", 2, r3);
        r0 = r7.zza;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x030a, code lost:
        if (r0.length() != 0) goto L_0x0318;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:0x0317, code lost:
        return new com.google.android.gms.internal.measurement.zzaf(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x0318, code lost:
        r1 = new java.util.ArrayList();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x0322, code lost:
        if (r3.isEmpty() == false) goto L_0x0329;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x0324, code lost:
        r1.add(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x0329, code lost:
        r2 = r5.zza(r3.get(0)).zzf();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x033c, code lost:
        if (r3.size() <= 1) goto L_0x0355;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:137:0x033e, code lost:
        r3 = com.google.android.gms.internal.measurement.zzg.zzc(r5.zza(r3.get(1)).zze().doubleValue());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:0x0355, code lost:
        r3 = 2147483647L;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x035c, code lost:
        if (r3 != 0) goto L_0x0364;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x0363, code lost:
        return new com.google.android.gms.internal.measurement.zzaf();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:0x0364, code lost:
        r0 = r0.split(java.util.regex.Pattern.quote(r2), ((int) r3) + 1);
        r5 = r0.length;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:0x0376, code lost:
        if (r2.isEmpty() == false) goto L_0x0392;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x0379, code lost:
        if (r0.length <= 0) goto L_0x0392;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:147:0x037b, code lost:
        r2 = r0[0].isEmpty();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:148:0x038c, code lost:
        if (r0[r0.length - 1].isEmpty() == false) goto L_0x0393;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:149:0x038e, code lost:
        r5 = r0.length - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:150:0x0392, code lost:
        r2 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:152:0x0397, code lost:
        if (((long) r0.length) <= r3) goto L_0x039b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:153:0x0399, code lost:
        r5 = r5 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x039b, code lost:
        if (r2 >= r5) goto L_0x03aa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:155:0x039d, code lost:
        r1.add(new com.google.android.gms.internal.measurement.zzas(r0[r2]));
        r2 = r2 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:157:0x03af, code lost:
        return new com.google.android.gms.internal.measurement.zzaf((java.util.List<com.google.android.gms.internal.measurement.zzaq>) r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x03b0, code lost:
        r5 = r24;
        r3 = r25;
        com.google.android.gms.internal.measurement.zzg.zzc("slice", 2, r3);
        r2 = r22.zza;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:159:0x03c0, code lost:
        if (r3.isEmpty() != false) goto L_0x03d6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:160:0x03c2, code lost:
        r8 = r5.zza(r3.get(0)).zze().doubleValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:161:0x03d6, code lost:
        r8 = 0.0d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:162:0x03d7, code lost:
        r8 = com.google.android.gms.internal.measurement.zzg.zza(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:163:0x03dd, code lost:
        if (r8 >= 0.0d) goto L_0x03ea;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:164:0x03df, code lost:
        r8 = java.lang.Math.max(((double) r2.length()) + r8, 0.0d);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:165:0x03ea, code lost:
        r8 = java.lang.Math.min(r8, (double) r2.length());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:166:0x03f3, code lost:
        r4 = (int) r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:167:0x03f9, code lost:
        if (r3.size() <= 1) goto L_0x040e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:168:0x03fb, code lost:
        r5 = r5.zza(r3.get(1)).zze().doubleValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:169:0x040e, code lost:
        r5 = (double) r2.length();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:170:0x0413, code lost:
        r5 = com.google.android.gms.internal.measurement.zzg.zza(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:171:0x0419, code lost:
        if (r5 >= 0.0d) goto L_0x0426;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:172:0x041b, code lost:
        r0 = java.lang.Math.max(((double) r2.length()) + r5, 0.0d);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:173:0x0426, code lost:
        r0 = java.lang.Math.min(r5, (double) r2.length());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:175:0x0440, code lost:
        return new com.google.android.gms.internal.measurement.zzas(r2.substring(r4, java.lang.Math.max(0, ((int) r0) - r4) + r4));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:176:0x0441, code lost:
        r5 = r24;
        r3 = r25;
        com.google.android.gms.internal.measurement.zzg.zzc("match", 1, r3);
        r0 = r22.zza;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:177:0x0451, code lost:
        if (r3.size() > 0) goto L_0x0456;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:178:0x0453, code lost:
        r1 = "";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:179:0x0456, code lost:
        r1 = r5.zza(r3.get(0)).zzf();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:180:0x0465, code lost:
        r0 = java.util.regex.Pattern.compile(r1).matcher(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:181:0x0471, code lost:
        if (r0.find() == false) goto L_0x0488;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:183:0x0487, code lost:
        return new com.google.android.gms.internal.measurement.zzaf(new com.google.android.gms.internal.measurement.zzas(r0.group()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:185:0x048a, code lost:
        return com.google.android.gms.internal.measurement.zzaq.zzd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:186:0x048b, code lost:
        com.google.android.gms.internal.measurement.zzg.zza("toUpperCase", 0, r25);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:187:0x049e, code lost:
        return new com.google.android.gms.internal.measurement.zzas(r22.zza.trim());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:188:0x049f, code lost:
        com.google.android.gms.internal.measurement.zzg.zza("toUpperCase", 0, r25);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:189:0x04b4, code lost:
        return new com.google.android.gms.internal.measurement.zzas(r22.zza.toUpperCase(java.util.Locale.ENGLISH));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:190:0x04b5, code lost:
        r5 = r24;
        r3 = r25;
        com.google.android.gms.internal.measurement.zzg.zzc("lastIndexOf", 2, r3);
        r0 = r22.zza;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:191:0x04c5, code lost:
        if (r3.size() > 0) goto L_0x04ce;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:192:0x04c7, code lost:
        r1 = com.google.android.gms.internal.measurement.zzaq.zzc.zzf();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:193:0x04ce, code lost:
        r1 = r5.zza(r3.get(0)).zzf();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:195:0x04e2, code lost:
        if (r3.size() >= 2) goto L_0x04e7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:196:0x04e4, code lost:
        r2 = Double.NaN;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:197:0x04e7, code lost:
        r2 = r5.zza(r3.get(1)).zze().doubleValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:199:0x04fe, code lost:
        if (java.lang.Double.isNaN(r2) == false) goto L_0x0503;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:200:0x0500, code lost:
        r2 = Double.POSITIVE_INFINITY;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:201:0x0503, code lost:
        r2 = com.google.android.gms.internal.measurement.zzg.zza(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:203:0x0516, code lost:
        return new com.google.android.gms.internal.measurement.zzai(java.lang.Double.valueOf((double) r0.lastIndexOf(r1, (int) r2)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:204:0x0517, code lost:
        com.google.android.gms.internal.measurement.zzg.zza("toLocaleUpperCase", 0, r25);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:205:0x052a, code lost:
        return new com.google.android.gms.internal.measurement.zzas(r22.zza.toUpperCase());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:206:0x052b, code lost:
        r7 = r22;
        r5 = r24;
        r3 = r25;
        com.google.android.gms.internal.measurement.zzg.zzc(com.google.firebase.analytics.FirebaseAnalytics.Event.SEARCH, 1, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:207:0x053a, code lost:
        if (r3.isEmpty() != false) goto L_0x054b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:208:0x053c, code lost:
        r0 = r5.zza(r3.get(0)).zzf();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:209:0x054b, code lost:
        r0 = com.google.android.gms.internal.measurement.zzaq.zzc.zzf();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:210:0x0551, code lost:
        r0 = java.util.regex.Pattern.compile(r0).matcher(r7.zza);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:211:0x055f, code lost:
        if (r0.find() == false) goto L_0x0570;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:213:0x056f, code lost:
        return new com.google.android.gms.internal.measurement.zzai(java.lang.Double.valueOf((double) r0.start()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:215:0x057b, code lost:
        return new com.google.android.gms.internal.measurement.zzai(java.lang.Double.valueOf(-1.0d));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:216:0x057c, code lost:
        com.google.android.gms.internal.measurement.zzg.zza("toLowerCase", 0, r25);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:217:0x0591, code lost:
        return new com.google.android.gms.internal.measurement.zzas(r22.zza.toLowerCase(java.util.Locale.ENGLISH));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:218:0x0592, code lost:
        r7 = r22;
        r5 = r24;
        r3 = r25;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:219:0x059c, code lost:
        if (r3.isEmpty() == false) goto L_0x059f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:220:0x059e, code lost:
        return r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:221:0x059f, code lost:
        r0 = new java.lang.StringBuilder(r7.zza);
        r1 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:223:0x05ab, code lost:
        if (r1 >= r3.size()) goto L_0x05c1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:224:0x05ad, code lost:
        r0.append(r5.zza(r3.get(r1)).zzf());
        r1 = r1 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:226:0x05ca, code lost:
        return new com.google.android.gms.internal.measurement.zzas(r0.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:227:0x05cb, code lost:
        r7 = r22;
        r5 = r24;
        r3 = r25;
        com.google.android.gms.internal.measurement.zzg.zzc(r6, 1, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:228:0x05d9, code lost:
        if (r3.isEmpty() != false) goto L_0x05f4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:229:0x05db, code lost:
        r3 = (int) com.google.android.gms.internal.measurement.zzg.zza(r5.zza(r3.get(0)).zze().doubleValue());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:230:0x05f4, code lost:
        r3 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:231:0x05f5, code lost:
        r0 = r7.zza;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:232:0x05f7, code lost:
        if (r3 < 0) goto L_0x060e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:234:0x05fd, code lost:
        if (r3 < r0.length()) goto L_0x0600;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:236:0x060d, code lost:
        return new com.google.android.gms.internal.measurement.zzas(java.lang.String.valueOf(r0.charAt(r3)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:238:0x0610, code lost:
        return com.google.android.gms.internal.measurement.zzaq.zzj;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:239:0x0611, code lost:
        com.google.android.gms.internal.measurement.zzg.zza("toLocaleLowerCase", 0, r25);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:240:0x0624, code lost:
        return new com.google.android.gms.internal.measurement.zzas(r22.zza.toLowerCase());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:241:0x0625, code lost:
        r7 = r22;
        com.google.android.gms.internal.measurement.zzg.zza(r16, 0, r25);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:242:0x062f, code lost:
        return r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:243:0x0630, code lost:
        r0 = r25;
        com.google.android.gms.internal.measurement.zzg.zza(r3, 1, r0);
        r1 = r22.zza;
        r0 = r24.zza(r0.get(0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:244:0x0651, code lost:
        if ("length".equals(r0.zzf()) == false) goto L_0x0656;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:246:0x0655, code lost:
        return com.google.android.gms.internal.measurement.zzag.zzh;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:247:0x0656, code lost:
        r2 = r0.zze().doubleValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:248:0x0664, code lost:
        if (r2 != java.lang.Math.floor(r2)) goto L_0x0672;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:249:0x0666, code lost:
        r0 = (int) r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:250:0x0667, code lost:
        if (r0 < 0) goto L_0x0672;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:252:0x066d, code lost:
        if (r0 >= r1.length()) goto L_0x0672;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:254:0x0671, code lost:
        return com.google.android.gms.internal.measurement.zzag.zzh;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:256:0x0674, code lost:
        return com.google.android.gms.internal.measurement.zzag.zzi;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00b1, code lost:
        r3 = r16;
        r6 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00b5, code lost:
        r16 = "toString";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x0166, code lost:
        r3 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x017f, code lost:
        r0 = 0.0d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x0181, code lost:
        switch(r19) {
            case 0: goto L_0x0630;
            case 1: goto L_0x0625;
            case 2: goto L_0x0611;
            case 3: goto L_0x05cb;
            case 4: goto L_0x0592;
            case 5: goto L_0x057c;
            case 6: goto L_0x052b;
            case 7: goto L_0x0517;
            case 8: goto L_0x04b5;
            case 9: goto L_0x049f;
            case 10: goto L_0x048b;
            case 11: goto L_0x0441;
            case 12: goto L_0x03b0;
            case 13: goto L_0x02fa;
            case 14: goto L_0x0280;
            case 15: goto L_0x01e5;
            case 16: goto L_0x018c;
            default: goto L_0x0184;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x018b, code lost:
        throw new java.lang.IllegalArgumentException("Command not supported");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x018c, code lost:
        r3 = r25;
        com.google.android.gms.internal.measurement.zzg.zzc("indexOf", 2, r3);
        r2 = r22.zza;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x019a, code lost:
        if (r3.size() > 0) goto L_0x01a5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x019c, code lost:
        r4 = com.google.android.gms.internal.measurement.zzaq.zzc.zzf();
        r5 = r24;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.measurement.zzaq zza(java.lang.String r23, com.google.android.gms.internal.measurement.zzh r24, java.util.List<com.google.android.gms.internal.measurement.zzaq> r25) {
        /*
            r22 = this;
            r1 = r23
            java.lang.String r4 = "charAt"
            boolean r5 = r4.equals(r1)
            java.lang.String r6 = "concat"
            java.lang.String r7 = "indexOf"
            java.lang.String r8 = "replace"
            java.lang.String r9 = "substring"
            java.lang.String r10 = "split"
            java.lang.String r11 = "slice"
            java.lang.String r12 = "match"
            java.lang.String r13 = "lastIndexOf"
            java.lang.String r14 = "toLocaleUpperCase"
            java.lang.String r15 = "search"
            r16 = r5
            java.lang.String r5 = "toLowerCase"
            java.lang.String r2 = "toLocaleLowerCase"
            java.lang.String r0 = "toString"
            java.lang.String r3 = "hasOwnProperty"
            r17 = r4
            java.lang.String r4 = "toUpperCase"
            if (r16 != 0) goto L_0x00a1
            boolean r16 = r6.equals(r1)
            if (r16 != 0) goto L_0x00a1
            boolean r16 = r3.equals(r1)
            if (r16 != 0) goto L_0x00a1
            boolean r16 = r7.equals(r1)
            if (r16 != 0) goto L_0x00a1
            boolean r16 = r13.equals(r1)
            if (r16 != 0) goto L_0x00a1
            boolean r16 = r12.equals(r1)
            if (r16 != 0) goto L_0x00a1
            boolean r16 = r8.equals(r1)
            if (r16 != 0) goto L_0x00a1
            boolean r16 = r15.equals(r1)
            if (r16 != 0) goto L_0x00a1
            boolean r16 = r11.equals(r1)
            if (r16 != 0) goto L_0x00a1
            boolean r16 = r10.equals(r1)
            if (r16 != 0) goto L_0x00a1
            boolean r16 = r9.equals(r1)
            if (r16 != 0) goto L_0x00a1
            boolean r16 = r5.equals(r1)
            if (r16 != 0) goto L_0x00a1
            boolean r16 = r2.equals(r1)
            if (r16 != 0) goto L_0x00a1
            boolean r16 = r0.equals(r1)
            if (r16 != 0) goto L_0x00a1
            boolean r16 = r4.equals(r1)
            if (r16 != 0) goto L_0x00a1
            boolean r16 = r14.equals(r1)
            if (r16 != 0) goto L_0x00a1
            r16 = r3
            java.lang.String r3 = "trim"
            boolean r3 = r3.equals(r1)
            if (r3 == 0) goto L_0x0091
            goto L_0x00a3
        L_0x0091:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r2 = "%s is not a String function"
            java.lang.Object[] r1 = new java.lang.Object[]{r1}
            java.lang.String r1 = java.lang.String.format(r2, r1)
            r0.<init>(r1)
            throw r0
        L_0x00a1:
            r16 = r3
        L_0x00a3:
            r1.hashCode()
            int r3 = r1.hashCode()
            r18 = r3
            r19 = -1
            switch(r18) {
                case -1789698943: goto L_0x0170;
                case -1776922004: goto L_0x015e;
                case -1464939364: goto L_0x014f;
                case -1361633751: goto L_0x0140;
                case -1354795244: goto L_0x0134;
                case -1137582698: goto L_0x0129;
                case -906336856: goto L_0x011f;
                case -726908483: goto L_0x0115;
                case -467511597: goto L_0x010b;
                case -399551817: goto L_0x0101;
                case 3568674: goto L_0x00f5;
                case 103668165: goto L_0x00eb;
                case 109526418: goto L_0x00e1;
                case 109648666: goto L_0x00d7;
                case 530542161: goto L_0x00cd;
                case 1094496948: goto L_0x00c3;
                case 1943291465: goto L_0x00b9;
                default: goto L_0x00b1;
            }
        L_0x00b1:
            r3 = r16
            r6 = r17
        L_0x00b5:
            r16 = r0
            goto L_0x017f
        L_0x00b9:
            boolean r1 = r1.equals(r7)
            if (r1 != 0) goto L_0x00c0
            goto L_0x00b1
        L_0x00c0:
            r19 = 16
            goto L_0x00b1
        L_0x00c3:
            boolean r1 = r1.equals(r8)
            if (r1 != 0) goto L_0x00ca
            goto L_0x00b1
        L_0x00ca:
            r19 = 15
            goto L_0x00b1
        L_0x00cd:
            boolean r1 = r1.equals(r9)
            if (r1 != 0) goto L_0x00d4
            goto L_0x00b1
        L_0x00d4:
            r19 = 14
            goto L_0x00b1
        L_0x00d7:
            boolean r1 = r1.equals(r10)
            if (r1 != 0) goto L_0x00de
            goto L_0x00b1
        L_0x00de:
            r19 = 13
            goto L_0x00b1
        L_0x00e1:
            boolean r1 = r1.equals(r11)
            if (r1 != 0) goto L_0x00e8
            goto L_0x00b1
        L_0x00e8:
            r19 = 12
            goto L_0x00b1
        L_0x00eb:
            boolean r1 = r1.equals(r12)
            if (r1 != 0) goto L_0x00f2
            goto L_0x00b1
        L_0x00f2:
            r19 = 11
            goto L_0x00b1
        L_0x00f5:
            java.lang.String r6 = "trim"
            boolean r1 = r1.equals(r6)
            if (r1 != 0) goto L_0x00fe
            goto L_0x00b1
        L_0x00fe:
            r19 = 10
            goto L_0x00b1
        L_0x0101:
            boolean r1 = r1.equals(r4)
            if (r1 != 0) goto L_0x0108
            goto L_0x00b1
        L_0x0108:
            r19 = 9
            goto L_0x00b1
        L_0x010b:
            boolean r1 = r1.equals(r13)
            if (r1 != 0) goto L_0x0112
            goto L_0x00b1
        L_0x0112:
            r19 = 8
            goto L_0x00b1
        L_0x0115:
            boolean r1 = r1.equals(r14)
            if (r1 != 0) goto L_0x011c
            goto L_0x00b1
        L_0x011c:
            r19 = 7
            goto L_0x00b1
        L_0x011f:
            boolean r1 = r1.equals(r15)
            if (r1 != 0) goto L_0x0126
            goto L_0x00b1
        L_0x0126:
            r19 = 6
            goto L_0x00b1
        L_0x0129:
            boolean r1 = r1.equals(r5)
            if (r1 != 0) goto L_0x0130
            goto L_0x00b1
        L_0x0130:
            r19 = 5
            goto L_0x00b1
        L_0x0134:
            boolean r1 = r1.equals(r6)
            if (r1 != 0) goto L_0x013c
            goto L_0x00b1
        L_0x013c:
            r19 = 4
            goto L_0x00b1
        L_0x0140:
            r6 = r17
            boolean r1 = r1.equals(r6)
            if (r1 != 0) goto L_0x0149
            goto L_0x0166
        L_0x0149:
            r3 = r16
            r19 = 3
            goto L_0x00b5
        L_0x014f:
            r6 = r17
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x0158
            goto L_0x0166
        L_0x0158:
            r3 = r16
            r19 = 2
            goto L_0x00b5
        L_0x015e:
            r6 = r17
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L_0x016a
        L_0x0166:
            r3 = r16
            goto L_0x00b5
        L_0x016a:
            r3 = r16
            r19 = 1
            goto L_0x00b5
        L_0x0170:
            r3 = r16
            r6 = r17
            boolean r1 = r1.equals(r3)
            r16 = r0
            if (r1 != 0) goto L_0x017d
            goto L_0x017f
        L_0x017d:
            r19 = 0
        L_0x017f:
            r0 = 0
            switch(r19) {
                case 0: goto L_0x0630;
                case 1: goto L_0x0625;
                case 2: goto L_0x0611;
                case 3: goto L_0x05cb;
                case 4: goto L_0x0592;
                case 5: goto L_0x057c;
                case 6: goto L_0x052b;
                case 7: goto L_0x0517;
                case 8: goto L_0x04b5;
                case 9: goto L_0x049f;
                case 10: goto L_0x048b;
                case 11: goto L_0x0441;
                case 12: goto L_0x03b0;
                case 13: goto L_0x02fa;
                case 14: goto L_0x0280;
                case 15: goto L_0x01e5;
                case 16: goto L_0x018c;
                default: goto L_0x0184;
            }
        L_0x0184:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Command not supported"
            r0.<init>(r1)
            throw r0
        L_0x018c:
            r3 = r25
            r2 = 2
            com.google.android.gms.internal.measurement.zzg.zzc(r7, r2, r3)
            r7 = r22
            java.lang.String r2 = r7.zza
            int r4 = r3.size()
            if (r4 > 0) goto L_0x01a5
            com.google.android.gms.internal.measurement.zzaq r4 = com.google.android.gms.internal.measurement.zzaq.zzc
            java.lang.String r4 = r4.zzf()
            r5 = r24
            goto L_0x01b6
        L_0x01a5:
            r4 = 0
            java.lang.Object r4 = r3.get(r4)
            com.google.android.gms.internal.measurement.zzaq r4 = (com.google.android.gms.internal.measurement.zzaq) r4
            r5 = r24
            com.google.android.gms.internal.measurement.zzaq r4 = r5.zza((com.google.android.gms.internal.measurement.zzaq) r4)
            java.lang.String r4 = r4.zzf()
        L_0x01b6:
            int r6 = r3.size()
            r8 = 2
            if (r6 >= r8) goto L_0x01be
            goto L_0x01d1
        L_0x01be:
            r0 = 1
            java.lang.Object r0 = r3.get(r0)
            com.google.android.gms.internal.measurement.zzaq r0 = (com.google.android.gms.internal.measurement.zzaq) r0
            com.google.android.gms.internal.measurement.zzaq r0 = r5.zza((com.google.android.gms.internal.measurement.zzaq) r0)
            java.lang.Double r0 = r0.zze()
            double r0 = r0.doubleValue()
        L_0x01d1:
            double r0 = com.google.android.gms.internal.measurement.zzg.zza((double) r0)
            com.google.android.gms.internal.measurement.zzai r3 = new com.google.android.gms.internal.measurement.zzai
            int r0 = (int) r0
            int r0 = r2.indexOf(r4, r0)
            double r0 = (double) r0
            java.lang.Double r0 = java.lang.Double.valueOf(r0)
            r3.<init>(r0)
            return r3
        L_0x01e5:
            r7 = r22
            r5 = r24
            r3 = r25
            r2 = 2
            com.google.android.gms.internal.measurement.zzg.zzc(r8, r2, r3)
            com.google.android.gms.internal.measurement.zzaq r0 = com.google.android.gms.internal.measurement.zzaq.zzc
            java.lang.String r0 = r0.zzf()
            com.google.android.gms.internal.measurement.zzaq r1 = com.google.android.gms.internal.measurement.zzaq.zzc
            boolean r2 = r3.isEmpty()
            if (r2 != 0) goto L_0x021d
            r4 = 0
            java.lang.Object r0 = r3.get(r4)
            com.google.android.gms.internal.measurement.zzaq r0 = (com.google.android.gms.internal.measurement.zzaq) r0
            com.google.android.gms.internal.measurement.zzaq r0 = r5.zza((com.google.android.gms.internal.measurement.zzaq) r0)
            java.lang.String r0 = r0.zzf()
            int r2 = r3.size()
            r4 = 1
            if (r2 <= r4) goto L_0x021d
            java.lang.Object r1 = r3.get(r4)
            com.google.android.gms.internal.measurement.zzaq r1 = (com.google.android.gms.internal.measurement.zzaq) r1
            com.google.android.gms.internal.measurement.zzaq r1 = r5.zza((com.google.android.gms.internal.measurement.zzaq) r1)
        L_0x021d:
            java.lang.String r2 = r7.zza
            int r3 = r2.indexOf(r0)
            if (r3 >= 0) goto L_0x0227
            goto L_0x059e
        L_0x0227:
            boolean r4 = r1 instanceof com.google.android.gms.internal.measurement.zzal
            if (r4 == 0) goto L_0x0253
            com.google.android.gms.internal.measurement.zzal r1 = (com.google.android.gms.internal.measurement.zzal) r1
            r4 = 3
            com.google.android.gms.internal.measurement.zzaq[] r4 = new com.google.android.gms.internal.measurement.zzaq[r4]
            com.google.android.gms.internal.measurement.zzas r6 = new com.google.android.gms.internal.measurement.zzas
            r6.<init>(r0)
            r17 = 0
            r4[r17] = r6
            com.google.android.gms.internal.measurement.zzai r6 = new com.google.android.gms.internal.measurement.zzai
            double r8 = (double) r3
            java.lang.Double r8 = java.lang.Double.valueOf(r8)
            r6.<init>(r8)
            r21 = 1
            r4[r21] = r6
            r20 = 2
            r4[r20] = r7
            java.util.List r4 = java.util.Arrays.asList(r4)
            com.google.android.gms.internal.measurement.zzaq r1 = r1.zza((com.google.android.gms.internal.measurement.zzh) r5, (java.util.List<com.google.android.gms.internal.measurement.zzaq>) r4)
        L_0x0253:
            com.google.android.gms.internal.measurement.zzas r4 = new com.google.android.gms.internal.measurement.zzas
            r5 = 0
            java.lang.String r5 = r2.substring(r5, r3)
            java.lang.String r1 = r1.zzf()
            int r0 = r0.length()
            int r3 = r3 + r0
            java.lang.String r0 = r2.substring(r3)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.StringBuilder r2 = r2.append(r5)
            java.lang.StringBuilder r1 = r2.append(r1)
            java.lang.StringBuilder r0 = r1.append(r0)
            java.lang.String r0 = r0.toString()
            r4.<init>(r0)
            return r4
        L_0x0280:
            r7 = r22
            r5 = r24
            r3 = r25
            r2 = 2
            com.google.android.gms.internal.measurement.zzg.zzc(r9, r2, r3)
            java.lang.String r0 = r7.zza
            boolean r1 = r3.isEmpty()
            if (r1 != 0) goto L_0x02ab
            r4 = 0
            java.lang.Object r1 = r3.get(r4)
            com.google.android.gms.internal.measurement.zzaq r1 = (com.google.android.gms.internal.measurement.zzaq) r1
            com.google.android.gms.internal.measurement.zzaq r1 = r5.zza((com.google.android.gms.internal.measurement.zzaq) r1)
            java.lang.Double r1 = r1.zze()
            double r1 = r1.doubleValue()
            double r1 = com.google.android.gms.internal.measurement.zzg.zza((double) r1)
            int r1 = (int) r1
            goto L_0x02ac
        L_0x02ab:
            r1 = 0
        L_0x02ac:
            int r2 = r3.size()
            r4 = 1
            if (r2 <= r4) goto L_0x02cb
            java.lang.Object r2 = r3.get(r4)
            com.google.android.gms.internal.measurement.zzaq r2 = (com.google.android.gms.internal.measurement.zzaq) r2
            com.google.android.gms.internal.measurement.zzaq r2 = r5.zza((com.google.android.gms.internal.measurement.zzaq) r2)
            java.lang.Double r2 = r2.zze()
            double r2 = r2.doubleValue()
            double r2 = com.google.android.gms.internal.measurement.zzg.zza((double) r2)
            int r2 = (int) r2
            goto L_0x02cf
        L_0x02cb:
            int r2 = r0.length()
        L_0x02cf:
            r4 = 0
            int r1 = java.lang.Math.max(r1, r4)
            int r3 = r0.length()
            int r1 = java.lang.Math.min(r1, r3)
            int r2 = java.lang.Math.max(r2, r4)
            int r3 = r0.length()
            int r2 = java.lang.Math.min(r2, r3)
            com.google.android.gms.internal.measurement.zzas r3 = new com.google.android.gms.internal.measurement.zzas
            int r4 = java.lang.Math.min(r1, r2)
            int r1 = java.lang.Math.max(r1, r2)
            java.lang.String r0 = r0.substring(r4, r1)
            r3.<init>(r0)
            return r3
        L_0x02fa:
            r7 = r22
            r5 = r24
            r3 = r25
            r2 = 2
            com.google.android.gms.internal.measurement.zzg.zzc(r10, r2, r3)
            java.lang.String r0 = r7.zza
            int r1 = r0.length()
            if (r1 != 0) goto L_0x0318
            com.google.android.gms.internal.measurement.zzaf r0 = new com.google.android.gms.internal.measurement.zzaf
            r4 = 1
            com.google.android.gms.internal.measurement.zzaq[] r1 = new com.google.android.gms.internal.measurement.zzaq[r4]
            r4 = 0
            r1[r4] = r7
            r0.<init>((com.google.android.gms.internal.measurement.zzaq[]) r1)
            return r0
        L_0x0318:
            r4 = 0
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            boolean r2 = r3.isEmpty()
            if (r2 == 0) goto L_0x0329
            r1.add(r7)
            goto L_0x03aa
        L_0x0329:
            java.lang.Object r2 = r3.get(r4)
            com.google.android.gms.internal.measurement.zzaq r2 = (com.google.android.gms.internal.measurement.zzaq) r2
            com.google.android.gms.internal.measurement.zzaq r2 = r5.zza((com.google.android.gms.internal.measurement.zzaq) r2)
            java.lang.String r2 = r2.zzf()
            int r4 = r3.size()
            r6 = 1
            if (r4 <= r6) goto L_0x0355
            java.lang.Object r3 = r3.get(r6)
            com.google.android.gms.internal.measurement.zzaq r3 = (com.google.android.gms.internal.measurement.zzaq) r3
            com.google.android.gms.internal.measurement.zzaq r3 = r5.zza((com.google.android.gms.internal.measurement.zzaq) r3)
            java.lang.Double r3 = r3.zze()
            double r3 = r3.doubleValue()
            long r3 = com.google.android.gms.internal.measurement.zzg.zzc(r3)
            goto L_0x0358
        L_0x0355:
            r3 = 2147483647(0x7fffffff, double:1.060997895E-314)
        L_0x0358:
            r5 = 0
            int r5 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r5 != 0) goto L_0x0364
            com.google.android.gms.internal.measurement.zzaf r0 = new com.google.android.gms.internal.measurement.zzaf
            r0.<init>()
            return r0
        L_0x0364:
            java.lang.String r5 = java.util.regex.Pattern.quote(r2)
            int r6 = (int) r3
            r21 = 1
            int r6 = r6 + 1
            java.lang.String[] r0 = r0.split(r5, r6)
            int r5 = r0.length
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L_0x0392
            int r2 = r0.length
            if (r2 <= 0) goto L_0x0392
            r17 = 0
            r2 = r0[r17]
            boolean r2 = r2.isEmpty()
            int r6 = r0.length
            int r6 = r6 + -1
            r6 = r0[r6]
            boolean r6 = r6.isEmpty()
            if (r6 == 0) goto L_0x0393
            int r5 = r0.length
            int r5 = r5 + -1
            goto L_0x0393
        L_0x0392:
            r2 = 0
        L_0x0393:
            int r6 = r0.length
            long r8 = (long) r6
            int r3 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r3 <= 0) goto L_0x039b
            int r5 = r5 + -1
        L_0x039b:
            if (r2 >= r5) goto L_0x03aa
            com.google.android.gms.internal.measurement.zzas r3 = new com.google.android.gms.internal.measurement.zzas
            r4 = r0[r2]
            r3.<init>(r4)
            r1.add(r3)
            int r2 = r2 + 1
            goto L_0x039b
        L_0x03aa:
            com.google.android.gms.internal.measurement.zzaf r0 = new com.google.android.gms.internal.measurement.zzaf
            r0.<init>((java.util.List<com.google.android.gms.internal.measurement.zzaq>) r1)
            return r0
        L_0x03b0:
            r7 = r22
            r5 = r24
            r3 = r25
            r2 = 2
            com.google.android.gms.internal.measurement.zzg.zzc(r11, r2, r3)
            java.lang.String r2 = r7.zza
            boolean r4 = r3.isEmpty()
            if (r4 != 0) goto L_0x03d6
            r4 = 0
            java.lang.Object r6 = r3.get(r4)
            com.google.android.gms.internal.measurement.zzaq r6 = (com.google.android.gms.internal.measurement.zzaq) r6
            com.google.android.gms.internal.measurement.zzaq r4 = r5.zza((com.google.android.gms.internal.measurement.zzaq) r6)
            java.lang.Double r4 = r4.zze()
            double r8 = r4.doubleValue()
            goto L_0x03d7
        L_0x03d6:
            r8 = r0
        L_0x03d7:
            double r8 = com.google.android.gms.internal.measurement.zzg.zza((double) r8)
            int r4 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r4 >= 0) goto L_0x03ea
            int r4 = r2.length()
            double r10 = (double) r4
            double r10 = r10 + r8
            double r8 = java.lang.Math.max(r10, r0)
            goto L_0x03f3
        L_0x03ea:
            int r4 = r2.length()
            double r10 = (double) r4
            double r8 = java.lang.Math.min(r8, r10)
        L_0x03f3:
            int r4 = (int) r8
            int r6 = r3.size()
            r8 = 1
            if (r6 <= r8) goto L_0x040e
            java.lang.Object r3 = r3.get(r8)
            com.google.android.gms.internal.measurement.zzaq r3 = (com.google.android.gms.internal.measurement.zzaq) r3
            com.google.android.gms.internal.measurement.zzaq r3 = r5.zza((com.google.android.gms.internal.measurement.zzaq) r3)
            java.lang.Double r3 = r3.zze()
            double r5 = r3.doubleValue()
            goto L_0x0413
        L_0x040e:
            int r3 = r2.length()
            double r5 = (double) r3
        L_0x0413:
            double r5 = com.google.android.gms.internal.measurement.zzg.zza((double) r5)
            int r3 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            if (r3 >= 0) goto L_0x0426
            int r3 = r2.length()
            double r8 = (double) r3
            double r8 = r8 + r5
            double r0 = java.lang.Math.max(r8, r0)
            goto L_0x042f
        L_0x0426:
            int r0 = r2.length()
            double r0 = (double) r0
            double r0 = java.lang.Math.min(r5, r0)
        L_0x042f:
            int r0 = (int) r0
            int r0 = r0 - r4
            r5 = 0
            int r0 = java.lang.Math.max(r5, r0)
            int r0 = r0 + r4
            com.google.android.gms.internal.measurement.zzas r1 = new com.google.android.gms.internal.measurement.zzas
            java.lang.String r0 = r2.substring(r4, r0)
            r1.<init>(r0)
            return r1
        L_0x0441:
            r7 = r22
            r5 = r24
            r3 = r25
            r4 = 1
            com.google.android.gms.internal.measurement.zzg.zzc(r12, r4, r3)
            java.lang.String r0 = r7.zza
            int r1 = r3.size()
            if (r1 > 0) goto L_0x0456
            java.lang.String r1 = ""
            goto L_0x0465
        L_0x0456:
            r4 = 0
            java.lang.Object r1 = r3.get(r4)
            com.google.android.gms.internal.measurement.zzaq r1 = (com.google.android.gms.internal.measurement.zzaq) r1
            com.google.android.gms.internal.measurement.zzaq r1 = r5.zza((com.google.android.gms.internal.measurement.zzaq) r1)
            java.lang.String r1 = r1.zzf()
        L_0x0465:
            java.util.regex.Pattern r1 = java.util.regex.Pattern.compile(r1)
            java.util.regex.Matcher r0 = r1.matcher(r0)
            boolean r1 = r0.find()
            if (r1 == 0) goto L_0x0488
            com.google.android.gms.internal.measurement.zzaf r1 = new com.google.android.gms.internal.measurement.zzaf
            r4 = 1
            com.google.android.gms.internal.measurement.zzaq[] r2 = new com.google.android.gms.internal.measurement.zzaq[r4]
            com.google.android.gms.internal.measurement.zzas r3 = new com.google.android.gms.internal.measurement.zzas
            java.lang.String r0 = r0.group()
            r3.<init>(r0)
            r5 = 0
            r2[r5] = r3
            r1.<init>((com.google.android.gms.internal.measurement.zzaq[]) r2)
            return r1
        L_0x0488:
            com.google.android.gms.internal.measurement.zzaq r0 = com.google.android.gms.internal.measurement.zzaq.zzd
            return r0
        L_0x048b:
            r5 = 0
            r7 = r22
            r3 = r25
            com.google.android.gms.internal.measurement.zzg.zza((java.lang.String) r4, (int) r5, (java.util.List<com.google.android.gms.internal.measurement.zzaq>) r3)
            java.lang.String r0 = r7.zza
            com.google.android.gms.internal.measurement.zzas r1 = new com.google.android.gms.internal.measurement.zzas
            java.lang.String r0 = r0.trim()
            r1.<init>(r0)
            return r1
        L_0x049f:
            r5 = 0
            r7 = r22
            r3 = r25
            com.google.android.gms.internal.measurement.zzg.zza((java.lang.String) r4, (int) r5, (java.util.List<com.google.android.gms.internal.measurement.zzaq>) r3)
            java.lang.String r0 = r7.zza
            com.google.android.gms.internal.measurement.zzas r1 = new com.google.android.gms.internal.measurement.zzas
            java.util.Locale r2 = java.util.Locale.ENGLISH
            java.lang.String r0 = r0.toUpperCase(r2)
            r1.<init>(r0)
            return r1
        L_0x04b5:
            r7 = r22
            r5 = r24
            r3 = r25
            r2 = 2
            com.google.android.gms.internal.measurement.zzg.zzc(r13, r2, r3)
            java.lang.String r0 = r7.zza
            int r1 = r3.size()
            if (r1 > 0) goto L_0x04ce
            com.google.android.gms.internal.measurement.zzaq r1 = com.google.android.gms.internal.measurement.zzaq.zzc
            java.lang.String r1 = r1.zzf()
            goto L_0x04dd
        L_0x04ce:
            r4 = 0
            java.lang.Object r1 = r3.get(r4)
            com.google.android.gms.internal.measurement.zzaq r1 = (com.google.android.gms.internal.measurement.zzaq) r1
            com.google.android.gms.internal.measurement.zzaq r1 = r5.zza((com.google.android.gms.internal.measurement.zzaq) r1)
            java.lang.String r1 = r1.zzf()
        L_0x04dd:
            int r2 = r3.size()
            r8 = 2
            if (r2 >= r8) goto L_0x04e7
            r2 = 9221120237041090560(0x7ff8000000000000, double:NaN)
            goto L_0x04fa
        L_0x04e7:
            r4 = 1
            java.lang.Object r2 = r3.get(r4)
            com.google.android.gms.internal.measurement.zzaq r2 = (com.google.android.gms.internal.measurement.zzaq) r2
            com.google.android.gms.internal.measurement.zzaq r2 = r5.zza((com.google.android.gms.internal.measurement.zzaq) r2)
            java.lang.Double r2 = r2.zze()
            double r2 = r2.doubleValue()
        L_0x04fa:
            boolean r4 = java.lang.Double.isNaN(r2)
            if (r4 == 0) goto L_0x0503
            r2 = 9218868437227405312(0x7ff0000000000000, double:Infinity)
            goto L_0x0507
        L_0x0503:
            double r2 = com.google.android.gms.internal.measurement.zzg.zza((double) r2)
        L_0x0507:
            com.google.android.gms.internal.measurement.zzai r4 = new com.google.android.gms.internal.measurement.zzai
            int r2 = (int) r2
            int r0 = r0.lastIndexOf(r1, r2)
            double r0 = (double) r0
            java.lang.Double r0 = java.lang.Double.valueOf(r0)
            r4.<init>(r0)
            return r4
        L_0x0517:
            r4 = 0
            r7 = r22
            r3 = r25
            com.google.android.gms.internal.measurement.zzg.zza((java.lang.String) r14, (int) r4, (java.util.List<com.google.android.gms.internal.measurement.zzaq>) r3)
            java.lang.String r0 = r7.zza
            com.google.android.gms.internal.measurement.zzas r1 = new com.google.android.gms.internal.measurement.zzas
            java.lang.String r0 = r0.toUpperCase()
            r1.<init>(r0)
            return r1
        L_0x052b:
            r7 = r22
            r5 = r24
            r3 = r25
            r0 = 1
            r4 = 0
            com.google.android.gms.internal.measurement.zzg.zzc(r15, r0, r3)
            boolean r0 = r3.isEmpty()
            if (r0 != 0) goto L_0x054b
            java.lang.Object r0 = r3.get(r4)
            com.google.android.gms.internal.measurement.zzaq r0 = (com.google.android.gms.internal.measurement.zzaq) r0
            com.google.android.gms.internal.measurement.zzaq r0 = r5.zza((com.google.android.gms.internal.measurement.zzaq) r0)
            java.lang.String r0 = r0.zzf()
            goto L_0x0551
        L_0x054b:
            com.google.android.gms.internal.measurement.zzaq r0 = com.google.android.gms.internal.measurement.zzaq.zzc
            java.lang.String r0 = r0.zzf()
        L_0x0551:
            java.lang.String r1 = r7.zza
            java.util.regex.Pattern r0 = java.util.regex.Pattern.compile(r0)
            java.util.regex.Matcher r0 = r0.matcher(r1)
            boolean r1 = r0.find()
            if (r1 == 0) goto L_0x0570
            com.google.android.gms.internal.measurement.zzai r1 = new com.google.android.gms.internal.measurement.zzai
            int r0 = r0.start()
            double r2 = (double) r0
            java.lang.Double r0 = java.lang.Double.valueOf(r2)
            r1.<init>(r0)
            return r1
        L_0x0570:
            com.google.android.gms.internal.measurement.zzai r0 = new com.google.android.gms.internal.measurement.zzai
            r1 = -4616189618054758400(0xbff0000000000000, double:-1.0)
            java.lang.Double r1 = java.lang.Double.valueOf(r1)
            r0.<init>(r1)
            return r0
        L_0x057c:
            r4 = 0
            r7 = r22
            r3 = r25
            com.google.android.gms.internal.measurement.zzg.zza((java.lang.String) r5, (int) r4, (java.util.List<com.google.android.gms.internal.measurement.zzaq>) r3)
            java.lang.String r0 = r7.zza
            com.google.android.gms.internal.measurement.zzas r1 = new com.google.android.gms.internal.measurement.zzas
            java.util.Locale r2 = java.util.Locale.ENGLISH
            java.lang.String r0 = r0.toLowerCase(r2)
            r1.<init>(r0)
            return r1
        L_0x0592:
            r7 = r22
            r5 = r24
            r3 = r25
            boolean r0 = r3.isEmpty()
            if (r0 == 0) goto L_0x059f
        L_0x059e:
            return r7
        L_0x059f:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = r7.zza
            r0.<init>(r1)
            r1 = 0
        L_0x05a7:
            int r2 = r3.size()
            if (r1 >= r2) goto L_0x05c1
            java.lang.Object r2 = r3.get(r1)
            com.google.android.gms.internal.measurement.zzaq r2 = (com.google.android.gms.internal.measurement.zzaq) r2
            com.google.android.gms.internal.measurement.zzaq r2 = r5.zza((com.google.android.gms.internal.measurement.zzaq) r2)
            java.lang.String r2 = r2.zzf()
            r0.append(r2)
            int r1 = r1 + 1
            goto L_0x05a7
        L_0x05c1:
            com.google.android.gms.internal.measurement.zzas r1 = new com.google.android.gms.internal.measurement.zzas
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            return r1
        L_0x05cb:
            r7 = r22
            r5 = r24
            r3 = r25
            r4 = 1
            com.google.android.gms.internal.measurement.zzg.zzc(r6, r4, r3)
            boolean r0 = r3.isEmpty()
            if (r0 != 0) goto L_0x05f4
            r4 = 0
            java.lang.Object r0 = r3.get(r4)
            com.google.android.gms.internal.measurement.zzaq r0 = (com.google.android.gms.internal.measurement.zzaq) r0
            com.google.android.gms.internal.measurement.zzaq r0 = r5.zza((com.google.android.gms.internal.measurement.zzaq) r0)
            java.lang.Double r0 = r0.zze()
            double r0 = r0.doubleValue()
            double r0 = com.google.android.gms.internal.measurement.zzg.zza((double) r0)
            int r3 = (int) r0
            goto L_0x05f5
        L_0x05f4:
            r3 = 0
        L_0x05f5:
            java.lang.String r0 = r7.zza
            if (r3 < 0) goto L_0x060e
            int r1 = r0.length()
            if (r3 < r1) goto L_0x0600
            goto L_0x060e
        L_0x0600:
            com.google.android.gms.internal.measurement.zzas r1 = new com.google.android.gms.internal.measurement.zzas
            char r0 = r0.charAt(r3)
            java.lang.String r0 = java.lang.String.valueOf(r0)
            r1.<init>(r0)
            return r1
        L_0x060e:
            com.google.android.gms.internal.measurement.zzaq r0 = com.google.android.gms.internal.measurement.zzaq.zzj
            return r0
        L_0x0611:
            r4 = 0
            r7 = r22
            r3 = r25
            com.google.android.gms.internal.measurement.zzg.zza((java.lang.String) r2, (int) r4, (java.util.List<com.google.android.gms.internal.measurement.zzaq>) r3)
            java.lang.String r0 = r7.zza
            com.google.android.gms.internal.measurement.zzas r1 = new com.google.android.gms.internal.measurement.zzas
            java.lang.String r0 = r0.toLowerCase()
            r1.<init>(r0)
            return r1
        L_0x0625:
            r4 = 0
            r7 = r22
            r3 = r25
            r0 = r16
            com.google.android.gms.internal.measurement.zzg.zza((java.lang.String) r0, (int) r4, (java.util.List<com.google.android.gms.internal.measurement.zzaq>) r3)
            return r7
        L_0x0630:
            r7 = r22
            r5 = r24
            r0 = r25
            r4 = 0
            r6 = 1
            com.google.android.gms.internal.measurement.zzg.zza((java.lang.String) r3, (int) r6, (java.util.List<com.google.android.gms.internal.measurement.zzaq>) r0)
            java.lang.String r1 = r7.zza
            java.lang.Object r0 = r0.get(r4)
            com.google.android.gms.internal.measurement.zzaq r0 = (com.google.android.gms.internal.measurement.zzaq) r0
            com.google.android.gms.internal.measurement.zzaq r0 = r5.zza((com.google.android.gms.internal.measurement.zzaq) r0)
            java.lang.String r2 = "length"
            java.lang.String r3 = r0.zzf()
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x0656
            com.google.android.gms.internal.measurement.zzaq r0 = com.google.android.gms.internal.measurement.zzag.zzh
            return r0
        L_0x0656:
            java.lang.Double r0 = r0.zze()
            double r2 = r0.doubleValue()
            double r4 = java.lang.Math.floor(r2)
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 != 0) goto L_0x0672
            int r0 = (int) r2
            if (r0 < 0) goto L_0x0672
            int r1 = r1.length()
            if (r0 >= r1) goto L_0x0672
            com.google.android.gms.internal.measurement.zzaq r0 = com.google.android.gms.internal.measurement.zzag.zzh
            return r0
        L_0x0672:
            com.google.android.gms.internal.measurement.zzaq r0 = com.google.android.gms.internal.measurement.zzag.zzi
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzas.zza(java.lang.String, com.google.android.gms.internal.measurement.zzh, java.util.List):com.google.android.gms.internal.measurement.zzaq");
    }

    public final zzaq zzc() {
        return new zzas(this.zza);
    }

    public final Boolean zzd() {
        return Boolean.valueOf(!this.zza.isEmpty());
    }

    public final Double zze() {
        if (this.zza.isEmpty()) {
            return Double.valueOf(0.0d);
        }
        try {
            return Double.valueOf(this.zza);
        } catch (NumberFormatException unused) {
            return Double.valueOf(Double.NaN);
        }
    }

    public final String zzf() {
        return this.zza;
    }

    public final String toString() {
        return "\"" + this.zza + "\"";
    }

    public final Iterator<zzaq> zzh() {
        return new zzav(this);
    }

    public final Iterator<zzaq> iterator() {
        return new zzau(this);
    }

    public zzas(String str) {
        if (str != null) {
            this.zza = str;
            return;
        }
        throw new IllegalArgumentException("StringValue cannot be null.");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzas)) {
            return false;
        }
        return this.zza.equals(((zzas) obj).zza);
    }
}
