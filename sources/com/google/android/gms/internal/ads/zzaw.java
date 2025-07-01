package com.google.android.gms.internal.ads;

import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzaw {
    public final String zza;
    public final zzar zzb;
    public final zzaq zzc;
    public final zzba zzd;
    public final zzam zze;
    public final zzat zzf;

    static {
        new zzak().zzc();
        Integer.toString(0, 36);
        Integer.toString(1, 36);
        Integer.toString(2, 36);
        Integer.toString(3, 36);
        Integer.toString(4, 36);
        Integer.toString(5, 36);
    }

    /* synthetic */ zzaw(String str, zzan zzan, zzar zzar, zzaq zzaq, zzba zzba, zzat zzat, zzav zzav) {
        this.zza = str;
        this.zzb = zzar;
        this.zzc = zzaq;
        this.zzd = zzba;
        this.zze = zzan;
        this.zzf = zzat;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzaw)) {
            return false;
        }
        zzaw zzaw = (zzaw) obj;
        return Objects.equals(this.zza, zzaw.zza) && this.zze.equals(zzaw.zze) && Objects.equals(this.zzb, zzaw.zzb) && Objects.equals(this.zzc, zzaw.zzc) && Objects.equals(this.zzd, zzaw.zzd) && Objects.equals(this.zzf, zzaw.zzf);
    }

    public final int hashCode() {
        int hashCode = this.zza.hashCode() * 31;
        zzar zzar = this.zzb;
        return (((((((hashCode + (zzar != null ? zzar.hashCode() : 0)) * 31) + this.zzc.hashCode()) * 31) + this.zze.hashCode()) * 31) + this.zzd.hashCode()) * 31;
    }
}
