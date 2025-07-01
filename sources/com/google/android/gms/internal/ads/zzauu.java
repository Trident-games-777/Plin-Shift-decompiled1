package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.ads.internal.client.zzbe;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzauu implements zzaux {
    private static zzauu zzb;
    volatile long zza = 0;
    private final Context zzc;
    private final zzfre zzd;
    private final zzfrl zze;
    private final zzfrn zzf;
    private final zzavz zzg;
    /* access modifiers changed from: private */
    public final zzfpp zzh;
    private final Executor zzi;
    private final zzfrk zzj;
    private final CountDownLatch zzk;
    private final zzawo zzl;
    private final zzawg zzm;
    private final zzavx zzn;
    /* access modifiers changed from: private */
    public final Object zzo = new Object();
    /* access modifiers changed from: private */
    public volatile boolean zzp;
    private volatile boolean zzq = false;
    private final int zzr;

    zzauu(Context context, zzfpp zzfpp, zzfre zzfre, zzfrl zzfrl, zzfrn zzfrn, zzavz zzavz, Executor executor, zzfpk zzfpk, int i, zzawo zzawo, zzawg zzawg, zzavx zzavx) {
        this.zzc = context;
        this.zzh = zzfpp;
        this.zzd = zzfre;
        this.zze = zzfrl;
        this.zzf = zzfrn;
        this.zzg = zzavz;
        this.zzi = executor;
        this.zzr = i;
        this.zzl = zzawo;
        this.zzm = zzawg;
        this.zzn = zzavx;
        this.zzq = false;
        this.zzk = new CountDownLatch(1);
        this.zzj = new zzaus(this, zzfpk);
    }

    public static synchronized zzauu zza(Context context, zzarj zzarj, boolean z) {
        zzauu zzs;
        synchronized (zzauu.class) {
            zzfpq zzc2 = zzfpr.zzc();
            zzc2.zza(zzarj.zzf());
            zzc2.zzg(zzarj.zzi());
            zzs = zzs(context, Executors.newCachedThreadPool(), zzc2.zzh(), z);
        }
        return zzs;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x009a, code lost:
        if (r4.zzc().zzj().equals(r5.zzj()) != false) goto L_0x00f5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* bridge */ /* synthetic */ void zzj(com.google.android.gms.internal.ads.zzauu r12) {
        /*
            long r1 = java.lang.System.currentTimeMillis()
            r0 = 1
            com.google.android.gms.internal.ads.zzfrd r3 = r12.zzu(r0)
            if (r3 == 0) goto L_0x001e
            com.google.android.gms.internal.ads.zzayb r4 = r3.zza()
            java.lang.String r4 = r4.zzk()
            com.google.android.gms.internal.ads.zzayb r3 = r3.zza()
            java.lang.String r3 = r3.zzj()
            r9 = r3
            r8 = r4
            goto L_0x0021
        L_0x001e:
            r4 = 0
            r8 = r4
            r9 = r8
        L_0x0021:
            android.content.Context r5 = r12.zzc     // Catch:{ zzgzm -> 0x011e }
            int r7 = r12.zzr     // Catch:{ zzgzm -> 0x011e }
            java.lang.String r10 = "1"
            com.google.android.gms.internal.ads.zzfpp r11 = r12.zzh     // Catch:{ zzgzm -> 0x011e }
            r6 = 1
            com.google.android.gms.internal.ads.zzfri r3 = com.google.android.gms.internal.ads.zzfpz.zza(r5, r6, r7, r8, r9, r10, r11)     // Catch:{ zzgzm -> 0x011e }
            byte[] r4 = r3.zzb     // Catch:{ zzgzm -> 0x011e }
            if (r4 == 0) goto L_0x010f
            int r5 = r4.length     // Catch:{ zzgzm -> 0x011e }
            if (r5 != 0) goto L_0x0037
            goto L_0x010f
        L_0x0037:
            r6 = 0
            com.google.android.gms.internal.ads.zzgxp r4 = com.google.android.gms.internal.ads.zzgxp.zzv(r4, r6, r5)     // Catch:{ NullPointerException -> 0x0102 }
            com.google.android.gms.internal.ads.zzgyh r5 = com.google.android.gms.internal.ads.zzgyh.zza()     // Catch:{ NullPointerException -> 0x0102 }
            com.google.android.gms.internal.ads.zzaxy r4 = com.google.android.gms.internal.ads.zzaxy.zzb(r4, r5)     // Catch:{ NullPointerException -> 0x0102 }
            com.google.android.gms.internal.ads.zzayb r5 = r4.zzc()     // Catch:{ zzgzm -> 0x011e }
            java.lang.String r5 = r5.zzk()     // Catch:{ zzgzm -> 0x011e }
            boolean r5 = r5.isEmpty()     // Catch:{ zzgzm -> 0x011e }
            if (r5 != 0) goto L_0x00f5
            com.google.android.gms.internal.ads.zzayb r5 = r4.zzc()     // Catch:{ zzgzm -> 0x011e }
            java.lang.String r5 = r5.zzj()     // Catch:{ zzgzm -> 0x011e }
            boolean r5 = r5.isEmpty()     // Catch:{ zzgzm -> 0x011e }
            if (r5 != 0) goto L_0x00f5
            com.google.android.gms.internal.ads.zzgxp r5 = r4.zzd()     // Catch:{ zzgzm -> 0x011e }
            byte[] r5 = r5.zzA()     // Catch:{ zzgzm -> 0x011e }
            int r5 = r5.length     // Catch:{ zzgzm -> 0x011e }
            if (r5 != 0) goto L_0x006d
            goto L_0x00f5
        L_0x006d:
            com.google.android.gms.internal.ads.zzfrd r5 = r12.zzu(r0)     // Catch:{ zzgzm -> 0x011e }
            if (r5 != 0) goto L_0x0074
            goto L_0x009c
        L_0x0074:
            com.google.android.gms.internal.ads.zzayb r5 = r5.zza()     // Catch:{ zzgzm -> 0x011e }
            com.google.android.gms.internal.ads.zzayb r6 = r4.zzc()     // Catch:{ zzgzm -> 0x011e }
            java.lang.String r6 = r6.zzk()     // Catch:{ zzgzm -> 0x011e }
            java.lang.String r7 = r5.zzk()     // Catch:{ zzgzm -> 0x011e }
            boolean r6 = r6.equals(r7)     // Catch:{ zzgzm -> 0x011e }
            if (r6 == 0) goto L_0x009c
            com.google.android.gms.internal.ads.zzayb r6 = r4.zzc()     // Catch:{ zzgzm -> 0x011e }
            java.lang.String r6 = r6.zzj()     // Catch:{ zzgzm -> 0x011e }
            java.lang.String r5 = r5.zzj()     // Catch:{ zzgzm -> 0x011e }
            boolean r5 = r6.equals(r5)     // Catch:{ zzgzm -> 0x011e }
            if (r5 != 0) goto L_0x00f5
        L_0x009c:
            com.google.android.gms.internal.ads.zzfrk r5 = r12.zzj     // Catch:{ zzgzm -> 0x011e }
            int r3 = r3.zzc     // Catch:{ zzgzm -> 0x011e }
            com.google.android.gms.internal.ads.zzbce r6 = com.google.android.gms.internal.ads.zzbcn.zzct     // Catch:{ zzgzm -> 0x011e }
            com.google.android.gms.internal.ads.zzbcl r7 = com.google.android.gms.ads.internal.client.zzbe.zzc()     // Catch:{ zzgzm -> 0x011e }
            java.lang.Object r6 = r7.zza(r6)     // Catch:{ zzgzm -> 0x011e }
            java.lang.Boolean r6 = (java.lang.Boolean) r6     // Catch:{ zzgzm -> 0x011e }
            boolean r6 = r6.booleanValue()     // Catch:{ zzgzm -> 0x011e }
            if (r6 == 0) goto L_0x00c6
            r6 = 3
            if (r3 != r6) goto L_0x00bc
            com.google.android.gms.internal.ads.zzfrl r3 = r12.zze     // Catch:{ zzgzm -> 0x011e }
            boolean r3 = r3.zza(r4)     // Catch:{ zzgzm -> 0x011e }
            goto L_0x00cc
        L_0x00bc:
            r6 = 4
            if (r3 != r6) goto L_0x00ce
            com.google.android.gms.internal.ads.zzfrl r3 = r12.zze     // Catch:{ zzgzm -> 0x011e }
            boolean r3 = r3.zzb(r4, r5)     // Catch:{ zzgzm -> 0x011e }
            goto L_0x00cc
        L_0x00c6:
            com.google.android.gms.internal.ads.zzfre r3 = r12.zzd     // Catch:{ zzgzm -> 0x011e }
            boolean r3 = r3.zza(r4, r5)     // Catch:{ zzgzm -> 0x011e }
        L_0x00cc:
            if (r3 != 0) goto L_0x00db
        L_0x00ce:
            com.google.android.gms.internal.ads.zzfpp r0 = r12.zzh     // Catch:{ zzgzm -> 0x011e }
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ zzgzm -> 0x011e }
            long r3 = r3 - r1
            r5 = 4009(0xfa9, float:5.618E-42)
            r0.zzd(r5, r3)     // Catch:{ zzgzm -> 0x011e }
            goto L_0x012b
        L_0x00db:
            com.google.android.gms.internal.ads.zzfrd r3 = r12.zzu(r0)     // Catch:{ zzgzm -> 0x011e }
            if (r3 == 0) goto L_0x012b
            com.google.android.gms.internal.ads.zzfrn r4 = r12.zzf     // Catch:{ zzgzm -> 0x011e }
            boolean r3 = r4.zzc(r3)     // Catch:{ zzgzm -> 0x011e }
            if (r3 == 0) goto L_0x00eb
            r12.zzq = r0     // Catch:{ zzgzm -> 0x011e }
        L_0x00eb:
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ zzgzm -> 0x011e }
            r5 = 1000(0x3e8, double:4.94E-321)
            long r3 = r3 / r5
            r12.zza = r3     // Catch:{ zzgzm -> 0x011e }
            goto L_0x012b
        L_0x00f5:
            com.google.android.gms.internal.ads.zzfpp r0 = r12.zzh     // Catch:{ zzgzm -> 0x011e }
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ zzgzm -> 0x011e }
            long r3 = r3 - r1
            r5 = 5010(0x1392, float:7.02E-42)
            r0.zzd(r5, r3)     // Catch:{ zzgzm -> 0x011e }
            goto L_0x012b
        L_0x0102:
            com.google.android.gms.internal.ads.zzfpp r0 = r12.zzh     // Catch:{ zzgzm -> 0x011e }
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ zzgzm -> 0x011e }
            long r3 = r3 - r1
            r5 = 2030(0x7ee, float:2.845E-42)
            r0.zzd(r5, r3)     // Catch:{ zzgzm -> 0x011e }
            goto L_0x012b
        L_0x010f:
            com.google.android.gms.internal.ads.zzfpp r0 = r12.zzh     // Catch:{ zzgzm -> 0x011e }
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ zzgzm -> 0x011e }
            long r3 = r3 - r1
            r5 = 5009(0x1391, float:7.019E-42)
            r0.zzd(r5, r3)     // Catch:{ zzgzm -> 0x011e }
            goto L_0x012b
        L_0x011c:
            r0 = move-exception
            goto L_0x0131
        L_0x011e:
            r0 = move-exception
            com.google.android.gms.internal.ads.zzfpp r3 = r12.zzh     // Catch:{ all -> 0x011c }
            long r4 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x011c }
            long r4 = r4 - r1
            r1 = 4002(0xfa2, float:5.608E-42)
            r3.zzc(r1, r4, r0)     // Catch:{ all -> 0x011c }
        L_0x012b:
            java.util.concurrent.CountDownLatch r12 = r12.zzk
            r12.countDown()
            return
        L_0x0131:
            java.util.concurrent.CountDownLatch r12 = r12.zzk
            r12.countDown()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzauu.zzj(com.google.android.gms.internal.ads.zzauu):void");
    }

    private static synchronized zzauu zzs(Context context, Executor executor, zzfpr zzfpr, boolean z) {
        zzauu zzauu;
        Context context2 = context;
        Executor executor2 = executor;
        synchronized (zzauu.class) {
            if (zzb == null) {
                zzfpp zza2 = zzfpp.zza(context2, executor2, z);
                zzavx zzavx = null;
                zzavi zzc2 = ((Boolean) zzbe.zzc().zza(zzbcn.zzdv)).booleanValue() ? zzavi.zzc(context2) : null;
                zzawo zzd2 = ((Boolean) zzbe.zzc().zza(zzbcn.zzdw)).booleanValue() ? zzawo.zzd(context, executor) : null;
                zzawg zzawg = ((Boolean) zzbe.zzc().zza(zzbcn.zzcL)).booleanValue() ? new zzawg() : null;
                if (((Boolean) zzbe.zzc().zza(zzbcn.zzcS)).booleanValue()) {
                    zzavx = new zzavx();
                }
                zzfpr zzfpr2 = zzfpr;
                zzfqi zze2 = zzfqi.zze(context2, executor2, zza2, zzfpr2);
                zzavy zzavy = new zzavy(context2);
                zzavx zzavx2 = zzavx;
                zzavz zzavz = new zzavz(zzfpr2, zze2, new zzawm(context2, zzavy), zzavy, zzc2, zzd2, zzawg, zzavx2);
                int zzb2 = zzfqr.zzb(context2, zza2);
                zzfpk zzfpk = new zzfpk();
                zzauu zzauu2 = new zzauu(context2, zza2, new zzfre(context2, zzb2), new zzfrl(context2, zzb2, new zzaur(zza2), ((Boolean) zzbe.zzc().zza(zzbcn.zzcv)).booleanValue()), new zzfrn(context2, zzavz, zza2, zzfpk), zzavz, executor2, zzfpk, zzb2, zzd2, zzawg, zzavx2);
                zzb = zzauu2;
                zzauu2.zzm();
                zzb.zzp();
            }
            zzauu = zzb;
        }
        return zzauu;
    }

    private final void zzt() {
        zzawo zzawo = this.zzl;
        if (zzawo != null) {
            zzawo.zzh();
        }
    }

    private final zzfrd zzu(int i) {
        if (!zzfqr.zza(this.zzr)) {
            return null;
        }
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzct)).booleanValue()) {
            return this.zze.zzc(1);
        }
        return this.zzd.zzc(1);
    }

    public final String zzd(Context context, String str, View view) {
        return zze(context, str, view, (Activity) null);
    }

    public final String zze(Context context, String str, View view, Activity activity) {
        zzt();
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzcL)).booleanValue()) {
            this.zzm.zzi();
        }
        zzp();
        zzfps zza2 = this.zzf.zza();
        if (zza2 == null) {
            return "";
        }
        long currentTimeMillis = System.currentTimeMillis();
        String zza3 = zza2.zza(context, (String) null, str, view, activity);
        this.zzh.zzf(5000, System.currentTimeMillis() - currentTimeMillis, zza3, (Map) null);
        return zza3;
    }

    public final String zzf(Context context) {
        zzt();
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzcL)).booleanValue()) {
            this.zzm.zzj();
        }
        zzp();
        zzfps zza2 = this.zzf.zza();
        if (zza2 == null) {
            return "";
        }
        long currentTimeMillis = System.currentTimeMillis();
        String zzc2 = zza2.zzc(context, (String) null);
        this.zzh.zzf(5001, System.currentTimeMillis() - currentTimeMillis, zzc2, (Map) null);
        return zzc2;
    }

    public final String zzg(Context context) {
        return "19";
    }

    public final String zzh(Context context, View view, Activity activity) {
        zzt();
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzcL)).booleanValue()) {
            this.zzm.zzk(context, view);
        }
        zzp();
        zzfps zza2 = this.zzf.zza();
        if (zza2 == null) {
            return "";
        }
        long currentTimeMillis = System.currentTimeMillis();
        String zzb2 = zza2.zzb(context, (String) null, view, activity);
        this.zzh.zzf(5002, System.currentTimeMillis() - currentTimeMillis, zzb2, (Map) null);
        return zzb2;
    }

    public final void zzk(MotionEvent motionEvent) {
        zzfps zza2 = this.zzf.zza();
        if (zza2 != null) {
            try {
                zza2.zzd((String) null, motionEvent);
            } catch (zzfrm e) {
                this.zzh.zzc(e.zza(), -1, e);
            }
        }
    }

    public final void zzl(int i, int i2, int i3) {
        DisplayMetrics displayMetrics;
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzlG)).booleanValue() && (displayMetrics = this.zzc.getResources().getDisplayMetrics()) != null) {
            float f = (float) i;
            float f2 = (float) i2;
            MotionEvent obtain = MotionEvent.obtain(0, 0, 0, f * displayMetrics.density, f2 * displayMetrics.density, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
            zzk(obtain);
            obtain.recycle();
            MotionEvent obtain2 = MotionEvent.obtain(0, 0, 2, f * displayMetrics.density, f2 * displayMetrics.density, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
            zzk(obtain2);
            obtain2.recycle();
            MotionEvent obtain3 = MotionEvent.obtain(0, (long) i3, 1, f * displayMetrics.density, f2 * displayMetrics.density, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
            zzk(obtain3);
            obtain3.recycle();
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized void zzm() {
        long currentTimeMillis = System.currentTimeMillis();
        zzfrd zzu = zzu(1);
        if (zzu == null) {
            this.zzh.zzd(4013, System.currentTimeMillis() - currentTimeMillis);
        } else if (this.zzf.zzc(zzu)) {
            this.zzq = true;
            this.zzk.countDown();
        }
    }

    public final void zzn(StackTraceElement[] stackTraceElementArr) {
        zzavx zzavx = this.zzn;
        if (zzavx != null) {
            zzavx.zzb(Arrays.asList(stackTraceElementArr));
        }
    }

    public final void zzo(View view) {
        this.zzg.zzd(view);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x003e, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzp() {
        /*
            r5 = this;
            boolean r0 = r5.zzp
            if (r0 != 0) goto L_0x0042
            java.lang.Object r0 = r5.zzo
            monitor-enter(r0)
            boolean r1 = r5.zzp     // Catch:{ all -> 0x003f }
            if (r1 != 0) goto L_0x003d
            long r1 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x003f }
            r3 = 1000(0x3e8, double:4.94E-321)
            long r1 = r1 / r3
            long r3 = r5.zza     // Catch:{ all -> 0x003f }
            long r1 = r1 - r3
            r3 = 3600(0xe10, double:1.7786E-320)
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 >= 0) goto L_0x001d
            monitor-exit(r0)     // Catch:{ all -> 0x003f }
            return
        L_0x001d:
            com.google.android.gms.internal.ads.zzfrn r1 = r5.zzf     // Catch:{ all -> 0x003f }
            com.google.android.gms.internal.ads.zzfrd r1 = r1.zzb()     // Catch:{ all -> 0x003f }
            if (r1 == 0) goto L_0x002b
            boolean r1 = r1.zzd(r3)     // Catch:{ all -> 0x003f }
            if (r1 == 0) goto L_0x003d
        L_0x002b:
            int r1 = r5.zzr     // Catch:{ all -> 0x003f }
            boolean r1 = com.google.android.gms.internal.ads.zzfqr.zza(r1)     // Catch:{ all -> 0x003f }
            if (r1 == 0) goto L_0x003d
            java.util.concurrent.Executor r1 = r5.zzi     // Catch:{ all -> 0x003f }
            com.google.android.gms.internal.ads.zzaut r2 = new com.google.android.gms.internal.ads.zzaut     // Catch:{ all -> 0x003f }
            r2.<init>(r5)     // Catch:{ all -> 0x003f }
            r1.execute(r2)     // Catch:{ all -> 0x003f }
        L_0x003d:
            monitor-exit(r0)     // Catch:{ all -> 0x003f }
            return
        L_0x003f:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x003f }
            throw r1
        L_0x0042:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzauu.zzp():void");
    }

    public final synchronized boolean zzr() {
        return this.zzq;
    }
}
