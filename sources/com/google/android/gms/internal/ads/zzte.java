package com.google.android.gms.internal.ads;

import android.text.TextUtils;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzte {
    public final String zza;
    public final boolean zzb;
    public final boolean zzc;

    public zzte(String str, boolean z, boolean z2) {
        this.zza = str;
        this.zzb = z;
        this.zzc = z2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && obj.getClass() == zzte.class) {
            zzte zzte = (zzte) obj;
            return TextUtils.equals(this.zza, zzte.zza) && this.zzb == zzte.zzb && this.zzc == zzte.zzc;
        }
    }

    public final int hashCode() {
        int i = 1237;
        int hashCode = (((this.zza.hashCode() + 31) * 31) + (true != this.zzb ? 1237 : 1231)) * 31;
        if (true == this.zzc) {
            i = 1231;
        }
        return hashCode + i;
    }
}
