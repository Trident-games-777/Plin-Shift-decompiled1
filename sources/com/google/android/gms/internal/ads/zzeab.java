package com.google.android.gms.internal.ads;

import java.io.InputStream;
import java.io.InputStreamReader;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzeab implements zzfiv {
    public final /* synthetic */ JSONObject zza;
    public final /* synthetic */ zzbvz zzb;

    public /* synthetic */ zzeab(JSONObject jSONObject, zzbvz zzbvz) {
        this.zza = jSONObject;
        this.zzb = zzbvz;
    }

    public final Object zza(Object obj) {
        return new zzebf(zzebt.zza(new InputStreamReader((InputStream) obj)), this.zza, this.zzb);
    }
}
