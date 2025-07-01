package com.google.android.gms.internal.ads;

import android.os.ParcelFileDescriptor;
import com.google.android.gms.ads.internal.util.zzba;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzeao extends zzbvl {
    final /* synthetic */ zzeap zza;

    protected zzeao(zzeap zzeap) {
        this.zza = zzeap;
    }

    public final void zze(zzba zzba) {
        this.zza.zza.zzd(zzba.zza());
    }

    public final void zzf(ParcelFileDescriptor parcelFileDescriptor) {
        this.zza.zza.zzc(new ParcelFileDescriptor.AutoCloseInputStream(parcelFileDescriptor));
    }
}
