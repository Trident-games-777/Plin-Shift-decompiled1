package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.content.pm.PackageManager;
import com.google.common.base.Optional;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.1.2 */
public final class zzhi {
    private static volatile Optional<Boolean> zza = Optional.absent();
    private static final Object zzb = new Object();

    private static boolean zza(Context context) {
        try {
            if ((context.getPackageManager().getApplicationInfo("com.google.android.gms", 0).flags & 129) != 0) {
                return true;
            }
            return false;
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x007f, code lost:
        if ("com.google.android.gms".equals(r0.packageName) != false) goto L_0x0081;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean zza(android.content.Context r5, android.net.Uri r6) {
        /*
            java.lang.String r6 = r6.getAuthority()
            java.lang.String r0 = "com.google.android.gms.phenotype"
            boolean r0 = r0.equals(r6)
            r1 = 0
            if (r0 != 0) goto L_0x0026
            java.lang.String r5 = "PhenotypeClientHelper"
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.StringBuilder r6 = r0.append(r6)
            java.lang.String r0 = " is an unsupported authority. Only com.google.android.gms.phenotype authority is supported."
            java.lang.StringBuilder r6 = r6.append(r0)
            java.lang.String r6 = r6.toString()
            android.util.Log.e(r5, r6)
            return r1
        L_0x0026:
            com.google.common.base.Optional<java.lang.Boolean> r6 = zza
            boolean r6 = r6.isPresent()
            if (r6 == 0) goto L_0x003b
            com.google.common.base.Optional<java.lang.Boolean> r5 = zza
            java.lang.Object r5 = r5.get()
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r5 = r5.booleanValue()
            return r5
        L_0x003b:
            java.lang.Object r6 = zzb
            monitor-enter(r6)
            com.google.common.base.Optional<java.lang.Boolean> r0 = zza     // Catch:{ all -> 0x00a0 }
            boolean r0 = r0.isPresent()     // Catch:{ all -> 0x00a0 }
            if (r0 == 0) goto L_0x0054
            com.google.common.base.Optional<java.lang.Boolean> r5 = zza     // Catch:{ all -> 0x00a0 }
            java.lang.Object r5 = r5.get()     // Catch:{ all -> 0x00a0 }
            java.lang.Boolean r5 = (java.lang.Boolean) r5     // Catch:{ all -> 0x00a0 }
            boolean r5 = r5.booleanValue()     // Catch:{ all -> 0x00a0 }
            monitor-exit(r6)     // Catch:{ all -> 0x00a0 }
            return r5
        L_0x0054:
            java.lang.String r0 = "com.google.android.gms"
            java.lang.String r2 = r5.getPackageName()     // Catch:{ all -> 0x00a0 }
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x00a0 }
            if (r0 == 0) goto L_0x0061
            goto L_0x0081
        L_0x0061:
            android.content.pm.PackageManager r0 = r5.getPackageManager()     // Catch:{ all -> 0x00a0 }
            java.lang.String r2 = "com.google.android.gms.phenotype"
            int r3 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x00a0 }
            r4 = 29
            if (r3 >= r4) goto L_0x006f
            r3 = r1
            goto L_0x0071
        L_0x006f:
            r3 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0071:
            android.content.pm.ProviderInfo r0 = r0.resolveContentProvider(r2, r3)     // Catch:{ all -> 0x00a0 }
            if (r0 == 0) goto L_0x0088
            java.lang.String r2 = "com.google.android.gms"
            java.lang.String r0 = r0.packageName     // Catch:{ all -> 0x00a0 }
            boolean r0 = r2.equals(r0)     // Catch:{ all -> 0x00a0 }
            if (r0 == 0) goto L_0x0088
        L_0x0081:
            boolean r5 = zza(r5)     // Catch:{ all -> 0x00a0 }
            if (r5 == 0) goto L_0x0088
            r1 = 1
        L_0x0088:
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r1)     // Catch:{ all -> 0x00a0 }
            com.google.common.base.Optional r5 = com.google.common.base.Optional.of(r5)     // Catch:{ all -> 0x00a0 }
            zza = r5     // Catch:{ all -> 0x00a0 }
            monitor-exit(r6)     // Catch:{ all -> 0x00a0 }
            com.google.common.base.Optional<java.lang.Boolean> r5 = zza
            java.lang.Object r5 = r5.get()
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r5 = r5.booleanValue()
            return r5
        L_0x00a0:
            r5 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x00a0 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzhi.zza(android.content.Context, android.net.Uri):boolean");
    }
}
