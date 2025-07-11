package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zze;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
public final class zzbpk extends zzayc implements zzbpm {
    zzbpk(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
    }

    public final void zze() throws RemoteException {
        zzdc(1, zza());
    }

    public final void zzf() throws RemoteException {
        zzdc(2, zza());
    }

    public final void zzg(int i) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(i);
        zzdc(3, zza);
    }

    public final void zzh(zze zze) throws RemoteException {
        Parcel zza = zza();
        zzaye.zzd(zza, zze);
        zzdc(23, zza);
    }

    public final void zzi(int i, String str) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(i);
        zza.writeString(str);
        zzdc(22, zza);
    }

    public final void zzj(int i) throws RemoteException {
        throw null;
    }

    public final void zzk(zze zze) throws RemoteException {
        Parcel zza = zza();
        zzaye.zzd(zza, zze);
        zzdc(24, zza);
    }

    public final void zzl(String str) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzdc(21, zza);
    }

    public final void zzm() throws RemoteException {
        zzdc(8, zza());
    }

    public final void zzn() throws RemoteException {
        zzdc(4, zza());
    }

    public final void zzo() throws RemoteException {
        zzdc(6, zza());
    }

    public final void zzp() throws RemoteException {
        zzdc(5, zza());
    }

    public final void zzq(String str, String str2) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzdc(9, zza);
    }

    public final void zzr(zzbgs zzbgs, String str) throws RemoteException {
        Parcel zza = zza();
        zzaye.zzf(zza, zzbgs);
        zza.writeString(str);
        zzdc(10, zza);
    }

    public final void zzs(zzbwv zzbwv) throws RemoteException {
        throw null;
    }

    public final void zzt(zzbwz zzbwz) throws RemoteException {
        Parcel zza = zza();
        zzaye.zzf(zza, zzbwz);
        zzdc(16, zza);
    }

    public final void zzu() throws RemoteException {
        zzdc(18, zza());
    }

    public final void zzv() throws RemoteException {
        zzdc(11, zza());
    }

    public final void zzw() throws RemoteException {
        zzdc(15, zza());
    }

    public final void zzx() throws RemoteException {
        zzdc(20, zza());
    }

    public final void zzy() throws RemoteException {
        zzdc(13, zza());
    }
}
