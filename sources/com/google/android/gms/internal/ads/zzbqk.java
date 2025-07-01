package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.ads.mediation.Adapter;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
public final class zzbqk extends zzbpl {
    private final Adapter zza;
    private final zzbwu zzb;

    zzbqk(Adapter adapter, zzbwu zzbwu) {
        this.zza = adapter;
        this.zzb = zzbwu;
    }

    public final void zze() throws RemoteException {
        zzbwu zzbwu = this.zzb;
        if (zzbwu != null) {
            zzbwu.zze(ObjectWrapper.wrap(this.zza));
        }
    }

    public final void zzf() throws RemoteException {
        zzbwu zzbwu = this.zzb;
        if (zzbwu != null) {
            zzbwu.zzf(ObjectWrapper.wrap(this.zza));
        }
    }

    public final void zzg(int i) throws RemoteException {
        zzbwu zzbwu = this.zzb;
        if (zzbwu != null) {
            zzbwu.zzg(ObjectWrapper.wrap(this.zza), i);
        }
    }

    public final void zzh(zze zze) throws RemoteException {
    }

    public final void zzi(int i, String str) throws RemoteException {
    }

    public final void zzj(int i) throws RemoteException {
    }

    public final void zzk(zze zze) {
    }

    public final void zzl(String str) {
    }

    public final void zzm() throws RemoteException {
    }

    public final void zzn() throws RemoteException {
    }

    public final void zzo() throws RemoteException {
        zzbwu zzbwu = this.zzb;
        if (zzbwu != null) {
            zzbwu.zzi(ObjectWrapper.wrap(this.zza));
        }
    }

    public final void zzp() throws RemoteException {
        zzbwu zzbwu = this.zzb;
        if (zzbwu != null) {
            zzbwu.zzj(ObjectWrapper.wrap(this.zza));
        }
    }

    public final void zzq(String str, String str2) throws RemoteException {
    }

    public final void zzr(zzbgs zzbgs, String str) throws RemoteException {
    }

    public final void zzs(zzbwv zzbwv) throws RemoteException {
    }

    public final void zzt(zzbwz zzbwz) throws RemoteException {
        zzbwu zzbwu = this.zzb;
        if (zzbwu != null) {
            zzbwu.zzm(ObjectWrapper.wrap(this.zza), new zzbwv(zzbwz.zzf(), zzbwz.zze()));
        }
    }

    public final void zzu() throws RemoteException {
        zzbwu zzbwu = this.zzb;
        if (zzbwu != null) {
            zzbwu.zzn(ObjectWrapper.wrap(this.zza));
        }
    }

    public final void zzv() throws RemoteException {
    }

    public final void zzw() throws RemoteException {
    }

    public final void zzx() throws RemoteException {
    }

    public final void zzy() throws RemoteException {
        zzbwu zzbwu = this.zzb;
        if (zzbwu != null) {
            zzbwu.zzo(ObjectWrapper.wrap(this.zza));
        }
    }
}
