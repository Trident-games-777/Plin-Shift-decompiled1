package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.List;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzajo implements zzacr {
    private zzacu zza;
    private zzajw zzb;
    private boolean zzc;

    @EnsuresNonNullIf(expression = {"streamReader"}, result = true)
    private final boolean zza(zzacs zzacs) throws IOException {
        zzajq zzajq = new zzajq();
        if (zzajq.zzb(zzacs, true) && (zzajq.zza & 2) == 2) {
            int min = Math.min(zzajq.zze, 8);
            zzed zzed = new zzed(min);
            zzacs.zzh(zzed.zzN(), 0, min);
            zzed.zzL(0);
            if (zzed.zzb() >= 5 && zzed.zzm() == 127 && zzed.zzu() == 1179402563) {
                this.zzb = new zzajn();
            } else {
                zzed.zzL(0);
                try {
                    if (zzaed.zzd(1, zzed, true)) {
                        this.zzb = new zzajy();
                    }
                } catch (zzbh unused) {
                }
                zzed.zzL(0);
                if (zzajs.zzd(zzed)) {
                    this.zzb = new zzajs();
                }
            }
            return true;
        }
        return false;
    }

    public final int zzb(zzacs zzacs, zzadn zzadn) throws IOException {
        zzdb.zzb(this.zza);
        if (this.zzb == null) {
            if (zza(zzacs)) {
                zzacs.zzj();
            } else {
                throw zzbh.zza("Failed to determine bitstream type", (Throwable) null);
            }
        }
        if (!this.zzc) {
            zzadx zzw = this.zza.zzw(0, 1);
            this.zza.zzD();
            this.zzb.zzh(this.zza, zzw);
            this.zzc = true;
        }
        return this.zzb.zze(zzacs, zzadn);
    }

    public final /* synthetic */ zzacr zzc() {
        return this;
    }

    public final /* synthetic */ List zzd() {
        return zzfzo.zzn();
    }

    public final void zze(zzacu zzacu) {
        this.zza = zzacu;
    }

    public final void zzf(long j, long j2) {
        zzajw zzajw = this.zzb;
        if (zzajw != null) {
            zzajw.zzj(j, j2);
        }
    }

    public final boolean zzi(zzacs zzacs) throws IOException {
        try {
            return zza(zzacs);
        } catch (zzbh unused) {
            return false;
        }
    }
}
