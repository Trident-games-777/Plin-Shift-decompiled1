package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzn;
import com.google.android.gms.ads.internal.zzv;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzcfv implements zzgdo {
    public final /* synthetic */ Context zza;
    public final /* synthetic */ zzavc zzb;
    public final /* synthetic */ VersionInfoParcel zzc;
    public final /* synthetic */ zza zzd;
    public final /* synthetic */ zzeea zze;
    public final /* synthetic */ zzffs zzf;
    public final /* synthetic */ String zzg;

    public /* synthetic */ zzcfv(Context context, zzavc zzavc, VersionInfoParcel versionInfoParcel, zza zza2, zzeea zzeea, zzffs zzffs, String str) {
        this.zza = context;
        this.zzb = zzavc;
        this.zzc = versionInfoParcel;
        this.zzd = zza2;
        this.zze = zzeea;
        this.zzf = zzffs;
        this.zzg = str;
    }

    public final ListenableFuture zza() {
        zzv.zzA();
        Context context = this.zza;
        zzche zza2 = zzche.zza();
        zzavc zzavc = this.zzb;
        zzeea zzeea = this.zze;
        zza zza3 = this.zzd;
        zzcfk zza4 = zzcfx.zza(context, zza2, "", false, false, zzavc, (zzbdu) null, this.zzc, (zzbdc) null, (zzn) null, zza3, zzbbl.zza(), (zzfet) null, (zzfew) null, zzeea, this.zzf);
        zzcan zza5 = zzcan.zza(zza4);
        zza4.zzN().zzB(new zzcfu(zza5));
        zza4.loadUrl(this.zzg);
        return zza5;
    }
}
