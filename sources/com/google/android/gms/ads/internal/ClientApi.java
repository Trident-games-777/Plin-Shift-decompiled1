package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.client.zzbu;
import com.google.android.gms.ads.internal.client.zzby;
import com.google.android.gms.ads.internal.client.zzci;
import com.google.android.gms.ads.internal.client.zzco;
import com.google.android.gms.ads.internal.client.zzcz;
import com.google.android.gms.ads.internal.client.zzdu;
import com.google.android.gms.ads.internal.client.zzs;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzab;
import com.google.android.gms.ads.internal.overlay.zzaf;
import com.google.android.gms.ads.internal.overlay.zzah;
import com.google.android.gms.ads.internal.overlay.zzai;
import com.google.android.gms.ads.internal.overlay.zzv;
import com.google.android.gms.ads.internal.overlay.zzw;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbgc;
import com.google.android.gms.internal.ads.zzbgi;
import com.google.android.gms.internal.ads.zzbkq;
import com.google.android.gms.internal.ads.zzbkt;
import com.google.android.gms.internal.ads.zzbpg;
import com.google.android.gms.internal.ads.zzbsz;
import com.google.android.gms.internal.ads.zzbtg;
import com.google.android.gms.internal.ads.zzbwm;
import com.google.android.gms.internal.ads.zzbxc;
import com.google.android.gms.internal.ads.zzbzh;
import com.google.android.gms.internal.ads.zzchk;
import com.google.android.gms.internal.ads.zzdjs;
import com.google.android.gms.internal.ads.zzdju;
import com.google.android.gms.internal.ads.zzdtv;
import com.google.android.gms.internal.ads.zzelv;
import com.google.android.gms.internal.ads.zzezt;
import com.google.android.gms.internal.ads.zzfbh;
import com.google.android.gms.internal.ads.zzfcy;
import com.google.android.gms.internal.ads.zzfem;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public class ClientApi extends zzco {
    public final zzbu zzb(IObjectWrapper iObjectWrapper, String str, zzbpg zzbpg, int i) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        return new zzelv(zzchk.zzb(context, zzbpg, i), context, str);
    }

    public final zzby zzc(IObjectWrapper iObjectWrapper, zzs zzs, String str, zzbpg zzbpg, int i) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzezt zzt = zzchk.zzb(context, zzbpg, i).zzt();
        zzt.zza(str);
        zzt.zzb(context);
        return zzt.zzc().zza();
    }

    public final zzby zzd(IObjectWrapper iObjectWrapper, zzs zzs, String str, zzbpg zzbpg, int i) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzfbh zzu = zzchk.zzb(context, zzbpg, i).zzu();
        zzu.zzc(context);
        zzu.zza(zzs);
        zzu.zzb(str);
        return zzu.zzd().zza();
    }

    public final zzby zze(IObjectWrapper iObjectWrapper, zzs zzs, String str, zzbpg zzbpg, int i) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzfcy zzv = zzchk.zzb(context, zzbpg, i).zzv();
        zzv.zzc(context);
        zzv.zza(zzs);
        zzv.zzb(str);
        return zzv.zzd().zza();
    }

    public final zzby zzf(IObjectWrapper iObjectWrapper, zzs zzs, String str, int i) {
        return new zzu((Context) ObjectWrapper.unwrap(iObjectWrapper), zzs, str, new VersionInfoParcel(243799000, i, true, false));
    }

    public final zzci zzg(IObjectWrapper iObjectWrapper, zzbpg zzbpg, int i) {
        return zzchk.zzb((Context) ObjectWrapper.unwrap(iObjectWrapper), zzbpg, i).zzA();
    }

    public final zzcz zzh(IObjectWrapper iObjectWrapper, int i) {
        return zzchk.zzb((Context) ObjectWrapper.unwrap(iObjectWrapper), (zzbpg) null, i).zzc();
    }

    public final zzdu zzi(IObjectWrapper iObjectWrapper, zzbpg zzbpg, int i) {
        return zzchk.zzb((Context) ObjectWrapper.unwrap(iObjectWrapper), zzbpg, i).zzm();
    }

    public final zzbgc zzj(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) {
        return new zzdju((FrameLayout) ObjectWrapper.unwrap(iObjectWrapper), (FrameLayout) ObjectWrapper.unwrap(iObjectWrapper2), 243799000);
    }

    public final zzbgi zzk(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) {
        return new zzdjs((View) ObjectWrapper.unwrap(iObjectWrapper), (HashMap) ObjectWrapper.unwrap(iObjectWrapper2), (HashMap) ObjectWrapper.unwrap(iObjectWrapper3));
    }

    public final zzbkt zzl(IObjectWrapper iObjectWrapper, zzbpg zzbpg, int i, zzbkq zzbkq) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzdtv zzk = zzchk.zzb(context, zzbpg, i).zzk();
        zzk.zzb(context);
        zzk.zza(zzbkq);
        return zzk.zzc().zzd();
    }

    public final zzbsz zzm(IObjectWrapper iObjectWrapper, zzbpg zzbpg, int i) {
        return zzchk.zzb((Context) ObjectWrapper.unwrap(iObjectWrapper), zzbpg, i).zzn();
    }

    public final zzbtg zzn(IObjectWrapper iObjectWrapper) {
        Activity activity = (Activity) ObjectWrapper.unwrap(iObjectWrapper);
        AdOverlayInfoParcel zza = AdOverlayInfoParcel.zza(activity.getIntent());
        if (zza == null) {
            return new zzw(activity);
        }
        int i = zza.zzk;
        if (i == 1) {
            return new zzv(activity);
        }
        if (i == 2) {
            return new zzah(activity);
        }
        if (i == 3) {
            return new zzai(activity);
        }
        if (i != 4) {
            return i != 5 ? new zzw(activity) : new zzaf(activity);
        }
        return new zzab(activity, zza);
    }

    public final zzbwm zzo(IObjectWrapper iObjectWrapper, zzbpg zzbpg, int i) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzfem zzw = zzchk.zzb(context, zzbpg, i).zzw();
        zzw.zzb(context);
        return zzw.zzc().zzb();
    }

    public final zzbxc zzp(IObjectWrapper iObjectWrapper, String str, zzbpg zzbpg, int i) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzfem zzw = zzchk.zzb(context, zzbpg, i).zzw();
        zzw.zzb(context);
        zzw.zza(str);
        return zzw.zzc().zza();
    }

    public final zzbzh zzq(IObjectWrapper iObjectWrapper, zzbpg zzbpg, int i) {
        return zzchk.zzb((Context) ObjectWrapper.unwrap(iObjectWrapper), zzbpg, i).zzq();
    }
}
