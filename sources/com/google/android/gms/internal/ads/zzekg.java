package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.util.client.zzm;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzekg implements zzefd {
    private final zzelk zza;
    private final zzdqd zzb;

    zzekg(zzelk zzelk, zzdqd zzdqd) {
        this.zza = zzelk;
        this.zzb = zzdqd;
    }

    public final zzefe zza(String str, JSONObject jSONObject) throws zzffv {
        zzbrf zzbrf;
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzbK)).booleanValue()) {
            try {
                zzbrf = this.zzb.zzb(str);
            } catch (RemoteException e) {
                zzm.zzh("Coundn't create RTB adapter: ", e);
                zzbrf = null;
            }
        } else {
            zzbrf = this.zza.zza(str);
        }
        if (zzbrf == null) {
            return null;
        }
        return new zzefe(zzbrf, new zzegx(), str);
    }
}
