package com.google.android.gms.internal.ads;

import java.util.HashSet;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public abstract class zzfpc extends zzfpd {
    protected final HashSet zza;
    protected final JSONObject zzb;
    protected final long zzc;

    public zzfpc(zzfov zzfov, HashSet hashSet, JSONObject jSONObject, long j) {
        super(zzfov);
        this.zza = new HashSet(hashSet);
        this.zzb = jSONObject;
        this.zzc = j;
    }
}
