package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.util.Log;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzfrp {
    final /* synthetic */ zzfrr zza;
    private final byte[] zzb;
    private int zzc;
    private int zzd;

    /* synthetic */ zzfrp(zzfrr zzfrr, byte[] bArr, zzfrq zzfrq) {
        this.zza = zzfrr;
        this.zzb = bArr;
    }

    public final zzfrp zza(int i) {
        this.zzd = i;
        return this;
    }

    public final zzfrp zzb(int i) {
        this.zzc = i;
        return this;
    }

    public final synchronized void zzc() {
        try {
            zzfrr zzfrr = this.zza;
            if (zzfrr.zzb) {
                zzfrr.zza.zzj(this.zzb);
                this.zza.zza.zzi(this.zzc);
                this.zza.zza.zzg(this.zzd);
                this.zza.zza.zzh((int[]) null);
                this.zza.zza.zzf();
            }
        } catch (RemoteException e) {
            Log.d("GASS", "Clearcut log failed", e);
        }
    }
}
