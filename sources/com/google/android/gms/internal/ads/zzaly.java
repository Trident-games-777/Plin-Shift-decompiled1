package com.google.android.gms.internal.ads;

import android.graphics.Color;
import android.text.TextUtils;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzaly {
    public static final Pattern zza = Pattern.compile("^(\\S+)\\s+-->\\s+(\\S+)(.*)?$");
    private static final Pattern zzb = Pattern.compile("(\\S+?):(\\S+)");
    private static final Map zzc;
    private static final Map zzd;

    static {
        HashMap hashMap = new HashMap();
        hashMap.put("white", Integer.valueOf(Color.rgb(255, 255, 255)));
        hashMap.put("lime", Integer.valueOf(Color.rgb(0, 255, 0)));
        hashMap.put("cyan", Integer.valueOf(Color.rgb(0, 255, 255)));
        hashMap.put("red", Integer.valueOf(Color.rgb(255, 0, 0)));
        hashMap.put("yellow", Integer.valueOf(Color.rgb(255, 255, 0)));
        hashMap.put("magenta", Integer.valueOf(Color.rgb(255, 0, 255)));
        hashMap.put("blue", Integer.valueOf(Color.rgb(0, 0, 255)));
        hashMap.put("black", Integer.valueOf(Color.rgb(0, 0, 0)));
        zzc = Collections.unmodifiableMap(hashMap);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("bg_white", Integer.valueOf(Color.rgb(255, 255, 255)));
        hashMap2.put("bg_lime", Integer.valueOf(Color.rgb(0, 255, 0)));
        hashMap2.put("bg_cyan", Integer.valueOf(Color.rgb(0, 255, 255)));
        hashMap2.put("bg_red", Integer.valueOf(Color.rgb(255, 0, 0)));
        hashMap2.put("bg_yellow", Integer.valueOf(Color.rgb(255, 255, 0)));
        hashMap2.put("bg_magenta", Integer.valueOf(Color.rgb(255, 0, 255)));
        hashMap2.put("bg_blue", Integer.valueOf(Color.rgb(0, 0, 255)));
        hashMap2.put("bg_black", Integer.valueOf(Color.rgb(0, 0, 0)));
        zzd = Collections.unmodifiableMap(hashMap2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:111:0x01d2  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x01ff  */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x0204  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0130  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static android.text.SpannedString zza(java.lang.String r18, java.lang.String r19, java.util.List r20) {
        /*
            r0 = r18
            r1 = r19
            r2 = r20
            android.text.SpannableStringBuilder r3 = new android.text.SpannableStringBuilder
            r3.<init>()
            java.util.ArrayDeque r4 = new java.util.ArrayDeque
            r4.<init>()
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            r7 = 0
        L_0x0016:
            int r8 = r1.length()
            if (r7 < r8) goto L_0x003c
        L_0x001c:
            boolean r1 = r4.isEmpty()
            if (r1 != 0) goto L_0x002c
            java.lang.Object r1 = r4.pop()
            com.google.android.gms.internal.ads.zzalu r1 = (com.google.android.gms.internal.ads.zzalu) r1
            zzg(r0, r1, r5, r3, r2)
            goto L_0x001c
        L_0x002c:
            com.google.android.gms.internal.ads.zzalu r1 = com.google.android.gms.internal.ads.zzalu.zzb()
            java.util.List r4 = java.util.Collections.emptyList()
            zzg(r0, r1, r4, r3, r2)
            android.text.SpannedString r0 = android.text.SpannedString.valueOf(r3)
            return r0
        L_0x003c:
            int r8 = r7 + 1
            char r9 = r1.charAt(r7)
            r10 = 62
            r11 = 60
            r12 = 38
            r14 = 2
            r15 = -1
            r16 = 0
            r6 = 1
            if (r9 == r12) goto L_0x0173
            if (r9 == r11) goto L_0x0056
            r3.append(r9)
            goto L_0x0210
        L_0x0056:
            int r9 = r1.length()
            if (r8 < r9) goto L_0x005e
            goto L_0x0210
        L_0x005e:
            char r9 = r1.charAt(r8)
            int r8 = r1.indexOf(r10, r8)
            if (r8 != r15) goto L_0x006d
            int r8 = r1.length()
            goto L_0x006f
        L_0x006d:
            int r8 = r8 + 1
        L_0x006f:
            int r10 = r8 + -2
            char r11 = r1.charAt(r10)
            r12 = 47
            if (r11 != r12) goto L_0x007b
            r11 = r6
            goto L_0x007d
        L_0x007b:
            r11 = r16
        L_0x007d:
            if (r9 != r12) goto L_0x0082
            r17 = r14
            goto L_0x0084
        L_0x0082:
            r17 = r6
        L_0x0084:
            int r7 = r7 + r17
            if (r11 == 0) goto L_0x0089
            goto L_0x008b
        L_0x0089:
            int r10 = r8 + -1
        L_0x008b:
            java.lang.String r7 = r1.substring(r7, r10)
            java.lang.String r10 = r7.trim()
            boolean r10 = r10.isEmpty()
            if (r10 == 0) goto L_0x009b
            goto L_0x0210
        L_0x009b:
            java.lang.String r10 = r7.trim()
            boolean r17 = r10.isEmpty()
            r17 = r17 ^ 1
            com.google.android.gms.internal.ads.zzdb.zzd(r17)
            int r17 = com.google.android.gms.internal.ads.zzen.zza
            java.lang.String r13 = "[ \\.]"
            java.lang.String[] r10 = r10.split(r13, r14)
            r10 = r10[r16]
            int r13 = r10.hashCode()
            r14 = 98
            if (r13 == r14) goto L_0x011f
            r14 = 99
            if (r13 == r14) goto L_0x0115
            r6 = 105(0x69, float:1.47E-43)
            if (r13 == r6) goto L_0x010b
            r6 = 3650(0xe42, float:5.115E-42)
            if (r13 == r6) goto L_0x0101
            r6 = 3314158(0x3291ee, float:4.644125E-39)
            if (r13 == r6) goto L_0x00f7
            r6 = 3511770(0x3595da, float:4.921038E-39)
            if (r13 == r6) goto L_0x00ed
            r6 = 117(0x75, float:1.64E-43)
            if (r13 == r6) goto L_0x00e3
            r6 = 118(0x76, float:1.65E-43)
            if (r13 == r6) goto L_0x00d9
            goto L_0x012a
        L_0x00d9:
            java.lang.String r6 = "v"
            boolean r6 = r10.equals(r6)
            if (r6 == 0) goto L_0x012a
            r13 = 7
            goto L_0x012b
        L_0x00e3:
            java.lang.String r6 = "u"
            boolean r6 = r10.equals(r6)
            if (r6 == 0) goto L_0x012a
            r13 = 6
            goto L_0x012b
        L_0x00ed:
            java.lang.String r6 = "ruby"
            boolean r6 = r10.equals(r6)
            if (r6 == 0) goto L_0x012a
            r13 = 4
            goto L_0x012b
        L_0x00f7:
            java.lang.String r6 = "lang"
            boolean r6 = r10.equals(r6)
            if (r6 == 0) goto L_0x012a
            r13 = 3
            goto L_0x012b
        L_0x0101:
            java.lang.String r6 = "rt"
            boolean r6 = r10.equals(r6)
            if (r6 == 0) goto L_0x012a
            r13 = 5
            goto L_0x012b
        L_0x010b:
            java.lang.String r6 = "i"
            boolean r6 = r10.equals(r6)
            if (r6 == 0) goto L_0x012a
            r13 = 2
            goto L_0x012b
        L_0x0115:
            java.lang.String r13 = "c"
            boolean r13 = r10.equals(r13)
            if (r13 == 0) goto L_0x012a
            r13 = r6
            goto L_0x012b
        L_0x011f:
            java.lang.String r6 = "b"
            boolean r6 = r10.equals(r6)
            if (r6 == 0) goto L_0x012a
            r13 = r16
            goto L_0x012b
        L_0x012a:
            r13 = r15
        L_0x012b:
            switch(r13) {
                case 0: goto L_0x0130;
                case 1: goto L_0x0130;
                case 2: goto L_0x0130;
                case 3: goto L_0x0130;
                case 4: goto L_0x0130;
                case 5: goto L_0x0130;
                case 6: goto L_0x0130;
                case 7: goto L_0x0130;
                default: goto L_0x012e;
            }
        L_0x012e:
            goto L_0x0210
        L_0x0130:
            if (r9 != r12) goto L_0x0164
        L_0x0132:
            boolean r6 = r4.isEmpty()
            if (r6 == 0) goto L_0x013a
            goto L_0x0210
        L_0x013a:
            java.lang.Object r6 = r4.pop()
            com.google.android.gms.internal.ads.zzalu r6 = (com.google.android.gms.internal.ads.zzalu) r6
            zzg(r0, r6, r5, r3, r2)
            boolean r7 = r4.isEmpty()
            if (r7 != 0) goto L_0x0157
            com.google.android.gms.internal.ads.zzalt r7 = new com.google.android.gms.internal.ads.zzalt
            int r9 = r3.length()
            r11 = 0
            r7.<init>(r6, r9, r11)
            r5.add(r7)
            goto L_0x015a
        L_0x0157:
            r5.clear()
        L_0x015a:
            java.lang.String r6 = r6.zza
            boolean r6 = r6.equals(r10)
            if (r6 == 0) goto L_0x0132
            goto L_0x0210
        L_0x0164:
            if (r11 != 0) goto L_0x0210
            int r6 = r3.length()
            com.google.android.gms.internal.ads.zzalu r6 = com.google.android.gms.internal.ads.zzalu.zza(r7, r6)
            r4.push(r6)
            goto L_0x0210
        L_0x0173:
            r7 = 59
            int r7 = r1.indexOf(r7, r8)
            r13 = 32
            int r14 = r1.indexOf(r13, r8)
            if (r7 != r15) goto L_0x0183
            r7 = r14
            goto L_0x0189
        L_0x0183:
            if (r14 == r15) goto L_0x0189
            int r7 = java.lang.Math.min(r7, r14)
        L_0x0189:
            if (r7 == r15) goto L_0x020d
            java.lang.String r8 = r1.substring(r8, r7)
            int r9 = r8.hashCode()
            r15 = 3309(0xced, float:4.637E-42)
            if (r9 == r15) goto L_0x01c5
            r15 = 3464(0xd88, float:4.854E-42)
            if (r9 == r15) goto L_0x01ba
            r15 = 96708(0x179c4, float:1.35517E-40)
            if (r9 == r15) goto L_0x01b0
            r15 = 3374865(0x337f11, float:4.729193E-39)
            if (r9 == r15) goto L_0x01a6
            goto L_0x01cf
        L_0x01a6:
            java.lang.String r9 = "nbsp"
            boolean r9 = r8.equals(r9)
            if (r9 == 0) goto L_0x01cf
            r15 = 2
            goto L_0x01d0
        L_0x01b0:
            java.lang.String r9 = "amp"
            boolean r9 = r8.equals(r9)
            if (r9 == 0) goto L_0x01cf
            r15 = 3
            goto L_0x01d0
        L_0x01ba:
            java.lang.String r9 = "lt"
            boolean r9 = r8.equals(r9)
            if (r9 == 0) goto L_0x01cf
            r15 = r16
            goto L_0x01d0
        L_0x01c5:
            java.lang.String r9 = "gt"
            boolean r9 = r8.equals(r9)
            if (r9 == 0) goto L_0x01cf
            r15 = r6
            goto L_0x01d0
        L_0x01cf:
            r15 = -1
        L_0x01d0:
            if (r15 == 0) goto L_0x01ff
            if (r15 == r6) goto L_0x01fb
            r6 = 2
            if (r15 == r6) goto L_0x01f7
            r6 = 3
            if (r15 == r6) goto L_0x01f3
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r9 = "ignoring unsupported entity: '&"
            r6.<init>(r9)
            r6.append(r8)
            java.lang.String r8 = ";'"
            r6.append(r8)
            java.lang.String r6 = r6.toString()
            java.lang.String r8 = "WebvttCueParser"
            com.google.android.gms.internal.ads.zzdt.zzf(r8, r6)
            goto L_0x0202
        L_0x01f3:
            r3.append(r12)
            goto L_0x0202
        L_0x01f7:
            r3.append(r13)
            goto L_0x0202
        L_0x01fb:
            r3.append(r10)
            goto L_0x0202
        L_0x01ff:
            r3.append(r11)
        L_0x0202:
            if (r7 != r14) goto L_0x0209
            java.lang.String r6 = " "
            r3.append(r6)
        L_0x0209:
            int r7 = r7 + 1
            goto L_0x0016
        L_0x020d:
            r3.append(r9)
        L_0x0210:
            r7 = r8
            goto L_0x0016
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaly.zza(java.lang.String, java.lang.String, java.util.List):android.text.SpannedString");
    }

    static zzcr zzb(String str) {
        zzalw zzalw = new zzalw();
        zzh(str, zzalw);
        return zzalw.zza();
    }

    public static zzalr zzc(zzed zzed, List list) {
        String zzz = zzed.zzz(StandardCharsets.UTF_8);
        if (zzz != null) {
            Pattern pattern = zza;
            Matcher matcher = pattern.matcher(zzz);
            if (matcher.matches()) {
                return zze((String) null, matcher, zzed, list);
            }
            String zzz2 = zzed.zzz(StandardCharsets.UTF_8);
            if (zzz2 != null) {
                Matcher matcher2 = pattern.matcher(zzz2);
                if (matcher2.matches()) {
                    return zze(zzz.trim(), matcher2, zzed, list);
                }
            }
        }
        return null;
    }

    private static int zzd(List list, String str, zzalu zzalu) {
        List zzf = zzf(list, str, zzalu);
        for (int i = 0; i < zzf.size(); i++) {
            zzalq zzalq = ((zzalv) zzf.get(i)).zzb;
            if (zzalq.zze() != -1) {
                return zzalq.zze();
            }
        }
        return -1;
    }

    private static zzalr zze(String str, Matcher matcher, zzed zzed, List list) {
        zzalw zzalw = new zzalw();
        try {
            String group = matcher.group(1);
            if (group != null) {
                String str2 = group;
                zzalw.zza = zzama.zzb(group);
                String group2 = matcher.group(2);
                if (group2 != null) {
                    String str3 = group2;
                    zzalw.zzb = zzama.zzb(group2);
                    String group3 = matcher.group(3);
                    group3.getClass();
                    String str4 = group3;
                    zzh(group3, zzalw);
                    StringBuilder sb = new StringBuilder();
                    String zzz = zzed.zzz(StandardCharsets.UTF_8);
                    while (!TextUtils.isEmpty(zzz)) {
                        if (sb.length() > 0) {
                            sb.append("\n");
                        }
                        sb.append(zzz.trim());
                        zzz = zzed.zzz(StandardCharsets.UTF_8);
                    }
                    zzalw.zzc = zza(str, sb.toString(), list);
                    return new zzalr(zzalw.zza().zzp(), zzalw.zza, zzalw.zzb);
                }
                throw null;
            }
            throw null;
        } catch (NumberFormatException unused) {
            zzdt.zzf("WebvttCueParser", "Skipping cue with bad header: ".concat(String.valueOf(matcher.group())));
            return null;
        }
    }

    private static List zzf(List list, String str, zzalu zzalu) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            zzalq zzalq = (zzalq) list.get(i);
            int zzf = zzalq.zzf(str, zzalu.zza, zzalu.zzd, zzalu.zzc);
            if (zzf > 0) {
                arrayList.add(new zzalv(zzf, zzalq));
            }
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    /* JADX WARNING: Removed duplicated region for block: B:114:? A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00e3  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00ed  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0167  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0170  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0184  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void zzg(java.lang.String r18, com.google.android.gms.internal.ads.zzalu r19, java.util.List r20, android.text.SpannableStringBuilder r21, java.util.List r22) {
        /*
            r0 = r18
            r1 = r19
            r2 = r21
            r3 = r22
            int r4 = r1.zzb
            int r5 = r2.length()
            java.lang.String r6 = r1.zza
            int r7 = r6.hashCode()
            r9 = 2
            r11 = -1
            if (r7 == 0) goto L_0x007d
            r13 = 105(0x69, float:1.47E-43)
            if (r7 == r13) goto L_0x0073
            r13 = 3314158(0x3291ee, float:4.644125E-39)
            if (r7 == r13) goto L_0x0069
            r13 = 3511770(0x3595da, float:4.921038E-39)
            if (r7 == r13) goto L_0x005f
            r13 = 98
            if (r7 == r13) goto L_0x0055
            r13 = 99
            if (r7 == r13) goto L_0x004b
            r13 = 117(0x75, float:1.64E-43)
            if (r7 == r13) goto L_0x0041
            r13 = 118(0x76, float:1.65E-43)
            if (r7 == r13) goto L_0x0037
            goto L_0x0087
        L_0x0037:
            java.lang.String r7 = "v"
            boolean r6 = r6.equals(r7)
            if (r6 == 0) goto L_0x0087
            r6 = 5
            goto L_0x0088
        L_0x0041:
            java.lang.String r7 = "u"
            boolean r6 = r6.equals(r7)
            if (r6 == 0) goto L_0x0087
            r6 = 3
            goto L_0x0088
        L_0x004b:
            java.lang.String r7 = "c"
            boolean r6 = r6.equals(r7)
            if (r6 == 0) goto L_0x0087
            r6 = 4
            goto L_0x0088
        L_0x0055:
            java.lang.String r7 = "b"
            boolean r6 = r6.equals(r7)
            if (r6 == 0) goto L_0x0087
            r6 = 0
            goto L_0x0088
        L_0x005f:
            java.lang.String r7 = "ruby"
            boolean r6 = r6.equals(r7)
            if (r6 == 0) goto L_0x0087
            r6 = r9
            goto L_0x0088
        L_0x0069:
            java.lang.String r7 = "lang"
            boolean r6 = r6.equals(r7)
            if (r6 == 0) goto L_0x0087
            r6 = 6
            goto L_0x0088
        L_0x0073:
            java.lang.String r7 = "i"
            boolean r6 = r6.equals(r7)
            if (r6 == 0) goto L_0x0087
            r6 = 1
            goto L_0x0088
        L_0x007d:
            java.lang.String r7 = ""
            boolean r6 = r6.equals(r7)
            if (r6 == 0) goto L_0x0087
            r6 = 7
            goto L_0x0088
        L_0x0087:
            r6 = r11
        L_0x0088:
            r7 = 33
            switch(r6) {
                case 0: goto L_0x0170;
                case 1: goto L_0x0167;
                case 2: goto L_0x00ed;
                case 3: goto L_0x00e3;
                case 4: goto L_0x009b;
                case 5: goto L_0x008f;
                case 6: goto L_0x0179;
                case 7: goto L_0x0179;
                default: goto L_0x008d;
            }
        L_0x008d:
            goto L_0x0237
        L_0x008f:
            java.lang.String r6 = r1.zzc
            com.google.android.gms.internal.ads.zzda r13 = new com.google.android.gms.internal.ads.zzda
            r13.<init>(r6)
            r2.setSpan(r13, r4, r5, r7)
            goto L_0x0179
        L_0x009b:
            java.util.Set r6 = r1.zzd
            java.util.Iterator r6 = r6.iterator()
        L_0x00a1:
            boolean r13 = r6.hasNext()
            if (r13 == 0) goto L_0x0179
            java.lang.Object r13 = r6.next()
            java.lang.String r13 = (java.lang.String) r13
            java.util.Map r14 = zzc
            boolean r15 = r14.containsKey(r13)
            if (r15 == 0) goto L_0x00c8
            java.lang.Object r13 = r14.get(r13)
            java.lang.Integer r13 = (java.lang.Integer) r13
            int r13 = r13.intValue()
            android.text.style.ForegroundColorSpan r14 = new android.text.style.ForegroundColorSpan
            r14.<init>(r13)
            r2.setSpan(r14, r4, r5, r7)
            goto L_0x00a1
        L_0x00c8:
            java.util.Map r14 = zzd
            boolean r15 = r14.containsKey(r13)
            if (r15 == 0) goto L_0x00a1
            java.lang.Object r13 = r14.get(r13)
            java.lang.Integer r13 = (java.lang.Integer) r13
            int r13 = r13.intValue()
            android.text.style.BackgroundColorSpan r14 = new android.text.style.BackgroundColorSpan
            r14.<init>(r13)
            r2.setSpan(r14, r4, r5, r7)
            goto L_0x00a1
        L_0x00e3:
            android.text.style.UnderlineSpan r6 = new android.text.style.UnderlineSpan
            r6.<init>()
            r2.setSpan(r6, r4, r5, r7)
            goto L_0x0179
        L_0x00ed:
            int r6 = zzd(r3, r0, r1)
            java.util.ArrayList r13 = new java.util.ArrayList
            int r14 = r20.size()
            r13.<init>(r14)
            r14 = r20
            r13.addAll(r14)
            java.util.Comparator r14 = com.google.android.gms.internal.ads.zzalt.zza
            java.util.Collections.sort(r13, r14)
            int r14 = r1.zzb
            r15 = 0
            r16 = 0
        L_0x010b:
            int r10 = r13.size()
            if (r15 >= r10) goto L_0x0179
            java.lang.Object r10 = r13.get(r15)
            com.google.android.gms.internal.ads.zzalt r10 = (com.google.android.gms.internal.ads.zzalt) r10
            com.google.android.gms.internal.ads.zzalu r10 = r10.zzb
            java.lang.String r10 = r10.zza
            java.lang.String r8 = "rt"
            boolean r8 = r8.equals(r10)
            if (r8 == 0) goto L_0x0163
            java.lang.Object r8 = r13.get(r15)
            com.google.android.gms.internal.ads.zzalt r8 = (com.google.android.gms.internal.ads.zzalt) r8
            com.google.android.gms.internal.ads.zzalu r10 = r8.zzb
            int r10 = zzd(r3, r0, r10)
            if (r10 == r11) goto L_0x0136
            goto L_0x013b
        L_0x0136:
            if (r6 == r11) goto L_0x013a
            r10 = r6
            goto L_0x013b
        L_0x013a:
            r10 = 1
        L_0x013b:
            com.google.android.gms.internal.ads.zzalu r11 = r8.zzb
            int r11 = r11.zzb
            int r11 = r11 - r16
            int r8 = r8.zzc
            int r8 = r8 - r16
            java.lang.CharSequence r17 = r2.subSequence(r11, r8)
            r2.delete(r11, r8)
            com.google.android.gms.internal.ads.zzcx r8 = new com.google.android.gms.internal.ads.zzcx
            java.lang.String r12 = r17.toString()
            r8.<init>(r12, r10)
            r2.setSpan(r8, r14, r11, r7)
            int r8 = r17.length()
            int r16 = r16 + r8
            r14 = r11
        L_0x0163:
            int r15 = r15 + 1
            r11 = -1
            goto L_0x010b
        L_0x0167:
            android.text.style.StyleSpan r6 = new android.text.style.StyleSpan
            r6.<init>(r9)
            r2.setSpan(r6, r4, r5, r7)
            goto L_0x0179
        L_0x0170:
            android.text.style.StyleSpan r6 = new android.text.style.StyleSpan
            r8 = 1
            r6.<init>(r8)
            r2.setSpan(r6, r4, r5, r7)
        L_0x0179:
            java.util.List r0 = zzf(r3, r0, r1)
            r10 = 0
        L_0x017e:
            int r1 = r0.size()
            if (r10 >= r1) goto L_0x0237
            java.lang.Object r1 = r0.get(r10)
            com.google.android.gms.internal.ads.zzalv r1 = (com.google.android.gms.internal.ads.zzalv) r1
            com.google.android.gms.internal.ads.zzalq r1 = r1.zzb
            if (r1 != 0) goto L_0x0193
            r6 = -1
            r8 = 3
            r12 = 1
            goto L_0x0233
        L_0x0193:
            int r3 = r1.zzg()
            r6 = -1
            if (r3 == r6) goto L_0x01a6
            android.text.style.StyleSpan r3 = new android.text.style.StyleSpan
            int r8 = r1.zzg()
            r3.<init>(r8)
            com.google.android.gms.internal.ads.zzcy.zzb(r2, r3, r4, r5, r7)
        L_0x01a6:
            boolean r3 = r1.zzz()
            if (r3 == 0) goto L_0x01b4
            android.text.style.UnderlineSpan r3 = new android.text.style.UnderlineSpan
            r3.<init>()
            r2.setSpan(r3, r4, r5, r7)
        L_0x01b4:
            boolean r3 = r1.zzy()
            if (r3 == 0) goto L_0x01c6
            android.text.style.ForegroundColorSpan r3 = new android.text.style.ForegroundColorSpan
            int r8 = r1.zzc()
            r3.<init>(r8)
            com.google.android.gms.internal.ads.zzcy.zzb(r2, r3, r4, r5, r7)
        L_0x01c6:
            boolean r3 = r1.zzx()
            if (r3 == 0) goto L_0x01d8
            android.text.style.BackgroundColorSpan r3 = new android.text.style.BackgroundColorSpan
            int r8 = r1.zzb()
            r3.<init>(r8)
            com.google.android.gms.internal.ads.zzcy.zzb(r2, r3, r4, r5, r7)
        L_0x01d8:
            java.lang.String r3 = r1.zzr()
            if (r3 == 0) goto L_0x01ea
            android.text.style.TypefaceSpan r3 = new android.text.style.TypefaceSpan
            java.lang.String r8 = r1.zzr()
            r3.<init>(r8)
            com.google.android.gms.internal.ads.zzcy.zzb(r2, r3, r4, r5, r7)
        L_0x01ea:
            int r3 = r1.zzd()
            r8 = 1
            if (r3 == r8) goto L_0x0216
            if (r3 == r9) goto L_0x0208
            r8 = 3
            if (r3 == r8) goto L_0x01f8
        L_0x01f6:
            r12 = 1
            goto L_0x0225
        L_0x01f8:
            android.text.style.RelativeSizeSpan r3 = new android.text.style.RelativeSizeSpan
            float r11 = r1.zza()
            r12 = 1120403456(0x42c80000, float:100.0)
            float r11 = r11 / r12
            r3.<init>(r11)
            com.google.android.gms.internal.ads.zzcy.zzb(r2, r3, r4, r5, r7)
            goto L_0x01f6
        L_0x0208:
            r8 = 3
            android.text.style.RelativeSizeSpan r3 = new android.text.style.RelativeSizeSpan
            float r11 = r1.zza()
            r3.<init>(r11)
            com.google.android.gms.internal.ads.zzcy.zzb(r2, r3, r4, r5, r7)
            goto L_0x01f6
        L_0x0216:
            r8 = 3
            android.text.style.AbsoluteSizeSpan r3 = new android.text.style.AbsoluteSizeSpan
            float r11 = r1.zza()
            int r11 = (int) r11
            r12 = 1
            r3.<init>(r11, r12)
            com.google.android.gms.internal.ads.zzcy.zzb(r2, r3, r4, r5, r7)
        L_0x0225:
            boolean r1 = r1.zzw()
            if (r1 == 0) goto L_0x0233
            com.google.android.gms.internal.ads.zzcw r1 = new com.google.android.gms.internal.ads.zzcw
            r1.<init>()
            r2.setSpan(r1, r4, r5, r7)
        L_0x0233:
            int r10 = r10 + 1
            goto L_0x017e
        L_0x0237:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaly.zzg(java.lang.String, com.google.android.gms.internal.ads.zzalu, java.util.List, android.text.SpannableStringBuilder, java.util.List):void");
    }

    private static void zzh(String str, zzalw zzalw) {
        zzalw zzalw2 = zzalw;
        Matcher matcher = zzb.matcher(str);
        while (matcher.find()) {
            int i = 1;
            String group = matcher.group(1);
            group.getClass();
            String str2 = group;
            int i2 = 2;
            String group2 = matcher.group(2);
            group2.getClass();
            String str3 = group2;
            try {
                char c = 65535;
                if ("line".equals(group)) {
                    int indexOf = group2.indexOf(44);
                    if (indexOf != -1) {
                        String substring = group2.substring(indexOf + 1);
                        switch (substring.hashCode()) {
                            case -1364013995:
                                if (substring.equals("center")) {
                                    c = 1;
                                    break;
                                }
                                break;
                            case -1074341483:
                                if (substring.equals("middle")) {
                                    c = 2;
                                    break;
                                }
                                break;
                            case 100571:
                                if (substring.equals("end")) {
                                    c = 3;
                                    break;
                                }
                                break;
                            case 109757538:
                                if (substring.equals("start")) {
                                    c = 0;
                                    break;
                                }
                                break;
                        }
                        if (c == 0) {
                            i2 = 0;
                        } else if (c == 1 || c == 2) {
                            i2 = 1;
                        } else if (c != 3) {
                            zzdt.zzf("WebvttCueParser", "Invalid anchor value: ".concat(String.valueOf(substring)));
                            i2 = Integer.MIN_VALUE;
                        }
                        zzalw2.zzg = i2;
                        group2 = group2.substring(0, indexOf);
                    }
                    if (group2.endsWith("%")) {
                        zzalw2.zze = zzama.zza(group2);
                        zzalw2.zzf = 0;
                    } else {
                        zzalw2.zze = (float) Integer.parseInt(group2);
                        zzalw2.zzf = 1;
                    }
                } else if ("align".equals(group)) {
                    switch (group2.hashCode()) {
                        case -1364013995:
                            if (group2.equals("center")) {
                                c = 2;
                                break;
                            }
                            break;
                        case -1074341483:
                            if (group2.equals("middle")) {
                                c = 3;
                                break;
                            }
                            break;
                        case 100571:
                            if (group2.equals("end")) {
                                c = 4;
                                break;
                            }
                            break;
                        case 3317767:
                            if (group2.equals("left")) {
                                c = 1;
                                break;
                            }
                            break;
                        case 108511772:
                            if (group2.equals("right")) {
                                c = 5;
                                break;
                            }
                            break;
                        case 109757538:
                            if (group2.equals("start")) {
                                c = 0;
                                break;
                            }
                            break;
                    }
                    if (c != 0) {
                        if (c != 1) {
                            if (!(c == 2 || c == 3)) {
                                if (c != 4) {
                                    i = 5;
                                    if (c != 5) {
                                        zzdt.zzf("WebvttCueParser", "Invalid alignment value: ".concat(group2));
                                    }
                                } else {
                                    i = 3;
                                }
                            }
                            i = 2;
                        } else {
                            i = 4;
                        }
                    }
                    zzalw2.zzd = i;
                } else if ("position".equals(group)) {
                    int indexOf2 = group2.indexOf(44);
                    if (indexOf2 != -1) {
                        String substring2 = group2.substring(indexOf2 + 1);
                        switch (substring2.hashCode()) {
                            case -1842484672:
                                if (substring2.equals("line-left")) {
                                    c = 0;
                                    break;
                                }
                                break;
                            case -1364013995:
                                if (substring2.equals("center")) {
                                    c = 2;
                                    break;
                                }
                                break;
                            case -1276788989:
                                if (substring2.equals("line-right")) {
                                    c = 4;
                                    break;
                                }
                                break;
                            case -1074341483:
                                if (substring2.equals("middle")) {
                                    c = 3;
                                    break;
                                }
                                break;
                            case 100571:
                                if (substring2.equals("end")) {
                                    c = 5;
                                    break;
                                }
                                break;
                            case 109757538:
                                if (substring2.equals("start")) {
                                    c = 1;
                                    break;
                                }
                                break;
                        }
                        if (c == 0 || c == 1) {
                            i = 0;
                        } else if (!(c == 2 || c == 3)) {
                            if (c == 4 || c == 5) {
                                i = 2;
                            } else {
                                zzdt.zzf("WebvttCueParser", "Invalid anchor value: ".concat(String.valueOf(substring2)));
                                i = Integer.MIN_VALUE;
                            }
                        }
                        zzalw2.zzi = i;
                        group2 = group2.substring(0, indexOf2);
                    }
                    zzalw2.zzh = zzama.zza(group2);
                } else if ("size".equals(group)) {
                    zzalw2.zzj = zzama.zza(group2);
                } else if (!"vertical".equals(group)) {
                    zzdt.zzf("WebvttCueParser", "Unknown cue setting " + group + ":" + group2);
                } else {
                    int hashCode = group2.hashCode();
                    if (hashCode != 3462) {
                        if (hashCode == 3642 && group2.equals("rl")) {
                            c = 0;
                        }
                    } else if (group2.equals("lr")) {
                        c = 1;
                    }
                    if (c != 0) {
                        if (c != 1) {
                            zzdt.zzf("WebvttCueParser", "Invalid 'vertical' value: ".concat(group2));
                            i = Integer.MIN_VALUE;
                        } else {
                            i = 2;
                        }
                    }
                    zzalw2.zzk = i;
                }
            } catch (NumberFormatException unused) {
                zzdt.zzf("WebvttCueParser", "Skipping bad cue setting: ".concat(String.valueOf(matcher.group())));
            }
        }
    }
}
