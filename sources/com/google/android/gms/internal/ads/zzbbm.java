package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.client.zzp;
import com.google.android.gms.ads.internal.util.client.zzq;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
public final /* synthetic */ class zzbbm implements Runnable {
    public final /* synthetic */ zzbbr zza;
    public final /* synthetic */ Context zzb;

    public /* synthetic */ zzbbm(zzbbr zzbbr, Context context) {
        this.zza = zzbbr;
        this.zzb = context;
    }

    public final void run() {
        boolean booleanValue = ((Boolean) zzbe.zzc().zza(zzbcn.zzeV)).booleanValue();
        zzbbr zzbbr = this.zza;
        Context context = this.zzb;
        if (booleanValue) {
            try {
                zzbbr.zza = (zzayh) zzq.zzb(context, "com.google.android.gms.ads.clearcut.DynamiteClearcutLogger", new zzbbn());
                zzbbr.zza.zze(ObjectWrapper.wrap(context), "GMA_SDK");
                zzbbr.zzb = true;
            } catch (RemoteException | zzp | NullPointerException unused) {
                zzm.zze("Cannot dynamite load clearcut");
            }
        }
    }
}
