package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzeqp implements zzevz {
    private final AtomicReference zza = new AtomicReference();
    private final AtomicReference zzb;
    private final Clock zzc;
    private final Executor zzd;
    private final zzevz zze;
    private final long zzf;
    private final zzdsm zzg;

    public zzeqp(zzevz zzevz, long j, Clock clock, Executor executor, zzdsm zzdsm) {
        this.zzc = clock;
        this.zze = zzevz;
        this.zzf = j;
        this.zzd = executor;
        this.zzg = zzdsm;
        this.zzb = new AtomicReference(false);
    }

    public final int zza() {
        return this.zze.zza();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x009d, code lost:
        if (((java.lang.Boolean) r8.zzb.get()).booleanValue() != false) goto L_0x0101;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00a3, code lost:
        if (r0.zza() != false) goto L_0x00a6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00a6, code lost:
        r0 = r0.zza;
        r1 = r8.zze;
        r5 = new com.google.android.gms.internal.ads.zzeqo(r1.zzb(), r8.zzf, r8.zzc);
        r8.zza.set(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00cc, code lost:
        if (((java.lang.Boolean) com.google.android.gms.ads.internal.client.zzbe.zzc().zza(com.google.android.gms.internal.ads.zzbcn.zzlx)).booleanValue() == false) goto L_0x0100;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00de, code lost:
        if (((java.lang.Boolean) com.google.android.gms.ads.internal.client.zzbe.zzc().zza(com.google.android.gms.internal.ads.zzbcn.zzly)).booleanValue() == false) goto L_0x00ff;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00e0, code lost:
        r1 = r8.zzg.zza();
        r1.zzb("action", "scs");
        r1.zzb("sid", java.lang.String.valueOf(r8.zze.zza()));
        r1.zzf();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00ff, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0100, code lost:
        r0 = r5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.common.util.concurrent.ListenableFuture zzb() {
        /*
            r8 = this;
            com.google.android.gms.internal.ads.zzbce r0 = com.google.android.gms.internal.ads.zzbcn.zzlw
            com.google.android.gms.internal.ads.zzbcl r1 = com.google.android.gms.ads.internal.client.zzbe.zzc()
            java.lang.Object r0 = r1.zza(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 != 0) goto L_0x0039
            java.util.concurrent.atomic.AtomicReference r0 = r8.zza
            java.lang.Object r0 = r0.get()
            com.google.android.gms.internal.ads.zzeqo r0 = (com.google.android.gms.internal.ads.zzeqo) r0
            if (r0 == 0) goto L_0x0022
            boolean r1 = r0.zza()
            if (r1 == 0) goto L_0x0101
        L_0x0022:
            com.google.android.gms.internal.ads.zzevz r0 = r8.zze
            long r1 = r8.zzf
            com.google.android.gms.common.util.Clock r3 = r8.zzc
            com.google.android.gms.internal.ads.zzeqo r4 = new com.google.android.gms.internal.ads.zzeqo
            com.google.common.util.concurrent.ListenableFuture r0 = r0.zzb()
            r4.<init>(r0, r1, r3)
            java.util.concurrent.atomic.AtomicReference r0 = r8.zza
            r0.set(r4)
            r0 = r4
            goto L_0x0101
        L_0x0039:
            com.google.android.gms.internal.ads.zzbce r0 = com.google.android.gms.internal.ads.zzbcn.zzlv
            com.google.android.gms.internal.ads.zzbcl r1 = com.google.android.gms.ads.internal.client.zzbe.zzc()
            java.lang.Object r0 = r1.zza(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x006d
            java.util.concurrent.atomic.AtomicReference r0 = r8.zzb
            r1 = 1
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            java.lang.Object r0 = r0.getAndSet(r1)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 != 0) goto L_0x006d
            java.util.concurrent.ScheduledExecutorService r1 = com.google.android.gms.internal.ads.zzcaj.zzd
            com.google.android.gms.internal.ads.zzeqm r2 = new com.google.android.gms.internal.ads.zzeqm
            r2.<init>(r8)
            long r3 = r8.zzf
            java.util.concurrent.TimeUnit r7 = java.util.concurrent.TimeUnit.MILLISECONDS
            r5 = r3
            r1.scheduleWithFixedDelay(r2, r3, r5, r7)
        L_0x006d:
            monitor-enter(r8)
            java.util.concurrent.atomic.AtomicReference r0 = r8.zza     // Catch:{ all -> 0x0104 }
            java.lang.Object r0 = r0.get()     // Catch:{ all -> 0x0104 }
            com.google.android.gms.internal.ads.zzeqo r0 = (com.google.android.gms.internal.ads.zzeqo) r0     // Catch:{ all -> 0x0104 }
            if (r0 != 0) goto L_0x0090
            com.google.android.gms.internal.ads.zzeqo r0 = new com.google.android.gms.internal.ads.zzeqo     // Catch:{ all -> 0x0104 }
            com.google.android.gms.internal.ads.zzevz r1 = r8.zze     // Catch:{ all -> 0x0104 }
            com.google.common.util.concurrent.ListenableFuture r1 = r1.zzb()     // Catch:{ all -> 0x0104 }
            long r2 = r8.zzf     // Catch:{ all -> 0x0104 }
            com.google.android.gms.common.util.Clock r4 = r8.zzc     // Catch:{ all -> 0x0104 }
            r0.<init>(r1, r2, r4)     // Catch:{ all -> 0x0104 }
            java.util.concurrent.atomic.AtomicReference r1 = r8.zza     // Catch:{ all -> 0x0104 }
            r1.set(r0)     // Catch:{ all -> 0x0104 }
            com.google.common.util.concurrent.ListenableFuture r0 = r0.zza     // Catch:{ all -> 0x0104 }
            monitor-exit(r8)     // Catch:{ all -> 0x0104 }
            return r0
        L_0x0090:
            monitor-exit(r8)     // Catch:{ all -> 0x0104 }
            java.util.concurrent.atomic.AtomicReference r1 = r8.zzb
            java.lang.Object r1 = r1.get()
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 != 0) goto L_0x0101
            boolean r1 = r0.zza()
            if (r1 != 0) goto L_0x00a6
            goto L_0x0101
        L_0x00a6:
            com.google.common.util.concurrent.ListenableFuture r0 = r0.zza
            com.google.android.gms.internal.ads.zzevz r1 = r8.zze
            long r2 = r8.zzf
            com.google.android.gms.common.util.Clock r4 = r8.zzc
            com.google.android.gms.internal.ads.zzeqo r5 = new com.google.android.gms.internal.ads.zzeqo
            com.google.common.util.concurrent.ListenableFuture r1 = r1.zzb()
            r5.<init>(r1, r2, r4)
            java.util.concurrent.atomic.AtomicReference r1 = r8.zza
            r1.set(r5)
            com.google.android.gms.internal.ads.zzbce r1 = com.google.android.gms.internal.ads.zzbcn.zzlx
            com.google.android.gms.internal.ads.zzbcl r2 = com.google.android.gms.ads.internal.client.zzbe.zzc()
            java.lang.Object r1 = r2.zza(r1)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L_0x0100
            com.google.android.gms.internal.ads.zzbce r1 = com.google.android.gms.internal.ads.zzbcn.zzly
            com.google.android.gms.internal.ads.zzbcl r2 = com.google.android.gms.ads.internal.client.zzbe.zzc()
            java.lang.Object r1 = r2.zza(r1)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L_0x00ff
            com.google.android.gms.internal.ads.zzdsm r1 = r8.zzg
            com.google.android.gms.internal.ads.zzdsl r1 = r1.zza()
            java.lang.String r2 = "action"
            java.lang.String r3 = "scs"
            r1.zzb(r2, r3)
            com.google.android.gms.internal.ads.zzevz r2 = r8.zze
            int r2 = r2.zza()
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.String r3 = "sid"
            r1.zzb(r3, r2)
            r1.zzf()
        L_0x00ff:
            return r0
        L_0x0100:
            r0 = r5
        L_0x0101:
            com.google.common.util.concurrent.ListenableFuture r0 = r0.zza
            return r0
        L_0x0104:
            r0 = move-exception
            monitor-exit(r8)     // Catch:{ all -> 0x0104 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeqp.zzb():com.google.common.util.concurrent.ListenableFuture");
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzd() {
        this.zza.set(new zzeqo(this.zze.zzb(), this.zzf, this.zzc));
    }
}
