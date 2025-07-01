package com.google.android.gms.internal.ads;

import android.os.ParcelFileDescriptor;
import com.google.android.gms.ads.internal.util.zzba;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzdyg extends zzbvo {
    private final zzcao zza;
    private final zzbvx zzb;

    zzdyg(zzcao zzcao, zzbvx zzbvx) {
        this.zza = zzcao;
        this.zzb = zzbvx;
    }

    public final void zze(zzba zzba) {
        this.zza.zzd(zzba.zza());
    }

    public final void zzf(ParcelFileDescriptor parcelFileDescriptor) {
        this.zza.zzc(new zzdyx(new ParcelFileDescriptor.AutoCloseInputStream(parcelFileDescriptor), this.zzb));
    }

    public final void zzg(ParcelFileDescriptor parcelFileDescriptor, zzbvx zzbvx) {
        this.zza.zzc(new zzdyx(new ParcelFileDescriptor.AutoCloseInputStream(parcelFileDescriptor), zzbvx));
    }
}
