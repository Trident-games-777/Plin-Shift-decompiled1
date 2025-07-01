package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.internal.client.zzbc;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.client.zzfv;
import com.google.android.gms.ads.internal.util.client.zzf;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.util.ClientLibraryUtils;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzbyv {
    final AtomicBoolean zza = new AtomicBoolean(false);
    private final AtomicReference zzb = new AtomicReference((Object) null);
    private final Object zzc = new Object();
    private String zzd = null;
    private final AtomicInteger zze = new AtomicInteger(-1);
    private final AtomicReference zzf = new AtomicReference((Object) null);
    private final AtomicReference zzg = new AtomicReference((Object) null);
    private final ConcurrentMap zzh = new ConcurrentHashMap(9);
    private final Object zzi;

    public zzbyv() {
        new AtomicReference((Object) null);
        new ArrayBlockingQueue(20);
        this.zzi = new Object();
    }

    public static final Bundle zzq(Map map) {
        Bundle bundle = new Bundle();
        if (map != null) {
            for (String str : map.keySet()) {
                try {
                    if (Objects.equals(str, "value")) {
                        bundle.putDouble(str, Double.parseDouble((String) map.get(str)));
                    } else {
                        bundle.putString(str, (String) map.get(str));
                    }
                } catch (NullPointerException | NumberFormatException unused) {
                }
            }
        }
        return bundle;
    }

    static final boolean zzr(Context context) {
        if (!((Boolean) zzbe.zzc().zza(zzbcn.zzas)).booleanValue()) {
            return false;
        }
        if (DynamiteModule.getLocalVersion(context, ModuleDescriptor.MODULE_ID) < ((Integer) zzbe.zzc().zza(zzbcn.zzat)).intValue()) {
            return false;
        }
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzau)).booleanValue()) {
            try {
                context.getClassLoader().loadClass("com.google.firebase.analytics.FirebaseAnalytics");
                return false;
            } catch (ClassNotFoundException unused) {
            }
        }
        return true;
    }

    private final Object zzs(String str, Context context) {
        if (!zzx(context, "com.google.android.gms.measurement.AppMeasurement", this.zzf, true)) {
            return null;
        }
        try {
            return zzt(context, str).invoke(this.zzf.get(), new Object[0]);
        } catch (Exception unused) {
            zzw(str, true);
            return null;
        }
    }

    private final Method zzt(Context context, String str) {
        Method method = (Method) this.zzh.get(str);
        if (method != null) {
            return method;
        }
        try {
            Method declaredMethod = context.getClassLoader().loadClass("com.google.android.gms.measurement.AppMeasurement").getDeclaredMethod(str, new Class[0]);
            this.zzh.put(str, declaredMethod);
            return declaredMethod;
        } catch (Exception unused) {
            zzw(str, false);
            return null;
        }
    }

    private final void zzu(Context context, String str, String str2) {
        if (zzx(context, "com.google.android.gms.measurement.AppMeasurement", this.zzf, true)) {
            Method method = (Method) this.zzh.get(str2);
            if (method == null) {
                try {
                    method = context.getClassLoader().loadClass("com.google.android.gms.measurement.AppMeasurement").getDeclaredMethod(str2, new Class[]{String.class});
                    this.zzh.put(str2, method);
                } catch (Exception unused) {
                    zzw(str2, false);
                    method = null;
                }
            }
            try {
                method.invoke(this.zzf.get(), new Object[]{str});
                zze.zza("Invoke Firebase method " + str2 + ", Ad Unit Id: " + str);
            } catch (Exception unused2) {
                zzw(str2, false);
            }
        }
    }

    private final void zzv(Context context, String str, String str2, Bundle bundle) {
        if (zzp(context)) {
            Bundle bundle2 = new Bundle();
            try {
                bundle2.putLong("_aeid", Long.parseLong(str2));
            } catch (NullPointerException | NumberFormatException e) {
                zzm.zzh("Invalid event ID: ".concat(String.valueOf(str2)), e);
            }
            if ("_ac".equals(str)) {
                bundle2.putInt("_r", 1);
            }
            if (bundle != null) {
                bundle2.putAll(bundle);
            }
            if (zzx(context, "com.google.android.gms.measurement.AppMeasurement", this.zzf, true)) {
                Method method = (Method) this.zzh.get("logEventInternal");
                if (method == null) {
                    try {
                        method = context.getClassLoader().loadClass("com.google.android.gms.measurement.AppMeasurement").getDeclaredMethod("logEventInternal", new Class[]{String.class, String.class, Bundle.class});
                        this.zzh.put("logEventInternal", method);
                    } catch (Exception unused) {
                        zzw("logEventInternal", true);
                        method = null;
                    }
                }
                try {
                    method.invoke(this.zzf.get(), new Object[]{"am", str, bundle2});
                } catch (Exception unused2) {
                    zzw("logEventInternal", true);
                }
            }
        }
    }

    private final void zzw(String str, boolean z) {
        if (!this.zza.get()) {
            zzm.zzj("Invoke Firebase method " + str + " error.");
            if (z) {
                zzm.zzj("The Google Mobile Ads SDK will not integrate with Firebase. Admob/Firebase integration requires the latest Firebase SDK jar, but Firebase SDK is either missing or out of date");
                this.zza.set(true);
            }
        }
    }

    private final boolean zzx(Context context, String str, AtomicReference atomicReference, boolean z) {
        if (atomicReference.get() == null) {
            try {
                zzbys.zza(atomicReference, (Object) null, context.getClassLoader().loadClass(str).getDeclaredMethod("getInstance", new Class[]{Context.class}).invoke((Object) null, new Object[]{context}));
            } catch (Exception unused) {
                zzw("getInstance", z);
                return false;
            }
        }
        return true;
    }

    public final String zza(Context context) {
        Object zzs;
        if (zzp(context) && (zzs = zzs("generateEventId", context)) != null) {
            return zzs.toString();
        }
        return null;
    }

    public final String zzb(Context context) {
        ExecutorService executorService;
        if (!zzp(context)) {
            return null;
        }
        long longValue = ((Long) zzbe.zzc().zza(zzbcn.zzaq)).longValue();
        if (longValue < 0) {
            return (String) zzs("getAppInstanceId", context);
        }
        if (this.zzb.get() == null) {
            if (ClientLibraryUtils.isPackageSide()) {
                executorService = zzftc.zza().zzc(((Integer) zzbe.zzc().zza(zzbcn.zzar)).intValue(), new zzbyu(this), 2);
            } else {
                executorService = new ThreadPoolExecutor(((Integer) zzbe.zzc().zza(zzbcn.zzar)).intValue(), ((Integer) zzbe.zzc().zza(zzbcn.zzar)).intValue(), 1, TimeUnit.MINUTES, new LinkedBlockingQueue(), new zzbyu(this));
            }
            zzbys.zza(this.zzb, (Object) null, executorService);
        }
        try {
            return (String) ((ExecutorService) this.zzb.get()).submit(new zzbyt(this, context)).get(longValue, TimeUnit.MILLISECONDS);
        } catch (TimeoutException unused) {
            return "TIME_OUT";
        } catch (Exception unused2) {
            return null;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v8, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String zzc(android.content.Context r7) {
        /*
            r6 = this;
            java.lang.String r0 = "getCurrentScreenName"
            boolean r1 = r6.zzp(r7)
            java.lang.String r2 = ""
            if (r1 != 0) goto L_0x000b
            goto L_0x0047
        L_0x000b:
            java.util.concurrent.atomic.AtomicReference r1 = r6.zzf
            java.lang.String r3 = "com.google.android.gms.measurement.AppMeasurement"
            r4 = 1
            boolean r1 = r6.zzx(r7, r3, r1, r4)
            if (r1 == 0) goto L_0x0047
            r1 = 0
            java.lang.reflect.Method r3 = r6.zzt(r7, r0)     // Catch:{ Exception -> 0x0044 }
            java.util.concurrent.atomic.AtomicReference r4 = r6.zzf     // Catch:{ Exception -> 0x0044 }
            java.lang.Object r4 = r4.get()     // Catch:{ Exception -> 0x0044 }
            java.lang.Object[] r5 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x0044 }
            java.lang.Object r3 = r3.invoke(r4, r5)     // Catch:{ Exception -> 0x0044 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ Exception -> 0x0044 }
            if (r3 != 0) goto L_0x0040
            java.lang.String r3 = "getCurrentScreenClass"
            java.lang.reflect.Method r7 = r6.zzt(r7, r3)     // Catch:{ Exception -> 0x0044 }
            java.util.concurrent.atomic.AtomicReference r3 = r6.zzf     // Catch:{ Exception -> 0x0044 }
            java.lang.Object r3 = r3.get()     // Catch:{ Exception -> 0x0044 }
            java.lang.Object[] r4 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x0044 }
            java.lang.Object r7 = r7.invoke(r3, r4)     // Catch:{ Exception -> 0x0044 }
            r3 = r7
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ Exception -> 0x0044 }
        L_0x0040:
            if (r3 != 0) goto L_0x0043
            return r2
        L_0x0043:
            return r3
        L_0x0044:
            r6.zzw(r0, r1)
        L_0x0047:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbyv.zzc(android.content.Context):java.lang.String");
    }

    public final String zzd(Context context) {
        if (!zzp(context)) {
            return null;
        }
        synchronized (this.zzc) {
            String str = this.zzd;
            if (str != null) {
                return str;
            }
            String str2 = (String) zzs("getGmpAppId", context);
            this.zzd = str2;
            return str2;
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ String zze(Context context) throws Exception {
        return (String) zzs("getAppInstanceId", context);
    }

    public final void zzf(Context context, String str) {
        if (zzp(context)) {
            zzu(context, str, "beginAdUnitExposure");
        }
    }

    public final void zzg(Context context, String str) {
        if (zzp(context)) {
            zzu(context, str, "endAdUnitExposure");
        }
    }

    public final void zzh(Context context, String str) {
        zzv(context, "_aa", str, (Bundle) null);
    }

    public final void zzi(Context context, String str) {
        zzv(context, "_aq", str, (Bundle) null);
    }

    public final void zzj(Context context, String str, Map map) {
        zzv(context, "_ac", str, zzq(map));
    }

    public final void zzk(Context context, String str, Map map) {
        zzv(context, "_ai", str, zzq(map));
    }

    public final void zzl(Context context, String str, String str2, String str3, int i) {
        if (zzp(context)) {
            Bundle bundle = new Bundle();
            bundle.putString("_ai", str2);
            bundle.putString("reward_type", str3);
            bundle.putInt("reward_value", i);
            zzv(context, "_ar", str, bundle);
            zze.zza("Log a Firebase reward video event, reward type: " + str3 + ", reward value: " + i);
        }
    }

    public final void zzm(Context context, com.google.android.gms.ads.internal.client.zzm zzm) {
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzax)).booleanValue() && zzp(context) && zzr(context)) {
            synchronized (this.zzi) {
            }
        }
    }

    public final void zzn(Context context, zzfv zzfv) {
        zzbyw.zzd(context).zzb().zzc(zzfv);
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzax)).booleanValue() && zzp(context) && zzr(context)) {
            synchronized (this.zzi) {
            }
        }
    }

    @Deprecated
    public final void zzo(Context context, String str) {
        if (zzp(context) && (context instanceof Activity) && zzx(context, "com.google.firebase.analytics.FirebaseAnalytics", this.zzg, false)) {
            Method method = (Method) this.zzh.get("setCurrentScreen");
            if (method == null) {
                try {
                    method = context.getClassLoader().loadClass("com.google.firebase.analytics.FirebaseAnalytics").getDeclaredMethod("setCurrentScreen", new Class[]{Activity.class, String.class, String.class});
                    this.zzh.put("setCurrentScreen", method);
                } catch (Exception unused) {
                    zzw("setCurrentScreen", false);
                    method = null;
                }
            }
            try {
                method.invoke(this.zzg.get(), new Object[]{(Activity) context, str, context.getPackageName()});
            } catch (Exception unused2) {
                zzw("setCurrentScreen", false);
            }
        }
    }

    public final boolean zzp(Context context) {
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzak)).booleanValue() && !this.zza.get()) {
            if (((Boolean) zzbe.zzc().zza(zzbcn.zzav)).booleanValue()) {
                return true;
            }
            if (this.zze.get() == -1) {
                zzbc.zzb();
                if (!zzf.zzt(context, GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE)) {
                    zzbc.zzb();
                    if (zzf.zzu(context)) {
                        zzm.zzj("Google Play Service is out of date, the Google Mobile Ads SDK will not integrate with Firebase. Admob/Firebase integration requires updated Google Play Service.");
                        this.zze.set(0);
                    }
                }
                this.zze.set(1);
            }
            if (this.zze.get() == 1) {
                return true;
            }
        }
        return false;
    }
}
