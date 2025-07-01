package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zztx implements zzvb, zzrl {
    final /* synthetic */ zztz zza;
    private final Object zzb;
    private zzva zzc;
    private zzrk zzd;

    public zztx(zztz zztz, Object obj) {
        this.zza = zztz;
        this.zzc = zztz.zze((zzur) null);
        this.zzd = zztz.zzc((zzur) null);
        this.zzb = obj;
    }

    private final zzun zzf(zzun zzun, zzur zzur) {
        zztz zztz = this.zza;
        Object obj = this.zzb;
        long j = zzun.zzc;
        zztz.zzx(obj, j, zzur);
        zztz zztz2 = this.zza;
        Object obj2 = this.zzb;
        long j2 = zzun.zzd;
        zztz2.zzx(obj2, j2, zzur);
        return (j == zzun.zzc && j2 == zzun.zzd) ? zzun : new zzun(1, zzun.zza, zzun.zzb, 0, (Object) null, j, j2);
    }

    private final boolean zzg(int i, zzur zzur) {
        zzur zzur2;
        if (zzur != null) {
            zzur2 = this.zza.zzy(this.zzb, zzur);
            if (zzur2 == null) {
                return false;
            }
        } else {
            zzur2 = null;
        }
        this.zza.zzw(this.zzb, 0);
        zzva zzva = this.zzc;
        int i2 = zzva.zza;
        if (!Objects.equals(zzva.zzb, zzur2)) {
            this.zzc = this.zza.zzf(0, zzur2);
        }
        zzrk zzrk = this.zzd;
        int i3 = zzrk.zza;
        if (Objects.equals(zzrk.zzb, zzur2)) {
            return true;
        }
        this.zzd = this.zza.zzd(0, zzur2);
        return true;
    }

    public final void zzaf(int i, zzur zzur, zzun zzun) {
        if (zzg(0, zzur)) {
            this.zzc.zzc(zzf(zzun, zzur));
        }
    }

    public final void zzag(int i, zzur zzur, zzui zzui, zzun zzun) {
        if (zzg(0, zzur)) {
            this.zzc.zzd(zzui, zzf(zzun, zzur));
        }
    }

    public final void zzah(int i, zzur zzur, zzui zzui, zzun zzun) {
        if (zzg(0, zzur)) {
            this.zzc.zze(zzui, zzf(zzun, zzur));
        }
    }

    public final void zzai(int i, zzur zzur, zzui zzui, zzun zzun, IOException iOException, boolean z) {
        if (zzg(0, zzur)) {
            this.zzc.zzf(zzui, zzf(zzun, zzur), iOException, z);
        }
    }

    public final void zzaj(int i, zzur zzur, zzui zzui, zzun zzun) {
        if (zzg(0, zzur)) {
            this.zzc.zzg(zzui, zzf(zzun, zzur));
        }
    }
}
