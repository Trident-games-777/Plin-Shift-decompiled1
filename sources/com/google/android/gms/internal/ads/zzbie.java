package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.admanager.AdManagerAdView;
import com.google.android.gms.ads.admanager.AppEventListener;
import com.google.android.gms.ads.formats.OnAdManagerAdViewLoadedListener;
import com.google.android.gms.ads.internal.client.zzby;
import com.google.android.gms.ads.internal.client.zzg;
import com.google.android.gms.ads.internal.util.client.zzf;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
public final class zzbie extends zzbhi {
    /* access modifiers changed from: private */
    public final OnAdManagerAdViewLoadedListener zza;

    public zzbie(OnAdManagerAdViewLoadedListener onAdManagerAdViewLoadedListener) {
        this.zza = onAdManagerAdViewLoadedListener;
    }

    public final void zze(zzby zzby, IObjectWrapper iObjectWrapper) {
        if (zzby != null && iObjectWrapper != null) {
            AdManagerAdView adManagerAdView = new AdManagerAdView((Context) ObjectWrapper.unwrap(iObjectWrapper));
            AppEventListener appEventListener = null;
            try {
                if (zzby.zzi() instanceof zzg) {
                    zzg zzg = (zzg) zzby.zzi();
                    adManagerAdView.setAdListener(zzg != null ? zzg.zzb() : null);
                }
            } catch (RemoteException e) {
                zzm.zzh("", e);
            }
            try {
                if (zzby.zzj() instanceof zzaza) {
                    zzaza zzaza = (zzaza) zzby.zzj();
                    if (zzaza != null) {
                        appEventListener = zzaza.zzb();
                    }
                    adManagerAdView.setAppEventListener(appEventListener);
                }
            } catch (RemoteException e2) {
                zzm.zzh("", e2);
            }
            zzf.zza.post(new zzbid(this, adManagerAdView, zzby));
        }
    }
}
