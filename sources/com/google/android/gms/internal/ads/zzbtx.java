package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.internal.client.zzbc;
import com.google.android.gms.ads.internal.client.zzei;
import com.google.android.gms.ads.internal.client.zzm;
import com.google.android.gms.ads.internal.client.zzn;
import com.google.android.gms.ads.internal.client.zzr;
import com.google.android.gms.ads.internal.client.zzs;
import com.google.android.gms.ads.query.QueryInfoGenerationCallback;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
public final class zzbtx {
    private static zzbzh zza;
    private final Context zzb;
    private final AdFormat zzc;
    private final zzei zzd;
    private final String zze;

    public zzbtx(Context context, AdFormat adFormat, zzei zzei, String str) {
        this.zzb = context;
        this.zzc = adFormat;
        this.zzd = zzei;
        this.zze = str;
    }

    public static zzbzh zza(Context context) {
        zzbzh zzbzh;
        synchronized (zzbtx.class) {
            if (zza == null) {
                zza = zzbc.zza().zzt(context, new zzbpc());
            }
            zzbzh = zza;
        }
        return zzbzh;
    }

    public final void zzb(QueryInfoGenerationCallback queryInfoGenerationCallback) {
        zzm zzm;
        long currentTimeMillis = System.currentTimeMillis();
        zzbzh zza2 = zza(this.zzb);
        if (zza2 == null) {
            queryInfoGenerationCallback.onFailure("Internal Error, query info generator is null.");
            return;
        }
        Context context = this.zzb;
        zzei zzei = this.zzd;
        IObjectWrapper wrap = ObjectWrapper.wrap(context);
        if (zzei == null) {
            zzn zzn = new zzn();
            zzn.zzg(currentTimeMillis);
            zzm = zzn.zza();
        } else {
            zzei.zzq(currentTimeMillis);
            zzm = zzr.zza.zza(this.zzb, this.zzd);
        }
        try {
            zza2.zzf(wrap, new zzbzl(this.zze, this.zzc.name(), (zzs) null, zzm), new zzbtw(this, queryInfoGenerationCallback));
        } catch (RemoteException unused) {
            queryInfoGenerationCallback.onFailure("Internal Error.");
        }
    }
}
