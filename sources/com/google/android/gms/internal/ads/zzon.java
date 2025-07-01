package com.google.android.gms.internal.ads;

import java.util.Objects;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzon {
    public static final zzon zza;
    public final int zzb;
    public final int zzc;
    private final zzfzt zzd;

    static {
        zzon zzon;
        if (zzen.zza >= 33) {
            zzfzs zzfzs = new zzfzs();
            for (int i = 1; i <= 10; i++) {
                zzfzs.zzf(Integer.valueOf(zzen.zzi(i)));
            }
            zzon = new zzon(2, (Set) zzfzs.zzi());
        } else {
            zzon = new zzon(2, 10);
        }
        zza = zzon;
    }

    public zzon(int i, int i2) {
        this.zzb = i;
        this.zzc = i2;
        this.zzd = null;
    }

    public zzon(int i, Set set) {
        this.zzb = i;
        zzfzt zzl = zzfzt.zzl(set);
        this.zzd = zzl;
        zzgbu zze = zzl.iterator();
        int i2 = 0;
        while (zze.hasNext()) {
            i2 = Math.max(i2, Integer.bitCount(((Integer) zze.next()).intValue()));
        }
        this.zzc = i2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzon)) {
            return false;
        }
        zzon zzon = (zzon) obj;
        return this.zzb == zzon.zzb && this.zzc == zzon.zzc && Objects.equals(this.zzd, zzon.zzd);
    }

    public final int hashCode() {
        zzfzt zzfzt = this.zzd;
        return (((this.zzb * 31) + this.zzc) * 31) + (zzfzt == null ? 0 : zzfzt.hashCode());
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzd);
        return "AudioProfile[format=" + this.zzb + ", maxChannelCount=" + this.zzc + ", channelMasks=" + valueOf + "]";
    }

    public final int zza(int i, zzg zzg) {
        if (this.zzd != null) {
            return this.zzc;
        }
        if (zzen.zza >= 29) {
            return zzol.zza(this.zzb, i, zzg);
        }
        Integer num = (Integer) zzop.zzb.getOrDefault(Integer.valueOf(this.zzb), 0);
        num.getClass();
        Integer num2 = num;
        return num.intValue();
    }

    public final boolean zzb(int i) {
        if (this.zzd == null) {
            return i <= this.zzc;
        }
        int zzi = zzen.zzi(i);
        if (zzi == 0) {
            return false;
        }
        return this.zzd.contains(Integer.valueOf(zzi));
    }
}
