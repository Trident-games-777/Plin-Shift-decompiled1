package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.nonagon.signalgeneration.zzau;
import com.google.android.gms.ads.nonagon.signalgeneration.zzw;
import com.google.android.gms.ads.nonagon.signalgeneration.zzx;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzcka implements zzw {
    private final zzciy zza;
    private zzcvw zzb;
    private zzau zzc;

    /* synthetic */ zzcka(zzciy zzciy, zzckd zzckd) {
        this.zza = zzciy;
    }

    public final /* bridge */ /* synthetic */ zzw zza(zzcvw zzcvw) {
        zzcvw zzcvw2 = zzcvw;
        this.zzb = zzcvw;
        return this;
    }

    public final /* bridge */ /* synthetic */ zzw zzb(zzau zzau) {
        zzau zzau2 = zzau;
        this.zzc = zzau;
        return this;
    }

    public final zzx zzc() {
        zzhgf.zzc(this.zzb, zzcvw.class);
        zzhgf.zzc(this.zzc, zzau.class);
        return new zzckb(this.zza, this.zzc, new zzcta(), new zzcuz(), new zzdta(), this.zzb, (zzfco) null, (zzfbr) null, (zzckd) null);
    }
}
