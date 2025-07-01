package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzfvq implements Runnable {
    public final /* synthetic */ zzfvs zza;
    public final /* synthetic */ IBinder zzb;

    public /* synthetic */ zzfvq(zzfvs zzfvs, IBinder iBinder) {
        this.zza = zzfvs;
        this.zzb = iBinder;
    }

    public final void run() {
        zzfvs zzfvs = this.zza;
        zzfvs.zza.zzj = zzftt.zzb(this.zzb);
        zzfvs.zza.zzc.zzc("linkToDeath", new Object[0]);
        try {
            IInterface zzb2 = zzfvs.zza.zzj;
            if (zzb2 != null) {
                IInterface iInterface = zzb2;
                zzb2.asBinder().linkToDeath(zzfvs.zza.zzh, 0);
                zzfvs.zza.zzf = false;
                synchronized (zzfvs.zza.zze) {
                    for (Runnable run : zzfvs.zza.zze) {
                        run.run();
                    }
                    zzfvs.zza.zze.clear();
                }
                return;
            }
            throw null;
        } catch (RemoteException e) {
            zzfvs.zza.zzc.zzb(e, "linkToDeath failed", new Object[0]);
        }
    }
}
