package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.zzbr;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzehi implements zzefh {
    private final Context zza;
    private final zzdgn zzb;
    private final VersionInfoParcel zzc;
    private final Executor zzd;

    public zzehi(Context context, VersionInfoParcel versionInfoParcel, zzdgn zzdgn, Executor executor) {
        this.zza = context;
        this.zzc = versionInfoParcel;
        this.zzb = zzdgn;
        this.zzd = executor;
    }

    public final /* bridge */ /* synthetic */ Object zza(zzfff zzfff, zzfet zzfet, zzefe zzefe) throws zzffv, zzeiz {
        zzdfk zze = this.zzb.zze(new zzcsg(zzfff, zzfet, zzefe.zza), new zzdfn(new zzehh(this, zzefe), (zzcfk) null));
        zze.zzd().zzo(new zzcmr((zzfgm) zzefe.zzb), this.zzd);
        ((zzegx) zzefe.zzc).zzc(zze.zzk());
        return zze.zzg();
    }

    public final void zzb(zzfff zzfff, zzfet zzfet, zzefe zzefe) throws zzffv {
        zzffo zzffo = zzfff.zza.zza;
        String jSONObject = zzfet.zzv.toString();
        String zzm = zzbr.zzm(zzfet.zzs);
        ((zzfgm) zzefe.zzb).zzo(this.zza, zzffo.zzd, jSONObject, zzm, (zzbpm) zzefe.zzc);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzc(zzefe zzefe, boolean z, Context context, zzcwz zzcwz) throws zzdgu {
        try {
            ((zzfgm) zzefe.zzb).zzv(z);
            if (this.zzc.clientJarVersion < ((Integer) zzbe.zzc().zza(zzbcn.zzaP)).intValue()) {
                ((zzfgm) zzefe.zzb).zzx();
            } else {
                ((zzfgm) zzefe.zzb).zzy(context);
            }
        } catch (zzffv e) {
            zzm.zzi("Cannot show interstitial.");
            throw new zzdgu(e.getCause());
        }
    }
}
