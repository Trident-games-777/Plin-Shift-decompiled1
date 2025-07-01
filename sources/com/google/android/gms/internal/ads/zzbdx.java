package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
public class zzbdx {
    private final String zza;
    private final Object zzb;
    private final int zzc;

    protected zzbdx(String str, Object obj, int i) {
        this.zza = str;
        this.zzb = obj;
        this.zzc = i;
    }

    public static zzbdx zza(String str, double d) {
        return new zzbdx(str, Double.valueOf(d), 3);
    }

    public static zzbdx zzb(String str, long j) {
        return new zzbdx(str, Long.valueOf(j), 2);
    }

    public static zzbdx zzc(String str, String str2) {
        return new zzbdx("gad:dynamite_module:experiment_id", "", 4);
    }

    public static zzbdx zzd(String str, boolean z) {
        return new zzbdx(str, Boolean.valueOf(z), 1);
    }

    public final Object zze() {
        zzbfc zza2 = zzbfe.zza();
        if (zza2 == null) {
            if (zzbfe.zzb() != null) {
                zzbfe.zzb().zza();
            }
            return this.zzb;
        }
        int i = this.zzc - 1;
        if (i == 0) {
            return zza2.zza(this.zza, ((Boolean) this.zzb).booleanValue());
        }
        if (i == 1) {
            return zza2.zzc(this.zza, ((Long) this.zzb).longValue());
        }
        if (i != 2) {
            return zza2.zzd(this.zza, (String) this.zzb);
        }
        return zza2.zzb(this.zza, ((Double) this.zzb).doubleValue());
    }
}
