package com.google.android.gms.internal.ads;

import androidx.exifinterface.media.ExifInterface;
import java.util.Locale;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzdd {
    public static final /* synthetic */ int zza = 0;
    private static final byte[] zzb = {0, 0, 0, 1};
    private static final String[] zzc = {"", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "C"};
    private static final Pattern zzd = Pattern.compile("^\\D?(\\d+)$");

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x010c  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x011a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.util.Pair zza(com.google.android.gms.internal.ads.zzad r20) {
        /*
            r0 = r20
            java.lang.String r1 = r0.zzk
            r2 = 0
            if (r1 != 0) goto L_0x0008
            return r2
        L_0x0008:
            java.lang.String r3 = "\\."
            java.lang.String[] r1 = r1.split(r3)
            java.lang.String r3 = r0.zzo
            java.lang.String r4 = "video/dolby-vision"
            boolean r3 = r4.equals(r3)
            r6 = 512(0x200, float:7.175E-43)
            r7 = 256(0x100, float:3.59E-43)
            r8 = 128(0x80, float:1.794E-43)
            r9 = 64
            r10 = 32
            r11 = 4096(0x1000, float:5.74E-42)
            r12 = 8
            r13 = 3
            r14 = 16
            r15 = 4
            r16 = r2
            r2 = 2
            r17 = 2048(0x800, float:2.87E-42)
            java.lang.String r4 = "CodecSpecificDataUtil"
            r18 = 1024(0x400, float:1.435E-42)
            r5 = 1
            if (r3 == 0) goto L_0x01f0
            java.lang.String r0 = r0.zzk
            int r3 = r1.length
            if (r3 >= r13) goto L_0x0047
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r1 = "Ignoring malformed Dolby Vision codec string: "
            java.lang.String r0 = r1.concat(r0)
            com.google.android.gms.internal.ads.zzdt.zzf(r4, r0)
            return r16
        L_0x0047:
            java.util.regex.Pattern r3 = zzd
            r13 = r1[r5]
            java.util.regex.Matcher r3 = r3.matcher(r13)
            boolean r13 = r3.matches()
            if (r13 != 0) goto L_0x0063
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r1 = "Ignoring malformed Dolby Vision codec string: "
            java.lang.String r0 = r1.concat(r0)
            com.google.android.gms.internal.ads.zzdt.zzf(r4, r0)
            return r16
        L_0x0063:
            java.lang.String r0 = r3.group(r5)
            if (r0 != 0) goto L_0x006d
        L_0x0069:
            r3 = r16
            goto L_0x010a
        L_0x006d:
            int r3 = r0.hashCode()
            r13 = 1567(0x61f, float:2.196E-42)
            if (r3 == r13) goto L_0x00fe
            switch(r3) {
                case 1536: goto L_0x00f1;
                case 1537: goto L_0x00e4;
                case 1538: goto L_0x00d7;
                case 1539: goto L_0x00ca;
                case 1540: goto L_0x00bd;
                case 1541: goto L_0x00b0;
                case 1542: goto L_0x00a3;
                case 1543: goto L_0x0095;
                case 1544: goto L_0x0087;
                case 1545: goto L_0x0079;
                default: goto L_0x0078;
            }
        L_0x0078:
            goto L_0x0069
        L_0x0079:
            java.lang.String r3 = "09"
            boolean r3 = r0.equals(r3)
            if (r3 == 0) goto L_0x0069
            java.lang.Integer r3 = java.lang.Integer.valueOf(r6)
            goto L_0x010a
        L_0x0087:
            java.lang.String r3 = "08"
            boolean r3 = r0.equals(r3)
            if (r3 == 0) goto L_0x0069
            java.lang.Integer r3 = java.lang.Integer.valueOf(r7)
            goto L_0x010a
        L_0x0095:
            java.lang.String r3 = "07"
            boolean r3 = r0.equals(r3)
            if (r3 == 0) goto L_0x0069
            java.lang.Integer r3 = java.lang.Integer.valueOf(r8)
            goto L_0x010a
        L_0x00a3:
            java.lang.String r3 = "06"
            boolean r3 = r0.equals(r3)
            if (r3 == 0) goto L_0x0069
            java.lang.Integer r3 = java.lang.Integer.valueOf(r9)
            goto L_0x010a
        L_0x00b0:
            java.lang.String r3 = "05"
            boolean r3 = r0.equals(r3)
            if (r3 == 0) goto L_0x0069
            java.lang.Integer r3 = java.lang.Integer.valueOf(r10)
            goto L_0x010a
        L_0x00bd:
            java.lang.String r3 = "04"
            boolean r3 = r0.equals(r3)
            if (r3 == 0) goto L_0x0069
            java.lang.Integer r3 = java.lang.Integer.valueOf(r14)
            goto L_0x010a
        L_0x00ca:
            java.lang.String r3 = "03"
            boolean r3 = r0.equals(r3)
            if (r3 == 0) goto L_0x0069
            java.lang.Integer r3 = java.lang.Integer.valueOf(r12)
            goto L_0x010a
        L_0x00d7:
            java.lang.String r3 = "02"
            boolean r3 = r0.equals(r3)
            if (r3 == 0) goto L_0x0069
            java.lang.Integer r3 = java.lang.Integer.valueOf(r15)
            goto L_0x010a
        L_0x00e4:
            java.lang.String r3 = "01"
            boolean r3 = r0.equals(r3)
            if (r3 == 0) goto L_0x0069
            java.lang.Integer r3 = java.lang.Integer.valueOf(r2)
            goto L_0x010a
        L_0x00f1:
            java.lang.String r3 = "00"
            boolean r3 = r0.equals(r3)
            if (r3 == 0) goto L_0x0069
            java.lang.Integer r3 = java.lang.Integer.valueOf(r5)
            goto L_0x010a
        L_0x00fe:
            java.lang.String r3 = "10"
            boolean r3 = r0.equals(r3)
            if (r3 == 0) goto L_0x0069
            java.lang.Integer r3 = java.lang.Integer.valueOf(r18)
        L_0x010a:
            if (r3 != 0) goto L_0x011a
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r1 = "Unknown Dolby Vision profile string: "
            java.lang.String r0 = r1.concat(r0)
            com.google.android.gms.internal.ads.zzdt.zzf(r4, r0)
            return r16
        L_0x011a:
            r0 = r1[r2]
            if (r0 != 0) goto L_0x0122
        L_0x011e:
            r1 = r16
            goto L_0x01da
        L_0x0122:
            int r1 = r0.hashCode()
            switch(r1) {
                case 1537: goto L_0x01ce;
                case 1538: goto L_0x01c1;
                case 1539: goto L_0x01b4;
                case 1540: goto L_0x01a7;
                case 1541: goto L_0x019a;
                case 1542: goto L_0x018d;
                case 1543: goto L_0x0180;
                case 1544: goto L_0x0173;
                case 1545: goto L_0x0165;
                default: goto L_0x0129;
            }
        L_0x0129:
            switch(r1) {
                case 1567: goto L_0x0157;
                case 1568: goto L_0x0149;
                case 1569: goto L_0x013b;
                case 1570: goto L_0x012d;
                default: goto L_0x012c;
            }
        L_0x012c:
            goto L_0x011e
        L_0x012d:
            java.lang.String r1 = "13"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x011e
            java.lang.Integer r1 = java.lang.Integer.valueOf(r11)
            goto L_0x01da
        L_0x013b:
            java.lang.String r1 = "12"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x011e
            java.lang.Integer r1 = java.lang.Integer.valueOf(r17)
            goto L_0x01da
        L_0x0149:
            java.lang.String r1 = "11"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x011e
            java.lang.Integer r1 = java.lang.Integer.valueOf(r18)
            goto L_0x01da
        L_0x0157:
            java.lang.String r1 = "10"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x011e
            java.lang.Integer r1 = java.lang.Integer.valueOf(r6)
            goto L_0x01da
        L_0x0165:
            java.lang.String r1 = "09"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x011e
            java.lang.Integer r1 = java.lang.Integer.valueOf(r7)
            goto L_0x01da
        L_0x0173:
            java.lang.String r1 = "08"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x011e
            java.lang.Integer r1 = java.lang.Integer.valueOf(r8)
            goto L_0x01da
        L_0x0180:
            java.lang.String r1 = "07"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x011e
            java.lang.Integer r1 = java.lang.Integer.valueOf(r9)
            goto L_0x01da
        L_0x018d:
            java.lang.String r1 = "06"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x011e
            java.lang.Integer r1 = java.lang.Integer.valueOf(r10)
            goto L_0x01da
        L_0x019a:
            java.lang.String r1 = "05"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x011e
            java.lang.Integer r1 = java.lang.Integer.valueOf(r14)
            goto L_0x01da
        L_0x01a7:
            java.lang.String r1 = "04"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x011e
            java.lang.Integer r1 = java.lang.Integer.valueOf(r12)
            goto L_0x01da
        L_0x01b4:
            java.lang.String r1 = "03"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x011e
            java.lang.Integer r1 = java.lang.Integer.valueOf(r15)
            goto L_0x01da
        L_0x01c1:
            java.lang.String r1 = "02"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x011e
            java.lang.Integer r1 = java.lang.Integer.valueOf(r2)
            goto L_0x01da
        L_0x01ce:
            java.lang.String r1 = "01"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x011e
            java.lang.Integer r1 = java.lang.Integer.valueOf(r5)
        L_0x01da:
            if (r1 != 0) goto L_0x01ea
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r1 = "Unknown Dolby Vision level string: "
            java.lang.String r0 = r1.concat(r0)
            com.google.android.gms.internal.ads.zzdt.zzf(r4, r0)
            return r16
        L_0x01ea:
            android.util.Pair r0 = new android.util.Pair
            r0.<init>(r3, r1)
            return r0
        L_0x01f0:
            r3 = 0
            r6 = r1[r3]
            int r19 = r6.hashCode()
            r7 = 6
            r8 = -1
            switch(r19) {
                case 3004662: goto L_0x0239;
                case 3006243: goto L_0x022f;
                case 3006244: goto L_0x0225;
                case 3199032: goto L_0x021b;
                case 3214780: goto L_0x0211;
                case 3356560: goto L_0x0207;
                case 3624515: goto L_0x01fd;
                default: goto L_0x01fc;
            }
        L_0x01fc:
            goto L_0x0243
        L_0x01fd:
            java.lang.String r9 = "vp09"
            boolean r6 = r6.equals(r9)
            if (r6 == 0) goto L_0x0243
            r6 = r2
            goto L_0x0244
        L_0x0207:
            java.lang.String r9 = "mp4a"
            boolean r6 = r6.equals(r9)
            if (r6 == 0) goto L_0x0243
            r6 = r7
            goto L_0x0244
        L_0x0211:
            java.lang.String r9 = "hvc1"
            boolean r6 = r6.equals(r9)
            if (r6 == 0) goto L_0x0243
            r6 = r15
            goto L_0x0244
        L_0x021b:
            java.lang.String r9 = "hev1"
            boolean r6 = r6.equals(r9)
            if (r6 == 0) goto L_0x0243
            r6 = r13
            goto L_0x0244
        L_0x0225:
            java.lang.String r9 = "avc2"
            boolean r6 = r6.equals(r9)
            if (r6 == 0) goto L_0x0243
            r6 = r5
            goto L_0x0244
        L_0x022f:
            java.lang.String r9 = "avc1"
            boolean r6 = r6.equals(r9)
            if (r6 == 0) goto L_0x0243
            r6 = r3
            goto L_0x0244
        L_0x0239:
            java.lang.String r9 = "av01"
            boolean r6 = r6.equals(r9)
            if (r6 == 0) goto L_0x0243
            r6 = 5
            goto L_0x0244
        L_0x0243:
            r6 = r8
        L_0x0244:
            r9 = 20
            switch(r6) {
                case 0: goto L_0x0473;
                case 1: goto L_0x0473;
                case 2: goto L_0x03b5;
                case 3: goto L_0x03ac;
                case 4: goto L_0x03ac;
                case 5: goto L_0x02ca;
                case 6: goto L_0x024a;
                default: goto L_0x0249;
            }
        L_0x0249:
            return r16
        L_0x024a:
            java.lang.String r0 = r0.zzk
            int r6 = r1.length
            if (r6 == r13) goto L_0x025d
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r1 = "Ignoring malformed MP4A codec string: "
            java.lang.String r0 = r1.concat(r0)
            com.google.android.gms.internal.ads.zzdt.zzf(r4, r0)
            return r16
        L_0x025d:
            r6 = r1[r5]     // Catch:{ NumberFormatException -> 0x02bb }
            int r6 = java.lang.Integer.parseInt(r6, r14)     // Catch:{ NumberFormatException -> 0x02bb }
            java.lang.String r6 = com.google.android.gms.internal.ads.zzbg.zzd(r6)     // Catch:{ NumberFormatException -> 0x02bb }
            java.lang.String r10 = "audio/mp4a-latm"
            boolean r6 = r10.equals(r6)     // Catch:{ NumberFormatException -> 0x02bb }
            if (r6 == 0) goto L_0x02ba
            r1 = r1[r2]     // Catch:{ NumberFormatException -> 0x02bb }
            int r1 = java.lang.Integer.parseInt(r1)     // Catch:{ NumberFormatException -> 0x02bb }
            r6 = 17
            if (r1 == r6) goto L_0x02a8
            if (r1 == r9) goto L_0x02a6
            r6 = 23
            if (r1 == r6) goto L_0x02a3
            r6 = 29
            if (r1 == r6) goto L_0x02a0
            r6 = 39
            if (r1 == r6) goto L_0x029d
            r6 = 42
            if (r1 == r6) goto L_0x029a
            switch(r1) {
                case 1: goto L_0x0298;
                case 2: goto L_0x0296;
                case 3: goto L_0x02aa;
                case 4: goto L_0x0294;
                case 5: goto L_0x0292;
                case 6: goto L_0x0290;
                default: goto L_0x028e;
            }     // Catch:{ NumberFormatException -> 0x02bb }
        L_0x028e:
            r13 = r8
            goto L_0x02aa
        L_0x0290:
            r13 = r7
            goto L_0x02aa
        L_0x0292:
            r13 = 5
            goto L_0x02aa
        L_0x0294:
            r13 = r15
            goto L_0x02aa
        L_0x0296:
            r13 = r2
            goto L_0x02aa
        L_0x0298:
            r13 = r5
            goto L_0x02aa
        L_0x029a:
            r13 = 42
            goto L_0x02aa
        L_0x029d:
            r13 = 39
            goto L_0x02aa
        L_0x02a0:
            r13 = 29
            goto L_0x02aa
        L_0x02a3:
            r13 = 23
            goto L_0x02aa
        L_0x02a6:
            r13 = r9
            goto L_0x02aa
        L_0x02a8:
            r13 = 17
        L_0x02aa:
            if (r13 == r8) goto L_0x02ba
            android.util.Pair r1 = new android.util.Pair     // Catch:{ NumberFormatException -> 0x02bb }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r13)     // Catch:{ NumberFormatException -> 0x02bb }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ NumberFormatException -> 0x02bb }
            r1.<init>(r2, r3)     // Catch:{ NumberFormatException -> 0x02bb }
            return r1
        L_0x02ba:
            return r16
        L_0x02bb:
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r1 = "Ignoring malformed MP4A codec string: "
            java.lang.String r0 = r1.concat(r0)
            com.google.android.gms.internal.ads.zzdt.zzf(r4, r0)
            goto L_0x0569
        L_0x02ca:
            java.lang.String r6 = r0.zzk
            com.google.android.gms.internal.ads.zzm r0 = r0.zzB
            int r9 = r1.length
            if (r9 >= r15) goto L_0x02df
            java.lang.String r0 = java.lang.String.valueOf(r6)
            java.lang.String r1 = "Ignoring malformed AV1 codec string: "
            java.lang.String r0 = r1.concat(r0)
            com.google.android.gms.internal.ads.zzdt.zzf(r4, r0)
            return r16
        L_0x02df:
            r9 = r1[r5]     // Catch:{ NumberFormatException -> 0x039d }
            int r9 = java.lang.Integer.parseInt(r9)     // Catch:{ NumberFormatException -> 0x039d }
            r10 = r1[r2]     // Catch:{ NumberFormatException -> 0x039d }
            java.lang.String r3 = r10.substring(r3, r2)     // Catch:{ NumberFormatException -> 0x039d }
            int r3 = java.lang.Integer.parseInt(r3)     // Catch:{ NumberFormatException -> 0x039d }
            r1 = r1[r13]     // Catch:{ NumberFormatException -> 0x039d }
            int r1 = java.lang.Integer.parseInt(r1)     // Catch:{ NumberFormatException -> 0x039d }
            if (r9 == 0) goto L_0x0309
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Unknown AV1 profile: "
            r0.<init>(r1)
            r0.append(r9)
            java.lang.String r0 = r0.toString()
            com.google.android.gms.internal.ads.zzdt.zzf(r4, r0)
            return r16
        L_0x0309:
            if (r1 == r12) goto L_0x0332
            r6 = 10
            if (r1 == r6) goto L_0x0321
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r2 = "Unknown AV1 bit depth: "
            r0.<init>(r2)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.google.android.gms.internal.ads.zzdt.zzf(r4, r0)
            return r16
        L_0x0321:
            if (r0 == 0) goto L_0x0330
            byte[] r1 = r0.zze
            if (r1 != 0) goto L_0x032e
            int r0 = r0.zzd
            r1 = 7
            if (r0 == r1) goto L_0x032e
            if (r0 != r7) goto L_0x0330
        L_0x032e:
            r0 = r11
            goto L_0x0333
        L_0x0330:
            r0 = r2
            goto L_0x0333
        L_0x0332:
            r0 = r5
        L_0x0333:
            switch(r3) {
                case 0: goto L_0x037a;
                case 1: goto L_0x0378;
                case 2: goto L_0x0376;
                case 3: goto L_0x0374;
                case 4: goto L_0x0372;
                case 5: goto L_0x036f;
                case 6: goto L_0x036c;
                case 7: goto L_0x0369;
                case 8: goto L_0x0366;
                case 9: goto L_0x0363;
                case 10: goto L_0x0360;
                case 11: goto L_0x035d;
                case 12: goto L_0x035b;
                case 13: goto L_0x0358;
                case 14: goto L_0x0355;
                case 15: goto L_0x0351;
                case 16: goto L_0x034e;
                case 17: goto L_0x034b;
                case 18: goto L_0x0348;
                case 19: goto L_0x0345;
                case 20: goto L_0x0342;
                case 21: goto L_0x033f;
                case 22: goto L_0x033c;
                case 23: goto L_0x0339;
                default: goto L_0x0336;
            }
        L_0x0336:
            r1 = r8
            goto L_0x037b
        L_0x0339:
            r1 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x037b
        L_0x033c:
            r1 = 4194304(0x400000, float:5.877472E-39)
            goto L_0x037b
        L_0x033f:
            r1 = 2097152(0x200000, float:2.938736E-39)
            goto L_0x037b
        L_0x0342:
            r1 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x037b
        L_0x0345:
            r1 = 524288(0x80000, float:7.34684E-40)
            goto L_0x037b
        L_0x0348:
            r1 = 262144(0x40000, float:3.67342E-40)
            goto L_0x037b
        L_0x034b:
            r1 = 131072(0x20000, float:1.83671E-40)
            goto L_0x037b
        L_0x034e:
            r1 = 65536(0x10000, float:9.18355E-41)
            goto L_0x037b
        L_0x0351:
            r1 = 32768(0x8000, float:4.5918E-41)
            goto L_0x037b
        L_0x0355:
            r1 = 16384(0x4000, float:2.2959E-41)
            goto L_0x037b
        L_0x0358:
            r1 = 8192(0x2000, float:1.14794E-41)
            goto L_0x037b
        L_0x035b:
            r1 = r11
            goto L_0x037b
        L_0x035d:
            r1 = r17
            goto L_0x037b
        L_0x0360:
            r1 = r18
            goto L_0x037b
        L_0x0363:
            r1 = 512(0x200, float:7.175E-43)
            goto L_0x037b
        L_0x0366:
            r1 = 256(0x100, float:3.59E-43)
            goto L_0x037b
        L_0x0369:
            r1 = 128(0x80, float:1.794E-43)
            goto L_0x037b
        L_0x036c:
            r1 = 64
            goto L_0x037b
        L_0x036f:
            r1 = 32
            goto L_0x037b
        L_0x0372:
            r1 = r14
            goto L_0x037b
        L_0x0374:
            r1 = r12
            goto L_0x037b
        L_0x0376:
            r1 = r15
            goto L_0x037b
        L_0x0378:
            r1 = r2
            goto L_0x037b
        L_0x037a:
            r1 = r5
        L_0x037b:
            if (r1 != r8) goto L_0x038f
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Unknown AV1 level: "
            r0.<init>(r1)
            r0.append(r3)
            java.lang.String r0 = r0.toString()
            com.google.android.gms.internal.ads.zzdt.zzf(r4, r0)
            return r16
        L_0x038f:
            android.util.Pair r2 = new android.util.Pair
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r2.<init>(r0, r1)
            return r2
        L_0x039d:
            java.lang.String r0 = java.lang.String.valueOf(r6)
            java.lang.String r1 = "Ignoring malformed AV1 codec string: "
            java.lang.String r0 = r1.concat(r0)
            com.google.android.gms.internal.ads.zzdt.zzf(r4, r0)
            goto L_0x0569
        L_0x03ac:
            java.lang.String r2 = r0.zzk
            com.google.android.gms.internal.ads.zzm r0 = r0.zzB
            android.util.Pair r0 = zzb(r2, r1, r0)
            return r0
        L_0x03b5:
            java.lang.String r0 = r0.zzk
            int r3 = r1.length
            if (r3 >= r13) goto L_0x03c8
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r1 = "Ignoring malformed VP9 codec string: "
            java.lang.String r0 = r1.concat(r0)
            com.google.android.gms.internal.ads.zzdt.zzf(r4, r0)
            return r16
        L_0x03c8:
            r3 = r1[r5]     // Catch:{ NumberFormatException -> 0x0464 }
            int r3 = java.lang.Integer.parseInt(r3)     // Catch:{ NumberFormatException -> 0x0464 }
            r1 = r1[r2]     // Catch:{ NumberFormatException -> 0x0464 }
            int r0 = java.lang.Integer.parseInt(r1)     // Catch:{ NumberFormatException -> 0x0464 }
            if (r3 == 0) goto L_0x03e4
            if (r3 == r5) goto L_0x03e2
            if (r3 == r2) goto L_0x03e0
            if (r3 == r13) goto L_0x03de
            r1 = r8
            goto L_0x03e5
        L_0x03de:
            r1 = r12
            goto L_0x03e5
        L_0x03e0:
            r1 = r15
            goto L_0x03e5
        L_0x03e2:
            r1 = r2
            goto L_0x03e5
        L_0x03e4:
            r1 = r5
        L_0x03e5:
            if (r1 != r8) goto L_0x03f9
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Unknown VP9 profile: "
            r0.<init>(r1)
            r0.append(r3)
            java.lang.String r0 = r0.toString()
            com.google.android.gms.internal.ads.zzdt.zzf(r4, r0)
            return r16
        L_0x03f9:
            r3 = 10
            if (r0 == r3) goto L_0x0441
            r3 = 11
            if (r0 == r3) goto L_0x0442
            if (r0 == r9) goto L_0x043f
            r2 = 21
            if (r0 == r2) goto L_0x043d
            r2 = 30
            if (r0 == r2) goto L_0x043b
            r2 = 31
            if (r0 == r2) goto L_0x0438
            r2 = 40
            if (r0 == r2) goto L_0x0435
            r2 = 41
            if (r0 == r2) goto L_0x0432
            r2 = 50
            if (r0 == r2) goto L_0x042f
            r2 = 51
            if (r0 == r2) goto L_0x042c
            switch(r0) {
                case 60: goto L_0x0429;
                case 61: goto L_0x0427;
                case 62: goto L_0x0424;
                default: goto L_0x0422;
            }
        L_0x0422:
            r2 = r8
            goto L_0x0442
        L_0x0424:
            r2 = 8192(0x2000, float:1.14794E-41)
            goto L_0x0442
        L_0x0427:
            r2 = r11
            goto L_0x0442
        L_0x0429:
            r2 = r17
            goto L_0x0442
        L_0x042c:
            r2 = 512(0x200, float:7.175E-43)
            goto L_0x0442
        L_0x042f:
            r2 = 256(0x100, float:3.59E-43)
            goto L_0x0442
        L_0x0432:
            r2 = 128(0x80, float:1.794E-43)
            goto L_0x0442
        L_0x0435:
            r2 = 64
            goto L_0x0442
        L_0x0438:
            r2 = 32
            goto L_0x0442
        L_0x043b:
            r2 = r14
            goto L_0x0442
        L_0x043d:
            r2 = r12
            goto L_0x0442
        L_0x043f:
            r2 = r15
            goto L_0x0442
        L_0x0441:
            r2 = r5
        L_0x0442:
            if (r2 != r8) goto L_0x0456
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Unknown VP9 level: "
            r1.<init>(r2)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            com.google.android.gms.internal.ads.zzdt.zzf(r4, r0)
            return r16
        L_0x0456:
            android.util.Pair r0 = new android.util.Pair
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r0.<init>(r1, r2)
            return r0
        L_0x0464:
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r1 = "Ignoring malformed VP9 codec string: "
            java.lang.String r0 = r1.concat(r0)
            com.google.android.gms.internal.ads.zzdt.zzf(r4, r0)
            goto L_0x0569
        L_0x0473:
            java.lang.String r0 = r0.zzk
            int r6 = r1.length
            java.lang.String r9 = "Ignoring malformed AVC codec string: "
            if (r6 >= r2) goto L_0x0486
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r0 = r9.concat(r0)
            com.google.android.gms.internal.ads.zzdt.zzf(r4, r0)
            return r16
        L_0x0486:
            r10 = r1[r5]     // Catch:{ NumberFormatException -> 0x055e }
            int r10 = r10.length()     // Catch:{ NumberFormatException -> 0x055e }
            if (r10 != r7) goto L_0x04a3
            r6 = r1[r5]     // Catch:{ NumberFormatException -> 0x055e }
            java.lang.String r3 = r6.substring(r3, r2)     // Catch:{ NumberFormatException -> 0x055e }
            int r3 = java.lang.Integer.parseInt(r3, r14)     // Catch:{ NumberFormatException -> 0x055e }
            r1 = r1[r5]     // Catch:{ NumberFormatException -> 0x055e }
            java.lang.String r1 = r1.substring(r15)     // Catch:{ NumberFormatException -> 0x055e }
            int r0 = java.lang.Integer.parseInt(r1, r14)     // Catch:{ NumberFormatException -> 0x055e }
            goto L_0x04b1
        L_0x04a3:
            if (r6 < r13) goto L_0x054e
            r3 = r1[r5]     // Catch:{ NumberFormatException -> 0x055e }
            int r3 = java.lang.Integer.parseInt(r3)     // Catch:{ NumberFormatException -> 0x055e }
            r1 = r1[r2]     // Catch:{ NumberFormatException -> 0x055e }
            int r0 = java.lang.Integer.parseInt(r1)     // Catch:{ NumberFormatException -> 0x055e }
        L_0x04b1:
            r1 = 66
            if (r3 == r1) goto L_0x04db
            r1 = 77
            if (r3 == r1) goto L_0x04dc
            r1 = 88
            if (r3 == r1) goto L_0x04d9
            r1 = 100
            if (r3 == r1) goto L_0x04d7
            r1 = 110(0x6e, float:1.54E-43)
            if (r3 == r1) goto L_0x04d5
            r1 = 122(0x7a, float:1.71E-43)
            if (r3 == r1) goto L_0x04d2
            r1 = 244(0xf4, float:3.42E-43)
            if (r3 == r1) goto L_0x04cf
            r2 = r8
            goto L_0x04dc
        L_0x04cf:
            r2 = 64
            goto L_0x04dc
        L_0x04d2:
            r2 = 32
            goto L_0x04dc
        L_0x04d5:
            r2 = r14
            goto L_0x04dc
        L_0x04d7:
            r2 = r12
            goto L_0x04dc
        L_0x04d9:
            r2 = r15
            goto L_0x04dc
        L_0x04db:
            r2 = r5
        L_0x04dc:
            if (r2 != r8) goto L_0x04f0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Unknown AVC profile: "
            r0.<init>(r1)
            r0.append(r3)
            java.lang.String r0 = r0.toString()
            com.google.android.gms.internal.ads.zzdt.zzf(r4, r0)
            return r16
        L_0x04f0:
            switch(r0) {
                case 10: goto L_0x052b;
                case 11: goto L_0x0529;
                case 12: goto L_0x0527;
                case 13: goto L_0x0525;
                default: goto L_0x04f3;
            }
        L_0x04f3:
            switch(r0) {
                case 20: goto L_0x0522;
                case 21: goto L_0x051f;
                case 22: goto L_0x051c;
                default: goto L_0x04f6;
            }
        L_0x04f6:
            switch(r0) {
                case 30: goto L_0x0519;
                case 31: goto L_0x0516;
                case 32: goto L_0x0513;
                default: goto L_0x04f9;
            }
        L_0x04f9:
            switch(r0) {
                case 40: goto L_0x0510;
                case 41: goto L_0x050e;
                case 42: goto L_0x050b;
                default: goto L_0x04fc;
            }
        L_0x04fc:
            switch(r0) {
                case 50: goto L_0x0508;
                case 51: goto L_0x0504;
                case 52: goto L_0x0501;
                default: goto L_0x04ff;
            }
        L_0x04ff:
            r1 = r8
            goto L_0x052c
        L_0x0501:
            r1 = 65536(0x10000, float:9.18355E-41)
            goto L_0x052c
        L_0x0504:
            r1 = 32768(0x8000, float:4.5918E-41)
            goto L_0x052c
        L_0x0508:
            r1 = 16384(0x4000, float:2.2959E-41)
            goto L_0x052c
        L_0x050b:
            r1 = 8192(0x2000, float:1.14794E-41)
            goto L_0x052c
        L_0x050e:
            r1 = r11
            goto L_0x052c
        L_0x0510:
            r1 = r17
            goto L_0x052c
        L_0x0513:
            r1 = r18
            goto L_0x052c
        L_0x0516:
            r1 = 512(0x200, float:7.175E-43)
            goto L_0x052c
        L_0x0519:
            r1 = 256(0x100, float:3.59E-43)
            goto L_0x052c
        L_0x051c:
            r1 = 128(0x80, float:1.794E-43)
            goto L_0x052c
        L_0x051f:
            r1 = 64
            goto L_0x052c
        L_0x0522:
            r1 = 32
            goto L_0x052c
        L_0x0525:
            r1 = r14
            goto L_0x052c
        L_0x0527:
            r1 = r12
            goto L_0x052c
        L_0x0529:
            r1 = r15
            goto L_0x052c
        L_0x052b:
            r1 = r5
        L_0x052c:
            if (r1 != r8) goto L_0x0540
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Unknown AVC level: "
            r1.<init>(r2)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            com.google.android.gms.internal.ads.zzdt.zzf(r4, r0)
            return r16
        L_0x0540:
            android.util.Pair r0 = new android.util.Pair
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r0.<init>(r2, r1)
            return r0
        L_0x054e:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ NumberFormatException -> 0x055e }
            r1.<init>(r9)     // Catch:{ NumberFormatException -> 0x055e }
            r1.append(r0)     // Catch:{ NumberFormatException -> 0x055e }
            java.lang.String r1 = r1.toString()     // Catch:{ NumberFormatException -> 0x055e }
            com.google.android.gms.internal.ads.zzdt.zzf(r4, r1)     // Catch:{ NumberFormatException -> 0x055e }
            return r16
        L_0x055e:
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r0 = r9.concat(r0)
            com.google.android.gms.internal.ads.zzdt.zzf(r4, r0)
        L_0x0569:
            return r16
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdd.zza(com.google.android.gms.internal.ads.zzad):android.util.Pair");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00be, code lost:
        if (r11.equals("L123") != false) goto L_0x0197;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.util.Pair zzb(java.lang.String r10, java.lang.String[] r11, com.google.android.gms.internal.ads.zzm r12) {
        /*
            int r0 = r11.length
            java.lang.String r1 = "Ignoring malformed HEVC codec string: "
            java.lang.String r2 = "CodecSpecificDataUtil"
            r3 = 0
            r4 = 4
            if (r0 >= r4) goto L_0x0015
            java.lang.String r10 = java.lang.String.valueOf(r10)
            java.lang.String r10 = r1.concat(r10)
            com.google.android.gms.internal.ads.zzdt.zzf(r2, r10)
            return r3
        L_0x0015:
            java.util.regex.Pattern r0 = zzd
            r5 = 1
            r6 = r11[r5]
            java.util.regex.Matcher r0 = r0.matcher(r6)
            boolean r6 = r0.matches()
            if (r6 != 0) goto L_0x0030
            java.lang.String r10 = java.lang.String.valueOf(r10)
            java.lang.String r10 = r1.concat(r10)
            com.google.android.gms.internal.ads.zzdt.zzf(r2, r10)
            return r3
        L_0x0030:
            java.lang.String r10 = r0.group(r5)
            java.lang.String r0 = "1"
            boolean r0 = r0.equals(r10)
            r1 = 4096(0x1000, float:5.74E-42)
            r6 = 6
            r7 = 2
            if (r0 == 0) goto L_0x0042
            r10 = r5
            goto L_0x005d
        L_0x0042:
            java.lang.String r0 = "2"
            boolean r0 = r0.equals(r10)
            if (r0 == 0) goto L_0x0054
            if (r12 == 0) goto L_0x0052
            int r10 = r12.zzd
            if (r10 != r6) goto L_0x0052
            r10 = r1
            goto L_0x005d
        L_0x0052:
            r10 = r7
            goto L_0x005d
        L_0x0054:
            java.lang.String r12 = "6"
            boolean r12 = r12.equals(r10)
            if (r12 == 0) goto L_0x026a
            r10 = r6
        L_0x005d:
            r12 = 3
            r11 = r11[r12]
            if (r11 != 0) goto L_0x0065
        L_0x0062:
            r12 = r3
            goto L_0x0250
        L_0x0065:
            int r0 = r11.hashCode()
            r8 = 8
            r9 = 16
            switch(r0) {
                case 70821: goto L_0x018b;
                case 70914: goto L_0x0180;
                case 70917: goto L_0x0175;
                case 71007: goto L_0x016b;
                case 71010: goto L_0x0160;
                case 74665: goto L_0x0156;
                case 74758: goto L_0x014c;
                case 74761: goto L_0x0142;
                case 74851: goto L_0x0138;
                case 74854: goto L_0x012d;
                case 2193639: goto L_0x0121;
                case 2193642: goto L_0x0115;
                case 2193732: goto L_0x0109;
                case 2193735: goto L_0x00fd;
                case 2193738: goto L_0x00f1;
                case 2193825: goto L_0x00e5;
                case 2193828: goto L_0x00d9;
                case 2193831: goto L_0x00cd;
                case 2312803: goto L_0x00c2;
                case 2312806: goto L_0x00b8;
                case 2312896: goto L_0x00ad;
                case 2312899: goto L_0x00a2;
                case 2312902: goto L_0x0096;
                case 2312989: goto L_0x008a;
                case 2312992: goto L_0x007e;
                case 2312995: goto L_0x0072;
                default: goto L_0x0070;
            }
        L_0x0070:
            goto L_0x0196
        L_0x0072:
            java.lang.String r12 = "L186"
            boolean r12 = r11.equals(r12)
            if (r12 == 0) goto L_0x0196
            r6 = 12
            goto L_0x0197
        L_0x007e:
            java.lang.String r12 = "L183"
            boolean r12 = r11.equals(r12)
            if (r12 == 0) goto L_0x0196
            r6 = 11
            goto L_0x0197
        L_0x008a:
            java.lang.String r12 = "L180"
            boolean r12 = r11.equals(r12)
            if (r12 == 0) goto L_0x0196
            r6 = 10
            goto L_0x0197
        L_0x0096:
            java.lang.String r12 = "L156"
            boolean r12 = r11.equals(r12)
            if (r12 == 0) goto L_0x0196
            r6 = 9
            goto L_0x0197
        L_0x00a2:
            java.lang.String r12 = "L153"
            boolean r12 = r11.equals(r12)
            if (r12 == 0) goto L_0x0196
            r6 = r8
            goto L_0x0197
        L_0x00ad:
            java.lang.String r12 = "L150"
            boolean r12 = r11.equals(r12)
            if (r12 == 0) goto L_0x0196
            r6 = 7
            goto L_0x0197
        L_0x00b8:
            java.lang.String r12 = "L123"
            boolean r12 = r11.equals(r12)
            if (r12 == 0) goto L_0x0196
            goto L_0x0197
        L_0x00c2:
            java.lang.String r12 = "L120"
            boolean r12 = r11.equals(r12)
            if (r12 == 0) goto L_0x0196
            r6 = 5
            goto L_0x0197
        L_0x00cd:
            java.lang.String r12 = "H186"
            boolean r12 = r11.equals(r12)
            if (r12 == 0) goto L_0x0196
            r6 = 25
            goto L_0x0197
        L_0x00d9:
            java.lang.String r12 = "H183"
            boolean r12 = r11.equals(r12)
            if (r12 == 0) goto L_0x0196
            r6 = 24
            goto L_0x0197
        L_0x00e5:
            java.lang.String r12 = "H180"
            boolean r12 = r11.equals(r12)
            if (r12 == 0) goto L_0x0196
            r6 = 23
            goto L_0x0197
        L_0x00f1:
            java.lang.String r12 = "H156"
            boolean r12 = r11.equals(r12)
            if (r12 == 0) goto L_0x0196
            r6 = 22
            goto L_0x0197
        L_0x00fd:
            java.lang.String r12 = "H153"
            boolean r12 = r11.equals(r12)
            if (r12 == 0) goto L_0x0196
            r6 = 21
            goto L_0x0197
        L_0x0109:
            java.lang.String r12 = "H150"
            boolean r12 = r11.equals(r12)
            if (r12 == 0) goto L_0x0196
            r6 = 20
            goto L_0x0197
        L_0x0115:
            java.lang.String r12 = "H123"
            boolean r12 = r11.equals(r12)
            if (r12 == 0) goto L_0x0196
            r6 = 19
            goto L_0x0197
        L_0x0121:
            java.lang.String r12 = "H120"
            boolean r12 = r11.equals(r12)
            if (r12 == 0) goto L_0x0196
            r6 = 18
            goto L_0x0197
        L_0x012d:
            java.lang.String r12 = "L93"
            boolean r12 = r11.equals(r12)
            if (r12 == 0) goto L_0x0196
            r6 = r4
            goto L_0x0197
        L_0x0138:
            java.lang.String r0 = "L90"
            boolean r0 = r11.equals(r0)
            if (r0 == 0) goto L_0x0196
            r6 = r12
            goto L_0x0197
        L_0x0142:
            java.lang.String r12 = "L63"
            boolean r12 = r11.equals(r12)
            if (r12 == 0) goto L_0x0196
            r6 = r7
            goto L_0x0197
        L_0x014c:
            java.lang.String r12 = "L60"
            boolean r12 = r11.equals(r12)
            if (r12 == 0) goto L_0x0196
            r6 = r5
            goto L_0x0197
        L_0x0156:
            java.lang.String r12 = "L30"
            boolean r12 = r11.equals(r12)
            if (r12 == 0) goto L_0x0196
            r6 = 0
            goto L_0x0197
        L_0x0160:
            java.lang.String r12 = "H93"
            boolean r12 = r11.equals(r12)
            if (r12 == 0) goto L_0x0196
            r6 = 17
            goto L_0x0197
        L_0x016b:
            java.lang.String r12 = "H90"
            boolean r12 = r11.equals(r12)
            if (r12 == 0) goto L_0x0196
            r6 = r9
            goto L_0x0197
        L_0x0175:
            java.lang.String r12 = "H63"
            boolean r12 = r11.equals(r12)
            if (r12 == 0) goto L_0x0196
            r6 = 15
            goto L_0x0197
        L_0x0180:
            java.lang.String r12 = "H60"
            boolean r12 = r11.equals(r12)
            if (r12 == 0) goto L_0x0196
            r6 = 14
            goto L_0x0197
        L_0x018b:
            java.lang.String r12 = "H30"
            boolean r12 = r11.equals(r12)
            if (r12 == 0) goto L_0x0196
            r6 = 13
            goto L_0x0197
        L_0x0196:
            r6 = -1
        L_0x0197:
            switch(r6) {
                case 0: goto L_0x024c;
                case 1: goto L_0x0247;
                case 2: goto L_0x0242;
                case 3: goto L_0x023b;
                case 4: goto L_0x0234;
                case 5: goto L_0x022d;
                case 6: goto L_0x0228;
                case 7: goto L_0x0221;
                case 8: goto L_0x021a;
                case 9: goto L_0x0213;
                case 10: goto L_0x020c;
                case 11: goto L_0x0205;
                case 12: goto L_0x01fe;
                case 13: goto L_0x01f9;
                case 14: goto L_0x01f4;
                case 15: goto L_0x01ed;
                case 16: goto L_0x01e5;
                case 17: goto L_0x01dd;
                case 18: goto L_0x01d5;
                case 19: goto L_0x01cd;
                case 20: goto L_0x01c4;
                case 21: goto L_0x01bc;
                case 22: goto L_0x01b4;
                case 23: goto L_0x01ac;
                case 24: goto L_0x01a4;
                case 25: goto L_0x019c;
                default: goto L_0x019a;
            }
        L_0x019a:
            goto L_0x0062
        L_0x019c:
            r12 = 33554432(0x2000000, float:9.403955E-38)
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            goto L_0x0250
        L_0x01a4:
            r12 = 8388608(0x800000, float:1.17549435E-38)
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            goto L_0x0250
        L_0x01ac:
            r12 = 2097152(0x200000, float:2.938736E-39)
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            goto L_0x0250
        L_0x01b4:
            r12 = 524288(0x80000, float:7.34684E-40)
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            goto L_0x0250
        L_0x01bc:
            r12 = 131072(0x20000, float:1.83671E-40)
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            goto L_0x0250
        L_0x01c4:
            r12 = 32768(0x8000, float:4.5918E-41)
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            goto L_0x0250
        L_0x01cd:
            r12 = 8192(0x2000, float:1.14794E-41)
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            goto L_0x0250
        L_0x01d5:
            r12 = 2048(0x800, float:2.87E-42)
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            goto L_0x0250
        L_0x01dd:
            r12 = 512(0x200, float:7.175E-43)
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            goto L_0x0250
        L_0x01e5:
            r12 = 128(0x80, float:1.794E-43)
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            goto L_0x0250
        L_0x01ed:
            r12 = 32
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            goto L_0x0250
        L_0x01f4:
            java.lang.Integer r12 = java.lang.Integer.valueOf(r8)
            goto L_0x0250
        L_0x01f9:
            java.lang.Integer r12 = java.lang.Integer.valueOf(r7)
            goto L_0x0250
        L_0x01fe:
            r12 = 16777216(0x1000000, float:2.3509887E-38)
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            goto L_0x0250
        L_0x0205:
            r12 = 4194304(0x400000, float:5.877472E-39)
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            goto L_0x0250
        L_0x020c:
            r12 = 1048576(0x100000, float:1.469368E-39)
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            goto L_0x0250
        L_0x0213:
            r12 = 262144(0x40000, float:3.67342E-40)
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            goto L_0x0250
        L_0x021a:
            r12 = 65536(0x10000, float:9.18355E-41)
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            goto L_0x0250
        L_0x0221:
            r12 = 16384(0x4000, float:2.2959E-41)
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            goto L_0x0250
        L_0x0228:
            java.lang.Integer r12 = java.lang.Integer.valueOf(r1)
            goto L_0x0250
        L_0x022d:
            r12 = 1024(0x400, float:1.435E-42)
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            goto L_0x0250
        L_0x0234:
            r12 = 256(0x100, float:3.59E-43)
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            goto L_0x0250
        L_0x023b:
            r12 = 64
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            goto L_0x0250
        L_0x0242:
            java.lang.Integer r12 = java.lang.Integer.valueOf(r9)
            goto L_0x0250
        L_0x0247:
            java.lang.Integer r12 = java.lang.Integer.valueOf(r4)
            goto L_0x0250
        L_0x024c:
            java.lang.Integer r12 = java.lang.Integer.valueOf(r5)
        L_0x0250:
            if (r12 != 0) goto L_0x0260
            java.lang.String r10 = java.lang.String.valueOf(r11)
            java.lang.String r11 = "Unknown HEVC level string: "
            java.lang.String r10 = r11.concat(r10)
            com.google.android.gms.internal.ads.zzdt.zzf(r2, r10)
            return r3
        L_0x0260:
            android.util.Pair r11 = new android.util.Pair
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            r11.<init>(r10, r12)
            return r11
        L_0x026a:
            java.lang.String r10 = java.lang.String.valueOf(r10)
            java.lang.String r11 = "Unknown HEVC profile string: "
            java.lang.String r10 = r11.concat(r10)
            com.google.android.gms.internal.ads.zzdt.zzf(r2, r10)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdd.zzb(java.lang.String, java.lang.String[], com.google.android.gms.internal.ads.zzm):android.util.Pair");
    }

    public static String zzc(int i, int i2, int i3) {
        return String.format("avc1.%02X%02X%02X", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
    }

    public static String zzd(int i, boolean z, int i2, int i3, int[] iArr, int i4) {
        int i5;
        StringBuilder sb = new StringBuilder(String.format(Locale.US, "hvc1.%s%d.%X.%c%d", new Object[]{zzc[i], Integer.valueOf(i2), Integer.valueOf(i3), Character.valueOf(true != z ? 'L' : 'H'), Integer.valueOf(i4)}));
        int i6 = 6;
        while (true) {
            if (i6 <= 0) {
                break;
            }
            int i7 = i6 - 1;
            if (iArr[i7] != 0) {
                break;
            }
            i6 = i7;
        }
        for (i5 = 0; i5 < i6; i5++) {
            sb.append(String.format(".%02X", new Object[]{Integer.valueOf(iArr[i5])}));
        }
        return sb.toString();
    }

    public static byte[] zze(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[(i2 + 4)];
        System.arraycopy(zzb, 0, bArr2, 0, 4);
        System.arraycopy(bArr, i, bArr2, 4, i2);
        return bArr2;
    }
}
