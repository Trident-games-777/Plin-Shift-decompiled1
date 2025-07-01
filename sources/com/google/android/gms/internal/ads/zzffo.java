package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.formats.AdManagerAdViewOptions;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.client.zzcm;
import com.google.android.gms.ads.internal.client.zzcq;
import com.google.android.gms.ads.internal.client.zzga;
import com.google.android.gms.ads.internal.client.zzm;
import com.google.android.gms.ads.internal.client.zzs;
import com.google.android.gms.ads.internal.client.zzy;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzffo {
    public final zzga zza;
    public final zzbmb zzb;
    public final zzems zzc;
    public final zzm zzd;
    public final zzs zze;
    public final String zzf;
    public final ArrayList zzg;
    public final ArrayList zzh;
    public final zzbfn zzi;
    public final zzy zzj;
    public final int zzk;
    public final AdManagerAdViewOptions zzl;
    public final PublisherAdViewOptions zzm;
    public final zzcm zzn;
    public final zzffb zzo;
    public final boolean zzp;
    public final boolean zzq;
    public final boolean zzr;
    public final Bundle zzs;
    public final zzcq zzt;

    /* synthetic */ zzffo(zzffm zzffm, zzffn zzffn) {
        zzga zzga;
        zzbfn zzbfn;
        this.zze = zzffm.zzb;
        this.zzf = zzffm.zzc;
        this.zzt = zzffm.zzu;
        int i = zzffm.zza.zza;
        long j = zzffm.zza.zzb;
        Bundle bundle = zzffm.zza.zzc;
        int i2 = zzffm.zza.zzd;
        List list = zzffm.zza.zze;
        boolean z = zzffm.zza.zzf;
        int i3 = zzffm.zza.zzg;
        boolean z2 = true;
        if (!zzffm.zza.zzh && !zzffm.zze) {
            z2 = false;
        }
        this.zzd = new zzm(i, j, bundle, i2, list, z, i3, z2, zzffm.zza.zzi, zzffm.zza.zzj, zzffm.zza.zzk, zzffm.zza.zzl, zzffm.zza.zzm, zzffm.zza.zzn, zzffm.zza.zzo, zzffm.zza.zzp, zzffm.zza.zzq, zzffm.zza.zzr, zzffm.zza.zzs, zzffm.zza.zzt, zzffm.zza.zzu, zzffm.zza.zzv, com.google.android.gms.ads.internal.util.zzs.zza(zzffm.zza.zzw), zzffm.zza.zzx, zzffm.zza.zzy, zzffm.zza.zzz);
        if (zzffm.zzd != null) {
            zzga = zzffm.zzd;
        } else {
            zzga = zzffm.zzh != null ? zzffm.zzh.zzf : null;
        }
        this.zza = zzga;
        this.zzg = zzffm.zzf;
        this.zzh = zzffm.zzg;
        if (zzffm.zzf == null) {
            zzbfn = null;
        } else {
            zzbfn = zzffm.zzh == null ? new zzbfn(new NativeAdOptions.Builder().build()) : zzffm.zzh;
        }
        this.zzi = zzbfn;
        this.zzj = zzffm.zzi;
        this.zzk = zzffm.zzm;
        this.zzl = zzffm.zzj;
        this.zzm = zzffm.zzk;
        this.zzn = zzffm.zzl;
        this.zzb = zzffm.zzn;
        this.zzo = new zzffb(zzffm.zzo, (zzffa) null);
        this.zzp = zzffm.zzp;
        this.zzq = zzffm.zzq;
        this.zzc = zzffm.zzr;
        this.zzr = zzffm.zzs;
        this.zzs = zzffm.zzt;
    }

    public final zzbhp zza() {
        PublisherAdViewOptions publisherAdViewOptions = this.zzm;
        if (publisherAdViewOptions == null && this.zzl == null) {
            return null;
        }
        if (publisherAdViewOptions != null) {
            return publisherAdViewOptions.zzb();
        }
        return this.zzl.zza();
    }

    public final boolean zzb() {
        zzbce zzbce = zzbcn.zzdm;
        return this.zzf.matches((String) zzbe.zzc().zza(zzbce));
    }
}
