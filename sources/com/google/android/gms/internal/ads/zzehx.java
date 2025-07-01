package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzbr;
import java.util.ArrayList;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzehx implements zzefh {
    private final Context zza;
    private final zzdhj zzb;
    private final Executor zzc;

    public zzehx(Context context, zzdhj zzdhj, Executor executor) {
        this.zza = context;
        this.zzb = zzdhj;
        this.zzc = executor;
    }

    private static final boolean zzc(zzfff zzfff, int i) {
        return zzfff.zza.zza.zzg.contains(Integer.toString(i));
    }

    public final /* bridge */ /* synthetic */ Object zza(zzfff zzfff, zzfet zzfet, zzefe zzefe) throws zzffv, zzeiz {
        zzdiy zzdiy;
        zzbpr zzD = ((zzfgm) zzefe.zzb).zzD();
        zzbps zzE = ((zzfgm) zzefe.zzb).zzE();
        zzbpv zzd = ((zzfgm) zzefe.zzb).zzd();
        if (zzd != null && zzc(zzfff, 6)) {
            zzdiy = zzdiy.zzt(zzd);
        } else if (zzD != null && zzc(zzfff, 6)) {
            zzdiy = zzdiy.zzai(zzD);
        } else if (zzD != null && zzc(zzfff, 2)) {
            zzdiy = zzdiy.zzag(zzD);
        } else if (zzE != null && zzc(zzfff, 6)) {
            zzdiy = zzdiy.zzaj(zzE);
        } else if (zzE == null || !zzc(zzfff, 1)) {
            throw new zzeiz(1, "No native ad mappers");
        } else {
            zzdiy = zzdiy.zzah(zzE);
        }
        zzffo zzffo = zzfff.zza.zza;
        if (zzffo.zzg.contains(Integer.toString(zzdiy.zzc()))) {
            zzdja zze = this.zzb.zze(new zzcsg(zzfff, zzfet, zzefe.zza), new zzdjk(zzdiy), new zzdlb(zzE, zzD, zzd));
            ((zzegx) zzefe.zzc).zzc(zze.zzk());
            zze.zzd().zzo(new zzcmr((zzfgm) zzefe.zzb), this.zzc);
            return zze.zza();
        }
        throw new zzeiz(1, "No corresponding native ad listener");
    }

    public final void zzb(zzfff zzfff, zzfet zzfet, zzefe zzefe) throws zzffv {
        zzffo zzffo = zzfff.zza.zza;
        zzffo zzffo2 = zzfff.zza.zza;
        Context context = this.zza;
        zzbfn zzbfn = zzffo2.zzi;
        ArrayList arrayList = zzffo2.zzg;
        ((zzfgm) zzefe.zzb).zzp(context, zzffo.zzd, zzfet.zzv.toString(), zzbr.zzm(zzfet.zzs), (zzbpm) zzefe.zzc, zzbfn, arrayList);
    }
}
