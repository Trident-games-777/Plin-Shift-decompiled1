package com.google.android.gms.internal.ads;

import android.graphics.PointF;
import java.util.Locale;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzala {
    private static final Pattern zzc = Pattern.compile("\\{([^}]*)\\}");
    private static final Pattern zzd = Pattern.compile(String.format(Locale.US, "\\\\pos\\((%1$s),(%1$s)\\)", new Object[]{"\\s*\\d+(?:\\.\\d+)?\\s*"}));
    private static final Pattern zze = Pattern.compile(String.format(Locale.US, "\\\\move\\(%1$s,%1$s,(%1$s),(%1$s)(?:,%1$s,%1$s)?\\)", new Object[]{"\\s*\\d+(?:\\.\\d+)?\\s*"}));
    private static final Pattern zzf = Pattern.compile("\\\\an(\\d+)");
    public final int zza;
    public final PointF zzb;

    private zzala(int i, PointF pointF) {
        this.zza = i;
        this.zzb = pointF;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:20|(1:22)|23|24|(2:26|(1:28)(2:37|29))(1:30)|(2:32|41)(1:40)|35) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x008b */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0097 A[Catch:{ RuntimeException -> 0x000a }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x000a A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.ads.zzala zza(java.lang.String r12) {
        /*
            java.util.regex.Pattern r0 = zzc
            java.util.regex.Matcher r12 = r0.matcher(r12)
            r0 = 0
            r1 = -1
            r3 = r0
            r2 = r1
        L_0x000a:
            boolean r4 = r12.find()
            if (r4 == 0) goto L_0x00ac
            r4 = 1
            java.lang.String r5 = r12.group(r4)
            r5.getClass()
            r6 = r5
            java.lang.String r6 = (java.lang.String) r6
            java.util.regex.Pattern r6 = zzd     // Catch:{ RuntimeException -> 0x008b }
            java.util.regex.Matcher r6 = r6.matcher(r5)     // Catch:{ RuntimeException -> 0x008b }
            java.util.regex.Pattern r7 = zze     // Catch:{ RuntimeException -> 0x008b }
            java.util.regex.Matcher r7 = r7.matcher(r5)     // Catch:{ RuntimeException -> 0x008b }
            boolean r8 = r6.find()     // Catch:{ RuntimeException -> 0x008b }
            boolean r9 = r7.find()     // Catch:{ RuntimeException -> 0x008b }
            r10 = 2
            if (r8 == 0) goto L_0x0058
            if (r9 == 0) goto L_0x004f
            java.lang.String r7 = "SsaStyle.Overrides"
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ RuntimeException -> 0x008b }
            r8.<init>()     // Catch:{ RuntimeException -> 0x008b }
            java.lang.String r9 = "Override has both \\pos(x,y) and \\move(x1,y1,x2,y2); using \\pos values. override='"
            r8.append(r9)     // Catch:{ RuntimeException -> 0x008b }
            r8.append(r5)     // Catch:{ RuntimeException -> 0x008b }
            java.lang.String r9 = "'"
            r8.append(r9)     // Catch:{ RuntimeException -> 0x008b }
            java.lang.String r8 = r8.toString()     // Catch:{ RuntimeException -> 0x008b }
            com.google.android.gms.internal.ads.zzdt.zze(r7, r8)     // Catch:{ RuntimeException -> 0x008b }
        L_0x004f:
            java.lang.String r7 = r6.group(r4)     // Catch:{ RuntimeException -> 0x008b }
            java.lang.String r6 = r6.group(r10)     // Catch:{ RuntimeException -> 0x008b }
            goto L_0x0065
        L_0x0058:
            if (r9 == 0) goto L_0x0087
            java.lang.String r6 = r7.group(r4)     // Catch:{ RuntimeException -> 0x008b }
            java.lang.String r7 = r7.group(r10)     // Catch:{ RuntimeException -> 0x008b }
            r11 = r7
            r7 = r6
            r6 = r11
        L_0x0065:
            android.graphics.PointF r8 = new android.graphics.PointF     // Catch:{ RuntimeException -> 0x008b }
            if (r7 == 0) goto L_0x0086
            r9 = r7
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ RuntimeException -> 0x008b }
            java.lang.String r7 = r7.trim()     // Catch:{ RuntimeException -> 0x008b }
            float r7 = java.lang.Float.parseFloat(r7)     // Catch:{ RuntimeException -> 0x008b }
            if (r6 == 0) goto L_0x0085
            r9 = r6
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ RuntimeException -> 0x008b }
            java.lang.String r6 = r6.trim()     // Catch:{ RuntimeException -> 0x008b }
            float r6 = java.lang.Float.parseFloat(r6)     // Catch:{ RuntimeException -> 0x008b }
            r8.<init>(r7, r6)     // Catch:{ RuntimeException -> 0x008b }
            goto L_0x0088
        L_0x0085:
            throw r0     // Catch:{ RuntimeException -> 0x008b }
        L_0x0086:
            throw r0     // Catch:{ RuntimeException -> 0x008b }
        L_0x0087:
            r8 = r0
        L_0x0088:
            if (r8 == 0) goto L_0x008b
            r3 = r8
        L_0x008b:
            java.util.regex.Pattern r6 = zzf     // Catch:{ RuntimeException -> 0x000a }
            java.util.regex.Matcher r5 = r6.matcher(r5)     // Catch:{ RuntimeException -> 0x000a }
            boolean r6 = r5.find()     // Catch:{ RuntimeException -> 0x000a }
            if (r6 == 0) goto L_0x00a6
            java.lang.String r4 = r5.group(r4)     // Catch:{ RuntimeException -> 0x000a }
            if (r4 == 0) goto L_0x00a5
            r5 = r4
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ RuntimeException -> 0x000a }
            int r4 = com.google.android.gms.internal.ads.zzalb.zzd(r4)     // Catch:{ RuntimeException -> 0x000a }
            goto L_0x00a7
        L_0x00a5:
            throw r0     // Catch:{ RuntimeException -> 0x000a }
        L_0x00a6:
            r4 = r1
        L_0x00a7:
            if (r4 == r1) goto L_0x000a
            r2 = r4
            goto L_0x000a
        L_0x00ac:
            com.google.android.gms.internal.ads.zzala r12 = new com.google.android.gms.internal.ads.zzala
            r12.<init>(r2, r3)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzala.zza(java.lang.String):com.google.android.gms.internal.ads.zzala");
    }

    public static String zzb(String str) {
        return zzc.matcher(str).replaceAll("");
    }
}
