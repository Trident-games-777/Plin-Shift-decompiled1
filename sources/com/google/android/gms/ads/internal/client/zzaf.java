package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzp;
import com.google.android.gms.ads.internal.util.client.zzq;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbcn;
import com.google.android.gms.internal.ads.zzbpg;
import com.google.android.gms.internal.ads.zzbuj;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
final class zzaf extends zzbb {
    final /* synthetic */ Context zza;
    final /* synthetic */ zzbpg zzb;

    zzaf(zzba zzba, Context context, zzbpg zzbpg) {
        this.zza = context;
        this.zzb = zzbpg;
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ Object zza() {
        zzba.zzv(this.zza, "out_of_context_tester");
        return null;
    }

    public final /* bridge */ /* synthetic */ Object zzb(zzcp zzcp) throws RemoteException {
        Context context = this.zza;
        IObjectWrapper wrap = ObjectWrapper.wrap(context);
        zzbcn.zza(context);
        if (((Boolean) zzbe.zzc().zza(zzbcn.zziY)).booleanValue()) {
            return zzcp.zzi(wrap, this.zzb, 243799000);
        }
        return null;
    }

    public final /* bridge */ /* synthetic */ Object zzc() throws RemoteException {
        Context context = this.zza;
        IObjectWrapper wrap = ObjectWrapper.wrap(context);
        zzbcn.zza(context);
        if (((Boolean) zzbe.zzc().zza(zzbcn.zziY)).booleanValue()) {
            try {
                return ((zzdv) zzq.zzb(this.zza, "com.google.android.gms.ads.DynamiteOutOfContextTesterCreatorImpl", new zzae())).zze(wrap, this.zzb, 243799000);
            } catch (RemoteException | zzp | NullPointerException e) {
                zzbuj.zza(this.zza).zzh(e, "ClientApiBroker.getOutOfContextTester");
            }
        }
        return null;
    }
}
