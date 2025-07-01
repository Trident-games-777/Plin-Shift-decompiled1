package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzm;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
public final class zzbbp {
    final /* synthetic */ zzbbr zza;
    private final byte[] zzb;
    private int zzc;

    /* synthetic */ zzbbp(zzbbr zzbbr, byte[] bArr, zzbbq zzbbq) {
        this.zza = zzbbr;
        this.zzb = bArr;
    }

    /* access modifiers changed from: private */
    public final synchronized void zzd() {
        try {
            zzbbr zzbbr = this.zza;
            if (zzbbr.zzb) {
                zzbbr.zza.zzj(this.zzb);
                this.zza.zza.zzi(0);
                this.zza.zza.zzg(this.zzc);
                this.zza.zza.zzh((int[]) null);
                this.zza.zza.zzf();
            }
        } catch (RemoteException e) {
            zzm.zzf("Clearcut log failed", e);
        }
    }

    public final zzbbp zza(int i) {
        this.zzc = i;
        return this;
    }

    public final synchronized void zzc() {
        this.zza.zzc.execute(new zzbbo(this));
    }
}
