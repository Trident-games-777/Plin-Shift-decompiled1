package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzp;
import com.google.android.gms.ads.internal.util.client.zzq;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbpg;
import com.google.android.gms.internal.ads.zzbtc;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
final class zzaj extends zzbb {
    final /* synthetic */ Context zza;
    final /* synthetic */ zzbpg zzb;

    zzaj(zzba zzba, Context context, zzbpg zzbpg) {
        this.zza = context;
        this.zzb = zzbpg;
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ Object zza() {
        return null;
    }

    public final /* bridge */ /* synthetic */ Object zzb(zzcp zzcp) throws RemoteException {
        return zzcp.zzm(ObjectWrapper.wrap(this.zza), this.zzb, 243799000);
    }

    public final /* bridge */ /* synthetic */ Object zzc() throws RemoteException {
        try {
            return ((zzbtc) zzq.zzb(this.zza, "com.google.android.gms.ads.DynamiteOfflineUtilsCreatorImpl", new zzai())).zze(ObjectWrapper.wrap(this.zza), this.zzb, 243799000);
        } catch (RemoteException | zzp | NullPointerException unused) {
            return null;
        }
    }
}
