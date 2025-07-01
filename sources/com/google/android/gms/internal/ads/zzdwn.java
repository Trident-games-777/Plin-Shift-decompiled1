package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public class zzdwn extends Exception {
    private final int zza;

    public zzdwn(int i) {
        this.zza = i;
    }

    public final int zza() {
        return this.zza;
    }

    public zzdwn(int i, String str) {
        super(str);
        this.zza = i;
    }

    public zzdwn(int i, String str, Throwable th) {
        super(str, th);
        this.zza = 1;
    }
}
