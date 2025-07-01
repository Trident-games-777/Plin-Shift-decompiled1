package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzea;
import com.google.android.gms.ads.internal.client.zzeb;
import com.google.android.gms.ads.internal.client.zzm;
import com.google.android.gms.ads.internal.client.zzs;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
public final class zzbrd extends zzayc implements zzbrf {
    zzbrd(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.rtb.IRtbAdapter");
    }

    public final zzeb zze() throws RemoteException {
        Parcel zzdb = zzdb(5, zza());
        zzeb zzb = zzea.zzb(zzdb.readStrongBinder());
        zzdb.recycle();
        return zzb;
    }

    public final zzbru zzf() throws RemoteException {
        Parcel zzdb = zzdb(2, zza());
        zzbru zzbru = (zzbru) zzaye.zza(zzdb, zzbru.CREATOR);
        zzdb.recycle();
        return zzbru;
    }

    public final zzbru zzg() throws RemoteException {
        Parcel zzdb = zzdb(3, zza());
        zzbru zzbru = (zzbru) zzaye.zza(zzdb, zzbru.CREATOR);
        zzdb.recycle();
        return zzbru;
    }

    public final void zzh(IObjectWrapper iObjectWrapper, String str, Bundle bundle, Bundle bundle2, zzs zzs, zzbri zzbri) throws RemoteException {
        Parcel zza = zza();
        zzaye.zzf(zza, iObjectWrapper);
        zza.writeString(str);
        zzaye.zzd(zza, bundle);
        zzaye.zzd(zza, bundle2);
        zzaye.zzd(zza, zzs);
        zzaye.zzf(zza, zzbri);
        zzdc(1, zza);
    }

    public final void zzi(String str, String str2, zzm zzm, IObjectWrapper iObjectWrapper, zzbqq zzbqq, zzbpm zzbpm) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzaye.zzd(zza, zzm);
        zzaye.zzf(zza, iObjectWrapper);
        zzaye.zzf(zza, zzbqq);
        zzaye.zzf(zza, zzbpm);
        zzdc(23, zza);
    }

    public final void zzj(String str, String str2, zzm zzm, IObjectWrapper iObjectWrapper, zzbqt zzbqt, zzbpm zzbpm, zzs zzs) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzaye.zzd(zza, zzm);
        zzaye.zzf(zza, iObjectWrapper);
        zzaye.zzf(zza, zzbqt);
        zzaye.zzf(zza, zzbpm);
        zzaye.zzd(zza, zzs);
        zzdc(13, zza);
    }

    public final void zzk(String str, String str2, zzm zzm, IObjectWrapper iObjectWrapper, zzbqt zzbqt, zzbpm zzbpm, zzs zzs) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzaye.zzd(zza, zzm);
        zzaye.zzf(zza, iObjectWrapper);
        zzaye.zzf(zza, zzbqt);
        zzaye.zzf(zza, zzbpm);
        zzaye.zzd(zza, zzs);
        zzdc(21, zza);
    }

    public final void zzl(String str, String str2, zzm zzm, IObjectWrapper iObjectWrapper, zzbqw zzbqw, zzbpm zzbpm) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzaye.zzd(zza, zzm);
        zzaye.zzf(zza, iObjectWrapper);
        zzaye.zzf(zza, zzbqw);
        zzaye.zzf(zza, zzbpm);
        zzdc(14, zza);
    }

    public final void zzm(String str, String str2, zzm zzm, IObjectWrapper iObjectWrapper, zzbqz zzbqz, zzbpm zzbpm) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzaye.zzd(zza, zzm);
        zzaye.zzf(zza, iObjectWrapper);
        zzaye.zzf(zza, zzbqz);
        zzaye.zzf(zza, zzbpm);
        zzdc(18, zza);
    }

    public final void zzn(String str, String str2, zzm zzm, IObjectWrapper iObjectWrapper, zzbqz zzbqz, zzbpm zzbpm, zzbfn zzbfn) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzaye.zzd(zza, zzm);
        zzaye.zzf(zza, iObjectWrapper);
        zzaye.zzf(zza, zzbqz);
        zzaye.zzf(zza, zzbpm);
        zzaye.zzd(zza, zzbfn);
        zzdc(22, zza);
    }

    public final void zzo(String str, String str2, zzm zzm, IObjectWrapper iObjectWrapper, zzbrc zzbrc, zzbpm zzbpm) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzaye.zzd(zza, zzm);
        zzaye.zzf(zza, iObjectWrapper);
        zzaye.zzf(zza, zzbrc);
        zzaye.zzf(zza, zzbpm);
        zzdc(20, zza);
    }

    public final void zzp(String str, String str2, zzm zzm, IObjectWrapper iObjectWrapper, zzbrc zzbrc, zzbpm zzbpm) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzaye.zzd(zza, zzm);
        zzaye.zzf(zza, iObjectWrapper);
        zzaye.zzf(zza, zzbrc);
        zzaye.zzf(zza, zzbpm);
        zzdc(16, zza);
    }

    public final void zzq(String str) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzdc(19, zza);
    }

    public final boolean zzr(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzaye.zzf(zza, iObjectWrapper);
        Parcel zzdb = zzdb(24, zza);
        boolean zzg = zzaye.zzg(zzdb);
        zzdb.recycle();
        return zzg;
    }

    public final boolean zzs(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzaye.zzf(zza, iObjectWrapper);
        Parcel zzdb = zzdb(15, zza);
        boolean zzg = zzaye.zzg(zzdb);
        zzdb.recycle();
        return zzg;
    }

    public final boolean zzt(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzaye.zzf(zza, iObjectWrapper);
        Parcel zzdb = zzdb(17, zza);
        boolean zzg = zzaye.zzg(zzdb);
        zzdb.recycle();
        return zzg;
    }
}
