package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbpg;
import com.google.firebase.analytics.FirebaseAnalytics;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
final class zzao extends zzbb {
    final /* synthetic */ Context zza;
    final /* synthetic */ zzs zzb;
    final /* synthetic */ String zzc;
    final /* synthetic */ zzba zzd;

    zzao(zzba zzba, Context context, zzs zzs, String str) {
        this.zza = context;
        this.zzb = zzs;
        this.zzc = str;
        this.zzd = zzba;
    }

    public final /* bridge */ /* synthetic */ Object zza() {
        zzba.zzv(this.zza, FirebaseAnalytics.Event.SEARCH);
        return new zzfk();
    }

    public final /* bridge */ /* synthetic */ Object zzb(zzcp zzcp) throws RemoteException {
        return zzcp.zzf(ObjectWrapper.wrap(this.zza), this.zzb, this.zzc, 243799000);
    }

    public final /* bridge */ /* synthetic */ Object zzc() throws RemoteException {
        return this.zzd.zza.zza(this.zza, this.zzb, this.zzc, (zzbpg) null, 3);
    }
}
