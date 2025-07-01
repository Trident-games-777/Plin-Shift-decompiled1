package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzacy {
    public static int zza(zzed zzed, int i) {
        switch (i) {
            case 1:
                return 192;
            case 2:
            case 3:
            case 4:
            case 5:
                return 576 << (i - 2);
            case 6:
                return zzed.zzm() + 1;
            case 7:
                return zzed.zzq() + 1;
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                return 256 << (i - 8);
            default:
                return -1;
        }
    }

    public static long zzb(zzacs zzacs, zzadc zzadc) throws IOException {
        zzacs.zzj();
        zzacs.zzg(1);
        byte[] bArr = new byte[1];
        zzacs.zzh(bArr, 0, 1);
        byte b = bArr[0] & 1;
        boolean z = 1 == b;
        zzacs.zzg(2);
        int i = 1 != b ? 6 : 7;
        zzed zzed = new zzed(i);
        zzed.zzK(zzacv.zza(zzacs, zzed.zzN(), 0, i));
        zzacs.zzj();
        zzacx zzacx = new zzacx();
        if (zzd(zzed, zzadc, z, zzacx)) {
            return zzacx.zza;
        }
        throw zzbh.zza((String) null, (Throwable) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x007f, code lost:
        if (r3 != r1.zzf) goto L_0x00af;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x008a, code lost:
        if ((r0.zzm() * 1000) == r5) goto L_0x009b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0099, code lost:
        if (r4 == r5) goto L_0x009b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean zzc(com.google.android.gms.internal.ads.zzed r23, com.google.android.gms.internal.ads.zzadc r24, int r25, com.google.android.gms.internal.ads.zzacx r26) {
        /*
            r0 = r23
            r1 = r24
            int r2 = r0.zzd()
            long r3 = r0.zzu()
            r5 = 16
            long r5 = r3 >>> r5
            r7 = r25
            long r7 = (long) r7
            int r7 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            r8 = 0
            if (r7 == 0) goto L_0x0019
            return r8
        L_0x0019:
            r9 = 1
            long r5 = r5 & r9
            int r5 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
            r6 = 1
            if (r5 != 0) goto L_0x0023
            r5 = r6
            goto L_0x0024
        L_0x0023:
            r5 = r8
        L_0x0024:
            r7 = 12
            long r11 = r3 >> r7
            r13 = 8
            long r13 = r3 >> r13
            r15 = 4
            long r15 = r3 >> r15
            long r17 = r3 >> r6
            long r3 = r3 & r9
            r19 = 15
            r21 = r9
            long r9 = r15 & r19
            int r9 = (int) r9
            r10 = 7
            r15 = -1
            if (r9 > r10) goto L_0x0043
            int r10 = r1.zzg
            int r10 = r10 + r15
            if (r9 != r10) goto L_0x00af
            goto L_0x004c
        L_0x0043:
            r10 = 10
            if (r9 > r10) goto L_0x00af
            int r9 = r1.zzg
            r10 = 2
            if (r9 != r10) goto L_0x00af
        L_0x004c:
            r9 = 7
            long r9 = r17 & r9
            int r9 = (int) r9
            if (r9 != 0) goto L_0x0054
            goto L_0x0058
        L_0x0054:
            int r10 = r1.zzi
            if (r9 != r10) goto L_0x00af
        L_0x0058:
            int r3 = (r3 > r21 ? 1 : (r3 == r21 ? 0 : -1))
            if (r3 == 0) goto L_0x00af
            r3 = r26
            boolean r3 = zzd(r0, r1, r5, r3)
            if (r3 == 0) goto L_0x00af
            long r3 = r11 & r19
            int r3 = (int) r3
            int r3 = zza(r0, r3)
            if (r3 == r15) goto L_0x00af
            int r4 = r1.zzb
            if (r3 > r4) goto L_0x00af
            long r3 = r13 & r19
            int r5 = r1.zze
            int r3 = (int) r3
            if (r3 != 0) goto L_0x0079
            goto L_0x009b
        L_0x0079:
            r4 = 11
            if (r3 > r4) goto L_0x0082
            int r1 = r1.zzf
            if (r3 == r1) goto L_0x009b
            goto L_0x00af
        L_0x0082:
            if (r3 != r7) goto L_0x008d
            int r1 = r0.zzm()
            int r1 = r1 * 1000
            if (r1 != r5) goto L_0x00af
            goto L_0x009b
        L_0x008d:
            r1 = 14
            if (r3 > r1) goto L_0x00af
            int r4 = r0.zzq()
            if (r3 != r1) goto L_0x0099
            int r4 = r4 * 10
        L_0x0099:
            if (r4 != r5) goto L_0x00af
        L_0x009b:
            int r1 = r0.zzm()
            int r3 = r0.zzd()
            byte[] r0 = r0.zzN()
            int r3 = r3 + r15
            int r0 = com.google.android.gms.internal.ads.zzen.zzg(r0, r2, r3, r8)
            if (r1 != r0) goto L_0x00af
            return r6
        L_0x00af:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzacy.zzc(com.google.android.gms.internal.ads.zzed, com.google.android.gms.internal.ads.zzadc, int, com.google.android.gms.internal.ads.zzacx):boolean");
    }

    private static boolean zzd(zzed zzed, zzadc zzadc, boolean z, zzacx zzacx) {
        try {
            long zzx = zzed.zzx();
            if (!z) {
                zzx *= (long) zzadc.zzb;
            }
            zzacx.zza = zzx;
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }
}
