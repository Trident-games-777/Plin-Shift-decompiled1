package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbpg;
import com.google.android.gms.internal.ads.zzbxo;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
final class zzab extends zzbb {
    final /* synthetic */ Context zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzbpg zzc;

    zzab(zzba zzba, Context context, String str, zzbpg zzbpg) {
        this.zza = context;
        this.zzb = str;
        this.zzc = zzbpg;
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ Object zza() {
        zzba.zzv(this.zza, "rewarded");
        return new zzfq();
    }

    public final /* bridge */ /* synthetic */ Object zzb(zzcp zzcp) throws RemoteException {
        return zzcp.zzp(ObjectWrapper.wrap(this.zza), this.zzb, this.zzc, 243799000);
    }

    public final /* bridge */ /* synthetic */ Object zzc() throws RemoteException {
        return zzbxo.zza(this.zza, this.zzb, this.zzc);
    }
}
