package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.client.zzby;
import com.google.android.gms.ads.internal.client.zzdr;
import com.google.android.gms.ads.internal.client.zzdy;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzcoy extends zzbae {
    private final zzcox zza;
    private final zzby zzb;
    private final zzfar zzc;
    private boolean zzd = ((Boolean) zzbe.zzc().zza(zzbcn.zzaO)).booleanValue();
    private final zzdsm zze;

    public zzcoy(zzcox zzcox, zzby zzby, zzfar zzfar, zzdsm zzdsm) {
        this.zza = zzcox;
        this.zzb = zzby;
        this.zzc = zzfar;
        this.zze = zzdsm;
    }

    public final zzby zze() {
        return this.zzb;
    }

    public final zzdy zzf() {
        if (!((Boolean) zzbe.zzc().zza(zzbcn.zzgD)).booleanValue()) {
            return null;
        }
        return this.zza.zzm();
    }

    public final void zzg(boolean z) {
        this.zzd = z;
    }

    public final void zzh(zzdr zzdr) {
        Preconditions.checkMainThread("setOnPaidEventListener must be called on the main UI thread.");
        if (this.zzc != null) {
            try {
                if (!zzdr.zzf()) {
                    this.zze.zze();
                }
            } catch (RemoteException e) {
                zzm.zzf("Error in making CSI ping for reporting paid event callback", e);
            }
            this.zzc.zzn(zzdr);
        }
    }

    public final void zzi(IObjectWrapper iObjectWrapper, zzbam zzbam) {
        try {
            this.zzc.zzp(zzbam);
            this.zza.zzd((Activity) ObjectWrapper.unwrap(iObjectWrapper), zzbam, this.zzd);
        } catch (RemoteException e) {
            zzm.zzl("#007 Could not call remote method.", e);
        }
    }
}
