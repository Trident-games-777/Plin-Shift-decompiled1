package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzcc;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.rewarded.OnAdMetadataChangedListener;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzfep implements OnAdMetadataChangedListener {
    final /* synthetic */ zzcc zza;
    final /* synthetic */ zzfeq zzb;

    zzfep(zzfeq zzfeq, zzcc zzcc) {
        this.zza = zzcc;
        this.zzb = zzfeq;
    }

    public final void onAdMetadataChanged() {
        if (this.zzb.zzd != null) {
            try {
                this.zza.zze();
            } catch (RemoteException e) {
                zzm.zzl("#007 Could not call remote method.", e);
            }
        }
    }
}
