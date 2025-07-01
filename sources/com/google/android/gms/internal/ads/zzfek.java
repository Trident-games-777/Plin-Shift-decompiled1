package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.client.zzdo;
import com.google.android.gms.ads.internal.client.zzdr;
import com.google.android.gms.ads.internal.client.zzdy;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.ads.internal.client.zzm;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.ads.rewarded.OnAdMetadataChangedListener;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzfek extends zzbxb {
    private final zzfeg zza;
    private final zzfdw zzb;
    private final String zzc;
    /* access modifiers changed from: private */
    public final zzffg zzd;
    private final Context zze;
    private final VersionInfoParcel zzf;
    private final zzavc zzg;
    private final zzdsm zzh;
    /* access modifiers changed from: private */
    public zzdor zzi;
    private boolean zzj = ((Boolean) zzbe.zzc().zza(zzbcn.zzaL)).booleanValue();

    public zzfek(String str, zzfeg zzfeg, Context context, zzfdw zzfdw, zzffg zzffg, VersionInfoParcel versionInfoParcel, zzavc zzavc, zzdsm zzdsm) {
        this.zzc = str;
        this.zza = zzfeg;
        this.zzb = zzfdw;
        this.zzd = zzffg;
        this.zze = context;
        this.zzf = versionInfoParcel;
        this.zzg = zzavc;
        this.zzh = zzdsm;
    }

    private final synchronized void zzu(zzm zzm, zzbxj zzbxj, int i) throws RemoteException {
        if (!zzm.zzb()) {
            boolean z = false;
            if (((Boolean) zzbel.zzk.zze()).booleanValue()) {
                if (((Boolean) zzbe.zzc().zza(zzbcn.zzkP)).booleanValue()) {
                    z = true;
                }
            }
            if (this.zzf.clientJarVersion < ((Integer) zzbe.zzc().zza(zzbcn.zzkQ)).intValue() || !z) {
                Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
            }
        }
        this.zzb.zzk(zzbxj);
        zzv.zzq();
        if (zzs.zzH(this.zze)) {
            if (zzm.zzs == null) {
                com.google.android.gms.ads.internal.util.client.zzm.zzg("Failed to load the ad because app ID is missing.");
                this.zzb.zzdB(zzfgq.zzd(4, (String) null, (zze) null));
                return;
            }
        }
        if (this.zzi == null) {
            zzfdy zzfdy = new zzfdy((String) null);
            this.zza.zzj(i);
            this.zza.zzb(zzm, this.zzc, zzfdy, new zzfej(this));
        }
    }

    public final Bundle zzb() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzdor zzdor = this.zzi;
        return zzdor != null ? zzdor.zza() : new Bundle();
    }

    public final zzdy zzc() {
        zzdor zzdor;
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzgD)).booleanValue() && (zzdor = this.zzi) != null) {
            return zzdor.zzm();
        }
        return null;
    }

    public final zzbwz zzd() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzdor zzdor = this.zzi;
        if (zzdor != null) {
            return zzdor.zzc();
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0016, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized java.lang.String zze() throws android.os.RemoteException {
        /*
            r2 = this;
            monitor-enter(r2)
            com.google.android.gms.internal.ads.zzdor r0 = r2.zzi     // Catch:{ all -> 0x0018 }
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfek.zze():java.lang.String");
    }

    public final synchronized void zzf(zzm zzm, zzbxj zzbxj) throws RemoteException {
        zzu(zzm, zzbxj, 2);
    }

    public final synchronized void zzg(zzm zzm, zzbxj zzbxj) throws RemoteException {
        zzu(zzm, zzbxj, 3);
    }

    public final synchronized void zzh(boolean z) {
        Preconditions.checkMainThread("setImmersiveMode must be called on the main UI thread.");
        this.zzj = z;
    }

    public final void zzi(zzdo zzdo) {
        if (zzdo == null) {
            this.zzb.zzg((OnAdMetadataChangedListener) null);
        } else {
            this.zzb.zzg(new zzfei(this, zzdo));
        }
    }

    public final void zzj(zzdr zzdr) {
        Preconditions.checkMainThread("setOnPaidEventListener must be called on the main UI thread.");
        try {
            if (!zzdr.zzf()) {
                this.zzh.zze();
            }
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzm.zzf("Error in making CSI ping for reporting paid event callback", e);
        }
        this.zzb.zzi(zzdr);
    }

    public final void zzk(zzbxf zzbxf) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        this.zzb.zzj(zzbxf);
    }

    public final synchronized void zzl(zzbxq zzbxq) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzffg zzffg = this.zzd;
        zzffg.zza = zzbxq.zza;
        zzffg.zzb = zzbxq.zzb;
    }

    public final synchronized void zzm(IObjectWrapper iObjectWrapper) throws RemoteException {
        zzn(iObjectWrapper, this.zzj);
    }

    public final synchronized void zzn(IObjectWrapper iObjectWrapper, boolean z) throws RemoteException {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        if (this.zzi == null) {
            com.google.android.gms.ads.internal.util.client.zzm.zzj("Rewarded can not be shown before loaded");
            this.zzb.zzq(zzfgq.zzd(9, (String) null, (zze) null));
            return;
        }
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzcS)).booleanValue()) {
            this.zzg.zzc().zzn(new Throwable().getStackTrace());
        }
        this.zzi.zzh(z, (Activity) ObjectWrapper.unwrap(iObjectWrapper));
    }

    public final boolean zzo() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzdor zzdor = this.zzi;
        return zzdor != null && !zzdor.zzf();
    }

    public final void zzp(zzbxk zzbxk) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        this.zzb.zzo(zzbxk);
    }
}
