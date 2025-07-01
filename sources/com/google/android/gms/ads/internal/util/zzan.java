package com.google.android.gms.ads.internal.util;

import android.content.DialogInterface;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzan implements DialogInterface.OnClickListener {
    public final /* synthetic */ zzat zza;
    public final /* synthetic */ int zzb;
    public final /* synthetic */ int zzc;
    public final /* synthetic */ int zzd;
    public final /* synthetic */ int zze;
    public final /* synthetic */ int zzf;

    public /* synthetic */ zzan(zzat zzat, int i, int i2, int i3, int i4, int i5) {
        this.zza = zzat;
        this.zzb = i;
        this.zzc = i2;
        this.zzd = i3;
        this.zze = i4;
        this.zzf = i5;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.zza.zzj(this.zzb, this.zzc, this.zzd, this.zze, this.zzf, dialogInterface, i);
    }
}
