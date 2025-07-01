package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzfud extends zzfvg {
    private int zza;
    private String zzb;
    private byte zzc;

    zzfud() {
    }

    public final zzfvg zza(String str) {
        this.zzb = str;
        return this;
    }

    public final zzfvg zzb(int i) {
        this.zza = i;
        this.zzc = 1;
        return this;
    }

    public final zzfvh zzc() {
        if (this.zzc == 1) {
            return new zzfuf(this.zza, this.zzb, (zzfue) null);
        }
        throw new IllegalStateException("Missing required properties: statusCode");
    }
}
