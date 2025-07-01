package com.google.android.gms.internal.ads;

import android.text.TextUtils;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzbcx extends zzbcy {
    zzbcx() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0034, code lost:
        if (r0 != r6.length()) goto L_0x0039;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final java.lang.String zzb(java.lang.String r6) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r6)
            if (r0 == 0) goto L_0x0007
            goto L_0x0037
        L_0x0007:
            int r0 = r6.length()
            r1 = 0
            r2 = r1
        L_0x000d:
            int r3 = r6.length()
            r4 = 44
            if (r2 >= r3) goto L_0x001e
            char r3 = r6.charAt(r2)
            if (r3 != r4) goto L_0x001e
            int r2 = r2 + 1
            goto L_0x000d
        L_0x001e:
            if (r0 <= 0) goto L_0x002a
            int r3 = r0 + -1
            char r5 = r6.charAt(r3)
            if (r5 != r4) goto L_0x002a
            r0 = r3
            goto L_0x001e
        L_0x002a:
            if (r0 >= r2) goto L_0x002e
            r6 = 0
            return r6
        L_0x002e:
            if (r2 != 0) goto L_0x0038
            int r2 = r6.length()
            if (r0 == r2) goto L_0x0037
            goto L_0x0039
        L_0x0037:
            return r6
        L_0x0038:
            r1 = r2
        L_0x0039:
            java.lang.String r6 = r6.substring(r1, r0)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbcx.zzb(java.lang.String):java.lang.String");
    }

    public final String zza(String str, String str2) {
        String zzb = zzb(str);
        String zzb2 = zzb(str2);
        if (TextUtils.isEmpty(zzb)) {
            return zzb2;
        }
        if (TextUtils.isEmpty(zzb2)) {
            return zzb;
        }
        return zzb + "," + zzb2;
    }
}
