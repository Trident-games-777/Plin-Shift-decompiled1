package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.ads.zzdsm;
import com.google.android.gms.internal.ads.zzfka;
import com.google.android.gms.internal.ads.zzfko;
import com.google.android.gms.internal.ads.zzgdp;
import com.google.common.util.concurrent.ListenableFuture;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzd implements zzgdp {
    public final /* synthetic */ Long zza;
    public final /* synthetic */ zzdsm zzb;
    public final /* synthetic */ zzfko zzc;
    public final /* synthetic */ zzfka zzd;

    public /* synthetic */ zzd(zzf zzf, Long l, zzdsm zzdsm, zzfko zzfko, zzfka zzfka) {
        this.zza = l;
        this.zzb = zzdsm;
        this.zzc = zzfko;
        this.zzd = zzfka;
    }

    public final ListenableFuture zza(Object obj) {
        return zzf.zzd(this.zza, this.zzb, this.zzc, this.zzd, (JSONObject) obj);
    }
}
