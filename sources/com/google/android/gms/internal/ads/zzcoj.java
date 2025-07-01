package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzcoj implements zzhfx {
    private final zzhgp zza;

    public zzcoj(zzhgp zzhgp) {
        this.zza = zzhgp;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzfet zza2 = ((zzcsh) this.zza).zza();
        zzfet zzfet = zza2;
        try {
            return new JSONObject(zza2.zzz);
        } catch (JSONException unused) {
            return null;
        }
    }
}
