package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzv;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzdun implements zzgee {
    final /* synthetic */ zzdup zza;

    zzdun(zzdup zzdup) {
        this.zza = zzdup;
    }

    public final void zza(Throwable th) {
        synchronized (this) {
            this.zza.zzc = true;
            this.zza.zzv("com.google.android.gms.ads.MobileAds", false, "Internal Error.", (int) (zzv.zzC().elapsedRealtime() - this.zza.zzd));
            this.zza.zze.zzd(new Exception());
        }
    }

    public final /* bridge */ /* synthetic */ void zzb(@Nullable Object obj) {
        String str = (String) obj;
        synchronized (this) {
            this.zza.zzc = true;
            this.zza.zzv("com.google.android.gms.ads.MobileAds", true, "", (int) (zzv.zzC().elapsedRealtime() - this.zza.zzd));
            this.zza.zzi.execute(new zzdum(this, str));
        }
    }
}
