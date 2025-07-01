package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zze;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzbno extends zzcav {
    private final Object zza = new Object();
    /* access modifiers changed from: private */
    public final zzbnt zzb;
    private boolean zzc;

    public zzbno(zzbnt zzbnt) {
        this.zzb = zzbnt;
    }

    public final void zzb() {
        zze.zza("release: Trying to acquire lock");
        synchronized (this.zza) {
            zze.zza("release: Lock acquired");
            if (this.zzc) {
                zze.zza("release: Lock already released");
                return;
            }
            this.zzc = true;
            zzj(new zzbnl(this), new zzcar());
            zzj(new zzbnm(this), new zzbnn(this));
            zze.zza("release: Lock released");
        }
    }
}
