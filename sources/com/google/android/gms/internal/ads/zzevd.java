package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzevd implements zzgdo {
    public final /* synthetic */ zzevg zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ List zzc;
    public final /* synthetic */ Bundle zzd;
    public final /* synthetic */ boolean zze;
    public final /* synthetic */ boolean zzf;

    public /* synthetic */ zzevd(zzevg zzevg, String str, List list, Bundle bundle, boolean z, boolean z2) {
        this.zza = zzevg;
        this.zzb = str;
        this.zzc = list;
        this.zzd = bundle;
        this.zze = z;
        this.zzf = z2;
    }

    public final ListenableFuture zza() {
        return this.zza.zzd(this.zzb, this.zzc, this.zzd, this.zze, this.zzf);
    }
}
