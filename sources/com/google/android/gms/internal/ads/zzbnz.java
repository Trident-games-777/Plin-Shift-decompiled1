package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzbnz {
    private final Object zza = new Object();
    private final Object zzb = new Object();
    private zzboi zzc;
    private zzboi zzd;

    private static final Context zzc(Context context) {
        Context applicationContext = context.getApplicationContext();
        return applicationContext == null ? context : applicationContext;
    }

    public final zzboi zza(Context context, VersionInfoParcel versionInfoParcel, zzfko zzfko) {
        zzboi zzboi;
        synchronized (this.zza) {
            if (this.zzc == null) {
                this.zzc = new zzboi(zzc(context), versionInfoParcel, (String) zzbe.zzc().zza(zzbcn.zza), zzfko);
            }
            zzboi = this.zzc;
        }
        return zzboi;
    }

    public final zzboi zzb(Context context, VersionInfoParcel versionInfoParcel, zzfko zzfko) {
        zzboi zzboi;
        synchronized (this.zzb) {
            if (this.zzd == null) {
                this.zzd = new zzboi(zzc(context), versionInfoParcel, (String) zzbex.zza.zze(), zzfko);
            }
            zzboi = this.zzd;
        }
        return zzboi;
    }
}
