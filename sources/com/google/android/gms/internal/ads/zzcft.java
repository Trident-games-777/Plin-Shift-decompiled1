package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.TrafficStats;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzn;
import com.google.android.gms.ads.internal.zzv;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzcft implements zzfxg {
    public final /* synthetic */ Context zza;
    public final /* synthetic */ zzche zzb;
    public final /* synthetic */ String zzc;
    public final /* synthetic */ boolean zzd;
    public final /* synthetic */ boolean zze;
    public final /* synthetic */ zzavc zzf;
    public final /* synthetic */ zzbdu zzg;
    public final /* synthetic */ VersionInfoParcel zzh;
    public final /* synthetic */ zzn zzi;
    public final /* synthetic */ zza zzj;
    public final /* synthetic */ zzbbl zzk;
    public final /* synthetic */ zzfet zzl;
    public final /* synthetic */ zzfew zzm;
    public final /* synthetic */ zzffs zzn;
    public final /* synthetic */ zzeea zzo;

    public /* synthetic */ zzcft(Context context, zzche zzche, String str, boolean z, boolean z2, zzavc zzavc, zzbdu zzbdu, VersionInfoParcel versionInfoParcel, zzbdc zzbdc, zzn zzn2, zza zza2, zzbbl zzbbl, zzfet zzfet, zzfew zzfew, zzffs zzffs, zzeea zzeea) {
        this.zza = context;
        this.zzb = zzche;
        this.zzc = str;
        this.zzd = z;
        this.zze = z2;
        this.zzf = zzavc;
        this.zzg = zzbdu;
        this.zzh = versionInfoParcel;
        this.zzi = zzn2;
        this.zzj = zza2;
        this.zzk = zzbbl;
        this.zzl = zzfet;
        this.zzm = zzfew;
        this.zzn = zzffs;
        this.zzo = zzeea;
    }

    public final Object zza() {
        zzche zzche = this.zzb;
        String str = this.zzc;
        boolean z = this.zzd;
        zzbbl zzbbl = this.zzk;
        boolean z2 = this.zze;
        zzavc zzavc = this.zzf;
        zzfet zzfet = this.zzl;
        zzbdu zzbdu = this.zzg;
        zzn zzn2 = this.zzi;
        zzfew zzfew = this.zzm;
        Context context = this.zza;
        VersionInfoParcel versionInfoParcel = this.zzh;
        zza zza2 = this.zzj;
        zzffs zzffs = this.zzn;
        zzeea zzeea = this.zzo;
        try {
            TrafficStats.setThreadStatsTag(264);
            int i = zzcgj.zza;
            zzfew zzfew2 = zzfew;
            zzeea zzeea2 = zzeea;
            zzcgc zzcgc = new zzcgc(new zzcgj(new zzchd(context), zzche, str, z, z2, zzavc, zzbdu, versionInfoParcel, (zzbdc) null, zzn2, zza2, zzbbl, zzfet, zzfew2, zzffs));
            zzcgc.setWebViewClient(zzv.zzr().zzc(zzcgc, zzbbl, z2, zzeea2));
            zzcgc.setWebChromeClient(new zzcfj(zzcgc));
            return zzcgc;
        } finally {
            TrafficStats.clearThreadStatsTag();
        }
    }
}
