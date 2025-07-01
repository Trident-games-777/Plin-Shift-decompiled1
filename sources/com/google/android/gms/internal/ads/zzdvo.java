package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzdvo implements zzhfx {
    private final zzhgp zza;
    private final zzhgp zzb;

    public zzdvo(zzhgp zzhgp, zzhgp zzhgp2) {
        this.zza = zzhgp;
        this.zzb = zzhgp2;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        Context zza2 = ((zzchq) this.zza).zza();
        Context context = zza2;
        VersionInfoParcel zza3 = ((zzcid) this.zzb).zza();
        VersionInfoParcel versionInfoParcel = zza3;
        zzdvv zzdvv = new zzdvv(zza2, zza3);
        zzdvv zzdvv2 = zzdvv;
        return zzdvv;
    }
}
