package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzv;
import java.lang.ref.WeakReference;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzdor extends zzcrq {
    private final Context zzc;
    private final WeakReference zzd;
    private final zzdgv zze;
    private final zzddp zzf;
    private final zzcwz zzg;
    private final zzcyg zzh;
    private final zzcsl zzi;
    private final zzbwz zzj;
    private final zzfqa zzk;
    private final zzffh zzl;
    private boolean zzm = false;

    zzdor(zzcrp zzcrp, Context context, zzcfk zzcfk, zzdgv zzdgv, zzddp zzddp, zzcwz zzcwz, zzcyg zzcyg, zzcsl zzcsl, zzfet zzfet, zzfqa zzfqa, zzffh zzffh) {
        super(zzcrp);
        String str;
        this.zzc = context;
        this.zze = zzdgv;
        this.zzd = new WeakReference(zzcfk);
        this.zzf = zzddp;
        this.zzg = zzcwz;
        this.zzh = zzcyg;
        this.zzi = zzcsl;
        this.zzk = zzfqa;
        zzbwv zzbwv = zzfet.zzl;
        if (zzbwv != null) {
            str = zzbwv.zza;
        } else {
            str = "";
        }
        this.zzj = new zzbxt(str, zzbwv != null ? zzbwv.zzb : 1);
        this.zzl = zzffh;
    }

    public final void finalize() throws Throwable {
        try {
            zzcfk zzcfk = (zzcfk) this.zzd.get();
            if (((Boolean) zzbe.zzc().zza(zzbcn.zzgB)).booleanValue()) {
                if (!this.zzm && zzcfk != null) {
                    zzges zzges = zzcaj.zze;
                    Objects.requireNonNull(zzcfk);
                    zzges.execute(new zzdoq(zzcfk));
                }
            } else if (zzcfk != null) {
                zzcfk.destroy();
            }
        } finally {
            super.finalize();
        }
    }

    public final Bundle zza() {
        return this.zzh.zzb();
    }

    public final zzbwz zzc() {
        return this.zzj;
    }

    public final zzffh zzd() {
        return this.zzl;
    }

    public final boolean zze() {
        return this.zzi.zzg();
    }

    public final boolean zzf() {
        return this.zzm;
    }

    public final boolean zzg() {
        zzcfk zzcfk = (zzcfk) this.zzd.get();
        return zzcfk != null && !zzcfk.zzaG();
    }

    public final boolean zzh(boolean z, Activity activity) {
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzaJ)).booleanValue()) {
            zzv.zzq();
            if (zzs.zzG(this.zzc)) {
                zzm.zzj("Rewarded ads that show when your app is in the background are a violation of AdMob policies and may lead to blocked ad serving. To learn more, visit https://googlemobileadssdk.page.link/admob-interstitial-policies");
                this.zzg.zzb();
                if (((Boolean) zzbe.zzc().zza(zzbcn.zzaK)).booleanValue()) {
                    this.zzk.zza(this.zza.zzb.zzb.zzb);
                }
                return false;
            }
        }
        if (this.zzm) {
            zzm.zzj("The rewarded ad have been showed.");
            this.zzg.zza(zzfgq.zzd(10, (String) null, (zze) null));
            return false;
        }
        this.zzm = true;
        this.zzf.zzb();
        Context context = activity;
        if (activity == null) {
            context = this.zzc;
        }
        try {
            this.zze.zza(z, context, this.zzg);
            this.zzf.zza();
            return true;
        } catch (zzdgu e) {
            this.zzg.zzc(e);
            return false;
        }
    }
}
