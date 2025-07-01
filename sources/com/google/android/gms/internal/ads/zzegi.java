package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzeb;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzegi implements zzcro {
    public final /* synthetic */ zzefe zza;

    public /* synthetic */ zzegi(zzefe zzefe) {
        this.zza = zzefe;
    }

    public final zzeb zza() {
        try {
            return ((zzbrf) this.zza.zzb).zze();
        } catch (RemoteException e) {
            throw new zzffv(e);
        }
    }
}
