package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzdr {
    public final Object zza;
    private zzx zzb = new zzx();
    private boolean zzc;
    private boolean zzd;

    public zzdr(Object obj) {
        this.zza = obj;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.zza.equals(((zzdr) obj).zza);
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final void zza(int i, zzdp zzdp) {
        if (!this.zzd) {
            if (i != -1) {
                this.zzb.zza(i);
            }
            this.zzc = true;
            zzdp.zza(this.zza);
        }
    }

    public final void zzb(zzdq zzdq) {
        if (!this.zzd && this.zzc) {
            zzz zzb2 = this.zzb.zzb();
            this.zzb = new zzx();
            this.zzc = false;
            zzdq.zza(this.zza, zzb2);
        }
    }

    public final void zzc(zzdq zzdq) {
        this.zzd = true;
        if (this.zzc) {
            this.zzc = false;
            zzdq.zza(this.zza, this.zzb.zzb());
        }
    }
}
