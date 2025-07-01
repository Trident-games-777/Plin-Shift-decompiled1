package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.zzg;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzcvr implements zzhfx {
    private final zzhgp zza;
    private final zzhgp zzb;
    private final zzhgp zzc;
    private final zzhgp zzd;
    private final zzhgp zze;
    private final zzhgp zzf;
    private final zzhgp zzg;
    private final zzhgp zzh;
    private final zzhgp zzi;
    private final zzhgp zzj;
    private final zzhgp zzk;

    public zzcvr(zzhgp zzhgp, zzhgp zzhgp2, zzhgp zzhgp3, zzhgp zzhgp4, zzhgp zzhgp5, zzhgp zzhgp6, zzhgp zzhgp7, zzhgp zzhgp8, zzhgp zzhgp9, zzhgp zzhgp10, zzhgp zzhgp11, zzhgp zzhgp12) {
        this.zza = zzhgp;
        this.zzb = zzhgp2;
        this.zzc = zzhgp3;
        this.zzd = zzhgp4;
        this.zze = zzhgp6;
        this.zzf = zzhgp7;
        this.zzg = zzhgp8;
        this.zzh = zzhgp9;
        this.zzi = zzhgp10;
        this.zzj = zzhgp11;
        this.zzk = zzhgp12;
    }

    /* renamed from: zza */
    public final zzcvq zzb() {
        VersionInfoParcel zza2 = ((zzcid) this.zzb).zza();
        VersionInfoParcel versionInfoParcel = zza2;
        ApplicationInfo zza3 = ((zzdxg) this.zzc).zzb();
        ApplicationInfo applicationInfo = zza3;
        String zza4 = ((zzdxj) this.zzd).zzb();
        String str = zza4;
        List zzc2 = zzeri.zzc();
        List list = zzc2;
        zzhfr zza5 = zzhfw.zza(zzhgi.zza(this.zzf));
        zzg zza6 = ((zzcho) this.zzg).zzb();
        zzg zzg2 = zza6;
        zzewc zza7 = ((zzewd) this.zzi).zzb();
        zzewc zzewc = zza7;
        zzffo zza8 = ((zzcwd) this.zzj).zza();
        zzffo zzffo = zza8;
        return new zzcvq((zzfjr) this.zza.zzb(), zza2, zza3, zza4, zzc2, (PackageInfo) this.zze.zzb(), zza5, zza6, (String) this.zzh.zzb(), zza7, zza8, (zzdbx) this.zzk.zzb());
    }
}
