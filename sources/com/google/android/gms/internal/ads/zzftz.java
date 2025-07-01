package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzftz extends zzfuk {
    private final String zza;
    private final String zzb;

    /* synthetic */ zzftz(String str, String str2, zzfty zzfty) {
        this.zza = str;
        this.zzb = str2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzfuk) {
            zzfuk zzfuk = (zzfuk) obj;
            String str = this.zza;
            if (str != null ? str.equals(zzfuk.zzb()) : zzfuk.zzb() == null) {
                String str2 = this.zzb;
                if (str2 != null ? str2.equals(zzfuk.zza()) : zzfuk.zza() == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public final String toString() {
        return "OverlayDisplayDismissRequest{sessionToken=" + this.zza + ", appId=" + this.zzb + "}";
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
