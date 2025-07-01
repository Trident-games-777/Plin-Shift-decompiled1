package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.client.zzdd;
import com.google.android.gms.ads.internal.client.zzdh;
import com.google.android.gms.ads.internal.client.zzdr;
import com.google.android.gms.ads.internal.client.zzdy;
import com.google.android.gms.ads.internal.client.zzeb;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzdnm extends zzbhu {
    private final String zza;
    private final zzdit zzb;
    private final zzdiy zzc;
    private final zzdsm zzd;

    public zzdnm(String str, zzdit zzdit, zzdiy zzdiy, zzdsm zzdsm) {
        this.zza = str;
        this.zzb = zzdit;
        this.zzc = zzdiy;
        this.zzd = zzdsm;
    }

    public final void zzA() {
        this.zzb.zzH();
    }

    public final void zzB(Bundle bundle) {
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzmF)).booleanValue()) {
            this.zzb.zzI(bundle);
        }
    }

    public final void zzC(Bundle bundle) throws RemoteException {
        this.zzb.zzM(bundle);
    }

    public final void zzD() {
        this.zzb.zzO();
    }

    public final void zzE(zzdd zzdd) throws RemoteException {
        this.zzb.zzP(zzdd);
    }

    public final void zzF(zzdr zzdr) throws RemoteException {
        try {
            if (!zzdr.zzf()) {
                this.zzd.zze();
            }
        } catch (RemoteException e) {
            zzm.zzf("Error in making CSI ping for reporting paid event callback", e);
        }
        this.zzb.zzQ(zzdr);
    }

    public final void zzG(zzbhs zzbhs) throws RemoteException {
        this.zzb.zzR(zzbhs);
    }

    public final boolean zzH() {
        return this.zzb.zzW();
    }

    public final boolean zzI() throws RemoteException {
        return !this.zzc.zzH().isEmpty() && this.zzc.zzk() != null;
    }

    public final boolean zzJ(Bundle bundle) throws RemoteException {
        return this.zzb.zzZ(bundle);
    }

    public final double zze() throws RemoteException {
        return this.zzc.zza();
    }

    public final Bundle zzf() throws RemoteException {
        return this.zzc.zzd();
    }

    public final zzdy zzg() throws RemoteException {
        if (!((Boolean) zzbe.zzc().zza(zzbcn.zzgD)).booleanValue()) {
            return null;
        }
        return this.zzb.zzm();
    }

    public final zzeb zzh() throws RemoteException {
        return this.zzc.zzj();
    }

    public final zzbfr zzi() throws RemoteException {
        return this.zzc.zzl();
    }

    public final zzbfv zzj() throws RemoteException {
        return this.zzb.zzc().zza();
    }

    public final zzbfy zzk() throws RemoteException {
        return this.zzc.zzn();
    }

    public final IObjectWrapper zzl() throws RemoteException {
        return this.zzc.zzv();
    }

    public final IObjectWrapper zzm() throws RemoteException {
        return ObjectWrapper.wrap(this.zzb);
    }

    public final String zzn() throws RemoteException {
        return this.zzc.zzx();
    }

    public final String zzo() throws RemoteException {
        return this.zzc.zzy();
    }

    public final String zzp() throws RemoteException {
        return this.zzc.zzz();
    }

    public final String zzq() throws RemoteException {
        return this.zzc.zzB();
    }

    public final String zzr() throws RemoteException {
        return this.zza;
    }

    public final String zzs() throws RemoteException {
        return this.zzc.zzD();
    }

    public final String zzt() throws RemoteException {
        return this.zzc.zzE();
    }

    public final List zzu() throws RemoteException {
        return this.zzc.zzG();
    }

    public final List zzv() throws RemoteException {
        if (zzI()) {
            return this.zzc.zzH();
        }
        return Collections.emptyList();
    }

    public final void zzw() throws RemoteException {
        this.zzb.zzv();
    }

    public final void zzx() throws RemoteException {
        this.zzb.zzb();
    }

    public final void zzy(zzdh zzdh) throws RemoteException {
        this.zzb.zzC(zzdh);
    }

    public final void zzz(Bundle bundle) throws RemoteException {
        this.zzb.zzG(bundle);
    }
}
