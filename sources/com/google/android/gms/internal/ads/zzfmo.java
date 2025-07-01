package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.ClientApi;
import com.google.android.gms.ads.internal.client.zzcf;
import com.google.android.gms.ads.internal.client.zzft;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.common.util.Clock;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public abstract class zzfmo {
    protected final ClientApi zza;
    protected final Context zzb;
    protected final int zzc;
    protected final zzbpg zzd;
    protected final zzft zze;
    protected final AtomicBoolean zzf = new AtomicBoolean(true);
    private final zzcf zzg;
    private final ConcurrentLinkedQueue zzh = new ConcurrentLinkedQueue();
    /* access modifiers changed from: private */
    public final zzflx zzi;
    /* access modifiers changed from: private */
    public final AtomicBoolean zzj = new AtomicBoolean(false);
    private final ScheduledExecutorService zzk;
    private final AtomicBoolean zzl;
    private final Clock zzm;

    public zzfmo(ClientApi clientApi, Context context, int i, zzbpg zzbpg, zzft zzft, zzcf zzcf, ScheduledExecutorService scheduledExecutorService, zzflx zzflx, Clock clock) {
        this.zza = clientApi;
        this.zzb = context;
        this.zzc = i;
        this.zzd = zzbpg;
        this.zze = zzft;
        this.zzg = zzcf;
        this.zzk = scheduledExecutorService;
        this.zzi = zzflx;
        this.zzl = new AtomicBoolean(true);
        this.zzm = clock;
    }

    /* access modifiers changed from: private */
    public final synchronized void zzm(Object obj) {
        zzfmi zzfmi = new zzfmi(obj, this.zzm);
        this.zzh.add(zzfmi);
        zzs.zza.post(new zzfmk(this));
        this.zzk.schedule(new zzfmj(this), zzfmi.zza(), TimeUnit.MILLISECONDS);
    }

    private final synchronized void zzn() {
        Iterator it = this.zzh.iterator();
        while (it.hasNext()) {
            if (((zzfmi) it.next()).zzc()) {
                it.remove();
            }
        }
    }

    /* access modifiers changed from: private */
    public final synchronized void zzo(boolean z) {
        if (!this.zzi.zzd()) {
            if (z) {
                this.zzi.zzb();
            }
            this.zzk.schedule(new zzfmj(this), this.zzi.zza(), TimeUnit.MILLISECONDS);
        }
    }

    /* access modifiers changed from: protected */
    public abstract ListenableFuture zza();

    public final synchronized zzfmo zzc() {
        this.zzk.submit(new zzfmj(this));
        return this;
    }

    public final synchronized Object zzd() {
        this.zzi.zzc();
        zzfmi zzfmi = (zzfmi) this.zzh.poll();
        zzh();
        if (zzfmi == null) {
            return null;
        }
        return zzfmi.zzb();
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0042, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzh() {
        /*
            r3 = this;
            monitor-enter(r3)
            r3.zzn()     // Catch:{ all -> 0x0043 }
            com.google.android.gms.internal.ads.zzfml r0 = new com.google.android.gms.internal.ads.zzfml     // Catch:{ all -> 0x0043 }
            r0.<init>(r3)     // Catch:{ all -> 0x0043 }
            com.google.android.gms.internal.ads.zzftd r1 = com.google.android.gms.ads.internal.util.zzs.zza     // Catch:{ all -> 0x0043 }
            r1.post(r0)     // Catch:{ all -> 0x0043 }
            java.util.concurrent.atomic.AtomicBoolean r0 = r3.zzj     // Catch:{ all -> 0x0043 }
            boolean r0 = r0.get()     // Catch:{ all -> 0x0043 }
            if (r0 != 0) goto L_0x0041
            java.util.concurrent.atomic.AtomicBoolean r0 = r3.zzf     // Catch:{ all -> 0x0043 }
            boolean r0 = r0.get()     // Catch:{ all -> 0x0043 }
            if (r0 == 0) goto L_0x0041
            java.util.concurrent.ConcurrentLinkedQueue r0 = r3.zzh     // Catch:{ all -> 0x0043 }
            com.google.android.gms.ads.internal.client.zzft r1 = r3.zze     // Catch:{ all -> 0x0043 }
            int r0 = r0.size()     // Catch:{ all -> 0x0043 }
            int r1 = r1.zzd     // Catch:{ all -> 0x0043 }
            if (r0 < r1) goto L_0x002b
            goto L_0x0041
        L_0x002b:
            java.util.concurrent.atomic.AtomicBoolean r0 = r3.zzj     // Catch:{ all -> 0x0043 }
            r1 = 1
            r0.set(r1)     // Catch:{ all -> 0x0043 }
            com.google.common.util.concurrent.ListenableFuture r0 = r3.zza()     // Catch:{ all -> 0x0043 }
            com.google.android.gms.internal.ads.zzfmm r1 = new com.google.android.gms.internal.ads.zzfmm     // Catch:{ all -> 0x0043 }
            r1.<init>(r3)     // Catch:{ all -> 0x0043 }
            java.util.concurrent.ScheduledExecutorService r2 = r3.zzk     // Catch:{ all -> 0x0043 }
            com.google.android.gms.internal.ads.zzgei.zzr(r0, r1, r2)     // Catch:{ all -> 0x0043 }
            monitor-exit(r3)
            return
        L_0x0041:
            monitor-exit(r3)
            return
        L_0x0043:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0043 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfmo.zzh():void");
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzi() {
        if (this.zzl.get()) {
            try {
                this.zzg.zze(this.zze);
            } catch (RemoteException unused) {
                zzm.zzj("Failed to call onAdsAvailable");
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzj() {
        if (this.zzl.get() && this.zzh.isEmpty()) {
            try {
                this.zzg.zzf(this.zze);
            } catch (RemoteException unused) {
                zzm.zzj("Failed to call onAdsExhausted");
            }
        }
    }

    public final void zzk() {
        this.zzf.set(false);
        this.zzl.set(false);
    }

    public final synchronized boolean zzl() {
        zzn();
        return !this.zzh.isEmpty();
    }
}
