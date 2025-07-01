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
import com.google.android.gms.ads.internal.client.zzeb;
import com.google.android.gms.ads.internal.client.zzef;
import com.google.android.gms.ads.internal.client.zzga;
import com.google.android.gms.ads.internal.client.zzs;
import com.google.android.gms.ads.internal.client.zzy;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Collections;
import java.util.concurrent.ExecutionException;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzely extends zzbx implements zzcyy {
    private final Context zza;
    private final zzfbf zzb;
    private final String zzc;
    private final zzems zzd;
    private zzs zze;
    private final zzffm zzf;
    private final VersionInfoParcel zzg;
    private final zzdsm zzh;
    /* access modifiers changed from: private */
    public zzcpd zzi;

    public zzely(Context context, zzs zzs, String str, zzfbf zzfbf, zzems zzems, VersionInfoParcel versionInfoParcel, zzdsm zzdsm) {
        this.zza = context;
        this.zzb = zzfbf;
        this.zze = zzs;
        this.zzc = str;
        this.zzd = zzems;
        this.zzf = zzfbf.zzg();
        this.zzg = versionInfoParcel;
        this.zzh = zzdsm;
        zzfbf.zzp(this);
    }

    private final synchronized void zzf(zzs zzs) {
        this.zzf.zzs(zzs);
        this.zzf.zzy(this.zze.zzn);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002e, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final synchronized boolean zzh(com.google.android.gms.ads.internal.client.zzm r5) throws android.os.RemoteException {
        /*
            r4 = this;
            monitor-enter(r4)
            boolean r0 = r4.zzm()     // Catch:{ all -> 0x0046 }
            if (r0 == 0) goto L_0x000c
            java.lang.String r0 = "loadAd must be called on the main UI thread."
            com.google.android.gms.common.internal.Preconditions.checkMainThread(r0)     // Catch:{ all -> 0x0046 }
        L_0x000c:
            com.google.android.gms.ads.internal.zzv.zzq()     // Catch:{ all -> 0x0046 }
            android.content.Context r0 = r4.zza     // Catch:{ all -> 0x0046 }
            boolean r0 = com.google.android.gms.ads.internal.util.zzs.zzH(r0)     // Catch:{ all -> 0x0046 }
            r1 = 0
            if (r0 == 0) goto L_0x0030
            com.google.android.gms.ads.internal.client.zzc r0 = r5.zzs     // Catch:{ all -> 0x0046 }
            if (r0 != 0) goto L_0x0030
            java.lang.String r5 = "Failed to load the ad because app ID is missing."
            com.google.android.gms.ads.internal.util.client.zzm.zzg(r5)     // Catch:{ all -> 0x0046 }
            com.google.android.gms.internal.ads.zzems r5 = r4.zzd     // Catch:{ all -> 0x0046 }
            if (r5 == 0) goto L_0x002d
            r0 = 4
            com.google.android.gms.ads.internal.client.zze r0 = com.google.android.gms.internal.ads.zzfgq.zzd(r0, r1, r1)     // Catch:{ all -> 0x0046 }
            r5.zzdB(r0)     // Catch:{ all -> 0x0046 }
        L_0x002d:
            monitor-exit(r4)
            r5 = 0
            return r5
        L_0x0030:
            android.content.Context r0 = r4.zza     // Catch:{ all -> 0x0046 }
            boolean r2 = r5.zzf     // Catch:{ all -> 0x0046 }
            com.google.android.gms.internal.ads.zzfgl.zza(r0, r2)     // Catch:{ all -> 0x0046 }
            com.google.android.gms.internal.ads.zzfbf r0 = r4.zzb     // Catch:{ all -> 0x0046 }
            java.lang.String r2 = r4.zzc     // Catch:{ all -> 0x0046 }
            com.google.android.gms.internal.ads.zzelx r3 = new com.google.android.gms.internal.ads.zzelx     // Catch:{ all -> 0x0046 }
            r3.<init>(r4)     // Catch:{ all -> 0x0046 }
            boolean r5 = r0.zzb(r5, r2, r1, r3)     // Catch:{ all -> 0x0046 }
            monitor-exit(r4)
            return r5
        L_0x0046:
            r5 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0046 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzely.zzh(com.google.android.gms.ads.internal.client.zzm):boolean");
    }

    private final boolean zzm() {
        boolean z;
        if (((Boolean) zzbel.zzf.zze()).booleanValue()) {
            if (((Boolean) zzbe.zzc().zza(zzbcn.zzkP)).booleanValue()) {
                z = true;
                return this.zzg.clientJarVersion >= ((Integer) zzbe.zzc().zza(zzbcn.zzkQ)).intValue() || !z;
            }
        }
        z = false;
        if (this.zzg.clientJarVersion >= ((Integer) zzbe.zzc().zza(zzbcn.zzkQ)).intValue()) {
        }
    }

    public final synchronized void zzA() {
        Preconditions.checkMainThread("recordManualImpression must be called on the main UI thread.");
        zzcpd zzcpd = this.zzi;
        if (zzcpd != null) {
            zzcpd.zzh();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0035, code lost:
        if (r3.zzg.clientJarVersion < ((java.lang.Integer) com.google.android.gms.ads.internal.client.zzbe.zzc().zza(com.google.android.gms.internal.ads.zzbcn.zzkR)).intValue()) goto L_0x0037;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzB() {
        /*
            r3 = this;
            monitor-enter(r3)
            com.google.android.gms.internal.ads.zzbdx r0 = com.google.android.gms.internal.ads.zzbel.zzh     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r0.zze()     // Catch:{ all -> 0x004c }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x004c }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x004c }
            if (r0 == 0) goto L_0x0037
            com.google.android.gms.internal.ads.zzbce r0 = com.google.android.gms.internal.ads.zzbcn.zzkL     // Catch:{ all -> 0x004c }
            com.google.android.gms.internal.ads.zzbcl r1 = com.google.android.gms.ads.internal.client.zzbe.zzc()     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r1.zza(r0)     // Catch:{ all -> 0x004c }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x004c }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x004c }
            if (r0 == 0) goto L_0x0037
            com.google.android.gms.ads.internal.util.client.VersionInfoParcel r0 = r3.zzg     // Catch:{ all -> 0x004c }
            int r0 = r0.clientJarVersion     // Catch:{ all -> 0x004c }
            com.google.android.gms.internal.ads.zzbce r1 = com.google.android.gms.internal.ads.zzbcn.zzkR     // Catch:{ all -> 0x004c }
            com.google.android.gms.internal.ads.zzbcl r2 = com.google.android.gms.ads.internal.client.zzbe.zzc()     // Catch:{ all -> 0x004c }
            java.lang.Object r1 = r2.zza(r1)     // Catch:{ all -> 0x004c }
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch:{ all -> 0x004c }
            int r1 = r1.intValue()     // Catch:{ all -> 0x004c }
            if (r0 >= r1) goto L_0x003c
        L_0x0037:
            java.lang.String r0 = "resume must be called on the main UI thread."
            com.google.android.gms.common.internal.Preconditions.checkMainThread(r0)     // Catch:{ all -> 0x004c }
        L_0x003c:
            com.google.android.gms.internal.ads.zzcpd r0 = r3.zzi     // Catch:{ all -> 0x004c }
            if (r0 == 0) goto L_0x004a
            com.google.android.gms.internal.ads.zzcxl r0 = r0.zzn()     // Catch:{ all -> 0x004c }
            r1 = 0
            r0.zzc(r1)     // Catch:{ all -> 0x004c }
            monitor-exit(r3)
            return
        L_0x004a:
            monitor-exit(r3)
            return
        L_0x004c:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x004c }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzely.zzB():void");
    }

    public final void zzC(zzbi zzbi) {
        if (zzm()) {
            Preconditions.checkMainThread("setAdListener must be called on the main UI thread.");
        }
        this.zzb.zzo(zzbi);
    }

    public final void zzD(zzbl zzbl) {
        if (zzm()) {
            Preconditions.checkMainThread("setAdListener must be called on the main UI thread.");
        }
        this.zzd.zzj(zzbl);
    }

    public final void zzE(zzcc zzcc) {
        Preconditions.checkMainThread("setAdMetadataListener must be called on the main UI thread.");
    }

    public final synchronized void zzF(zzs zzs) {
        Preconditions.checkMainThread("setAdSize must be called on the main UI thread.");
        this.zzf.zzs(zzs);
        this.zze = zzs;
        zzcpd zzcpd = this.zzi;
        if (zzcpd != null) {
            zzcpd.zzi(this.zzb.zzc(), zzs);
        }
    }

    public final void zzG(zzcm zzcm) {
        if (zzm()) {
            Preconditions.checkMainThread("setAppEventListener must be called on the main UI thread.");
        }
        this.zzd.zzm(zzcm);
    }

    public final void zzH(zzbai zzbai) {
    }

    public final void zzI(zzy zzy) {
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
        if (zzm()) {
            Preconditions.checkMainThread("setManualImpressionsEnabled must be called from the main thread.");
        }
        this.zzf.zzB(z);
    }

    public final synchronized void zzO(zzbdi zzbdi) {
        Preconditions.checkMainThread("setOnCustomRenderedAdLoadedListener must be called on the main UI thread.");
        this.zzb.zzq(zzbdi);
    }

    public final void zzP(zzdr zzdr) {
        if (zzm()) {
            Preconditions.checkMainThread("setPaidEventListener must be called on the main UI thread.");
        }
        try {
            if (!zzdr.zzf()) {
                this.zzh.zze();
            }
        } catch (RemoteException e) {
            zzm.zzf("Error in making CSI ping for reporting paid event callback", e);
        }
        this.zzd.zzl(zzdr);
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
        if (zzm()) {
            Preconditions.checkMainThread("setVideoOptions must be called on the main UI thread.");
        }
        this.zzf.zzI(zzga);
    }

    public final void zzW(IObjectWrapper iObjectWrapper) {
    }

    public final void zzX() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x000f, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean zzY() {
        /*
            r1 = this;
            monitor-enter(r1)
            com.google.android.gms.internal.ads.zzcpd r0 = r1.zzi     // Catch:{ all -> 0x0011 }
            if (r0 == 0) goto L_0x000e
            boolean r0 = r0.zzs()     // Catch:{ all -> 0x0011 }
            if (r0 == 0) goto L_0x000e
            monitor-exit(r1)
            r0 = 1
            return r0
        L_0x000e:
            monitor-exit(r1)
            r0 = 0
            return r0
        L_0x0011:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0011 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzely.zzY():boolean");
    }

    public final synchronized boolean zzZ() {
        return this.zzb.zza();
    }

    public final synchronized void zza() {
        if (this.zzb.zzt()) {
            zzs zzh2 = this.zzf.zzh();
            zzcpd zzcpd = this.zzi;
            if (!(zzcpd == null || zzcpd.zzg() == null || !this.zzf.zzT())) {
                zzh2 = zzffu.zza(this.zza, Collections.singletonList(this.zzi.zzg()));
            }
            zzf(zzh2);
            this.zzf.zzx(true);
            try {
                zzh(this.zzf.zzf());
            } catch (RemoteException unused) {
                zzm.zzj("Failed to refresh the banner ad.");
            }
            this.zzf.zzx(false);
            return;
        }
        this.zzb.zzm();
    }

    public final boolean zzaa() {
        return false;
    }

    public final synchronized boolean zzab(com.google.android.gms.ads.internal.client.zzm zzm) throws RemoteException {
        zzf(this.zze);
        return zzh(zzm);
    }

    public final synchronized void zzac(zzcq zzcq) {
        Preconditions.checkMainThread("setCorrelationIdProvider must be called on the main UI thread");
        this.zzf.zzV(zzcq);
    }

    public final synchronized void zzb() throws ExecutionException, InterruptedException {
        if (this.zzb.zzt()) {
            this.zzb.zzr();
        } else {
            this.zzb.zzn();
        }
    }

    public final Bundle zzd() {
        Preconditions.checkMainThread("getAdMetadata must be called on the main UI thread.");
        return new Bundle();
    }

    public final synchronized zzs zzg() {
        Preconditions.checkMainThread("getAdSize must be called on the main UI thread.");
        zzcpd zzcpd = this.zzi;
        if (zzcpd != null) {
            return zzffu.zza(this.zza, Collections.singletonList(zzcpd.zzf()));
        }
        return this.zzf.zzh();
    }

    public final zzbl zzi() {
        return this.zzd.zzg();
    }

    public final zzcm zzj() {
        return this.zzd.zzi();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001f, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized com.google.android.gms.ads.internal.client.zzdy zzk() {
        /*
            r2 = this;
            monitor-enter(r2)
            com.google.android.gms.internal.ads.zzbce r0 = com.google.android.gms.internal.ads.zzbcn.zzgD     // Catch:{ all -> 0x0021 }
            com.google.android.gms.internal.ads.zzbcl r1 = com.google.android.gms.ads.internal.client.zzbe.zzc()     // Catch:{ all -> 0x0021 }
            java.lang.Object r0 = r1.zza(r0)     // Catch:{ all -> 0x0021 }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x0021 }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x0021 }
            if (r0 != 0) goto L_0x0014
            goto L_0x001e
        L_0x0014:
            com.google.android.gms.internal.ads.zzcpd r0 = r2.zzi     // Catch:{ all -> 0x0021 }
            if (r0 == 0) goto L_0x001e
            com.google.android.gms.internal.ads.zzcwf r0 = r0.zzm()     // Catch:{ all -> 0x0021 }
            monitor-exit(r2)
            return r0
        L_0x001e:
            monitor-exit(r2)
            r0 = 0
            return r0
        L_0x0021:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0021 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzely.zzk():com.google.android.gms.ads.internal.client.zzdy");
    }

    public final synchronized zzeb zzl() {
        Preconditions.checkMainThread("getVideoController must be called from the main thread.");
        zzcpd zzcpd = this.zzi;
        if (zzcpd == null) {
            return null;
        }
        return zzcpd.zze();
    }

    public final IObjectWrapper zzn() {
        if (zzm()) {
            Preconditions.checkMainThread("getAdFrame must be called on the main UI thread.");
        }
        return ObjectWrapper.wrap(this.zzb.zzc());
    }

    public final synchronized String zzr() {
        return this.zzc;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0016, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized java.lang.String zzs() {
        /*
            r2 = this;
            monitor-enter(r2)
            com.google.android.gms.internal.ads.zzcpd r0 = r2.zzi     // Catch:{ all -> 0x0018 }
            if (r0 == 0) goto L_0x0015
            com.google.android.gms.internal.ads.zzcwf r1 = r0.zzm()     // Catch:{ all -> 0x0018 }
            if (r1 == 0) goto L_0x0015
            com.google.android.gms.internal.ads.zzcwf r0 = r0.zzm()     // Catch:{ all -> 0x0018 }
            java.lang.String r0 = r0.zzg()     // Catch:{ all -> 0x0018 }
            monitor-exit(r2)
            return r0
        L_0x0015:
            monitor-exit(r2)
            r0 = 0
            return r0
        L_0x0018:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0018 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzely.zzs():java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0016, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized java.lang.String zzt() {
        /*
            r2 = this;
            monitor-enter(r2)
            com.google.android.gms.internal.ads.zzcpd r0 = r2.zzi     // Catch:{ all -> 0x0018 }
            if (r0 == 0) goto L_0x0015
            com.google.android.gms.internal.ads.zzcwf r1 = r0.zzm()     // Catch:{ all -> 0x0018 }
            if (r1 == 0) goto L_0x0015
            com.google.android.gms.internal.ads.zzcwf r0 = r0.zzm()     // Catch:{ all -> 0x0018 }
            java.lang.String r0 = r0.zzg()     // Catch:{ all -> 0x0018 }
            monitor-exit(r2)
            return r0
        L_0x0015:
            monitor-exit(r2)
            r0 = 0
            return r0
        L_0x0018:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0018 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzely.zzt():java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0035, code lost:
        if (r3.zzg.clientJarVersion < ((java.lang.Integer) com.google.android.gms.ads.internal.client.zzbe.zzc().zza(com.google.android.gms.internal.ads.zzbcn.zzkR)).intValue()) goto L_0x0037;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzx() {
        /*
            r3 = this;
            monitor-enter(r3)
            com.google.android.gms.internal.ads.zzbdx r0 = com.google.android.gms.internal.ads.zzbel.zze     // Catch:{ all -> 0x0047 }
            java.lang.Object r0 = r0.zze()     // Catch:{ all -> 0x0047 }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x0047 }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x0047 }
            if (r0 == 0) goto L_0x0037
            com.google.android.gms.internal.ads.zzbce r0 = com.google.android.gms.internal.ads.zzbcn.zzkM     // Catch:{ all -> 0x0047 }
            com.google.android.gms.internal.ads.zzbcl r1 = com.google.android.gms.ads.internal.client.zzbe.zzc()     // Catch:{ all -> 0x0047 }
            java.lang.Object r0 = r1.zza(r0)     // Catch:{ all -> 0x0047 }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x0047 }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x0047 }
            if (r0 == 0) goto L_0x0037
            com.google.android.gms.ads.internal.util.client.VersionInfoParcel r0 = r3.zzg     // Catch:{ all -> 0x0047 }
            int r0 = r0.clientJarVersion     // Catch:{ all -> 0x0047 }
            com.google.android.gms.internal.ads.zzbce r1 = com.google.android.gms.internal.ads.zzbcn.zzkR     // Catch:{ all -> 0x0047 }
            com.google.android.gms.internal.ads.zzbcl r2 = com.google.android.gms.ads.internal.client.zzbe.zzc()     // Catch:{ all -> 0x0047 }
            java.lang.Object r1 = r2.zza(r1)     // Catch:{ all -> 0x0047 }
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch:{ all -> 0x0047 }
            int r1 = r1.intValue()     // Catch:{ all -> 0x0047 }
            if (r0 >= r1) goto L_0x003c
        L_0x0037:
            java.lang.String r0 = "destroy must be called on the main UI thread."
            com.google.android.gms.common.internal.Preconditions.checkMainThread(r0)     // Catch:{ all -> 0x0047 }
        L_0x003c:
            com.google.android.gms.internal.ads.zzcpd r0 = r3.zzi     // Catch:{ all -> 0x0047 }
            if (r0 == 0) goto L_0x0045
            r0.zzb()     // Catch:{ all -> 0x0047 }
            monitor-exit(r3)
            return
        L_0x0045:
            monitor-exit(r3)
            return
        L_0x0047:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0047 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzely.zzx():void");
    }

    public final void zzy(com.google.android.gms.ads.internal.client.zzm zzm, zzbo zzbo) {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0035, code lost:
        if (r3.zzg.clientJarVersion < ((java.lang.Integer) com.google.android.gms.ads.internal.client.zzbe.zzc().zza(com.google.android.gms.internal.ads.zzbcn.zzkR)).intValue()) goto L_0x0037;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzz() {
        /*
            r3 = this;
            monitor-enter(r3)
            com.google.android.gms.internal.ads.zzbdx r0 = com.google.android.gms.internal.ads.zzbel.zzg     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r0.zze()     // Catch:{ all -> 0x004c }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x004c }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x004c }
            if (r0 == 0) goto L_0x0037
            com.google.android.gms.internal.ads.zzbce r0 = com.google.android.gms.internal.ads.zzbcn.zzkN     // Catch:{ all -> 0x004c }
            com.google.android.gms.internal.ads.zzbcl r1 = com.google.android.gms.ads.internal.client.zzbe.zzc()     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r1.zza(r0)     // Catch:{ all -> 0x004c }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x004c }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x004c }
            if (r0 == 0) goto L_0x0037
            com.google.android.gms.ads.internal.util.client.VersionInfoParcel r0 = r3.zzg     // Catch:{ all -> 0x004c }
            int r0 = r0.clientJarVersion     // Catch:{ all -> 0x004c }
            com.google.android.gms.internal.ads.zzbce r1 = com.google.android.gms.internal.ads.zzbcn.zzkR     // Catch:{ all -> 0x004c }
            com.google.android.gms.internal.ads.zzbcl r2 = com.google.android.gms.ads.internal.client.zzbe.zzc()     // Catch:{ all -> 0x004c }
            java.lang.Object r1 = r2.zza(r1)     // Catch:{ all -> 0x004c }
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch:{ all -> 0x004c }
            int r1 = r1.intValue()     // Catch:{ all -> 0x004c }
            if (r0 >= r1) goto L_0x003c
        L_0x0037:
            java.lang.String r0 = "pause must be called on the main UI thread."
            com.google.android.gms.common.internal.Preconditions.checkMainThread(r0)     // Catch:{ all -> 0x004c }
        L_0x003c:
            com.google.android.gms.internal.ads.zzcpd r0 = r3.zzi     // Catch:{ all -> 0x004c }
            if (r0 == 0) goto L_0x004a
            com.google.android.gms.internal.ads.zzcxl r0 = r0.zzn()     // Catch:{ all -> 0x004c }
            r1 = 0
            r0.zzb(r1)     // Catch:{ all -> 0x004c }
            monitor-exit(r3)
            return
        L_0x004a:
            monitor-exit(r3)
            return
        L_0x004c:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x004c }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzely.zzz():void");
    }
}
