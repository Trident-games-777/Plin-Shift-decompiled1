package com.google.android.gms.internal.ads;

import java.io.Serializable;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.5.0 */
public abstract class zzfwo implements Serializable {
    zzfwo() {
    }

    public static zzfwo zzc() {
        return zzfvy.zza;
    }

    public static zzfwo zzd(@CheckForNull Object obj) {
        return obj == null ? zzfvy.zza : new zzfwv(obj);
    }

    public abstract zzfwo zza(zzfwh zzfwh);

    public abstract Object zzb(Object obj);
}
