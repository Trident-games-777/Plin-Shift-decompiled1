package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public class zzbh extends IOException {
    public final boolean zza;
    public final int zzb;

    protected zzbh(String str, Throwable th, boolean z, int i) {
        super(str, th);
        this.zza = z;
        this.zzb = i;
    }

    public static zzbh zza(String str, Throwable th) {
        return new zzbh(str, th, true, 1);
    }

    public static zzbh zzb(String str, Throwable th) {
        return new zzbh(str, th, true, 0);
    }

    public static zzbh zzc(String str) {
        return new zzbh(str, (Throwable) null, false, 1);
    }

    public final String getMessage() {
        String message = super.getMessage();
        return message + " {contentIsMalformed=" + this.zza + ", dataType=" + this.zzb + "}";
    }
}
