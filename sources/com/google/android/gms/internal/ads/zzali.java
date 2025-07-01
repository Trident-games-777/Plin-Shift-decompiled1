package com.google.android.gms.internal.ads;

import java.util.regex.Pattern;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzali implements zzaki {
    static final Pattern zza = Pattern.compile("^([-+]?\\d+\\.?\\d*?)%$");
    static final Pattern zzb = Pattern.compile("^(\\d+\\.?\\d*?)% (\\d+\\.?\\d*?)%$");
    private static final Pattern zzc = Pattern.compile("^([0-9][0-9]+):([0-9][0-9]):([0-9][0-9])(?:(\\.[0-9]+)|:([0-9][0-9])(?:\\.([0-9]+))?)?$");
    private static final Pattern zzd = Pattern.compile("^([0-9]+(?:\\.[0-9]+)?)(h|m|s|ms|f|t)$");
    private static final Pattern zze = Pattern.compile("^(([0-9]*.)?[0-9]+)(px|em|%)$");
    private static final Pattern zzf = Pattern.compile("^(\\d+\\.?\\d*?)px (\\d+\\.?\\d*?)px$");
    private static final Pattern zzg = Pattern.compile("^(\\d+) (\\d+)$");
    private static final zzalg zzh = new zzalg(30.0f, 1, 1);
    private final XmlPullParserFactory zzi;

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00d6, code lost:
        if (r13.equals("s") != false) goto L_0x0102;
     */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0104  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x011f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static long zzc(java.lang.String r13, com.google.android.gms.internal.ads.zzalg r14) throws com.google.android.gms.internal.ads.zzake {
        /*
            java.util.regex.Pattern r0 = zzc
            java.util.regex.Matcher r0 = r0.matcher(r13)
            boolean r1 = r0.matches()
            r2 = 4696837146684686336(0x412e848000000000, double:1000000.0)
            r4 = 5
            r5 = 4
            r6 = 3
            r7 = 2
            r8 = 1
            if (r1 == 0) goto L_0x0085
            java.lang.String r13 = r0.group(r8)
            r13.getClass()
            r1 = r13
            java.lang.String r1 = (java.lang.String) r1
            long r8 = java.lang.Long.parseLong(r13)
            r10 = 3600(0xe10, double:1.7786E-320)
            long r8 = r8 * r10
            java.lang.String r13 = r0.group(r7)
            r13.getClass()
            double r7 = (double) r8
            r1 = r13
            java.lang.String r1 = (java.lang.String) r1
            long r9 = java.lang.Long.parseLong(r13)
            r11 = 60
            long r9 = r9 * r11
            java.lang.String r13 = r0.group(r6)
            r13.getClass()
            double r9 = (double) r9
            double r7 = r7 + r9
            r1 = r13
            java.lang.String r1 = (java.lang.String) r1
            long r9 = java.lang.Long.parseLong(r13)
            double r9 = (double) r9
            java.lang.String r13 = r0.group(r5)
            r5 = 0
            if (r13 == 0) goto L_0x0057
            double r11 = java.lang.Double.parseDouble(r13)
            goto L_0x0058
        L_0x0057:
            r11 = r5
        L_0x0058:
            double r7 = r7 + r9
            java.lang.String r13 = r0.group(r4)
            if (r13 == 0) goto L_0x0069
            long r9 = java.lang.Long.parseLong(r13)
            float r13 = (float) r9
            float r1 = r14.zza
            float r13 = r13 / r1
            double r9 = (double) r13
            goto L_0x006a
        L_0x0069:
            r9 = r5
        L_0x006a:
            double r7 = r7 + r11
            r13 = 6
            java.lang.String r13 = r0.group(r13)
            if (r13 == 0) goto L_0x0080
            long r0 = java.lang.Long.parseLong(r13)
            double r0 = (double) r0
            int r13 = r14.zzb
            double r4 = (double) r13
            float r13 = r14.zza
            double r13 = (double) r13
            double r0 = r0 / r4
            double r5 = r0 / r13
        L_0x0080:
            double r7 = r7 + r9
            double r7 = r7 + r5
            double r7 = r7 * r2
            long r13 = (long) r7
            return r13
        L_0x0085:
            java.util.regex.Pattern r0 = zzd
            java.util.regex.Matcher r0 = r0.matcher(r13)
            boolean r1 = r0.matches()
            if (r1 == 0) goto L_0x0128
            java.lang.String r13 = r0.group(r8)
            r13.getClass()
            r1 = r13
            java.lang.String r1 = (java.lang.String) r1
            double r9 = java.lang.Double.parseDouble(r13)
            java.lang.String r13 = r0.group(r7)
            r13.getClass()
            r0 = r13
            java.lang.String r0 = (java.lang.String) r0
            int r0 = r13.hashCode()
            r1 = 102(0x66, float:1.43E-43)
            if (r0 == r1) goto L_0x00f7
            r1 = 104(0x68, float:1.46E-43)
            if (r0 == r1) goto L_0x00ed
            r1 = 109(0x6d, float:1.53E-43)
            if (r0 == r1) goto L_0x00e3
            r1 = 3494(0xda6, float:4.896E-42)
            if (r0 == r1) goto L_0x00d9
            r1 = 115(0x73, float:1.61E-43)
            if (r0 == r1) goto L_0x00d0
            r1 = 116(0x74, float:1.63E-43)
            if (r0 == r1) goto L_0x00c6
            goto L_0x0101
        L_0x00c6:
            java.lang.String r0 = "t"
            boolean r13 = r13.equals(r0)
            if (r13 == 0) goto L_0x0101
            r7 = r4
            goto L_0x0102
        L_0x00d0:
            java.lang.String r0 = "s"
            boolean r13 = r13.equals(r0)
            if (r13 == 0) goto L_0x0101
            goto L_0x0102
        L_0x00d9:
            java.lang.String r0 = "ms"
            boolean r13 = r13.equals(r0)
            if (r13 == 0) goto L_0x0101
            r7 = r6
            goto L_0x0102
        L_0x00e3:
            java.lang.String r0 = "m"
            boolean r13 = r13.equals(r0)
            if (r13 == 0) goto L_0x0101
            r7 = r8
            goto L_0x0102
        L_0x00ed:
            java.lang.String r0 = "h"
            boolean r13 = r13.equals(r0)
            if (r13 == 0) goto L_0x0101
            r7 = 0
            goto L_0x0102
        L_0x00f7:
            java.lang.String r0 = "f"
            boolean r13 = r13.equals(r0)
            if (r13 == 0) goto L_0x0101
            r7 = r5
            goto L_0x0102
        L_0x0101:
            r7 = -1
        L_0x0102:
            if (r7 == 0) goto L_0x011f
            if (r7 == r8) goto L_0x011c
            if (r7 == r6) goto L_0x0115
            if (r7 == r5) goto L_0x0111
            if (r7 == r4) goto L_0x010d
            goto L_0x0125
        L_0x010d:
            int r13 = r14.zzc
            double r13 = (double) r13
            goto L_0x011a
        L_0x0111:
            float r13 = r14.zza
            double r13 = (double) r13
            goto L_0x011a
        L_0x0115:
            r13 = 4652007308841189376(0x408f400000000000, double:1000.0)
        L_0x011a:
            double r9 = r9 / r13
            goto L_0x0125
        L_0x011c:
            r13 = 4633641066610819072(0x404e000000000000, double:60.0)
            goto L_0x0124
        L_0x011f:
            r13 = 4660134898793709568(0x40ac200000000000, double:3600.0)
        L_0x0124:
            double r9 = r9 * r13
        L_0x0125:
            double r9 = r9 * r2
            long r13 = (long) r9
            return r13
        L_0x0128:
            java.lang.String r13 = java.lang.String.valueOf(r13)
            com.google.android.gms.internal.ads.zzake r14 = new com.google.android.gms.internal.ads.zzake
            java.lang.String r0 = "Malformed time expression: "
            java.lang.String r13 = r0.concat(r13)
            r14.<init>(r13)
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzali.zzc(java.lang.String, com.google.android.gms.internal.ads.zzalg):long");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.text.Layout.Alignment zzd(java.lang.String r5) {
        /*
            java.lang.String r5 = com.google.android.gms.internal.ads.zzfwa.zza(r5)
            int r0 = r5.hashCode()
            r1 = 4
            r2 = 3
            r3 = 2
            r4 = 1
            switch(r0) {
                case -1364013995: goto L_0x0038;
                case 100571: goto L_0x002e;
                case 3317767: goto L_0x0024;
                case 108511772: goto L_0x001a;
                case 109757538: goto L_0x0010;
                default: goto L_0x000f;
            }
        L_0x000f:
            goto L_0x0042
        L_0x0010:
            java.lang.String r0 = "start"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x0042
            r5 = r4
            goto L_0x0043
        L_0x001a:
            java.lang.String r0 = "right"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x0042
            r5 = r3
            goto L_0x0043
        L_0x0024:
            java.lang.String r0 = "left"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x0042
            r5 = 0
            goto L_0x0043
        L_0x002e:
            java.lang.String r0 = "end"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x0042
            r5 = r2
            goto L_0x0043
        L_0x0038:
            java.lang.String r0 = "center"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x0042
            r5 = r1
            goto L_0x0043
        L_0x0042:
            r5 = -1
        L_0x0043:
            if (r5 == 0) goto L_0x0055
            if (r5 == r4) goto L_0x0055
            if (r5 == r3) goto L_0x0052
            if (r5 == r2) goto L_0x0052
            if (r5 == r1) goto L_0x004f
            r5 = 0
            return r5
        L_0x004f:
            android.text.Layout$Alignment r5 = android.text.Layout.Alignment.ALIGN_CENTER
            return r5
        L_0x0052:
            android.text.Layout$Alignment r5 = android.text.Layout.Alignment.ALIGN_OPPOSITE
            return r5
        L_0x0055:
            android.text.Layout$Alignment r5 = android.text.Layout.Alignment.ALIGN_NORMAL
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzali.zzd(java.lang.String):android.text.Layout$Alignment");
    }

    private static zzall zze(zzall zzall) {
        return zzall == null ? new zzall() : zzall;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.android.gms.internal.ads.zzall zzf(org.xmlpull.v1.XmlPullParser r16, com.google.android.gms.internal.ads.zzall r17) {
        /*
            r1 = r16
            int r2 = r1.getAttributeCount()
            r3 = 0
            r0 = r17
            r4 = r3
        L_0x000a:
            if (r4 >= r2) goto L_0x03f5
            java.lang.String r5 = r1.getAttributeValue(r4)
            java.lang.String r6 = r1.getAttributeName(r4)
            int r7 = r6.hashCode()
            r8 = 5
            r9 = 4
            r10 = -1
            r11 = 3
            r12 = 2
            r13 = 1
            switch(r7) {
                case -1550943582: goto L_0x00bc;
                case -1224696685: goto L_0x00b2;
                case -1065511464: goto L_0x00a8;
                case -879295043: goto L_0x009d;
                case -734428249: goto L_0x0093;
                case 3355: goto L_0x0089;
                case 3511770: goto L_0x007e;
                case 94842723: goto L_0x0074;
                case 109403361: goto L_0x0069;
                case 110138194: goto L_0x005d;
                case 365601008: goto L_0x0052;
                case 921125321: goto L_0x0046;
                case 1115953443: goto L_0x003a;
                case 1287124693: goto L_0x002f;
                case 1754920356: goto L_0x0023;
                default: goto L_0x0021;
            }
        L_0x0021:
            goto L_0x00c6
        L_0x0023:
            java.lang.String r7 = "multiRowAlign"
            boolean r6 = r6.equals(r7)
            if (r6 == 0) goto L_0x00c6
            r6 = 8
            goto L_0x00c7
        L_0x002f:
            java.lang.String r7 = "backgroundColor"
            boolean r6 = r6.equals(r7)
            if (r6 == 0) goto L_0x00c6
            r6 = r13
            goto L_0x00c7
        L_0x003a:
            java.lang.String r7 = "rubyPosition"
            boolean r6 = r6.equals(r7)
            if (r6 == 0) goto L_0x00c6
            r6 = 11
            goto L_0x00c7
        L_0x0046:
            java.lang.String r7 = "textEmphasis"
            boolean r6 = r6.equals(r7)
            if (r6 == 0) goto L_0x00c6
            r6 = 13
            goto L_0x00c7
        L_0x0052:
            java.lang.String r7 = "fontSize"
            boolean r6 = r6.equals(r7)
            if (r6 == 0) goto L_0x00c6
            r6 = r9
            goto L_0x00c7
        L_0x005d:
            java.lang.String r7 = "textCombine"
            boolean r6 = r6.equals(r7)
            if (r6 == 0) goto L_0x00c6
            r6 = 9
            goto L_0x00c7
        L_0x0069:
            java.lang.String r7 = "shear"
            boolean r6 = r6.equals(r7)
            if (r6 == 0) goto L_0x00c6
            r6 = 14
            goto L_0x00c7
        L_0x0074:
            java.lang.String r7 = "color"
            boolean r6 = r6.equals(r7)
            if (r6 == 0) goto L_0x00c6
            r6 = r12
            goto L_0x00c7
        L_0x007e:
            java.lang.String r7 = "ruby"
            boolean r6 = r6.equals(r7)
            if (r6 == 0) goto L_0x00c6
            r6 = 10
            goto L_0x00c7
        L_0x0089:
            java.lang.String r7 = "id"
            boolean r6 = r6.equals(r7)
            if (r6 == 0) goto L_0x00c6
            r6 = r3
            goto L_0x00c7
        L_0x0093:
            java.lang.String r7 = "fontWeight"
            boolean r6 = r6.equals(r7)
            if (r6 == 0) goto L_0x00c6
            r6 = r8
            goto L_0x00c7
        L_0x009d:
            java.lang.String r7 = "textDecoration"
            boolean r6 = r6.equals(r7)
            if (r6 == 0) goto L_0x00c6
            r6 = 12
            goto L_0x00c7
        L_0x00a8:
            java.lang.String r7 = "textAlign"
            boolean r6 = r6.equals(r7)
            if (r6 == 0) goto L_0x00c6
            r6 = 7
            goto L_0x00c7
        L_0x00b2:
            java.lang.String r7 = "fontFamily"
            boolean r6 = r6.equals(r7)
            if (r6 == 0) goto L_0x00c6
            r6 = r11
            goto L_0x00c7
        L_0x00bc:
            java.lang.String r7 = "fontStyle"
            boolean r6 = r6.equals(r7)
            if (r6 == 0) goto L_0x00c6
            r6 = 6
            goto L_0x00c7
        L_0x00c6:
            r6 = r10
        L_0x00c7:
            r7 = 0
            java.lang.String r14 = "TtmlParser"
            switch(r6) {
                case 0: goto L_0x03dd;
                case 1: goto L_0x03c3;
                case 2: goto L_0x03a9;
                case 3: goto L_0x03a1;
                case 4: goto L_0x02ba;
                case 5: goto L_0x02ab;
                case 6: goto L_0x029c;
                case 7: goto L_0x028f;
                case 8: goto L_0x0282;
                case 9: goto L_0x0244;
                case 10: goto L_0x01cb;
                case 11: goto L_0x018d;
                case 12: goto L_0x012c;
                case 13: goto L_0x011f;
                case 14: goto L_0x00cf;
                default: goto L_0x00cd;
            }
        L_0x00cd:
            goto L_0x03f0
        L_0x00cf:
            com.google.android.gms.internal.ads.zzall r6 = zze(r0)
            java.util.regex.Pattern r0 = zza
            java.util.regex.Matcher r0 = r0.matcher(r5)
            boolean r8 = r0.matches()
            r9 = 2139095039(0x7f7fffff, float:3.4028235E38)
            if (r8 != 0) goto L_0x00f0
            java.lang.String r0 = java.lang.String.valueOf(r5)
            java.lang.String r5 = "Invalid value for shear: "
            java.lang.String r0 = r5.concat(r0)
            com.google.android.gms.internal.ads.zzdt.zzf(r14, r0)
            goto L_0x0119
        L_0x00f0:
            java.lang.String r0 = r0.group(r13)     // Catch:{ NumberFormatException -> 0x010b }
            if (r0 == 0) goto L_0x010a
            r7 = r0
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ NumberFormatException -> 0x010b }
            float r0 = java.lang.Float.parseFloat(r0)     // Catch:{ NumberFormatException -> 0x010b }
            r7 = -1027080192(0xffffffffc2c80000, float:-100.0)
            float r0 = java.lang.Math.max(r7, r0)     // Catch:{ NumberFormatException -> 0x010b }
            r7 = 1120403456(0x42c80000, float:100.0)
            float r9 = java.lang.Math.min(r7, r0)     // Catch:{ NumberFormatException -> 0x010b }
            goto L_0x0119
        L_0x010a:
            throw r7     // Catch:{ NumberFormatException -> 0x010b }
        L_0x010b:
            r0 = move-exception
            java.lang.String r5 = java.lang.String.valueOf(r5)
            java.lang.String r7 = "Failed to parse shear: "
            java.lang.String r5 = r7.concat(r5)
            com.google.android.gms.internal.ads.zzdt.zzg(r14, r5, r0)
        L_0x0119:
            r6.zzy(r9)
            r0 = r6
            goto L_0x03f0
        L_0x011f:
            com.google.android.gms.internal.ads.zzall r0 = zze(r0)
            com.google.android.gms.internal.ads.zzale r5 = com.google.android.gms.internal.ads.zzale.zza(r5)
            r0.zzB(r5)
            goto L_0x03f0
        L_0x012c:
            java.lang.String r5 = com.google.android.gms.internal.ads.zzfwa.zza(r5)
            int r6 = r5.hashCode()
            switch(r6) {
                case -1461280213: goto L_0x0156;
                case -1026963764: goto L_0x014c;
                case 913457136: goto L_0x0142;
                case 1679736913: goto L_0x0138;
                default: goto L_0x0137;
            }
        L_0x0137:
            goto L_0x015f
        L_0x0138:
            java.lang.String r6 = "linethrough"
            boolean r5 = r5.equals(r6)
            if (r5 == 0) goto L_0x015f
            r10 = r3
            goto L_0x015f
        L_0x0142:
            java.lang.String r6 = "nolinethrough"
            boolean r5 = r5.equals(r6)
            if (r5 == 0) goto L_0x015f
            r10 = r13
            goto L_0x015f
        L_0x014c:
            java.lang.String r6 = "underline"
            boolean r5 = r5.equals(r6)
            if (r5 == 0) goto L_0x015f
            r10 = r12
            goto L_0x015f
        L_0x0156:
            java.lang.String r6 = "nounderline"
            boolean r5 = r5.equals(r6)
            if (r5 == 0) goto L_0x015f
            r10 = r11
        L_0x015f:
            if (r10 == 0) goto L_0x0184
            if (r10 == r13) goto L_0x017b
            if (r10 == r12) goto L_0x0172
            if (r10 == r11) goto L_0x0169
            goto L_0x03f0
        L_0x0169:
            com.google.android.gms.internal.ads.zzall r0 = zze(r0)
            r0.zzC(r3)
            goto L_0x03f0
        L_0x0172:
            com.google.android.gms.internal.ads.zzall r0 = zze(r0)
            r0.zzC(r13)
            goto L_0x03f0
        L_0x017b:
            com.google.android.gms.internal.ads.zzall r0 = zze(r0)
            r0.zzu(r3)
            goto L_0x03f0
        L_0x0184:
            com.google.android.gms.internal.ads.zzall r0 = zze(r0)
            r0.zzu(r13)
            goto L_0x03f0
        L_0x018d:
            java.lang.String r5 = com.google.android.gms.internal.ads.zzfwa.zza(r5)
            int r6 = r5.hashCode()
            r7 = -1392885889(0xffffffffacfa3f7f, float:-7.112477E-12)
            if (r6 == r7) goto L_0x01aa
            r7 = 92734940(0x58705dc, float:1.2697491E-35)
            if (r6 == r7) goto L_0x01a0
            goto L_0x01b3
        L_0x01a0:
            java.lang.String r6 = "after"
            boolean r5 = r5.equals(r6)
            if (r5 == 0) goto L_0x01b3
            r10 = r13
            goto L_0x01b3
        L_0x01aa:
            java.lang.String r6 = "before"
            boolean r5 = r5.equals(r6)
            if (r5 == 0) goto L_0x01b3
            r10 = r3
        L_0x01b3:
            if (r10 == 0) goto L_0x01c2
            if (r10 == r13) goto L_0x01b9
            goto L_0x03f0
        L_0x01b9:
            com.google.android.gms.internal.ads.zzall r0 = zze(r0)
            r0.zzw(r12)
            goto L_0x03f0
        L_0x01c2:
            com.google.android.gms.internal.ads.zzall r0 = zze(r0)
            r0.zzw(r13)
            goto L_0x03f0
        L_0x01cb:
            java.lang.String r5 = com.google.android.gms.internal.ads.zzfwa.zza(r5)
            int r6 = r5.hashCode()
            switch(r6) {
                case -618561360: goto L_0x0209;
                case -410956671: goto L_0x01ff;
                case -250518009: goto L_0x01f5;
                case -136074796: goto L_0x01eb;
                case 3016401: goto L_0x01e1;
                case 3556653: goto L_0x01d7;
                default: goto L_0x01d6;
            }
        L_0x01d6:
            goto L_0x0212
        L_0x01d7:
            java.lang.String r6 = "text"
            boolean r5 = r5.equals(r6)
            if (r5 == 0) goto L_0x0212
            r10 = r11
            goto L_0x0212
        L_0x01e1:
            java.lang.String r6 = "base"
            boolean r5 = r5.equals(r6)
            if (r5 == 0) goto L_0x0212
            r10 = r13
            goto L_0x0212
        L_0x01eb:
            java.lang.String r6 = "textContainer"
            boolean r5 = r5.equals(r6)
            if (r5 == 0) goto L_0x0212
            r10 = r9
            goto L_0x0212
        L_0x01f5:
            java.lang.String r6 = "delimiter"
            boolean r5 = r5.equals(r6)
            if (r5 == 0) goto L_0x0212
            r10 = r8
            goto L_0x0212
        L_0x01ff:
            java.lang.String r6 = "container"
            boolean r5 = r5.equals(r6)
            if (r5 == 0) goto L_0x0212
            r10 = r3
            goto L_0x0212
        L_0x0209:
            java.lang.String r6 = "baseContainer"
            boolean r5 = r5.equals(r6)
            if (r5 == 0) goto L_0x0212
            r10 = r12
        L_0x0212:
            if (r10 == 0) goto L_0x023b
            if (r10 == r13) goto L_0x0232
            if (r10 == r12) goto L_0x0232
            if (r10 == r11) goto L_0x0229
            if (r10 == r9) goto L_0x0229
            if (r10 == r8) goto L_0x0220
            goto L_0x03f0
        L_0x0220:
            com.google.android.gms.internal.ads.zzall r0 = zze(r0)
            r0.zzx(r9)
            goto L_0x03f0
        L_0x0229:
            com.google.android.gms.internal.ads.zzall r0 = zze(r0)
            r0.zzx(r11)
            goto L_0x03f0
        L_0x0232:
            com.google.android.gms.internal.ads.zzall r0 = zze(r0)
            r0.zzx(r12)
            goto L_0x03f0
        L_0x023b:
            com.google.android.gms.internal.ads.zzall r0 = zze(r0)
            r0.zzx(r13)
            goto L_0x03f0
        L_0x0244:
            java.lang.String r5 = com.google.android.gms.internal.ads.zzfwa.zza(r5)
            int r6 = r5.hashCode()
            r7 = 96673(0x179a1, float:1.35468E-40)
            if (r6 == r7) goto L_0x0261
            r7 = 3387192(0x33af38, float:4.746467E-39)
            if (r6 == r7) goto L_0x0257
            goto L_0x026a
        L_0x0257:
            java.lang.String r6 = "none"
            boolean r5 = r5.equals(r6)
            if (r5 == 0) goto L_0x026a
            r10 = r3
            goto L_0x026a
        L_0x0261:
            java.lang.String r6 = "all"
            boolean r5 = r5.equals(r6)
            if (r5 == 0) goto L_0x026a
            r10 = r13
        L_0x026a:
            if (r10 == 0) goto L_0x0279
            if (r10 == r13) goto L_0x0270
            goto L_0x03f0
        L_0x0270:
            com.google.android.gms.internal.ads.zzall r0 = zze(r0)
            r0.zzA(r13)
            goto L_0x03f0
        L_0x0279:
            com.google.android.gms.internal.ads.zzall r0 = zze(r0)
            r0.zzA(r3)
            goto L_0x03f0
        L_0x0282:
            com.google.android.gms.internal.ads.zzall r0 = zze(r0)
            android.text.Layout$Alignment r5 = zzd(r5)
            r0.zzv(r5)
            goto L_0x03f0
        L_0x028f:
            com.google.android.gms.internal.ads.zzall r0 = zze(r0)
            android.text.Layout$Alignment r5 = zzd(r5)
            r0.zzz(r5)
            goto L_0x03f0
        L_0x029c:
            com.google.android.gms.internal.ads.zzall r0 = zze(r0)
            java.lang.String r6 = "italic"
            boolean r5 = r6.equalsIgnoreCase(r5)
            r0.zzt(r5)
            goto L_0x03f0
        L_0x02ab:
            com.google.android.gms.internal.ads.zzall r0 = zze(r0)
            java.lang.String r6 = "bold"
            boolean r5 = r6.equalsIgnoreCase(r5)
            r0.zzn(r5)
            goto L_0x03f0
        L_0x02ba:
            com.google.android.gms.internal.ads.zzall r0 = zze(r0)     // Catch:{ zzake -> 0x0393 }
            java.lang.String r6 = "\\s+"
            int r8 = com.google.android.gms.internal.ads.zzen.zza     // Catch:{ zzake -> 0x0393 }
            java.lang.String[] r6 = r5.split(r6, r10)     // Catch:{ zzake -> 0x0393 }
            int r8 = r6.length     // Catch:{ zzake -> 0x0393 }
            if (r8 != r13) goto L_0x02d0
            java.util.regex.Pattern r6 = zze     // Catch:{ zzake -> 0x0393 }
            java.util.regex.Matcher r6 = r6.matcher(r5)     // Catch:{ zzake -> 0x0393 }
            goto L_0x02df
        L_0x02d0:
            if (r8 != r12) goto L_0x0377
            java.util.regex.Pattern r8 = zze     // Catch:{ zzake -> 0x0393 }
            r6 = r6[r13]     // Catch:{ zzake -> 0x0393 }
            java.util.regex.Matcher r6 = r8.matcher(r6)     // Catch:{ zzake -> 0x0393 }
            java.lang.String r8 = "Multiple values in fontSize attribute. Picking the second value for vertical font size and ignoring the first."
            com.google.android.gms.internal.ads.zzdt.zzf(r14, r8)     // Catch:{ zzake -> 0x0393 }
        L_0x02df:
            boolean r8 = r6.matches()     // Catch:{ zzake -> 0x0393 }
            java.lang.String r9 = "'."
            if (r8 == 0) goto L_0x035d
            java.lang.String r8 = r6.group(r11)     // Catch:{ zzake -> 0x0393 }
            if (r8 == 0) goto L_0x035c
            r15 = r8
            java.lang.String r15 = (java.lang.String) r15     // Catch:{ zzake -> 0x0393 }
            int r15 = r8.hashCode()     // Catch:{ zzake -> 0x0393 }
            r3 = 37
            if (r15 == r3) goto L_0x0315
            r3 = 3240(0xca8, float:4.54E-42)
            if (r15 == r3) goto L_0x030b
            r3 = 3592(0xe08, float:5.033E-42)
            if (r15 == r3) goto L_0x0301
            goto L_0x031e
        L_0x0301:
            java.lang.String r3 = "px"
            boolean r3 = r8.equals(r3)
            if (r3 == 0) goto L_0x031e
            r10 = 0
            goto L_0x031e
        L_0x030b:
            java.lang.String r3 = "em"
            boolean r3 = r8.equals(r3)
            if (r3 == 0) goto L_0x031e
            r10 = r13
            goto L_0x031e
        L_0x0315:
            java.lang.String r3 = "%"
            boolean r3 = r8.equals(r3)
            if (r3 == 0) goto L_0x031e
            r10 = r12
        L_0x031e:
            if (r10 == 0) goto L_0x0346
            if (r10 == r13) goto L_0x0342
            if (r10 != r12) goto L_0x0328
            r0.zzr(r11)     // Catch:{ zzake -> 0x0393 }
            goto L_0x0349
        L_0x0328:
            com.google.android.gms.internal.ads.zzake r3 = new com.google.android.gms.internal.ads.zzake     // Catch:{ zzake -> 0x0393 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ zzake -> 0x0393 }
            r6.<init>()     // Catch:{ zzake -> 0x0393 }
            java.lang.String r7 = "Invalid unit for fontSize: '"
            r6.append(r7)     // Catch:{ zzake -> 0x0393 }
            r6.append(r8)     // Catch:{ zzake -> 0x0393 }
            r6.append(r9)     // Catch:{ zzake -> 0x0393 }
            java.lang.String r6 = r6.toString()     // Catch:{ zzake -> 0x0393 }
            r3.<init>(r6)     // Catch:{ zzake -> 0x0393 }
            throw r3     // Catch:{ zzake -> 0x0393 }
        L_0x0342:
            r0.zzr(r12)     // Catch:{ zzake -> 0x0393 }
            goto L_0x0349
        L_0x0346:
            r0.zzr(r13)     // Catch:{ zzake -> 0x0393 }
        L_0x0349:
            java.lang.String r3 = r6.group(r13)     // Catch:{ zzake -> 0x0393 }
            if (r3 == 0) goto L_0x035b
            r6 = r3
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ zzake -> 0x0393 }
            float r3 = java.lang.Float.parseFloat(r3)     // Catch:{ zzake -> 0x0393 }
            r0.zzq(r3)     // Catch:{ zzake -> 0x0393 }
            goto L_0x03f0
        L_0x035b:
            throw r7     // Catch:{ zzake -> 0x0393 }
        L_0x035c:
            throw r7     // Catch:{ zzake -> 0x0393 }
        L_0x035d:
            com.google.android.gms.internal.ads.zzake r3 = new com.google.android.gms.internal.ads.zzake     // Catch:{ zzake -> 0x0393 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ zzake -> 0x0393 }
            r6.<init>()     // Catch:{ zzake -> 0x0393 }
            java.lang.String r7 = "Invalid expression for fontSize: '"
            r6.append(r7)     // Catch:{ zzake -> 0x0393 }
            r6.append(r5)     // Catch:{ zzake -> 0x0393 }
            r6.append(r9)     // Catch:{ zzake -> 0x0393 }
            java.lang.String r6 = r6.toString()     // Catch:{ zzake -> 0x0393 }
            r3.<init>(r6)     // Catch:{ zzake -> 0x0393 }
            throw r3     // Catch:{ zzake -> 0x0393 }
        L_0x0377:
            com.google.android.gms.internal.ads.zzake r3 = new com.google.android.gms.internal.ads.zzake     // Catch:{ zzake -> 0x0393 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ zzake -> 0x0393 }
            r6.<init>()     // Catch:{ zzake -> 0x0393 }
            java.lang.String r7 = "Invalid number of entries for fontSize: "
            r6.append(r7)     // Catch:{ zzake -> 0x0393 }
            r6.append(r8)     // Catch:{ zzake -> 0x0393 }
            java.lang.String r7 = "."
            r6.append(r7)     // Catch:{ zzake -> 0x0393 }
            java.lang.String r6 = r6.toString()     // Catch:{ zzake -> 0x0393 }
            r3.<init>(r6)     // Catch:{ zzake -> 0x0393 }
            throw r3     // Catch:{ zzake -> 0x0393 }
        L_0x0393:
            java.lang.String r3 = java.lang.String.valueOf(r5)
            java.lang.String r5 = "Failed parsing fontSize value: "
            java.lang.String r3 = r5.concat(r3)
            com.google.android.gms.internal.ads.zzdt.zzf(r14, r3)
            goto L_0x03f0
        L_0x03a1:
            com.google.android.gms.internal.ads.zzall r0 = zze(r0)
            r0.zzp(r5)
            goto L_0x03f0
        L_0x03a9:
            com.google.android.gms.internal.ads.zzall r0 = zze(r0)
            int r3 = com.google.android.gms.internal.ads.zzde.zzb(r5)     // Catch:{ IllegalArgumentException -> 0x03b5 }
            r0.zzo(r3)     // Catch:{ IllegalArgumentException -> 0x03b5 }
            goto L_0x03f0
        L_0x03b5:
            java.lang.String r3 = java.lang.String.valueOf(r5)
            java.lang.String r5 = "Failed parsing color value: "
            java.lang.String r3 = r5.concat(r3)
            com.google.android.gms.internal.ads.zzdt.zzf(r14, r3)
            goto L_0x03f0
        L_0x03c3:
            com.google.android.gms.internal.ads.zzall r0 = zze(r0)
            int r3 = com.google.android.gms.internal.ads.zzde.zzb(r5)     // Catch:{ IllegalArgumentException -> 0x03cf }
            r0.zzm(r3)     // Catch:{ IllegalArgumentException -> 0x03cf }
            goto L_0x03f0
        L_0x03cf:
            java.lang.String r3 = java.lang.String.valueOf(r5)
            java.lang.String r5 = "Failed parsing background value: "
            java.lang.String r3 = r5.concat(r3)
            com.google.android.gms.internal.ads.zzdt.zzf(r14, r3)
            goto L_0x03f0
        L_0x03dd:
            java.lang.String r3 = r1.getName()
            java.lang.String r6 = "style"
            boolean r3 = r6.equals(r3)
            if (r3 == 0) goto L_0x03f0
            com.google.android.gms.internal.ads.zzall r0 = zze(r0)
            r0.zzs(r5)
        L_0x03f0:
            int r4 = r4 + 1
            r3 = 0
            goto L_0x000a
        L_0x03f5:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzali.zzf(org.xmlpull.v1.XmlPullParser, com.google.android.gms.internal.ads.zzall):com.google.android.gms.internal.ads.zzall");
    }

    private static String[] zzg(String str) {
        String trim = str.trim();
        if (trim.isEmpty()) {
            return new String[0];
        }
        int i = zzen.zza;
        return trim.split("\\s+", -1);
    }

    public final void zza(byte[] bArr, int i, int i2, zzakh zzakh, zzdg zzdg) {
        zzakc.zza(zzb(bArr, i, i2), zzakh, zzdg);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v4, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v9, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v61, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v65, resolved type: int} */
    /* JADX WARNING: type inference failed for: r43v1, types: [java.lang.Throwable] */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x01ec A[SYNTHETIC, Splitter:B:104:0x01ec] */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x027c A[Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }, LOOP:1: B:137:0x027c->B:305:0x050b, LOOP_START, PHI: r1 r5 r9 
      PHI: (r1v29 java.lang.String) = (r1v19 java.lang.String), (r1v30 java.lang.String) binds: [B:136:0x027a, B:305:0x050b] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r5v23 java.util.HashMap) = (r5v1 java.util.HashMap), (r5v24 java.util.HashMap) binds: [B:136:0x027a, B:305:0x050b] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r9v7 java.util.ArrayDeque) = (r9v3 java.util.ArrayDeque), (r9v8 java.util.ArrayDeque) binds: [B:136:0x027a, B:305:0x050b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARNING: Removed duplicated region for block: B:244:0x0443  */
    /* JADX WARNING: Removed duplicated region for block: B:247:0x044e  */
    /* JADX WARNING: Removed duplicated region for block: B:253:0x0467 A[Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:273:0x04a3  */
    /* JADX WARNING: Removed duplicated region for block: B:276:0x04aa  */
    /* JADX WARNING: Removed duplicated region for block: B:305:0x050b A[LOOP:1: B:137:0x027c->B:305:0x050b, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:306:0x0513  */
    /* JADX WARNING: Removed duplicated region for block: B:463:0x0507 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x018e A[Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzakd zzb(byte[] r41, int r42, int r43) {
        /*
            r40 = this;
            java.lang.String r1 = ""
            java.lang.String r2 = "http://www.w3.org/ns/ttml#parameter"
            r3 = r40
            org.xmlpull.v1.XmlPullParserFactory r0 = r3.zzi     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            org.xmlpull.v1.XmlPullParser r4 = r0.newPullParser()     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            java.util.HashMap r5 = new java.util.HashMap     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            r5.<init>()     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            java.util.HashMap r6 = new java.util.HashMap     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            r6.<init>()     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            java.util.HashMap r7 = new java.util.HashMap     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            r7.<init>()     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            com.google.android.gms.internal.ads.zzalj r8 = new com.google.android.gms.internal.ads.zzalj     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            java.lang.String r9 = ""
            r10 = -8388609(0xffffffffff7fffff, float:-3.4028235E38)
            r12 = -2147483648(0xffffffff80000000, float:-0.0)
            r11 = r10
            r13 = r12
            r14 = r10
            r15 = r10
            r16 = r12
            r17 = r10
            r18 = r12
            r8.<init>(r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            r6.put(r1, r8)     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            java.io.ByteArrayInputStream r0 = new java.io.ByteArrayInputStream     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            r8 = r41
            r9 = r42
            r10 = r43
            r0.<init>(r8, r9, r10)     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            r8 = 0
            r4.setInput(r0, r8)     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            java.util.ArrayDeque r9 = new java.util.ArrayDeque     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            r9.<init>()     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            int r0 = r4.getEventType()     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            com.google.android.gms.internal.ads.zzalg r10 = zzh     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            r13 = r8
            r15 = r13
            r14 = 0
            r16 = 15
        L_0x0053:
            r11 = 1
            if (r0 == r11) goto L_0x06b9
            java.lang.Object r17 = r9.peek()     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            r42 = 0
            r12 = r17
            com.google.android.gms.internal.ads.zzalf r12 = (com.google.android.gms.internal.ads.zzalf) r12     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            r43 = r8
            r8 = 2
            if (r14 != 0) goto L_0x068b
            r18 = r11
            java.lang.String r11 = r4.getName()     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            r19 = r1
            java.lang.String r1 = "tt"
            if (r0 != r8) goto L_0x063f
            boolean r0 = r1.equals(r11)     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            r20 = 1065353216(0x3f800000, float:1.0)
            r3 = -1
            java.lang.String r8 = "TtmlParser"
            if (r0 == 0) goto L_0x01d6
            java.lang.String r0 = "frameRate"
            java.lang.String r0 = r4.getAttributeValue(r2, r0)     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            if (r0 == 0) goto L_0x0089
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            goto L_0x008b
        L_0x0089:
            r0 = 30
        L_0x008b:
            java.lang.String r10 = "frameRateMultiplier"
            java.lang.String r10 = r4.getAttributeValue(r2, r10)     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            java.lang.String r15 = " "
            if (r10 == 0) goto L_0x00bb
            int r16 = com.google.android.gms.internal.ads.zzen.zza     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            java.lang.String[] r10 = r10.split(r15, r3)     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            int r3 = r10.length     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            r16 = r10
            r10 = 2
            if (r3 != r10) goto L_0x00a4
            r3 = r18
            goto L_0x00a6
        L_0x00a4:
            r3 = r42
        L_0x00a6:
            java.lang.String r10 = "frameRateMultiplier doesn't have 2 parts"
            com.google.android.gms.internal.ads.zzdb.zze(r3, r10)     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            r3 = r16[r42]     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            int r3 = java.lang.Integer.parseInt(r3)     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            float r3 = (float) r3     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            r10 = r16[r18]     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            int r10 = java.lang.Integer.parseInt(r10)     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            float r10 = (float) r10     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            float r3 = r3 / r10
            goto L_0x00bd
        L_0x00bb:
            r3 = r20
        L_0x00bd:
            com.google.android.gms.internal.ads.zzalg r10 = zzh     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            r16 = r3
            int r3 = r10.zzb     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            r22 = r3
            java.lang.String r3 = "subFrameRate"
            java.lang.String r3 = r4.getAttributeValue(r2, r3)     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            if (r3 == 0) goto L_0x00d2
            int r3 = java.lang.Integer.parseInt(r3)     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            goto L_0x00d4
        L_0x00d2:
            r3 = r22
        L_0x00d4:
            int r10 = r10.zzc     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            r22 = r10
            java.lang.String r10 = "tickRate"
            java.lang.String r10 = r4.getAttributeValue(r2, r10)     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            if (r10 == 0) goto L_0x00e5
            int r10 = java.lang.Integer.parseInt(r10)     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            goto L_0x00e7
        L_0x00e5:
            r10 = r22
        L_0x00e7:
            r22 = r13
            com.google.android.gms.internal.ads.zzalg r13 = new com.google.android.gms.internal.ads.zzalg     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            float r0 = (float) r0     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            float r0 = r0 * r16
            r13.<init>(r0, r3, r10)     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            java.lang.String r0 = "cellResolution"
            java.lang.String r0 = r4.getAttributeValue(r2, r0)     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            if (r0 != 0) goto L_0x0103
        L_0x00f9:
            r23 = r2
            r16 = r13
            r24 = r14
        L_0x00ff:
            r2 = 15
            goto L_0x0183
        L_0x0103:
            java.util.regex.Pattern r3 = zzg     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            java.util.regex.Matcher r3 = r3.matcher(r0)     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            boolean r10 = r3.matches()     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            if (r10 != 0) goto L_0x0119
            java.lang.String r3 = "Ignoring malformed cell resolution: "
            java.lang.String r0 = r3.concat(r0)     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            com.google.android.gms.internal.ads.zzdt.zzf(r8, r0)     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            goto L_0x00f9
        L_0x0119:
            r10 = r18
            java.lang.String r16 = r3.group(r10)     // Catch:{ NumberFormatException -> 0x0172 }
            if (r16 == 0) goto L_0x016b
            r10 = r16
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ NumberFormatException -> 0x0172 }
            int r10 = java.lang.Integer.parseInt(r16)     // Catch:{ NumberFormatException -> 0x0172 }
            r23 = r2
            r2 = 2
            java.lang.String r3 = r3.group(r2)     // Catch:{ NumberFormatException -> 0x0174 }
            if (r3 == 0) goto L_0x0166
            r2 = r3
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ NumberFormatException -> 0x0174 }
            int r2 = java.lang.Integer.parseInt(r3)     // Catch:{ NumberFormatException -> 0x0174 }
            if (r10 == 0) goto L_0x0145
            if (r2 == 0) goto L_0x0141
            r16 = r13
            r3 = 1
            goto L_0x0149
        L_0x0141:
            r2 = r42
            r3 = r2
            goto L_0x0147
        L_0x0145:
            r3 = r42
        L_0x0147:
            r16 = r13
        L_0x0149:
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ NumberFormatException -> 0x0176 }
            r13.<init>()     // Catch:{ NumberFormatException -> 0x0176 }
            r24 = r14
            java.lang.String r14 = "Invalid cell resolution "
            r13.append(r14)     // Catch:{ NumberFormatException -> 0x0178 }
            r13.append(r10)     // Catch:{ NumberFormatException -> 0x0178 }
            r13.append(r15)     // Catch:{ NumberFormatException -> 0x0178 }
            r13.append(r2)     // Catch:{ NumberFormatException -> 0x0178 }
            java.lang.String r10 = r13.toString()     // Catch:{ NumberFormatException -> 0x0178 }
            com.google.android.gms.internal.ads.zzdb.zze(r3, r10)     // Catch:{ NumberFormatException -> 0x0178 }
            goto L_0x0183
        L_0x0166:
            r16 = r13
            r24 = r14
            throw r43     // Catch:{ NumberFormatException -> 0x0178 }
        L_0x016b:
            r23 = r2
            r16 = r13
            r24 = r14
            throw r43     // Catch:{ NumberFormatException -> 0x0178 }
        L_0x0172:
            r23 = r2
        L_0x0174:
            r16 = r13
        L_0x0176:
            r24 = r14
        L_0x0178:
            java.lang.String r2 = "Ignoring malformed cell resolution: "
            java.lang.String r0 = r2.concat(r0)     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            com.google.android.gms.internal.ads.zzdt.zzf(r8, r0)     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            goto L_0x00ff
        L_0x0183:
            java.lang.String r0 = "extent"
            java.lang.String r0 = com.google.android.gms.internal.ads.zzeo.zza(r4, r0)     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            if (r0 != 0) goto L_0x018e
        L_0x018b:
            r15 = r43
            goto L_0x01d3
        L_0x018e:
            java.util.regex.Pattern r3 = zzf     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            java.util.regex.Matcher r3 = r3.matcher(r0)     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            boolean r10 = r3.matches()     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            if (r10 != 0) goto L_0x01a4
            java.lang.String r3 = "Ignoring non-pixel tts extent: "
            java.lang.String r0 = r3.concat(r0)     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            com.google.android.gms.internal.ads.zzdt.zzf(r8, r0)     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            goto L_0x018b
        L_0x01a4:
            r10 = 1
            java.lang.String r13 = r3.group(r10)     // Catch:{ NumberFormatException -> 0x01c9 }
            if (r13 == 0) goto L_0x01c8
            r10 = r13
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ NumberFormatException -> 0x01c9 }
            int r10 = java.lang.Integer.parseInt(r13)     // Catch:{ NumberFormatException -> 0x01c9 }
            r13 = 2
            java.lang.String r3 = r3.group(r13)     // Catch:{ NumberFormatException -> 0x01c9 }
            if (r3 == 0) goto L_0x01c7
            r13 = r3
            java.lang.String r13 = (java.lang.String) r13     // Catch:{ NumberFormatException -> 0x01c9 }
            int r3 = java.lang.Integer.parseInt(r3)     // Catch:{ NumberFormatException -> 0x01c9 }
            com.google.android.gms.internal.ads.zzalh r13 = new com.google.android.gms.internal.ads.zzalh     // Catch:{ NumberFormatException -> 0x01c9 }
            r13.<init>(r10, r3)     // Catch:{ NumberFormatException -> 0x01c9 }
            r15 = r13
            goto L_0x01d3
        L_0x01c7:
            throw r43     // Catch:{ NumberFormatException -> 0x01c9 }
        L_0x01c8:
            throw r43     // Catch:{ NumberFormatException -> 0x01c9 }
        L_0x01c9:
            java.lang.String r3 = "Ignoring malformed tts extent: "
            java.lang.String r0 = r3.concat(r0)     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            com.google.android.gms.internal.ads.zzdt.zzf(r8, r0)     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            goto L_0x018b
        L_0x01d3:
            r10 = r16
            goto L_0x01de
        L_0x01d6:
            r23 = r2
            r22 = r13
            r24 = r14
            r2 = r16
        L_0x01de:
            boolean r0 = r11.equals(r1)     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            java.lang.String r1 = "metadata"
            java.lang.String r3 = "region"
            java.lang.String r13 = "head"
            java.lang.String r14 = "style"
            if (r0 != 0) goto L_0x0276
            boolean r0 = r11.equals(r13)     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            if (r0 != 0) goto L_0x0276
            java.lang.String r0 = "body"
            boolean r0 = r11.equals(r0)     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            if (r0 != 0) goto L_0x0276
            java.lang.String r0 = "div"
            boolean r0 = r11.equals(r0)     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            if (r0 != 0) goto L_0x0276
            java.lang.String r0 = "p"
            boolean r0 = r11.equals(r0)     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            if (r0 != 0) goto L_0x0276
            java.lang.String r0 = "span"
            boolean r0 = r11.equals(r0)     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            if (r0 != 0) goto L_0x0276
            java.lang.String r0 = "br"
            boolean r0 = r11.equals(r0)     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            if (r0 != 0) goto L_0x0276
            boolean r0 = r11.equals(r14)     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            if (r0 != 0) goto L_0x0276
            java.lang.String r0 = "styling"
            boolean r0 = r11.equals(r0)     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            if (r0 != 0) goto L_0x0276
            java.lang.String r0 = "layout"
            boolean r0 = r11.equals(r0)     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            if (r0 != 0) goto L_0x0276
            boolean r0 = r11.equals(r3)     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            if (r0 != 0) goto L_0x0276
            boolean r0 = r11.equals(r1)     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            if (r0 != 0) goto L_0x0276
            java.lang.String r0 = "image"
            boolean r0 = r11.equals(r0)     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            if (r0 != 0) goto L_0x0276
            java.lang.String r0 = "data"
            boolean r0 = r11.equals(r0)     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            if (r0 != 0) goto L_0x0276
            java.lang.String r0 = "information"
            boolean r0 = r11.equals(r0)     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            if (r0 == 0) goto L_0x0255
            goto L_0x0276
        L_0x0255:
            java.lang.String r0 = r4.getName()     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            r1.<init>()     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            java.lang.String r3 = "Ignoring unsupported tag: "
            r1.append(r3)     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            r1.append(r0)     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            java.lang.String r0 = r1.toString()     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            com.google.android.gms.internal.ads.zzdt.zze(r8, r0)     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            r16 = r2
            r1 = r5
            r3 = r9
            r13 = r22
            r14 = 1
            goto L_0x06a7
        L_0x0276:
            boolean r0 = r13.equals(r11)     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            if (r0 == 0) goto L_0x0513
        L_0x027c:
            r4.next()     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            boolean r0 = com.google.android.gms.internal.ads.zzeo.zzc(r4, r14)     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            if (r0 == 0) goto L_0x02bb
            java.lang.String r0 = com.google.android.gms.internal.ads.zzeo.zza(r4, r14)     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            com.google.android.gms.internal.ads.zzall r11 = new com.google.android.gms.internal.ads.zzall     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            r11.<init>()     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            com.google.android.gms.internal.ads.zzall r11 = zzf(r4, r11)     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            if (r0 == 0) goto L_0x02af
            java.lang.String[] r0 = zzg(r0)     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            int r12 = r0.length     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            r25 = r9
            r9 = r42
        L_0x029d:
            if (r9 >= r12) goto L_0x02b1
            r16 = r9
            r9 = r0[r16]     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            java.lang.Object r9 = r5.get(r9)     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            com.google.android.gms.internal.ads.zzall r9 = (com.google.android.gms.internal.ads.zzall) r9     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            r11.zzl(r9)     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            int r9 = r16 + 1
            goto L_0x029d
        L_0x02af:
            r25 = r9
        L_0x02b1:
            java.lang.String r0 = r11.zzE()     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            if (r0 == 0) goto L_0x02e9
            r5.put(r0, r11)     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            goto L_0x02e9
        L_0x02bb:
            r25 = r9
            boolean r0 = com.google.android.gms.internal.ads.zzeo.zzc(r4, r3)     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            java.lang.String r9 = "id"
            if (r0 != 0) goto L_0x02ef
            boolean r0 = com.google.android.gms.internal.ads.zzeo.zzc(r4, r1)     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            if (r0 == 0) goto L_0x02e9
        L_0x02cb:
            r4.next()     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            java.lang.String r0 = "image"
            boolean r0 = com.google.android.gms.internal.ads.zzeo.zzc(r4, r0)     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            if (r0 == 0) goto L_0x02e3
            java.lang.String r0 = com.google.android.gms.internal.ads.zzeo.zza(r4, r9)     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            if (r0 == 0) goto L_0x02e3
            java.lang.String r11 = r4.nextText()     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            r7.put(r0, r11)     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
        L_0x02e3:
            boolean r0 = com.google.android.gms.internal.ads.zzeo.zzb(r4, r1)     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            if (r0 == 0) goto L_0x02cb
        L_0x02e9:
            r16 = r1
            r37 = r5
            goto L_0x0501
        L_0x02ef:
            java.lang.String r27 = com.google.android.gms.internal.ads.zzeo.zza(r4, r9)     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            if (r27 != 0) goto L_0x02fd
            r0 = r43
            r16 = r1
            r37 = r5
            goto L_0x04fa
        L_0x02fd:
            java.lang.String r0 = "origin"
            java.lang.String r0 = com.google.android.gms.internal.ads.zzeo.zza(r4, r0)     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            if (r0 == 0) goto L_0x04ef
            java.util.regex.Pattern r9 = zzb     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            java.util.regex.Matcher r11 = r9.matcher(r0)     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            java.util.regex.Pattern r12 = zzf     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            r16 = r1
            java.util.regex.Matcher r1 = r12.matcher(r0)     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            boolean r17 = r11.matches()     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            r21 = 1120403456(0x42c80000, float:100.0)
            if (r17 == 0) goto L_0x034d
            r37 = r5
            r5 = 1
            java.lang.String r1 = r11.group(r5)     // Catch:{ NumberFormatException -> 0x0342 }
            if (r1 == 0) goto L_0x0341
            r5 = r1
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ NumberFormatException -> 0x0342 }
            float r1 = java.lang.Float.parseFloat(r1)     // Catch:{ NumberFormatException -> 0x0342 }
            float r1 = r1 / r21
            r5 = 2
            java.lang.String r11 = r11.group(r5)     // Catch:{ NumberFormatException -> 0x0342 }
            if (r11 == 0) goto L_0x0340
            r5 = r11
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ NumberFormatException -> 0x0342 }
            float r5 = java.lang.Float.parseFloat(r11)     // Catch:{ NumberFormatException -> 0x0342 }
            float r5 = r5 / r21
            r28 = r1
            goto L_0x038b
        L_0x0340:
            throw r43     // Catch:{ NumberFormatException -> 0x0342 }
        L_0x0341:
            throw r43     // Catch:{ NumberFormatException -> 0x0342 }
        L_0x0342:
            java.lang.String r1 = "Ignoring region with malformed origin: "
            java.lang.String r0 = r1.concat(r0)     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            com.google.android.gms.internal.ads.zzdt.zzf(r8, r0)     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            goto L_0x04f8
        L_0x034d:
            r37 = r5
            boolean r5 = r1.matches()     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            if (r5 == 0) goto L_0x04e5
            if (r15 != 0) goto L_0x0362
            java.lang.String r1 = "Ignoring region with missing tts:extent: "
            java.lang.String r0 = r1.concat(r0)     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            com.google.android.gms.internal.ads.zzdt.zzf(r8, r0)     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            goto L_0x04f8
        L_0x0362:
            r5 = 1
            java.lang.String r11 = r1.group(r5)     // Catch:{ NumberFormatException -> 0x04db }
            if (r11 == 0) goto L_0x04da
            r5 = r11
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ NumberFormatException -> 0x04db }
            int r5 = java.lang.Integer.parseInt(r11)     // Catch:{ NumberFormatException -> 0x04db }
            r11 = 2
            java.lang.String r1 = r1.group(r11)     // Catch:{ NumberFormatException -> 0x04db }
            if (r1 == 0) goto L_0x04d9
            r11 = r1
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ NumberFormatException -> 0x04db }
            int r1 = java.lang.Integer.parseInt(r1)     // Catch:{ NumberFormatException -> 0x04db }
            float r5 = (float) r5     // Catch:{ NumberFormatException -> 0x04db }
            int r11 = r15.zza     // Catch:{ NumberFormatException -> 0x04db }
            float r11 = (float) r11     // Catch:{ NumberFormatException -> 0x04db }
            float r5 = r5 / r11
            float r1 = (float) r1     // Catch:{ NumberFormatException -> 0x04db }
            int r11 = r15.zzb     // Catch:{ NumberFormatException -> 0x04db }
            float r11 = (float) r11
            float r1 = r1 / r11
            r28 = r5
            r5 = r1
        L_0x038b:
            java.lang.String r1 = "extent"
            java.lang.String r1 = com.google.android.gms.internal.ads.zzeo.zza(r4, r1)     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            if (r1 == 0) goto L_0x04d3
            java.util.regex.Matcher r9 = r9.matcher(r1)     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            java.util.regex.Matcher r1 = r12.matcher(r1)     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            boolean r11 = r9.matches()     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            if (r11 == 0) goto L_0x03d3
            r11 = 1
            java.lang.String r1 = r9.group(r11)     // Catch:{ NumberFormatException -> 0x03c8 }
            if (r1 == 0) goto L_0x03c7
            r11 = r1
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ NumberFormatException -> 0x03c8 }
            float r1 = java.lang.Float.parseFloat(r1)     // Catch:{ NumberFormatException -> 0x03c8 }
            float r1 = r1 / r21
            r11 = 2
            java.lang.String r9 = r9.group(r11)     // Catch:{ NumberFormatException -> 0x03c8 }
            if (r9 == 0) goto L_0x03c6
            r11 = r9
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ NumberFormatException -> 0x03c8 }
            float r0 = java.lang.Float.parseFloat(r9)     // Catch:{ NumberFormatException -> 0x03c8 }
            float r0 = r0 / r21
            r32 = r1
        L_0x03c3:
            r33 = r0
            goto L_0x0410
        L_0x03c6:
            throw r43     // Catch:{ NumberFormatException -> 0x03c8 }
        L_0x03c7:
            throw r43     // Catch:{ NumberFormatException -> 0x03c8 }
        L_0x03c8:
            java.lang.String r1 = "Ignoring region with malformed extent: "
            java.lang.String r0 = r1.concat(r0)     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            com.google.android.gms.internal.ads.zzdt.zzf(r8, r0)     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            goto L_0x04f8
        L_0x03d3:
            boolean r9 = r1.matches()     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            if (r9 == 0) goto L_0x04c9
            if (r15 != 0) goto L_0x03e6
            java.lang.String r1 = "Ignoring region with missing tts:extent: "
            java.lang.String r0 = r1.concat(r0)     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            com.google.android.gms.internal.ads.zzdt.zzf(r8, r0)     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            goto L_0x04f8
        L_0x03e6:
            r11 = 1
            java.lang.String r9 = r1.group(r11)     // Catch:{ NumberFormatException -> 0x04bf }
            if (r9 == 0) goto L_0x04be
            r11 = r9
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ NumberFormatException -> 0x04bf }
            int r9 = java.lang.Integer.parseInt(r9)     // Catch:{ NumberFormatException -> 0x04bf }
            r11 = 2
            java.lang.String r1 = r1.group(r11)     // Catch:{ NumberFormatException -> 0x04bf }
            if (r1 == 0) goto L_0x04bd
            r11 = r1
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ NumberFormatException -> 0x04bf }
            int r1 = java.lang.Integer.parseInt(r1)     // Catch:{ NumberFormatException -> 0x04bf }
            float r9 = (float) r9     // Catch:{ NumberFormatException -> 0x04bf }
            int r11 = r15.zza     // Catch:{ NumberFormatException -> 0x04bf }
            float r11 = (float) r11     // Catch:{ NumberFormatException -> 0x04bf }
            float r9 = r9 / r11
            float r1 = (float) r1     // Catch:{ NumberFormatException -> 0x04bf }
            int r0 = r15.zzb     // Catch:{ NumberFormatException -> 0x04bf }
            float r0 = (float) r0
            float r0 = r1 / r0
            r32 = r9
            goto L_0x03c3
        L_0x0410:
            java.lang.String r0 = "displayAlign"
            java.lang.String r0 = com.google.android.gms.internal.ads.zzeo.zza(r4, r0)     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            if (r0 == 0) goto L_0x0458
            java.lang.String r0 = com.google.android.gms.internal.ads.zzfwa.zza(r0)     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            int r1 = r0.hashCode()     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            r9 = -1364013995(0xffffffffaeb2cc55, float:-8.1307995E-11)
            if (r1 == r9) goto L_0x0435
            r9 = 92734940(0x58705dc, float:1.2697491E-35)
            if (r1 == r9) goto L_0x042b
            goto L_0x0440
        L_0x042b:
            java.lang.String r1 = "after"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0440
            r0 = 1
            goto L_0x0441
        L_0x0435:
            java.lang.String r1 = "center"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0440
            r0 = r42
            goto L_0x0441
        L_0x0440:
            r0 = -1
        L_0x0441:
            if (r0 == 0) goto L_0x044e
            r11 = 1
            if (r0 == r11) goto L_0x0447
            goto L_0x0458
        L_0x0447:
            float r5 = r5 + r33
            r29 = r5
            r31 = 2
            goto L_0x045c
        L_0x044e:
            r0 = 1073741824(0x40000000, float:2.0)
            float r0 = r33 / r0
            float r5 = r5 + r0
            r29 = r5
            r31 = 1
            goto L_0x045c
        L_0x0458:
            r31 = r42
            r29 = r5
        L_0x045c:
            float r0 = (float) r2
            float r35 = r20 / r0
            java.lang.String r0 = "writingMode"
            java.lang.String r0 = com.google.android.gms.internal.ads.zzeo.zza(r4, r0)     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            if (r0 == 0) goto L_0x04ad
            java.lang.String r0 = com.google.android.gms.internal.ads.zzfwa.zza(r0)     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            int r1 = r0.hashCode()     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            r5 = 3694(0xe6e, float:5.176E-42)
            if (r1 == r5) goto L_0x0492
            r5 = 3553396(0x363874, float:4.979368E-39)
            if (r1 == r5) goto L_0x0488
            r5 = 3553576(0x363928, float:4.97962E-39)
            if (r1 == r5) goto L_0x047e
            goto L_0x049d
        L_0x047e:
            java.lang.String r1 = "tbrl"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x049d
            r0 = 2
            goto L_0x049e
        L_0x0488:
            java.lang.String r1 = "tblr"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x049d
            r0 = 1
            goto L_0x049e
        L_0x0492:
            java.lang.String r1 = "tb"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x049d
            r0 = r42
            goto L_0x049e
        L_0x049d:
            r0 = -1
        L_0x049e:
            if (r0 == 0) goto L_0x04aa
            r11 = 1
            if (r0 == r11) goto L_0x04aa
            r11 = 2
            if (r0 == r11) goto L_0x04a7
            goto L_0x04ad
        L_0x04a7:
            r36 = 1
            goto L_0x04b1
        L_0x04aa:
            r36 = 2
            goto L_0x04b1
        L_0x04ad:
            r0 = -2147483648(0xffffffff80000000, float:-0.0)
            r36 = r0
        L_0x04b1:
            com.google.android.gms.internal.ads.zzalj r26 = new com.google.android.gms.internal.ads.zzalj     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            r30 = 0
            r34 = 1
            r26.<init>(r27, r28, r29, r30, r31, r32, r33, r34, r35, r36)     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            r0 = r26
            goto L_0x04fa
        L_0x04bd:
            throw r43     // Catch:{ NumberFormatException -> 0x04bf }
        L_0x04be:
            throw r43     // Catch:{ NumberFormatException -> 0x04bf }
        L_0x04bf:
            java.lang.String r1 = "Ignoring region with malformed extent: "
            java.lang.String r0 = r1.concat(r0)     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            com.google.android.gms.internal.ads.zzdt.zzf(r8, r0)     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            goto L_0x04f8
        L_0x04c9:
            java.lang.String r1 = "Ignoring region with unsupported extent: "
            java.lang.String r0 = r1.concat(r0)     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            com.google.android.gms.internal.ads.zzdt.zzf(r8, r0)     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            goto L_0x04f8
        L_0x04d3:
            java.lang.String r0 = "Ignoring region without an extent"
            com.google.android.gms.internal.ads.zzdt.zzf(r8, r0)     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            goto L_0x04f8
        L_0x04d9:
            throw r43     // Catch:{ NumberFormatException -> 0x04db }
        L_0x04da:
            throw r43     // Catch:{ NumberFormatException -> 0x04db }
        L_0x04db:
            java.lang.String r1 = "Ignoring region with malformed origin: "
            java.lang.String r0 = r1.concat(r0)     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            com.google.android.gms.internal.ads.zzdt.zzf(r8, r0)     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            goto L_0x04f8
        L_0x04e5:
            java.lang.String r1 = "Ignoring region with unsupported origin: "
            java.lang.String r0 = r1.concat(r0)     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            com.google.android.gms.internal.ads.zzdt.zzf(r8, r0)     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            goto L_0x04f8
        L_0x04ef:
            r16 = r1
            r37 = r5
            java.lang.String r0 = "Ignoring region without an origin"
            com.google.android.gms.internal.ads.zzdt.zzf(r8, r0)     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
        L_0x04f8:
            r0 = r43
        L_0x04fa:
            if (r0 == 0) goto L_0x0501
            java.lang.String r1 = r0.zza     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            r6.put(r1, r0)     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
        L_0x0501:
            boolean r0 = com.google.android.gms.internal.ads.zzeo.zzb(r4, r13)     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            if (r0 == 0) goto L_0x050b
            r3 = r25
            goto L_0x0624
        L_0x050b:
            r1 = r16
            r9 = r25
            r5 = r37
            goto L_0x027c
        L_0x0513:
            r37 = r5
            r25 = r9
            int r0 = r4.getAttributeCount()     // Catch:{ zzake -> 0x062d }
            r1 = r43
            com.google.android.gms.internal.ads.zzall r31 = zzf(r4, r1)     // Catch:{ zzake -> 0x062d }
            r26 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r1 = r42
            r33 = r19
            r28 = r26
            r35 = r28
            r38 = r35
            r32 = 0
            r34 = 0
        L_0x0534:
            if (r1 >= r0) goto L_0x05d2
            java.lang.String r5 = r4.getAttributeName(r1)     // Catch:{ zzake -> 0x05cc }
            java.lang.String r9 = r4.getAttributeValue(r1)     // Catch:{ zzake -> 0x05cc }
            int r11 = r5.hashCode()     // Catch:{ zzake -> 0x05cc }
            r13 = 5
            switch(r11) {
                case -934795532: goto L_0x0578;
                case 99841: goto L_0x056e;
                case 100571: goto L_0x0564;
                case 93616297: goto L_0x0559;
                case 109780401: goto L_0x0551;
                case 1292595405: goto L_0x0547;
                default: goto L_0x0546;
            }
        L_0x0546:
            goto L_0x0580
        L_0x0547:
            java.lang.String r11 = "backgroundImage"
            boolean r5 = r5.equals(r11)
            if (r5 == 0) goto L_0x0580
            r5 = r13
            goto L_0x0581
        L_0x0551:
            boolean r5 = r5.equals(r14)
            if (r5 == 0) goto L_0x0580
            r5 = 3
            goto L_0x0581
        L_0x0559:
            java.lang.String r11 = "begin"
            boolean r5 = r5.equals(r11)
            if (r5 == 0) goto L_0x0580
            r5 = r42
            goto L_0x0581
        L_0x0564:
            java.lang.String r11 = "end"
            boolean r5 = r5.equals(r11)
            if (r5 == 0) goto L_0x0580
            r5 = 1
            goto L_0x0581
        L_0x056e:
            java.lang.String r11 = "dur"
            boolean r5 = r5.equals(r11)
            if (r5 == 0) goto L_0x0580
            r5 = 2
            goto L_0x0581
        L_0x0578:
            boolean r5 = r5.equals(r3)
            if (r5 == 0) goto L_0x0580
            r5 = 4
            goto L_0x0581
        L_0x0580:
            r5 = -1
        L_0x0581:
            if (r5 == 0) goto L_0x05c3
            r11 = 1
            if (r5 == r11) goto L_0x05be
            r11 = 2
            if (r5 == r11) goto L_0x05b8
            r11 = 3
            if (r5 == r11) goto L_0x05ad
            r11 = 4
            if (r5 == r11) goto L_0x05a3
            if (r5 == r13) goto L_0x0593
        L_0x0591:
            r11 = 1
            goto L_0x05c8
        L_0x0593:
            java.lang.String r5 = "#"
            boolean r5 = r9.startsWith(r5)     // Catch:{ zzake -> 0x05cc }
            if (r5 == 0) goto L_0x0591
            r11 = 1
            java.lang.String r5 = r9.substring(r11)     // Catch:{ zzake -> 0x05f1 }
            r34 = r5
            goto L_0x05c8
        L_0x05a3:
            r11 = 1
            boolean r5 = r6.containsKey(r9)     // Catch:{ zzake -> 0x05f1 }
            if (r5 == 0) goto L_0x05c8
            r33 = r9
            goto L_0x05c8
        L_0x05ad:
            r11 = 1
            java.lang.String[] r5 = zzg(r9)     // Catch:{ zzake -> 0x05f1 }
            int r9 = r5.length     // Catch:{ zzake -> 0x05f1 }
            if (r9 <= 0) goto L_0x05c8
            r32 = r5
            goto L_0x05c8
        L_0x05b8:
            r11 = 1
            long r38 = zzc(r9, r10)     // Catch:{ zzake -> 0x05f1 }
            goto L_0x05c8
        L_0x05be:
            long r28 = zzc(r9, r10)     // Catch:{ zzake -> 0x05f1 }
            goto L_0x05c8
        L_0x05c3:
            r11 = 1
            long r35 = zzc(r9, r10)     // Catch:{ zzake -> 0x05f1 }
        L_0x05c8:
            int r1 = r1 + 1
            goto L_0x0534
        L_0x05cc:
            r0 = move-exception
            r11 = 1
        L_0x05ce:
            r3 = r25
            goto L_0x0631
        L_0x05d2:
            r11 = 1
            if (r12 == 0) goto L_0x05f3
            long r0 = r12.zzd     // Catch:{ zzake -> 0x05f1 }
            int r3 = (r0 > r26 ? 1 : (r0 == r26 ? 0 : -1))
            if (r3 == 0) goto L_0x05ef
            int r3 = (r35 > r26 ? 1 : (r35 == r26 ? 0 : -1))
            if (r3 == 0) goto L_0x05e2
            long r35 = r35 + r0
            goto L_0x05e4
        L_0x05e2:
            r35 = r26
        L_0x05e4:
            int r3 = (r28 > r26 ? 1 : (r28 == r26 ? 0 : -1))
            if (r3 == 0) goto L_0x05eb
            long r28 = r28 + r0
            goto L_0x05ef
        L_0x05eb:
            r0 = r12
            r28 = r26
            goto L_0x05f4
        L_0x05ef:
            r0 = r12
            goto L_0x05f4
        L_0x05f1:
            r0 = move-exception
            goto L_0x05ce
        L_0x05f3:
            r0 = 0
        L_0x05f4:
            int r1 = (r28 > r26 ? 1 : (r28 == r26 ? 0 : -1))
            if (r1 != 0) goto L_0x060c
            int r1 = (r38 > r26 ? 1 : (r38 == r26 ? 0 : -1))
            if (r1 == 0) goto L_0x0601
            long r26 = r35 + r38
        L_0x05fe:
            r29 = r26
            goto L_0x060e
        L_0x0601:
            if (r0 == 0) goto L_0x05fe
            long r13 = r0.zze     // Catch:{ zzake -> 0x05f1 }
            int r1 = (r13 > r26 ? 1 : (r13 == r26 ? 0 : -1))
            if (r1 == 0) goto L_0x05fe
            r29 = r13
            goto L_0x060e
        L_0x060c:
            r29 = r28
        L_0x060e:
            java.lang.String r26 = r4.getName()     // Catch:{ zzake -> 0x05f1 }
            r27 = r35
            r35 = r0
            com.google.android.gms.internal.ads.zzalf r0 = com.google.android.gms.internal.ads.zzalf.zzb(r26, r27, r29, r31, r32, r33, r34, r35)     // Catch:{ zzake -> 0x05f1 }
            r3 = r25
            r3.push(r0)     // Catch:{ zzake -> 0x062b }
            if (r12 == 0) goto L_0x0624
            r12.zzf(r0)     // Catch:{ zzake -> 0x062b }
        L_0x0624:
            r16 = r2
            r13 = r22
            r14 = r24
            goto L_0x063b
        L_0x062b:
            r0 = move-exception
            goto L_0x0631
        L_0x062d:
            r0 = move-exception
            r3 = r25
            r11 = 1
        L_0x0631:
            java.lang.String r1 = "Suppressing parser error"
            com.google.android.gms.internal.ads.zzdt.zzg(r8, r1, r0)     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            r16 = r2
            r14 = r11
            r13 = r22
        L_0x063b:
            r1 = r37
            goto L_0x06a7
        L_0x063f:
            r23 = r2
            r37 = r5
            r3 = r9
            r22 = r13
            r24 = r14
            r11 = 4
            if (r0 != r11) goto L_0x065e
            if (r12 == 0) goto L_0x065c
            r0 = r12
            com.google.android.gms.internal.ads.zzalf r0 = (com.google.android.gms.internal.ads.zzalf) r0     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            java.lang.String r0 = r4.getText()     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            com.google.android.gms.internal.ads.zzalf r0 = com.google.android.gms.internal.ads.zzalf.zzc(r0)     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            r12.zzf(r0)     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            goto L_0x0688
        L_0x065c:
            r1 = 0
            throw r1     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
        L_0x065e:
            r11 = 3
            if (r0 != r11) goto L_0x0688
            java.lang.String r0 = r4.getName()     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            boolean r0 = r0.equals(r1)     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            if (r0 == 0) goto L_0x0680
            com.google.android.gms.internal.ads.zzalm r13 = new com.google.android.gms.internal.ads.zzalm     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            java.lang.Object r0 = r3.peek()     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            com.google.android.gms.internal.ads.zzalf r0 = (com.google.android.gms.internal.ads.zzalf) r0     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            if (r0 == 0) goto L_0x067e
            r1 = r0
            com.google.android.gms.internal.ads.zzalf r1 = (com.google.android.gms.internal.ads.zzalf) r1     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            r1 = r37
            r13.<init>(r0, r1, r6, r7)     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            goto L_0x0684
        L_0x067e:
            r1 = 0
            throw r1     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
        L_0x0680:
            r1 = r37
            r13 = r22
        L_0x0684:
            r3.pop()     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            goto L_0x06a5
        L_0x0688:
            r1 = r37
            goto L_0x06a3
        L_0x068b:
            r19 = r1
            r23 = r2
            r1 = r5
            r11 = r8
            r3 = r9
            r22 = r13
            r24 = r14
            if (r0 != r11) goto L_0x069d
            int r14 = r24 + 1
        L_0x069a:
            r13 = r22
            goto L_0x06a7
        L_0x069d:
            r11 = 3
            if (r0 != r11) goto L_0x06a3
            int r14 = r24 + -1
            goto L_0x069a
        L_0x06a3:
            r13 = r22
        L_0x06a5:
            r14 = r24
        L_0x06a7:
            r4.next()     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            int r0 = r4.getEventType()     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            r5 = r1
            r9 = r3
            r1 = r19
            r2 = r23
            r8 = 0
            r3 = r40
            goto L_0x0053
        L_0x06b9:
            r22 = r13
            if (r22 == 0) goto L_0x06c2
            r13 = r22
            com.google.android.gms.internal.ads.zzakd r13 = (com.google.android.gms.internal.ads.zzakd) r13     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
            return r13
        L_0x06c2:
            r1 = 0
            throw r1     // Catch:{ XmlPullParserException -> 0x06cd, IOException -> 0x06c4 }
        L_0x06c4:
            r0 = move-exception
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "Unexpected error when reading input."
            r1.<init>(r2, r0)
            throw r1
        L_0x06cd:
            r0 = move-exception
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "Unable to decode source"
            r1.<init>(r2, r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzali.zzb(byte[], int, int):com.google.android.gms.internal.ads.zzakd");
    }

    public zzali() {
        try {
            XmlPullParserFactory newInstance = XmlPullParserFactory.newInstance();
            this.zzi = newInstance;
            newInstance.setNamespaceAware(true);
        } catch (XmlPullParserException e) {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", e);
        }
    }
}
