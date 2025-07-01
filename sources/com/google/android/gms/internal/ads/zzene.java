package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.ads.internal.util.client.zzm;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzene implements zzcwp {
    public final /* synthetic */ zzems zza;
    public final /* synthetic */ zzbmk zzb;

    public /* synthetic */ zzene(zzems zzems, zzbmk zzbmk) {
        this.zza = zzems;
        this.zzb = zzbmk;
    }

    public final void zzdB(zze zze) {
        this.zza.zzdB(zze);
        zzbmk zzbmk = this.zzb;
        if (zzbmk != null) {
            try {
                zzbmk.zzf(zze);
            } catch (RemoteException e) {
                zzm.zzl("#007 Could not call remote method.", e);
            }
        }
        if (zzbmk != null) {
            try {
                zzbmk.zze(zze.zza);
            } catch (RemoteException e2) {
                zzm.zzl("#007 Could not call remote method.", e2);
            }
        }
    }
}
