package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzado {
    public final zzadr zza;
    public final zzadr zzb;

    public zzado(zzadr zzadr, zzadr zzadr2) {
        zzadr zzadr3 = zzadr;
        this.zza = zzadr;
        zzadr zzadr4 = zzadr2;
        this.zzb = zzadr2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzado zzado = (zzado) obj;
            return this.zza.equals(zzado.zza) && this.zzb.equals(zzado.zzb);
        }
    }

    public final int hashCode() {
        return (this.zza.hashCode() * 31) + this.zzb.hashCode();
    }

    public final String toString() {
        zzadr zzadr = this.zza;
        zzadr zzadr2 = this.zzb;
        String obj = zzadr.toString();
        String concat = zzadr.equals(zzadr2) ? "" : ", ".concat(this.zzb.toString());
        return "[" + obj + concat + "]";
    }
}
