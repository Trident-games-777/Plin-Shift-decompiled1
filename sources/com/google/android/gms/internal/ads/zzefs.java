package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zze;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzefs extends zzbqp {
    private final zzefe zza;

    /* synthetic */ zzefs(zzefe zzefe, zzeft zzeft) {
        this.zza = zzefe;
    }

    public final void zze(String str) throws RemoteException {
        ((zzegx) this.zza.zzc).zzi(0, str);
    }

    public final void zzf(zze zze) throws RemoteException {
        ((zzegx) this.zza.zzc).zzh(zze);
    }

    public final void zzg() throws RemoteException {
        ((zzegx) this.zza.zzc).zzo();
    }
}
