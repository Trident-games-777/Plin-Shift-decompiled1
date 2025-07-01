package com.google.android.gms.dynamite;

import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.os.IBinder;
import android.os.IInterface;
import android.util.Log;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
public final class DynamiteModule {
    public static final int LOCAL = -1;
    public static final int NONE = 0;
    public static final int NO_SELECTION = 0;
    public static final VersionPolicy PREFER_HIGHEST_OR_LOCAL_VERSION = new zzi();
    public static final VersionPolicy PREFER_HIGHEST_OR_LOCAL_VERSION_NO_FORCE_STAGING = new zzj();
    public static final VersionPolicy PREFER_HIGHEST_OR_REMOTE_VERSION = new zzk();
    public static final VersionPolicy PREFER_LOCAL = new zzg();
    public static final VersionPolicy PREFER_REMOTE = new zzf();
    public static final VersionPolicy PREFER_REMOTE_VERSION_NO_FORCE_STAGING = new zzh();
    public static final int REMOTE = 1;
    public static final VersionPolicy zza = new zzl();
    private static Boolean zzb = null;
    private static String zzc = null;
    private static boolean zzd = false;
    private static int zze = -1;
    private static Boolean zzf;
    private static final ThreadLocal zzg = new ThreadLocal();
    private static final ThreadLocal zzh = new zzd();
    private static final VersionPolicy.IVersions zzi = new zze();
    private static zzq zzk;
    private static zzr zzl;
    private final Context zzj;

    /* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
    public static class DynamiteLoaderClassLoader {
        public static ClassLoader sClassLoader;
    }

    /* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
    public static class LoadingException extends Exception {
        /* synthetic */ LoadingException(String str, zzp zzp) {
            super(str);
        }

