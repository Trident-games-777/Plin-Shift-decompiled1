package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzalc implements zzaki {
    private static final Pattern zza = Pattern.compile("\\s*((?:(\\d+):)?(\\d+):(\\d+)(?:,(\\d+))?)\\s*-->\\s*((?:(\\d+):)?(\\d+):(\\d+)(?:,(\\d+))?)\\s*");
    private static final Pattern zzb = Pattern.compile("\\{\\\\.*?\\}");
    private final StringBuilder zzc = new StringBuilder();
    private final ArrayList zzd = new ArrayList();
    private final zzed zze = new zzed();

    public static float zzb(int i) {
        if (i == 0) {
            return 0.08f;
        }
        if (i == 1) {
            return 0.5f;
        }
        if (i == 2) {
            return 0.92f;
        }
        throw new IllegalArgumentException();
    }

    private static long zzc(Matcher matcher, int i) {
        String group = matcher.group(i + 1);
        long parseLong = group != null ? Long.parseLong(group) * 3600000 : 0;
        String group2 = matcher.group(i + 2);
        group2.getClass();
        String str = group2;
        long parseLong2 = parseLong + (Long.parseLong(group2) * 60000);
        String group3 = matcher.group(i + 3);
        group3.getClass();
        String str2 = group3;
        long parseLong3 = parseLong2 + (Long.parseLong(group3) * 1000);
        String group4 = matcher.group(i + 4);
        if (group4 != null) {
            parseLong3 += Long.parseLong(group4);
        }
        return parseLong3 * 1000;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(byte[] r17, int r18, int r19, com.google.android.gms.internal.ads.zzakh r20, com.google.android.gms.internal.ads.zzdg r21) {
        /*
            r16 = this;
            r0 = r16
            r1 = r18
            java.lang.String r2 = "SubripParser"
            int r3 = r1 + r19
            com.google.android.gms.internal.ads.zzed r4 = r0.zze
            r5 = r17
            r4.zzJ(r5, r3)
            com.google.android.gms.internal.ads.zzed r3 = r0.zze
            r3.zzL(r1)
            com.google.android.gms.internal.ads.zzed r1 = r0.zze
            java.nio.charset.Charset r1 = r1.zzC()
            if (r1 != 0) goto L_0x001e
            java.nio.charset.Charset r1 = java.nio.charset.StandardCharsets.UTF_8
        L_0x001e:
            com.google.android.gms.internal.ads.zzed r3 = r0.zze
            java.lang.String r3 = r3.zzz(r1)
            if (r3 == 0) goto L_0x0201
            int r4 = r3.length()
            if (r4 == 0) goto L_0x01fb
            java.lang.Integer.parseInt(r3)     // Catch:{ NumberFormatException -> 0x01ef }
            com.google.android.gms.internal.ads.zzed r3 = r0.zze
            java.lang.String r3 = r3.zzz(r1)
            if (r3 != 0) goto L_0x003d
            java.lang.String r1 = "Unexpected end"
            com.google.android.gms.internal.ads.zzdt.zzf(r2, r1)
            return
        L_0x003d:
            java.util.regex.Pattern r4 = zza
            java.util.regex.Matcher r4 = r4.matcher(r3)
            boolean r5 = r4.matches()
            if (r5 == 0) goto L_0x01e3
            r3 = 1
            long r7 = zzc(r4, r3)
            r5 = 6
            long r4 = zzc(r4, r5)
            java.lang.StringBuilder r6 = r0.zzc
            r9 = 0
            r6.setLength(r9)
            java.util.ArrayList r6 = r0.zzd
            r6.clear()
            com.google.android.gms.internal.ads.zzed r6 = r0.zze
            java.lang.String r6 = r6.zzz(r1)
        L_0x0064:
            boolean r10 = android.text.TextUtils.isEmpty(r6)
            if (r10 != 0) goto L_0x00be
            java.lang.StringBuilder r10 = r0.zzc
            int r10 = r10.length()
            if (r10 <= 0) goto L_0x0079
            java.lang.StringBuilder r10 = r0.zzc
            java.lang.String r11 = "<br>"
            r10.append(r11)
        L_0x0079:
            java.lang.StringBuilder r10 = r0.zzc
            java.util.ArrayList r11 = r0.zzd
            java.lang.String r6 = r6.trim()
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>(r6)
            java.util.regex.Pattern r13 = zzb
            java.util.regex.Matcher r6 = r13.matcher(r6)
            r13 = r9
        L_0x008d:
            boolean r14 = r6.find()
            if (r14 == 0) goto L_0x00ae
            java.lang.String r14 = r6.group()
            r11.add(r14)
            int r15 = r6.start()
            int r15 = r15 - r13
            int r14 = r14.length()
            int r9 = r15 + r14
            java.lang.String r3 = ""
            r12.replace(r15, r9, r3)
            int r13 = r13 + r14
            r3 = 1
            r9 = 0
            goto L_0x008d
        L_0x00ae:
            java.lang.String r3 = r12.toString()
            r10.append(r3)
            com.google.android.gms.internal.ads.zzed r3 = r0.zze
            java.lang.String r6 = r3.zzz(r1)
            r3 = 1
            r9 = 0
            goto L_0x0064
        L_0x00be:
            java.lang.StringBuilder r3 = r0.zzc
            java.lang.String r3 = r3.toString()
            android.text.Spanned r3 = android.text.Html.fromHtml(r3)
            r6 = 0
        L_0x00c9:
            java.util.ArrayList r9 = r0.zzd
            int r9 = r9.size()
            if (r6 >= r9) goto L_0x00e5
            java.util.ArrayList r9 = r0.zzd
            java.lang.Object r9 = r9.get(r6)
            java.lang.String r9 = (java.lang.String) r9
            java.lang.String r10 = "\\{\\\\an[1-9]\\}"
            boolean r10 = r9.matches(r10)
            if (r10 == 0) goto L_0x00e2
            goto L_0x00e6
        L_0x00e2:
            int r6 = r6 + 1
            goto L_0x00c9
        L_0x00e5:
            r9 = 0
        L_0x00e6:
            r10 = r4
            com.google.android.gms.internal.ads.zzaka r5 = new com.google.android.gms.internal.ads.zzaka
            com.google.android.gms.internal.ads.zzcr r4 = new com.google.android.gms.internal.ads.zzcr
            r4.<init>()
            r4.zzl(r3)
            if (r9 != 0) goto L_0x00f9
            com.google.android.gms.internal.ads.zzct r3 = r4.zzp()
            goto L_0x01d4
        L_0x00f9:
            int r3 = r9.hashCode()
            java.lang.String r6 = "{\\an9}"
            java.lang.String r12 = "{\\an7}"
            java.lang.String r13 = "{\\an3}"
            java.lang.String r14 = "{\\an1}"
            r15 = 2
            switch(r3) {
                case -685620710: goto L_0x0136;
                case -685620648: goto L_0x012e;
                case -685620617: goto L_0x0124;
                case -685620555: goto L_0x011a;
                case -685620524: goto L_0x0112;
                case -685620462: goto L_0x010a;
                default: goto L_0x0109;
            }
        L_0x0109:
            goto L_0x013e
        L_0x010a:
            boolean r3 = r9.equals(r6)
            if (r3 == 0) goto L_0x013e
            r3 = 5
            goto L_0x013f
        L_0x0112:
            boolean r3 = r9.equals(r12)
            if (r3 == 0) goto L_0x013e
            r3 = r15
            goto L_0x013f
        L_0x011a:
            java.lang.String r3 = "{\\an6}"
            boolean r3 = r9.equals(r3)
            if (r3 == 0) goto L_0x013e
            r3 = 4
            goto L_0x013f
        L_0x0124:
            java.lang.String r3 = "{\\an4}"
            boolean r3 = r9.equals(r3)
            if (r3 == 0) goto L_0x013e
            r3 = 1
            goto L_0x013f
        L_0x012e:
            boolean r3 = r9.equals(r13)
            if (r3 == 0) goto L_0x013e
            r3 = 3
            goto L_0x013f
        L_0x0136:
            boolean r3 = r9.equals(r14)
            if (r3 == 0) goto L_0x013e
            r3 = 0
            goto L_0x013f
        L_0x013e:
            r3 = -1
        L_0x013f:
            if (r3 == 0) goto L_0x0158
            r0 = 1
            if (r3 == r0) goto L_0x0158
            if (r3 == r15) goto L_0x0158
            r15 = 3
            if (r3 == r15) goto L_0x0153
            r15 = 4
            if (r3 == r15) goto L_0x0153
            r15 = 5
            if (r3 == r15) goto L_0x0153
            r4.zzi(r0)
            goto L_0x015c
        L_0x0153:
            r0 = 2
            r4.zzi(r0)
            goto L_0x015c
        L_0x0158:
            r0 = 0
            r4.zzi(r0)
        L_0x015c:
            int r0 = r9.hashCode()
            switch(r0) {
                case -685620710: goto L_0x0190;
                case -685620679: goto L_0x0186;
                case -685620648: goto L_0x017e;
                case -685620524: goto L_0x0176;
                case -685620493: goto L_0x016c;
                case -685620462: goto L_0x0164;
                default: goto L_0x0163;
            }
        L_0x0163:
            goto L_0x0198
        L_0x0164:
            boolean r0 = r9.equals(r6)
            if (r0 == 0) goto L_0x0198
            r0 = 5
            goto L_0x0199
        L_0x016c:
            java.lang.String r0 = "{\\an8}"
            boolean r0 = r9.equals(r0)
            if (r0 == 0) goto L_0x0198
            r0 = 4
            goto L_0x0199
        L_0x0176:
            boolean r0 = r9.equals(r12)
            if (r0 == 0) goto L_0x0198
            r0 = 3
            goto L_0x0199
        L_0x017e:
            boolean r0 = r9.equals(r13)
            if (r0 == 0) goto L_0x0198
            r0 = 2
            goto L_0x0199
        L_0x0186:
            java.lang.String r0 = "{\\an2}"
            boolean r0 = r9.equals(r0)
            if (r0 == 0) goto L_0x0198
            r0 = 1
            goto L_0x0199
        L_0x0190:
            boolean r0 = r9.equals(r14)
            if (r0 == 0) goto L_0x0198
            r0 = 0
            goto L_0x0199
        L_0x0198:
            r0 = -1
        L_0x0199:
            if (r0 == 0) goto L_0x01b5
            r3 = 1
            if (r0 == r3) goto L_0x01b5
            r6 = 2
            if (r0 == r6) goto L_0x01b3
            r15 = 3
            if (r0 == r15) goto L_0x01ae
            r15 = 4
            if (r0 == r15) goto L_0x01ae
            r15 = 5
            if (r0 == r15) goto L_0x01ae
            r4.zzf(r3)
            goto L_0x01b9
        L_0x01ae:
            r0 = 0
            r4.zzf(r0)
            goto L_0x01b9
        L_0x01b3:
            r0 = r6
            goto L_0x01b6
        L_0x01b5:
            r0 = 2
        L_0x01b6:
            r4.zzf(r0)
        L_0x01b9:
            int r0 = r4.zzb()
            float r0 = zzb(r0)
            r4.zzh(r0)
            int r0 = r4.zza()
            float r0 = zzb(r0)
            r3 = 0
            r4.zze(r0, r3)
            com.google.android.gms.internal.ads.zzct r3 = r4.zzp()
        L_0x01d4:
            long r9 = r10 - r7
            com.google.android.gms.internal.ads.zzfzo r6 = com.google.android.gms.internal.ads.zzfzo.zzo(r3)
            r5.<init>(r6, r7, r9)
            r0 = r21
            r0.zza(r5)
            goto L_0x01fd
        L_0x01e3:
            r0 = r21
            java.lang.String r4 = "Skipping invalid timing: "
            java.lang.String r3 = r4.concat(r3)
            com.google.android.gms.internal.ads.zzdt.zzf(r2, r3)
            goto L_0x01fd
        L_0x01ef:
            r0 = r21
            java.lang.String r4 = "Skipping invalid index: "
            java.lang.String r3 = r4.concat(r3)
            com.google.android.gms.internal.ads.zzdt.zzf(r2, r3)
            goto L_0x01fd
        L_0x01fb:
            r0 = r21
        L_0x01fd:
            r0 = r16
            goto L_0x001e
        L_0x0201:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzalc.zza(byte[], int, int, com.google.android.gms.internal.ads.zzakh, com.google.android.gms.internal.ads.zzdg):void");
    }
}
