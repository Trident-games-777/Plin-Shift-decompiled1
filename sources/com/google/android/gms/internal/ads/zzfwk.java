package com.google.android.gms.internal.ads;

import java.util.Arrays;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
public final class zzfwk {
    private final String zza;
    private final zzfwj zzb;
    private zzfwj zzc;

    public final String toString() {
        StringBuilder sb = new StringBuilder(32);
        sb.append(this.zza);
        sb.append('{');
        zzfwj zzfwj = this.zzb.zzb;
        String str = "";
        while (zzfwj != null) {
            Object obj = zzfwj.zza;
            sb.append(str);
            if (obj == null || !obj.getClass().isArray()) {
                sb.append(obj);
            } else {
                String deepToString = Arrays.deepToString(new Object[]{obj});
                sb.append(deepToString, 1, deepToString.length() - 1);
            }
            zzfwj = zzfwj.zzb;
            str = ", ";
        }
        sb.append('}');
        return sb.toString();
    }

    public final zzfwk zza(@CheckForNull Object obj) {
        zzfwj zzfwj = new zzfwj();
        this.zzc.zzb = zzfwj;
        this.zzc = zzfwj;
        zzfwj.zza = obj;
        return this;
    }

    /* synthetic */ zzfwk(String str, zzfwl zzfwl) {
        zzfwj zzfwj = new zzfwj();
        this.zzb = zzfwj;
        this.zzc = zzfwj;
        str.getClass();
        String str2 = str;
        this.zza = str;
    }
}
