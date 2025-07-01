package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzwr {
    public static final zzwr zza = new zzwr(new zzbw[0]);
    public final int zzb;
    private final zzfzo zzc;
    private int zzd;

    static {
        Integer.toString(0, 36);
    }

    public zzwr(zzbw... zzbwArr) {
        this.zzc = zzfzo.zzm(zzbwArr);
        this.zzb = zzbwArr.length;
        int i = 0;
        while (i < this.zzc.size()) {
            int i2 = i + 1;
            for (int i3 = i2; i3 < this.zzc.size(); i3++) {
                if (((zzbw) this.zzc.get(i)).equals(this.zzc.get(i3))) {
                    zzdt.zzd("TrackGroupArray", "", new IllegalArgumentException("Multiple identical TrackGroups added to one TrackGroupArray."));
                }
            }
            i = i2;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzwr zzwr = (zzwr) obj;
            return this.zzb == zzwr.zzb && this.zzc.equals(zzwr.zzc);
        }
    }

    public final int hashCode() {
        int i = this.zzd;
        if (i != 0) {
            return i;
        }
        int hashCode = this.zzc.hashCode();
        this.zzd = hashCode;
        return hashCode;
    }

    public final int zza(zzbw zzbw) {
        int indexOf = this.zzc.indexOf(zzbw);
        if (indexOf >= 0) {
            return indexOf;
        }
        return -1;
    }

    public final zzbw zzb(int i) {
        return (zzbw) this.zzc.get(i);
    }

    public final zzfzo zzc() {
        return zzfzo.zzl(zzgae.zzb(this.zzc, new zzwq()));
    }
}
