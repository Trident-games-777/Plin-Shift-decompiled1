package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import kotlinx.coroutines.DebugKt;
import org.checkerframework.dataflow.qual.Pure;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.1.2 */
public final class zzlj extends zzh {
    protected zzlk zza;
    private volatile zzlk zzb;
    private volatile zzlk zzc;
    private final Map<Integer, zzlk> zzd = new ConcurrentHashMap();
    private Activity zze;
    private volatile boolean zzf;
    private volatile zzlk zzg;
    /* access modifiers changed from: private */
    public zzlk zzh;
    private boolean zzi;
    private final Object zzj = new Object();

    @Pure
    public final /* bridge */ /* synthetic */ Context zza() {
        return super.zza();
    }

    /* access modifiers changed from: protected */
    public final boolean zzz() {
        return false;
    }

    @Pure
    public final /* bridge */ /* synthetic */ Clock zzb() {
        return super.zzb();
    }

    public final /* bridge */ /* synthetic */ zzb zzc() {
        return super.zzc();
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

    private final zzlk zzd(Activity activity) {
        Preconditions.checkNotNull(activity);
        zzlk zzlk = this.zzd.get(Integer.valueOf(activity.hashCode()));
        if (zzlk == null) {
            zzlk zzlk2 = new zzlk((String) null, zza(activity.getClass(), "Activity"), zzq().zzn());
            this.zzd.put(Integer.valueOf(activity.hashCode()), zzlk2);
            zzlk = zzlk2;
        }
        return this.zzg != null ? this.zzg : zzlk;
    }

    public final zzlk zzaa() {
        return this.zzb;
    }

    public final zzlk zza(boolean z) {
        zzu();
        zzt();
        if (!z) {
            return this.zza;
        }
        zzlk zzlk = this.zza;
        return zzlk != null ? zzlk : this.zzh;
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

    private final String zza(Class<?> cls, String str) {
        String str2;
        String canonicalName = cls.getCanonicalName();
        if (canonicalName == null) {
            return str;
        }
        String[] split = canonicalName.split("\\.");
        if (split.length > 0) {
            str2 = split[split.length - 1];
        } else {
            str2 = "";
        }
        return str2.length() > zze().zza((String) null, false) ? str2.substring(0, zze().zza((String) null, false)) : str2;
    }

    static /* synthetic */ void zza(zzlj zzlj, Bundle bundle, zzlk zzlk, zzlk zzlk2, long j) {
        if (bundle != null) {
            bundle.remove(FirebaseAnalytics.Param.SCREEN_NAME);
            bundle.remove(FirebaseAnalytics.Param.SCREEN_CLASS);
        }
        zzlj.zza(zzlk, zzlk2, j, true, zzlj.zzq().zza((String) null, FirebaseAnalytics.Event.SCREEN_VIEW, bundle, (List<String>) null, false));
    }

    public zzlj(zzhy zzhy) {
        super(zzhy);
    }

    private final void zza(Activity activity, zzlk zzlk, boolean z) {
        zzlk zzlk2;
        zzlk zzlk3 = this.zzb == null ? this.zzc : this.zzb;
        if (zzlk.zzb == null) {
            zzlk2 = new zzlk(zzlk.zza, activity != null ? zza(activity.getClass(), "Activity") : null, zzlk.zzc, zzlk.zze, zzlk.zzf);
        } else {
            zzlk2 = zzlk;
        }
        this.zzc = this.zzb;
        this.zzb = zzlk2;
        zzl().zzb((Runnable) new zzll(this, zzlk2, zzlk3, zzb().elapsedRealtime(), z));
    }

    /* access modifiers changed from: private */
    public final void zza(zzlk zzlk, zzlk zzlk2, long j, boolean z, Bundle bundle) {
        Bundle bundle2;
        String str;
        zzlk zzlk3 = zzlk;
        zzlk zzlk4 = zzlk2;
        long j2 = j;
        Bundle bundle3 = bundle;
        zzt();
        boolean z2 = false;
        boolean z3 = zzlk4 == null || zzlk4.zzc != zzlk3.zzc || !Objects.equals(zzlk4.zzb, zzlk3.zzb) || !Objects.equals(zzlk4.zza, zzlk3.zza);
        if (z && this.zza != null) {
            z2 = true;
        }
        if (z3) {
            if (bundle3 == null) {
                bundle2 = new Bundle();
            }
            Bundle bundle4 = bundle2;
            zzos.zza(zzlk, bundle4, true);
            if (zzlk4 != null) {
                if (zzlk4.zza != null) {
                    bundle4.putString("_pn", zzlk4.zza);
                }
                if (zzlk4.zzb != null) {
                    bundle4.putString("_pc", zzlk4.zzb);
                }
                bundle4.putLong("_pi", zzlk4.zzc);
            }
            if (z2) {
                long zza2 = zzp().zzb.zza(j2);
                if (zza2 > 0) {
                    zzq().zza(bundle4, zza2);
                }
            }
            if (!zze().zzw()) {
                bundle4.putLong("_mst", 1);
            }
            if (zzlk3.zze) {
                str = "app";
            } else {
                str = DebugKt.DEBUG_PROPERTY_VALUE_AUTO;
            }
            String str2 = str;
            long currentTimeMillis = zzb().currentTimeMillis();
            if (zzlk3.zze && zzlk3.zzf != 0) {
                currentTimeMillis = zzlk3.zzf;
            }
            zzm().zza(str2, "_vs", currentTimeMillis, bundle4);
        }
        if (z2) {
            zza(this.zza, true, j2);
        }
        this.zza = zzlk3;
        if (zzlk3.zze) {
            this.zzh = zzlk3;
        }
        zzo().zza(zzlk);
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

    public final void zza(Activity activity, Bundle bundle) {
        Bundle bundle2;
        if (zze().zzw() && bundle != null && (bundle2 = bundle.getBundle("com.google.app_measurement.screen_service")) != null) {
            this.zzd.put(Integer.valueOf(activity.hashCode()), new zzlk(bundle2.getString("name"), bundle2.getString("referrer_name"), bundle2.getLong("id")));
        }
    }

    public final void zza(Activity activity) {
        synchronized (this.zzj) {
            if (activity == this.zze) {
                this.zze = null;
            }
        }
        if (zze().zzw()) {
            this.zzd.remove(Integer.valueOf(activity.hashCode()));
        }
    }

    public final void zzb(Activity activity) {
        synchronized (this.zzj) {
            this.zzi = false;
            this.zzf = true;
        }
        long elapsedRealtime = zzb().elapsedRealtime();
        if (!zze().zzw()) {
            this.zzb = null;
            zzl().zzb((Runnable) new zzln(this, elapsedRealtime));
            return;
        }
        zzlk zzd2 = zzd(activity);
        this.zzc = this.zzb;
        this.zzb = null;
        zzl().zzb((Runnable) new zzlq(this, zzd2, elapsedRealtime));
    }

    public final void zzc(Activity activity) {
        synchronized (this.zzj) {
            this.zzi = true;
            if (activity != this.zze) {
                synchronized (this.zzj) {
                    this.zze = activity;
                    this.zzf = false;
                }
                if (zze().zzw()) {
                    this.zzg = null;
                    zzl().zzb((Runnable) new zzlp(this));
                }
            }
        }
        if (!zze().zzw()) {
            this.zzb = this.zzg;
            zzl().zzb((Runnable) new zzlo(this));
            return;
        }
        zza(activity, zzd(activity), false);
        zzb zzc2 = zzc();
        zzc2.zzl().zzb((Runnable) new zzc(zzc2, zzc2.zzb().elapsedRealtime()));
    }

    public final void zzb(Activity activity, Bundle bundle) {
        zzlk zzlk;
        if (zze().zzw() && bundle != null && (zzlk = this.zzd.get(Integer.valueOf(activity.hashCode()))) != null) {
            Bundle bundle2 = new Bundle();
            bundle2.putLong("id", zzlk.zzc);
            bundle2.putString("name", zzlk.zza);
            bundle2.putString("referrer_name", zzlk.zzb);
            bundle.putBundle("com.google.app_measurement.screen_service", bundle2);
        }
    }

    /* access modifiers changed from: private */
    public final void zza(zzlk zzlk, boolean z, long j) {
        zzc().zza(zzb().elapsedRealtime());
        if (zzp().zza(zzlk != null && zzlk.zzd, z, j) && zzlk != null) {
            zzlk.zzd = false;
        }
    }

    @Deprecated
    public final void zza(Activity activity, String str, String str2) {
        if (!zze().zzw()) {
            zzj().zzv().zza("setCurrentScreen cannot be called while screen reporting is disabled.");
            return;
        }
        zzlk zzlk = this.zzb;
        if (zzlk == null) {
            zzj().zzv().zza("setCurrentScreen cannot be called while no activity active");
        } else if (this.zzd.get(Integer.valueOf(activity.hashCode())) == null) {
            zzj().zzv().zza("setCurrentScreen must be called with an activity in the activity lifecycle");
        } else {
            if (str2 == null) {
                str2 = zza(activity.getClass(), "Activity");
            }
            boolean equals = Objects.equals(zzlk.zzb, str2);
            boolean equals2 = Objects.equals(zzlk.zza, str);
            if (equals && equals2) {
                zzj().zzv().zza("setCurrentScreen cannot be called with the same class and name");
            } else if (str != null && (str.length() <= 0 || str.length() > zze().zza((String) null, false))) {
                zzj().zzv().zza("Invalid screen name length in setCurrentScreen. Length", Integer.valueOf(str.length()));
            } else if (str2 == null || (str2.length() > 0 && str2.length() <= zze().zza((String) null, false))) {
                zzj().zzp().zza("Setting current screen to name, class", str == null ? "null" : str, str2);
                zzlk zzlk2 = new zzlk(str, str2, zzq().zzn());
                this.zzd.put(Integer.valueOf(activity.hashCode()), zzlk2);
                zza(activity, zzlk2, true);
            } else {
                zzj().zzv().zza("Invalid class name length in setCurrentScreen. Length", Integer.valueOf(str2.length()));
            }
        }
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00c2, code lost:
        r0 = zzj().zzp();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00cc, code lost:
        if (r4 != null) goto L_0x00d1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00ce, code lost:
        r2 = "null";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00d1, code lost:
        r2 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00d2, code lost:
        if (r5 != null) goto L_0x00d7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00d4, code lost:
        r3 = "null";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00d7, code lost:
        r3 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00d8, code lost:
        r0.zza("Logging screen view with name, class", r2, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00dd, code lost:
        if (r13.zzb != null) goto L_0x00e2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00df, code lost:
        r0 = r13.zzc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00e2, code lost:
        r0 = r13.zzb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00e4, code lost:
        r3 = new com.google.android.gms.measurement.internal.zzlk(r4, r5, zzq().zzn(), true, r15);
        r13.zzb = r3;
        r13.zzc = r0;
        r13.zzg = r3;
        zzl().zzb((java.lang.Runnable) new com.google.android.gms.measurement.internal.zzlm(r13, r14, r3, r0, zzb().elapsedRealtime()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0111, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(android.os.Bundle r14, long r15) {
        /*
            r13 = this;
            java.lang.Object r1 = r13.zzj
            monitor-enter(r1)
            boolean r0 = r13.zzi     // Catch:{ all -> 0x0112 }
            if (r0 != 0) goto L_0x0016
            com.google.android.gms.measurement.internal.zzgo r14 = r13.zzj()     // Catch:{ all -> 0x0112 }
            com.google.android.gms.measurement.internal.zzgq r14 = r14.zzv()     // Catch:{ all -> 0x0112 }
            java.lang.String r0 = "Cannot log screen view event when the app is in the background."
            r14.zza(r0)     // Catch:{ all -> 0x0112 }
            monitor-exit(r1)     // Catch:{ all -> 0x0112 }
            return
        L_0x0016:
            r0 = 0
            r2 = 0
            if (r14 == 0) goto L_0x0083
            java.lang.String r3 = "screen_name"
            java.lang.String r3 = r14.getString(r3)     // Catch:{ all -> 0x0112 }
            if (r3 == 0) goto L_0x004d
            int r4 = r3.length()     // Catch:{ all -> 0x0112 }
            if (r4 <= 0) goto L_0x0036
            int r4 = r3.length()     // Catch:{ all -> 0x0112 }
            com.google.android.gms.measurement.internal.zzag r5 = r13.zze()     // Catch:{ all -> 0x0112 }
            int r5 = r5.zza((java.lang.String) r2, (boolean) r0)     // Catch:{ all -> 0x0112 }
            if (r4 <= r5) goto L_0x004d
        L_0x0036:
            com.google.android.gms.measurement.internal.zzgo r14 = r13.zzj()     // Catch:{ all -> 0x0112 }
            com.google.android.gms.measurement.internal.zzgq r14 = r14.zzv()     // Catch:{ all -> 0x0112 }
            java.lang.String r0 = "Invalid screen name length for screen view. Length"
            int r2 = r3.length()     // Catch:{ all -> 0x0112 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x0112 }
            r14.zza(r0, r2)     // Catch:{ all -> 0x0112 }
            monitor-exit(r1)     // Catch:{ all -> 0x0112 }
            return
        L_0x004d:
            java.lang.String r4 = "screen_class"
            java.lang.String r4 = r14.getString(r4)     // Catch:{ all -> 0x0112 }
            if (r4 == 0) goto L_0x0080
            int r5 = r4.length()     // Catch:{ all -> 0x0112 }
            if (r5 <= 0) goto L_0x0069
            int r5 = r4.length()     // Catch:{ all -> 0x0112 }
            com.google.android.gms.measurement.internal.zzag r6 = r13.zze()     // Catch:{ all -> 0x0112 }
            int r2 = r6.zza((java.lang.String) r2, (boolean) r0)     // Catch:{ all -> 0x0112 }
            if (r5 <= r2) goto L_0x0080
        L_0x0069:
            com.google.android.gms.measurement.internal.zzgo r14 = r13.zzj()     // Catch:{ all -> 0x0112 }
            com.google.android.gms.measurement.internal.zzgq r14 = r14.zzv()     // Catch:{ all -> 0x0112 }
            java.lang.String r0 = "Invalid screen class length for screen view. Length"
            int r2 = r4.length()     // Catch:{ all -> 0x0112 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x0112 }
            r14.zza(r0, r2)     // Catch:{ all -> 0x0112 }
            monitor-exit(r1)     // Catch:{ all -> 0x0112 }
            return
        L_0x0080:
            r2 = r4
            r4 = r3
            goto L_0x0084
        L_0x0083:
            r4 = r2
        L_0x0084:
            if (r2 != 0) goto L_0x0097
            android.app.Activity r2 = r13.zze     // Catch:{ all -> 0x0112 }
            if (r2 == 0) goto L_0x0095
            java.lang.Class r2 = r2.getClass()     // Catch:{ all -> 0x0112 }
            java.lang.String r3 = "Activity"
            java.lang.String r2 = r13.zza((java.lang.Class<?>) r2, (java.lang.String) r3)     // Catch:{ all -> 0x0112 }
            goto L_0x0097
        L_0x0095:
            java.lang.String r2 = "Activity"
        L_0x0097:
            r5 = r2
            com.google.android.gms.measurement.internal.zzlk r2 = r13.zzb     // Catch:{ all -> 0x0112 }
            boolean r3 = r13.zzf     // Catch:{ all -> 0x0112 }
            if (r3 == 0) goto L_0x00c1
            if (r2 == 0) goto L_0x00c1
            r13.zzf = r0     // Catch:{ all -> 0x0112 }
            java.lang.String r0 = r2.zzb     // Catch:{ all -> 0x0112 }
            boolean r0 = java.util.Objects.equals(r0, r5)     // Catch:{ all -> 0x0112 }
            java.lang.String r2 = r2.zza     // Catch:{ all -> 0x0112 }
            boolean r2 = java.util.Objects.equals(r2, r4)     // Catch:{ all -> 0x0112 }
            if (r0 == 0) goto L_0x00c1
            if (r2 == 0) goto L_0x00c1
            com.google.android.gms.measurement.internal.zzgo r14 = r13.zzj()     // Catch:{ all -> 0x0112 }
            com.google.android.gms.measurement.internal.zzgq r14 = r14.zzv()     // Catch:{ all -> 0x0112 }
            java.lang.String r0 = "Ignoring call to log screen view event with duplicate parameters."
            r14.zza(r0)     // Catch:{ all -> 0x0112 }
            monitor-exit(r1)     // Catch:{ all -> 0x0112 }
            return
        L_0x00c1:
            monitor-exit(r1)     // Catch:{ all -> 0x0112 }
            com.google.android.gms.measurement.internal.zzgo r0 = r13.zzj()
            com.google.android.gms.measurement.internal.zzgq r0 = r0.zzp()
            java.lang.String r1 = "Logging screen view with name, class"
            if (r4 != 0) goto L_0x00d1
            java.lang.String r2 = "null"
            goto L_0x00d2
        L_0x00d1:
            r2 = r4
        L_0x00d2:
            if (r5 != 0) goto L_0x00d7
            java.lang.String r3 = "null"
            goto L_0x00d8
        L_0x00d7:
            r3 = r5
        L_0x00d8:
            r0.zza(r1, r2, r3)
            com.google.android.gms.measurement.internal.zzlk r0 = r13.zzb
            if (r0 != 0) goto L_0x00e2
            com.google.android.gms.measurement.internal.zzlk r0 = r13.zzc
            goto L_0x00e4
        L_0x00e2:
            com.google.android.gms.measurement.internal.zzlk r0 = r13.zzb
        L_0x00e4:
            com.google.android.gms.measurement.internal.zzlk r3 = new com.google.android.gms.measurement.internal.zzlk
            com.google.android.gms.measurement.internal.zzos r1 = r13.zzq()
            long r6 = r1.zzn()
            r8 = 1
            r9 = r15
            r3.<init>(r4, r5, r6, r8, r9)
            r13.zzb = r3
            r13.zzc = r0
            r13.zzg = r3
            com.google.android.gms.common.util.Clock r1 = r13.zzb()
            long r11 = r1.elapsedRealtime()
            com.google.android.gms.measurement.internal.zzhv r1 = r13.zzl()
            com.google.android.gms.measurement.internal.zzlm r6 = new com.google.android.gms.measurement.internal.zzlm
            r7 = r13
            r8 = r14
            r10 = r0
            r9 = r3
            r6.<init>(r7, r8, r9, r10, r11)
            r1.zzb((java.lang.Runnable) r6)
            return
        L_0x0112:
            r0 = move-exception
            r14 = r0
            monitor-exit(r1)     // Catch:{ all -> 0x0112 }
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzlj.zza(android.os.Bundle, long):void");
    }
}
