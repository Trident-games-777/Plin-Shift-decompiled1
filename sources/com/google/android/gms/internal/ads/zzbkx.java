package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.os.RemoteException;
import com.google.android.gms.ads.h5.OnH5AdsEventListener;
import com.google.android.gms.ads.internal.client.zzbc;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
public final class zzbkx {
    private final Context zza;
    private final OnH5AdsEventListener zzb;
    private zzbkt zzc;

    public zzbkx(Context context, OnH5AdsEventListener onH5AdsEventListener) {
        Preconditions.checkState(true, "Android version must be Lollipop or higher");
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(onH5AdsEventListener);
        this.zza = context;
        this.zzb = onH5AdsEventListener;
        zzbcn.zza(context);
    }

    public static final boolean zzc(String str) {
        if (!((Boolean) zzbe.zzc().zza(zzbcn.zzjC)).booleanValue()) {
            return false;
        }
        Preconditions.checkNotNull(str);
        if (str.length() > ((Integer) zzbe.zzc().zza(zzbcn.zzjE)).intValue()) {
            zzm.zze("H5 GMSG exceeds max length");
            return false;
        }
        Uri parse = Uri.parse(str);
        if (!"gmsg".equals(parse.getScheme()) || !"mobileads.google.com".equals(parse.getHost()) || !"/h5ads".equals(parse.getPath())) {
            return false;
        }
        return true;
    }

    private final void zzd() {
        if (this.zzc == null) {
            this.zzc = zzbc.zza().zzn(this.zza, new zzbpc(), this.zzb);
        }
    }

    public final void zza() {
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzjC)).booleanValue()) {
            zzd();
            zzbkt zzbkt = this.zzc;
            if (zzbkt != null) {
                try {
                    zzbkt.zze();
                } catch (RemoteException e) {
                    zzm.zzl("#007 Could not call remote method.", e);
                }
            }
        }
    }

    public final boolean zzb(String str) {
        if (!zzc(str)) {
            return false;
        }
        zzd();
        zzbkt zzbkt = this.zzc;
        if (zzbkt == null) {
            return false;
        }
        try {
            zzbkt.zzf(str);
            return true;
        } catch (RemoteException e) {
            zzm.zzl("#007 Could not call remote method.", e);
            return true;
        }
    }
}
