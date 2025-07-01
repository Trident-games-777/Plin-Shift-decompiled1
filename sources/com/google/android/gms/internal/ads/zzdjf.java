package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzdjf implements zzhfx {
    private final zzhgp zza;
    private final zzhgp zzb;

    public zzdjf(zzhgp zzhgp, zzhgp zzhgp2) {
        this.zza = zzhgp;
        this.zzb = zzhgp2;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzfet zza2 = ((zzcsh) this.zza).zza();
        zzfet zzfet = zza2;
        JSONObject zzc = ((zzdhy) this.zzb).zzc();
        JSONObject jSONObject = zzc;
        return new zzdjc(zza2, zzc);
    }
}
