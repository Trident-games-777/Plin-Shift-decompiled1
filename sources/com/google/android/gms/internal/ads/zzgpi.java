package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzgpi extends RuntimeException {
    public zzgpi(String str) {
        super(str);
    }

    public static Object zza(zzgph zzgph) {
        try {
            return zzgph.zza();
        } catch (Exception e) {
            throw new zzgpi((Throwable) e);
        }
    }

    public zzgpi(String str, Throwable th) {
        super(str, th);
    }

    public zzgpi(Throwable th) {
        super(th);
    }
}
