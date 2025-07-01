package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzs;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zza;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzdpn {
    private final Context zza;
    private final zzavc zzb;
    private final zzbdu zzc;
    private final VersionInfoParcel zzd;
    private final zza zze;
    private final zzbbl zzf;
    /* access modifiers changed from: private */
    public final zzcze zzg;
    private final zzeea zzh;
    private final zzffs zzi;

    public zzdpn(zzcfx zzcfx, Context context, zzavc zzavc, zzbdu zzbdu, VersionInfoParcel versionInfoParcel, zza zza2, zzbbl zzbbl, zzcze zzcze, zzeea zzeea, zzffs zzffs) {
        this.zza = context;
        this.zzb = zzavc;
        this.zzc = zzbdu;
        this.zzd = versionInfoParcel;
        this.zze = zza2;
        this.zzf = zzbbl;
        this.zzg = zzcze;
        this.zzh = zzeea;
        this.zzi = zzffs;
    }

    public final zzcfk zza(zzs zzs, zzfet zzfet, zzfew zzfew) throws zzcfw {
        zzche zzc2 = zzche.zzc(zzs);
        String str = zzs.zza;
        zzdpc zzdpc = new zzdpc(this);
        zzeea zzeea = this.zzh;
        zzffs zzffs = this.zzi;
        zza zza2 = this.zze;
        zzbbl zzbbl = this.zzf;
        return zzcfx.zza(this.zza, zzc2, str, false, false, this.zzb, this.zzc, this.zzd, (zzbdc) null, zzdpc, zza2, zzbbl, zzfet, zzfew, zzeea, zzffs);
    }
}
