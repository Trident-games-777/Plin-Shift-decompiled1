package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzegy extends zzbwt implements zzcxw {
    private zzbwu zza;
    private zzcxv zzb;
    private zzdew zzc;

    public final synchronized void zza(zzcxv zzcxv) {
        this.zzb = zzcxv;
    }

    public final synchronized void zzc(zzbwu zzbwu) {
        this.zza = zzbwu;
    }

    public final synchronized void zzd(zzdew zzdew) {
        this.zzc = zzdew;
    }

    public final synchronized void zze(IObjectWrapper iObjectWrapper) throws RemoteException {
        zzbwu zzbwu = this.zza;
        if (zzbwu != null) {
            ((zzekd) zzbwu).zzb.onAdClicked();
        }
    }

    public final synchronized void zzf(IObjectWrapper iObjectWrapper) throws RemoteException {
        zzbwu zzbwu = this.zza;
        if (zzbwu != null) {
            zzbwu.zzf(iObjectWrapper);
        }
    }

    public final synchronized void zzg(IObjectWrapper iObjectWrapper, int i) throws RemoteException {
        zzcxv zzcxv = this.zzb;
        if (zzcxv != null) {
            zzcxv.zza(i);
        }
    }

    public final synchronized void zzh(IObjectWrapper iObjectWrapper) throws RemoteException {
        zzbwu zzbwu = this.zza;
        if (zzbwu != null) {
            ((zzekd) zzbwu).zzc.zzb();
        }
    }

    public final synchronized void zzi(IObjectWrapper iObjectWrapper) throws RemoteException {
        zzcxv zzcxv = this.zzb;
        if (zzcxv != null) {
            zzcxv.zzd();
        }
    }

    public final synchronized void zzj(IObjectWrapper iObjectWrapper) throws RemoteException {
        zzbwu zzbwu = this.zza;
        if (zzbwu != null) {
            ((zzekd) zzbwu).zza.zzdr();
        }
    }

    public final synchronized void zzk(IObjectWrapper iObjectWrapper, int i) throws RemoteException {
        zzdew zzdew = this.zzc;
        if (zzdew != null) {
            zzm.zzj("Fail to initialize adapter ".concat(String.valueOf(((zzekc) zzdew).zzc.zza)));
        }
    }

    public final synchronized void zzl(IObjectWrapper iObjectWrapper) throws RemoteException {
        zzdew zzdew = this.zzc;
        if (zzdew != null) {
            ((zzekc) zzdew).zzd.zzb.execute(new zzekb((zzekc) zzdew));
        }
    }

    public final synchronized void zzm(IObjectWrapper iObjectWrapper, zzbwv zzbwv) throws RemoteException {
        zzbwu zzbwu = this.zza;
        if (zzbwu != null) {
            ((zzekd) zzbwu).zzd.zza(zzbwv);
        }
    }

    public final synchronized void zzn(IObjectWrapper iObjectWrapper) throws RemoteException {
        zzbwu zzbwu = this.zza;
        if (zzbwu != null) {
            ((zzekd) zzbwu).zzc.zze();
        }
    }

    public final synchronized void zzo(IObjectWrapper iObjectWrapper) throws RemoteException {
        zzbwu zzbwu = this.zza;
        if (zzbwu != null) {
            ((zzekd) zzbwu).zzd.zzc();
        }
    }
}
