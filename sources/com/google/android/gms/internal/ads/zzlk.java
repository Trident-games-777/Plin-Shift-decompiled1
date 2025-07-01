package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzlk extends zzuf {
    private final zzbu zzc = new zzbu();

    zzlk(zzll zzll, zzbv zzbv) {
        super(zzbv);
    }

    public final zzbt zzd(int i, zzbt zzbt, boolean z) {
        zzbt zzd = this.zzb.zzd(i, zzbt, z);
        if (this.zzb.zze(zzd.zzc, this.zzc, 0).zzb()) {
            Object obj = zzbt.zza;
            Object obj2 = zzbt.zzb;
            int i2 = zzbt.zzc;
            long j = zzbt.zzd;
            long j2 = zzbt.zze;
            zzd.zzi(obj, obj2, i2, j, 0, zzb.zza, true);
            return zzd;
        }
        zzd.zzf = true;
        return zzd;
    }
}
