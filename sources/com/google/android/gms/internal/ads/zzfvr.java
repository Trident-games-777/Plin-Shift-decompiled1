package com.google.android.gms.internal.ads;

import android.os.IInterface;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzfvr implements Runnable {
    public final /* synthetic */ zzfvs zza;

    public /* synthetic */ zzfvr(zzfvs zzfvs) {
        this.zza = zzfvs;
    }

    public final void run() {
        zzfvs zzfvs = this.zza;
        zzfvs.zza.zzc.zzc("unlinkToDeath", new Object[0]);
        IInterface zzb = zzfvs.zza.zzj;
        zzb.getClass();
        IInterface iInterface = zzb;
        zzb.asBinder().unlinkToDeath(zzfvs.zza.zzh, 0);
        zzfvs.zza.zzj = null;
        zzfvs.zza.zzf = false;
    }
}
