package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzeib implements zzefh {
    private final Context zza;
    private final zzdhj zzb;
    /* access modifiers changed from: private */
    public zzbpv zzc;
    private final VersionInfoParcel zzd;

    public zzeib(Context context, zzdhj zzdhj, VersionInfoParcel versionInfoParcel) {
        this.zza = context;
        this.zzb = zzdhj;
        this.zzd = versionInfoParcel;
    }

    public final /* bridge */ /* synthetic */ Object zza(zzfff zzfff, zzfet zzfet, zzefe zzefe) throws zzffv, zzeiz {
        if (zzfff.zza.zza.zzg.contains(Integer.toString(6))) {
            zzdiy zzt = zzdiy.zzt(this.zzc);
            zzffo zzffo = zzfff.zza.zza;
            if (zzffo.zzg.contains(Integer.toString(zzt.zzc()))) {
                zzdja zze = this.zzb.zze(new zzcsg(zzfff, zzfet, zzefe.zza), new zzdjk(zzt), new zzdlb((zzbps) null, (zzbpr) null, this.zzc));
                ((zzegx) zzefe.zzc).zzc(zze.zzj());
                return zze.zza();
            }
            throw new zzeiz(1, "No corresponding native ad listener");
        }
        throw new zzeiz(2, "Unified must be used for RTB.");
    }

    public final void zzb(zzfff zzfff, zzfet zzfet, zzefe zzefe) throws zzffv {
        try {
            ((zzbrf) zzefe.zzb).zzq(zzfet.zzZ);
            if (this.zzd.clientJarVersion < ((Integer) zzbe.zzc().zza(zzbcn.zzbN)).intValue()) {
                ((zzbrf) zzefe.zzb).zzm(zzfet.zzU, zzfet.zzv.toString(), zzfff.zza.zza.zzd, ObjectWrapper.wrap(this.zza), new zzehz(this, zzefe, (zzeia) null), (zzbpm) zzefe.zzc);
            } else {
                ((zzbrf) zzefe.zzb).zzn(zzfet.zzU, zzfet.zzv.toString(), zzfff.zza.zza.zzd, ObjectWrapper.wrap(this.zza), new zzehz(this, zzefe, (zzeia) null), (zzbpm) zzefe.zzc, zzfff.zza.zza.zzi);
            }
        } catch (RemoteException e) {
            throw new zzffv(e);
        }
    }
}
