package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
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
import com.google.android.gms.ads.internal.client.zzeb;
import com.google.android.gms.ads.internal.client.zzef;
import com.google.android.gms.ads.internal.client.zzga;
import com.google.android.gms.ads.internal.client.zzs;
import com.google.android.gms.ads.internal.client.zzy;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Collections;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzelt extends zzbx {
    private final Context zza;
    private final zzbl zzb;
    private final zzffo zzc;
    private final zzcpd zzd;
    private final ViewGroup zze;
    private final zzdsm zzf;

    public zzelt(Context context, zzbl zzbl, zzffo zzffo, zzcpd zzcpd, zzdsm zzdsm) {
        this.zza = context;
        this.zzb = zzbl;
        this.zzc = zzffo;
        this.zzd = zzcpd;
        this.zzf = zzdsm;
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.removeAllViews();
        View zzd2 = zzcpd.zzd();
        zzv.zzq();
        frameLayout.addView(zzd2, new ViewGroup.LayoutParams(-1, -1));
        frameLayout.setMinimumHeight(zzg().zzc);
        frameLayout.setMinimumWidth(zzg().zzf);
        this.zze = frameLayout;
    }

    public final void zzA() throws RemoteException {
        this.zzd.zzh();
    }

    public final void zzB() throws RemoteException {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        this.zzd.zzn().zzc((Context) null);
    }

    public final void zzC(zzbi zzbi) throws RemoteException {
        zzm.zzi("setAdClickListener is not supported in Ad Manager AdView returned by AdLoader.");
    }

    public final void zzD(zzbl zzbl) throws RemoteException {
        zzm.zzi("setAdListener is not supported in Ad Manager AdView returned by AdLoader.");
    }

    public final void zzE(zzcc zzcc) throws RemoteException {
        zzm.zzi("setAdMetadataListener is not supported in Ad Manager AdView returned by AdLoader.");
    }

    public final void zzF(zzs zzs) throws RemoteException {
        Preconditions.checkMainThread("setAdSize must be called on the main UI thread.");
        zzcpd zzcpd = this.zzd;
        if (zzcpd != null) {
            zzcpd.zzi(this.zze, zzs);
        }
    }

    public final void zzG(zzcm zzcm) throws RemoteException {
        zzems zzems = this.zzc.zzc;
        if (zzems != null) {
            zzems.zzm(zzcm);
        }
    }

    public final void zzH(zzbai zzbai) throws RemoteException {
    }

    public final void zzI(zzy zzy) throws RemoteException {
    }

    public final void zzJ(zzct zzct) {
    }

    public final void zzK(zzef zzef) throws RemoteException {
    }

    public final void zzL(boolean z) throws RemoteException {
    }

    public final void zzM(zzbtp zzbtp) throws RemoteException {
    }

    public final void zzN(boolean z) throws RemoteException {
        zzm.zzi("setManualImpressionsEnabled is not supported in Ad Manager AdView returned by AdLoader.");
    }

    public final void zzO(zzbdi zzbdi) throws RemoteException {
        zzm.zzi("setOnCustomRenderedAdLoadedListener is not supported in Ad Manager AdView returned by AdLoader.");
    }

    public final void zzP(zzdr zzdr) {
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzll)).booleanValue()) {
            zzems zzems = this.zzc.zzc;
            if (zzems != null) {
                try {
                    if (!zzdr.zzf()) {
                        this.zzf.zze();
                    }
                } catch (RemoteException e) {
                    zzm.zzf("Error in making CSI ping for reporting paid event callback", e);
                }
                zzems.zzl(zzdr);
                return;
            }
            return;
        }
        zzm.zzi("setOnPaidEventListener is not supported in Ad Manager AdView returned by AdLoader.");
    }

    public final void zzQ(zzbts zzbts, String str) throws RemoteException {
    }

    public final void zzR(String str) throws RemoteException {
    }

    public final void zzS(zzbwp zzbwp) throws RemoteException {
    }

    public final void zzT(String str) throws RemoteException {
    }

    public final void zzU(zzga zzga) throws RemoteException {
        zzm.zzi("setVideoOptions is not supported in Ad Manager AdView returned by AdLoader.");
    }

    public final void zzW(IObjectWrapper iObjectWrapper) {
    }

    public final void zzX() throws RemoteException {
    }

    public final boolean zzY() throws RemoteException {
        zzcpd zzcpd = this.zzd;
        return zzcpd != null && zzcpd.zzs();
    }

    public final boolean zzZ() throws RemoteException {
        return false;
    }

    public final boolean zzaa() throws RemoteException {
        return false;
    }

    public final boolean zzab(com.google.android.gms.ads.internal.client.zzm zzm) throws RemoteException {
        zzm.zzi("loadAd is not supported for an Ad Manager AdView returned from AdLoader.");
        return false;
    }

    public final void zzac(zzcq zzcq) throws RemoteException {
        zzm.zzi("setCorrelationIdProvider is not supported in Ad Manager AdView returned by AdLoader.");
    }

    public final Bundle zzd() throws RemoteException {
        zzm.zzi("getAdMetadata is not supported in Ad Manager AdView returned by AdLoader.");
        return new Bundle();
    }

    public final zzs zzg() {
        Preconditions.checkMainThread("getAdSize must be called on the main UI thread.");
        return zzffu.zza(this.zza, Collections.singletonList(this.zzd.zzf()));
    }

    public final zzbl zzi() throws RemoteException {
        return this.zzb;
    }

    public final zzcm zzj() throws RemoteException {
        return this.zzc.zzn;
    }

    public final zzdy zzk() {
        return this.zzd.zzm();
    }

    public final zzeb zzl() throws RemoteException {
        return this.zzd.zze();
    }

    public final IObjectWrapper zzn() throws RemoteException {
        return ObjectWrapper.wrap(this.zze);
    }

    public final String zzr() throws RemoteException {
        return this.zzc.zzf;
    }

    public final String zzs() throws RemoteException {
        if (this.zzd.zzm() != null) {
            return this.zzd.zzm().zzg();
        }
        return null;
    }

    public final String zzt() throws RemoteException {
        if (this.zzd.zzm() != null) {
            return this.zzd.zzm().zzg();
        }
        return null;
    }

    public final void zzx() throws RemoteException {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        this.zzd.zzb();
    }

    public final void zzy(com.google.android.gms.ads.internal.client.zzm zzm, zzbo zzbo) {
    }

    public final void zzz() throws RemoteException {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        this.zzd.zzn().zzb((Context) null);
    }
}
