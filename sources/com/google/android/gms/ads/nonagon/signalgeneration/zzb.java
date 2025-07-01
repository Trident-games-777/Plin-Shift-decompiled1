package com.google.android.gms.ads.nonagon.signalgeneration;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.internal.ads.zzbbw;
import com.google.android.gms.internal.ads.zzchq;
import com.google.android.gms.internal.ads.zzcid;
import com.google.android.gms.internal.ads.zzckz;
import com.google.android.gms.internal.ads.zzeri;
import com.google.android.gms.internal.ads.zzhfx;
import com.google.android.gms.internal.ads.zzhgp;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzb implements zzhfx {
    private final zzhgp zza;
    private final zzhgp zzb;

    public zzb(zzhgp zzhgp, zzhgp zzhgp2, zzhgp zzhgp3, zzhgp zzhgp4) {
        this.zza = zzhgp;
        this.zzb = zzhgp4;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        Context zza2 = ((zzchq) this.zza).zza();
        Context context = zza2;
        zzbbw zza3 = zzckz.zza();
        zzbbw zzbbw = zza3;
        List zzc = zzeri.zzc();
        List list = zzc;
        VersionInfoParcel zza4 = ((zzcid) this.zzb).zza();
        VersionInfoParcel versionInfoParcel = zza4;
        return new zza(zza2, zza3, zzc, zza4);
    }
}
