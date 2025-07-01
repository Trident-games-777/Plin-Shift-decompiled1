package com.google.android.gms.internal.ads;

import java.util.ArrayDeque;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
final class zzhax {
    private final ArrayDeque zza = new ArrayDeque();

    private zzhax() {
    }

    static /* bridge */ /* synthetic */ zzgxp zza(zzhax zzhax, zzgxp zzgxp, zzgxp zzgxp2) {
        zzhax.zzb(zzgxp);
        zzhax.zzb(zzgxp2);
        zzgxp zzgxp3 = (zzgxp) zzhax.zza.pop();
        while (!zzhax.zza.isEmpty()) {
            zzgxp3 = new zzhba((zzgxp) zzhax.zza.pop(), zzgxp3);
        }
        return zzgxp3;
    }

    private final void zzb(zzgxp zzgxp) {
        if (zzgxp.zzh()) {
            int zzc = zzc(zzgxp.zzd());
            ArrayDeque arrayDeque = this.zza;
            int zzc2 = zzhba.zzc(zzc + 1);
            if (arrayDeque.isEmpty() || ((zzgxp) this.zza.peek()).zzd() >= zzc2) {
                this.zza.push(zzgxp);
                return;
            }
            int zzc3 = zzhba.zzc(zzc);
            zzgxp zzgxp2 = (zzgxp) this.zza.pop();
            while (!this.zza.isEmpty() && ((zzgxp) this.zza.peek()).zzd() < zzc3) {
                zzgxp2 = new zzhba((zzgxp) this.zza.pop(), zzgxp2);
            }
            zzhba zzhba = new zzhba(zzgxp2, zzgxp);
            while (!this.zza.isEmpty()) {
                ArrayDeque arrayDeque2 = this.zza;
                if (((zzgxp) arrayDeque2.peek()).zzd() >= zzhba.zzc(zzc(zzhba.zzd()) + 1)) {
                    break;
                }
                zzhba = new zzhba((zzgxp) this.zza.pop(), zzhba);
            }
            this.zza.push(zzhba);
        } else if (zzgxp instanceof zzhba) {
            zzhba zzhba2 = (zzhba) zzgxp;
            zzb(zzhba2.zzd);
            zzb(zzhba2.zze);
        } else {
            throw new IllegalArgumentException("Has a new type of ByteString been created? Found ".concat(String.valueOf(String.valueOf(zzgxp.getClass()))));
        }
    }

    private static final int zzc(int i) {
        int binarySearch = Arrays.binarySearch(zzhba.zza, i);
        return binarySearch < 0 ? (-(binarySearch + 1)) - 1 : binarySearch;
    }

    /* synthetic */ zzhax(zzhaz zzhaz) {
    }
}
