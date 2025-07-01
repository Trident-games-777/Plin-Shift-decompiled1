package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.zzat;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzcvf implements zzfwh {
    public final /* synthetic */ Context zza;
    public final /* synthetic */ VersionInfoParcel zzb;
    public final /* synthetic */ zzffo zzc;

    public /* synthetic */ zzcvf(Context context, VersionInfoParcel versionInfoParcel, zzffo zzffo) {
        this.zza = context;
        this.zzb = versionInfoParcel;
        this.zzc = zzffo;
    }

    public final Object apply(Object obj) {
        zzfet zzfet = (zzfet) obj;
        zzat zzat = new zzat(this.zza);
        zzat.zzp(zzfet.zzB);
        zzat.zzq(zzfet.zzC.toString());
        zzat.zzo(this.zzb.afmaVersion);
        zzat.zzn(this.zzc.zzf);
        return zzat;
    }
}
