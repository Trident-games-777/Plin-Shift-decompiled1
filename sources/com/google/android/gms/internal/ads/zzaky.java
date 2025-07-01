package com.google.android.gms.internal.ads;

import androidx.compose.animation.core.AnimationKt;
import androidx.work.WorkRequest;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzaky implements zzaki {
    private static final Pattern zza = Pattern.compile("(?:(\\d+):)?(\\d+):(\\d+)[:.](\\d+)");
    private final boolean zzb;
    private final zzakx zzc;
    private final zzed zzd;
    private Map zze;
    private float zzf;
    private float zzg;

    public zzaky() {
        this((List) null);
    }

    private static float zzb(int i) {
        if (i == 0) {
            return 0.05f;
        }
        if (i != 1) {
            return i != 2 ? -3.4028235E38f : 0.95f;
        }
        return 0.5f;
    }

    private static int zzc(long j, List list, List list2) {
        int i;
        int size = list.size();
        while (true) {
            size--;
            if (size >= 0) {
                if (((Long) list.get(size)).longValue() != j) {
                    if (((Long) list.get(size)).longValue() < j) {
                        i = size + 1;
                        break;
                    }
                } else {
                    return size;
                }
            } else {
                i = 0;
                break;
            }
        }
        list.add(i, Long.valueOf(j));
        list2.add(i, i == 0 ? new ArrayList() : new ArrayList((Collection) list2.get(i - 1)));
        return i;
    }

    private static long zzd(String str) {
        Matcher matcher = zza.matcher(str.trim());
        if (!matcher.matches()) {
            return -9223372036854775807L;
        }
        String group = matcher.group(1);
        int i = zzen.zza;
        String str2 = group;
        String group2 = matcher.group(2);
        String str3 = group2;
        String group3 = matcher.group(3);
        String str4 = group3;
        long parseLong = Long.parseLong(group3) * AnimationKt.MillisToNanos;
        String group4 = matcher.group(4);
        String str5 = group4;
        return (Long.parseLong(group) * 3600000000L) + (Long.parseLong(group2) * 60000000) + parseLong + (Long.parseLong(group4) * WorkRequest.MIN_BACKOFF_MILLIS);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0050, code lost:
        if (r3.equals("playresx") != false) goto L_0x0054;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zze(com.google.android.gms.internal.ads.zzed r7, java.nio.charset.Charset r8) {
        /*
            r6 = this;
        L_0x0000:
            java.lang.String r0 = r7.zzz(r8)
            if (r0 == 0) goto L_0x00dd
            java.lang.String r1 = "[Script Info]"
            boolean r1 = r1.equalsIgnoreCase(r0)
            r2 = 91
            if (r1 == 0) goto L_0x0073
        L_0x0010:
            java.lang.String r0 = r7.zzz(r8)
            if (r0 == 0) goto L_0x0000
            int r1 = r7.zzb()
            if (r1 == 0) goto L_0x0022
            char r1 = r7.zza(r8)
            if (r1 == r2) goto L_0x0000
        L_0x0022:
            java.lang.String r1 = ":"
            java.lang.String[] r0 = r0.split(r1)
            int r1 = r0.length
            r3 = 2
            if (r1 != r3) goto L_0x0010
            r1 = 0
            r3 = r0[r1]
            java.lang.String r3 = r3.trim()
            java.lang.String r3 = com.google.android.gms.internal.ads.zzfwa.zza(r3)
            int r4 = r3.hashCode()
            r5 = 1
            switch(r4) {
                case 1879649548: goto L_0x004a;
                case 1879649549: goto L_0x0040;
                default: goto L_0x003f;
            }
        L_0x003f:
            goto L_0x0053
        L_0x0040:
            java.lang.String r1 = "playresy"
            boolean r1 = r3.equals(r1)
            if (r1 == 0) goto L_0x0053
            r1 = r5
            goto L_0x0054
        L_0x004a:
            java.lang.String r4 = "playresx"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0053
            goto L_0x0054
        L_0x0053:
            r1 = -1
        L_0x0054:
            if (r1 == 0) goto L_0x0066
            if (r1 == r5) goto L_0x0059
            goto L_0x0010
        L_0x0059:
            r0 = r0[r5]     // Catch:{ NumberFormatException -> 0x0010 }
            java.lang.String r0 = r0.trim()     // Catch:{ NumberFormatException -> 0x0010 }
            float r0 = java.lang.Float.parseFloat(r0)     // Catch:{ NumberFormatException -> 0x0010 }
            r6.zzg = r0     // Catch:{ NumberFormatException -> 0x0010 }
            goto L_0x0010
        L_0x0066:
            r0 = r0[r5]     // Catch:{ NumberFormatException -> 0x0010 }
            java.lang.String r0 = r0.trim()     // Catch:{ NumberFormatException -> 0x0010 }
            float r0 = java.lang.Float.parseFloat(r0)     // Catch:{ NumberFormatException -> 0x0010 }
            r6.zzf = r0     // Catch:{ NumberFormatException -> 0x0010 }
            goto L_0x0010
        L_0x0073:
            java.lang.String r1 = "[V4+ Styles]"
            boolean r1 = r1.equalsIgnoreCase(r0)
            java.lang.String r3 = "SsaParser"
            if (r1 == 0) goto L_0x00c6
            java.util.LinkedHashMap r0 = new java.util.LinkedHashMap
            r0.<init>()
            r1 = 0
        L_0x0083:
            java.lang.String r4 = r7.zzz(r8)
            if (r4 == 0) goto L_0x00c2
            int r5 = r7.zzb()
            if (r5 == 0) goto L_0x0095
            char r5 = r7.zza(r8)
            if (r5 == r2) goto L_0x00c2
        L_0x0095:
            java.lang.String r5 = "Format:"
            boolean r5 = r4.startsWith(r5)
            if (r5 == 0) goto L_0x00a2
            com.google.android.gms.internal.ads.zzakz r1 = com.google.android.gms.internal.ads.zzakz.zza(r4)
            goto L_0x0083
        L_0x00a2:
            java.lang.String r5 = "Style:"
            boolean r5 = r4.startsWith(r5)
            if (r5 == 0) goto L_0x0083
            if (r1 != 0) goto L_0x00b6
            java.lang.String r5 = "Skipping 'Style:' line before 'Format:' line: "
            java.lang.String r4 = r5.concat(r4)
            com.google.android.gms.internal.ads.zzdt.zzf(r3, r4)
            goto L_0x0083
        L_0x00b6:
            com.google.android.gms.internal.ads.zzalb r4 = com.google.android.gms.internal.ads.zzalb.zzb(r4, r1)
            if (r4 == 0) goto L_0x0083
            java.lang.String r5 = r4.zza
            r0.put(r5, r4)
            goto L_0x0083
        L_0x00c2:
            r6.zze = r0
            goto L_0x0000
        L_0x00c6:
            java.lang.String r1 = "[V4 Styles]"
            boolean r1 = r1.equalsIgnoreCase(r0)
            if (r1 == 0) goto L_0x00d5
            java.lang.String r0 = "[V4 Styles] are not supported"
            com.google.android.gms.internal.ads.zzdt.zze(r3, r0)
            goto L_0x0000
        L_0x00d5:
            java.lang.String r1 = "[Events]"
            boolean r0 = r1.equalsIgnoreCase(r0)
            if (r0 == 0) goto L_0x0000
        L_0x00dd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaky.zze(com.google.android.gms.internal.ads.zzed, java.nio.charset.Charset):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:100:0x0248, code lost:
        r7.zzh(zzb(r7.zzb()));
        r7.zze(zzb(r7.zza()), 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x025f, code lost:
        r0 = r7.zzp();
        r1 = zzc(r13, r3, r2);
        r4 = zzc(r9, r3, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x026b, code lost:
        if (r1 >= r4) goto L_0x027f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x026d, code lost:
        ((java.util.List) r2.get(r1)).add(r0);
        r1 = r1 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x01ed, code lost:
        r1 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x01ee, code lost:
        r7.zzm(r1);
        r1 = Integer.MIN_VALUE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x01f3, code lost:
        switch(r8) {
            case -1: goto L_0x020c;
            case 0: goto L_0x01f6;
            case 1: goto L_0x020a;
            case 2: goto L_0x0208;
            case 3: goto L_0x0206;
            case 4: goto L_0x020a;
            case 5: goto L_0x0208;
            case 6: goto L_0x0206;
            case 7: goto L_0x020a;
            case 8: goto L_0x0208;
            case 9: goto L_0x0206;
            default: goto L_0x01f6;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x01f6, code lost:
        com.google.android.gms.internal.ads.zzdt.zzf("SsaParser", "Unknown alignment: " + r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0206, code lost:
        r4 = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0208, code lost:
        r4 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x020a, code lost:
        r4 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x020c, code lost:
        r4 = Integer.MIN_VALUE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x020d, code lost:
        r7.zzi(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x0210, code lost:
        switch(r8) {
            case -1: goto L_0x0228;
            case 0: goto L_0x0213;
            case 1: goto L_0x0227;
            case 2: goto L_0x0227;
            case 3: goto L_0x0227;
            case 4: goto L_0x0225;
            case 5: goto L_0x0225;
            case 6: goto L_0x0225;
            case 7: goto L_0x0223;
            case 8: goto L_0x0223;
            case 9: goto L_0x0223;
            default: goto L_0x0213;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x0213, code lost:
        com.google.android.gms.internal.ads.zzdt.zzf("SsaParser", "Unknown alignment: " + r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x0223, code lost:
        r1 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x0225, code lost:
        r1 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x0227, code lost:
        r1 = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x0228, code lost:
        r7.zzf(r1);
        r0 = r11.zzb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x022d, code lost:
        if (r0 == null) goto L_0x0248;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x0231, code lost:
        if (r15 == -3.4028235E38f) goto L_0x0248;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x0235, code lost:
        if (r21 == -3.4028235E38f) goto L_0x0248;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x0237, code lost:
        r7.zzh(r0.x / r21);
        r7.zze(r11.zzb.y / r15, 0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(byte[] r23, int r24, int r25, com.google.android.gms.internal.ads.zzakh r26, com.google.android.gms.internal.ads.zzdg r27) {
        /*
            r22 = this;
            r0 = r22
            r1 = r24
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            int r4 = r1 + r25
            com.google.android.gms.internal.ads.zzed r5 = r0.zzd
            r6 = r23
            r5.zzJ(r6, r4)
            com.google.android.gms.internal.ads.zzed r4 = r0.zzd
            r4.zzL(r1)
            com.google.android.gms.internal.ads.zzed r1 = r0.zzd
            java.nio.charset.Charset r1 = r1.zzC()
            if (r1 != 0) goto L_0x0026
            java.nio.charset.Charset r1 = java.nio.charset.StandardCharsets.UTF_8
        L_0x0026:
            boolean r4 = r0.zzb
            if (r4 != 0) goto L_0x002f
            com.google.android.gms.internal.ads.zzed r4 = r0.zzd
            r0.zze(r4, r1)
        L_0x002f:
            com.google.android.gms.internal.ads.zzed r4 = r0.zzd
            boolean r5 = r0.zzb
            if (r5 == 0) goto L_0x0038
            com.google.android.gms.internal.ads.zzakx r5 = r0.zzc
            goto L_0x0039
        L_0x0038:
            r5 = 0
        L_0x0039:
            java.lang.String r7 = r4.zzz(r1)
            r8 = -1
            if (r7 == 0) goto L_0x0289
            java.lang.String r11 = "Format:"
            boolean r11 = r7.startsWith(r11)
            if (r11 == 0) goto L_0x004d
            com.google.android.gms.internal.ads.zzakx r5 = com.google.android.gms.internal.ads.zzakx.zza(r7)
            goto L_0x0039
        L_0x004d:
            java.lang.String r11 = "Dialogue:"
            boolean r12 = r7.startsWith(r11)
            if (r12 == 0) goto L_0x0279
            java.lang.String r12 = "SsaParser"
            if (r5 != 0) goto L_0x0064
            java.lang.String r8 = "Skipping dialogue line before complete format: "
            java.lang.String r7 = r8.concat(r7)
            com.google.android.gms.internal.ads.zzdt.zzf(r12, r7)
            goto L_0x0279
        L_0x0064:
            boolean r11 = r7.startsWith(r11)
            com.google.android.gms.internal.ads.zzdb.zzd(r11)
            r11 = 9
            java.lang.String r11 = r7.substring(r11)
            java.lang.String r13 = ","
            int r14 = r5.zze
            java.lang.String[] r11 = r11.split(r13, r14)
            int r13 = r11.length
            int r14 = r5.zze
            if (r13 == r14) goto L_0x0089
            java.lang.String r8 = "Skipping dialogue line with fewer columns than format: "
            java.lang.String r7 = r8.concat(r7)
            com.google.android.gms.internal.ads.zzdt.zzf(r12, r7)
            goto L_0x0279
        L_0x0089:
            int r13 = r5.zza
            r13 = r11[r13]
            long r13 = zzd(r13)
            r15 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r17 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            java.lang.String r6 = "Skipping invalid timing: "
            if (r17 != 0) goto L_0x00a5
            java.lang.String r6 = r6.concat(r7)
            com.google.android.gms.internal.ads.zzdt.zzf(r12, r6)
            goto L_0x0279
        L_0x00a5:
            r24 = r15
            int r15 = r5.zzb
            r15 = r11[r15]
            long r9 = zzd(r15)
            int r15 = (r9 > r24 ? 1 : (r9 == r24 ? 0 : -1))
            if (r15 != 0) goto L_0x00bc
            java.lang.String r6 = r6.concat(r7)
            com.google.android.gms.internal.ads.zzdt.zzf(r12, r6)
            goto L_0x0279
        L_0x00bc:
            java.util.Map r6 = r0.zze
            if (r6 == 0) goto L_0x00d1
            int r7 = r5.zzc
            if (r7 == r8) goto L_0x00d1
            r7 = r11[r7]
            java.lang.String r7 = r7.trim()
            java.lang.Object r6 = r6.get(r7)
            com.google.android.gms.internal.ads.zzalb r6 = (com.google.android.gms.internal.ads.zzalb) r6
            goto L_0x00d2
        L_0x00d1:
            r6 = 0
        L_0x00d2:
            int r7 = r5.zzd
            r7 = r11[r7]
            com.google.android.gms.internal.ads.zzala r11 = com.google.android.gms.internal.ads.zzala.zza(r7)
            java.lang.String r7 = com.google.android.gms.internal.ads.zzala.zzb(r7)
            java.lang.String r15 = "\\N"
            java.lang.String r8 = "\n"
            java.lang.String r7 = r7.replace(r15, r8)
            java.lang.String r15 = "\\n"
            java.lang.String r7 = r7.replace(r15, r8)
            java.lang.String r8 = "\\h"
            java.lang.String r15 = " "
            java.lang.String r7 = r7.replace(r8, r15)
            float r8 = r0.zzf
            float r15 = r0.zzg
            android.text.SpannableString r0 = new android.text.SpannableString
            r0.<init>(r7)
            com.google.android.gms.internal.ads.zzcr r7 = new com.google.android.gms.internal.ads.zzcr
            r7.<init>()
            r7.zzl(r0)
            r17 = r1
            r18 = -8388609(0xffffffffff7fffff, float:-3.4028235E38)
            if (r6 == 0) goto L_0x01bc
            java.lang.Integer r1 = r6.zzc
            r19 = r1
            if (r19 == 0) goto L_0x012c
            android.text.style.ForegroundColorSpan r1 = new android.text.style.ForegroundColorSpan
            r20 = r4
            int r4 = r19.intValue()
            r1.<init>(r4)
            int r4 = r0.length()
            r19 = r5
            r21 = r8
            r5 = 33
            r8 = 0
            r0.setSpan(r1, r8, r4, r5)
            goto L_0x0132
        L_0x012c:
            r20 = r4
            r19 = r5
            r21 = r8
        L_0x0132:
            int r1 = r6.zzj
            r4 = 3
            if (r1 != r4) goto L_0x014e
            java.lang.Integer r1 = r6.zzd
            if (r1 == 0) goto L_0x014e
            android.text.style.BackgroundColorSpan r5 = new android.text.style.BackgroundColorSpan
            int r1 = r1.intValue()
            r5.<init>(r1)
            int r1 = r0.length()
            r4 = 0
            r8 = 33
            r0.setSpan(r5, r4, r1, r8)
        L_0x014e:
            float r1 = r6.zze
            int r4 = (r1 > r18 ? 1 : (r1 == r18 ? 0 : -1))
            if (r4 == 0) goto L_0x015d
            int r4 = (r15 > r18 ? 1 : (r15 == r18 ? 0 : -1))
            if (r4 == 0) goto L_0x015d
            float r1 = r1 / r15
            r4 = 1
            r7.zzn(r1, r4)
        L_0x015d:
            boolean r1 = r6.zzf
            if (r1 == 0) goto L_0x0187
            boolean r1 = r6.zzg
            if (r1 == 0) goto L_0x0176
            android.text.style.StyleSpan r1 = new android.text.style.StyleSpan
            r4 = 3
            r1.<init>(r4)
            int r4 = r0.length()
            r5 = 33
            r8 = 0
            r0.setSpan(r1, r8, r4, r5)
            goto L_0x019b
        L_0x0176:
            r5 = 33
            r8 = 0
            android.text.style.StyleSpan r1 = new android.text.style.StyleSpan
            r4 = 1
            r1.<init>(r4)
            int r4 = r0.length()
            r0.setSpan(r1, r8, r4, r5)
            goto L_0x019b
        L_0x0187:
            r5 = 33
            r8 = 0
            boolean r1 = r6.zzg
            if (r1 == 0) goto L_0x019b
            android.text.style.StyleSpan r1 = new android.text.style.StyleSpan
            r4 = 2
            r1.<init>(r4)
            int r4 = r0.length()
            r0.setSpan(r1, r8, r4, r5)
        L_0x019b:
            boolean r1 = r6.zzh
            if (r1 == 0) goto L_0x01ab
            android.text.style.UnderlineSpan r1 = new android.text.style.UnderlineSpan
            r1.<init>()
            int r4 = r0.length()
            r0.setSpan(r1, r8, r4, r5)
        L_0x01ab:
            boolean r1 = r6.zzi
            if (r1 == 0) goto L_0x01c2
            android.text.style.StrikethroughSpan r1 = new android.text.style.StrikethroughSpan
            r1.<init>()
            int r4 = r0.length()
            r0.setSpan(r1, r8, r4, r5)
            goto L_0x01c2
        L_0x01bc:
            r20 = r4
            r19 = r5
            r21 = r8
        L_0x01c2:
            int r0 = r11.zza
            r1 = -1
            if (r0 == r1) goto L_0x01c9
            r8 = r0
            goto L_0x01cf
        L_0x01c9:
            if (r6 == 0) goto L_0x01ce
            int r8 = r6.zzb
            goto L_0x01cf
        L_0x01ce:
            r8 = -1
        L_0x01cf:
            java.lang.String r0 = "Unknown alignment: "
            switch(r8) {
                case -1: goto L_0x01ed;
                case 0: goto L_0x01d4;
                case 1: goto L_0x01ea;
                case 2: goto L_0x01e7;
                case 3: goto L_0x01e4;
                case 4: goto L_0x01ea;
                case 5: goto L_0x01e7;
                case 6: goto L_0x01e4;
                case 7: goto L_0x01ea;
                case 8: goto L_0x01e7;
                case 9: goto L_0x01e4;
                default: goto L_0x01d4;
            }
        L_0x01d4:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r0)
            r1.append(r8)
            java.lang.String r1 = r1.toString()
            com.google.android.gms.internal.ads.zzdt.zzf(r12, r1)
            goto L_0x01ed
        L_0x01e4:
            android.text.Layout$Alignment r1 = android.text.Layout.Alignment.ALIGN_OPPOSITE
            goto L_0x01ee
        L_0x01e7:
            android.text.Layout$Alignment r1 = android.text.Layout.Alignment.ALIGN_CENTER
            goto L_0x01ee
        L_0x01ea:
            android.text.Layout$Alignment r1 = android.text.Layout.Alignment.ALIGN_NORMAL
            goto L_0x01ee
        L_0x01ed:
            r1 = 0
        L_0x01ee:
            r7.zzm(r1)
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            switch(r8) {
                case -1: goto L_0x020c;
                case 0: goto L_0x01f6;
                case 1: goto L_0x020a;
                case 2: goto L_0x0208;
                case 3: goto L_0x0206;
                case 4: goto L_0x020a;
                case 5: goto L_0x0208;
                case 6: goto L_0x0206;
                case 7: goto L_0x020a;
                case 8: goto L_0x0208;
                case 9: goto L_0x0206;
                default: goto L_0x01f6;
            }
        L_0x01f6:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r0)
            r4.append(r8)
            java.lang.String r4 = r4.toString()
            com.google.android.gms.internal.ads.zzdt.zzf(r12, r4)
            goto L_0x020c
        L_0x0206:
            r4 = 2
            goto L_0x020d
        L_0x0208:
            r4 = 1
            goto L_0x020d
        L_0x020a:
            r4 = 0
            goto L_0x020d
        L_0x020c:
            r4 = r1
        L_0x020d:
            r7.zzi(r4)
            switch(r8) {
                case -1: goto L_0x0228;
                case 0: goto L_0x0213;
                case 1: goto L_0x0227;
                case 2: goto L_0x0227;
                case 3: goto L_0x0227;
                case 4: goto L_0x0225;
                case 5: goto L_0x0225;
                case 6: goto L_0x0225;
                case 7: goto L_0x0223;
                case 8: goto L_0x0223;
                case 9: goto L_0x0223;
                default: goto L_0x0213;
            }
        L_0x0213:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r0)
            r4.append(r8)
            java.lang.String r0 = r4.toString()
            com.google.android.gms.internal.ads.zzdt.zzf(r12, r0)
            goto L_0x0228
        L_0x0223:
            r1 = 0
            goto L_0x0228
        L_0x0225:
            r1 = 1
            goto L_0x0228
        L_0x0227:
            r1 = 2
        L_0x0228:
            r7.zzf(r1)
            android.graphics.PointF r0 = r11.zzb
            if (r0 == 0) goto L_0x0248
            int r1 = (r15 > r18 ? 1 : (r15 == r18 ? 0 : -1))
            if (r1 == 0) goto L_0x0248
            int r1 = (r21 > r18 ? 1 : (r21 == r18 ? 0 : -1))
            if (r1 == 0) goto L_0x0248
            float r0 = r0.x
            float r0 = r0 / r21
            r7.zzh(r0)
            android.graphics.PointF r0 = r11.zzb
            float r0 = r0.y
            float r0 = r0 / r15
            r8 = 0
            r7.zze(r0, r8)
            goto L_0x025f
        L_0x0248:
            r8 = 0
            int r0 = r7.zzb()
            float r0 = zzb(r0)
            r7.zzh(r0)
            int r0 = r7.zza()
            float r0 = zzb(r0)
            r7.zze(r0, r8)
        L_0x025f:
            com.google.android.gms.internal.ads.zzct r0 = r7.zzp()
            int r1 = zzc(r13, r3, r2)
            int r4 = zzc(r9, r3, r2)
        L_0x026b:
            if (r1 >= r4) goto L_0x027f
            java.lang.Object r5 = r2.get(r1)
            java.util.List r5 = (java.util.List) r5
            r5.add(r0)
            int r1 = r1 + 1
            goto L_0x026b
        L_0x0279:
            r17 = r1
            r20 = r4
            r19 = r5
        L_0x027f:
            r0 = r22
            r1 = r17
            r5 = r19
            r4 = r20
            goto L_0x0039
        L_0x0289:
            r8 = 0
            r0 = r8
        L_0x028b:
            int r1 = r2.size()
            if (r0 >= r1) goto L_0x02e3
            java.lang.Object r1 = r2.get(r0)
            r10 = r1
            java.util.List r10 = (java.util.List) r10
            boolean r1 = r10.isEmpty()
            if (r1 == 0) goto L_0x02a6
            if (r0 == 0) goto L_0x02a5
            r1 = r27
            r4 = -1
        L_0x02a3:
            r5 = 1
            goto L_0x02db
        L_0x02a5:
            r0 = r8
        L_0x02a6:
            int r1 = r2.size()
            r4 = -1
            int r1 = r1 + r4
            if (r0 == r1) goto L_0x02dd
            java.lang.Object r1 = r3.get(r0)
            java.lang.Long r1 = (java.lang.Long) r1
            long r11 = r1.longValue()
            int r1 = r0 + 1
            java.lang.Object r1 = r3.get(r1)
            java.lang.Long r1 = (java.lang.Long) r1
            long r5 = r1.longValue()
            java.lang.Object r1 = r3.get(r0)
            java.lang.Long r1 = (java.lang.Long) r1
            long r13 = r1.longValue()
            long r13 = r5 - r13
            com.google.android.gms.internal.ads.zzaka r9 = new com.google.android.gms.internal.ads.zzaka
            r9.<init>(r10, r11, r13)
            r1 = r27
            r1.zza(r9)
            goto L_0x02a3
        L_0x02db:
            int r0 = r0 + r5
            goto L_0x028b
        L_0x02dd:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            r0.<init>()
            throw r0
        L_0x02e3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaky.zza(byte[], int, int, com.google.android.gms.internal.ads.zzakh, com.google.android.gms.internal.ads.zzdg):void");
    }

    public zzaky(List list) {
        this.zzf = -3.4028235E38f;
        this.zzg = -3.4028235E38f;
        this.zzd = new zzed();
        if (list == null || list.isEmpty()) {
            this.zzb = false;
            this.zzc = null;
            return;
        }
        this.zzb = true;
        String zzB = zzen.zzB((byte[]) list.get(0));
        zzdb.zzd(zzB.startsWith("Format:"));
        zzakx zza2 = zzakx.zza(zzB);
        zza2.getClass();
        zzakx zzakx = zza2;
        this.zzc = zza2;
        zze(new zzed((byte[]) list.get(1)), StandardCharsets.UTF_8);
    }
}
