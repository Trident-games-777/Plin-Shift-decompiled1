package com.google.android.gms.internal.ads;

import android.util.Pair;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzlb implements zzvb, zzrl {
    final /* synthetic */ zzlf zza;
    private final zzld zzb;

    public zzlb(zzlf zzlf, zzld zzld) {
        this.zza = zzlf;
        this.zzb = zzld;
    }

    private final Pair zzf(int i, zzur zzur) {
        zzur zzur2;
        zzur zzur3 = null;
        if (zzur != null) {
            zzld zzld = this.zzb;
            int i2 = 0;
            while (true) {
                if (i2 >= zzld.zzc.size()) {
                    zzur2 = null;
                    break;
                } else if (((zzur) zzld.zzc.get(i2)).zzd == zzur.zzd) {
                    zzur2 = zzur.zza(Pair.create(zzld.zzb, zzur.zza));
                    break;
                } else {
                    i2++;
                }
            }
            if (zzur2 == null) {
                return null;
            }
            zzur3 = zzur2;
        }
        return Pair.create(Integer.valueOf(this.zzb.zzd), zzur3);
    }

    public final void zzaf(int i, zzur zzur, zzun zzun) {
        Pair zzf = zzf(0, zzur);
        if (zzf != null) {
            this.zza.zzi.zzh(new zzkz(this, zzf, zzun));
        }
    }

    public final void zzag(int i, zzur zzur, zzui zzui, zzun zzun) {
        Pair zzf = zzf(0, zzur);
        if (zzf != null) {
            this.zza.zzi.zzh(new zzkx(this, zzf, zzui, zzun));
        }
    }

    public final void zzah(int i, zzur zzur, zzui zzui, zzun zzun) {
        Pair zzf = zzf(0, zzur);
        if (zzf != null) {
            this.zza.zzi.zzh(new zzla(this, zzf, zzui, zzun));
        }
    }

    public final void zzai(int i, zzur zzur, zzui zzui, zzun zzun, IOException iOException, boolean z) {
        Pair zzf = zzf(0, zzur);
        if (zzf != null) {
            this.zza.zzi.zzh(new zzkw(this, zzf, zzui, zzun, iOException, z));
        }
    }

    public final void zzaj(int i, zzur zzur, zzui zzui, zzun zzun) {
        Pair zzf = zzf(0, zzur);
        if (zzf != null) {
            this.zza.zzi.zzh(new zzky(this, zzf, zzui, zzun));
        }
    }
}
