package com.google.android.gms.internal.ads;

import android.app.Activity;
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
import com.google.android.gms.ads.internal.client.zze;
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

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzena extends zzbx {
    private final zzs zza;
    private final Context zzb;
    private final zzfcw zzc;
    private final String zzd;
    private final VersionInfoParcel zze;
    private final zzems zzf;
    private final zzfdw zzg;
    private final zzavc zzh;
    private final zzdsm zzi;
    /* access modifiers changed from: private */
    public zzdfj zzj;
    private boolean zzk = ((Boolean) zzbe.zzc().zza(zzbcn.zzaL)).booleanValue();

    public zzena(Context context, zzs zzs, String str, zzfcw zzfcw, zzems zzems, zzfdw zzfdw, VersionInfoParcel versionInfoParcel, zzavc zzavc, zzdsm zzdsm) {
        this.zza = zzs;
        this.zzd = str;
        this.zzb = context;
        this.zzc = zzfcw;
        this.zzf = zzems;
        this.zzg = zzfdw;
        this.zze = versionInfoParcel;
        this.zzh = zzavc;
        this.zzi = zzdsm;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x000f, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final synchronized boolean zze() {
        /*
            r1 = this;
            monitor-enter(r1)
            com.google.android.gms.internal.ads.zzdfj r0 = r1.zzj     // Catch:{ all -> 0x0011 }
            if (r0 == 0) goto L_0x000e
            boolean r0 = r0.zza()     // Catch:{ all -> 0x0011 }
            if (r0 != 0) goto L_0x000e
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzena.zze():boolean");
    }

    public final void zzA() {
    }

    public final synchronized void zzB() {
        Preconditions.checkMainThread("resume must be called on the main UI thread.");
        zzdfj zzdfj = this.zzj;
        if (zzdfj != null) {
            zzdfj.zzn().zzc((Context) null);
        }
    }

    public final void zzC(zzbi zzbi) {
    }

    public final void zzD(zzbl zzbl) {
        Preconditions.checkMainThread("setAdListener must be called on the main UI thread.");
        this.zzf.zzj(zzbl);
    }

    public final void zzE(zzcc zzcc) {
        Preconditions.checkMainThread("setAdMetadataListener must be called on the main UI thread.");
    }

    public final void zzF(zzs zzs) {
    }

    public final void zzG(zzcm zzcm) {
        Preconditions.checkMainThread("setAppEventListener must be called on the main UI thread.");
        this.zzf.zzm(zzcm);
    }

    public final void zzH(zzbai zzbai) {
    }

    public final void zzI(zzy zzy) {
    }

    public final void zzJ(zzct zzct) {
        this.zzf.zzn(zzct);
    }

    public final void zzK(zzef zzef) {
    }

    public final synchronized void zzL(boolean z) {
        Preconditions.checkMainThread("setImmersiveMode must be called on the main UI thread.");
        this.zzk = z;
    }

    public final void zzM(zzbtp zzbtp) {
    }

    public final void zzN(boolean z) {
    }

    public final synchronized void zzO(zzbdi zzbdi) {
        Preconditions.checkMainThread("setOnCustomRenderedAdLoadedListener must be called on the main UI thread.");
        this.zzc.zzi(zzbdi);
    }

    public final void zzP(zzdr zzdr) {
        Preconditions.checkMainThread("setPaidEventListener must be called on the main UI thread.");
        try {
            if (!zzdr.zzf()) {
                this.zzi.zze();
            }
        } catch (RemoteException e) {
            zzm.zzf("Error in making CSI ping for reporting paid event callback", e);
        }
        this.zzf.zzl(zzdr);
    }

    public final void zzQ(zzbts zzbts, String str) {
    }

    public final void zzR(String str) {
    }

    public final void zzS(zzbwp zzbwp) {
        this.zzg.zzm(zzbwp);
    }

    public final void zzT(String str) {
    }

    public final void zzU(zzga zzga) {
    }

    public final synchronized void zzW(IObjectWrapper iObjectWrapper) {
        if (this.zzj == null) {
            zzm.zzj("Interstitial can not be shown before loaded.");
            this.zzf.zzq(zzfgq.zzd(9, (String) null, (zze) null));
            return;
        }
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzcS)).booleanValue()) {
            this.zzh.zzc().zzn(new Throwable().getStackTrace());
        }
        this.zzj.zzc(this.zzk, (Activity) ObjectWrapper.unwrap(iObjectWrapper));
    }

    public final synchronized void zzX() {
        Preconditions.checkMainThread("showInterstitial must be called on the main UI thread.");
        if (this.zzj == null) {
            zzm.zzj("Interstitial can not be shown before loaded.");
            this.zzf.zzq(zzfgq.zzd(9, (String) null, (zze) null));
            return;
        }
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzcS)).booleanValue()) {
            this.zzh.zzc().zzn(new Throwable().getStackTrace());
        }
        this.zzj.zzc(this.zzk, (Activity) null);
    }

    public final synchronized boolean zzY() {
        return false;
    }

    public final synchronized boolean zzZ() {
        return this.zzc.zza();
    }

    public final synchronized boolean zzaa() {
        Preconditions.checkMainThread("isLoaded must be called on the main UI thread.");
        return zze();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0091, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean zzab(com.google.android.gms.ads.internal.client.zzm r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            boolean r0 = r6.zzb()     // Catch:{ all -> 0x0092 }
            r1 = 0
            if (r0 == 0) goto L_0x0009
            goto L_0x0049
        L_0x0009:
            com.google.android.gms.internal.ads.zzbdx r0 = com.google.android.gms.internal.ads.zzbel.zzi     // Catch:{ all -> 0x0092 }
            java.lang.Object r0 = r0.zze()     // Catch:{ all -> 0x0092 }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x0092 }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x0092 }
            if (r0 == 0) goto L_0x002b
            com.google.android.gms.internal.ads.zzbce r0 = com.google.android.gms.internal.ads.zzbcn.zzkP     // Catch:{ all -> 0x0092 }
            com.google.android.gms.internal.ads.zzbcl r2 = com.google.android.gms.ads.internal.client.zzbe.zzc()     // Catch:{ all -> 0x0092 }
            java.lang.Object r0 = r2.zza(r0)     // Catch:{ all -> 0x0092 }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x0092 }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x0092 }
            if (r0 == 0) goto L_0x002b
            r0 = 1
            goto L_0x002c
        L_0x002b:
            r0 = r1
        L_0x002c:
            com.google.android.gms.ads.internal.util.client.VersionInfoParcel r2 = r5.zze     // Catch:{ all -> 0x0092 }
            int r2 = r2.clientJarVersion     // Catch:{ all -> 0x0092 }
            com.google.android.gms.internal.ads.zzbce r3 = com.google.android.gms.internal.ads.zzbcn.zzkQ     // Catch:{ all -> 0x0092 }
            com.google.android.gms.internal.ads.zzbcl r4 = com.google.android.gms.ads.internal.client.zzbe.zzc()     // Catch:{ all -> 0x0092 }
            java.lang.Object r3 = r4.zza(r3)     // Catch:{ all -> 0x0092 }
            java.lang.Integer r3 = (java.lang.Integer) r3     // Catch:{ all -> 0x0092 }
            int r3 = r3.intValue()     // Catch:{ all -> 0x0092 }
            if (r2 < r3) goto L_0x0044
            if (r0 != 0) goto L_0x0049
        L_0x0044:
            java.lang.String r0 = "loadAd must be called on the main UI thread."
            com.google.android.gms.common.internal.Preconditions.checkMainThread(r0)     // Catch:{ all -> 0x0092 }
        L_0x0049:
            com.google.android.gms.ads.internal.zzv.zzq()     // Catch:{ all -> 0x0092 }
            android.content.Context r0 = r5.zzb     // Catch:{ all -> 0x0092 }
            boolean r0 = com.google.android.gms.ads.internal.util.zzs.zzH(r0)     // Catch:{ all -> 0x0092 }
            r2 = 0
            if (r0 == 0) goto L_0x006b
            com.google.android.gms.ads.internal.client.zzc r0 = r6.zzs     // Catch:{ all -> 0x0092 }
            if (r0 != 0) goto L_0x006b
            java.lang.String r6 = "Failed to load the ad because app ID is missing."
            com.google.android.gms.ads.internal.util.client.zzm.zzg(r6)     // Catch:{ all -> 0x0092 }
            com.google.android.gms.internal.ads.zzems r6 = r5.zzf     // Catch:{ all -> 0x0092 }
            if (r6 == 0) goto L_0x0090
            r0 = 4
            com.google.android.gms.ads.internal.client.zze r0 = com.google.android.gms.internal.ads.zzfgq.zzd(r0, r2, r2)     // Catch:{ all -> 0x0092 }
            r6.zzdB(r0)     // Catch:{ all -> 0x0092 }
            goto L_0x0090
        L_0x006b:
            boolean r0 = r5.zze()     // Catch:{ all -> 0x0092 }
            if (r0 != 0) goto L_0x0090
            android.content.Context r0 = r5.zzb     // Catch:{ all -> 0x0092 }
            boolean r1 = r6.zzf     // Catch:{ all -> 0x0092 }
            com.google.android.gms.internal.ads.zzfgl.zza(r0, r1)     // Catch:{ all -> 0x0092 }
            r5.zzj = r2     // Catch:{ all -> 0x0092 }
            com.google.android.gms.internal.ads.zzfcw r0 = r5.zzc     // Catch:{ all -> 0x0092 }
            java.lang.String r1 = r5.zzd     // Catch:{ all -> 0x0092 }
            com.google.android.gms.ads.internal.client.zzs r2 = r5.zza     // Catch:{ all -> 0x0092 }
            com.google.android.gms.internal.ads.zzfcp r3 = new com.google.android.gms.internal.ads.zzfcp     // Catch:{ all -> 0x0092 }
            r3.<init>(r2)     // Catch:{ all -> 0x0092 }
            com.google.android.gms.internal.ads.zzemz r2 = new com.google.android.gms.internal.ads.zzemz     // Catch:{ all -> 0x0092 }
            r2.<init>(r5)     // Catch:{ all -> 0x0092 }
            boolean r6 = r0.zzb(r6, r1, r3, r2)     // Catch:{ all -> 0x0092 }
            monitor-exit(r5)
            return r6
        L_0x0090:
            monitor-exit(r5)
            return r1
        L_0x0092:
            r6 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x0092 }
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzena.zzab(com.google.android.gms.ads.internal.client.zzm):boolean");
    }

    public final void zzac(zzcq zzcq) {
    }

    public final Bundle zzd() {
        Preconditions.checkMainThread("getAdMetadata must be called on the main UI thread.");
        return new Bundle();
    }

    public final zzs zzg() {
        return null;
    }

    public final zzbl zzi() {
        return this.zzf.zzg();
    }

    public final zzcm zzj() {
        return this.zzf.zzi();
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
            com.google.android.gms.internal.ads.zzdfj r0 = r2.zzj     // Catch:{ all -> 0x0021 }
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzena.zzk():com.google.android.gms.ads.internal.client.zzdy");
    }

    public final zzeb zzl() {
        return null;
    }

    public final IObjectWrapper zzn() {
        return null;
    }

    public final synchronized String zzr() {
        return this.zzd;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0016, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized java.lang.String zzs() {
        /*
            r2 = this;
            monitor-enter(r2)
            com.google.android.gms.internal.ads.zzdfj r0 = r2.zzj     // Catch:{ all -> 0x0018 }
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzena.zzs():java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0016, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized java.lang.String zzt() {
        /*
            r2 = this;
            monitor-enter(r2)
            com.google.android.gms.internal.ads.zzdfj r0 = r2.zzj     // Catch:{ all -> 0x0018 }
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzena.zzt():java.lang.String");
    }

    public final synchronized void zzx() {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        zzdfj zzdfj = this.zzj;
        if (zzdfj != null) {
            zzdfj.zzn().zza((Context) null);
        }
    }

    public final void zzy(com.google.android.gms.ads.internal.client.zzm zzm, zzbo zzbo) {
        this.zzf.zzk(zzbo);
        zzab(zzm);
    }

    public final synchronized void zzz() {
        Preconditions.checkMainThread("pause must be called on the main UI thread.");
        zzdfj zzdfj = this.zzj;
        if (zzdfj != null) {
            zzdfj.zzn().zzb((Context) null);
        }
    }
}
