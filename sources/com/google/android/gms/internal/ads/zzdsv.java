package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.zzr;
import com.google.android.gms.ads.nonagon.util.logging.csi.CsiParamDefaults;
import com.google.android.gms.ads.nonagon.util.logging.csi.CsiParamDefaults_Factory;
import com.google.android.gms.ads.nonagon.util.logging.csi.CsiUrlBuilder;
import com.google.android.gms.ads.nonagon.util.logging.csi.CsiUrlBuilder_Factory;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzdsv implements zzhfx {
    private final zzhgp zza;
    private final zzhgp zzb;
    private final zzhgp zzc;
    private final zzhgp zzd;

    public zzdsv(zzhgp zzhgp, zzhgp zzhgp2, zzhgp zzhgp3, zzhgp zzhgp4, zzhgp zzhgp5) {
        this.zza = zzhgp2;
        this.zzb = zzhgp3;
        this.zzc = zzhgp4;
        this.zzd = zzhgp5;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        CsiParamDefaults csiParamDefaults = ((CsiParamDefaults_Factory) this.zzb).zzb();
        CsiParamDefaults csiParamDefaults2 = csiParamDefaults;
        CsiUrlBuilder csiUrlBuilder = ((CsiUrlBuilder_Factory) this.zzc).zzb();
        CsiUrlBuilder csiUrlBuilder2 = csiUrlBuilder;
        Context zza2 = ((zzchq) this.zzd).zza();
        Context context = zza2;
        return new zzdsr(zzfin.zzc(), (zzr) this.zza.zzb(), csiParamDefaults, csiUrlBuilder, zza2);
    }
}
