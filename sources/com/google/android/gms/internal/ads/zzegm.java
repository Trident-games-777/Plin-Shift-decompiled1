package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutionException;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzegm implements zzefh {
    private final Context zza;
    private final zzcqh zzb;
    /* access modifiers changed from: private */
    public View zzc;
    /* access modifiers changed from: private */
    public zzbpp zzd;

    public zzegm(Context context, zzcqh zzcqh) {
        this.zza = context;
        this.zzb = zzcqh;
    }

    public final /* bridge */ /* synthetic */ Object zza(zzfff zzfff, zzfet zzfet, zzefe zzefe) throws zzffv, zzeiz {
        View view;
        if (!((Boolean) zzbe.zzc().zza(zzbcn.zzhy)).booleanValue() || !zzfet.zzag) {
            view = this.zzc;
        } else {
            try {
                view = (View) ObjectWrapper.unwrap(this.zzd.zze());
                boolean zzf = this.zzd.zzf();
                if (view == null) {
                    throw new zzffv(new Exception("BannerRtbAdapterWrapper interscrollerView should not be null"));
                } else if (zzf) {
                    try {
                        view = (View) zzgei.zzn(zzgei.zzh((Object) null), new zzegj(this, view, zzfet), zzcaj.zze).get();
                    } catch (InterruptedException | ExecutionException e) {
                        throw new zzffv(e);
                    }
                }
            } catch (RemoteException e2) {
                throw new zzffv(e2);
            }
        }
        zzcpe zza2 = this.zzb.zza(new zzcsg(zzfff, zzfet, zzefe.zza), new zzcpk(view, (zzcfk) null, new zzegi(zzefe), (zzfeu) zzfet.zzu.get(0)));
        zza2.zzg().zza(view);
        ((zzegx) zzefe.zzc).zzc(zza2.zzj());
        return zza2.zza();
    }

    public final void zzb(zzfff zzfff, zzfet zzfet, zzefe zzefe) throws zzffv {
        try {
            ((zzbrf) zzefe.zzb).zzq(zzfet.zzZ);
            if (!((Boolean) zzbe.zzc().zza(zzbcn.zzhy)).booleanValue() || !zzfet.zzag) {
                ((zzbrf) zzefe.zzb).zzj(zzfet.zzU, zzfet.zzv.toString(), zzfff.zza.zza.zzd, ObjectWrapper.wrap(this.zza), new zzegk(this, zzefe, (zzegl) null), (zzbpm) zzefe.zzc, zzfff.zza.zza.zze);
            } else {
                ((zzbrf) zzefe.zzb).zzk(zzfet.zzU, zzfet.zzv.toString(), zzfff.zza.zza.zzd, ObjectWrapper.wrap(this.zza), new zzegk(this, zzefe, (zzegl) null), (zzbpm) zzefe.zzc, zzfff.zza.zza.zze);
            }
        } catch (RemoteException e) {
            throw new zzffv(e);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zzc(View view, zzfet zzfet, Object obj) throws Exception {
        return zzgei.zzh(zzcrc.zza(this.zza, view, zzfet));
    }
}
