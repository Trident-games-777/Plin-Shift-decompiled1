package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.os.ext.SdkExtensions;
import android.text.TextUtils;
import androidx.compose.material3.internal.CalendarModelKt;
import androidx.core.app.NotificationCompat;
import androidx.privacysandbox.ads.adservices.java.measurement.MeasurementManagerFutures;
import androidx.webkit.ProxyConfig;
import androidx.work.WorkRequest;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.CollectionUtils;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzdo;
import com.google.android.gms.internal.measurement.zzpu;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.ByteArrayInputStream;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Random;
import java.util.TreeSet;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import javax.security.auth.x500.X500Principal;
import kotlin.time.DurationKt;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.dataflow.qual.Pure;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.1.2 */
public final class zzos extends zzjd {
    private static final String[] zza = {"firebase_", "google_", "ga_"};
    private static final String[] zzb = {"_err"};
    private SecureRandom zzc;
    private final AtomicLong zzd = new AtomicLong(0);
    private int zze;
    private MeasurementManagerFutures zzf;
    private Boolean zzg;
    private Integer zzh = null;

    /* JADX WARNING: Removed duplicated region for block: B:34:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00aa A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00ab  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int zza(java.lang.String r12, java.lang.String r13, java.lang.String r14, java.lang.Object r15, android.os.Bundle r16, java.util.List<java.lang.String> r17, boolean r18, boolean r19) {
        /*
            r11 = this;
            r0 = r16
            r11.zzt()
            boolean r1 = zza((java.lang.Object) r15)
            java.lang.String r2 = "param"
            r3 = 0
            if (r1 == 0) goto L_0x0084
            if (r19 == 0) goto L_0x0081
            java.lang.String[] r1 = com.google.android.gms.measurement.internal.zzjk.zzc
            boolean r1 = zza((java.lang.String) r14, (java.lang.String[]) r1)
            if (r1 != 0) goto L_0x001b
            r12 = 20
            return r12
        L_0x001b:
            com.google.android.gms.measurement.internal.zzhy r1 = r11.zzu
            com.google.android.gms.measurement.internal.zzls r1 = r1.zzr()
            boolean r1 = r1.zzam()
            if (r1 != 0) goto L_0x002a
            r12 = 25
            return r12
        L_0x002a:
            boolean r1 = r15 instanceof android.os.Parcelable[]
            if (r1 == 0) goto L_0x0033
            r4 = r15
            android.os.Parcelable[] r4 = (android.os.Parcelable[]) r4
            int r4 = r4.length
            goto L_0x003e
        L_0x0033:
            boolean r4 = r15 instanceof java.util.ArrayList
            if (r4 == 0) goto L_0x0084
            r4 = r15
            java.util.ArrayList r4 = (java.util.ArrayList) r4
            int r4 = r4.size()
        L_0x003e:
            r5 = 200(0xc8, float:2.8E-43)
            if (r4 <= r5) goto L_0x0084
            com.google.android.gms.measurement.internal.zzgo r6 = r11.zzj()
            com.google.android.gms.measurement.internal.zzgq r6 = r6.zzv()
            java.lang.String r7 = "Parameter array is too long; discarded. Value kind, name, array length"
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r6.zza(r7, r2, r14, r4)
            if (r1 == 0) goto L_0x0065
            r1 = r15
            android.os.Parcelable[] r1 = (android.os.Parcelable[]) r1
            int r4 = r1.length
            if (r4 <= r5) goto L_0x007e
            java.lang.Object[] r1 = java.util.Arrays.copyOf(r1, r5)
            android.os.Parcelable[] r1 = (android.os.Parcelable[]) r1
            r0.putParcelableArray(r14, r1)
            goto L_0x007e
        L_0x0065:
            boolean r1 = r15 instanceof java.util.ArrayList
            if (r1 == 0) goto L_0x007e
            r1 = r15
            java.util.ArrayList r1 = (java.util.ArrayList) r1
            int r4 = r1.size()
            if (r4 <= r5) goto L_0x007e
            java.util.ArrayList r4 = new java.util.ArrayList
            java.util.List r1 = r1.subList(r3, r5)
            r4.<init>(r1)
            r0.putParcelableArrayList(r14, r4)
        L_0x007e:
            r0 = 17
            goto L_0x0085
        L_0x0081:
            r12 = 21
            return r12
        L_0x0084:
            r0 = r3
        L_0x0085:
            boolean r1 = zzg(r13)
            r4 = 0
            if (r1 != 0) goto L_0x009c
            boolean r1 = zzg(r14)
            if (r1 == 0) goto L_0x0093
            goto L_0x009c
        L_0x0093:
            com.google.android.gms.measurement.internal.zzag r1 = r11.zze()
            int r1 = r1.zza((java.lang.String) r4, (boolean) r3)
            goto L_0x00a4
        L_0x009c:
            com.google.android.gms.measurement.internal.zzag r1 = r11.zze()
            int r1 = r1.zzb((java.lang.String) r4, (boolean) r3)
        L_0x00a4:
            boolean r1 = r11.zza((java.lang.String) r2, (java.lang.String) r14, (int) r1, (java.lang.Object) r15)
            if (r1 == 0) goto L_0x00ab
            return r0
        L_0x00ab:
            if (r19 == 0) goto L_0x0132
            boolean r1 = r15 instanceof android.os.Bundle
            if (r1 == 0) goto L_0x00c0
            r8 = r15
            android.os.Bundle r8 = (android.os.Bundle) r8
            r4 = r11
            r5 = r12
            r6 = r13
            r7 = r14
            r9 = r17
            r10 = r18
            r4.zza((java.lang.String) r5, (java.lang.String) r6, (java.lang.String) r7, (android.os.Bundle) r8, (java.util.List<java.lang.String>) r9, (boolean) r10)
            return r0
        L_0x00c0:
            boolean r1 = r15 instanceof android.os.Parcelable[]
            if (r1 == 0) goto L_0x00f4
            android.os.Parcelable[] r15 = (android.os.Parcelable[]) r15
            int r8 = r15.length
            r9 = r3
        L_0x00c8:
            if (r9 >= r8) goto L_0x00f3
            r1 = r15[r9]
            boolean r2 = r1 instanceof android.os.Bundle
            if (r2 != 0) goto L_0x00e2
            com.google.android.gms.measurement.internal.zzgo r12 = r11.zzj()
            com.google.android.gms.measurement.internal.zzgq r12 = r12.zzv()
            java.lang.String r13 = "All Parcelable[] elements must be of type Bundle. Value type, name"
            java.lang.Class r15 = r1.getClass()
            r12.zza(r13, r15, r14)
            goto L_0x0132
        L_0x00e2:
            r5 = r1
            android.os.Bundle r5 = (android.os.Bundle) r5
            r1 = r11
            r2 = r12
            r3 = r13
            r4 = r14
            r6 = r17
            r7 = r18
            r1.zza((java.lang.String) r2, (java.lang.String) r3, (java.lang.String) r4, (android.os.Bundle) r5, (java.util.List<java.lang.String>) r6, (boolean) r7)
            int r9 = r9 + 1
            goto L_0x00c8
        L_0x00f3:
            return r0
        L_0x00f4:
            boolean r1 = r15 instanceof java.util.ArrayList
            if (r1 == 0) goto L_0x0132
            java.util.ArrayList r15 = (java.util.ArrayList) r15
            int r8 = r15.size()
        L_0x00fe:
            if (r3 >= r8) goto L_0x0131
            java.lang.Object r1 = r15.get(r3)
            int r9 = r3 + 1
            boolean r2 = r1 instanceof android.os.Bundle
            if (r2 != 0) goto L_0x0121
            com.google.android.gms.measurement.internal.zzgo r12 = r11.zzj()
            com.google.android.gms.measurement.internal.zzgq r12 = r12.zzv()
            if (r1 == 0) goto L_0x0119
            java.lang.Class r13 = r1.getClass()
            goto L_0x011b
        L_0x0119:
            java.lang.String r13 = "null"
        L_0x011b:
            java.lang.String r15 = "All ArrayList elements must be of type Bundle. Value type, name"
            r12.zza(r15, r13, r14)
            goto L_0x0132
        L_0x0121:
            r5 = r1
            android.os.Bundle r5 = (android.os.Bundle) r5
            r1 = r11
            r2 = r12
            r3 = r13
            r4 = r14
            r6 = r17
            r7 = r18
            r1.zza((java.lang.String) r2, (java.lang.String) r3, (java.lang.String) r4, (android.os.Bundle) r5, (java.util.List<java.lang.String>) r6, (boolean) r7)
            r3 = r9
            goto L_0x00fe
        L_0x0131:
            return r0
        L_0x0132:
            r12 = 4
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzos.zza(java.lang.String, java.lang.String, java.lang.String, java.lang.Object, android.os.Bundle, java.util.List, boolean, boolean):int");
    }

    /* access modifiers changed from: protected */
    public final boolean zzh() {
        return true;
    }

