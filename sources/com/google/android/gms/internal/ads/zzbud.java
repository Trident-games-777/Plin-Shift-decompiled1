package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.query.UpdateClickUrlCallback;
import com.google.android.gms.ads.query.UpdateImpressionUrlsCallback;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import javax.annotation.Nonnull;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
public final class zzbud {
    @Nonnull
    private final View zza;
    private final Map zzb;
    private final zzbzh zzc;

    public zzbud(zzbuc zzbuc) {
        View zza2 = zzbuc.zza;
        this.zza = zza2;
        Map zzd = zzbuc.zzb;
        this.zzb = zzd;
        zzbzh zza3 = zzbtx.zza(zzbuc.zza.getContext());
        this.zzc = zza3;
        if (zza3 != null && !zzd.isEmpty()) {
            try {
                zza3.zzg(new zzbue(ObjectWrapper.wrap(zza2).asBinder(), ObjectWrapper.wrap(zzd).asBinder()));
            } catch (RemoteException unused) {
                zzm.zzg("Failed to call remote method.");
            }
        }
    }

    public final void zza(List list) {
        if (list == null || list.isEmpty()) {
            zzm.zzj("No click urls were passed to recordClick");
            return;
        }
        if (this.zzc == null) {
            zzm.zzj("Failed to get internal reporting info generator in recordClick.");
        }
        try {
            this.zzc.zzh(list, ObjectWrapper.wrap(this.zza), new zzbub(this, list));
        } catch (RemoteException e) {
            zzm.zzg("RemoteException recording click: ".concat(e.toString()));
        }
    }

    public final void zzb(List list) {
        if (list == null || list.isEmpty()) {
            zzm.zzj("No impression urls were passed to recordImpression");
            return;
        }
        zzbzh zzbzh = this.zzc;
        if (zzbzh != null) {
            try {
                zzbzh.zzi(list, ObjectWrapper.wrap(this.zza), new zzbua(this, list));
            } catch (RemoteException e) {
                zzm.zzg("RemoteException recording impression urls: ".concat(e.toString()));
            }
        } else {
            zzm.zzj("Failed to get internal reporting info generator from recordImpression.");
        }
    }

    public final void zzc(MotionEvent motionEvent) {
        zzbzh zzbzh = this.zzc;
        if (zzbzh != null) {
            try {
                zzbzh.zzk(ObjectWrapper.wrap(motionEvent));
            } catch (RemoteException unused) {
                zzm.zzg("Failed to call remote method.");
            }
        } else {
            zzm.zze("Failed to get internal reporting info generator.");
        }
    }

    public final void zzd(Uri uri, UpdateClickUrlCallback updateClickUrlCallback) {
        if (this.zzc == null) {
            updateClickUrlCallback.onFailure("Failed to get internal reporting info generator.");
        }
        try {
            this.zzc.zzl(new ArrayList(Arrays.asList(new Uri[]{uri})), ObjectWrapper.wrap(this.zza), new zzbtz(this, updateClickUrlCallback));
        } catch (RemoteException e) {
            updateClickUrlCallback.onFailure("Internal error: ".concat(e.toString()));
        }
    }

    public final void zze(List list, UpdateImpressionUrlsCallback updateImpressionUrlsCallback) {
        if (this.zzc == null) {
            updateImpressionUrlsCallback.onFailure("Failed to get internal reporting info generator.");
        }
        try {
            this.zzc.zzm(list, ObjectWrapper.wrap(this.zza), new zzbty(this, updateImpressionUrlsCallback));
        } catch (RemoteException e) {
            updateImpressionUrlsCallback.onFailure("Internal error: ".concat(e.toString()));
        }
    }
}
