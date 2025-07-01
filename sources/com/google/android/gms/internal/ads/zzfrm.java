package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzfrm extends Exception {
    private final int zza;

    public zzfrm(int i, String str) {
        super(str);
        this.zza = i;
    }

    public final int zza() {
        return this.zza;
    }

    public zzfrm(int i, Throwable th) {
        super(th);
        this.zza = i;
    }
}
