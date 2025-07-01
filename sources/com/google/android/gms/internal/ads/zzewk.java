package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzewk implements zzevz {
    private final zzges zza;
    private final Context zzb;

    public zzewk(zzges zzges, Context context) {
        this.zza = zzges;
        this.zzb = context;
    }

    private static ResolveInfo zzd(PackageManager packageManager, String str) {
        return packageManager.resolveActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)), 65536);
    }

    public final int zza() {
        return 38;
    }

    public final ListenableFuture zzb() {
        return this.zza.zzb(new zzewj(this));
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x009b A[Catch:{ Exception -> 0x00b2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00ba  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0135  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0157  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0179  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x017f  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0181  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0184  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0186  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ com.google.android.gms.internal.ads.zzewi zzc() throws java.lang.Exception {
        /*
            r25 = this;
            r0 = r25
            java.lang.String r1 = "com.google.unity.ads.UNITY_VERSION"
            android.content.Context r2 = r0.zzb
            android.content.pm.PackageManager r2 = r2.getPackageManager()
            java.util.Locale r3 = java.util.Locale.getDefault()
            java.lang.String r4 = "geo:0,0?q=donuts"
            android.content.pm.ResolveInfo r4 = zzd(r2, r4)
            java.lang.String r5 = "http://www.google.com"
            android.content.pm.ResolveInfo r5 = zzd(r2, r5)
            java.lang.String r9 = r3.getCountry()
            com.google.android.gms.ads.internal.zzv.zzq()
            com.google.android.gms.ads.internal.client.zzbc.zzb()
            boolean r10 = com.google.android.gms.ads.internal.util.client.zzf.zzs()
            android.content.Context r6 = r0.zzb
            boolean r11 = com.google.android.gms.common.util.DeviceProperties.isLatchsky(r6)
            boolean r12 = com.google.android.gms.common.util.DeviceProperties.isSidewinder(r6)
            java.lang.String r13 = r3.getLanguage()
            java.util.ArrayList r14 = new java.util.ArrayList
            r14.<init>()
            android.os.LocaleList r3 = android.os.LocaleList.getDefault()
            r6 = 0
            r7 = r6
        L_0x0041:
            int r8 = r3.size()
            if (r7 >= r8) goto L_0x0055
            java.util.Locale r8 = r3.get(r7)
            java.lang.String r8 = r8.getLanguage()
            r14.add(r8)
            int r7 = r7 + 1
            goto L_0x0041
        L_0x0055:
            android.content.Context r3 = r0.zzb
            java.lang.String r7 = "market://details?id=com.google.android.gms.ads"
            android.content.pm.ResolveInfo r7 = zzd(r2, r7)
            java.lang.String r8 = "."
            if (r7 != 0) goto L_0x0063
        L_0x0061:
            r15 = 0
            goto L_0x008b
        L_0x0063:
            android.content.pm.ActivityInfo r7 = r7.activityInfo
            if (r7 != 0) goto L_0x0068
            goto L_0x0061
        L_0x0068:
            com.google.android.gms.common.wrappers.PackageManagerWrapper r3 = com.google.android.gms.common.wrappers.Wrappers.packageManager(r3)     // Catch:{ NameNotFoundException -> 0x0061 }
            java.lang.String r15 = r7.packageName     // Catch:{ NameNotFoundException -> 0x0061 }
            android.content.pm.PackageInfo r3 = r3.getPackageInfo(r15, r6)     // Catch:{ NameNotFoundException -> 0x0061 }
            if (r3 == 0) goto L_0x0061
            int r3 = r3.versionCode     // Catch:{ NameNotFoundException -> 0x0061 }
            java.lang.String r7 = r7.packageName     // Catch:{ NameNotFoundException -> 0x0061 }
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ NameNotFoundException -> 0x0061 }
            r15.<init>()     // Catch:{ NameNotFoundException -> 0x0061 }
            r15.append(r3)     // Catch:{ NameNotFoundException -> 0x0061 }
            r15.append(r8)     // Catch:{ NameNotFoundException -> 0x0061 }
            r15.append(r7)     // Catch:{ NameNotFoundException -> 0x0061 }
            java.lang.String r3 = r15.toString()     // Catch:{ NameNotFoundException -> 0x0061 }
            r15 = r3
        L_0x008b:
            android.content.Context r3 = r0.zzb
            r7 = 128(0x80, float:1.794E-43)
            com.google.android.gms.common.wrappers.PackageManagerWrapper r3 = com.google.android.gms.common.wrappers.Wrappers.packageManager(r3)     // Catch:{ Exception -> 0x00b2 }
            java.lang.String r6 = "com.android.vending"
            android.content.pm.PackageInfo r3 = r3.getPackageInfo(r6, r7)     // Catch:{ Exception -> 0x00b2 }
            if (r3 == 0) goto L_0x00b2
            int r6 = r3.versionCode     // Catch:{ Exception -> 0x00b2 }
            java.lang.String r3 = r3.packageName     // Catch:{ Exception -> 0x00b2 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00b2 }
            r7.<init>()     // Catch:{ Exception -> 0x00b2 }
            r7.append(r6)     // Catch:{ Exception -> 0x00b2 }
            r7.append(r8)     // Catch:{ Exception -> 0x00b2 }
            r7.append(r3)     // Catch:{ Exception -> 0x00b2 }
            java.lang.String r3 = r7.toString()     // Catch:{ Exception -> 0x00b2 }
            goto L_0x00b3
        L_0x00b2:
            r3 = 0
        L_0x00b3:
            android.content.Context r6 = r0.zzb
            r7 = 0
            java.lang.String r17 = android.os.Build.FINGERPRINT
            if (r2 != 0) goto L_0x00bd
            r21 = r3
            goto L_0x010b
        L_0x00bd:
            android.content.Intent r8 = new android.content.Intent
            java.lang.String r7 = "android.intent.action.VIEW"
            java.lang.String r20 = "http://www.example.com"
            r21 = r3
            android.net.Uri r3 = android.net.Uri.parse(r20)
            r8.<init>(r7, r3)
            r7 = 0
            android.content.pm.ResolveInfo r3 = r2.resolveActivity(r8, r7)
            r7 = 65536(0x10000, float:9.18355E-41)
            java.util.List r2 = r2.queryIntentActivities(r8, r7)
            if (r2 == 0) goto L_0x010a
            if (r3 == 0) goto L_0x010a
            r7 = 0
        L_0x00dc:
            int r8 = r2.size()
            if (r7 >= r8) goto L_0x010a
            java.lang.Object r8 = r2.get(r7)
            android.content.pm.ResolveInfo r8 = (android.content.pm.ResolveInfo) r8
            r20 = r2
            android.content.pm.ActivityInfo r2 = r3.activityInfo
            java.lang.String r2 = r2.name
            android.content.pm.ActivityInfo r8 = r8.activityInfo
            java.lang.String r8 = r8.name
            boolean r2 = r2.equals(r8)
            if (r2 == 0) goto L_0x0105
            android.content.pm.ActivityInfo r2 = r3.activityInfo
            java.lang.String r2 = r2.packageName
            java.lang.String r3 = com.google.android.gms.internal.ads.zzhgq.zza(r6)
            boolean r7 = r2.equals(r3)
            goto L_0x010b
        L_0x0105:
            int r7 = r7 + 1
            r2 = r20
            goto L_0x00dc
        L_0x010a:
            r7 = 0
        L_0x010b:
            com.google.android.gms.ads.internal.zzv.zzq()
            android.os.StatFs r2 = new android.os.StatFs
            java.io.File r3 = android.os.Environment.getDataDirectory()
            java.lang.String r3 = r3.getAbsolutePath()
            r2.<init>(r3)
            long r2 = r2.getAvailableBytes()
            r22 = 1024(0x400, double:5.06E-321)
            long r2 = r2 / r22
            com.google.android.gms.internal.ads.zzbce r6 = com.google.android.gms.internal.ads.zzbcn.zzkY
            com.google.android.gms.internal.ads.zzbcl r8 = com.google.android.gms.ads.internal.client.zzbe.zzc()
            java.lang.Object r6 = r8.zza(r6)
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            if (r6 == 0) goto L_0x0143
            com.google.android.gms.ads.internal.zzv.zzq()
            android.content.Context r6 = r0.zzb
            boolean r6 = com.google.android.gms.ads.internal.util.zzs.zzB(r6)
            if (r6 == 0) goto L_0x0143
            r22 = 1
            goto L_0x0145
        L_0x0143:
            r22 = 0
        L_0x0145:
            com.google.android.gms.internal.ads.zzbce r6 = com.google.android.gms.internal.ads.zzbcn.zzlc
            com.google.android.gms.internal.ads.zzbcl r8 = com.google.android.gms.ads.internal.client.zzbe.zzc()
            java.lang.Object r6 = r8.zza(r6)
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            if (r6 == 0) goto L_0x0179
            android.content.Context r6 = r0.zzb
            com.google.android.gms.common.wrappers.PackageManagerWrapper r8 = com.google.android.gms.common.wrappers.Wrappers.packageManager(r6)     // Catch:{ NameNotFoundException -> 0x0176 }
            java.lang.String r6 = r6.getPackageName()     // Catch:{ NameNotFoundException -> 0x0176 }
            r0 = 128(0x80, float:1.794E-43)
            android.content.pm.ApplicationInfo r0 = r8.getApplicationInfo(r6, r0)     // Catch:{ NameNotFoundException -> 0x0176 }
            android.os.Bundle r0 = r0.metaData     // Catch:{ NameNotFoundException -> 0x0176 }
            if (r0 == 0) goto L_0x0176
            boolean r6 = r0.containsKey(r1)     // Catch:{ NameNotFoundException -> 0x0176 }
            if (r6 == 0) goto L_0x0176
            java.lang.String r0 = r0.getString(r1)     // Catch:{ NameNotFoundException -> 0x0176 }
            goto L_0x017b
        L_0x0176:
            r23 = 0
            goto L_0x017d
        L_0x0179:
            java.lang.String r0 = ""
        L_0x017b:
            r23 = r0
        L_0x017d:
            if (r5 == 0) goto L_0x0181
            r8 = 1
            goto L_0x0182
        L_0x0181:
            r8 = 0
        L_0x0182:
            if (r4 == 0) goto L_0x0186
            r6 = 1
            goto L_0x0187
        L_0x0186:
            r6 = 0
        L_0x0187:
            com.google.android.gms.internal.ads.zzewi r0 = new com.google.android.gms.internal.ads.zzewi
            java.lang.String r19 = android.os.Build.MODEL
            int r24 = android.os.Build.VERSION.SDK_INT
            r18 = r7
            r16 = r21
            r20 = r2
            r7 = r6
            r6 = r0
            r6.<init>(r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r22, r23, r24)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzewk.zzc():com.google.android.gms.internal.ads.zzewi");
    }
}
