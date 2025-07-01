package com.google.android.gms.ads.nonagon.signalgeneration;

import android.webkit.ValueCallback;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.ads.query.QueryInfo;
import com.google.android.gms.ads.query.QueryInfoGenerationCallback;
import com.google.android.gms.internal.ads.zzbcn;
import com.google.android.gms.internal.ads.zzbes;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
final class zzbk extends QueryInfoGenerationCallback {
    final /* synthetic */ String zza;
    final /* synthetic */ TaggingLibraryJsInterface zzb;

    zzbk(TaggingLibraryJsInterface taggingLibraryJsInterface, String str) {
        this.zza = str;
        this.zzb = taggingLibraryJsInterface;
    }

    public final void onFailure(String str) {
        String str2;
        long j;
        zzm.zzj("Failed to generate query info for the tagging library, error: ".concat(String.valueOf(str)));
        if (((Boolean) zzbes.zza.zze()).booleanValue()) {
            str2 = ",\"appLevelSignals\":".concat(this.zzb.zzk.zza().toString());
        } else {
            str2 = "";
        }
        String str3 = this.zza;
        Locale locale = Locale.getDefault();
        if (((Boolean) zzbes.zzb.zze()).booleanValue()) {
            j = ((Long) zzbe.zzc().zza(zzbcn.zzjz)).longValue();
        } else {
            j = 0;
        }
        String format = String.format(locale, "window.postMessage({\"paw_id\":\"%1$s\",\"error\":\"%2$s\",\"sdk_ttl_ms\":%3$d%4$s}, '*');", new Object[]{str3, str, Long.valueOf(j), str2});
        if (((Boolean) zzbes.zzb.zze()).booleanValue()) {
            try {
                this.zzb.zzh.execute(new zzbi(this, format));
            } catch (RuntimeException e) {
                zzv.zzp().zzv(e, "TaggingLibraryJsInterface.getQueryInfo.onFailure");
            }
        } else {
            this.zzb.zzb.evaluateJavascript(format, (ValueCallback) null);
        }
        if (((Boolean) zzbes.zza.zze()).booleanValue()) {
            this.zzb.zzl.zzb();
        }
    }

    public final void onSuccess(QueryInfo queryInfo) {
        String str;
        String str2;
        long j;
        String query = queryInfo.getQuery();
        long j2 = 0;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("paw_id", this.zza);
            jSONObject.put("signal", query);
            if (((Boolean) zzbes.zzb.zze()).booleanValue()) {
                j = ((Long) zzbe.zzc().zza(zzbcn.zzjz)).longValue();
            } else {
                j = 0;
            }
            jSONObject.put("sdk_ttl_ms", j);
            if (((Boolean) zzbes.zza.zze()).booleanValue()) {
                jSONObject.put("appLevelSignals", this.zzb.zzk.zza());
            }
            str = String.format(Locale.getDefault(), "window.postMessage(%1$s, '*');", new Object[]{jSONObject});
        } catch (JSONException unused) {
            if (((Boolean) zzbes.zza.zze()).booleanValue()) {
                str2 = ",\"appLevelSignals\":".concat(this.zzb.zzk.zza().toString());
            } else {
                str2 = "";
            }
            String str3 = this.zza;
            Locale locale = Locale.getDefault();
            String query2 = queryInfo.getQuery();
            if (((Boolean) zzbes.zzb.zze()).booleanValue()) {
                j2 = ((Long) zzbe.zzc().zza(zzbcn.zzjz)).longValue();
            }
            str = String.format(locale, "window.postMessage({\"paw_id\":\"%1$s\",\"signal\":\"%2$s\",\"sdk_ttl_ms\":%3$d%4$s}, '*');", new Object[]{str3, query2, Long.valueOf(j2), str2});
        }
        if (((Boolean) zzbes.zzb.zze()).booleanValue()) {
            try {
                this.zzb.zzh.execute(new zzbj(this, str));
            } catch (RuntimeException e) {
                zzv.zzp().zzv(e, "TaggingLibraryJsInterface.getQueryInfo.onSuccess");
            }
        } else {
            this.zzb.zzb.evaluateJavascript(str, (ValueCallback) null);
        }
        if (((Boolean) zzbes.zza.zze()).booleanValue()) {
            this.zzb.zzl.zzb();
        }
    }
}
