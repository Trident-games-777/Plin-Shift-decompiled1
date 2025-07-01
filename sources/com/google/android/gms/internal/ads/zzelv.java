package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.formats.AdManagerAdViewOptions;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import com.google.android.gms.ads.internal.client.zzbl;
import com.google.android.gms.ads.internal.client.zzbr;
import com.google.android.gms.ads.internal.client.zzbt;
import com.google.android.gms.ads.internal.client.zzcq;
import com.google.android.gms.ads.internal.client.zzs;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzelv extends zzbt {
    final zzffm zza;
    final zzdjh zzb = new zzdjh();
    private final Context zzc;
    private final zzchk zzd;
    private zzbl zze;

    public zzelv(zzchk zzchk, Context context, String str) {
        zzffm zzffm = new zzffm();
        this.zza = zzffm;
        this.zzd = zzchk;
        zzffm.zzt(str);
        this.zzc = context;
    }

    public final zzbr zze() {
        zzdjj zzg = this.zzb.zzg();
        this.zza.zzE(zzg.zzi());
        this.zza.zzF(zzg.zzh());
        zzffm zzffm = this.zza;
        if (zzffm.zzh() == null) {
            zzffm.zzs(zzs.zzc());
        }
        return new zzelw(this.zzc, this.zzd, this.zza, zzg, this.zze);
    }

    public final void zzf(zzbgw zzbgw) {
        this.zzb.zza(zzbgw);
    }

    public final void zzg(zzbgz zzbgz) {
        this.zzb.zzb(zzbgz);
    }

    public final void zzh(String str, zzbhf zzbhf, zzbhc zzbhc) {
        this.zzb.zzc(str, zzbhf, zzbhc);
    }

    public final void zzi(zzbmk zzbmk) {
        this.zzb.zzd(zzbmk);
    }

    public final void zzj(zzbhj zzbhj, zzs zzs) {
        this.zzb.zze(zzbhj);
        this.zza.zzs(zzs);
    }

    public final void zzk(zzbhm zzbhm) {
        this.zzb.zzf(zzbhm);
    }

    public final void zzl(zzbl zzbl) {
        this.zze = zzbl;
    }

    public final void zzm(AdManagerAdViewOptions adManagerAdViewOptions) {
        this.zza.zzr(adManagerAdViewOptions);
    }

    public final void zzn(zzbmb zzbmb) {
        this.zza.zzw(zzbmb);
    }

    public final void zzo(zzbfn zzbfn) {
        this.zza.zzD(zzbfn);
    }

    public final void zzp(PublisherAdViewOptions publisherAdViewOptions) {
        this.zza.zzG(publisherAdViewOptions);
    }

    public final void zzq(zzcq zzcq) {
        this.zza.zzV(zzcq);
    }
}
