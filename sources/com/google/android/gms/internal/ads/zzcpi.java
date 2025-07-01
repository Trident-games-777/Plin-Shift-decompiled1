package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.zzax;
import com.google.android.gms.ads.internal.zzv;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzcpi implements zzcya {
    public final /* synthetic */ Context zza;
    public final /* synthetic */ VersionInfoParcel zzb;
    public final /* synthetic */ zzfet zzc;
    public final /* synthetic */ zzffo zzd;

    public /* synthetic */ zzcpi(Context context, VersionInfoParcel versionInfoParcel, zzfet zzfet, zzffo zzffo) {
        this.zza = context;
        this.zzb = versionInfoParcel;
        this.zzc = zzfet;
        this.zzd = zzffo;
    }

    public final void zzs() {
        zzax zzt = zzv.zzt();
        Context context = this.zza;
        zzffo zzffo = this.zzd;
        zzt.zzn(context, this.zzb.afmaVersion, this.zzc.zzC.toString(), zzffo.zzf);
    }
}
