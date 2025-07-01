package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.util.zzba;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzv;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzebc implements zzgee {
    final /* synthetic */ zzbvx zza;
    final /* synthetic */ zzbvp zzb;

    zzebc(zzebg zzebg, zzbvx zzbvx, zzbvp zzbvp) {
        this.zza = zzbvx;
        this.zzb = zzbvp;
    }

    public final void zza(Throwable th) {
        try {
            this.zzb.zze(zzba.zzb(th));
        } catch (RemoteException e) {
            zze.zzb("Service can't call client", e);
        }
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        Bundle bundle;
        ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor) obj;
        try {
            if (((Boolean) zzbe.zzc().zza(zzbcn.zzci)).booleanValue()) {
                if (((Boolean) zzbe.zzc().zza(zzbcn.zzcj)).booleanValue() && (bundle = this.zza.zzm) != null) {
                    bundle.putLong(zzdrv.BINDER_CALL_START.zza(), zzv.zzC().currentTimeMillis());
                }
                this.zzb.zzg(parcelFileDescriptor, this.zza);
                return;
            }
            this.zzb.zzf(parcelFileDescriptor);
        } catch (RemoteException e) {
            zze.zzb("Service can't call client", e);
        }
    }
}
