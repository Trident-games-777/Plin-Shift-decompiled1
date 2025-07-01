package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzcwi implements zzhfx {
    private final zzhgp zza;
    private final zzhgp zzb;
    private final zzhgp zzc;

    public zzcwi(zzcwh zzcwh, zzhgp zzhgp, zzhgp zzhgp2, zzhgp zzhgp3, zzhgp zzhgp4) {
        this.zza = zzhgp;
        this.zzb = zzhgp2;
        this.zzc = zzhgp3;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        Context context = (Context) this.zza.zzb();
        VersionInfoParcel zza2 = ((zzcid) this.zzb).zza();
        VersionInfoParcel versionInfoParcel = zza2;
        zzfet zza3 = ((zzcsh) this.zzc).zza();
        zzfet zzfet = zza3;
        zzbyd zzbyd = new zzbyd();
        zzbyd zzbyd2 = zzbyd;
        zzbyd zzbyd3 = zzbyd;
        zzbye zzbye = zza3.zzA;
        String str = null;
        if (zzbye == null) {
            return null;
        }
        zzfey zzfey = zza3.zzs;
        if (zzfey != null) {
            str = zzfey.zzb;
        }
        return new zzbyc(context, zza2, zzbye, str, zzbyd);
    }
}
