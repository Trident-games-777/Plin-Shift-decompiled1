package com.google.android.gms.internal.ads;

import java.util.HashSet;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.5.0 */
public final class zzfpg extends zzfpc {
    public zzfpg(zzfov zzfov, HashSet hashSet, JSONObject jSONObject, long j) {
        super(zzfov, hashSet, jSONObject, j);
    }

    private final void zzc(String str) {
        zzfnr zza = zzfnr.zza();
        if (zza != null) {
            for (zzfna zzfna : zza.zzc()) {
                if (this.zza.contains(zzfna.zzh())) {
                    zzfna.zzg().zzd(str, this.zzc);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object doInBackground(Object[] objArr) {
        return this.zzb.toString();
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void onPostExecute(Object obj) {
        String str = (String) obj;
        zzc(str);
        super.onPostExecute(str);
    }

    /* access modifiers changed from: protected */
    public final void zza(String str) {
        zzc(str);
        super.onPostExecute(str);
    }
}
