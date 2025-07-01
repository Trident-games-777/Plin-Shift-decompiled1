package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import org.json.JSONArray;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzeht implements zzgdp {
    public final /* synthetic */ zzehv zza;
    public final /* synthetic */ zzfff zzb;
    public final /* synthetic */ zzfet zzc;

    public /* synthetic */ zzeht(zzehv zzehv, zzfff zzfff, zzfet zzfet) {
        this.zza = zzehv;
        this.zzb = zzfff;
        this.zzc = zzfet;
    }

    public final ListenableFuture zza(Object obj) {
        return this.zza.zzf(this.zzb, this.zzc, (JSONArray) obj);
    }
}
