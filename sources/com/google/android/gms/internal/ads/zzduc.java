package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzm;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzduc implements zzdtm {
    /* access modifiers changed from: private */
    public final long zza;
    /* access modifiers changed from: private */
    public final zzdtr zzb;
    private final zzfek zzc;

    zzduc(long j, Context context, zzdtr zzdtr, zzchk zzchk, String str) {
        this.zza = j;
        this.zzb = zzdtr;
        zzfem zzw = zzchk.zzw();
        zzw.zzb(context);
        zzw.zza(str);
        this.zzc = zzw.zzc().zza();
    }

    public final void zza() {
    }

    public final void zzb(zzm zzm) {
        try {
            this.zzc.zzf(zzm, new zzdua(this));
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzm.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void zzc() {
        try {
            this.zzc.zzk(new zzdub(this));
            this.zzc.zzm(ObjectWrapper.wrap(null));
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzm.zzl("#007 Could not call remote method.", e);
        }
    }
}
