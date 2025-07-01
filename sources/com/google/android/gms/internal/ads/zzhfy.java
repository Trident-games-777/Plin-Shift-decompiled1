package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzhfy implements zzhfx, zzhfr {
    private static final zzhfy zza = new zzhfy((Object) null);
    private final Object zzb;

    private zzhfy(Object obj) {
        this.zzb = obj;
    }

    public static zzhfx zza(Object obj) {
        zzhgf.zza(obj, "instance cannot be null");
        return new zzhfy(obj);
    }

    public static zzhfx zzc(Object obj) {
        return obj == null ? zza : new zzhfy(obj);
    }

    public final Object zzb() {
        return this.zzb;
    }
}
