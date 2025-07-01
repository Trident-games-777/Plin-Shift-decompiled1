package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.query.QueryInfo;
import com.google.android.gms.ads.query.QueryInfoGenerationCallback;
import org.json.JSONException;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzbdr extends QueryInfoGenerationCallback {
    final /* synthetic */ String zza;
    final /* synthetic */ zzbds zzb;

    zzbdr(zzbds zzbds, String str) {
        this.zza = str;
        this.zzb = zzbds;
    }

    public final void onFailure(String str) {
        zzm.zzj("Failed to generate query info for Custom Tab error: ".concat(String.valueOf(str)));
        try {
            zzbds zzbds = this.zzb;
            zzbds.zzg.postMessage(zzbds.zzc(this.zza, str).toString(), (Bundle) null);
        } catch (JSONException e) {
            zzm.zzh("Error creating PACT Error Response JSON: ", e);
        }
    }

    public final void onSuccess(QueryInfo queryInfo) {
        String query = queryInfo.getQuery();
        try {
            zzbds zzbds = this.zzb;
            zzbds.zzg.postMessage(zzbds.zzd(this.zza, query).toString(), (Bundle) null);
        } catch (JSONException e) {
            zzm.zzh("Error creating PACT Signal Response JSON: ", e);
        }
    }
}
