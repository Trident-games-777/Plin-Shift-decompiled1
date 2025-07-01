package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzv;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzcil implements zzhfx {
    private final zzhgp zza;
    private final zzhgp zzb;

    public zzcil(zzhgp zzhgp, zzhgp zzhgp2) {
        this.zza = zzhgp;
        this.zzb = zzhgp2;
    }

    /* renamed from: zza */
    public final zzbvr zzb() {
        Context zza2 = ((zzchq) this.zza).zza();
        Context context = zza2;
        zzfko zzfko = (zzfko) this.zzb.zzb();
        zzv.zzg().zzb(zza2, VersionInfoParcel.forPackage(), zzfko).zza("google.afma.request.getAdDictionary", zzbof.zza, zzbof.zza);
        zzboi zzb2 = zzv.zzg().zzb(zza2, VersionInfoParcel.forPackage(), zzfko);
        zzboc zzboc = zzbof.zza;
        return new zzbvt(zza2, zzb2.zza("google.afma.sdkConstants.getSdkConstants", zzboc, zzboc), VersionInfoParcel.forPackage());
    }
}
