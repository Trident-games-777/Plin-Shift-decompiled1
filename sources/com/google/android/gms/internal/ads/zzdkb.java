package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzm;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzdkb implements zzbjr {
    public final /* synthetic */ zzdkc zza;
    public final /* synthetic */ zzbhs zzb;

    public /* synthetic */ zzdkb(zzdkc zzdkc, zzbhs zzbhs) {
        this.zza = zzdkc;
        this.zzb = zzbhs;
    }

    public final void zza(Object obj, Map map) {
        zzdkc zzdkc = this.zza;
        try {
            zzdkc.zzb = Long.valueOf(Long.parseLong((String) map.get("timestamp")));
        } catch (NumberFormatException unused) {
            zzm.zzg("Failed to call parse unconfirmedClickTimestamp.");
        }
        zzbhs zzbhs = this.zzb;
        zzdkc.zza = (String) map.get("id");
        String str = (String) map.get("asset_id");
        if (zzbhs == null) {
            zzm.zze("Received unconfirmed click but UnconfirmedClickListener is null.");
            return;
        }
        try {
            zzbhs.zzf(str);
        } catch (RemoteException e) {
            zzm.zzl("#007 Could not call remote method.", e);
        }
    }
}
