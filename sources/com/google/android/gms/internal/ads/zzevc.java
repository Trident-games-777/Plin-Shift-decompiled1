package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzevc implements Runnable {
    public final /* synthetic */ zzevg zza;
    public final /* synthetic */ zzbrf zzb;
    public final /* synthetic */ Bundle zzc;
    public final /* synthetic */ List zzd;
    public final /* synthetic */ zzelr zze;
    public final /* synthetic */ zzcao zzf;

    public /* synthetic */ zzevc(zzevg zzevg, zzbrf zzbrf, Bundle bundle, List list, zzelr zzelr, zzcao zzcao) {
        this.zza = zzevg;
        this.zzb = zzbrf;
        this.zzc = bundle;
        this.zzd = list;
        this.zze = zzelr;
        this.zzf = zzcao;
    }

    public final void run() {
        this.zza.zze(this.zzb, this.zzc, this.zzd, this.zze, this.zzf);
    }
}
