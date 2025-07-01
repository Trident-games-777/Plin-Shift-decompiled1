package com.google.android.gms.internal.ads;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.Serializable;
import java.util.Arrays;
import javax.annotation.CheckForNull;
import okhttp3.HttpUrl;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzgcp implements Serializable {
    private final int[] zza;
    private final int zzb;

    private zzgcp(int[] iArr, int i, int i2) {
        this.zza = iArr;
        this.zzb = i2;
    }

    public static zzgcp zzb(int[] iArr) {
        int[] copyOf = Arrays.copyOf(iArr, iArr.length);
        return new zzgcp(copyOf, 0, copyOf.length);
    }

    public final boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzgcp)) {
            return false;
        }
        zzgcp zzgcp = (zzgcp) obj;
        if (this.zzb != zzgcp.zzb) {
            return false;
        }
        for (int i = 0; i < this.zzb; i++) {
            if (zza(i) != zzgcp.zza(i)) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.zzb; i2++) {
            i = (i * 31) + this.zza[i2];
        }
        return i;
    }

    public final String toString() {
        int i = this.zzb;
        if (i == 0) {
            return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }
        StringBuilder sb = new StringBuilder(i * 5);
        sb.append('[');
        sb.append(this.zza[0]);
        for (int i2 = 1; i2 < this.zzb; i2++) {
            sb.append(", ");
            sb.append(this.zza[i2]);
        }
        sb.append(']');
        return sb.toString();
    }

    public final int zza(int i) {
        zzfwq.zza(i, this.zzb, FirebaseAnalytics.Param.INDEX);
        return this.zza[i];
    }
}
