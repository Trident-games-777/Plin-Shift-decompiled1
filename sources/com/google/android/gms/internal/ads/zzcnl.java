package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzv;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzcnl implements zzgee {
    final /* synthetic */ zzcnn zza;

    zzcnl(zzcnn zzcnn) {
        this.zza = zzcnn;
    }

    public final void zza(Throwable th) {
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzcnn zzcnn = this.zza;
        zzfga zzj = zzcnn.zzh;
        List zzd = zzcnn.zzg.zzd(zzcnn.zze, zzcnn.zzf, false, "", (String) obj, zzcnn.zzf.zzc);
        int i = 1;
        if (true == zzv.zzp().zzA(this.zza.zza)) {
            i = 2;
        }
        zzj.zzc(zzd, i);
    }
}
