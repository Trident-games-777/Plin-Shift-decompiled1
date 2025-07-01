package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzdml {
    private final Executor zza;
    private final zzdmg zzb;

    public zzdml(Executor executor, zzdmg zzdmg) {
        this.zza = executor;
        this.zzb = zzdmg;
    }

    public final ListenableFuture zza(JSONObject jSONObject, String str) {
        ListenableFuture listenableFuture;
        JSONArray optJSONArray = jSONObject.optJSONArray("custom_assets");
        if (optJSONArray == null) {
            return zzgei.zzh(Collections.emptyList());
        }
        ArrayList arrayList = new ArrayList();
        int length = optJSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject == null) {
                listenableFuture = zzgei.zzh((Object) null);
            } else {
                String optString = optJSONObject.optString("name");
                if (optString == null) {
                    listenableFuture = zzgei.zzh((Object) null);
                } else {
                    String optString2 = optJSONObject.optString("type");
                    if ("string".equals(optString2)) {
                        listenableFuture = zzgei.zzh(new zzdmk(optString, optJSONObject.optString("string_value")));
                    } else if ("image".equals(optString2)) {
                        listenableFuture = zzgei.zzm(this.zzb.zze(optJSONObject, "image_value"), new zzdmi(optString), this.zza);
                    } else {
                        listenableFuture = zzgei.zzh((Object) null);
                    }
                }
            }
            arrayList.add(listenableFuture);
        }
        return zzgei.zzm(zzgei.zzd(arrayList), new zzdmj(), this.zza);
    }
}
