package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzpt extends Exception {
    public final int zza;
    public final boolean zzb;
    public final zzad zzc;

    public zzpt(int i, zzad zzad, boolean z) {
        super("AudioTrack write failed: " + i);
        this.zzb = z;
        this.zza = i;
        this.zzc = zzad;
    }
}