    /* access modifiers changed from: package-private */
    public final int zza(String str, Object obj) {
        boolean z;
        if ("_ldl".equals(str)) {
            z = zza("user property referrer", str, zzm(str), obj);
        } else {
            z = zza("user property", str, zzm(str), obj);
        }
        return z ? 0 : 7;
    }

    /* access modifiers changed from: package-private */
    public final int zza(String str) {
        if (!zzb(NotificationCompat.CATEGORY_EVENT, str)) {
            return 2;
        }
        if (!zza(NotificationCompat.CATEGORY_EVENT, zzji.zza, zzji.zzb, str)) {
            return 13;
        }
        if (!zza(NotificationCompat.CATEGORY_EVENT, 40, str)) {
            return 2;
        }
        return 0;
    }

    private final int zzk(String str) {
        if (!zzb("event param", str)) {
            return 3;
        }
        if (!zza("event param", (String[]) null, str)) {
            return 14;
        }
        if (!zza("event param", 40, str)) {
            return 3;
        }
        return 0;
    }

    private final int zzl(String str) {
        if (!zzc("event param", str)) {
            return 3;
        }
        if (!zza("event param", (String[]) null, str)) {
            return 14;
        }
        if (!zza("event param", 40, str)) {
            return 3;
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    public final int zzb(String str) {
        if (!zzb("user property", str)) {
            return 6;
        }
        if (!zza("user property", zzjj.zza, str)) {
            return 15;
        }
        if (!zza("user property", 24, str)) {
            return 6;
        }
        return 0;
    }

    static int zzc() {
        if (Build.VERSION.SDK_INT < 30 || SdkExtensions.getExtensionVersion(30) <= 3) {
            return 0;
        }
        return SdkExtensions.getExtensionVersion(DurationKt.NANOS_IN_MILLIS);
    }

    @EnsuresNonNull({"this.apkVersion"})
    public final int zzg() {
        if (this.zzh == null) {
            this.zzh = Integer.valueOf(GoogleApiAvailabilityLight.getInstance().getApkVersion(zza()) / 1000);
        }
        return this.zzh.intValue();
    }

    private static int zzm(String str) {
        if ("_ldl".equals(str)) {
            return 2048;
        }
        if ("_id".equals(str)) {
            return 256;
        }
        return "_lgclid".equals(str) ? 100 : 36;
    }

    public final int zza(int i) {
        return GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(zza(), GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE);
    }

    /* access modifiers changed from: package-private */
    public final long zzc(String str) {
        if (zza().getPackageManager() == null) {
            return 0;
        }
        int i = 0;
        try {
            ApplicationInfo applicationInfo = Wrappers.packageManager(zza()).getApplicationInfo(str, 0);
            if (applicationInfo != null) {
                i = applicationInfo.targetSdkVersion;
            }
        } catch (PackageManager.NameNotFoundException unused) {
            zzj().zzo().zza("PackageManager failed to find running app: app_id", str);
        }
        return (long) i;
    }

    /* access modifiers changed from: package-private */
    public final long zzm() {
        long j;
        zzt();
        if (!zzd(this.zzu.zzh().zzad())) {
            return 0;
        }
        if (Build.VERSION.SDK_INT < 30) {
            j = 4;
        } else if (SdkExtensions.getExtensionVersion(30) < 4) {
            j = 8;
        } else {
            j = zzc() < zzbh.zzax.zza(null).intValue() ? 16 : 0;
        }
        if (!zze("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")) {
            j |= 2;
        }
        if (j == 0 && !zzy()) {
            j |= 64;
        }
        if (j == 0) {
            return 1;
        }
        return j;
    }

    /* access modifiers changed from: package-private */
    public final long zza(Context context, String str) {
        zzt();
        Preconditions.checkNotNull(context);
        Preconditions.checkNotEmpty(str);
        PackageManager packageManager = context.getPackageManager();
        MessageDigest zzu = zzu();
        if (zzu == null) {
            zzj().zzg().zza("Could not get MD5 instance");
            return -1;
        } else if (packageManager == null) {
            return 0;
        } else {
            try {
                if (zzb(context, str)) {
                    return 0;
                }
                PackageInfo packageInfo = Wrappers.packageManager(context).getPackageInfo(zza().getPackageName(), 64);
                if (packageInfo.signatures != null && packageInfo.signatures.length > 0) {
                    return zza(zzu.digest(packageInfo.signatures[0].toByteArray()));
                }
                zzj().zzu().zza("Could not get signatures");
                return -1;
            } catch (PackageManager.NameNotFoundException e) {
                zzj().zzg().zza("Package name not found", e);
                return 0;
            }
        }
    }

    static long zza(byte[] bArr) {
        Preconditions.checkNotNull(bArr);
        int i = 0;
        Preconditions.checkState(bArr.length > 0);
        int length = bArr.length - 1;
        long j = 0;
        while (length >= 0 && length >= bArr.length - 8) {
            j += (((long) bArr[length]) & 255) << i;
            i += 8;
            length--;
        }
        return j;
    }

    public static long zza(zzbe zzbe) {
        long j = 0;
        if (zzbe == null) {
            return 0;
        }
        Iterator<String> it = zzbe.iterator();
        while (it.hasNext()) {
            Object zzc2 = zzbe.zzc(it.next());
            if (zzc2 instanceof Parcelable[]) {
                j += (long) ((Parcelable[]) zzc2).length;
            }
        }
        return j;
    }

    public final long zzn() {
        long andIncrement;
        long j;
        if (this.zzd.get() == 0) {
            synchronized (this.zzd) {
                long nextLong = new Random(System.nanoTime() ^ zzb().currentTimeMillis()).nextLong();
                int i = this.zze + 1;
                this.zze = i;
                j = nextLong + ((long) i);
            }
            return j;
        }
        synchronized (this.zzd) {
            this.zzd.compareAndSet(-1, 1);
            andIncrement = this.zzd.getAndIncrement();
        }
        return andIncrement;
    }

    public static long zza(long j, long j2) {
        return (j + (j2 * 60000)) / CalendarModelKt.MillisecondsIn24Hours;
    }

    @Pure
    public final /* bridge */ /* synthetic */ Context zza() {
        return super.zza();
    }

    public static Bundle zza(List<zzon> list) {
        Bundle bundle = new Bundle();
        if (list != null) {
            for (zzon next : list) {
                if (next.zzd != null) {
                    bundle.putString(next.zza, next.zzd);
                } else if (next.zzc != null) {
                    bundle.putLong(next.zza, next.zzc.longValue());
                } else if (next.zzf != null) {
                    bundle.putDouble(next.zza, next.zzf.doubleValue());
                }
            }
        }
        return bundle;
    }

    /* access modifiers changed from: package-private */
    public final Bundle zza(Uri uri, boolean z) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        Uri uri2 = uri;
        if (uri2 == null) {
            return null;
        }
        try {
            if (uri2.isHierarchical()) {
                str9 = uri2.getQueryParameter("utm_campaign");
                str8 = uri2.getQueryParameter("utm_source");
                str7 = uri2.getQueryParameter("utm_medium");
                str6 = uri2.getQueryParameter("gclid");
                str5 = z ? uri2.getQueryParameter("gbraid") : null;
                str4 = uri2.getQueryParameter("utm_id");
                str3 = uri2.getQueryParameter("dclid");
                str2 = uri2.getQueryParameter("srsltid");
                str = uri2.getQueryParameter("sfmc_id");
            } else {
                str9 = null;
                str8 = null;
                str7 = null;
                str6 = null;
                str5 = null;
                str4 = null;
                str3 = null;
                str2 = null;
                str = null;
            }
            if (TextUtils.isEmpty(str9) && TextUtils.isEmpty(str8) && TextUtils.isEmpty(str7) && TextUtils.isEmpty(str6) && ((!z || TextUtils.isEmpty(str5)) && TextUtils.isEmpty(str4) && TextUtils.isEmpty(str3) && TextUtils.isEmpty(str2) && TextUtils.isEmpty(str))) {
                return null;
            }
            Bundle bundle = new Bundle();
            if (!TextUtils.isEmpty(str9)) {
                str10 = "sfmc_id";
                bundle.putString("campaign", str9);
            } else {
                str10 = "sfmc_id";
            }
            if (!TextUtils.isEmpty(str8)) {
                bundle.putString("source", str8);
            }
            if (!TextUtils.isEmpty(str7)) {
                bundle.putString("medium", str7);
            }
            if (!TextUtils.isEmpty(str6)) {
                bundle.putString("gclid", str6);
            }
            if (z && !TextUtils.isEmpty(str5)) {
                bundle.putString("gbraid", str5);
            }
            String queryParameter = uri2.getQueryParameter("gad_source");
            if (z && !TextUtils.isEmpty(queryParameter)) {
                bundle.putString("gad_source", queryParameter);
            }
            String queryParameter2 = uri2.getQueryParameter("utm_term");
            if (!TextUtils.isEmpty(queryParameter2)) {
                bundle.putString(FirebaseAnalytics.Param.TERM, queryParameter2);
            }
            String queryParameter3 = uri2.getQueryParameter("utm_content");
            if (!TextUtils.isEmpty(queryParameter3)) {
                bundle.putString(FirebaseAnalytics.Param.CONTENT, queryParameter3);
            }
            String queryParameter4 = uri2.getQueryParameter(FirebaseAnalytics.Param.ACLID);
            if (!TextUtils.isEmpty(queryParameter4)) {
                bundle.putString(FirebaseAnalytics.Param.ACLID, queryParameter4);
            }
            String queryParameter5 = uri2.getQueryParameter(FirebaseAnalytics.Param.CP1);
            if (!TextUtils.isEmpty(queryParameter5)) {
                bundle.putString(FirebaseAnalytics.Param.CP1, queryParameter5);
            }
            String queryParameter6 = uri2.getQueryParameter("anid");
            if (!TextUtils.isEmpty(queryParameter6)) {
                bundle.putString("anid", queryParameter6);
            }
            if (!TextUtils.isEmpty(str4)) {
                bundle.putString(FirebaseAnalytics.Param.CAMPAIGN_ID, str4);
            }
            if (!TextUtils.isEmpty(str3)) {
                bundle.putString("dclid", str3);
            }
            String queryParameter7 = uri2.getQueryParameter("utm_source_platform");
            if (!TextUtils.isEmpty(queryParameter7)) {
                bundle.putString(FirebaseAnalytics.Param.SOURCE_PLATFORM, queryParameter7);
            }
            String queryParameter8 = uri2.getQueryParameter("utm_creative_format");
            if (!TextUtils.isEmpty(queryParameter8)) {
                bundle.putString(FirebaseAnalytics.Param.CREATIVE_FORMAT, queryParameter8);
            }
            String queryParameter9 = uri2.getQueryParameter("utm_marketing_tactic");
            if (!TextUtils.isEmpty(queryParameter9)) {
                bundle.putString(FirebaseAnalytics.Param.MARKETING_TACTIC, queryParameter9);
            }
            if (!TextUtils.isEmpty(str2)) {
                bundle.putString("srsltid", str2);
            }
            if (!TextUtils.isEmpty(str)) {
                bundle.putString(str10, str);
            }
            return bundle;
        } catch (UnsupportedOperationException e) {
            zzj().zzu().zza("Install referrer url isn't a hierarchical URI", e);
            return null;
        }
    }

    public static Bundle zza(Bundle bundle) {
        if (bundle == null) {
            return new Bundle();
        }
        Bundle bundle2 = new Bundle(bundle);
        for (String str : bundle2.keySet()) {
            Object obj = bundle2.get(str);
            if (obj instanceof Bundle) {
                bundle2.putBundle(str, new Bundle((Bundle) obj));
            } else {
                int i = 0;
                if (obj instanceof Parcelable[]) {
                    Parcelable[] parcelableArr = (Parcelable[]) obj;
                    while (i < parcelableArr.length) {
                        if (parcelableArr[i] instanceof Bundle) {
                            parcelableArr[i] = new Bundle((Bundle) parcelableArr[i]);
                        }
                        i++;
                    }
                } else if (obj instanceof List) {
                    List list = (List) obj;
                    while (i < list.size()) {
                        Object obj2 = list.get(i);
                        if (obj2 instanceof Bundle) {
                            list.set(i, new Bundle((Bundle) obj2));
                        }
                        i++;
                    }
                }
            }
        }
        return bundle2;
    }

    /* access modifiers changed from: package-private */
    public final Bundle zza(Bundle bundle, String str) {
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            for (String str2 : bundle.keySet()) {
                Object zzb2 = zzb(str2, bundle.get(str2));
                if (zzb2 == null) {
                    zzj().zzv().zza("Param value can't be null", zzi().zzb(str2));
                } else {
                    zza(bundle2, str2, zzb2);
                }
            }
        }
        return bundle2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: java.lang.String} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.os.Bundle zza(java.lang.String r16, java.lang.String r17, android.os.Bundle r18, java.util.List<java.lang.String> r19, boolean r20) {
        /*
            r15 = this;
            r2 = r17
            r9 = r18
            r6 = r19
            java.lang.String[] r0 = com.google.android.gms.measurement.internal.zzji.zzd
            boolean r8 = zza((java.lang.String) r2, (java.lang.String[]) r0)
            r10 = 0
            if (r9 == 0) goto L_0x00da
            android.os.Bundle r5 = new android.os.Bundle
            r5.<init>(r9)
            com.google.android.gms.measurement.internal.zzag r0 = r15.zze()
            int r11 = r0.zzc()
            java.util.TreeSet r0 = new java.util.TreeSet
            java.util.Set r1 = r9.keySet()
            r0.<init>(r1)
            java.util.Iterator r12 = r0.iterator()
            r13 = 0
            r14 = r13
        L_0x002b:
            boolean r0 = r12.hasNext()
            if (r0 == 0) goto L_0x00d9
            java.lang.Object r0 = r12.next()
            r3 = r0
            java.lang.String r3 = (java.lang.String) r3
            if (r6 == 0) goto L_0x0043
            boolean r0 = r6.contains(r3)
            if (r0 != 0) goto L_0x0041
            goto L_0x0043
        L_0x0041:
            r0 = r13
            goto L_0x0051
        L_0x0043:
            if (r20 != 0) goto L_0x004a
            int r0 = r15.zzl(r3)
            goto L_0x004b
        L_0x004a:
            r0 = r13
        L_0x004b:
            if (r0 != 0) goto L_0x0051
            int r0 = r15.zzk(r3)
        L_0x0051:
            if (r0 == 0) goto L_0x0060
            r1 = 3
            if (r0 != r1) goto L_0x0058
            r1 = r3
            goto L_0x0059
        L_0x0058:
            r1 = r10
        L_0x0059:
            zza((android.os.Bundle) r5, (int) r0, (java.lang.String) r3, (java.lang.Object) r1)
            r5.remove(r3)
            goto L_0x0094
        L_0x0060:
            java.lang.Object r4 = r9.get(r3)
            r0 = r15
            r1 = r16
            r7 = r20
            int r4 = r0.zza(r1, r2, r3, r4, r5, r6, r7, r8)
            r0 = 17
            if (r4 != r0) goto L_0x0079
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r13)
            zza((android.os.Bundle) r5, (int) r4, (java.lang.String) r3, (java.lang.Object) r0)
            goto L_0x0097
        L_0x0079:
            if (r4 == 0) goto L_0x0097
            java.lang.String r0 = "_ev"
            boolean r0 = r0.equals(r3)
            if (r0 != 0) goto L_0x0097
            r0 = 21
            if (r4 != r0) goto L_0x0089
            r0 = r2
            goto L_0x008a
        L_0x0089:
            r0 = r3
        L_0x008a:
            java.lang.Object r1 = r9.get(r3)
            zza((android.os.Bundle) r5, (int) r4, (java.lang.String) r0, (java.lang.Object) r1)
            r5.remove(r3)
        L_0x0094:
            r6 = r19
            goto L_0x002b
        L_0x0097:
            boolean r0 = zzh(r3)
            if (r0 == 0) goto L_0x0094
            int r14 = r14 + 1
            if (r14 <= r11) goto L_0x0094
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Event can't contain more than "
            r0.<init>(r1)
            java.lang.StringBuilder r0 = r0.append(r11)
            java.lang.String r1 = " params"
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.google.android.gms.measurement.internal.zzgo r1 = r15.zzj()
            com.google.android.gms.measurement.internal.zzgq r1 = r1.zzm()
            com.google.android.gms.measurement.internal.zzgh r4 = r15.zzi()
            java.lang.String r4 = r4.zza((java.lang.String) r2)
            com.google.android.gms.measurement.internal.zzgh r6 = r15.zzi()
            java.lang.String r6 = r6.zza((android.os.Bundle) r9)
            r1.zza(r0, r4, r6)
            r0 = 5
            zzb((android.os.Bundle) r5, (int) r0)
            r5.remove(r3)
            goto L_0x0094
        L_0x00d9:
            return r5
        L_0x00da:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzos.zza(java.lang.String, java.lang.String, android.os.Bundle, java.util.List, boolean):android.os.Bundle");
    }

    /* access modifiers changed from: package-private */
    public final MeasurementManagerFutures zzo() {
        if (this.zzf == null) {
            this.zzf = MeasurementManagerFutures.from(zza());
        }
        return this.zzf;
    }

    @Pure
    public final /* bridge */ /* synthetic */ Clock zzb() {
        return super.zzb();
    }

    @Pure
    public final /* bridge */ /* synthetic */ zzab zzd() {
        return super.zzd();
    }

    @Pure
    public final /* bridge */ /* synthetic */ zzag zze() {
        return super.zze();
    }

    @Pure
    public final /* bridge */ /* synthetic */ zzaz zzf() {
        return super.zzf();
    }

    /* access modifiers changed from: package-private */
    public final zzbf zza(String str, String str2, Bundle bundle, String str3, long j, boolean z, boolean z2) {
        Bundle bundle2;
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        if (zza(str2) == 0) {
            if (bundle == null) {
                bundle2 = new Bundle();
            }
            Bundle bundle3 = bundle2;
            bundle3.putString("_o", str3);
            String str4 = str;
            String str5 = str2;
            Bundle zza2 = zza(str4, str5, bundle3, (List<String>) CollectionUtils.listOf("_o"), true);
            String str6 = str5;
            if (z) {
                zza2 = zza(zza2, str4);
            }
            Preconditions.checkNotNull(zza2);
            long j2 = j;
            return new zzbf(str6, new zzbe(zza2), str3, j2);
        }
        zzj().zzg().zza("Invalid conditional property event name", zzi().zzc(str2));
        throw new IllegalArgumentException();
    }

    @Pure
    public final /* bridge */ /* synthetic */ zzgh zzi() {
        return super.zzi();
    }

    @Pure
    public final /* bridge */ /* synthetic */ zzgo zzj() {
        return super.zzj();
    }

    @Pure
    public final /* bridge */ /* synthetic */ zzha zzk() {
        return super.zzk();
    }

    @Pure
    public final /* bridge */ /* synthetic */ zzhv zzl() {
        return super.zzl();
    }

    @Pure
    public final /* bridge */ /* synthetic */ zzos zzq() {
        return super.zzq();
    }

    /* access modifiers changed from: package-private */
    public final Object zzb(String str, Object obj) {
        int i;
        if ("_ev".equals(str)) {
            return zza(zze().zzb((String) null, false), obj, true, true, (String) null);
        }
        Object obj2 = obj;
        if (zzg(str)) {
            i = zze().zzb((String) null, false);
        } else {
            i = zze().zza((String) null, false);
        }
        return zza(i, obj2, false, true, (String) null);
    }

    /* access modifiers changed from: package-private */
    public final Object zzc(String str, Object obj) {
        if ("_ldl".equals(str)) {
            return zza(zzm(str), obj, true, false, (String) null);
        }
        return zza(zzm(str), obj, false, false, (String) null);
    }

    private final Object zza(int i, Object obj, boolean z, boolean z2, String str) {
        Bundle zza2;
        if (obj == null) {
            return null;
        }
        if ((obj instanceof Long) || (obj instanceof Double)) {
            return obj;
        }
        if (obj instanceof Integer) {
            return Long.valueOf((long) ((Integer) obj).intValue());
        }
        if (obj instanceof Byte) {
            return Long.valueOf((long) ((Byte) obj).byteValue());
        }
        if (obj instanceof Short) {
            return Long.valueOf((long) ((Short) obj).shortValue());
        }
        if (obj instanceof Boolean) {
            return Long.valueOf(((Boolean) obj).booleanValue() ? 1 : 0);
        } else if (obj instanceof Float) {
            return Double.valueOf(((Float) obj).doubleValue());
        } else {
            if ((obj instanceof String) || (obj instanceof Character) || (obj instanceof CharSequence)) {
                return zza(String.valueOf(obj), i, z);
            }
            if (!z2 || (!(obj instanceof Bundle[]) && !(obj instanceof Parcelable[]))) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (Parcelable parcelable : (Parcelable[]) obj) {
                if ((parcelable instanceof Bundle) && (zza2 = zza((Bundle) parcelable, (String) null)) != null && !zza2.isEmpty()) {
                    arrayList.add(zza2);
                }
            }
            return arrayList.toArray(new Bundle[arrayList.size()]);
        }
    }

    /* access modifiers changed from: package-private */
    public final String zzp() {
        byte[] bArr = new byte[16];
        zzv().nextBytes(bArr);
        return String.format(Locale.US, "%032x", new Object[]{new BigInteger(1, bArr)});
    }

    public static String zza(String str, int i, boolean z) {
        if (str == null) {
            return null;
        }
        if (str.codePointCount(0, str.length()) <= i) {
            return str;
        }
        if (!z) {
            return null;
        }
        return str.substring(0, str.offsetByCodePoints(0, i)) + "...";
    }

    public final URL zza(long j, String str, String str2, long j2, String str3) {
        try {
            Preconditions.checkNotEmpty(str2);
            Preconditions.checkNotEmpty(str);
            String format = String.format("https://www.googleadservices.com/pagead/conversion/app/deeplink?id_type=adid&sdk_version=%s&rdid=%s&bundleid=%s&retry=%s", new Object[]{String.format("v%s.%s", new Object[]{Long.valueOf(j), Integer.valueOf(zzg())}), str2, str, Long.valueOf(j2)});
            if (str.equals(zze().zzp())) {
                format = format.concat("&ddl_test=1");
            }
            if (!str3.isEmpty()) {
                if (str3.charAt(0) != '&') {
                    format = format.concat("&");
                }
                format = format.concat(str3);
            }
            return new URL(format);
        } catch (IllegalArgumentException | MalformedURLException e) {
            zzj().zzg().zza("Failed to create BOW URL for Deferred Deep Link. exception", e.getMessage());
            return null;
        }
    }

    static MessageDigest zzu() {
        int i = 0;
        while (i < 2) {
            try {
                MessageDigest instance = MessageDigest.getInstance("MD5");
                if (instance != null) {
                    return instance;
                }
                i++;
            } catch (NoSuchAlgorithmException unused) {
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    @EnsuresNonNull({"this.secureRandom"})
    public final SecureRandom zzv() {
        zzt();
        if (this.zzc == null) {
            this.zzc = new SecureRandom();
        }
        return this.zzc;
    }

    public static ArrayList<Bundle> zzb(List<zzae> list) {
        if (list == null) {
            return new ArrayList<>(0);
        }
        ArrayList<Bundle> arrayList = new ArrayList<>(list.size());
        for (zzae next : list) {
            Bundle bundle = new Bundle();
            bundle.putString("app_id", next.zza);
            bundle.putString("origin", next.zzb);
            bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, next.zzd);
            bundle.putString("name", next.zzc.zza);
            zzjf.zza(bundle, Preconditions.checkNotNull(next.zzc.zza()));
            bundle.putBoolean(AppMeasurementSdk.ConditionalUserProperty.ACTIVE, next.zze);
            if (next.zzf != null) {
                bundle.putString(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, next.zzf);
            }
            if (next.zzg != null) {
                zzbf zzbf = next.zzg;
                bundle.putString(AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_NAME, zzbf.zza);
                if (zzbf.zzb != null) {
                    bundle.putBundle(AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_PARAMS, zzbf.zzb.zzb());
                }
            }
            bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, next.zzh);
            if (next.zzi != null) {
                zzbf zzbf2 = next.zzi;
                bundle.putString(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_NAME, zzbf2.zza);
                if (zzbf2.zzb != null) {
                    bundle.putBundle(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_PARAMS, zzbf2.zzb.zzb());
                }
            }
            bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP, next.zzc.zzb);
            bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, next.zzj);
            if (next.zzk != null) {
                zzbf zzbf3 = next.zzk;
                bundle.putString(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME, zzbf3.zza);
                if (zzbf3.zzb != null) {
                    bundle.putBundle(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS, zzbf3.zzb.zzb());
                }
            }
            arrayList.add(bundle);
        }
        return arrayList;
    }

