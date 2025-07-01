package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.client.zzbi;
import com.google.android.gms.ads.internal.client.zzbl;
import com.google.android.gms.ads.internal.client.zzbo;
import com.google.android.gms.ads.internal.client.zzbx;
import com.google.android.gms.ads.internal.client.zzcc;
import com.google.android.gms.ads.internal.client.zzcm;
import com.google.android.gms.ads.internal.client.zzcq;
import com.google.android.gms.ads.internal.client.zzct;
import com.google.android.gms.ads.internal.client.zzdr;
import com.google.android.gms.ads.internal.client.zzdy;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.ads.internal.client.zzeb;
import com.google.android.gms.ads.internal.client.zzef;
import com.google.android.gms.ads.internal.client.zzga;
import com.google.android.gms.ads.internal.client.zzm;
import com.google.android.gms.ads.internal.client.zzs;
import com.google.android.gms.ads.internal.client.zzy;
import com.google.android.gms.ads.internal.overlay.zzr;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzfaz extends zzbx implements zzr, zzazz {
    protected zzcox zza;
    private final zzchk zzb;
    private final Context zzc;
    private AtomicBoolean zzd = new AtomicBoolean();
    private final String zze;
    private final zzfat zzf;
    /* access modifiers changed from: private */
    public final zzfar zzg;
    private final VersionInfoParcel zzh;
    /* access modifiers changed from: private */
    public final zzdsm zzi;
    private long zzj = -1;
    private zzcok zzk;

    public zzfaz(zzchk zzchk, Context context, String str, zzfat zzfat, zzfar zzfar, VersionInfoParcel versionInfoParcel, zzdsm zzdsm) {
        this.zzb = zzchk;
        this.zzc = context;
        this.zze = str;
        this.zzf = zzfat;
        this.zzg = zzfar;
        this.zzh = versionInfoParcel;
        this.zzi = zzdsm;
        zzfar.zzm(this);
    }

    private final synchronized void zzq(int i) {
        if (this.zzd.compareAndSet(false, true)) {
            this.zzg.zzj();
            zzcok zzcok = this.zzk;
            if (zzcok != null) {
                zzv.zzb().zze(zzcok);
            }
            if (this.zza != null) {
                long j = -1;
                if (this.zzj != -1) {
                    j = zzv.zzC().elapsedRealtime() - this.zzj;
                }
                this.zza.zze(j, i);
            }
            zzx();
        }
    }

    public final synchronized void zzA() {
    }

    public final synchronized void zzB() {
        Preconditions.checkMainThread("resume must be called on the main UI thread.");
    }

    public final void zzC(zzbi zzbi) {
    }

    public final void zzD(zzbl zzbl) {
    }

    public final void zzE(zzcc zzcc) {
    }

    public final synchronized void zzF(zzs zzs) {
        Preconditions.checkMainThread("setAdSize must be called on the main UI thread.");
    }

    public final void zzG(zzcm zzcm) {
    }

    public final void zzH(zzbai zzbai) {
        this.zzg.zzo(zzbai);
    }

    public final void zzI(zzy zzy) {
        this.zzf.zzl(zzy);
    }

    public final void zzJ(zzct zzct) {
    }

    public final void zzK(zzef zzef) {
    }

    public final void zzL(boolean z) {
    }

    public final void zzM(zzbtp zzbtp) {
    }

    public final synchronized void zzN(boolean z) {
    }

    public final synchronized void zzO(zzbdi zzbdi) {
    }

    public final void zzP(zzdr zzdr) {
    }

    public final void zzQ(zzbts zzbts, String str) {
    }

    public final void zzR(String str) {
    }

    public final void zzS(zzbwp zzbwp) {
    }

    public final void zzT(String str) {
    }

    public final synchronized void zzU(zzga zzga) {
    }

    public final void zzW(IObjectWrapper iObjectWrapper) {
    }

    public final synchronized void zzX() {
    }

    public final synchronized boolean zzY() {
        return false;
    }

    public final synchronized boolean zzZ() {
        return this.zzf.zza();
    }

    public final void zza() {
        zzq(3);
    }

    public final boolean zzaa() {
        return false;
    }

    public final synchronized boolean zzab(zzm zzm) throws RemoteException {
        boolean z;
        if (!zzm.zzb()) {
            if (((Boolean) zzbel.zzd.zze()).booleanValue()) {
                if (((Boolean) zzbe.zzc().zza(zzbcn.zzkP)).booleanValue()) {
                    z = true;
                    if (this.zzh.clientJarVersion < ((Integer) zzbe.zzc().zza(zzbcn.zzkQ)).intValue() || !z) {
                        Preconditions.checkMainThread("loadAd must be called on the main UI thread.");
                    }
                }
            }
            z = false;
            Preconditions.checkMainThread("loadAd must be called on the main UI thread.");
        }
        zzv.zzq();
        if (com.google.android.gms.ads.internal.util.zzs.zzH(this.zzc)) {
            if (zzm.zzs == null) {
                com.google.android.gms.ads.internal.util.client.zzm.zzg("Failed to load the ad because app ID is missing.");
                this.zzg.zzdB(zzfgq.zzd(4, (String) null, (zze) null));
                return false;
            }
        }
        if (zzZ()) {
            return false;
        }
        this.zzd = new AtomicBoolean();
        return this.zzf.zzb(zzm, this.zze, new zzfax(this), new zzfay(this));
    }

    public final synchronized void zzac(zzcq zzcq) {
    }

    public final Bundle zzd() {
        return new Bundle();
    }

    public final void zzdH() {
    }

    public final void zzdk() {
    }

    public final void zzdq() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0034, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzdr() {
        /*
            r4 = this;
            monitor-enter(r4)
            com.google.android.gms.internal.ads.zzcox r0 = r4.zza     // Catch:{ all -> 0x0035 }
            if (r0 != 0) goto L_0x0006
            goto L_0x0033
        L_0x0006:
            com.google.android.gms.common.util.Clock r0 = com.google.android.gms.ads.internal.zzv.zzC()     // Catch:{ all -> 0x0035 }
            long r0 = r0.elapsedRealtime()     // Catch:{ all -> 0x0035 }
            r4.zzj = r0     // Catch:{ all -> 0x0035 }
            com.google.android.gms.internal.ads.zzcox r0 = r4.zza     // Catch:{ all -> 0x0035 }
            int r0 = r0.zza()     // Catch:{ all -> 0x0035 }
            if (r0 <= 0) goto L_0x0033
            com.google.android.gms.internal.ads.zzchk r1 = r4.zzb     // Catch:{ all -> 0x0035 }
            com.google.android.gms.internal.ads.zzcok r2 = new com.google.android.gms.internal.ads.zzcok     // Catch:{ all -> 0x0035 }
            java.util.concurrent.ScheduledExecutorService r1 = r1.zzD()     // Catch:{ all -> 0x0035 }
            com.google.android.gms.common.util.Clock r3 = com.google.android.gms.ads.internal.zzv.zzC()     // Catch:{ all -> 0x0035 }
            r2.<init>(r1, r3)     // Catch:{ all -> 0x0035 }
            r4.zzk = r2     // Catch:{ all -> 0x0035 }
            com.google.android.gms.internal.ads.zzfaw r1 = new com.google.android.gms.internal.ads.zzfaw     // Catch:{ all -> 0x0035 }
            r1.<init>(r4)     // Catch:{ all -> 0x0035 }
            r2.zzd(r0, r1)     // Catch:{ all -> 0x0035 }
            monitor-exit(r4)
            return
        L_0x0033:
            monitor-exit(r4)
            return
        L_0x0035:
            r0 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0035 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfaz.zzdr():void");
    }

    public final synchronized void zzdt() {
        zzcox zzcox = this.zza;
        if (zzcox != null) {
            zzcox.zze(zzv.zzC().elapsedRealtime() - this.zzj, 1);
        }
    }

    public final synchronized zzs zzg() {
        return null;
    }

    public final zzbl zzi() {
        return null;
    }

    public final zzcm zzj() {
        return null;
    }

    public final synchronized zzdy zzk() {
        return null;
    }

    public final synchronized zzeb zzl() {
        return null;
    }

    public final IObjectWrapper zzn() {
        return null;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzo() {
        zzq(5);
    }

    public final void zzp() {
        this.zzb.zzC().execute(new zzfav(this));
    }

    public final synchronized String zzr() {
        return this.zze;
    }

    public final synchronized String zzs() {
        return null;
    }

    public final synchronized String zzt() {
        return null;
    }

    public final synchronized void zzx() {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        zzcox zzcox = this.zza;
        if (zzcox != null) {
            zzcox.zzb();
        }
    }

    public final void zzy(zzm zzm, zzbo zzbo) {
    }

    public final synchronized void zzz() {
        Preconditions.checkMainThread("pause must be called on the main UI thread.");
    }

    public final void zzdu(int i) {
        if (i != 0) {
            int i2 = i - 1;
            if (i2 == 0) {
                zzq(2);
            } else if (i2 == 1) {
                zzq(4);
            } else if (i2 != 2) {
                zzq(6);
            } else {
                zzq(3);
            }
        } else {
            throw null;
        }
    }
}
