package com.google.android.gms.internal.ads;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.WebView;
import androidx.core.os.EnvironmentCompat;
import androidx.webkit.ProxyConfig;
import coil3.disk.DiskLruCache;
import com.google.android.gms.ads.internal.client.zzbc;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzf;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.client.zzr;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.wrappers.Wrappers;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
public final class zzbuj implements zzbul {
    public static zzbul zza;
    static zzbul zzb;
    static zzbul zzc;
    static Boolean zzd;
    private static final Object zze = new Object();
    private final Object zzf;
    private final Context zzg;
    private final WeakHashMap zzh;
    private final ExecutorService zzi;
    private final VersionInfoParcel zzj;
    private final PackageInfo zzk;
    private final String zzl;
    private final String zzm;
    private final AtomicBoolean zzn;
    private boolean zzo;

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0096  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00b3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected zzbuj(android.content.Context r3, com.google.android.gms.ads.internal.util.client.VersionInfoParcel r4) {
        /*
            r2 = this;
            r2.<init>()
            java.lang.Object r0 = new java.lang.Object
            r0.<init>()
            r2.zzf = r0
            java.util.WeakHashMap r0 = new java.util.WeakHashMap
            r0.<init>()
            r2.zzh = r0
            com.google.android.gms.internal.ads.zzftc.zza()
            java.util.concurrent.ExecutorService r0 = java.util.concurrent.Executors.newCachedThreadPool()
            java.util.concurrent.ExecutorService r0 = java.util.concurrent.Executors.unconfigurableExecutorService(r0)
            r2.zzi = r0
            java.util.concurrent.atomic.AtomicBoolean r0 = new java.util.concurrent.atomic.AtomicBoolean
            r0.<init>()
            r2.zzn = r0
            android.content.Context r0 = r3.getApplicationContext()
            if (r0 == 0) goto L_0x002f
            android.content.Context r3 = r3.getApplicationContext()
        L_0x002f:
            r2.zzg = r3
            r2.zzj = r4
            com.google.android.gms.internal.ads.zzbce r4 = com.google.android.gms.internal.ads.zzbcn.zzhv
            com.google.android.gms.internal.ads.zzbcl r0 = com.google.android.gms.ads.internal.client.zzbe.zzc()
            java.lang.Object r4 = r0.zza(r4)
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r4 = r4.booleanValue()
            r0 = 0
            if (r4 == 0) goto L_0x0061
            android.os.Handler r4 = com.google.android.gms.ads.internal.util.client.zzf.zza
            if (r3 == 0) goto L_0x0061
            android.content.pm.ApplicationInfo r4 = r3.getApplicationInfo()
            if (r4 != 0) goto L_0x0051
            goto L_0x0061
        L_0x0051:
            com.google.android.gms.common.wrappers.PackageManagerWrapper r4 = com.google.android.gms.common.wrappers.Wrappers.packageManager(r3)     // Catch:{ NameNotFoundException -> 0x0061 }
            android.content.pm.ApplicationInfo r3 = r3.getApplicationInfo()     // Catch:{ NameNotFoundException -> 0x0061 }
            java.lang.String r3 = r3.packageName     // Catch:{ NameNotFoundException -> 0x0061 }
            r1 = 0
            android.content.pm.PackageInfo r3 = r4.getPackageInfo(r3, r1)     // Catch:{ NameNotFoundException -> 0x0061 }
            goto L_0x0062
        L_0x0061:
            r3 = r0
        L_0x0062:
            r2.zzk = r3
            com.google.android.gms.internal.ads.zzbce r3 = com.google.android.gms.internal.ads.zzbcn.zzht
            com.google.android.gms.internal.ads.zzbcl r4 = com.google.android.gms.ads.internal.client.zzbe.zzc()
            java.lang.Object r3 = r4.zza(r3)
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            boolean r3 = r3.booleanValue()
            java.lang.String r4 = "unknown"
            if (r3 == 0) goto L_0x0081
            java.util.Locale r3 = java.util.Locale.getDefault()
            java.lang.String r3 = r3.getCountry()
            goto L_0x0082
        L_0x0081:
            r3 = r4
        L_0x0082:
            r2.zzl = r3
            com.google.android.gms.internal.ads.zzbce r3 = com.google.android.gms.internal.ads.zzbcn.zzht
            com.google.android.gms.internal.ads.zzbcl r1 = com.google.android.gms.ads.internal.client.zzbe.zzc()
            java.lang.Object r3 = r1.zza(r3)
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            boolean r3 = r3.booleanValue()
            if (r3 == 0) goto L_0x00b3
            android.content.Context r3 = r2.zzg
            android.os.Handler r4 = com.google.android.gms.ads.internal.util.client.zzf.zza
            if (r3 != 0) goto L_0x009d
            goto L_0x00b4
        L_0x009d:
            com.google.android.gms.common.wrappers.PackageManagerWrapper r3 = com.google.android.gms.common.wrappers.Wrappers.packageManager(r3)     // Catch:{ NameNotFoundException -> 0x00b4 }
            java.lang.String r4 = "com.android.vending"
            r1 = 128(0x80, float:1.794E-43)
            android.content.pm.PackageInfo r3 = r3.getPackageInfo(r4, r1)     // Catch:{ NameNotFoundException -> 0x00b4 }
            if (r3 != 0) goto L_0x00ac
            goto L_0x00b4
        L_0x00ac:
            int r3 = r3.versionCode     // Catch:{ NameNotFoundException -> 0x00b4 }
            java.lang.String r0 = java.lang.Integer.toString(r3)     // Catch:{ NameNotFoundException -> 0x00b4 }
            goto L_0x00b4
        L_0x00b3:
            r0 = r4
        L_0x00b4:
            r2.zzm = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbuj.<init>(android.content.Context, com.google.android.gms.ads.internal.util.client.VersionInfoParcel):void");
    }

    public static zzbul zza(Context context) {
        synchronized (zze) {
            if (zza == null) {
                if (zzl(context)) {
                    zza = new zzbuj(context, VersionInfoParcel.forPackage());
                } else {
                    zza = new zzbuk();
                }
            }
        }
        return zza;
    }

    public static zzbul zzb(Context context, VersionInfoParcel versionInfoParcel) {
        synchronized (zze) {
            if (zzc == null) {
                boolean z = false;
                if (((Boolean) zzbef.zzc.zze()).booleanValue()) {
                    if (!((Boolean) zzbe.zzc().zza(zzbcn.zzho)).booleanValue() || ((Boolean) zzbef.zza.zze()).booleanValue()) {
                        z = true;
                    }
                }
                if (zzl(context)) {
                    zzbuj zzbuj = new zzbuj(context, versionInfoParcel);
                    zzbuj.zzk();
                    zzbuj.zzj();
                    zzc = zzbuj;
                } else if (!z || context == null) {
                    zzc = new zzbuk();
                } else {
                    zzbuj zzbuj2 = new zzbuj(context, versionInfoParcel, true);
                    zzbuj2.zzk();
                    zzbuj2.zzj();
                    zzc = zzbuj2;
                }
            }
        }
        return zzc;
    }

    public static zzbul zzc(Context context) {
        synchronized (zze) {
            if (zzb == null) {
                if (((Boolean) zzbe.zzc().zza(zzbcn.zzhp)).booleanValue()) {
                    if (!((Boolean) zzbe.zzc().zza(zzbcn.zzho)).booleanValue()) {
                        zzb = new zzbuj(context, VersionInfoParcel.forPackage());
                    }
                }
                zzb = new zzbuk();
            }
        }
        return zzb;
    }

    public static zzbul zzd(Context context, VersionInfoParcel versionInfoParcel) {
        synchronized (zze) {
            if (zzb == null) {
                if (((Boolean) zzbe.zzc().zza(zzbcn.zzhp)).booleanValue()) {
                    if (!((Boolean) zzbe.zzc().zza(zzbcn.zzho)).booleanValue()) {
                        zzb = new zzbuj(context, versionInfoParcel);
                    }
                }
                zzb = new zzbuk();
            }
        }
        return zzb;
    }

    public static String zze(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    public static String zzf(Throwable th) {
        return zzfxf.zzc(zzf.zzg(zze(th)));
    }

    private final void zzj() {
        Thread.setDefaultUncaughtExceptionHandler(new zzbuh(this, Thread.getDefaultUncaughtExceptionHandler()));
    }

    private final void zzk() {
        Thread thread = Looper.getMainLooper().getThread();
        if (thread != null) {
            synchronized (this.zzf) {
                this.zzh.put(thread, true);
            }
            thread.setUncaughtExceptionHandler(new zzbui(this, thread.getUncaughtExceptionHandler()));
        }
    }

    private static boolean zzl(Context context) {
        if (context == null) {
            return false;
        }
        if (!((Boolean) zzbe.zzc().zza(zzbcn.zzmv)).booleanValue()) {
            if (((Boolean) zzbew.zze.zze()).booleanValue()) {
                if (!((Boolean) zzbe.zzc().zza(zzbcn.zzho)).booleanValue()) {
                    return true;
                }
            }
            return false;
        }
        synchronized (zze) {
            if (zzd == null) {
                zzd = Boolean.valueOf(zzbc.zze().nextInt(100) < ((Integer) zzbe.zzc().zza(zzbcn.zzms)).intValue());
            }
        }
        if (zzd.booleanValue()) {
            if (!((Boolean) zzbe.zzc().zza(zzbcn.zzho)).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public final void zzg(Thread thread, Throwable th) {
        if (th != null) {
            boolean z = false;
            boolean z2 = false;
            for (Throwable th2 = th; th2 != null; th2 = th2.getCause()) {
                for (StackTraceElement stackTraceElement : th2.getStackTrace()) {
                    z |= zzf.zzp(stackTraceElement.getClassName());
                    z2 |= getClass().getName().equals(stackTraceElement.getClassName());
                }
            }
            if (z && !z2) {
                if (!this.zzo) {
                    zzh(th, "");
                }
                if (!this.zzn.getAndSet(true) && ((Boolean) zzbef.zzc.zze()).booleanValue()) {
                    zzbbx.zzc(this.zzg);
                }
            }
        }
    }

    public final void zzh(Throwable th, String str) {
        if (!this.zzo) {
            zzi(th, str, 1.0f);
        }
    }

    public final void zzi(Throwable th, String str, float f) {
        Throwable th2;
        String str2;
        ActivityManager.MemoryInfo zzc2;
        Throwable th3;
        float f2 = f;
        if (!this.zzo) {
            Handler handler = zzf.zza;
            boolean z = false;
            if (((Boolean) zzbew.zzf.zze()).booleanValue()) {
                th2 = th;
            } else {
                LinkedList linkedList = new LinkedList();
                for (Throwable th4 = th; th4 != null; th4 = th4.getCause()) {
                    linkedList.push(th4);
                }
                th2 = null;
                while (!linkedList.isEmpty()) {
                    Throwable th5 = (Throwable) linkedList.pop();
                    StackTraceElement[] stackTrace = th5.getStackTrace();
                    boolean z2 = ((Boolean) zzbe.zzc().zza(zzbcn.zzcr)).booleanValue() && stackTrace != null && stackTrace.length == 0 && zzf.zzp(th5.getClass().getName());
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new StackTraceElement(th5.getClass().getName(), "<filtered>", "<filtered>", 1));
                    for (StackTraceElement stackTraceElement : stackTrace) {
                        if (zzf.zzp(stackTraceElement.getClassName())) {
                            arrayList.add(stackTraceElement);
                            z2 = true;
                        } else {
                            String className = stackTraceElement.getClassName();
                            if (!TextUtils.isEmpty(className) && (className.startsWith("android.") || className.startsWith("java."))) {
                                arrayList.add(stackTraceElement);
                            } else {
                                arrayList.add(new StackTraceElement("<filtered>", "<filtered>", "<filtered>", 1));
                            }
                        }
                    }
                    if (z2) {
                        if (th2 == null) {
                            th3 = new Throwable(th5.getMessage());
                        } else {
                            th3 = new Throwable(th5.getMessage(), th2);
                        }
                        th2 = th3;
                        th2.setStackTrace((StackTraceElement[]) arrayList.toArray(new StackTraceElement[0]));
                    }
                }
            }
            if (th2 != null) {
                String name = th.getClass().getName();
                String zze2 = zze(th);
                String zzf2 = ((Boolean) zzbe.zzc().zza(zzbcn.zziu)).booleanValue() ? zzf(th) : "";
                double d = (double) f2;
                int i = (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1));
                double random = Math.random();
                int i2 = i > 0 ? (int) (1.0f / f2) : 1;
                if (random < d) {
                    ArrayList<String> arrayList2 = new ArrayList<>();
                    try {
                        z = Wrappers.packageManager(this.zzg).isCallerInstantApp();
                    } catch (Throwable th6) {
                        zzm.zzh("Error fetching instant app info", th6);
                    }
                    try {
                        str2 = this.zzg.getPackageName();
                    } catch (Throwable unused) {
                        zzm.zzj("Cannot obtain package name, proceeding.");
                        str2 = EnvironmentCompat.MEDIA_UNKNOWN;
                    }
                    Uri.Builder appendQueryParameter = new Uri.Builder().scheme(ProxyConfig.MATCH_HTTPS).path("//pagead2.googlesyndication.com/pagead/gen_204").appendQueryParameter("is_aia", Boolean.toString(z)).appendQueryParameter("id", "gmob-apps-report-exception").appendQueryParameter("os", Build.VERSION.RELEASE).appendQueryParameter("api", String.valueOf(Build.VERSION.SDK_INT));
                    String str3 = Build.MANUFACTURER;
                    String str4 = Build.MODEL;
                    if (!str4.startsWith(str3)) {
                        str4 = str3 + " " + str4;
                    }
                    Uri.Builder appendQueryParameter2 = appendQueryParameter.appendQueryParameter("device", str4).appendQueryParameter("js", this.zzj.afmaVersion).appendQueryParameter("appid", str2).appendQueryParameter("exceptiontype", name).appendQueryParameter("stacktrace", zze2).appendQueryParameter("eids", TextUtils.join(",", zzbe.zza().zza())).appendQueryParameter("exceptionkey", str).appendQueryParameter("cl", "685849915").appendQueryParameter("rc", "dev").appendQueryParameter("sampling_rate", Integer.toString(i2)).appendQueryParameter("pb_tm", String.valueOf(zzbew.zzc.zze())).appendQueryParameter("gmscv", String.valueOf(GoogleApiAvailabilityLight.getInstance().getApkVersion(this.zzg)));
                    String str5 = "0";
                    Uri.Builder appendQueryParameter3 = appendQueryParameter2.appendQueryParameter("lite", true != this.zzj.isLiteSdk ? str5 : DiskLruCache.VERSION);
                    if (!TextUtils.isEmpty(zzf2)) {
                        appendQueryParameter3.appendQueryParameter("hash", zzf2);
                    }
                    if (((Boolean) zzbe.zzc().zza(zzbcn.zzhu)).booleanValue() && (zzc2 = zzf.zzc(this.zzg)) != null) {
                        appendQueryParameter3.appendQueryParameter("available_memory", Long.toString(zzc2.availMem));
                        appendQueryParameter3.appendQueryParameter("total_memory", Long.toString(zzc2.totalMem));
                        if (true == zzc2.lowMemory) {
                            str5 = DiskLruCache.VERSION;
                        }
                        appendQueryParameter3.appendQueryParameter("is_low_memory", str5);
                    }
                    if (((Boolean) zzbe.zzc().zza(zzbcn.zzht)).booleanValue()) {
                        if (!TextUtils.isEmpty(this.zzl)) {
                            appendQueryParameter3.appendQueryParameter("countrycode", this.zzl);
                        }
                        if (!TextUtils.isEmpty(this.zzm)) {
                            appendQueryParameter3.appendQueryParameter("psv", this.zzm);
                        }
                        PackageInfo currentWebViewPackage = WebView.getCurrentWebViewPackage();
                        if (currentWebViewPackage != null) {
                            appendQueryParameter3.appendQueryParameter("wvvc", Integer.toString(currentWebViewPackage.versionCode));
                            appendQueryParameter3.appendQueryParameter("wvvn", currentWebViewPackage.versionName);
                            appendQueryParameter3.appendQueryParameter("wvpn", currentWebViewPackage.packageName);
                        }
                    }
                    PackageInfo packageInfo = this.zzk;
                    if (packageInfo != null) {
                        appendQueryParameter3.appendQueryParameter("appvc", String.valueOf(packageInfo.versionCode));
                        appendQueryParameter3.appendQueryParameter("appvn", this.zzk.versionName);
                    }
                    arrayList2.add(appendQueryParameter3.toString());
                    for (String zzbug : arrayList2) {
                        this.zzi.execute(new zzbug(new zzr((String) null), zzbug));
                    }
                }
            }
        }
    }

    protected zzbuj(Context context, VersionInfoParcel versionInfoParcel, boolean z) {
        this(context, versionInfoParcel);
        this.zzo = true;
    }
}