    zzos(zzhy zzhy) {
        super(zzhy);
    }

    /* access modifiers changed from: package-private */
    public final void zza(Bundle bundle, long j) {
        long j2 = bundle.getLong("_et");
        if (j2 != 0) {
            zzj().zzu().zza("Params already contained engagement", Long.valueOf(j2));
        }
        bundle.putLong("_et", j + j2);
    }

    private static void zza(Bundle bundle, int i, String str, Object obj) {
        if (zzb(bundle, i)) {
            bundle.putString("_ev", zza(str, 40, true));
            if (obj != null) {
                Preconditions.checkNotNull(bundle);
                if (obj == null) {
                    return;
                }
                if ((obj instanceof String) || (obj instanceof CharSequence)) {
                    bundle.putLong("_el", (long) String.valueOf(obj).length());
                }
            }
        }
    }

    public static void zza(zzlk zzlk, Bundle bundle, boolean z) {
        if (bundle != null && zzlk != null && (!bundle.containsKey("_sc") || z)) {
            if (zzlk.zza != null) {
                bundle.putString("_sn", zzlk.zza);
            } else {
                bundle.remove("_sn");
            }
            if (zzlk.zzb != null) {
                bundle.putString("_sc", zzlk.zzb);
            } else {
                bundle.remove("_sc");
            }
            bundle.putLong("_si", zzlk.zzc);
        } else if (bundle != null && zzlk == null && z) {
            bundle.remove("_sn");
            bundle.remove("_sc");
            bundle.remove("_si");
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(Bundle bundle, Bundle bundle2) {
        if (bundle2 != null) {
            for (String str : bundle2.keySet()) {
                if (!bundle.containsKey(str)) {
                    zzq().zza(bundle, str, bundle2.get(str));
                }
            }
        }
    }

    public final /* bridge */ /* synthetic */ void zzr() {
        super.zzr();
    }

    public final /* bridge */ /* synthetic */ void zzs() {
        super.zzs();
    }

    public final /* bridge */ /* synthetic */ void zzt() {
        super.zzt();
    }

    /* access modifiers changed from: package-private */
    public final void zza(Parcelable[] parcelableArr, int i) {
        Preconditions.checkNotNull(parcelableArr);
        for (Bundle bundle : parcelableArr) {
            int i2 = 0;
            for (String str : new TreeSet(bundle.keySet())) {
                if (zzh(str) && !zza(str, zzjk.zzd) && (i2 = i2 + 1) > i) {
                    zzj().zzm().zza("Param can't contain more than " + i + " item-scoped custom parameters", zzi().zzb(str), zzi().zza(bundle));
                    zzb(bundle, 28);
                    bundle.remove(str);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzgs zzgs, int i) {
        int i2 = 0;
        for (String str : new TreeSet(zzgs.zzc.keySet())) {
            if (zzh(str) && (i2 = i2 + 1) > i) {
                zzj().zzm().zza("Event can't contain more than " + i + " params", zzi().zza(zzgs.zza), zzi().zza(zzgs.zzc));
                zzb(zzgs.zzc, 5);
                zzgs.zzc.remove(str);
            }
        }
    }

    public static void zza(zzor zzor, int i, String str, String str2, int i2) {
        zza(zzor, (String) null, i, str, str2, i2);
    }

    static void zza(zzor zzor, String str, int i, String str2, String str3, int i2) {
        Bundle bundle = new Bundle();
        zzb(bundle, i);
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            bundle.putString(str2, str3);
        }
        if (i == 6 || i == 7 || i == 2) {
            bundle.putLong("_el", (long) i2);
        }
        zzor.zza(str, "_err", bundle);
    }

    /* access modifiers changed from: protected */
    public final void zzaa() {
        zzt();
        SecureRandom secureRandom = new SecureRandom();
        long nextLong = secureRandom.nextLong();
        if (nextLong == 0) {
            nextLong = secureRandom.nextLong();
            if (nextLong == 0) {
                zzj().zzu().zza("Utils falling back to Random for random id");
            }
        }
        this.zzd.set(nextLong);
    }

    /* access modifiers changed from: package-private */
    public final void zza(Bundle bundle, String str, Object obj) {
        if (bundle != null) {
            if (obj instanceof Long) {
                bundle.putLong(str, ((Long) obj).longValue());
            } else if (obj instanceof String) {
                bundle.putString(str, String.valueOf(obj));
            } else if (obj instanceof Double) {
                bundle.putDouble(str, ((Double) obj).doubleValue());
            } else if (obj instanceof Bundle[]) {
                bundle.putParcelableArray(str, (Bundle[]) obj);
            } else if (str != null) {
                zzj().zzv().zza("Not putting event parameter. Invalid value type. name, type", zzi().zzb(str), obj != null ? obj.getClass().getSimpleName() : null);
            }
        }
    }

    public final void zza(zzdo zzdo, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("r", z);
        try {
            zzdo.zza(bundle);
        } catch (RemoteException e) {
            this.zzu.zzj().zzu().zza("Error returning boolean value to wrapper", e);
        }
    }

    public final void zza(zzdo zzdo, ArrayList<Bundle> arrayList) {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("r", arrayList);
        try {
            zzdo.zza(bundle);
        } catch (RemoteException e) {
            this.zzu.zzj().zzu().zza("Error returning bundle list to wrapper", e);
        }
    }

    public final void zza(zzdo zzdo, Bundle bundle) {
        try {
            zzdo.zza(bundle);
        } catch (RemoteException e) {
            this.zzu.zzj().zzu().zza("Error returning bundle value to wrapper", e);
        }
    }

    public final void zza(zzdo zzdo, byte[] bArr) {
        Bundle bundle = new Bundle();
        bundle.putByteArray("r", bArr);
        try {
            zzdo.zza(bundle);
        } catch (RemoteException e) {
            this.zzu.zzj().zzu().zza("Error returning byte array to wrapper", e);
        }
    }

    public final void zza(zzdo zzdo, int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("r", i);
        try {
            zzdo.zza(bundle);
        } catch (RemoteException e) {
            this.zzu.zzj().zzu().zza("Error returning int value to wrapper", e);
        }
    }

    public final void zza(zzdo zzdo, long j) {
        Bundle bundle = new Bundle();
        bundle.putLong("r", j);
        try {
            zzdo.zza(bundle);
        } catch (RemoteException e) {
            this.zzu.zzj().zzu().zza("Error returning long value to wrapper", e);
        }
    }

    public final void zza(zzdo zzdo, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("r", str);
        try {
            zzdo.zza(bundle);
        } catch (RemoteException e) {
            this.zzu.zzj().zzu().zza("Error returning string value to wrapper", e);
        }
    }

    private final void zza(String str, String str2, String str3, Bundle bundle, List<String> list, boolean z) {
        int i;
        int i2;
        String str4 = str2;
        Bundle bundle2 = bundle;
        List<String> list2 = list;
        if (bundle2 != null) {
            int i3 = zze().zzq().zza(231100000, true) ? 35 : 0;
            int i4 = 0;
            for (String str5 : new TreeSet(bundle2.keySet())) {
                if (list2 == null || !list2.contains(str5)) {
                    i = !z ? zzl(str5) : 0;
                    if (i == 0) {
                        i = zzk(str5);
                    }
                } else {
                    i = 0;
                }
                if (i != 0) {
                    zza(bundle2, i, str5, (Object) i == 3 ? str5 : null);
                    bundle2.remove(str5);
                    String str6 = str3;
                } else {
                    if (zza(bundle2.get(str5))) {
                        zzj().zzv().zza("Nested Bundle parameters are not allowed; discarded. event name, param name, child param name", str4, str3, str5);
                        i2 = 22;
                    } else {
                        String str7 = str3;
                        i2 = zza(str, str4, str5, bundle2.get(str5), bundle2, list2, z, false);
                    }
                    if (i2 != 0 && !"_ev".equals(str5)) {
                        zza(bundle2, i2, str5, bundle2.get(str5));
                        bundle2.remove(str5);
                    } else if (zzh(str5) && !zza(str5, zzjk.zzd)) {
                        i4++;
                        if (!zza(231100000, true)) {
                            zzj().zzm().zza("Item array not supported on client's version of Google Play Services (Android Only)", zzi().zza(str4), zzi().zza(bundle2));
                            zzb(bundle2, 23);
                            bundle2.remove(str5);
                        } else if (i4 > i3) {
                            zzj().zzm().zza("Item can't contain more than " + i3 + " item-scoped custom params", zzi().zza(str4), zzi().zza(bundle2));
                            zzb(bundle2, 28);
                            bundle2.remove(str5);
                        }
                    }
                }
                list2 = list;
            }
        }
    }

    private static boolean zzb(Bundle bundle, int i) {
        if (bundle == null || bundle.getLong("_err") != 0) {
            return false;
        }
        bundle.putLong("_err", (long) i);
        return true;
    }

    static boolean zzd(String str) {
        return zze(zzbh.zzbd.zza(null), str);
    }

    private static boolean zza(String str, String[] strArr) {
        Preconditions.checkNotNull(strArr);
        for (String equals : strArr) {
            if (Objects.equals(str, equals)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public final boolean zza(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            if (zzn(str)) {
                return true;
            }
            if (this.zzu.zzae()) {
                zzj().zzm().zza("Invalid google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI. provided id", zzgo.zza(str));
            }
            return false;
        } else if (TextUtils.isEmpty(str2)) {
            if (this.zzu.zzae()) {
                zzj().zzm().zza("Missing google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI");
            }
            return false;
        } else if (zzn(str2)) {
            return true;
        } else {
            zzj().zzm().zza("Invalid admob_app_id. Analytics disabled.", zzgo.zza(str2));
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean zza(String str, int i, String str2) {
        if (str2 == null) {
            zzj().zzm().zza("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.codePointCount(0, str2.length()) <= i) {
            return true;
        } else {
            zzj().zzm().zza("Name is too long. Type, maximum supported length, name", str, Integer.valueOf(i), str2);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean zza(String str, String[] strArr, String str2) {
        return zza(str, strArr, (String[]) null, str2);
    }

    /* access modifiers changed from: package-private */
    public final boolean zza(String str, String[] strArr, String[] strArr2, String str2) {
        if (str2 == null) {
            zzj().zzm().zza("Name is required and can't be null. Type", str);
            return false;
        }
        Preconditions.checkNotNull(str2);
        for (String startsWith : zza) {
            if (str2.startsWith(startsWith)) {
                zzj().zzm().zza("Name starts with reserved prefix. Type, name", str, str2);
                return false;
            }
        }
        if (strArr == null || !zza(str2, strArr)) {
            return true;
        }
        if (strArr2 != null && zza(str2, strArr2)) {
            return true;
        }
        zzj().zzm().zza("Name is reserved. Type, name", str, str2);
        return false;
    }

    /* access modifiers changed from: package-private */
    public final boolean zza(String str, String str2, int i, Object obj) {
        if (obj != null && !(obj instanceof Long) && !(obj instanceof Float) && !(obj instanceof Integer) && !(obj instanceof Byte) && !(obj instanceof Short) && !(obj instanceof Boolean) && !(obj instanceof Double)) {
            if (!(obj instanceof String) && !(obj instanceof Character) && !(obj instanceof CharSequence)) {
                return false;
            }
            String valueOf = String.valueOf(obj);
            if (valueOf.codePointCount(0, valueOf.length()) > i) {
                zzj().zzv().zza("Value is too long; discarded. Value kind, name, value length", str, str2, Integer.valueOf(valueOf.length()));
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzb(String str, String str2) {
        if (str2 == null) {
            zzj().zzm().zza("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.length() == 0) {
            zzj().zzm().zza("Name is required and can't be empty. Type", str);
            return false;
        } else {
            int codePointAt = str2.codePointAt(0);
            if (Character.isLetter(codePointAt) || codePointAt == 95) {
                int length = str2.length();
                int charCount = Character.charCount(codePointAt);
                while (charCount < length) {
                    int codePointAt2 = str2.codePointAt(charCount);
                    if (codePointAt2 == 95 || Character.isLetterOrDigit(codePointAt2)) {
                        charCount += Character.charCount(codePointAt2);
                    } else {
                        zzj().zzm().zza("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                        return false;
                    }
                }
                return true;
            }
            zzj().zzm().zza("Name must start with a letter or _ (underscore). Type, name", str, str2);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean zzc(String str, String str2) {
        if (str2 == null) {
            zzj().zzm().zza("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.length() == 0) {
            zzj().zzm().zza("Name is required and can't be empty. Type", str);
            return false;
        } else {
            int codePointAt = str2.codePointAt(0);
            if (!Character.isLetter(codePointAt)) {
                zzj().zzm().zza("Name must start with a letter. Type, name", str, str2);
                return false;
            }
            int length = str2.length();
            int charCount = Character.charCount(codePointAt);
            while (charCount < length) {
                int codePointAt2 = str2.codePointAt(charCount);
                if (codePointAt2 == 95 || Character.isLetterOrDigit(codePointAt2)) {
                    charCount += Character.charCount(codePointAt2);
                } else {
                    zzj().zzm().zza("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                    return false;
                }
            }
            return true;
        }
    }

    static boolean zza(Bundle bundle, int i) {
        int i2 = 0;
        if (bundle.size() <= i) {
            return false;
        }
        for (String str : new TreeSet(bundle.keySet())) {
            i2++;
            if (i2 > i) {
                bundle.remove(str);
            }
        }
        return true;
    }

    private final boolean zzy() {
        Integer num;
        Object e;
        boolean z;
        if (this.zzg == null) {
            MeasurementManagerFutures zzo = zzo();
            if (zzo == null) {
                return false;
            }
            try {
                num = (Integer) zzo.getMeasurementApiStatusAsync().get(WorkRequest.MIN_BACKOFF_MILLIS, TimeUnit.MILLISECONDS);
                if (num != null) {
                    try {
                        z = true;
                        if (num.intValue() == 1) {
                            this.zzg = Boolean.valueOf(z);
                            zzj().zzp().zza("Measurement manager api status result", num);
                        }
                    } catch (CancellationException e2) {
                        e = e2;
                        zzj().zzu().zza("Measurement manager api exception", e);
                        this.zzg = false;
                        zzj().zzp().zza("Measurement manager api status result", num);
                        return this.zzg.booleanValue();
                    } catch (ExecutionException e3) {
                        e = e3;
                        zzj().zzu().zza("Measurement manager api exception", e);
                        this.zzg = false;
                        zzj().zzp().zza("Measurement manager api status result", num);
                        return this.zzg.booleanValue();
                    } catch (InterruptedException e4) {
                        e = e4;
                        zzj().zzu().zza("Measurement manager api exception", e);
                        this.zzg = false;
                        zzj().zzp().zza("Measurement manager api status result", num);
                        return this.zzg.booleanValue();
                    } catch (TimeoutException e5) {
                        e = e5;
                        zzj().zzu().zza("Measurement manager api exception", e);
                        this.zzg = false;
                        zzj().zzp().zza("Measurement manager api status result", num);
                        return this.zzg.booleanValue();
                    }
                }
                z = false;
                this.zzg = Boolean.valueOf(z);
            } catch (InterruptedException | CancellationException | ExecutionException | TimeoutException e6) {
                e = e6;
                num = null;
                zzj().zzu().zza("Measurement manager api exception", e);
                this.zzg = false;
                zzj().zzp().zza("Measurement manager api status result", num);
                return this.zzg.booleanValue();
            }
            zzj().zzp().zza("Measurement manager api status result", num);
        }
        return this.zzg.booleanValue();
    }

    /* access modifiers changed from: package-private */
    public final boolean zze(String str) {
        zzt();
        if (Wrappers.packageManager(zza()).checkCallingOrSelfPermission(str) == 0) {
            return true;
        }
        zzj().zzc().zza("Permission not granted", str);
        return false;
    }

    static boolean zzf(String str) {
        return zze(zzbh.zzca.zza(null), str);
    }

    /* access modifiers changed from: package-private */
    public final boolean zzd(String str, String str2) {
        if (zzpu.zza() && zze().zza(zzbh.zzby) && !TextUtils.isEmpty(str2)) {
            return true;
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return zze().zzo().equals(str);
    }

    static boolean zza(Object obj) {
        return (obj instanceof Parcelable[]) || (obj instanceof ArrayList) || (obj instanceof Bundle);
    }

    private final boolean zzb(Context context, String str) {
        X500Principal x500Principal = new X500Principal("CN=Android Debug,O=Android,C=US");
        try {
            PackageInfo packageInfo = Wrappers.packageManager(context).getPackageInfo(str, 64);
            if (packageInfo == null || packageInfo.signatures == null || packageInfo.signatures.length <= 0) {
                return true;
            }
            return ((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(packageInfo.signatures[0].toByteArray()))).getSubjectX500Principal().equals(x500Principal);
        } catch (CertificateException e) {
            zzj().zzg().zza("Error obtaining certificate", e);
            return true;
        } catch (PackageManager.NameNotFoundException e2) {
            zzj().zzg().zza("Package name not found", e2);
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean zzw() {
        zzt();
        return zzm() == 1;
    }

    public final boolean zzx() {
        try {
            zza().getClassLoader().loadClass("com.google.firebase.remoteconfig.FirebaseRemoteConfig");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public final boolean zza(int i, boolean z) {
        Boolean zzab = this.zzu.zzr().zzab();
        if (zzg() < i / 1000) {
            return zzab != null && !zzab.booleanValue();
        }
        return true;
    }

    static boolean zzg(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith("_");
    }

    static boolean zzh(String str) {
        Preconditions.checkNotEmpty(str);
        if (str.charAt(0) != '_' || str.equals("_ep")) {
            return true;
        }
        return false;
    }

    static boolean zza(Context context) {
        ActivityInfo receiverInfo;
        Preconditions.checkNotNull(context);
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null || (receiverInfo = packageManager.getReceiverInfo(new ComponentName(context, "com.google.android.gms.measurement.AppMeasurementReceiver"), 0)) == null || !receiverInfo.enabled) {
                return false;
            }
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }

    private static boolean zzc(Context context, String str) {
        ServiceInfo serviceInfo;
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null || (serviceInfo = packageManager.getServiceInfo(new ComponentName(context, str), 0)) == null || !serviceInfo.enabled) {
                return false;
            }
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }

    static boolean zza(Context context, boolean z) {
        Preconditions.checkNotNull(context);
        return zzc(context, "com.google.android.gms.measurement.AppMeasurementJobService");
    }

    public final boolean zzi(String str) {
        List<ResolveInfo> queryIntentActivities;
        if (!TextUtils.isEmpty(str) && (queryIntentActivities = zza().getPackageManager().queryIntentActivities(new Intent("android.intent.action.VIEW", Uri.parse(str)), 0)) != null && !queryIntentActivities.isEmpty()) {
            return true;
        }
        return false;
    }

    private static boolean zze(String str, String str2) {
        return str.equals(ProxyConfig.MATCH_ALL_SCHEMES) || Arrays.asList(str.split(",")).contains(str2);
    }

    /* access modifiers changed from: package-private */
    public final boolean zza(String str, double d) {
        try {
            SharedPreferences.Editor edit = zza().getSharedPreferences("google.analytics.deferred.deeplink.prefs", 0).edit();
            edit.putString("deeplink", str);
            edit.putLong("timestamp", Double.doubleToRawLongBits(d));
            return edit.commit();
        } catch (RuntimeException e) {
            zzj().zzg().zza("Failed to persist Deferred Deep Link. exception", e);
            return false;
        }
    }

    static boolean zza(Intent intent) {
        String stringExtra = intent.getStringExtra("android.intent.extra.REFERRER_NAME");
        return "android-app://com.google.android.googlequicksearchbox/https/www.google.com".equals(stringExtra) || "https://www.google.com".equals(stringExtra) || "android-app://com.google.appcrawler".equals(stringExtra);
    }

    public static boolean zzj(String str) {
        for (String equals : zzb) {
            if (equals.equals(str)) {
                return false;
            }
        }
        return true;
    }

    static boolean zza(String str, String str2, String str3, String str4) {
        boolean isEmpty = TextUtils.isEmpty(str);
        boolean isEmpty2 = TextUtils.isEmpty(str2);
        if (!isEmpty && !isEmpty2) {
            Preconditions.checkNotNull(str);
            return !str.equals(str2);
        } else if (isEmpty && isEmpty2) {
            return (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) ? !TextUtils.isEmpty(str4) : !str3.equals(str4);
        } else {
            if (isEmpty || !isEmpty2) {
                return TextUtils.isEmpty(str3) || !str3.equals(str4);
            }
            if (TextUtils.isEmpty(str4)) {
                return false;
            }
            return TextUtils.isEmpty(str3) || !str3.equals(str4);
        }
    }

    private static boolean zzn(String str) {
        Preconditions.checkNotNull(str);
        return str.matches("^(1:\\d+:android:[a-f0-9]+|ca-app-pub-.*)$");
    }

    static byte[] zza(Parcelable parcelable) {
        if (parcelable == null) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        try {
            parcelable.writeToParcel(obtain, 0);
            return obtain.marshall();
        } finally {
            obtain.recycle();
        }
    }

    static Bundle[] zzb(Object obj) {
        if (obj instanceof Bundle) {
            return new Bundle[]{(Bundle) obj};
        } else if (obj instanceof Parcelable[]) {
            Parcelable[] parcelableArr = (Parcelable[]) obj;
            return (Bundle[]) Arrays.copyOf(parcelableArr, parcelableArr.length, Bundle[].class);
        } else if (!(obj instanceof ArrayList)) {
            return null;
        } else {
            ArrayList arrayList = (ArrayList) obj;
            return (Bundle[]) arrayList.toArray(new Bundle[arrayList.size()]);
        }
    }
}
