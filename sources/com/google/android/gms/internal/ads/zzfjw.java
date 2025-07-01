package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzfjw implements zzhfx {
    private final zzhgp zza;
    private final zzhgp zzb;
    private final zzhgp zzc;

    public zzfjw(zzfjv zzfjv, zzhgp zzhgp, zzhgp zzhgp2, zzhgp zzhgp3) {
        this.zza = zzhgp;
        this.zzb = zzhgp2;
        this.zzc = zzhgp3;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        Context zza2 = ((zzchq) this.zza).zza();
        Context context = zza2;
        VersionInfoParcel zza3 = ((zzcid) this.zzb).zza();
        VersionInfoParcel versionInfoParcel = zza3;
        zzboi zza4 = new zzbnz().zza(zza2, zza3, (zzfko) this.zzc.zzb());
        zzhgf.zzb(zza4);
        zzboi zzboi = zza4;
        return zza4;
    }
}
