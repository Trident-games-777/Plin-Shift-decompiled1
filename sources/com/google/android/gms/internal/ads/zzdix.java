package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzea;
import com.google.android.gms.ads.internal.client.zzeb;
import com.google.android.gms.ads.internal.client.zzee;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzdix extends zzea {
    private final Object zza = new Object();
    @Nullable
    private final zzeb zzb;
    @Nullable
    private final zzbpv zzc;

    public zzdix(@Nullable zzeb zzeb, @Nullable zzbpv zzbpv) {
        this.zzb = zzeb;
        this.zzc = zzbpv;
    }

    public final float zze() throws RemoteException {
        throw new RemoteException();
    }

    public final float zzf() throws RemoteException {
        zzbpv zzbpv = this.zzc;
        if (zzbpv != null) {
            return zzbpv.zzg();
        }
        return 0.0f;
    }

    public final float zzg() throws RemoteException {
        zzbpv zzbpv = this.zzc;
        if (zzbpv != null) {
            return zzbpv.zzh();
        }
        return 0.0f;
    }

    public final int zzh() throws RemoteException {
        throw new RemoteException();
    }

    @Nullable
    public final zzee zzi() throws RemoteException {
        synchronized (this.zza) {
            zzeb zzeb = this.zzb;
            if (zzeb == null) {
                return null;
            }
            zzee zzi = zzeb.zzi();
            return zzi;
        }
    }

    public final void zzj(boolean z) throws RemoteException {
        throw new RemoteException();
    }

    public final void zzk() throws RemoteException {
        throw new RemoteException();
    }

    public final void zzl() throws RemoteException {
        throw new RemoteException();
    }

    public final void zzm(@Nullable zzee zzee) throws RemoteException {
        synchronized (this.zza) {
            zzeb zzeb = this.zzb;
            if (zzeb != null) {
                zzeb.zzm(zzee);
            }
        }
    }

    public final void zzn() throws RemoteException {
        throw new RemoteException();
    }

    public final boolean zzo() throws RemoteException {
        throw new RemoteException();
    }

    public final boolean zzp() throws RemoteException {
        throw new RemoteException();
    }

    public final boolean zzq() throws RemoteException {
        throw new RemoteException();
    }
}
