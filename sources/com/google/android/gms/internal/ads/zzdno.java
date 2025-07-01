package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzm;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzdno implements zzbjr {
    private final zzbhc zza;
    private final zzdoc zzb;
    private final zzhfr zzc;

    public zzdno(zzdjj zzdjj, zzdiy zzdiy, zzdoc zzdoc, zzhfr zzhfr) {
        this.zza = zzdjj.zzc(zzdiy.zzA());
        this.zzb = zzdoc;
        this.zzc = zzhfr;
    }

    public final void zza(Object obj, Map map) {
        String str = (String) map.get("asset");
        try {
            this.zza.zze((zzbgs) this.zzc.zzb(), str);
        } catch (RemoteException e) {
            zzm.zzk("Failed to call onCustomClick for asset " + str + ".", e);
        }
    }

    public final void zzb() {
        if (this.zza != null) {
            this.zzb.zzl("/nativeAdCustomClick", this);
        }
    }
}
