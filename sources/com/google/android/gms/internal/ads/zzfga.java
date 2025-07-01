package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzbc;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.zzv;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzfga {
    private final zzfet zza;
    private final zzfew zzb;
    private final zzedp zzc;
    private final zzflr zzd;
    private final zzfkl zze;
    private final zzcnb zzf;

    public zzfga(zzedp zzedp, zzflr zzflr, zzfet zzfet, zzfew zzfew, zzcnb zzcnb, zzfkl zzfkl) {
        this.zza = zzfet;
        this.zzb = zzfew;
        this.zzc = zzedp;
        this.zzd = zzflr;
        this.zzf = zzcnb;
        this.zze = zzfkl;
    }

    public final void zza(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzb((String) it.next(), 2);
        }
    }

    public final void zzb(String str, int i) {
        if (!this.zza.zzai) {
            this.zzd.zzc(str, this.zze);
            return;
        }
        this.zzc.zzd(new zzedr(zzv.zzC().currentTimeMillis(), this.zzb.zzb, str, i));
    }

    public final void zzc(List list, int i) {
        ListenableFuture listenableFuture;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (!((Boolean) zzbe.zzc().zza(zzbcn.zzjI)).booleanValue() || !zzcnb.zzj(str)) {
                listenableFuture = zzgei.zzh(str);
            } else {
                listenableFuture = this.zzf.zzb(str, zzbc.zze());
            }
            zzgei.zzr(listenableFuture, new zzffz(this, i), zzcaj.zza);
        }
    }
}
