package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzfsa extends zzfsh {
    private final String zzb;
    private final boolean zzc;
    private final int zzd;

    /* synthetic */ zzfsa(String str, boolean z, boolean z2, zzfrw zzfrw, zzfrx zzfrx, int i, zzfrz zzfrz) {
        this.zzb = str;
        this.zzc = z2;
        this.zzd = i;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzfsh) {
            zzfsh zzfsh = (zzfsh) obj;
            if (this.zzb.equals(zzfsh.zzc())) {
                zzfsh.zzd();
                if (this.zzc == zzfsh.zze()) {
                    zzfsh.zza();
                    zzfsh.zzb();
                    int i = this.zzd;
                    int zzf = zzfsh.zzf();
                    if (i == 0) {
                        throw null;
                    } else if (zzf == 1) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.zzb.hashCode() ^ 1000003;
        if (this.zzd != 0) {
            return (((((hashCode * 1000003) ^ 1237) * 1000003) ^ (true != this.zzc ? 1237 : 1231)) * 583896283) ^ 1;
        }
        throw null;
    }

    public final String toString() {
        String str = this.zzd != 1 ? "null" : "READ_AND_WRITE";
        boolean z = this.zzc;
        String str2 = this.zzb;
        return "FileComplianceOptions{fileOwner=" + str2 + ", hasDifferentDmaOwner=false, skipChecks=" + z + ", dataForwardingNotAllowedResolver=null, multipleProductIdGroupsResolver=null, filePurpose=" + str + "}";
    }

    public final zzfrw zza() {
        return null;
    }

    public final zzfrx zzb() {
        return null;
    }

    public final String zzc() {
        return this.zzb;
    }

    public final boolean zzd() {
        return false;
    }

    public final boolean zze() {
        return this.zzc;
    }

    public final int zzf() {
        return this.zzd;
    }
}
