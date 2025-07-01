package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zztu implements zzwg {
    public final zzwg zza;
    final /* synthetic */ zztv zzb;
    private boolean zzc;

    public zztu(zztv zztv, zzwg zzwg) {
        this.zzb = zztv;
        this.zza = zzwg;
    }

    public final int zza(zzkj zzkj, zzhm zzhm, int i) {
        zztv zztv = this.zzb;
        if (zztv.zzq()) {
            return -3;
        }
        if (this.zzc) {
            zzhm.zzc(4);
            return -4;
        }
        long zzb2 = zztv.zzb();
        int zza2 = this.zza.zza(zzkj, zzhm, i);
        if (zza2 == -5) {
            zzad zzad = zzkj.zza;
            zzad.getClass();
            zzad zzad2 = zzad;
            int i2 = zzad.zzF;
            int i3 = 0;
            if (i2 == 0) {
                if (zzad.zzG != 0) {
                    i2 = 0;
                }
                return -5;
            }
            if (this.zzb.zzb == Long.MIN_VALUE) {
                i3 = zzad.zzG;
            }
            zzab zzb3 = zzad.zzb();
            zzb3.zzG(i2);
            zzb3.zzH(i3);
            zzkj.zza = zzb3.zzaf();
            return -5;
        }
        long j = this.zzb.zzb;
        if (j == Long.MIN_VALUE || ((zza2 != -4 || zzhm.zze < j) && (zza2 != -3 || zzb2 != Long.MIN_VALUE || zzhm.zzd))) {
            return zza2;
        }
        zzhm.zzb();
        zzhm.zzc(4);
        this.zzc = true;
        return -4;
    }

    public final int zzb(long j) {
        if (this.zzb.zzq()) {
            return -3;
        }
        return this.zza.zzb(j);
    }

    public final void zzc() {
        this.zzc = false;
    }

    public final void zzd() throws IOException {
        this.zza.zzd();
    }

    public final boolean zze() {
        return !this.zzb.zzq() && this.zza.zze();
    }
}
