package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzhy {
    public final String zza;
    public final zzad zzb;
    public final zzad zzc;
    public final int zzd;
    public final int zze;

    public zzhy(String str, zzad zzad, zzad zzad2, int i, int i2) {
        boolean z = true;
        if (i != 0) {
            if (i2 == 0) {
                i2 = 0;
            } else {
                z = false;
            }
        }
        zzdb.zzd(z);
        zzdb.zzc(str);
        this.zza = str;
        zzad zzad3 = zzad;
        this.zzb = zzad;
        zzad2.getClass();
        zzad zzad4 = zzad2;
        this.zzc = zzad2;
        this.zzd = i;
        this.zze = i2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzhy zzhy = (zzhy) obj;
            return this.zzd == zzhy.zzd && this.zze == zzhy.zze && this.zza.equals(zzhy.zza) && this.zzb.equals(zzhy.zzb) && this.zzc.equals(zzhy.zzc);
        }
    }

    public final int hashCode() {
        return ((((((((this.zzd + 527) * 31) + this.zze) * 31) + this.zza.hashCode()) * 31) + this.zzb.hashCode()) * 31) + this.zzc.hashCode();
    }
}
