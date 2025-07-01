package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.internal.ads.zzbbs;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzdqm implements zzhfx {
    private final zzhgp zza;
    private final zzhgp zzb;
    private final zzhgp zzc;
    private final zzhgp zzd;
    private final zzhgp zze;

    public zzdqm(zzhgp zzhgp, zzhgp zzhgp2, zzhgp zzhgp3, zzhgp zzhgp4, zzhgp zzhgp5) {
        this.zza = zzhgp;
        this.zzb = zzhgp2;
        this.zzc = zzhgp3;
        this.zzd = zzhgp4;
        this.zze = zzhgp5;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        Context zza2 = ((zzchq) this.zza).zza();
        Context context = zza2;
        String zza3 = ((zzdxj) this.zzb).zzb();
        String str = zza3;
        VersionInfoParcel zza4 = ((zzcid) this.zzc).zza();
        VersionInfoParcel versionInfoParcel = zza4;
        zzbbs.zza.C0000zza zza5 = (zzbbs.zza.C0000zza) this.zzd.zzb();
        String str2 = (String) this.zze.zzb();
        zzbbl zzbbl = new zzbbl(new zzbbr(zza2));
        zzbbs.zzar.zza zzd2 = zzbbs.zzar.zzd();
        zzd2.zzg(zza4.buddyApkVersion);
        zzd2.zzi(zza4.clientJarVersion);
        zzd2.zzh(true != zza4.isClientJar ? 2 : 0);
        zzbbl.zzb(new zzdql(zza5, zza3, (zzbbs.zzar) zzd2.zzbr(), str2));
        zzbbl zzbbl2 = zzbbl;
        return zzbbl;
    }
}
