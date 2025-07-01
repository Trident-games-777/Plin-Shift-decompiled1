package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import androidx.collection.ArrayMap;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.overlay.zzr;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.internal.ads.zzbbs;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzdgw implements zzcya, zzr, zzcxg {
    zzeew zza;
    private final Context zzb;
    private final zzcfk zzc;
    private final zzfet zzd;
    private final VersionInfoParcel zze;
    private final zzbbs.zza.C0000zza zzf;
    private final zzeeu zzg;

    public zzdgw(Context context, zzcfk zzcfk, zzfet zzfet, VersionInfoParcel versionInfoParcel, zzbbs.zza.C0000zza zza2, zzeeu zzeeu) {
        this.zzb = context;
        this.zzc = zzcfk;
        this.zzd = zzfet;
        this.zze = versionInfoParcel;
        this.zzf = zza2;
        this.zzg = zzeeu;
    }

    private final boolean zzg() {
        return ((Boolean) zzbe.zzc().zza(zzbcn.zzfe)).booleanValue() && this.zzg.zzd();
    }

    public final void zzdH() {
    }

    public final void zzdk() {
    }

    public final void zzdq() {
    }

    public final void zzdr() {
        if (!((Boolean) zzbe.zzc().zza(zzbcn.zzfj)).booleanValue() && this.zzc != null) {
            if (this.zza == null && !zzg()) {
                return;
            }
            if (this.zza != null) {
                this.zzc.zzd("onSdkImpression", new ArrayMap());
            } else {
                this.zzg.zzb();
            }
        }
    }

    public final void zzdt() {
    }

    public final void zzdu(int i) {
        this.zza = null;
    }

    public final void zzr() {
        if (zzg()) {
            this.zzg.zzb();
        } else if (this.zza != null && this.zzc != null) {
            if (((Boolean) zzbe.zzc().zza(zzbcn.zzfj)).booleanValue()) {
                this.zzc.zzd("onSdkImpression", new ArrayMap());
            }
        }
    }

    public final void zzs() {
        zzeet zzeet;
        zzeet zzeet2;
        zzees zzees;
        zzbbs.zza.C0000zza zza2;
        if ((((Boolean) zzbe.zzc().zza(zzbcn.zzfm)).booleanValue() || this.zzf == zzbbs.zza.C0000zza.REWARD_BASED_VIDEO_AD || (zza2 = this.zzf) == zzbbs.zza.C0000zza.INTERSTITIAL || zza2 == zzbbs.zza.C0000zza.APP_OPEN) && this.zzd.zzT && this.zzc != null) {
            if (!zzv.zzB().zzl(this.zzb)) {
                return;
            }
            if (zzg()) {
                this.zzg.zzc();
                return;
            }
            VersionInfoParcel versionInfoParcel = this.zze;
            String str = versionInfoParcel.buddyApkVersion + "." + versionInfoParcel.clientJarVersion;
            zzffr zzffr = this.zzd.zzV;
            String zza3 = zzffr.zza();
            if (zzffr.zzc() == 1) {
                zzees = zzees.VIDEO;
                zzeet2 = zzeet.DEFINED_BY_JAVASCRIPT;
            } else {
                if (this.zzd.zzY == 2) {
                    zzeet = zzeet.UNSPECIFIED;
                } else {
                    zzeet = zzeet.BEGIN_TO_RENDER;
                }
                zzeet2 = zzeet;
                zzees = zzees.HTML_DISPLAY;
            }
            this.zza = zzv.zzB().zza(str, this.zzc.zzG(), "", "javascript", zza3, zzeet2, zzees, this.zzd.zzal);
            View zzF = this.zzc.zzF();
            zzeew zzeew = this.zza;
            if (zzeew != null) {
                zzfmw zza4 = zzeew.zza();
                if (((Boolean) zzbe.zzc().zza(zzbcn.zzfd)).booleanValue()) {
                    zzv.zzB().zzj(zza4, this.zzc.zzG());
                    for (View zzg2 : this.zzc.zzV()) {
                        zzv.zzB().zzg(zza4, zzg2);
                    }
                } else {
                    zzv.zzB().zzj(zza4, zzF);
                }
                this.zzc.zzat(this.zza);
                zzv.zzB().zzk(zza4);
                this.zzc.zzd("onSdkLoaded", new ArrayMap());
            }
        }
    }
}
