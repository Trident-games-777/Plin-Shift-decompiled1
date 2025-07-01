package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzv;
import java.io.IOException;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzbjd implements zzbjr {
    zzbjd() {
    }

    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzcfk zzcfk = (zzcfk) obj;
        try {
            zzftl.zzj(zzcfk.getContext()).zzk();
            zzftm.zzi(zzcfk.getContext()).zzj();
            zzftn.zza(zzcfk.getContext()).zzb((zzfth) null);
        } catch (IOException e) {
            zzv.zzp().zzw(e, "DefaultGmsgHandlers.ResetPaid");
        }
    }
}
