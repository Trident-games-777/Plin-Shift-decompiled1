package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzac;
import com.google.android.gms.ads.internal.overlay.zzn;
import com.google.android.gms.ads.internal.overlay.zzr;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzl;
import com.google.android.gms.ads.internal.zzv;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzehd implements zzdgv {
    private final Context zza;
    private final VersionInfoParcel zzb;
    private final ListenableFuture zzc;
    private final zzfet zzd;
    private final zzcfk zze;
    private final zzffo zzf;
    private final zzbju zzg;
    private final boolean zzh;
    private final zzeea zzi;

    zzehd(Context context, VersionInfoParcel versionInfoParcel, ListenableFuture listenableFuture, zzfet zzfet, zzcfk zzcfk, zzffo zzffo, boolean z, zzbju zzbju, zzeea zzeea) {
        this.zza = context;
        this.zzb = versionInfoParcel;
        this.zzc = listenableFuture;
        this.zzd = zzfet;
        this.zze = zzcfk;
        this.zzf = zzffo;
        this.zzg = zzbju;
        this.zzh = z;
        this.zzi = zzeea;
    }

    public final void zza(boolean z, Context context, zzcwz zzcwz) {
        zzdfk zzdfk = (zzdfk) zzgei.zzq(this.zzc);
        this.zze.zzaq(true);
        boolean z2 = false;
        boolean zze2 = this.zzh ? this.zzg.zze(false) : false;
        zzv.zzq();
        Context context2 = this.zza;
        boolean z3 = this.zzh;
        boolean zzI = zzs.zzI(context2);
        if (z3) {
            z2 = this.zzg.zzd();
        }
        zzl zzl = new zzl(zze2, zzI, z2, this.zzh ? this.zzg.zza() : 0.0f, -1, z, this.zzd.zzO, false);
        if (zzcwz != null) {
            zzcwz.zzf();
        }
        zzv.zzj();
        zzl zzl2 = zzl;
        zzdgk zzh2 = zzdfk.zzh();
        zzcfk zzcfk = this.zze;
        zzfet zzfet = this.zzd;
        VersionInfoParcel versionInfoParcel = this.zzb;
        int i = zzfet.zzQ;
        String str = zzfet.zzB;
        zzfey zzfey = zzfet.zzs;
        zzn.zza(context, new AdOverlayInfoParcel((zza) null, (zzr) zzh2, (zzac) null, zzcfk, i, versionInfoParcel, str, zzl2, zzfey.zzb, zzfey.zza, this.zzf.zzf, zzcwz, (zzbsz) zzfet.zzai ? this.zzi : null), true);
    }
}
