package com.google.android.gms.measurement.internal;

import android.content.Context;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.measurement.zzpz;
import com.google.android.gms.measurement.internal.zzje;
import java.math.BigInteger;
import java.util.List;
import java.util.Locale;
import org.checkerframework.dataflow.qual.Pure;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.1.2 */
public final class zzgg extends zzh {
    private String zza;
    private String zzb;
    private int zzc;
    private String zzd;
    private long zze;
    private long zzf;
    private List<String> zzg;
    private String zzh;
    private int zzi;
    private String zzj;
    private String zzk;
    private String zzl;
    private long zzm = 0;
    private String zzn = null;

    /* access modifiers changed from: package-private */
    public final int zzaa() {
        zzu();
        return this.zzi;
    }

    /* access modifiers changed from: protected */
    public final boolean zzz() {
        return true;
    }

    /* access modifiers changed from: package-private */
    public final int zzab() {
        zzu();
        return this.zzc;
    }

    @Pure
    public final /* bridge */ /* synthetic */ Context zza() {
        return super.zza();
    }

    @Pure
    public final /* bridge */ /* synthetic */ Clock zzb() {
        return super.zzb();
    }

    public final /* bridge */ /* synthetic */ zzb zzc() {
        return super.zzc();
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0120, code lost:
        if (zzk().zzo().zza(com.google.android.gms.measurement.internal.zzje.zza.ANALYTICS_STORAGE) == false) goto L_0x015d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.measurement.internal.zzo zza(java.lang.String r43) {
        /*
            r42 = this;
            r0 = r42
            r0.zzt()
            com.google.android.gms.measurement.internal.zzo r1 = new com.google.android.gms.measurement.internal.zzo
            java.lang.String r2 = r0.zzad()
            java.lang.String r3 = r0.zzae()
            r0.zzu()
            java.lang.String r4 = r0.zzb
            int r5 = r0.zzab()
            long r5 = (long) r5
            r0.zzu()
            java.lang.String r7 = r0.zzd
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r7)
            java.lang.String r7 = r0.zzd
            r0.zzu()
            r0.zzt()
            long r8 = r0.zze
            r10 = 0
            int r8 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r8 != 0) goto L_0x0049
            com.google.android.gms.measurement.internal.zzhy r8 = r0.zzu
            com.google.android.gms.measurement.internal.zzos r8 = r8.zzt()
            android.content.Context r9 = r0.zza()
            android.content.Context r12 = r0.zza()
            java.lang.String r12 = r12.getPackageName()
            long r8 = r8.zza((android.content.Context) r9, (java.lang.String) r12)
            r0.zze = r8
        L_0x0049:
            r8 = r10
            long r10 = r0.zze
            com.google.android.gms.measurement.internal.zzhy r12 = r0.zzu
            boolean r13 = r12.zzac()
            com.google.android.gms.measurement.internal.zzha r12 = r0.zzk()
            boolean r12 = r12.zzm
            r14 = 1
            r12 = r12 ^ r14
            r0.zzt()
            com.google.android.gms.measurement.internal.zzhy r15 = r0.zzu
            boolean r15 = r15.zzac()
            r16 = 0
            if (r15 != 0) goto L_0x006a
            r15 = r16
            goto L_0x006e
        L_0x006a:
            java.lang.String r15 = r0.zzah()
        L_0x006e:
            r17 = r8
            com.google.android.gms.measurement.internal.zzhy r8 = r0.zzu
            com.google.android.gms.measurement.internal.zzha r9 = r8.zzn()
            com.google.android.gms.measurement.internal.zzhb r9 = r9.zzc
            r19 = r14
            r20 = r15
            long r14 = r9.zza()
            int r9 = (r14 > r17 ? 1 : (r14 == r17 ? 0 : -1))
            if (r9 != 0) goto L_0x0087
            long r8 = r8.zza
            goto L_0x008d
        L_0x0087:
            long r8 = r8.zza
            long r8 = java.lang.Math.min(r8, r14)
        L_0x008d:
            r15 = r20
            int r20 = r0.zzaa()
            com.google.android.gms.measurement.internal.zzag r14 = r0.zze()
            boolean r21 = r14.zzv()
            com.google.android.gms.measurement.internal.zzha r14 = r0.zzk()
            r14.zzt()
            android.content.SharedPreferences r14 = r14.zzg()
            r22 = r1
            java.lang.String r1 = "deferred_analytics_collection"
            r23 = r2
            r2 = 0
            boolean r1 = r14.getBoolean(r1, r2)
            r14 = r2
            r2 = r23
            java.lang.String r23 = r0.zzac()
            com.google.android.gms.measurement.internal.zzag r14 = r0.zze()
            r25 = r1
            java.lang.String r1 = "google_analytics_default_allow_ad_personalization_signals"
            java.lang.Boolean r14 = r14.zze(r1)
            if (r14 != 0) goto L_0x00cd
            r14 = r16
        L_0x00c8:
            r27 = r2
            r26 = r3
            goto L_0x00d8
        L_0x00cd:
            boolean r14 = r14.booleanValue()
            r14 = r14 ^ 1
            java.lang.Boolean r14 = java.lang.Boolean.valueOf(r14)
            goto L_0x00c8
        L_0x00d8:
            long r2 = r0.zzf
            r28 = r2
            java.util.List<java.lang.String> r2 = r0.zzg
            com.google.android.gms.measurement.internal.zzha r3 = r0.zzk()
            com.google.android.gms.measurement.internal.zzje r3 = r3.zzo()
            java.lang.String r3 = r3.zzf()
            r30 = r2
            java.lang.String r2 = r0.zzh
            if (r2 != 0) goto L_0x00fa
            com.google.android.gms.measurement.internal.zzos r2 = r0.zzq()
            java.lang.String r2 = r2.zzp()
            r0.zzh = r2
        L_0x00fa:
            java.lang.String r2 = r0.zzh
            boolean r31 = com.google.android.gms.internal.measurement.zznm.zza()
            if (r31 == 0) goto L_0x0123
            r31 = r2
            com.google.android.gms.measurement.internal.zzag r2 = r0.zze()
            r32 = r3
            com.google.android.gms.measurement.internal.zzfz<java.lang.Boolean> r3 = com.google.android.gms.measurement.internal.zzbh.zzcx
            boolean r2 = r2.zza((com.google.android.gms.measurement.internal.zzfz<java.lang.Boolean>) r3)
            if (r2 == 0) goto L_0x0127
            com.google.android.gms.measurement.internal.zzha r2 = r0.zzk()
            com.google.android.gms.measurement.internal.zzje r2 = r2.zzo()
            com.google.android.gms.measurement.internal.zzje$zza r3 = com.google.android.gms.measurement.internal.zzje.zza.ANALYTICS_STORAGE
            boolean r2 = r2.zza((com.google.android.gms.measurement.internal.zzje.zza) r3)
            if (r2 != 0) goto L_0x0127
            goto L_0x015d
        L_0x0123:
            r31 = r2
            r32 = r3
        L_0x0127:
            r0.zzt()
            long r2 = r0.zzm
            int r2 = (r2 > r17 ? 1 : (r2 == r17 ? 0 : -1))
            if (r2 == 0) goto L_0x0152
            com.google.android.gms.common.util.Clock r2 = r0.zzb()
            long r2 = r2.currentTimeMillis()
            r33 = r2
            long r2 = r0.zzm
            long r2 = r33 - r2
            r33 = r2
            java.lang.String r2 = r0.zzl
            if (r2 == 0) goto L_0x0152
            r2 = 86400000(0x5265c00, double:4.2687272E-316)
            int r2 = (r33 > r2 ? 1 : (r33 == r2 ? 0 : -1))
            if (r2 <= 0) goto L_0x0152
            java.lang.String r2 = r0.zzn
            if (r2 != 0) goto L_0x0152
            r0.zzag()
        L_0x0152:
            java.lang.String r2 = r0.zzl
            if (r2 != 0) goto L_0x0159
            r0.zzag()
        L_0x0159:
            java.lang.String r2 = r0.zzl
            r16 = r2
        L_0x015d:
            com.google.android.gms.measurement.internal.zzag r2 = r0.zze()
            java.lang.String r3 = "google_analytics_sgtm_upload_enabled"
            java.lang.Boolean r2 = r2.zze(r3)
            if (r2 != 0) goto L_0x016b
            r2 = 0
            goto L_0x016f
        L_0x016b:
            boolean r2 = r2.booleanValue()
        L_0x016f:
            com.google.android.gms.measurement.internal.zzos r3 = r0.zzq()
            java.lang.String r0 = r42.zzad()
            long r33 = r3.zzc(r0)
            com.google.android.gms.measurement.internal.zzha r0 = r42.zzk()
            com.google.android.gms.measurement.internal.zzje r0 = r0.zzo()
            int r35 = r0.zza()
            com.google.android.gms.measurement.internal.zzha r0 = r42.zzk()
            com.google.android.gms.measurement.internal.zzax r0 = r0.zzn()
            java.lang.String r36 = r0.zzf()
            boolean r0 = com.google.android.gms.internal.measurement.zzpn.zza()
            if (r0 == 0) goto L_0x01af
            com.google.android.gms.measurement.internal.zzag r0 = r42.zze()
            com.google.android.gms.measurement.internal.zzfz<java.lang.Boolean> r3 = com.google.android.gms.measurement.internal.zzbh.zzci
            boolean r0 = r0.zza((com.google.android.gms.measurement.internal.zzfz<java.lang.Boolean>) r3)
            if (r0 == 0) goto L_0x01af
            r42.zzq()
            int r0 = com.google.android.gms.measurement.internal.zzos.zzc()
            r37 = r0
            goto L_0x01b1
        L_0x01af:
            r37 = 0
        L_0x01b1:
            boolean r0 = com.google.android.gms.internal.measurement.zzpn.zza()
            if (r0 == 0) goto L_0x01cb
            com.google.android.gms.measurement.internal.zzag r0 = r42.zze()
            com.google.android.gms.measurement.internal.zzfz<java.lang.Boolean> r3 = com.google.android.gms.measurement.internal.zzbh.zzci
            boolean r0 = r0.zza((com.google.android.gms.measurement.internal.zzfz<java.lang.Boolean>) r3)
            if (r0 == 0) goto L_0x01cb
            com.google.android.gms.measurement.internal.zzos r0 = r42.zzq()
            long r17 = r0.zzm()
        L_0x01cb:
            r38 = r17
            com.google.android.gms.measurement.internal.zzag r0 = r42.zze()
            java.lang.String r40 = r0.zzu()
            com.google.android.gms.measurement.internal.zzag r0 = r42.zze()
            r3 = r19
            com.google.android.gms.measurement.internal.zzjh r0 = r0.zzc((java.lang.String) r1, (boolean) r3)
            com.google.android.gms.measurement.internal.zzf r1 = new com.google.android.gms.measurement.internal.zzf
            r1.<init>(r0)
            java.lang.String r41 = r1.zzb()
            r18 = r8
            r8 = 106000(0x19e10, double:5.2371E-319)
            r1 = r22
            r22 = r25
            r3 = r26
            r25 = r28
            r29 = r32
            r32 = r2
            r2 = r27
            r27 = r30
            r30 = r31
            r31 = r16
            r16 = 0
            r28 = 0
            r24 = r14
            r14 = r12
            r12 = r43
            r1.<init>((java.lang.String) r2, (java.lang.String) r3, (java.lang.String) r4, (long) r5, (java.lang.String) r7, (long) r8, (long) r10, (java.lang.String) r12, (boolean) r13, (boolean) r14, (java.lang.String) r15, (long) r16, (long) r18, (int) r20, (boolean) r21, (boolean) r22, (java.lang.String) r23, (java.lang.Boolean) r24, (long) r25, (java.util.List<java.lang.String>) r27, (java.lang.String) r28, (java.lang.String) r29, (java.lang.String) r30, (java.lang.String) r31, (boolean) r32, (long) r33, (int) r35, (java.lang.String) r36, (int) r37, (long) r38, (java.lang.String) r40, (java.lang.String) r41)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzgg.zza(java.lang.String):com.google.android.gms.measurement.internal.zzo");
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

    public final /* bridge */ /* synthetic */ zzgg zzg() {
        return super.zzg();
    }

    public final /* bridge */ /* synthetic */ zzgf zzh() {
        return super.zzh();
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

    public final /* bridge */ /* synthetic */ zzjq zzm() {
        return super.zzm();
    }

    public final /* bridge */ /* synthetic */ zzlj zzn() {
        return super.zzn();
    }

    public final /* bridge */ /* synthetic */ zzls zzo() {
        return super.zzo();
    }

    public final /* bridge */ /* synthetic */ zznb zzp() {
        return super.zzp();
    }

    @Pure
    public final /* bridge */ /* synthetic */ zzos zzq() {
        return super.zzq();
    }

    /* access modifiers changed from: package-private */
    public final String zzac() {
        zzu();
        return this.zzk;
    }

    /* access modifiers changed from: package-private */
    public final String zzad() {
        zzu();
        Preconditions.checkNotNull(this.zza);
        return this.zza;
    }

    private final String zzah() {
        if (!zzpz.zza() || !zze().zza(zzbh.zzbr)) {
            try {
                Class<?> loadClass = zza().getClassLoader().loadClass("com.google.firebase.analytics.FirebaseAnalytics");
                if (loadClass == null) {
                    return null;
                }
                try {
                    Object invoke = loadClass.getDeclaredMethod("getInstance", new Class[]{Context.class}).invoke((Object) null, new Object[]{zza()});
                    if (invoke == null) {
                        return null;
                    }
                    try {
                        return (String) loadClass.getDeclaredMethod("getFirebaseInstanceId", new Class[0]).invoke(invoke, new Object[0]);
                    } catch (Exception unused) {
                        zzj().zzv().zza("Failed to retrieve Firebase Instance Id");
                        return null;
                    }
                } catch (Exception unused2) {
                    zzj().zzw().zza("Failed to obtain Firebase Analytics instance");
                    return null;
                }
            } catch (ClassNotFoundException unused3) {
                return null;
            }
        } else {
            zzj().zzp().zza("Disabled IID for tests.");
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public final String zzae() {
        zzt();
        zzu();
        Preconditions.checkNotNull(this.zzj);
        return this.zzj;
    }

    /* access modifiers changed from: package-private */
    public final List<String> zzaf() {
        return this.zzg;
    }

    zzgg(zzhy zzhy, long j) {
        super(zzhy);
        this.zzf = j;
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

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00b5  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00db  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00ea  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00f8  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0106  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0114  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0122  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0130  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x013e  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x014c  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x015c  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0163  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0186 A[Catch:{ IllegalStateException -> 0x01c6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0187 A[Catch:{ IllegalStateException -> 0x01c6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0190 A[Catch:{ IllegalStateException -> 0x01c6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x01a9 A[Catch:{ IllegalStateException -> 0x01c6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x01e7  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x021c  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0227  */
    @org.checkerframework.checker.nullness.qual.EnsuresNonNull({"appId", "appStore", "appName", "gmpAppId", "gaAppId"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzx() {
        /*
            r11 = this;
            android.content.Context r0 = r11.zza()
            java.lang.String r0 = r0.getPackageName()
            android.content.Context r1 = r11.zza()
            android.content.pm.PackageManager r1 = r1.getPackageManager()
            java.lang.String r2 = ""
            r3 = 0
            java.lang.String r4 = "unknown"
            java.lang.String r5 = "Unknown"
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r1 != 0) goto L_0x002d
            com.google.android.gms.measurement.internal.zzgo r7 = r11.zzj()
            com.google.android.gms.measurement.internal.zzgq r7 = r7.zzg()
            java.lang.String r8 = "PackageManager is null, app identity information might be inaccurate. appId"
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzgo.zza((java.lang.String) r0)
            r7.zza(r8, r9)
            goto L_0x008c
        L_0x002d:
            java.lang.String r4 = r1.getInstallerPackageName(r0)     // Catch:{ IllegalArgumentException -> 0x0032 }
            goto L_0x0043
        L_0x0032:
            com.google.android.gms.measurement.internal.zzgo r7 = r11.zzj()
            com.google.android.gms.measurement.internal.zzgq r7 = r7.zzg()
            java.lang.String r8 = "Error retrieving app installer package name. appId"
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzgo.zza((java.lang.String) r0)
            r7.zza(r8, r9)
        L_0x0043:
            if (r4 != 0) goto L_0x0048
            java.lang.String r4 = "manual_install"
            goto L_0x0051
        L_0x0048:
            java.lang.String r7 = "com.android.vending"
            boolean r7 = r7.equals(r4)
            if (r7 == 0) goto L_0x0051
            r4 = r2
        L_0x0051:
            android.content.Context r7 = r11.zza()     // Catch:{ NameNotFoundException -> 0x0079 }
            java.lang.String r7 = r7.getPackageName()     // Catch:{ NameNotFoundException -> 0x0079 }
            android.content.pm.PackageInfo r7 = r1.getPackageInfo(r7, r3)     // Catch:{ NameNotFoundException -> 0x0079 }
            if (r7 == 0) goto L_0x008c
            android.content.pm.ApplicationInfo r8 = r7.applicationInfo     // Catch:{ NameNotFoundException -> 0x0079 }
            java.lang.CharSequence r8 = r1.getApplicationLabel(r8)     // Catch:{ NameNotFoundException -> 0x0079 }
            boolean r9 = android.text.TextUtils.isEmpty(r8)     // Catch:{ NameNotFoundException -> 0x0079 }
            if (r9 != 0) goto L_0x0070
            java.lang.String r8 = r8.toString()     // Catch:{ NameNotFoundException -> 0x0079 }
            goto L_0x0071
        L_0x0070:
            r8 = r5
        L_0x0071:
            java.lang.String r5 = r7.versionName     // Catch:{ NameNotFoundException -> 0x0076 }
            int r6 = r7.versionCode     // Catch:{ NameNotFoundException -> 0x0076 }
            goto L_0x008c
        L_0x0076:
            r7 = r5
            r5 = r8
            goto L_0x007a
        L_0x0079:
            r7 = r5
        L_0x007a:
            com.google.android.gms.measurement.internal.zzgo r8 = r11.zzj()
            com.google.android.gms.measurement.internal.zzgq r8 = r8.zzg()
            java.lang.String r9 = "Error retrieving package info. appId, appName"
            java.lang.Object r10 = com.google.android.gms.measurement.internal.zzgo.zza((java.lang.String) r0)
            r8.zza(r9, r10, r5)
            r5 = r7
        L_0x008c:
            r11.zza = r0
            r11.zzd = r4
            r11.zzb = r5
            r11.zzc = r6
            r4 = 0
            r11.zze = r4
            com.google.android.gms.measurement.internal.zzhy r4 = r11.zzu
            java.lang.String r4 = r4.zzu()
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            r5 = 1
            if (r4 != 0) goto L_0x00b5
            com.google.android.gms.measurement.internal.zzhy r4 = r11.zzu
            java.lang.String r4 = r4.zzv()
            java.lang.String r6 = "am"
            boolean r4 = r6.equals(r4)
            if (r4 == 0) goto L_0x00b5
            r4 = r5
            goto L_0x00b6
        L_0x00b5:
            r4 = r3
        L_0x00b6:
            com.google.android.gms.measurement.internal.zzhy r6 = r11.zzu
            int r6 = r6.zzc()
            switch(r6) {
                case 0: goto L_0x014c;
                case 1: goto L_0x013e;
                case 2: goto L_0x0130;
                case 3: goto L_0x0122;
                case 4: goto L_0x0114;
                case 5: goto L_0x0106;
                case 6: goto L_0x00f8;
                case 7: goto L_0x00ea;
                case 8: goto L_0x00db;
                default: goto L_0x00bf;
            }
        L_0x00bf:
            com.google.android.gms.measurement.internal.zzgo r7 = r11.zzj()
            com.google.android.gms.measurement.internal.zzgq r7 = r7.zzo()
            java.lang.String r8 = "App measurement disabled"
            r7.zza(r8)
            com.google.android.gms.measurement.internal.zzgo r7 = r11.zzj()
            com.google.android.gms.measurement.internal.zzgq r7 = r7.zzn()
            java.lang.String r8 = "Invalid scion state in identity"
            r7.zza(r8)
            goto L_0x0159
        L_0x00db:
            com.google.android.gms.measurement.internal.zzgo r7 = r11.zzj()
            com.google.android.gms.measurement.internal.zzgq r7 = r7.zzo()
            java.lang.String r8 = "App measurement disabled due to denied storage consent"
            r7.zza(r8)
            goto L_0x0159
        L_0x00ea:
            com.google.android.gms.measurement.internal.zzgo r7 = r11.zzj()
            com.google.android.gms.measurement.internal.zzgq r7 = r7.zzo()
            java.lang.String r8 = "App measurement disabled via the global data collection setting"
            r7.zza(r8)
            goto L_0x0159
        L_0x00f8:
            com.google.android.gms.measurement.internal.zzgo r7 = r11.zzj()
            com.google.android.gms.measurement.internal.zzgq r7 = r7.zzv()
            java.lang.String r8 = "App measurement deactivated via resources. This method is being deprecated. Please refer to https://firebase.google.com/support/guides/disable-analytics"
            r7.zza(r8)
            goto L_0x0159
        L_0x0106:
            com.google.android.gms.measurement.internal.zzgo r7 = r11.zzj()
            com.google.android.gms.measurement.internal.zzgq r7 = r7.zzp()
            java.lang.String r8 = "App measurement disabled via the init parameters"
            r7.zza(r8)
            goto L_0x0159
        L_0x0114:
            com.google.android.gms.measurement.internal.zzgo r7 = r11.zzj()
            com.google.android.gms.measurement.internal.zzgq r7 = r7.zzo()
            java.lang.String r8 = "App measurement disabled via the manifest"
            r7.zza(r8)
            goto L_0x0159
        L_0x0122:
            com.google.android.gms.measurement.internal.zzgo r7 = r11.zzj()
            com.google.android.gms.measurement.internal.zzgq r7 = r7.zzo()
            java.lang.String r8 = "App measurement disabled by setAnalyticsCollectionEnabled(false)"
            r7.zza(r8)
            goto L_0x0159
        L_0x0130:
            com.google.android.gms.measurement.internal.zzgo r7 = r11.zzj()
            com.google.android.gms.measurement.internal.zzgq r7 = r7.zzp()
            java.lang.String r8 = "App measurement deactivated via the init parameters"
            r7.zza(r8)
            goto L_0x0159
        L_0x013e:
            com.google.android.gms.measurement.internal.zzgo r7 = r11.zzj()
            com.google.android.gms.measurement.internal.zzgq r7 = r7.zzo()
            java.lang.String r8 = "App measurement deactivated via the manifest"
            r7.zza(r8)
            goto L_0x0159
        L_0x014c:
            com.google.android.gms.measurement.internal.zzgo r7 = r11.zzj()
            com.google.android.gms.measurement.internal.zzgq r7 = r7.zzp()
            java.lang.String r8 = "App measurement collection enabled"
            r7.zza(r8)
        L_0x0159:
            if (r6 != 0) goto L_0x015c
            goto L_0x015d
        L_0x015c:
            r5 = r3
        L_0x015d:
            r11.zzj = r2
            r11.zzk = r2
            if (r4 == 0) goto L_0x016b
            com.google.android.gms.measurement.internal.zzhy r4 = r11.zzu
            java.lang.String r4 = r4.zzu()
            r11.zzk = r4
        L_0x016b:
            android.content.Context r4 = r11.zza()     // Catch:{ IllegalStateException -> 0x01c6 }
            com.google.android.gms.measurement.internal.zzhy r6 = r11.zzu     // Catch:{ IllegalStateException -> 0x01c6 }
            java.lang.String r6 = r6.zzx()     // Catch:{ IllegalStateException -> 0x01c6 }
            java.lang.String r7 = "google_app_id"
            com.google.android.gms.measurement.internal.zzhs r8 = new com.google.android.gms.measurement.internal.zzhs     // Catch:{ IllegalStateException -> 0x01c6 }
            r8.<init>(r4, r6)     // Catch:{ IllegalStateException -> 0x01c6 }
            java.lang.String r4 = r8.zza((java.lang.String) r7)     // Catch:{ IllegalStateException -> 0x01c6 }
            boolean r6 = android.text.TextUtils.isEmpty(r4)     // Catch:{ IllegalStateException -> 0x01c6 }
            if (r6 == 0) goto L_0x0187
            goto L_0x0188
        L_0x0187:
            r2 = r4
        L_0x0188:
            r11.zzj = r2     // Catch:{ IllegalStateException -> 0x01c6 }
            boolean r2 = android.text.TextUtils.isEmpty(r4)     // Catch:{ IllegalStateException -> 0x01c6 }
            if (r2 != 0) goto L_0x01a7
            com.google.android.gms.measurement.internal.zzhs r2 = new com.google.android.gms.measurement.internal.zzhs     // Catch:{ IllegalStateException -> 0x01c6 }
            android.content.Context r4 = r11.zza()     // Catch:{ IllegalStateException -> 0x01c6 }
            com.google.android.gms.measurement.internal.zzhy r6 = r11.zzu     // Catch:{ IllegalStateException -> 0x01c6 }
            java.lang.String r6 = r6.zzx()     // Catch:{ IllegalStateException -> 0x01c6 }
            r2.<init>(r4, r6)     // Catch:{ IllegalStateException -> 0x01c6 }
            java.lang.String r4 = "admob_app_id"
            java.lang.String r2 = r2.zza((java.lang.String) r4)     // Catch:{ IllegalStateException -> 0x01c6 }
            r11.zzk = r2     // Catch:{ IllegalStateException -> 0x01c6 }
        L_0x01a7:
            if (r5 == 0) goto L_0x01d8
            com.google.android.gms.measurement.internal.zzgo r2 = r11.zzj()     // Catch:{ IllegalStateException -> 0x01c6 }
            com.google.android.gms.measurement.internal.zzgq r2 = r2.zzp()     // Catch:{ IllegalStateException -> 0x01c6 }
            java.lang.String r4 = "App measurement enabled for app package, google app id"
            java.lang.String r5 = r11.zza     // Catch:{ IllegalStateException -> 0x01c6 }
            java.lang.String r6 = r11.zzj     // Catch:{ IllegalStateException -> 0x01c6 }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ IllegalStateException -> 0x01c6 }
            if (r6 == 0) goto L_0x01c0
            java.lang.String r6 = r11.zzk     // Catch:{ IllegalStateException -> 0x01c6 }
            goto L_0x01c2
        L_0x01c0:
            java.lang.String r6 = r11.zzj     // Catch:{ IllegalStateException -> 0x01c6 }
        L_0x01c2:
            r2.zza(r4, r5, r6)     // Catch:{ IllegalStateException -> 0x01c6 }
            goto L_0x01d8
        L_0x01c6:
            r2 = move-exception
            com.google.android.gms.measurement.internal.zzgo r4 = r11.zzj()
            com.google.android.gms.measurement.internal.zzgq r4 = r4.zzg()
            java.lang.String r5 = "Fetching Google App Id failed with exception. appId"
            java.lang.Object r0 = com.google.android.gms.measurement.internal.zzgo.zza((java.lang.String) r0)
            r4.zza(r5, r0, r2)
        L_0x01d8:
            r0 = 0
            r11.zzg = r0
            com.google.android.gms.measurement.internal.zzag r0 = r11.zze()
            java.lang.String r2 = "analytics.safelisted_events"
            java.util.List r0 = r0.zzg(r2)
            if (r0 == 0) goto L_0x0218
            boolean r2 = r0.isEmpty()
            if (r2 == 0) goto L_0x01fb
            com.google.android.gms.measurement.internal.zzgo r0 = r11.zzj()
            com.google.android.gms.measurement.internal.zzgq r0 = r0.zzv()
            java.lang.String r2 = "Safelisted event list is empty. Ignoring"
            r0.zza(r2)
            goto L_0x021a
        L_0x01fb:
            java.util.Iterator r2 = r0.iterator()
        L_0x01ff:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L_0x0218
            java.lang.Object r4 = r2.next()
            java.lang.String r4 = (java.lang.String) r4
            com.google.android.gms.measurement.internal.zzos r5 = r11.zzq()
            java.lang.String r6 = "safelisted event"
            boolean r4 = r5.zzb((java.lang.String) r6, (java.lang.String) r4)
            if (r4 != 0) goto L_0x01ff
            goto L_0x021a
        L_0x0218:
            r11.zzg = r0
        L_0x021a:
            if (r1 == 0) goto L_0x0227
            android.content.Context r0 = r11.zza()
            boolean r0 = com.google.android.gms.common.wrappers.InstantApps.isInstantApp(r0)
            r11.zzi = r0
            return
        L_0x0227:
            r11.zzi = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzgg.zzx():void");
    }

    /* access modifiers changed from: package-private */
    public final void zzag() {
        String str;
        zzt();
        if (!zzk().zzo().zza(zzje.zza.ANALYTICS_STORAGE)) {
            zzj().zzc().zza("Analytics Storage consent is not granted");
            str = null;
        } else {
            byte[] bArr = new byte[16];
            zzq().zzv().nextBytes(bArr);
            str = String.format(Locale.US, "%032x", new Object[]{new BigInteger(1, bArr)});
        }
        zzj().zzc().zza(String.format("Resetting session stitching token to %s", new Object[]{str == null ? "null" : "not null"}));
        this.zzl = str;
        this.zzm = zzb().currentTimeMillis();
    }

    /* access modifiers changed from: package-private */
    public final boolean zzb(String str) {
        String str2 = this.zzn;
        boolean z = str2 != null && !str2.equals(str);
        this.zzn = str;
        return z;
    }
}
