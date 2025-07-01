package com.google.android.gms.internal.ads;

import android.content.Context;
import javax.net.ssl.SSLSocketFactory;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzaqw {
    public static zzaps zza(Context context, zzaqd zzaqd) {
        zzaqe zzaqe;
        if (zzaqd == null) {
            zzaqe = new zzaqe(new zzaqq((zzaqp) null, (SSLSocketFactory) null));
        } else {
            zzaqe = new zzaqe(zzaqd);
        }
        zzaps zzaps = new zzaps(new zzaql((zzaqk) new zzaqv(context.getApplicationContext()), 5242880), zzaqe, 4);
        zzaps.zzd();
        return zzaps;
    }
}
