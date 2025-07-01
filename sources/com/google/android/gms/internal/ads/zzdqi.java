package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.zzv;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.CheckForNull;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzdqi {
    private final Map zza = new ConcurrentHashMap();
    private JSONObject zzb;
    private final Executor zzc;
    private boolean zzd;
    private JSONObject zze;
    private final AtomicBoolean zzf = new AtomicBoolean(false);

    public zzdqi(Executor executor) {
        this.zzc = executor;
    }

    private final void zzg() {
        if (!this.zzf.getAndSet(true)) {
            zzv.zzp().zzi().zzo(new zzdqh(this));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: zzh */
    public final synchronized void zze() {
        Map map;
        this.zzd = true;
        zzbzt zzg = zzv.zzp().zzi().zzg();
        if (zzg != null) {
            JSONObject zzf2 = zzg.zzf();
            if (zzf2 != null) {
                this.zzb = ((Boolean) zzbe.zzc().zza(zzbcn.zzee)).booleanValue() ? zzf2.optJSONObject("common_settings") : null;
                this.zze = zzf2.optJSONObject("ad_unit_patterns");
                JSONArray optJSONArray = zzf2.optJSONArray("ad_unit_id_settings");
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                        if (optJSONObject != null) {
                            String optString = optJSONObject.optString("ad_unit_id");
                            String optString2 = optJSONObject.optString("format");
                            JSONObject optJSONObject2 = optJSONObject.optJSONObject("request_signals");
                            if (!(optString == null || optJSONObject2 == null || optString2 == null)) {
                                if (this.zza.containsKey(optString2)) {
                                    map = (Map) this.zza.get(optString2);
                                } else {
                                    ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
                                    this.zza.put(optString2, concurrentHashMap);
                                    map = concurrentHashMap;
                                }
                                map.put(optString, optJSONObject2);
                            }
                        }
                    }
                }
            }
        }
    }

    @CheckForNull
    public final JSONObject zza() {
        if (!((Boolean) zzbe.zzc().zza(zzbcn.zzee)).booleanValue()) {
            return null;
        }
        return this.zzb;
    }

    @CheckForNull
    public final JSONObject zzb(String str, String str2) {
        if (!((Boolean) zzbe.zzc().zza(zzbcn.zzec)).booleanValue() || str == null || str2 == null) {
            return null;
        }
        if (!this.zzd) {
            zze();
            if (((Boolean) zzbe.zzc().zza(zzbcn.zzed)).booleanValue()) {
                zzg();
            }
        }
        Map map = (Map) this.zza.get(str2);
        if (map == null) {
            return null;
        }
        JSONObject jSONObject = (JSONObject) map.get(str);
        if (jSONObject != null) {
            return jSONObject;
        }
        String zza2 = zzdqk.zza(this.zze, str, str2);
        if (zza2 != null) {
            return (JSONObject) map.get(zza2);
        }
        return null;
    }

    public final void zzd() {
        zzg();
        this.zzc.execute(new zzdqf(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzf() {
        this.zzc.execute(new zzdqg(this));
    }
}
