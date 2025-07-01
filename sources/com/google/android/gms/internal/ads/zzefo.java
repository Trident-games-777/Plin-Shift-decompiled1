package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.client.zzy;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzac;
import com.google.android.gms.ads.internal.overlay.zzn;
import com.google.android.gms.ads.internal.overlay.zzr;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.zzl;
import com.google.android.gms.ads.internal.zzv;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzefo implements zzdgv {
    private final VersionInfoParcel zza;
    private final ListenableFuture zzb;
    private final zzfet zzc;
    private final zzcfk zzd;
    private final zzffo zze;
    private final zzbju zzf;
    private final boolean zzg;
    private final zzeea zzh;

    zzefo(VersionInfoParcel versionInfoParcel, ListenableFuture listenableFuture, zzfet zzfet, zzcfk zzcfk, zzffo zzffo, boolean z, zzbju zzbju, zzeea zzeea) {
        this.zza = versionInfoParcel;
        this.zzb = listenableFuture;
        this.zzc = zzfet;
        this.zzd = zzcfk;
        this.zze = zzffo;
        this.zzg = z;
        this.zzf = zzbju;
        this.zzh = zzeea;
    }

    public final void zza(boolean z, Context context, zzcwz zzcwz) {
        zzcoo zzcoo = (zzcoo) zzgei.zzq(this.zzb);
        this.zzd.zzaq(true);
        boolean zze2 = this.zzg ? this.zzf.zze(true) : true;
        boolean z2 = this.zzg;
        zzl zzl = new zzl(zze2, true, z2 ? this.zzf.zzd() : false, z2 ? this.zzf.zza() : 0.0f, -1, z, this.zzc.zzO, false);
        if (zzcwz != null) {
            zzcwz.zzf();
        }
        zzv.zzj();
        zzl zzl2 = zzl;
        zzdgk zzg2 = zzcoo.zzg();
        zzcfk zzcfk = this.zzd;
        int i = this.zzc.zzQ;
        if (i == -1) {
            zzy zzy = this.zze.zzj;
            if (zzy != null) {
                int i2 = zzy.zza;
                if (i2 == 1) {
                    i = 7;
                } else if (i2 == 2) {
                    i = 6;
                }
            }
            zzm.zze("Error setting app open orientation; no targeting orientation available.");
            i = this.zzc.zzQ;
        }
        int i3 = i;
        VersionInfoParcel versionInfoParcel = this.zza;
        zzfet zzfet = this.zzc;
        String str = zzfet.zzB;
        zzfey zzfey = zzfet.zzs;
        zzn.zza(context, new AdOverlayInfoParcel((zza) null, (zzr) zzg2, (zzac) null, zzcfk, i3, versionInfoParcel, str, zzl2, zzfey.zzb, zzfey.zza, this.zze.zzf, zzcwz, (zzbsz) zzfet.zzai ? this.zzh : null), true);
    }
}
