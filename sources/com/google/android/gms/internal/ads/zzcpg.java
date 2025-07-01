package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.client.zzby;
import com.google.android.gms.ads.internal.client.zzeb;
import com.google.android.gms.ads.internal.client.zzs;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzcpg extends zzcpd {
    private final Context zzc;
    private final View zzd;
    private final zzcfk zze;
    private final zzfeu zzf;
    private final zzcro zzg;
    private final zzdjj zzh;
    private final zzden zzi;
    private final zzhfr zzj;
    private final Executor zzk;
    private zzs zzl;

    zzcpg(zzcrp zzcrp, Context context, zzfeu zzfeu, View view, zzcfk zzcfk, zzcro zzcro, zzdjj zzdjj, zzden zzden, zzhfr zzhfr, Executor executor) {
        super(zzcrp);
        this.zzc = context;
        this.zzd = view;
        this.zze = zzcfk;
        this.zzf = zzfeu;
        this.zzg = zzcro;
        this.zzh = zzdjj;
        this.zzi = zzden;
        this.zzj = zzhfr;
        this.zzk = executor;
    }

    public static /* synthetic */ void zzj(zzcpg zzcpg) {
        zzdjj zzdjj = zzcpg.zzh;
        if (zzdjj.zze() != null) {
            try {
                zzdjj.zze().zze((zzby) zzcpg.zzj.zzb(), ObjectWrapper.wrap(zzcpg.zzc));
            } catch (RemoteException e) {
                zzm.zzh("RemoteException when notifyAdLoad is called", e);
            }
        }
    }

    public final int zza() {
        return this.zza.zzb.zzb.zzd;
    }

    public final int zzc() {
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzhy)).booleanValue() && this.zzb.zzag) {
            if (!((Boolean) zzbe.zzc().zza(zzbcn.zzhz)).booleanValue()) {
                return 0;
            }
        }
        return this.zza.zzb.zzb.zzc;
    }

    public final View zzd() {
        return this.zzd;
    }

    public final zzeb zze() {
        try {
            return this.zzg.zza();
        } catch (zzffv unused) {
            return null;
        }
    }

    public final zzfeu zzf() {
        zzs zzs = this.zzl;
        if (zzs != null) {
            return zzffu.zzb(zzs);
        }
        zzfet zzfet = this.zzb;
        if (zzfet.zzac) {
            for (String str : zzfet.zza) {
                if (str == null || !str.contains("FirstParty")) {
                }
            }
            View view = this.zzd;
            return new zzfeu(view.getWidth(), view.getHeight(), false);
        }
        return (zzfeu) this.zzb.zzr.get(0);
    }

    public final zzfeu zzg() {
        return this.zzf;
    }

    public final void zzh() {
        this.zzi.zza();
    }

    public final void zzi(ViewGroup viewGroup, zzs zzs) {
        zzcfk zzcfk;
        if (viewGroup != null && (zzcfk = this.zze) != null) {
            zzcfk.zzaj(zzche.zzc(zzs));
            viewGroup.setMinimumHeight(zzs.zzc);
            viewGroup.setMinimumWidth(zzs.zzf);
            this.zzl = zzs;
        }
    }

    public final void zzk() {
        this.zzk.execute(new zzcpf(this));
        super.zzk();
    }
}
