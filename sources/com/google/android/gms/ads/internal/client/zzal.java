package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.h5.OnH5AdsEventListener;
import com.google.android.gms.ads.internal.util.client.zzp;
import com.google.android.gms.ads.internal.util.client.zzq;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbkn;
import com.google.android.gms.internal.ads.zzbkw;
import com.google.android.gms.internal.ads.zzbla;
import com.google.android.gms.internal.ads.zzbpg;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
final class zzal extends zzbb {
    final /* synthetic */ Context zza;
    final /* synthetic */ zzbpg zzb;
    final /* synthetic */ OnH5AdsEventListener zzc;

    zzal(zzba zzba, Context context, zzbpg zzbpg, OnH5AdsEventListener onH5AdsEventListener) {
        this.zza = context;
        this.zzb = zzbpg;
        this.zzc = onH5AdsEventListener;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object zza() {
        return new zzbla();
    }

    public final /* bridge */ /* synthetic */ Object zzb(zzcp zzcp) throws RemoteException {
        return zzcp.zzl(ObjectWrapper.wrap(this.zza), this.zzb, 243799000, new zzbkn(this.zzc));
    }

    public final /* bridge */ /* synthetic */ Object zzc() throws RemoteException {
        try {
            return ((zzbkw) zzq.zzb(this.zza, "com.google.android.gms.ads.DynamiteH5AdsManagerCreatorImpl", new zzak())).zze(ObjectWrapper.wrap(this.zza), this.zzb, 243799000, new zzbkn(this.zzc));
        } catch (RemoteException | zzp | NullPointerException unused) {
            return null;
        }
    }
}
