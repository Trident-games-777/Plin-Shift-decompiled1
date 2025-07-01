package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzaen implements zzaef {
    public final zzfzo zza;
    private final int zzb;

    private zzaen(int i, zzfzo zzfzo) {
        this.zzb = i;
        this.zza = zzfzo;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.ads.zzaen zzc(int r16, com.google.android.gms.internal.ads.zzed r17) {
        /*
            r0 = r17
            com.google.android.gms.internal.ads.zzfzl r1 = new com.google.android.gms.internal.ads.zzfzl
            r1.<init>()
            int r2 = r0.zze()
            r3 = -2
        L_0x000c:
            int r4 = r0.zzb()
            r5 = 8
            if (r4 <= r5) goto L_0x018e
            int r4 = r0.zzi()
            int r5 = r0.zzi()
            int r6 = r0.zzd()
            int r6 = r6 + r5
            r0.zzK(r6)
            r5 = 1414744396(0x5453494c, float:3.62987127E12)
            r7 = 2
            r8 = 1
            if (r4 != r5) goto L_0x0035
            int r4 = r0.zzi()
            com.google.android.gms.internal.ads.zzaen r4 = zzc(r4, r0)
            goto L_0x014a
        L_0x0035:
            r5 = 0
            switch(r4) {
                case 1718776947: goto L_0x004e;
                case 1751742049: goto L_0x0048;
                case 1752331379: goto L_0x0042;
                case 1852994675: goto L_0x003c;
                default: goto L_0x0039;
            }
        L_0x0039:
            r4 = r5
            goto L_0x014a
        L_0x003c:
            com.google.android.gms.internal.ads.zzaep r4 = com.google.android.gms.internal.ads.zzaep.zzb(r0)
            goto L_0x014a
        L_0x0042:
            com.google.android.gms.internal.ads.zzael r4 = com.google.android.gms.internal.ads.zzael.zzb(r0)
            goto L_0x014a
        L_0x0048:
            com.google.android.gms.internal.ads.zzaek r4 = com.google.android.gms.internal.ads.zzaek.zzb(r0)
            goto L_0x014a
        L_0x004e:
            java.lang.String r4 = "StreamFormatChunk"
            if (r3 != r7) goto L_0x00a4
            r9 = 4
            r0.zzM(r9)
            int r10 = r0.zzi()
            int r11 = r0.zzi()
            r0.zzM(r9)
            int r9 = r0.zzi()
            switch(r9) {
                case 808802372: goto L_0x0076;
                case 826496577: goto L_0x0073;
                case 828601953: goto L_0x0073;
                case 842289229: goto L_0x0070;
                case 859066445: goto L_0x006d;
                case 875967048: goto L_0x0073;
                case 877677894: goto L_0x0076;
                case 1145656883: goto L_0x0076;
                case 1145656920: goto L_0x0076;
                case 1196444237: goto L_0x006a;
                case 1482049860: goto L_0x0076;
                case 1684633208: goto L_0x0076;
                case 1735420525: goto L_0x006a;
                case 2021026148: goto L_0x0076;
                default: goto L_0x0068;
            }
        L_0x0068:
            r12 = r5
            goto L_0x0078
        L_0x006a:
            java.lang.String r12 = "video/mjpeg"
            goto L_0x0078
        L_0x006d:
            java.lang.String r12 = "video/mp43"
            goto L_0x0078
        L_0x0070:
            java.lang.String r12 = "video/mp42"
            goto L_0x0078
        L_0x0073:
            java.lang.String r12 = "video/avc"
            goto L_0x0078
        L_0x0076:
            java.lang.String r12 = "video/mp4v-es"
        L_0x0078:
            if (r12 != 0) goto L_0x008c
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            java.lang.String r11 = "Ignoring track with unsupported compression "
            r10.<init>(r11)
            r10.append(r9)
            java.lang.String r9 = r10.toString()
            com.google.android.gms.internal.ads.zzdt.zzf(r4, r9)
            goto L_0x0039
        L_0x008c:
            com.google.android.gms.internal.ads.zzab r4 = new com.google.android.gms.internal.ads.zzab
            r4.<init>()
            r4.zzae(r10)
            r4.zzJ(r11)
            r4.zzZ(r12)
            com.google.android.gms.internal.ads.zzaeo r5 = new com.google.android.gms.internal.ads.zzaeo
            com.google.android.gms.internal.ads.zzad r4 = r4.zzaf()
            r5.<init>(r4)
            goto L_0x0039
        L_0x00a4:
            if (r3 != r8) goto L_0x013b
            int r9 = r0.zzk()
            java.lang.String r10 = "audio/mp4a-latm"
            java.lang.String r11 = "audio/raw"
            if (r9 == r8) goto L_0x00cd
            r12 = 85
            if (r9 == r12) goto L_0x00ca
            r12 = 255(0xff, float:3.57E-43)
            if (r9 == r12) goto L_0x00c8
            r12 = 8192(0x2000, float:1.14794E-41)
            if (r9 == r12) goto L_0x00c5
            r12 = 8193(0x2001, float:1.1481E-41)
            if (r9 == r12) goto L_0x00c2
            r12 = r5
            goto L_0x00ce
        L_0x00c2:
            java.lang.String r12 = "audio/vnd.dts"
            goto L_0x00ce
        L_0x00c5:
            java.lang.String r12 = "audio/ac3"
            goto L_0x00ce
        L_0x00c8:
            r12 = r10
            goto L_0x00ce
        L_0x00ca:
            java.lang.String r12 = "audio/mpeg"
            goto L_0x00ce
        L_0x00cd:
            r12 = r11
        L_0x00ce:
            if (r12 != 0) goto L_0x00e3
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            java.lang.String r11 = "Ignoring track with unsupported format tag "
            r10.<init>(r11)
            r10.append(r9)
            java.lang.String r9 = r10.toString()
            com.google.android.gms.internal.ads.zzdt.zzf(r4, r9)
            goto L_0x0039
        L_0x00e3:
            int r4 = r0.zzk()
            int r5 = r0.zzi()
            r9 = 6
            r0.zzM(r9)
            int r9 = r0.zzk()
            int r9 = com.google.android.gms.internal.ads.zzen.zzn(r9)
            int r13 = r0.zzb()
            r14 = 0
            if (r13 <= 0) goto L_0x0103
            int r13 = r0.zzk()
            goto L_0x0104
        L_0x0103:
            r13 = r14
        L_0x0104:
            byte[] r15 = new byte[r13]
            r0.zzH(r15, r14, r13)
            com.google.android.gms.internal.ads.zzab r14 = new com.google.android.gms.internal.ads.zzab
            r14.<init>()
            r14.zzZ(r12)
            r14.zzz(r4)
            r14.zzaa(r5)
            boolean r4 = r11.equals(r12)
            if (r4 == 0) goto L_0x0122
            if (r9 == 0) goto L_0x0122
            r14.zzT(r9)
        L_0x0122:
            boolean r4 = r10.equals(r12)
            if (r4 == 0) goto L_0x0131
            if (r13 <= 0) goto L_0x0131
            com.google.android.gms.internal.ads.zzfzo r4 = com.google.android.gms.internal.ads.zzfzo.zzo(r15)
            r14.zzM(r4)
        L_0x0131:
            com.google.android.gms.internal.ads.zzaeo r4 = new com.google.android.gms.internal.ads.zzaeo
            com.google.android.gms.internal.ads.zzad r5 = r14.zzaf()
            r4.<init>(r5)
            goto L_0x014a
        L_0x013b:
            java.lang.String r9 = "Ignoring strf box for unsupported track type: "
            java.lang.String r10 = com.google.android.gms.internal.ads.zzen.zzD(r3)
            java.lang.String r9 = r9.concat(r10)
            com.google.android.gms.internal.ads.zzdt.zzf(r4, r9)
            goto L_0x0039
        L_0x014a:
            if (r4 == 0) goto L_0x0186
            int r5 = r4.zza()
            r9 = 1752331379(0x68727473, float:4.5798432E24)
            if (r5 != r9) goto L_0x0183
            r3 = r4
            com.google.android.gms.internal.ads.zzael r3 = (com.google.android.gms.internal.ads.zzael) r3
            int r3 = r3.zza
            r5 = 1935960438(0x73646976, float:1.809666E31)
            if (r3 == r5) goto L_0x0182
            r5 = 1935963489(0x73647561, float:1.8100348E31)
            if (r3 == r5) goto L_0x0180
            r5 = 1937012852(0x73747874, float:1.936895E31)
            if (r3 == r5) goto L_0x017e
            java.lang.String r3 = java.lang.Integer.toHexString(r3)
            java.lang.String r3 = java.lang.String.valueOf(r3)
            java.lang.String r5 = "AviStreamHeaderChunk"
            java.lang.String r7 = "Found unsupported streamType fourCC: "
            java.lang.String r3 = r7.concat(r3)
            com.google.android.gms.internal.ads.zzdt.zzf(r5, r3)
            r3 = -1
            goto L_0x0183
        L_0x017e:
            r3 = 3
            goto L_0x0183
        L_0x0180:
            r3 = r8
            goto L_0x0183
        L_0x0182:
            r3 = r7
        L_0x0183:
            r1.zzf(r4)
        L_0x0186:
            r0.zzL(r6)
            r0.zzK(r2)
            goto L_0x000c
        L_0x018e:
            com.google.android.gms.internal.ads.zzaen r0 = new com.google.android.gms.internal.ads.zzaen
            com.google.android.gms.internal.ads.zzfzo r1 = r1.zzi()
            r2 = r16
            r0.<init>(r2, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaen.zzc(int, com.google.android.gms.internal.ads.zzed):com.google.android.gms.internal.ads.zzaen");
    }

    public final int zza() {
        return this.zzb;
    }

    public final zzaef zzb(Class cls) {
        zzfzo zzfzo = this.zza;
        int size = zzfzo.size();
        int i = 0;
        while (i < size) {
            zzaef zzaef = (zzaef) zzfzo.get(i);
            i++;
            if (zzaef.getClass() == cls) {
                return zzaef;
            }
        }
        return null;
    }
}
