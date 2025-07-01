package com.google.android.gms.ads.nonagon.signalgeneration;

import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.internal.ads.zzbcn;
import com.google.android.gms.internal.ads.zzcaj;
import com.google.android.gms.internal.ads.zzcvq;
import com.google.android.gms.internal.ads.zzcvr;
import com.google.android.gms.internal.ads.zzdfa;
import com.google.android.gms.internal.ads.zzfix;
import com.google.android.gms.internal.ads.zzfjl;
import com.google.android.gms.internal.ads.zzfjr;
import com.google.android.gms.internal.ads.zzgei;
import com.google.android.gms.internal.ads.zzhfx;
import com.google.android.gms.internal.ads.zzhgp;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzaz implements zzhfx {
    private final zzhgp zza;
    private final zzhgp zzb;
    private final zzhgp zzc;
    private final zzhgp zzd;

    public zzaz(zzhgp zzhgp, zzhgp zzhgp2, zzhgp zzhgp3, zzhgp zzhgp4) {
        this.zza = zzhgp;
        this.zzb = zzhgp2;
        this.zzc = zzhgp3;
        this.zzd = zzhgp4;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzbb zza2 = ((zzbc) this.zzb).zzb();
        zzbb zzbb = zza2;
        zzcvq zza3 = ((zzcvr) this.zzc).zzb();
        zzcvq zzcvq = zza3;
        zzfix zza4 = ((zzfjr) this.zza.zzb()).zzb(zzfjl.GENERATE_SIGNALS, zza3.zzc()).zzf(zza2).zzi((long) ((Integer) zzbe.zzc().zza(zzbcn.zzfx)).intValue(), TimeUnit.SECONDS).zza();
        zzgei.zzr(zza4, new zzar((zzdfa) this.zzd.zzb()), zzcaj.zza);
        return zza4;
    }
}
