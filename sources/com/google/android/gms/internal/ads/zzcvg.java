package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzcvg implements zzhfx {
    private final zzhgp zza;
    private final zzhgp zzb;
    private final zzhgp zzc;

    public zzcvg(zzhgp zzhgp, zzhgp zzhgp2, zzhgp zzhgp3) {
        this.zza = zzhgp;
        this.zzb = zzhgp2;
        this.zzc = zzhgp3;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        VersionInfoParcel zza2 = ((zzcid) this.zzb).zza();
        VersionInfoParcel versionInfoParcel = zza2;
        zzffo zza3 = ((zzcwd) this.zzc).zza();
        zzffo zzffo = zza3;
        return new zzcvf((Context) this.zza.zzb(), zza2, zza3);
    }
}
