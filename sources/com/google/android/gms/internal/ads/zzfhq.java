package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzfhq {
    private final HashMap zza = new HashMap();

    public final zzfhp zza(zzfhg zzfhg, Context context, zzfgy zzfgy, zzfhw zzfhw) {
        zzfhp zzfhp = (zzfhp) this.zza.get(zzfhg);
        if (zzfhp != null) {
            return zzfhp;
        }
        zzfhd zzfhd = new zzfhd(zzfhj.zza(zzfhg, context));
        zzfhp zzfhp2 = new zzfhp(zzfhd, new zzfhy(zzfhd, zzfgy, zzfhw));
        this.zza.put(zzfhg, zzfhp2);
        return zzfhp2;
    }
}
