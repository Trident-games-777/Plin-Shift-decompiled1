package com.google.android.gms.internal.ads;

import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzalp {
    private static final Pattern zza = Pattern.compile("\\[voice=\"([^\"]*)\"\\]");
    private static final Pattern zzb = Pattern.compile("^((?:[0-9]*\\.)?[0-9]+)(px|em|%)$");
    private final zzed zzc = new zzed();
    private final StringBuilder zzd = new StringBuilder();

    static String zza(zzed zzed, StringBuilder sb) {
        zzc(zzed);
        if (zzed.zzb() == 0) {
            return null;
        }
        String zzd2 = zzd(zzed, sb);
        if (!"".equals(zzd2)) {
            return zzd2;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append((char) zzed.zzm());
        return sb2.toString();
    }

    static void zzc(zzed zzed) {
        while (true) {
            boolean z = true;
            while (zzed.zzb() > 0 && z) {
                char c = (char) zzed.zzN()[zzed.zzd()];
                if (c == 9 || c == 10 || c == 12 || c == 13 || c == ' ') {
                    zzed.zzM(1);
                } else {
                    int zzd2 = zzed.zzd();
                    int zze = zzed.zze();
                    byte[] zzN = zzed.zzN();
                    if (zzd2 + 2 <= zze) {
                        int i = zzd2 + 1;
                        if (zzN[zzd2] == 47) {
                            int i2 = zzd2 + 2;
                            if (zzN[i] == 42) {
                                while (true) {
                                    int i3 = i2 + 1;
                                    if (i3 >= zze) {
                                        break;
                                    } else if (((char) zzN[i2]) == '*' && ((char) zzN[i3]) == '/') {
                                        zze = i2 + 2;
                                        i2 = zze;
                                    } else {
                                        i2 = i3;
                                    }
                                }
                                zzed.zzM(zze - zzed.zzd());
                            }
                        } else {
                            continue;
                        }
                    }
                    z = false;
                }
            }
            return;
        }
    }

    private static String zzd(zzed zzed, StringBuilder sb) {
        sb.setLength(0);
        int zzd2 = zzed.zzd();
        int zze = zzed.zze();
        loop0:
        while (true) {
            boolean z = false;
            while (zzd2 < zze && !z) {
                char c = (char) zzed.zzN()[zzd2];
                if ((c < 'A' || c > 'Z') && ((c < 'a' || c > 'z') && !((c >= '0' && c <= '9') || c == '#' || c == '-' || c == '.' || c == '_'))) {
                    z = true;
                } else {
                    sb.append(c);
                    zzd2++;
                }
            }
        }
        zzed.zzM(zzd2 - zzed.zzd());
        return sb.toString();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00b0, code lost:
        if (")".equals(zza(r3, r4)) == false) goto L_0x0044;
     */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x02e9  */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x02fc  */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x0320 A[EDGE_INSN: B:160:0x0320->B:158:0x0320 ?: BREAK  
    EDGE_INSN: B:161:0x0320->B:158:0x0320 ?: BREAK  , RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00c5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List zzb(com.google.android.gms.internal.ads.zzed r18) {
        /*
            r17 = this;
            r0 = r17
            java.lang.StringBuilder r1 = r0.zzd
            r2 = 0
            r1.setLength(r2)
            int r1 = r18.zzd()
        L_0x000c:
            java.nio.charset.Charset r3 = java.nio.charset.StandardCharsets.UTF_8
            r4 = r18
            java.lang.String r3 = r4.zzz(r3)
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 == 0) goto L_0x000c
            com.google.android.gms.internal.ads.zzed r3 = r0.zzc
            byte[] r5 = r4.zzN()
            int r4 = r4.zzd()
            r3.zzJ(r5, r4)
            com.google.android.gms.internal.ads.zzed r3 = r0.zzc
            r3.zzL(r1)
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
        L_0x0031:
            com.google.android.gms.internal.ads.zzed r3 = r0.zzc
            java.lang.StringBuilder r4 = r0.zzd
            zzc(r3)
            int r5 = r3.zzb()
            java.lang.String r6 = "{"
            r7 = 5
            java.lang.String r8 = ""
            r10 = 1
            if (r5 >= r7) goto L_0x0047
        L_0x0044:
            r5 = 0
            goto L_0x00b3
        L_0x0047:
            java.nio.charset.Charset r5 = java.nio.charset.StandardCharsets.UTF_8
            java.lang.String r5 = r3.zzB(r7, r5)
            java.lang.String r7 = "::cue"
            boolean r5 = r7.equals(r5)
            if (r5 != 0) goto L_0x0056
            goto L_0x0044
        L_0x0056:
            int r5 = r3.zzd()
            java.lang.String r7 = zza(r3, r4)
            if (r7 != 0) goto L_0x0061
            goto L_0x0044
        L_0x0061:
            boolean r11 = r6.equals(r7)
            if (r11 == 0) goto L_0x006c
            r3.zzL(r5)
            r5 = r8
            goto L_0x00b3
        L_0x006c:
            java.lang.String r5 = "("
            boolean r5 = r5.equals(r7)
            if (r5 == 0) goto L_0x00a5
            int r5 = r3.zzd()
            int r7 = r3.zze()
            r11 = r2
        L_0x007d:
            if (r5 >= r7) goto L_0x0093
            if (r11 != 0) goto L_0x0093
            byte[] r11 = r3.zzN()
            int r12 = r5 + 1
            byte r5 = r11[r5]
            char r5 = (char) r5
            r11 = 41
            if (r5 != r11) goto L_0x0090
            r11 = r10
            goto L_0x0091
        L_0x0090:
            r11 = r2
        L_0x0091:
            r5 = r12
            goto L_0x007d
        L_0x0093:
            int r5 = r5 + -1
            int r7 = r3.zzd()
            int r5 = r5 - r7
            java.nio.charset.Charset r7 = java.nio.charset.StandardCharsets.UTF_8
            java.lang.String r5 = r3.zzB(r5, r7)
            java.lang.String r5 = r5.trim()
            goto L_0x00a6
        L_0x00a5:
            r5 = 0
        L_0x00a6:
            java.lang.String r3 = zza(r3, r4)
            java.lang.String r4 = ")"
            boolean r3 = r4.equals(r3)
            if (r3 != 0) goto L_0x00b3
            goto L_0x0044
        L_0x00b3:
            if (r5 == 0) goto L_0x0320
            com.google.android.gms.internal.ads.zzed r3 = r0.zzc
            java.lang.StringBuilder r4 = r0.zzd
            java.lang.String r3 = zza(r3, r4)
            boolean r3 = r6.equals(r3)
            if (r3 != 0) goto L_0x00c5
            goto L_0x0320
        L_0x00c5:
            com.google.android.gms.internal.ads.zzalq r3 = new com.google.android.gms.internal.ads.zzalq
            r3.<init>()
            boolean r4 = r8.equals(r5)
            r6 = -1
            if (r4 == 0) goto L_0x00d4
        L_0x00d1:
            r4 = r2
            r5 = 0
            goto L_0x0130
        L_0x00d4:
            r4 = 91
            int r4 = r5.indexOf(r4)
            if (r4 == r6) goto L_0x00fd
            java.util.regex.Pattern r7 = zza
            java.lang.String r11 = r5.substring(r4)
            java.util.regex.Matcher r7 = r7.matcher(r11)
            boolean r11 = r7.matches()
            if (r11 == 0) goto L_0x00f9
            java.lang.String r7 = r7.group(r10)
            r7.getClass()
            r11 = r7
            java.lang.String r11 = (java.lang.String) r11
            r3.zzv(r7)
        L_0x00f9:
            java.lang.String r5 = r5.substring(r2, r4)
        L_0x00fd:
            int r4 = com.google.android.gms.internal.ads.zzen.zza
            java.lang.String r4 = "\\."
            java.lang.String[] r4 = r5.split(r4, r6)
            r5 = r4[r2]
            r7 = 35
            int r7 = r5.indexOf(r7)
            if (r7 == r6) goto L_0x0120
            java.lang.String r11 = r5.substring(r2, r7)
            r3.zzu(r11)
            int r7 = r7 + 1
            java.lang.String r5 = r5.substring(r7)
            r3.zzt(r5)
            goto L_0x0123
        L_0x0120:
            r3.zzu(r5)
        L_0x0123:
            int r5 = r4.length
            if (r5 <= r10) goto L_0x00d1
            java.lang.Object[] r4 = java.util.Arrays.copyOfRange(r4, r10, r5)
            java.lang.String[] r4 = (java.lang.String[]) r4
            r3.zzs(r4)
            goto L_0x00d1
        L_0x0130:
            java.lang.String r7 = "}"
            if (r4 != 0) goto L_0x0314
            com.google.android.gms.internal.ads.zzed r4 = r0.zzc
            java.lang.StringBuilder r5 = r0.zzd
            int r11 = r4.zzd()
            java.lang.String r5 = zza(r4, r5)
            if (r5 == 0) goto L_0x014b
            boolean r4 = r7.equals(r5)
            if (r4 == 0) goto L_0x0149
            goto L_0x014b
        L_0x0149:
            r4 = r2
            goto L_0x014c
        L_0x014b:
            r4 = r10
        L_0x014c:
            if (r4 != 0) goto L_0x0310
            com.google.android.gms.internal.ads.zzed r12 = r0.zzc
            r12.zzL(r11)
            com.google.android.gms.internal.ads.zzed r11 = r0.zzc
            java.lang.StringBuilder r12 = r0.zzd
            zzc(r11)
            java.lang.String r13 = zzd(r11, r12)
            boolean r14 = r8.equals(r13)
            if (r14 == 0) goto L_0x0166
            goto L_0x0310
        L_0x0166:
            java.lang.String r14 = zza(r11, r12)
            java.lang.String r15 = ":"
            boolean r14 = r15.equals(r14)
            if (r14 != 0) goto L_0x0174
            goto L_0x0310
        L_0x0174:
            zzc(r11)
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            r15 = r2
        L_0x017d:
            java.lang.String r2 = ";"
            if (r15 != 0) goto L_0x01a4
            int r6 = r11.zzd()
            java.lang.String r9 = zza(r11, r12)
            if (r9 != 0) goto L_0x018d
            r6 = 0
            goto L_0x01a8
        L_0x018d:
            boolean r16 = r7.equals(r9)
            if (r16 != 0) goto L_0x019e
            boolean r2 = r2.equals(r9)
            if (r2 == 0) goto L_0x019a
            goto L_0x019e
        L_0x019a:
            r14.append(r9)
            goto L_0x01a2
        L_0x019e:
            r11.zzL(r6)
            r15 = r10
        L_0x01a2:
            r6 = -1
            goto L_0x017d
        L_0x01a4:
            java.lang.String r6 = r14.toString()
        L_0x01a8:
            if (r6 == 0) goto L_0x0310
            boolean r9 = r8.equals(r6)
            if (r9 == 0) goto L_0x01b2
            goto L_0x0310
        L_0x01b2:
            int r9 = r11.zzd()
            java.lang.String r12 = zza(r11, r12)
            boolean r2 = r2.equals(r12)
            if (r2 == 0) goto L_0x01c1
            goto L_0x01ca
        L_0x01c1:
            boolean r2 = r7.equals(r12)
            if (r2 == 0) goto L_0x0310
            r11.zzL(r9)
        L_0x01ca:
            java.lang.String r2 = "color"
            boolean r2 = r2.equals(r13)
            if (r2 == 0) goto L_0x01db
            int r2 = com.google.android.gms.internal.ads.zzde.zza(r6)
            r3.zzk(r2)
            goto L_0x0310
        L_0x01db:
            java.lang.String r2 = "background-color"
            boolean r2 = r2.equals(r13)
            if (r2 == 0) goto L_0x01ec
            int r2 = com.google.android.gms.internal.ads.zzde.zza(r6)
            r3.zzh(r2)
            goto L_0x0310
        L_0x01ec:
            java.lang.String r2 = "ruby-position"
            boolean r2 = r2.equals(r13)
            r7 = 2
            if (r2 == 0) goto L_0x020f
            java.lang.String r2 = "over"
            boolean r2 = r2.equals(r6)
            if (r2 == 0) goto L_0x0202
            r3.zzp(r10)
            goto L_0x0310
        L_0x0202:
            java.lang.String r2 = "under"
            boolean r2 = r2.equals(r6)
            if (r2 == 0) goto L_0x0310
            r3.zzp(r7)
            goto L_0x0310
        L_0x020f:
            java.lang.String r2 = "text-combine-upright"
            boolean r2 = r2.equals(r13)
            if (r2 == 0) goto L_0x0230
            java.lang.String r2 = "all"
            boolean r2 = r2.equals(r6)
            if (r2 != 0) goto L_0x022a
            java.lang.String r2 = "digits"
            boolean r2 = r6.startsWith(r2)
            if (r2 == 0) goto L_0x0228
            goto L_0x022a
        L_0x0228:
            r2 = 0
            goto L_0x022b
        L_0x022a:
            r2 = r10
        L_0x022b:
            r3.zzj(r2)
            goto L_0x0310
        L_0x0230:
            java.lang.String r2 = "text-decoration"
            boolean r2 = r2.equals(r13)
            if (r2 == 0) goto L_0x0245
            java.lang.String r2 = "underline"
            boolean r2 = r2.equals(r6)
            if (r2 == 0) goto L_0x0310
            r3.zzq(r10)
            goto L_0x0310
        L_0x0245:
            java.lang.String r2 = "font-family"
            boolean r2 = r2.equals(r13)
            if (r2 == 0) goto L_0x0252
            r3.zzl(r6)
            goto L_0x0310
        L_0x0252:
            java.lang.String r2 = "font-weight"
            boolean r2 = r2.equals(r13)
            if (r2 == 0) goto L_0x0267
            java.lang.String r2 = "bold"
            boolean r2 = r2.equals(r6)
            if (r2 == 0) goto L_0x0310
            r3.zzi(r10)
            goto L_0x0310
        L_0x0267:
            java.lang.String r2 = "font-style"
            boolean r2 = r2.equals(r13)
            if (r2 == 0) goto L_0x027c
            java.lang.String r2 = "italic"
            boolean r2 = r2.equals(r6)
            if (r2 == 0) goto L_0x0310
            r3.zzo(r10)
            goto L_0x0310
        L_0x027c:
            java.lang.String r2 = "font-size"
            boolean r2 = r2.equals(r13)
            if (r2 == 0) goto L_0x0310
            java.util.regex.Pattern r2 = zzb
            java.lang.String r9 = com.google.android.gms.internal.ads.zzfwa.zza(r6)
            java.util.regex.Matcher r2 = r2.matcher(r9)
            boolean r9 = r2.matches()
            if (r9 != 0) goto L_0x02ad
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r7 = "Invalid font-size: '"
            r2.<init>(r7)
            r2.append(r6)
            java.lang.String r6 = "'."
            r2.append(r6)
            java.lang.String r2 = r2.toString()
            java.lang.String r6 = "WebvttCssParser"
            com.google.android.gms.internal.ads.zzdt.zzf(r6, r2)
            goto L_0x0310
        L_0x02ad:
            java.lang.String r6 = r2.group(r7)
            r6.getClass()
            r9 = r6
            java.lang.String r9 = (java.lang.String) r9
            int r9 = r6.hashCode()
            r11 = 37
            if (r9 == r11) goto L_0x02dc
            r11 = 3240(0xca8, float:4.54E-42)
            if (r9 == r11) goto L_0x02d2
            r11 = 3592(0xe08, float:5.033E-42)
            if (r9 == r11) goto L_0x02c8
            goto L_0x02e6
        L_0x02c8:
            java.lang.String r9 = "px"
            boolean r6 = r6.equals(r9)
            if (r6 == 0) goto L_0x02e6
            r6 = 0
            goto L_0x02e7
        L_0x02d2:
            java.lang.String r9 = "em"
            boolean r6 = r6.equals(r9)
            if (r6 == 0) goto L_0x02e6
            r6 = r10
            goto L_0x02e7
        L_0x02dc:
            java.lang.String r9 = "%"
            boolean r6 = r6.equals(r9)
            if (r6 == 0) goto L_0x02e6
            r6 = r7
            goto L_0x02e7
        L_0x02e6:
            r6 = -1
        L_0x02e7:
            if (r6 == 0) goto L_0x02fc
            if (r6 == r10) goto L_0x02f8
            if (r6 != r7) goto L_0x02f2
            r6 = 3
            r3.zzn(r6)
            goto L_0x02ff
        L_0x02f2:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            r1.<init>()
            throw r1
        L_0x02f8:
            r3.zzn(r7)
            goto L_0x02ff
        L_0x02fc:
            r3.zzn(r10)
        L_0x02ff:
            java.lang.String r2 = r2.group(r10)
            r2.getClass()
            r6 = r2
            java.lang.String r6 = (java.lang.String) r6
            float r2 = java.lang.Float.parseFloat(r2)
            r3.zzm(r2)
        L_0x0310:
            r2 = 0
            r6 = -1
            goto L_0x0130
        L_0x0314:
            boolean r2 = r7.equals(r5)
            if (r2 == 0) goto L_0x031d
            r1.add(r3)
        L_0x031d:
            r2 = 0
            goto L_0x0031
        L_0x0320:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzalp.zzb(com.google.android.gms.internal.ads.zzed):java.util.List");
    }
}
