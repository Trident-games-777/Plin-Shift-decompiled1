package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzv;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final /* synthetic */ class zzdzt implements zzgdp {
    public final ListenableFuture zza(Object obj) {
        InputStream inputStream = (InputStream) obj;
        JSONObject jSONObject = new JSONObject();
        if (inputStream == null) {
            return zzgei.zzh(jSONObject);
        }
        try {
            zzv.zzq();
            jSONObject = new JSONObject(zzs.zzN(new InputStreamReader(inputStream)));
        } catch (IOException | JSONException e) {
            zzv.zzp().zzw(e, "AdsServiceSignalTask.startAdsServiceSignalTask");
        }
        return zzgei.zzh(jSONObject);
    }
}
