package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.client.zzbi;
import com.google.android.gms.ads.internal.util.client.zzm;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzemw implements zza, zzdel {
    private zzbi zza;

    public final synchronized void onAdClicked() {
        zzbi zzbi = this.zza;
        if (zzbi != null) {
            try {
                zzbi.zzb();
            } catch (RemoteException e) {
                zzm.zzk("Remote Exception at onAdClicked.", e);
            }
        }
    }

    public final synchronized void zza(zzbi zzbi) {
        this.zza = zzbi;
    }

    public final synchronized void zzdG() {
        zzbi zzbi = this.zza;
        if (zzbi != null) {
            try {
                zzbi.zzb();
            } catch (RemoteException e) {
                zzm.zzk("Remote Exception at onPhysicalClick.", e);
            }
        }
    }

    public final synchronized void zzdf() {
    }
}
