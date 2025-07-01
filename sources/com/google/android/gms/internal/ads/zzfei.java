package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzdo;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.rewarded.OnAdMetadataChangedListener;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzfei implements OnAdMetadataChangedListener {
    final /* synthetic */ zzdo zza;
    final /* synthetic */ zzfek zzb;

    zzfei(zzfek zzfek, zzdo zzdo) {
        this.zza = zzdo;
        this.zzb = zzfek;
    }

    public final void onAdMetadataChanged() {
        if (this.zzb.zzi != null) {
            try {
                this.zza.zze();
            } catch (RemoteException e) {
                zzm.zzl("#007 Could not call remote method.", e);
            }
        }
    }
}
