package com.google.android.gms.internal.ads;

import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzafl {
    private static final String[] zza = {"Camera:MotionPhoto", "GCamera:MotionPhoto", "Camera:MicroVideo", "GCamera:MicroVideo"};
    private static final String[] zzb = {"Camera:MotionPhotoPresentationTimestampUs", "GCamera:MotionPhotoPresentationTimestampUs", "Camera:MicroVideoPresentationTimestampUs", "GCamera:MicroVideoPresentationTimestampUs"};
    private static final String[] zzc = {"Camera:MicroVideoOffset", "GCamera:MicroVideoOffset"};

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0088, code lost:
        r7 = -9223372036854775807L;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.ads.zzafh zza(java.lang.String r22) throws java.io.IOException {
        /*
            java.lang.String r0 = "x:xmpmeta"
            r1 = 0
            org.xmlpull.v1.XmlPullParserFactory r2 = org.xmlpull.v1.XmlPullParserFactory.newInstance()     // Catch:{ zzbh | NumberFormatException | XmlPullParserException -> 0x00df }
            org.xmlpull.v1.XmlPullParser r2 = r2.newPullParser()     // Catch:{ zzbh | NumberFormatException | XmlPullParserException -> 0x00df }
            java.io.StringReader r3 = new java.io.StringReader     // Catch:{ zzbh | NumberFormatException | XmlPullParserException -> 0x00df }
            r4 = r22
            r3.<init>(r4)     // Catch:{ zzbh | NumberFormatException | XmlPullParserException -> 0x00df }
            r2.setInput(r3)     // Catch:{ zzbh | NumberFormatException | XmlPullParserException -> 0x00df }
            r2.next()     // Catch:{ zzbh | NumberFormatException | XmlPullParserException -> 0x00df }
            boolean r3 = com.google.android.gms.internal.ads.zzeo.zzc(r2, r0)     // Catch:{ zzbh | NumberFormatException | XmlPullParserException -> 0x00df }
            if (r3 == 0) goto L_0x00d8
            com.google.android.gms.internal.ads.zzfzo r3 = com.google.android.gms.internal.ads.zzfzo.zzn()     // Catch:{ zzbh | NumberFormatException | XmlPullParserException -> 0x00df }
            r4 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r6 = r4
        L_0x0028:
            r2.next()     // Catch:{ zzbh | NumberFormatException | XmlPullParserException -> 0x00df }
            java.lang.String r8 = "rdf:Description"
            boolean r8 = com.google.android.gms.internal.ads.zzeo.zzc(r2, r8)     // Catch:{ zzbh | NumberFormatException | XmlPullParserException -> 0x00df }
            if (r8 != 0) goto L_0x0057
            java.lang.String r8 = "Container:Directory"
            boolean r8 = com.google.android.gms.internal.ads.zzeo.zzc(r2, r8)     // Catch:{ zzbh | NumberFormatException | XmlPullParserException -> 0x00df }
            if (r8 == 0) goto L_0x0045
            java.lang.String r3 = "Container"
            java.lang.String r8 = "Item"
            com.google.android.gms.internal.ads.zzfzo r3 = zzb(r2, r3, r8)     // Catch:{ zzbh | NumberFormatException | XmlPullParserException -> 0x00df }
            goto L_0x00c0
        L_0x0045:
            java.lang.String r8 = "GContainer:Directory"
            boolean r8 = com.google.android.gms.internal.ads.zzeo.zzc(r2, r8)     // Catch:{ zzbh | NumberFormatException | XmlPullParserException -> 0x00df }
            if (r8 == 0) goto L_0x00c0
            java.lang.String r3 = "GContainer"
            java.lang.String r8 = "GContainerItem"
            com.google.android.gms.internal.ads.zzfzo r3 = zzb(r2, r3, r8)     // Catch:{ zzbh | NumberFormatException | XmlPullParserException -> 0x00df }
            goto L_0x00c0
        L_0x0057:
            java.lang.String[] r3 = zza     // Catch:{ zzbh | NumberFormatException | XmlPullParserException -> 0x00df }
            r6 = 0
            r7 = r6
        L_0x005b:
            r8 = 4
            if (r7 >= r8) goto L_0x00d7
            r9 = r3[r7]     // Catch:{ zzbh | NumberFormatException | XmlPullParserException -> 0x00df }
            java.lang.String r9 = com.google.android.gms.internal.ads.zzeo.zza(r2, r9)     // Catch:{ zzbh | NumberFormatException | XmlPullParserException -> 0x00df }
            if (r9 == 0) goto L_0x00d4
            int r3 = java.lang.Integer.parseInt(r9)     // Catch:{ zzbh | NumberFormatException | XmlPullParserException -> 0x00df }
            r7 = 1
            if (r3 != r7) goto L_0x00d3
            java.lang.String[] r3 = zzb     // Catch:{ zzbh | NumberFormatException | XmlPullParserException -> 0x00df }
            r7 = r6
        L_0x0070:
            if (r7 >= r8) goto L_0x0088
            r9 = r3[r7]     // Catch:{ zzbh | NumberFormatException | XmlPullParserException -> 0x00df }
            java.lang.String r9 = com.google.android.gms.internal.ads.zzeo.zza(r2, r9)     // Catch:{ zzbh | NumberFormatException | XmlPullParserException -> 0x00df }
            if (r9 == 0) goto L_0x0085
            long r7 = java.lang.Long.parseLong(r9)     // Catch:{ zzbh | NumberFormatException | XmlPullParserException -> 0x00df }
            r9 = -1
            int r3 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r3 != 0) goto L_0x0089
            goto L_0x0088
        L_0x0085:
            int r7 = r7 + 1
            goto L_0x0070
        L_0x0088:
            r7 = r4
        L_0x0089:
            java.lang.String[] r3 = zzc     // Catch:{ zzbh | NumberFormatException | XmlPullParserException -> 0x00df }
        L_0x008b:
            r9 = 2
            if (r6 >= r9) goto L_0x00bb
            r9 = r3[r6]     // Catch:{ zzbh | NumberFormatException | XmlPullParserException -> 0x00df }
            java.lang.String r9 = com.google.android.gms.internal.ads.zzeo.zza(r2, r9)     // Catch:{ zzbh | NumberFormatException | XmlPullParserException -> 0x00df }
            if (r9 == 0) goto L_0x00b8
            long r13 = java.lang.Long.parseLong(r9)     // Catch:{ zzbh | NumberFormatException | XmlPullParserException -> 0x00df }
            com.google.android.gms.internal.ads.zzafg r15 = new com.google.android.gms.internal.ads.zzafg     // Catch:{ zzbh | NumberFormatException | XmlPullParserException -> 0x00df }
            java.lang.String r16 = "image/jpeg"
            java.lang.String r17 = "Primary"
            r18 = 0
            r20 = 0
            r15.<init>(r16, r17, r18, r20)     // Catch:{ zzbh | NumberFormatException | XmlPullParserException -> 0x00df }
            r3 = r15
            com.google.android.gms.internal.ads.zzafg r10 = new com.google.android.gms.internal.ads.zzafg     // Catch:{ zzbh | NumberFormatException | XmlPullParserException -> 0x00df }
            java.lang.String r11 = "video/mp4"
            java.lang.String r12 = "MotionPhoto"
            r15 = 0
            r10.<init>(r11, r12, r13, r15)     // Catch:{ zzbh | NumberFormatException | XmlPullParserException -> 0x00df }
            com.google.android.gms.internal.ads.zzfzo r3 = com.google.android.gms.internal.ads.zzfzo.zzp(r3, r10)     // Catch:{ zzbh | NumberFormatException | XmlPullParserException -> 0x00df }
            goto L_0x00bf
        L_0x00b8:
            int r6 = r6 + 1
            goto L_0x008b
        L_0x00bb:
            com.google.android.gms.internal.ads.zzfzo r3 = com.google.android.gms.internal.ads.zzfzo.zzn()     // Catch:{ zzbh | NumberFormatException | XmlPullParserException -> 0x00df }
        L_0x00bf:
            r6 = r7
        L_0x00c0:
            boolean r8 = com.google.android.gms.internal.ads.zzeo.zzb(r2, r0)     // Catch:{ zzbh | NumberFormatException | XmlPullParserException -> 0x00df }
            if (r8 == 0) goto L_0x0028
            boolean r0 = r3.isEmpty()     // Catch:{ zzbh | NumberFormatException | XmlPullParserException -> 0x00df }
            if (r0 == 0) goto L_0x00cd
            return r1
        L_0x00cd:
            com.google.android.gms.internal.ads.zzafh r0 = new com.google.android.gms.internal.ads.zzafh     // Catch:{ zzbh | NumberFormatException | XmlPullParserException -> 0x00df }
            r0.<init>(r6, r3)     // Catch:{ zzbh | NumberFormatException | XmlPullParserException -> 0x00df }
            return r0
        L_0x00d3:
            return r1
        L_0x00d4:
            int r7 = r7 + 1
            goto L_0x005b
        L_0x00d7:
            return r1
        L_0x00d8:
            java.lang.String r0 = "Couldn't find xmp metadata"
            com.google.android.gms.internal.ads.zzbh r0 = com.google.android.gms.internal.ads.zzbh.zza(r0, r1)     // Catch:{ zzbh | NumberFormatException | XmlPullParserException -> 0x00df }
            throw r0     // Catch:{ zzbh | NumberFormatException | XmlPullParserException -> 0x00df }
        L_0x00df:
            java.lang.String r0 = "MotionPhotoXmpParser"
            java.lang.String r2 = "Ignoring unexpected XMP metadata"
            com.google.android.gms.internal.ads.zzdt.zzf(r0, r2)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzafl.zza(java.lang.String):com.google.android.gms.internal.ads.zzafh");
    }

    private static zzfzo zzb(XmlPullParser xmlPullParser, String str, String str2) throws XmlPullParserException, IOException {
        zzfzl zzfzl = new zzfzl();
        do {
            String concat = str.concat(":Item");
            xmlPullParser.next();
            if (zzeo.zzc(xmlPullParser, concat)) {
                String concat2 = str2.concat(":Mime");
                String concat3 = str2.concat(":Semantic");
                String concat4 = str2.concat(":Length");
                String concat5 = str2.concat(":Padding");
                String zza2 = zzeo.zza(xmlPullParser, concat2);
                String zza3 = zzeo.zza(xmlPullParser, concat3);
                String zza4 = zzeo.zza(xmlPullParser, concat4);
                String zza5 = zzeo.zza(xmlPullParser, concat5);
                if (zza2 == null || zza3 == null) {
                    return zzfzo.zzn();
                }
                long j = 0;
                long parseLong = zza4 != null ? Long.parseLong(zza4) : 0;
                if (zza5 != null) {
                    j = Long.parseLong(zza5);
                }
                zzfzl.zzf(new zzafg(zza2, zza3, parseLong, j));
            }
        } while (!zzeo.zzb(xmlPullParser, str.concat(":Directory")));
        return zzfzl.zzi();
    }
}
