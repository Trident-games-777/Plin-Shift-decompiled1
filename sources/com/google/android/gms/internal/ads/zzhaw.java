package com.google.android.gms.internal.ads;

import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
final class zzhaw extends zzgxi {
    final zzhay zza;
    zzgxk zzb = zzb();
    final /* synthetic */ zzhba zzc;

    zzhaw(zzhba zzhba) {
        this.zzc = zzhba;
        this.zza = new zzhay(zzhba, (zzhaz) null);
    }

    private final zzgxk zzb() {
        zzhay zzhay = this.zza;
        if (zzhay.hasNext()) {
            return zzhay.next().iterator();
        }
        return null;
    }

    public final boolean hasNext() {
        return this.zzb != null;
    }

    public final byte zza() {
        zzgxk zzgxk = this.zzb;
        if (zzgxk != null) {
            byte zza2 = zzgxk.zza();
            if (!this.zzb.hasNext()) {
                this.zzb = zzb();
            }
            return zza2;
        }
        throw new NoSuchElementException();
    }
}
