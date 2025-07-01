package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.internal.ads.zzbbs;
import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzdha implements zzcwm, zzddq {
    private final zzbyr zza;
    private final Context zzb;
    private final zzbyv zzc;
    private final View zzd;
    private String zze;
    private final zzbbs.zza.C0000zza zzf;

    public zzdha(zzbyr zzbyr, Context context, zzbyv zzbyv, View view, zzbbs.zza.C0000zza zza2) {
        this.zza = zzbyr;
        this.zzb = context;
        this.zzc = zzbyv;
        this.zzd = view;
        this.zzf = zza2;
    }

    public final void zza() {
        this.zza.zzb(false);
    }

    public final void zzb() {
    }

    public final void zzc() {
        View view = this.zzd;
        if (!(view == null || this.zze == null)) {
            this.zzc.zzo(view.getContext(), this.zze);
        }
        this.zza.zzb(true);
    }

    @ParametersAreNonnullByDefault
    public final void zzds(zzbwj zzbwj, String str, String str2) {
        if (this.zzc.zzp(this.zzb)) {
            try {
                zzbyv zzbyv = this.zzc;
                Context context = this.zzb;
                zzbyv.zzl(context, zzbyv.zza(context), this.zza.zza(), zzbwj.zzc(), zzbwj.zzb());
            } catch (RemoteException e) {
                zzm.zzk("Remote Exception to get reward item.", e);
            }
        }
    }

    public final void zze() {
    }

    public final void zzf() {
    }

    public final void zzk() {
    }

    public final void zzl() {
        if (this.zzf != zzbbs.zza.C0000zza.APP_OPEN) {
            String zzc2 = this.zzc.zzc(this.zzb);
            this.zze = zzc2;
            this.zze = String.valueOf(zzc2).concat(this.zzf == zzbbs.zza.C0000zza.REWARD_BASED_VIDEO_AD ? "/Rewarded" : "/Interstitial");
        }
    }
}
