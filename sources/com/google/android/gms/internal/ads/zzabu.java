package com.google.android.gms.internal.ads;

import com.google.common.primitives.SignedBytes;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzabu {
    public static final /* synthetic */ int zza = 0;
    private static final int[] zzb = {2002, 2000, 1920, 1601, 1600, 1001, 1000, 960, 800, 800, 480, 400, 400, 2048};

    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0090, code lost:
        if (r11 != 11) goto L_0x009e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0095, code lost:
        if (r11 != 11) goto L_0x009e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x009a, code lost:
        if (r11 != 8) goto L_0x009e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.ads.zzabs zza(com.google.android.gms.internal.ads.zzec r11) {
        /*
            r0 = 16
            int r1 = r11.zzd(r0)
            int r0 = r11.zzd(r0)
            r2 = 65535(0xffff, float:9.1834E-41)
            r3 = 4
            if (r0 != r2) goto L_0x0018
            r0 = 24
            int r0 = r11.zzd(r0)
            r2 = 7
            goto L_0x0019
        L_0x0018:
            r2 = r3
        L_0x0019:
            int r0 = r0 + r2
            r2 = 44097(0xac41, float:6.1793E-41)
            if (r1 != r2) goto L_0x0021
            int r0 = r0 + 2
        L_0x0021:
            r8 = r0
            r0 = 2
            int r1 = r11.zzd(r0)
            r2 = 0
            r4 = 3
            if (r1 != r4) goto L_0x003d
            r1 = r2
        L_0x002c:
            int r5 = r11.zzd(r0)
            int r1 = r1 + r5
            boolean r5 = r11.zzp()
            if (r5 != 0) goto L_0x0039
            int r1 = r1 + r4
            goto L_0x003d
        L_0x0039:
            int r1 = r1 + 1
            int r1 = r1 << r0
            goto L_0x002c
        L_0x003d:
            r5 = r1
            r1 = 10
            int r1 = r11.zzd(r1)
            boolean r6 = r11.zzp()
            if (r6 == 0) goto L_0x0053
            int r6 = r11.zzd(r4)
            if (r6 <= 0) goto L_0x0053
            r11.zzn(r0)
        L_0x0053:
            boolean r6 = r11.zzp()
            r7 = 44100(0xac44, float:6.1797E-41)
            r9 = 48000(0xbb80, float:6.7262E-41)
            r10 = 1
            if (r10 == r6) goto L_0x0062
            r6 = r7
            goto L_0x0064
        L_0x0062:
            r6 = r7
            r7 = r9
        L_0x0064:
            int r11 = r11.zzd(r3)
            if (r7 != r6) goto L_0x0073
            r6 = 13
            if (r11 != r6) goto L_0x0073
            int[] r11 = zzb
            r2 = r11[r6]
            goto L_0x009e
        L_0x0073:
            if (r7 != r9) goto L_0x009e
            r6 = 14
            if (r11 >= r6) goto L_0x009e
            int[] r2 = zzb
            r2 = r2[r11]
            int r1 = r1 % 5
            r6 = 8
            if (r1 == r10) goto L_0x0098
            r9 = 11
            if (r1 == r0) goto L_0x0093
            if (r1 == r4) goto L_0x0098
            if (r1 == r3) goto L_0x008c
            goto L_0x009e
        L_0x008c:
            if (r11 == r4) goto L_0x009c
            if (r11 == r6) goto L_0x009c
            if (r11 != r9) goto L_0x009e
            goto L_0x009c
        L_0x0093:
            if (r11 == r6) goto L_0x009c
            if (r11 != r9) goto L_0x009e
            goto L_0x009c
        L_0x0098:
            if (r11 == r4) goto L_0x009c
            if (r11 != r6) goto L_0x009e
        L_0x009c:
            int r2 = r2 + 1
        L_0x009e:
            r9 = r2
            com.google.android.gms.internal.ads.zzabs r4 = new com.google.android.gms.internal.ads.zzabs
            r6 = 2
            r10 = 0
            r4.<init>(r5, r6, r7, r8, r9, r10)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzabu.zza(com.google.android.gms.internal.ads.zzec):com.google.android.gms.internal.ads.zzabs");
    }

    public static void zzb(int i, zzed zzed) {
        zzed.zzI(7);
        byte[] zzN = zzed.zzN();
        zzN[0] = -84;
        zzN[1] = SignedBytes.MAX_POWER_OF_TWO;
        zzN[2] = -1;
        zzN[3] = -1;
        zzN[4] = (byte) ((i >> 16) & 255);
        zzN[5] = (byte) ((i >> 8) & 255);
        zzN[6] = (byte) (i & 255);
    }
}
