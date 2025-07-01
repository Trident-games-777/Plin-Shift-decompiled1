package com.google.android.gms.internal.ads;

import android.os.ParcelFileDescriptor;
import com.google.android.gms.ads.internal.util.zzba;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzdyf extends zzbvo {
    final /* synthetic */ zzdyh zza;

    protected zzdyf(zzdyh zzdyh) {
        this.zza = zzdyh;
    }

    public final void zze(zzba zzba) {
        this.zza.zza.zzd(zzba.zza());
    }

    public final void zzf(ParcelFileDescriptor parcelFileDescriptor) {
        ParcelFileDescriptor.AutoCloseInputStream autoCloseInputStream = new ParcelFileDescriptor.AutoCloseInputStream(parcelFileDescriptor);
        zzdyh zzdyh = this.zza;
        zzdyh.zza.zzc(new zzdyx(autoCloseInputStream, zzdyh.zze));
    }

    public final void zzg(ParcelFileDescriptor parcelFileDescriptor, zzbvx zzbvx) {
        this.zza.zza.zzc(new zzdyx(new ParcelFileDescriptor.AutoCloseInputStream(parcelFileDescriptor), zzbvx));
    }
}
