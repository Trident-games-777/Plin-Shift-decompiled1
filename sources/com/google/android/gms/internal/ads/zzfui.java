package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzfui extends zzfvk {
    private final String zza;
    private final String zzb;

    /* synthetic */ zzfui(String str, String str2, zzfuh zzfuh) {
        this.zza = str;
        this.zzb = str2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzfvk) {
            zzfvk zzfvk = (zzfvk) obj;
            String str = this.zza;
            if (str != null ? str.equals(zzfvk.zzb()) : zzfvk.zzb() == null) {
                String str2 = this.zzb;
                if (str2 != null ? str2.equals(zzfvk.zza()) : zzfvk.zza() == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public final String toString() {
        return "OverlayDisplayUpdateRequest{sessionToken=" + this.zza + ", appId=" + this.zzb + "}";
    }

    public final String zza() {
        return this.zzb;
    }

    public final String zzb() {
        return this.zza;
    }

    public final int hashCode() {
        int i;
        String str = this.zza;
        int i2 = 0;
        if (str == null) {
            i = 0;
        } else {
            i = str.hashCode();
        }
        String str2 = this.zzb;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return ((i ^ 1000003) * 1000003) ^ i2;
    }
}
