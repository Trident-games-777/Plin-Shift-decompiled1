package com.google.android.gms.ads.nonagon.signalgeneration;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.internal.ads.zzavc;
import com.google.android.gms.internal.ads.zzbds;
import com.google.android.gms.internal.ads.zzbdt;
import com.google.android.gms.internal.ads.zzchk;
import com.google.android.gms.internal.ads.zzchq;
import com.google.android.gms.internal.ads.zzcid;
import com.google.android.gms.internal.ads.zzdsr;
import com.google.android.gms.internal.ads.zzffs;
import com.google.android.gms.internal.ads.zzfgn;
import com.google.android.gms.internal.ads.zzfin;
import com.google.android.gms.internal.ads.zzflr;
import com.google.android.gms.internal.ads.zzges;
import com.google.android.gms.internal.ads.zzhfx;
import com.google.android.gms.internal.ads.zzhgp;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzaq implements zzhfx {
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
    private final zzhgp zzl;

    public zzaq(zzhgp zzhgp, zzhgp zzhgp2, zzhgp zzhgp3, zzhgp zzhgp4, zzhgp zzhgp5, zzhgp zzhgp6, zzhgp zzhgp7, zzhgp zzhgp8, zzhgp zzhgp9, zzhgp zzhgp10, zzhgp zzhgp11, zzhgp zzhgp12, zzhgp zzhgp13) {
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
        this.zzl = zzhgp13;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        Context zza2 = ((zzchq) this.zzb).zza();
        Context context = zza2;
        zzges zzc2 = zzfin.zzc();
        zzges zzges = zzc2;
        VersionInfoParcel zza3 = ((zzcid) this.zzh).zza();
        VersionInfoParcel versionInfoParcel = zza3;
        zzbds zza4 = ((zzbdt) this.zzi).zzb();
        zzbds zzbds = zza4;
        return new zzap((zzchk) this.zza.zzb(), zza2, (zzavc) this.zzc.zzb(), (zzfgn) this.zzd.zzb(), zzc2, (ScheduledExecutorService) this.zze.zzb(), (zzdsr) this.zzf.zzb(), (zzflr) this.zzg.zzb(), zza3, zza4, (zzffs) this.zzj.zzb(), (zzj) this.zzk.zzb(), (zza) this.zzl.zzb());
    }
}
