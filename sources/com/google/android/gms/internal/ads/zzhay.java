package com.google.android.gms.internal.ads;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
final class zzhay implements Iterator {
    private final ArrayDeque zza;
    private zzgxl zzb;

    /* synthetic */ zzhay(zzgxp zzgxp, zzhaz zzhaz) {
        if (zzgxp instanceof zzhba) {
            zzhba zzhba = (zzhba) zzgxp;
            ArrayDeque arrayDeque = new ArrayDeque(zzhba.zzf());
            this.zza = arrayDeque;
            arrayDeque.push(zzhba);
            this.zzb = zzb(zzhba.zzd);
            return;
        }
        this.zza = null;
        this.zzb = (zzgxl) zzgxp;
    }

    private final zzgxl zzb(zzgxp zzgxp) {
        while (zzgxp instanceof zzhba) {
            zzhba zzhba = (zzhba) zzgxp;
            this.zza.push(zzhba);
            zzgxp = zzhba.zzd;
        }
        return (zzgxl) zzgxp;
    }

    public final boolean hasNext() {
        return this.zzb != null;
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    /* renamed from: zza */
    public final zzgxl next() {
        zzgxl zzgxl;
        zzgxl zzgxl2 = this.zzb;
        if (zzgxl2 != null) {
            do {
                ArrayDeque arrayDeque = this.zza;
                zzgxl = null;
                if (arrayDeque == null || arrayDeque.isEmpty()) {
                    this.zzb = zzgxl;
                } else {
                    zzgxl = zzb(((zzhba) this.zza.pop()).zze);
                }
            } while (zzgxl.zzd() == 0);
            this.zzb = zzgxl;
            return zzgxl2;
        }
        throw new NoSuchElementException();
    }
}
