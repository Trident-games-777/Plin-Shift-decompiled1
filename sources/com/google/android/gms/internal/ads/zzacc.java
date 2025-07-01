package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public class zzacc {
    protected final zzabw zza;
    protected final zzacb zzb;
    protected zzaby zzc;
    private final int zzd;

    protected zzacc(zzabz zzabz, zzacb zzacb, long j, long j2, long j3, long j4, long j5, long j6, int i) {
        this.zzb = zzacb;
        this.zzd = i;
        this.zza = new zzabw(zzabz, j, 0, j3, j4, j5, j6);
    }

    protected static final int zzf(zzacs zzacs, long j, zzadn zzadn) {
        if (j == zzacs.zzf()) {
            return 0;
        }
        zzadn.zza = j;
        return 1;
    }

    protected static final boolean zzg(zzacs zzacs, long j) throws IOException {
        long zzf = j - zzacs.zzf();
        if (zzf < 0 || zzf > 262144) {
            return false;
        }
        zzacs.zzk((int) zzf);
        return true;
    }

    public final int zza(zzacs zzacs, zzadn zzadn) throws IOException {
        while (true) {
            zzaby zzaby = this.zzc;
            zzdb.zzb(zzaby);
            zzaby zzaby2 = zzaby;
            long zzb2 = zzaby.zzf;
            long zza2 = zzaby.zzg;
            long zzc2 = zzaby.zzh;
            if (zza2 - zzb2 <= ((long) this.zzd)) {
                zzc(false, zzb2);
                return zzf(zzacs, zzb2, zzadn);
            } else if (!zzg(zzacs, zzc2)) {
                return zzf(zzacs, zzc2, zzadn);
            } else {
                zzacs.zzj();
                zzaca zza3 = this.zzb.zza(zzacs, zzaby.zzb);
                int zza4 = zza3.zzb;
                if (zza4 == -3) {
                    zzc(false, zzc2);
                    return zzf(zzacs, zzc2, zzadn);
                } else if (zza4 == -2) {
                    zzaby.zzh(zzaby, zza3.zzc, zza3.zzd);
                } else if (zza4 != -1) {
                    zzg(zzacs, zza3.zzd);
                    zzc(true, zza3.zzd);
                    return zzf(zzacs, zza3.zzd, zzadn);
                } else {
                    zzaby.zzg(zzaby, zza3.zzc, zza3.zzd);
                }
            }
        }
    }

    public final zzadq zzb() {
        return this.zza;
    }

    /* access modifiers changed from: protected */
    public final void zzc(boolean z, long j) {
        this.zzc = null;
        this.zzb.zzb();
    }

    public final void zzd(long j) {
        long j2 = j;
        zzaby zzaby = this.zzc;
        if (zzaby == null || zzaby.zza != j2) {
            zzabw zzabw = this.zza;
            this.zzc = new zzaby(j2, zzabw.zzf(j2), 0, zzabw.zzc, zzabw.zzd, zzabw.zze, zzabw.zzf);
        }
    }

    public final boolean zze() {
        return this.zzc != null;
    }
}
