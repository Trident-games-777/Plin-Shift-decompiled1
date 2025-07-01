package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzcyg extends zzdcc implements zzbih {
    private final Bundle zzb = new Bundle();

    zzcyg(Set set) {
        super(set);
    }

    public final synchronized void zza(String str, Bundle bundle) {
        this.zzb.putAll(bundle);
        zzq(new zzcyf());
    }

    public final synchronized Bundle zzb() {
        return new Bundle(this.zzb);
    }
}
