package com.google.android.gms.security;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.internal.Preconditions;
import java.lang.reflect.Method;

/* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
public class ProviderInstaller {
    public static final String PROVIDER_NAME = "GmsCore_OpenSSL";
    /* access modifiers changed from: private */
    public static final GoogleApiAvailabilityLight zza = GoogleApiAvailabilityLight.getInstance();
    private static final Object zzb = new Object();
    private static Method zzc = null;
    private static Method zzd = null;

    /* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
    public interface ProviderInstallListener {
        void onProviderInstallFailed(int i, Intent intent);

        void onProviderInstalled();
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void installIfNeeded(android.content.Context r12) throws com.google.android.gms.common.GooglePlayServicesRepairableException, com.google.android.gms.common.GooglePlayServicesNotAvailableException {
        /*
            java.lang.String r0 = "Context must not be null"
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r12, r0)
            com.google.android.gms.common.GoogleApiAvailabilityLight r0 = zza
            r1 = 11925000(0xb5f608, float:1.6710484E-38)
            r0.verifyGooglePlayServicesIsAvailable(r12, r1)
            java.lang.Object r0 = zzb
            monitor-enter(r0)
            long r1 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x00a8 }
            r3 = 0
            com.google.android.gms.dynamite.DynamiteModule$VersionPolicy r4 = com.google.android.gms.dynamite.DynamiteModule.PREFER_HIGHEST_OR_LOCAL_VERSION_NO_FORCE_STAGING     // Catch:{ LoadingException -> 0x0022 }
            java.lang.String r5 = "com.google.android.gms.providerinstaller.dynamite"
            com.google.android.gms.dynamite.DynamiteModule r4 = com.google.android.gms.dynamite.DynamiteModule.load(r12, r4, r5)     // Catch:{ LoadingException -> 0x0022 }
            android.content.Context r4 = r4.getModuleContext()     // Catch:{ LoadingException -> 0x0022 }
            goto L_0x0037
        L_0x0022:
            r4 = move-exception
            java.lang.String r5 = "ProviderInstaller"
            java.lang.String r4 = r4.getMessage()     // Catch:{ all -> 0x00a8 }
            java.lang.String r6 = "Failed to load providerinstaller module: "
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ all -> 0x00a8 }
            java.lang.String r4 = r6.concat(r4)     // Catch:{ all -> 0x00a8 }
            android.util.Log.w(r5, r4)     // Catch:{ all -> 0x00a8 }
            r4 = r3
        L_0x0037:
            if (r4 == 0) goto L_0x0040
            java.lang.String r1 = "com.google.android.gms.providerinstaller.ProviderInstallerImpl"
            zzc(r4, r12, r1)     // Catch:{ all -> 0x00a8 }
            monitor-exit(r0)     // Catch:{ all -> 0x00a8 }
            goto L_0x0098
        L_0x0040:
            long r4 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x00a8 }
            android.content.Context r6 = com.google.android.gms.common.GooglePlayServicesUtilLight.getRemoteContext(r12)     // Catch:{ all -> 0x00a8 }
            if (r6 == 0) goto L_0x0090
            java.lang.reflect.Method r7 = zzd     // Catch:{ Exception -> 0x007c }
            if (r7 != 0) goto L_0x006a
            java.lang.String r7 = "com.google.android.gms.common.security.ProviderInstallerImpl"
            java.lang.String r8 = "reportRequestStats"
            r9 = 3
            java.lang.Class[] r9 = new java.lang.Class[r9]     // Catch:{ Exception -> 0x007c }
            java.lang.Class<android.content.Context> r10 = android.content.Context.class
            r11 = 0
            r9[r11] = r10     // Catch:{ Exception -> 0x007c }
            java.lang.Class r10 = java.lang.Long.TYPE     // Catch:{ Exception -> 0x007c }
            r11 = 1
            r9[r11] = r10     // Catch:{ Exception -> 0x007c }
            java.lang.Class r10 = java.lang.Long.TYPE     // Catch:{ Exception -> 0x007c }
            r11 = 2
            r9[r11] = r10     // Catch:{ Exception -> 0x007c }
            java.lang.reflect.Method r7 = zzb(r6, r7, r8, r9)     // Catch:{ Exception -> 0x007c }
            zzd = r7     // Catch:{ Exception -> 0x007c }
        L_0x006a:
            java.lang.reflect.Method r7 = zzd     // Catch:{ Exception -> 0x007c }
            java.lang.Long r1 = java.lang.Long.valueOf(r1)     // Catch:{ Exception -> 0x007c }
            java.lang.Long r2 = java.lang.Long.valueOf(r4)     // Catch:{ Exception -> 0x007c }
            java.lang.Object[] r1 = new java.lang.Object[]{r12, r1, r2}     // Catch:{ Exception -> 0x007c }
            r7.invoke(r3, r1)     // Catch:{ Exception -> 0x007c }
            goto L_0x0090
        L_0x007c:
            r1 = move-exception
            java.lang.String r2 = "ProviderInstaller"
            java.lang.String r1 = r1.getMessage()     // Catch:{ all -> 0x00a8 }
            java.lang.String r3 = "Failed to report request stats: "
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch:{ all -> 0x00a8 }
            java.lang.String r1 = r3.concat(r1)     // Catch:{ all -> 0x00a8 }
            android.util.Log.w(r2, r1)     // Catch:{ all -> 0x00a8 }
        L_0x0090:
            if (r6 == 0) goto L_0x0099
            java.lang.String r1 = "com.google.android.gms.common.security.ProviderInstallerImpl"
            zzc(r6, r12, r1)     // Catch:{ all -> 0x00a8 }
            monitor-exit(r0)     // Catch:{ all -> 0x00a8 }
        L_0x0098:
            return
        L_0x0099:
            java.lang.String r12 = "ProviderInstaller"
            java.lang.String r1 = "Failed to get remote context"
            android.util.Log.e(r12, r1)     // Catch:{ all -> 0x00a8 }
            com.google.android.gms.common.GooglePlayServicesNotAvailableException r12 = new com.google.android.gms.common.GooglePlayServicesNotAvailableException     // Catch:{ all -> 0x00a8 }
            r1 = 8
            r12.<init>(r1)     // Catch:{ all -> 0x00a8 }
            throw r12     // Catch:{ all -> 0x00a8 }
        L_0x00a8:
            r12 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00a8 }
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.security.ProviderInstaller.installIfNeeded(android.content.Context):void");
    }

    public static void installIfNeededAsync(Context context, ProviderInstallListener providerInstallListener) {
        Preconditions.checkNotNull(context, "Context must not be null");
        Preconditions.checkNotNull(providerInstallListener, "Listener must not be null");
        Preconditions.checkMainThread("Must be called on the UI thread");
        new zza(context, providerInstallListener).execute(new Void[0]);
    }

    private static Method zzb(Context context, String str, String str2, Class[] clsArr) throws ClassNotFoundException, NoSuchMethodException {
        return context.getClassLoader().loadClass(str).getMethod(str2, clsArr);
    }

    private static void zzc(Context context, Context context2, String str) throws GooglePlayServicesNotAvailableException {
        try {
            if (zzc == null) {
                zzc = zzb(context, str, "insertProvider", new Class[]{Context.class});
            }
            zzc.invoke((Object) null, new Object[]{context});
        } catch (Exception e) {
            Throwable cause = e.getCause();
            if (Log.isLoggable("ProviderInstaller", 6)) {
                Log.e("ProviderInstaller", "Failed to install provider: ".concat(String.valueOf(cause == null ? e.getMessage() : cause.getMessage())));
            }
            throw new GooglePlayServicesNotAvailableException(8);
        }
    }
}
