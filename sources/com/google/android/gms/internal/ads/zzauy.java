package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.ads.internal.client.zzbe;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public abstract class zzauy implements zzaux {
    protected static volatile zzawf zza;
    protected MotionEvent zzb;
    protected final LinkedList zzc = new LinkedList();
    protected long zzd = 0;
    protected long zze = 0;
    protected long zzf = 0;
    protected long zzg = 0;
    protected long zzh = 0;
    protected long zzi = 0;
    protected long zzj = 0;
    protected double zzk;
    protected float zzl;
    protected float zzm;
    protected float zzn;
    protected float zzo;
    protected boolean zzp = false;
    protected DisplayMetrics zzq;
    protected zzavx zzr;
    private double zzs;
    private double zzt;
    private boolean zzu = false;

    protected zzauy(Context context) {
        try {
            zzaua.zze();
            this.zzq = context.getResources().getDisplayMetrics();
            if (((Boolean) zzbe.zzc().zza(zzbcn.zzcS)).booleanValue()) {
                this.zzr = new zzavx();
            }
        } catch (Throwable unused) {
        }
    }

    private final void zzm() {
        this.zzh = 0;
        this.zzd = 0;
        this.zze = 0;
        this.zzf = 0;
        this.zzg = 0;
        this.zzi = 0;
        this.zzj = 0;
        if (!this.zzc.isEmpty()) {
            Iterator it = this.zzc.iterator();
            while (it.hasNext()) {
                ((MotionEvent) it.next()).recycle();
            }
            this.zzc.clear();
        } else {
            MotionEvent motionEvent = this.zzb;
            if (motionEvent != null) {
                motionEvent.recycle();
            }
        }
        this.zzb = null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0099 A[SYNTHETIC, Splitter:B:44:0x0099] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.String zzp(android.content.Context r19, java.lang.String r20, int r21, android.view.View r22, android.app.Activity r23, byte[] r24) {
        /*
            r18 = this;
            r1 = r18
            r0 = r19
            r2 = r21
            r3 = r22
            r4 = r23
            long r5 = java.lang.System.currentTimeMillis()
            com.google.android.gms.internal.ads.zzbce r7 = com.google.android.gms.internal.ads.zzbcn.zzcF
            com.google.android.gms.internal.ads.zzbcl r8 = com.google.android.gms.ads.internal.client.zzbe.zzc()
            java.lang.Object r7 = r8.zza(r7)
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            r8 = 0
            if (r7 == 0) goto L_0x0033
            com.google.android.gms.internal.ads.zzawf r9 = zza
            if (r9 == 0) goto L_0x002c
            com.google.android.gms.internal.ads.zzawf r9 = zza
            com.google.android.gms.internal.ads.zzauw r9 = r9.zzd()
            goto L_0x002d
        L_0x002c:
            r9 = r8
        L_0x002d:
            java.lang.String r10 = "be"
            r11 = r9
            r16 = r10
            goto L_0x0036
        L_0x0033:
            r11 = r8
            r16 = r11
        L_0x0036:
            r9 = 1
            r10 = 2
            r12 = 3
            if (r2 != r12) goto L_0x004c
            com.google.android.gms.internal.ads.zzasf r8 = r1.zzb(r0, r3, r4)     // Catch:{ Exception -> 0x0049 }
            r1.zzu = r9     // Catch:{ Exception -> 0x0044 }
            r0 = 1002(0x3ea, float:1.404E-42)
            goto L_0x005d
        L_0x0044:
            r0 = move-exception
            r17 = r0
            r3 = r12
            goto L_0x0076
        L_0x0049:
            r0 = move-exception
            r3 = r12
            goto L_0x0074
        L_0x004c:
            if (r2 != r10) goto L_0x0055
            com.google.android.gms.internal.ads.zzasf r0 = r1.zzi(r0, r3, r4)     // Catch:{ Exception -> 0x0049 }
            r3 = 1008(0x3f0, float:1.413E-42)
            goto L_0x005b
        L_0x0055:
            com.google.android.gms.internal.ads.zzasf r0 = r1.zzc(r0, r8)     // Catch:{ Exception -> 0x0049 }
            r3 = 1000(0x3e8, float:1.401E-42)
        L_0x005b:
            r8 = r0
            r0 = r3
        L_0x005d:
            if (r7 == 0) goto L_0x0072
            if (r11 == 0) goto L_0x0072
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0049 }
            long r14 = r3 - r5
            r13 = -1
            r17 = 0
            r3 = r12
            r12 = r0
            r11.zzc(r12, r13, r14, r16, r17)     // Catch:{ Exception -> 0x0070 }
            goto L_0x0093
        L_0x0070:
            r0 = move-exception
            goto L_0x0074
        L_0x0072:
            r3 = r12
            goto L_0x0093
        L_0x0074:
            r17 = r0
        L_0x0076:
            if (r7 == 0) goto L_0x0093
            if (r11 == 0) goto L_0x0093
            if (r2 != r3) goto L_0x0080
            r0 = 1003(0x3eb, float:1.406E-42)
        L_0x007e:
            r12 = r0
            goto L_0x0089
        L_0x0080:
            if (r2 != r10) goto L_0x0085
            r0 = 1009(0x3f1, float:1.414E-42)
            goto L_0x007e
        L_0x0085:
            r0 = 1001(0x3e9, float:1.403E-42)
            r12 = r0
            r2 = r9
        L_0x0089:
            long r13 = java.lang.System.currentTimeMillis()
            long r14 = r13 - r5
            r13 = -1
            r11.zzc(r12, r13, r14, r16, r17)
        L_0x0093:
            long r4 = java.lang.System.currentTimeMillis()
            if (r8 == 0) goto L_0x00d7
            com.google.android.gms.internal.ads.zzgyx r0 = r8.zzbr()     // Catch:{ Exception -> 0x00dd }
            com.google.android.gms.internal.ads.zzata r0 = (com.google.android.gms.internal.ads.zzata) r0     // Catch:{ Exception -> 0x00dd }
            int r0 = r0.zzaY()     // Catch:{ Exception -> 0x00dd }
            if (r0 != 0) goto L_0x00a6
            goto L_0x00d7
        L_0x00a6:
            com.google.android.gms.internal.ads.zzgyx r0 = r8.zzbr()     // Catch:{ Exception -> 0x00dd }
            com.google.android.gms.internal.ads.zzata r0 = (com.google.android.gms.internal.ads.zzata) r0     // Catch:{ Exception -> 0x00dd }
            int r6 = com.google.android.gms.internal.ads.zzaua.zzc     // Catch:{ Exception -> 0x00dd }
            byte[] r0 = r0.zzaV()     // Catch:{ Exception -> 0x00dd }
            r6 = r20
            java.lang.String r0 = com.google.android.gms.internal.ads.zzaua.zzb(r0, r6)     // Catch:{ Exception -> 0x00dd }
            if (r7 == 0) goto L_0x0101
            if (r11 == 0) goto L_0x0101
            if (r2 != r3) goto L_0x00c2
            r6 = 1006(0x3ee, float:1.41E-42)
        L_0x00c0:
            r12 = r6
            goto L_0x00ca
        L_0x00c2:
            if (r2 != r10) goto L_0x00c7
            r6 = 1010(0x3f2, float:1.415E-42)
            goto L_0x00c0
        L_0x00c7:
            r6 = 1004(0x3ec, float:1.407E-42)
            goto L_0x00c0
        L_0x00ca:
            long r8 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x00dd }
            long r14 = r8 - r4
            r13 = -1
            r17 = 0
            r11.zzc(r12, r13, r14, r16, r17)     // Catch:{ Exception -> 0x00dd }
            goto L_0x0101
        L_0x00d7:
            r0 = 5
            java.lang.String r0 = java.lang.Integer.toString(r0)     // Catch:{ Exception -> 0x00dd }
            goto L_0x0101
        L_0x00dd:
            r0 = move-exception
            r17 = r0
            r0 = 7
            java.lang.String r0 = java.lang.Integer.toString(r0)
            if (r7 == 0) goto L_0x0101
            if (r11 == 0) goto L_0x0101
            if (r2 != r3) goto L_0x00ef
            r2 = 1007(0x3ef, float:1.411E-42)
        L_0x00ed:
            r12 = r2
            goto L_0x00f7
        L_0x00ef:
            if (r2 != r10) goto L_0x00f4
            r2 = 1011(0x3f3, float:1.417E-42)
            goto L_0x00ed
        L_0x00f4:
            r2 = 1005(0x3ed, float:1.408E-42)
            goto L_0x00ed
        L_0x00f7:
            long r2 = java.lang.System.currentTimeMillis()
            long r14 = r2 - r4
            r13 = -1
            r11.zzc(r12, r13, r14, r16, r17)
        L_0x0101:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzauy.zzp(android.content.Context, java.lang.String, int, android.view.View, android.app.Activity, byte[]):java.lang.String");
    }

    /* access modifiers changed from: protected */
    public abstract long zza(StackTraceElement[] stackTraceElementArr) throws zzavv;

    /* access modifiers changed from: protected */
    public abstract zzasf zzb(Context context, View view, Activity activity);

    /* access modifiers changed from: protected */
    public abstract zzasf zzc(Context context, zzars zzars);

    public final String zzd(Context context, String str, View view) {
        return zzp(context, str, 3, view, (Activity) null, (byte[]) null);
    }

    public final String zze(Context context, String str, View view, Activity activity) {
        return zzp(context, str, 3, view, activity, (byte[]) null);
    }

    public final String zzf(Context context) {
        if (!zzawi.zzc()) {
            return zzp(context, (String) null, 1, (View) null, (Activity) null, (byte[]) null);
        }
        throw new IllegalStateException("The caller must not be called from the UI thread.");
    }

    public final String zzg(Context context) {
        return "19";
    }

    public final String zzh(Context context, View view, Activity activity) {
        return zzp(context, (String) null, 2, view, activity, (byte[]) null);
    }

    /* access modifiers changed from: protected */
    public abstract zzasf zzi(Context context, View view, Activity activity);

    /* access modifiers changed from: protected */
    public abstract zzawh zzj(MotionEvent motionEvent) throws zzavv;

    public final synchronized void zzk(MotionEvent motionEvent) {
        Long l;
        if (this.zzu) {
            zzm();
            this.zzu = false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.zzk = 0.0d;
            this.zzs = (double) motionEvent.getRawX();
            this.zzt = (double) motionEvent.getRawY();
        } else if (action == 1 || action == 2) {
            double rawX = (double) motionEvent.getRawX();
            double rawY = (double) motionEvent.getRawY();
            double d = rawX - this.zzs;
            double d2 = rawY - this.zzt;
            this.zzk += Math.sqrt((d * d) + (d2 * d2));
            this.zzs = rawX;
            this.zzt = rawY;
        }
        int action2 = motionEvent.getAction();
        if (action2 == 0) {
            this.zzl = motionEvent.getX();
            this.zzm = motionEvent.getY();
            this.zzn = motionEvent.getRawX();
            this.zzo = motionEvent.getRawY();
            this.zzd++;
        } else if (action2 == 1) {
            MotionEvent obtain = MotionEvent.obtain(motionEvent);
            this.zzb = obtain;
            this.zzc.add(obtain);
            if (this.zzc.size() > 6) {
                ((MotionEvent) this.zzc.remove()).recycle();
            }
            this.zzf++;
            this.zzh = zza(new Throwable().getStackTrace());
        } else if (action2 == 2) {
            this.zze += (long) (motionEvent.getHistorySize() + 1);
            try {
                zzawh zzj2 = zzj(motionEvent);
                Long l2 = zzj2.zzd;
                if (!(l2 == null || zzj2.zzg == null)) {
                    this.zzi += l2.longValue() + zzj2.zzg.longValue();
                }
                if (!(this.zzq == null || (l = zzj2.zze) == null || zzj2.zzh == null)) {
                    this.zzj += l.longValue() + zzj2.zzh.longValue();
                }
            } catch (zzavv unused) {
            }
        } else if (action2 == 3) {
            this.zzg++;
        }
        this.zzp = true;
    }

    public final synchronized void zzl(int i, int i2, int i3) {
        synchronized (this) {
            if (this.zzb != null) {
                if (((Boolean) zzbe.zzc().zza(zzbcn.zzcD)).booleanValue()) {
                    zzm();
                } else {
                    this.zzb.recycle();
                }
            }
            DisplayMetrics displayMetrics = this.zzq;
            if (displayMetrics != null) {
                this.zzb = MotionEvent.obtain(0, (long) i3, 1, ((float) i) * displayMetrics.density, ((float) i2) * this.zzq.density, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
            } else {
                this.zzb = null;
            }
            this.zzp = false;
        }
    }

    public final void zzn(StackTraceElement[] stackTraceElementArr) {
        zzavx zzavx;
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzcS)).booleanValue() && (zzavx = this.zzr) != null) {
            zzavx.zzb(Arrays.asList(stackTraceElementArr));
        }
    }

    public void zzo(View view) {
    }
}
