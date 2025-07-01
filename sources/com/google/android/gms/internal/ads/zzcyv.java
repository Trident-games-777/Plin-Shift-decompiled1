package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.client.zzu;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzcyv extends zzdcc implements zzcxg, zzcyl {
    private final zzfet zzb;
    private final AtomicBoolean zzc = new AtomicBoolean();

    public zzcyv(Set set, zzfet zzfet) {
        super(set);
        this.zzb = zzfet;
    }

    private final void zzb() {
        zzu zzu;
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzhx)).booleanValue() && this.zzc.compareAndSet(false, true) && (zzu = this.zzb.zzae) != null && zzu.zza == 3) {
            zzq(new zzcyu(this));
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(zzcyx zzcyx) throws Exception {
        zzcyx.zzh(this.zzb.zzae);
    }

    public final void zzg() {
        if (this.zzb.zzb == 1) {
            zzb();
        }
    }

    public final void zzr() {
        int i = this.zzb.zzb;
        if (i == 2 || i == 5 || i == 4 || i == 6 || i == 7) {
            zzb();
        }
    }
}