        /* synthetic */ LoadingException(String str, Throwable th, zzp zzp) {
            super(str, th);
        }
    }

    /* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
    public interface VersionPolicy {

        /* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
        public interface IVersions {
            int zza(Context context, String str);

            int zzb(Context context, String str, boolean z) throws LoadingException;
        }

        /* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
        public static class SelectionResult {
            public int localVersion = 0;
            public int remoteVersion = 0;
            public int selection = 0;
        }

        SelectionResult selectModule(Context context, String str, IVersions iVersions) throws LoadingException;
    }

    private DynamiteModule(Context context) {
        Preconditions.checkNotNull(context);
        this.zzj = context;
    }

    public static int getLocalVersion(Context context, String str) {
        try {
            ClassLoader classLoader = context.getApplicationContext().getClassLoader();
            Class<?> loadClass = classLoader.loadClass("com.google.android.gms.dynamite.descriptors." + str + ".ModuleDescriptor");
            Field declaredField = loadClass.getDeclaredField("MODULE_ID");
            Field declaredField2 = loadClass.getDeclaredField("MODULE_VERSION");
            if (Objects.equal(declaredField.get((Object) null), str)) {
                return declaredField2.getInt((Object) null);
            }
            String valueOf = String.valueOf(declaredField.get((Object) null));
            Log.e("DynamiteModule", "Module descriptor id '" + valueOf + "' didn't match expected id '" + str + "'");
            return 0;
        } catch (ClassNotFoundException unused) {
            Log.w("DynamiteModule", "Local module descriptor class for " + str + " not found.");
            return 0;
        } catch (Exception e) {
            Log.e("DynamiteModule", "Failed to load module descriptor class: ".concat(String.valueOf(e.getMessage())));
            return 0;
        }
    }

    public static int getRemoteVersion(Context context, String str) {
        return zza(context, str, false);
    }

    /* JADX WARNING: Removed duplicated region for block: B:147:0x02a8  */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x02ae  */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x02bb  */
    @com.google.errorprone.annotations.ResultIgnorabilityUnspecified
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.dynamite.DynamiteModule load(android.content.Context r23, com.google.android.gms.dynamite.DynamiteModule.VersionPolicy r24, java.lang.String r25) throws com.google.android.gms.dynamite.DynamiteModule.LoadingException {
        /*
            r1 = r23
            r2 = r24
            r3 = r25
            java.lang.String r0 = "Selected remote version of "
            java.lang.String r4 = "Selected remote version of "
            java.lang.String r5 = "VersionPolicy returned invalid code:"
            java.lang.String r6 = "No acceptable module "
            java.lang.String r7 = "Considering local module "
            android.content.Context r8 = r1.getApplicationContext()
            r9 = 0
            if (r8 == 0) goto L_0x02c4
            java.lang.ThreadLocal r10 = zzg
            java.lang.Object r11 = r10.get()
            com.google.android.gms.dynamite.zzn r11 = (com.google.android.gms.dynamite.zzn) r11
            com.google.android.gms.dynamite.zzn r12 = new com.google.android.gms.dynamite.zzn
            r12.<init>(r9)
            r10.set(r12)
            java.lang.ThreadLocal r13 = zzh
            java.lang.Object r14 = r13.get()
            java.lang.Long r14 = (java.lang.Long) r14
            long r14 = r14.longValue()
            r16 = 0
            long r18 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x02a1 }
            r20 = r9
            java.lang.Long r9 = java.lang.Long.valueOf(r18)     // Catch:{ all -> 0x02a1 }
            r13.set(r9)     // Catch:{ all -> 0x02a1 }
            com.google.android.gms.dynamite.DynamiteModule$VersionPolicy$IVersions r9 = zzi     // Catch:{ all -> 0x02a1 }
            com.google.android.gms.dynamite.DynamiteModule$VersionPolicy$SelectionResult r9 = r2.selectModule(r1, r3, r9)     // Catch:{ all -> 0x02a1 }
            java.lang.String r13 = "DynamiteModule"
            r18 = r10
            int r10 = r9.localVersion     // Catch:{ all -> 0x02a1 }
            r21 = r14
            int r14 = r9.remoteVersion     // Catch:{ all -> 0x029f }
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ all -> 0x029f }
            r15.<init>(r7)     // Catch:{ all -> 0x029f }
            r15.append(r3)     // Catch:{ all -> 0x029f }
            java.lang.String r7 = ":"
            r15.append(r7)     // Catch:{ all -> 0x029f }
            r15.append(r10)     // Catch:{ all -> 0x029f }
            java.lang.String r7 = " and remote module "
            r15.append(r7)     // Catch:{ all -> 0x029f }
            r15.append(r3)     // Catch:{ all -> 0x029f }
            java.lang.String r7 = ":"
            r15.append(r7)     // Catch:{ all -> 0x029f }
            r15.append(r14)     // Catch:{ all -> 0x029f }
            java.lang.String r7 = r15.toString()     // Catch:{ all -> 0x029f }
            android.util.Log.i(r13, r7)     // Catch:{ all -> 0x029f }
            int r7 = r9.selection     // Catch:{ all -> 0x029f }
            if (r7 == 0) goto L_0x0273
            r10 = -1
            if (r7 != r10) goto L_0x0085
            int r7 = r9.localVersion     // Catch:{ all -> 0x029f }
            if (r7 == 0) goto L_0x0273
            r7 = r10
        L_0x0085:
            r13 = 1
            if (r7 != r13) goto L_0x008c
            int r14 = r9.remoteVersion     // Catch:{ all -> 0x029f }
            if (r14 == 0) goto L_0x0273
        L_0x008c:
            if (r7 != r10) goto L_0x0094
            com.google.android.gms.dynamite.DynamiteModule r0 = zzc(r8, r3)     // Catch:{ all -> 0x029f }
            goto L_0x0237
        L_0x0094:
            if (r7 != r13) goto L_0x0260
            r5 = 0
            int r6 = r9.remoteVersion     // Catch:{ LoadingException -> 0x0207 }
            java.lang.Class<com.google.android.gms.dynamite.DynamiteModule> r7 = com.google.android.gms.dynamite.DynamiteModule.class
            monitor-enter(r7)     // Catch:{ RemoteException -> 0x01fd, LoadingException -> 0x01fb, all -> 0x01ee }
            boolean r14 = zzf(r1)     // Catch:{ all -> 0x01eb }
            if (r14 == 0) goto L_0x01e2
            java.lang.Boolean r14 = zzb     // Catch:{ all -> 0x01eb }
            monitor-exit(r7)     // Catch:{ all -> 0x01eb }
            if (r14 == 0) goto L_0x01d9
            boolean r7 = r14.booleanValue()     // Catch:{ RemoteException -> 0x01fd, LoadingException -> 0x01fb, all -> 0x01ee }
            r14 = 2
            if (r7 == 0) goto L_0x0151
            java.lang.String r4 = "DynamiteModule"
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ RemoteException -> 0x01fd, LoadingException -> 0x01fb, all -> 0x01ee }
            r7.<init>(r0)     // Catch:{ RemoteException -> 0x01fd, LoadingException -> 0x01fb, all -> 0x01ee }
            r7.append(r3)     // Catch:{ RemoteException -> 0x01fd, LoadingException -> 0x01fb, all -> 0x01ee }
            java.lang.String r0 = ", version >= "
            r7.append(r0)     // Catch:{ RemoteException -> 0x01fd, LoadingException -> 0x01fb, all -> 0x01ee }
            r7.append(r6)     // Catch:{ RemoteException -> 0x01fd, LoadingException -> 0x01fb, all -> 0x01ee }
            java.lang.String r0 = r7.toString()     // Catch:{ RemoteException -> 0x01fd, LoadingException -> 0x01fb, all -> 0x01ee }
            android.util.Log.i(r4, r0)     // Catch:{ RemoteException -> 0x01fd, LoadingException -> 0x01fb, all -> 0x01ee }
            java.lang.Class<com.google.android.gms.dynamite.DynamiteModule> r4 = com.google.android.gms.dynamite.DynamiteModule.class
            monitor-enter(r4)     // Catch:{ RemoteException -> 0x01fd, LoadingException -> 0x01fb, all -> 0x01ee }
            com.google.android.gms.dynamite.zzr r0 = zzl     // Catch:{ all -> 0x014e }
            monitor-exit(r4)     // Catch:{ all -> 0x014e }
            if (r0 == 0) goto L_0x0145
            java.lang.Object r4 = r18.get()     // Catch:{ RemoteException -> 0x01fd, LoadingException -> 0x01fb, all -> 0x01ee }
            com.google.android.gms.dynamite.zzn r4 = (com.google.android.gms.dynamite.zzn) r4     // Catch:{ RemoteException -> 0x01fd, LoadingException -> 0x01fb, all -> 0x01ee }
            if (r4 == 0) goto L_0x013c
            android.database.Cursor r7 = r4.zza     // Catch:{ RemoteException -> 0x01fd, LoadingException -> 0x01fb, all -> 0x01ee }
            if (r7 == 0) goto L_0x013c
            android.content.Context r7 = r1.getApplicationContext()     // Catch:{ RemoteException -> 0x01fd, LoadingException -> 0x01fb, all -> 0x01ee }
            android.database.Cursor r4 = r4.zza     // Catch:{ RemoteException -> 0x01fd, LoadingException -> 0x01fb, all -> 0x01ee }
            com.google.android.gms.dynamic.ObjectWrapper.wrap(r20)     // Catch:{ RemoteException -> 0x01fd, LoadingException -> 0x01fb, all -> 0x01ee }
            java.lang.Class<com.google.android.gms.dynamite.DynamiteModule> r15 = com.google.android.gms.dynamite.DynamiteModule.class
            monitor-enter(r15)     // Catch:{ RemoteException -> 0x01fd, LoadingException -> 0x01fb, all -> 0x01ee }
            int r13 = zze     // Catch:{ all -> 0x0139 }
            if (r13 < r14) goto L_0x00ed
            r13 = 1
            goto L_0x00ee
        L_0x00ed:
            r13 = r5
        L_0x00ee:
            java.lang.Boolean r13 = java.lang.Boolean.valueOf(r13)     // Catch:{ all -> 0x0139 }
            monitor-exit(r15)     // Catch:{ all -> 0x0139 }
            boolean r13 = r13.booleanValue()     // Catch:{ RemoteException -> 0x01fd, LoadingException -> 0x01fb, all -> 0x01ee }
            if (r13 == 0) goto L_0x010d
            java.lang.String r13 = "DynamiteModule"
            java.lang.String r14 = "Dynamite loader version >= 2, using loadModule2NoCrashUtils"
            android.util.Log.v(r13, r14)     // Catch:{ RemoteException -> 0x01fd, LoadingException -> 0x01fb, all -> 0x01ee }
            com.google.android.gms.dynamic.IObjectWrapper r7 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r7)     // Catch:{ RemoteException -> 0x01fd, LoadingException -> 0x01fb, all -> 0x01ee }
            com.google.android.gms.dynamic.IObjectWrapper r4 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r4)     // Catch:{ RemoteException -> 0x01fd, LoadingException -> 0x01fb, all -> 0x01ee }
            com.google.android.gms.dynamic.IObjectWrapper r0 = r0.zzf(r7, r3, r6, r4)     // Catch:{ RemoteException -> 0x01fd, LoadingException -> 0x01fb, all -> 0x01ee }
            goto L_0x0120
        L_0x010d:
            java.lang.String r13 = "DynamiteModule"
            java.lang.String r14 = "Dynamite loader version < 2, falling back to loadModule2"
            android.util.Log.w(r13, r14)     // Catch:{ RemoteException -> 0x01fd, LoadingException -> 0x01fb, all -> 0x01ee }
            com.google.android.gms.dynamic.IObjectWrapper r7 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r7)     // Catch:{ RemoteException -> 0x01fd, LoadingException -> 0x01fb, all -> 0x01ee }
            com.google.android.gms.dynamic.IObjectWrapper r4 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r4)     // Catch:{ RemoteException -> 0x01fd, LoadingException -> 0x01fb, all -> 0x01ee }
            com.google.android.gms.dynamic.IObjectWrapper r0 = r0.zze(r7, r3, r6, r4)     // Catch:{ RemoteException -> 0x01fd, LoadingException -> 0x01fb, all -> 0x01ee }
        L_0x0120:
            java.lang.Object r0 = com.google.android.gms.dynamic.ObjectWrapper.unwrap(r0)     // Catch:{ RemoteException -> 0x01fd, LoadingException -> 0x01fb, all -> 0x01ee }
            android.content.Context r0 = (android.content.Context) r0     // Catch:{ RemoteException -> 0x01fd, LoadingException -> 0x01fb, all -> 0x01ee }
            if (r0 == 0) goto L_0x012f
            com.google.android.gms.dynamite.DynamiteModule r4 = new com.google.android.gms.dynamite.DynamiteModule     // Catch:{ RemoteException -> 0x01fd, LoadingException -> 0x01fb, all -> 0x01ee }
            r4.<init>(r0)     // Catch:{ RemoteException -> 0x01fd, LoadingException -> 0x01fb, all -> 0x01ee }
            goto L_0x01c5
        L_0x012f:
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r0 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ RemoteException -> 0x01fd, LoadingException -> 0x01fb, all -> 0x01ee }
            java.lang.String r4 = "Failed to get module context"
            r6 = r20
            r0.<init>(r4, r6)     // Catch:{ RemoteException -> 0x01fd, LoadingException -> 0x01fb, all -> 0x01ee }
            throw r0     // Catch:{ RemoteException -> 0x01fd, LoadingException -> 0x01fb, all -> 0x01ee }
        L_0x0139:
            r0 = move-exception
            monitor-exit(r15)     // Catch:{ all -> 0x0139 }
            throw r0     // Catch:{ RemoteException -> 0x01fd, LoadingException -> 0x01fb, all -> 0x01ee }
        L_0x013c:
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r0 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ RemoteException -> 0x01fd, LoadingException -> 0x01fb, all -> 0x01ee }
            java.lang.String r4 = "No result cursor"
            r6 = 0
            r0.<init>(r4, r6)     // Catch:{ RemoteException -> 0x01fd, LoadingException -> 0x01fb, all -> 0x01ee }
            throw r0     // Catch:{ RemoteException -> 0x01fd, LoadingException -> 0x01fb, all -> 0x01ee }
        L_0x0145:
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r0 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ RemoteException -> 0x01fd, LoadingException -> 0x01fb, all -> 0x01ee }
            java.lang.String r4 = "DynamiteLoaderV2 was not cached."
            r6 = 0
            r0.<init>(r4, r6)     // Catch:{ RemoteException -> 0x01fd, LoadingException -> 0x01fb, all -> 0x01ee }
            throw r0     // Catch:{ RemoteException -> 0x01fd, LoadingException -> 0x01fb, all -> 0x01ee }
        L_0x014e:
            r0 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x014e }
            throw r0     // Catch:{ RemoteException -> 0x01fd, LoadingException -> 0x01fb, all -> 0x01ee }
        L_0x0151:
            java.lang.String r0 = "DynamiteModule"
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ RemoteException -> 0x01fd, LoadingException -> 0x01fb, all -> 0x01ee }
            r7.<init>(r4)     // Catch:{ RemoteException -> 0x01fd, LoadingException -> 0x01fb, all -> 0x01ee }
            r7.append(r3)     // Catch:{ RemoteException -> 0x01fd, LoadingException -> 0x01fb, all -> 0x01ee }
            java.lang.String r4 = ", version >= "
            r7.append(r4)     // Catch:{ RemoteException -> 0x01fd, LoadingException -> 0x01fb, all -> 0x01ee }
            r7.append(r6)     // Catch:{ RemoteException -> 0x01fd, LoadingException -> 0x01fb, all -> 0x01ee }
            java.lang.String r4 = r7.toString()     // Catch:{ RemoteException -> 0x01fd, LoadingException -> 0x01fb, all -> 0x01ee }
            android.util.Log.i(r0, r4)     // Catch:{ RemoteException -> 0x01fd, LoadingException -> 0x01fb, all -> 0x01ee }
            com.google.android.gms.dynamite.zzq r0 = zzg(r1)     // Catch:{ RemoteException -> 0x01fd, LoadingException -> 0x01fb, all -> 0x01ee }
            if (r0 == 0) goto L_0x01d0
            int r4 = r0.zze()     // Catch:{ RemoteException -> 0x01fd, LoadingException -> 0x01fb, all -> 0x01ee }
            r7 = 3
            if (r4 < r7) goto L_0x0197
            java.lang.Object r4 = r18.get()     // Catch:{ RemoteException -> 0x01fd, LoadingException -> 0x01fb, all -> 0x01ee }
            com.google.android.gms.dynamite.zzn r4 = (com.google.android.gms.dynamite.zzn) r4     // Catch:{ RemoteException -> 0x01fd, LoadingException -> 0x01fb, all -> 0x01ee }
            if (r4 == 0) goto L_0x018e
            com.google.android.gms.dynamic.IObjectWrapper r7 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r1)     // Catch:{ RemoteException -> 0x01fd, LoadingException -> 0x01fb, all -> 0x01ee }
            android.database.Cursor r4 = r4.zza     // Catch:{ RemoteException -> 0x01fd, LoadingException -> 0x01fb, all -> 0x01ee }
            com.google.android.gms.dynamic.IObjectWrapper r4 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r4)     // Catch:{ RemoteException -> 0x01fd, LoadingException -> 0x01fb, all -> 0x01ee }
            com.google.android.gms.dynamic.IObjectWrapper r0 = r0.zzi(r7, r3, r6, r4)     // Catch:{ RemoteException -> 0x01fd, LoadingException -> 0x01fb, all -> 0x01ee }
            goto L_0x01b8
        L_0x018e:
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r0 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ RemoteException -> 0x01fd, LoadingException -> 0x01fb, all -> 0x01ee }
            java.lang.String r4 = "No cached result cursor holder"
            r6 = 0
            r0.<init>(r4, r6)     // Catch:{ RemoteException -> 0x01fd, LoadingException -> 0x01fb, all -> 0x01ee }
            throw r0     // Catch:{ RemoteException -> 0x01fd, LoadingException -> 0x01fb, all -> 0x01ee }
        L_0x0197:
            if (r4 != r14) goto L_0x01a9
            java.lang.String r4 = "DynamiteModule"
            java.lang.String r7 = "IDynamite loader version = 2"
            android.util.Log.w(r4, r7)     // Catch:{ RemoteException -> 0x01fd, LoadingException -> 0x01fb, all -> 0x01ee }
            com.google.android.gms.dynamic.IObjectWrapper r4 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r1)     // Catch:{ RemoteException -> 0x01fd, LoadingException -> 0x01fb, all -> 0x01ee }
            com.google.android.gms.dynamic.IObjectWrapper r0 = r0.zzj(r4, r3, r6)     // Catch:{ RemoteException -> 0x01fd, LoadingException -> 0x01fb, all -> 0x01ee }
            goto L_0x01b8
        L_0x01a9:
            java.lang.String r4 = "DynamiteModule"
            java.lang.String r7 = "Dynamite loader version < 2, falling back to createModuleContext"
            android.util.Log.w(r4, r7)     // Catch:{ RemoteException -> 0x01fd, LoadingException -> 0x01fb, all -> 0x01ee }
            com.google.android.gms.dynamic.IObjectWrapper r4 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r1)     // Catch:{ RemoteException -> 0x01fd, LoadingException -> 0x01fb, all -> 0x01ee }
            com.google.android.gms.dynamic.IObjectWrapper r0 = r0.zzh(r4, r3, r6)     // Catch:{ RemoteException -> 0x01fd, LoadingException -> 0x01fb, all -> 0x01ee }
        L_0x01b8:
            java.lang.Object r0 = com.google.android.gms.dynamic.ObjectWrapper.unwrap(r0)     // Catch:{ RemoteException -> 0x01fd, LoadingException -> 0x01fb, all -> 0x01ee }
            if (r0 == 0) goto L_0x01c7
            com.google.android.gms.dynamite.DynamiteModule r4 = new com.google.android.gms.dynamite.DynamiteModule     // Catch:{ RemoteException -> 0x01fd, LoadingException -> 0x01fb, all -> 0x01ee }
            android.content.Context r0 = (android.content.Context) r0     // Catch:{ RemoteException -> 0x01fd, LoadingException -> 0x01fb, all -> 0x01ee }
            r4.<init>(r0)     // Catch:{ RemoteException -> 0x01fd, LoadingException -> 0x01fb, all -> 0x01ee }
        L_0x01c5:
            r0 = r4
            goto L_0x0237
        L_0x01c7:
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r0 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ RemoteException -> 0x01fd, LoadingException -> 0x01fb, all -> 0x01ee }
            java.lang.String r4 = "Failed to load remote module."
            r6 = 0
            r0.<init>(r4, r6)     // Catch:{ RemoteException -> 0x01fd, LoadingException -> 0x01fb, all -> 0x01ee }
            throw r0     // Catch:{ RemoteException -> 0x01fd, LoadingException -> 0x01fb, all -> 0x01ee }
        L_0x01d0:
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r0 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ RemoteException -> 0x01fd, LoadingException -> 0x01fb, all -> 0x01ee }
            java.lang.String r4 = "Failed to create IDynamiteLoader."
            r6 = 0
            r0.<init>(r4, r6)     // Catch:{ RemoteException -> 0x01fd, LoadingException -> 0x01fb, all -> 0x01ee }
            throw r0     // Catch:{ RemoteException -> 0x01fd, LoadingException -> 0x01fb, all -> 0x01ee }
        L_0x01d9:
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r0 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ RemoteException -> 0x01fd, LoadingException -> 0x01fb, all -> 0x01ee }
            java.lang.String r4 = "Failed to determine which loading route to use."
            r6 = 0
            r0.<init>(r4, r6)     // Catch:{ RemoteException -> 0x01fd, LoadingException -> 0x01fb, all -> 0x01ee }
            throw r0     // Catch:{ RemoteException -> 0x01fd, LoadingException -> 0x01fb, all -> 0x01ee }
        L_0x01e2:
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r0 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ all -> 0x01eb }
            java.lang.String r4 = "Remote loading disabled"
            r6 = 0
            r0.<init>(r4, r6)     // Catch:{ all -> 0x01eb }
            throw r0     // Catch:{ all -> 0x01eb }
        L_0x01eb:
            r0 = move-exception
            monitor-exit(r7)     // Catch:{ all -> 0x01eb }
            throw r0     // Catch:{ RemoteException -> 0x01fd, LoadingException -> 0x01fb, all -> 0x01ee }
        L_0x01ee:
            r0 = move-exception
            com.google.android.gms.common.util.CrashUtils.addDynamiteErrorToDropBox(r1, r0)     // Catch:{ LoadingException -> 0x0207 }
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r4 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ LoadingException -> 0x0207 }
            java.lang.String r6 = "Failed to load remote module."
            r7 = 0
            r4.<init>(r6, r0, r7)     // Catch:{ LoadingException -> 0x0207 }
            throw r4     // Catch:{ LoadingException -> 0x0207 }
        L_0x01fb:
            r0 = move-exception
            throw r0     // Catch:{ LoadingException -> 0x0207 }
        L_0x01fd:
            r0 = move-exception
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r4 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ LoadingException -> 0x0207 }
            java.lang.String r6 = "Failed to load remote module."
            r7 = 0
            r4.<init>(r6, r0, r7)     // Catch:{ LoadingException -> 0x0207 }
            throw r4     // Catch:{ LoadingException -> 0x0207 }
        L_0x0207:
            r0 = move-exception
            java.lang.String r4 = "DynamiteModule"
            java.lang.String r6 = r0.getMessage()     // Catch:{ all -> 0x029f }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x029f }
            r7.<init>()     // Catch:{ all -> 0x029f }
            java.lang.String r13 = "Failed to load remote module: "
            r7.append(r13)     // Catch:{ all -> 0x029f }
            r7.append(r6)     // Catch:{ all -> 0x029f }
            java.lang.String r6 = r7.toString()     // Catch:{ all -> 0x029f }
            android.util.Log.w(r4, r6)     // Catch:{ all -> 0x029f }
            int r4 = r9.localVersion     // Catch:{ all -> 0x029f }
            if (r4 == 0) goto L_0x0257
            com.google.android.gms.dynamite.zzo r6 = new com.google.android.gms.dynamite.zzo     // Catch:{ all -> 0x029f }
            r6.<init>(r4, r5)     // Catch:{ all -> 0x029f }
            com.google.android.gms.dynamite.DynamiteModule$VersionPolicy$SelectionResult r1 = r2.selectModule(r1, r3, r6)     // Catch:{ all -> 0x029f }
            int r1 = r1.selection     // Catch:{ all -> 0x029f }
            if (r1 != r10) goto L_0x0257
            com.google.android.gms.dynamite.DynamiteModule r0 = zzc(r8, r3)     // Catch:{ all -> 0x029f }
        L_0x0237:
            int r1 = (r21 > r16 ? 1 : (r21 == r16 ? 0 : -1))
            if (r1 != 0) goto L_0x0241
            java.lang.ThreadLocal r1 = zzh
            r1.remove()
            goto L_0x024a
        L_0x0241:
            java.lang.ThreadLocal r1 = zzh
            java.lang.Long r2 = java.lang.Long.valueOf(r21)
            r1.set(r2)
        L_0x024a:
            android.database.Cursor r1 = r12.zza
            if (r1 == 0) goto L_0x0251
            r1.close()
        L_0x0251:
            java.lang.ThreadLocal r1 = zzg
            r1.set(r11)
            return r0
        L_0x0257:
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r1 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ all -> 0x029f }
            java.lang.String r2 = "Remote load failed. No local fallback found."
            r6 = 0
            r1.<init>(r2, r0, r6)     // Catch:{ all -> 0x029f }
            throw r1     // Catch:{ all -> 0x029f }
        L_0x0260:
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r0 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ all -> 0x029f }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x029f }
            r1.<init>(r5)     // Catch:{ all -> 0x029f }
            r1.append(r7)     // Catch:{ all -> 0x029f }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x029f }
            r6 = 0
            r0.<init>(r1, r6)     // Catch:{ all -> 0x029f }
            throw r0     // Catch:{ all -> 0x029f }
        L_0x0273:
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r0 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ all -> 0x029f }
            int r1 = r9.localVersion     // Catch:{ all -> 0x029f }
            int r2 = r9.remoteVersion     // Catch:{ all -> 0x029f }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x029f }
            r4.<init>(r6)     // Catch:{ all -> 0x029f }
            r4.append(r3)     // Catch:{ all -> 0x029f }
            java.lang.String r3 = " found. Local version is "
            r4.append(r3)     // Catch:{ all -> 0x029f }
            r4.append(r1)     // Catch:{ all -> 0x029f }
            java.lang.String r1 = " and remote version is "
            r4.append(r1)     // Catch:{ all -> 0x029f }
            r4.append(r2)     // Catch:{ all -> 0x029f }
            java.lang.String r1 = "."
            r4.append(r1)     // Catch:{ all -> 0x029f }
            java.lang.String r1 = r4.toString()     // Catch:{ all -> 0x029f }
            r6 = 0
            r0.<init>(r1, r6)     // Catch:{ all -> 0x029f }
            throw r0     // Catch:{ all -> 0x029f }
        L_0x029f:
            r0 = move-exception
            goto L_0x02a4
        L_0x02a1:
            r0 = move-exception
            r21 = r14
        L_0x02a4:
            int r1 = (r21 > r16 ? 1 : (r21 == r16 ? 0 : -1))
            if (r1 != 0) goto L_0x02ae
            java.lang.ThreadLocal r1 = zzh
            r1.remove()
            goto L_0x02b7
        L_0x02ae:
            java.lang.ThreadLocal r1 = zzh
            java.lang.Long r2 = java.lang.Long.valueOf(r21)
            r1.set(r2)
        L_0x02b7:
            android.database.Cursor r1 = r12.zza
            if (r1 == 0) goto L_0x02be
            r1.close()
        L_0x02be:
            java.lang.ThreadLocal r1 = zzg
            r1.set(r11)
            throw r0
        L_0x02c4:
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r0 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException
            java.lang.String r1 = "null application Context"
            r6 = 0
            r0.<init>(r1, r6)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.DynamiteModule.load(android.content.Context, com.google.android.gms.dynamite.DynamiteModule$VersionPolicy, java.lang.String):com.google.android.gms.dynamite.DynamiteModule");
    }

    /* JADX INFO: finally extract failed */
    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:31:0x0056=Splitter:B:31:0x0056, B:17:0x003b=Splitter:B:17:0x003b, B:50:0x009c=Splitter:B:50:0x009c} */
    public static int zza(android.content.Context r10, java.lang.String r11, boolean r12) {
        /*
            java.lang.Class<com.google.android.gms.dynamite.DynamiteModule> r1 = com.google.android.gms.dynamite.DynamiteModule.class
            monitor-enter(r1)     // Catch:{ all -> 0x01cd }
            java.lang.Boolean r0 = zzb     // Catch:{ all -> 0x01c9 }
            r2 = 0
            r3 = 0
            if (r0 != 0) goto L_0x00da
            android.content.Context r0 = r10.getApplicationContext()     // Catch:{ ClassNotFoundException -> 0x00bb, IllegalAccessException -> 0x00b9, NoSuchFieldException -> 0x00b7 }
            java.lang.ClassLoader r0 = r0.getClassLoader()     // Catch:{ ClassNotFoundException -> 0x00bb, IllegalAccessException -> 0x00b9, NoSuchFieldException -> 0x00b7 }
            java.lang.Class<com.google.android.gms.dynamite.DynamiteModule$DynamiteLoaderClassLoader> r4 = com.google.android.gms.dynamite.DynamiteModule.DynamiteLoaderClassLoader.class
            java.lang.String r4 = r4.getName()     // Catch:{ ClassNotFoundException -> 0x00bb, IllegalAccessException -> 0x00b9, NoSuchFieldException -> 0x00b7 }
            java.lang.Class r0 = r0.loadClass(r4)     // Catch:{ ClassNotFoundException -> 0x00bb, IllegalAccessException -> 0x00b9, NoSuchFieldException -> 0x00b7 }
            java.lang.String r4 = "sClassLoader"
            java.lang.reflect.Field r0 = r0.getDeclaredField(r4)     // Catch:{ ClassNotFoundException -> 0x00bb, IllegalAccessException -> 0x00b9, NoSuchFieldException -> 0x00b7 }
            java.lang.Class r4 = r0.getDeclaringClass()     // Catch:{ ClassNotFoundException -> 0x00bb, IllegalAccessException -> 0x00b9, NoSuchFieldException -> 0x00b7 }
            monitor-enter(r4)     // Catch:{ ClassNotFoundException -> 0x00bb, IllegalAccessException -> 0x00b9, NoSuchFieldException -> 0x00b7 }
            java.lang.Object r5 = r0.get(r2)     // Catch:{ all -> 0x00b4 }
            java.lang.ClassLoader r5 = (java.lang.ClassLoader) r5     // Catch:{ all -> 0x00b4 }
            java.lang.ClassLoader r6 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ all -> 0x00b4 }
            if (r5 != r6) goto L_0x0036
            java.lang.Boolean r0 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x00b4 }
            goto L_0x00b2
        L_0x0036:
            if (r5 == 0) goto L_0x003f
            zzd(r5)     // Catch:{ LoadingException -> 0x003b }
        L_0x003b:
            java.lang.Boolean r0 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x00b4 }
            goto L_0x00b2
        L_0x003f:
            boolean r5 = zzf(r10)     // Catch:{ all -> 0x00b4 }
            if (r5 != 0) goto L_0x0048
            monitor-exit(r4)     // Catch:{ all -> 0x00b4 }
            monitor-exit(r1)     // Catch:{ all -> 0x01c9 }
            return r3
        L_0x0048:
            boolean r5 = zzd     // Catch:{ all -> 0x00b4 }
            if (r5 != 0) goto L_0x00a9
            java.lang.Boolean r5 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x00b4 }
            boolean r5 = r5.equals(r2)     // Catch:{ all -> 0x00b4 }
            if (r5 == 0) goto L_0x0055
            goto L_0x00a9
        L_0x0055:
            r5 = 1
            int r5 = zzb(r10, r11, r12, r5)     // Catch:{ LoadingException -> 0x009f }
            java.lang.String r6 = zzc     // Catch:{ LoadingException -> 0x009f }
            if (r6 == 0) goto L_0x009c
            boolean r6 = r6.isEmpty()     // Catch:{ LoadingException -> 0x009f }
            if (r6 == 0) goto L_0x0065
            goto L_0x009c
        L_0x0065:
            java.lang.ClassLoader r6 = com.google.android.gms.dynamite.zzb.zza()     // Catch:{ LoadingException -> 0x009f }
            if (r6 == 0) goto L_0x006c
            goto L_0x008f
        L_0x006c:
            int r6 = android.os.Build.VERSION.SDK_INT     // Catch:{ LoadingException -> 0x009f }
            r7 = 29
            if (r6 < r7) goto L_0x0081
            dalvik.system.DelegateLastClassLoader r6 = new dalvik.system.DelegateLastClassLoader     // Catch:{ LoadingException -> 0x009f }
            java.lang.String r7 = zzc     // Catch:{ LoadingException -> 0x009f }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r7)     // Catch:{ LoadingException -> 0x009f }
            java.lang.ClassLoader r8 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ LoadingException -> 0x009f }
            r6.<init>(r7, r8)     // Catch:{ LoadingException -> 0x009f }
            goto L_0x008f
        L_0x0081:
            com.google.android.gms.dynamite.zzc r6 = new com.google.android.gms.dynamite.zzc     // Catch:{ LoadingException -> 0x009f }
            java.lang.String r7 = zzc     // Catch:{ LoadingException -> 0x009f }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r7)     // Catch:{ LoadingException -> 0x009f }
            java.lang.ClassLoader r8 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ LoadingException -> 0x009f }
            r6.<init>(r7, r8)     // Catch:{ LoadingException -> 0x009f }
        L_0x008f:
            zzd(r6)     // Catch:{ LoadingException -> 0x009f }
            r0.set(r2, r6)     // Catch:{ LoadingException -> 0x009f }
            java.lang.Boolean r6 = java.lang.Boolean.TRUE     // Catch:{ LoadingException -> 0x009f }
            zzb = r6     // Catch:{ LoadingException -> 0x009f }
            monitor-exit(r4)     // Catch:{ all -> 0x00b4 }
            monitor-exit(r1)     // Catch:{ all -> 0x01c9 }
            return r5
        L_0x009c:
            monitor-exit(r4)     // Catch:{ all -> 0x00b4 }
            monitor-exit(r1)     // Catch:{ all -> 0x01c9 }
            return r5
        L_0x009f:
            java.lang.ClassLoader r5 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ all -> 0x00b4 }
            r0.set(r2, r5)     // Catch:{ all -> 0x00b4 }
            java.lang.Boolean r0 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x00b4 }
            goto L_0x00b2
        L_0x00a9:
            java.lang.ClassLoader r5 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ all -> 0x00b4 }
            r0.set(r2, r5)     // Catch:{ all -> 0x00b4 }
            java.lang.Boolean r0 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x00b4 }
        L_0x00b2:
            monitor-exit(r4)     // Catch:{ all -> 0x00b4 }
            goto L_0x00d8
        L_0x00b4:
            r0 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x00b4 }
            throw r0     // Catch:{ ClassNotFoundException -> 0x00bb, IllegalAccessException -> 0x00b9, NoSuchFieldException -> 0x00b7 }
        L_0x00b7:
            r0 = move-exception
            goto L_0x00bc
        L_0x00b9:
            r0 = move-exception
            goto L_0x00bc
        L_0x00bb:
            r0 = move-exception
        L_0x00bc:
            java.lang.String r4 = "DynamiteModule"
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x01c9 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x01c9 }
            r5.<init>()     // Catch:{ all -> 0x01c9 }
            java.lang.String r6 = "Failed to load module via V2: "
            r5.append(r6)     // Catch:{ all -> 0x01c9 }
            r5.append(r0)     // Catch:{ all -> 0x01c9 }
            java.lang.String r0 = r5.toString()     // Catch:{ all -> 0x01c9 }
            android.util.Log.w(r4, r0)     // Catch:{ all -> 0x01c9 }
            java.lang.Boolean r0 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x01c9 }
        L_0x00d8:
            zzb = r0     // Catch:{ all -> 0x01c9 }
        L_0x00da:
            monitor-exit(r1)     // Catch:{ all -> 0x01c9 }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x01cd }
            if (r0 == 0) goto L_0x0103
            int r10 = zzb(r10, r11, r12, r3)     // Catch:{ LoadingException -> 0x00e6 }
            return r10
        L_0x00e6:
            r0 = move-exception
            r11 = r0
            java.lang.String r12 = "DynamiteModule"
            java.lang.String r11 = r11.getMessage()     // Catch:{ all -> 0x01cd }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x01cd }
            r0.<init>()     // Catch:{ all -> 0x01cd }
            java.lang.String r1 = "Failed to retrieve remote module version: "
            r0.append(r1)     // Catch:{ all -> 0x01cd }
            r0.append(r11)     // Catch:{ all -> 0x01cd }
            java.lang.String r11 = r0.toString()     // Catch:{ all -> 0x01cd }
            android.util.Log.w(r12, r11)     // Catch:{ all -> 0x01cd }
            return r3
        L_0x0103:
            com.google.android.gms.dynamite.zzq r4 = zzg(r10)     // Catch:{ all -> 0x01cd }
            if (r4 != 0) goto L_0x010b
            goto L_0x01bf
        L_0x010b:
            int r0 = r4.zze()     // Catch:{ RemoteException -> 0x019d }
            r1 = 3
            if (r0 < r1) goto L_0x0176
            java.lang.ThreadLocal r0 = zzg     // Catch:{ RemoteException -> 0x019d }
            java.lang.Object r0 = r0.get()     // Catch:{ RemoteException -> 0x019d }
            com.google.android.gms.dynamite.zzn r0 = (com.google.android.gms.dynamite.zzn) r0     // Catch:{ RemoteException -> 0x019d }
            if (r0 == 0) goto L_0x0126
            android.database.Cursor r0 = r0.zza     // Catch:{ RemoteException -> 0x019d }
            if (r0 == 0) goto L_0x0126
            int r3 = r0.getInt(r3)     // Catch:{ RemoteException -> 0x019d }
            goto L_0x01bf
        L_0x0126:
            com.google.android.gms.dynamic.IObjectWrapper r5 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r10)     // Catch:{ RemoteException -> 0x019d }
            java.lang.ThreadLocal r0 = zzh     // Catch:{ RemoteException -> 0x019d }
            java.lang.Object r0 = r0.get()     // Catch:{ RemoteException -> 0x019d }
            java.lang.Long r0 = (java.lang.Long) r0     // Catch:{ RemoteException -> 0x019d }
            long r8 = r0.longValue()     // Catch:{ RemoteException -> 0x019d }
            r6 = r11
            r7 = r12
            com.google.android.gms.dynamic.IObjectWrapper r11 = r4.zzk(r5, r6, r7, r8)     // Catch:{ RemoteException -> 0x019d }
            java.lang.Object r11 = com.google.android.gms.dynamic.ObjectWrapper.unwrap(r11)     // Catch:{ RemoteException -> 0x019d }
            android.database.Cursor r11 = (android.database.Cursor) r11     // Catch:{ RemoteException -> 0x019d }
            if (r11 == 0) goto L_0x0161
            boolean r12 = r11.moveToFirst()     // Catch:{ RemoteException -> 0x0172, all -> 0x016e }
            if (r12 != 0) goto L_0x014b
            goto L_0x0161
        L_0x014b:
            int r12 = r11.getInt(r3)     // Catch:{ RemoteException -> 0x0172, all -> 0x016e }
            if (r12 <= 0) goto L_0x0158
            boolean r0 = zze(r11)     // Catch:{ RemoteException -> 0x0172, all -> 0x016e }
            if (r0 == 0) goto L_0x0158
            goto L_0x0159
        L_0x0158:
            r2 = r11
        L_0x0159:
            if (r2 == 0) goto L_0x015e
            r2.close()     // Catch:{ all -> 0x01cd }
        L_0x015e:
            r3 = r12
            goto L_0x01bf
        L_0x0161:
            java.lang.String r12 = "DynamiteModule"
            java.lang.String r0 = "Failed to retrieve remote module version."
            android.util.Log.w(r12, r0)     // Catch:{ RemoteException -> 0x0172, all -> 0x016e }
            if (r11 == 0) goto L_0x01bf
            r11.close()     // Catch:{ all -> 0x01cd }
            goto L_0x01bf
        L_0x016e:
            r0 = move-exception
            r12 = r0
            r2 = r11
            goto L_0x01c3
        L_0x0172:
            r0 = move-exception
            r12 = r0
            r2 = r11
            goto L_0x01a0
        L_0x0176:
            r6 = r11
            r7 = r12
            r11 = 2
            if (r0 != r11) goto L_0x018b
            java.lang.String r11 = "DynamiteModule"
            java.lang.String r12 = "IDynamite loader version = 2, no high precision latency measurement."
            android.util.Log.w(r11, r12)     // Catch:{ RemoteException -> 0x019d }
            com.google.android.gms.dynamic.IObjectWrapper r11 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r10)     // Catch:{ RemoteException -> 0x019d }
            int r3 = r4.zzg(r11, r6, r7)     // Catch:{ RemoteException -> 0x019d }
            goto L_0x01bf
        L_0x018b:
            java.lang.String r11 = "DynamiteModule"
            java.lang.String r12 = "IDynamite loader version < 2, falling back to getModuleVersion2"
            android.util.Log.w(r11, r12)     // Catch:{ RemoteException -> 0x019d }
            com.google.android.gms.dynamic.IObjectWrapper r11 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r10)     // Catch:{ RemoteException -> 0x019d }
            int r3 = r4.zzf(r11, r6, r7)     // Catch:{ RemoteException -> 0x019d }
            goto L_0x01bf
        L_0x019b:
            r12 = r11
            goto L_0x01c3
        L_0x019d:
            r0 = move-exception
            r11 = r0
            r12 = r11
        L_0x01a0:
            java.lang.String r11 = "DynamiteModule"
            java.lang.String r12 = r12.getMessage()     // Catch:{ all -> 0x01c0 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x01c0 }
            r0.<init>()     // Catch:{ all -> 0x01c0 }
            java.lang.String r1 = "Failed to retrieve remote module version: "
            r0.append(r1)     // Catch:{ all -> 0x01c0 }
            r0.append(r12)     // Catch:{ all -> 0x01c0 }
            java.lang.String r12 = r0.toString()     // Catch:{ all -> 0x01c0 }
            android.util.Log.w(r11, r12)     // Catch:{ all -> 0x01c0 }
            if (r2 == 0) goto L_0x01bf
            r2.close()     // Catch:{ all -> 0x01cd }
        L_0x01bf:
            return r3
        L_0x01c0:
            r0 = move-exception
            r11 = r0
            goto L_0x019b
        L_0x01c3:
            if (r2 == 0) goto L_0x01c8
            r2.close()     // Catch:{ all -> 0x01cd }
        L_0x01c8:
            throw r12     // Catch:{ all -> 0x01cd }
        L_0x01c9:
            r0 = move-exception
            r11 = r0
            monitor-exit(r1)     // Catch:{ all -> 0x01c9 }
            throw r11     // Catch:{ all -> 0x01cd }
        L_0x01cd:
            r0 = move-exception
            r11 = r0
            com.google.android.gms.common.util.CrashUtils.addDynamiteErrorToDropBox(r10, r11)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.DynamiteModule.zza(android.content.Context, java.lang.String, boolean):int");
    }

    /* JADX WARNING: Removed duplicated region for block: B:58:0x00c0 A[Catch:{ all -> 0x00dc }] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00c1 A[Catch:{ all -> 0x00dc }] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00e1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int zzb(android.content.Context r9, java.lang.String r10, boolean r11, boolean r12) throws com.google.android.gms.dynamite.DynamiteModule.LoadingException {
        /*
            r1 = 0
            android.content.ContentResolver r2 = r9.getContentResolver()     // Catch:{ Exception -> 0x00b8, all -> 0x00b4 }
            java.lang.ThreadLocal r9 = zzh     // Catch:{ Exception -> 0x00b8, all -> 0x00b4 }
            java.lang.Object r9 = r9.get()     // Catch:{ Exception -> 0x00b8, all -> 0x00b4 }
            java.lang.Long r9 = (java.lang.Long) r9     // Catch:{ Exception -> 0x00b8, all -> 0x00b4 }
            long r3 = r9.longValue()     // Catch:{ Exception -> 0x00b8, all -> 0x00b4 }
            java.lang.String r9 = "api_force_staging"
            java.lang.String r0 = "api"
            r8 = 1
            if (r8 == r11) goto L_0x0019
            r9 = r0
        L_0x0019:
            android.net.Uri$Builder r11 = new android.net.Uri$Builder     // Catch:{ Exception -> 0x00b8, all -> 0x00b4 }
            r11.<init>()     // Catch:{ Exception -> 0x00b8, all -> 0x00b4 }
            java.lang.String r0 = "content"
            android.net.Uri$Builder r11 = r11.scheme(r0)     // Catch:{ Exception -> 0x00b8, all -> 0x00b4 }
            java.lang.String r0 = "com.google.android.gms.chimera"
            android.net.Uri$Builder r11 = r11.authority(r0)     // Catch:{ Exception -> 0x00b8, all -> 0x00b4 }
            android.net.Uri$Builder r9 = r11.path(r9)     // Catch:{ Exception -> 0x00b8, all -> 0x00b4 }
            android.net.Uri$Builder r9 = r9.appendPath(r10)     // Catch:{ Exception -> 0x00b8, all -> 0x00b4 }
            java.lang.String r10 = "requestStartTime"
            java.lang.String r11 = java.lang.String.valueOf(r3)     // Catch:{ Exception -> 0x00b8, all -> 0x00b4 }
            android.net.Uri$Builder r9 = r9.appendQueryParameter(r10, r11)     // Catch:{ Exception -> 0x00b8, all -> 0x00b4 }
            android.net.Uri r3 = r9.build()     // Catch:{ Exception -> 0x00b8, all -> 0x00b4 }
            r6 = 0
            r7 = 0
            r4 = 0
            r5 = 0
            android.database.Cursor r9 = r2.query(r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x00b8, all -> 0x00b4 }
            if (r9 == 0) goto L_0x00a5
            boolean r10 = r9.moveToFirst()     // Catch:{ Exception -> 0x009c }
            if (r10 == 0) goto L_0x00a5
            r10 = 0
            int r11 = r9.getInt(r10)     // Catch:{ Exception -> 0x009c }
            if (r11 <= 0) goto L_0x008f
            java.lang.Class<com.google.android.gms.dynamite.DynamiteModule> r2 = com.google.android.gms.dynamite.DynamiteModule.class
            monitor-enter(r2)     // Catch:{ Exception -> 0x009c }
            r0 = 2
            java.lang.String r0 = r9.getString(r0)     // Catch:{ all -> 0x008b }
            zzc = r0     // Catch:{ all -> 0x008b }
            java.lang.String r0 = "loaderVersion"
            int r0 = r9.getColumnIndex(r0)     // Catch:{ all -> 0x008b }
            if (r0 < 0) goto L_0x006f
            int r0 = r9.getInt(r0)     // Catch:{ all -> 0x008b }
            zze = r0     // Catch:{ all -> 0x008b }
        L_0x006f:
            java.lang.String r0 = "disableStandaloneDynamiteLoader2"
            int r0 = r9.getColumnIndex(r0)     // Catch:{ all -> 0x008b }
            if (r0 < 0) goto L_0x0082
            int r0 = r9.getInt(r0)     // Catch:{ all -> 0x008b }
            if (r0 == 0) goto L_0x007e
            goto L_0x007f
        L_0x007e:
            r8 = r10
        L_0x007f:
            zzd = r8     // Catch:{ all -> 0x008b }
            r10 = r8
        L_0x0082:
            monitor-exit(r2)     // Catch:{ all -> 0x008b }
            boolean r0 = zze(r9)     // Catch:{ Exception -> 0x009c }
            if (r0 == 0) goto L_0x008f
            r9 = r1
            goto L_0x008f
        L_0x008b:
            r0 = move-exception
            r10 = r0
            monitor-exit(r2)     // Catch:{ all -> 0x008b }
            throw r10     // Catch:{ Exception -> 0x009c }
        L_0x008f:
            if (r12 == 0) goto L_0x009f
            if (r10 != 0) goto L_0x0094
            goto L_0x009f
        L_0x0094:
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r10 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ Exception -> 0x009c }
            java.lang.String r11 = "forcing fallback to container DynamiteLoader impl"
            r10.<init>(r11, r1)     // Catch:{ Exception -> 0x009c }
            throw r10     // Catch:{ Exception -> 0x009c }
        L_0x009c:
            r0 = move-exception
            r10 = r0
            goto L_0x00bc
        L_0x009f:
            if (r9 == 0) goto L_0x00a4
            r9.close()
        L_0x00a4:
            return r11
        L_0x00a5:
            java.lang.String r10 = "DynamiteModule"
            java.lang.String r11 = "Failed to retrieve remote module version."
            android.util.Log.w(r10, r11)     // Catch:{ Exception -> 0x009c }
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r10 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ Exception -> 0x009c }
            java.lang.String r11 = "Failed to connect to dynamite module ContentResolver."
            r10.<init>(r11, r1)     // Catch:{ Exception -> 0x009c }
            throw r10     // Catch:{ Exception -> 0x009c }
        L_0x00b4:
            r0 = move-exception
            r9 = r0
            r10 = r9
            goto L_0x00df
        L_0x00b8:
            r0 = move-exception
            r9 = r0
            r10 = r9
            r9 = r1
        L_0x00bc:
            boolean r11 = r10 instanceof com.google.android.gms.dynamite.DynamiteModule.LoadingException     // Catch:{ all -> 0x00dc }
            if (r11 == 0) goto L_0x00c1
            throw r10     // Catch:{ all -> 0x00dc }
        L_0x00c1:
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r11 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ all -> 0x00dc }
            java.lang.String r12 = r10.getMessage()     // Catch:{ all -> 0x00dc }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x00dc }
            r0.<init>()     // Catch:{ all -> 0x00dc }
            java.lang.String r2 = "V2 version check failed: "
            r0.append(r2)     // Catch:{ all -> 0x00dc }
            r0.append(r12)     // Catch:{ all -> 0x00dc }
            java.lang.String r12 = r0.toString()     // Catch:{ all -> 0x00dc }
            r11.<init>(r12, r10, r1)     // Catch:{ all -> 0x00dc }
            throw r11     // Catch:{ all -> 0x00dc }
        L_0x00dc:
            r0 = move-exception
            r10 = r0
            r1 = r9
        L_0x00df:
            if (r1 == 0) goto L_0x00e4
            r1.close()
        L_0x00e4:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.DynamiteModule.zzb(android.content.Context, java.lang.String, boolean, boolean):int");
    }

    private static DynamiteModule zzc(Context context, String str) {
        Log.i("DynamiteModule", "Selected local version of ".concat(String.valueOf(str)));
        return new DynamiteModule(context);
    }

    private static void zzd(ClassLoader classLoader) throws LoadingException {
        zzr zzr;
        try {
            IBinder iBinder = (IBinder) classLoader.loadClass("com.google.android.gms.dynamiteloader.DynamiteLoaderV2").getConstructor(new Class[0]).newInstance(new Object[0]);
            if (iBinder == null) {
                zzr = null;
            } else {
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoaderV2");
                if (queryLocalInterface instanceof zzr) {
                    zzr = (zzr) queryLocalInterface;
                } else {
                    zzr = new zzr(iBinder);
                }
            }
            zzl = zzr;
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            throw new LoadingException("Failed to instantiate dynamite loader", e, (zzp) null);
        }
    }

    private static boolean zze(Cursor cursor) {
        zzn zzn = (zzn) zzg.get();
        if (zzn == null || zzn.zza != null) {
            return false;
        }
        zzn.zza = cursor;
        return true;
    }

    private static boolean zzf(Context context) {
        if (Boolean.TRUE.equals((Object) null) || Boolean.TRUE.equals(zzf)) {
            return true;
        }
        boolean z = false;
        if (zzf == null) {
            ProviderInfo resolveContentProvider = context.getPackageManager().resolveContentProvider("com.google.android.gms.chimera", 0);
            if (GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(context, 10000000) == 0 && resolveContentProvider != null && "com.google.android.gms".equals(resolveContentProvider.packageName)) {
                z = true;
            }
            Boolean valueOf = Boolean.valueOf(z);
            zzf = valueOf;
            z = valueOf.booleanValue();
            if (z && resolveContentProvider.applicationInfo != null && (resolveContentProvider.applicationInfo.flags & 129) == 0) {
                Log.i("DynamiteModule", "Non-system-image GmsCore APK, forcing V1");
                zzd = true;
            }
        }
        if (!z) {
            Log.e("DynamiteModule", "Invalid GmsCore APK, remote loading disabled.");
        }
        return z;
    }

    private static zzq zzg(Context context) {
        zzq zzq;
        synchronized (DynamiteModule.class) {
            zzq zzq2 = zzk;
            if (zzq2 != null) {
                return zzq2;
            }
            try {
                IBinder iBinder = (IBinder) context.createPackageContext("com.google.android.gms", 3).getClassLoader().loadClass("com.google.android.gms.chimera.container.DynamiteLoaderImpl").newInstance();
                if (iBinder == null) {
                    zzq = null;
                } else {
                    IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoader");
                    zzq = queryLocalInterface instanceof zzq ? (zzq) queryLocalInterface : new zzq(iBinder);
                }
                if (zzq != null) {
                    zzk = zzq;
                    return zzq;
                }
            } catch (Exception e) {
                Log.e("DynamiteModule", "Failed to load IDynamiteLoader from GmsCore: " + e.getMessage());
            }
        }
        return null;
    }

    @ResultIgnorabilityUnspecified
    public Context getModuleContext() {
        return this.zzj;
    }

    public IBinder instantiate(String str) throws LoadingException {
        try {
            return (IBinder) this.zzj.getClassLoader().loadClass(str).newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            throw new LoadingException("Failed to instantiate module class: ".concat(String.valueOf(str)), e, (zzp) null);
        }
    }
}
