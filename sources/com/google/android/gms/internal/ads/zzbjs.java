package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzbjs implements zzbjr {
    private final zzdvk zza;

    public zzbjs(zzdvk zzdvk) {
        Preconditions.checkNotNull(zzdvk, "The Inspector Manager must not be null");
        this.zza = zzdvk;
    }

    public final void zza(Object obj, Map map) {
        if (map != null && map.containsKey("persistentData") && !TextUtils.isEmpty((CharSequence) map.get("persistentData"))) {
            this.zza.zzj((String) map.get("persistentData"));
        }
    }
}
