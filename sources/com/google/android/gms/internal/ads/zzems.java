package com.google.android.gms.internal.ads;

import android.util.Pair;
import com.google.android.gms.ads.admanager.AppEventListener;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.client.zzbl;
import com.google.android.gms.ads.internal.client.zzbo;
import com.google.android.gms.ads.internal.client.zzcm;
import com.google.android.gms.ads.internal.client.zzct;
import com.google.android.gms.ads.internal.client.zzdr;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.ads.internal.client.zzu;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzems implements AppEventListener, zzczj, zzcya, zzcwp, zzcxg, zza, zzcwm, zzcyx, zzcxc, zzdel {
    final zzdsm zza;
    final BlockingQueue zzb = new ArrayBlockingQueue(((Integer) zzbe.zzc().zza(zzbcn.zziw)).intValue());
    private final AtomicReference zzc = new AtomicReference();
    private final AtomicReference zzd = new AtomicReference();
    private final AtomicReference zze = new AtomicReference();
    private final AtomicReference zzf = new AtomicReference();
    private final AtomicReference zzg = new AtomicReference();
    private final AtomicBoolean zzh = new AtomicBoolean(true);
    private final AtomicBoolean zzi = new AtomicBoolean(false);
    private final AtomicBoolean zzj = new AtomicBoolean(false);

    public zzems(zzdsm zzdsm) {
        this.zza = zzdsm;
    }

    private final void zzo() {
        if (this.zzi.get() && this.zzj.get()) {
            for (Pair zzemd : this.zzb) {
                zzfby.zza(this.zzd, new zzemd(zzemd));
            }
            this.zzb.clear();
            this.zzh.set(false);
        }
    }

    public final void onAdClicked() {
        if (!((Boolean) zzbe.zzc().zza(zzbcn.zzkt)).booleanValue()) {
            zzfby.zza(this.zzc, new zzemq());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003a, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void onAppEvent(java.lang.String r4, java.lang.String r5) {
        /*
            r3 = this;
            monitor-enter(r3)
            java.util.concurrent.atomic.AtomicBoolean r0 = r3.zzh     // Catch:{ all -> 0x0047 }
            boolean r0 = r0.get()     // Catch:{ all -> 0x0047 }
            if (r0 == 0) goto L_0x003b
            java.util.concurrent.BlockingQueue r0 = r3.zzb     // Catch:{ all -> 0x0047 }
            android.util.Pair r1 = new android.util.Pair     // Catch:{ all -> 0x0047 }
            r1.<init>(r4, r5)     // Catch:{ all -> 0x0047 }
            boolean r0 = r0.offer(r1)     // Catch:{ all -> 0x0047 }
            if (r0 != 0) goto L_0x0039
            java.lang.String r0 = "The queue for app events is full, dropping the new event."
            com.google.android.gms.ads.internal.util.client.zzm.zze(r0)     // Catch:{ all -> 0x0047 }
            com.google.android.gms.internal.ads.zzdsm r0 = r3.zza     // Catch:{ all -> 0x0047 }
            if (r0 == 0) goto L_0x0039
            com.google.android.gms.internal.ads.zzdsl r0 = r0.zza()     // Catch:{ all -> 0x0047 }
            java.lang.String r1 = "action"
            java.lang.String r2 = "dae_action"
            r0.zzb(r1, r2)     // Catch:{ all -> 0x0047 }
            java.lang.String r1 = "dae_name"
            r0.zzb(r1, r4)     // Catch:{ all -> 0x0047 }
            java.lang.String r4 = "dae_data"
            r0.zzb(r4, r5)     // Catch:{ all -> 0x0047 }
            r0.zzf()     // Catch:{ all -> 0x0047 }
            monitor-exit(r3)
            return
        L_0x0039:
            monitor-exit(r3)
            return
        L_0x003b:
            java.util.concurrent.atomic.AtomicReference r0 = r3.zzd     // Catch:{ all -> 0x0047 }
            com.google.android.gms.internal.ads.zzemk r1 = new com.google.android.gms.internal.ads.zzemk     // Catch:{ all -> 0x0047 }
            r1.<init>(r4, r5)     // Catch:{ all -> 0x0047 }
            com.google.android.gms.internal.ads.zzfby.zza(r0, r1)     // Catch:{ all -> 0x0047 }
            monitor-exit(r3)
            return
        L_0x0047:
            r4 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0047 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzems.onAppEvent(java.lang.String, java.lang.String):void");
    }

    public final void zza() {
        zzfby.zza(this.zzc, new zzema());
        zzfby.zza(this.zzg, new zzemb());
    }

    public final void zzb() {
        zzfby.zza(this.zzc, new zzeml());
    }

    public final void zzc() {
        zzfby.zza(this.zzc, new zzemn());
        zzfby.zza(this.zzg, new zzemo());
        zzfby.zza(this.zzg, new zzemp());
    }

    public final void zzdB(zze zze2) {
        zzfby.zza(this.zzc, new zzeme(zze2));
        zzfby.zza(this.zzc, new zzemf(zze2));
        zzfby.zza(this.zzf, new zzemg(zze2));
        this.zzh.set(false);
        this.zzb.clear();
    }

    public final void zzdG() {
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzkt)).booleanValue()) {
            zzfby.zza(this.zzc, new zzemq());
        }
        zzfby.zza(this.zzg, new zzemc());
    }

    public final void zzdf() {
        zzfby.zza(this.zzc, new zzemm());
    }

    public final void zzdn(zzbvx zzbvx) {
    }

    public final void zzdo(zzfff zzfff) {
        this.zzh.set(true);
        this.zzj.set(false);
    }

    public final void zzds(zzbwj zzbwj, String str, String str2) {
    }

    public final void zze() {
    }

    public final void zzf() {
    }

    public final synchronized zzbl zzg() {
        return (zzbl) this.zzc.get();
    }

    public final void zzh(zzu zzu) {
        zzfby.zza(this.zze, new zzemr(zzu));
    }

    public final synchronized zzcm zzi() {
        return (zzcm) this.zzd.get();
    }

    public final void zzj(zzbl zzbl) {
        this.zzc.set(zzbl);
    }

    public final void zzk(zzbo zzbo) {
        this.zzf.set(zzbo);
    }

    public final void zzl(zzdr zzdr) {
        this.zze.set(zzdr);
    }

    public final void zzm(zzcm zzcm) {
        this.zzd.set(zzcm);
        this.zzi.set(true);
        zzo();
    }

    public final void zzn(zzct zzct) {
        this.zzg.set(zzct);
    }

    public final void zzq(zze zze2) {
        zzfby.zza(this.zzg, new zzemj(zze2));
    }

    public final void zzr() {
        zzfby.zza(this.zzc, new zzelz());
    }

    public final synchronized void zzs() {
        zzfby.zza(this.zzc, new zzemh());
        zzfby.zza(this.zzf, new zzemi());
        this.zzj.set(true);
        zzo();
    }
}
