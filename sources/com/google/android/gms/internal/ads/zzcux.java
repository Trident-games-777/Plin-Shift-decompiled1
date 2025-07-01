package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.zzg;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.ads.nonagon.signalgeneration.zzbd;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzcux implements zzczj, zzdex {
    private final Context zza;
    private final zzffo zzb;
    private final VersionInfoParcel zzc;
    private final zzg zzd;
    private final zzdup zze;
    private final zzfko zzf;

    public zzcux(Context context, zzffo zzffo, VersionInfoParcel versionInfoParcel, zzg zzg, zzdup zzdup, zzfko zzfko) {
        this.zza = context;
        this.zzb = zzffo;
        this.zzc = versionInfoParcel;
        this.zzd = zzg;
        this.zze = zzdup;
        this.zzf = zzfko;
    }

    private final void zzc() {
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzea)).booleanValue()) {
            zzg zzg = this.zzd;
            Context context = this.zza;
            VersionInfoParcel versionInfoParcel = this.zzc;
            zzffo zzffo = this.zzb;
            zzfko zzfko = this.zzf;
            zzv.zza().zzc(context, versionInfoParcel, zzffo.zzf, zzg.zzg(), zzfko);
        }
        this.zze.zzr();
    }

    public final void zzdn(zzbvx zzbvx) {
        zzc();
    }

    public final void zzdo(zzfff zzfff) {
    }

    public final void zze(zzbd zzbd) {
        if (((Boolean) zzbe.zzc().zza(zzbcn.zzeb)).booleanValue()) {
            zzc();
        }
    }

    public final void zzf(String str) {
    }
}
