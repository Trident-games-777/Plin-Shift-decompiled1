package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzaij implements zzaig {
    private final int zza;
    private final int zzb;
    private final zzed zzc;

    public zzaij(zzet zzet, zzad zzad) {
        zzed zzed = zzet.zza;
        this.zzc = zzed;
        zzed.zzL(12);
        int zzp = zzed.zzp();
        if ("audio/raw".equals(zzad.zzo)) {
            int zzk = zzen.zzk(zzad.zzE) * zzad.zzC;
            if (zzp == 0 || zzp % zzk != 0) {
                zzdt.zzf("BoxParsers", "Audio sample size mismatch. stsd sample size: " + zzk + ", stsz sample size: " + zzp);
                zzp = zzk;
            }
        }
        this.zza = zzp == 0 ? -1 : zzp;
        this.zzb = zzed.zzp();
    }

    public final int zza() {
        return this.zza;
    }

    public final int zzb() {
        return this.zzb;
    }

    public final int zzc() {
        int i = this.zza;
        return i == -1 ? this.zzc.zzp() : i;
    }
}
