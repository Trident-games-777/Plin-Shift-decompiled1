package com.google.android.gms.internal.ads;

import java.util.regex.Pattern;
import kotlinx.coroutines.DebugKt;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzale {
    private static final Pattern zzd = Pattern.compile("\\s+");
    private static final zzfzt zze = zzfzt.zzp(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "none");
    private static final zzfzt zzf = zzfzt.zzq("dot", "sesame", "circle");
    private static final zzfzt zzg = zzfzt.zzp("filled", "open");
    private static final zzfzt zzh = zzfzt.zzq("after", "before", "outside");
    public final int zza;
    public final int zzb;
    public final int zzc;

    private zzale(int i, int i2, int i3) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = i3;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0085  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.ads.zzale zza(java.lang.String r8) {
        /*
            if (r8 != 0) goto L_0x0004
            goto L_0x00f6
        L_0x0004:
            java.lang.String r8 = r8.trim()
            java.lang.String r8 = com.google.android.gms.internal.ads.zzfwa.zza(r8)
            boolean r0 = r8.isEmpty()
            if (r0 != 0) goto L_0x00f6
            java.util.regex.Pattern r0 = zzd
            java.lang.String[] r8 = android.text.TextUtils.split(r8, r0)
            com.google.android.gms.internal.ads.zzfzt r8 = com.google.android.gms.internal.ads.zzfzt.zzm(r8)
            com.google.android.gms.internal.ads.zzfzt r0 = zzh
            com.google.android.gms.internal.ads.zzgbo r0 = com.google.android.gms.internal.ads.zzgbq.zzb(r0, r8)
            java.lang.String r1 = "outside"
            java.lang.Object r0 = com.google.android.gms.internal.ads.zzfzu.zza(r0, r1)
            java.lang.String r0 = (java.lang.String) r0
            int r2 = r0.hashCode()
            r3 = -1106037339(0xffffffffbe1335a5, float:-0.14375933)
            r4 = -1
            r5 = 0
            r6 = 1
            if (r2 == r3) goto L_0x0046
            r1 = 92734940(0x58705dc, float:1.2697491E-35)
            if (r2 == r1) goto L_0x003c
            goto L_0x004e
        L_0x003c:
            java.lang.String r1 = "after"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x004e
            r0 = r5
            goto L_0x004f
        L_0x0046:
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x004e
            r0 = r6
            goto L_0x004f
        L_0x004e:
            r0 = r4
        L_0x004f:
            r1 = 2
            if (r0 == 0) goto L_0x0058
            if (r0 == r6) goto L_0x0056
            r0 = r6
            goto L_0x0059
        L_0x0056:
            r0 = -2
            goto L_0x0059
        L_0x0058:
            r0 = r1
        L_0x0059:
            com.google.android.gms.internal.ads.zzfzt r2 = zze
            com.google.android.gms.internal.ads.zzgbo r2 = com.google.android.gms.internal.ads.zzgbq.zzb(r2, r8)
            boolean r3 = r2.isEmpty()
            if (r3 != 0) goto L_0x0085
            java.util.Iterator r8 = r2.iterator()
            java.lang.Object r8 = r8.next()
            java.lang.String r8 = (java.lang.String) r8
            int r1 = r8.hashCode()
            r2 = 3387192(0x33af38, float:4.746467E-39)
            if (r1 == r2) goto L_0x007a
            goto L_0x00f0
        L_0x007a:
            java.lang.String r1 = "none"
            boolean r8 = r8.equals(r1)
            if (r8 == 0) goto L_0x00f0
            r4 = r5
            goto L_0x00f0
        L_0x0085:
            com.google.android.gms.internal.ads.zzfzt r2 = zzg
            com.google.android.gms.internal.ads.zzgbo r2 = com.google.android.gms.internal.ads.zzgbq.zzb(r2, r8)
            com.google.android.gms.internal.ads.zzfzt r3 = zzf
            com.google.android.gms.internal.ads.zzgbo r8 = com.google.android.gms.internal.ads.zzgbq.zzb(r3, r8)
            boolean r3 = r2.isEmpty()
            if (r3 == 0) goto L_0x009e
            boolean r3 = r8.isEmpty()
            if (r3 == 0) goto L_0x009e
            goto L_0x00f0
        L_0x009e:
            java.lang.String r3 = "filled"
            java.lang.Object r2 = com.google.android.gms.internal.ads.zzfzu.zza(r2, r3)
            java.lang.String r2 = (java.lang.String) r2
            int r3 = r2.hashCode()
            r7 = 3417674(0x34264a, float:4.789181E-39)
            if (r3 == r7) goto L_0x00b0
            goto L_0x00ba
        L_0x00b0:
            java.lang.String r3 = "open"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x00ba
            r2 = r1
            goto L_0x00bb
        L_0x00ba:
            r2 = r6
        L_0x00bb:
            java.lang.String r3 = "circle"
            java.lang.Object r8 = com.google.android.gms.internal.ads.zzfzu.zza(r8, r3)
            java.lang.String r8 = (java.lang.String) r8
            int r3 = r8.hashCode()
            r7 = -905816648(0xffffffffca0255b8, float:-2135406.0)
            if (r3 == r7) goto L_0x00dc
            r7 = 99657(0x18549, float:1.39649E-40)
            if (r3 == r7) goto L_0x00d2
            goto L_0x00e5
        L_0x00d2:
            java.lang.String r3 = "dot"
            boolean r8 = r8.equals(r3)
            if (r8 == 0) goto L_0x00e5
            r4 = r5
            goto L_0x00e5
        L_0x00dc:
            java.lang.String r3 = "sesame"
            boolean r8 = r8.equals(r3)
            if (r8 == 0) goto L_0x00e5
            r4 = r6
        L_0x00e5:
            if (r4 == 0) goto L_0x00ee
            if (r4 == r6) goto L_0x00ec
            r5 = r2
            r4 = r6
            goto L_0x00f0
        L_0x00ec:
            r4 = 3
            goto L_0x00ef
        L_0x00ee:
            r4 = r1
        L_0x00ef:
            r5 = r2
        L_0x00f0:
            com.google.android.gms.internal.ads.zzale r8 = new com.google.android.gms.internal.ads.zzale
            r8.<init>(r4, r5, r0)
            return r8
        L_0x00f6:
            r8 = 0
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzale.zza(java.lang.String):com.google.android.gms.internal.ads.zzale");
    }
}
