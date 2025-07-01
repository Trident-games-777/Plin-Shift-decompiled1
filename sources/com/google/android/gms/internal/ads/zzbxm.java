package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.rewarded.RewardItem;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
public final class zzbxm implements RewardItem {
    private final zzbwz zza;

    public zzbxm(zzbwz zzbwz) {
        this.zza = zzbwz;
    }

    public final int getAmount() {
        zzbwz zzbwz = this.zza;
        if (zzbwz != null) {
            try {
                return zzbwz.zze();
            } catch (RemoteException e) {
                zzm.zzk("Could not forward getAmount to RewardItem", e);
            }
        }
        return 0;
    }

    public final String getType() {
        zzbwz zzbwz = this.zza;
        if (zzbwz != null) {
            try {
                return zzbwz.zzf();
            } catch (RemoteException e) {
                zzm.zzk("Could not forward getType to RewardItem", e);
            }
        }
        return null;
    }
}
