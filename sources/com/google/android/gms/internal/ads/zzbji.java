package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzm;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzbji implements zzbjr {
    zzbji() {
    }

    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzcfk zzcfk = (zzcfk) obj;
        if (zzcfk.zzJ() != null) {
            zzcfk.zzJ().zza();
        }
        zzm zzL = zzcfk.zzL();
        if (zzL != null) {
            zzL.zzb();
            return;
        }
        zzm zzM = zzcfk.zzM();
        if (zzM != null) {
            zzM.zzb();
        } else {
            com.google.android.gms.ads.internal.util.client.zzm.zzj("A GMSG tried to close something that wasn't an overlay.");
        }
    }
}
