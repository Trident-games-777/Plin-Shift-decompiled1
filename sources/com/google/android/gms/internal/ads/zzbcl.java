package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.ConditionVariable;
import androidx.lifecycle.CoroutineLiveDataKt;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONException;
import org.json.JSONObject;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
public final class zzbcl implements SharedPreferences.OnSharedPreferenceChangeListener {
    volatile boolean zza = false;
    private final Object zzb = new Object();
    private final ConditionVariable zzc = new ConditionVariable();
    private volatile boolean zzd = false;
    private SharedPreferences zze = null;
    private Bundle zzf = new Bundle();
    private Context zzg;
    private JSONObject zzh = new JSONObject();
    private boolean zzi = false;
    private boolean zzj = false;

    private final void zzg(SharedPreferences sharedPreferences) {
        if (sharedPreferences != null) {
            try {
                this.zzh = new JSONObject((String) zzbcp.zza(new zzbci(sharedPreferences)));
            } catch (JSONException unused) {
            }
        }
    }

    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        if ("flag_configuration".equals(str)) {
            zzg(sharedPreferences);
        }
    }

    public final Object zza(zzbce zzbce) {
        if (!this.zzc.block(CoroutineLiveDataKt.DEFAULT_TIMEOUT)) {
            synchronized (this.zzb) {
                if (!this.zza) {
                    throw new IllegalStateException("Flags.initialize() was not called!");
                }
            }
        }
        if (!this.zzd || this.zze == null || this.zzj) {
            synchronized (this.zzb) {
                if (this.zzd && this.zze != null) {
                    if (this.zzj) {
                    }
                }
                Object zzk = zzbce.zzk();
                return zzk;
            }
        }
        if (zzbce.zze() == 2) {
            Bundle bundle = this.zzf;
            if (bundle == null) {
                return zzbce.zzk();
            }
            return zzbce.zzb(bundle);
        } else if (zzbce.zze() != 1 || !this.zzh.has(zzbce.zzl())) {
            return zzbcp.zza(new zzbcj(this, zzbce));
        } else {
            return zzbce.zza(this.zzh);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object zzc(zzbce zzbce) {
        return zzbce.zzc(this.zze);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0118, code lost:
        if (new org.json.JSONObject((java.lang.String) com.google.android.gms.internal.ads.zzbcp.zza(new com.google.android.gms.internal.ads.zzbch(r3))).optBoolean("local_flags_enabled") != false) goto L_0x011a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:?, code lost:
        return;
     */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x011e A[SYNTHETIC, Splitter:B:68:0x011e] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0127 A[SYNTHETIC, Splitter:B:70:0x0127] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzd(android.content.Context r11) {
        /*
            r10 = this;
            boolean r0 = r10.zzd
            if (r0 == 0) goto L_0x0006
            goto L_0x0154
        L_0x0006:
            java.lang.Object r0 = r10.zzb
            monitor-enter(r0)
            boolean r1 = r10.zzd     // Catch:{ all -> 0x015e }
            if (r1 == 0) goto L_0x000f
            monitor-exit(r0)     // Catch:{ all -> 0x015e }
            return
        L_0x000f:
            boolean r1 = r10.zza     // Catch:{ all -> 0x015e }
            r2 = 1
            if (r1 != 0) goto L_0x0016
            r10.zza = r2     // Catch:{ all -> 0x015e }
        L_0x0016:
            java.lang.String r1 = r11.getPackageName()     // Catch:{ all -> 0x015e }
            java.lang.String r3 = "com.google.android.gms"
            boolean r1 = android.text.TextUtils.equals(r1, r3)     // Catch:{ all -> 0x015e }
            r10.zzi = r1     // Catch:{ all -> 0x015e }
            android.content.Context r1 = r11.getApplicationContext()     // Catch:{ all -> 0x015e }
            if (r1 == 0) goto L_0x002c
            android.content.Context r11 = r11.getApplicationContext()     // Catch:{ all -> 0x015e }
        L_0x002c:
            r10.zzg = r11     // Catch:{ all -> 0x015e }
            com.google.android.gms.common.wrappers.PackageManagerWrapper r11 = com.google.android.gms.common.wrappers.Wrappers.packageManager(r11)     // Catch:{ NameNotFoundException | NullPointerException -> 0x0042 }
            android.content.Context r1 = r10.zzg     // Catch:{ NameNotFoundException | NullPointerException -> 0x0042 }
            java.lang.String r1 = r1.getPackageName()     // Catch:{ NameNotFoundException | NullPointerException -> 0x0042 }
            r3 = 128(0x80, float:1.794E-43)
            android.content.pm.ApplicationInfo r11 = r11.getApplicationInfo(r1, r3)     // Catch:{ NameNotFoundException | NullPointerException -> 0x0042 }
            android.os.Bundle r11 = r11.metaData     // Catch:{ NameNotFoundException | NullPointerException -> 0x0042 }
            r10.zzf = r11     // Catch:{ NameNotFoundException | NullPointerException -> 0x0042 }
        L_0x0042:
            r11 = 0
            android.content.Context r1 = r10.zzg     // Catch:{ all -> 0x0155 }
            android.content.Context r3 = com.google.android.gms.common.GooglePlayServicesUtilLight.getRemoteContext(r1)     // Catch:{ all -> 0x0155 }
            if (r3 != 0) goto L_0x0053
            if (r1 == 0) goto L_0x0053
            android.content.Context r3 = r1.getApplicationContext()     // Catch:{ all -> 0x0155 }
            if (r3 == 0) goto L_0x0054
        L_0x0053:
            r1 = r3
        L_0x0054:
            if (r1 == 0) goto L_0x005e
            com.google.android.gms.ads.internal.client.zzbe.zzb()     // Catch:{ all -> 0x0155 }
            android.content.SharedPreferences r3 = com.google.android.gms.internal.ads.zzbcg.zza(r1)     // Catch:{ all -> 0x0155 }
            goto L_0x005f
        L_0x005e:
            r3 = 0
        L_0x005f:
            if (r3 == 0) goto L_0x0069
            com.google.android.gms.internal.ads.zzbck r4 = new com.google.android.gms.internal.ads.zzbck     // Catch:{ all -> 0x0155 }
            r4.<init>(r10, r3)     // Catch:{ all -> 0x0155 }
            com.google.android.gms.internal.ads.zzbfe.zzc(r4)     // Catch:{ all -> 0x0155 }
        L_0x0069:
            boolean r3 = r10.zzi     // Catch:{ all -> 0x0155 }
            r4 = 0
            if (r3 != 0) goto L_0x00a4
            com.google.android.gms.internal.ads.zzbdx r3 = com.google.android.gms.internal.ads.zzbef.zzd     // Catch:{ all -> 0x0155 }
            java.lang.Object r3 = r3.zze()     // Catch:{ all -> 0x0155 }
            java.lang.Long r3 = (java.lang.Long) r3     // Catch:{ all -> 0x0155 }
            long r6 = r3.longValue()     // Catch:{ all -> 0x0155 }
            int r3 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r3 <= 0) goto L_0x00a4
            android.content.Context r3 = r10.zzg     // Catch:{ all -> 0x0155 }
            int r3 = com.google.android.gms.internal.ads.zzbbx.zza(r3)     // Catch:{ all -> 0x0155 }
            long r6 = (long) r3     // Catch:{ all -> 0x0155 }
            com.google.android.gms.internal.ads.zzbdx r3 = com.google.android.gms.internal.ads.zzbef.zzd     // Catch:{ all -> 0x0155 }
            java.lang.Object r3 = r3.zze()     // Catch:{ all -> 0x0155 }
            java.lang.Long r3 = (java.lang.Long) r3     // Catch:{ all -> 0x0155 }
            long r8 = r3.longValue()     // Catch:{ all -> 0x0155 }
            int r3 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r3 < 0) goto L_0x00a4
            r10.zzj = r2     // Catch:{ all -> 0x0155 }
            r10.zzd = r2     // Catch:{ all -> 0x0155 }
            r10.zza = r11     // Catch:{ all -> 0x015e }
            android.os.ConditionVariable r11 = r10.zzc     // Catch:{ all -> 0x015e }
            r11.open()     // Catch:{ all -> 0x015e }
        L_0x00a1:
            monitor-exit(r0)     // Catch:{ all -> 0x015e }
            goto L_0x0154
        L_0x00a4:
            boolean r3 = r10.zzi     // Catch:{ all -> 0x0155 }
            if (r3 != 0) goto L_0x00db
            com.google.android.gms.internal.ads.zzbdx r3 = com.google.android.gms.internal.ads.zzbef.zzf     // Catch:{ all -> 0x0155 }
            java.lang.Object r3 = r3.zze()     // Catch:{ all -> 0x0155 }
            java.lang.Long r3 = (java.lang.Long) r3     // Catch:{ all -> 0x0155 }
            long r6 = r3.longValue()     // Catch:{ all -> 0x0155 }
            int r3 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r3 <= 0) goto L_0x00db
            android.content.Context r3 = r10.zzg     // Catch:{ all -> 0x0155 }
            int r3 = com.google.android.gms.internal.ads.zzbbx.zzb(r3)     // Catch:{ all -> 0x0155 }
            long r3 = (long) r3     // Catch:{ all -> 0x0155 }
            com.google.android.gms.internal.ads.zzbdx r5 = com.google.android.gms.internal.ads.zzbef.zzf     // Catch:{ all -> 0x0155 }
            java.lang.Object r5 = r5.zze()     // Catch:{ all -> 0x0155 }
            java.lang.Long r5 = (java.lang.Long) r5     // Catch:{ all -> 0x0155 }
            long r5 = r5.longValue()     // Catch:{ all -> 0x0155 }
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 < 0) goto L_0x00db
            r10.zzj = r2     // Catch:{ all -> 0x0155 }
            r10.zzd = r2     // Catch:{ all -> 0x0155 }
            r10.zza = r11     // Catch:{ all -> 0x015e }
            android.os.ConditionVariable r11 = r10.zzc     // Catch:{ all -> 0x015e }
            r11.open()     // Catch:{ all -> 0x015e }
            goto L_0x00a1
        L_0x00db:
            android.content.Context r3 = r10.zzg     // Catch:{ all -> 0x0155 }
            com.google.android.gms.internal.ads.zzbdx r4 = com.google.android.gms.internal.ads.zzben.zzh     // Catch:{ all -> 0x0155 }
            java.lang.Object r4 = r4.zze()     // Catch:{ all -> 0x0155 }
            java.lang.Boolean r4 = (java.lang.Boolean) r4     // Catch:{ all -> 0x0155 }
            boolean r4 = r4.booleanValue()     // Catch:{ all -> 0x0155 }
            if (r4 == 0) goto L_0x00ec
            goto L_0x011a
        L_0x00ec:
            com.google.android.gms.internal.ads.zzbdx r4 = com.google.android.gms.internal.ads.zzben.zzi     // Catch:{ all -> 0x0155 }
            java.lang.Object r4 = r4.zze()     // Catch:{ all -> 0x0155 }
            java.lang.Boolean r4 = (java.lang.Boolean) r4     // Catch:{ all -> 0x0155 }
            boolean r4 = r4.booleanValue()     // Catch:{ all -> 0x0155 }
            if (r4 == 0) goto L_0x011c
            java.lang.String r4 = "admob"
            android.content.SharedPreferences r3 = r3.getSharedPreferences(r4, r11)     // Catch:{ all -> 0x0155 }
            if (r3 == 0) goto L_0x011c
            com.google.android.gms.internal.ads.zzbch r4 = new com.google.android.gms.internal.ads.zzbch     // Catch:{ all -> 0x0155 }
            r4.<init>(r3)     // Catch:{ all -> 0x0155 }
            java.lang.Object r3 = com.google.android.gms.internal.ads.zzbcp.zza(r4)     // Catch:{ all -> 0x0155 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x0155 }
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ JSONException -> 0x011c }
            r4.<init>(r3)     // Catch:{ JSONException -> 0x011c }
            java.lang.String r3 = "local_flags_enabled"
            boolean r3 = r4.optBoolean(r3)     // Catch:{ JSONException -> 0x011c }
            if (r3 == 0) goto L_0x011c
        L_0x011a:
            android.content.Context r1 = r10.zzg     // Catch:{ all -> 0x0155 }
        L_0x011c:
            if (r1 != 0) goto L_0x0127
            r10.zza = r11     // Catch:{ all -> 0x015e }
            android.os.ConditionVariable r11 = r10.zzc     // Catch:{ all -> 0x015e }
            r11.open()     // Catch:{ all -> 0x015e }
            goto L_0x00a1
        L_0x0127:
            com.google.android.gms.ads.internal.client.zzbe.zzb()     // Catch:{ all -> 0x0155 }
            android.content.SharedPreferences r1 = com.google.android.gms.internal.ads.zzbcg.zza(r1)     // Catch:{ all -> 0x0155 }
            r10.zze = r1     // Catch:{ all -> 0x0155 }
            com.google.android.gms.internal.ads.zzbdx r1 = com.google.android.gms.internal.ads.zzben.zza     // Catch:{ all -> 0x0155 }
            java.lang.Object r1 = r1.zze()     // Catch:{ all -> 0x0155 }
            java.lang.Boolean r1 = (java.lang.Boolean) r1     // Catch:{ all -> 0x0155 }
            boolean r1 = r1.booleanValue()     // Catch:{ all -> 0x0155 }
            if (r1 != 0) goto L_0x0145
            android.content.SharedPreferences r1 = r10.zze     // Catch:{ all -> 0x0155 }
            if (r1 == 0) goto L_0x0145
            r1.registerOnSharedPreferenceChangeListener(r10)     // Catch:{ all -> 0x0155 }
        L_0x0145:
            android.content.SharedPreferences r1 = r10.zze     // Catch:{ all -> 0x0155 }
            r10.zzg(r1)     // Catch:{ all -> 0x0155 }
            r10.zzd = r2     // Catch:{ all -> 0x0155 }
            r10.zza = r11     // Catch:{ all -> 0x015e }
            android.os.ConditionVariable r11 = r10.zzc     // Catch:{ all -> 0x015e }
            r11.open()     // Catch:{ all -> 0x015e }
            monitor-exit(r0)     // Catch:{ all -> 0x015e }
        L_0x0154:
            return
        L_0x0155:
            r1 = move-exception
            r10.zza = r11     // Catch:{ all -> 0x015e }
            android.os.ConditionVariable r11 = r10.zzc     // Catch:{ all -> 0x015e }
            r11.open()     // Catch:{ all -> 0x015e }
            throw r1     // Catch:{ all -> 0x015e }
        L_0x015e:
            r11 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x015e }
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbcl.zzd(android.content.Context):void");
    }

    public final boolean zze() {
        return this.zzj;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzf() {
        return this.zzi;
    }

    public final Object zzb(zzbce zzbce) {
        if (this.zzd || this.zza) {
            return zza(zzbce);
        }
        return zzbce.zzk();
    }
}
