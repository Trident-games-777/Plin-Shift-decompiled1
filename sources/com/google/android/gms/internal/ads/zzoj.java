package com.google.android.gms.internal.ads;

import android.media.metrics.LogSessionId;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzoj {
    public final String zza;
    private final zzoi zzb;
    private final Object zzc;

    static {
        if (zzen.zza < 31) {
            new zzoj("");
        } else {
            int i = zzoi.zzb;
        }
    }

    public zzoj(LogSessionId logSessionId, String str) {
        this.zzb = new zzoi(logSessionId);
        this.zza = str;
        this.zzc = new Object();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzoj)) {
            return false;
        }
        zzoj zzoj = (zzoj) obj;
        return Objects.equals(this.zza, zzoj.zza) && Objects.equals(this.zzb, zzoj.zzb) && Objects.equals(this.zzc, zzoj.zzc);
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{this.zza, this.zzb, this.zzc});
    }

    public zzoj(String str) {
        zzdb.zzf(zzen.zza < 31);
        this.zza = str;
        this.zzb = null;
        this.zzc = new Object();
    }

    public final LogSessionId zza() {
        zzoi zzoi = this.zzb;
        zzoi.getClass();
        zzoi zzoi2 = zzoi;
        return zzoi.zza;
    }
}
