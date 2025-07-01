package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.util.zzb;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzv;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzcdj extends zzb {
    final zzccf zza;
    final zzcdr zzb;
    private final String zzc;
    private final String[] zzd;

    zzcdj(zzccf zzccf, zzcdr zzcdr, String str, String[] strArr) {
        this.zza = zzccf;
        this.zzb = zzcdr;
        this.zzc = str;
        this.zzd = strArr;
        zzv.zzz().zzb(this);
    }

    public final void zza() {
        try {
            this.zzb.zzu(this.zzc, this.zzd);
        } finally {
            zzs.zza.post(new zzcdi(this));
        }
    }

    public final ListenableFuture zzb() {
        if (!((Boolean) zzbe.zzc().zza(zzbcn.zzcc)).booleanValue() || !(this.zzb instanceof zzcea)) {
            return super.zzb();
        }
        return zzcaj.zze.zzb(new zzcdh(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Boolean zzd() throws Exception {
        return Boolean.valueOf(this.zzb.zzw(this.zzc, this.zzd, this));
    }

    public final String zze() {
        return this.zzc;
    }
}
