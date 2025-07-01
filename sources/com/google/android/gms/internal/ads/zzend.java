package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzdy;
import com.google.android.gms.ads.internal.util.client.zzm;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzend {
    private final zzeni zza;
    private final String zzb;
    /* access modifiers changed from: private */
    public zzdy zzc;

    public zzend(zzeni zzeni, String str) {
        this.zza = zzeni;
        this.zzb = str;
    }

    public final synchronized String zza() {
        String str;
        str = null;
        try {
            zzdy zzdy = this.zzc;
            if (zzdy != null) {
                str = zzdy.zzg();
            }
        } catch (RemoteException e) {
            zzm.zzl("#007 Could not call remote method.", e);
            return null;
        }
        return str;
    }

    public final synchronized String zzb() {
        String str;
        str = null;
        try {
            zzdy zzdy = this.zzc;
            if (zzdy != null) {
                str = zzdy.zzg();
            }
        } catch (RemoteException e) {
            zzm.zzl("#007 Could not call remote method.", e);
            return null;
        }
        return str;
    }

    public final synchronized void zzd(com.google.android.gms.ads.internal.client.zzm zzm, int i) throws RemoteException {
        this.zzc = null;
        zzenj zzenj = new zzenj(i);
        zzenc zzenc = new zzenc(this);
        this.zza.zzb(zzm, this.zzb, zzenj, zzenc);
    }

    public final synchronized boolean zze() throws RemoteException {
        return this.zza.zza();
    }
}
