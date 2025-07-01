package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public abstract class zzhfp {
    public static zzhfp zzb(Class cls) {
        if (System.getProperty("java.vm.name").equalsIgnoreCase("Dalvik")) {
            return new zzhfk(cls.getSimpleName());
        }
        return new zzhfm(cls.getSimpleName());
    }

    public abstract void zza(String str);
}
