package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzbk {
    private final zzx zza = new zzx();

    public final zzbk zza(int i) {
        this.zza.zza(i);
        return this;
    }

    public final zzbk zzb(zzbl zzbl) {
        zzz zza2 = zzbl.zza;
        for (int i = 0; i < zza2.zzb(); i++) {
            this.zza.zza(zza2.zza(i));
        }
        return this;
    }

    public final zzbk zzc(int... iArr) {
        for (int i = 0; i < 20; i++) {
            this.zza.zza(iArr[i]);
        }
        return this;
    }

    public final zzbk zzd(int i, boolean z) {
        if (z) {
            this.zza.zza(i);
        }
        return this;
    }

    public final zzbl zze() {
        return new zzbl(this.zza.zzb(), (zzbo) null);
    }
}
