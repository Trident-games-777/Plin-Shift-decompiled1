package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzv;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzbms implements zzchb {
    public final /* synthetic */ zzbnd zza;

    public /* synthetic */ zzbms(zzbnd zzbnd) {
        this.zza = zzbnd;
    }

    public final void zza() {
        long currentTimeMillis = zzv.zzC().currentTimeMillis();
        zzbnd zzbnd = this.zza;
        long j = zzbnd.zzc;
        ArrayList arrayList = zzbnd.zzb;
        arrayList.add(Long.valueOf(currentTimeMillis - j));
        String valueOf = String.valueOf(arrayList.get(0));
        zze.zza("LoadNewJavascriptEngine(onEngLoaded) latency is " + valueOf + " ms.");
        zzs.zza.postDelayed(new zzbmz(zzbnd.zza, zzbnd.zzd, zzbnd.zze, arrayList, j), (long) ((Integer) zzbe.zzc().zza(zzbcn.zzb)).intValue());
    }
}
