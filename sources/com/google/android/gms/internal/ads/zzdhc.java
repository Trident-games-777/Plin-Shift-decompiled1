package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzdhc implements zzcrt {
    private final Map zza;
    private final Map zzb;
    private final Map zzc;
    private final zzhgp zzd;
    private final zzdjj zze;

    zzdhc(Map map, Map map2, Map map3, zzhgp zzhgp, zzdjj zzdjj) {
        this.zza = map;
        this.zzb = map2;
        this.zzc = map3;
        this.zzd = zzhgp;
        this.zze = zzdjj;
    }

    public final zzefb zza(int i, String str) {
        zzefb zzefb;
        zzefb zzefb2 = (zzefb) this.zza.get(str);
        if (zzefb2 != null) {
            return zzefb2;
        }
        if (i != 1) {
            if (i != 4) {
                return null;
            }
            zzehp zzehp = (zzehp) this.zzc.get(str);
            if (zzehp != null) {
                return new zzefc(zzehp, new zzcrv());
            }
            zzefb = (zzefb) this.zzb.get(str);
            if (zzefb == null) {
                return null;
            }
        } else if (this.zze.zze() == null || (zzefb = ((zzcrt) this.zzd.zzb()).zza(i, str)) == null) {
            return null;
        }
        return new zzefc(zzefb, new zzcrw());
    }
}
